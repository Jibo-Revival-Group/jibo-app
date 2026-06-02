package org.apache.http.pool;

import java.util.concurrent.TimeUnit;
import org.apache.http.annotation.GuardedBy;
import org.apache.http.annotation.ThreadSafe;
import org.apache.http.util.Args;

@ThreadSafe
public abstract class PoolEntry<T, C> {
   private final C conn;
   private final long created;
   @GuardedBy("this")
   private long expiry;
   private final String id;
   private final T route;
   private volatile Object state;
   @GuardedBy("this")
   private long updated;
   private final long validityDeadline;

   public PoolEntry(String var1, T var2, C var3) {
      this(var1, (T)var2, (C)var3, 0L, TimeUnit.MILLISECONDS);
   }

   public PoolEntry(String var1, T var2, C var3, long var4, TimeUnit var6) {
      Args.notNull(var2, "Route");
      Args.notNull(var3, "Connection");
      Args.notNull(var6, "Time unit");
      this.id = var1;
      this.route = (T)var2;
      this.conn = (C)var3;
      this.created = System.currentTimeMillis();
      if (var4 > 0L) {
         this.validityDeadline = this.created + var6.toMillis(var4);
      } else {
         this.validityDeadline = Long.MAX_VALUE;
      }

      this.expiry = this.validityDeadline;
   }

   public abstract void close();

   public C getConnection() {
      return this.conn;
   }

   public long getCreated() {
      return this.created;
   }

   public long getExpiry() {
      synchronized (this) {
         return this.expiry;
      }
   }

   public String getId() {
      return this.id;
   }

   public T getRoute() {
      return this.route;
   }

   public Object getState() {
      return this.state;
   }

   public long getUpdated() {
      synchronized (this) {
         return this.updated;
      }
   }

   @Deprecated
   public long getValidUnit() {
      return this.validityDeadline;
   }

   public long getValidityDeadline() {
      return this.validityDeadline;
   }

   public abstract boolean isClosed();

   // $VF: Could not verify finally blocks. A semaphore variable has been added to preserve control flow.
   // $VF: Could not create synchronized statement, marking monitor enters and exits
   // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
   public boolean isExpired(long var1) {
      synchronized (this){} // $VF: monitorenter 
      boolean var8 = false /* VF: Semaphore variable */;

      long var3;
      try {
         var8 = true;
         var3 = this.expiry;
         var8 = false;
      } finally {
         if (var8) {
            // $VF: monitorexit
         }
      }

      boolean var5;
      if (var1 >= var3) {
         var5 = true;
      } else {
         var5 = false;
      }

      // $VF: monitorexit
      return var5;
   }

   public void setState(Object var1) {
      this.state = var1;
   }

   @Override
   public String toString() {
      StringBuilder var1 = new StringBuilder();
      var1.append("[id:");
      var1.append(this.id);
      var1.append("][route:");
      var1.append(this.route);
      var1.append("][state:");
      var1.append(this.state);
      var1.append("]");
      return var1.toString();
   }

   public void updateExpiry(long param1, TimeUnit param3) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.IndexOutOfBoundsException: Index -1 out of bounds for length 0
      //   at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
      //   at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
      //   at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
      //   at java.base/java.util.Objects.checkIndex(Objects.java:361)
      //   at java.base/java.util.ArrayList.remove(ArrayList.java:504)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.removeExceptionInstructionsEx(FinallyProcessor.java:1065)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.verifyFinallyEx(FinallyProcessor.java:566)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.iterateGraph(FinallyProcessor.java:90)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:185)
      //
      // Bytecode:
      // 00: aload 0
      // 01: monitorenter
      // 02: aload 3
      // 03: ldc "Time unit"
      // 05: invokestatic org/apache/http/util/Args.notNull (Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;
      // 08: pop
      // 09: aload 0
      // 0a: invokestatic java/lang/System.currentTimeMillis ()J
      // 0d: putfield org/apache/http/pool/PoolEntry.updated J
      // 10: lload 1
      // 11: lconst_0
      // 12: lcmp
      // 13: ifle 30
      // 16: aload 0
      // 17: getfield org/apache/http/pool/PoolEntry.updated J
      // 1a: aload 3
      // 1b: lload 1
      // 1c: invokevirtual java/util/concurrent/TimeUnit.toMillis (J)J
      // 1f: ladd
      // 20: lstore 1
      // 21: aload 0
      // 22: lload 1
      // 23: aload 0
      // 24: getfield org/apache/http/pool/PoolEntry.validityDeadline J
      // 27: invokestatic java/lang/Math.min (JJ)J
      // 2a: putfield org/apache/http/pool/PoolEntry.expiry J
      // 2d: aload 0
      // 2e: monitorexit
      // 2f: return
      // 30: ldc2_w 9223372036854775807
      // 33: lstore 1
      // 34: goto 21
      // 37: astore 3
      // 38: aload 0
      // 39: monitorexit
      // 3a: aload 3
      // 3b: athrow
      // try (2 -> 9): 32 null
      // try (13 -> 20): 32 null
      // try (20 -> 26): 32 null
   }
}
