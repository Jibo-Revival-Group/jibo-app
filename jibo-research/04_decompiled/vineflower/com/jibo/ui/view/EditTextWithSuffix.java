package com.jibo.ui.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint.Align;
import android.text.TextPaint;
import android.util.AttributeSet;
import com.jibo.R;
import com.jibo.ui.view.proxima.CustomFontEditText;

public class EditTextWithSuffix extends CustomFontEditText {
   TextPaint a = new TextPaint();
   private String b = "";
   private float c;

   public EditTextWithSuffix(Context var1) {
      super(var1);
   }

   public EditTextWithSuffix(Context var1, AttributeSet var2) {
      super(var1, var2);
      this.a(var1, var2, 0);
   }

   public EditTextWithSuffix(Context var1, AttributeSet var2, int var3) {
      super(var1, var2, var3);
      this.a(var1, var2, var3);
   }

   private void a(Context var1, AttributeSet var2, int var3) {
      TypedArray var4 = var1.obtainStyledAttributes(var2, R.styleable.EditTextWithSuffix, var3, 0);
      if (var4 != null) {
         this.b = var4.getString(0);
         if (this.b == null) {
            this.b = "";
         }

         this.c = var4.getDimension(1, 0.0F);
      }

      var4.recycle();
   }

   public void onDraw(Canvas var1) {
      super.onDraw(var1);
      int var3 = (int)this.getPaint().measureText(this.getText().toString());
      int var2 = this.getPaddingLeft();
      var1.drawText(this.b, Math.max(var3 + var2, this.c), this.getBaseline(), this.a);
   }

   protected void onFinishInflate() {
      super.onFinishInflate();
      this.a.setColor(this.getCurrentTextColor());
      this.a.setTextSize(this.getTextSize());
      this.a.setTextAlign(Align.LEFT);
   }
}
