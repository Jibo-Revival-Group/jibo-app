package com.crashlytics.android.core;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.ScrollView;
import android.widget.TextView;
import io.fabric.sdk.android.services.settings.PromptSettingsData;
import java.util.concurrent.CountDownLatch;

class CrashPromptDialog {
   private final CrashPromptDialog.OptInLatch a;
   private final Builder b;

   private CrashPromptDialog(Builder var1, CrashPromptDialog.OptInLatch var2) {
      this.a = var2;
      this.b = var1;
   }

   private static int a(float var0, int var1) {
      return (int)(var1 * var0);
   }

   private static ScrollView a(Activity var0, String var1) {
      float var2 = var0.getResources().getDisplayMetrics().density;
      int var3 = a(var2, 5);
      TextView var4 = new TextView(var0);
      var4.setAutoLinkMask(15);
      var4.setText(var1);
      var4.setTextAppearance(var0, 16973892);
      var4.setPadding(var3, var3, var3, var3);
      var4.setFocusable(false);
      ScrollView var5 = new ScrollView(var0);
      var5.setPadding(a(var2, 14), a(var2, 2), a(var2, 10), a(var2, 12));
      var5.addView(var4);
      return var5;
   }

   public static CrashPromptDialog a(Activity var0, PromptSettingsData var1, CrashPromptDialog.AlwaysSendCallback var2) {
      CrashPromptDialog.OptInLatch var3 = new CrashPromptDialog.OptInLatch();
      DialogStringResolver var4 = new DialogStringResolver(var0, var1);
      Builder var5 = new Builder(var0);
      ScrollView var6 = a(var0, var4.b());
      OnClickListener var7 = new OnClickListener(var3) {
         final CrashPromptDialog.OptInLatch a;

         {
            this.a = var1;
         }

         public void onClick(DialogInterface var1, int var2x) {
            this.a.a(true);
            var1.dismiss();
         }
      };
      var5.setView(var6).setTitle(var4.a()).setCancelable(false).setNeutralButton(var4.c(), var7);
      if (var1.d) {
         OnClickListener var8 = new OnClickListener(var3) {
            final CrashPromptDialog.OptInLatch a;

            {
               this.a = var1;
            }

            public void onClick(DialogInterface var1, int var2) {
               this.a.a(false);
               var1.dismiss();
            }
         };
         var5.setNegativeButton(var4.e(), var8);
      }

      if (var1.f) {
         OnClickListener var9 = new OnClickListener(var2, var3) {
            final CrashPromptDialog.AlwaysSendCallback a;
            final CrashPromptDialog.OptInLatch b;

            {
               this.a = var1;
               this.b = var2x;
            }

            public void onClick(DialogInterface var1, int var2) {
               this.a.a(true);
               this.b.a(true);
               var1.dismiss();
            }
         };
         var5.setPositiveButton(var4.d(), var9);
      }

      return new CrashPromptDialog(var5, var3);
   }

   public void a() {
      this.b.show();
   }

   public void b() {
      this.a.b();
   }

   public boolean c() {
      return this.a.a();
   }

   interface AlwaysSendCallback {
      void a(boolean var1);
   }

   private static class OptInLatch {
      private boolean a = false;
      private final CountDownLatch b = new CountDownLatch(1);

      private OptInLatch() {
      }

      void a(boolean var1) {
         this.a = var1;
         this.b.countDown();
      }

      boolean a() {
         return this.a;
      }

      void b() {
         try {
            this.b.await();
         } catch (InterruptedException var2) {
         }
      }
   }
}
