package android.support.v4.app;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Parcelable;
import java.util.ArrayList;

public final class ShareCompat {
   public static class IntentBuilder {
      private Activity a;
      private Intent b;
      private CharSequence c;
      private ArrayList<String> d;
      private ArrayList<String> e;
      private ArrayList<String> f;
      private ArrayList<Uri> g;

      private IntentBuilder(Activity var1) {
         this.a = var1;
         this.b = new Intent().setAction("android.intent.action.SEND");
         this.b.putExtra("android.support.v4.app.EXTRA_CALLING_PACKAGE", var1.getPackageName());
         this.b.putExtra("android.support.v4.app.EXTRA_CALLING_ACTIVITY", var1.getComponentName());
         this.b.addFlags(524288);
      }

      public static ShareCompat.IntentBuilder a(Activity var0) {
         return new ShareCompat.IntentBuilder(var0);
      }

      private void a(String var1, ArrayList<String> var2) {
         String[] var5 = this.b.getStringArrayExtra(var1);
         int var3;
         if (var5 != null) {
            var3 = var5.length;
         } else {
            var3 = 0;
         }

         String[] var4 = new String[var2.size() + var3];
         var2.toArray(var4);
         if (var5 != null) {
            System.arraycopy(var5, 0, var4, var2.size(), var3);
         }

         this.b.putExtra(var1, var4);
      }

      public Intent a() {
         if (this.d != null) {
            this.a("android.intent.extra.EMAIL", this.d);
            this.d = null;
         }

         if (this.e != null) {
            this.a("android.intent.extra.CC", this.e);
            this.e = null;
         }

         if (this.f != null) {
            this.a("android.intent.extra.BCC", this.f);
            this.f = null;
         }

         boolean var1;
         if (this.g != null && this.g.size() > 1) {
            var1 = true;
         } else {
            var1 = false;
         }

         boolean var2 = this.b.getAction().equals("android.intent.action.SEND_MULTIPLE");
         if (!var1 && var2) {
            this.b.setAction("android.intent.action.SEND");
            if (this.g != null && !this.g.isEmpty()) {
               this.b.putExtra("android.intent.extra.STREAM", (Parcelable)this.g.get(0));
            } else {
               this.b.removeExtra("android.intent.extra.STREAM");
            }

            this.g = null;
         }

         if (var1 && !var2) {
            this.b.setAction("android.intent.action.SEND_MULTIPLE");
            if (this.g != null && !this.g.isEmpty()) {
               this.b.putParcelableArrayListExtra("android.intent.extra.STREAM", this.g);
            } else {
               this.b.removeExtra("android.intent.extra.STREAM");
            }
         }

         return this.b;
      }

      public ShareCompat.IntentBuilder a(int var1) {
         return this.a(this.a.getText(var1));
      }

      public ShareCompat.IntentBuilder a(Uri var1) {
         if (!this.b.getAction().equals("android.intent.action.SEND")) {
            this.b.setAction("android.intent.action.SEND");
         }

         this.g = null;
         this.b.putExtra("android.intent.extra.STREAM", var1);
         return this;
      }

      public ShareCompat.IntentBuilder a(CharSequence var1) {
         this.c = var1;
         return this;
      }

      public ShareCompat.IntentBuilder a(String var1) {
         this.b.setType(var1);
         return this;
      }

      public Intent b() {
         return Intent.createChooser(this.a(), this.c);
      }

      public ShareCompat.IntentBuilder b(Uri var1) {
         Uri var2 = (Uri)this.b.getParcelableExtra("android.intent.extra.STREAM");
         ShareCompat.IntentBuilder var3;
         if (this.g == null && var2 == null) {
            var3 = this.a(var1);
         } else {
            if (this.g == null) {
               this.g = new ArrayList<>();
            }

            if (var2 != null) {
               this.b.removeExtra("android.intent.extra.STREAM");
               this.g.add(var2);
            }

            this.g.add(var1);
            var3 = this;
         }

         return var3;
      }
   }
}
