package com.google.maps;

import com.google.maps.errors.ApiException;
import com.google.maps.internal.ApiConfig;
import com.google.maps.internal.ApiResponse;
import com.google.maps.internal.StringJoin;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

abstract class PendingResultBase<T, A extends PendingResultBase<T, A, R>, R extends ApiResponse<T>> implements PendingResult<T> {
   private final ApiConfig config;
   private final GeoApiContext context;
   private PendingResult<T> delegate;
   private HashMap<String, String> params = new HashMap<>();
   private Class<? extends R> responseClass;

   protected PendingResultBase(GeoApiContext var1, ApiConfig var2, Class<? extends R> var3) {
      this.context = var1;
      this.config = var2;
      this.responseClass = var3;
   }

   private PendingResult<T> makeRequest() {
      if (this.delegate != null) {
         throw new IllegalStateException("'await', 'awaitIgnoreError' or 'setCallback' was already called.");
      }

      this.validateRequest();
      PendingResult var3;
      switch (this.config.requestVerb) {
         case "GET":
            var3 = this.context.get(this.config, this.responseClass, this.params);
            this.delegate = var3;
            break;
         case "POST":
            var3 = this.context.post(this.config, this.responseClass, this.params);
            this.delegate = var3;
            break;
         default:
            throw new IllegalStateException(String.format("Unexpected request method '%s'", this.config.requestVerb));
      }

      return var3;
   }

   @Override
   public final T await() throws ApiException, InterruptedException, IOException {
      return this.makeRequest().await();
   }

   @Override
   public final T awaitIgnoreError() {
      return this.makeRequest().awaitIgnoreError();
   }

   @Override
   public final void cancel() {
      if (this.delegate != null) {
         this.delegate.cancel();
      }
   }

   public A channel(String var1) {
      return this.param("channel", var1);
   }

   public A custom(String var1, String var2) {
      return this.param(var1, var2);
   }

   public final A language(String var1) {
      return this.param("language", var1);
   }

   protected A param(String var1, StringJoin.UrlValue var2) {
      this.params.put(var1, var2.toUrlValue());
      return (A)this;
   }

   protected A param(String var1, String var2) {
      this.params.put(var1, var2);
      return (A)this;
   }

   protected Map<String, String> params() {
      return Collections.unmodifiableMap(this.params);
   }

   @Override
   public final void setCallback(PendingResult.Callback<T> var1) {
      this.makeRequest().setCallback(var1);
   }

   protected abstract void validateRequest();
}
