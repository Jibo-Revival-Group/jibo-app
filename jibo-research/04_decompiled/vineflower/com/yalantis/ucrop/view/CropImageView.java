package com.yalantis.ucrop.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.yalantis.ucrop.R;
import com.yalantis.ucrop.callback.BitmapCropCallback;
import com.yalantis.ucrop.callback.CropBoundsChangeListener;
import com.yalantis.ucrop.model.CropParameters;
import com.yalantis.ucrop.model.ImageState;
import com.yalantis.ucrop.task.BitmapCropTask;
import com.yalantis.ucrop.util.CubicEasing;
import com.yalantis.ucrop.util.RectUtils;
import java.lang.ref.WeakReference;
import java.util.Arrays;

public class CropImageView extends TransformImageView {
   public static final float DEFAULT_ASPECT_RATIO = 0.0F;
   public static final int DEFAULT_IMAGE_TO_CROP_BOUNDS_ANIM_DURATION = 500;
   public static final int DEFAULT_MAX_BITMAP_SIZE = 0;
   public static final float DEFAULT_MAX_SCALE_MULTIPLIER = 10.0F;
   public static final float SOURCE_IMAGE_ASPECT_RATIO = 0.0F;
   private CropBoundsChangeListener mCropBoundsChangeListener;
   private final RectF mCropRect = new RectF();
   private long mImageToWrapCropBoundsAnimDuration;
   private int mMaxResultImageSizeX;
   private int mMaxResultImageSizeY;
   private float mMaxScale;
   private float mMaxScaleMultiplier;
   private float mMinScale;
   private float mTargetAspectRatio;
   private final Matrix mTempMatrix = new Matrix();
   private Runnable mWrapCropBoundsRunnable;
   private Runnable mZoomImageToPositionRunnable;

   public CropImageView(Context var1) {
      this(var1, null);
   }

   public CropImageView(Context var1, AttributeSet var2) {
      this(var1, var2, 0);
   }

   public CropImageView(Context var1, AttributeSet var2, int var3) {
      super(var1, var2, var3);
      this.mMaxScaleMultiplier = 10.0F;
      this.mZoomImageToPositionRunnable = null;
      this.mMaxResultImageSizeX = 0;
      this.mMaxResultImageSizeY = 0;
      this.mImageToWrapCropBoundsAnimDuration = 500L;
   }

   private float[] calculateImageIndents() {
      float var3 = 0.0F;
      this.mTempMatrix.reset();
      this.mTempMatrix.setRotate(-this.getCurrentAngle());
      float[] var7 = Arrays.copyOf(this.mCurrentImageCorners, this.mCurrentImageCorners.length);
      float[] var6 = RectUtils.getCornersFromRect(this.mCropRect);
      this.mTempMatrix.mapPoints(var7);
      this.mTempMatrix.mapPoints(var6);
      RectF var13 = RectUtils.trapToRect(var7);
      RectF var11 = RectUtils.trapToRect(var6);
      float var1 = var13.left - var11.left;
      float var5 = var13.top - var11.top;
      float var4 = var13.right - var11.right;
      float var2 = var13.bottom - var11.bottom;
      var6 = new float[4];
      if (!(var1 > 0.0F)) {
         var1 = 0.0F;
      }

      var6[0] = var1;
      if (var5 > 0.0F) {
         var1 = var5;
      } else {
         var1 = 0.0F;
      }

      var6[1] = var1;
      if (var4 < 0.0F) {
         var1 = var4;
      } else {
         var1 = 0.0F;
      }

      var6[2] = var1;
      var1 = var3;
      if (var2 < 0.0F) {
         var1 = var2;
      }

      var6[3] = var1;
      this.mTempMatrix.reset();
      this.mTempMatrix.setRotate(this.getCurrentAngle());
      this.mTempMatrix.mapPoints(var6);
      return var6;
   }

   private void calculateImageScaleBounds() {
      Drawable var1 = this.getDrawable();
      if (var1 != null) {
         this.calculateImageScaleBounds(var1.getIntrinsicWidth(), var1.getIntrinsicHeight());
      }
   }

   private void calculateImageScaleBounds(float var1, float var2) {
      this.mMinScale = Math.max(this.mCropRect.width() / var1, this.mCropRect.height() / var2);
      this.mMaxScale = this.mMinScale * this.mMaxScaleMultiplier;
   }

