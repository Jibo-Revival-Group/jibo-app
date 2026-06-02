package com.google.api.client.http.apache;

import com.google.api.client.util.Preconditions;
import com.google.api.client.util.StreamingContent;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.http.entity.AbstractHttpEntity;

final class ContentEntity extends AbstractHttpEntity {
   private final long contentLength;
   private final StreamingContent streamingContent;

   ContentEntity(long var1, StreamingContent var3) {
      this.contentLength = var1;
      this.streamingContent = Preconditions.checkNotNull(var3);
   }

   @Override
   public InputStream getContent() {
      throw new UnsupportedOperationException();
   }

   @Override
   public long getContentLength() {
      return this.contentLength;
   }

   @Override
   public boolean isRepeatable() {
      return false;
   }

   @Override
   public boolean isStreaming() {
      return true;
   }

   @Override
   public void writeTo(OutputStream var1) throws IOException {
      if (this.contentLength != 0L) {
         this.streamingContent.writeTo(var1);
      }
   }
}
