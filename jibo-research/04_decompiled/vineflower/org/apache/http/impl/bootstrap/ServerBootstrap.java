package org.apache.http.impl.bootstrap;

import java.net.InetAddress;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import javax.net.ServerSocketFactory;
import javax.net.ssl.SSLContext;
import org.apache.http.ConnectionReuseStrategy;
import org.apache.http.ExceptionLogger;
import org.apache.http.HttpConnectionFactory;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.HttpResponseFactory;
import org.apache.http.HttpResponseInterceptor;
import org.apache.http.config.ConnectionConfig;
import org.apache.http.config.SocketConfig;
import org.apache.http.impl.DefaultBHttpServerConnection;
import org.apache.http.impl.DefaultBHttpServerConnectionFactory;
import org.apache.http.impl.DefaultConnectionReuseStrategy;
import org.apache.http.impl.DefaultHttpResponseFactory;
import org.apache.http.protocol.HttpExpectationVerifier;
import org.apache.http.protocol.HttpProcessor;
import org.apache.http.protocol.HttpProcessorBuilder;
import org.apache.http.protocol.HttpRequestHandler;
import org.apache.http.protocol.HttpRequestHandlerMapper;
import org.apache.http.protocol.HttpService;
import org.apache.http.protocol.ResponseConnControl;
import org.apache.http.protocol.ResponseContent;
import org.apache.http.protocol.ResponseDate;
import org.apache.http.protocol.ResponseServer;
import org.apache.http.protocol.UriHttpRequestHandlerMapper;

public class ServerBootstrap {
   private ConnectionReuseStrategy connStrategy;
   private ConnectionConfig connectionConfig;
   private HttpConnectionFactory<? extends DefaultBHttpServerConnection> connectionFactory;
   private ExceptionLogger exceptionLogger;
   private HttpExpectationVerifier expectationVerifier;
   private Map<String, HttpRequestHandler> handlerMap;
   private HttpRequestHandlerMapper handlerMapper;
   private HttpProcessor httpProcessor;
   private int listenerPort;
   private InetAddress localAddress;
   private LinkedList<HttpRequestInterceptor> requestFirst;
   private LinkedList<HttpRequestInterceptor> requestLast;
   private HttpResponseFactory responseFactory;
   private LinkedList<HttpResponseInterceptor> responseFirst;
   private LinkedList<HttpResponseInterceptor> responseLast;
   private String serverInfo;
   private ServerSocketFactory serverSocketFactory;
   private SocketConfig socketConfig;
   private SSLContext sslContext;
   private SSLServerSetupHandler sslSetupHandler;

   private ServerBootstrap() {
   }

   public static ServerBootstrap bootstrap() {
      return new ServerBootstrap();
   }

   public final ServerBootstrap addInterceptorFirst(HttpRequestInterceptor var1) {
      if (var1 != null) {
         if (this.requestFirst == null) {
            this.requestFirst = new LinkedList<>();
         }

         this.requestFirst.addFirst(var1);
      }

      return this;
   }

   public final ServerBootstrap addInterceptorFirst(HttpResponseInterceptor var1) {
      if (var1 != null) {
         if (this.responseFirst == null) {
            this.responseFirst = new LinkedList<>();
         }

         this.responseFirst.addFirst(var1);
      }

      return this;
   }

   public final ServerBootstrap addInterceptorLast(HttpRequestInterceptor var1) {
      if (var1 != null) {
         if (this.requestLast == null) {
            this.requestLast = new LinkedList<>();
         }

         this.requestLast.addLast(var1);
      }

      return this;
   }

   public final ServerBootstrap addInterceptorLast(HttpResponseInterceptor var1) {
      if (var1 != null) {
         if (this.responseLast == null) {
            this.responseLast = new LinkedList<>();
         }

         this.responseLast.addLast(var1);
      }

      return this;
   }

