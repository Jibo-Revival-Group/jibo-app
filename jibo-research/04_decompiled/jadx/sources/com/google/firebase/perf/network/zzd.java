package com.google.firebase.perf.network;

import com.google.android.gms.internal.zzevv;
import com.google.android.gms.internal.zzewn;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ProtocolException;
import java.net.URL;
import java.security.Permission;
import java.security.Principal;
import java.security.cert.Certificate;
import java.util.List;
import java.util.Map;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocketFactory;

/* JADX INFO: loaded from: classes.dex */
public final class zzd extends HttpsURLConnection {

    /* JADX INFO: renamed from: a */
    private final zze f8766a;

    /* JADX INFO: renamed from: b */
    private final HttpsURLConnection f8767b;

    zzd(HttpsURLConnection httpsURLConnection, zzewn zzewnVar, zzevv zzevvVar) {
        super(httpsURLConnection.getURL());
        this.f8767b = httpsURLConnection;
        this.f8766a = new zze(httpsURLConnection, zzewnVar, zzevvVar);
    }

    @Override // java.net.URLConnection
    public final void addRequestProperty(String str, String str2) {
        this.f8766a.m9286a(str, str2);
    }

    @Override // java.net.URLConnection
    public final void connect() throws IOException {
        this.f8766a.m9284a();
    }

    @Override // java.net.HttpURLConnection
    public final void disconnect() {
        this.f8766a.m9291b();
    }

    public final boolean equals(Object obj) {
        return this.f8766a.equals(obj);
    }

