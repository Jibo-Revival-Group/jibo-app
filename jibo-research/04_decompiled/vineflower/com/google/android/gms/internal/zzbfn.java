package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public final class zzbfn {
   public static ArrayList<Integer> A(Parcel var0, int var1) {
      int var4 = a(var0, var1);
      int var2 = var0.dataPosition();
      ArrayList var6;
      if (var4 == 0) {
         var6 = null;
      } else {
         ArrayList var5 = new ArrayList();
         int var3 = var0.readInt();

         for (int var7 = 0; var7 < var3; var7++) {
            var5.add(var0.readInt());
         }

         var0.setDataPosition(var2 + var4);
         var6 = var5;
      }

      return var6;
   }

   public static ArrayList<String> B(Parcel var0, int var1) {
      int var2 = a(var0, var1);
      var1 = var0.dataPosition();
      ArrayList var4;
      if (var2 == 0) {
         var4 = null;
      } else {
         ArrayList var3 = var0.createStringArrayList();
         var0.setDataPosition(var2 + var1);
         var4 = var3;
      }

      return var4;
   }

   public static Parcel C(Parcel var0, int var1) {
      int var2 = a(var0, var1);
      var1 = var0.dataPosition();
      if (var2 == 0) {
         var0 = null;
      } else {
         Parcel var3 = Parcel.obtain();
         var3.appendFrom(var0, var1, var2);
         var0.setDataPosition(var2 + var1);
         var0 = var3;
      }

      return var0;
   }

   public static Parcel[] D(Parcel var0, int var1) {
      Object var7 = null;
      int var4 = a(var0, var1);
      int var2 = var0.dataPosition();
      Parcel[] var9;
      if (var4 == 0) {
         var9 = (Parcel[])var7;
      } else {
         int var3 = var0.readInt();
         var7 = new Parcel[var3];

         for (int var10 = 0; var10 < var3; var10++) {
            int var6 = var0.readInt();
            if (var6 != 0) {
               int var5 = var0.dataPosition();
               Parcel var8 = Parcel.obtain();
               var8.appendFrom(var0, var5, var6);
               ((Object[])var7)[var10] = var8;
               var0.setDataPosition(var6 + var5);
            } else {
               ((Object[])var7)[var10] = null;
            }
         }

         var0.setDataPosition(var2 + var4);
         var9 = (Parcel[])var7;
      }

      return var9;
   }

   public static void E(Parcel var0, int var1) {
      if (var0.dataPosition() != var1) {
         throw new zzbfo(new StringBuilder(37).append("Overread allowed size end=").append(var1).toString(), var0);
      }
   }

   public static int a(Parcel var0) {
      int var3 = var0.readInt();
      int var2 = a(var0, var3);
      int var1 = var0.dataPosition();
      if ((65535 & var3) != 20293) {
         String var4 = String.valueOf(Integer.toHexString(var3));
         if (var4.length() != 0) {
            var4 = "Expected object header. Got 0x".concat(var4);
         } else {
            var4 = new String("Expected object header. Got 0x");
         }

         throw new zzbfo(var4, var0);
      } else {
         var2 = var1 + var2;
         if (var2 >= var1 && var2 <= var0.dataSize()) {
            return var2;
         } else {
            throw new zzbfo(new StringBuilder(54).append("Size read is invalid start=").append(var1).append(" end=").append(var2).toString(), var0);
         }
      }
   }

   public static int a(Parcel var0, int var1) {
      if ((var1 & -65536) != -65536) {
         var1 = var1 >> 16 & 65535;
      } else {
         var1 = var0.readInt();
      }

      return var1;
   }

   public static <T extends Parcelable> T a(Parcel var0, int var1, Creator<T> var2) {
      int var3 = a(var0, var1);
      var1 = var0.dataPosition();
      Parcelable var4;
      if (var3 == 0) {
         var4 = null;
      } else {
         Parcelable var6 = (Parcelable)var2.createFromParcel(var0);
         var0.setDataPosition(var3 + var1);
         var4 = var6;
      }

      return (T)var4;
   }

   private static void a(Parcel var0, int var1, int var2) {
      var1 = a(var0, var1);
      if (var1 != var2) {
         String var3 = Integer.toHexString(var1);
         throw new zzbfo(
            new StringBuilder(String.valueOf(var3).length() + 46)
               .append("Expected size ")
               .append(var2)
               .append(" got ")
               .append(var1)
               .append(" (0x")
               .append(var3)
               .append(")")
               .toString(),
            var0
         );
      }
   }

   private static void a(Parcel var0, int var1, int var2, int var3) {
      if (var2 != var3) {
         String var4 = Integer.toHexString(var2);
         throw new zzbfo(
            new StringBuilder(String.valueOf(var4).length() + 46)
               .append("Expected size ")
               .append(var3)
               .append(" got ")
               .append(var2)
               .append(" (0x")
               .append(var4)
               .append(")")
               .toString(),
            var0
         );
      }
   }

   public static void a(Parcel var0, int var1, List var2, ClassLoader var3) {
      int var4 = a(var0, var1);
      var1 = var0.dataPosition();
      if (var4 != 0) {
         var0.readList(var2, var3);
         var0.setDataPosition(var4 + var1);
      }
   }

   public static void b(Parcel var0, int var1) {
      var0.setDataPosition(a(var0, var1) + var0.dataPosition());
   }

   public static <T> T[] b(Parcel var0, int var1, Creator<T> var2) {
      var1 = a(var0, var1);
      int var3 = var0.dataPosition();
      Object[] var4;
      if (var1 == 0) {
         var4 = null;
      } else {
         Object[] var6 = var0.createTypedArray(var2);
         var0.setDataPosition(var1 + var3);
         var4 = var6;
      }

      return (T[])var4;
   }

   public static <T> ArrayList<T> c(Parcel var0, int var1, Creator<T> var2) {
      int var3 = a(var0, var1);
      var1 = var0.dataPosition();
      ArrayList var4;
      if (var3 == 0) {
         var4 = null;
      } else {
         ArrayList var6 = var0.createTypedArrayList(var2);
         var0.setDataPosition(var3 + var1);
         var4 = var6;
      }

      return var4;
   }

   public static boolean c(Parcel var0, int var1) {
      a(var0, var1, 4);
      boolean var2;
      if (var0.readInt() != 0) {
         var2 = true;
      } else {
         var2 = false;
      }

      return var2;
   }

   public static byte d(Parcel var0, int var1) {
      a(var0, var1, 4);
      return (byte)var0.readInt();
   }

   public static short e(Parcel var0, int var1) {
      a(var0, var1, 4);
      return (short)var0.readInt();
   }

   public static int f(Parcel var0, int var1) {
      a(var0, var1, 4);
      return var0.readInt();
   }

   public static Integer g(Parcel var0, int var1) {
      int var2 = a(var0, var1);
      Integer var3;
      if (var2 == 0) {
         var3 = null;
      } else {
         a(var0, var1, var2, 4);
         var3 = var0.readInt();
      }

      return var3;
   }

   public static long h(Parcel var0, int var1) {
      a(var0, var1, 8);
      return var0.readLong();
   }

   public static Long i(Parcel var0, int var1) {
      int var2 = a(var0, var1);
      Long var3;
      if (var2 == 0) {
         var3 = null;
      } else {
         a(var0, var1, var2, 8);
         var3 = var0.readLong();
      }

      return var3;
   }

   public static BigInteger j(Parcel var0, int var1) {
      var1 = a(var0, var1);
      int var2 = var0.dataPosition();
      BigInteger var4;
      if (var1 == 0) {
         var4 = null;
      } else {
         byte[] var3 = var0.createByteArray();
         var0.setDataPosition(var1 + var2);
         var4 = new BigInteger(var3);
      }

      return var4;
   }

   public static float k(Parcel var0, int var1) {
      a(var0, var1, 4);
      return var0.readFloat();
   }

   public static Float l(Parcel var0, int var1) {
      int var2 = a(var0, var1);
      Float var3;
      if (var2 == 0) {
         var3 = null;
      } else {
         a(var0, var1, var2, 4);
         var3 = var0.readFloat();
      }

      return var3;
   }

   public static double m(Parcel var0, int var1) {
      a(var0, var1, 8);
      return var0.readDouble();
   }

   public static Double n(Parcel var0, int var1) {
      int var2 = a(var0, var1);
      Double var3;
      if (var2 == 0) {
         var3 = null;
      } else {
         a(var0, var1, var2, 8);
         var3 = var0.readDouble();
      }

      return var3;
   }

   public static BigDecimal o(Parcel var0, int var1) {
      var1 = a(var0, var1);
      int var3 = var0.dataPosition();
      BigDecimal var5;
      if (var1 == 0) {
         var5 = null;
      } else {
         byte[] var4 = var0.createByteArray();
         int var2 = var0.readInt();
         var0.setDataPosition(var1 + var3);
         var5 = new BigDecimal(new BigInteger(var4), var2);
      }

      return var5;
   }

   public static String p(Parcel var0, int var1) {
      int var2 = a(var0, var1);
      var1 = var0.dataPosition();
      String var4;
      if (var2 == 0) {
         var4 = null;
      } else {
         String var3 = var0.readString();
         var0.setDataPosition(var2 + var1);
         var4 = var3;
      }

      return var4;
   }

   public static IBinder q(Parcel var0, int var1) {
      var1 = a(var0, var1);
      int var2 = var0.dataPosition();
      IBinder var4;
      if (var1 == 0) {
         var4 = null;
      } else {
         IBinder var3 = var0.readStrongBinder();
         var0.setDataPosition(var1 + var2);
         var4 = var3;
      }

      return var4;
   }

   public static Bundle r(Parcel var0, int var1) {
      var1 = a(var0, var1);
      int var2 = var0.dataPosition();
      Bundle var4;
      if (var1 == 0) {
         var4 = null;
      } else {
         Bundle var3 = var0.readBundle();
         var0.setDataPosition(var1 + var2);
         var4 = var3;
      }

      return var4;
   }

   public static byte[] s(Parcel var0, int var1) {
      int var2 = a(var0, var1);
      var1 = var0.dataPosition();
      byte[] var4;
      if (var2 == 0) {
         var4 = null;
      } else {
         byte[] var3 = var0.createByteArray();
         var0.setDataPosition(var2 + var1);
         var4 = var3;
      }

      return var4;
   }

   public static byte[][] t(Parcel var0, int var1) {
      int var4 = a(var0, var1);
      int var3 = var0.dataPosition();
      byte[][] var6;
      if (var4 == 0) {
         var6 = null;
      } else {
         int var2 = var0.readInt();
         byte[][] var5 = new byte[var2][];

         for (int var7 = 0; var7 < var2; var7++) {
            var5[var7] = var0.createByteArray();
         }

         var0.setDataPosition(var3 + var4);
         var6 = var5;
      }

      return var6;
   }

   public static boolean[] u(Parcel var0, int var1) {
      var1 = a(var0, var1);
      int var2 = var0.dataPosition();
      boolean[] var4;
      if (var1 == 0) {
         var4 = null;
      } else {
         boolean[] var3 = var0.createBooleanArray();
         var0.setDataPosition(var1 + var2);
         var4 = var3;
      }

      return var4;
   }

   public static int[] v(Parcel var0, int var1) {
      int var2 = a(var0, var1);
      var1 = var0.dataPosition();
      int[] var4;
      if (var2 == 0) {
         var4 = null;
      } else {
         int[] var3 = var0.createIntArray();
         var0.setDataPosition(var2 + var1);
         var4 = var3;
      }

      return var4;
   }

   public static long[] w(Parcel var0, int var1) {
      int var2 = a(var0, var1);
      var1 = var0.dataPosition();
      long[] var4;
      if (var2 == 0) {
         var4 = null;
      } else {
         long[] var3 = var0.createLongArray();
         var0.setDataPosition(var2 + var1);
         var4 = var3;
      }

      return var4;
   }

   public static float[] x(Parcel var0, int var1) {
      var1 = a(var0, var1);
      int var2 = var0.dataPosition();
      float[] var4;
      if (var1 == 0) {
         var4 = null;
      } else {
         float[] var3 = var0.createFloatArray();
         var0.setDataPosition(var1 + var2);
         var4 = var3;
      }

      return var4;
   }

   public static BigDecimal[] y(Parcel var0, int var1) {
      int var4 = a(var0, var1);
      int var2 = var0.dataPosition();
      BigDecimal[] var8;
      if (var4 == 0) {
         var8 = null;
      } else {
         int var3 = var0.readInt();
         BigDecimal[] var6 = new BigDecimal[var3];

         for (int var9 = 0; var9 < var3; var9++) {
            byte[] var7 = var0.createByteArray();
            int var5 = var0.readInt();
            var6[var9] = new BigDecimal(new BigInteger(var7), var5);
         }

         var0.setDataPosition(var2 + var4);
         var8 = var6;
      }

      return var8;
   }

   public static String[] z(Parcel var0, int var1) {
      int var2 = a(var0, var1);
      var1 = var0.dataPosition();
      String[] var4;
      if (var2 == 0) {
         var4 = null;
      } else {
         String[] var3 = var0.createStringArray();
         var0.setDataPosition(var2 + var1);
         var4 = var3;
      }

      return var4;
   }
}
