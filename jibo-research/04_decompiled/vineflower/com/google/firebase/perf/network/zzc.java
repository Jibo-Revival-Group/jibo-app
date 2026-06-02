package com.google.firebase.perf.network;

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

public final class zzc extends HttpURLConnection {
   private final zze a;

   zzc(HttpURLConnection var1, zzewn var2, zzevv var3) {
      super(var1.getURL());
      this.a = new zze(var1, var2, var3);
   }

   @Override
   public final void addRequestProperty(String var1, String var2) {
      this.a.a(var1, var2);
   }

   @Override
   public final void connect() throws IOException {
      this.a.a();
   }

   @Override
   public final void disconnect() {
      this.a.b();
   }

   @Override
   public final boolean equals(Object var1) {
      return this.a.equals(var1);
   }

   @Override
   public final boolean getAllowUserInteraction() {
      return this.a.q();
   }

   @Override
   public final int getConnectTimeout() {
      return this.a.r();
   }

   @Override
   public final Object getContent() throws IOException {
      return this.a.c();
   }

   @Override
   public final Object getContent(Class[] var1) throws IOException {
      return this.a.a(var1);
   }

   @Override
   public final String getContentEncoding() {
      return this.a.l();
   }

   @Override
   public final int getContentLength() {
      return this.a.m();
   }

   @Override
   public final long getContentLengthLong() {
      return this.a.n();
   }

   @Override
   public final String getContentType() {
      return this.a.o();
   }

   @Override
   public final long getDate() {
      return this.a.p();
   }

   @Override
   public final boolean getDefaultUseCaches() {
      return this.a.s();
   }

   @Override
   public final boolean getDoInput() {
      return this.a.t();
   }

   @Override
   public final boolean getDoOutput() {
      return this.a.u();
   }

   @Override
   public final InputStream getErrorStream() {
      return this.a.v();
   }

   @Override
   public final long getExpiration() {
      return this.a.j();
   }

   @Override
   public final String getHeaderField(int var1) {
      return this.a.a(var1);
   }

   @Override
   public final String getHeaderField(String var1) {
      return this.a.a(var1);
   }

   @Override
   public final long getHeaderFieldDate(String var1, long var2) {
      return this.a.a(var1, var2);
   }

   @Override
   public final int getHeaderFieldInt(String var1, int var2) {
      return this.a.a(var1, var2);
   }

   @Override
   public final String getHeaderFieldKey(int var1) {
      return this.a.b(var1);
   }

   @Override
   public final long getHeaderFieldLong(String var1, long var2) {
      return this.a.b(var1, var2);
   }

   @Override
   public final Map<String, List<String>> getHeaderFields() {
      return this.a.k();
   }

   @Override
   public final long getIfModifiedSince() {
      return this.a.w();
   }

   @Override
   public final InputStream getInputStream() throws IOException {
      return this.a.d();
   }

   @Override
   public final boolean getInstanceFollowRedirects() {
      return this.a.x();
   }

   @Override
   public final long getLastModified() {
      return this.a.e();
   }

   @Override
   public final OutputStream getOutputStream() throws IOException {
      return this.a.f();
   }

   @Override
   public final Permission getPermission() throws IOException {
      return this.a.g();
   }

   @Override
   public final int getReadTimeout() {
      return this.a.y();
   }

   @Override
   public final String getRequestMethod() {
      return this.a.z();
   }

   @Override
   public final Map<String, List<String>> getRequestProperties() {
      return this.a.A();
   }

   @Override
   public final String getRequestProperty(String var1) {
      return this.a.b(var1);
   }

   @Override
   public final int getResponseCode() throws IOException {
      return this.a.h();
   }

   @Override
   public final String getResponseMessage() throws IOException {
      return this.a.i();
   }

   @Override
   public final URL getURL() {
      return this.a.B();
   }

   @Override
   public final boolean getUseCaches() {
      return this.a.C();
   }

   @Override
   public final int hashCode() {
      return this.a.hashCode();
   }

   @Override
   public final void setAllowUserInteraction(boolean var1) {
      this.a.a(var1);
   }

   @Override
   public final void setChunkedStreamingMode(int var1) {
      this.a.c(var1);
   }

   @Override
   public final void setConnectTimeout(int var1) {
      this.a.d(var1);
   }

   @Override
   public final void setDefaultUseCaches(boolean var1) {
      this.a.b(var1);
   }

   @Override
   public final void setDoInput(boolean var1) {
      this.a.c(var1);
   }

   @Override
   public final void setDoOutput(boolean var1) {
      this.a.d(var1);
   }

   @Override
   public final void setFixedLengthStreamingMode(int var1) {
      this.a.e(var1);
   }

   @Override
   public final void setFixedLengthStreamingMode(long var1) {
      this.a.a(var1);
   }

   @Override
   public final void setIfModifiedSince(long var1) {
      this.a.b(var1);
   }

   @Override
   public final void setInstanceFollowRedirects(boolean var1) {
      this.a.e(var1);
   }

   @Override
   public final void setReadTimeout(int var1) {
      this.a.f(var1);
   }

   @Override
   public final void setRequestMethod(String var1) throws ProtocolException {
      this.a.c(var1);
   }

   @Override
   public final void setRequestProperty(String var1, String var2) {
      this.a.b(var1, var2);
   }

   @Override
   public final void setUseCaches(boolean var1) {
      this.a.f(var1);
   }

   @Override
   public final String toString() {
      return this.a.toString();
   }

   @Override
   public final boolean usingProxy() {
      return this.a.D();
   }
}
