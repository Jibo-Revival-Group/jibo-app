package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Result;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public interface zzcc {
   <A extends Api.zzb, R extends Result, T extends zzm<R, A>> T a(T var1);

   void a();

   void a(String var1, FileDescriptor var2, PrintWriter var3, String[] var4);

   boolean a(zzcu var1);

   ConnectionResult b();

   <A extends Api.zzb, T extends zzm<? extends Result, A>> T b(T var1);

   void c();

   boolean d();

   void f();

   void g();
}
