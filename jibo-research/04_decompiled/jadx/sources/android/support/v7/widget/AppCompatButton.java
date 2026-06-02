package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.v4.view.TintableBackgroundView;
import android.support.v4.widget.AutoSizeableTextView;
import android.support.v7.appcompat.R;
import android.util.AttributeSet;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;

/* JADX INFO: loaded from: classes.dex */
public class AppCompatButton extends Button implements TintableBackgroundView, AutoSizeableTextView {

    /* JADX INFO: renamed from: b */
    private final AppCompatBackgroundHelper f3652b;

    /* JADX INFO: renamed from: c */
    private final AppCompatTextHelper f3653c;

    public AppCompatButton(Context context) {
        this(context, null);
    }

    public AppCompatButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.buttonStyle);
    }

    public AppCompatButton(Context context, AttributeSet attributeSet, int i) {
        super(TintContextWrapper.m4950a(context), attributeSet, i);
        this.f3652b = new AppCompatBackgroundHelper(this);
        this.f3652b.m3844a(attributeSet, i);
        this.f3653c = AppCompatTextHelper.m3923a(this);
        this.f3653c.mo3935a(attributeSet, i);
        this.f3653c.mo3929a();
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        if (this.f3652b != null) {
            this.f3652b.m3840a(i);
        }
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.f3652b != null) {
            this.f3652b.m3843a(drawable);
        }
    }

    @Override // android.support.v4.view.TintableBackgroundView
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (this.f3652b != null) {
            this.f3652b.m3841a(colorStateList);
        }
    }

    @Override // android.support.v4.view.TintableBackgroundView
    public ColorStateList getSupportBackgroundTintList() {
        if (this.f3652b != null) {
            return this.f3652b.m3839a();
        }
        return null;
    }

    @Override // android.support.v4.view.TintableBackgroundView
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        if (this.f3652b != null) {
            this.f3652b.m3842a(mode);
        }
    }

    @Override // android.support.v4.view.TintableBackgroundView
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        if (this.f3652b != null) {
            return this.f3652b.m3845b();
        }
        return null;
    }

    @Override // android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f3652b != null) {
            this.f3652b.m3847c();
        }
        if (this.f3653c != null) {
            this.f3653c.mo3929a();
        }
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        if (this.f3653c != null) {
            this.f3653c.m3933a(context, i);
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(Button.class.getName());
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(Button.class.getName());
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.f3653c != null) {
            this.f3653c.m3937a(z, i, i2, i3, i4);
        }
    }

    @Override // android.widget.TextView
    public void setTextSize(int i, float f) {
        if (f2518a) {
            super.setTextSize(i, f);
        } else if (this.f3653c != null) {
            this.f3653c.m3931a(i, f);
        }
    }

    @Override // android.widget.TextView
    protected void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        super.onTextChanged(charSequence, i, i2, i3);
        if (this.f3653c != null && !f2518a && this.f3653c.m3940c()) {
            this.f3653c.m3939b();
        }
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeWithDefaults(int i) {
        if (f2518a) {
            super.setAutoSizeTextTypeWithDefaults(i);
        } else if (this.f3653c != null) {
            this.f3653c.m3930a(i);
        }
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeUniformWithConfiguration(int i, int i2, int i3, int i4) throws IllegalArgumentException {
        if (f2518a) {
            super.setAutoSizeTextTypeUniformWithConfiguration(i, i2, i3, i4);
        } else if (this.f3653c != null) {
            this.f3653c.m3932a(i, i2, i3, i4);
        }
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeUniformWithPresetSizes(int[] iArr, int i) throws IllegalArgumentException {
        if (f2518a) {
            super.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i);
        } else if (this.f3653c != null) {
            this.f3653c.m3938a(iArr, i);
        }
    }

    @Override // android.widget.TextView
    public int getAutoSizeTextType() {
        if (f2518a) {
            return super.getAutoSizeTextType() == 1 ? 1 : 0;
        }
        if (this.f3653c != null) {
            return this.f3653c.m3941d();
        }
        return 0;
    }

    @Override // android.widget.TextView
    public int getAutoSizeStepGranularity() {
        if (f2518a) {
            return super.getAutoSizeStepGranularity();
        }
        if (this.f3653c != null) {
            return this.f3653c.m3942e();
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int getAutoSizeMinTextSize() {
        if (f2518a) {
            return super.getAutoSizeMinTextSize();
        }
        if (this.f3653c != null) {
            return this.f3653c.m3943f();
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int getAutoSizeMaxTextSize() {
        if (f2518a) {
            return super.getAutoSizeMaxTextSize();
        }
        if (this.f3653c != null) {
            return this.f3653c.m3944g();
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int[] getAutoSizeTextAvailableSizes() {
        if (f2518a) {
            return super.getAutoSizeTextAvailableSizes();
        }
        if (this.f3653c != null) {
            return this.f3653c.m3945h();
        }
        return new int[0];
    }

    public void setSupportAllCaps(boolean z) {
        if (this.f3653c != null) {
            this.f3653c.m3936a(z);
        }
    }
}
