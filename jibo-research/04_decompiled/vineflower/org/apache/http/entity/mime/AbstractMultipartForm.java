package org.apache.http.entity.mime;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.List;
import org.apache.http.util.Args;
import org.apache.http.util.ByteArrayBuffer;

abstract class AbstractMultipartForm {
   private static final ByteArrayBuffer CR_LF = encode(MIME.DEFAULT_CHARSET, "\r\n");
   private static final ByteArrayBuffer FIELD_SEP = encode(MIME.DEFAULT_CHARSET, ": ");
   private static final ByteArrayBuffer TWO_DASHES = encode(MIME.DEFAULT_CHARSET, "--");
   private final String boundary;
   protected final Charset charset;
   private final String subType;

   public AbstractMultipartForm(String var1, String var2) {
      this(var1, null, var2);
   }

   public AbstractMultipartForm(String var1, Charset var2, String var3) {
      Args.notNull(var1, "Multipart subtype");
      Args.notNull(var3, "Multipart boundary");
      this.subType = var1;
      if (var2 == null) {
         var2 = MIME.DEFAULT_CHARSET;
      }

      this.charset = var2;
      this.boundary = var3;
   }

   private static ByteArrayBuffer encode(Charset var0, String var1) {
      ByteBuffer var3 = var0.encode(CharBuffer.wrap(var1));
      ByteArrayBuffer var2 = new ByteArrayBuffer(var3.remaining());
      var2.append(var3.array(), var3.position(), var3.remaining());
      return var2;
   }

   private static void writeBytes(String var0, OutputStream var1) throws IOException {
      writeBytes(encode(MIME.DEFAULT_CHARSET, var0), var1);
   }

   private static void writeBytes(String var0, Charset var1, OutputStream var2) throws IOException {
      writeBytes(encode(var1, var0), var2);
   }

   private static void writeBytes(ByteArrayBuffer var0, OutputStream var1) throws IOException {
      var1.write(var0.buffer(), 0, var0.length());
   }

   protected static void writeField(MinimalField var0, OutputStream var1) throws IOException {
      writeBytes(var0.getName(), var1);
      writeBytes(FIELD_SEP, var1);
      writeBytes(var0.getBody(), var1);
      writeBytes(CR_LF, var1);
   }

   protected static void writeField(MinimalField var0, Charset var1, OutputStream var2) throws IOException {
      writeBytes(var0.getName(), var1, var2);
      writeBytes(FIELD_SEP, var2);
      writeBytes(var0.getBody(), var1, var2);
      writeBytes(CR_LF, var2);
   }

   void doWriteTo(OutputStream var1, boolean var2) throws IOException {
      ByteArrayBuffer var3 = encode(this.charset, this.getBoundary());

      for (FormBodyPart var4 : this.getBodyParts()) {
         writeBytes(TWO_DASHES, var1);
         writeBytes(var3, var1);
         writeBytes(CR_LF, var1);
         this.formatMultipartHeader(var4, var1);
         writeBytes(CR_LF, var1);
         if (var2) {
            var4.getBody().writeTo(var1);
         }

         writeBytes(CR_LF, var1);
      }

      writeBytes(TWO_DASHES, var1);
      writeBytes(var3, var1);
      writeBytes(TWO_DASHES, var1);
      writeBytes(CR_LF, var1);
   }

   protected abstract void formatMultipartHeader(FormBodyPart var1, OutputStream var2) throws IOException;

   public abstract List<FormBodyPart> getBodyParts();

   public String getBoundary() {
      return this.boundary;
   }

   public Charset getCharset() {
      return this.charset;
   }

   public String getSubType() {
      return this.subType;
   }

   public long getTotalLength() {
      Iterator var6 = this.getBodyParts().iterator();
      long var2 = 0L;

      while (true) {
         if (var6.hasNext()) {
            long var4 = ((FormBodyPart)var6.next()).getBody().getContentLength();
            if (var4 >= 0L) {
               var2 += var4;
               continue;
            }

            var2 = -1L;
            break;
         }

         ByteArrayOutputStream var9 = new ByteArrayOutputStream();

         int var1;
         try {
            this.doWriteTo(var9, false);
            var1 = var9.toByteArray().length;
         } catch (IOException var7) {
            var2 = -1L;
            break;
         }

         var2 = var1 + var2;
         break;
      }

      return var2;
   }

   public void writeTo(OutputStream var1) throws IOException {
      this.doWriteTo(var1, true);
   }
}
