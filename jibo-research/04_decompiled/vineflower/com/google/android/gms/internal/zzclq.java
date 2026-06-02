package com.google.android.gms.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.measurement.AppMeasurement;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import javax.security.auth.x500.X500Principal;

public final class zzclq extends zzcjl {
   private static String[] a = new String[]{"firebase_"};
   private SecureRandom b;
   private final AtomicLong c = new AtomicLong(0L);
   private int d;

   zzclq(zzcim var1) {
      super(var1);
   }

   private final int a(String var1, Object var2, boolean var3) {
      if (var3) {
         int var6;
         label32: {
            if (var2 instanceof Parcelable[]) {
               var6 = ((Parcelable[])var2).length;
            } else {
               if (!(var2 instanceof ArrayList)) {
                  var6 = 1;
                  break label32;
               }

               var6 = ((ArrayList)var2).size();
            }

            if (var6 > 1000) {
               this.t().A().a("Parameter array is too long; discarded. Value kind, name, array length", "param", var1, var6);
               var6 = 0;
            } else {
               var6 = 1;
            }
         }

         if (!var6) {
            byte var8 = 17;
            return var8;
         }
      }

      if (i(var1)) {
         var3 = this.a("param", var1, 256, var2, var3);
      } else {
         var3 = this.a("param", var1, 100, var2, var3);
      }

      byte var7;
      if (var3) {
         var7 = 0;
      } else {
         var7 = 4;
      }

      return var7;
   }

   private static Object a(int var0, Object var1, boolean var2) {
      Object var5;
      if (var1 == null) {
         var5 = null;
      } else {
         var5 = var1;
         if (!(var1 instanceof Long)) {
            var5 = var1;
            if (!(var1 instanceof Double)) {
               if (var1 instanceof Integer) {
                  var5 = (long)((Integer)var1).intValue();
               } else if (var1 instanceof Byte) {
                  var5 = (long)((Byte)var1).byteValue();
               } else if (var1 instanceof Short) {
                  var5 = (long)((Short)var1).shortValue();
               } else if (var1 instanceof Boolean) {
                  long var3;
                  if ((Boolean)var1) {
                     var3 = 1L;
                  } else {
                     var3 = 0L;
                  }

                  var5 = var3;
               } else if (var1 instanceof Float) {
                  var5 = ((Float)var1).doubleValue();
               } else if (!(var1 instanceof String) && !(var1 instanceof Character) && !(var1 instanceof CharSequence)) {
                  var5 = null;
               } else {
                  var5 = a(String.valueOf(var1), var0, var2);
               }
            }
         }
      }

      return var5;
   }

   public static Object a(zzcmb var0, String var1) {
      zzcmc[] var5 = var0.a;
      int var3 = var5.length;
      int var2 = 0;

      while (true) {
         if (var2 >= var3) {
            var6 = null;
            break;
         }

         zzcmc var4 = var5[var2];
         if (var4.a.equals(var1)) {
            if (var4.b != null) {
               var6 = var4.b;
               break;
            }

            if (var4.c != null) {
               var6 = var4.c;
               break;
            }

            if (var4.d != null) {
               var6 = var4.d;
               break;
            }
         }

         var2++;
      }

      return var6;
   }

   public static String a(String var0, int var1, boolean var2) {
      String var3 = var0;
      if (var0.codePointCount(0, var0.length()) > var1) {
         if (var2) {
            var3 = String.valueOf(var0.substring(0, var0.offsetByCodePoints(0, var1))).concat("...");
         } else {
            var3 = null;
         }
      }

      return var3;
   }

   public static String a(String var0, String[] var1, String[] var2) {
      zzbq.a(var1);
      zzbq.a(var2);
      int var4 = Math.min(var1.length, var2.length);
      int var3 = 0;

      while (true) {
         if (var3 >= var4) {
            var0 = null;
            break;
         }

         if (a(var0, var1[var3])) {
            var0 = var2[var3];
            break;
         }

         var3++;
      }

      return var0;
   }

