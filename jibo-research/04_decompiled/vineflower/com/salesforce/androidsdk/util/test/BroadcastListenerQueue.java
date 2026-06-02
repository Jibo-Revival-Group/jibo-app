package com.salesforce.androidsdk.util.test;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BroadcastListenerQueue extends BroadcastReceiver {
   private BlockingQueue<Intent> a = new ArrayBlockingQueue<>(10);

   public void onReceive(Context var1, Intent var2) {
      this.a.offer(var2);
   }
}
