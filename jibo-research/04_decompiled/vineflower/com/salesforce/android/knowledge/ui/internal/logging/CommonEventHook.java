package com.salesforce.android.knowledge.ui.internal.logging;

import android.content.Context;
import com.salesforce.android.service.common.liveagentlogging.event.BackgroundedEvent;
import com.salesforce.android.service.common.liveagentlogging.event.BaseEvent;
import com.salesforce.android.service.common.liveagentlogging.event.ConnectivityEvent;
import com.salesforce.android.service.common.liveagentlogging.event.OrientationEvent;
import com.salesforce.android.service.common.utilities.activity.ActivityTracker;
import com.salesforce.android.service.common.utilities.internal.android.BackgroundTracker;
import com.salesforce.android.service.common.utilities.internal.connectivity.ConnectionInfo;
import com.salesforce.android.service.common.utilities.internal.connectivity.ConnectivityState;
import com.salesforce.android.service.common.utilities.internal.connectivity.ConnectivityTracker;
import com.salesforce.android.service.common.utilities.internal.device.OrientationTracker;
import com.salesforce.android.service.common.utilities.spatial.Orientation;

class CommonEventHook implements BackgroundTracker.Listener, ConnectivityTracker.Listener, OrientationTracker.Listener {
   private CommonEventHook.Listener a;
   private final String b;
   private final BackgroundTracker c;
   private OrientationTracker d;
   private ConnectivityTracker e;

   CommonEventHook(BackgroundTracker var1, String var2) {
      this.c = var1;
      this.b = var2;
   }

   static CommonEventHook a(ActivityTracker var0, String var1) {
      return new CommonEventHook(BackgroundTracker.a(var0), var1);
   }

   private void a(BaseEvent var1) {
      if (this.a != null) {
         this.a.b(var1);
      }
   }

   void a() {
      this.c.b();
      if (this.d != null) {
         this.d.a();
         this.d = null;
      }

      if (this.e != null) {
         this.e.c();
         this.e = null;
      }
   }

   void a(Context var1) {
      this.d = new OrientationTracker.Builder().a(var1).a(this).a();
      this.e = new ConnectivityTracker.Builder().a(var1).a(this).a();
      this.c.a(this);
      this.c.a();
   }

   void a(CommonEventHook.Listener var1) {
      this.a = var1;
   }

   @Override
   public void a(ConnectionInfo var1, ConnectivityState var2, ConnectivityState var3) {
      String var5 = var1.b().name();
      String var4 = var1.c().getRadioName();
      this.a(new ConnectivityEvent("KB", this.b, var5, var4));
   }

   @Override
   public void a(Orientation var1) {
      this.a(new OrientationEvent("KB", this.b, var1));
   }

   @Override
   public void a(boolean var1) {
      this.a(new BackgroundedEvent("KB", this.b, var1));
   }

   interface Listener {
      void b(BaseEvent var1);
   }
}