   private void setupInitialImagePosition(float var1, float var2) {
      float var4 = this.mCropRect.width();
      float var3 = this.mCropRect.height();
      var1 = (var4 - this.mMinScale * var1) / 2.0F;
      var4 = this.mCropRect.left;
      var2 = (var3 - this.mMinScale * var2) / 2.0F;
      var3 = this.mCropRect.top;
      this.mCurrentImageMatrix.reset();
      this.mCurrentImageMatrix.postScale(this.mMinScale, this.mMinScale);
      this.mCurrentImageMatrix.postTranslate(var1 + var4, var2 + var3);
      this.setImageMatrix(this.mCurrentImageMatrix);
   }

   public void cancelAllAnimations() {
      this.removeCallbacks(this.mWrapCropBoundsRunnable);
      this.removeCallbacks(this.mZoomImageToPositionRunnable);
   }

   public void cropAndSaveImage(CompressFormat var1, int var2, BitmapCropCallback var3) {
      this.cancelAllAnimations();
      this.setImageToWrapCropBounds(false);
      ImageState var4 = new ImageState(this.mCropRect, RectUtils.trapToRect(this.mCurrentImageCorners), this.getCurrentScale(), this.getCurrentAngle());
      CropParameters var5 = new CropParameters(
         this.mMaxResultImageSizeX, this.mMaxResultImageSizeY, var1, var2, this.getImageInputPath(), this.getImageOutputPath(), this.getExifInfo()
      );
      new BitmapCropTask(this.getViewBitmap(), var4, var5, var3).execute(new Void[0]);
   }

   public CropBoundsChangeListener getCropBoundsChangeListener() {
      return this.mCropBoundsChangeListener;
   }

   public float getMaxScale() {
      return this.mMaxScale;
   }

   public float getMinScale() {
      return this.mMinScale;
   }

   public float getTargetAspectRatio() {
      return this.mTargetAspectRatio;
   }

   protected boolean isImageWrapCropBounds() {
      return this.isImageWrapCropBounds(this.mCurrentImageCorners);
   }

   protected boolean isImageWrapCropBounds(float[] var1) {
      this.mTempMatrix.reset();
      this.mTempMatrix.setRotate(-this.getCurrentAngle());
      float[] var2 = Arrays.copyOf(var1, var1.length);
      this.mTempMatrix.mapPoints(var2);
      var1 = RectUtils.getCornersFromRect(this.mCropRect);
      this.mTempMatrix.mapPoints(var1);
      return RectUtils.trapToRect(var2).contains(RectUtils.trapToRect(var1));
   }

   @Override
   protected void onImageLaidOut() {
      super.onImageLaidOut();
      Drawable var5 = this.getDrawable();
      if (var5 != null) {
         float var1 = var5.getIntrinsicWidth();
         float var2 = var5.getIntrinsicHeight();
         if (this.mTargetAspectRatio == 0.0F) {
            this.mTargetAspectRatio = var1 / var2;
         }

         int var3 = (int)(this.mThisWidth / this.mTargetAspectRatio);
         if (var3 > this.mThisHeight) {
            var3 = (int)(this.mThisHeight * this.mTargetAspectRatio);
            int var4 = (this.mThisWidth - var3) / 2;
            this.mCropRect.set(var4, 0.0F, var3 + var4, this.mThisHeight);
         } else {
            int var7 = (this.mThisHeight - var3) / 2;
            this.mCropRect.set(0.0F, var7, this.mThisWidth, var3 + var7);
         }

         this.calculateImageScaleBounds(var1, var2);
         this.setupInitialImagePosition(var1, var2);
         if (this.mCropBoundsChangeListener != null) {
            this.mCropBoundsChangeListener.onCropAspectRatioChanged(this.mTargetAspectRatio);
         }

         if (this.mTransformImageListener != null) {
            this.mTransformImageListener.onScale(this.getCurrentScale());
            this.mTransformImageListener.onRotate(this.getCurrentAngle());
         }
      }
   }

   public void postRotate(float var1) {
      this.postRotate(var1, this.mCropRect.centerX(), this.mCropRect.centerY());
   }

   @Override
   public void postScale(float var1, float var2, float var3) {
      if (var1 > 1.0F && this.getCurrentScale() * var1 <= this.getMaxScale()) {
         super.postScale(var1, var2, var3);
      } else if (var1 < 1.0F && this.getCurrentScale() * var1 >= this.getMinScale()) {
         super.postScale(var1, var2, var3);
      }
   }

