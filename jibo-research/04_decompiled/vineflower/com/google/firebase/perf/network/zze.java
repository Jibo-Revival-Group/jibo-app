package com.google.firebase.perf.network;

import android.util.Log;
import com.google.android.gms.internal.zzevv;
import com.google.android.gms.internal.zzewn;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.security.Permission;
import java.util.List;
import java.util.Map;

final class zze {
   private final HttpURLConnection a;
   private final zzevv b;
   private long c = -1L;
   private long d = -1L;
   private final zzewn e;

   public zze(HttpURLConnection var1, zzewn var2, zzevv var3) {
      this.a = var1;
      this.b = var3;
      this.e = var2;
      this.b.a(this.a.getURL().toString());
   }

   private final void E() {
      if (this.c == -1L) {
         this.e.a();
         this.c = this.e.b();
         this.b.c(this.c);
      }

      String var1 = this.a.getRequestMethod();
      if (var1 != null) {
         this.b.b(var1);
      } else if (this.a.getDoOutput()) {
         this.b.b("POST");
      } else {
         this.b.b("GET");
      }
   }

   public final Map<String, List<String>> A() {
      return this.a.getRequestProperties();
   }

   public final URL B() {
      return this.a.getURL();
   }

   public final boolean C() {
      return this.a.getUseCaches();
   }

   public final boolean D() {
      return this.a.usingProxy();
   }

   public final int a(String var1, int var2) {
      this.E();
      return this.a.getHeaderFieldInt(var1, var2);
   }

   public final long a(String var1, long var2) {
      this.E();
      return this.a.getHeaderFieldDate(var1, var2);
   }

   public final Object a(Class[] var1) throws IOException {
      this.E();
      this.b.a(this.a.getResponseCode());

      try {
         var3 = this.a.getContent(var1);
      } catch (IOException var2) {
         this.b.f(this.e.c());
         zzh.a(this.b);
         throw var2;
      }

      if (var3 instanceof InputStream) {
         this.b.c(this.a.getContentType());
         var3 = new zza((InputStream)var3, this.b, this.e);
      } else {
         this.b.c(this.a.getContentType());
         this.b.b(this.a.getContentLength());
         this.b.f(this.e.c());
         this.b.d();
      }

      return var3;
   }

   public final String a(int var1) {
      this.E();
      return this.a.getHeaderField(var1);
   }

   public final String a(String var1) {
      this.E();
      return this.a.getHeaderField(var1);
   }

   public final void a() throws IOException {
      if (this.c == -1L) {
         this.e.a();
         this.c = this.e.b();
         this.b.c(this.c);
      }

      try {
         this.a.connect();
      } catch (IOException var2) {
         this.b.f(this.e.c());
         zzh.a(this.b);
         throw var2;
      }
   }

   public final void a(long var1) {
      this.a.setFixedLengthStreamingMode(var1);
   }

   public final void a(String var1, String var2) {
      this.a.addRequestProperty(var1, var2);
   }

   public final void a(boolean var1) {
      this.a.setAllowUserInteraction(var1);
   }

   public final long b(String var1, long var2) {
      this.E();
      return this.a.getHeaderFieldLong(var1, var2);
   }

   public final String b(int var1) {
      this.E();
      return this.a.getHeaderFieldKey(var1);
   }

   public final String b(String var1) {
      return this.a.getRequestProperty(var1);
   }

   public final void b() {
      this.b.f(this.e.c());
      this.b.d();
      this.a.disconnect();
   }

   public final void b(long var1) {
      this.a.setIfModifiedSince(var1);
   }

   public final void b(String var1, String var2) {
      this.a.setRequestProperty(var1, var2);
   }

   public final void b(boolean var1) {
      this.a.setDefaultUseCaches(var1);
   }

   public final Object c() throws IOException {
      this.E();
      this.b.a(this.a.getResponseCode());

      Object var1;
      try {
         var1 = this.a.getContent();
      } catch (IOException var2) {
         this.b.f(this.e.c());
         zzh.a(this.b);
         throw var2;
      }

      if (var1 instanceof InputStream) {
         this.b.c(this.a.getContentType());
         var1 = new zza((InputStream)var1, this.b, this.e);
      } else {
         this.b.c(this.a.getContentType());
         this.b.b(this.a.getContentLength());
         this.b.f(this.e.c());
         this.b.d();
      }

      return var1;
   }

