package com.jibo.p019ui.view;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.NumberPicker;
import com.jibo.p019ui.view.proxima.ProximaHelper;
import com.jibo.utils.ImageUtils;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes.dex */
public class MaterialDatePicker extends DatePicker {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MaterialDatePicker(Context context, AttributeSet attributeSet) throws ClassNotFoundException {
        Class<?> cls;
        Field field;
        NumberPicker numberPicker;
        Field field2;
        NumberPicker numberPicker2;
        Field field3;
        NumberPicker numberPicker3;
        Class<?> cls2;
        super(context, attributeSet);
        Field declaredField = null;
        try {
            cls = Class.forName("com.android.internal.R$id");
        } catch (ClassNotFoundException e) {
            cls = null;
        }
        try {
            field = cls.getField("month");
        } catch (NoSuchFieldException e2) {
            field = null;
        }
        try {
            numberPicker = (NumberPicker) findViewById(field.getInt(null));
        } catch (IllegalAccessException e3) {
            numberPicker = null;
        } catch (IllegalArgumentException e4) {
            numberPicker = null;
        }
        try {
            field2 = cls.getField("day");
        } catch (NoSuchFieldException e5) {
            field2 = null;
        }
        try {
            numberPicker2 = (NumberPicker) findViewById(field2.getInt(null));
        } catch (IllegalAccessException e6) {
            numberPicker2 = null;
        } catch (IllegalArgumentException e7) {
            numberPicker2 = null;
        }
        try {
            field3 = cls.getField("year");
        } catch (NoSuchFieldException e8) {
            field3 = null;
        }
        try {
            numberPicker3 = (NumberPicker) findViewById(field3.getInt(null));
        } catch (IllegalAccessException e9) {
            numberPicker3 = null;
        } catch (IllegalArgumentException e10) {
            numberPicker3 = null;
        }
        try {
            cls2 = Class.forName("android.widget.NumberPicker");
        } catch (ClassNotFoundException e11) {
            cls2 = null;
        }
        try {
            declaredField = cls2.getDeclaredField("mSelectionDivider");
        } catch (NoSuchFieldException e12) {
        }
        try {
            declaredField.setAccessible(true);
            declaredField.set(numberPicker, new ColorDrawable(0));
            declaredField.set(numberPicker2, new ColorDrawable(0));
            declaredField.set(numberPicker3, new ColorDrawable(0));
            m11275a(numberPicker2);
            m11275a(numberPicker);
            m11275a(numberPicker3);
        } catch (Resources.NotFoundException e13) {
        } catch (IllegalAccessException e14) {
        } catch (IllegalArgumentException e15) {
        }
    }

    /* JADX INFO: renamed from: a */
    private void m11275a(NumberPicker numberPicker) {
        numberPicker.setDescendantFocusability(393216);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < getChildCount()) {
                View childAt = numberPicker.getChildAt(i2);
                if (childAt instanceof EditText) {
                    try {
                        Field declaredField = NumberPicker.class.getDeclaredField("mSelectorWheelPaint");
                        declaredField.setAccessible(true);
                        Paint paint = (Paint) declaredField.get(numberPicker);
                        paint.setColor(ImageUtils.m11399b(getContext(), R.color.black));
                        paint.setTextSize(m11274a(getContext(), 18.0f));
                        paint.setTypeface(ProximaHelper.f11649a);
                        EditText editText = (EditText) childAt;
                        editText.setTextColor(ImageUtils.m11399b(getContext(), R.color.black));
                        editText.setTextSize(18.0f);
                        paint.setTypeface(ProximaHelper.f11649a);
                        numberPicker.invalidate();
                        return;
                    } catch (IllegalAccessException e) {
                    } catch (IllegalArgumentException e2) {
                    } catch (NoSuchFieldException e3) {
                    }
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private float m11274a(Context context, float f) {
        return context.getResources().getDisplayMetrics().scaledDensity * f;
    }
}
