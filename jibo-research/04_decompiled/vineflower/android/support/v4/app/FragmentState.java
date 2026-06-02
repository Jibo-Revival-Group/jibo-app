package android.support.v4.app;

import android.arch.lifecycle.ViewModelStore;
import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.Log;

final class FragmentState implements Parcelable {
   public static final Creator<FragmentState> CREATOR = new Creator<FragmentState>() {
      public FragmentState a(Parcel var1) {
         return new FragmentState(var1);
      }

      public FragmentState[] a(int var1) {
         return new FragmentState[var1];
      }
   };
   final String a;
   final int b;
   final boolean c;
   final int d;
   final int e;
   final String f;
   final boolean g;
   final boolean h;
   final Bundle i;
   final boolean j;
   Bundle k;
   Fragment l;

   FragmentState(Parcel var1) {
      boolean var3 = true;
      super();
      this.a = var1.readString();
      this.b = var1.readInt();
      boolean var2;
      if (var1.readInt() != 0) {
         var2 = true;
      } else {
         var2 = false;
      }

      this.c = var2;
      this.d = var1.readInt();
      this.e = var1.readInt();
      this.f = var1.readString();
      if (var1.readInt() != 0) {
         var2 = true;
      } else {
         var2 = false;
      }

      this.g = var2;
      if (var1.readInt() != 0) {
         var2 = true;
      } else {
         var2 = false;
      }

      this.h = var2;
      this.i = var1.readBundle();
      if (var1.readInt() != 0) {
         var2 = var3;
      } else {
         var2 = false;
      }

      this.j = var2;
      this.k = var1.readBundle();
   }

   FragmentState(Fragment var1) {
      this.a = var1.getClass().getName();
      this.b = var1.mIndex;
      this.c = var1.mFromLayout;
      this.d = var1.mFragmentId;
      this.e = var1.mContainerId;
      this.f = var1.mTag;
      this.g = var1.mRetainInstance;
      this.h = var1.mDetached;
      this.i = var1.mArguments;
      this.j = var1.mHidden;
   }

   public Fragment a(FragmentHostCallback var1, FragmentContainer var2, Fragment var3, FragmentManagerNonConfig var4, ViewModelStore var5) {
      if (this.l == null) {
         Context var6 = var1.i();
         if (this.i != null) {
            this.i.setClassLoader(var6.getClassLoader());
         }

         if (var2 != null) {
            this.l = var2.a(var6, this.a, this.i);
         } else {
            this.l = Fragment.instantiate(var6, this.a, this.i);
         }

         if (this.k != null) {
            this.k.setClassLoader(var6.getClassLoader());
            this.l.mSavedFragmentState = this.k;
         }

         this.l.setIndex(this.b, var3);
         this.l.mFromLayout = this.c;
         this.l.mRestored = true;
         this.l.mFragmentId = this.d;
         this.l.mContainerId = this.e;
         this.l.mTag = this.f;
         this.l.mRetainInstance = this.g;
         this.l.mDetached = this.h;
         this.l.mHidden = this.j;
         this.l.mFragmentManager = var1.d;
         if (FragmentManagerImpl.a) {
            Log.v("FragmentManager", "Instantiated fragment " + this.l);
         }
      }

      this.l.mChildNonConfig = var4;
      this.l.mViewModelStore = var5;
      return this.l;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      byte var3 = 1;
      var1.writeString(this.a);
      var1.writeInt(this.b);
      byte var4;
      if (this.c) {
         var4 = 1;
      } else {
         var4 = 0;
      }

      var1.writeInt(var4);
      var1.writeInt(this.d);
      var1.writeInt(this.e);
      var1.writeString(this.f);
      if (this.g) {
         var4 = 1;
      } else {
         var4 = 0;
      }

      var1.writeInt(var4);
      if (this.h) {
         var4 = 1;
      } else {
         var4 = 0;
      }

      var1.writeInt(var4);
      var1.writeBundle(this.i);
      if (this.j) {
         var4 = var3;
      } else {
         var4 = 0;
      }

      var1.writeInt(var4);
      var1.writeBundle(this.k);
   }
}
