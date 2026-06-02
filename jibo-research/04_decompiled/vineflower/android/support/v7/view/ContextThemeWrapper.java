package android.support.v7.view;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.os.Build.VERSION;
import android.support.v7.appcompat.R;
import android.view.LayoutInflater;

public class ContextThemeWrapper extends ContextWrapper {
   private int a;
   private Theme b;
   private LayoutInflater c;
   private Configuration d;
   private Resources e;

   public ContextThemeWrapper() {
      super(null);
   }

   public ContextThemeWrapper(Context var1, int var2) {
      super(var1);
      this.a = var2;
   }

   public ContextThemeWrapper(Context var1, Theme var2) {
      super(var1);
      this.b = var2;
   }

   private Resources b() {
      if (this.e == null) {
         if (this.d == null) {
            this.e = super.getResources();
         } else if (VERSION.SDK_INT >= 17) {
            this.e = this.createConfigurationContext(this.d).getResources();
         }
      }

      return this.e;
   }

   private void c() {
      boolean var1;
      if (this.b == null) {
         var1 = true;
      } else {
         var1 = false;
      }

      if (var1) {
         this.b = this.getResources().newTheme();
         Theme var2 = this.getBaseContext().getTheme();
         if (var2 != null) {
            this.b.setTo(var2);
         }
      }

      this.a(this.b, this.a, var1);
   }

   public int a() {
      return this.a;
   }

   protected void a(Theme var1, int var2, boolean var3) {
      var1.applyStyle(var2, true);
   }

   protected void attachBaseContext(Context var1) {
      super.attachBaseContext(var1);
   }

   public AssetManager getAssets() {
      return this.getResources().getAssets();
   }

   public Resources getResources() {
      return this.b();
   }

   public Object getSystemService(String var1) {
      Object var2;
      if ("layout_inflater".equals(var1)) {
         if (this.c == null) {
            this.c = LayoutInflater.from(this.getBaseContext()).cloneInContext(this);
         }

         var2 = this.c;
      } else {
         var2 = this.getBaseContext().getSystemService(var1);
      }

      return var2;
   }

   public Theme getTheme() {
      Theme var1;
      if (this.b != null) {
         var1 = this.b;
      } else {
         if (this.a == 0) {
            this.a = R.style.Theme_AppCompat_Light;
         }

         this.c();
         var1 = this.b;
      }

      return var1;
   }

   public void setTheme(int var1) {
      if (this.a != var1) {
         this.a = var1;
         this.c();
      }
   }
}