   protected void processStyledAttributes(TypedArray var1) {
      float var2 = Math.abs(var1.getFloat(R.styleable.ucrop_UCropView_ucrop_aspect_ratio_x, 0.0F));
      float var3 = Math.abs(var1.getFloat(R.styleable.ucrop_UCropView_ucrop_aspect_ratio_y, 0.0F));
      if (var2 != 0.0F && var3 != 0.0F) {
         this.mTargetAspectRatio = var2 / var3;
      } else {
         this.mTargetAspectRatio = 0.0F;
      }
   }

   public void setCropBoundsChangeListener(CropBoundsChangeListener var1) {
      this.mCropBoundsChangeListener = var1;
   }

   public void setCropRect(RectF var1) {
      this.mCropRect
         .set(var1.left - this.getPaddingLeft(), var1.top - this.getPaddingTop(), var1.right - this.getPaddingRight(), var1.bottom - this.getPaddingBottom());
      this.calculateImageScaleBounds();
      this.setImageToWrapCropBounds();
   }

   public void setImageToWrapCropBounds() {
      this.setImageToWrapCropBounds(true);
   }

   public void setImageToWrapCropBounds(boolean var1) {
      if (this.mBitmapLaidOut && !this.isImageWrapCropBounds()) {
         float var5 = this.mCurrentImageCenter[0];
         float var6 = this.mCurrentImageCenter[1];
         float var7 = this.getCurrentScale();
         float var4 = this.mCropRect.centerX() - var5;
         float var2 = this.mCropRect.centerY() - var6;
         float var3 = 0.0F;
         this.mTempMatrix.reset();
         this.mTempMatrix.setTranslate(var4, var2);
         float[] var9 = Arrays.copyOf(this.mCurrentImageCorners, this.mCurrentImageCorners.length);
         this.mTempMatrix.mapPoints(var9);
         boolean var8 = this.isImageWrapCropBounds(var9);
         if (var8) {
            var9 = this.calculateImageIndents();
            var4 = -(var9[0] + var9[2]);
            var2 = var9[1];
            var2 = -(var9[3] + var2);
         } else {
            RectF var13 = new RectF(this.mCropRect);
            this.mTempMatrix.reset();
            this.mTempMatrix.setRotate(this.getCurrentAngle());
            this.mTempMatrix.mapRect(var13);
            float[] var10 = RectUtils.getRectSidesFromCorners(this.mCurrentImageCorners);
            var3 = Math.max(var13.width() / var10[0], var13.height() / var10[1]) * var7 - var7;
         }

         if (var1) {
            CropImageView.WrapCropBoundsRunnable var14 = new CropImageView.WrapCropBoundsRunnable(
               this, this.mImageToWrapCropBoundsAnimDuration, var5, var6, var4, var2, var7, var3, var8
            );
            this.mWrapCropBoundsRunnable = var14;
            this.post(var14);
         } else {
            this.postTranslate(var4, var2);
            if (!var8) {
               this.zoomInImage(var7 + var3, this.mCropRect.centerX(), this.mCropRect.centerY());
            }
         }
      }
   }

   public void setImageToWrapCropBoundsAnimDuration(long var1) {
      if (var1 > 0L) {
         this.mImageToWrapCropBoundsAnimDuration = var1;
      } else {
         throw new IllegalArgumentException("Animation duration cannot be negative value.");
      }
   }

   public void setMaxResultImageSizeX(int var1) {
      this.mMaxResultImageSizeX = var1;
   }

   public void setMaxResultImageSizeY(int var1) {
      this.mMaxResultImageSizeY = var1;
   }

   public void setMaxScaleMultiplier(float var1) {
      this.mMaxScaleMultiplier = var1;
   }

   public void setTargetAspectRatio(float var1) {
      Drawable var2 = this.getDrawable();
      if (var2 == null) {
         this.mTargetAspectRatio = var1;
      } else {
         if (var1 == 0.0F) {
            this.mTargetAspectRatio = (float)var2.getIntrinsicWidth() / var2.getIntrinsicHeight();
         } else {
            this.mTargetAspectRatio = var1;
         }

         if (this.mCropBoundsChangeListener != null) {
            this.mCropBoundsChangeListener.onCropAspectRatioChanged(this.mTargetAspectRatio);
         }
      }
   }

