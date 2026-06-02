package com.yalantis.ucrop.view.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Paint.Style;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.TextView;
import com.yalantis.ucrop.R;
import com.yalantis.ucrop.model.AspectRatio;
import java.util.Locale;

public class AspectRatioTextView extends TextView {
   private float mAspectRatio;
   private String mAspectRatioTitle;
   private float mAspectRatioX;
   private float mAspectRatioY;
   private final Rect mCanvasClipBounds = new Rect();
   private Paint mDotPaint;
   private int mDotSize;

   public AspectRatioTextView(Context var1) {
      this(var1, null);
   }

   public AspectRatioTextView(Context var1, AttributeSet var2) {
      this(var1, var2, 0);
   }

   public AspectRatioTextView(Context var1, AttributeSet var2, int var3) {
      super(var1, var2, var3);
      this.init(var1.obtainStyledAttributes(var2, R.styleable.ucrop_AspectRatioTextView));
   }

   @TargetApi(21)
   public AspectRatioTextView(Context var1, AttributeSet var2, int var3, int var4) {
      super(var1, var2, var3, var4);
      this.init(var1.obtainStyledAttributes(var2, R.styleable.ucrop_AspectRatioTextView));
   }

   private void applyActiveColor(int var1) {
      if (this.mDotPaint != null) {
         this.mDotPaint.setColor(var1);
      }

      int var2 = ContextCompat.c(this.getContext(), R.color.ucrop_color_widget);
      this.setTextColor(new ColorStateList(new int[][]{{16842913}, {0}}, new int[]{var1, var2}));
   }

   private void init(TypedArray var1) {
      this.setGravity(1);
      this.mAspectRatioTitle = var1.getString(R.styleable.ucrop_AspectRatioTextView_ucrop_artv_ratio_title);
      this.mAspectRatioX = var1.getFloat(R.styleable.ucrop_AspectRatioTextView_ucrop_artv_ratio_x, 0.0F);
      this.mAspectRatioY = var1.getFloat(R.styleable.ucrop_AspectRatioTextView_ucrop_artv_ratio_y, 0.0F);
      if (this.mAspectRatioX != 0.0F && this.mAspectRatioY != 0.0F) {
         this.mAspectRatio = this.mAspectRatioX / this.mAspectRatioY;
      } else {
         this.mAspectRatio = 0.0F;
      }

      this.mDotSize = this.getContext().getResources().getDimensionPixelSize(R.dimen.ucrop_size_dot_scale_text_view);
      this.mDotPaint = new Paint(1);
      this.mDotPaint.setStyle(Style.FILL);
      this.setTitle();
      this.applyActiveColor(this.getResources().getColor(R.color.ucrop_color_widget_active));
      var1.recycle();
   }

   private void setTitle() {
      if (!TextUtils.isEmpty(this.mAspectRatioTitle)) {
         this.setText(this.mAspectRatioTitle);
      } else {
         this.setText(String.format(Locale.US, "%d:%d", (int)this.mAspectRatioX, (int)this.mAspectRatioY));
      }
   }

   private void toggleAspectRatio() {
      if (this.mAspectRatio != 0.0F) {
         float var1 = this.mAspectRatioX;
         this.mAspectRatioX = this.mAspectRatioY;
         this.mAspectRatioY = var1;
         this.mAspectRatio = this.mAspectRatioX / this.mAspectRatioY;
      }
   }

   public float getAspectRatio(boolean var1) {
      if (var1) {
         this.toggleAspectRatio();
         this.setTitle();
      }

      return this.mAspectRatio;
   }

   protected void onDraw(Canvas var1) {
      super.onDraw(var1);
      if (this.isSelected()) {
         var1.getClipBounds(this.mCanvasClipBounds);
         var1.drawCircle(
            (this.mCanvasClipBounds.right - this.mCanvasClipBounds.left) / 2.0F,
            this.mCanvasClipBounds.bottom - this.mDotSize,
            this.mDotSize / 2,
            this.mDotPaint
         );
      }
   }

   public void setActiveColor(int var1) {
      this.applyActiveColor(var1);
      this.invalidate();
   }

   public void setAspectRatio(AspectRatio var1) {
      this.mAspectRatioTitle = var1.getAspectRatioTitle();
      this.mAspectRatioX = var1.getAspectRatioX();
      this.mAspectRatioY = var1.getAspectRatioY();
      if (this.mAspectRatioX != 0.0F && this.mAspectRatioY != 0.0F) {
         this.mAspectRatio = this.mAspectRatioX / this.mAspectRatioY;
      } else {
         this.mAspectRatio = 0.0F;
      }

      this.setTitle();
   }
}
