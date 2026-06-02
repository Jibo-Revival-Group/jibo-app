package com.yalantis.ucrop.util;

import android.view.MotionEvent;

public class RotationGestureDetector {
   private static final int INVALID_POINTER_INDEX = -1;
   private float fX;
   private float fY;
   private float mAngle;
   private boolean mIsFirstTouch;
   private RotationGestureDetector.OnRotationGestureListener mListener;
   private int mPointerIndex1;
   private int mPointerIndex2;
   private float sX;
   private float sY;

   public RotationGestureDetector(RotationGestureDetector.OnRotationGestureListener var1) {
      this.mListener = var1;
      this.mPointerIndex1 = -1;
      this.mPointerIndex2 = -1;
   }

   private float calculateAngleBetweenLines(float var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8) {
      return this.calculateAngleDelta(
         (float)Math.toDegrees((float)Math.atan2(var2 - var4, var1 - var3)), (float)Math.toDegrees((float)Math.atan2(var6 - var8, var5 - var7))
      );
   }

   private float calculateAngleDelta(float var1, float var2) {
      this.mAngle = var2 % 360.0F - var1 % 360.0F;
      if (this.mAngle < -180.0F) {
         this.mAngle += 360.0F;
      } else if (this.mAngle > 180.0F) {
         this.mAngle -= 360.0F;
      }

      return this.mAngle;
   }

   public float getAngle() {
      return this.mAngle;
   }

   public boolean onTouchEvent(MotionEvent var1) {
      switch (var1.getActionMasked()) {
         case 0:
            this.sX = var1.getX();
            this.sY = var1.getY();
            this.mPointerIndex1 = var1.findPointerIndex(var1.getPointerId(0));
            this.mAngle = 0.0F;
            this.mIsFirstTouch = true;
            break;
         case 1:
            this.mPointerIndex1 = -1;
            break;
         case 2:
            if (this.mPointerIndex1 != -1 && this.mPointerIndex2 != -1 && var1.getPointerCount() > this.mPointerIndex2) {
               float var2 = var1.getX(this.mPointerIndex1);
               float var4 = var1.getY(this.mPointerIndex1);
               float var5 = var1.getX(this.mPointerIndex2);
               float var3 = var1.getY(this.mPointerIndex2);
               if (this.mIsFirstTouch) {
                  this.mAngle = 0.0F;
                  this.mIsFirstTouch = false;
               } else {
                  this.calculateAngleBetweenLines(this.fX, this.fY, this.sX, this.sY, var5, var3, var2, var4);
               }

               if (this.mListener != null) {
                  this.mListener.onRotation(this);
               }

               this.fX = var5;
               this.fY = var3;
               this.sX = var2;
               this.sY = var4;
            }
         case 3:
         case 4:
         default:
            break;
         case 5:
            this.fX = var1.getX();
            this.fY = var1.getY();
            this.mPointerIndex2 = var1.findPointerIndex(var1.getPointerId(var1.getActionIndex()));
            this.mAngle = 0.0F;
            this.mIsFirstTouch = true;
            break;
         case 6:
            this.mPointerIndex2 = -1;
      }

      return true;
   }

   public interface OnRotationGestureListener {
      boolean onRotation(RotationGestureDetector var1);
   }

   public static class SimpleOnRotationGestureListener implements RotationGestureDetector.OnRotationGestureListener {
      @Override
      public boolean onRotation(RotationGestureDetector var1) {
         return false;
      }
   }
}
