package org.apache.http.entity.mime;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.http.HttpEntity;
import org.apache.http.message.BasicHeader;

class MultipartFormEntity implements HttpEntity {
   private final long contentLength;
   private final org.apache.http.Header contentType;
   private final AbstractMultipartForm multipart;

   MultipartFormEntity(AbstractMultipartForm var1, String var2, long var3) {
      this.multipart = var1;
      this.contentType = new BasicHeader("Content-Type", var2);
      this.contentLength = var3;
   }

   @Override
   public void consumeContent() throws IOException, UnsupportedOperationException {
      if (this.isStreaming()) {
         throw new UnsupportedOperationException("Streaming entity does not implement #consumeContent()");
      }
   }

   @Override
   public InputStream getContent() throws IOException {
      throw new UnsupportedOperationException("Multipart form entity does not implement #getContent()");
   }

   @Override
   public org.apache.http.Header getContentEncoding() {
      return null;
   }

   @Override
   public long getContentLength() {
      return this.contentLength;
   }

   @Override
   public org.apache.http.Header getContentType() {
      return this.contentType;
   }

   AbstractMultipartForm getMultipart() {
      return this.multipart;
   }

   @Override
   public boolean isChunked() {
      boolean var1;
      if (!this.isRepeatable()) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   @Override
   public boolean isRepeatable() {
      boolean var1;
      if (this.contentLength != -1L) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   @Override
   public boolean isStreaming() {
      boolean var1;
      if (!this.isRepeatable()) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   @Override
   public void writeTo(OutputStream var1) throws IOException {
      this.multipart.writeTo(var1);
   }
}
