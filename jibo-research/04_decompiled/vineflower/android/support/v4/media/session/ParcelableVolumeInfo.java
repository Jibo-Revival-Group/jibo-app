package android.support.v4.media.session;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class ParcelableVolumeInfo implements Parcelable {
   public static final Creator<ParcelableVolumeInfo> CREATOR = new Creator<ParcelableVolumeInfo>() {
      public ParcelableVolumeInfo a(Parcel var1) {
         return new ParcelableVolumeInfo(var1);
      }

      public ParcelableVolumeInfo[] a(int var1) {
         return new ParcelableVolumeInfo[var1];
      }
   };
   public int a;
   public int b;
   public int c;
   public int d;
   public int e;

   public ParcelableVolumeInfo(Parcel var1) {
      this.a = var1.readInt();
      this.c = var1.readInt();
      this.d = var1.readInt();
      this.e = var1.readInt();
      this.b = var1.readInt();
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      var1.writeInt(this.a);
      var1.writeInt(this.c);
      var1.writeInt(this.d);
      var1.writeInt(this.e);
      var1.writeInt(this.b);
   }
}
