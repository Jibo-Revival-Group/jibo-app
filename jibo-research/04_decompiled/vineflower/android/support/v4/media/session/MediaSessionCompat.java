package android.support.v4.media.session;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.ResultReceiver;
import android.os.Build.VERSION;
import android.os.Parcelable.Creator;
import android.support.v4.media.MediaDescriptionCompat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MediaSessionCompat {
   public static final class QueueItem implements Parcelable {
      public static final Creator<MediaSessionCompat.QueueItem> CREATOR = new Creator<MediaSessionCompat.QueueItem>() {
         public MediaSessionCompat.QueueItem a(Parcel var1) {
            return new MediaSessionCompat.QueueItem(var1);
         }

         public MediaSessionCompat.QueueItem[] a(int var1) {
            return new MediaSessionCompat.QueueItem[var1];
         }
      };
      private final MediaDescriptionCompat a;
      private final long b;
      private Object c;

      QueueItem(Parcel var1) {
         this.a = (MediaDescriptionCompat)MediaDescriptionCompat.CREATOR.createFromParcel(var1);
         this.b = var1.readLong();
      }

      private QueueItem(Object var1, MediaDescriptionCompat var2, long var3) {
         if (var2 == null) {
            throw new IllegalArgumentException("Description cannot be null.");
         }

         if (var3 == -1L) {
            throw new IllegalArgumentException("Id cannot be QueueItem.UNKNOWN_ID");
         }

         this.a = var2;
         this.b = var3;
         this.c = var1;
      }

      public static MediaSessionCompat.QueueItem a(Object var0) {
         if (var0 != null && VERSION.SDK_INT >= 21) {
            var0 = new MediaSessionCompat.QueueItem(
               var0, MediaDescriptionCompat.a(MediaSessionCompatApi21.QueueItem.a(var0)), MediaSessionCompatApi21.QueueItem.b(var0)
            );
         } else {
            var0 = null;
         }

         return var0;
      }

      public static List<MediaSessionCompat.QueueItem> a(List<?> var0) {
         if (var0 != null && VERSION.SDK_INT >= 21) {
            ArrayList var1 = new ArrayList();
            Iterator var2 = var0.iterator();

            while (true) {
               var0 = var1;
               if (!var2.hasNext()) {
                  break;
               }

               var1.add(a(var2.next()));
            }
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
         return "MediaSession.QueueItem {Description=" + this.a + ", Id=" + this.b + " }";
      }

      public void writeToParcel(Parcel var1, int var2) {
         this.a.writeToParcel(var1, var2);
         var1.writeLong(this.b);
      }
   }

   static final class ResultReceiverWrapper implements Parcelable {
      public static final Creator<MediaSessionCompat.ResultReceiverWrapper> CREATOR = new Creator<MediaSessionCompat.ResultReceiverWrapper>() {
         public MediaSessionCompat.ResultReceiverWrapper a(Parcel var1) {
            return new MediaSessionCompat.ResultReceiverWrapper(var1);
         }

         public MediaSessionCompat.ResultReceiverWrapper[] a(int var1) {
            return new MediaSessionCompat.ResultReceiverWrapper[var1];
         }
      };
      private ResultReceiver a;

      ResultReceiverWrapper(Parcel var1) {
         this.a = (ResultReceiver)ResultReceiver.CREATOR.createFromParcel(var1);
      }

      public int describeContents() {
         return 0;
      }

      public void writeToParcel(Parcel var1, int var2) {
         this.a.writeToParcel(var1, var2);
      }
   }

   public static final class Token implements Parcelable {
      public static final Creator<MediaSessionCompat.Token> CREATOR = new Creator<MediaSessionCompat.Token>() {
         public MediaSessionCompat.Token a(Parcel var1) {
            Object var2;
            if (VERSION.SDK_INT >= 21) {
               var2 = var1.readParcelable(null);
            } else {
               var2 = var1.readStrongBinder();
            }

            return new MediaSessionCompat.Token(var2);
         }

         public MediaSessionCompat.Token[] a(int var1) {
            return new MediaSessionCompat.Token[var1];
         }
      };
      private final Object a;
      private final IMediaSession b;

      Token(Object var1) {
         this(var1, null);
      }

      Token(Object var1, IMediaSession var2) {
         this.a = var1;
         this.b = var2;
      }

      public static MediaSessionCompat.Token a(Object var0) {
         return a(var0, null);
      }

      public static MediaSessionCompat.Token a(Object var0, IMediaSession var1) {
         if (var0 != null && VERSION.SDK_INT >= 21) {
            var0 = new MediaSessionCompat.Token(MediaSessionCompatApi21.a(var0), var1);
         } else {
            var0 = null;
         }

         return var0;
      }

      public Object a() {
         return this.a;
      }

      public IMediaSession b() {
         return this.b;
      }

      public int describeContents() {
         return 0;
      }

      @Override
      public boolean equals(Object var1) {
         boolean var2 = true;
         if (this != var1) {
            if (!(var1 instanceof MediaSessionCompat.Token)) {
               var2 = false;
            } else {
               var1 = var1;
               if (this.a == null) {
                  if (var1.a != null) {
                     var2 = false;
                  }
               } else if (var1.a == null) {
                  var2 = false;
               } else {
                  var2 = this.a.equals(var1.a);
               }
            }
         }

         return var2;
      }

      @Override
      public int hashCode() {
         int var1;
         if (this.a == null) {
            var1 = 0;
         } else {
            var1 = this.a.hashCode();
         }

         return var1;
      }

      public void writeToParcel(Parcel var1, int var2) {
         if (VERSION.SDK_INT >= 21) {
            var1.writeParcelable((Parcelable)this.a, var2);
         } else {
            var1.writeStrongBinder((IBinder)this.a);
         }
      }
   }
}
