package com.google.android.gms.ads.identifier;

import java.util.Map;

final class zza extends Thread {
   private Map a;

   zza(AdvertisingIdClient var1, Map var2) {
      this.a = var2;
      super();
   }

   @Override
   public final void run() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
      //   at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
      //   at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
      //   at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
      //   at java.base/java.util.Objects.checkIndex(Objects.java:361)
      //   at java.base/java.util.ArrayList.remove(ArrayList.java:504)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.removeExceptionInstructionsEx(FinallyProcessor.java:1058)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.verifyFinallyEx(FinallyProcessor.java:573)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.iterateGraph(FinallyProcessor.java:90)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:185)
      //
      // Bytecode:
      // 000: new com/google/android/gms/ads/identifier/zzc
      // 003: dup
      // 004: invokespecial com/google/android/gms/ads/identifier/zzc.<init> ()V
      // 007: pop
      // 008: aload 0
      // 009: getfield com/google/android/gms/ads/identifier/zza.a Ljava/util/Map;
      // 00c: astore 4
      // 00e: ldc "https://pagead2.googlesyndication.com/pagead/gen_204?id=gmob-apps"
      // 010: invokestatic android/net/Uri.parse (Ljava/lang/String;)Landroid/net/Uri;
      // 013: invokevirtual android/net/Uri.buildUpon ()Landroid/net/Uri$Builder;
      // 016: astore 3
      // 017: aload 4
      // 019: invokeinterface java/util/Map.keySet ()Ljava/util/Set; 1
      // 01e: invokeinterface java/util/Set.iterator ()Ljava/util/Iterator; 1
      // 023: astore 6
      // 025: aload 6
      // 027: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 02c: ifeq 051
      // 02f: aload 6
      // 031: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 036: checkcast java/lang/String
      // 039: astore 5
      // 03b: aload 3
      // 03c: aload 5
      // 03e: aload 4
      // 040: aload 5
      // 042: invokeinterface java/util/Map.get (Ljava/lang/Object;)Ljava/lang/Object; 2
      // 047: checkcast java/lang/String
      // 04a: invokevirtual android/net/Uri$Builder.appendQueryParameter (Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;
      // 04d: pop
      // 04e: goto 025
      // 051: aload 3
      // 052: invokevirtual android/net/Uri$Builder.build ()Landroid/net/Uri;
      // 055: invokevirtual android/net/Uri.toString ()Ljava/lang/String;
      // 058: astore 4
      // 05a: new java/net/URL
      // 05d: astore 3
      // 05e: aload 3
      // 05f: aload 4
      // 061: invokespecial java/net/URL.<init> (Ljava/lang/String;)V
      // 064: aload 3
      // 065: invokevirtual java/net/URL.openConnection ()Ljava/net/URLConnection;
      // 068: checkcast java/net/HttpURLConnection
      // 06b: astore 3
      // 06c: aload 3
      // 06d: invokevirtual java/net/HttpURLConnection.getResponseCode ()I
      // 070: istore 2
      // 071: iload 2
      // 072: sipush 200
      // 075: if_icmplt 07f
      // 078: iload 2
      // 079: sipush 300
      // 07c: if_icmplt 0b4
      // 07f: aload 4
      // 081: invokestatic java/lang/String.valueOf (Ljava/lang/Object;)Ljava/lang/String;
      // 084: invokevirtual java/lang/String.length ()I
      // 087: istore 1
      // 088: new java/lang/StringBuilder
      // 08b: astore 5
      // 08d: aload 5
      // 08f: iload 1
      // 090: bipush 65
      // 092: iadd
      // 093: invokespecial java/lang/StringBuilder.<init> (I)V
      // 096: ldc "HttpUrlPinger"
      // 098: aload 5
      // 09a: ldc "Received non-success response code "
      // 09c: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 09f: iload 2
      // 0a0: invokevirtual java/lang/StringBuilder.append (I)Ljava/lang/StringBuilder;
      // 0a3: ldc " from pinging URL: "
      // 0a5: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 0a8: aload 4
      // 0aa: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 0ad: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 0b0: invokestatic android/util/Log.w (Ljava/lang/String;Ljava/lang/String;)I
      // 0b3: pop
      // 0b4: aload 3
      // 0b5: invokevirtual java/net/HttpURLConnection.disconnect ()V
      // 0b8: return
      // 0b9: astore 5
      // 0bb: aload 3
      // 0bc: invokevirtual java/net/HttpURLConnection.disconnect ()V
      // 0bf: aload 5
      // 0c1: athrow
      // 0c2: astore 5
      // 0c4: aload 5
      // 0c6: invokevirtual java/lang/IndexOutOfBoundsException.getMessage ()Ljava/lang/String;
      // 0c9: astore 3
      // 0ca: ldc "HttpUrlPinger"
      // 0cc: new java/lang/StringBuilder
      // 0cf: dup
      // 0d0: aload 4
      // 0d2: invokestatic java/lang/String.valueOf (Ljava/lang/Object;)Ljava/lang/String;
      // 0d5: invokevirtual java/lang/String.length ()I
      // 0d8: bipush 32
      // 0da: iadd
      // 0db: aload 3
      // 0dc: invokestatic java/lang/String.valueOf (Ljava/lang/Object;)Ljava/lang/String;
      // 0df: invokevirtual java/lang/String.length ()I
      // 0e2: iadd
      // 0e3: invokespecial java/lang/StringBuilder.<init> (I)V
      // 0e6: ldc "Error while parsing ping URL: "
      // 0e8: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 0eb: aload 4
      // 0ed: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 0f0: ldc ". "
      // 0f2: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 0f5: aload 3
      // 0f6: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 0f9: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 0fc: aload 5
      // 0fe: invokestatic android/util/Log.w (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
      // 101: pop
      // 102: goto 0b8
      // 105: astore 3
      // 106: aload 3
      // 107: invokevirtual java/lang/Exception.getMessage ()Ljava/lang/String;
      // 10a: astore 5
      // 10c: ldc "HttpUrlPinger"
      // 10e: new java/lang/StringBuilder
      // 111: dup
      // 112: aload 4
      // 114: invokestatic java/lang/String.valueOf (Ljava/lang/Object;)Ljava/lang/String;
      // 117: invokevirtual java/lang/String.length ()I
      // 11a: bipush 27
      // 11c: iadd
      // 11d: aload 5
      // 11f: invokestatic java/lang/String.valueOf (Ljava/lang/Object;)Ljava/lang/String;
      // 122: invokevirtual java/lang/String.length ()I
      // 125: iadd
      // 126: invokespecial java/lang/StringBuilder.<init> (I)V
      // 129: ldc "Error while pinging URL: "
      // 12b: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 12e: aload 4
      // 130: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 133: ldc ". "
      // 135: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 138: aload 5
      // 13a: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 13d: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 140: aload 3
      // 141: invokestatic android/util/Log.w (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
      // 144: pop
      // 145: goto 0b8
      // 148: astore 3
      // 149: goto 106
      // try (35 -> 44): 85 java/lang/IndexOutOfBoundsException
      // try (35 -> 44): 145 java/io/IOException
      // try (35 -> 44): 115 java/lang/RuntimeException
      // try (44 -> 47): 80 null
      // try (53 -> 77): 80 null
      // try (77 -> 79): 85 java/lang/IndexOutOfBoundsException
      // try (77 -> 79): 145 java/io/IOException
      // try (77 -> 79): 115 java/lang/RuntimeException
      // try (81 -> 85): 85 java/lang/IndexOutOfBoundsException
      // try (81 -> 85): 145 java/io/IOException
      // try (81 -> 85): 115 java/lang/RuntimeException
   }
}
