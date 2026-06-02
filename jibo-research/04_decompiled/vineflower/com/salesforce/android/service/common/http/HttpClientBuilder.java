package com.salesforce.android.service.common.http;

import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import okhttp3.Cache;
import okhttp3.ConnectionSpec;
import okhttp3.Interceptor;

public interface HttpClientBuilder {
   HttpClient a();

   HttpClientBuilder a(long var1, TimeUnit var3);

   HttpClientBuilder a(List<ConnectionSpec> var1);

   HttpClientBuilder a(SSLSocketFactory var1, X509TrustManager var2);

   HttpClientBuilder a(Cache var1);

   HttpClientBuilder a(Interceptor var1);

   HttpClientBuilder b(long var1, TimeUnit var3);

   HttpClientBuilder b(Interceptor var1);
}
