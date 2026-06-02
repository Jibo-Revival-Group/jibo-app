package com.firebase.jobdispatcher;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;

public final class GooglePlayDriver implements Driver {
   private final JobValidator a;
   private final Context b;
   private final PendingIntent c;
   private final GooglePlayJobWriter d;
   private final boolean e = true;

   public GooglePlayDriver(Context var1) {
      this.b = var1;
      this.c = PendingIntent.getBroadcast(var1, 0, new Intent(), 0);
      this.d = new GooglePlayJobWriter();
      this.a = new DefaultJobValidator(var1);
   }

   private Intent a(JobParameters var1) {
      Intent var2 = this.c("SCHEDULE_TASK");
      var2.putExtras(this.d.a(var1, var2.getExtras()));
      return var2;
   }

   private Intent c(String var1) {
      Intent var2 = new Intent("com.google.android.gms.gcm.ACTION_SCHEDULE");
      var2.setPackage("com.google.android.gms");
      var2.putExtra("scheduler_action", var1);
      var2.putExtra("app", this.c);
      var2.putExtra("source", 8);
      var2.putExtra("source_version", 1);
      return var2;
   }

   @Override
   public int a(Job var1) {
      GooglePlayReceiver.a(var1);
      this.b.sendBroadcast(this.a((JobParameters)var1));
      return 0;
   }

   @Override
   public int a(String var1) {
      this.b.sendBroadcast(this.b(var1));
      return 0;
   }

   @Override
   public JobValidator a() {
      return this.a;
   }

   protected Intent b(String var1) {
      Intent var2 = this.c("CANCEL_TASK");
      var2.putExtra("tag", var1);
      var2.putExtra("component", new ComponentName(this.b, this.c()));
      return var2;
   }

   @Override
   public boolean b() {
      return true;
   }

   protected Class<GooglePlayReceiver> c() {
      return GooglePlayReceiver.class;
   }
}
