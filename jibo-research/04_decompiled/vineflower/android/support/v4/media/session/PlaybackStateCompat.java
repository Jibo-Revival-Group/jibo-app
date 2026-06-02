package android.support.v4.media.session;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Build.VERSION;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class PlaybackStateCompat implements Parcelable {
   public static final Creator<PlaybackStateCompat> CREATOR = new Creator<PlaybackStateCompat>() {
      public PlaybackStateCompat a(Parcel var1) {
         return new PlaybackStateCompat(var1);
      }

      public PlaybackStateCompat[] a(int var1) {
         return new PlaybackStateCompat[var1];
      }
   };
   final int a;
   final long b;
   final long c;
   final float d;
   final long e;
   final int f;
   final CharSequence g;
   final long h;
   List<PlaybackStateCompat.CustomAction> i;
   final long j;
   final Bundle k;
   private Object l;

   PlaybackStateCompat(
      int var1,
      long var2,
      long var4,
      float var6,
      long var7,
      int var9,
      CharSequence var10,
      long var11,
      List<PlaybackStateCompat.CustomAction> var13,
      long var14,
      Bundle var16
   ) {
      this.a = var1;
      this.b = var2;
      this.c = var4;
      this.d = var6;
      this.e = var7;
      this.f = var9;
      this.g = var10;
      this.h = var11;
      this.i = new ArrayList<>(var13);
      this.j = var14;
      this.k = var16;
   }

   PlaybackStateCompat(Parcel var1) {
      this.a = var1.readInt();
      this.b = var1.readLong();
      this.d = var1.readFloat();
      this.h = var1.readLong();
      this.c = var1.readLong();
      this.e = var1.readLong();
      this.g = (CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(var1);
      this.i = var1.createTypedArrayList(PlaybackStateCompat.CustomAction.CREATOR);
      this.j = var1.readLong();
      this.k = var1.readBundle();
      this.f = var1.readInt();
   }

   public static PlaybackStateCompat a(Object var0) {
      if (var0 != null && VERSION.SDK_INT >= 21) {
         List var3 = PlaybackStateCompatApi21.h(var0);
         ArrayList var1 = null;
         if (var3 != null) {
            ArrayList var2 = new ArrayList(var3.size());
            Iterator var7 = var3.iterator();

            while (true) {
               var1 = var2;
               if (!var7.hasNext()) {
                  break;
               }

               var2.add(PlaybackStateCompat.CustomAction.a(var7.next()));
            }
         }

         Bundle var6;
         if (VERSION.SDK_INT >= 22) {
            var6 = PlaybackStateCompatApi22.a(var0);
         } else {
            var6 = null;
         }

         PlaybackStateCompat var5 = new PlaybackStateCompat(
            PlaybackStateCompatApi21.a(var0),
            PlaybackStateCompatApi21.b(var0),
            PlaybackStateCompatApi21.c(var0),
            PlaybackStateCompatApi21.d(var0),
            PlaybackStateCompatApi21.e(var0),
            0,
            PlaybackStateCompatApi21.f(var0),
            PlaybackStateCompatApi21.g(var0),
            var1,
            PlaybackStateCompatApi21.i(var0),
            var6
         );
         var5.l = var0;
         var0 = var5;
      } else {
         var0 = null;
      }

      return var0;
   }

   public int describeContents() {
      return 0;
   }

   @Override
   public String toString() {
      StringBuilder var1 = new StringBuilder("PlaybackState {");
      var1.append("state=").append(this.a);
      var1.append(", position=").append(this.b);
      var1.append(", buffered position=").append(this.c);
      var1.append(", speed=").append(this.d);
      var1.append(", updated=").append(this.h);
      var1.append(", actions=").append(this.e);
      var1.append(", error code=").append(this.f);
      var1.append(", error message=").append(this.g);
      var1.append(", custom actions=").append(this.i);
      var1.append(", active item id=").append(this.j);
      var1.append("}");
      return var1.toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      var1.writeInt(this.a);
      var1.writeLong(this.b);
      var1.writeFloat(this.d);
      var1.writeLong(this.h);
      var1.writeLong(this.c);
      var1.writeLong(this.e);
      TextUtils.writeToParcel(this.g, var1, var2);
      var1.writeTypedList(this.i);
      var1.writeLong(this.j);
      var1.writeBundle(this.k);
      var1.writeInt(this.f);
   }

   public static final class CustomAction implements Parcelable {
      public static final Creator<PlaybackStateCompat.CustomAction> CREATOR = new Creator<PlaybackStateCompat.CustomAction>() {
         public PlaybackStateCompat.CustomAction a(Parcel var1) {
            return new PlaybackStateCompat.CustomAction(var1);
         }

         public PlaybackStateCompat.CustomAction[] a(int var1) {
            return new PlaybackStateCompat.CustomAction[var1];
         }
      };
      private final String a;
      private final CharSequence b;
      private final int c;
      private final Bundle d;
      private Object e;

      CustomAction(Parcel var1) {
         this.a = var1.readString();
         this.b = (CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(var1);
         this.c = var1.readInt();
         this.d = var1.readBundle();
      }

      CustomAction(String var1, CharSequence var2, int var3, Bundle var4) {
         this.a = var1;
         this.b = var2;
         this.c = var3;
         this.d = var4;
      }

      public static PlaybackStateCompat.CustomAction a(Object var0) {
         if (var0 != null && VERSION.SDK_INT >= 21) {
            PlaybackStateCompat.CustomAction var1 = new PlaybackStateCompat.CustomAction(
               PlaybackStateCompatApi21.CustomAction.a(var0),
               PlaybackStateCompatApi21.CustomAction.b(var0),
               PlaybackStateCompatApi21.CustomAction.c(var0),
               PlaybackStateCompatApi21.CustomAction.d(var0)
            );
            var1.e = var0;
            var0 = var1;
         } else {
            var0 = null;
         }

         return var0;
      }

      public int describeContents() {
         return 0;
      }

      @Override
      public String toString() {
         return "Action:mName='" + this.b + ", mIcon=" + this.c + ", mExtras=" + this.d;
      }

      public void writeToParcel(Parcel var1, int var2) {
         var1.writeString(this.a);
         TextUtils.writeToParcel(this.b, var1, var2);
         var1.writeInt(this.c);
         var1.writeBundle(this.d);
      }
   }
}
