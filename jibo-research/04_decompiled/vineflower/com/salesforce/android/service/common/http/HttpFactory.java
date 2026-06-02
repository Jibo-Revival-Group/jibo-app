package com.salesforce.android.service.common.http;

import com.salesforce.android.service.common.http.okhttp.SalesforceOkHttpClient;
import com.salesforce.android.service.common.http.okhttp.SalesforceOkHttpRequest;

public class HttpFactory {
   public static HttpClientBuilder a() {
      return SalesforceOkHttpClient.b();
   }

   public static HttpRequestBuilder b() {
      return SalesforceOkHttpRequest.c();
   }
}
