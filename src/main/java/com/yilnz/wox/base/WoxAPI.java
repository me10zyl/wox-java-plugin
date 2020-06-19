package com.yilnz.wox.base;

import com.alibaba.fastjson.JSONObject;

import java.util.Arrays;

public class WoxAPI {
    public static void changeQuery(String query, boolean reQuery){
       RPCJson rpcJson = new RPCJson();
       rpcJson.setMethod("Wox.ChangeQuery");
       rpcJson.setParameters(Arrays.asList(query, reQuery));
       System.out.println(JSONObject.toJSONString(rpcJson));
    }

    public static void shellRun(String cmd) {
        RPCJson rpcJson = new RPCJson();
        rpcJson.setMethod("Wox.ShellRun");
        rpcJson.setParameters(Arrays.asList(cmd));
        System.out.println(JSONObject.toJSONString(rpcJson));
    }

    public static void hideApp() {
        RPCJson rpcJson = new RPCJson();
        rpcJson.setMethod("Wox.HideApp");
        System.out.println(JSONObject.toJSONString(rpcJson));
    }

    public static void showMsg(String title, String subTile, String iconPath) {
        if(iconPath == null){
            iconPath = "";
        }
        RPCJson rpcJson = new RPCJson();
        rpcJson.setMethod("Wox.showMsg");
        rpcJson.setParameters(Arrays.asList(title, subTile, iconPath));
        System.out.println(JSONObject.toJSONString(rpcJson));
    }

    public static void closeApp() {
        RPCJson rpcJson = new RPCJson();
        rpcJson.setMethod("Wox.CloseApp");
        System.out.println(JSONObject.toJSONString(rpcJson));
    }

    public static void startLoadingBar() {
        RPCJson rpcJson = new RPCJson();
        rpcJson.setMethod("Wox.StartLoadingBar");
        System.out.println(JSONObject.toJSONString(rpcJson));
    }

    public static void stopLoadingBar() {
        RPCJson rpcJson = new RPCJson();
        rpcJson.setMethod("Wox.StopLoadingBar");
        System.out.println(JSONObject.toJSONString(rpcJson));
    }

    public static void oenSettingDialog() {
        RPCJson rpcJson = new RPCJson();
        rpcJson.setMethod("Wox.OpenSettingDialog");
        System.out.println(JSONObject.toJSONString(rpcJson));
    }

    public static void reloadPlugins() {
        RPCJson rpcJson = new RPCJson();
        rpcJson.setMethod("Wox.ReloadPlugins");
        System.out.println(JSONObject.toJSONString(rpcJson));
    }
}
