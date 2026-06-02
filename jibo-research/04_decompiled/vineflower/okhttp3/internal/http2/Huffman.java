package okhttp3.internal.http2;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.nio.ShortBuffer;
import okio.BufferedSink;
import okio.ByteString;

class Huffman {
   private static final int[] a = $d2j$hex$aed4b9af$decode_I(
      "f81f0000d8ff7f00e2ffff0fe3ffff0fe4ffff0fe5ffff0fe6ffff0fe7ffff0fe8ffff0feaffff00fcffff3fe9ffff0feaffff0ffdffff3febffff0fecffff0fedffff0feeffff0fefffff0ff0ffff0ff1ffff0ff2ffff0ffeffff3ff3ffff0ff4ffff0ff5ffff0ff6ffff0ff7ffff0ff8ffff0ff9ffff0ffaffff0ffbffff0f14000000f8030000f9030000fa0f0000f91f000015000000f8000000fa070000fa030000fb030000f9000000fb070000fa000000160000001700000018000000000000000100000002000000190000001a0000001b0000001c0000001d0000001e0000001f0000005c000000fb000000fc7f000020000000fb0f0000fc030000fa1f0000210000005d0000005e0000005f000000600000006100000062000000630000006400000065000000660000006700000068000000690000006a0000006b0000006c0000006d0000006e0000006f000000700000007100000072000000fc00000073000000fd000000fb1f0000f0ff0700fc1f0000fc3f000022000000fd7f0000030000002300000004000000240000000500000025000000260000002700000006000000740000007500000028000000290000002a000000070000002b000000760000002c00000008000000090000002d0000007700000078000000790000007a0000007b000000fe7f0000fc070000fd3f0000fd1f0000fcffff0fe6ff0f00d2ff3f00e7ff0f00e8ff0f00d3ff3f00d4ff3f00d5ff3f00d9ff7f00d6ff3f00daff7f00dbff7f00dcff7f00ddff7f00deff7f00ebffff00dfff7f00ecffff00edffff00d7ff3f00e0ff7f00eeffff00e1ff7f00e2ff7f00e3ff7f00e4ff7f00dcff1f00d8ff3f00e5ff7f00d9ff3f00e6ff7f00e7ff7f00efffff00daff3f00ddff1f00e9ff0f00dbff3f00dcff3f00e8ff7f00e9ff7f00deff1f00eaff7f00ddff3f00deff3f00f0ffff00dfff1f00dfff3f00ebff7f00ecff7f00e0ff1f00e1ff1f00e0ff3f00e2ff1f00edff7f00e1ff3f00eeff7f00efff7f00eaff0f00e2ff3f00e3ff3f00e4ff3f00f0ff7f00e5ff3f00e6ff3f00f1ff7f00e0ffff03e1ffff03ebff0f00f1ff0700e7ff3f00f2ff7f00e8ff3f00ecffff01e2ffff03e3ffff03e4ffff03deffff07dfffff07e5ffff03f1ffff00edffff01f2ff0700e3ff1f00e6ffff03e0ffff07e1ffff07e7ffff03e2ffff07f2ffff00e4ff1f00e5ff1f00e8ffff03e9ffff03fdffff0fe3ffff07e4ffff07e5ffff07ecff0f00f3ffff00edff0f00e6ff1f00e9ff3f00e7ff1f00e8ff1f00f3ff7f00eaff3f00ebff3f00eeffff01efffff01f4ffff00f5ffff00eaffff03f4ff7f00ebffff03e6ffff07ecffff03edffff03e7ffff07e8ffff07e9ffff07eaffff07ebffff07feffff0fecffff07edffff07eeffff07efffff07f0ffff07eeffff03"
   );
   private static final byte[] b = new byte[]{
      13,
      23,
      28,
      28,
      28,
      28,
      28,
      28,
      28,
      24,
      30,
      28,
      28,
      30,
      28,
      28,
      28,
      28,
      28,
      28,
      28,
      28,
      30,
      28,
      28,
      28,
      28,
      28,
      28,
      28,
      28,
      28,
      6,
      10,
      10,
      12,
      13,
      6,
      8,
      11,
      10,
      10,
      8,
      11,
      8,
      6,
      6,
      6,
      5,
      5,
      5,
      6,
      6,
      6,
      6,
      6,
      6,
      6,
      7,
      8,
      15,
      6,
      12,
      10,
      13,
      6,
      7,
      7,
      7,
      7,
      7,
      7,
      7,
      7,
      7,
      7,
      7,
      7,
      7,
      7,
      7,
      7,
      7,
      7,
      7,
      7,
      7,
      7,
      8,
      7,
      8,
      13,
      19,
      13,
      14,
      6,
      15,
      5,
      6,
      5,
      6,
      5,
      6,
      6,
      6,
      5,
      7,
      7,
      6,
      6,
      6,
      5,
      6,
      7,
      6,
      5,
      5,
      6,
      7,
      7,
      7,
      7,
      7,
      15,
      11,
      14,
      13,
      28,
      20,
      22,
      20,
      20,
      22,
      22,
      22,
      23,
      22,
      23,
      23,
      23,
      23,
      23,
      24,
      23,
      24,
      24,
      22,
      23,
      24,
      23,
      23,
      23,
      23,
      21,
      22,
      23,
      22,
      23,
      23,
      24,
      22,
      21,
      20,
      22,
      22,
      23,
      23,
      21,
      23,
      22,
      22,
      24,
      21,
      22,
      23,
      23,
      21,
      21,
      22,
      21,
      23,
      22,
      23,
      23,
      20,
      22,
      22,
      22,
      23,
      22,
      22,
      23,
      26,
      26,
      20,
      19,
      22,
      23,
      22,
      25,
      26,
      26,
      26,
      27,
      27,
      26,
      24,
      25,
      19,
      21,
      26,
      27,
      27,
      26,
      27,
      24,
      21,
      21,
      26,
      26,
      28,
      27,
      27,
      27,
      20,
      24,
      20,
      21,
      22,
      21,
      21,
      23,
      22,
      22,
      25,
      25,
      24,
      24,
      26,
      23,
      26,
      27,
      26,
      26,
      27,
      27,
      27,
      27,
      27,
      28,
      27,
      27,
      27,
      27,
      27,
      26
   };
   private static final Huffman c = new Huffman();
   private final Huffman.Node d = new Huffman.Node();

