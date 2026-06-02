package org.apache.http.impl;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.util.concurrent.atomic.AtomicReference;
import org.apache.http.Header;
import org.apache.http.HttpConnection;
import org.apache.http.HttpConnectionMetrics;
import org.apache.http.HttpEntity;
import org.apache.http.HttpException;
import org.apache.http.HttpInetConnection;
import org.apache.http.HttpMessage;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.config.MessageConstraints;
import org.apache.http.entity.BasicHttpEntity;
import org.apache.http.entity.ContentLengthStrategy;
import org.apache.http.impl.entity.LaxContentLengthStrategy;
import org.apache.http.impl.entity.StrictContentLengthStrategy;
import org.apache.http.impl.io.ChunkedInputStream;
import org.apache.http.impl.io.ChunkedOutputStream;
import org.apache.http.impl.io.ContentLengthInputStream;
import org.apache.http.impl.io.ContentLengthOutputStream;
import org.apache.http.impl.io.EmptyInputStream;
import org.apache.http.impl.io.HttpTransportMetricsImpl;
import org.apache.http.impl.io.IdentityInputStream;
import org.apache.http.impl.io.IdentityOutputStream;
import org.apache.http.impl.io.SessionInputBufferImpl;
import org.apache.http.impl.io.SessionOutputBufferImpl;
import org.apache.http.io.SessionInputBuffer;
import org.apache.http.io.SessionOutputBuffer;
import org.apache.http.util.Args;
import org.apache.http.util.Asserts;
import org.apache.http.util.NetUtils;

@NotThreadSafe
public class BHttpConnectionBase implements HttpConnection, HttpInetConnection {
   private final HttpConnectionMetricsImpl connMetrics;
   private final SessionInputBufferImpl inbuffer;
   private final ContentLengthStrategy incomingContentStrategy;
   private final MessageConstraints messageConstraints;
   private final SessionOutputBufferImpl outbuffer;
   private final ContentLengthStrategy outgoingContentStrategy;
   private final AtomicReference<Socket> socketHolder;

   protected BHttpConnectionBase(
      int var1, int var2, CharsetDecoder var3, CharsetEncoder var4, MessageConstraints var5, ContentLengthStrategy var6, ContentLengthStrategy var7
   ) {
      Args.positive(var1, "Buffer size");
      HttpTransportMetricsImpl var10 = new HttpTransportMetricsImpl();
      HttpTransportMetricsImpl var9 = new HttpTransportMetricsImpl();
      MessageConstraints var8;
      if (var5 != null) {
         var8 = var5;
      } else {
         var8 = MessageConstraints.DEFAULT;
      }

      this.inbuffer = new SessionInputBufferImpl(var10, var1, -1, var8, var3);
      this.outbuffer = new SessionOutputBufferImpl(var9, var1, var2, var4);
      this.messageConstraints = var5;
      this.connMetrics = new HttpConnectionMetricsImpl(var10, var9);
      if (var6 == null) {
         var6 = LaxContentLengthStrategy.INSTANCE;
      }

      this.incomingContentStrategy = var6;
      if (var7 == null) {
         var7 = StrictContentLengthStrategy.INSTANCE;
      }

      this.outgoingContentStrategy = var7;
      this.socketHolder = new AtomicReference<>();
   }

   private int fillInputBuffer(int var1) throws IOException {
      Socket var3 = this.socketHolder.get();
      int var2 = var3.getSoTimeout();

      try {
         var3.setSoTimeout(var1);
         return this.inbuffer.fillBuffer();
      } finally {
         var3.setSoTimeout(var2);
      }
   }

   protected boolean awaitInput(int var1) throws IOException {
      boolean var2;
      if (this.inbuffer.hasBufferedData()) {
         var2 = true;
      } else {
         this.fillInputBuffer(var1);
         var2 = this.inbuffer.hasBufferedData();
      }

      return var2;
   }

   protected void bind(Socket var1) throws IOException {
      Args.notNull(var1, "Socket");
      this.socketHolder.set(var1);
      this.inbuffer.bind(null);
      this.outbuffer.bind(null);
   }

   @Override
   public void close() throws IOException {
      Socket var1 = this.socketHolder.getAndSet(null);
      if (var1 != null) {
         try {
            this.inbuffer.clear();
            this.outbuffer.flush();

            try {
               try {
                  var1.shutdownOutput();
               } catch (IOException var8) {
               }

               try {
                  var1.shutdownInput();
               } catch (IOException var7) {
               }
            } catch (UnsupportedOperationException var9) {
            }
         } finally {
            var1.close();
         }
      }
   }

   protected InputStream createInputStream(long var1, SessionInputBuffer var3) {
      InputStream var4;
      if (var1 == -2L) {
         var4 = new ChunkedInputStream(var3, this.messageConstraints);
      } else if (var1 == -1L) {
         var4 = new IdentityInputStream(var3);
      } else if (var1 == 0L) {
         var4 = EmptyInputStream.INSTANCE;
      } else {
         var4 = new ContentLengthInputStream(var3, var1);
      }

      return var4;
   }

   protected OutputStream createOutputStream(long var1, SessionOutputBuffer var3) {
      OutputStream var4;
      if (var1 == -2L) {
         var4 = new ChunkedOutputStream(2048, var3);
      } else if (var1 == -1L) {
         var4 = new IdentityOutputStream(var3);
      } else {
         var4 = new ContentLengthOutputStream(var3, var1);
      }

      return var4;
   }

