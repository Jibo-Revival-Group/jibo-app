package com.bumptech.glide.load.model;

import com.bumptech.glide.load.Encoder;
import java.io.InputStream;
import java.io.OutputStream;

public class StreamEncoder implements Encoder<InputStream> {
   public boolean a(InputStream param1, OutputStream param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 00: bipush 0
      // 01: istore 4
      // 03: invokestatic com/bumptech/glide/util/ByteArrayPool.a ()Lcom/bumptech/glide/util/ByteArrayPool;
      // 06: invokevirtual com/bumptech/glide/util/ByteArrayPool.b ()[B
      // 09: astore 5
      // 0b: aload 1
      // 0c: aload 5
      // 0e: invokevirtual java/io/InputStream.read ([B)I
      // 11: istore 3
      // 12: iload 3
      // 13: bipush -1
      // 14: if_icmpeq 41
      // 17: aload 2
      // 18: aload 5
      // 1a: bipush 0
      // 1b: iload 3
      // 1c: invokevirtual java/io/OutputStream.write ([BII)V
      // 1f: goto 0b
      // 22: astore 1
      // 23: ldc "StreamEncoder"
      // 25: bipush 3
      // 26: invokestatic android/util/Log.isLoggable (Ljava/lang/String;I)Z
      // 29: ifeq 35
      // 2c: ldc "StreamEncoder"
      // 2e: ldc "Failed to encode data onto the OutputStream"
      // 30: aload 1
      // 31: invokestatic android/util/Log.d (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
      // 34: pop
      // 35: invokestatic com/bumptech/glide/util/ByteArrayPool.a ()Lcom/bumptech/glide/util/ByteArrayPool;
      // 38: aload 5
      // 3a: invokevirtual com/bumptech/glide/util/ByteArrayPool.a ([B)Z
      // 3d: pop
      // 3e: iload 4
      // 40: ireturn
      // 41: bipush 1
      // 42: istore 4
      // 44: invokestatic com/bumptech/glide/util/ByteArrayPool.a ()Lcom/bumptech/glide/util/ByteArrayPool;
      // 47: aload 5
      // 49: invokevirtual com/bumptech/glide/util/ByteArrayPool.a ([B)Z
      // 4c: pop
      // 4d: goto 3e
      // 50: astore 1
      // 51: invokestatic com/bumptech/glide/util/ByteArrayPool.a ()Lcom/bumptech/glide/util/ByteArrayPool;
      // 54: aload 5
      // 56: invokevirtual com/bumptech/glide/util/ByteArrayPool.a ([B)Z
      // 59: pop
      // 5a: aload 1
      // 5b: athrow
      // try (5 -> 9): 18 java/io/IOException
      // try (5 -> 9): 41 null
      // try (12 -> 17): 18 java/io/IOException
      // try (12 -> 17): 41 null
      // try (19 -> 28): 41 null
   }

   @Override
   public String getId() {
      return "";
   }
}
