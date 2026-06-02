package android.support.design.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import android.util.SparseArray;

public class ParcelableSparseArray extends SparseArray<Parcelable> implements Parcelable {
   public static final Creator<ParcelableSparseArray> CREATOR = new ClassLoaderCreator<ParcelableSparseArray>() {
      public ParcelableSparseArray a(Parcel var1) {
         return new ParcelableSparseArray(var1, null);
      }

      public ParcelableSparseArray a(Parcel var1, ClassLoader var2) {
         return new ParcelableSparseArray(var1, var2);
      }

      public ParcelableSparseArray[] a(int var1) {
         return new ParcelableSparseArray[var1];
      }
   };

   public ParcelableSparseArray() {
   }

   public ParcelableSparseArray(Parcel var1, ClassLoader var2) {
      int var4 = var1.readInt();
      int[] var5 = new int[var4];
      var1.readIntArray(var5);
      Parcelable[] var6 = var1.readParcelableArray(var2);

      for (int var3 = 0; var3 < var4; var3++) {
         this.put(var5[var3], var6[var3]);
      }
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      int var4 = this.size();
      int[] var6 = new int[var4];
      Parcelable[] var5 = new Parcelable[var4];

      for (int var3 = 0; var3 < var4; var3++) {
         var6[var3] = this.keyAt(var3);
         var5[var3] = (Parcelable)this.valueAt(var3);
      }

      var1.writeInt(var4);
      var1.writeIntArray(var6);
      var1.writeParcelableArray(var5, var2);
   }
}
