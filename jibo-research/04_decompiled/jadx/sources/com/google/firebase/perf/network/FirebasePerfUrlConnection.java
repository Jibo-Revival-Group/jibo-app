package com.google.firebase.perf.network;

import android.support.annotation.Keep;
import com.google.android.gms.internal.zzevv;
import com.google.android.gms.internal.zzevz;
import com.google.android.gms.internal.zzewn;
import com.google.android.gms.internal.zzewp;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import javax.net.ssl.HttpsURLConnection;

/* JADX INFO: loaded from: classes.dex */
public class FirebasePerfUrlConnection {
    private FirebasePerfUrlConnection() {
    }

    /* JADX INFO: renamed from: a */
    private static InputStream m9271a(zzewp zzewpVar, zzevz zzevzVar, zzewn zzewnVar) throws IOException {
        zzewnVar.m8600a();
        long jM8601b = zzewnVar.m8601b();
        zzevv zzevvVarM8529a = zzevv.m8529a(zzevzVar);
        try {
            URLConnection uRLConnectionM8603a = zzewpVar.m8603a();
            return uRLConnectionM8603a instanceof HttpsURLConnection ? new zzd((HttpsURLConnection) uRLConnectionM8603a, zzewnVar, zzevvVarM8529a).getInputStream() : uRLConnectionM8603a instanceof HttpURLConnection ? new zzc((HttpURLConnection) uRLConnectionM8603a, zzewnVar, zzevvVarM8529a).getInputStream() : uRLConnectionM8603a.getInputStream();
        } catch (IOException e) {
            zzevvVarM8529a.m8538c(jM8601b);
            zzevvVarM8529a.m8543f(zzewnVar.m8602c());
            zzevvVarM8529a.m8532a(zzewpVar.toString());
            zzh.m9330a(zzevvVarM8529a);
            throw e;
        }
    }

    /* JADX INFO: renamed from: a */
    private static Object m9272a(zzewp zzewpVar, Class[] clsArr, zzevz zzevzVar, zzewn zzewnVar) throws IOException {
        zzewnVar.m8600a();
        long jM8601b = zzewnVar.m8601b();
        zzevv zzevvVarM8529a = zzevv.m8529a(zzevzVar);
        try {
            URLConnection uRLConnectionM8603a = zzewpVar.m8603a();
            return uRLConnectionM8603a instanceof HttpsURLConnection ? new zzd((HttpsURLConnection) uRLConnectionM8603a, zzewnVar, zzevvVarM8529a).getContent(clsArr) : uRLConnectionM8603a instanceof HttpURLConnection ? new zzc((HttpURLConnection) uRLConnectionM8603a, zzewnVar, zzevvVarM8529a).getContent(clsArr) : uRLConnectionM8603a.getContent(clsArr);
        } catch (IOException e) {
            zzevvVarM8529a.m8538c(jM8601b);
            zzevvVarM8529a.m8543f(zzewnVar.m8602c());
            zzevvVarM8529a.m8532a(zzewpVar.toString());
            zzh.m9330a(zzevvVarM8529a);
            throw e;
        }
    }

    /* JADX INFO: renamed from: b */
    private static Object m9273b(zzewp zzewpVar, zzevz zzevzVar, zzewn zzewnVar) throws IOException {
        zzewnVar.m8600a();
        long jM8601b = zzewnVar.m8601b();
        zzevv zzevvVarM8529a = zzevv.m8529a(zzevzVar);
        try {
            URLConnection uRLConnectionM8603a = zzewpVar.m8603a();
            return uRLConnectionM8603a instanceof HttpsURLConnection ? new zzd((HttpsURLConnection) uRLConnectionM8603a, zzewnVar, zzevvVarM8529a).getContent() : uRLConnectionM8603a instanceof HttpURLConnection ? new zzc((HttpURLConnection) uRLConnectionM8603a, zzewnVar, zzevvVarM8529a).getContent() : uRLConnectionM8603a.getContent();
        } catch (IOException e) {
            zzevvVarM8529a.m8538c(jM8601b);
            zzevvVarM8529a.m8543f(zzewnVar.m8602c());
            zzevvVarM8529a.m8532a(zzewpVar.toString());
            zzh.m9330a(zzevvVarM8529a);
            throw e;
        }
    }

    @Keep
    public static Object getContent(URL url) throws IOException {
        return m9273b(new zzewp(url), zzevz.m8561a(), new zzewn());
    }

    @Keep
    public static Object getContent(URL url, Class[] clsArr) throws IOException {
        return m9272a(new zzewp(url), clsArr, zzevz.m8561a(), new zzewn());
    }

    @Keep
    public static Object instrument(Object obj) throws IOException {
        return obj instanceof HttpsURLConnection ? new zzd((HttpsURLConnection) obj, new zzewn(), zzevv.m8529a(zzevz.m8561a())) : obj instanceof HttpURLConnection ? new zzc((HttpURLConnection) obj, new zzewn(), zzevv.m8529a(zzevz.m8561a())) : obj;
    }

    @Keep
    public static InputStream openStream(URL url) throws IOException {
        return m9271a(new zzewp(url), zzevz.m8561a(), new zzewn());
    }
}
