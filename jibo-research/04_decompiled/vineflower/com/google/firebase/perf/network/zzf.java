package com.google.firebase.perf.network;

import com.google.android.gms.internal.zzevv;
import com.google.android.gms.internal.zzewn;
import java.io.IOException;
import org.apache.http.HttpMessage;
import org.apache.http.HttpResponse;
import org.apache.http.client.ResponseHandler;

public final class zzf<T> implements ResponseHandler<T> {
   private final ResponseHandler<? extends T> a;
   private final zzewn b;
   private final zzevv c;

   public zzf(ResponseHandler<? extends T> var1, zzewn var2, zzevv var3) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
   }

   public final T handleResponse(HttpResponse var1) throws IOException {
      this.c.f(this.b.c());
      this.c.a(var1.getStatusLine().getStatusCode());
      Long var2 = zzh.a((HttpMessage)var1);
      if (var2 != null) {
         this.c.b(var2);
      }

      String var3 = zzh.a(var1);
      if (var3 != null) {
         this.c.c(var3);
      }

      this.c.d();
      return (T)this.a.handleResponse(var1);
   }
}
