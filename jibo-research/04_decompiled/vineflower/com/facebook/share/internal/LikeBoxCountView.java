package com.facebook.share.internal;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Paint.Style;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.FrameLayout.LayoutParams;
import com.facebook.R;

public class LikeBoxCountView extends FrameLayout {
   private int additionalTextPadding;
   private Paint borderPaint;
   private float borderRadius;
   private float caretHeight;
   private LikeBoxCountView.LikeBoxCountViewCaretPosition caretPosition = LikeBoxCountView.LikeBoxCountViewCaretPosition.LEFT;
   private float caretWidth;
   private TextView likeCountLabel;
   private int textPadding;

   public LikeBoxCountView(Context var1) {
      super(var1);
      this.initialize(var1);
   }

   private void drawBorder(Canvas var1, float var2, float var3, float var4, float var5) {
      Path var7 = new Path();
      float var6 = this.borderRadius * 2.0F;
      var7.addArc(new RectF(var2, var3, var2 + var6, var3 + var6), -180.0F, 90.0F);
      if (this.caretPosition == LikeBoxCountView.LikeBoxCountViewCaretPosition.TOP) {
         var7.lineTo((var4 - var2 - this.caretWidth) / 2.0F + var2, var3);
         var7.lineTo((var4 - var2) / 2.0F + var2, var3 - this.caretHeight);
         var7.lineTo((var4 - var2 + this.caretWidth) / 2.0F + var2, var3);
      }

      var7.lineTo(var4 - this.borderRadius, var3);
      var7.addArc(new RectF(var4 - var6, var3, var4, var3 + var6), -90.0F, 90.0F);
      if (this.caretPosition == LikeBoxCountView.LikeBoxCountViewCaretPosition.RIGHT) {
         var7.lineTo(var4, (var5 - var3 - this.caretWidth) / 2.0F + var3);
         var7.lineTo(this.caretHeight + var4, (var5 - var3) / 2.0F + var3);
         var7.lineTo(var4, (var5 - var3 + this.caretWidth) / 2.0F + var3);
      }

      var7.lineTo(var4, var5 - this.borderRadius);
      var7.addArc(new RectF(var4 - var6, var5 - var6, var4, var5), 0.0F, 90.0F);
      if (this.caretPosition == LikeBoxCountView.LikeBoxCountViewCaretPosition.BOTTOM) {
         var7.lineTo((var4 - var2 + this.caretWidth) / 2.0F + var2, var5);
         var7.lineTo((var4 - var2) / 2.0F + var2, this.caretHeight + var5);
         var7.lineTo((var4 - var2 - this.caretWidth) / 2.0F + var2, var5);
      }

      var7.lineTo(this.borderRadius + var2, var5);
      var7.addArc(new RectF(var2, var5 - var6, var6 + var2, var5), 90.0F, 90.0F);
      if (this.caretPosition == LikeBoxCountView.LikeBoxCountViewCaretPosition.LEFT) {
         var7.lineTo(var2, (var5 - var3 + this.caretWidth) / 2.0F + var3);
         var7.lineTo(var2 - this.caretHeight, (var5 - var3) / 2.0F + var3);
         var7.lineTo(var2, (var5 - var3 - this.caretWidth) / 2.0F + var3);
      }

      var7.lineTo(var2, this.borderRadius + var3);
      var1.drawPath(var7, this.borderPaint);
   }

   private void initialize(Context var1) {
      this.setWillNotDraw(false);
      this.caretHeight = this.getResources().getDimension(R.dimen.com_facebook_likeboxcountview_caret_height);
      this.caretWidth = this.getResources().getDimension(R.dimen.com_facebook_likeboxcountview_caret_width);
      this.borderRadius = this.getResources().getDimension(R.dimen.com_facebook_likeboxcountview_border_radius);
      this.borderPaint = new Paint();
      this.borderPaint.setColor(this.getResources().getColor(R.color.com_facebook_likeboxcountview_border_color));
      this.borderPaint.setStrokeWidth(this.getResources().getDimension(R.dimen.com_facebook_likeboxcountview_border_width));
      this.borderPaint.setStyle(Style.STROKE);
      this.initializeLikeCountLabel(var1);
      this.addView(this.likeCountLabel);
      this.setCaretPosition(this.caretPosition);
   }

