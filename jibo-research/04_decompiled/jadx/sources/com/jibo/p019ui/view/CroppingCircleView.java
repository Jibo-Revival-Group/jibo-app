package com.jibo.p019ui.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ImageView;
import com.jibo.R;
import com.jibo.utils.ImageUtils;
import com.yalantis.ucrop.view.CropImageView;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class CroppingCircleView extends ImageView {

    /* JADX INFO: renamed from: A */
    private boolean f11529A;

    /* JADX INFO: renamed from: B */
    private boolean f11530B;

    /* JADX INFO: renamed from: e */
    private Paint f11531e;

    /* JADX INFO: renamed from: f */
    private Paint f11532f;

    /* JADX INFO: renamed from: g */
    private Paint f11533g;

    /* JADX INFO: renamed from: h */
    private Path f11534h;

    /* JADX INFO: renamed from: i */
    private RectF f11535i;

    /* JADX INFO: renamed from: j */
    private RectF f11536j;

    /* JADX INFO: renamed from: k */
    private RectF f11537k;

    /* JADX INFO: renamed from: l */
    private Rect f11538l;

    /* JADX INFO: renamed from: m */
    private Path f11539m;

    /* JADX INFO: renamed from: n */
    private int f11540n;

    /* JADX INFO: renamed from: o */
    private int f11541o;

    /* JADX INFO: renamed from: p */
    private int f11542p;

    /* JADX INFO: renamed from: q */
    private int f11543q;

    /* JADX INFO: renamed from: r */
    private int f11544r;

    /* JADX INFO: renamed from: s */
    private int f11545s;

    /* JADX INFO: renamed from: t */
    private int f11546t;

    /* JADX INFO: renamed from: u */
    private int f11547u;

    /* JADX INFO: renamed from: v */
    private int f11548v;

    /* JADX INFO: renamed from: w */
    private float f11549w;

    /* JADX INFO: renamed from: x */
    private float f11550x;

    /* JADX INFO: renamed from: y */
    private float f11551y;

    /* JADX INFO: renamed from: z */
    private File f11552z;

    /* JADX INFO: renamed from: b */
    private static String f11526b = "radius";

    /* JADX INFO: renamed from: c */
    private static String f11527c = "x";

    /* JADX INFO: renamed from: d */
    private static String f11528d = "y";

    /* JADX INFO: renamed from: a */
    public static int f11525a = 500;

    public CroppingCircleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f11540n = -1;
        this.f11541o = -1;
        this.f11542p = -1;
        this.f11543q = -1;
        this.f11529A = false;
        this.f11530B = false;
        m11250a();
    }

    public CroppingCircleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f11540n = -1;
        this.f11541o = -1;
        this.f11542p = -1;
        this.f11543q = -1;
        this.f11529A = false;
        this.f11530B = false;
        m11250a();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f11537k != null) {
            this.f11534h.reset();
            this.f11534h.addOval(this.f11537k, Path.Direction.CW);
            this.f11539m.reset();
            int i = this.f11542p + 2;
            this.f11539m.moveTo(this.f11540n - i, this.f11541o - i);
            this.f11539m.lineTo(this.f11540n + i, this.f11541o - i);
            this.f11539m.lineTo(this.f11540n + i, this.f11541o + i);
            this.f11539m.lineTo(this.f11540n - i, this.f11541o + i);
            this.f11539m.lineTo(this.f11540n - i, this.f11541o - i);
            this.f11539m.lineTo(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO);
            this.f11539m.lineTo(CropImageView.DEFAULT_ASPECT_RATIO, getHeight());
            this.f11539m.lineTo(getWidth(), getHeight());
            this.f11539m.lineTo(getWidth(), CropImageView.DEFAULT_ASPECT_RATIO);
            this.f11539m.lineTo(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO);
            this.f11539m.close();
            canvas.drawPath(this.f11534h, this.f11531e);
            canvas.drawPath(this.f11539m, this.f11531e);
            canvas.drawOval(this.f11535i, this.f11532f);
            canvas.drawArc(this.f11536j, 290.0f, 50.0f, false, this.f11533g);
            if (this.f11530B) {
                Rect rect = new Rect(0, getHeight() - f11525a, f11525a, getHeight());
                try {
                    Bitmap bitmapDecodeRegion = BitmapRegionDecoder.newInstance(this.f11552z.getPath(), false).decodeRegion(this.f11538l, null);
                    if (bitmapDecodeRegion != null) {
                        canvas.drawBitmap(bitmapDecodeRegion, new Rect(0, 0, bitmapDecodeRegion.getWidth(), bitmapDecodeRegion.getHeight()), rect, (Paint) null);
                    }
                } catch (IOException e) {
                }
            }
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f11540n = this.f11540n == -1 ? i / 2 : this.f11540n;
        this.f11541o = this.f11541o == -1 ? i2 / 2 : this.f11541o;
        m11253c();
        m11252b();
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            this.f11542p = ((Bundle) parcelable).getInt(f11526b);
            this.f11543q = this.f11542p - 2;
            this.f11548v = this.f11542p / 4;
            this.f11540n = ((Bundle) parcelable).getInt(f11527c);
            this.f11541o = ((Bundle) parcelable).getInt(f11528d);
            m11252b();
            super.onRestoreInstanceState(((Bundle) parcelable).getParcelable("instanceState"));
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putInt(f11526b, this.f11542p);
        bundle.putInt(f11527c, this.f11540n);
        bundle.putInt(f11528d, this.f11541o);
        bundle.putParcelable("instanceState", super.onSaveInstanceState());
        return bundle;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getPointerCount() == 1 && getDrawable() != null) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            switch (motionEvent.getActionMasked()) {
                case 0:
                    if (x >= (this.f11540n + this.f11542p) - (this.f11548v * 2) && x <= this.f11540n + this.f11542p && y >= this.f11541o - this.f11542p && y <= (this.f11541o - this.f11542p) + (this.f11548v * 2)) {
                        this.f11529A = true;
                        this.f11550x = x;
                        this.f11551y = y;
                    } else {
                        this.f11529A = false;
                        this.f11540n = m11248a(this.f11543q, (int) (x - (this.f11542p / 2)));
                        this.f11541o = m11251b(this.f11543q, (int) (y - (this.f11542p / 2)));
                    }
                    break;
                case 1:
                    this.f11529A = false;
                    break;
                case 2:
                    if (this.f11529A) {
                        this.f11542p = m11249a(this.f11542p, Math.min(Math.max((int) Math.round((Math.sqrt(Math.pow(x - this.f11540n, 2.0d) + Math.pow(y - this.f11541o, 2.0d)) / Math.sqrt(Math.pow(this.f11550x - this.f11540n, 2.0d) + Math.pow(this.f11551y - this.f11541o, 2.0d))) * ((double) this.f11542p)), this.f11544r), this.f11545s), this.f11540n, this.f11541o);
                        this.f11543q = this.f11542p - 2;
                        this.f11548v = this.f11542p / 4;
                        this.f11550x = x;
                        this.f11551y = y;
                    } else {
                        this.f11540n = m11248a(this.f11543q, (int) (x - (this.f11542p / 2)));
                        this.f11541o = m11251b(this.f11543q, (int) (y - (this.f11542p / 2)));
                    }
                    break;
            }
            m11252b();
            invalidate();
        }
        return true;
    }

    /* JADX INFO: renamed from: a */
    private void m11250a() {
        this.f11542p = getResources().getDimensionPixelSize(R.dimen.avatar_size_small);
        this.f11543q = this.f11542p - 2;
        this.f11545s = getResources().getDimensionPixelSize(R.dimen.avatar_size);
        this.f11544r = (int) (getResources().getDimensionPixelSize(R.dimen.avatar_size_small) - (getResources().getDimensionPixelSize(R.dimen.avatar_size_small) * 0.1f));
        this.f11548v = this.f11542p / 4;
        this.f11531e = new Paint();
        this.f11531e.setARGB(100, 0, 0, 0);
        this.f11531e.setStrokeCap(Paint.Cap.SQUARE);
        this.f11531e.setStrokeWidth(CropImageView.DEFAULT_ASPECT_RATIO);
        this.f11532f = new Paint();
        this.f11532f.setColor(-1);
        this.f11532f.setStrokeWidth(4.0f);
        this.f11532f.setStyle(Paint.Style.STROKE);
        this.f11532f.setAntiAlias(true);
        this.f11533g = new Paint();
        this.f11533g.setColor(getResources().getColor(R.color.jibo_blue));
        this.f11533g.setStrokeWidth(6.0f);
        this.f11533g.setStyle(Paint.Style.STROKE);
        this.f11533g.setAntiAlias(true);
        this.f11534h = new Path();
        this.f11534h.setFillType(Path.FillType.INVERSE_EVEN_ODD);
        this.f11539m = new Path();
        this.f11539m.setFillType(Path.FillType.EVEN_ODD);
    }

    /* JADX INFO: renamed from: b */
    private void m11252b() {
        if (this.f11552z != null && getWidth() != 0 && getHeight() != 0) {
            this.f11537k = new RectF(this.f11540n - this.f11542p, this.f11541o - this.f11542p, this.f11540n + this.f11542p, this.f11541o + this.f11542p);
            this.f11535i = new RectF(this.f11540n - this.f11543q, this.f11541o - this.f11543q, this.f11540n + this.f11543q, this.f11541o + this.f11543q);
            this.f11536j = new RectF(this.f11535i.left - 1.0f, this.f11535i.top - 1.0f, this.f11535i.right - 1.0f, this.f11535i.bottom - 1.0f);
            int width = this.f11540n - (getWidth() / 2);
            int height = this.f11541o - (getHeight() / 2);
            this.f11538l = new Rect((this.f11546t / 2) - ((int) (((-width) + this.f11543q) * this.f11549w)), (this.f11547u / 2) - ((int) (((-height) + this.f11543q) * this.f11549w)), ((int) ((width + this.f11543q) * this.f11549w)) + (this.f11546t / 2), ((int) ((height + this.f11543q) * this.f11549w)) + (this.f11547u / 2));
        }
    }

    /* JADX INFO: renamed from: a */
    private int m11248a(int i, int i2) {
        float[] bitmapInViewBounds = getBitmapInViewBounds();
        int width = ((int) ((getWidth() / 2) - (bitmapInViewBounds[0] / 2.0f))) + 2;
        int width2 = ((int) ((bitmapInViewBounds[0] / 2.0f) + (getWidth() / 2))) - 2;
        int i3 = i2 - i < width ? width + i : i2;
        return i3 + i > width2 ? width2 - i : i3;
    }

    /* JADX INFO: renamed from: b */
    private int m11251b(int i, int i2) {
        float[] bitmapInViewBounds = getBitmapInViewBounds();
        int height = ((int) ((getHeight() / 2) - (bitmapInViewBounds[1] / 2.0f))) + 2;
        int height2 = ((int) ((bitmapInViewBounds[1] / 2.0f) + (getHeight() / 2))) - 2;
        int i3 = i2 - i < height ? height + i : i2;
        return i3 + i > height2 ? height2 - i : i3;
    }

    /* JADX INFO: renamed from: a */
    private int m11249a(int i, int i2, int i3, int i4) {
        return (i3 == m11248a(i2, i3) && i4 == m11251b(i2, i4)) ? i2 : i;
    }

    private float[] getBitmapInViewBounds() {
        float[] fArr = {getWidth(), getHeight()};
        float width = getWidth() / getDrawable().getIntrinsicWidth();
        float height = getHeight() / getDrawable().getIntrinsicHeight();
        if (getDrawable().getIntrinsicWidth() / getDrawable().getIntrinsicHeight() > 1.0f || getDrawable().getIntrinsicHeight() * width < getHeight()) {
            fArr[1] = getDrawable().getIntrinsicHeight() * width;
        } else {
            fArr[0] = getDrawable().getIntrinsicWidth() * height;
        }
        return fArr;
    }

    /* JADX INFO: renamed from: c */
    private void m11253c() {
        if (this.f11552z != null && getWidth() != 0 && getHeight() != 0) {
            try {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeFile(this.f11552z.getPath(), options);
                this.f11546t = options.outWidth;
                this.f11547u = options.outHeight;
                setImageBitmap(ImageUtils.m11390a(this.f11552z.getPath(), getWidth(), getHeight()));
                this.f11549w = this.f11546t / getBitmapInViewBounds()[0];
            } catch (FileNotFoundException e) {
            }
        }
    }

    public void setImageFile(File file) {
        this.f11552z = file;
        m11253c();
        m11252b();
    }

    public Bitmap getCroppedImage() {
        try {
            return BitmapRegionDecoder.newInstance(this.f11552z.getPath(), false).decodeRegion(this.f11538l, null);
        } catch (Exception e) {
            return null;
        }
    }

    public void setCropPreview(boolean z) {
        this.f11530B = z;
    }
}
