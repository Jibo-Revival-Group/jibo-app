package com.google.firebase.perf.network;

import com.google.android.gms.internal.zzevv;
import com.google.android.gms.internal.zzevz;
import com.google.android.gms.internal.zzewn;
import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;

public final class zzg implements Callback {
   private final Callback a;
   private final zzevv b;
   private final long c;
   private final zzewn d;

   public zzg(Callback var1, zzevz var2, zzewn var3, long var4) {
      this.a = var1;
      this.b = zzevv.a(var2);
      this.c = var4;
      this.d = var3;
   }

   @Override
   public final void onFailure(Call var1, IOException var2) {
      Request var4 = var1.a();
      if (var4 != null) {
         HttpUrl var3 = var4.a();
         if (var3 != null) {
            this.b.a(var3.a().toString());
         }

         if (var4.b() != null) {
            this.b.b(var4.b());
         }
      }

      this.b.c(this.c);
      this.b.f(this.d.c());
      zzh.a(this.b);
      this.a.onFailure(var1, var2);
   }

   @Override
   public final void onResponse(Call var1, Response var2) throws IOException {
      long var3 = this.d.c();
      FirebasePerfOkHttpClient.a(var2, this.b, this.c, var3);
      this.a.onResponse(var1, var2);
   }
}