   private Huffman() {
      this.b();
   }

   public static Huffman a() {
      return c;
   }

   private void a(int var1, int var2, byte var3) {
      Huffman.Node var5 = new Huffman.Node(var1, var3);
      Huffman.Node var4 = this.d;

      while (var3 > 8) {
         var3 = (byte)(var3 - 8);
         var1 = var2 >>> var3 & 0xFF;
         if (var4.a == null) {
            throw new IllegalStateException("invalid dictionary: prefix not unique");
         }

         if (var4.a[var1] == null) {
            var4.a[var1] = new Huffman.Node();
         }

         var4 = var4.a[var1];
      }

      var3 = 8 - var3;
      var2 = var2 << var3 & 0xFF;

      for (int var7 = var2; var7 < var2 + (1 << var3); var7++) {
         var4.a[var7] = var5;
      }
   }

   private void b() {
      for (int var1 = 0; var1 < b.length; var1++) {
         this.a(var1, a[var1], b[var1]);
      }
   }

   int a(ByteString var1) {
      long var4 = 0L;

      for (int var2 = 0; var2 < var1.h(); var2++) {
         byte var3 = var1.a(var2);
         var4 += b[var3 & 0xFF];
      }

      return (int)(7L + var4 >> 3);
   }

   void a(ByteString var1, BufferedSink var2) throws IOException {
      int var4 = 0;
      long var7 = 0L;
      byte var3 = 0;

      while (var4 < var1.h()) {
         int var6 = var1.a(var4) & 255;
         int var5 = a[var6];
         byte var9 = b[var6];
         var7 = var7 << var9 | var5;
         var3 += var9;

         while (var3 >= 8) {
            var3 -= 8;
            var2.k((int)(var7 >> var3));
         }

         var4++;
      }

      if (var3 > 0) {
         var2.k((int)(255 >>> var3 | var7 << 8 - var3));
      }
   }

