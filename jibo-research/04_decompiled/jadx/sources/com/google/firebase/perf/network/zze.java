package com.google.firebase.perf.network;

import android.util.Log;
import com.google.android.gms.internal.zzevv;
import com.google.android.gms.internal.zzewn;
import com.google.api.client.http.HttpMethods;
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
final class zze {

    /* JADX INFO: renamed from: a */
    private final HttpURLConnection f8768a;

    /* JADX INFO: renamed from: b */
    private final zzevv f8769b;

    /* JADX INFO: renamed from: c */
    private long f8770c = -1;

    /* JADX INFO: renamed from: d */
    private long f8771d = -1;

    /* JADX INFO: renamed from: e */
    private final zzewn f8772e;

    public zze(HttpURLConnection httpURLConnection, zzewn zzewnVar, zzevv zzevvVar) {
        this.f8768a = httpURLConnection;
        this.f8769b = zzevvVar;
        this.f8772e = zzewnVar;
        this.f8769b.m8532a(this.f8768a.getURL().toString());
    }

    /* JADX INFO: renamed from: E */
    private final void m9274E() {
        if (this.f8770c == -1) {
            this.f8772e.m8600a();
            this.f8770c = this.f8772e.m8601b();
            this.f8769b.m8538c(this.f8770c);
        }
        String requestMethod = this.f8768a.getRequestMethod();
        if (requestMethod != null) {
            this.f8769b.m8536b(requestMethod);
        } else if (this.f8768a.getDoOutput()) {
            this.f8769b.m8536b(HttpMethods.POST);
        } else {
            this.f8769b.m8536b(HttpMethods.GET);
        }
    }

    /* JADX INFO: renamed from: A */
    public final Map<String, List<String>> m9275A() {
        return this.f8768a.getRequestProperties();
    }

    /* JADX INFO: renamed from: B */
    public final URL m9276B() {
        return this.f8768a.getURL();
    }

    /* JADX INFO: renamed from: C */
    public final boolean m9277C() {
        return this.f8768a.getUseCaches();
    }

    /* JADX INFO: renamed from: D */
    public final boolean m9278D() {
        return this.f8768a.usingProxy();
    }

    /* JADX INFO: renamed from: a */
    public final int m9279a(String str, int i) {
        m9274E();
        return this.f8768a.getHeaderFieldInt(str, i);
    }

    /* JADX INFO: renamed from: a */
    public final long m9280a(String str, long j) {
        m9274E();
        return this.f8768a.getHeaderFieldDate(str, j);
    }

    /* JADX INFO: renamed from: a */
    public final Object m9281a(Class[] clsArr) throws IOException {
        m9274E();
        this.f8769b.m8530a(this.f8768a.getResponseCode());
        try {
            Object content = this.f8768a.getContent(clsArr);
            if (content instanceof InputStream) {
                this.f8769b.m8539c(this.f8768a.getContentType());
                return new zza((InputStream) content, this.f8769b, this.f8772e);
            }
            this.f8769b.m8539c(this.f8768a.getContentType());
            this.f8769b.m8535b(this.f8768a.getContentLength());
            this.f8769b.m8543f(this.f8772e.m8602c());
            this.f8769b.m8541d();
            return content;
        } catch (IOException e) {
            this.f8769b.m8543f(this.f8772e.m8602c());
            zzh.m9330a(this.f8769b);
            throw e;
        }
    }

    /* JADX INFO: renamed from: a */
    public final String m9282a(int i) {
        m9274E();
        return this.f8768a.getHeaderField(i);
    }

    /* JADX INFO: renamed from: a */
    public final String m9283a(String str) {
        m9274E();
        return this.f8768a.getHeaderField(str);
    }

