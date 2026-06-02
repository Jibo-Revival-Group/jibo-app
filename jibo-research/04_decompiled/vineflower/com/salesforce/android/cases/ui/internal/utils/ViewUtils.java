package com.salesforce.android.cases.ui.internal.utils;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import com.salesforce.android.cases.R;

public class ViewUtils {
   @TargetApi(21)
   public static void a(Activity var0) {
      if (VERSION.SDK_INT >= 21) {
         TypedArray var2 = var0.getTheme().obtainStyledAttributes(new int[]{R.attr.salesforceToolbarBackgroundColor});
         int var1 = var2.getColor(0, ContextCompat.c(var0, R.color.salesforce_brand_primary));
         var2.recycle();
         var0.getWindow().setStatusBarColor(ColorUtils.a(var1, 0.2F));
      }
   }

   public static void a(Snackbar var0, int var1) {
      a(var0, 0, var1);
   }

   public static void a(Snackbar var0, int var1, int var2) {
      View var3 = var0.b();
      if (var1 != 0) {
         var3.setBackgroundColor(var1);
      }

      b(var0, var2);
   }

   public static void a(View var0) {
      var0.post(new Runnable((InputMethodManager)var0.getContext().getSystemService("input_method"), var0) {
         final InputMethodManager a;
         final View b;

         {
            this.a = var1;
            this.b = var2;
         }

         @Override
         public void run() {
            this.a.hideSoftInputFromWindow(this.b.getWindowToken(), 0);
         }
      });
   }

   public static void b(Snackbar var0, int var1) {
      TextView var2 = (TextView)var0.b().findViewById(android.support.design.R.id.snackbar_text);
      if (var2 != null) {
         var2.setTextColor(var1);
      }
   }

   public static void b(View var0) {
      if (var0.getAlpha() != 1.0F || var0.getVisibility() != 0) {
         var0.setVisibility(0);
         var0.setAlpha(0.0F);
         var0.animate().alpha(1.0F).start();
      }
   }

   public static void c(View var0) {
      if (var0.getAlpha() != 0.0F || 8 != var0.getVisibility()) {
         var0.animate().alpha(0.0F).withEndAction(new Runnable(var0) {
            final View a;

            {
               this.a = var1;
            }

            @Override
            public void run() {
               this.a.setVisibility(8);
            }
         });
      }
   }

   public static void d(View var0) {
      var0.post(new Runnable(var0) {
         final View a;

         {
            this.a = var1;
         }

         @Override
         public void run() {
            this.a.requestFocus();
         }
      });
   }
}
