package android.support.design.widget;

import android.content.Context;
import android.support.design.R;
import android.support.design.internal.SnackbarContentLayout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;

public final class Snackbar extends BaseTransientBottomBar<Snackbar> {
   private Snackbar(ViewGroup var1, View var2, BaseTransientBottomBar.ContentViewCallback var3) {
      super(var1, var2, var3);
   }

   public static Snackbar a(View var0, int var1, int var2) {
      return a(var0, var0.getResources().getText(var1), var2);
   }

   public static Snackbar a(View var0, CharSequence var1, int var2) {
      ViewGroup var4 = a(var0);
      if (var4 == null) {
         throw new IllegalArgumentException("No suitable parent found from the given view. Please provide a valid view.");
      }

      SnackbarContentLayout var3 = (SnackbarContentLayout)LayoutInflater.from(var4.getContext()).inflate(R.layout.design_layout_snackbar_include, var4, false);
      Snackbar var5 = new Snackbar(var4, var3, var3);
      var5.a(var1);
      var5.a(var2);
      return var5;
   }

   private static ViewGroup a(View var0) {
      ViewGroup var2 = null;
      View var3 = var0;

      View var1;
      do {
         if (var3 instanceof CoordinatorLayout) {
            var4 = (ViewGroup)var3;
            break;
         }

         var4 = var2;
         if (var3 instanceof FrameLayout) {
            if (var3.getId() == 16908290) {
               var4 = (ViewGroup)var3;
               break;
            }

            var4 = (ViewGroup)var3;
         }

         var1 = var3;
         if (var3 != null) {
            ViewParent var5 = var3.getParent();
            if (var5 instanceof View) {
               var1 = (View)var5;
            } else {
               var1 = null;
            }
         }

         var3 = var1;
         var2 = var4;
      } while (var1 != null);

      return var4;
   }

   public Snackbar a(int var1, OnClickListener var2) {
      return this.a(this.a().getText(var1), var2);
   }

   public Snackbar a(CharSequence var1) {
      ((SnackbarContentLayout)this.b.getChildAt(0)).getMessageView().setText(var1);
      return this;
   }

   public Snackbar a(CharSequence var1, OnClickListener var2) {
      Button var3 = ((SnackbarContentLayout)this.b.getChildAt(0)).getActionView();
      if (!TextUtils.isEmpty(var1) && var2 != null) {
         var3.setVisibility(0);
         var3.setText(var1);
         var3.setOnClickListener(new OnClickListener(this, var2) {
            final OnClickListener a;
            final Snackbar b;

            {
               this.b = var1;
               this.a = var2x;
            }

            public void onClick(View var1) {
               this.a.onClick(var1);
               this.b.b(1);
            }
         });
      } else {
         var3.setVisibility(8);
         var3.setOnClickListener(null);
      }

      return this;
   }

   public Snackbar e(int var1) {
      ((SnackbarContentLayout)this.b.getChildAt(0)).getActionView().setTextColor(var1);
      return this;
   }

   public static class Callback extends BaseTransientBottomBar.BaseCallback<Snackbar> {
      public void a(Snackbar var1) {
      }

      public void a(Snackbar var1, int var2) {
      }
   }

   public static final class SnackbarLayout extends BaseTransientBottomBar.SnackbarBaseLayout {
      public SnackbarLayout(Context var1) {
         super(var1);
      }

      public SnackbarLayout(Context var1, AttributeSet var2) {
         super(var1, var2);
      }

      protected void onMeasure(int var1, int var2) {
         super.onMeasure(var1, var2);
         int var4 = this.getChildCount();
         var2 = this.getMeasuredWidth();
         int var5 = this.getPaddingLeft();
         int var3 = this.getPaddingRight();

         for (int var7 = 0; var7 < var4; var7++) {
            View var6 = this.getChildAt(var7);
            if (var6.getLayoutParams().width == -1) {
               var6.measure(MeasureSpec.makeMeasureSpec(var2 - var5 - var3, 1073741824), MeasureSpec.makeMeasureSpec(var6.getMeasuredHeight(), 1073741824));
            }
         }
      }
   }
}
