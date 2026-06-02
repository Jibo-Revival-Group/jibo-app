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

/* JADX INFO: loaded from: classes.dex */
public final class zzc extends HttpURLConnection {

    /* JADX INFO: renamed from: a */
    private final zze f8765a;

    zzc(HttpURLConnection httpURLConnection, zzewn zzewnVar, zzevv zzevvVar) {
        super(httpURLConnection.getURL());
        this.f8765a = new zze(httpURLConnection, zzewnVar, zzevvVar);
    }

    @Override // java.net.URLConnection
    public final void addRequestProperty(String str, String str2) {
        this.f8765a.m9286a(str, str2);
    }

    @Override // java.net.URLConnection
    public final void connect() throws IOException {
        this.f8765a.m9284a();
    }

    @Override // java.net.HttpURLConnection
    public final void disconnect() {
        this.f8765a.m9291b();
    }

    public final boolean equals(Object obj) {
        return this.f8765a.equals(obj);
    }

    @Override // java.net.URLConnection
    public final boolean getAllowUserInteraction() {
        return this.f8765a.m9318q();
    }

    @Override // java.net.URLConnection
    public final int getConnectTimeout() {
        return this.f8765a.m9319r();
    }

    @Override // java.net.URLConnection
    public final Object getContent() throws IOException {
        return this.f8765a.m9295c();
    }

    @Override // java.net.URLConnection
    public final Object getContent(Class[] clsArr) throws IOException {
        return this.f8765a.m9281a(clsArr);
    }

    @Override // java.net.URLConnection
    public final String getContentEncoding() {
        return this.f8765a.m9313l();
    }

    @Override // java.net.URLConnection
    public final int getContentLength() {
        return this.f8765a.m9314m();
    }

    @Override // java.net.URLConnection
    public final long getContentLengthLong() {
        return this.f8765a.m9315n();
    }

    @Override // java.net.URLConnection
    public final String getContentType() {
        return this.f8765a.m9316o();
    }

    @Override // java.net.URLConnection
    public final long getDate() {
        return this.f8765a.m9317p();
    }

    @Override // java.net.URLConnection
    public final boolean getDefaultUseCaches() {
        return this.f8765a.m9320s();
    }

    @Override // java.net.URLConnection
    public final boolean getDoInput() {
        return this.f8765a.m9321t();
    }

    @Override // java.net.URLConnection
    public final boolean getDoOutput() {
        return this.f8765a.m9322u();
    }

    @Override // java.net.HttpURLConnection
    public final InputStream getErrorStream() {
        return this.f8765a.m9323v();
    }

    @Override // java.net.URLConnection
    public final long getExpiration() {
        return this.f8765a.m9311j();
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public final String getHeaderField(int i) {
        return this.f8765a.m9282a(i);
    }

    @Override // java.net.URLConnection
    public final String getHeaderField(String str) {
        return this.f8765a.m9283a(str);
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public final long getHeaderFieldDate(String str, long j) {
        return this.f8765a.m9280a(str, j);
    }

    @Override // java.net.URLConnection
    public final int getHeaderFieldInt(String str, int i) {
        return this.f8765a.m9279a(str, i);
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public final String getHeaderFieldKey(int i) {
        return this.f8765a.m9289b(i);
    }

    @Override // java.net.URLConnection
    public final long getHeaderFieldLong(String str, long j) {
        return this.f8765a.m9288b(str, j);
    }

    @Override // java.net.URLConnection
    public final Map<String, List<String>> getHeaderFields() {
        return this.f8765a.m9312k();
    }

    @Override // java.net.URLConnection
    public final long getIfModifiedSince() {
        return this.f8765a.m9324w();
    }

    @Override // java.net.URLConnection
    public final InputStream getInputStream() throws IOException {
        return this.f8765a.m9299d();
    }

    @Override // java.net.HttpURLConnection
    public final boolean getInstanceFollowRedirects() {
        return this.f8765a.m9325x();
    }

    @Override // java.net.URLConnection
    public final long getLastModified() {
        return this.f8765a.m9302e();
    }

    @Override // java.net.URLConnection
    public final OutputStream getOutputStream() throws IOException {
        return this.f8765a.m9305f();
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public final Permission getPermission() throws IOException {
        return this.f8765a.m9308g();
    }

    @Override // java.net.URLConnection
    public final int getReadTimeout() {
        return this.f8765a.m9326y();
    }

    @Override // java.net.HttpURLConnection
    public final String getRequestMethod() {
        return this.f8765a.m9327z();
    }

    @Override // java.net.URLConnection
    public final Map<String, List<String>> getRequestProperties() {
        return this.f8765a.m9275A();
    }

    @Override // java.net.URLConnection
    public final String getRequestProperty(String str) {
        return this.f8765a.m9290b(str);
    }

    @Override // java.net.HttpURLConnection
    public final int getResponseCode() throws IOException {
        return this.f8765a.m9309h();
    }

    @Override // java.net.HttpURLConnection
    public final String getResponseMessage() throws IOException {
        return this.f8765a.m9310i();
    }

    @Override // java.net.URLConnection
    public final URL getURL() {
        return this.f8765a.m9276B();
    }

    @Override // java.net.URLConnection
    public final boolean getUseCaches() {
        return this.f8765a.m9277C();
    }

    public final int hashCode() {
        return this.f8765a.hashCode();
    }

    @Override // java.net.URLConnection
    public final void setAllowUserInteraction(boolean z) {
        this.f8765a.m9287a(z);
    }

    @Override // java.net.HttpURLConnection
    public final void setChunkedStreamingMode(int i) {
        this.f8765a.m9296c(i);
    }

    @Override // java.net.URLConnection
    public final void setConnectTimeout(int i) {
        this.f8765a.m9300d(i);
    }

    @Override // java.net.URLConnection
    public final void setDefaultUseCaches(boolean z) {
        this.f8765a.m9294b(z);
    }

    @Override // java.net.URLConnection
    public final void setDoInput(boolean z) {
        this.f8765a.m9298c(z);
    }

    @Override // java.net.URLConnection
    public final void setDoOutput(boolean z) {
        this.f8765a.m9301d(z);
    }

    @Override // java.net.HttpURLConnection
    public final void setFixedLengthStreamingMode(int i) {
        this.f8765a.m9303e(i);
    }

    @Override // java.net.HttpURLConnection
    public final void setFixedLengthStreamingMode(long j) {
        this.f8765a.m9285a(j);
    }

    @Override // java.net.URLConnection
    public final void setIfModifiedSince(long j) {
        this.f8765a.m9292b(j);
    }

    @Override // java.net.HttpURLConnection
    public final void setInstanceFollowRedirects(boolean z) {
        this.f8765a.m9304e(z);
    }

    @Override // java.net.URLConnection
    public final void setReadTimeout(int i) {
        this.f8765a.m9306f(i);
    }

    @Override // java.net.HttpURLConnection
    public final void setRequestMethod(String str) throws ProtocolException {
        this.f8765a.m9297c(str);
    }

    @Override // java.net.URLConnection
    public final void setRequestProperty(String str, String str2) {
        this.f8765a.m9293b(str, str2);
    }

    @Override // java.net.URLConnection
    public final void setUseCaches(boolean z) {
        this.f8765a.m9307f(z);
    }

    @Override // java.net.URLConnection
    public final String toString() {
        return this.f8765a.toString();
    }

    @Override // java.net.HttpURLConnection
    public final boolean usingProxy() {
        return this.f8765a.m9278D();
    }
}
