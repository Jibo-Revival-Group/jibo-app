package org.apache.http.entity;

import java.io.IOException;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.message.BasicHeader;

@NotThreadSafe
public abstract class AbstractHttpEntity implements HttpEntity {
   protected static final int OUTPUT_BUFFER_SIZE = 4096;
   protected boolean chunked;
   protected Header contentEncoding;
   protected Header contentType;

   protected AbstractHttpEntity() {
   }

   @Deprecated
   @Override
   public void consumeContent() throws IOException {
   }

   @Override
   public Header getContentEncoding() {
      return this.contentEncoding;
   }

   @Override
   public Header getContentType() {
      return this.contentType;
   }

   @Override
   public boolean isChunked() {
      return this.chunked;
   }

   public void setChunked(boolean var1) {
      this.chunked = var1;
   }

   public void setContentEncoding(String var1) {
      BasicHeader var2 = null;
      if (var1 != null) {
         var2 = new BasicHeader("Content-Encoding", var1);
      }

      this.setContentEncoding(var2);
   }

   public void setContentEncoding(Header var1) {
      this.contentEncoding = var1;
   }

   public void setContentType(String var1) {
      BasicHeader var2 = null;
      if (var1 != null) {
         var2 = new BasicHeader("Content-Type", var1);
      }

      this.setContentType(var2);
   }

   public void setContentType(Header var1) {
      this.contentType = var1;
   }

   @Override
   public String toString() {
      StringBuilder var3 = new StringBuilder();
      var3.append('[');
      if (this.contentType != null) {
         var3.append("Content-Type: ");
         var3.append(this.contentType.getValue());
         var3.append(',');
      }

      if (this.contentEncoding != null) {
         var3.append("Content-Encoding: ");
         var3.append(this.contentEncoding.getValue());
         var3.append(',');
      }

      long var1 = this.getContentLength();
      if (var1 >= 0L) {
         var3.append("Content-Length: ");
         var3.append(var1);
         var3.append(',');
      }

      var3.append("Chunked: ");
      var3.append(this.chunked);
      var3.append(']');
      return var3.toString();
   }
}
