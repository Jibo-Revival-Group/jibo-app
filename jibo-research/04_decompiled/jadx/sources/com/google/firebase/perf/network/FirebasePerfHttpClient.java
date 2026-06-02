package com.google.firebase.perf.network;

import android.support.annotation.Keep;
import com.google.android.gms.internal.zzevv;
import com.google.android.gms.internal.zzevz;
import com.google.android.gms.internal.zzewn;
import java.io.IOException;
import org.apache.http.HttpHost;
import org.apache.http.HttpMessage;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.protocol.HttpContext;

/* JADX INFO: loaded from: classes.dex */
public class FirebasePerfHttpClient {
    private FirebasePerfHttpClient() {
    }

    /* JADX INFO: renamed from: a */
    private static <T> T m9262a(HttpClient httpClient, HttpHost httpHost, HttpRequest httpRequest, ResponseHandler<? extends T> responseHandler, zzewn zzewnVar, zzevz zzevzVar) throws IOException {
        zzevv zzevvVarM8529a = zzevv.m8529a(zzevzVar);
        try {
            String strValueOf = String.valueOf(httpHost.toURI());
            String strValueOf2 = String.valueOf(httpRequest.getRequestLine().getUri());
            zzevvVarM8529a.m8532a(strValueOf2.length() != 0 ? strValueOf.concat(strValueOf2) : new String(strValueOf)).m8536b(httpRequest.getRequestLine().getMethod());
            Long lM9328a = zzh.m9328a(httpRequest);
            if (lM9328a != null) {
                zzevvVarM8529a.m8531a(lM9328a.longValue());
            }
            zzewnVar.m8600a();
            zzevvVarM8529a.m8538c(zzewnVar.m8601b());
            return (T) httpClient.execute(httpHost, httpRequest, new zzf(responseHandler, zzewnVar, zzevvVarM8529a));
        } catch (IOException e) {
            zzevvVarM8529a.m8543f(zzewnVar.m8602c());
            zzh.m9330a(zzevvVarM8529a);
            throw e;
        }
    }

    /* JADX INFO: renamed from: a */
    private static <T> T m9263a(HttpClient httpClient, HttpHost httpHost, HttpRequest httpRequest, ResponseHandler<? extends T> responseHandler, HttpContext httpContext, zzewn zzewnVar, zzevz zzevzVar) throws IOException {
        zzevv zzevvVarM8529a = zzevv.m8529a(zzevzVar);
        try {
            String strValueOf = String.valueOf(httpHost.toURI());
            String strValueOf2 = String.valueOf(httpRequest.getRequestLine().getUri());
            zzevvVarM8529a.m8532a(strValueOf2.length() != 0 ? strValueOf.concat(strValueOf2) : new String(strValueOf)).m8536b(httpRequest.getRequestLine().getMethod());
            Long lM9328a = zzh.m9328a(httpRequest);
            if (lM9328a != null) {
                zzevvVarM8529a.m8531a(lM9328a.longValue());
            }
            zzewnVar.m8600a();
            zzevvVarM8529a.m8538c(zzewnVar.m8601b());
            return (T) httpClient.execute(httpHost, httpRequest, new zzf(responseHandler, zzewnVar, zzevvVarM8529a), httpContext);
        } catch (IOException e) {
            zzevvVarM8529a.m8543f(zzewnVar.m8602c());
            zzh.m9330a(zzevvVarM8529a);
            throw e;
        }
    }

    /* JADX INFO: renamed from: a */
    private static <T> T m9264a(HttpClient httpClient, HttpUriRequest httpUriRequest, ResponseHandler<T> responseHandler, zzewn zzewnVar, zzevz zzevzVar) throws IOException {
        zzevv zzevvVarM8529a = zzevv.m8529a(zzevzVar);
        try {
            zzevvVarM8529a.m8532a(httpUriRequest.getURI().toString()).m8536b(httpUriRequest.getMethod());
            Long lM9328a = zzh.m9328a(httpUriRequest);
            if (lM9328a != null) {
                zzevvVarM8529a.m8531a(lM9328a.longValue());
            }
            zzewnVar.m8600a();
            zzevvVarM8529a.m8538c(zzewnVar.m8601b());
            return (T) httpClient.execute(httpUriRequest, new zzf(responseHandler, zzewnVar, zzevvVarM8529a));
        } catch (IOException e) {
            zzevvVarM8529a.m8543f(zzewnVar.m8602c());
            zzh.m9330a(zzevvVarM8529a);
            throw e;
        }
    }

