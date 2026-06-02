package com.google.api.client.googleapis.services;

import com.google.api.client.googleapis.MethodOverride;
import com.google.api.client.googleapis.batch.BatchCallback;
import com.google.api.client.googleapis.batch.BatchRequest;
import com.google.api.client.googleapis.media.MediaHttpDownloader;
import com.google.api.client.googleapis.media.MediaHttpUploader;
import com.google.api.client.http.AbstractInputStreamContent;
import com.google.api.client.http.EmptyContent;
import com.google.api.client.http.GZipEncoding;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpContent;
import com.google.api.client.http.HttpHeaders;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpResponseException;
import com.google.api.client.http.HttpResponseInterceptor;
import com.google.api.client.http.UriTemplate;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.Preconditions;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public abstract class AbstractGoogleClientRequest<T> extends GenericData {
   public static final String USER_AGENT_SUFFIX = "Google-API-Java-Client";
   private final AbstractGoogleClient abstractGoogleClient;
   private boolean disableGZipContent;
   private MediaHttpDownloader downloader;
   private final HttpContent httpContent;
   private HttpHeaders lastResponseHeaders;
   private int lastStatusCode;
   private String lastStatusMessage;
   private HttpHeaders requestHeaders = new HttpHeaders();
   private final String requestMethod;
   private Class<T> responseClass;
   private MediaHttpUploader uploader;
   private final String uriTemplate;

   protected AbstractGoogleClientRequest(AbstractGoogleClient var1, String var2, String var3, HttpContent var4, Class<T> var5) {
      this.lastStatusCode = -1;
      this.responseClass = Preconditions.checkNotNull(var5);
      this.abstractGoogleClient = Preconditions.checkNotNull(var1);
      this.requestMethod = Preconditions.checkNotNull(var2);
      this.uriTemplate = Preconditions.checkNotNull(var3);
      this.httpContent = var4;
      var2 = var1.getApplicationName();
      if (var2 != null) {
         HttpHeaders var6 = this.requestHeaders;
         var3 = String.valueOf(String.valueOf(var2));
         var2 = String.valueOf(String.valueOf("Google-API-Java-Client"));
         var6.setUserAgent(new StringBuilder(var3.length() + 1 + var2.length()).append(var3).append(" ").append(var2).toString());
      } else {
         this.requestHeaders.setUserAgent("Google-API-Java-Client");
      }
   }

   private HttpRequest buildHttpRequest(boolean var1) throws IOException {
      boolean var3 = false;
      boolean var2;
      if (this.uploader == null) {
         var2 = true;
      } else {
         var2 = false;
      }

      label36: {
         Preconditions.checkArgument(var2);
         if (var1) {
            var2 = var3;
            if (!this.requestMethod.equals("GET")) {
               break label36;
            }
         }

         var2 = true;
      }

      Preconditions.checkArgument(var2);
      String var4;
      if (var1) {
         var4 = "HEAD";
      } else {
         var4 = this.requestMethod;
      }

      HttpRequest var6 = this.getAbstractGoogleClient().getRequestFactory().buildRequest(var4, this.buildHttpRequestUrl(), this.httpContent);
      new MethodOverride().intercept(var6);
      var6.setParser(this.getAbstractGoogleClient().getObjectParser());
      if (this.httpContent == null && (this.requestMethod.equals("POST") || this.requestMethod.equals("PUT") || this.requestMethod.equals("PATCH"))) {
         var6.setContent(new EmptyContent());
      }

      var6.getHeaders().putAll(this.requestHeaders);
      if (!this.disableGZipContent) {
         var6.setEncoding(new GZipEncoding());
      }

      var6.setResponseInterceptor(new HttpResponseInterceptor(this, var6.getResponseInterceptor(), var6) {
         final AbstractGoogleClientRequest this$0;
         final HttpRequest val$httpRequest;
         final HttpResponseInterceptor val$responseInterceptor;

         {
            this.this$0 = var1;
            this.val$responseInterceptor = var2x;
            this.val$httpRequest = var3x;
         }

         @Override
         public void interceptResponse(HttpResponse var1) throws IOException {
            if (this.val$responseInterceptor != null) {
               this.val$responseInterceptor.interceptResponse(var1);
            }

            if (!var1.isSuccessStatusCode() && this.val$httpRequest.getThrowExceptionOnExecuteError()) {
               throw this.this$0.newExceptionOnError(var1);
            }
         }
      });
      return var6;
   }

   private HttpResponse executeUnparsed(boolean var1) throws IOException {
      HttpResponse var2;
      if (this.uploader == null) {
         var2 = this.buildHttpRequest(var1).execute();
      } else {
         GenericUrl var5 = this.buildHttpRequestUrl();
         var1 = this.getAbstractGoogleClient().getRequestFactory().buildRequest(this.requestMethod, var5, this.httpContent).getThrowExceptionOnExecuteError();
         HttpResponse var3 = this.uploader.setInitiationHeaders(this.requestHeaders).setDisableGZipContent(this.disableGZipContent).upload(var5);
         var3.getRequest().setParser(this.getAbstractGoogleClient().getObjectParser());
         var2 = var3;
         if (var1) {
            var2 = var3;
            if (!var3.isSuccessStatusCode()) {
               throw this.newExceptionOnError(var3);
            }
         }
      }

      this.lastResponseHeaders = var2.getHeaders();
      this.lastStatusCode = var2.getStatusCode();
      this.lastStatusMessage = var2.getStatusMessage();
      return var2;
   }

   public HttpRequest buildHttpRequest() throws IOException {
      return this.buildHttpRequest(false);
   }

   public GenericUrl buildHttpRequestUrl() {
      return new GenericUrl(UriTemplate.expand(this.abstractGoogleClient.getBaseUrl(), this.uriTemplate, this, true));
   }

   protected HttpRequest buildHttpRequestUsingHead() throws IOException {
      return this.buildHttpRequest(true);
   }

   protected final void checkRequiredParameter(Object var1, String var2) {
      boolean var3;
      if (!this.abstractGoogleClient.getSuppressRequiredParameterChecks() && var1 == null) {
         var3 = false;
      } else {
         var3 = true;
      }

      Preconditions.checkArgument(var3, "Required parameter %s must be specified", var2);
   }

   public T execute() throws IOException {
      return this.executeUnparsed().parseAs(this.responseClass);
   }

   public void executeAndDownloadTo(OutputStream var1) throws IOException {
      this.executeUnparsed().download(var1);
   }

   public InputStream executeAsInputStream() throws IOException {
      return this.executeUnparsed().getContent();
   }

   protected HttpResponse executeMedia() throws IOException {
      this.set("alt", "media");
      return this.executeUnparsed();
   }

   protected void executeMediaAndDownloadTo(OutputStream var1) throws IOException {
      if (this.downloader == null) {
         this.executeMedia().download(var1);
      } else {
         this.downloader.download(this.buildHttpRequestUrl(), this.requestHeaders, var1);
      }
   }

   protected InputStream executeMediaAsInputStream() throws IOException {
      return this.executeMedia().getContent();
   }

   public HttpResponse executeUnparsed() throws IOException {
      return this.executeUnparsed(false);
   }

   protected HttpResponse executeUsingHead() throws IOException {
      boolean var1;
      if (this.uploader == null) {
         var1 = true;
      } else {
         var1 = false;
      }

      Preconditions.checkArgument(var1);
      HttpResponse var2 = this.executeUnparsed(true);
      var2.ignore();
      return var2;
   }

   public AbstractGoogleClient getAbstractGoogleClient() {
      return this.abstractGoogleClient;
   }

   public final boolean getDisableGZipContent() {
      return this.disableGZipContent;
   }

   public final HttpContent getHttpContent() {
      return this.httpContent;
   }

   public final HttpHeaders getLastResponseHeaders() {
      return this.lastResponseHeaders;
   }

   public final int getLastStatusCode() {
      return this.lastStatusCode;
   }

   public final String getLastStatusMessage() {
      return this.lastStatusMessage;
   }

   public final MediaHttpDownloader getMediaHttpDownloader() {
      return this.downloader;
   }

   public final MediaHttpUploader getMediaHttpUploader() {
      return this.uploader;
   }

   public final HttpHeaders getRequestHeaders() {
      return this.requestHeaders;
   }

   public final String getRequestMethod() {
      return this.requestMethod;
   }

   public final Class<T> getResponseClass() {
      return this.responseClass;
   }

   public final String getUriTemplate() {
      return this.uriTemplate;
   }

   protected final void initializeMediaDownload() {
      HttpRequestFactory var1 = this.abstractGoogleClient.getRequestFactory();
      this.downloader = new MediaHttpDownloader(var1.getTransport(), var1.getInitializer());
   }

   protected final void initializeMediaUpload(AbstractInputStreamContent var1) {
      HttpRequestFactory var2 = this.abstractGoogleClient.getRequestFactory();
      this.uploader = new MediaHttpUploader(var1, var2.getTransport(), var2.getInitializer());
      this.uploader.setInitiationRequestMethod(this.requestMethod);
      if (this.httpContent != null) {
         this.uploader.setMetadata(this.httpContent);
      }
   }

   protected IOException newExceptionOnError(HttpResponse var1) {
      return new HttpResponseException(var1);
   }

   public final <E> void queue(BatchRequest var1, Class<E> var2, BatchCallback<T, E> var3) throws IOException {
      boolean var4;
      if (this.uploader == null) {
         var4 = true;
      } else {
         var4 = false;
      }

      Preconditions.checkArgument(var4, "Batching media requests is not supported");
      var1.queue(this.buildHttpRequest(), this.getResponseClass(), var2, var3);
   }

   public AbstractGoogleClientRequest<T> set(String var1, Object var2) {
      return (AbstractGoogleClientRequest<T>)super.set(var1, var2);
   }

   public AbstractGoogleClientRequest<T> setDisableGZipContent(boolean var1) {
      this.disableGZipContent = var1;
      return this;
   }

   public AbstractGoogleClientRequest<T> setRequestHeaders(HttpHeaders var1) {
      this.requestHeaders = var1;
      return this;
   }
}
