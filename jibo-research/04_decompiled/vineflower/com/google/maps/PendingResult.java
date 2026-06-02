package com.google.maps;

import com.google.maps.errors.ApiException;
import java.io.IOException;

public interface PendingResult<T> {
   T await() throws ApiException, InterruptedException, IOException;

   T awaitIgnoreError();

   void cancel();

   void setCallback(PendingResult.Callback<T> var1);

   interface Callback<T> {
      void onFailure(Throwable var1);

      void onResult(T var1);
   }
}
