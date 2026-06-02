package android.support.v7.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.v4.view.TintableBackgroundView;
import android.support.v7.content.res.AppCompatResources;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.MultiAutoCompleteTextView;

/* JADX INFO: loaded from: classes.dex */
public class AppCompatMultiAutoCompleteTextView extends MultiAutoCompleteTextView implements TintableBackgroundView {

    /* JADX INFO: renamed from: a */
    private static final int[] f3689a = {R.attr.popupBackground};

    /* JADX INFO: renamed from: b */
    private final AppCompatBackgroundHelper f3690b;

    /* JADX INFO: renamed from: c */
    private final AppCompatTextHelper f3691c;

    public AppCompatMultiAutoCompleteTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, android.support.v7.appcompat.R.attr.autoCompleteTextViewStyle);
    }

    public AppCompatMultiAutoCompleteTextView(Context context, AttributeSet attributeSet, int i) {
        super(TintContextWrapper.m4950a(context), attributeSet, i);
        TintTypedArray tintTypedArrayM4955a = TintTypedArray.m4955a(getContext(), attributeSet, f3689a, i, 0);
        if (tintTypedArrayM4955a.m4973g(0)) {
            setDropDownBackgroundDrawable(tintTypedArrayM4955a.m4959a(0));
        }
        tintTypedArrayM4955a.m4960a();
        this.f3690b = new AppCompatBackgroundHelper(this);
        this.f3690b.m3844a(attributeSet, i);
        this.f3691c = AppCompatTextHelper.m3923a(this);
        this.f3691c.mo3935a(attributeSet, i);
        this.f3691c.mo3929a();
    }

    @Override // android.widget.AutoCompleteTextView
    public void setDropDownBackgroundResource(int i) {
        setDropDownBackgroundDrawable(AppCompatResources.m3426b(getContext(), i));
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        if (this.f3690b != null) {
            this.f3690b.m3840a(i);
        }
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.f3690b != null) {
            this.f3690b.m3843a(drawable);
        }
    }

    @Override // android.support.v4.view.TintableBackgroundView
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (this.f3690b != null) {
            this.f3690b.m3841a(colorStateList);
        }
    }

    @Override // android.support.v4.view.TintableBackgroundView
    public ColorStateList getSupportBackgroundTintList() {
        if (this.f3690b != null) {
            return this.f3690b.m3839a();
        }
        return null;
    }

    @Override // android.support.v4.view.TintableBackgroundView
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        if (this.f3690b != null) {
            this.f3690b.m3842a(mode);
        }
    }

    @Override // android.support.v4.view.TintableBackgroundView
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        if (this.f3690b != null) {
            return this.f3690b.m3845b();
        }
        return null;
    }

    @Override // android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f3690b != null) {
            this.f3690b.m3847c();
        }
        if (this.f3691c != null) {
            this.f3691c.mo3929a();
        }
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        if (this.f3691c != null) {
            this.f3691c.m3933a(context, i);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        return AppCompatHintHelper.m3890a(super.onCreateInputConnection(editorInfo), editorInfo, this);
    }
}