   public HttpServer create() {
      HttpProcessor var3 = this.httpProcessor;
      HttpProcessor var2 = var3;
      if (var3 == null) {
         HttpProcessorBuilder var4 = HttpProcessorBuilder.create();
         if (this.requestFirst != null) {
            Iterator var8 = this.requestFirst.iterator();

            while (var8.hasNext()) {
               var4.addFirst((HttpRequestInterceptor)var8.next());
            }
         }

         if (this.responseFirst != null) {
            Iterator var9 = this.responseFirst.iterator();

            while (var9.hasNext()) {
               var4.addFirst((HttpResponseInterceptor)var9.next());
            }
         }

         String var14 = this.serverInfo;
         String var10 = var14;
         if (var14 == null) {
            var10 = "Apache-HttpCore/1.1";
         }

         var4.addAll(new ResponseDate(), new ResponseServer(var10), new ResponseContent(), new ResponseConnControl());
         if (this.requestLast != null) {
            Iterator var11 = this.requestLast.iterator();

            while (var11.hasNext()) {
               var4.addLast((HttpRequestInterceptor)var11.next());
            }
         }

         if (this.responseLast != null) {
            Iterator var12 = this.responseLast.iterator();

            while (var12.hasNext()) {
               var4.addLast((HttpResponseInterceptor)var12.next());
            }
         }

         var2 = var4.build();
      }

      UriHttpRequestHandlerMapper var19 = this.handlerMapper;
      HttpRequestHandlerMapper var15 = var19;
      if (var19 == null) {
         var19 = new UriHttpRequestHandlerMapper();
         var15 = var19;
         if (this.handlerMap != null) {
            Iterator var5 = this.handlerMap.entrySet().iterator();

            while (true) {
               var15 = var19;
               if (!var5.hasNext()) {
                  break;
               }

               Entry var16 = (Entry)var5.next();
               var19.register((String)var16.getKey(), (HttpRequestHandler)var16.getValue());
            }
         }
      }

      ConnectionReuseStrategy var24 = this.connStrategy;
      ConnectionReuseStrategy var21 = var24;
      if (var24 == null) {
         var21 = DefaultConnectionReuseStrategy.INSTANCE;
      }

      HttpResponseFactory var6 = this.responseFactory;
      HttpResponseFactory var25 = var6;
      if (var6 == null) {
         var25 = DefaultHttpResponseFactory.INSTANCE;
      }

      HttpService var28 = new HttpService(var2, var21, var25, var15, this.expectationVerifier);
      ServerSocketFactory var17 = this.serverSocketFactory;
      ServerSocketFactory var13 = var17;
      if (var17 == null) {
         if (this.sslContext != null) {
            var13 = this.sslContext.getServerSocketFactory();
         } else {
            var13 = ServerSocketFactory.getDefault();
         }
      }

      HttpConnectionFactory var22 = this.connectionFactory;
      HttpConnectionFactory var18 = var22;
      if (var22 == null) {
         if (this.connectionConfig != null) {
            var18 = new DefaultBHttpServerConnectionFactory(this.connectionConfig);
         } else {
            var18 = DefaultBHttpServerConnectionFactory.INSTANCE;
         }
      }

      ExceptionLogger var26 = this.exceptionLogger;
      ExceptionLogger var23 = var26;
      if (var26 == null) {
         var23 = ExceptionLogger.NO_OP;
      }

      int var1;
      if (this.listenerPort > 0) {
         var1 = this.listenerPort;
      } else {
         var1 = 0;
      }

      InetAddress var7 = this.localAddress;
      SocketConfig var27;
      if (this.socketConfig != null) {
         var27 = this.socketConfig;
      } else {
         var27 = SocketConfig.DEFAULT;
      }

      return new HttpServer(var1, var7, var27, var13, var28, var18, this.sslSetupHandler, var23);
   }

   public final ServerBootstrap registerHandler(String var1, HttpRequestHandler var2) {
      if (var1 != null && var2 != null) {
         if (this.handlerMap == null) {
            this.handlerMap = new HashMap<>();
         }

         this.handlerMap.put(var1, var2);
      }

      return this;
   }

   public final ServerBootstrap setConnectionConfig(ConnectionConfig var1) {
      this.connectionConfig = var1;
      return this;
   }

   public final ServerBootstrap setConnectionFactory(HttpConnectionFactory<? extends DefaultBHttpServerConnection> var1) {
      this.connectionFactory = var1;
      return this;
   }

   public final ServerBootstrap setConnectionReuseStrategy(ConnectionReuseStrategy var1) {
      this.connStrategy = var1;
      return this;
   }

   public final ServerBootstrap setExceptionLogger(ExceptionLogger var1) {
      this.exceptionLogger = var1;
      return this;
   }

   public final ServerBootstrap setExpectationVerifier(HttpExpectationVerifier var1) {
      this.expectationVerifier = var1;
      return this;
   }

   public final ServerBootstrap setHandlerMapper(HttpRequestHandlerMapper var1) {
      this.handlerMapper = var1;
      return this;
   }

   public final ServerBootstrap setHttpProcessor(HttpProcessor var1) {
      this.httpProcessor = var1;
      return this;
   }

   public final ServerBootstrap setListenerPort(int var1) {
      this.listenerPort = var1;
      return this;
   }

   public final ServerBootstrap setLocalAddress(InetAddress var1) {
      this.localAddress = var1;
      return this;
   }

   public final ServerBootstrap setResponseFactory(HttpResponseFactory var1) {
      this.responseFactory = var1;
      return this;
   }

   public final ServerBootstrap setServerInfo(String var1) {
      this.serverInfo = var1;
      return this;
   }

   public final ServerBootstrap setServerSocketFactory(ServerSocketFactory var1) {
      this.serverSocketFactory = var1;
      return this;
   }

   public final ServerBootstrap setSocketConfig(SocketConfig var1) {
      this.socketConfig = var1;
      return this;
   }

   public final ServerBootstrap setSslContext(SSLContext var1) {
      this.sslContext = var1;
      return this;
   }

   public final ServerBootstrap setSslSetupHandler(SSLServerSetupHandler var1) {
      this.sslSetupHandler = var1;
      return this;
   }
}