    /* JADX INFO: renamed from: a */
    public final void m9284a() throws IOException {
        if (this.f8770c == -1) {
            this.f8772e.m8600a();
            this.f8770c = this.f8772e.m8601b();
            this.f8769b.m8538c(this.f8770c);
        }
        try {
            this.f8768a.connect();
        } catch (IOException e) {
            this.f8769b.m8543f(this.f8772e.m8602c());
            zzh.m9330a(this.f8769b);
            throw e;
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m9285a(long j) {
        this.f8768a.setFixedLengthStreamingMode(j);
    }

    /* JADX INFO: renamed from: a */
    public final void m9286a(String str, String str2) {
        this.f8768a.addRequestProperty(str, str2);
    }

    /* JADX INFO: renamed from: a */
    public final void m9287a(boolean z) {
        this.f8768a.setAllowUserInteraction(z);
    }

    /* JADX INFO: renamed from: b */
    public final long m9288b(String str, long j) {
        m9274E();
        return this.f8768a.getHeaderFieldLong(str, j);
    }

    /* JADX INFO: renamed from: b */
    public final String m9289b(int i) {
        m9274E();
        return this.f8768a.getHeaderFieldKey(i);
    }

    /* JADX INFO: renamed from: b */
    public final String m9290b(String str) {
        return this.f8768a.getRequestProperty(str);
    }

    /* JADX INFO: renamed from: b */
    public final void m9291b() {
        this.f8769b.m8543f(this.f8772e.m8602c());
        this.f8769b.m8541d();
        this.f8768a.disconnect();
    }

    /* JADX INFO: renamed from: b */
    public final void m9292b(long j) {
        this.f8768a.setIfModifiedSince(j);
    }

    /* JADX INFO: renamed from: b */
    public final void m9293b(String str, String str2) {
        this.f8768a.setRequestProperty(str, str2);
    }

    /* JADX INFO: renamed from: b */
    public final void m9294b(boolean z) {
        this.f8768a.setDefaultUseCaches(z);
    }

    /* JADX INFO: renamed from: c */
    public final Object m9295c() throws IOException {
        m9274E();
        this.f8769b.m8530a(this.f8768a.getResponseCode());
        try {
            Object content = this.f8768a.getContent();
            if (content instanceof InputStream) {
                this.f8769b.m8539c(this.f8768a.getContentType());
                return new zza((InputStream) content, this.f8769b, this.f8772e);
            }
            this.f8769b.m8539c(this.f8768a.getContentType());
            this.f8769b.m8535b(this.f8768a.getContentLength());
            this.f8769b.m8543f(this.f8772e.m8602c());
            this.f8769b.m8541d();
            return content;
        } catch (IOException e) {
            this.f8769b.m8543f(this.f8772e.m8602c());
            zzh.m9330a(this.f8769b);
            throw e;
        }
    }

    /* JADX INFO: renamed from: c */
    public final void m9296c(int i) {
        this.f8768a.setChunkedStreamingMode(i);
    }

    /* JADX INFO: renamed from: c */
    public final void m9297c(String str) throws ProtocolException {
        this.f8768a.setRequestMethod(str);
    }

    /* JADX INFO: renamed from: c */
    public final void m9298c(boolean z) {
        this.f8768a.setDoInput(z);
    }

    /* JADX INFO: renamed from: d */
    public final InputStream m9299d() throws IOException {
        m9274E();
        this.f8769b.m8530a(this.f8768a.getResponseCode());
        this.f8769b.m8539c(this.f8768a.getContentType());
        try {
            return new zza(this.f8768a.getInputStream(), this.f8769b, this.f8772e);
        } catch (IOException e) {
            this.f8769b.m8543f(this.f8772e.m8602c());
            zzh.m9330a(this.f8769b);
            throw e;
        }
    }

    /* JADX INFO: renamed from: d */
    public final void m9300d(int i) {
        this.f8768a.setConnectTimeout(i);
    }

    /* JADX INFO: renamed from: d */
    public final void m9301d(boolean z) {
        this.f8768a.setDoOutput(z);
    }

    /* JADX INFO: renamed from: e */
    public final long m9302e() {
        m9274E();
        return this.f8768a.getLastModified();
    }

    /* JADX INFO: renamed from: e */
    public final void m9303e(int i) {
        this.f8768a.setFixedLengthStreamingMode(i);
    }

    /* JADX INFO: renamed from: e */
    public final void m9304e(boolean z) {
        this.f8768a.setInstanceFollowRedirects(z);
    }

    public final boolean equals(Object obj) {
        return this.f8768a.equals(obj);
    }

    /* JADX INFO: renamed from: f */
    public final OutputStream m9305f() throws IOException {
        try {
            return new zzb(this.f8768a.getOutputStream(), this.f8769b, this.f8772e);
        } catch (IOException e) {
            this.f8769b.m8543f(this.f8772e.m8602c());
            zzh.m9330a(this.f8769b);
            throw e;
        }
    }

    /* JADX INFO: renamed from: f */
    public final void m9306f(int i) {
        this.f8768a.setReadTimeout(i);
    }

    /* JADX INFO: renamed from: f */
    public final void m9307f(boolean z) {
        this.f8768a.setUseCaches(z);
    }

    /* JADX INFO: renamed from: g */
    public final Permission m9308g() throws IOException {
        try {
            return this.f8768a.getPermission();
        } catch (IOException e) {
            this.f8769b.m8543f(this.f8772e.m8602c());
            zzh.m9330a(this.f8769b);
            throw e;
        }
    }

    /* JADX INFO: renamed from: h */
    public final int m9309h() throws IOException {
        m9274E();
        if (this.f8771d == -1) {
            this.f8771d = this.f8772e.m8602c();
            this.f8769b.m8542e(this.f8771d);
        }
        try {
            return this.f8768a.getResponseCode();
        } catch (IOException e) {
            this.f8769b.m8543f(this.f8772e.m8602c());
            zzh.m9330a(this.f8769b);
            throw e;
        }
    }

    public final int hashCode() {
        return this.f8768a.hashCode();
    }

    /* JADX INFO: renamed from: i */
    public final String m9310i() throws IOException {
        m9274E();
        if (this.f8771d == -1) {
            this.f8771d = this.f8772e.m8602c();
            this.f8769b.m8542e(this.f8771d);
        }
        try {
            String responseMessage = this.f8768a.getResponseMessage();
            this.f8769b.m8530a(this.f8768a.getResponseCode());
            return responseMessage;
        } catch (IOException e) {
            this.f8769b.m8543f(this.f8772e.m8602c());
            zzh.m9330a(this.f8769b);
            throw e;
        }
    }

    /* JADX INFO: renamed from: j */
    public final long m9311j() {
        m9274E();
        return this.f8768a.getExpiration();
    }

    /* JADX INFO: renamed from: k */
    public final Map<String, List<String>> m9312k() {
        m9274E();
        return this.f8768a.getHeaderFields();
    }

    /* JADX INFO: renamed from: l */
    public final String m9313l() {
        m9274E();
        return this.f8768a.getContentEncoding();
    }

    /* JADX INFO: renamed from: m */
    public final int m9314m() {
        m9274E();
        return this.f8768a.getContentLength();
    }

    /* JADX INFO: renamed from: n */
    public final long m9315n() {
        m9274E();
        return this.f8768a.getContentLengthLong();
    }

    /* JADX INFO: renamed from: o */
    public final String m9316o() {
        m9274E();
        return this.f8768a.getContentType();
    }

    /* JADX INFO: renamed from: p */
    public final long m9317p() {
        m9274E();
        return this.f8768a.getDate();
    }

    /* JADX INFO: renamed from: q */
    public final boolean m9318q() {
        return this.f8768a.getAllowUserInteraction();
    }

    /* JADX INFO: renamed from: r */
    public final int m9319r() {
        return this.f8768a.getConnectTimeout();
    }

    /* JADX INFO: renamed from: s */
    public final boolean m9320s() {
        return this.f8768a.getDefaultUseCaches();
    }

    /* JADX INFO: renamed from: t */
    public final boolean m9321t() {
        return this.f8768a.getDoInput();
    }

    public final String toString() {
        return this.f8768a.toString();
    }

    /* JADX INFO: renamed from: u */
    public final boolean m9322u() {
        return this.f8768a.getDoOutput();
    }

    /* JADX INFO: renamed from: v */
    public final InputStream m9323v() {
        m9274E();
        try {
            this.f8769b.m8530a(this.f8768a.getResponseCode());
        } catch (IOException e) {
            Log.d("FirebasePerformance", "IOException thrown trying to obtain the response code");
        }
        InputStream errorStream = this.f8768a.getErrorStream();
        return errorStream != null ? new zza(errorStream, this.f8769b, this.f8772e) : errorStream;
    }

    /* JADX INFO: renamed from: w */
    public final long m9324w() {
        return this.f8768a.getIfModifiedSince();
    }

    /* JADX INFO: renamed from: x */
    public final boolean m9325x() {
        return this.f8768a.getInstanceFollowRedirects();
    }

    /* JADX INFO: renamed from: y */
    public final int m9326y() {
        return this.f8768a.getReadTimeout();
    }

    /* JADX INFO: renamed from: z */
    public final String m9327z() {
        return this.f8768a.getRequestMethod();
    }
}