   byte[] a(byte[] var1) {
      int var3 = 0;
      ByteArrayOutputStream var8 = new ByteArrayOutputStream();
      Huffman.Node var6 = this.d;
      int var4 = 0;
      int var2 = 0;

      while (true) {
         int var5 = var2;
         Huffman.Node var7 = var6;
         if (var3 >= var1.length) {
            while (var5 > 0) {
               Huffman.Node var9 = var7.a[var4 << 8 - var5 & 0xFF];
               if (var9.a != null || var9.c > var5) {
                  break;
               }

               var8.write(var9.b);
               var5 -= var9.c;
               var7 = this.d;
            }

            return var8.toByteArray();
         }

         var4 = var4 << 8 | var1[var3] & 255;
         var2 += 8;

         while (var2 >= 8) {
            var6 = var6.a[var4 >>> var2 - 8 & 0xFF];
            if (var6.a == null) {
               var8.write(var6.b);
               var2 -= var6.c;
               var6 = this.d;
            } else {
               var2 -= 8;
            }
         }

         var3++;
      }
   }

   private static long[] $d2j$hex$aed4b9af$decode_J(String src) {
      byte[] d = $d2j$hex$aed4b9af$decode_B(src);
      ByteBuffer b = ByteBuffer.wrap(d);
      b.order(ByteOrder.LITTLE_ENDIAN);
      LongBuffer s = b.asLongBuffer();
      long[] data = new long[d.length / 8];
      s.get(data);
      return data;
   }

   private static int[] $d2j$hex$aed4b9af$decode_I(String src) {
      byte[] d = $d2j$hex$aed4b9af$decode_B(src);
      ByteBuffer b = ByteBuffer.wrap(d);
      b.order(ByteOrder.LITTLE_ENDIAN);
      IntBuffer s = b.asIntBuffer();
      int[] data = new int[d.length / 4];
      s.get(data);
      return data;
   }

   private static short[] $d2j$hex$aed4b9af$decode_S(String src) {
      byte[] d = $d2j$hex$aed4b9af$decode_B(src);
      ByteBuffer b = ByteBuffer.wrap(d);
      b.order(ByteOrder.LITTLE_ENDIAN);
      ShortBuffer s = b.asShortBuffer();
      short[] data = new short[d.length / 2];
      s.get(data);
      return data;
   }

   private static byte[] $d2j$hex$aed4b9af$decode_B(String src) {
      char[] d = src.toCharArray();
      byte[] ret = new byte[src.length() / 2];

      for (int i = 0; i < ret.length; i++) {
         char h = d[2 * i];
         char l = d[2 * i + 1];
         int hh;
         if (h >= '0' && h <= '9') {
            hh = h - '0';
         } else if (h >= 'a' && h <= 'f') {
            hh = h - 'a' + 10;
         } else {
            if (h < 'A' || h > 'F') {
               throw new RuntimeException();
            }

            hh = h - 'A' + 10;
         }

         int ll;
         if (l >= '0' && l <= '9') {
            ll = l - '0';
         } else if (l >= 'a' && l <= 'f') {
            ll = l - 'a' + 10;
         } else {
            if (l < 'A' || l > 'F') {
               throw new RuntimeException();
            }

            ll = l - 'A' + 10;
         }

         ret[i] = (byte)(hh << 4 | ll);
      }

      return ret;
   }

   private static final class Node {
      final Huffman.Node[] a;
      final int b;
      final int c;

      Node() {
         this.a = new Huffman.Node[256];
         this.b = 0;
         this.c = 0;
      }

      Node(int var1, int var2) {
         this.a = null;
         this.b = var1;
         var2 &= 7;
         var1 = var2;
         if (var2 == 0) {
            var1 = 8;
         }

         this.c = var1;
      }
   }
}