   protected void zoomImageToPosition(float var1, float var2, float var3, long var4) {
      float var6 = var1;
      if (var1 > this.getMaxScale()) {
         var6 = this.getMaxScale();
      }

      var1 = this.getCurrentScale();
      CropImageView.ZoomImageToPosition var7 = new CropImageView.ZoomImageToPosition(this, var4, var1, var6 - var1, var2, var3);
      this.mZoomImageToPositionRunnable = var7;
      this.post(var7);
   }

   public void zoomInImage(float var1) {
      this.zoomInImage(var1, this.mCropRect.centerX(), this.mCropRect.centerY());
   }

   public void zoomInImage(float var1, float var2, float var3) {
      if (var1 <= this.getMaxScale()) {
         this.postScale(var1 / this.getCurrentScale(), var2, var3);
      }
   }

   public void zoomOutImage(float var1) {
      this.zoomOutImage(var1, this.mCropRect.centerX(), this.mCropRect.centerY());
   }

   public void zoomOutImage(float var1, float var2, float var3) {
      if (var1 >= this.getMinScale()) {
         this.postScale(var1 / this.getCurrentScale(), var2, var3);
      }
   }

   private static class WrapCropBoundsRunnable implements Runnable {
      private final float mCenterDiffX;
      private final float mCenterDiffY;
      private final WeakReference<CropImageView> mCropImageView;
      private final float mDeltaScale;
      private final long mDurationMs;
      private final float mOldScale;
      private final float mOldX;
      private final float mOldY;
      private final long mStartTime;
      private final boolean mWillBeImageInBoundsAfterTranslate;

      public WrapCropBoundsRunnable(CropImageView var1, long var2, float var4, float var5, float var6, float var7, float var8, float var9, boolean var10) {
         this.mCropImageView = new WeakReference<>(var1);
         this.mDurationMs = var2;
         this.mStartTime = System.currentTimeMillis();
         this.mOldX = var4;
         this.mOldY = var5;
         this.mCenterDiffX = var6;
         this.mCenterDiffY = var7;
         this.mOldScale = var8;
         this.mDeltaScale = var9;
         this.mWillBeImageInBoundsAfterTranslate = var10;
      }

      @Override
      public void run() {
         CropImageView var7 = this.mCropImageView.get();
         if (var7 != null) {
            long var5 = System.currentTimeMillis();
            float var4 = (float)Math.min(this.mDurationMs, var5 - this.mStartTime);
            float var1 = CubicEasing.easeOut(var4, 0.0F, this.mCenterDiffX, (float)this.mDurationMs);
            float var2 = CubicEasing.easeOut(var4, 0.0F, this.mCenterDiffY, (float)this.mDurationMs);
            float var3 = CubicEasing.easeInOut(var4, 0.0F, this.mDeltaScale, (float)this.mDurationMs);
            if (var4 < (float)this.mDurationMs) {
               var7.postTranslate(var1 - (var7.mCurrentImageCenter[0] - this.mOldX), var2 - (var7.mCurrentImageCenter[1] - this.mOldY));
               if (!this.mWillBeImageInBoundsAfterTranslate) {
                  var7.zoomInImage(this.mOldScale + var3, var7.mCropRect.centerX(), var7.mCropRect.centerY());
               }

               if (!var7.isImageWrapCropBounds()) {
                  var7.post(this);
               }
            }
         }
      }
   }

   private static class ZoomImageToPosition implements Runnable {
      private final WeakReference<CropImageView> mCropImageView;
      private final float mDeltaScale;
      private final float mDestX;
      private final float mDestY;
      private final long mDurationMs;
      private final float mOldScale;
      private final long mStartTime;

      public ZoomImageToPosition(CropImageView var1, long var2, float var4, float var5, float var6, float var7) {
         this.mCropImageView = new WeakReference<>(var1);
         this.mStartTime = System.currentTimeMillis();
         this.mDurationMs = var2;
         this.mOldScale = var4;
         this.mDeltaScale = var5;
         this.mDestX = var6;
         this.mDestY = var7;
      }

      @Override
      public void run() {
         CropImageView var5 = this.mCropImageView.get();
         if (var5 != null) {
            long var3 = System.currentTimeMillis();
            float var2 = (float)Math.min(this.mDurationMs, var3 - this.mStartTime);
            float var1 = CubicEasing.easeInOut(var2, 0.0F, this.mDeltaScale, (float)this.mDurationMs);
            if (var2 < (float)this.mDurationMs) {
               var5.zoomInImage(this.mOldScale + var1, this.mDestX, this.mDestY);
               var5.post(this);
            } else {
               var5.setImageToWrapCropBounds();
            }
         }
      }
   }
}