   protected void doFlush() throws IOException {
      this.outbuffer.flush();
   }

   protected void ensureOpen() throws IOException {
      Socket var2 = this.socketHolder.get();
      boolean var1;
      if (var2 != null) {
         var1 = true;
      } else {
         var1 = false;
      }

      Asserts.check(var1, "Connection is not open");
      if (!this.inbuffer.isBound()) {
         this.inbuffer.bind(this.getSocketInputStream(var2));
      }

      if (!this.outbuffer.isBound()) {
         this.outbuffer.bind(this.getSocketOutputStream(var2));
      }
   }

   @Override
   public InetAddress getLocalAddress() {
      Socket var1 = this.socketHolder.get();
      InetAddress var2;
      if (var1 != null) {
         var2 = var1.getLocalAddress();
      } else {
         var2 = null;
      }

      return var2;
   }

   @Override
   public int getLocalPort() {
      Socket var2 = this.socketHolder.get();
      int var1;
      if (var2 != null) {
         var1 = var2.getLocalPort();
      } else {
         var1 = -1;
      }

      return var1;
   }

   @Override
   public HttpConnectionMetrics getMetrics() {
      return this.connMetrics;
   }

   @Override
   public InetAddress getRemoteAddress() {
      Socket var1 = this.socketHolder.get();
      InetAddress var2;
      if (var1 != null) {
         var2 = var1.getInetAddress();
      } else {
         var2 = null;
      }

      return var2;
   }

   @Override
   public int getRemotePort() {
      Socket var2 = this.socketHolder.get();
      int var1;
      if (var2 != null) {
         var1 = var2.getPort();
      } else {
         var1 = -1;
      }

      return var1;
   }

   protected SessionInputBuffer getSessionInputBuffer() {
      return this.inbuffer;
   }

   protected SessionOutputBuffer getSessionOutputBuffer() {
      return this.outbuffer;
   }

   protected Socket getSocket() {
      return this.socketHolder.get();
   }

   protected InputStream getSocketInputStream(Socket var1) throws IOException {
      return var1.getInputStream();
   }

   protected OutputStream getSocketOutputStream(Socket var1) throws IOException {
      return var1.getOutputStream();
   }

   @Override
   public int getSocketTimeout() {
      Socket var2 = this.socketHolder.get();
      int var1;
      if (var2 != null) {
         try {
            var1 = var2.getSoTimeout();
         } catch (SocketException var3) {
            var1 = -1;
         }
      } else {
         var1 = -1;
      }

      return var1;
   }

   protected void incrementRequestCount() {
      this.connMetrics.incrementRequestCount();
   }

   protected void incrementResponseCount() {
      this.connMetrics.incrementResponseCount();
   }

   @Override
   public boolean isOpen() {
      boolean var1;
      if (this.socketHolder.get() != null) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   @Override
   public boolean isStale() {
      boolean var2 = true;
      if (this.isOpen()) {
         int var1;
         try {
            var1 = this.fillInputBuffer(1);
         } catch (SocketTimeoutException var4) {
            var2 = false;
            return var2;
         } catch (IOException var5) {
            return var2;
         }

         if (var1 >= 0) {
            var2 = false;
         }
      }

      return var2;
   }

   protected HttpEntity prepareInput(HttpMessage var1) throws HttpException {
      BasicHttpEntity var4 = new BasicHttpEntity();
      long var2 = this.incomingContentStrategy.determineLength(var1);
      InputStream var5 = this.createInputStream(var2, this.inbuffer);
      if (var2 == -2L) {
         var4.setChunked(true);
         var4.setContentLength(-1L);
         var4.setContent(var5);
      } else if (var2 == -1L) {
         var4.setChunked(false);
         var4.setContentLength(-1L);
         var4.setContent(var5);
      } else {
         var4.setChunked(false);
         var4.setContentLength(var2);
         var4.setContent(var5);
      }

      Header var7 = var1.getFirstHeader("Content-Type");
      if (var7 != null) {
         var4.setContentType(var7);
      }

      Header var6 = var1.getFirstHeader("Content-Encoding");
      if (var6 != null) {
         var4.setContentEncoding(var6);
      }

      return var4;
   }

   protected OutputStream prepareOutput(HttpMessage var1) throws HttpException {
      return this.createOutputStream(this.outgoingContentStrategy.determineLength(var1), this.outbuffer);
   }

   @Override
   public void setSocketTimeout(int var1) {
      Socket var2 = this.socketHolder.get();
      if (var2 != null) {
         try {
            var2.setSoTimeout(var1);
         } catch (SocketException var3) {
         }
      }
   }

   @Override
   public void shutdown() throws IOException {
      Socket var1 = this.socketHolder.getAndSet(null);
      if (var1 != null) {
         try {
            var1.setSoLinger(true, 0);
         } catch (IOException var5) {
         } finally {
            var1.close();
         }
      }
   }

   @Override
   public String toString() {
      Socket var3 = this.socketHolder.get();
      String var4;
      if (var3 != null) {
         StringBuilder var2 = new StringBuilder();
         SocketAddress var1 = var3.getRemoteSocketAddress();
         SocketAddress var5 = var3.getLocalSocketAddress();
         if (var1 != null && var5 != null) {
            NetUtils.formatAddress(var2, var5);
            var2.append("<->");
            NetUtils.formatAddress(var2, var1);
         }

         var4 = var2.toString();
      } else {
         var4 = "[Not bound]";
      }

      return var4;
   }
}
