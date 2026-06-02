package android.support.v4.media;

import android.graphics.Bitmap;
import android.media.MediaDescription;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;

class MediaDescriptionCompatApi21 {
   public static Object a(Parcel var0) {
      return MediaDescription.CREATOR.createFromParcel(var0);
   }

   public static String a(Object var0) {
      return ((MediaDescription)var0).getMediaId();
   }

   public static void a(Object var0, Parcel var1, int var2) {
      ((MediaDescription)var0).writeToParcel(var1, var2);
   }

   public static CharSequence b(Object var0) {
      return ((MediaDescription)var0).getTitle();
   }

   public static CharSequence c(Object var0) {
      return ((MediaDescription)var0).getSubtitle();
   }

   public static CharSequence d(Object var0) {
      return ((MediaDescription)var0).getDescription();
   }

   public static Bitmap e(Object var0) {
      return ((MediaDescription)var0).getIconBitmap();
   }

   public static Uri f(Object var0) {
      return ((MediaDescription)var0).getIconUri();
   }

   public static Bundle g(Object var0) {
      return ((MediaDescription)var0).getExtras();
   }

   static class Builder {
      public static Object a() {
         return new android.media.MediaDescription.Builder();
      }

      public static Object a(Object var0) {
         return ((android.media.MediaDescription.Builder)var0).build();
      }

      public static void a(Object var0, Bitmap var1) {
         ((android.media.MediaDescription.Builder)var0).setIconBitmap(var1);
      }

      public static void a(Object var0, Uri var1) {
         ((android.media.MediaDescription.Builder)var0).setIconUri(var1);
      }

      public static void a(Object var0, Bundle var1) {
         ((android.media.MediaDescription.Builder)var0).setExtras(var1);
      }

      public static void a(Object var0, CharSequence var1) {
         ((android.media.MediaDescription.Builder)var0).setTitle(var1);
      }

      public static void a(Object var0, String var1) {
         ((android.media.MediaDescription.Builder)var0).setMediaId(var1);
      }

      public static void b(Object var0, CharSequence var1) {
         ((android.media.MediaDescription.Builder)var0).setSubtitle(var1);
      }

      public static void c(Object var0, CharSequence var1) {
         ((android.media.MediaDescription.Builder)var0).setDescription(var1);
      }
   }
}
