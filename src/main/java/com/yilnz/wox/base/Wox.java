package com.yilnz.wox.base;

import com.alibaba.fastjson.JSONObject;
import com.yilnz.wox.enity.WoxContextResult;
import com.yilnz.wox.enity.WoxQueryResult;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
public abstract class Wox {

    @Data
    private static class FinalResults{
        private List<Object> result;
    }

    /**
     * 执行插件返回结果
     * @param args
     */
    public void run(String[] args) {
        try {
            for (int i = 0; i < args.length; i++) {
                log.info("[args]" + i + ":" + args[i]);
            }
            String q = args[0];
            RPCJson rpcJson = JSONObject.parseObject(q, RPCJson.class);
            Method[] methods = this.getClass().getSuperclass().getDeclaredMethods();
            String results = null;
            log.info(rpcJson.toString());
            for (Method method : methods) {
                if (method.getName().equals(("_" + rpcJson.getMethod()))) {
                    try {
                        log.info("invoking method " + method.getName());
                        method.setAccessible(true);
                        results = (String) method.invoke(this, rpcJson.getParameters());
                    } catch (IllegalAccessException | InvocationTargetException e) {
                        log.error("err", e);
                    }
                    break;
                }
            }
            if (results != null) {
                log.info("[result]" + results);
                System.out.println(results);
            }
        }catch (Exception e){
            log.error("fatal err", e);
        }
    }

    private String _query(List<String> params){
        if(params.size() == 1){
            if(params.get(0).contains(" ")){
                params = Arrays.asList(params.get(0).split(" "));
            }
        }
        FinalResults finalResults = new FinalResults();
        finalResults.result = new ArrayList<>();
        finalResults.result.addAll(query(params));
        return JSONObject.toJSONString(finalResults);
    }

    private String _take_action(List<String> params){
        if(params.size() == 1){
            if(params.get(0).contains(" ")){
                params = Arrays.asList(params.get(0).split(" "));
            }
        }
        takeAction(params);
        return null;
    }

    private String _context_menu(List<String> params){
        if(params.size() == 1){
            if(params.get(0).contains(" ")){
                params = Arrays.asList(params.get(0).split(" "));
            }
        }
        FinalResults finalResults = new FinalResults();
        finalResults.result = new ArrayList<>();
        finalResults.result.addAll(query(params));
        return JSONObject.toJSONString(finalResults);
    }

    /**
     * 查询
     * @param params
     * @return
     */
    public abstract List<WoxQueryResult> query(List<String> params);

    /**
     * 右键菜单
     * @param params
     * @return
     */
    public abstract List<WoxContextResult> contextMenu(List<String> params);

    /**
     * 按下回车
     * @param params
     */
    public abstract void takeAction(List<String> params);
}
