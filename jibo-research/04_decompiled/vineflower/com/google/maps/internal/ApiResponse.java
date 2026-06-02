package com.google.maps.internal;

import com.google.maps.errors.ApiException;

public interface ApiResponse<T> {
   ApiException getError();

   T getResult();

   boolean successful();
}
