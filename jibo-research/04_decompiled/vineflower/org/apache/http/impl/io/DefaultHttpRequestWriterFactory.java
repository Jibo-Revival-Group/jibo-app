package org.apache.http.impl.io;

import org.apache.http.HttpRequest;
import org.apache.http.annotation.Immutable;
import org.apache.http.io.HttpMessageWriter;
import org.apache.http.io.HttpMessageWriterFactory;
import org.apache.http.io.SessionOutputBuffer;
import org.apache.http.message.BasicLineFormatter;
import org.apache.http.message.LineFormatter;

@Immutable
public class DefaultHttpRequestWriterFactory implements HttpMessageWriterFactory<HttpRequest> {
   public static final DefaultHttpRequestWriterFactory INSTANCE = new DefaultHttpRequestWriterFactory();
   private final LineFormatter lineFormatter;

   public DefaultHttpRequestWriterFactory() {
      this(null);
   }

   public DefaultHttpRequestWriterFactory(LineFormatter var1) {
      if (var1 == null) {
         var1 = BasicLineFormatter.INSTANCE;
      }

      this.lineFormatter = var1;
   }

   @Override
   public HttpMessageWriter<HttpRequest> create(SessionOutputBuffer var1) {
      return new DefaultHttpRequestWriter(var1, this.lineFormatter);
   }
}
