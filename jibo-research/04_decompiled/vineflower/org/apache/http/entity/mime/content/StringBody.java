package org.apache.http.entity.mime.content;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;
import org.apache.http.Consts;
import org.apache.http.entity.ContentType;
import org.apache.http.util.Args;

public class StringBody extends AbstractContentBody {
   private final byte[] content;

   @Deprecated
   public StringBody(String var1) throws UnsupportedEncodingException {
      this(var1, "text/plain", Consts.ASCII);
   }

   @Deprecated
   public StringBody(String var1, String var2, Charset var3) throws UnsupportedEncodingException {
      this(var1, ContentType.create(var2, var3));
   }

   @Deprecated
   public StringBody(String var1, Charset var2) throws UnsupportedEncodingException {
      this(var1, "text/plain", var2);
   }

   public StringBody(String var1, ContentType var2) {
      super(var2);
      Charset var4 = var2.getCharset();
      String var5;
      if (var4 != null) {
         var5 = var4.name();
      } else {
         var5 = Consts.ASCII.name();
      }

      try {
         this.content = var1.getBytes(var5);
      } catch (UnsupportedEncodingException var3) {
         throw new UnsupportedCharsetException(var5);
      }
   }

   @Deprecated
   public static StringBody create(String var0) throws IllegalArgumentException {
      return create(var0, null, null);
   }

   @Deprecated
   public static StringBody create(String var0, String var1, Charset var2) throws IllegalArgumentException {
      try {
         return new StringBody(var0, var1, var2);
      } catch (UnsupportedEncodingException var3) {
         throw new IllegalArgumentException("Charset " + var2 + " is not supported", var3);
      }
   }

   @Deprecated
   public static StringBody create(String var0, Charset var1) throws IllegalArgumentException {
      return create(var0, null, var1);
   }

   @Override
   public long getContentLength() {
      return this.content.length;
   }

   @Override
   public String getFilename() {
      return null;
   }

   public Reader getReader() {
      Charset var1 = this.getContentType().getCharset();
      ByteArrayInputStream var2 = new ByteArrayInputStream(this.content);
      if (var1 == null) {
         var1 = Consts.ASCII;
      }

      return new InputStreamReader(var2, var1);
   }

   @Override
   public String getTransferEncoding() {
      return "8bit";
   }

   @Override
   public void writeTo(OutputStream var1) throws IOException {
      Args.notNull(var1, "Output stream");
      ByteArrayInputStream var4 = new ByteArrayInputStream(this.content);
      byte[] var3 = new byte[4096];

      while (true) {
         int var2 = var4.read(var3);
         if (var2 == -1) {
            var1.flush();
            return;
         }

         var1.write(var3, 0, var2);
      }
   }
}
