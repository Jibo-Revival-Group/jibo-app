package android.support.customtabs;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v4.app.BundleCompat;
import android.support.v4.content.ContextCompat;
import java.util.ArrayList;

public final class CustomTabsIntent {
   public final Intent a;
   public final Bundle b;

   private CustomTabsIntent(Intent var1, Bundle var2) {
      this.a = var1;
      this.b = var2;
   }

   public void a(Context var1, Uri var2) {
      this.a.setData(var2);
      ContextCompat.a(var1, this.a, this.b);
   }

   public static final class Builder {
      private final Intent a;
      private ArrayList<Bundle> b;
      private Bundle c;
      private ArrayList<Bundle> d;
      private boolean e;

      public Builder() {
         this(null);
      }

      public Builder(CustomTabsSession var1) {
         Object var2 = null;
         super();
         this.a = new Intent("android.intent.action.VIEW");
         this.b = null;
         this.c = null;
         this.d = null;
         this.e = true;
         if (var1 != null) {
            this.a.setPackage(var1.b().getPackageName());
         }

         Bundle var3 = new Bundle();
         IBinder var4;
         if (var1 == null) {
            var4 = (IBinder)var2;
         } else {
            var4 = var1.a();
         }

         BundleCompat.a(var3, "android.support.customtabs.extra.SESSION", var4);
         this.a.putExtras(var3);
      }

      public CustomTabsIntent a() {
         if (this.b != null) {
            this.a.putParcelableArrayListExtra("android.support.customtabs.extra.MENU_ITEMS", this.b);
         }

         if (this.d != null) {
            this.a.putParcelableArrayListExtra("android.support.customtabs.extra.TOOLBAR_ITEMS", this.d);
         }

         this.a.putExtra("android.support.customtabs.extra.EXTRA_ENABLE_INSTANT_APPS", this.e);
         return new CustomTabsIntent(this.a, this.c);
      }
   }
}
