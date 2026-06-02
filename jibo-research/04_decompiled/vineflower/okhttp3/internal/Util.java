package okhttp3.internal;

import java.io.Closeable;
import java.io.IOException;
import java.net.IDN;
import java.net.Socket;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import okhttp3.HttpUrl;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import okio.BufferedSource;
import okio.ByteString;
import okio.Source;

public final class Util {
   public static final byte[] a = new byte[0];
   public static final String[] b = new String[0];
   public static final ResponseBody c = ResponseBody.a(null, a);
   public static final RequestBody d = RequestBody.a(null, a);
   public static final Charset e = Charset.forName("UTF-8");
   public static final TimeZone f = TimeZone.getTimeZone("GMT");
   public static final Comparator<String> g = new Comparator<String>() {
      public int a(String var1, String var2) {
         return var1.compareTo(var2);
      }
   };
   private static final ByteString h = ByteString.c("efbbbf");
   private static final ByteString i = ByteString.c("feff");
   private static final ByteString j = ByteString.c("fffe");
   private static final ByteString k = ByteString.c("0000ffff");
   private static final ByteString l = ByteString.c("ffff0000");
   private static final Charset m = Charset.forName("UTF-16BE");
   private static final Charset n = Charset.forName("UTF-16LE");
   private static final Charset o = Charset.forName("UTF-32BE");
   private static final Charset p = Charset.forName("UTF-32LE");
   private static final Pattern q = Pattern.compile("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");

   public static int a(String var0, int var1, int var2) {
      while (true) {
         int var3 = var2;
         if (var1 < var2) {
            switch (var0.charAt(var1)) {
               case '\t':
               case '\n':
               case '\f':
               case '\r':
               case ' ':
                  var1++;
                  continue;
               default:
                  var3 = var1;
            }
         }

         return var3;
      }
   }

   public static int a(String var0, int var1, int var2, char var3) {
      while (true) {
         int var4 = var2;
         if (var1 < var2) {
            if (var0.charAt(var1) != var3) {
               var1++;
               continue;
            }

            var4 = var1;
         }

         return var4;
      }
   }

   public static int a(String var0, int var1, int var2, String var3) {
      while (true) {
         int var4 = var2;
         if (var1 < var2) {
            if (var3.indexOf(var0.charAt(var1)) == -1) {
               var1++;
               continue;
            }

            var4 = var1;
         }

         return var4;
      }
   }

   public static int a(Comparator<String> var0, String[] var1, String var2) {
      int var3 = 0;
      int var4 = var1.length;

      while (true) {
         if (var3 >= var4) {
            var3 = -1;
            break;
         }

         if (var0.compare(var1[var3], var2) == 0) {
            break;
         }

         var3++;
      }

      return var3;
   }

   public static String a(String var0) {
      Object var2 = null;

      boolean var1;
      String var3;
      try {
         var3 = IDN.toASCII(var0).toLowerCase(Locale.US);
         if (var3.isEmpty()) {
            return (String)var2;
         }

         var1 = d(var3);
      } catch (IllegalArgumentException var4) {
         return (String)var2;
      }

      var0 = (String)var2;
      if (!var1) {
         var0 = var3;
      }

      return var0;
   }

   public static String a(String var0, Object... var1) {
      return String.format(Locale.US, var0, var1);
   }

   public static String a(HttpUrl var0, boolean var1) {
      String var2;
      if (var0.g().contains(":")) {
         var2 = "[" + var0.g() + "]";
      } else {
         var2 = var0.g();
      }

      if (!var1) {
         String var3 = var2;
         if (var0.h() == HttpUrl.a(var0.c())) {
            return var3;
         }
      }

      return var2 + ":" + var0.h();
   }

   public static Charset a(BufferedSource var0, Charset var1) throws IOException {
      if (var0.a(0L, h)) {
         var0.i(h.h());
         var1 = e;
      } else if (var0.a(0L, i)) {
         var0.i(i.h());
         var1 = m;
      } else if (var0.a(0L, j)) {
         var0.i(j.h());
         var1 = n;
      } else if (var0.a(0L, k)) {
         var0.i(k.h());
         var1 = o;
      } else if (var0.a(0L, l)) {
         var0.i(l.h());
         var1 = p;
      }

      return var1;
   }

   public static <T> List<T> a(List<T> var0) {
      return Collections.unmodifiableList(new ArrayList<>(var0));
   }

   public static <T> List<T> a(T... var0) {
      return Collections.unmodifiableList(Arrays.asList((T[])((Object[])var0.clone())));
   }

