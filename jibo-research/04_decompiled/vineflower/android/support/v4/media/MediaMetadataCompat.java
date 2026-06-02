package android.support.v4.media;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Build.VERSION;
import android.os.Parcelable.Creator;
import android.support.v4.util.ArrayMap;

public final class MediaMetadataCompat implements Parcelable {
   public static final Creator<MediaMetadataCompat> CREATOR = new Creator<MediaMetadataCompat>() {
      public MediaMetadataCompat a(Parcel var1) {
         return new MediaMetadataCompat(var1);
      }

      public MediaMetadataCompat[] a(int var1) {
         return new MediaMetadataCompat[var1];
      }
   };
   static final ArrayMap<String, Integer> a = new ArrayMap<>();
   private static final String[] c = new String[]{
      "android.media.metadata.TITLE",
      "android.media.metadata.ARTIST",
      "android.media.metadata.ALBUM",
      "android.media.metadata.ALBUM_ARTIST",
      "android.media.metadata.WRITER",
      "android.media.metadata.AUTHOR",
      "android.media.metadata.COMPOSER"
   };
   private static final String[] d = new String[]{"android.media.metadata.DISPLAY_ICON", "android.media.metadata.ART", "android.media.metadata.ALBUM_ART"};
   private static final String[] e = new String[]{
      "android.media.metadata.DISPLAY_ICON_URI", "android.media.metadata.ART_URI", "android.media.metadata.ALBUM_ART_URI"
   };
   final Bundle b;
   private Object f;

   static {
      a.put("android.media.metadata.TITLE", 1);
      a.put("android.media.metadata.ARTIST", 1);
      a.put("android.media.metadata.DURATION", 0);
      a.put("android.media.metadata.ALBUM", 1);
      a.put("android.media.metadata.AUTHOR", 1);
      a.put("android.media.metadata.WRITER", 1);
      a.put("android.media.metadata.COMPOSER", 1);
      a.put("android.media.metadata.COMPILATION", 1);
      a.put("android.media.metadata.DATE", 1);
      a.put("android.media.metadata.YEAR", 0);
      a.put("android.media.metadata.GENRE", 1);
      a.put("android.media.metadata.TRACK_NUMBER", 0);
      a.put("android.media.metadata.NUM_TRACKS", 0);
      a.put("android.media.metadata.DISC_NUMBER", 0);
      a.put("android.media.metadata.ALBUM_ARTIST", 1);
      a.put("android.media.metadata.ART", 2);
      a.put("android.media.metadata.ART_URI", 1);
      a.put("android.media.metadata.ALBUM_ART", 2);
      a.put("android.media.metadata.ALBUM_ART_URI", 1);
      a.put("android.media.metadata.USER_RATING", 3);
      a.put("android.media.metadata.RATING", 3);
      a.put("android.media.metadata.DISPLAY_TITLE", 1);
      a.put("android.media.metadata.DISPLAY_SUBTITLE", 1);
      a.put("android.media.metadata.DISPLAY_DESCRIPTION", 1);
      a.put("android.media.metadata.DISPLAY_ICON", 2);
      a.put("android.media.metadata.DISPLAY_ICON_URI", 1);
      a.put("android.media.metadata.MEDIA_ID", 1);
      a.put("android.media.metadata.BT_FOLDER_TYPE", 0);
      a.put("android.media.metadata.MEDIA_URI", 1);
      a.put("android.media.metadata.ADVERTISEMENT", 0);
      a.put("android.media.metadata.DOWNLOAD_STATUS", 0);
   }

   MediaMetadataCompat(Parcel var1) {
      this.b = var1.readBundle();
      this.b.setClassLoader(MediaMetadataCompat.class.getClassLoader());
   }

   public static MediaMetadataCompat a(Object var0) {
      if (var0 != null && VERSION.SDK_INT >= 21) {
         Parcel var2 = Parcel.obtain();
         MediaMetadataCompatApi21.a(var0, var2, 0);
         var2.setDataPosition(0);
         MediaMetadataCompat var1 = (MediaMetadataCompat)CREATOR.createFromParcel(var2);
         var2.recycle();
         var1.f = var0;
         var0 = var1;
      } else {
         var0 = null;
      }

      return var0;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      var1.writeBundle(this.b);
   }
}
