package com.firebase.jobdispatcher;

import android.annotation.TargetApi;
import android.app.AppOpsManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.util.Log;

@TargetApi(21)
class GooglePlayMessageHandler extends Handler {
   private final GooglePlayReceiver a;

   public GooglePlayMessageHandler(Looper var1, GooglePlayReceiver var2) {
      super(var1);
      this.a = var2;
   }

   private void a(Message var1) {
      Bundle var2 = var1.getData();
      Messenger var4 = var1.replyTo;
      String var3 = var2.getString("tag");
      if (var4 != null && var3 != null) {
         GooglePlayMessengerCallback var5 = new GooglePlayMessengerCallback(var4, var3);
         JobInvocation var6 = this.a.a(var5, var2);
         this.a.a().a(var6);
      } else if (Log.isLoggable("FJD.GooglePlayReceiver", 3)) {
         Log.d("FJD.GooglePlayReceiver", "Invalid start execution message.");
      }
   }

   private void b(Message var1) {
      JobInvocation.Builder var2 = GooglePlayReceiver.b().b(var1.getData());
      if (var2 == null) {
         if (Log.isLoggable("FJD.GooglePlayReceiver", 3)) {
            Log.d("FJD.GooglePlayReceiver", "Invalid stop execution message.");
         }
      } else {
         ExecutionDelegator.a(var2.a(), true);
      }
   }

   public void handleMessage(Message var1) {
      if (var1 != null) {
         AppOpsManager var2 = (AppOpsManager)this.a.getApplicationContext().getSystemService("appops");

         try {
            var2.checkPackage(var1.sendingUid, "com.google.android.gms");
         } catch (SecurityException var3) {
            Log.e("FJD.GooglePlayReceiver", "Message was not sent from GCM.");
            return;
         }

         switch (var1.what) {
            case 1:
               this.a(var1);
               break;
            case 2:
               this.b(var1);
               break;
            case 3:
            default:
               Log.e("FJD.GooglePlayReceiver", "Unrecognized message received: " + var1);
            case 4:
         }
      }
   }
}
