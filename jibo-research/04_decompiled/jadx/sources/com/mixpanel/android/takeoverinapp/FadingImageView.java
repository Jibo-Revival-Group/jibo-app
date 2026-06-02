package com.mixpanel.android.takeoverinapp;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.yalantis.ucrop.view.CropImageView;

/* JADX INFO: loaded from: classes.dex */
public class FadingImageView extends ImageView {

    /* JADX INFO: renamed from: a */
    private Matrix f12056a;

    /* JADX INFO: renamed from: b */
    private Paint f12057b;

    /* JADX INFO: renamed from: c */
    private Shader f12058c;

    /* JADX INFO: renamed from: d */
    private Paint f12059d;

    /* JADX INFO: renamed from: e */
    private Shader f12060e;

    /* JADX INFO: renamed from: f */
    private int f12061f;

    /* JADX INFO: renamed from: g */
    private int f12062g;

    /* JADX INFO: renamed from: h */
    private boolean f12063h;

    public FadingImageView(Context context) {
        super(context);
        m11988a();
    }

    public FadingImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m11988a();
    }

    public FadingImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m11988a();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.f12063h) {
            this.f12061f = getHeight();
            this.f12062g = getWidth();
            this.f12056a.setScale(1.0f, View.MeasureSpec.getSize(i2));
            this.f12058c.setLocalMatrix(this.f12056a);
            this.f12060e.setLocalMatrix(this.f12056a);
        }
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        if (this.f12063h) {
            Rect clipBounds = canvas.getClipBounds();
            int iSaveLayer = canvas.saveLayer(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, clipBounds.width(), clipBounds.height(), null, 31);
            super.draw(canvas);
            canvas.drawRect(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, this.f12062g, this.f12061f, this.f12057b);
            canvas.restoreToCount(iSaveLayer);
            return;
        }
        super.draw(canvas);
    }

    /* JADX INFO: renamed from: a */
    private void m11988a() {
        this.f12056a = new Matrix();
        this.f12057b = new Paint();
        this.f12058c = new LinearGradient(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, 1.0f, new int[]{-16777216, -16777216, -452984832, 0}, new float[]{CropImageView.DEFAULT_ASPECT_RATIO, 0.2f, 0.4f, 1.0f}, Shader.TileMode.CLAMP);
        this.f12057b.setShader(this.f12058c);
        this.f12057b.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        this.f12059d = new Paint();
        this.f12060e = new LinearGradient(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, 1.0f, new int[]{0, 0, -16777216, -16777216}, new float[]{CropImageView.DEFAULT_ASPECT_RATIO, 0.85f, 0.98f, 1.0f}, Shader.TileMode.CLAMP);
        this.f12059d.setShader(this.f12060e);
        this.f12057b.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
    }

    /* JADX INFO: renamed from: a */
    public void m11989a(boolean z) {
        this.f12063h = z;
    }
}
