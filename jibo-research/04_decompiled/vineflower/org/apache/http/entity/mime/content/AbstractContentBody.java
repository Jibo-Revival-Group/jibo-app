package org.apache.http.entity.mime.content;

import java.nio.charset.Charset;
import org.apache.http.entity.ContentType;
import org.apache.http.util.Args;

public abstract class AbstractContentBody implements ContentBody {
   private final ContentType contentType;

   @Deprecated
   public AbstractContentBody(String var1) {
      this(ContentType.parse(var1));
   }

   public AbstractContentBody(ContentType var1) {
      Args.notNull(var1, "Content type");
      this.contentType = var1;
   }

   @Override
   public String getCharset() {
      Charset var1 = this.contentType.getCharset();
      String var2;
      if (var1 != null) {
         var2 = var1.name();
      } else {
         var2 = null;
      }

      return var2;
   }

   public ContentType getContentType() {
      return this.contentType;
   }

   @Override
   public String getMediaType() {
      String var3 = this.contentType.getMimeType();
      int var1 = var3.indexOf(47);
      String var2 = var3;
      if (var1 != -1) {
         var2 = var3.substring(0, var1);
      }

      return var2;
   }

   @Override
   public String getMimeType() {
      return this.contentType.getMimeType();
   }

   @Override
   public String getSubType() {
      String var2 = this.contentType.getMimeType();
      int var1 = var2.indexOf(47);
      if (var1 != -1) {
         var2 = var2.substring(var1 + 1);
      } else {
         var2 = null;
      }

      return var2;
   }
}
