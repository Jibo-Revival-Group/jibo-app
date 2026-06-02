package com.yalantis.ucrop.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Region;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.yalantis.ucrop.C1735R;
import com.yalantis.ucrop.callback.OverlayViewChangeListener;
import com.yalantis.ucrop.util.RectUtils;

/* JADX INFO: loaded from: classes.dex */
public class OverlayView extends View {
    public static final int DEFAULT_CROP_GRID_COLUMN_COUNT = 2;
    public static final int DEFAULT_CROP_GRID_ROW_COUNT = 2;
    public static final boolean DEFAULT_FREESTYLE_CROP_ENABLED = false;
    public static final boolean DEFAULT_OVAL_DIMMED_LAYER = false;
    public static final boolean DEFAULT_SHOW_CROP_FRAME = true;
    public static final boolean DEFAULT_SHOW_CROP_GRID = true;
    private OverlayViewChangeListener mCallback;
    private Path mCircularPath;
    private Paint mCropFrameCornersPaint;
    private Paint mCropFramePaint;
    private int mCropGridColumnCount;
    protected float[] mCropGridCorners;
    private Paint mCropGridPaint;
    private int mCropGridRowCount;
    private int mCropRectCornerTouchAreaLineLength;
    private int mCropRectMinSize;
    private final RectF mCropViewRect;
    private int mCurrentTouchCornerIndex;
    private int mDimmedColor;
    private Paint mDimmedStrokePaint;
    private float[] mGridPoints;
    private boolean mIsFreestyleCropEnabled;
    private boolean mOvalDimmedLayer;
    private boolean mShowCropFrame;
    private boolean mShowCropGrid;
    private float mTargetAspectRatio;
    private final RectF mTempRect;
    protected int mThisHeight;
    protected int mThisWidth;
    private int mTouchPointThreshold;

    public OverlayView(Context context) {
        this(context, null);
    }

