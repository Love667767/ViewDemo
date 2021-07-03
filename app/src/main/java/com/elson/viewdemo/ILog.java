package com.elson.viewdemo;

import android.util.Log;

/**
 * @author elson
 * @date 2021/7/2
 * @Desc
 */
public class ILog {

    public static final void d(String tag, String content) {
        Log.d("Touch_" + tag, content);
    }
}