   private void initializeLikeCountLabel(Context var1) {
      this.likeCountLabel = new TextView(var1);
      LayoutParams var2 = new LayoutParams(-1, -1);
      this.likeCountLabel.setLayoutParams(var2);
      this.likeCountLabel.setGravity(17);
      this.likeCountLabel.setTextSize(0, this.getResources().getDimension(R.dimen.com_facebook_likeboxcountview_text_size));
      this.likeCountLabel.setTextColor(this.getResources().getColor(R.color.com_facebook_likeboxcountview_text_color));
      this.textPadding = this.getResources().getDimensionPixelSize(R.dimen.com_facebook_likeboxcountview_text_padding);
      this.additionalTextPadding = this.getResources().getDimensionPixelSize(R.dimen.com_facebook_likeboxcountview_caret_height);
   }

   private void setAdditionalTextPadding(int var1, int var2, int var3, int var4) {
      this.likeCountLabel.setPadding(this.textPadding + var1, this.textPadding + var2, this.textPadding + var3, this.textPadding + var4);
   }

   protected void onDraw(Canvas var1) {
      super.onDraw(var1);
      int var5 = this.getPaddingTop();
      int var4 = this.getPaddingLeft();
      int var3 = this.getWidth() - this.getPaddingRight();
      int var2 = this.getHeight() - this.getPaddingBottom();
      switch (<unrepresentable>.$SwitchMap$com$facebook$share$internal$LikeBoxCountView$LikeBoxCountViewCaretPosition[this.caretPosition.ordinal()]) {
         case 1:
            var4 = (int)(var4 + this.caretHeight);
            break;
         case 2:
            var5 = (int)(var5 + this.caretHeight);
            break;
         case 3:
            var3 = (int)(var3 - this.caretHeight);
            break;
         case 4:
            var2 = (int)(var2 - this.caretHeight);
      }

      this.drawBorder(var1, var4, var5, var3, var2);
   }

   public void setCaretPosition(LikeBoxCountView.LikeBoxCountViewCaretPosition var1) {
      this.caretPosition = var1;
      switch (<unrepresentable>.$SwitchMap$com$facebook$share$internal$LikeBoxCountView$LikeBoxCountViewCaretPosition[var1.ordinal()]) {
         case 1:
            this.setAdditionalTextPadding(this.additionalTextPadding, 0, 0, 0);
            break;
         case 2:
            this.setAdditionalTextPadding(0, this.additionalTextPadding, 0, 0);
            break;
         case 3:
            this.setAdditionalTextPadding(0, 0, this.additionalTextPadding, 0);
            break;
         case 4:
            this.setAdditionalTextPadding(0, 0, 0, this.additionalTextPadding);
      }
   }

   public void setText(String var1) {
      this.likeCountLabel.setText(var1);
   }

   public enum LikeBoxCountViewCaretPosition {
      BOTTOM,
      LEFT,
      RIGHT,
      TOP;

      private static final LikeBoxCountView.LikeBoxCountViewCaretPosition[] $VALUES = new LikeBoxCountView.LikeBoxCountViewCaretPosition[]{
         LikeBoxCountView.LikeBoxCountViewCaretPosition.LEFT,
         LikeBoxCountView.LikeBoxCountViewCaretPosition.TOP,
         LikeBoxCountView.LikeBoxCountViewCaretPosition.RIGHT,
         LikeBoxCountView.LikeBoxCountViewCaretPosition.BOTTOM
      };
   }
}