    public OverlayView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public OverlayView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCropViewRect = new RectF();
        this.mTempRect = new RectF();
        this.mGridPoints = null;
        this.mCircularPath = new Path();
        this.mDimmedStrokePaint = new Paint(1);
        this.mCropGridPaint = new Paint(1);
        this.mCropFramePaint = new Paint(1);
        this.mCropFrameCornersPaint = new Paint(1);
        this.mIsFreestyleCropEnabled = false;
        this.mCurrentTouchCornerIndex = -1;
        this.mTouchPointThreshold = getResources().getDimensionPixelSize(C1735R.dimen.ucrop_default_crop_rect_corner_touch_threshold);
        this.mCropRectMinSize = getResources().getDimensionPixelSize(C1735R.dimen.ucrop_default_crop_rect_min_size);
        this.mCropRectCornerTouchAreaLineLength = getResources().getDimensionPixelSize(C1735R.dimen.ucrop_default_crop_rect_corner_touch_area_line_length);
        init();
    }

    public OverlayViewChangeListener getOverlayViewChangeListener() {
        return this.mCallback;
    }

    public void setOverlayViewChangeListener(OverlayViewChangeListener overlayViewChangeListener) {
        this.mCallback = overlayViewChangeListener;
    }

    public RectF getCropViewRect() {
        return this.mCropViewRect;
    }

    public boolean isFreestyleCropEnabled() {
        return this.mIsFreestyleCropEnabled;
    }

    public void setFreestyleCropEnabled(boolean z) {
        this.mIsFreestyleCropEnabled = z;
    }

    public void setOvalDimmedLayer(boolean z) {
        this.mOvalDimmedLayer = z;
    }

    public void setCropGridRowCount(int i) {
        this.mCropGridRowCount = i;
        this.mGridPoints = null;
    }

    public void setCropGridColumnCount(int i) {
        this.mCropGridColumnCount = i;
        this.mGridPoints = null;
    }

    public void setShowCropFrame(boolean z) {
        this.mShowCropFrame = z;
    }

    public void setShowCropGrid(boolean z) {
        this.mShowCropGrid = z;
    }

    public void setDimmedColor(int i) {
        this.mDimmedColor = i;
    }

    public void setCropFrameStrokeWidth(int i) {
        this.mCropFramePaint.setStrokeWidth(i);
    }

    public void setCropGridStrokeWidth(int i) {
        this.mCropGridPaint.setStrokeWidth(i);
    }

    public void setCropFrameColor(int i) {
        this.mCropFramePaint.setColor(i);
    }

    public void setCropGridColor(int i) {
        this.mCropGridPaint.setColor(i);
    }

    public void setTargetAspectRatio(float f) {
        this.mTargetAspectRatio = f;
        setupCropBounds();
        postInvalidate();
    }

    public void setupCropBounds() {
        int i = (int) (this.mThisWidth / this.mTargetAspectRatio);
        if (i > this.mThisHeight) {
            int i2 = (this.mThisWidth - ((int) (this.mThisHeight * this.mTargetAspectRatio))) / 2;
            this.mCropViewRect.set(getPaddingLeft() + i2, getPaddingTop(), r0 + getPaddingLeft() + i2, getPaddingTop() + this.mThisHeight);
        } else {
            int i3 = (this.mThisHeight - i) / 2;
            this.mCropViewRect.set(getPaddingLeft(), getPaddingTop() + i3, getPaddingLeft() + this.mThisWidth, i + getPaddingTop() + i3);
        }
        if (this.mCallback != null) {
            this.mCallback.onCropRectUpdated(this.mCropViewRect);
        }
        updateGridPoints();
    }

    private void updateGridPoints() {
        this.mCropGridCorners = RectUtils.getCornersFromRect(this.mCropViewRect);
        this.mGridPoints = null;
        this.mCircularPath.reset();
        this.mCircularPath.addOval(this.mCropViewRect, Path.Direction.CW);
    }

    protected void init() {
        if (Build.VERSION.SDK_INT < 18 && Build.VERSION.SDK_INT >= 11) {
            setLayerType(1, null);
        }
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int width = getWidth() - getPaddingRight();
            int height = getHeight() - getPaddingBottom();
            this.mThisWidth = width - paddingLeft;
            this.mThisHeight = height - paddingTop;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawDimmedLayer(canvas);
        drawCropGrid(canvas);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.mCropViewRect.isEmpty() || !this.mIsFreestyleCropEnabled) {
            return false;
        }
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        if ((motionEvent.getAction() & 255) == 0) {
            this.mCurrentTouchCornerIndex = getCurrentTouchCorner(x, y);
            return this.mCurrentTouchCornerIndex != -1;
        }
        if ((motionEvent.getAction() & 255) == 2 && motionEvent.getPointerCount() == 1 && this.mCurrentTouchCornerIndex != -1) {
            resizeCropViewRect(Math.min(Math.max(x, getPaddingLeft()), getWidth() - getPaddingRight()), Math.min(Math.max(y, getPaddingTop()), getHeight() - getPaddingBottom()));
            return true;
        }
        if ((motionEvent.getAction() & 255) == 1) {
            this.mCurrentTouchCornerIndex = -1;
            if (this.mCallback != null) {
                this.mCallback.onCropRectUpdated(this.mCropViewRect);
            }
        }
        return false;
    }

    private void resizeCropViewRect(float f, float f2) {
        this.mTempRect.set(this.mCropViewRect);
        switch (this.mCurrentTouchCornerIndex) {
            case 0:
                this.mTempRect.set(f, f2, this.mCropViewRect.right, this.mCropViewRect.bottom);
                break;
            case 1:
                this.mTempRect.set(this.mCropViewRect.left, f2, f, this.mCropViewRect.bottom);
                break;
            case 2:
                this.mTempRect.set(this.mCropViewRect.left, this.mCropViewRect.top, f, f2);
                break;
            case 3:
                this.mTempRect.set(f, this.mCropViewRect.top, this.mCropViewRect.right, f2);
                break;
        }
        boolean z = this.mTempRect.height() >= ((float) this.mCropRectMinSize);
        boolean z2 = this.mTempRect.width() >= ((float) this.mCropRectMinSize);
        this.mCropViewRect.set(z2 ? this.mTempRect.left : this.mCropViewRect.left, z ? this.mTempRect.top : this.mCropViewRect.top, z2 ? this.mTempRect.right : this.mCropViewRect.right, z ? this.mTempRect.bottom : this.mCropViewRect.bottom);
        if (z || z2) {
            updateGridPoints();
            postInvalidate();
        }
    }

    private int getCurrentTouchCorner(float f, float f2) {
        int i;
        int i2 = -1;
        double d = this.mTouchPointThreshold;
        int i3 = 0;
        while (i3 < 8) {
            double dSqrt = Math.sqrt(Math.pow(f - this.mCropGridCorners[i3], 2.0d) + Math.pow(f2 - this.mCropGridCorners[i3 + 1], 2.0d));
            if (dSqrt < d) {
                i = i3 / 2;
            } else {
                dSqrt = d;
                i = i2;
            }
            i3 += 2;
            i2 = i;
            d = dSqrt;
        }
        return i2;
    }

    protected void drawDimmedLayer(Canvas canvas) {
        canvas.save();
        if (this.mOvalDimmedLayer) {
            canvas.clipPath(this.mCircularPath, Region.Op.DIFFERENCE);
        } else {
            canvas.clipRect(this.mCropViewRect, Region.Op.DIFFERENCE);
        }
        canvas.drawColor(this.mDimmedColor);
        canvas.restore();
        if (this.mOvalDimmedLayer) {
            canvas.drawOval(this.mCropViewRect, this.mDimmedStrokePaint);
        }
    }

    protected void drawCropGrid(Canvas canvas) {
        if (this.mShowCropGrid) {
            if (this.mGridPoints == null && !this.mCropViewRect.isEmpty()) {
                this.mGridPoints = new float[(this.mCropGridRowCount * 4) + (this.mCropGridColumnCount * 4)];
                int i = 0;
                for (int i2 = 0; i2 < this.mCropGridRowCount; i2++) {
                    int i3 = i + 1;
                    this.mGridPoints[i] = this.mCropViewRect.left;
                    int i4 = i3 + 1;
                    this.mGridPoints[i3] = (this.mCropViewRect.height() * ((i2 + 1.0f) / (this.mCropGridRowCount + 1))) + this.mCropViewRect.top;
                    int i5 = i4 + 1;
                    this.mGridPoints[i4] = this.mCropViewRect.right;
                    i = i5 + 1;
                    this.mGridPoints[i5] = (this.mCropViewRect.height() * ((i2 + 1.0f) / (this.mCropGridRowCount + 1))) + this.mCropViewRect.top;
                }
                for (int i6 = 0; i6 < this.mCropGridColumnCount; i6++) {
                    int i7 = i + 1;
                    this.mGridPoints[i] = (this.mCropViewRect.width() * ((i6 + 1.0f) / (this.mCropGridColumnCount + 1))) + this.mCropViewRect.left;
                    int i8 = i7 + 1;
                    this.mGridPoints[i7] = this.mCropViewRect.top;
                    int i9 = i8 + 1;
                    this.mGridPoints[i8] = (this.mCropViewRect.width() * ((i6 + 1.0f) / (this.mCropGridColumnCount + 1))) + this.mCropViewRect.left;
                    i = i9 + 1;
                    this.mGridPoints[i9] = this.mCropViewRect.bottom;
                }
            }
            if (this.mGridPoints != null) {
                canvas.drawLines(this.mGridPoints, this.mCropGridPaint);
            }
        }
        if (this.mShowCropFrame) {
            canvas.drawRect(this.mCropViewRect, this.mCropFramePaint);
        }
        if (this.mIsFreestyleCropEnabled) {
            canvas.save();
            this.mTempRect.set(this.mCropViewRect);
            this.mTempRect.inset(this.mCropRectCornerTouchAreaLineLength, -this.mCropRectCornerTouchAreaLineLength);
            canvas.clipRect(this.mTempRect, Region.Op.DIFFERENCE);
            this.mTempRect.set(this.mCropViewRect);
            this.mTempRect.inset(-this.mCropRectCornerTouchAreaLineLength, this.mCropRectCornerTouchAreaLineLength);
            canvas.clipRect(this.mTempRect, Region.Op.DIFFERENCE);
            canvas.drawRect(this.mCropViewRect, this.mCropFrameCornersPaint);
            canvas.restore();
        }
    }

    protected void processStyledAttributes(TypedArray typedArray) {
        this.mOvalDimmedLayer = typedArray.getBoolean(C1735R.styleable.ucrop_UCropView_ucrop_oval_dimmed_layer, false);
        this.mDimmedColor = typedArray.getColor(C1735R.styleable.ucrop_UCropView_ucrop_dimmed_color, getResources().getColor(C1735R.color.ucrop_color_default_dimmed));
        this.mDimmedStrokePaint.setColor(this.mDimmedColor);
        this.mDimmedStrokePaint.setStyle(Paint.Style.STROKE);
        this.mDimmedStrokePaint.setStrokeWidth(1.0f);
        initCropFrameStyle(typedArray);
        this.mShowCropFrame = typedArray.getBoolean(C1735R.styleable.ucrop_UCropView_ucrop_show_frame, true);
        initCropGridStyle(typedArray);
        this.mShowCropGrid = typedArray.getBoolean(C1735R.styleable.ucrop_UCropView_ucrop_show_grid, true);
    }

    private void initCropFrameStyle(TypedArray typedArray) {
        int dimensionPixelSize = typedArray.getDimensionPixelSize(C1735R.styleable.ucrop_UCropView_ucrop_frame_stroke_size, getResources().getDimensionPixelSize(C1735R.dimen.ucrop_default_crop_frame_stoke_width));
        int color = typedArray.getColor(C1735R.styleable.ucrop_UCropView_ucrop_frame_color, getResources().getColor(C1735R.color.ucrop_color_default_crop_frame));
        this.mCropFramePaint.setStrokeWidth(dimensionPixelSize);
        this.mCropFramePaint.setColor(color);
        this.mCropFramePaint.setStyle(Paint.Style.STROKE);
        this.mCropFrameCornersPaint.setStrokeWidth(dimensionPixelSize * 3);
        this.mCropFrameCornersPaint.setColor(color);
        this.mCropFrameCornersPaint.setStyle(Paint.Style.STROKE);
    }

    private void initCropGridStyle(TypedArray typedArray) {
        int dimensionPixelSize = typedArray.getDimensionPixelSize(C1735R.styleable.ucrop_UCropView_ucrop_grid_stroke_size, getResources().getDimensionPixelSize(C1735R.dimen.ucrop_default_crop_grid_stoke_width));
        int color = typedArray.getColor(C1735R.styleable.ucrop_UCropView_ucrop_grid_color, getResources().getColor(C1735R.color.ucrop_color_default_crop_grid));
        this.mCropGridPaint.setStrokeWidth(dimensionPixelSize);
        this.mCropGridPaint.setColor(color);
        this.mCropGridRowCount = typedArray.getInt(C1735R.styleable.ucrop_UCropView_ucrop_grid_row_count, 2);
        this.mCropGridColumnCount = typedArray.getInt(C1735R.styleable.ucrop_UCropView_ucrop_grid_column_count, 2);
    }
}
