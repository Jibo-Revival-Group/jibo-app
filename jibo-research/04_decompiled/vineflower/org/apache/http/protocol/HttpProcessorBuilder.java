package org.apache.http.protocol;

import java.util.LinkedList;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.HttpResponseInterceptor;

public class HttpProcessorBuilder {
   private ChainBuilder<HttpRequestInterceptor> requestChainBuilder;
   private ChainBuilder<HttpResponseInterceptor> responseChainBuilder;

   HttpProcessorBuilder() {
   }

   public static HttpProcessorBuilder create() {
      return new HttpProcessorBuilder();
   }

   private ChainBuilder<HttpRequestInterceptor> getRequestChainBuilder() {
      if (this.requestChainBuilder == null) {
         this.requestChainBuilder = new ChainBuilder<>();
      }

      return this.requestChainBuilder;
   }

   private ChainBuilder<HttpResponseInterceptor> getResponseChainBuilder() {
      if (this.responseChainBuilder == null) {
         this.responseChainBuilder = new ChainBuilder<>();
      }

      return this.responseChainBuilder;
   }

   public HttpProcessorBuilder add(HttpRequestInterceptor var1) {
      return this.addLast(var1);
   }

   public HttpProcessorBuilder add(HttpResponseInterceptor var1) {
      return this.addLast(var1);
   }

   public HttpProcessorBuilder addAll(HttpRequestInterceptor... var1) {
      return this.addAllLast(var1);
   }

   public HttpProcessorBuilder addAll(HttpResponseInterceptor... var1) {
      return this.addAllLast(var1);
   }

   public HttpProcessorBuilder addAllFirst(HttpRequestInterceptor... var1) {
      if (var1 != null) {
         this.getRequestChainBuilder().addAllFirst(var1);
      }

      return this;
   }

   public HttpProcessorBuilder addAllFirst(HttpResponseInterceptor... var1) {
      if (var1 != null) {
         this.getResponseChainBuilder().addAllFirst(var1);
      }

      return this;
   }

   public HttpProcessorBuilder addAllLast(HttpRequestInterceptor... var1) {
      if (var1 != null) {
         this.getRequestChainBuilder().addAllLast(var1);
      }

      return this;
   }

   public HttpProcessorBuilder addAllLast(HttpResponseInterceptor... var1) {
      if (var1 != null) {
         this.getResponseChainBuilder().addAllLast(var1);
      }

      return this;
   }

   public HttpProcessorBuilder addFirst(HttpRequestInterceptor var1) {
      if (var1 != null) {
         this.getRequestChainBuilder().addFirst(var1);
      }

      return this;
   }

   public HttpProcessorBuilder addFirst(HttpResponseInterceptor var1) {
      if (var1 != null) {
         this.getResponseChainBuilder().addFirst(var1);
      }

      return this;
   }

   public HttpProcessorBuilder addLast(HttpRequestInterceptor var1) {
      if (var1 != null) {
         this.getRequestChainBuilder().addLast(var1);
      }

      return this;
   }

   public HttpProcessorBuilder addLast(HttpResponseInterceptor var1) {
      if (var1 != null) {
         this.getResponseChainBuilder().addLast(var1);
      }

      return this;
   }

   public HttpProcessor build() {
      LinkedList var2 = null;
      LinkedList var1;
      if (this.requestChainBuilder != null) {
         var1 = this.requestChainBuilder.build();
      } else {
         var1 = null;
      }

      if (this.responseChainBuilder != null) {
         var2 = this.responseChainBuilder.build();
      }

      return new ImmutableHttpProcessor(var1, var2);
   }
}
