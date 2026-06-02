package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.util.AttributeSet;
import android.widget.Button;
import com.google.android.gms.R;

public final class zzby extends Button {
   public zzby(Context var1) {
      this(var1, null);
   }

   private zzby(Context var1, AttributeSet var2) {
      super(var1, null, 16842824);
   }

   private static int a(int var0, int var1, int var2, int var3) {
      switch (var0) {
         case 0:
            break;
         case 1:
            var1 = var2;
            break;
         case 2:
            var1 = var3;
            break;
         default:
            throw new IllegalStateException(new StringBuilder(33).append("Unknown color scheme: ").append(var0).toString());
      }

      return var1;
   }

   public final void a(Resources var1, int var2, int var3) {
      this.setTypeface(Typeface.DEFAULT_BOLD);
      this.setTextSize(14.0F);
      float var4 = var1.getDisplayMetrics().density;
      this.setMinHeight((int)(var4 * 48.0F + 0.5F));
      this.setMinWidth((int)(var4 * 48.0F + 0.5F));
      int var6 = a(
         var3, R.drawable.common_google_signin_btn_icon_dark, R.drawable.common_google_signin_btn_icon_light, R.drawable.common_google_signin_btn_icon_light
      );
      int var5 = a(
         var3, R.drawable.common_google_signin_btn_text_dark, R.drawable.common_google_signin_btn_text_light, R.drawable.common_google_signin_btn_text_light
      );
      switch (var2) {
         case 2:
            var5 = var6;
         case 0:
         case 1:
            Drawable var7 = DrawableCompat.g(var1.getDrawable(var5));
            DrawableCompat.a(var7, var1.getColorStateList(R.color.common_google_signin_btn_tint));
            DrawableCompat.a(var7, Mode.SRC_ATOP);
            this.setBackgroundDrawable(var7);
            this.setTextColor(
               zzbq.a(
                  var1.getColorStateList(
                     a(
                        var3,
                        R.color.common_google_signin_btn_text_dark,
                        R.color.common_google_signin_btn_text_light,
                        R.color.common_google_signin_btn_text_light
                     )
                  )
               )
            );
            switch (var2) {
               case 0:
                  this.setText(var1.getString(R.string.common_signin_button_text));
                  break;
               case 1:
                  this.setText(var1.getString(R.string.common_signin_button_text_long));
                  break;
               case 2:
                  this.setText(null);
                  break;
               default:
                  throw new IllegalStateException(new StringBuilder(32).append("Unknown button size: ").append(var2).toString());
            }

            this.setTransformationMethod(null);
            if (com.google.android.gms.common.util.zzi.a(this.getContext())) {
               this.setGravity(19);
            }

            return;
         default:
            throw new IllegalStateException(new StringBuilder(32).append("Unknown button size: ").append(var2).toString());
      }
   }
}
