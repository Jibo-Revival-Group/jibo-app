package com.salesforce.android.cases.core.requests;

import com.salesforce.android.cases.core.FetchSaveRequestBuilder;

public abstract class NoCacheRequestBuilder<T extends FetchSaveRequestBuilder<T>> extends FetchSaveRequestBuilder<T> {
   public final T a(boolean var1) {
      throw new IllegalStateException("Cannot set return cached results on NoCacheRequest");
   }

   public final T b(boolean var1) {
      throw new IllegalStateException("Cannot set cache results on NoCacheRequest");
   }

   @Override
   public final boolean d() {
      return false;
   }

   @Override
   public final boolean f_() {
      return false;
   }
}
