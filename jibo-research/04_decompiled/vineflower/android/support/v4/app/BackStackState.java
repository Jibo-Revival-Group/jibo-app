package android.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;

final class BackStackState implements Parcelable {
   public static final Creator<BackStackState> CREATOR = new Creator<BackStackState>() {
      public BackStackState a(Parcel var1) {
         return new BackStackState(var1);
      }

      public BackStackState[] a(int var1) {
         return new BackStackState[var1];
      }
   };
   final int[] a;
   final int b;
   final int c;
   final String d;
   final int e;
   final int f;
   final CharSequence g;
   final int h;
   final CharSequence i;
   final ArrayList<String> j;
   final ArrayList<String> k;
   final boolean l;

   public BackStackState(Parcel var1) {
      this.a = var1.createIntArray();
      this.b = var1.readInt();
      this.c = var1.readInt();
      this.d = var1.readString();
      this.e = var1.readInt();
      this.f = var1.readInt();
      this.g = (CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(var1);
      this.h = var1.readInt();
      this.i = (CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(var1);
      this.j = var1.createStringArrayList();
      this.k = var1.createStringArrayList();
      boolean var2;
      if (var1.readInt() != 0) {
         var2 = true;
      } else {
         var2 = false;
      }

      this.l = var2;
   }

   public BackStackState(BackStackRecord var1) {
      int var4 = var1.b.size();
      this.a = new int[var4 * 6];
      if (!var1.i) {
         throw new IllegalStateException("Not on back stack");
      }

      int var2 = 0;
      int var3 = 0;

      while (var2 < var4) {
         BackStackRecord.Op var7 = var1.b.get(var2);
         int[] var8 = this.a;
         int var5 = var3 + 1;
         var8[var3] = var7.a;
         var8 = this.a;
         int var6 = var5 + 1;
         if (var7.b != null) {
            var3 = var7.b.mIndex;
         } else {
            var3 = -1;
         }

         var8[var5] = var3;
         var8 = this.a;
         var3 = var6 + 1;
         var8[var6] = var7.c;
         var8 = this.a;
         var5 = var3 + 1;
         var8[var3] = var7.d;
         var8 = this.a;
         var6 = var5 + 1;
         var8[var5] = var7.e;
         var8 = this.a;
         var3 = var6 + 1;
         var8[var6] = var7.f;
         var2++;
      }

      this.b = var1.g;
      this.c = var1.h;
      this.d = var1.k;
      this.e = var1.m;
      this.f = var1.n;
      this.g = var1.o;
      this.h = var1.p;
      this.i = var1.q;
      this.j = var1.r;
      this.k = var1.s;
      this.l = var1.t;
   }

   public BackStackRecord a(FragmentManagerImpl var1) {
      int var3 = 0;
      BackStackRecord var6 = new BackStackRecord(var1);
      int var2 = 0;

      while (var3 < this.a.length) {
         BackStackRecord.Op var5 = new BackStackRecord.Op();
         int[] var7 = this.a;
         int var4 = var3 + 1;
         var5.a = var7[var3];
         if (FragmentManagerImpl.a) {
            Log.v("FragmentManager", "Instantiate " + var6 + " op #" + var2 + " base fragment #" + this.a[var4]);
         }

         var7 = this.a;
         var3 = var4 + 1;
         var4 = var7[var4];
         if (var4 >= 0) {
            var5.b = (Fragment)var1.f.get(var4);
         } else {
            var5.b = null;
         }

         var7 = this.a;
         var4 = var3 + 1;
         var5.c = var7[var3];
         var7 = this.a;
         var3 = var4 + 1;
         var5.d = var7[var4];
         var7 = this.a;
         var4 = var3 + 1;
         var5.e = var7[var3];
         var5.f = this.a[var4];
         var6.c = var5.c;
         var6.d = var5.d;
         var6.e = var5.e;
         var6.f = var5.f;
         var6.a(var5);
         var2++;
         var3 = var4 + 1;
      }

      var6.g = this.b;
      var6.h = this.c;
      var6.k = this.d;
      var6.m = this.e;
      var6.i = true;
      var6.n = this.f;
      var6.o = this.g;
      var6.p = this.h;
      var6.q = this.i;
      var6.r = this.j;
      var6.s = this.k;
      var6.t = this.l;
      var6.a(1);
      return var6;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      byte var3 = 0;
      var1.writeIntArray(this.a);
      var1.writeInt(this.b);
      var1.writeInt(this.c);
      var1.writeString(this.d);
      var1.writeInt(this.e);
      var1.writeInt(this.f);
      TextUtils.writeToParcel(this.g, var1, 0);
      var1.writeInt(this.h);
      TextUtils.writeToParcel(this.i, var1, 0);
      var1.writeStringList(this.j);
      var1.writeStringList(this.k);
      if (this.l) {
         var3 = 1;
      }

      var1.writeInt(var3);
   }
}
