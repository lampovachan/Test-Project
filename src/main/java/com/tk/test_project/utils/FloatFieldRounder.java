package com.tk.test_project.utils;

import java.math.BigDecimal;

public class FloatFieldRounder {
    public static float roundFloatField(float number) {
        BigDecimal bd = new BigDecimal(Float.toString(number));
        bd = bd.setScale(2, BigDecimal.ROUND_HALF_UP);
        return bd.floatValue();
    }
}
