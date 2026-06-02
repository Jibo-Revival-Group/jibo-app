package com.jibo.p019ui.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.NumberPicker;
import com.google.api.client.googleapis.media.MediaHttpUploader;
import com.jibo.R;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes.dex */
public class MaterialNumberPicker extends NumberPicker {

    /* JADX INFO: renamed from: a */
    private int f11572a;

    /* JADX INFO: renamed from: b */
    private float f11573b;

    public MaterialNumberPicker(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m11277a();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.MaterialNumberPicker);
        for (int i = 0; i < typedArrayObtainStyledAttributes.getIndexCount(); i++) {
            int index = typedArrayObtainStyledAttributes.getIndex(i);
            if (index == 1) {
                setTextSize(typedArrayObtainStyledAttributes.getDimension(index, 18.0f));
            } else if (index == 0) {
                setTextColor(typedArrayObtainStyledAttributes.getColor(index, context.getColor(R.color.black)));
            }
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    /* JADX INFO: renamed from: a */
    private void m11277a() {
        setSeparatorColor(0);
        setTextColor(getContext().getResources().getColor(R.color.black));
        setTextSize(18.0f);
        setWrapSelectorWheel(false);
        setFocusability(false);
        try {
            Field declaredField = NumberPicker.class.getDeclaredField("mInputText");
            declaredField.setAccessible(true);
            EditText editText = (EditText) declaredField.get(this);
            editText.setTextColor(this.f11572a);
            editText.setTextSize(this.f11573b);
            editText.setFilters(new InputFilter[0]);
        } catch (IllegalAccessException e) {
        } catch (IllegalArgumentException e2) {
        } catch (NoSuchFieldException e3) {
        }
    }

    public void setSeparatorColor(int i) {
        for (Field field : NumberPicker.class.getDeclaredFields()) {
            if (field.getName().equals("mSelectionDivider")) {
                field.setAccessible(true);
                try {
                    field.set(this, new ColorDrawable(i));
                    return;
                } catch (IllegalAccessException e) {
                    return;
                } catch (IllegalArgumentException e2) {
                    return;
                }
            }
        }
    }

    @Override // android.widget.NumberPicker
    public void setTextColor(int i) {
        this.f11572a = i;
        m11278b();
    }

    @Override // android.widget.NumberPicker
    public void setTextSize(float f) {
        this.f11573b = f;
        m11278b();
    }

    /* JADX INFO: renamed from: b */
    private void m11278b() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < getChildCount()) {
                View childAt = getChildAt(i2);
                if (childAt instanceof EditText) {
                    try {
                        Field declaredField = NumberPicker.class.getDeclaredField("mSelectorWheelPaint");
                        declaredField.setAccessible(true);
                        Paint paint = (Paint) declaredField.get(this);
                        paint.setColor(this.f11572a);
                        paint.setTextSize(m11276a(getContext(), this.f11573b));
                        EditText editText = (EditText) childAt;
                        editText.setTextColor(this.f11572a);
                        editText.setTextSize(this.f11573b);
                        invalidate();
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

    private void setFocusability(boolean z) {
        setDescendantFocusability(z ? MediaHttpUploader.MINIMUM_CHUNK_SIZE : 393216);
    }

    /* JADX INFO: renamed from: a */
    private float m11276a(Context context, float f) {
        return context.getResources().getDisplayMetrics().scaledDensity * f;
    }
}
