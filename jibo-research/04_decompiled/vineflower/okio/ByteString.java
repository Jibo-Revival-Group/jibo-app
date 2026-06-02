package okio;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class ByteString implements Serializable, Comparable<ByteString> {
   static final char[] a = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
   public static final ByteString b = a();
   final byte[] c;
   transient int d;
   transient String e;

   ByteString(byte[] var1) {
      this.c = var1;
   }

   private static int a(char var0) {
      int var1;
      if (var0 >= '0' && var0 <= '9') {
         var1 = var0 - '0';
      } else if (var0 >= 'a' && var0 <= 'f') {
         var1 = var0 - 'a' + 10;
      } else {
         if (var0 < 'A' || var0 > 'F') {
            throw new IllegalArgumentException("Unexpected hex digit: " + var0);
         }

         var1 = var0 - 'A' + 10;
      }

      return var1;
   }

   static int a(String var0, int var1) {
      int var2 = 0;
      int var4 = var0.length();
      int var3 = 0;

      while (true) {
         if (var2 < var4) {
            if (var3 == var1) {
               break;
            }

            int var5 = var0.codePointAt(var2);
            if ((!Character.isISOControl(var5) || var5 == 10 || var5 == 13) && var5 != 65533) {
               var3++;
               var2 += Character.charCount(var5);
               continue;
            }

            var2 = -1;
            break;
         }

         var2 = var0.length();
         break;
      }

      return var2;
   }

   public static ByteString a(InputStream var0, int var1) throws IOException {
      if (var0 == null) {
         throw new IllegalArgumentException("in == null");
      }

      if (var1 < 0) {
         throw new IllegalArgumentException("byteCount < 0: " + var1);
      }

      byte[] var4 = new byte[var1];
      int var2 = 0;

      while (var2 < var1) {
         int var3 = var0.read(var4, var2, var1 - var2);
         if (var3 == -1) {
            throw new EOFException();
         }

         var2 += var3;
      }

      return new ByteString(var4);
   }

   public static ByteString a(String var0) {
      if (var0 == null) {
         throw new IllegalArgumentException("s == null");
      }

      ByteString var1 = new ByteString(var0.getBytes(Util.a));
      var1.e = var0;
      return var1;
   }

   public static ByteString a(byte... var0) {
      if (var0 == null) {
         throw new IllegalArgumentException("data == null");
      } else {
         return new ByteString((byte[])var0.clone());
      }
   }

   public static ByteString b(String var0) {
      if (var0 == null) {
         throw new IllegalArgumentException("base64 == null");
      }

      byte[] var1 = Base64.a(var0);
      ByteString var2;
      if (var1 != null) {
         var2 = new ByteString(var1);
      } else {
         var2 = null;
      }

      return var2;
   }

   public static ByteString c(String var0) {
      if (var0 == null) {
         throw new IllegalArgumentException("hex == null");
      }

      if (var0.length() % 2 != 0) {
         throw new IllegalArgumentException("Unexpected hex string: " + var0);
      }

      byte[] var2 = new byte[var0.length() / 2];

      for (int var1 = 0; var1 < var2.length; var1++) {
         var2[var1] = (byte)((a(var0.charAt(var1 * 2)) << 4) + a(var0.charAt(var1 * 2 + 1)));
      }

      return a(var2);
   }

   private ByteString d(String var1) {
      try {
         return a(MessageDigest.getInstance(var1).digest(this.c));
      } catch (NoSuchAlgorithmException var2) {
         throw new AssertionError(var2);
      }
   }

   private void readObject(ObjectInputStream var1) throws IOException {
      ByteString var5 = a(var1, var1.readInt());

      try {
         Field var2 = ByteString.class.getDeclaredField("c");
         var2.setAccessible(true);
         var2.set(this, var5.c);
      } catch (NoSuchFieldException var3) {
         throw new AssertionError();
      } catch (IllegalAccessException var4) {
         throw new AssertionError();
      }
   }

   private void writeObject(ObjectOutputStream var1) throws IOException {
      var1.writeInt(this.c.length);
      var1.write(this.c);
   }

   public byte a(int var1) {
      return this.c[var1];
   }

   public String a() {
      String var1 = this.e;
      if (var1 == null) {
         var1 = new String(this.c, Util.a);
         this.e = var1;
      }

      return var1;
   }

   public ByteString a(int var1, int var2) {
      if (var1 < 0) {
         throw new IllegalArgumentException("beginIndex < 0");
      }

      if (var2 > this.c.length) {
         throw new IllegalArgumentException("endIndex > length(" + this.c.length + ")");
      }

      int var3 = var2 - var1;
      if (var3 < 0) {
         throw new IllegalArgumentException("endIndex < beginIndex");
      }

      ByteString var5;
      if (var1 == 0 && var2 == this.c.length) {
         var5 = this;
      } else {
         byte[] var4 = new byte[var3];
         System.arraycopy(this.c, var1, var4, 0, var3);
         var5 = new ByteString(var4);
      }

      return var5;
   }

   void a(Buffer var1) {
      var1.b(this.c, 0, this.c.length);
   }

   public boolean a(int var1, ByteString var2, int var3, int var4) {
      return var2.a(var3, this.c, var1, var4);
   }

   public boolean a(int var1, byte[] var2, int var3, int var4) {
      boolean var5;
      if (var1 >= 0 && var1 <= this.c.length - var4 && var3 >= 0 && var3 <= var2.length - var4 && Util.a(this.c, var1, var2, var3, var4)) {
         var5 = true;
      } else {
         var5 = false;
      }

      return var5;
   }

   public final boolean a(ByteString var1) {
      return this.a(0, var1, 0, var1.h());
   }

   public int b(ByteString var1) {
      byte var3 = -1;
      int var5 = this.h();
      int var4 = var1.h();
      int var6 = Math.min(var5, var4);
      int var2 = 0;

      while (true) {
         if (var2 < var6) {
            int var8 = this.a(var2) & 255;
            int var7 = var1.a(var2) & 255;
            if (var8 == var7) {
               var2++;
               continue;
            }

            if (var8 < var7) {
               var9 = var3;
            } else {
               var9 = 1;
            }
            break;
         }

         if (var5 == var4) {
            var9 = 0;
         } else {
            var9 = var3;
            if (var5 >= var4) {
               var9 = 1;
            }
         }
         break;
      }

      return var9;
   }

   public String b() {
      return Base64.a(this.c);
   }

   public ByteString c() {
      return this.d("MD5");
   }

   public ByteString d() {
      return this.d("SHA-1");
   }

   public ByteString e() {
      return this.d("SHA-256");
   }

   @Override
   public boolean equals(Object var1) {
      boolean var2 = true;
      if (var1 != this) {
         if (var1 instanceof ByteString && ((ByteString)var1).h() == this.c.length && ((ByteString)var1).a(0, this.c, 0, this.c.length)) {
            var2 = true;
         } else {
            var2 = false;
         }
      }

      return var2;
   }

   public String f() {
      byte var2 = 0;
      char[] var7 = new char[this.c.length * 2];

      for (byte var5 : this.c) {
         int var8;
         int var4 = var8 + 1;
         var7[var8] = a[var5 >> 4 & 15];
         var8 = var4 + 1;
         var7[var4] = a[var5 & 15];
      }

      return new String(var7);
   }

   public ByteString g() {
      int var1 = 0;

      ByteString var3;
      while (true) {
         var3 = this;
         if (var1 >= this.c.length) {
            break;
         }

         byte var2 = this.c[var1];
         if (var2 >= 65 && var2 <= 90) {
            byte[] var6 = (byte[])this.c.clone();
            var6[var1] = (byte)(var2 + 32);
            var1++;

            for (; var1 < var6.length; var1++) {
               var2 = var6[var1];
               if (var2 >= 65 && var2 <= 90) {
                  var6[var1] = (byte)(var2 + 32);
               }
            }

            var3 = new ByteString(var6);
            break;
         }

         var1++;
      }

      return var3;
   }

   public int h() {
      return this.c.length;
   }

   @Override
   public int hashCode() {
      int var1 = this.d;
      if (var1 == 0) {
         var1 = Arrays.hashCode(this.c);
         this.d = var1;
      }

      return var1;
   }

   public byte[] i() {
      return (byte[])this.c.clone();
   }

   @Override
   public String toString() {
      String var2;
      if (this.c.length == 0) {
         var2 = "[size=0]";
      } else {
         String var3 = this.a();
         int var1 = a(var3, 64);
         if (var1 == -1) {
            if (this.c.length <= 64) {
               var2 = "[hex=" + this.f() + "]";
            } else {
               var2 = "[size=" + this.c.length + " hex=" + this.a(0, 64).f() + "…]";
            }
         } else {
            var2 = var3.substring(0, var1).replace("\\", "\\\\").replace("\n", "\\n").replace("\r", "\\r");
            if (var1 < var3.length()) {
               var2 = "[size=" + this.c.length + " text=" + var2 + "…]";
            } else {
               var2 = "[text=" + var2 + "]";
            }
         }
      }

      return var2;
   }
}
