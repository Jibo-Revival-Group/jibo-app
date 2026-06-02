package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.v4.widget.TintableCompoundButton;
import android.support.v7.appcompat.R;
import android.support.v7.content.res.AppCompatResources;
import android.util.AttributeSet;
import android.widget.RadioButton;

/* JADX INFO: loaded from: classes.dex */
public class AppCompatRadioButton extends RadioButton implements TintableCompoundButton {

    /* JADX INFO: renamed from: a */
    private final AppCompatCompoundButtonHelper f3697a;

    /* JADX INFO: renamed from: b */
    private final AppCompatTextHelper f3698b;

    public AppCompatRadioButton(Context context) {
        this(context, null);
    }

    public AppCompatRadioButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.radioButtonStyle);
    }

    public AppCompatRadioButton(Context context, AttributeSet attributeSet, int i) {
        super(TintContextWrapper.m4950a(context), attributeSet, i);
        this.f3697a = new AppCompatCompoundButtonHelper(this);
        this.f3697a.m3852a(attributeSet, i);
        this.f3698b = new AppCompatTextHelper(this);
        this.f3698b.mo3935a(attributeSet, i);
    }

    @Override // android.widget.CompoundButton
    public void setButtonDrawable(Drawable drawable) {
        super.setButtonDrawable(drawable);
        if (this.f3697a != null) {
            this.f3697a.m3854c();
        }
    }

    @Override // android.widget.CompoundButton
    public void setButtonDrawable(int i) {
        setButtonDrawable(AppCompatResources.m3426b(getContext(), i));
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingLeft() {
        int compoundPaddingLeft = super.getCompoundPaddingLeft();
        return this.f3697a != null ? this.f3697a.m3848a(compoundPaddingLeft) : compoundPaddingLeft;
    }

    @Override // android.support.v4.widget.TintableCompoundButton
    public void setSupportButtonTintList(ColorStateList colorStateList) {
        if (this.f3697a != null) {
            this.f3697a.m3850a(colorStateList);
        }
    }

    public ColorStateList getSupportButtonTintList() {
        if (this.f3697a != null) {
            return this.f3697a.m3849a();
        }
        return null;
    }

    @Override // android.support.v4.widget.TintableCompoundButton
    public void setSupportButtonTintMode(PorterDuff.Mode mode) {
        if (this.f3697a != null) {
            this.f3697a.m3851a(mode);
        }
    }

    public PorterDuff.Mode getSupportButtonTintMode() {
        if (this.f3697a != null) {
            return this.f3697a.m3853b();
        }
        return null;
    }
}
