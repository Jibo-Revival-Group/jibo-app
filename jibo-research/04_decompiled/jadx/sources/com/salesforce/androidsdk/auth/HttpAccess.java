package com.salesforce.androidsdk.auth;

import android.content.Context;
import android.net.ConnectivityManager;
import android.os.Build;
import com.salesforce.androidsdk.util.SalesforceSDKLogger;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.Collections;
import java.util.concurrent.TimeUnit;
import okhttp3.ConnectionSpec;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import okhttp3.TlsVersion;

/* JADX INFO: loaded from: classes.dex */
public class HttpAccess {

    /* JADX INFO: renamed from: a */
    public static HttpAccess f14141a;

    /* JADX INFO: renamed from: b */
    static final /* synthetic */ boolean f14142b;

    /* JADX INFO: renamed from: c */
    private String f14143c;

    /* JADX INFO: renamed from: d */
    private OkHttpClient f14144d;

    /* JADX INFO: renamed from: e */
    private final ConnectivityManager f14145e;

    static {
        f14142b = !HttpAccess.class.desiredAssertionStatus();
    }

    /* JADX INFO: renamed from: a */
    public static void m14475a(Context context, String str) {
        if (!f14142b && f14141a != null) {
            throw new AssertionError("HttpAccess.init should be called once per process");
        }
        f14141a = new HttpAccess(context, str);
    }

    public HttpAccess(Context context, String str) {
        this.f14143c = str;
        if (context == null) {
            this.f14145e = null;
        } else {
            this.f14145e = (ConnectivityManager) context.getSystemService("connectivity");
        }
    }

    /* JADX INFO: renamed from: a */
    public OkHttpClient.Builder m14476a() {
        OkHttpClient.Builder builderM15754b = new OkHttpClient.Builder().m15745a(Collections.singletonList(new ConnectionSpec.Builder(ConnectionSpec.f15029a).m15572a(TlsVersion.TLS_1_1, TlsVersion.TLS_1_2).m15573a())).m15743a(60L, TimeUnit.SECONDS).m15753b(20L, TimeUnit.SECONDS).m15754b(new UserAgentInterceptor(this.f14143c));
        if (Build.VERSION.SDK_INT < 21) {
            try {
                builderM15754b.m15746a(SalesforceTLSSocketFactory.getInstance());
            } catch (KeyManagementException e) {
                SalesforceSDKLogger.m15016a("HttpAccess", "Exception thrown while setting SSL socket factory", e);
            } catch (NoSuchAlgorithmException e2) {
                SalesforceSDKLogger.m15016a("HttpAccess", "Exception thrown while setting SSL socket factory", e2);
            }
        }
        return builderM15754b;
    }

    /* JADX INFO: renamed from: b */
    public synchronized OkHttpClient m14477b() {
        if (this.f14144d == null) {
            this.f14144d = m14476a().m15752a();
        }
        return this.f14144d;
    }

    public static class UserAgentInterceptor implements Interceptor {

        /* JADX INFO: renamed from: a */
        private final String f14146a;

        public UserAgentInterceptor(String str) {
            this.f14146a = str;
        }

        @Override // okhttp3.Interceptor
        /* JADX INFO: renamed from: a */
        public Response mo12243a(Interceptor.Chain chain) throws IOException {
            return chain.mo15693a(chain.mo15692a().m15770e().m15775a("User-Agent", this.f14146a).m15784c());
        }
    }
}
