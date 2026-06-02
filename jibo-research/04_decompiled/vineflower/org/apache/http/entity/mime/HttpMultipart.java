package org.apache.http.entity.mime;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Deprecated
public class HttpMultipart extends AbstractMultipartForm {
   private final HttpMultipartMode mode;
   private final List<FormBodyPart> parts;

   public HttpMultipart(String var1, String var2) {
      this(var1, null, var2);
   }

   public HttpMultipart(String var1, Charset var2, String var3) {
      this(var1, var2, var3, HttpMultipartMode.STRICT);
   }

   public HttpMultipart(String var1, Charset var2, String var3, HttpMultipartMode var4) {
      super(var1, var2, var3);
      this.mode = var4;
      this.parts = new ArrayList<>();
   }

   public void addBodyPart(FormBodyPart var1) {
      if (var1 != null) {
         this.parts.add(var1);
      }
   }

   @Override
   protected void formatMultipartHeader(FormBodyPart var1, OutputStream var2) throws IOException {
      Header var3 = var1.getHeader();
      switch (<unrepresentable>.$SwitchMap$org$apache$http$entity$mime$HttpMultipartMode[this.mode.ordinal()]) {
         case 1:
            writeField(var3.getField("Content-Disposition"), this.charset, var2);
            if (var1.getBody().getFilename() != null) {
               writeField(var3.getField("Content-Type"), this.charset, var2);
            }
            break;
         default:
            Iterator var4 = var3.iterator();

            while (var4.hasNext()) {
               writeField((MinimalField)var4.next(), var2);
            }
      }
   }

   @Override
   public List<FormBodyPart> getBodyParts() {
      return this.parts;
   }

   public HttpMultipartMode getMode() {
      return this.mode;
   }
}
