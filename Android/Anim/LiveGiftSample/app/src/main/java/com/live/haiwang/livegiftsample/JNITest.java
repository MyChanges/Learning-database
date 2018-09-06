package com.live.haiwang.livegiftsample;

/**
 * Created by haiwang on 2017/7/18.
 */

public class JNITest {
    public native String getStringFromC();
    static {
        System.loadLibrary("JNITest");
    }
}
