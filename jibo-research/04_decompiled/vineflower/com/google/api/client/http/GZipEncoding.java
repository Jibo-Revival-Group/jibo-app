package com.google.api.client.http;

import com.google.api.client.util.StreamingContent;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.GZIPOutputStream;

public class GZipEncoding implements HttpEncoding {
   @Override
   public void encode(StreamingContent var1, OutputStream var2) throws IOException {
      var2 = new GZIPOutputStream(new BufferedOutputStream(this, var2) {
         final GZipEncoding this$0;

         {
            this.this$0 = var1;
         }

         @Override
         public void close() throws IOException {
            try {
               this.flush();
            } catch (IOException var2x) {
            }
         }
      });
      var1.writeTo(var2);
      var2.close();
   }

   @Override
   public String getName() {
      return "gzip";
   }
}
