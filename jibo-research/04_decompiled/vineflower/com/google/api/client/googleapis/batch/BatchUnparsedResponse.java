package com.google.api.client.googleapis.batch;

import com.google.api.client.http.BackOffPolicy;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpContent;
import com.google.api.client.http.HttpHeaders;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpStatusCodes;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.HttpUnsuccessfulResponseHandler;
import com.google.api.client.http.LowLevelHttpRequest;
import com.google.api.client.http.LowLevelHttpResponse;
import com.google.api.client.util.ByteStreams;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

final class BatchUnparsedResponse {
   boolean backOffRequired;
   private final String boundary;
   private int contentId;
   boolean hasNext = true;
   private final InputStream inputStream;
   private final List<BatchRequest.RequestInfo<?, ?>> requestInfos;
   private final boolean retryAllowed;
   List<BatchRequest.RequestInfo<?, ?>> unsuccessfulRequestInfos = new ArrayList<>();

   BatchUnparsedResponse(InputStream var1, String var2, List<BatchRequest.RequestInfo<?, ?>> var3, boolean var4) throws IOException {
      this.contentId = 0;
      this.boundary = var2;
      this.requestInfos = var3;
      this.retryAllowed = var4;
      this.inputStream = var1;
      this.checkForFinalBoundary(this.readLine());
   }

   private void checkForFinalBoundary(String var1) throws IOException {
      if (var1.equals(String.valueOf(this.boundary).concat("--"))) {
         this.hasNext = false;
         this.inputStream.close();
      }
   }

   private HttpResponse getFakeResponse(int var1, InputStream var2, List<String> var3, List<String> var4) throws IOException {
      HttpRequest var5 = new BatchUnparsedResponse.FakeResponseHttpTransport(var1, var2, var3, var4)
         .createRequestFactory()
         .buildPostRequest(new GenericUrl("http://google.com/"), null);
      var5.setLoggingEnabled(false);
      var5.setThrowExceptionOnExecuteError(false);
      return var5.execute();
   }

   private <A, T, E> A getParsedDataClass(Class<A> var1, HttpResponse var2, BatchRequest.RequestInfo<T, E> var3) throws IOException {
      Object var4;
      if (var1 == Void.class) {
         var4 = null;
      } else {
         var4 = var3.request.getParser().parseAndClose(var2.getContent(), var2.getContentCharset(), var1);
      }

      return (A)var4;
   }

   private <T, E> void parseAndCallback(BatchRequest.RequestInfo<T, E> var1, int var2, HttpResponse var3) throws IOException {
      boolean var4 = true;
      BatchCallback var11 = var1.callback;
      HttpHeaders var9 = var3.getHeaders();
      HttpUnsuccessfulResponseHandler var10 = var1.request.getUnsuccessfulResponseHandler();
      BackOffPolicy var8 = var1.request.getBackOffPolicy();
      this.backOffRequired = false;
      if (HttpStatusCodes.isSuccess(var2)) {
         if (var11 != null) {
            var11.onSuccess(this.getParsedDataClass(var1.dataClass, var3, var1), var9);
         }
      } else {
         HttpContent var7 = var1.request.getContent();
         boolean var5;
         if (!this.retryAllowed || var7 != null && !var7.retrySupported()) {
            var5 = false;
         } else {
            var5 = true;
         }

         boolean var6;
         if (var10 != null) {
            var6 = var10.handleResponse(var1.request, var3, var5);
         } else {
            var6 = false;
         }

         label51: {
            if (!var6) {
               if (var1.request.handleRedirect(var3.getStatusCode(), var3.getHeaders())) {
                  var12 = var4;
                  break label51;
               }

               if (var5 && var8 != null && var8.isBackOffRequired(var3.getStatusCode())) {
                  this.backOffRequired = true;
               }
            }

            var12 = false;
         }

         if (!var5 || !var6 && !this.backOffRequired && !var12) {
            if (var11 != null) {
               var11.onFailure(this.getParsedDataClass(var1.errorClass, var3, var1), var9);
            }
         } else {
            this.unsuccessfulRequestInfos.add(var1);
         }
      }
   }

   private String readLine() throws IOException {
      return trimCrlf(this.readRawLine());
   }

   private String readRawLine() throws IOException {
      int var1 = this.inputStream.read();
      String var2;
      if (var1 == -1) {
         var2 = null;
      } else {
         StringBuilder var3 = new StringBuilder();

         while (var1 != -1) {
            var3.append((char)var1);
            if (var1 == 10) {
               break;
            }

            var1 = this.inputStream.read();
         }

         var2 = var3.toString();
      }

      return var2;
   }

   private static InputStream trimCrlf(byte[] var0) {
      int var2 = var0.length;
      int var1 = var2;
      if (var2 > 0) {
         var1 = var2;
         if (var0[var2 - 1] == 10) {
            var1 = var2 - 1;
         }
      }

      var2 = var1;
      if (var1 > 0) {
         var2 = var1;
         if (var0[var1 - 1] == 13) {
            var2 = var1 - 1;
         }
      }

      return new ByteArrayInputStream(var0, 0, var2);
   }

