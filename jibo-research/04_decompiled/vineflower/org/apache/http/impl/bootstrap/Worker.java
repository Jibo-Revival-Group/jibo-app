package org.apache.http.impl.bootstrap;

import org.apache.http.ExceptionLogger;
import org.apache.http.HttpServerConnection;
import org.apache.http.protocol.HttpService;

class Worker implements Runnable {
   private final HttpServerConnection conn;
   private final ExceptionLogger exceptionLogger;
   private final HttpService httpservice;

   Worker(HttpService var1, HttpServerConnection var2, ExceptionLogger var3) {
      this.httpservice = var1;
      this.conn = var2;
      this.exceptionLogger = var3;
   }

   public HttpServerConnection getConnection() {
      return this.conn;
   }

   @Override
   public void run() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 00: new org/apache/http/protocol/BasicHttpContext
      // 03: astore 1
      // 04: aload 1
      // 05: invokespecial org/apache/http/protocol/BasicHttpContext.<init> ()V
      // 08: aload 1
      // 09: invokestatic org/apache/http/protocol/HttpCoreContext.adapt (Lorg/apache/http/protocol/HttpContext;)Lorg/apache/http/protocol/HttpCoreContext;
      // 0c: astore 2
      // 0d: invokestatic java/lang/Thread.interrupted ()Z
      // 10: ifne 47
      // 13: aload 0
      // 14: getfield org/apache/http/impl/bootstrap/Worker.conn Lorg/apache/http/HttpServerConnection;
      // 17: invokeinterface org/apache/http/HttpServerConnection.isOpen ()Z 1
      // 1c: ifeq 47
      // 1f: aload 0
      // 20: getfield org/apache/http/impl/bootstrap/Worker.httpservice Lorg/apache/http/protocol/HttpService;
      // 23: aload 0
      // 24: getfield org/apache/http/impl/bootstrap/Worker.conn Lorg/apache/http/HttpServerConnection;
      // 27: aload 2
      // 28: invokevirtual org/apache/http/protocol/HttpService.handleRequest (Lorg/apache/http/HttpServerConnection;Lorg/apache/http/protocol/HttpContext;)V
      // 2b: aload 1
      // 2c: invokevirtual org/apache/http/protocol/BasicHttpContext.clear ()V
      // 2f: goto 0d
      // 32: astore 1
      // 33: aload 0
      // 34: getfield org/apache/http/impl/bootstrap/Worker.exceptionLogger Lorg/apache/http/ExceptionLogger;
      // 37: aload 1
      // 38: invokeinterface org/apache/http/ExceptionLogger.log (Ljava/lang/Exception;)V 2
      // 3d: aload 0
      // 3e: getfield org/apache/http/impl/bootstrap/Worker.conn Lorg/apache/http/HttpServerConnection;
      // 41: invokeinterface org/apache/http/HttpServerConnection.shutdown ()V 1
      // 46: return
      // 47: aload 0
      // 48: getfield org/apache/http/impl/bootstrap/Worker.conn Lorg/apache/http/HttpServerConnection;
      // 4b: invokeinterface org/apache/http/HttpServerConnection.close ()V 1
      // 50: aload 0
      // 51: getfield org/apache/http/impl/bootstrap/Worker.conn Lorg/apache/http/HttpServerConnection;
      // 54: invokeinterface org/apache/http/HttpServerConnection.shutdown ()V 1
      // 59: goto 46
      // 5c: astore 1
      // 5d: aload 0
      // 5e: getfield org/apache/http/impl/bootstrap/Worker.exceptionLogger Lorg/apache/http/ExceptionLogger;
      // 61: aload 1
      // 62: invokeinterface org/apache/http/ExceptionLogger.log (Ljava/lang/Exception;)V 2
      // 67: goto 46
      // 6a: astore 1
      // 6b: aload 0
      // 6c: getfield org/apache/http/impl/bootstrap/Worker.exceptionLogger Lorg/apache/http/ExceptionLogger;
      // 6f: aload 1
      // 70: invokeinterface org/apache/http/ExceptionLogger.log (Ljava/lang/Exception;)V 2
      // 75: goto 46
      // 78: astore 2
      // 79: aload 0
      // 7a: getfield org/apache/http/impl/bootstrap/Worker.conn Lorg/apache/http/HttpServerConnection;
      // 7d: invokeinterface org/apache/http/HttpServerConnection.shutdown ()V 1
      // 82: aload 2
      // 83: athrow
      // 84: astore 1
      // 85: aload 0
      // 86: getfield org/apache/http/impl/bootstrap/Worker.exceptionLogger Lorg/apache/http/ExceptionLogger;
      // 89: aload 1
      // 8a: invokeinterface org/apache/http/ExceptionLogger.log (Ljava/lang/Exception;)V 2
      // 8f: goto 82
      // try (0 -> 7): 22 java/lang/Exception
      // try (0 -> 7): 50 null
      // try (7 -> 21): 22 java/lang/Exception
      // try (7 -> 21): 50 null
      // try (23 -> 27): 50 null
      // try (27 -> 30): 44 java/io/IOException
      // try (31 -> 34): 22 java/lang/Exception
      // try (31 -> 34): 50 null
      // try (34 -> 37): 38 java/io/IOException
      // try (51 -> 54): 56 java/io/IOException
   }
}
