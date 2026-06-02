package com.google.android.gms.gcm;

import android.os.Bundle;
import android.os.Parcel;
import android.util.Log;
import com.google.android.gms.common.internal.ReflectedParcelable;

public class Task implements ReflectedParcelable {
   private final String a;
   private final String b;
   private final boolean c;
   private final boolean d;
   private final int e;
   private final boolean f;
   private final boolean g;
   private final zzi h;
   private final Bundle i;

   @Deprecated
   Task(Parcel var1) {
      boolean var3 = true;
      super();
      Log.e("Task", "Constructing a Task object using a parcel.");
      this.a = var1.readString();
      this.b = var1.readString();
      boolean var2;
      if (var1.readInt() == 1) {
         var2 = true;
      } else {
         var2 = false;
      }

      this.c = var2;
      if (var1.readInt() == 1) {
         var2 = var3;
      } else {
         var2 = false;
      }

      this.d = var2;
      this.e = 2;
      this.f = false;
      this.g = false;
      this.h = zzi.a;
      this.i = null;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      byte var3 = 1;
      var1.writeString(this.a);
      var1.writeString(this.b);
      byte var4;
      if (this.c) {
         var4 = 1;
      } else {
         var4 = 0;
      }

      var1.writeInt(var4);
      if (this.d) {
         var4 = var3;
      } else {
         var4 = 0;
      }

      var1.writeInt(var4);
   }
}
