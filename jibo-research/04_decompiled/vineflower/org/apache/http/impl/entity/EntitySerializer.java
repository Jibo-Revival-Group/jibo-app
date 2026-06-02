package org.apache.http.impl.entity;

import java.io.IOException;
import java.io.OutputStream;
import org.apache.http.HttpEntity;
import org.apache.http.HttpException;
import org.apache.http.HttpMessage;
import org.apache.http.annotation.Immutable;
import org.apache.http.entity.ContentLengthStrategy;
import org.apache.http.impl.io.ChunkedOutputStream;
import org.apache.http.impl.io.ContentLengthOutputStream;
import org.apache.http.impl.io.IdentityOutputStream;
import org.apache.http.io.SessionOutputBuffer;
import org.apache.http.util.Args;

@Deprecated
@Immutable
public class EntitySerializer {
   private final ContentLengthStrategy lenStrategy;

   public EntitySerializer(ContentLengthStrategy var1) {
      this.lenStrategy = Args.notNull(var1, "Content length strategy");
   }

   protected OutputStream doSerialize(SessionOutputBuffer var1, HttpMessage var2) throws HttpException, IOException {
      long var3 = this.lenStrategy.determineLength(var2);
      OutputStream var5;
      if (var3 == -2L) {
         var5 = new ChunkedOutputStream(var1);
      } else if (var3 == -1L) {
         var5 = new IdentityOutputStream(var1);
      } else {
         var5 = new ContentLengthOutputStream(var1, var3);
      }

      return var5;
   }

   public void serialize(SessionOutputBuffer var1, HttpMessage var2, HttpEntity var3) throws HttpException, IOException {
      Args.notNull(var1, "Session output buffer");
      Args.notNull(var2, "HTTP message");
      Args.notNull(var3, "HTTP entity");
      OutputStream var4 = this.doSerialize(var1, var2);
      var3.writeTo(var4);
      var4.close();
   }
}
