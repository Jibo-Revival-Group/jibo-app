package android.support.v4.media;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public final class RatingCompat implements Parcelable {
   public static final Creator<RatingCompat> CREATOR = new Creator<RatingCompat>() {
      public RatingCompat a(Parcel var1) {
         return new RatingCompat(var1.readInt(), var1.readFloat());
      }

      public RatingCompat[] a(int var1) {
         return new RatingCompat[var1];
      }
   };
   private final int a;
   private final float b;

   RatingCompat(int var1, float var2) {
      this.a = var1;
      this.b = var2;
   }

   public int describeContents() {
      return this.a;
   }

   @Override
   public String toString() {
      StringBuilder var2 = new StringBuilder().append("Rating:style=").append(this.a).append(" rating=");
      String var1;
      if (this.b < 0.0F) {
         var1 = "unrated";
      } else {
         var1 = String.valueOf(this.b);
      }

      return var2.append(var1).toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      var1.writeInt(this.a);
      var1.writeFloat(this.b);
   }
}