    @Override // java.net.URLConnection
    public final boolean getAllowUserInteraction() {
        return this.f8766a.m9318q();
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public final String getCipherSuite() {
        return this.f8767b.getCipherSuite();
    }

    @Override // java.net.URLConnection
    public final int getConnectTimeout() {
        return this.f8766a.m9319r();
    }

    @Override // java.net.URLConnection
    public final Object getContent() throws IOException {
        return this.f8766a.m9295c();
    }

    @Override // java.net.URLConnection
    public final Object getContent(Class[] clsArr) throws IOException {
        return this.f8766a.m9281a(clsArr);
    }

    @Override // java.net.URLConnection
    public final String getContentEncoding() {
        return this.f8766a.m9313l();
    }

    @Override // java.net.URLConnection
    public final int getContentLength() {
        return this.f8766a.m9314m();
    }

    @Override // java.net.URLConnection
    public final long getContentLengthLong() {
        return this.f8766a.m9315n();
    }

    @Override // java.net.URLConnection
    public final String getContentType() {
        return this.f8766a.m9316o();
    }

    @Override // java.net.URLConnection
    public final long getDate() {
        return this.f8766a.m9317p();
    }

    @Override // java.net.URLConnection
    public final boolean getDefaultUseCaches() {
        return this.f8766a.m9320s();
    }

    @Override // java.net.URLConnection
    public final boolean getDoInput() {
        return this.f8766a.m9321t();
    }

    @Override // java.net.URLConnection
    public final boolean getDoOutput() {
        return this.f8766a.m9322u();
    }

    @Override // java.net.HttpURLConnection
    public final InputStream getErrorStream() {
        return this.f8766a.m9323v();
    }

    @Override // java.net.URLConnection
    public final long getExpiration() {
        return this.f8766a.m9311j();
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public final String getHeaderField(int i) {
        return this.f8766a.m9282a(i);
    }

    @Override // java.net.URLConnection
    public final String getHeaderField(String str) {
        return this.f8766a.m9283a(str);
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public final long getHeaderFieldDate(String str, long j) {
        return this.f8766a.m9280a(str, j);
    }

    @Override // java.net.URLConnection
    public final int getHeaderFieldInt(String str, int i) {
        return this.f8766a.m9279a(str, i);
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public final String getHeaderFieldKey(int i) {
        return this.f8766a.m9289b(i);
    }

    @Override // java.net.URLConnection
    public final long getHeaderFieldLong(String str, long j) {
        return this.f8766a.m9288b(str, j);
    }

    @Override // java.net.URLConnection
    public final Map<String, List<String>> getHeaderFields() {
        return this.f8766a.m9312k();
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public final HostnameVerifier getHostnameVerifier() {
        return this.f8767b.getHostnameVerifier();
    }

    @Override // java.net.URLConnection
    public final long getIfModifiedSince() {
        return this.f8766a.m9324w();
    }

    @Override // java.net.URLConnection
    public final InputStream getInputStream() throws IOException {
        return this.f8766a.m9299d();
    }

    @Override // java.net.HttpURLConnection
    public final boolean getInstanceFollowRedirects() {
        return this.f8766a.m9325x();
    }

    @Override // java.net.URLConnection
    public final long getLastModified() {
        return this.f8766a.m9302e();
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public final Certificate[] getLocalCertificates() {
        return this.f8767b.getLocalCertificates();
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public final Principal getLocalPrincipal() {
        return this.f8767b.getLocalPrincipal();
    }

    @Override // java.net.URLConnection
    public final OutputStream getOutputStream() throws IOException {
        return this.f8766a.m9305f();
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public final Principal getPeerPrincipal() throws SSLPeerUnverifiedException {
        return this.f8767b.getPeerPrincipal();
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public final Permission getPermission() throws IOException {
        return this.f8766a.m9308g();
    }

    @Override // java.net.URLConnection
    public final int getReadTimeout() {
        return this.f8766a.m9326y();
    }

    @Override // java.net.HttpURLConnection
    public final String getRequestMethod() {
        return this.f8766a.m9327z();
    }

    @Override // java.net.URLConnection
    public final Map<String, List<String>> getRequestProperties() {
        return this.f8766a.m9275A();
    }

    @Override // java.net.URLConnection
    public final String getRequestProperty(String str) {
        return this.f8766a.m9290b(str);
    }

    @Override // java.net.HttpURLConnection
    public final int getResponseCode() throws IOException {
        return this.f8766a.m9309h();
    }

    @Override // java.net.HttpURLConnection
    public final String getResponseMessage() throws IOException {
        return this.f8766a.m9310i();
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public final SSLSocketFactory getSSLSocketFactory() {
        return this.f8767b.getSSLSocketFactory();
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public final Certificate[] getServerCertificates() throws SSLPeerUnverifiedException {
        return this.f8767b.getServerCertificates();
    }

    @Override // java.net.URLConnection
    public final URL getURL() {
        return this.f8766a.m9276B();
    }

    @Override // java.net.URLConnection
    public final boolean getUseCaches() {
        return this.f8766a.m9277C();
    }

    public final int hashCode() {
        return this.f8766a.hashCode();
    }

    @Override // java.net.URLConnection
    public final void setAllowUserInteraction(boolean z) {
        this.f8766a.m9287a(z);
    }

    @Override // java.net.HttpURLConnection
    public final void setChunkedStreamingMode(int i) {
        this.f8766a.m9296c(i);
    }

    @Override // java.net.URLConnection
    public final void setConnectTimeout(int i) {
        this.f8766a.m9300d(i);
    }

    @Override // java.net.URLConnection
    public final void setDefaultUseCaches(boolean z) {
        this.f8766a.m9294b(z);
    }

    @Override // java.net.URLConnection
    public final void setDoInput(boolean z) {
        this.f8766a.m9298c(z);
    }

    @Override // java.net.URLConnection
    public final void setDoOutput(boolean z) {
        this.f8766a.m9301d(z);
    }

    @Override // java.net.HttpURLConnection
    public final void setFixedLengthStreamingMode(int i) {
        this.f8766a.m9303e(i);
    }

    @Override // java.net.HttpURLConnection
    public final void setFixedLengthStreamingMode(long j) {
        this.f8766a.m9285a(j);
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public final void setHostnameVerifier(HostnameVerifier hostnameVerifier) {
        this.f8767b.setHostnameVerifier(hostnameVerifier);
    }

    @Override // java.net.URLConnection
    public final void setIfModifiedSince(long j) {
        this.f8766a.m9292b(j);
    }

    @Override // java.net.HttpURLConnection
    public final void setInstanceFollowRedirects(boolean z) {
        this.f8766a.m9304e(z);
    }

    @Override // java.net.URLConnection
    public final void setReadTimeout(int i) {
        this.f8766a.m9306f(i);
    }

    @Override // java.net.HttpURLConnection
    public final void setRequestMethod(String str) throws ProtocolException {
        this.f8766a.m9297c(str);
    }

    @Override // java.net.URLConnection
    public final void setRequestProperty(String str, String str2) {
        this.f8766a.m9293b(str, str2);
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public final void setSSLSocketFactory(SSLSocketFactory sSLSocketFactory) {
        this.f8767b.setSSLSocketFactory(sSLSocketFactory);
    }

    @Override // java.net.URLConnection
    public final void setUseCaches(boolean z) {
        this.f8766a.m9307f(z);
    }

    @Override // java.net.URLConnection
    public final String toString() {
        return this.f8766a.toString();
    }

    @Override // java.net.HttpURLConnection
    public final boolean usingProxy() {
        return this.f8766a.m9278D();
    }
}
