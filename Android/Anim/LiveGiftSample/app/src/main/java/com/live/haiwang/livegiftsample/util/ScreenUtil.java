package com.live.haiwang.livegiftsample.util;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;

/**
 * Created by haiwang on 2017/6/7.
 */

public class ScreenUtil {

    public static float a(Context paramContext, float paramFloat) {
        if (paramContext == null) {
            return -1.0F;
        }
        return paramContext.getResources().getDisplayMetrics().density * paramFloat;
    }

    public static int a(Context paramContext) {
        if (paramContext == null) {
            return -1;
        }
        return paramContext.getResources().getDisplayMetrics().widthPixels;
    }

    public static int b(Context paramContext) {
        if (paramContext == null) {
            return -1;
        }
        return paramContext.getResources().getDisplayMetrics().heightPixels;
    }

    public static int b(Context paramContext, float paramFloat) {
        return (int) (a(paramContext, paramFloat) + 0.5F);
    }
}
