package android.support.v4.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Build.VERSION;
import android.widget.RemoteViews;
import java.util.ArrayList;

public class NotificationCompat {
   public static Bundle a(Notification var0) {
      Bundle var1;
      if (VERSION.SDK_INT >= 19) {
         var1 = var0.extras;
      } else if (VERSION.SDK_INT >= 16) {
         var1 = NotificationCompatJellybean.a(var0);
      } else {
         var1 = null;
      }

      return var1;
   }

   public static class Action {
      final Bundle a;
      public int b;
      public CharSequence c;
      public PendingIntent d;
      private final RemoteInput[] e;
      private final RemoteInput[] f;
      private boolean g;

      public int a() {
         return this.b;
      }

      public CharSequence b() {
         return this.c;
      }

      public PendingIntent c() {
         return this.d;
      }

      public Bundle d() {
         return this.a;
      }

      public boolean e() {
         return this.g;
      }

      public RemoteInput[] f() {
         return this.e;
      }

      public RemoteInput[] g() {
         return this.f;
      }
   }

   public static class BigTextStyle extends NotificationCompat.Style {
      private CharSequence e;

      public BigTextStyle() {
      }

      public BigTextStyle(NotificationCompat.Builder var1) {
         this.a(var1);
      }

      public NotificationCompat.BigTextStyle a(CharSequence var1) {
         this.b = NotificationCompat.Builder.d(var1);
         return this;
      }

      @Override
      public void a(NotificationBuilderWithBuilderAccessor var1) {
         if (VERSION.SDK_INT >= 16) {
            android.app.Notification.BigTextStyle var2 = new android.app.Notification.BigTextStyle(var1.a()).setBigContentTitle(this.b).bigText(this.e);
            if (this.d) {
               var2.setSummaryText(this.c);
            }
         }
      }

      public NotificationCompat.BigTextStyle b(CharSequence var1) {
         this.e = NotificationCompat.Builder.d(var1);
         return this;
      }
   }

   public static class Builder {
      Bundle A;
      int B;
      int C;
      Notification D;
      RemoteViews E;
      RemoteViews F;
      RemoteViews G;
      String H;
      int I;
      String J;
      long K;
      int L;
      Notification M;
      @Deprecated
      public ArrayList<String> N;
      public Context a;
      public ArrayList<NotificationCompat.Action> b = new ArrayList<>();
      CharSequence c;
      CharSequence d;
      PendingIntent e;
      PendingIntent f;
      RemoteViews g;
      Bitmap h;
      CharSequence i;
      int j;
      int k;
      boolean l = true;
      boolean m;
      NotificationCompat.Style n;
      CharSequence o;
      CharSequence[] p;
      int q;
      int r;
      boolean s;
      String t;
      boolean u;
      String v;
      boolean w = false;
      boolean x;
      boolean y;
      String z;

      @Deprecated
      public Builder(Context var1) {
         this(var1, null);
      }

      public Builder(Context var1, String var2) {
         this.B = 0;
         this.C = 0;
         this.I = 0;
         this.L = 0;
         this.M = new Notification();
         this.a = var1;
         this.H = var2;
         this.M.when = System.currentTimeMillis();
         this.M.audioStreamType = -1;
         this.k = 0;
         this.N = new ArrayList<>();
      }

      private void a(int var1, boolean var2) {
         if (var2) {
            Notification var3 = this.M;
            var3.flags |= var1;
         } else {
            Notification var4 = this.M;
            var4.flags &= ~var1;
         }
      }

      protected static CharSequence d(CharSequence var0) {
         CharSequence var1;
         if (var0 == null) {
            var1 = var0;
         } else {
            var1 = var0;
            if (var0.length() > 5120) {
               var1 = var0.subSequence(0, 5120);
            }
         }

         return var1;
      }

      @Deprecated
      public Notification a() {
         return this.b();
      }

      public NotificationCompat.Builder a(int var1) {
         this.M.icon = var1;
         return this;
      }

      public NotificationCompat.Builder a(long var1) {
         this.M.when = var1;
         return this;
      }

      public NotificationCompat.Builder a(PendingIntent var1) {
         this.e = var1;
         return this;
      }

      public NotificationCompat.Builder a(Bitmap var1) {
         this.h = var1;
         return this;
      }

      public NotificationCompat.Builder a(Uri var1) {
         this.M.sound = var1;
         this.M.audioStreamType = -1;
         if (VERSION.SDK_INT >= 21) {
            this.M.audioAttributes = new android.media.AudioAttributes.Builder().setContentType(4).setUsage(5).build();
         }

         return this;
      }

      public NotificationCompat.Builder a(NotificationCompat.Style var1) {
         if (this.n != var1) {
            this.n = var1;
            if (this.n != null) {
               this.n.a(this);
            }
         }

         return this;
      }

      public NotificationCompat.Builder a(CharSequence var1) {
         this.c = d(var1);
         return this;
      }

      public NotificationCompat.Builder a(String var1) {
         this.H = var1;
         return this;
      }

      public NotificationCompat.Builder a(boolean var1) {
         this.a(16, var1);
         return this;
      }

      public Notification b() {
         return new NotificationCompatBuilder(this).b();
      }

      public NotificationCompat.Builder b(int var1) {
         this.M.defaults = var1;
         if ((var1 & 4) != 0) {
            Notification var2 = this.M;
            var2.flags |= 1;
         }

         return this;
      }

      public NotificationCompat.Builder b(PendingIntent var1) {
         this.M.deleteIntent = var1;
         return this;
      }

      public NotificationCompat.Builder b(CharSequence var1) {
         this.d = d(var1);
         return this;
      }

      public NotificationCompat.Builder b(boolean var1) {
         this.w = var1;
         return this;
      }

      public NotificationCompat.Builder c(int var1) {
         this.k = var1;
         return this;
      }

      public NotificationCompat.Builder c(CharSequence var1) {
         this.M.tickerText = d(var1);
         return this;
      }

      public NotificationCompat.Builder d(int var1) {
         this.B = var1;
         return this;
      }
   }

   public abstract static class Style {
      protected NotificationCompat.Builder a;
      CharSequence b;
      CharSequence c;
      boolean d = false;

      public void a(Bundle var1) {
      }

      public void a(NotificationBuilderWithBuilderAccessor var1) {
      }

      public void a(NotificationCompat.Builder var1) {
         if (this.a != var1) {
            this.a = var1;
            if (this.a != null) {
               this.a.a(this);
            }
         }
      }

      public RemoteViews b(NotificationBuilderWithBuilderAccessor var1) {
         return null;
      }

      public RemoteViews c(NotificationBuilderWithBuilderAccessor var1) {
         return null;
      }

      public RemoteViews d(NotificationBuilderWithBuilderAccessor var1) {
         return null;
      }
   }
}