   private static String trimCrlf(String var0) {
      String var1;
      if (var0.endsWith("\r\n")) {
         var1 = var0.substring(0, var0.length() - 2);
      } else {
         var1 = var0;
         if (var0.endsWith("\n")) {
            var1 = var0.substring(0, var0.length() - 1);
         }
      }

      return var1;
   }

   void parseNextResponse() throws IOException {
      this.contentId++;

      String var4;
      do {
         var4 = this.readLine();
      } while (var4 != null && !var4.equals(""));

      int var1 = Integer.parseInt(this.readLine().split(" ")[1]);
      ArrayList var7 = new ArrayList();
      ArrayList var6 = new ArrayList();
      long var2 = -1L;

      while (true) {
         var4 = this.readLine();
         if (var4 == null || var4.equals("")) {
            InputStream var13;
            if (var2 == -1L) {
               ByteArrayOutputStream var12 = new ByteArrayOutputStream();

               while (true) {
                  var4 = this.readRawLine();
                  if (var4 == null || var4.startsWith(this.boundary)) {
                     var13 = trimCrlf(var12.toByteArray());
                     var4 = trimCrlf(var4);
                     break;
                  }

                  var12.write(var4.getBytes("ISO-8859-1"));
               }
            } else {
               var13 = new FilterInputStream(this, ByteStreams.limit(this.inputStream, var2)) {
                  final BatchUnparsedResponse this$0;

                  {
                     this.this$0 = var1;
                  }

                  @Override
                  public void close() {
                  }
               };
            }

            HttpResponse var14 = this.getFakeResponse(var1, var13, var7, var6);
            this.parseAndCallback(this.requestInfos.get(this.contentId - 1), var1, var14);

            do {
               while (var13.skip(var2) > 0L) {
               }
            } while (var13.read() != -1);

            if (var2 != -1L) {
               var4 = this.readLine();
            }

            while (var4 != null && var4.length() == 0) {
               var4 = this.readLine();
            }

            this.checkForFinalBoundary(var4);
            return;
         }

         String[] var5 = var4.split(": ", 2);
         var4 = var5[0];
         String var11 = var5[1];
         var7.add(var4);
         var6.add(var11);
         if ("Content-Length".equalsIgnoreCase(var4.trim())) {
            var2 = Long.parseLong(var11);
         }
      }
   }

   private static class FakeLowLevelHttpRequest extends LowLevelHttpRequest {
      private List<String> headerNames;
      private List<String> headerValues;
      private InputStream partContent;
      private int statusCode;

      FakeLowLevelHttpRequest(InputStream var1, int var2, List<String> var3, List<String> var4) {
         this.partContent = var1;
         this.statusCode = var2;
         this.headerNames = var3;
         this.headerValues = var4;
      }

      @Override
      public void addHeader(String var1, String var2) {
      }

      @Override
      public LowLevelHttpResponse execute() {
         return new BatchUnparsedResponse.FakeLowLevelHttpResponse(this.partContent, this.statusCode, this.headerNames, this.headerValues);
      }
   }

   private static class FakeLowLevelHttpResponse extends LowLevelHttpResponse {
      private List<String> headerNames = new ArrayList<>();
      private List<String> headerValues = new ArrayList<>();
      private InputStream partContent;
      private int statusCode;

      FakeLowLevelHttpResponse(InputStream var1, int var2, List<String> var3, List<String> var4) {
         this.partContent = var1;
         this.statusCode = var2;
         this.headerNames = var3;
         this.headerValues = var4;
      }

      @Override
      public InputStream getContent() {
         return this.partContent;
      }

      @Override
      public String getContentEncoding() {
         return null;
      }

      @Override
      public long getContentLength() {
         return 0L;
      }

      @Override
      public String getContentType() {
         return null;
      }

      @Override
      public int getHeaderCount() {
         return this.headerNames.size();
      }

      @Override
      public String getHeaderName(int var1) {
         return this.headerNames.get(var1);
      }

      @Override
      public String getHeaderValue(int var1) {
         return this.headerValues.get(var1);
      }

      @Override
      public String getReasonPhrase() {
         return null;
      }

      @Override
      public int getStatusCode() {
         return this.statusCode;
      }

      @Override
      public String getStatusLine() {
         return null;
      }
   }

   private static class FakeResponseHttpTransport extends HttpTransport {
      private List<String> headerNames;
      private List<String> headerValues;
      private InputStream partContent;
      private int statusCode;

      FakeResponseHttpTransport(int var1, InputStream var2, List<String> var3, List<String> var4) {
         this.statusCode = var1;
         this.partContent = var2;
         this.headerNames = var3;
         this.headerValues = var4;
      }

      @Override
      protected LowLevelHttpRequest buildRequest(String var1, String var2) {
         return new BatchUnparsedResponse.FakeLowLevelHttpRequest(this.partContent, this.statusCode, this.headerNames, this.headerValues);
      }
   }
}
