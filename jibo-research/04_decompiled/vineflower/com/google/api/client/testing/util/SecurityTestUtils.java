package com.google.api.client.testing.util;

import com.google.api.client.util.Beta;
import com.google.api.client.util.SecurityUtils;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.nio.ShortBuffer;
import java.security.GeneralSecurityException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

@Beta
public final class SecurityTestUtils {
   private static final byte[] ENCODED_PRIVATE_KEY = $d2j$hex$c48aebe0$decode_B(
      "30820276020100300d06092a864886f70d0101010500048202603082025c02010002818100a72108846ec45908c245785fc5d50dee7b1de10db0b46dc2b10268a24c3bb7e6637bc7a49c7432e760357c5f4cc5ac461b0048c154b3fe95bee0891ba136d4a701472c07c97e05b257978e41ed3ab2a10076534ca802eb7f404a998e81baaf817ddb1571149a2edb919f61812057b06912ed6bb7ce9f0be9c5959553e70fa3eb02030100010281802dde981ad8d7d4e3dd85f992b79650fb8a18da42caa3ca982bc2d07af2d75512cb6d168f2c4d8c070ad5c32bd8c34c13f5a72f50b871aa46e91b7125ff2a3054b01e562484ea4fd457d81fd7d4f0b6553d86ea0ae14e5c85b30cb03ecc44d2ef437cb2e997b3fe59f0f4c8cd1a662e27c3f3b1bffb7e461d1f689341e9bb17f9024100d612650aeb256bfd8ee3d84c6b862808c6e0f437fcc3be5bc8ce4e840bcfc287c846a45a2090311a9d712c1a2a9dd885115d727d238ae07dc03d3ac69797d95d024100c7dcea95d6b1008a79b478346e7f7344aafc60ce48c4c77d3915afd41970b55339c93d181c9099f8786ecc94d7b4a0578b4500401a047a0d069670cdff4f75e702407f443c51fb6e29ff7a5db68fe834bfc4480820e8d01ac726e600d0e8ebe4be2fdf3f30226ccd8c83d82a1a200c49ff194d33930716844fe632cdb40db0be13f9024100a663ec44fcacf597538584c199f0af654eb8b85b64c7b69131123604ed7d20e87de664df8b0073bf217c9503a1a5760c0c1d50fd0cec07348af47a4b75af90a702405debcc92caf74f85697dc84bb3e67d85bb3efe4f0848b4bd05218701d6ef1d45ecbce6e95ff9bacef63a10f1a7e887f2b881a7c142074da7caa1a62dd48a45ff"
   );
   private static final byte[] ENCODED_PUBLIC_KEY = new byte[]{
      48,
      -127,
      -97,
      48,
      13,
      6,
      9,
      42,
      -122,
      72,
      -122,
      -9,
      13,
      1,
      1,
      1,
      5,
      0,
      3,
      -127,
      -115,
      0,
      48,
      -127,
      -119,
      2,
      -127,
      -127,
      0,
      -89,
      33,
      8,
      -124,
      110,
      -60,
      89,
      8,
      -62,
      69,
      120,
      95,
      -59,
      -43,
      13,
      -18,
      123,
      29,
      -31,
      13,
      -80,
      -76,
      109,
      -62,
      -79,
      2,
      104,
      -94,
      76,
      59,
      -73,
      -26,
      99,
      123,
      -57,
      -92,
      -100,
      116,
      50,
      -25,
      96,
      53,
      124,
      95,
      76,
      -59,
      -84,
      70,
      27,
      0,
      72,
      -63,
      84,
      -77,
      -2,
      -107,
      -66,
      -32,
      -119,
      27,
      -95,
      54,
      -44,
      -89,
      1,
      71,
      44,
      7,
      -55,
      126,
      5,
      -78,
      87,
      -105,
      -114,
      65,
      -19,
      58,
      -78,
      -95,
      0,
      118,
      83,
      76,
      -88,
      2,
      -21,
      127,
      64,
      74,
      -103,
      -114,
      -127,
      -70,
      -81,
      -127,
      125,
      -37,
      21,
      113,
      20,
      -102,
      46,
      -37,
      -111,
      -97,
      97,
      -127,
      32,
      87,
      -80,
      105,
      18,
      -19,
      107,
      -73,
      -50,
      -97,
      11,
      -23,
      -59,
      -107,
      -107,
      83,
      -25,
      15,
      -93,
      -21,
      2,
      3,
      1,
      0,
      1
   };

   private SecurityTestUtils() {
   }

   public static byte[] newEncodedRsaPrivateKeyBytes() {
      return (byte[])ENCODED_PRIVATE_KEY.clone();
   }

   public static byte[] newEncodedRsaPublicKeyBytes() {
      return (byte[])ENCODED_PUBLIC_KEY.clone();
   }

   public static RSAPrivateKey newRsaPrivateKey() throws GeneralSecurityException {
      return (RSAPrivateKey)SecurityUtils.getRsaKeyFactory().generatePrivate(new PKCS8EncodedKeySpec(ENCODED_PRIVATE_KEY));
   }

   public static RSAPublicKey newRsaPublicKey() throws GeneralSecurityException {
      return (RSAPublicKey)SecurityUtils.getRsaKeyFactory().generatePublic(new X509EncodedKeySpec(ENCODED_PUBLIC_KEY));
   }

   private static long[] $d2j$hex$c48aebe0$decode_J(String src) {
      byte[] d = $d2j$hex$c48aebe0$decode_B(src);
      ByteBuffer b = ByteBuffer.wrap(d);
      b.order(ByteOrder.LITTLE_ENDIAN);
      LongBuffer s = b.asLongBuffer();
      long[] data = new long[d.length / 8];
      s.get(data);
      return data;
   }

   private static int[] $d2j$hex$c48aebe0$decode_I(String src) {
      byte[] d = $d2j$hex$c48aebe0$decode_B(src);
      ByteBuffer b = ByteBuffer.wrap(d);
      b.order(ByteOrder.LITTLE_ENDIAN);
      IntBuffer s = b.asIntBuffer();
      int[] data = new int[d.length / 4];
      s.get(data);
      return data;
   }

   private static short[] $d2j$hex$c48aebe0$decode_S(String src) {
      byte[] d = $d2j$hex$c48aebe0$decode_B(src);
      ByteBuffer b = ByteBuffer.wrap(d);
      b.order(ByteOrder.LITTLE_ENDIAN);
      ShortBuffer s = b.asShortBuffer();
      short[] data = new short[d.length / 2];
      s.get(data);
      return data;
   }

   private static byte[] $d2j$hex$c48aebe0$decode_B(String src) {
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
}
