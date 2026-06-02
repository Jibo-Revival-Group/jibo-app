package org.apache.http.impl;

import java.io.IOException;
import java.net.Socket;
import org.apache.http.HttpConnectionFactory;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.annotation.Immutable;
import org.apache.http.config.ConnectionConfig;
import org.apache.http.entity.ContentLengthStrategy;
import org.apache.http.io.HttpMessageParserFactory;
import org.apache.http.io.HttpMessageWriterFactory;

@Immutable
public class DefaultBHttpServerConnectionFactory implements HttpConnectionFactory<DefaultBHttpServerConnection> {
   public static final DefaultBHttpServerConnectionFactory INSTANCE = new DefaultBHttpServerConnectionFactory();
   private final ConnectionConfig cconfig;
   private final ContentLengthStrategy incomingContentStrategy;
   private final ContentLengthStrategy outgoingContentStrategy;
   private final HttpMessageParserFactory<HttpRequest> requestParserFactory;
   private final HttpMessageWriterFactory<HttpResponse> responseWriterFactory;

   public DefaultBHttpServerConnectionFactory() {
      this(null, null, null, null, null);
   }

   public DefaultBHttpServerConnectionFactory(ConnectionConfig var1) {
      this(var1, null, null, null, null);
   }

   public DefaultBHttpServerConnectionFactory(
      ConnectionConfig var1,
      ContentLengthStrategy var2,
      ContentLengthStrategy var3,
      HttpMessageParserFactory<HttpRequest> var4,
      HttpMessageWriterFactory<HttpResponse> var5
   ) {
      if (var1 == null) {
         var1 = ConnectionConfig.DEFAULT;
      }

      this.cconfig = var1;
      this.incomingContentStrategy = var2;
      this.outgoingContentStrategy = var3;
      this.requestParserFactory = var4;
      this.responseWriterFactory = var5;
   }

   public DefaultBHttpServerConnectionFactory(ConnectionConfig var1, HttpMessageParserFactory<HttpRequest> var2, HttpMessageWriterFactory<HttpResponse> var3) {
      this(var1, null, null, var2, var3);
   }

   public DefaultBHttpServerConnection createConnection(Socket var1) throws IOException {
      DefaultBHttpServerConnection var2 = new DefaultBHttpServerConnection(
         this.cconfig.getBufferSize(),
         this.cconfig.getFragmentSizeHint(),
         ConnSupport.createDecoder(this.cconfig),
         ConnSupport.createEncoder(this.cconfig),
         this.cconfig.getMessageConstraints(),
         this.incomingContentStrategy,
         this.outgoingContentStrategy,
         this.requestParserFactory,
         this.responseWriterFactory
      );
      var2.bind(var1);
      return var2;
   }
}
