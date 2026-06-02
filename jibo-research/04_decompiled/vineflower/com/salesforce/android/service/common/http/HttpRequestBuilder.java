package com.salesforce.android.service.common.http;

import okhttp3.RequestBody;

public interface HttpRequestBuilder {
   HttpRequestBuilder a();

   HttpRequestBuilder a(String var1);

   HttpRequestBuilder a(String var1, String var2);

   HttpRequestBuilder a(okhttp3.HttpUrl var1);

   HttpRequestBuilder a(RequestBody var1);

   HttpRequestBuilder b();

   HttpRequest c();
}
