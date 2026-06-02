package com.yalantis.ucrop.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Paint.Style;
import android.graphics.Path.Direction;
import android.graphics.Region.Op;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.yalantis.ucrop.R;
import com.yalantis.ucrop.callback.OverlayViewChangeListener;
import com.yalantis.ucrop.util.RectUtils;

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
   private final RectF mCropViewRect = new RectF();
   private int mCurrentTouchCornerIndex;
   private int mDimmedColor;
   private Paint mDimmedStrokePaint;
   private float[] mGridPoints;
   private boolean mIsFreestyleCropEnabled;
   private boolean mOvalDimmedLayer;
   private boolean mShowCropFrame;
   private boolean mShowCropGrid;
   private float mTargetAspectRatio;
   private final RectF mTempRect = new RectF();
   protected int mThisHeight;
   protected int mThisWidth;
   private int mTouchPointThreshold;

   public OverlayView(Context var1) {
      this(var1, null);
   }

   public OverlayView(Context var1, AttributeSet var2) {
      this(var1, var2, 0);
   }

   public OverlayView(Context var1, AttributeSet var2, int var3) {
      super(var1, var2, var3);
      this.mGridPoints = null;
      this.mCircularPath = new Path();
      this.mDimmedStrokePaint = new Paint(1);
      this.mCropGridPaint = new Paint(1);
      this.mCropFramePaint = new Paint(1);
      this.mCropFrameCornersPaint = new Paint(1);
      this.mIsFreestyleCropEnabled = false;
      this.mCurrentTouchCornerIndex = -1;
      this.mTouchPointThreshold = this.getResources().getDimensionPixelSize(R.dimen.ucrop_default_crop_rect_corner_touch_threshold);
      this.mCropRectMinSize = this.getResources().getDimensionPixelSize(R.dimen.ucrop_default_crop_rect_min_size);
      this.mCropRectCornerTouchAreaLineLength = this.getResources().getDimensionPixelSize(R.dimen.ucrop_default_crop_rect_corner_touch_area_line_length);
      this.init();
   }

   private int getCurrentTouchCorner(float var1, float var2) {
      int var7 = -1;
      double var3 = this.mTouchPointThreshold;

      for (byte var8 = 0; var8 < 8; var8 += 2) {
         double var5 = Math.sqrt(Math.pow(var1 - this.mCropGridCorners[var8], 2.0) + Math.pow(var2 - this.mCropGridCorners[var8 + 1], 2.0));
         if (var5 < var3) {
            var7 = var8 / 2;
            var3 = var5;
         }
      }

      return var7;
   }

   private void initCropFrameStyle(TypedArray var1) {
      int var3 = var1.getDimensionPixelSize(
         R.styleable.ucrop_UCropView_ucrop_frame_stroke_size, this.getResources().getDimensionPixelSize(R.dimen.ucrop_default_crop_frame_stoke_width)
      );
      int var2 = var1.getColor(R.styleable.ucrop_UCropView_ucrop_frame_color, this.getResources().getColor(R.color.ucrop_color_default_crop_frame));
      this.mCropFramePaint.setStrokeWidth(var3);
      this.mCropFramePaint.setColor(var2);
      this.mCropFramePaint.setStyle(Style.STROKE);
      this.mCropFrameCornersPaint.setStrokeWidth(var3 * 3);
      this.mCropFrameCornersPaint.setColor(var2);
      this.mCropFrameCornersPaint.setStyle(Style.STROKE);
   }

   private void initCropGridStyle(TypedArray var1) {
      int var2 = var1.getDimensionPixelSize(
         R.styleable.ucrop_UCropView_ucrop_grid_stroke_size, this.getResources().getDimensionPixelSize(R.dimen.ucrop_default_crop_grid_stoke_width)
      );
      int var3 = var1.getColor(R.styleable.ucrop_UCropView_ucrop_grid_color, this.getResources().getColor(R.color.ucrop_color_default_crop_grid));
      this.mCropGridPaint.setStrokeWidth(var2);
      this.mCropGridPaint.setColor(var3);
      this.mCropGridRowCount = var1.getInt(R.styleable.ucrop_UCropView_ucrop_grid_row_count, 2);
      this.mCropGridColumnCount = var1.getInt(R.styleable.ucrop_UCropView_ucrop_grid_column_count, 2);
   }

   private void resizeCropViewRect(float var1, float var2) {
      boolean var6 = true;
      this.mTempRect.set(this.mCropViewRect);
      switch (this.mCurrentTouchCornerIndex) {
         case 0:
            this.mTempRect.set(var1, var2, this.mCropViewRect.right, this.mCropViewRect.bottom);
            break;
         case 1:
            this.mTempRect.set(this.mCropViewRect.left, var2, var1, this.mCropViewRect.bottom);
            break;
         case 2:
            this.mTempRect.set(this.mCropViewRect.left, this.mCropViewRect.top, var1, var2);
            break;
         case 3:
            this.mTempRect.set(var1, this.mCropViewRect.top, this.mCropViewRect.right, var2);
      }

      boolean var5;
      if (this.mTempRect.height() >= this.mCropRectMinSize) {
         var5 = true;
      } else {
         var5 = false;
      }

      if (!(this.mTempRect.width() >= this.mCropRectMinSize)) {
         var6 = false;
      }

      RectF var7 = this.mCropViewRect;
      if (var6) {
         var1 = this.mTempRect.left;
      } else {
         var1 = this.mCropViewRect.left;
      }

      if (var5) {
         var2 = this.mTempRect.top;
      } else {
         var2 = this.mCropViewRect.top;
      }

      float var3;
      if (var6) {
         var3 = this.mTempRect.right;
      } else {
         var3 = this.mCropViewRect.right;
      }

      float var4;
      if (var5) {
         var4 = this.mTempRect.bottom;
      } else {
         var4 = this.mCropViewRect.bottom;
      }

      var7.set(var1, var2, var3, var4);
      if (var5 || var6) {
         this.updateGridPoints();
         this.postInvalidate();
      }
   }

   private void updateGridPoints() {
      this.mCropGridCorners = RectUtils.getCornersFromRect(this.mCropViewRect);
      this.mGridPoints = null;
      this.mCircularPath.reset();
      this.mCircularPath.addOval(this.mCropViewRect, Direction.CW);
   }

   protected void drawCropGrid(Canvas var1) {
      byte var6 = 0;
      if (this.mShowCropGrid) {
         if (this.mGridPoints == null && !this.mCropViewRect.isEmpty()) {
            this.mGridPoints = new float[this.mCropGridRowCount * 4 + this.mCropGridColumnCount * 4];
            int var4 = 0;
            int var2 = 0;

            while (true) {
               int var3 = var6;
               int var5 = var2;
               if (var4 >= this.mCropGridRowCount) {
                  while (var3 < this.mCropGridColumnCount) {
                     float[] var17 = this.mGridPoints;
                     var4 = var5 + 1;
                     var17[var5] = this.mCropViewRect.width() * ((var3 + 1.0F) / (this.mCropGridColumnCount + 1)) + this.mCropViewRect.left;
                     var17 = this.mGridPoints;
                     var2 = var4 + 1;
                     var17[var4] = this.mCropViewRect.top;
                     var17 = this.mGridPoints;
                     var4 = var2 + 1;
                     var17[var2] = this.mCropViewRect.width() * ((var3 + 1.0F) / (this.mCropGridColumnCount + 1)) + this.mCropViewRect.left;
                     var17 = this.mGridPoints;
                     var5 = var4 + 1;
                     var17[var4] = this.mCropViewRect.bottom;
                     var3++;
                  }
                  break;
               }

               float[] var7 = this.mGridPoints;
               var3 = var2 + 1;
               var7[var2] = this.mCropViewRect.left;
               var7 = this.mGridPoints;
               var2 = var3 + 1;
               var7[var3] = this.mCropViewRect.height() * ((var4 + 1.0F) / (this.mCropGridRowCount + 1)) + this.mCropViewRect.top;
               var7 = this.mGridPoints;
               var3 = var2 + 1;
               var7[var2] = this.mCropViewRect.right;
               var7 = this.mGridPoints;
               var2 = var3 + 1;
               var7[var3] = this.mCropViewRect.height() * ((var4 + 1.0F) / (this.mCropGridRowCount + 1)) + this.mCropViewRect.top;
               var4++;
            }
         }

         if (this.mGridPoints != null) {
            var1.drawLines(this.mGridPoints, this.mCropGridPaint);
         }
      }

      if (this.mShowCropFrame) {
         var1.drawRect(this.mCropViewRect, this.mCropFramePaint);
      }

      if (this.mIsFreestyleCropEnabled) {
         var1.save();
         this.mTempRect.set(this.mCropViewRect);
         this.mTempRect.inset(this.mCropRectCornerTouchAreaLineLength, -this.mCropRectCornerTouchAreaLineLength);
         var1.clipRect(this.mTempRect, Op.DIFFERENCE);
         this.mTempRect.set(this.mCropViewRect);
         this.mTempRect.inset(-this.mCropRectCornerTouchAreaLineLength, this.mCropRectCornerTouchAreaLineLength);
         var1.clipRect(this.mTempRect, Op.DIFFERENCE);
         var1.drawRect(this.mCropViewRect, this.mCropFrameCornersPaint);
         var1.restore();
      }
   }

   protected void drawDimmedLayer(Canvas var1) {
      var1.save();
      if (this.mOvalDimmedLayer) {
         var1.clipPath(this.mCircularPath, Op.DIFFERENCE);
      } else {
         var1.clipRect(this.mCropViewRect, Op.DIFFERENCE);
      }

      var1.drawColor(this.mDimmedColor);
      var1.restore();
      if (this.mOvalDimmedLayer) {
         var1.drawOval(this.mCropViewRect, this.mDimmedStrokePaint);
      }
   }

   public RectF getCropViewRect() {
      return this.mCropViewRect;
   }

   public OverlayViewChangeListener getOverlayViewChangeListener() {
      return this.mCallback;
   }

   protected void init() {
      if (VERSION.SDK_INT < 18 && VERSION.SDK_INT >= 11) {
         this.setLayerType(1, null);
      }
   }

   public boolean isFreestyleCropEnabled() {
      return this.mIsFreestyleCropEnabled;
   }

   protected void onDraw(Canvas var1) {
      super.onDraw(var1);
      this.drawDimmedLayer(var1);
      this.drawCropGrid(var1);
   }

   protected void onLayout(boolean var1, int var2, int var3, int var4, int var5) {
      super.onLayout(var1, var2, var3, var4, var5);
      if (var1) {
         var2 = this.getPaddingLeft();
         var4 = this.getPaddingTop();
         int var6 = this.getWidth();
         var5 = this.getPaddingRight();
         int var7 = this.getHeight();
         var3 = this.getPaddingBottom();
         this.mThisWidth = var6 - var5 - var2;
         this.mThisHeight = var7 - var3 - var4;
      }
   }

   public boolean onTouchEvent(MotionEvent var1) {
      boolean var4 = true;
      if (!this.mCropViewRect.isEmpty() && this.mIsFreestyleCropEnabled) {
         float var2 = var1.getX();
         float var3 = var1.getY();
         if ((var1.getAction() & 0xFF) == 0) {
            this.mCurrentTouchCornerIndex = this.getCurrentTouchCorner(var2, var3);
            if (this.mCurrentTouchCornerIndex == -1) {
               var4 = false;
            }
         } else if ((var1.getAction() & 0xFF) == 2 && var1.getPointerCount() == 1 && this.mCurrentTouchCornerIndex != -1) {
            this.resizeCropViewRect(
               Math.min(Math.max(var2, this.getPaddingLeft()), this.getWidth() - this.getPaddingRight()),
               Math.min(Math.max(var3, this.getPaddingTop()), this.getHeight() - this.getPaddingBottom())
            );
         } else {
            if ((var1.getAction() & 0xFF) == 1) {
               this.mCurrentTouchCornerIndex = -1;
               if (this.mCallback != null) {
                  this.mCallback.onCropRectUpdated(this.mCropViewRect);
               }
            }

            var4 = false;
         }
      } else {
         var4 = false;
      }

      return var4;
   }

   protected void processStyledAttributes(TypedArray var1) {
      this.mOvalDimmedLayer = var1.getBoolean(R.styleable.ucrop_UCropView_ucrop_oval_dimmed_layer, false);
      this.mDimmedColor = var1.getColor(R.styleable.ucrop_UCropView_ucrop_dimmed_color, this.getResources().getColor(R.color.ucrop_color_default_dimmed));
      this.mDimmedStrokePaint.setColor(this.mDimmedColor);
      this.mDimmedStrokePaint.setStyle(Style.STROKE);
      this.mDimmedStrokePaint.setStrokeWidth(1.0F);
      this.initCropFrameStyle(var1);
      this.mShowCropFrame = var1.getBoolean(R.styleable.ucrop_UCropView_ucrop_show_frame, true);
      this.initCropGridStyle(var1);
      this.mShowCropGrid = var1.getBoolean(R.styleable.ucrop_UCropView_ucrop_show_grid, true);
   }

   public void setCropFrameColor(int var1) {
      this.mCropFramePaint.setColor(var1);
   }

   public void setCropFrameStrokeWidth(int var1) {
      this.mCropFramePaint.setStrokeWidth(var1);
   }

   public void setCropGridColor(int var1) {
      this.mCropGridPaint.setColor(var1);
   }

   public void setCropGridColumnCount(int var1) {
      this.mCropGridColumnCount = var1;
      this.mGridPoints = null;
   }

   public void setCropGridRowCount(int var1) {
      this.mCropGridRowCount = var1;
      this.mGridPoints = null;
   }

   public void setCropGridStrokeWidth(int var1) {
      this.mCropGridPaint.setStrokeWidth(var1);
   }

   public void setDimmedColor(int var1) {
      this.mDimmedColor = var1;
   }

   public void setFreestyleCropEnabled(boolean var1) {
      this.mIsFreestyleCropEnabled = var1;
   }

   public void setOvalDimmedLayer(boolean var1) {
      this.mOvalDimmedLayer = var1;
   }

   public void setOverlayViewChangeListener(OverlayViewChangeListener var1) {
      this.mCallback = var1;
   }

   public void setShowCropFrame(boolean var1) {
      this.mShowCropFrame = var1;
   }

   public void setShowCropGrid(boolean var1) {
      this.mShowCropGrid = var1;
   }

   public void setTargetAspectRatio(float var1) {
      this.mTargetAspectRatio = var1;
      this.setupCropBounds();
      this.postInvalidate();
   }

   public void setupCropBounds() {
      int var1 = (int)(this.mThisWidth / this.mTargetAspectRatio);
      if (var1 > this.mThisHeight) {
         var1 = (int)(this.mThisHeight * this.mTargetAspectRatio);
         int var2 = (this.mThisWidth - var1) / 2;
         this.mCropViewRect
            .set(this.getPaddingLeft() + var2, this.getPaddingTop(), var1 + this.getPaddingLeft() + var2, this.getPaddingTop() + this.mThisHeight);
      } else {
         int var4 = (this.mThisHeight - var1) / 2;
         this.mCropViewRect
            .set(this.getPaddingLeft(), this.getPaddingTop() + var4, this.getPaddingLeft() + this.mThisWidth, var1 + this.getPaddingTop() + var4);
      }

      if (this.mCallback != null) {
         this.mCallback.onCropRectUpdated(this.mCropViewRect);
      }

      this.updateGridPoints();
   }
}
