package org.apache.http.impl.bootstrap;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import org.apache.http.ExceptionLogger;
import org.apache.http.HttpConnectionFactory;
import org.apache.http.HttpServerConnection;
import org.apache.http.config.SocketConfig;
import org.apache.http.protocol.HttpService;

class RequestListener implements Runnable {
   private final HttpConnectionFactory<? extends HttpServerConnection> connectionFactory;
   private final ExceptionLogger exceptionLogger;
   private final ExecutorService executorService;
   private final HttpService httpService;
   private final ServerSocket serversocket;
   private final SocketConfig socketConfig;
   private final AtomicBoolean terminated;

   public RequestListener(
      SocketConfig var1,
      ServerSocket var2,
      HttpService var3,
      HttpConnectionFactory<? extends HttpServerConnection> var4,
      ExceptionLogger var5,
      ExecutorService var6
   ) {
      this.socketConfig = var1;
      this.serversocket = var2;
      this.connectionFactory = var4;
      this.httpService = var3;
      this.exceptionLogger = var5;
      this.executorService = var6;
      this.terminated = new AtomicBoolean(false);
   }

   public boolean isTerminated() {
      return this.terminated.get();
   }

   @Override
   public void run() {
      while (true) {
         try {
            if (!this.isTerminated() && !Thread.interrupted()) {
               Socket var1 = this.serversocket.accept();
               var1.setSoTimeout(this.socketConfig.getSoTimeout());
               var1.setKeepAlive(this.socketConfig.isSoKeepAlive());
               var1.setTcpNoDelay(this.socketConfig.isTcpNoDelay());
               if (this.socketConfig.getRcvBufSize() > 0) {
                  var1.setReceiveBufferSize(this.socketConfig.getRcvBufSize());
               }

               if (this.socketConfig.getSndBufSize() > 0) {
                  var1.setSendBufferSize(this.socketConfig.getSndBufSize());
               }

               if (this.socketConfig.getSoLinger() >= 0) {
                  var1.setSoLinger(true, this.socketConfig.getSoLinger());
               }

               HttpServerConnection var4 = this.connectionFactory.createConnection(var1);
               Worker var2 = new Worker(this.httpService, var4, this.exceptionLogger);
               this.executorService.execute(var2);
               continue;
            }
         } catch (Exception var3) {
            this.exceptionLogger.log(var3);
         }

         return;
      }
   }

   public void terminate() throws IOException {
      if (this.terminated.compareAndSet(false, true)) {
         this.serversocket.close();
      }
   }
}
