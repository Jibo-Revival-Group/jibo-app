package android.support.v7.widget;

import android.R;
import android.content.Context;
import android.support.v7.content.res.AppCompatResources;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.CheckedTextView;

/* JADX INFO: loaded from: classes.dex */
public class AppCompatCheckedTextView extends CheckedTextView {

    /* JADX INFO: renamed from: a */
    private static final int[] f3655a = {R.attr.checkMark};

    /* JADX INFO: renamed from: b */
    private final AppCompatTextHelper f3656b;

    public AppCompatCheckedTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.checkedTextViewStyle);
    }

    public AppCompatCheckedTextView(Context context, AttributeSet attributeSet, int i) {
        super(TintContextWrapper.m4950a(context), attributeSet, i);
        this.f3656b = AppCompatTextHelper.m3923a(this);
        this.f3656b.mo3935a(attributeSet, i);
        this.f3656b.mo3929a();
        TintTypedArray tintTypedArrayM4955a = TintTypedArray.m4955a(getContext(), attributeSet, f3655a, i, 0);
        setCheckMarkDrawable(tintTypedArrayM4955a.m4959a(0));
        tintTypedArrayM4955a.m4960a();
    }

    @Override // android.widget.CheckedTextView
    public void setCheckMarkDrawable(int i) {
        setCheckMarkDrawable(AppCompatResources.m3426b(getContext(), i));
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        if (this.f3656b != null) {
            this.f3656b.m3933a(context, i);
        }
    }

    @Override // android.widget.CheckedTextView, android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f3656b != null) {
            this.f3656b.mo3929a();
        }
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        return AppCompatHintHelper.m3890a(super.onCreateInputConnection(editorInfo), editorInfo, this);
    }
}
