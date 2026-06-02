package com.facebook.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;

public abstract class PlatformServiceClient implements ServiceConnection {
   private final String applicationId;
   private final Context context;
   private final Handler handler;
   private PlatformServiceClient.CompletedListener listener;
   private final int protocolVersion;
   private int replyMessage;
   private int requestMessage;
   private boolean running;
   private Messenger sender;

   public PlatformServiceClient(Context var1, int var2, int var3, int var4, String var5) {
      Context var6 = var1.getApplicationContext();
      if (var6 != null) {
         var1 = var6;
      }

      this.context = var1;
      this.requestMessage = var2;
      this.replyMessage = var3;
      this.applicationId = var5;
      this.protocolVersion = var4;
      this.handler = new Handler(this) {
         final PlatformServiceClient this$0;

         {
            this.this$0 = var1;
         }

         public void handleMessage(Message var1) {
            this.this$0.handleMessage(var1);
         }
      };
   }

   private void callback(Bundle var1) {
      if (this.running) {
         this.running = false;
         PlatformServiceClient.CompletedListener var2 = this.listener;
         if (var2 != null) {
            var2.completed(var1);
         }
      }
   }

   private void sendMessage() {
      Bundle var2 = new Bundle();
      var2.putString("com.facebook.platform.extra.APPLICATION_ID", this.applicationId);
      this.populateRequestBundle(var2);
      Message var1 = Message.obtain(null, this.requestMessage);
      var1.arg1 = this.protocolVersion;
      var1.setData(var2);
      var1.replyTo = new Messenger(this.handler);

      try {
         this.sender.send(var1);
      } catch (RemoteException var3) {
         this.callback(null);
      }
   }

   public void cancel() {
      this.running = false;
   }

   protected Context getContext() {
      return this.context;
   }

   protected void handleMessage(Message var1) {
      if (var1.what == this.replyMessage) {
         Bundle var3 = var1.getData();
         if (var3.getString("com.facebook.platform.status.ERROR_TYPE") != null) {
            this.callback(null);
         } else {
            this.callback(var3);
         }

         try {
            this.context.unbindService(this);
         } catch (IllegalArgumentException var2) {
         }
      }
   }

   public void onServiceConnected(ComponentName var1, IBinder var2) {
      this.sender = new Messenger(var2);
      this.sendMessage();
   }

   public void onServiceDisconnected(ComponentName var1) {
      this.sender = null;

      try {
         this.context.unbindService(this);
      } catch (IllegalArgumentException var2) {
      }

      this.callback(null);
   }

   protected abstract void populateRequestBundle(Bundle var1);

   public void setCompletedListener(PlatformServiceClient.CompletedListener var1) {
      this.listener = var1;
   }

   public boolean start() {
      boolean var2 = false;
      boolean var1;
      if (this.running) {
         var1 = var2;
      } else {
         var1 = var2;
         if (NativeProtocol.getLatestAvailableProtocolVersionForService(this.protocolVersion) != -1) {
            Intent var3 = NativeProtocol.createPlatformServiceIntent(this.context);
            var1 = var2;
            if (var3 != null) {
               this.running = true;
               this.context.bindService(var3, this, 1);
               var1 = true;
            }
         }
      }

      return var1;
   }

   public interface CompletedListener {
      void completed(Bundle var1);
   }
}
