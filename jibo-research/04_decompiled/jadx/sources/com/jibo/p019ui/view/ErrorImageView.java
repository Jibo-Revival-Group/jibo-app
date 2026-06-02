package com.jibo.p019ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

/* JADX INFO: loaded from: classes.dex */
public class ErrorImageView extends ImageView {

    /* JADX INFO: renamed from: a */
    private boolean f11556a;

    public ErrorImageView(Context context) {
        super(context);
        this.f11556a = false;
    }

    public ErrorImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f11556a = false;
    }

    public ErrorImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f11556a = false;
    }

    public boolean getError() {
        return this.f11556a;
    }

    public void setError(boolean z) {
        this.f11556a = z;
    }
}