   private static void a(Bundle var0, Object var1) {
      zzbq.a(var0);
      if (var1 != null && (var1 instanceof String || var1 instanceof CharSequence)) {
         var0.putLong("_el", String.valueOf(var1).length());
      }
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   public static boolean a(Context var0, String var1) {
      boolean var3 = false;

      PackageManager var6;
      try {
         var6 = var0.getPackageManager();
      } catch (NameNotFoundException var9) {
         return var3;
      }

      boolean var2;
      if (var6 == null) {
         var2 = var3;
      } else {
         try {
            ComponentName var5 = new ComponentName(var0, var1);
            var10 = var6.getServiceInfo(var5, 4);
         } catch (NameNotFoundException var8) {
            var2 = var3;
            return var2;
         }

         var2 = var3;
         if (var10 != null) {
            boolean var4;
            try {
               var4 = var10.enabled;
            } catch (NameNotFoundException var7) {
               var2 = var3;
               return var2;
            }

            var2 = var3;
            if (var4) {
               var2 = true;
            }
         }
      }

      return var2;
   }

   public static boolean a(Intent var0) {
      String var2 = var0.getStringExtra("android.intent.extra.REFERRER_NAME");
      boolean var1;
      if (!"android-app://com.google.android.googlequicksearchbox/https/www.google.com".equals(var2)
         && !"https://www.google.com".equals(var2)
         && !"android-app://com.google.appcrawler".equals(var2)) {
         var1 = false;
      } else {
         var1 = true;
      }

      return var1;
   }

   private static boolean a(Bundle var0, int var1) {
      boolean var2;
      if (var0.getLong("_err") == 0L) {
         var0.putLong("_err", var1);
         var2 = true;
      } else {
         var2 = false;
      }

      return var2;
   }

   static boolean a(zzcha var0, zzcgi var1) {
      zzbq.a(var0);
      zzbq.a(var1);
      boolean var2;
      if (TextUtils.isEmpty(var1.b)) {
         var2 = false;
      } else {
         var2 = true;
      }

      return var2;
   }

   static boolean a(String var0) {
      boolean var1 = false;
      zzbq.a(var0);
      if (var0.charAt(0) != '_' || var0.equals("_ep")) {
         var1 = true;
      }

      return var1;
   }

   private final boolean a(String var1, int var2, String var3) {
      boolean var4 = false;
      if (var3 == null) {
         this.t().y().a("Name is required and can't be null. Type", var1);
      } else if (var3.codePointCount(0, var3.length()) > var2) {
         this.t().y().a("Name is too long. Type, maximum supported length, name", var1, var2, var3);
      } else {
         var4 = true;
      }

      return var4;
   }

   public static boolean a(String var0, String var1) {
      boolean var2;
      if (var0 == null && var1 == null) {
         var2 = true;
      } else if (var0 == null) {
         var2 = false;
      } else {
         var2 = var0.equals(var1);
      }

      return var2;
   }

   private final boolean a(String var1, String var2, int var3, Object var4, boolean var5) {
      boolean var8 = true;
      boolean var7;
      if (var4 == null) {
         var7 = var8;
      } else {
         var7 = var8;
         if (!(var4 instanceof Long)) {
            var7 = var8;
            if (!(var4 instanceof Float)) {
               var7 = var8;
               if (!(var4 instanceof Integer)) {
                  var7 = var8;
                  if (!(var4 instanceof Byte)) {
                     var7 = var8;
                     if (!(var4 instanceof Short)) {
                        var7 = var8;
                        if (!(var4 instanceof Boolean)) {
                           var7 = var8;
                           if (!(var4 instanceof Double)) {
                              if (!(var4 instanceof String) && !(var4 instanceof Character) && !(var4 instanceof CharSequence)) {
                                 if (var4 instanceof Bundle) {
                                    var7 = var8;
                                    if (var5) {
                                       return var7;
                                    }
                                 }

                                 if (var4 instanceof Parcelable[] && var5) {
                                    Parcelable[] var10 = (Parcelable[])var4;
                                    int var16 = var10.length;
                                    var3 = 0;

                                    while (true) {
                                       var7 = var8;
                                       if (var3 >= var16) {
                                          break;
                                       }

                                       Parcelable var15 = var10[var3];
                                       if (!(var15 instanceof Bundle)) {
                                          this.t().A().a("All Parcelable[] elements must be of type Bundle. Value type, name", var15.getClass(), var2);
                                          var7 = false;
                                          break;
                                       }

                                       var3++;
                                    }
                                 } else if (var4 instanceof ArrayList && var5) {
                                    ArrayList var14 = (ArrayList)var4;
                                    int var6 = var14.size();
                                    var3 = 0;

                                    while (true) {
                                       var7 = var8;
                                       if (var3 >= var6) {
                                          break;
                                       }

                                       Object var9 = var14.get(var3);
                                       var3++;
                                       if (!(var9 instanceof Bundle)) {
                                          this.t().A().a("All ArrayList elements must be of type Bundle. Value type, name", var9.getClass(), var2);
                                          var7 = false;
                                          break;
                                       }
                                    }
                                 } else {
                                    var7 = false;
                                 }
                              } else {
                                 String var13 = String.valueOf(var4);
                                 var7 = var8;
                                 if (var13.codePointCount(0, var13.length()) > var3) {
                                    this.t().A().a("Value is too long; discarded. Value kind, name, value length", var1, var2, var13.length());
                                    var7 = false;
                                 }
                              }
                           }
                        }
                     }
                  }
               }
            }
         }
      }

      return var7;
   }

   private final boolean a(String var1, String[] var2, String var3) {
      boolean var5 = false;
      if (var3 == null) {
         this.t().y().a("Name is required and can't be null. Type", var1);
      } else {
         zzbq.a((String)var3);
         int var4 = 0;

         while (true) {
            if (var4 >= a.length) {
               var6 = false;
               break;
            }

            if (var3.startsWith(a[var4])) {
               var6 = true;
               break;
            }

            var4++;
         }

         if (var6) {
            this.t().y().a("Name starts with reserved prefix. Type, name", var1, var3);
         } else {
            if (var2 != null) {
               zzbq.a(var2);
               var4 = 0;

               while (true) {
                  if (var4 >= var2.length) {
                     var8 = false;
                     break;
                  }

                  if (a(var3, var2[var4])) {
                     var8 = true;
                     break;
                  }

                  var4++;
               }

               if (var8) {
                  this.t().y().a("Name is reserved. Type, name", var1, var3);
                  return var5;
               }
            }

            var5 = true;
         }
      }

      return var5;
   }

   public static boolean a(long[] var0, int var1) {
      boolean var2 = false;
      if (var1 < var0.length << 6 && (var0[var1 / 64] & 1L << var1 % 64) != 0L) {
         var2 = true;
      }

      return var2;
   }

   static byte[] a(Parcelable var0) {
      byte[] var4;
      if (var0 == null) {
         var4 = null;
      } else {
         Parcel var1 = Parcel.obtain();

         try {
            var0.writeToParcel(var1, 0);
            var4 = var1.marshall();
         } finally {
            var1.recycle();
         }
      }

      return var4;
   }

   public static long[] a(BitSet var0) {
      int var3 = (var0.length() + 63) / 64;
      long[] var4 = new long[var3];

      for (int var1 = 0; var1 < var3; var1++) {
         var4[var1] = 0L;

         for (int var2 = 0; var2 < 64 && (var1 << 6) + var2 < var0.length(); var2++) {
            if (var0.get((var1 << 6) + var2)) {
               var4[var1] |= 1L << var2;
            }
         }
      }

      return var4;
   }

   public static Bundle[] a(Object var0) {
      Bundle[] var2;
      if (var0 instanceof Bundle) {
         Bundle[] var1 = new Bundle[]{(Bundle)var0};
         var2 = var1;
      } else if (var0 instanceof Parcelable[]) {
         var2 = Arrays.copyOf((Parcelable[])var0, ((Parcelable[])var0).length, Bundle[].class);
      } else if (var0 instanceof ArrayList) {
         ArrayList var3 = (ArrayList)var0;
         var2 = var3.toArray(new Bundle[var3.size()]);
      } else {
         var2 = null;
      }

      return var2;
   }

   static zzcmc[] a(zzcmc[] var0, String var1, Object var2) {
      int var4 = var0.length;
      int var3 = 0;

      while (true) {
         if (var3 >= var4) {
            zzcmc[] var8 = new zzcmc[var0.length + 1];
            System.arraycopy(var0, 0, var8, 0, var0.length);
            zzcmc var6 = new zzcmc();
            var6.a = var1;
            if (var2 instanceof Long) {
               var6.c = (Long)var2;
            } else if (var2 instanceof String) {
               var6.b = (String)var2;
            } else if (var2 instanceof Double) {
               var6.d = (Double)var2;
            }

            var8[var0.length] = var6;
            var7 = var8;
            break;
         }

         zzcmc var5 = var0[var3];
         if (Objects.equals(var5.a, var1)) {
            var5.c = null;
            var5.b = null;
            var5.d = null;
            if (var2 instanceof Long) {
               var5.c = (Long)var2;
               var7 = var0;
            } else if (var2 instanceof String) {
               var5.b = (String)var2;
               var7 = var0;
            } else {
               var7 = var0;
               if (var2 instanceof Double) {
                  var5.d = (Double)var2;
                  var7 = var0;
               }
            }
            break;
         }

         var3++;
      }

      return var7;
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   // $VF: Could not verify finally blocks. A semaphore variable has been added to preserve control flow.
   // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
   public static Object b(Object var0) {
      Object var3 = null;
      if (var0 == null) {
         var0 = var3;
      } else {
         boolean var38 = false /* VF: Semaphore variable */;

         ObjectInputStream var1;
         ObjectOutputStream var2;
         label151: {
            label152: {
               ByteArrayOutputStream var4;
               try {
                  var38 = true;
                  var4 = new ByteArrayOutputStream();
                  var2 = new ObjectOutputStream(var4);
                  var38 = false;
               } finally {
                  if (var38) {
                     var1 = null;
                     var2 = null;
                     break label152;
                  }
               }

               try {
                  var2.writeObject(var0);
                  var2.flush();
                  var0 = new ByteArrayInputStream(var4.toByteArray());
                  var1 = new ObjectInputStream((InputStream)var0);
               } finally {
                  ;
               }

               label140:
               try {
                  var0 = var1.readObject();
                  break label151;
               } finally {
                  break label140;
               }
            }

            if (var2 != null) {
               try {
                  var2.close();
               } catch (IOException var46) {
                  var0 = var3;
                  return var0;
               } catch (ClassNotFoundException var47) {
                  var0 = var3;
                  return var0;
               }
            }

            if (var1 != null) {
               try {
                  var1.close();
               } catch (IOException var44) {
                  var0 = var3;
                  return var0;
               } catch (ClassNotFoundException var45) {
                  var0 = var3;
                  return var0;
               }
            }

            try {
               throw var0;
            } catch (IOException var39) {
               var0 = var3;
               return var0;
            } catch (ClassNotFoundException var40) {
               var0 = var3;
               return var0;
            }
         }

         try {
            var2.close();
            var1.close();
         } catch (IOException var41) {
            var0 = var3;
         } catch (ClassNotFoundException var42) {
            var0 = var3;
         }
      }

      return var0;
   }

   private final boolean b(String var1, String var2) {
      boolean var6 = false;
      if (var2 == null) {
         this.t().y().a("Name is required and can't be null. Type", var1);
      } else if (var2.length() == 0) {
         this.t().y().a("Name is required and can't be empty. Type", var1);
      } else {
         int var3 = var2.codePointAt(0);
         if (!Character.isLetter(var3)) {
            this.t().y().a("Name must start with a letter. Type, name", var1, var2);
         } else {
            int var4 = var2.length();
            var3 = Character.charCount(var3);

            while (true) {
               if (var3 >= var4) {
                  var6 = true;
                  break;
               }

               int var5 = var2.codePointAt(var3);
               if (var5 != 95 && !Character.isLetterOrDigit(var5)) {
                  this.t().y().a("Name must consist of letters, digits or _ (underscores). Type, name", var1, var2);
                  break;
               }

               var3 += Character.charCount(var5);
            }
         }
      }

      return var6;
   }

   static long c(byte[] var0) {
      byte var1 = 0;
      zzbq.a(var0);
      boolean var5;
      if (var0.length > 0) {
         var5 = true;
      } else {
         var5 = false;
      }

      zzbq.a(var5);
      long var3 = 0L;

      for (int var2 = var0.length - 1; var2 >= 0 && var2 >= var0.length - 8; var2--) {
         var3 += (var0[var2] & 255L) << var1;
         var1 += 8;
      }

      return var3;
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   private final boolean c(Context var1, String var2) {
      X500Principal var4 = new X500Principal("CN=Android Debug,O=Android,C=US");

      try {
         var10 = zzbhf.a(var1).b(var2, 64);
      } catch (CertificateException var8) {
         this.t().y().a("Error obtaining certificate", var8);
         return true;
      } catch (NameNotFoundException var9) {
         this.t().y().a("Package name not found", var9);
         return true;
      }

      if (var10 != null) {
         try {
            if (var10.signatures != null && var10.signatures.length > 0) {
               Signature var11 = var10.signatures[0];
               CertificateFactory var12 = CertificateFactory.getInstance("X.509");
               ByteArrayInputStream var5 = new ByteArrayInputStream(var11.toByteArray());
               return ((X509Certificate)var12.generateCertificate(var5)).getSubjectX500Principal().equals(var4);
            }
         } catch (CertificateException var6) {
            this.t().y().a("Error obtaining certificate", var6);
         } catch (NameNotFoundException var7) {
            this.t().y().a("Package name not found", var7);
         }
      }

      return true;
   }

   private final boolean c(String var1, String var2) {
      boolean var6 = false;
      if (var2 == null) {
         this.t().y().a("Name is required and can't be null. Type", var1);
      } else if (var2.length() == 0) {
         this.t().y().a("Name is required and can't be empty. Type", var1);
      } else {
         int var3 = var2.codePointAt(0);
         if (!Character.isLetter(var3) && var3 != 95) {
            this.t().y().a("Name must start with a letter or _ (underscore). Type, name", var1, var2);
         } else {
            int var4 = var2.length();
            var3 = Character.charCount(var3);

            while (true) {
               if (var3 >= var4) {
                  var6 = true;
                  break;
               }

               int var5 = var2.codePointAt(var3);
               if (var5 != 95 && !Character.isLetterOrDigit(var5)) {
                  this.t().y().a("Name must consist of letters, digits or _ (underscores). Type, name", var1, var2);
                  break;
               }

               var3 += Character.charCount(var5);
            }
         }
      }

      return var6;
   }

   static MessageDigest g(String var0) {
      int var1 = 0;

      MessageDigest var2;
      while (true) {
         if (var1 >= 2) {
            var2 = null;
            break;
         }

         label18: {
            try {
               var2 = MessageDigest.getInstance(var0);
            } catch (NoSuchAlgorithmException var3) {
               break label18;
            }

            if (var2 != null) {
               break;
            }
         }

         var1++;
      }

      return var2;
   }

   public static boolean i(String var0) {
      boolean var1;
      if (!TextUtils.isEmpty(var0) && var0.startsWith("_")) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   static boolean k(String var0) {
      boolean var1;
      if (var0 != null && var0.matches("(\\+|-)?([0-9]+\\.?[0-9]*|[0-9]*\\.?[0-9]+)") && var0.length() <= 310) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   static boolean n(String var0) {
      boolean var2 = true;
      zzbq.a(var0);
      switch (var0) {
         default:
            var2 = false;
         case "_in":
         case "_ui":
         case "_ug":
            return var2;
      }
   }

   private final int o(String var1) {
      byte var2 = 3;
      if (this.b("event param", var1)) {
         if (!this.a("event param", null, var1)) {
            var2 = 14;
         } else if (this.a("event param", 40, var1)) {
            var2 = 0;
         }
      }

      return var2;
   }

   private final int p(String var1) {
      byte var2 = 3;
      if (this.c("event param", var1)) {
         if (!this.a("event param", null, var1)) {
            var2 = 14;
         } else if (this.a("event param", 40, var1)) {
            var2 = 0;
         }
      }

      return var2;
   }

   private static int q(String var0) {
      short var1;
      if ("_ldl".equals(var0)) {
         var1 = 2048;
      } else {
         var1 = 36;
      }

      return var1;
   }

   public final Bundle a(Uri var1) {
      Bundle var6 = null;
      if (var1 != null) {
         String var2;
         String var3;
         String var4;
         String var5;
         label63: {
            try {
               if (var1.isHierarchical()) {
                  var5 = var1.getQueryParameter("utm_campaign");
                  var2 = var1.getQueryParameter("utm_source");
                  var3 = var1.getQueryParameter("utm_medium");
                  var4 = var1.getQueryParameter("gclid");
                  break label63;
               }
            } catch (UnsupportedOperationException var8) {
               this.t().A().a("Install referrer url isn't a hierarchical URI", var8);
               return var6;
            }

            var4 = null;
            var3 = null;
            var2 = null;
            var5 = null;
         }

         if (!TextUtils.isEmpty(var5) || !TextUtils.isEmpty(var2) || !TextUtils.isEmpty(var3) || !TextUtils.isEmpty(var4)) {
            Bundle var7 = new Bundle();
            if (!TextUtils.isEmpty(var5)) {
               var7.putString("campaign", var5);
            }

            if (!TextUtils.isEmpty(var2)) {
               var7.putString("source", var2);
            }

            if (!TextUtils.isEmpty(var3)) {
               var7.putString("medium", var3);
            }

            if (!TextUtils.isEmpty(var4)) {
               var7.putString("gclid", var4);
            }

            var2 = var1.getQueryParameter("utm_term");
            if (!TextUtils.isEmpty(var2)) {
               var7.putString("term", var2);
            }

            var2 = var1.getQueryParameter("utm_content");
            if (!TextUtils.isEmpty(var2)) {
               var7.putString("content", var2);
            }

            var2 = var1.getQueryParameter("aclid");
            if (!TextUtils.isEmpty(var2)) {
               var7.putString("aclid", var2);
            }

            var2 = var1.getQueryParameter("cp1");
            if (!TextUtils.isEmpty(var2)) {
               var7.putString("cp1", var2);
            }

            String var9 = var1.getQueryParameter("anid");
            var6 = var7;
            if (!TextUtils.isEmpty(var9)) {
               var7.putString("anid", var9);
               var6 = var7;
            }
         }
      }

      return var6;
   }

   final Bundle a(Bundle var1) {
      Bundle var3 = new Bundle();
      if (var1 != null) {
         for (String var2 : var1.keySet()) {
            Object var4 = this.a(var2, var1.get(var2));
            if (var4 == null) {
               this.t().A().a("Param value can't be null", this.o().b(var2));
            } else {
               this.a(var3, var2, var4);
            }
         }
      }

      return var3;
   }

   public final Bundle a(String var1, Bundle var2, List<String> var3, boolean var4, boolean var5) {
      Bundle var9 = null;
      if (var2 != null) {
         var9 = new Bundle(var2);
         Iterator var11 = var2.keySet().iterator();
         int var6 = 0;

         while (var11.hasNext()) {
            String var10 = (String)var11.next();
            int var7 = 0;
            int var8 = 0;
            if (var3 == null || !var3.contains(var10)) {
               if (var4) {
                  var8 = this.o(var10);
               }

               var7 = var8;
               if (var8 == 0) {
                  var7 = this.p(var10);
               }
            }

            if (var7 != 0) {
               if (a(var9, var7)) {
                  var9.putString("_ev", a(var10, 40, true));
                  if (var7 == 3) {
                     a(var9, var10);
                  }
               }

               var9.remove(var10);
            } else {
               var7 = this.a(var10, var2.get(var10), var5);
               if (var7 != 0 && !"_ev".equals(var10)) {
                  if (a(var9, var7)) {
                     var9.putString("_ev", a(var10, 40, true));
                     a(var9, var2.get(var10));
                  }

                  var9.remove(var10);
               } else {
                  var7 = var6;
                  if (a(var10)) {
                     var7 = ++var6;
                     if (var6 > 25) {
                        String var12 = new StringBuilder(48).append("Event can't contain more then 25 params").toString();
                        this.t().y().a(var12, this.o().a(var1), this.o().a(var2));
                        a(var9, 5);
                        var9.remove(var10);
                        continue;
                     }
                  }

                  var6 = var7;
               }
            }
         }
      }

      return var9;
   }

   final <T extends Parcelable> T a(byte[] var1, Creator<T> var2) {
      Object var8;
      if (var1 == null) {
         var8 = null;
      } else {
         Parcel var3 = Parcel.obtain();

         try {
            var3.unmarshall(var1, 0, var1.length);
            var3.setDataPosition(0);
            var8 = (Parcelable)var2.createFromParcel(var3);
            return (T)var8;
         } catch (zzbfo var6) {
            this.t().y().a("Failed to load parcelable from buffer");
         } finally {
            var3.recycle();
         }

         var8 = null;
      }

      return (T)var8;
   }

   final zzcha a(String var1, Bundle var2, String var3, long var4, boolean var6, boolean var7) {
      zzcha var8;
      if (TextUtils.isEmpty(var1)) {
         var8 = null;
      } else {
         if (this.c(var1) != 0) {
            this.t().y().a("Invalid conditional property event name", this.o().c(var1));
            throw new IllegalArgumentException();
         }

         if (var2 != null) {
            var2 = new Bundle(var2);
         } else {
            var2 = new Bundle();
         }

         var2.putString("_o", var3);
         var8 = new zzcha(var1, new zzcgx(this.a(this.a(var1, var2, Collections.singletonList("_o"), false, false))), var3, var4);
      }

      return var8;
   }

   public final Object a(String var1, Object var2) {
      short var3 = 256;
      Object var4;
      if ("_ev".equals(var1)) {
         var4 = a(256, var2, true);
      } else {
         if (!i(var1)) {
            var3 = 100;
         }

         var4 = a(var3, var2, false);
      }

      return var4;
   }

   public final void a(int var1, String var2, String var3, int var4) {
      this.a(null, var1, var2, var3, var4);
   }

   public final void a(Bundle var1, String var2, Object var3) {
      if (var1 != null) {
         if (var3 instanceof Long) {
            var1.putLong(var2, (Long)var3);
         } else if (var3 instanceof String) {
            var1.putString(var2, String.valueOf(var3));
         } else if (var3 instanceof Double) {
            var1.putDouble(var2, (Double)var3);
         } else if (var2 != null) {
            String var4;
            if (var3 != null) {
               var4 = var3.getClass().getSimpleName();
            } else {
               var4 = null;
            }

            this.t().B().a("Not putting event parameter. Invalid value type. name, type", this.o().b(var2), var4);
         }
      }
   }

   public final void a(zzcmc var1, Object var2) {
      zzbq.a(var2);
      var1.b = null;
      var1.c = null;
      var1.d = null;
      if (var2 instanceof String) {
         var1.b = (String)var2;
      } else if (var2 instanceof Long) {
         var1.c = (Long)var2;
      } else if (var2 instanceof Double) {
         var1.d = (Double)var2;
      } else {
         this.t().y().a("Ignoring invalid (type) event param value", var2);
      }
   }

   public final void a(zzcmg var1, Object var2) {
      zzbq.a(var2);
      var1.c = null;
      var1.d = null;
      var1.e = null;
      if (var2 instanceof String) {
         var1.c = (String)var2;
      } else if (var2 instanceof Long) {
         var1.d = (Long)var2;
      } else if (var2 instanceof Double) {
         var1.e = (Double)var2;
      } else {
         this.t().y().a("Ignoring invalid (type) user attribute value", var2);
      }
   }

   public final void a(String var1, int var2, String var3, String var4, int var5) {
      Bundle var6 = new Bundle();
      a(var6, var2);
      if (!TextUtils.isEmpty(var3)) {
         var6.putString(var3, var4);
      }

      if (var2 == 6 || var2 == 7 || var2 == 2) {
         var6.putLong("_el", var5);
      }

      this.p.l().a("auto", "_err", var6);
   }

   public final boolean a(long var1, long var3) {
      boolean var6 = true;
      boolean var5 = var6;
      if (var1 != 0L) {
         if (var3 <= 0L) {
            var5 = var6;
         } else {
            var5 = var6;
            if (Math.abs(this.k().a() - var1) <= var3) {
               var5 = false;
            }
         }
      }

      return var5;
   }

   public final byte[] a(zzcmd var1) {
      byte[] var2;
      try {
         var2 = new byte[var1.f()];
         zzfjk var3 = zzfjk.a(var2, 0, var2.length);
         var1.a(var3);
         var3.a();
      } catch (IOException var4) {
         this.t().y().a("Data loss. Failed to serialize batch", var4);
         return null;
      }

      return var2;
   }

   public final byte[] a(byte[] var1) throws IOException {
      try {
         ByteArrayOutputStream var2 = new ByteArrayOutputStream();
         GZIPOutputStream var3 = new GZIPOutputStream(var2);
         var3.write(var1);
         var3.close();
         var2.close();
         return var2.toByteArray();
      } catch (IOException var4) {
         this.t().y().a("Failed to gzip content", var4);
         throw var4;
      }
   }

   public final int b(String var1) {
      byte var2 = 2;
      if (this.b("event", var1)) {
         if (!this.a("event", AppMeasurement.Event.a, var1)) {
            var2 = 13;
         } else if (this.a("event", 40, var1)) {
            var2 = 0;
         }
      }

      return var2;
   }

   public final int b(String var1, Object var2) {
      byte var3 = 0;
      boolean var4;
      if ("_ldl".equals(var1)) {
         var4 = this.a("user property referrer", var1, q(var1), var2, false);
      } else {
         var4 = this.a("user property", var1, q(var1), var2, false);
      }

      if (!var4) {
         var3 = 7;
      }

      return var3;
   }

   final long b(Context var1, String var2) {
      long var3 = -1L;
      this.c();
      zzbq.a(var1);
      zzbq.a(var2);
      PackageManager var6 = var1.getPackageManager();
      MessageDigest var5 = g("MD5");
      if (var5 == null) {
         this.t().y().a("Could not get MD5 instance");
      } else {
         if (var6 != null) {
            try {
               if (!this.c(var1, var2)) {
                  PackageInfo var8 = zzbhf.a(var1).b(this.l().getPackageName(), 64);
                  if (var8.signatures != null && var8.signatures.length > 0) {
                     var3 = c(var5.digest(var8.signatures[0].toByteArray()));
                  } else {
                     this.t().A().a("Could not get signatures");
                  }

                  return var3;
               }
            } catch (NameNotFoundException var7) {
               this.t().y().a("Package name not found", var7);
            }
         }

         var3 = 0L;
      }

      return var3;
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   public final byte[] b(byte[] var1) throws IOException {
      ByteArrayInputStream var3;
      ByteArrayOutputStream var4;
      byte[] var5;
      try {
         var3 = new ByteArrayInputStream(var1);
         var10 = new GZIPInputStream(var3);
         var4 = new ByteArrayOutputStream();
         var5 = new byte[1024];
      } catch (IOException var9) {
         this.t().y().a("Failed to ungzip content", var9);
         throw var9;
      }

      while (true) {
         int var2;
         try {
            var2 = var10.read(var5);
         } catch (IOException var7) {
            this.t().y().a("Failed to ungzip content", var7);
            throw var7;
         }

         if (var2 <= 0) {
            try {
               var10.close();
               var3.close();
               return var4.toByteArray();
            } catch (IOException var6) {
               this.t().y().a("Failed to ungzip content", var6);
               throw var6;
            }
         }

         try {
            var4.write(var5, 0, var2);
         } catch (IOException var8) {
            this.t().y().a("Failed to ungzip content", var8);
            throw var8;
         }
      }
   }

   public final int c(String var1) {
      byte var2 = 2;
      if (this.c("event", var1)) {
         if (!this.a("event", AppMeasurement.Event.a, var1)) {
            var2 = 13;
         } else if (this.a("event", 40, var1)) {
            var2 = 0;
         }
      }

      return var2;
   }

   public final Object c(String var1, Object var2) {
      Object var3;
      if ("_ldl".equals(var1)) {
         var3 = a(q(var1), var2, true);
      } else {
         var3 = a(q(var1), var2, false);
      }

      return var3;
   }

   public final int d(String var1) {
      byte var2 = 6;
      if (this.b("user property", var1)) {
         if (!this.a("user property", AppMeasurement.UserProperty.a, var1)) {
            var2 = 15;
         } else if (this.a("user property", 24, var1)) {
            var2 = 0;
         }
      }

      return var2;
   }

   @Override
   protected final void d_() {
      this.c();
      SecureRandom var5 = new SecureRandom();
      long var3 = var5.nextLong();
      long var1 = var3;
      if (var3 == 0L) {
         var3 = var5.nextLong();
         var1 = var3;
         if (var3 == 0L) {
            this.t().A().a("Utils falling back to Random for random id");
            var1 = var3;
         }
      }

      this.c.set(var1);
   }

   public final int e(String var1) {
      byte var2 = 6;
      if (this.c("user property", var1)) {
         if (!this.a("user property", AppMeasurement.UserProperty.a, var1)) {
            var2 = 15;
         } else if (this.a("user property", 24, var1)) {
            var2 = 0;
         }
      }

      return var2;
   }

   public final boolean f(String var1) {
      boolean var2 = false;
      if (TextUtils.isEmpty(var1)) {
         this.t().y().a("Missing google_app_id. Firebase Analytics disabled. See https://goo.gl/NAOOOI");
      } else {
         zzbq.a((String)var1);
         if (!var1.matches("^1:\\d+:android:[a-f0-9]+$")) {
            this.t().y().a("Invalid google_app_id. Firebase Analytics disabled. See https://goo.gl/NAOOOI. provided id", var1);
         } else {
            var2 = true;
         }
      }

      return var2;
   }

   public final boolean h(String var1) {
      this.c();
      boolean var2;
      if (zzbhf.a(this.l()).a(var1) == 0) {
         var2 = true;
      } else {
         this.t().D().a("Permission not granted", var1);
         var2 = false;
      }

      return var2;
   }

   public final boolean j(String var1) {
      boolean var2;
      if (TextUtils.isEmpty(var1)) {
         var2 = false;
      } else {
         var2 = this.v().A().equals(var1);
      }

      return var2;
   }

   final boolean l(String var1) {
      return "1".equals(this.q().a(var1, "measurement.upload.blacklist_internal"));
   }

   final boolean m(String var1) {
      return "1".equals(this.q().a(var1, "measurement.upload.blacklist_public"));
   }

   @Override
   protected final boolean w() {
      return true;
   }

   public final long y() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.NullPointerException: Cannot read field "id" because the return value of "org.jetbrains.java.decompiler.modules.decompiler.flow.FlattenStatementsHelper.getDirectNode(org.jetbrains.java.decompiler.modules.decompiler.stats.Statement)" is null
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:186)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.processStatement(ExprProcessor.java:119)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.getFinallyInformation(FinallyProcessor.java:136)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.iterateGraph(FinallyProcessor.java:84)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:185)
      //
      // Bytecode:
      // 00: aload 0
      // 01: getfield com/google/android/gms/internal/zzclq.c Ljava/util/concurrent/atomic/AtomicLong;
      // 04: invokevirtual java/util/concurrent/atomic/AtomicLong.get ()J
      // 07: lconst_0
      // 08: lcmp
      // 09: ifne 50
      // 0c: aload 0
      // 0d: getfield com/google/android/gms/internal/zzclq.c Ljava/util/concurrent/atomic/AtomicLong;
      // 10: astore 4
      // 12: aload 4
      // 14: monitorenter
      // 15: new java/util/Random
      // 18: astore 5
      // 1a: aload 5
      // 1c: invokestatic java/lang/System.nanoTime ()J
      // 1f: aload 0
      // 20: invokevirtual com/google/android/gms/internal/zzcjk.k ()Lcom/google/android/gms/common/util/zzd;
      // 23: invokeinterface com/google/android/gms/common/util/zzd.a ()J 1
      // 28: lxor
      // 29: invokespecial java/util/Random.<init> (J)V
      // 2c: aload 5
      // 2e: invokevirtual java/util/Random.nextLong ()J
      // 31: lstore 2
      // 32: aload 0
      // 33: getfield com/google/android/gms/internal/zzclq.d I
      // 36: bipush 1
      // 37: iadd
      // 38: istore 1
      // 39: aload 0
      // 3a: iload 1
      // 3b: putfield com/google/android/gms/internal/zzclq.d I
      // 3e: lload 2
      // 3f: iload 1
      // 40: i2l
      // 41: ladd
      // 42: lstore 2
      // 43: aload 4
      // 45: monitorexit
      // 46: lload 2
      // 47: lreturn
      // 48: astore 5
      // 4a: aload 4
      // 4c: monitorexit
      // 4d: aload 5
      // 4f: athrow
      // 50: aload 0
      // 51: getfield com/google/android/gms/internal/zzclq.c Ljava/util/concurrent/atomic/AtomicLong;
      // 54: astore 4
      // 56: aload 4
      // 58: monitorenter
      // 59: aload 0
      // 5a: getfield com/google/android/gms/internal/zzclq.c Ljava/util/concurrent/atomic/AtomicLong;
      // 5d: ldc2_w -1
      // 60: lconst_1
      // 61: invokevirtual java/util/concurrent/atomic/AtomicLong.compareAndSet (JJ)Z
      // 64: pop
      // 65: aload 0
      // 66: getfield com/google/android/gms/internal/zzclq.c Ljava/util/concurrent/atomic/AtomicLong;
      // 69: invokevirtual java/util/concurrent/atomic/AtomicLong.getAndIncrement ()J
      // 6c: lstore 2
      // 6d: aload 4
      // 6f: monitorexit
      // 70: goto 46
      // 73: astore 5
      // 75: aload 4
      // 77: monitorexit
      // 78: aload 5
      // 7a: athrow
      // try (11 -> 31): 40 null
      // try (36 -> 38): 40 null
      // try (41 -> 43): 40 null
      // try (50 -> 62): 63 null
      // try (64 -> 66): 63 null
   }

   final SecureRandom z() {
      this.c();
      if (this.b == null) {
         this.b = new SecureRandom();
      }

      return this.b;
   }
}
