package android.support.v4.media;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Build.VERSION;
import android.os.Parcelable.Creator;
import android.text.TextUtils;

public final class MediaDescriptionCompat implements Parcelable {
   public static final Creator<MediaDescriptionCompat> CREATOR = new Creator<MediaDescriptionCompat>() {
      public MediaDescriptionCompat a(Parcel var1) {
         MediaDescriptionCompat var2;
         if (VERSION.SDK_INT < 21) {
            var2 = new MediaDescriptionCompat(var1);
         } else {
            var2 = MediaDescriptionCompat.a(MediaDescriptionCompatApi21.a(var1));
         }

         return var2;
      }

      public MediaDescriptionCompat[] a(int var1) {
         return new MediaDescriptionCompat[var1];
      }
   };
   private final String a;
   private final CharSequence b;
   private final CharSequence c;
   private final CharSequence d;
   private final Bitmap e;
   private final Uri f;
   private final Bundle g;
   private final Uri h;
   private Object i;

   MediaDescriptionCompat(Parcel var1) {
      this.a = var1.readString();
      this.b = (CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(var1);
      this.c = (CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(var1);
      this.d = (CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(var1);
      this.e = (Bitmap)var1.readParcelable(null);
      this.f = (Uri)var1.readParcelable(null);
      this.g = var1.readBundle();
      this.h = (Uri)var1.readParcelable(null);
   }

   MediaDescriptionCompat(String var1, CharSequence var2, CharSequence var3, CharSequence var4, Bitmap var5, Uri var6, Bundle var7, Uri var8) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
      this.d = var4;
      this.e = var5;
      this.f = var6;
      this.g = var7;
      this.h = var8;
   }

   public static MediaDescriptionCompat a(Object var0) {
      Bundle var2 = null;
      MediaDescriptionCompat var1 = var2;
      if (var0 != null) {
         var1 = var2;
         if (VERSION.SDK_INT >= 21) {
            MediaDescriptionCompat.Builder var3 = new MediaDescriptionCompat.Builder();
            var3.a(MediaDescriptionCompatApi21.a(var0));
            var3.a(MediaDescriptionCompatApi21.b(var0));
            var3.b(MediaDescriptionCompatApi21.c(var0));
            var3.c(MediaDescriptionCompatApi21.d(var0));
            var3.a(MediaDescriptionCompatApi21.e(var0));
            var3.a(MediaDescriptionCompatApi21.f(var0));
            var2 = MediaDescriptionCompatApi21.g(var0);
            Uri var4;
            if (var2 == null) {
               var4 = null;
            } else {
               var4 = (Uri)var2.getParcelable("android.support.v4.media.description.MEDIA_URI");
            }

            if (var4 != null) {
               if (var2.containsKey("android.support.v4.media.description.NULL_BUNDLE_FLAG") && var2.size() == 2) {
                  var2 = null;
               } else {
                  var2.remove("android.support.v4.media.description.MEDIA_URI");
                  var2.remove("android.support.v4.media.description.NULL_BUNDLE_FLAG");
               }
            }

            var3.a(var2);
            if (var4 != null) {
               var3.b(var4);
            } else if (VERSION.SDK_INT >= 23) {
               var3.b(MediaDescriptionCompatApi23.h(var0));
            }

            var1 = var3.a();
            var1.i = var0;
         }
      }

      return var1;
   }

   public String a() {
      return this.a;
   }

   public Object b() {
      Object var1;
      if (this.i == null && VERSION.SDK_INT >= 21) {
         Object var3 = MediaDescriptionCompatApi21.Builder.a();
         MediaDescriptionCompatApi21.Builder.a(var3, this.a);
         MediaDescriptionCompatApi21.Builder.a(var3, this.b);
         MediaDescriptionCompatApi21.Builder.b(var3, this.c);
         MediaDescriptionCompatApi21.Builder.c(var3, this.d);
         MediaDescriptionCompatApi21.Builder.a(var3, this.e);
         MediaDescriptionCompatApi21.Builder.a(var3, this.f);
         Bundle var2 = this.g;
         var1 = var2;
         if (VERSION.SDK_INT < 23) {
            var1 = var2;
            if (this.h != null) {
               var1 = var2;
               if (var2 == null) {
                  var1 = new Bundle();
                  var1.putBoolean("android.support.v4.media.description.NULL_BUNDLE_FLAG", true);
               }

               var1.putParcelable("android.support.v4.media.description.MEDIA_URI", this.h);
            }
         }

         MediaDescriptionCompatApi21.Builder.a(var3, var1);
         if (VERSION.SDK_INT >= 23) {
            MediaDescriptionCompatApi23.Builder.b(var3, this.h);
         }

         this.i = MediaDescriptionCompatApi21.Builder.a(var3);
         var1 = (Bundle)this.i;
      } else {
         var1 = (Bundle)this.i;
      }

      return var1;
   }

   public int describeContents() {
      return 0;
   }

   @Override
   public String toString() {
      return this.b + ", " + this.c + ", " + this.d;
   }

   public void writeToParcel(Parcel var1, int var2) {
      if (VERSION.SDK_INT < 21) {
         var1.writeString(this.a);
         TextUtils.writeToParcel(this.b, var1, var2);
         TextUtils.writeToParcel(this.c, var1, var2);
         TextUtils.writeToParcel(this.d, var1, var2);
         var1.writeParcelable(this.e, var2);
         var1.writeParcelable(this.f, var2);
         var1.writeBundle(this.g);
         var1.writeParcelable(this.h, var2);
      } else {
         MediaDescriptionCompatApi21.a(this.b(), var1, var2);
      }
   }

   public static final class Builder {
      private String a;
      private CharSequence b;
      private CharSequence c;
      private CharSequence d;
      private Bitmap e;
      private Uri f;
      private Bundle g;
      private Uri h;

      public MediaDescriptionCompat.Builder a(Bitmap var1) {
         this.e = var1;
         return this;
      }

      public MediaDescriptionCompat.Builder a(Uri var1) {
         this.f = var1;
         return this;
      }

      public MediaDescriptionCompat.Builder a(Bundle var1) {
         this.g = var1;
         return this;
      }

      public MediaDescriptionCompat.Builder a(CharSequence var1) {
         this.b = var1;
         return this;
      }

      public MediaDescriptionCompat.Builder a(String var1) {
         this.a = var1;
         return this;
      }

      public MediaDescriptionCompat a() {
         return new MediaDescriptionCompat(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h);
      }

      public MediaDescriptionCompat.Builder b(Uri var1) {
         this.h = var1;
         return this;
      }

      public MediaDescriptionCompat.Builder b(CharSequence var1) {
         this.c = var1;
         return this;
      }

      public MediaDescriptionCompat.Builder c(CharSequence var1) {
         this.d = var1;
         return this;
      }
   }
}
