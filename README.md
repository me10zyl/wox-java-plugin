# wox-java-plugin

# Wox Java Example:
```java
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
        r.setIconPath("Images/app.png");
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
        r.setIconPath("Images/app.png");
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
```

# main.py
```python
# -*- coding: utf-8 -*-
import jpype 
import sys
jvmPath = r"c:\Program Files\Java\jre32\jre1.8.0_251\bin\client\jvm.dll"
ext_classpath= r"./wox.jar"
if __name__ == "__main__":
   #ctypes.CDLL(jvmPath)
    args = sys.argv[1:]
    if not jpype.isJVMStarted():
        jpype.startJVM(jvmpath=jvmPath,convertStrings=False, classpath=ext_classpath)
    RpcClass = jpype.JClass("com.yilnz.wox.example.JavaHelloWorld")
    rcp = RpcClass()
    rcp.run(args)
    if jpype.isJVMStarted():
        jpype.shutdownJVM()
```

# IMG:
![1](1.png)

# Wox Example Plugin Download:
[https://github.com/me10zyl/wox-java-plugin/releases/tag/1.0](https://github.com/me10zyl/wox-java-plugin/releases/tag/1.0)