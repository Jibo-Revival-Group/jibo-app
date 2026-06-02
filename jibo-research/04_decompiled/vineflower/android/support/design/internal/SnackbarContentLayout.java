package android.support.design.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.design.R;
import android.support.design.widget.BaseTransientBottomBar;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SnackbarContentLayout extends LinearLayout implements BaseTransientBottomBar.ContentViewCallback {
   private TextView a;
   private Button b;
   private int c;
   private int d;

   public SnackbarContentLayout(Context var1) {
      this(var1, null);
   }

   public SnackbarContentLayout(Context var1, AttributeSet var2) {
      super(var1, var2);
      TypedArray var3 = var1.obtainStyledAttributes(var2, R.styleable.SnackbarLayout);
      this.c = var3.getDimensionPixelSize(R.styleable.SnackbarLayout_android_maxWidth, -1);
      this.d = var3.getDimensionPixelSize(R.styleable.SnackbarLayout_maxActionInlineWidth, -1);
      var3.recycle();
   }

   private static void a(View var0, int var1, int var2) {
      if (ViewCompat.t(var0)) {
         ViewCompat.b(var0, ViewCompat.g(var0), var1, ViewCompat.h(var0), var2);
      } else {
         var0.setPadding(var0.getPaddingLeft(), var1, var0.getPaddingRight(), var2);
      }
   }

   private boolean a(int var1, int var2, int var3) {
      boolean var4 = false;
      if (var1 != this.getOrientation()) {
         this.setOrientation(var1);
         var4 = true;
      }

      if (this.a.getPaddingTop() != var2 || this.a.getPaddingBottom() != var3) {
         a(this.a, var2, var3);
         var4 = true;
      }

      return var4;
   }

   @Override
   public void a(int var1, int var2) {
      this.a.setAlpha(0.0F);
      this.a.animate().alpha(1.0F).setDuration(var2).setStartDelay(var1).start();
      if (this.b.getVisibility() == 0) {
         this.b.setAlpha(0.0F);
         this.b.animate().alpha(1.0F).setDuration(var2).setStartDelay(var1).start();
      }
   }

   @Override
   public void b(int var1, int var2) {
      this.a.setAlpha(1.0F);
      this.a.animate().alpha(0.0F).setDuration(var2).setStartDelay(var1).start();
      if (this.b.getVisibility() == 0) {
         this.b.setAlpha(1.0F);
         this.b.animate().alpha(0.0F).setDuration(var2).setStartDelay(var1).start();
      }
   }

   public Button getActionView() {
      return this.b;
   }

   public TextView getMessageView() {
      return this.a;
   }

   protected void onFinishInflate() {
      super.onFinishInflate();
      this.a = (TextView)this.findViewById(R.id.snackbar_text);
      this.b = (Button)this.findViewById(R.id.snackbar_action);
   }

   protected void onMeasure(int var1, int var2) {
      super.onMeasure(var1, var2);
      int var3 = var1;
      if (this.c > 0) {
         var3 = var1;
         if (this.getMeasuredWidth() > this.c) {
            var3 = MeasureSpec.makeMeasureSpec(this.c, 1073741824);
            super.onMeasure(var3, var2);
         }
      }

      int var4 = this.getResources().getDimensionPixelSize(R.dimen.design_snackbar_padding_vertical_2lines);
      int var5 = this.getResources().getDimensionPixelSize(R.dimen.design_snackbar_padding_vertical);
      boolean var6;
      if (this.a.getLayout().getLineCount() > 1) {
         var6 = 1;
      } else {
         var6 = 0;
      }

      label46: {
         if (var6 && this.d > 0 && this.b.getMeasuredWidth() > this.d) {
            if (this.a(1, var4, var4 - var5)) {
               var6 = (boolean)1;
               break label46;
            }
         } else {
            if (var6) {
               var6 = var4;
            } else {
               var6 = var5;
            }

            if (this.a(0, var6, var6)) {
               var6 = (boolean)1;
               break label46;
            }
         }

         var6 = (boolean)0;
      }

      if (var6) {
         super.onMeasure(var3, var2);
      }
   }
}
