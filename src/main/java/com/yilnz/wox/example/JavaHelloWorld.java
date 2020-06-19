package com.yilnz.wox.example;

import com.yilnz.wox.base.Wox;
import com.yilnz.wox.enity.JsonRPCAction_;
import com.yilnz.wox.enity.WoxContextResult;
import com.yilnz.wox.enity.WoxQueryResult;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class JavaHelloWorld extends Wox {
    @Override
    public List<WoxQueryResult> query(List<String> params) {
        List<WoxQueryResult> results = new ArrayList<>();
        WoxQueryResult r = new WoxQueryResult();
        r.setTitle("Java Hello World");
        r.setSubTitle("query subTitle");
        r.setIcoPath("Images/app.png");
        r.setContextData("ctxData233");
        JsonRPCAction_ jsonRPCAction = new JsonRPCAction_();
        jsonRPCAction.setMethod("take_action");
        List<String> parameters = new ArrayList<>();
        parameters.add("helloPeter");
        jsonRPCAction.setParameters(parameters);
        jsonRPCAction.setDontHideAfterAction(false);
        r.setJsonRPCAction(jsonRPCAction);
        results.add(r);
        return results;
    }

    @Override
    public List<WoxContextResult> contextMenu(List<String> params) {
        List<WoxContextResult> results = new ArrayList<>();
        WoxContextResult r = new WoxContextResult();
        r.setTitle("Content menu triggered");
        r.setIcoPath("Images/app.png");
        r.setSubTitle("data : " + params);
        results.add(r);
        log.info("context menu clicked " + params);
        return results;
    }

    @Override
    public void takeAction(List<String> params) {
        log.info("takeAction:" + params);
    }

    public static void main(String[] args) {
        new JavaHelloWorld().run(args);
    }
}
