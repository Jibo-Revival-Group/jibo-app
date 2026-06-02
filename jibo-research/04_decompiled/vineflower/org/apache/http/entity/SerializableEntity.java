package org.apache.http.entity;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.util.Args;

@NotThreadSafe
public class SerializableEntity extends AbstractHttpEntity {
   private Serializable objRef;
   private byte[] objSer;

   public SerializableEntity(Serializable var1) {
      Args.notNull(var1, "Source object");
      this.objRef = var1;
   }

   public SerializableEntity(Serializable var1, boolean var2) throws IOException {
      Args.notNull(var1, "Source object");
      if (var2) {
         this.createBytes(var1);
      } else {
         this.objRef = var1;
      }
   }

   private void createBytes(Serializable var1) throws IOException {
      ByteArrayOutputStream var3 = new ByteArrayOutputStream();
      ObjectOutputStream var2 = new ObjectOutputStream(var3);
      var2.writeObject(var1);
      var2.flush();
      this.objSer = var3.toByteArray();
   }

   @Override
   public InputStream getContent() throws IOException, IllegalStateException {
      if (this.objSer == null) {
         this.createBytes(this.objRef);
      }

      return new ByteArrayInputStream(this.objSer);
   }

   @Override
   public long getContentLength() {
      long var1;
      if (this.objSer == null) {
         var1 = -1L;
      } else {
         var1 = this.objSer.length;
      }

      return var1;
   }

   @Override
   public boolean isRepeatable() {
      return true;
   }

   @Override
   public boolean isStreaming() {
      boolean var1;
      if (this.objSer == null) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   @Override
   public void writeTo(OutputStream var1) throws IOException {
      Args.notNull(var1, "Output stream");
      if (this.objSer == null) {
         var1 = new ObjectOutputStream(var1);
         var1.writeObject(this.objRef);
         var1.flush();
      } else {
         var1.write(this.objSer);
         var1.flush();
      }
   }
}
