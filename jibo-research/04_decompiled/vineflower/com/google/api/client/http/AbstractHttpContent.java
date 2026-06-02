package com.google.api.client.http;

import com.google.api.client.util.Charsets;
import com.google.api.client.util.IOUtils;
import java.io.IOException;
import java.nio.charset.Charset;

public abstract class AbstractHttpContent implements HttpContent {
   private long computedLength = -1L;
   private HttpMediaType mediaType;

   protected AbstractHttpContent(HttpMediaType var1) {
      this.mediaType = var1;
   }

   protected AbstractHttpContent(String var1) {
      HttpMediaType var2;
      if (var1 == null) {
         var2 = null;
      } else {
         var2 = new HttpMediaType(var1);
      }

      this(var2);
   }

   public static long computeLength(HttpContent var0) throws IOException {
      long var1;
      if (!var0.retrySupported()) {
         var1 = -1L;
      } else {
         var1 = IOUtils.computeLength(var0);
      }

      return var1;
   }

   protected long computeLength() throws IOException {
      return computeLength(this);
   }

   protected final Charset getCharset() {
      Charset var1;
      if (this.mediaType != null && this.mediaType.getCharsetParameter() != null) {
         var1 = this.mediaType.getCharsetParameter();
      } else {
         var1 = Charsets.UTF_8;
      }

      return var1;
   }

   @Override
   public long getLength() throws IOException {
      if (this.computedLength == -1L) {
         this.computedLength = this.computeLength();
      }

      return this.computedLength;
   }

   public final HttpMediaType getMediaType() {
      return this.mediaType;
   }

   @Override
   public String getType() {
      String var1;
      if (this.mediaType == null) {
         var1 = null;
      } else {
         var1 = this.mediaType.build();
      }

      return var1;
   }

   @Override
   public boolean retrySupported() {
      return true;
   }

   public AbstractHttpContent setMediaType(HttpMediaType var1) {
      this.mediaType = var1;
      return this;
   }
}
