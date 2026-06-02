package org.apache.http.entity;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.http.HttpEntity;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.util.Args;
import org.apache.http.util.EntityUtils;

@NotThreadSafe
public class BufferedHttpEntity extends HttpEntityWrapper {
   private final byte[] buffer;

   public BufferedHttpEntity(HttpEntity var1) throws IOException {
      super(var1);
      if (var1.isRepeatable() && var1.getContentLength() >= 0L) {
         this.buffer = null;
      } else {
         this.buffer = EntityUtils.toByteArray(var1);
      }
   }

   @Override
   public InputStream getContent() throws IOException {
      InputStream var1;
      if (this.buffer != null) {
         var1 = new ByteArrayInputStream(this.buffer);
      } else {
         var1 = super.getContent();
      }

      return var1;
   }

   @Override
   public long getContentLength() {
      long var1;
      if (this.buffer != null) {
         var1 = this.buffer.length;
      } else {
         var1 = super.getContentLength();
      }

      return var1;
   }

   @Override
   public boolean isChunked() {
      boolean var1;
      if (this.buffer == null && super.isChunked()) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   @Override
   public boolean isRepeatable() {
      return true;
   }

   @Override
   public boolean isStreaming() {
      boolean var1;
      if (this.buffer == null && super.isStreaming()) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   @Override
   public void writeTo(OutputStream var1) throws IOException {
      Args.notNull(var1, "Output stream");
      if (this.buffer != null) {
         var1.write(this.buffer);
      } else {
         super.writeTo(var1);
      }
   }
}
