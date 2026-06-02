package org.apache.http.impl;

import java.io.IOException;
import org.apache.http.HttpConnectionMetrics;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpException;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestFactory;
import org.apache.http.HttpResponse;
import org.apache.http.HttpServerConnection;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.impl.entity.DisallowIdentityContentLengthStrategy;
import org.apache.http.impl.entity.EntityDeserializer;
import org.apache.http.impl.entity.EntitySerializer;
import org.apache.http.impl.entity.LaxContentLengthStrategy;
import org.apache.http.impl.entity.StrictContentLengthStrategy;
import org.apache.http.impl.io.DefaultHttpRequestParser;
import org.apache.http.impl.io.HttpResponseWriter;
import org.apache.http.io.EofSensor;
import org.apache.http.io.HttpMessageParser;
import org.apache.http.io.HttpMessageWriter;
import org.apache.http.io.HttpTransportMetrics;
import org.apache.http.io.SessionInputBuffer;
import org.apache.http.io.SessionOutputBuffer;
import org.apache.http.params.HttpParams;
import org.apache.http.util.Args;

@Deprecated
@NotThreadSafe
public abstract class AbstractHttpServerConnection implements HttpServerConnection {
   private final EntityDeserializer entitydeserializer;
   private final EntitySerializer entityserializer;
   private EofSensor eofSensor;
   private SessionInputBuffer inbuffer = null;
   private HttpConnectionMetricsImpl metrics;
   private SessionOutputBuffer outbuffer = null;
   private HttpMessageParser<HttpRequest> requestParser;
   private HttpMessageWriter<HttpResponse> responseWriter;

   public AbstractHttpServerConnection() {
      this.eofSensor = null;
      this.requestParser = null;
      this.responseWriter = null;
      this.metrics = null;
      this.entityserializer = this.createEntitySerializer();
      this.entitydeserializer = this.createEntityDeserializer();
   }

   protected abstract void assertOpen() throws IllegalStateException;

   protected HttpConnectionMetricsImpl createConnectionMetrics(HttpTransportMetrics var1, HttpTransportMetrics var2) {
      return new HttpConnectionMetricsImpl(var1, var2);
   }

   protected EntityDeserializer createEntityDeserializer() {
      return new EntityDeserializer(new DisallowIdentityContentLengthStrategy(new LaxContentLengthStrategy(0)));
   }

   protected EntitySerializer createEntitySerializer() {
      return new EntitySerializer(new StrictContentLengthStrategy());
   }

   protected HttpRequestFactory createHttpRequestFactory() {
      return DefaultHttpRequestFactory.INSTANCE;
   }

   protected HttpMessageParser<HttpRequest> createRequestParser(SessionInputBuffer var1, HttpRequestFactory var2, HttpParams var3) {
      return new DefaultHttpRequestParser(var1, null, var2, var3);
   }

   protected HttpMessageWriter<HttpResponse> createResponseWriter(SessionOutputBuffer var1, HttpParams var2) {
      return new HttpResponseWriter(var1, null, var2);
   }

   protected void doFlush() throws IOException {
      this.outbuffer.flush();
   }

   @Override
   public void flush() throws IOException {
      this.assertOpen();
      this.doFlush();
   }

   @Override
   public HttpConnectionMetrics getMetrics() {
      return this.metrics;
   }

   protected void init(SessionInputBuffer var1, SessionOutputBuffer var2, HttpParams var3) {
      this.inbuffer = Args.notNull(var1, "Input session buffer");
      this.outbuffer = Args.notNull(var2, "Output session buffer");
      if (var1 instanceof EofSensor) {
         this.eofSensor = (EofSensor)var1;
      }

      this.requestParser = this.createRequestParser(var1, this.createHttpRequestFactory(), var3);
      this.responseWriter = this.createResponseWriter(var2, var3);
      this.metrics = this.createConnectionMetrics(var1.getMetrics(), var2.getMetrics());
   }

   protected boolean isEof() {
      boolean var1;
      if (this.eofSensor != null && this.eofSensor.isEof()) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   @Override
   public boolean isStale() {
      boolean var2 = true;
      boolean var1;
      if (!this.isOpen()) {
         var1 = var2;
      } else {
         var1 = var2;
         if (!this.isEof()) {
            try {
               this.inbuffer.isDataAvailable(1);
               var1 = this.isEof();
            } catch (IOException var4) {
               var1 = var2;
            }
         }
      }

      return var1;
   }

   @Override
   public void receiveRequestEntity(HttpEntityEnclosingRequest var1) throws HttpException, IOException {
      Args.notNull(var1, "HTTP request");
      this.assertOpen();
      var1.setEntity(this.entitydeserializer.deserialize(this.inbuffer, var1));
   }

   @Override
   public HttpRequest receiveRequestHeader() throws HttpException, IOException {
      this.assertOpen();
      HttpRequest var1 = this.requestParser.parse();
      this.metrics.incrementRequestCount();
      return var1;
   }

   @Override
   public void sendResponseEntity(HttpResponse var1) throws HttpException, IOException {
      if (var1.getEntity() != null) {
         this.entityserializer.serialize(this.outbuffer, var1, var1.getEntity());
      }
   }

   @Override
   public void sendResponseHeader(HttpResponse var1) throws HttpException, IOException {
      Args.notNull(var1, "HTTP response");
      this.assertOpen();
      this.responseWriter.write(var1);
      if (var1.getStatusLine().getStatusCode() >= 200) {
         this.metrics.incrementResponseCount();
      }
   }
}
