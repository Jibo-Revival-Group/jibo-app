package okio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class Okio {
   static final Logger a = Logger.getLogger(Okio.class.getName());

   private Okio() {
   }

   public static BufferedSink a(Sink var0) {
      return new RealBufferedSink(var0);
   }

   public static BufferedSource a(Source var0) {
      return new RealBufferedSource(var0);
   }

   public static Sink a() {
      return new Sink() {
         @Override
         public Timeout a() {
            return Timeout.c;
         }

         @Override
         public void a_(Buffer var1, long var2) throws IOException {
            var1.i(var2);
         }

         @Override
         public void close() throws IOException {
         }

         @Override
         public void flush() throws IOException {
         }
      };
   }

   public static Sink a(OutputStream var0) {
      return a(var0, new Timeout());
   }

   private static Sink a(OutputStream var0, Timeout var1) {
      if (var0 == null) {
         throw new IllegalArgumentException("out == null");
      } else if (var1 == null) {
         throw new IllegalArgumentException("timeout == null");
      } else {
         return new Sink(var1, var0) {
            final Timeout a;
            final OutputStream b;

            {
               this.a = var1;
               this.b = var2;
            }

            @Override
            public Timeout a() {
               return this.a;
            }

            @Override
            public void a_(Buffer var1, long var2) throws IOException {
               Util.a(var1.b, 0L, var2);

               while (var2 > 0L) {
                  this.a.g();
                  Segment var7 = var1.a;
                  int var4 = (int)Math.min(var2, var7.c - var7.b);
                  this.b.write(var7.a, var7.b, var4);
                  var7.b += var4;
                  long var5 = var2 - var4;
                  var1.b -= var4;
                  var2 = var5;
                  if (var7.b == var7.c) {
                     var1.a = var7.a();
                     SegmentPool.a(var7);
                     var2 = var5;
                  }
               }
            }

            @Override
            public void close() throws IOException {
               this.b.close();
            }

            @Override
            public void flush() throws IOException {
               this.b.flush();
            }

            @Override
            public String toString() {
               return "sink(" + this.b + ")";
            }
         };
      }
   }

   public static Sink a(Socket var0) throws IOException {
      if (var0 == null) {
         throw new IllegalArgumentException("socket == null");
      }

      AsyncTimeout var1 = c(var0);
      return var1.a(a(var0.getOutputStream(), var1));
   }

   public static Source a(File var0) throws FileNotFoundException {
      if (var0 == null) {
         throw new IllegalArgumentException("file == null");
      } else {
         return a(new FileInputStream(var0));
      }
   }

   public static Source a(InputStream var0) {
      return a(var0, new Timeout());
   }

   private static Source a(InputStream var0, Timeout var1) {
      if (var0 == null) {
         throw new IllegalArgumentException("in == null");
      } else if (var1 == null) {
         throw new IllegalArgumentException("timeout == null");
      } else {
         return new Source(var1, var0) {
            final Timeout a;
            final InputStream b;

            {
               this.a = var1;
               this.b = var2;
            }

            // $VF: Duplicated exception handlers to handle obfuscated exceptions
            @Override
            public long a(Buffer var1, long var2) throws IOException {
               long var5 = 0L;
               if (var2 < 0L) {
                  throw new IllegalArgumentException("byteCount < 0: " + var2);
               }

               if (var2 == 0L) {
                  var2 = var5;
               } else {
                  Segment var7;
                  int var12;
                  try {
                     this.a.g();
                     var7 = var1.f(1);
                     var12 = (int)Math.min(var2, 8192 - var7.c);
                     var12 = this.b.read(var7.a, var7.c, var12);
                  } catch (AssertionError var9) {
                     if (Okio.a(var9)) {
                        throw new IOException(var9);
                     }

                     throw var9;
                  }

                  if (var12 == -1) {
                     return -1L;
                  }

                  try {
                     var7.c += var12;
                     var1.b += var12;
                  } catch (AssertionError var8) {
                     if (Okio.a(var8)) {
                        throw new IOException(var8);
                     }

                     throw var8;
                  }

                  var2 = var12;
               }

               return var2;
            }

            @Override
            public Timeout a() {
               return this.a;
            }

            @Override
            public void close() throws IOException {
               this.b.close();
            }

            @Override
            public String toString() {
               return "source(" + this.b + ")";
            }
         };
      }
   }

   static boolean a(AssertionError var0) {
      boolean var1;
      if (var0.getCause() != null && var0.getMessage() != null && var0.getMessage().contains("getsockname failed")) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   public static Sink b(File var0) throws FileNotFoundException {
      if (var0 == null) {
         throw new IllegalArgumentException("file == null");
      } else {
         return a(new FileOutputStream(var0));
      }
   }

   public static Source b(Socket var0) throws IOException {
      if (var0 == null) {
         throw new IllegalArgumentException("socket == null");
      }

      AsyncTimeout var1 = c(var0);
      return var1.a(a(var0.getInputStream(), var1));
   }

   private static AsyncTimeout c(Socket var0) {
      return new AsyncTimeout(var0) {
         final Socket a;

         {
            this.a = var1;
         }

         @Override
         protected IOException a(IOException var1) {
            SocketTimeoutException var2 = new SocketTimeoutException("timeout");
            if (var1 != null) {
               var2.initCause(var1);
            }

            return var2;
         }

         @Override
         protected void a() {
            try {
               this.a.close();
            } catch (Exception var2) {
               Okio.a.log(Level.WARNING, "Failed to close timed out socket " + this.a, var2);
            } catch (AssertionError var3) {
               if (!Okio.a(var3)) {
                  throw var3;
               }

               Okio.a.log(Level.WARNING, "Failed to close timed out socket " + this.a, var3);
            }
         }
      };
   }

   public static Sink c(File var0) throws FileNotFoundException {
      if (var0 == null) {
         throw new IllegalArgumentException("file == null");
      } else {
         return a(new FileOutputStream(var0, true));
      }
   }
}
