package com.google.api.client.http;

import java.io.IOException;
import java.io.OutputStream;

public class EmptyContent implements HttpContent {
   @Override
   public long getLength() throws IOException {
      return 0L;
   }

   @Override
   public String getType() {
      return null;
   }

   @Override
   public boolean retrySupported() {
      return true;
   }

   @Override
   public void writeTo(OutputStream var1) throws IOException {
      var1.flush();
   }
}
