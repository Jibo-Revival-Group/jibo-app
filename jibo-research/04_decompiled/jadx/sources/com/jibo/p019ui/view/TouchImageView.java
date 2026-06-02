package com.jibo.p019ui.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import android.widget.OverScroller;
import android.widget.Scroller;
import com.yalantis.ucrop.view.CropImageView;

/* JADX INFO: loaded from: classes.dex */
public class TouchImageView extends ImageView {

    /* JADX INFO: renamed from: A */
    private View.OnTouchListener f11586A;

    /* JADX INFO: renamed from: B */
    private OnTouchImageViewListener f11587B;

    /* JADX INFO: renamed from: a */
    private float f11588a;

    /* JADX INFO: renamed from: b */
    private Matrix f11589b;

    /* JADX INFO: renamed from: c */
    private Matrix f11590c;

    /* JADX INFO: renamed from: d */
    private State f11591d;

    /* JADX INFO: renamed from: e */
    private float f11592e;

    /* JADX INFO: renamed from: f */
    private float f11593f;

    /* JADX INFO: renamed from: g */
    private float f11594g;

    /* JADX INFO: renamed from: h */
    private float f11595h;

    /* JADX INFO: renamed from: i */
    private float[] f11596i;

    /* JADX INFO: renamed from: j */
    private Context f11597j;

    /* JADX INFO: renamed from: k */
    private Fling f11598k;

    /* JADX INFO: renamed from: l */
    private ImageView.ScaleType f11599l;

    /* JADX INFO: renamed from: m */
    private boolean f11600m;

    /* JADX INFO: renamed from: n */
    private boolean f11601n;

    /* JADX INFO: renamed from: o */
    private ZoomVariables f11602o;

    /* JADX INFO: renamed from: p */
    private int f11603p;

    /* JADX INFO: renamed from: q */
    private int f11604q;

    /* JADX INFO: renamed from: r */
    private int f11605r;

    /* JADX INFO: renamed from: s */
    private int f11606s;

    /* JADX INFO: renamed from: t */
    private float f11607t;

    /* JADX INFO: renamed from: u */
    private float f11608u;

    /* JADX INFO: renamed from: v */
    private float f11609v;

    /* JADX INFO: renamed from: w */
    private float f11610w;

    /* JADX INFO: renamed from: x */
    private ScaleGestureDetector f11611x;

    /* JADX INFO: renamed from: y */
    private GestureDetector f11612y;

    /* JADX INFO: renamed from: z */
    private GestureDetector.OnDoubleTapListener f11613z;

    public interface OnTouchImageViewListener {
        /* JADX INFO: renamed from: a */
        void m11345a();
    }

    private enum State {
        NONE,
        DRAG,
        ZOOM,
        FLING,
        ANIMATE_ZOOM
    }

    public TouchImageView(Context context) {
        super(context);
        this.f11613z = null;
        this.f11586A = null;
        this.f11587B = null;
        m11301a(context);
    }

