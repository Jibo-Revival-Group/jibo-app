package com.mixpanel.android.util;

import android.content.Context;
import android.net.ConnectivityManager;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.util.Map;
import javax.net.ssl.SSLSocketFactory;

public class HttpService implements RemoteService {
   private static boolean a;

   private boolean a(OfflineMode var1) {
      boolean var3 = false;
      boolean var2 = var3;
      if (var1 != null) {
         boolean var4;
         try {
            var4 = var1.a();
         } catch (Exception var5) {
            MPLog.a("MixpanelAPI.Message", "Client State should not throw exception, will assume is not on offline mode", var5);
            var2 = var3;
            return var2;
         }

         var2 = var3;
         if (var4) {
            var2 = true;
         }
      }

      return var2;
   }

   private static byte[] a(InputStream var0) throws IOException {
      ByteArrayOutputStream var3 = new ByteArrayOutputStream();
      byte[] var2 = new byte[8192];

      while (true) {
         int var1 = var0.read(var2, 0, var2.length);
         if (var1 == -1) {
            var3.flush();
            return var3.toByteArray();
         }

         var3.write(var2, 0, var1);
      }
   }

   @Override
   public void a() {
      new Thread(new Runnable(this) {
         final HttpService a;

         {
            this.a = var1;
         }

         // $VF: Duplicated exception handlers to handle obfuscated exceptions
         @Override
         public void run() {
            boolean var1;
            label32: {
               label31: {
                  try {
                     InetAddress var2 = InetAddress.getByName("api.mixpanel.com");
                     InetAddress var3 = InetAddress.getByName("decide.mixpanel.com");
                     if (var2.isLoopbackAddress() || var2.isAnyLocalAddress() || var3.isLoopbackAddress() || var3.isAnyLocalAddress()) {
                        break label31;
                     }
                  } catch (Exception var5) {
                     return;
                  }

                  var1 = false;
                  break label32;
               }

               var1 = true;
            }

            try {
               HttpService.a = var1;
               if (HttpService.a) {
                  MPLog.a("MixpanelAPI.Message", "AdBlocker is enabled. Won't be able to use Mixpanel services.");
               }
            } catch (Exception var4) {
            }
         }
      }).start();
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   @Override
   public boolean a(Context var1, OfflineMode var2) {
      boolean var3 = false;
      if (!a && !this.a(var2)) {
         try {
            var8 = ((ConnectivityManager)var1.getSystemService("connectivity")).getActiveNetworkInfo();
         } catch (SecurityException var7) {
            MPLog.a("MixpanelAPI.Message", "Don't have permission to check connectivity, will assume we are online");
            var3 = true;
            return var3;
         }

         if (var8 == null) {
            try {
               MPLog.a("MixpanelAPI.Message", "A default network has not been set so we cannot be certain whether we are offline");
            } catch (SecurityException var6) {
               MPLog.a("MixpanelAPI.Message", "Don't have permission to check connectivity, will assume we are online");
               var3 = true;
               return var3;
            }

            var3 = true;
         } else {
            try {
               var3 = var8.isConnectedOrConnecting();
               StringBuilder var9 = new StringBuilder();
               var11 = var9.append("ConnectivityManager says we ");
            } catch (SecurityException var5) {
               MPLog.a("MixpanelAPI.Message", "Don't have permission to check connectivity, will assume we are online");
               var3 = true;
               return var3;
            }

            String var10;
            if (var3) {
               var10 = "are";
            } else {
               var10 = "are not";
            }

            try {
               MPLog.a("MixpanelAPI.Message", var11.append(var10).append(" online").toString());
            } catch (SecurityException var4) {
               MPLog.a("MixpanelAPI.Message", "Don't have permission to check connectivity, will assume we are online");
               var3 = true;
            }
         }
      }

      return var3;
   }

   @Override
   public byte[] a(String param1, Map<String, Object> param2, SSLSocketFactory param3) throws RemoteService.ServiceUnavailableException, IOException {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 000: ldc "MixpanelAPI.Message"
      // 002: new java/lang/StringBuilder
      // 005: dup
      // 006: invokespecial java/lang/StringBuilder.<init> ()V
      // 009: ldc "Attempting request to "
      // 00b: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 00e: aload 1
      // 00f: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 012: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 015: invokestatic com/mixpanel/android/util/MPLog.a (Ljava/lang/String;Ljava/lang/String;)V
      // 018: aconst_null
      // 019: astore 8
      // 01b: bipush 0
      // 01c: istore 5
      // 01e: bipush 0
      // 01f: istore 4
      // 021: iload 5
      // 023: bipush 3
      // 024: if_icmpge 2d1
      // 027: iload 4
      // 029: ifne 2d1
      // 02c: aconst_null
      // 02d: astore 13
      // 02f: aconst_null
      // 030: astore 22
      // 032: aconst_null
      // 033: astore 14
      // 035: aconst_null
      // 036: astore 12
      // 038: aconst_null
      // 039: astore 20
      // 03b: aconst_null
      // 03c: astore 23
      // 03e: aconst_null
      // 03f: astore 18
      // 041: aconst_null
      // 042: astore 15
      // 044: aconst_null
      // 045: astore 6
      // 047: aconst_null
      // 048: astore 17
      // 04a: aconst_null
      // 04b: astore 16
      // 04d: aconst_null
      // 04e: astore 21
      // 050: aconst_null
      // 051: astore 19
      // 053: aload 21
      // 055: astore 7
      // 057: aload 6
      // 059: astore 9
      // 05b: aload 23
      // 05d: astore 11
      // 05f: aload 22
      // 061: astore 10
      // 063: new java/net/URL
      // 066: astore 24
      // 068: aload 21
      // 06a: astore 7
      // 06c: aload 6
      // 06e: astore 9
      // 070: aload 23
      // 072: astore 11
      // 074: aload 22
      // 076: astore 10
      // 078: aload 24
      // 07a: aload 1
      // 07b: invokespecial java/net/URL.<init> (Ljava/lang/String;)V
      // 07e: aload 21
      // 080: astore 7
      // 082: aload 6
      // 084: astore 9
      // 086: aload 23
      // 088: astore 11
      // 08a: aload 22
      // 08c: astore 10
      // 08e: aload 24
      // 090: invokevirtual java/net/URL.openConnection ()Ljava/net/URLConnection;
      // 093: invokestatic com/google/firebase/perf/network/FirebasePerfUrlConnection.instrument (Ljava/lang/Object;)Ljava/lang/Object;
      // 096: checkcast java/net/URLConnection
      // 099: checkcast java/net/HttpURLConnection
      // 09c: astore 6
      // 09e: aload 3
      // 09f: ifnull 0b3
      // 0a2: aload 6
      // 0a4: instanceof javax/net/ssl/HttpsURLConnection
      // 0a7: ifeq 0b3
      // 0aa: aload 6
      // 0ac: checkcast javax/net/ssl/HttpsURLConnection
      // 0af: aload 3
      // 0b0: invokevirtual javax/net/ssl/HttpsURLConnection.setSSLSocketFactory (Ljavax/net/ssl/SSLSocketFactory;)V
      // 0b3: aload 6
      // 0b5: sipush 2000
      // 0b8: invokevirtual java/net/HttpURLConnection.setConnectTimeout (I)V
      // 0bb: aload 6
      // 0bd: sipush 10000
      // 0c0: invokevirtual java/net/HttpURLConnection.setReadTimeout (I)V
      // 0c3: aload 2
      // 0c4: ifnull 1b2
      // 0c7: new android/net/Uri$Builder
      // 0ca: astore 9
      // 0cc: aload 9
      // 0ce: invokespecial android/net/Uri$Builder.<init> ()V
      // 0d1: aload 2
      // 0d2: invokeinterface java/util/Map.entrySet ()Ljava/util/Set; 1
      // 0d7: invokeinterface java/util/Set.iterator ()Ljava/util/Iterator; 1
      // 0dc: astore 10
      // 0de: aload 10
      // 0e0: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 0e5: ifeq 162
      // 0e8: aload 10
      // 0ea: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 0ef: checkcast java/util/Map$Entry
      // 0f2: astore 7
      // 0f4: aload 9
      // 0f6: aload 7
      // 0f8: invokeinterface java/util/Map$Entry.getKey ()Ljava/lang/Object; 1
      // 0fd: checkcast java/lang/String
      // 100: aload 7
      // 102: invokeinterface java/util/Map$Entry.getValue ()Ljava/lang/Object; 1
      // 107: invokevirtual java/lang/Object.toString ()Ljava/lang/String;
      // 10a: invokevirtual android/net/Uri$Builder.appendQueryParameter (Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;
      // 10d: pop
      // 10e: goto 0de
      // 111: aconst_null
      // 112: astore 11
      // 114: aconst_null
      // 115: astore 9
      // 117: astore 7
      // 119: aload 6
      // 11b: astore 7
      // 11d: aload 8
      // 11f: astore 6
      // 121: aload 12
      // 123: astore 10
      // 125: aload 11
      // 127: astore 8
      // 129: ldc "MixpanelAPI.Message"
      // 12b: ldc "Failure to connect, likely caused by a known issue with Android lib. Retrying."
      // 12d: invokestatic com/mixpanel/android/util/MPLog.b (Ljava/lang/String;Ljava/lang/String;)V
      // 130: iinc 5 1
      // 133: aload 9
      // 135: ifnull 13d
      // 138: aload 9
      // 13a: invokevirtual java/io/BufferedOutputStream.close ()V
      // 13d: aload 8
      // 13f: ifnull 147
      // 142: aload 8
      // 144: invokevirtual java/io/OutputStream.close ()V
      // 147: aload 10
      // 149: ifnull 151
      // 14c: aload 10
      // 14e: invokevirtual java/io/InputStream.close ()V
      // 151: aload 7
      // 153: ifnull 46c
      // 156: aload 7
      // 158: invokevirtual java/net/HttpURLConnection.disconnect ()V
      // 15b: aload 6
      // 15d: astore 8
      // 15f: goto 021
      // 162: aload 9
      // 164: invokevirtual android/net/Uri$Builder.build ()Landroid/net/Uri;
      // 167: invokevirtual android/net/Uri.getEncodedQuery ()Ljava/lang/String;
      // 16a: astore 10
      // 16c: aload 6
      // 16e: aload 10
      // 170: invokevirtual java/lang/String.getBytes ()[B
      // 173: arraylength
      // 174: invokevirtual java/net/HttpURLConnection.setFixedLengthStreamingMode (I)V
      // 177: aload 6
      // 179: bipush 1
      // 17a: invokevirtual java/net/HttpURLConnection.setDoOutput (Z)V
      // 17d: aload 6
      // 17f: ldc "POST"
      // 181: invokevirtual java/net/HttpURLConnection.setRequestMethod (Ljava/lang/String;)V
      // 184: aload 6
      // 186: invokevirtual java/net/HttpURLConnection.getOutputStream ()Ljava/io/OutputStream;
      // 189: astore 7
      // 18b: new java/io/BufferedOutputStream
      // 18e: astore 9
      // 190: aload 9
      // 192: aload 7
      // 194: invokespecial java/io/BufferedOutputStream.<init> (Ljava/io/OutputStream;)V
      // 197: aload 9
      // 199: aload 10
      // 19b: ldc "UTF-8"
      // 19d: invokevirtual java/lang/String.getBytes (Ljava/lang/String;)[B
      // 1a0: invokevirtual java/io/BufferedOutputStream.write ([B)V
      // 1a3: aload 9
      // 1a5: invokevirtual java/io/BufferedOutputStream.flush ()V
      // 1a8: aload 9
      // 1aa: invokevirtual java/io/BufferedOutputStream.close ()V
      // 1ad: aload 7
      // 1af: invokevirtual java/io/OutputStream.close ()V
      // 1b2: aconst_null
      // 1b3: astore 9
      // 1b5: aconst_null
      // 1b6: astore 10
      // 1b8: aconst_null
      // 1b9: astore 11
      // 1bb: aconst_null
      // 1bc: astore 16
      // 1be: aconst_null
      // 1bf: astore 17
      // 1c1: aconst_null
      // 1c2: astore 15
      // 1c4: aload 6
      // 1c6: invokevirtual java/net/HttpURLConnection.getInputStream ()Ljava/io/InputStream;
      // 1c9: astore 7
      // 1cb: aload 7
      // 1cd: invokestatic com/mixpanel/android/util/HttpService.a (Ljava/io/InputStream;)[B
      // 1d0: astore 12
      // 1d2: aload 12
      // 1d4: astore 8
      // 1d6: aload 7
      // 1d8: invokevirtual java/io/InputStream.close ()V
      // 1db: bipush 0
      // 1dc: ifeq 1e7
      // 1df: new java/lang/NullPointerException
      // 1e2: dup
      // 1e3: invokespecial java/lang/NullPointerException.<init> ()V
      // 1e6: athrow
      // 1e7: bipush 0
      // 1e8: ifeq 1f3
      // 1eb: new java/lang/NullPointerException
      // 1ee: dup
      // 1ef: invokespecial java/lang/NullPointerException.<init> ()V
      // 1f2: athrow
      // 1f3: bipush 0
      // 1f4: ifeq 1ff
      // 1f7: new java/lang/NullPointerException
      // 1fa: dup
      // 1fb: invokespecial java/lang/NullPointerException.<init> ()V
      // 1fe: athrow
      // 1ff: aload 6
      // 201: ifnull 46f
      // 204: aload 6
      // 206: invokevirtual java/net/HttpURLConnection.disconnect ()V
      // 209: bipush 1
      // 20a: istore 4
      // 20c: aload 8
      // 20e: astore 6
      // 210: goto 15b
      // 213: astore 3
      // 214: aload 13
      // 216: astore 8
      // 218: aload 20
      // 21a: astore 2
      // 21b: aload 15
      // 21d: astore 6
      // 21f: aload 19
      // 221: astore 1
      // 222: aload 1
      // 223: astore 7
      // 225: aload 6
      // 227: astore 9
      // 229: aload 2
      // 22a: astore 11
      // 22c: aload 8
      // 22e: astore 10
      // 230: aload 1
      // 231: invokevirtual java/net/HttpURLConnection.getResponseCode ()I
      // 234: sipush 500
      // 237: if_icmplt 2c1
      // 23a: aload 1
      // 23b: astore 7
      // 23d: aload 6
      // 23f: astore 9
      // 241: aload 2
      // 242: astore 11
      // 244: aload 8
      // 246: astore 10
      // 248: aload 1
      // 249: invokevirtual java/net/HttpURLConnection.getResponseCode ()I
      // 24c: sipush 599
      // 24f: if_icmpgt 2c1
      // 252: aload 1
      // 253: astore 7
      // 255: aload 6
      // 257: astore 9
      // 259: aload 2
      // 25a: astore 11
      // 25c: aload 8
      // 25e: astore 10
      // 260: new com/mixpanel/android/util/RemoteService$ServiceUnavailableException
      // 263: astore 3
      // 264: aload 1
      // 265: astore 7
      // 267: aload 6
      // 269: astore 9
      // 26b: aload 2
      // 26c: astore 11
      // 26e: aload 8
      // 270: astore 10
      // 272: aload 3
      // 273: ldc_w "Service Unavailable"
      // 276: aload 1
      // 277: ldc_w "Retry-After"
      // 27a: invokevirtual java/net/HttpURLConnection.getHeaderField (Ljava/lang/String;)Ljava/lang/String;
      // 27d: invokespecial com/mixpanel/android/util/RemoteService$ServiceUnavailableException.<init> (Ljava/lang/String;Ljava/lang/String;)V
      // 280: aload 1
      // 281: astore 7
      // 283: aload 6
      // 285: astore 9
      // 287: aload 2
      // 288: astore 11
      // 28a: aload 8
      // 28c: astore 10
      // 28e: aload 3
      // 28f: athrow
      // 290: astore 1
      // 291: aload 11
      // 293: astore 8
      // 295: aload 9
      // 297: astore 3
      // 298: aload 7
      // 29a: astore 2
      // 29b: aload 3
      // 29c: ifnull 2a3
      // 29f: aload 3
      // 2a0: invokevirtual java/io/BufferedOutputStream.close ()V
      // 2a3: aload 8
      // 2a5: ifnull 2ad
      // 2a8: aload 8
      // 2aa: invokevirtual java/io/OutputStream.close ()V
      // 2ad: aload 10
      // 2af: ifnull 2b7
      // 2b2: aload 10
      // 2b4: invokevirtual java/io/InputStream.close ()V
      // 2b7: aload 2
      // 2b8: ifnull 2bf
      // 2bb: aload 2
      // 2bc: invokevirtual java/net/HttpURLConnection.disconnect ()V
      // 2bf: aload 1
      // 2c0: athrow
      // 2c1: aload 1
      // 2c2: astore 7
      // 2c4: aload 6
      // 2c6: astore 9
      // 2c8: aload 2
      // 2c9: astore 11
      // 2cb: aload 8
      // 2cd: astore 10
      // 2cf: aload 3
      // 2d0: athrow
      // 2d1: iload 5
      // 2d3: bipush 3
      // 2d4: if_icmplt 2df
      // 2d7: ldc "MixpanelAPI.Message"
      // 2d9: ldc_w "Could not connect to Mixpanel service after three retries."
      // 2dc: invokestatic com/mixpanel/android/util/MPLog.a (Ljava/lang/String;Ljava/lang/String;)V
      // 2df: aload 8
      // 2e1: areturn
      // 2e2: astore 7
      // 2e4: goto 1e7
      // 2e7: astore 7
      // 2e9: goto 1f3
      // 2ec: astore 7
      // 2ee: goto 1ff
      // 2f1: astore 9
      // 2f3: goto 13d
      // 2f6: astore 8
      // 2f8: goto 147
      // 2fb: astore 8
      // 2fd: goto 151
      // 300: astore 3
      // 301: goto 2a3
      // 304: astore 3
      // 305: goto 2ad
      // 308: astore 3
      // 309: goto 2b7
      // 30c: astore 1
      // 30d: aload 7
      // 30f: astore 2
      // 310: aload 9
      // 312: astore 3
      // 313: goto 29b
      // 316: aconst_null
      // 317: astore 8
      // 319: aconst_null
      // 31a: astore 3
      // 31b: astore 1
      // 31c: aload 6
      // 31e: astore 2
      // 31f: aload 14
      // 321: astore 10
      // 323: goto 29b
      // 326: astore 1
      // 327: aload 6
      // 329: astore 2
      // 32a: aload 17
      // 32c: astore 3
      // 32d: aload 7
      // 32f: astore 8
      // 331: aload 14
      // 333: astore 10
      // 335: goto 29b
      // 338: astore 1
      // 339: aload 9
      // 33b: astore 3
      // 33c: aload 6
      // 33e: astore 2
      // 33f: aload 7
      // 341: astore 8
      // 343: aload 14
      // 345: astore 10
      // 347: goto 29b
      // 34a: astore 1
      // 34b: aconst_null
      // 34c: astore 3
      // 34d: aload 6
      // 34f: astore 2
      // 350: aload 7
      // 352: astore 8
      // 354: aload 14
      // 356: astore 10
      // 358: goto 29b
      // 35b: astore 1
      // 35c: aload 6
      // 35e: astore 2
      // 35f: aload 17
      // 361: astore 3
      // 362: aload 10
      // 364: astore 8
      // 366: aload 7
      // 368: astore 10
      // 36a: goto 29b
      // 36d: aconst_null
      // 36e: astore 2
      // 36f: aconst_null
      // 370: astore 7
      // 372: astore 3
      // 373: aload 6
      // 375: astore 1
      // 376: aload 7
      // 378: astore 6
      // 37a: aload 13
      // 37c: astore 8
      // 37e: goto 222
      // 381: astore 3
      // 382: aload 7
      // 384: astore 2
      // 385: aload 6
      // 387: astore 1
      // 388: aload 15
      // 38a: astore 6
      // 38c: aload 13
      // 38e: astore 8
      // 390: goto 222
      // 393: astore 3
      // 394: aload 7
      // 396: astore 2
      // 397: aload 6
      // 399: astore 1
      // 39a: aload 9
      // 39c: astore 6
      // 39e: aload 13
      // 3a0: astore 8
      // 3a2: goto 222
      // 3a5: astore 3
      // 3a6: aconst_null
      // 3a7: astore 8
      // 3a9: aload 7
      // 3ab: astore 2
      // 3ac: aload 6
      // 3ae: astore 1
      // 3af: aload 8
      // 3b1: astore 6
      // 3b3: aload 13
      // 3b5: astore 8
      // 3b7: goto 222
      // 3ba: astore 3
      // 3bb: aload 6
      // 3bd: astore 1
      // 3be: aload 16
      // 3c0: astore 6
      // 3c2: aload 9
      // 3c4: astore 2
      // 3c5: aload 7
      // 3c7: astore 8
      // 3c9: goto 222
      // 3cc: astore 6
      // 3ce: aconst_null
      // 3cf: astore 7
      // 3d1: aload 8
      // 3d3: astore 6
      // 3d5: aload 16
      // 3d7: astore 9
      // 3d9: aload 18
      // 3db: astore 8
      // 3dd: aload 12
      // 3df: astore 10
      // 3e1: goto 129
      // 3e4: astore 9
      // 3e6: aload 7
      // 3e8: astore 10
      // 3ea: aload 6
      // 3ec: astore 7
      // 3ee: aload 8
      // 3f0: astore 6
      // 3f2: aload 16
      // 3f4: astore 9
      // 3f6: aload 10
      // 3f8: astore 8
      // 3fa: aload 12
      // 3fc: astore 10
      // 3fe: goto 129
      // 401: astore 10
      // 403: aload 7
      // 405: astore 10
      // 407: aload 6
      // 409: astore 7
      // 40b: aload 8
      // 40d: astore 6
      // 40f: aload 10
      // 411: astore 8
      // 413: aload 12
      // 415: astore 10
      // 417: goto 129
      // 41a: astore 9
      // 41c: aconst_null
      // 41d: astore 9
      // 41f: aload 7
      // 421: astore 10
      // 423: aload 6
      // 425: astore 7
      // 427: aload 8
      // 429: astore 6
      // 42b: aload 10
      // 42d: astore 8
      // 42f: aload 12
      // 431: astore 10
      // 433: goto 129
      // 436: astore 9
      // 438: aload 6
      // 43a: astore 9
      // 43c: aload 7
      // 43e: astore 10
      // 440: aload 8
      // 442: astore 6
      // 444: aload 9
      // 446: astore 7
      // 448: aload 15
      // 44a: astore 9
      // 44c: aload 11
      // 44e: astore 8
      // 450: goto 129
      // 453: astore 9
      // 455: aload 7
      // 457: astore 10
      // 459: aload 6
      // 45b: astore 7
      // 45d: aload 8
      // 45f: astore 6
      // 461: aload 15
      // 463: astore 9
      // 465: aload 11
      // 467: astore 8
      // 469: goto 129
      // 46c: goto 15b
      // 46f: bipush 1
      // 470: istore 4
      // 472: aload 8
      // 474: astore 6
      // 476: goto 15b
      // try (55 -> 57): 481 java/io/EOFException
      // try (55 -> 57): 243 java/io/IOException
      // try (55 -> 57): 310 null
      // try (65 -> 68): 481 java/io/EOFException
      // try (65 -> 68): 243 java/io/IOException
      // try (65 -> 68): 310 null
      // try (76 -> 82): 481 java/io/EOFException
      // try (76 -> 82): 243 java/io/IOException
      // try (76 -> 82): 310 null
      // try (84 -> 91): 124 java/io/EOFException
      // try (84 -> 91): 427 java/io/IOException
      // try (84 -> 91): 377 null
      // try (91 -> 97): 124 java/io/EOFException
      // try (91 -> 97): 427 java/io/IOException
      // try (91 -> 97): 377 null
      // try (99 -> 107): 124 java/io/EOFException
      // try (99 -> 107): 427 java/io/IOException
      // try (99 -> 107): 377 null
      // try (107 -> 123): 124 java/io/EOFException
      // try (107 -> 123): 427 java/io/IOException
      // try (107 -> 123): 377 null
      // try (137 -> 140): 371 null
      // try (143 -> 145): 359 java/io/IOException
      // try (147 -> 149): 361 java/io/IOException
      // try (151 -> 153): 363 java/io/IOException
      // try (160 -> 178): 124 java/io/EOFException
      // try (160 -> 178): 427 java/io/IOException
      // try (160 -> 178): 377 null
      // try (178 -> 183): 493 java/io/EOFException
      // try (178 -> 183): 439 java/io/IOException
      // try (178 -> 183): 387 null
      // try (183 -> 192): 507 java/io/EOFException
      // try (183 -> 192): 449 java/io/IOException
      // try (183 -> 192): 397 null
      // try (192 -> 194): 519 java/io/EOFException
      // try (192 -> 194): 459 java/io/IOException
      // try (192 -> 194): 407 null
      // try (206 -> 209): 124 java/io/EOFException
      // try (206 -> 209): 427 java/io/IOException
      // try (206 -> 209): 377 null
      // try (209 -> 212): 533 java/io/EOFException
      // try (209 -> 212): 471 java/io/IOException
      // try (209 -> 212): 417 null
      // try (214 -> 216): 547 java/io/EOFException
      // try (214 -> 216): 471 java/io/IOException
      // try (214 -> 216): 417 null
      // try (218 -> 222): 353 java/io/IOException
      // try (224 -> 228): 355 java/io/IOException
      // try (230 -> 234): 357 java/io/IOException
      // try (260 -> 264): 310 null
      // try (272 -> 276): 310 null
      // try (284 -> 286): 310 null
      // try (294 -> 300): 310 null
      // try (308 -> 310): 310 null
      // try (319 -> 321): 365 java/io/IOException
      // try (323 -> 325): 367 java/io/IOException
      // try (327 -> 329): 369 java/io/IOException
      // try (343 -> 345): 310 null
   }
}
