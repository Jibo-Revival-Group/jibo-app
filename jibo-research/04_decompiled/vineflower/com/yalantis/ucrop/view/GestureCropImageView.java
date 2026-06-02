package com.yalantis.ucrop.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.ScaleGestureDetector.SimpleOnScaleGestureListener;
import com.yalantis.ucrop.util.RotationGestureDetector;

public class GestureCropImageView extends CropImageView {
   private static final int DOUBLE_TAP_ZOOM_DURATION = 200;
   private int mDoubleTapScaleSteps;
   private GestureDetector mGestureDetector;
   private boolean mIsRotateEnabled = true;
   private boolean mIsScaleEnabled = true;
   private float mMidPntX;
   private float mMidPntY;
   private RotationGestureDetector mRotateDetector;
   private ScaleGestureDetector mScaleDetector;

   public GestureCropImageView(Context var1) {
      super(var1);
      this.mDoubleTapScaleSteps = 5;
   }

   public GestureCropImageView(Context var1, AttributeSet var2) {
      this(var1, var2, 0);
   }

   public GestureCropImageView(Context var1, AttributeSet var2, int var3) {
      super(var1, var2, var3);
      this.mDoubleTapScaleSteps = 5;
   }

   private void setupGestureListeners() {
      this.mGestureDetector = new GestureDetector(this.getContext(), new GestureCropImageView.GestureListener(this), null, true);
      this.mScaleDetector = new ScaleGestureDetector(this.getContext(), new GestureCropImageView.ScaleListener(this));
      this.mRotateDetector = new RotationGestureDetector(new GestureCropImageView.RotateListener(this));
   }

   public int getDoubleTapScaleSteps() {
      return this.mDoubleTapScaleSteps;
   }

   protected float getDoubleTapTargetScale() {
      return this.getCurrentScale() * (float)Math.pow(this.getMaxScale() / this.getMinScale(), 1.0F / this.mDoubleTapScaleSteps);
   }

   @Override
   protected void init() {
      super.init();
      this.setupGestureListeners();
   }

   public boolean isRotateEnabled() {
      return this.mIsRotateEnabled;
   }

   public boolean isScaleEnabled() {
      return this.mIsScaleEnabled;
   }

   public boolean onTouchEvent(MotionEvent var1) {
      if ((var1.getAction() & 0xFF) == 0) {
         this.cancelAllAnimations();
      }

      if (var1.getPointerCount() > 1) {
         this.mMidPntX = (var1.getX(0) + var1.getX(1)) / 2.0F;
         this.mMidPntY = (var1.getY(0) + var1.getY(1)) / 2.0F;
      }

      this.mGestureDetector.onTouchEvent(var1);
      if (this.mIsScaleEnabled) {
         this.mScaleDetector.onTouchEvent(var1);
      }

      if (this.mIsRotateEnabled) {
         this.mRotateDetector.onTouchEvent(var1);
      }

      if ((var1.getAction() & 0xFF) == 1) {
         this.setImageToWrapCropBounds();
      }

      return true;
   }

   public void setDoubleTapScaleSteps(int var1) {
      this.mDoubleTapScaleSteps = var1;
   }

   public void setRotateEnabled(boolean var1) {
      this.mIsRotateEnabled = var1;
   }

   public void setScaleEnabled(boolean var1) {
      this.mIsScaleEnabled = var1;
   }

   private class GestureListener extends SimpleOnGestureListener {
      final GestureCropImageView this$0;

      private GestureListener(GestureCropImageView var1) {
         this.this$0 = var1;
      }

      public boolean onDoubleTap(MotionEvent var1) {
         this.this$0.zoomImageToPosition(this.this$0.getDoubleTapTargetScale(), var1.getX(), var1.getY(), 200L);
         return super.onDoubleTap(var1);
      }

      public boolean onScroll(MotionEvent var1, MotionEvent var2, float var3, float var4) {
         this.this$0.postTranslate(-var3, -var4);
         return true;
      }
   }

   private class RotateListener extends RotationGestureDetector.SimpleOnRotationGestureListener {
      final GestureCropImageView this$0;

      private RotateListener(GestureCropImageView var1) {
         this.this$0 = var1;
      }

      @Override
      public boolean onRotation(RotationGestureDetector var1) {
         this.this$0.postRotate(var1.getAngle(), this.this$0.mMidPntX, this.this$0.mMidPntY);
         return true;
      }
   }

   private class ScaleListener extends SimpleOnScaleGestureListener {
      final GestureCropImageView this$0;

      private ScaleListener(GestureCropImageView var1) {
         this.this$0 = var1;
      }

      public boolean onScale(ScaleGestureDetector var1) {
         this.this$0.postScale(var1.getScaleFactor(), this.this$0.mMidPntX, this.this$0.mMidPntY);
         return true;
      }
   }
}
