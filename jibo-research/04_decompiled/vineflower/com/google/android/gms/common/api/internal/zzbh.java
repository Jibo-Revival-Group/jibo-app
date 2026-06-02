package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Result;

public interface zzbh {
   <A extends Api.zzb, R extends Result, T extends zzm<R, A>> T a(T var1);

   void a();

   void a(int var1);

   void a(Bundle var1);

   void a(ConnectionResult var1, Api<?> var2, boolean var3);

   <A extends Api.zzb, T extends zzm<? extends Result, A>> T b(T var1);

   boolean b();

   void c();
}
