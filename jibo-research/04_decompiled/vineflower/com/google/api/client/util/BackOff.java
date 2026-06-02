package com.google.api.client.util;

import java.io.IOException;

public interface BackOff {
   long STOP = -1L;
   BackOff STOP_BACKOFF = new BackOff() {
      @Override
      public long nextBackOffMillis() throws IOException {
         return -1L;
      }

      @Override
      public void reset() throws IOException {
      }
   };
   BackOff ZERO_BACKOFF = new BackOff() {
      @Override
      public long nextBackOffMillis() throws IOException {
         return 0L;
      }

      @Override
      public void reset() throws IOException {
      }
   };

   long nextBackOffMillis() throws IOException;

   void reset() throws IOException;
}
