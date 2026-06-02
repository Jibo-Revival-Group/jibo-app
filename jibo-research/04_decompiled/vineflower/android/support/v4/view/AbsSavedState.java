package android.support.v4.view;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;

public abstract class AbsSavedState implements Parcelable {
   public static final Creator<AbsSavedState> CREATOR = new ClassLoaderCreator<AbsSavedState>() {
      public AbsSavedState a(Parcel var1) {
         return this.a(var1, null);
      }

      public AbsSavedState a(Parcel var1, ClassLoader var2) {
         if (var1.readParcelable(var2) != null) {
            throw new IllegalStateException("superState must be null");
         } else {
            return AbsSavedState.d;
         }
      }

      public AbsSavedState[] a(int var1) {
         return new AbsSavedState[var1];
      }
   };
   public static final AbsSavedState d = new AbsSavedState() {};
   private final Parcelable a;

   private AbsSavedState() {
      this.a = null;
   }

   protected AbsSavedState(Parcel var1, ClassLoader var2) {
      Parcelable var3 = var1.readParcelable(var2);
      if (var3 == null) {
         var3 = d;
      }

      this.a = var3;
   }

   protected AbsSavedState(Parcelable var1) {
      if (var1 == null) {
         throw new IllegalArgumentException("superState must not be null");
      }

      if (var1 == d) {
         var1 = null;
      }

      this.a = var1;
   }

   public final Parcelable a() {
      return this.a;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      var1.writeParcelable(this.a, var2);
   }
}
