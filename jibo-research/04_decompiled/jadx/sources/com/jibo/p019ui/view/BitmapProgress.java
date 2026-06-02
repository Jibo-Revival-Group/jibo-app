package com.jibo.p019ui.view;

import android.R;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import com.yalantis.ucrop.view.CropImageView;

/* JADX INFO: loaded from: classes.dex */
public class BitmapProgress extends View {

    /* JADX INFO: renamed from: a */
    private int f11510a;

    /* JADX INFO: renamed from: b */
    private int f11511b;

    /* JADX INFO: renamed from: c */
    private Bitmap f11512c;

    /* JADX INFO: renamed from: d */
    private Path f11513d;

    /* JADX INFO: renamed from: e */
    private Paint f11514e;

    /* JADX INFO: renamed from: f */
    private int f11515f;

    /* JADX INFO: renamed from: g */
    private int f11516g;

    /* JADX INFO: renamed from: h */
    private int f11517h;

    /* JADX INFO: renamed from: i */
    private float f11518i;

    /* JADX INFO: renamed from: j */
    private int f11519j;

    /* JADX INFO: renamed from: k */
    private Handler f11520k;

    public BitmapProgress(Context context) {
        this(context, null, 0);
    }

    public BitmapProgress(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BitmapProgress(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f11515f = R.color.white;
        this.f11516g = 100;
        this.f11517h = 0;
        this.f11519j = 50;
        this.f11520k = new Handler() { // from class: com.jibo.ui.view.BitmapProgress.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                super.handleMessage(message);
                switch (message.what) {
                    case 1911:
                        BitmapProgress.this.invalidate();
                        sendEmptyMessageDelayed(1911, BitmapProgress.this.f11519j);
                        break;
                }
            }
        };
        m11243b();
    }

    public void setWaveColor(int i) {
        this.f11515f = i;
    }

    public void setProgress(int i) {
        this.f11517h = i;
    }

    public void setMaxProgress(int i) {
        this.f11516g = i;
    }

    public int getCurrentProgress() {
        return this.f11517h;
    }

    /* JADX INFO: renamed from: b */
    private void m11243b() {
        if (getBackground() == null) {
            throw new IllegalArgumentException(String.format("background is null.", new Object[0]));
        }
        m11245a();
        this.f11513d = new Path();
        this.f11514e = new Paint();
        this.f11514e.setAntiAlias(true);
        this.f11514e.setStyle(Paint.Style.FILL);
        this.f11520k.sendEmptyMessageDelayed(1911, 100L);
    }

    /* JADX INFO: renamed from: a */
    public void m11245a() {
        this.f11512c = m11242a(getBackground());
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        this.f11510a = size;
        this.f11518i = size;
        this.f11511b = View.MeasureSpec.getSize(i2);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.f11512c != null) {
            canvas.drawBitmap(m11244c(), CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, (Paint) null);
        }
    }

    /* JADX INFO: renamed from: c */
    private Bitmap m11244c() {
        this.f11514e.setColor(getResources().getColor(this.f11515f));
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(this.f11510a, this.f11511b, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        float f = this.f11510a * (this.f11517h / this.f11516g);
        this.f11513d.reset();
        this.f11513d.moveTo(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO);
        this.f11513d.lineTo(CropImageView.DEFAULT_ASPECT_RATIO, this.f11511b);
        this.f11513d.lineTo(f, this.f11511b);
        this.f11513d.lineTo(f, CropImageView.DEFAULT_ASPECT_RATIO);
        this.f11513d.close();
        canvas.drawPath(this.f11513d, this.f11514e);
        this.f11512c = Bitmap.createScaledBitmap(this.f11512c, this.f11510a, this.f11511b, false);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_ATOP));
        canvas.drawBitmap(this.f11512c, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, paint);
        return bitmapCreateBitmap;
    }

    /* JADX INFO: renamed from: a */
    private Bitmap m11242a(Drawable drawable) {
        if (drawable == null) {
            return null;
        }
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        try {
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmapCreateBitmap);
            drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            drawable.draw(canvas);
            return bitmapCreateBitmap;
        } catch (OutOfMemoryError e) {
            return null;
        }
    }
}
