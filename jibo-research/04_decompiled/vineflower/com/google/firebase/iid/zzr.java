package com.google.firebase.iid;

import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.tasks.TaskCompletionSource;

abstract class zzr<T> {
   final int a;
   final TaskCompletionSource<T> b = new TaskCompletionSource<>();
   final int c;
   final Bundle d;

   zzr(int var1, int var2, Bundle var3) {
      this.a = var1;
      this.c = var2;
      this.d = var3;
   }

   abstract void a(Bundle var1);

   final void a(zzs var1) {
      if (Log.isLoggable("MessengerIpcClient", 3)) {
         String var3 = String.valueOf(this);
         String var2 = String.valueOf(var1);
         Log.d(
            "MessengerIpcClient",
            new StringBuilder(String.valueOf(var3).length() + 14 + String.valueOf(var2).length())
               .append("Failing ")
               .append(var3)
               .append(" with ")
               .append(var2)
               .toString()
         );
      }

      this.b.a(var1);
   }

   final void a(T var1) {
      if (Log.isLoggable("MessengerIpcClient", 3)) {
         String var2 = String.valueOf(this);
         String var3 = String.valueOf(var1);
         Log.d(
            "MessengerIpcClient",
            new StringBuilder(String.valueOf(var2).length() + 16 + String.valueOf(var3).length())
               .append("Finishing ")
               .append(var2)
               .append(" with ")
               .append(var3)
               .toString()
         );
      }

      this.b.a((T)var1);
   }

   abstract boolean a();

   @Override
   public String toString() {
      int var1 = this.c;
      int var2 = this.a;
      boolean var3 = this.a();
      return new StringBuilder(55).append("Request { what=").append(var1).append(" id=").append(var2).append(" oneWay=").append(var3).append("}").toString();
   }
}
