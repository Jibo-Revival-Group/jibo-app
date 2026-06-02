package com.jibo.p019ui.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.jibo.R;

/* JADX INFO: loaded from: classes.dex */
public class BottomPanelButton extends FrameLayout {

    /* JADX INFO: renamed from: a */
    Unbinder f11522a;

    /* JADX INFO: renamed from: b */
    private boolean f11523b;

    @BindView
    TextView badge;

    @BindView
    ImageView icon;

    @BindView
    TextView text;

    public BottomPanelButton(Context context) {
        super(context);
        this.f11523b = true;
        m11246a();
    }

    public BottomPanelButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f11523b = true;
        m11247a(context, attributeSet);
    }

    public BottomPanelButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f11523b = true;
        m11247a(context, attributeSet);
    }

    @Override // android.view.View
    public void setSelected(boolean z) {
        super.setSelected(z);
        this.text.setSelected(z);
        this.icon.setSelected(z);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f11522a.unbind();
    }

    /* JADX INFO: renamed from: a */
    private void m11246a() {
        ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(R.layout.view_bottom_panel_button, this);
        this.f11522a = ButterKnife.m5153a(this);
    }

    /* JADX INFO: renamed from: a */
    private void m11247a(Context context, AttributeSet attributeSet) {
        m11246a();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.BottomPanelButton);
        String string = typedArrayObtainStyledAttributes.getString(1);
        if (string != null) {
            this.text.setText(string);
        }
        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(0);
        if (drawable != null) {
            this.icon.setImageDrawable(drawable);
        }
    }

    public void setBadgeNumber(int i) {
        if (i > 0) {
            this.badge.setText(String.valueOf(i));
            this.badge.setVisibility(0);
        } else {
            this.badge.setVisibility(8);
        }
    }

    public void setIcon(Drawable drawable) {
        this.icon.setImageDrawable(drawable);
    }

    public void setText(int i) {
        this.text.setText(i);
    }

    public void setText(String str) {
        this.text.setText(str);
    }
}
