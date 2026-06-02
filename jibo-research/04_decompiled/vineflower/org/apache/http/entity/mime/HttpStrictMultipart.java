package org.apache.http.entity.mime;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.List;

class HttpStrictMultipart extends AbstractMultipartForm {
   private final List<FormBodyPart> parts;

   public HttpStrictMultipart(String var1, Charset var2, String var3, List<FormBodyPart> var4) {
      super(var1, var2, var3);
      this.parts = var4;
   }

   @Override
   protected void formatMultipartHeader(FormBodyPart var1, OutputStream var2) throws IOException {
      Iterator var3 = var1.getHeader().iterator();

      while (var3.hasNext()) {
         writeField((MinimalField)var3.next(), var2);
      }
   }

   @Override
   public List<FormBodyPart> getBodyParts() {
      return this.parts;
   }
}
