package com.google.android.gms.internal;

import com.google.android.gms.common.internal.zzbq;
import java.net.URL;
import java.util.Map;

final class zzchu implements Runnable {
   private final URL a;
   private final byte[] b;
   private final zzchs c;
   private final String d;
   private final Map<String, String> e;
   private zzchq f;

   public zzchu(zzchq var1, String var2, URL var3, byte[] var4, Map var5, zzchs var6) {
      this.f = var1;
      super();
      zzbq.a(var2);
      zzbq.a(var3);
      zzbq.a(var6);
      this.a = var3;
      this.b = var4;
      this.c = var6;
      this.d = var2;
      this.e = var5;
   }

   @Override
   public final void run() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 000: bipush 0
      // 001: istore 1
      // 002: bipush 0
      // 003: istore 5
      // 005: bipush 0
      // 006: istore 4
      // 008: aload 0
      // 009: getfield com/google/android/gms/internal/zzchu.f Lcom/google/android/gms/internal/zzchq;
      // 00c: invokevirtual com/google/android/gms/internal/zzcjk.b ()V
      // 00f: aload 0
      // 010: getfield com/google/android/gms/internal/zzchu.a Ljava/net/URL;
      // 013: invokevirtual java/net/URL.openConnection ()Ljava/net/URLConnection;
      // 016: astore 6
      // 018: aload 6
      // 01a: instanceof java/net/HttpURLConnection
      // 01d: ifne 071
      // 020: new java/io/IOException
      // 023: astore 6
      // 025: aload 6
      // 027: ldc "Failed to obtain HTTP connection"
      // 029: invokespecial java/io/IOException.<init> (Ljava/lang/String;)V
      // 02c: aload 6
      // 02e: athrow
      // 02f: astore 8
      // 031: aconst_null
      // 032: astore 9
      // 034: bipush 0
      // 035: istore 1
      // 036: aconst_null
      // 037: astore 6
      // 039: aconst_null
      // 03a: astore 7
      // 03c: aload 6
      // 03e: ifnull 046
      // 041: aload 6
      // 043: invokevirtual java/io/OutputStream.close ()V
      // 046: aload 7
      // 048: ifnull 050
      // 04b: aload 7
      // 04d: invokevirtual java/net/HttpURLConnection.disconnect ()V
      // 050: aload 0
      // 051: getfield com/google/android/gms/internal/zzchu.f Lcom/google/android/gms/internal/zzchq;
      // 054: invokevirtual com/google/android/gms/internal/zzcjk.s ()Lcom/google/android/gms/internal/zzcih;
      // 057: new com/google/android/gms/internal/zzcht
      // 05a: dup
      // 05b: aload 0
      // 05c: getfield com/google/android/gms/internal/zzchu.d Ljava/lang/String;
      // 05f: aload 0
      // 060: getfield com/google/android/gms/internal/zzchu.c Lcom/google/android/gms/internal/zzchs;
      // 063: iload 1
      // 064: aload 8
      // 066: aconst_null
      // 067: aload 9
      // 069: aconst_null
      // 06a: invokespecial com/google/android/gms/internal/zzcht.<init> (Ljava/lang/String;Lcom/google/android/gms/internal/zzchs;ILjava/lang/Throwable;[BLjava/util/Map;Lcom/google/android/gms/internal/zzchr;)V
      // 06d: invokevirtual com/google/android/gms/internal/zzcih.a (Ljava/lang/Runnable;)V
      // 070: return
      // 071: aload 6
      // 073: checkcast java/net/HttpURLConnection
      // 076: astore 6
      // 078: aload 6
      // 07a: bipush 0
      // 07b: invokevirtual java/net/HttpURLConnection.setDefaultUseCaches (Z)V
      // 07e: aload 6
      // 080: ldc 60000
      // 082: invokevirtual java/net/HttpURLConnection.setConnectTimeout (I)V
      // 085: aload 6
      // 087: ldc 61000
      // 089: invokevirtual java/net/HttpURLConnection.setReadTimeout (I)V
      // 08c: aload 6
      // 08e: bipush 0
      // 08f: invokevirtual java/net/HttpURLConnection.setInstanceFollowRedirects (Z)V
      // 092: aload 6
      // 094: bipush 1
      // 095: invokevirtual java/net/HttpURLConnection.setDoInput (Z)V
      // 098: iload 4
      // 09a: istore 3
      // 09b: iload 5
      // 09d: istore 2
      // 09e: aload 0
      // 09f: getfield com/google/android/gms/internal/zzchu.e Ljava/util/Map;
      // 0a2: ifnull 110
      // 0a5: iload 4
      // 0a7: istore 3
      // 0a8: iload 5
      // 0aa: istore 2
      // 0ab: aload 0
      // 0ac: getfield com/google/android/gms/internal/zzchu.e Ljava/util/Map;
      // 0af: invokeinterface java/util/Map.entrySet ()Ljava/util/Set; 1
      // 0b4: invokeinterface java/util/Set.iterator ()Ljava/util/Iterator; 1
      // 0b9: astore 8
      // 0bb: iload 4
      // 0bd: istore 3
      // 0be: iload 5
      // 0c0: istore 2
      // 0c1: aload 8
      // 0c3: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 0c8: ifeq 110
      // 0cb: iload 4
      // 0cd: istore 3
      // 0ce: iload 5
      // 0d0: istore 2
      // 0d1: aload 8
      // 0d3: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 0d8: checkcast java/util/Map$Entry
      // 0db: astore 7
      // 0dd: iload 4
      // 0df: istore 3
      // 0e0: iload 5
      // 0e2: istore 2
      // 0e3: aload 6
      // 0e5: aload 7
      // 0e7: invokeinterface java/util/Map$Entry.getKey ()Ljava/lang/Object; 1
      // 0ec: checkcast java/lang/String
      // 0ef: aload 7
      // 0f1: invokeinterface java/util/Map$Entry.getValue ()Ljava/lang/Object; 1
      // 0f6: checkcast java/lang/String
      // 0f9: invokevirtual java/net/HttpURLConnection.addRequestProperty (Ljava/lang/String;Ljava/lang/String;)V
      // 0fc: goto 0bb
      // 0ff: astore 8
      // 101: aconst_null
      // 102: astore 9
      // 104: iload 3
      // 105: istore 1
      // 106: aload 6
      // 108: astore 7
      // 10a: aconst_null
      // 10b: astore 6
      // 10d: goto 03c
      // 110: iload 4
      // 112: istore 3
      // 113: iload 5
      // 115: istore 2
      // 116: aload 0
      // 117: getfield com/google/android/gms/internal/zzchu.b [B
      // 11a: ifnull 19b
      // 11d: iload 4
      // 11f: istore 3
      // 120: iload 5
      // 122: istore 2
      // 123: aload 0
      // 124: getfield com/google/android/gms/internal/zzchu.f Lcom/google/android/gms/internal/zzchq;
      // 127: invokevirtual com/google/android/gms/internal/zzcjk.p ()Lcom/google/android/gms/internal/zzclq;
      // 12a: aload 0
      // 12b: getfield com/google/android/gms/internal/zzchu.b [B
      // 12e: invokevirtual com/google/android/gms/internal/zzclq.a ([B)[B
      // 131: astore 8
      // 133: iload 4
      // 135: istore 3
      // 136: iload 5
      // 138: istore 2
      // 139: aload 0
      // 13a: getfield com/google/android/gms/internal/zzchu.f Lcom/google/android/gms/internal/zzchq;
      // 13d: invokevirtual com/google/android/gms/internal/zzcjk.t ()Lcom/google/android/gms/internal/zzchm;
      // 140: invokevirtual com/google/android/gms/internal/zzchm.E ()Lcom/google/android/gms/internal/zzcho;
      // 143: ldc "Uploading data. size"
      // 145: aload 8
      // 147: arraylength
      // 148: invokestatic java/lang/Integer.valueOf (I)Ljava/lang/Integer;
      // 14b: invokevirtual com/google/android/gms/internal/zzcho.a (Ljava/lang/String;Ljava/lang/Object;)V
      // 14e: iload 4
      // 150: istore 3
      // 151: iload 5
      // 153: istore 2
      // 154: aload 6
      // 156: bipush 1
      // 157: invokevirtual java/net/HttpURLConnection.setDoOutput (Z)V
      // 15a: iload 4
      // 15c: istore 3
      // 15d: iload 5
      // 15f: istore 2
      // 160: aload 6
      // 162: ldc "Content-Encoding"
      // 164: ldc "gzip"
      // 166: invokevirtual java/net/HttpURLConnection.addRequestProperty (Ljava/lang/String;Ljava/lang/String;)V
      // 169: iload 4
      // 16b: istore 3
      // 16c: iload 5
      // 16e: istore 2
      // 16f: aload 6
      // 171: aload 8
      // 173: arraylength
      // 174: invokevirtual java/net/HttpURLConnection.setFixedLengthStreamingMode (I)V
      // 177: iload 4
      // 179: istore 3
      // 17a: iload 5
      // 17c: istore 2
      // 17d: aload 6
      // 17f: invokevirtual java/net/HttpURLConnection.connect ()V
      // 182: iload 4
      // 184: istore 3
      // 185: iload 5
      // 187: istore 2
      // 188: aload 6
      // 18a: invokevirtual java/net/HttpURLConnection.getOutputStream ()Ljava/io/OutputStream;
      // 18d: astore 7
      // 18f: aload 7
      // 191: aload 8
      // 193: invokevirtual java/io/OutputStream.write ([B)V
      // 196: aload 7
      // 198: invokevirtual java/io/OutputStream.close ()V
      // 19b: iload 4
      // 19d: istore 3
      // 19e: iload 5
      // 1a0: istore 2
      // 1a1: aload 6
      // 1a3: invokevirtual java/net/HttpURLConnection.getResponseCode ()I
      // 1a6: istore 1
      // 1a7: iload 1
      // 1a8: istore 3
      // 1a9: iload 1
      // 1aa: istore 2
      // 1ab: aload 6
      // 1ad: invokevirtual java/net/HttpURLConnection.getHeaderFields ()Ljava/util/Map;
      // 1b0: astore 7
      // 1b2: aload 0
      // 1b3: getfield com/google/android/gms/internal/zzchu.f Lcom/google/android/gms/internal/zzchq;
      // 1b6: aload 6
      // 1b8: invokestatic com/google/android/gms/internal/zzchq.a (Lcom/google/android/gms/internal/zzchq;Ljava/net/HttpURLConnection;)[B
      // 1bb: astore 8
      // 1bd: aload 6
      // 1bf: ifnull 1c7
      // 1c2: aload 6
      // 1c4: invokevirtual java/net/HttpURLConnection.disconnect ()V
      // 1c7: aload 0
      // 1c8: getfield com/google/android/gms/internal/zzchu.f Lcom/google/android/gms/internal/zzchq;
      // 1cb: invokevirtual com/google/android/gms/internal/zzcjk.s ()Lcom/google/android/gms/internal/zzcih;
      // 1ce: new com/google/android/gms/internal/zzcht
      // 1d1: dup
      // 1d2: aload 0
      // 1d3: getfield com/google/android/gms/internal/zzchu.d Ljava/lang/String;
      // 1d6: aload 0
      // 1d7: getfield com/google/android/gms/internal/zzchu.c Lcom/google/android/gms/internal/zzchs;
      // 1da: iload 1
      // 1db: aconst_null
      // 1dc: aload 8
      // 1de: aload 7
      // 1e0: aconst_null
      // 1e1: invokespecial com/google/android/gms/internal/zzcht.<init> (Ljava/lang/String;Lcom/google/android/gms/internal/zzchs;ILjava/lang/Throwable;[BLjava/util/Map;Lcom/google/android/gms/internal/zzchr;)V
      // 1e4: invokevirtual com/google/android/gms/internal/zzcih.a (Ljava/lang/Runnable;)V
      // 1e7: goto 070
      // 1ea: astore 6
      // 1ec: aload 0
      // 1ed: getfield com/google/android/gms/internal/zzchu.f Lcom/google/android/gms/internal/zzchq;
      // 1f0: invokevirtual com/google/android/gms/internal/zzcjk.t ()Lcom/google/android/gms/internal/zzchm;
      // 1f3: invokevirtual com/google/android/gms/internal/zzchm.y ()Lcom/google/android/gms/internal/zzcho;
      // 1f6: ldc "Error closing HTTP compressed POST connection output stream. appId"
      // 1f8: aload 0
      // 1f9: getfield com/google/android/gms/internal/zzchu.d Ljava/lang/String;
      // 1fc: invokestatic com/google/android/gms/internal/zzchm.a (Ljava/lang/String;)Ljava/lang/Object;
      // 1ff: aload 6
      // 201: invokevirtual com/google/android/gms/internal/zzcho.a (Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
      // 204: goto 046
      // 207: astore 8
      // 209: aconst_null
      // 20a: astore 7
      // 20c: aconst_null
      // 20d: astore 6
      // 20f: aconst_null
      // 210: astore 9
      // 212: aload 6
      // 214: ifnull 21c
      // 217: aload 6
      // 219: invokevirtual java/io/OutputStream.close ()V
      // 21c: aload 9
      // 21e: ifnull 226
      // 221: aload 9
      // 223: invokevirtual java/net/HttpURLConnection.disconnect ()V
      // 226: aload 0
      // 227: getfield com/google/android/gms/internal/zzchu.f Lcom/google/android/gms/internal/zzchq;
      // 22a: invokevirtual com/google/android/gms/internal/zzcjk.s ()Lcom/google/android/gms/internal/zzcih;
      // 22d: new com/google/android/gms/internal/zzcht
      // 230: dup
      // 231: aload 0
      // 232: getfield com/google/android/gms/internal/zzchu.d Ljava/lang/String;
      // 235: aload 0
      // 236: getfield com/google/android/gms/internal/zzchu.c Lcom/google/android/gms/internal/zzchs;
      // 239: iload 1
      // 23a: aconst_null
      // 23b: aconst_null
      // 23c: aload 7
      // 23e: aconst_null
      // 23f: invokespecial com/google/android/gms/internal/zzcht.<init> (Ljava/lang/String;Lcom/google/android/gms/internal/zzchs;ILjava/lang/Throwable;[BLjava/util/Map;Lcom/google/android/gms/internal/zzchr;)V
      // 242: invokevirtual com/google/android/gms/internal/zzcih.a (Ljava/lang/Runnable;)V
      // 245: aload 8
      // 247: athrow
      // 248: astore 6
      // 24a: aload 0
      // 24b: getfield com/google/android/gms/internal/zzchu.f Lcom/google/android/gms/internal/zzchq;
      // 24e: invokevirtual com/google/android/gms/internal/zzcjk.t ()Lcom/google/android/gms/internal/zzchm;
      // 251: invokevirtual com/google/android/gms/internal/zzchm.y ()Lcom/google/android/gms/internal/zzcho;
      // 254: ldc "Error closing HTTP compressed POST connection output stream. appId"
      // 256: aload 0
      // 257: getfield com/google/android/gms/internal/zzchu.d Ljava/lang/String;
      // 25a: invokestatic com/google/android/gms/internal/zzchm.a (Ljava/lang/String;)Ljava/lang/Object;
      // 25d: aload 6
      // 25f: invokevirtual com/google/android/gms/internal/zzcho.a (Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
      // 262: goto 21c
      // 265: astore 8
      // 267: aconst_null
      // 268: astore 7
      // 26a: aconst_null
      // 26b: astore 10
      // 26d: aload 6
      // 26f: astore 9
      // 271: aload 10
      // 273: astore 6
      // 275: iload 2
      // 276: istore 1
      // 277: goto 212
      // 27a: astore 8
      // 27c: aconst_null
      // 27d: astore 10
      // 27f: aload 6
      // 281: astore 9
      // 283: aload 7
      // 285: astore 6
      // 287: aload 10
      // 289: astore 7
      // 28b: goto 212
      // 28e: astore 8
      // 290: aconst_null
      // 291: astore 10
      // 293: aload 6
      // 295: astore 9
      // 297: aload 10
      // 299: astore 6
      // 29b: goto 212
      // 29e: astore 8
      // 2a0: aconst_null
      // 2a1: astore 10
      // 2a3: bipush 0
      // 2a4: istore 1
      // 2a5: aload 6
      // 2a7: astore 9
      // 2a9: aload 7
      // 2ab: astore 6
      // 2ad: aload 9
      // 2af: astore 7
      // 2b1: aload 10
      // 2b3: astore 9
      // 2b5: goto 03c
      // 2b8: astore 8
      // 2ba: aload 7
      // 2bc: astore 9
      // 2be: aload 6
      // 2c0: astore 7
      // 2c2: aconst_null
      // 2c3: astore 6
      // 2c5: goto 03c
      // try (9 -> 23): 23 java/io/IOException
      // try (9 -> 23): 253 null
      // try (34 -> 36): 241 java/io/IOException
      // try (57 -> 75): 23 java/io/IOException
      // try (57 -> 75): 253 null
      // try (79 -> 82): 119 java/io/IOException
      // try (79 -> 82): 298 null
      // try (86 -> 91): 119 java/io/IOException
      // try (86 -> 91): 298 null
      // try (95 -> 98): 119 java/io/IOException
      // try (95 -> 98): 298 null
      // try (102 -> 106): 119 java/io/IOException
      // try (102 -> 106): 298 null
      // try (110 -> 118): 119 java/io/IOException
      // try (110 -> 118): 298 null
      // try (133 -> 136): 119 java/io/IOException
      // try (133 -> 136): 298 null
      // try (140 -> 147): 119 java/io/IOException
      // try (140 -> 147): 298 null
      // try (151 -> 160): 119 java/io/IOException
      // try (151 -> 160): 298 null
      // try (164 -> 167): 119 java/io/IOException
      // try (164 -> 167): 298 null
      // try (171 -> 175): 119 java/io/IOException
      // try (171 -> 175): 298 null
      // try (179 -> 183): 119 java/io/IOException
      // try (179 -> 183): 298 null
      // try (187 -> 189): 119 java/io/IOException
      // try (187 -> 189): 298 null
      // try (193 -> 196): 119 java/io/IOException
      // try (193 -> 196): 298 null
      // try (196 -> 201): 328 java/io/IOException
      // try (196 -> 201): 310 null
      // try (205 -> 208): 119 java/io/IOException
      // try (205 -> 208): 298 null
      // try (212 -> 215): 119 java/io/IOException
      // try (212 -> 215): 298 null
      // try (215 -> 220): 342 java/io/IOException
      // try (215 -> 220): 320 null
      // try (262 -> 264): 286 java/io/IOException
   }
}
