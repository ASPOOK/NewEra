package com.aspook.jsengine;

import android.util.Log;
import android.webkit.JavascriptInterface;

public class MyConsole {
    int count = 0;

    @JavascriptInterface
    public void log(String msg) {
        count++;
        Log.d(QuickJsTool.TAG, msg);
    }

    @JavascriptInterface
    public void info(String msg) {
        count++;
        Log.i(QuickJsTool.TAG, msg);
    }

    @JavascriptInterface
    public void error(String msg) {
        count++;
        Log.e(QuickJsTool.TAG, msg);
    }

    @JavascriptInterface
    public int count() {
        return count;
    }
}
