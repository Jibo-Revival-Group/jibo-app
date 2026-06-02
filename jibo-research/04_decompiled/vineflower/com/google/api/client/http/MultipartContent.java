package com.google.api.client.http;

import com.google.api.client.util.Preconditions;
import com.google.api.client.util.StreamingContent;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

public class MultipartContent extends AbstractHttpContent {
   static final String NEWLINE = "\r\n";
   private static final String TWO_DASHES = "--";
   private ArrayList<MultipartContent.Part> parts = new ArrayList<>();

   public MultipartContent() {
      super(new HttpMediaType("multipart/related").setParameter("boundary", "__END_OF_PART__"));
   }

   public MultipartContent addPart(MultipartContent.Part var1) {
      this.parts.add(Preconditions.checkNotNull(var1));
      return this;
   }

   public final String getBoundary() {
      return this.getMediaType().getParameter("boundary");
   }

   public final Collection<MultipartContent.Part> getParts() {
      return Collections.unmodifiableCollection(this.parts);
   }

   @Override
   public boolean retrySupported() {
      Iterator var2 = this.parts.iterator();

      boolean var1;
      while (true) {
         if (var2.hasNext()) {
            if (((MultipartContent.Part)var2.next()).content.retrySupported()) {
               continue;
            }

            var1 = false;
            break;
         }

         var1 = true;
         break;
      }

      return var1;
   }

   public MultipartContent setBoundary(String var1) {
      this.getMediaType().setParameter("boundary", Preconditions.checkNotNull(var1));
      return this;
   }

   public MultipartContent setContentParts(Collection<? extends HttpContent> var1) {
      this.parts = new ArrayList<>(var1.size());
      Iterator var2 = var1.iterator();

      while (var2.hasNext()) {
         this.addPart(new MultipartContent.Part((HttpContent)var2.next()));
      }

      return this;
   }

   public MultipartContent setMediaType(HttpMediaType var1) {
      super.setMediaType(var1);
      return this;
   }

   public MultipartContent setParts(Collection<MultipartContent.Part> var1) {
      this.parts = new ArrayList<>(var1);
      return this;
   }

   @Override
   public void writeTo(OutputStream var1) throws IOException {
      OutputStreamWriter var6 = new OutputStreamWriter(var1, this.getCharset());
      String var7 = this.getBoundary();

      for (MultipartContent.Part var5 : this.parts) {
         HttpHeaders var9 = new HttpHeaders().setAcceptEncoding(null);
         if (var5.headers != null) {
            var9.fromHttpHeaders(var5.headers);
         }

         var9.setContentEncoding(null).setUserAgent(null).setContentType(null).setContentLength(null).set("Content-Transfer-Encoding", null);
         StreamingContent var4 = var5.content;
         StreamingContent var12;
         if (var4 != null) {
            var9.set("Content-Transfer-Encoding", Arrays.asList("binary"));
            var9.setContentType(var4.getType());
            HttpEncoding var10 = var5.encoding;
            long var2;
            if (var10 == null) {
               var2 = var4.getLength();
            } else {
               var9.setContentEncoding(var10.getName());
               HttpEncodingStreamingContent var11 = new HttpEncodingStreamingContent(var4, var10);
               var2 = AbstractHttpContent.computeLength(var4);
               var4 = var11;
            }

            var12 = var4;
            if (var2 != -1L) {
               var9.setContentLength(var2);
               var12 = var4;
            }
         } else {
            var12 = null;
         }

         var6.write("--");
         var6.write(var7);
         var6.write("\r\n");
         HttpHeaders.serializeHeadersForMultipartRequests(var9, null, null, var6);
         if (var12 != null) {
            var6.write("\r\n");
            var6.flush();
            var12.writeTo(var1);
         }

         var6.write("\r\n");
      }

      var6.write("--");
      var6.write(var7);
      var6.write("--");
      var6.write("\r\n");
      var6.flush();
   }

   public static final class Part {
      HttpContent content;
      HttpEncoding encoding;
      HttpHeaders headers;

      public Part() {
         this(null);
      }

      public Part(HttpContent var1) {
         this(null, var1);
      }

      public Part(HttpHeaders var1, HttpContent var2) {
         this.setHeaders(var1);
         this.setContent(var2);
      }

      public HttpContent getContent() {
         return this.content;
      }

      public HttpEncoding getEncoding() {
         return this.encoding;
      }

      public HttpHeaders getHeaders() {
         return this.headers;
      }

      public MultipartContent.Part setContent(HttpContent var1) {
         this.content = var1;
         return this;
      }

      public MultipartContent.Part setEncoding(HttpEncoding var1) {
         this.encoding = var1;
         return this;
      }

      public MultipartContent.Part setHeaders(HttpHeaders var1) {
         this.headers = var1;
         return this;
      }
   }
}