   public final void c(int var1) {
      this.a.setChunkedStreamingMode(var1);
   }

   public final void c(String var1) throws ProtocolException {
      this.a.setRequestMethod(var1);
   }

   public final void c(boolean var1) {
      this.a.setDoInput(var1);
   }

   public final InputStream d() throws IOException {
      this.E();
      this.b.a(this.a.getResponseCode());
      this.b.c(this.a.getContentType());

      try {
         return new zza(this.a.getInputStream(), this.b, this.e);
      } catch (IOException var2) {
         this.b.f(this.e.c());
         zzh.a(this.b);
         throw var2;
      }
   }

   public final void d(int var1) {
      this.a.setConnectTimeout(var1);
   }

   public final void d(boolean var1) {
      this.a.setDoOutput(var1);
   }

   public final long e() {
      this.E();
      return this.a.getLastModified();
   }

   public final void e(int var1) {
      this.a.setFixedLengthStreamingMode(var1);
   }

   public final void e(boolean var1) {
      this.a.setInstanceFollowRedirects(var1);
   }

   @Override
   public final boolean equals(Object var1) {
      return this.a.equals(var1);
   }

   public final OutputStream f() throws IOException {
      try {
         return new zzb(this.a.getOutputStream(), this.b, this.e);
      } catch (IOException var2) {
         this.b.f(this.e.c());
         zzh.a(this.b);
         throw var2;
      }
   }

   public final void f(int var1) {
      this.a.setReadTimeout(var1);
   }

   public final void f(boolean var1) {
      this.a.setUseCaches(var1);
   }

   public final Permission g() throws IOException {
      try {
         return this.a.getPermission();
      } catch (IOException var2) {
         this.b.f(this.e.c());
         zzh.a(this.b);
         throw var2;
      }
   }

   public final int h() throws IOException {
      this.E();
      if (this.d == -1L) {
         this.d = this.e.c();
         this.b.e(this.d);
      }

      try {
         return this.a.getResponseCode();
      } catch (IOException var3) {
         this.b.f(this.e.c());
         zzh.a(this.b);
         throw var3;
      }
   }

   @Override
   public final int hashCode() {
      return this.a.hashCode();
   }

   public final String i() throws IOException {
      this.E();
      if (this.d == -1L) {
         this.d = this.e.c();
         this.b.e(this.d);
      }

      try {
         String var1 = this.a.getResponseMessage();
         this.b.a(this.a.getResponseCode());
         return var1;
      } catch (IOException var2) {
         this.b.f(this.e.c());
         zzh.a(this.b);
         throw var2;
      }
   }

   public final long j() {
      this.E();
      return this.a.getExpiration();
   }

   public final Map<String, List<String>> k() {
      this.E();
      return this.a.getHeaderFields();
   }

   public final String l() {
      this.E();
      return this.a.getContentEncoding();
   }

   public final int m() {
      this.E();
      return this.a.getContentLength();
   }

   public final long n() {
      this.E();
      return this.a.getContentLengthLong();
   }

   public final String o() {
      this.E();
      return this.a.getContentType();
   }

   public final long p() {
      this.E();
      return this.a.getDate();
   }

   public final boolean q() {
      return this.a.getAllowUserInteraction();
   }

   public final int r() {
      return this.a.getConnectTimeout();
   }

   public final boolean s() {
      return this.a.getDefaultUseCaches();
   }

   public final boolean t() {
      return this.a.getDoInput();
   }

   @Override
   public final String toString() {
      return this.a.toString();
   }

   public final boolean u() {
      return this.a.getDoOutput();
   }

   public final InputStream v() {
      this.E();

      try {
         this.b.a(this.a.getResponseCode());
      } catch (IOException var2) {
         Log.d("FirebasePerformance", "IOException thrown trying to obtain the response code");
      }

      InputStream var1 = this.a.getErrorStream();
      if (var1 != null) {
         var1 = new zza(var1, this.b, this.e);
      }

      return var1;
   }

   public final long w() {
      return this.a.getIfModifiedSince();
   }

   public final boolean x() {
      return this.a.getInstanceFollowRedirects();
   }

   public final int y() {
      return this.a.getReadTimeout();
   }

   public final String z() {
      return this.a.getRequestMethod();
   }
}
