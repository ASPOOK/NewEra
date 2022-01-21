package com.aspook.jsengine;

import android.util.Log;

import com.quickjs.JSArray;
import com.quickjs.JSContext;
import com.quickjs.JSFunction;
import com.quickjs.JSObject;
import com.quickjs.JavaCallback;
import com.quickjs.JavaVoidCallback;
import com.quickjs.QuickJS;

/**
 * QuickJS tool for test
 *
 * @author aspook
 */
public class QuickJsTool {
    public static final String TAG = "QuickJS";

    private QuickJsTool() {

    }

    /**
     * simple test
     */
    public static void quickJsTest() {
        Log.d(TAG, "start=" + System.currentTimeMillis());
        QuickJS quickJS = QuickJS.createRuntime();
        JSContext jsContext = quickJS.createContext();
        Log.d(TAG, "createQJSRuntime=" + System.currentTimeMillis());
        int intRes = jsContext.executeIntegerScript("var a = 1+2;\n a;", "file_name.js");
//        String strRes = jsContext.executeStringScript("'Hello QuickJS'", "file_name.js");
        Log.e(TAG, "execute end = " + System.currentTimeMillis());
        jsContext.close();
        quickJS.close();
        Log.e(TAG, "close end = " + System.currentTimeMillis());

        Log.d(TAG, "int reuslt = " + intRes);
//        Log.d(TAG, "String reuslt = " + strRes);
    }

    public static void quickJsTestClose() {
        QuickJS quickJS = QuickJS.createRuntime();
        JSContext jsContext = quickJS.createContext();
        int intRes = jsContext.executeIntegerScript("var a = 2+10;\n a;", "file_name.js");
        String strRes = jsContext.executeStringScript("'Hello QuickJS'", "file_name.js");

        jsContext.close();
        quickJS.close();

        Log.d(TAG, "int reuslt = " + intRes);
        Log.d(TAG, "String reuslt = " + strRes);
    }

    public static void testJSObject() {
        QuickJS quickJS = QuickJS.createRuntime();
        JSContext jsContext = quickJS.createContext();

        JSObject user = new JSObject(jsContext).set("name", "Wiki").set("age", 18).set("time", System.currentTimeMillis());
//        Log.d(TAG, String.valueOf(user.getString("name")));
//        Log.d(TAG, String.valueOf(user.getInteger("age")));
//        Log.d(TAG, String.valueOf(user.getDouble("time")));

        user.registerJavaMethod(new JavaVoidCallback() {
            @Override
            public void invoke(JSObject receiver, JSArray args) {
                Log.d(TAG, "" + args.getBoolean(1));
            }
        }, "jsLog");

        user.executeVoidFunction("jsLog", new JSArray(jsContext).push("Hello").push(false));

        jsContext.close();
        quickJS.close();
    }

    public static void testJSFunction() {
        QuickJS quickJS = QuickJS.createRuntime();
        JSContext jsContext = quickJS.createContext();

        JSFunction log = new JSFunction(jsContext, new JavaVoidCallback() {
            @Override
            public void invoke(JSObject receiver, JSArray args) {
                Log.d(TAG, "log result=" + args.getString(0));
            }
        });

        JSFunction message = new JSFunction(jsContext, new JavaCallback() {
            @Override
            public Object invoke(JSObject receiver, JSArray args) {
                return "Hello QuickJS";
//                return new JSArray(jsContext).push("Hello").push("World");
            }
        });

        jsContext.set("my_console", new JSObject(jsContext).set("log", log).set("message", message));
        jsContext.executeVoidScript("my_console.log(my_console.message())", null);

        jsContext.close();
        quickJS.close();
    }

    public static void testAddJavaScriptInterface() {
        QuickJS quickJS = QuickJS.createRuntime();
        JSContext jsContext = quickJS.createContext();

        jsContext.addJavascriptInterface(new MyConsole(), "my_console");
        jsContext.executeVoidScript("my_console.log('log::Hello QuickJS')", null);
        jsContext.executeVoidScript("my_console.info('Info::Hello QuickJS')", null);
        jsContext.executeVoidScript("my_console.error('Error::Hello QuickJS')", null);
        int count = jsContext.executeIntegerScript("my_console.count()", null);
        Log.d(TAG, "count result=" + count);

        jsContext.close();
        quickJS.close();
    }


}
