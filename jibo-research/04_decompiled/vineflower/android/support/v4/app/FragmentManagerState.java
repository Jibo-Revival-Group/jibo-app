package android.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

final class FragmentManagerState implements Parcelable {
   public static final Creator<FragmentManagerState> CREATOR = new Creator<FragmentManagerState>() {
      public FragmentManagerState a(Parcel var1) {
         return new FragmentManagerState(var1);
      }

      public FragmentManagerState[] a(int var1) {
         return new FragmentManagerState[var1];
      }
   };
   FragmentState[] a;
   int[] b;
   BackStackState[] c;
   int d = -1;
   int e;

   public FragmentManagerState() {
   }

   public FragmentManagerState(Parcel var1) {
      this.a = (FragmentState[])var1.createTypedArray(FragmentState.CREATOR);
      this.b = var1.createIntArray();
      this.c = (BackStackState[])var1.createTypedArray(BackStackState.CREATOR);
      this.d = var1.readInt();
      this.e = var1.readInt();
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      var1.writeTypedArray(this.a, var2);
      var1.writeIntArray(this.b);
      var1.writeTypedArray(this.c, var2);
      var1.writeInt(this.d);
      var1.writeInt(this.e);
   }
}