    /* JADX INFO: renamed from: a */
    private static <T> T m9265a(HttpClient httpClient, HttpUriRequest httpUriRequest, ResponseHandler<T> responseHandler, HttpContext httpContext, zzewn zzewnVar, zzevz zzevzVar) throws IOException {
        zzevv zzevvVarM8529a = zzevv.m8529a(zzevzVar);
        try {
            zzevvVarM8529a.m8532a(httpUriRequest.getURI().toString()).m8536b(httpUriRequest.getMethod());
            Long lM9328a = zzh.m9328a(httpUriRequest);
            if (lM9328a != null) {
                zzevvVarM8529a.m8531a(lM9328a.longValue());
            }
            zzewnVar.m8600a();
            zzevvVarM8529a.m8538c(zzewnVar.m8601b());
            return (T) httpClient.execute(httpUriRequest, new zzf(responseHandler, zzewnVar, zzevvVarM8529a), httpContext);
        } catch (IOException e) {
            zzevvVarM8529a.m8543f(zzewnVar.m8602c());
            zzh.m9330a(zzevvVarM8529a);
            throw e;
        }
    }

    /* JADX INFO: renamed from: a */
    private static HttpResponse m9266a(HttpClient httpClient, HttpHost httpHost, HttpRequest httpRequest, zzewn zzewnVar, zzevz zzevzVar) throws IOException {
        zzevv zzevvVarM8529a = zzevv.m8529a(zzevzVar);
        try {
            String strValueOf = String.valueOf(httpHost.toURI());
            String strValueOf2 = String.valueOf(httpRequest.getRequestLine().getUri());
            zzevvVarM8529a.m8532a(strValueOf2.length() != 0 ? strValueOf.concat(strValueOf2) : new String(strValueOf)).m8536b(httpRequest.getRequestLine().getMethod());
            Long lM9328a = zzh.m9328a(httpRequest);
            if (lM9328a != null) {
                zzevvVarM8529a.m8531a(lM9328a.longValue());
            }
            zzewnVar.m8600a();
            zzevvVarM8529a.m8538c(zzewnVar.m8601b());
            HttpResponse httpResponseExecute = httpClient.execute(httpHost, httpRequest);
            zzevvVarM8529a.m8543f(zzewnVar.m8602c());
            zzevvVarM8529a.m8530a(httpResponseExecute.getStatusLine().getStatusCode());
            Long lM9328a2 = zzh.m9328a((HttpMessage) httpResponseExecute);
            if (lM9328a2 != null) {
                zzevvVarM8529a.m8535b(lM9328a2.longValue());
            }
            String strM9329a = zzh.m9329a(httpResponseExecute);
            if (strM9329a != null) {
                zzevvVarM8529a.m8539c(strM9329a);
            }
            zzevvVarM8529a.m8541d();
            return httpResponseExecute;
        } catch (IOException e) {
            zzevvVarM8529a.m8543f(zzewnVar.m8602c());
            zzh.m9330a(zzevvVarM8529a);
            throw e;
        }
    }

    /* JADX INFO: renamed from: a */
    private static HttpResponse m9267a(HttpClient httpClient, HttpHost httpHost, HttpRequest httpRequest, HttpContext httpContext, zzewn zzewnVar, zzevz zzevzVar) throws IOException {
        zzevv zzevvVarM8529a = zzevv.m8529a(zzevzVar);
        try {
            String strValueOf = String.valueOf(httpHost.toURI());
            String strValueOf2 = String.valueOf(httpRequest.getRequestLine().getUri());
            zzevvVarM8529a.m8532a(strValueOf2.length() != 0 ? strValueOf.concat(strValueOf2) : new String(strValueOf)).m8536b(httpRequest.getRequestLine().getMethod());
            Long lM9328a = zzh.m9328a(httpRequest);
            if (lM9328a != null) {
                zzevvVarM8529a.m8531a(lM9328a.longValue());
            }
            zzewnVar.m8600a();
            zzevvVarM8529a.m8538c(zzewnVar.m8601b());
            HttpResponse httpResponseExecute = httpClient.execute(httpHost, httpRequest, httpContext);
            zzevvVarM8529a.m8543f(zzewnVar.m8602c());
            zzevvVarM8529a.m8530a(httpResponseExecute.getStatusLine().getStatusCode());
            Long lM9328a2 = zzh.m9328a((HttpMessage) httpResponseExecute);
            if (lM9328a2 != null) {
                zzevvVarM8529a.m8535b(lM9328a2.longValue());
            }
            String strM9329a = zzh.m9329a(httpResponseExecute);
            if (strM9329a != null) {
                zzevvVarM8529a.m8539c(strM9329a);
            }
            zzevvVarM8529a.m8541d();
            return httpResponseExecute;
        } catch (IOException e) {
            zzevvVarM8529a.m8543f(zzewnVar.m8602c());
            zzh.m9330a(zzevvVarM8529a);
            throw e;
        }
    }

