package com.amazonaws.http;

public interface HttpClient {
   HttpResponse execute(HttpRequest var1);

   void shutdown();
}
