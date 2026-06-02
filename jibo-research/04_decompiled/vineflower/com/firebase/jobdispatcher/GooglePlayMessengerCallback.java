package com.firebase.jobdispatcher;

import android.os.Bundle;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;

class GooglePlayMessengerCallback implements JobCallback {
   private final Messenger a;
   private final String b;

   GooglePlayMessengerCallback(Messenger var1, String var2) {
      this.a = var1;
      this.b = var2;
   }

   private Message b(int var1) {
      Message var3 = Message.obtain();
      var3.what = 3;
      var3.arg1 = var1;
      Bundle var2 = new Bundle();
      var2.putString("tag", this.b);
      var3.setData(var2);
      return var3;
   }

   @Override
   public void a(int var1) {
      try {
         this.a.send(this.b(var1));
      } catch (RemoteException var3) {
         throw new RuntimeException(var3);
      }
   }
}
