package com.bumptech.glide.load.model;

import java.util.Collections;
import java.util.Map;

public interface Headers {
   Headers DEFAULT = new LazyHeaders.Builder().build();
   @Deprecated
   Headers NONE = new Headers() {
      @Override
      public Map<String, String> getHeaders() {
         return Collections.emptyMap();
      }
   };

   Map<String, String> getHeaders();
}
