package com.jibo.p019ui.view;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.jibo.R;
import com.yalantis.ucrop.view.CropImageView;

/* JADX INFO: loaded from: classes.dex */
public class MaskLayout extends FrameLayout {

    /* JADX INFO: renamed from: a */
    private Handler f11564a;

    /* JADX INFO: renamed from: b */
    private Drawable f11565b;

    /* JADX INFO: renamed from: c */
    private Bitmap f11566c;

    /* JADX INFO: renamed from: d */
    private boolean f11567d;

    /* JADX INFO: renamed from: e */
    private Paint f11568e;

    /* JADX INFO: renamed from: f */
    private PorterDuffXfermode f11569f;

    public MaskLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f11565b = null;
        this.f11566c = null;
        this.f11567d = false;
        this.f11568e = null;
        this.f11569f = null;
        m11267a(context, attributeSet);
    }

    public MaskLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f11565b = null;
        this.f11566c = null;
        this.f11567d = false;
        this.f11568e = null;
        this.f11569f = null;
        m11267a(context, attributeSet);
    }

    /* JADX INFO: renamed from: a */
    private void m11267a(Context context, AttributeSet attributeSet) {
        this.f11564a = new Handler();
        setDrawingCacheEnabled(true);
        if (Build.VERSION.SDK_INT >= 11) {
            setLayerType(1, null);
        }
        this.f11568e = m11261a(false);
        Resources.Theme theme = context.getTheme();
        if (theme != null) {
            TypedArray typedArrayObtainStyledAttributes = theme.obtainStyledAttributes(attributeSet, R.styleable.MaskLayout, 0, 0);
            try {
                m11269a(m11263a(typedArrayObtainStyledAttributes));
                this.f11569f = m11262a(typedArrayObtainStyledAttributes.getInteger(2, 0));
                m11269a(this.f11565b);
                if (typedArrayObtainStyledAttributes.getBoolean(0, false)) {
                    this.f11568e = m11261a(true);
                }
            } finally {
                if (typedArrayObtainStyledAttributes != null) {
                    typedArrayObtainStyledAttributes.recycle();
                }
            }
        } else {
            m11272a("Couldn't load theme, mask in xml won't be loaded.");
        }
        m11265a();
    }

    /* JADX INFO: renamed from: a */
    private Paint m11261a(boolean z) {
        Paint paint = new Paint(1);
        paint.setAntiAlias(z);
        paint.setXfermode(this.f11569f);
        return paint;
    }

    /* JADX INFO: renamed from: a */
    private Drawable m11263a(TypedArray typedArray) {
        return typedArray.getDrawable(1);
    }

    /* JADX INFO: renamed from: a */
    private void m11269a(Drawable drawable) {
        if (drawable != null) {
            this.f11565b = drawable;
            if (this.f11565b instanceof AnimationDrawable) {
                this.f11565b.setCallback(this);
                return;
            }
            return;
        }
        m11272a("Are you sure you don't want to provide a mask ?");
    }

    public Drawable getDrawableMask() {
        return this.f11565b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: b */
    public Bitmap m11273b(Drawable drawable) {
        if (drawable != null) {
            if (getMeasuredWidth() > 0 && getMeasuredHeight() > 0) {
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap(getMeasuredWidth(), getMeasuredHeight(), Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(bitmapCreateBitmap);
                drawable.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
                drawable.draw(canvas);
                return bitmapCreateBitmap;
            }
            m11272a("Can't create a mask with height 0 or width 0. Or the layout has no children and is wrap content");
            return null;
        }
        m11272a("No bitmap mask loaded, view will NOT be masked !");
        return null;
    }

    public void setMask(int i) {
        Resources resources = getResources();
        if (resources != null) {
            setMask(resources.getDrawable(i));
        } else {
            m11272a("Unable to load resources, mask will not be loaded as drawable");
        }
    }

    public void setMask(Drawable drawable) {
        m11269a(drawable);
        m11268a(m11273b(this.f11565b));
        invalidate();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        m11266a(i, i2);
    }

    /* JADX INFO: renamed from: a */
    private void m11266a(int i, int i2) {
        if (i > 0 && i2 > 0) {
            if (this.f11565b != null) {
                m11268a(m11273b(this.f11565b));
                return;
            }
            return;
        }
        m11272a("Width and height must be higher than 0");
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.f11566c != null && this.f11568e != null) {
            this.f11568e.setXfermode(this.f11569f);
            canvas.drawBitmap(this.f11566c, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, this.f11568e);
            this.f11568e.setXfermode(null);
            return;
        }
        m11272a("Mask or paint is null ...");
    }

    /* JADX INFO: renamed from: a */
    private void m11265a() {
        final ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
            viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.jibo.ui.view.MaskLayout.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    ViewTreeObserver viewTreeObserver2 = viewTreeObserver;
                    if (!viewTreeObserver2.isAlive()) {
                        viewTreeObserver2 = MaskLayout.this.getViewTreeObserver();
                    }
                    if (viewTreeObserver2 == null) {
                        MaskLayout.this.m11272a("GlobalLayoutListener not removed as ViewTreeObserver is not valid");
                    } else if (Build.VERSION.SDK_INT >= 16) {
                        viewTreeObserver2.removeOnGlobalLayoutListener(this);
                    } else {
                        viewTreeObserver2.removeGlobalOnLayoutListener(this);
                    }
                    MaskLayout.this.m11268a(MaskLayout.this.m11273b(MaskLayout.this.f11565b));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public void m11272a(String str) {
        Log.d("MaskLayout", str);
    }

    @Override // android.view.View, android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        if (drawable != null) {
            m11269a(drawable);
            m11268a(m11273b(drawable));
            invalidate();
        }
    }

    @Override // android.view.View, android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        if (drawable != null && runnable != null) {
            this.f11564a.postAtTime(runnable, j);
        }
    }

    @Override // android.view.View, android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        if (drawable != null && runnable != null) {
            this.f11564a.removeCallbacks(runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public void m11268a(Bitmap bitmap) {
        if (bitmap != null) {
            if (this.f11566c != null && !this.f11566c.isRecycled()) {
                this.f11566c.recycle();
            }
            this.f11566c = bitmap;
        }
    }

    /* JADX INFO: renamed from: a */
    private PorterDuffXfermode m11262a(int i) {
        PorterDuff.Mode mode;
        switch (i) {
            case 0:
                if (Build.VERSION.SDK_INT >= 11) {
                    PorterDuff.Mode mode2 = PorterDuff.Mode.ADD;
                    break;
                } else {
                    m11272a("MODE_ADD is not supported on api lvl " + Build.VERSION.SDK_INT);
                    break;
                }
            case 1:
                mode = PorterDuff.Mode.CLEAR;
                break;
            case 2:
                mode = PorterDuff.Mode.DARKEN;
                break;
            case 3:
                mode = PorterDuff.Mode.DST;
                break;
            case 4:
                mode = PorterDuff.Mode.DST_ATOP;
                break;
            case 5:
                mode = PorterDuff.Mode.DST_IN;
                break;
            case 6:
                mode = PorterDuff.Mode.DST_OUT;
                break;
            case 7:
                mode = PorterDuff.Mode.DST_OVER;
                break;
            case 8:
                mode = PorterDuff.Mode.LIGHTEN;
                break;
            case 9:
                mode = PorterDuff.Mode.MULTIPLY;
                break;
            case 10:
                if (Build.VERSION.SDK_INT >= 11) {
                    PorterDuff.Mode mode3 = PorterDuff.Mode.OVERLAY;
                    break;
                } else {
                    m11272a("MODE_OVERLAY is not supported on api lvl " + Build.VERSION.SDK_INT);
                    break;
                }
            case 11:
                mode = PorterDuff.Mode.SCREEN;
                break;
            case 12:
                mode = PorterDuff.Mode.SRC;
                break;
            case 13:
                mode = PorterDuff.Mode.SRC_ATOP;
                break;
            case 14:
                mode = PorterDuff.Mode.SRC_IN;
                break;
            case 15:
                mode = PorterDuff.Mode.SRC_OUT;
                break;
            case 16:
                mode = PorterDuff.Mode.SRC_OVER;
                break;
            case 17:
                mode = PorterDuff.Mode.XOR;
                break;
            default:
                mode = PorterDuff.Mode.DST_IN;
                break;
        }
        m11272a("Mode is " + mode.toString());
        return new PorterDuffXfermode(mode);
    }
}
