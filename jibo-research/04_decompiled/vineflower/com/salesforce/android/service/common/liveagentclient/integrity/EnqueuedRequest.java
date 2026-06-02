package com.salesforce.android.service.common.liveagentclient.integrity;

import com.salesforce.android.service.common.liveagentclient.request.LiveAgentRequest;
import com.salesforce.android.service.common.utilities.control.BasicAsync;
import java.io.IOException;

class EnqueuedRequest<T> {
   private final LiveAgentRequest a;
   private final Class<T> b;
   private final BasicAsync<T> c;
   private int d;

   public EnqueuedRequest(LiveAgentRequest var1, Class<T> var2) {
      this(var1, var2, new BasicAsync<>(), 1);
   }

   EnqueuedRequest(LiveAgentRequest var1, Class<T> var2, BasicAsync<T> var3, int var4) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
      this.d = var4;
   }

   public LiveAgentRequest a() {
      return this.a;
   }

   public Class<T> b() {
      return this.b;
   }

   public BasicAsync<T> c() {
      return this.c;
   }

   public void d() {
      this.d++;
   }

   public void e() {
      this.c.a(new IOException("Unable to send " + this));
   }

   @Override
   public String toString() {
      return String.format("%s on attempt #%s", this.a.getClass().getSimpleName(), this.d);
   }

   static class Factory {
      <T> EnqueuedRequest<T> a(LiveAgentRequest var1, Class<T> var2) {
         return new EnqueuedRequest<>(var1, var2);
      }
   }
}