   public static ThreadFactory a(String var0, boolean var1) {
      return new ThreadFactory(var0, var1) {
         final String a;
         final boolean b;

         {
            this.a = var1;
            this.b = var2;
         }

         @Override
         public Thread newThread(Runnable var1) {
            var1 = new Thread(var1, this.a);
            var1.setDaemon(this.b);
            return var1;
         }
      };
   }

   public static void a(long var0, long var2, long var4) {
      if ((var2 | var4) < 0L || var2 > var0 || var0 - var2 < var4) {
         throw new ArrayIndexOutOfBoundsException();
      }
   }

   public static void a(Closeable var0) {
      if (var0 != null) {
         try {
            var0.close();
         } catch (RuntimeException var1) {
            throw var1;
         } catch (Exception var2) {
         }
      }
   }

   public static void a(Socket var0) {
      if (var0 != null) {
         try {
            var0.close();
         } catch (AssertionError var1) {
            if (!a(var1)) {
               throw var1;
            }
         } catch (RuntimeException var2) {
            throw var2;
         } catch (Exception var3) {
         }
      }
   }

   public static boolean a(AssertionError var0) {
      boolean var1;
      if (var0.getCause() != null && var0.getMessage() != null && var0.getMessage().contains("getsockname failed")) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   public static boolean a(Object var0, Object var1) {
      boolean var2;
      if (var0 != var1 && (var0 == null || !var0.equals(var1))) {
         var2 = false;
      } else {
         var2 = true;
      }

      return var2;
   }

   public static boolean a(Source var0, int var1, TimeUnit var2) {
      boolean var3;
      try {
         var3 = b(var0, var1, var2);
      } catch (IOException var4) {
         var3 = false;
      }

      return var3;
   }

   public static String[] a(Comparator<? super String> var0, String[] var1, String[] var2) {
      ArrayList var8 = new ArrayList();

      for (String var7 : var1) {
         int var6 = var2.length;

         for (int var4 = 0; var4 < var6; var4++) {
            if (var0.compare(var7, var2[var4]) == 0) {
               var8.add(var7);
               break;
            }
         }
      }

      return var8.toArray(new String[var8.size()]);
   }

   public static String[] a(String[] var0, String var1) {
      String[] var2 = new String[var0.length + 1];
      System.arraycopy(var0, 0, var2, 0, var0.length);
      var2[var2.length - 1] = var1;
      return var2;
   }

   public static int b(String var0) {
      int var1 = 0;
      int var3 = var0.length();

      int var2;
      while (true) {
         if (var1 >= var3) {
            var2 = -1;
            break;
         }

         char var4 = var0.charAt(var1);
         var2 = var1;
         if (var4 <= 31) {
            break;
         }

         if (var4 >= 127) {
            var2 = var1;
            break;
         }

         var1++;
      }

      return var2;
   }

   public static int b(String var0, int var1, int var2) {
      var2--;

      while (true) {
         int var3 = var1;
         if (var2 < var1) {
            return var3;
         }

         switch (var0.charAt(var2)) {
            case '\t':
            case '\n':
            case '\f':
            case '\r':
            case ' ':
               var2--;
               break;
            default:
               var3 = var2 + 1;
               return var3;
         }
      }
   }

   public static boolean b(Comparator<String> var0, String[] var1, String[] var2) {
      boolean var8 = false;
      boolean var7 = var8;
      if (var1 != null) {
         var7 = var8;
         if (var2 != null) {
            var7 = var8;
            if (var1.length != 0) {
               if (var2.length == 0) {
                  var7 = var8;
               } else {
                  int var5 = var1.length;
                  int var3 = 0;

                  while (true) {
                     var7 = var8;
                     if (var3 >= var5) {
                        break;
                     }

                     String var9 = var1[var3];
                     int var6 = var2.length;

                     for (int var4 = 0; var4 < var6; var4++) {
                        if (var0.compare(var9, var2[var4]) == 0) {
                           var7 = true;
                           return var7;
                        }
                     }

                     var3++;
                  }
               }
            }
         }
      }

      return var7;
   }

   public static boolean b(Source param0, int param1, TimeUnit param2) throws IOException {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 00: invokestatic java/lang/System.nanoTime ()J
      // 03: lstore 5
      // 05: aload 0
      // 06: invokeinterface okio/Source.a ()Lokio/Timeout; 1
      // 0b: invokevirtual okio/Timeout.y_ ()Z
      // 0e: ifeq 6e
      // 11: aload 0
      // 12: invokeinterface okio/Source.a ()Lokio/Timeout; 1
      // 17: invokevirtual okio/Timeout.d ()J
      // 1a: lload 5
      // 1c: lsub
      // 1d: lstore 3
      // 1e: aload 0
      // 1f: invokeinterface okio/Source.a ()Lokio/Timeout; 1
      // 24: lload 3
      // 25: aload 2
      // 26: iload 1
      // 27: i2l
      // 28: invokevirtual java/util/concurrent/TimeUnit.toNanos (J)J
      // 2b: invokestatic java/lang/Math.min (JJ)J
      // 2e: lload 5
      // 30: ladd
      // 31: invokevirtual okio/Timeout.a (J)Lokio/Timeout;
      // 34: pop
      // 35: new okio/Buffer
      // 38: astore 2
      // 39: aload 2
      // 3a: invokespecial okio/Buffer.<init> ()V
      // 3d: aload 0
      // 3e: aload 2
      // 3f: ldc2_w 8192
      // 42: invokeinterface okio/Source.a (Lokio/Buffer;J)J 4
      // 47: ldc2_w -1
      // 4a: lcmp
      // 4b: ifeq 75
      // 4e: aload 2
      // 4f: invokevirtual okio/Buffer.u ()V
      // 52: goto 3d
      // 55: astore 2
      // 56: lload 3
      // 57: ldc2_w 9223372036854775807
      // 5a: lcmp
      // 5b: ifne 9e
      // 5e: aload 0
      // 5f: invokeinterface okio/Source.a ()Lokio/Timeout; 1
      // 64: invokevirtual okio/Timeout.f ()Lokio/Timeout;
      // 67: pop
      // 68: bipush 0
      // 69: istore 7
      // 6b: iload 7
      // 6d: ireturn
      // 6e: ldc2_w 9223372036854775807
      // 71: lstore 3
      // 72: goto 1e
      // 75: lload 3
      // 76: ldc2_w 9223372036854775807
      // 79: lcmp
      // 7a: ifne 8d
      // 7d: aload 0
      // 7e: invokeinterface okio/Source.a ()Lokio/Timeout; 1
      // 83: invokevirtual okio/Timeout.f ()Lokio/Timeout;
      // 86: pop
      // 87: bipush 1
      // 88: istore 7
      // 8a: goto 6b
      // 8d: aload 0
      // 8e: invokeinterface okio/Source.a ()Lokio/Timeout; 1
      // 93: lload 3
      // 94: lload 5
      // 96: ladd
      // 97: invokevirtual okio/Timeout.a (J)Lokio/Timeout;
      // 9a: pop
      // 9b: goto 87
      // 9e: aload 0
      // 9f: invokeinterface okio/Source.a ()Lokio/Timeout; 1
      // a4: lload 3
      // a5: lload 5
      // a7: ladd
      // a8: invokevirtual okio/Timeout.a (J)Lokio/Timeout;
      // ab: pop
      // ac: goto 68
      // af: astore 2
      // b0: lload 3
      // b1: ldc2_w 9223372036854775807
      // b4: lcmp
      // b5: ifne c4
      // b8: aload 0
      // b9: invokeinterface okio/Source.a ()Lokio/Timeout; 1
      // be: invokevirtual okio/Timeout.f ()Lokio/Timeout;
      // c1: pop
      // c2: aload 2
      // c3: athrow
      // c4: aload 0
      // c5: invokeinterface okio/Source.a ()Lokio/Timeout; 1
      // ca: lload 3
      // cb: lload 5
      // cd: ladd
      // ce: invokevirtual okio/Timeout.a (J)Lokio/Timeout;
      // d1: pop
      // d2: goto c2
      // try (24 -> 28): 38 java/io/InterruptedIOException
      // try (24 -> 28): 81 null
      // try (28 -> 37): 38 java/io/InterruptedIOException
      // try (28 -> 37): 81 null
   }

   public static String c(String var0, int var1, int var2) {
      var1 = a(var0, var1, var2);
      return var0.substring(var1, b(var0, var1, var2));
   }

   public static boolean c(String var0) {
      return q.matcher(var0).matches();
   }

   private static boolean d(String var0) {
      boolean var4 = false;
      int var1 = 0;

      boolean var3;
      while (true) {
         var3 = var4;
         if (var1 >= var0.length()) {
            break;
         }

         char var2 = var0.charAt(var1);
         if (var2 <= 31 || var2 >= 127) {
            var3 = true;
            break;
         }

         if (" #%/:?@[\\]".indexOf(var2) != -1) {
            var3 = true;
            break;
         }

         var1++;
      }

      return var3;
   }
}
