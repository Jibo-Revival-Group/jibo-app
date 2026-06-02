package com.yalantis.ucrop.view.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Paint.Style;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.yalantis.ucrop.R;

public class HorizontalProgressWheelView extends View {
   private final Rect mCanvasClipBounds = new Rect();
   private float mLastTouchedPosition;
   private int mMiddleLineColor;
   private int mProgressLineHeight;
   private int mProgressLineMargin;
   private Paint mProgressLinePaint;
   private int mProgressLineWidth;
   private boolean mScrollStarted;
   private HorizontalProgressWheelView.ScrollingListener mScrollingListener;
   private float mTotalScrollDistance;

   public HorizontalProgressWheelView(Context var1) {
      this(var1, null);
   }

   public HorizontalProgressWheelView(Context var1, AttributeSet var2) {
      this(var1, var2, 0);
   }

   public HorizontalProgressWheelView(Context var1, AttributeSet var2, int var3) {
      super(var1, var2, var3);
      this.init();
   }

   @TargetApi(21)
   public HorizontalProgressWheelView(Context var1, AttributeSet var2, int var3, int var4) {
      super(var1, var2, var3, var4);
   }

   private void init() {
      this.mMiddleLineColor = ContextCompat.c(this.getContext(), R.color.ucrop_color_progress_wheel_line);
      this.mProgressLineWidth = this.getContext().getResources().getDimensionPixelSize(R.dimen.ucrop_width_horizontal_wheel_progress_line);
      this.mProgressLineHeight = this.getContext().getResources().getDimensionPixelSize(R.dimen.ucrop_height_horizontal_wheel_progress_line);
      this.mProgressLineMargin = this.getContext().getResources().getDimensionPixelSize(R.dimen.ucrop_margin_horizontal_wheel_progress_line);
      this.mProgressLinePaint = new Paint(1);
      this.mProgressLinePaint.setStyle(Style.STROKE);
      this.mProgressLinePaint.setStrokeWidth(this.mProgressLineWidth);
   }

   private void onScrollEvent(MotionEvent var1, float var2) {
      this.mTotalScrollDistance -= var2;
      this.postInvalidate();
      this.mLastTouchedPosition = var1.getX();
      if (this.mScrollingListener != null) {
         this.mScrollingListener.onScroll(-var2, this.mTotalScrollDistance);
      }
   }

   protected void onDraw(Canvas var1) {
      super.onDraw(var1);
      var1.getClipBounds(this.mCanvasClipBounds);
      int var13 = this.mCanvasClipBounds.width() / (this.mProgressLineWidth + this.mProgressLineMargin);
      float var9 = this.mTotalScrollDistance % (this.mProgressLineMargin + this.mProgressLineWidth);
      this.mProgressLinePaint.setColor(this.getResources().getColor(R.color.ucrop_color_progress_wheel_line));

      for (int var12 = 0; var12 < var13; var12++) {
         if (var12 < var13 / 4) {
            this.mProgressLinePaint.setAlpha((int)((float)var12 / (var13 / 4) * 255.0F));
         } else if (var12 > var13 * 3 / 4) {
            this.mProgressLinePaint.setAlpha((int)((float)(var13 - var12) / (var13 / 4) * 255.0F));
         } else {
            this.mProgressLinePaint.setAlpha(255);
         }

         float var3 = -var9;
         float var6 = this.mCanvasClipBounds.left;
         float var4 = (this.mProgressLineWidth + this.mProgressLineMargin) * var12;
         float var2 = this.mCanvasClipBounds.centerY();
         float var5 = this.mProgressLineHeight / 4.0F;
         float var10 = -var9;
         float var7 = this.mCanvasClipBounds.left;
         float var11 = (this.mProgressLineWidth + this.mProgressLineMargin) * var12;
         float var8 = this.mCanvasClipBounds.centerY();
         var1.drawLine(var4 + (var3 + var6), var2 - var5, var11 + (var10 + var7), this.mProgressLineHeight / 4.0F + var8, this.mProgressLinePaint);
      }

      this.mProgressLinePaint.setColor(this.mMiddleLineColor);
      float var16 = this.mCanvasClipBounds.centerX();
      float var14 = this.mCanvasClipBounds.centerY();
      float var17 = this.mProgressLineHeight / 2.0F;
      float var15 = this.mCanvasClipBounds.centerX();
      float var18 = this.mCanvasClipBounds.centerY();
      var1.drawLine(var16, var14 - var17, var15, this.mProgressLineHeight / 2.0F + var18, this.mProgressLinePaint);
   }

   public boolean onTouchEvent(MotionEvent var1) {
      switch (var1.getAction()) {
         case 0:
            this.mLastTouchedPosition = var1.getX();
            break;
         case 1:
            if (this.mScrollingListener != null) {
               this.mScrollStarted = false;
               this.mScrollingListener.onScrollEnd();
            }
            break;
         case 2:
            float var2 = var1.getX() - this.mLastTouchedPosition;
            if (var2 != 0.0F) {
               if (!this.mScrollStarted) {
                  this.mScrollStarted = true;
                  if (this.mScrollingListener != null) {
                     this.mScrollingListener.onScrollStart();
                  }
               }

               this.onScrollEvent(var1, var2);
            }
      }

      return true;
   }

   public void setMiddleLineColor(int var1) {
      this.mMiddleLineColor = var1;
      this.invalidate();
   }

   public void setScrollingListener(HorizontalProgressWheelView.ScrollingListener var1) {
      this.mScrollingListener = var1;
   }

   public interface ScrollingListener {
      void onScroll(float var1, float var2);

      void onScrollEnd();

      void onScrollStart();
   }
}
