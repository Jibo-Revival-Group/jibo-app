package com.google.firebase.iid;

import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.iid.MessengerCompat;

final class zzp {
   private final Messenger a;
   private final MessengerCompat b;

   zzp(IBinder var1) throws RemoteException {
      String var2 = var1.getInterfaceDescriptor();
      if ("android.os.IMessenger".equals(var2)) {
         this.a = new Messenger(var1);
         this.b = null;
      } else {
         if (!"com.google.android.gms.iid.IMessengerCompat".equals(var2)) {
            String var3 = String.valueOf(var2);
            String var4;
            if (var3.length() != 0) {
               var4 = "Invalid interface descriptor: ".concat(var3);
            } else {
               var4 = new String("Invalid interface descriptor: ");
            }

            Log.w("MessengerIpcClient", var4);
            throw new RemoteException();
         }

         this.b = new MessengerCompat(var1);
         this.a = null;
      }
   }

   final void a(Message var1) throws RemoteException {
      if (this.a != null) {
         this.a.send(var1);
      } else {
         if (this.b == null) {
            throw new IllegalStateException("Both messengers are null");
         }

         this.b.a(var1);
      }
   }
}
