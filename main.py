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
    
    