    public TouchImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f11613z = null;
        this.f11586A = null;
        this.f11587B = null;
        m11301a(context);
    }

    public TouchImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f11613z = null;
        this.f11586A = null;
        this.f11587B = null;
        m11301a(context);
    }

    /* JADX INFO: renamed from: a */
    private void m11301a(Context context) {
        C14521 c14521 = null;
        super.setClickable(true);
        this.f11597j = context;
        this.f11611x = new ScaleGestureDetector(context, new ScaleListener(this, c14521));
        this.f11612y = new GestureDetector(context, new GestureListener(this, c14521));
        this.f11589b = new Matrix();
        this.f11590c = new Matrix();
        this.f11596i = new float[9];
        this.f11588a = 1.0f;
        if (this.f11599l == null) {
            this.f11599l = ImageView.ScaleType.FIT_CENTER;
        }
        this.f11592e = 1.0f;
        this.f11593f = 3.0f;
        this.f11594g = 0.75f * this.f11592e;
        this.f11595h = 1.25f * this.f11593f;
        setImageMatrix(this.f11589b);
        setScaleType(ImageView.ScaleType.MATRIX);
        setState(State.NONE);
        this.f11601n = false;
        super.setOnTouchListener(new PrivateOnTouchListener(this, c14521));
    }

    @Override // android.view.View
    public void setOnTouchListener(View.OnTouchListener onTouchListener) {
        this.f11586A = onTouchListener;
    }

    public void setOnTouchImageViewListener(OnTouchImageViewListener onTouchImageViewListener) {
        this.f11587B = onTouchImageViewListener;
    }

    public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
        this.f11613z = onDoubleTapListener;
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        super.setImageResource(i);
        m11310c();
        m11316f();
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        m11310c();
        m11316f();
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        m11310c();
        m11316f();
    }

    @Override // android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        m11310c();
        m11316f();
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType scaleType) {
        if (scaleType == ImageView.ScaleType.FIT_START || scaleType == ImageView.ScaleType.FIT_END) {
            throw new UnsupportedOperationException("TouchImageView does not support FIT_START or FIT_END");
        }
        if (scaleType == ImageView.ScaleType.MATRIX) {
            super.setScaleType(ImageView.ScaleType.MATRIX);
            return;
        }
        this.f11599l = scaleType;
        if (this.f11601n) {
            m11331a(1.0f, 0.5f, 0.5f, getScaleType());
        }
    }

    @Override // android.widget.ImageView
    public ImageView.ScaleType getScaleType() {
        return this.f11599l;
    }

    /* JADX INFO: renamed from: a */
    public boolean m11332a() {
        return this.f11588a != 1.0f;
    }

    public RectF getZoomedRect() {
        if (this.f11599l == ImageView.ScaleType.FIT_XY) {
            throw new UnsupportedOperationException("getZoomedRect() not supported with FIT_XY");
        }
        PointF pointFM11294a = m11294a(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, true);
        PointF pointFM11294a2 = m11294a(this.f11603p, this.f11604q, true);
        float intrinsicWidth = getDrawable().getIntrinsicWidth();
        float intrinsicHeight = getDrawable().getIntrinsicHeight();
        return new RectF(pointFM11294a.x / intrinsicWidth, pointFM11294a.y / intrinsicHeight, pointFM11294a2.x / intrinsicWidth, pointFM11294a2.y / intrinsicHeight);
    }

    /* JADX INFO: renamed from: c */
    private void m11310c() {
        if (this.f11589b != null && this.f11604q != 0 && this.f11603p != 0) {
            this.f11589b.getValues(this.f11596i);
            this.f11590c.setValues(this.f11596i);
            this.f11610w = this.f11608u;
            this.f11609v = this.f11607t;
            this.f11606s = this.f11604q;
            this.f11605r = this.f11603p;
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("instanceState", super.onSaveInstanceState());
        bundle.putFloat("saveScale", this.f11588a);
        bundle.putFloat("matchViewHeight", this.f11608u);
        bundle.putFloat("matchViewWidth", this.f11607t);
        bundle.putInt("viewWidth", this.f11603p);
        bundle.putInt("viewHeight", this.f11604q);
        this.f11589b.getValues(this.f11596i);
        bundle.putFloatArray("matrix", this.f11596i);
        bundle.putBoolean("imageRendered", this.f11600m);
        return bundle;
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            this.f11588a = bundle.getFloat("saveScale");
            this.f11596i = bundle.getFloatArray("matrix");
            this.f11590c.setValues(this.f11596i);
            this.f11610w = bundle.getFloat("matchViewHeight");
            this.f11609v = bundle.getFloat("matchViewWidth");
            this.f11606s = bundle.getInt("viewHeight");
            this.f11605r = bundle.getInt("viewWidth");
            this.f11600m = bundle.getBoolean("imageRendered");
            super.onRestoreInstanceState(bundle.getParcelable("instanceState"));
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        this.f11601n = true;
        this.f11600m = true;
        if (this.f11602o != null) {
            m11331a(this.f11602o.f11637a, this.f11602o.f11638b, this.f11602o.f11639c, this.f11602o.f11640d);
            this.f11602o = null;
        }
        super.onDraw(canvas);
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        m11310c();
    }

    public float getMaxZoom() {
        return this.f11593f;
    }

    public void setMaxZoom(float f) {
        this.f11593f = f;
        this.f11595h = 1.25f * this.f11593f;
    }

    public float getMinZoom() {
        return this.f11592e;
    }

    public float getCurrentZoom() {
        return this.f11588a;
    }

    public void setMinZoom(float f) {
        this.f11592e = f;
        this.f11594g = 0.75f * this.f11592e;
    }

    /* JADX INFO: renamed from: b */
    public void m11334b() {
        this.f11588a = 1.0f;
        m11316f();
    }

    public void setZoom(float f) {
        m11330a(f, 0.5f, 0.5f);
    }

    /* JADX INFO: renamed from: a */
    public void m11330a(float f, float f2, float f3) {
        m11331a(f, f2, f3, this.f11599l);
    }

    /* JADX INFO: renamed from: a */
    public void m11331a(float f, float f2, float f3, ImageView.ScaleType scaleType) {
        if (!this.f11601n) {
            this.f11602o = new ZoomVariables(f, f2, f3, scaleType);
            return;
        }
        if (scaleType != this.f11599l) {
            setScaleType(scaleType);
        }
        m11334b();
        m11299a(f, this.f11603p / 2, this.f11604q / 2, true);
        this.f11589b.getValues(this.f11596i);
        this.f11596i[2] = -((getImageWidth() * f2) - (this.f11603p * 0.5f));
        this.f11596i[5] = -((getImageHeight() * f3) - (this.f11604q * 0.5f));
        this.f11589b.setValues(this.f11596i);
        m11312d();
        setImageMatrix(this.f11589b);
    }

    public void setZoom(TouchImageView touchImageView) {
        PointF scrollPosition = touchImageView.getScrollPosition();
        m11331a(touchImageView.getCurrentZoom(), scrollPosition.x, scrollPosition.y, touchImageView.getScaleType());
    }

    public PointF getScrollPosition() {
        Drawable drawable = getDrawable();
        if (drawable == null) {
            return null;
        }
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        PointF pointFM11294a = m11294a(this.f11603p / 2, this.f11604q / 2, true);
        pointFM11294a.x /= intrinsicWidth;
        pointFM11294a.y /= intrinsicHeight;
        return pointFM11294a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: d */
    public void m11312d() {
        this.f11589b.getValues(this.f11596i);
        float f = this.f11596i[2];
        float f2 = this.f11596i[5];
        float fM11306b = m11306b(f, this.f11603p, getImageWidth());
        float fM11306b2 = m11306b(f2, this.f11604q, getImageHeight());
        if (fM11306b != CropImageView.DEFAULT_ASPECT_RATIO || fM11306b2 != CropImageView.DEFAULT_ASPECT_RATIO) {
            this.f11589b.postTranslate(fM11306b, fM11306b2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: e */
    public void m11314e() {
        m11312d();
        this.f11589b.getValues(this.f11596i);
        if (getImageWidth() < this.f11603p) {
            this.f11596i[2] = (this.f11603p - getImageWidth()) / 2.0f;
        }
        if (getImageHeight() < this.f11604q) {
            this.f11596i[5] = (this.f11604q - getImageHeight()) / 2.0f;
        }
        this.f11589b.setValues(this.f11596i);
    }

    /* JADX INFO: renamed from: b */
    private float m11306b(float f, float f2, float f3) {
        float f4;
        float f5;
        if (f3 <= f2) {
            f5 = f2 - f3;
            f4 = 0.0f;
        } else {
            f4 = f2 - f3;
            f5 = 0.0f;
        }
        if (f < f4) {
            return (-f) + f4;
        }
        return f > f5 ? (-f) + f5 : CropImageView.DEFAULT_ASPECT_RATIO;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: c */
    public float m11308c(float f, float f2, float f3) {
        if (f3 <= f2) {
            return CropImageView.DEFAULT_ASPECT_RATIO;
        }
        return f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float getImageWidth() {
        return this.f11607t * this.f11588a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float getImageHeight() {
        return this.f11608u * this.f11588a;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        Drawable drawable = getDrawable();
        if (drawable == null || drawable.getIntrinsicWidth() == 0 || drawable.getIntrinsicHeight() == 0) {
            this.f11603p = View.MeasureSpec.getSize(i);
            this.f11604q = View.MeasureSpec.getSize(i2);
            this.f11604q = this.f11604q < getLayoutParams().height ? getLayoutParams().height : this.f11604q;
            setMeasuredDimension(this.f11603p, this.f11604q);
            return;
        }
        int i3 = this.f11603p;
        int i4 = this.f11604q;
        this.f11603p = View.MeasureSpec.getSize(i);
        this.f11604q = View.MeasureSpec.getSize(i2);
        this.f11604q = this.f11604q < getLayoutParams().height ? getLayoutParams().height : this.f11604q;
        setMeasuredDimension(this.f11603p, this.f11604q);
        if (i3 != this.f11603p || i4 != this.f11604q) {
            m11316f();
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00c2  */
    /* JADX INFO: renamed from: f */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void m11316f() {
        /*
            Method dump skipped, instruction units count: 298
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jibo.p019ui.view.TouchImageView.m11316f():void");
    }

    /* JADX INFO: renamed from: com.jibo.ui.view.TouchImageView$1 */
    static /* synthetic */ class C14521 {

        /* JADX INFO: renamed from: a */
        static final /* synthetic */ int[] f11614a = new int[ImageView.ScaleType.values().length];

        static {
            try {
                f11614a[ImageView.ScaleType.CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f11614a[ImageView.ScaleType.CENTER_CROP.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f11614a[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f11614a[ImageView.ScaleType.FIT_CENTER.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f11614a[ImageView.ScaleType.FIT_XY.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private void m11300a(int i, float f, float f2, float f3, int i2, int i3, int i4) {
        if (f3 < i3) {
            this.f11596i[i] = (i3 - (i4 * this.f11596i[0])) * 0.5f;
        } else if (f > CropImageView.DEFAULT_ASPECT_RATIO) {
            this.f11596i[i] = -((f3 - i3) * 0.5f);
        } else {
            this.f11596i[i] = -((((Math.abs(f) + (i2 * 0.5f)) / f2) * f3) - (i3 * 0.5f));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setState(State state) {
        this.f11591d = state;
    }

    /* JADX INFO: renamed from: a */
    public boolean m11333a(int i) {
        return canScrollHorizontally(i);
    }

    @Override // android.view.View
    public boolean canScrollHorizontally(int i) {
        this.f11589b.getValues(this.f11596i);
        float f = this.f11596i[2];
        if (getImageWidth() < this.f11603p) {
            return false;
        }
        if (f < -1.0f || i >= 0) {
            return (Math.abs(f) + ((float) this.f11603p)) + 1.0f < getImageWidth() || i <= 0;
        }
        return false;
    }

    private class GestureListener extends GestureDetector.SimpleOnGestureListener {
        private GestureListener() {
        }

        /* synthetic */ GestureListener(TouchImageView touchImageView, C14521 c14521) {
            this();
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            return TouchImageView.this.f11613z != null ? TouchImageView.this.f11613z.onSingleTapConfirmed(motionEvent) : TouchImageView.this.performClick();
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            TouchImageView.this.performLongClick();
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (TouchImageView.this.f11598k != null) {
                TouchImageView.this.f11598k.m11344a();
            }
            TouchImageView.this.f11598k = TouchImageView.this.new Fling((int) f, (int) f2);
            TouchImageView.this.m11305a(TouchImageView.this.f11598k);
            return super.onFling(motionEvent, motionEvent2, f, f2);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            boolean zOnDoubleTap = TouchImageView.this.f11613z != null ? TouchImageView.this.f11613z.onDoubleTap(motionEvent) : false;
            if (TouchImageView.this.f11591d == State.NONE) {
                TouchImageView.this.m11305a(TouchImageView.this.new DoubleTapZoom(TouchImageView.this.f11588a == TouchImageView.this.f11592e ? TouchImageView.this.f11593f : TouchImageView.this.f11592e, motionEvent.getX(), motionEvent.getY(), false));
                return true;
            }
            return zOnDoubleTap;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTapEvent(MotionEvent motionEvent) {
            if (TouchImageView.this.f11613z != null) {
                return TouchImageView.this.f11613z.onDoubleTapEvent(motionEvent);
            }
            return false;
        }
    }

    private class PrivateOnTouchListener implements View.OnTouchListener {

        /* JADX INFO: renamed from: b */
        private PointF f11635b;

        private PrivateOnTouchListener() {
            this.f11635b = new PointF();
        }

        /* synthetic */ PrivateOnTouchListener(TouchImageView touchImageView, C14521 c14521) {
            this();
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            TouchImageView.this.f11611x.onTouchEvent(motionEvent);
            TouchImageView.this.f11612y.onTouchEvent(motionEvent);
            PointF pointF = new PointF(motionEvent.getX(), motionEvent.getY());
            if (TouchImageView.this.f11591d == State.NONE || TouchImageView.this.f11591d == State.DRAG || TouchImageView.this.f11591d == State.FLING) {
                switch (motionEvent.getAction()) {
                    case 0:
                        this.f11635b.set(pointF);
                        if (TouchImageView.this.f11598k != null) {
                            TouchImageView.this.f11598k.m11344a();
                        }
                        TouchImageView.this.setState(State.DRAG);
                        break;
                    case 1:
                    case 6:
                        TouchImageView.this.setState(State.NONE);
                        break;
                    case 2:
                        if (TouchImageView.this.f11591d == State.DRAG) {
                            TouchImageView.this.f11589b.postTranslate(TouchImageView.this.m11308c(pointF.x - this.f11635b.x, TouchImageView.this.f11603p, TouchImageView.this.getImageWidth()), TouchImageView.this.m11308c(pointF.y - this.f11635b.y, TouchImageView.this.f11604q, TouchImageView.this.getImageHeight()));
                            TouchImageView.this.m11312d();
                            this.f11635b.set(pointF.x, pointF.y);
                        }
                        break;
                }
            }
            TouchImageView.this.setImageMatrix(TouchImageView.this.f11589b);
            if (TouchImageView.this.f11586A != null) {
                TouchImageView.this.f11586A.onTouch(view, motionEvent);
            }
            if (TouchImageView.this.f11587B != null) {
                TouchImageView.this.f11587B.m11345a();
                return true;
            }
            return true;
        }
    }

    private class ScaleListener extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        private ScaleListener() {
        }

        /* synthetic */ ScaleListener(TouchImageView touchImageView, C14521 c14521) {
            this();
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            TouchImageView.this.setState(State.ZOOM);
            return true;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            TouchImageView.this.m11299a(scaleGestureDetector.getScaleFactor(), scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY(), true);
            if (TouchImageView.this.f11587B != null) {
                TouchImageView.this.f11587B.m11345a();
            }
            return true;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
            super.onScaleEnd(scaleGestureDetector);
            TouchImageView.this.setState(State.NONE);
            boolean z = false;
            float f = TouchImageView.this.f11588a;
            if (TouchImageView.this.f11588a > TouchImageView.this.f11593f) {
                f = TouchImageView.this.f11593f;
                z = true;
            } else if (TouchImageView.this.f11588a < TouchImageView.this.f11592e) {
                f = TouchImageView.this.f11592e;
                z = true;
            }
            if (z) {
                TouchImageView.this.m11305a(TouchImageView.this.new DoubleTapZoom(f, TouchImageView.this.f11603p / 2, TouchImageView.this.f11604q / 2, true));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public void m11299a(double d, float f, float f2, boolean z) {
        float f3;
        float f4;
        if (z) {
            f3 = this.f11594g;
            f4 = this.f11595h;
        } else {
            f3 = this.f11592e;
            f4 = this.f11593f;
        }
        float f5 = this.f11588a;
        this.f11588a = (float) (((double) this.f11588a) * d);
        if (this.f11588a > f4) {
            this.f11588a = f4;
            d = f4 / f5;
        } else if (this.f11588a < f3) {
            this.f11588a = f3;
            d = f3 / f5;
        }
        this.f11589b.postScale((float) d, (float) d, f, f2);
        m11314e();
    }

    private class DoubleTapZoom implements Runnable {

        /* JADX INFO: renamed from: b */
        private long f11620b;

        /* JADX INFO: renamed from: c */
        private float f11621c;

        /* JADX INFO: renamed from: d */
        private float f11622d;

        /* JADX INFO: renamed from: e */
        private float f11623e;

        /* JADX INFO: renamed from: f */
        private float f11624f;

        /* JADX INFO: renamed from: g */
        private boolean f11625g;

        /* JADX INFO: renamed from: h */
        private AccelerateDecelerateInterpolator f11626h = new AccelerateDecelerateInterpolator();

        /* JADX INFO: renamed from: i */
        private PointF f11627i;

        /* JADX INFO: renamed from: j */
        private PointF f11628j;

        DoubleTapZoom(float f, float f2, float f3, boolean z) {
            TouchImageView.this.setState(State.ANIMATE_ZOOM);
            this.f11620b = System.currentTimeMillis();
            this.f11621c = TouchImageView.this.f11588a;
            this.f11622d = f;
            this.f11625g = z;
            PointF pointFM11294a = TouchImageView.this.m11294a(f2, f3, false);
            this.f11623e = pointFM11294a.x;
            this.f11624f = pointFM11294a.y;
            this.f11627i = TouchImageView.this.m11293a(this.f11623e, this.f11624f);
            this.f11628j = new PointF(TouchImageView.this.f11603p / 2, TouchImageView.this.f11604q / 2);
        }

        @Override // java.lang.Runnable
        public void run() {
            float fM11341a = m11341a();
            TouchImageView.this.m11299a(m11343b(fM11341a), this.f11623e, this.f11624f, this.f11625g);
            m11342a(fM11341a);
            TouchImageView.this.m11314e();
            TouchImageView.this.setImageMatrix(TouchImageView.this.f11589b);
            if (TouchImageView.this.f11587B != null) {
                TouchImageView.this.f11587B.m11345a();
            }
            if (fM11341a < 1.0f) {
                TouchImageView.this.m11305a(this);
            } else {
                TouchImageView.this.setState(State.NONE);
            }
        }

        /* JADX INFO: renamed from: a */
        private void m11342a(float f) {
            float f2 = this.f11627i.x + ((this.f11628j.x - this.f11627i.x) * f);
            float f3 = this.f11627i.y + ((this.f11628j.y - this.f11627i.y) * f);
            PointF pointFM11293a = TouchImageView.this.m11293a(this.f11623e, this.f11624f);
            TouchImageView.this.f11589b.postTranslate(f2 - pointFM11293a.x, f3 - pointFM11293a.y);
        }

        /* JADX INFO: renamed from: a */
        private float m11341a() {
            return this.f11626h.getInterpolation(Math.min(1.0f, (System.currentTimeMillis() - this.f11620b) / 500.0f));
        }

        /* JADX INFO: renamed from: b */
        private double m11343b(float f) {
            return ((double) (this.f11621c + ((this.f11622d - this.f11621c) * f))) / ((double) TouchImageView.this.f11588a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public PointF m11294a(float f, float f2, boolean z) {
        this.f11589b.getValues(this.f11596i);
        float intrinsicWidth = getDrawable().getIntrinsicWidth();
        float intrinsicHeight = getDrawable().getIntrinsicHeight();
        float f3 = this.f11596i[2];
        float f4 = this.f11596i[5];
        float imageWidth = ((f - f3) * intrinsicWidth) / getImageWidth();
        float imageHeight = ((f2 - f4) * intrinsicHeight) / getImageHeight();
        if (z) {
            imageWidth = Math.min(Math.max(imageWidth, CropImageView.DEFAULT_ASPECT_RATIO), intrinsicWidth);
            imageHeight = Math.min(Math.max(imageHeight, CropImageView.DEFAULT_ASPECT_RATIO), intrinsicHeight);
        }
        return new PointF(imageWidth, imageHeight);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public PointF m11293a(float f, float f2) {
        this.f11589b.getValues(this.f11596i);
        return new PointF(((f / getDrawable().getIntrinsicWidth()) * getImageWidth()) + this.f11596i[2], ((f2 / getDrawable().getIntrinsicHeight()) * getImageHeight()) + this.f11596i[5]);
    }

    private class Fling implements Runnable {

        /* JADX INFO: renamed from: a */
        CompatScroller f11629a;

        /* JADX INFO: renamed from: b */
        int f11630b;

        /* JADX INFO: renamed from: c */
        int f11631c;

        Fling(int i, int i2) {
            int i3;
            int imageWidth;
            int i4;
            int imageHeight;
            TouchImageView.this.setState(State.FLING);
            this.f11629a = TouchImageView.this.new CompatScroller(TouchImageView.this.f11597j);
            TouchImageView.this.f11589b.getValues(TouchImageView.this.f11596i);
            int i5 = (int) TouchImageView.this.f11596i[2];
            int i6 = (int) TouchImageView.this.f11596i[5];
            if (TouchImageView.this.getImageWidth() > TouchImageView.this.f11603p) {
                imageWidth = TouchImageView.this.f11603p - ((int) TouchImageView.this.getImageWidth());
                i3 = 0;
            } else {
                i3 = i5;
                imageWidth = i5;
            }
            if (TouchImageView.this.getImageHeight() > TouchImageView.this.f11604q) {
                imageHeight = TouchImageView.this.f11604q - ((int) TouchImageView.this.getImageHeight());
                i4 = 0;
            } else {
                i4 = i6;
                imageHeight = i6;
            }
            this.f11629a.m11335a(i5, i6, i, i2, imageWidth, i3, imageHeight, i4);
            this.f11630b = i5;
            this.f11631c = i6;
        }

        /* JADX INFO: renamed from: a */
        public void m11344a() {
            if (this.f11629a != null) {
                TouchImageView.this.setState(State.NONE);
                this.f11629a.m11336a(true);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (TouchImageView.this.f11587B != null) {
                TouchImageView.this.f11587B.m11345a();
            }
            if (this.f11629a.m11337a()) {
                this.f11629a = null;
                return;
            }
            if (this.f11629a.m11338b()) {
                int iM11339c = this.f11629a.m11339c();
                int iM11340d = this.f11629a.m11340d();
                int i = iM11339c - this.f11630b;
                int i2 = iM11340d - this.f11631c;
                this.f11630b = iM11339c;
                this.f11631c = iM11340d;
                TouchImageView.this.f11589b.postTranslate(i, i2);
                TouchImageView.this.m11312d();
                TouchImageView.this.setImageMatrix(TouchImageView.this.f11589b);
                TouchImageView.this.m11305a(this);
            }
        }
    }

    @TargetApi(9)
    private class CompatScroller {

        /* JADX INFO: renamed from: a */
        Scroller f11615a;

        /* JADX INFO: renamed from: b */
        OverScroller f11616b;

        /* JADX INFO: renamed from: c */
        boolean f11617c;

        public CompatScroller(Context context) {
            if (Build.VERSION.SDK_INT < 9) {
                this.f11617c = true;
                this.f11615a = new Scroller(context);
            } else {
                this.f11617c = false;
                this.f11616b = new OverScroller(context);
            }
        }

        /* JADX INFO: renamed from: a */
        public void m11335a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            if (this.f11617c) {
                this.f11615a.fling(i, i2, i3, i4, i5, i6, i7, i8);
            } else {
                this.f11616b.fling(i, i2, i3, i4, i5, i6, i7, i8);
            }
        }

        /* JADX INFO: renamed from: a */
        public void m11336a(boolean z) {
            if (this.f11617c) {
                this.f11615a.forceFinished(z);
            } else {
                this.f11616b.forceFinished(z);
            }
        }

        /* JADX INFO: renamed from: a */
        public boolean m11337a() {
            return this.f11617c ? this.f11615a.isFinished() : this.f11616b.isFinished();
        }

        /* JADX INFO: renamed from: b */
        public boolean m11338b() {
            if (this.f11617c) {
                return this.f11615a.computeScrollOffset();
            }
            this.f11616b.computeScrollOffset();
            return this.f11616b.computeScrollOffset();
        }

        /* JADX INFO: renamed from: c */
        public int m11339c() {
            return this.f11617c ? this.f11615a.getCurrX() : this.f11616b.getCurrX();
        }

        /* JADX INFO: renamed from: d */
        public int m11340d() {
            return this.f11617c ? this.f11615a.getCurrY() : this.f11616b.getCurrY();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @TargetApi(16)
    /* JADX INFO: renamed from: a */
    public void m11305a(Runnable runnable) {
        if (Build.VERSION.SDK_INT >= 16) {
            postOnAnimation(runnable);
        } else {
            postDelayed(runnable, 16L);
        }
    }

    private class ZoomVariables {

        /* JADX INFO: renamed from: a */
        public float f11637a;

        /* JADX INFO: renamed from: b */
        public float f11638b;

        /* JADX INFO: renamed from: c */
        public float f11639c;

        /* JADX INFO: renamed from: d */
        public ImageView.ScaleType f11640d;

        public ZoomVariables(float f, float f2, float f3, ImageView.ScaleType scaleType) {
            this.f11637a = f;
            this.f11638b = f2;
            this.f11639c = f3;
            this.f11640d = scaleType;
        }
    }
}
