package bolts;

import java.io.Closeable;

public class CancellationTokenRegistration implements Closeable {
   private final Object a;
   private CancellationTokenSource b;
   private Runnable c;
   private boolean d;

   @Override
   public void close() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 00: aload 0
      // 01: getfield bolts/CancellationTokenRegistration.a Ljava/lang/Object;
      // 04: astore 1
      // 05: aload 1
      // 06: monitorenter
      // 07: aload 0
      // 08: getfield bolts/CancellationTokenRegistration.d Z
      // 0b: ifeq 11
      // 0e: aload 1
      // 0f: monitorexit
      // 10: return
      // 11: aload 0
      // 12: bipush 1
      // 13: putfield bolts/CancellationTokenRegistration.d Z
      // 16: aload 0
      // 17: getfield bolts/CancellationTokenRegistration.b Lbolts/CancellationTokenSource;
      // 1a: aload 0
      // 1b: invokevirtual bolts/CancellationTokenSource.a (Lbolts/CancellationTokenRegistration;)V
      // 1e: aload 0
      // 1f: aconst_null
      // 20: putfield bolts/CancellationTokenRegistration.b Lbolts/CancellationTokenSource;
      // 23: aload 0
      // 24: aconst_null
      // 25: putfield bolts/CancellationTokenRegistration.c Ljava/lang/Runnable;
      // 28: aload 1
      // 29: monitorexit
      // 2a: goto 10
      // 2d: astore 2
      // 2e: aload 1
      // 2f: monitorexit
      // 30: aload 2
      // 31: athrow
      // try (5 -> 10): 27 null
      // try (11 -> 26): 27 null
      // try (28 -> 30): 27 null
   }
}