    /* JADX INFO: renamed from: a */
    private static HttpResponse m9268a(HttpClient httpClient, HttpUriRequest httpUriRequest, zzewn zzewnVar, zzevz zzevzVar) throws IOException {
        zzevv zzevvVarM8529a = zzevv.m8529a(zzevzVar);
        try {
            zzevvVarM8529a.m8532a(httpUriRequest.getURI().toString()).m8536b(httpUriRequest.getMethod());
            Long lM9328a = zzh.m9328a(httpUriRequest);
            if (lM9328a != null) {
                zzevvVarM8529a.m8531a(lM9328a.longValue());
            }
            zzewnVar.m8600a();
            zzevvVarM8529a.m8538c(zzewnVar.m8601b());
            HttpResponse httpResponseExecute = httpClient.execute(httpUriRequest);
            zzevvVarM8529a.m8543f(zzewnVar.m8602c());
            zzevvVarM8529a.m8530a(httpResponseExecute.getStatusLine().getStatusCode());
            Long lM9328a2 = zzh.m9328a((HttpMessage) httpResponseExecute);
            if (lM9328a2 != null) {
                zzevvVarM8529a.m8535b(lM9328a2.longValue());
            }
            String strM9329a = zzh.m9329a(httpResponseExecute);
            if (strM9329a != null) {
                zzevvVarM8529a.m8539c(strM9329a);
            }
            zzevvVarM8529a.m8541d();
            return httpResponseExecute;
        } catch (IOException e) {
            zzevvVarM8529a.m8543f(zzewnVar.m8602c());
            zzh.m9330a(zzevvVarM8529a);
            throw e;
        }
    }

    /* JADX INFO: renamed from: a */
    private static HttpResponse m9269a(HttpClient httpClient, HttpUriRequest httpUriRequest, HttpContext httpContext, zzewn zzewnVar, zzevz zzevzVar) throws IOException {
        zzevv zzevvVarM8529a = zzevv.m8529a(zzevzVar);
        try {
            zzevvVarM8529a.m8532a(httpUriRequest.getURI().toString()).m8536b(httpUriRequest.getMethod());
            Long lM9328a = zzh.m9328a(httpUriRequest);
            if (lM9328a != null) {
                zzevvVarM8529a.m8531a(lM9328a.longValue());
            }
            zzewnVar.m8600a();
            zzevvVarM8529a.m8538c(zzewnVar.m8601b());
            HttpResponse httpResponseExecute = httpClient.execute(httpUriRequest, httpContext);
            zzevvVarM8529a.m8543f(zzewnVar.m8602c());
            zzevvVarM8529a.m8530a(httpResponseExecute.getStatusLine().getStatusCode());
            Long lM9328a2 = zzh.m9328a((HttpMessage) httpResponseExecute);
            if (lM9328a2 != null) {
                zzevvVarM8529a.m8535b(lM9328a2.longValue());
            }
            String strM9329a = zzh.m9329a(httpResponseExecute);
            if (strM9329a != null) {
                zzevvVarM8529a.m8539c(strM9329a);
            }
            zzevvVarM8529a.m8541d();
            return httpResponseExecute;
        } catch (IOException e) {
            zzevvVarM8529a.m8543f(zzewnVar.m8602c());
            zzh.m9330a(zzevvVarM8529a);
            throw e;
        }
    }

    @Keep
    public static <T> T execute(HttpClient httpClient, HttpHost httpHost, HttpRequest httpRequest, ResponseHandler<? extends T> responseHandler) throws IOException {
        return (T) m9262a(httpClient, httpHost, httpRequest, responseHandler, new zzewn(), zzevz.m8561a());
    }

    @Keep
    public static <T> T execute(HttpClient httpClient, HttpHost httpHost, HttpRequest httpRequest, ResponseHandler<? extends T> responseHandler, HttpContext httpContext) throws IOException {
        return (T) m9263a(httpClient, httpHost, httpRequest, responseHandler, httpContext, new zzewn(), zzevz.m8561a());
    }

    @Keep
    public static <T> T execute(HttpClient httpClient, HttpUriRequest httpUriRequest, ResponseHandler<T> responseHandler) throws IOException {
        return (T) m9264a(httpClient, httpUriRequest, responseHandler, new zzewn(), zzevz.m8561a());
    }

    @Keep
    public static <T> T execute(HttpClient httpClient, HttpUriRequest httpUriRequest, ResponseHandler<T> responseHandler, HttpContext httpContext) throws IOException {
        return (T) m9265a(httpClient, httpUriRequest, responseHandler, httpContext, new zzewn(), zzevz.m8561a());
    }

    @Keep
    public static HttpResponse execute(HttpClient httpClient, HttpHost httpHost, HttpRequest httpRequest) throws IOException {
        return m9266a(httpClient, httpHost, httpRequest, new zzewn(), zzevz.m8561a());
    }

    @Keep
    public static HttpResponse execute(HttpClient httpClient, HttpHost httpHost, HttpRequest httpRequest, HttpContext httpContext) throws IOException {
        return m9267a(httpClient, httpHost, httpRequest, httpContext, new zzewn(), zzevz.m8561a());
    }

    @Keep
    public static HttpResponse execute(HttpClient httpClient, HttpUriRequest httpUriRequest) throws IOException {
        return m9268a(httpClient, httpUriRequest, new zzewn(), zzevz.m8561a());
    }

    @Keep
    public static HttpResponse execute(HttpClient httpClient, HttpUriRequest httpUriRequest, HttpContext httpContext) throws IOException {
        return m9269a(httpClient, httpUriRequest, httpContext, new zzewn(), zzevz.m8561a());
    }
}
