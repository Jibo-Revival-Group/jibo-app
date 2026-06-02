package com.google.api.client.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoggingByteArrayOutputStream extends ByteArrayOutputStream {
   private int bytesWritten;
   private boolean closed;
   private final Logger logger;
   private final Level loggingLevel;
   private final int maximumBytesToLog;

   public LoggingByteArrayOutputStream(Logger var1, Level var2, int var3) {
      this.logger = Preconditions.checkNotNull(var1);
      this.loggingLevel = Preconditions.checkNotNull(var2);
      boolean var4;
      if (var3 >= 0) {
         var4 = true;
      } else {
         var4 = false;
      }

      Preconditions.checkArgument(var4);
      this.maximumBytesToLog = var3;
   }

   private static void appendBytes(StringBuilder var0, int var1) {
      if (var1 == 1) {
         var0.append("1 byte");
      } else {
         var0.append(NumberFormat.getInstance().format(var1)).append(" bytes");
      }
   }

   @Override
   public void close() throws IOException {
      synchronized (this) {
         if (!this.closed) {
            if (this.bytesWritten != 0) {
               StringBuilder var1 = new StringBuilder();
               var1 = var1.append("Total: ");
               appendBytes(var1, this.bytesWritten);
               if (this.count != 0 && this.count < this.bytesWritten) {
                  var1.append(" (logging first ");
                  appendBytes(var1, this.count);
                  var1.append(")");
               }

               this.logger.config(var1.toString());
               if (this.count != 0) {
                  this.logger.log(this.loggingLevel, this.toString("UTF-8").replaceAll("[\\x00-\\x09\\x0B\\x0C\\x0E-\\x1F\\x7F]", " "));
               }
            }

            this.closed = true;
         }
      }
   }

   public final int getBytesWritten() {
      synchronized (this) {
         return this.bytesWritten;
      }
   }

   public final int getMaximumBytesToLog() {
      return this.maximumBytesToLog;
   }

   @Override
   public void write(int param1) {
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
      // 02: aload 0
      // 03: getfield com/google/api/client/util/LoggingByteArrayOutputStream.closed Z
      // 06: ifne 2c
      // 09: bipush 1
      // 0a: istore 2
      // 0b: iload 2
      // 0c: invokestatic com/google/api/client/util/Preconditions.checkArgument (Z)V
      // 0f: aload 0
      // 10: aload 0
      // 11: getfield com/google/api/client/util/LoggingByteArrayOutputStream.bytesWritten I
      // 14: bipush 1
      // 15: iadd
      // 16: putfield com/google/api/client/util/LoggingByteArrayOutputStream.bytesWritten I
      // 19: aload 0
      // 1a: getfield com/google/api/client/util/LoggingByteArrayOutputStream.count I
      // 1d: aload 0
      // 1e: getfield com/google/api/client/util/LoggingByteArrayOutputStream.maximumBytesToLog I
      // 21: if_icmpge 29
      // 24: aload 0
      // 25: iload 1
      // 26: invokespecial java/io/ByteArrayOutputStream.write (I)V
      // 29: aload 0
      // 2a: monitorexit
      // 2b: return
      // 2c: bipush 0
      // 2d: istore 2
      // 2e: goto 0b
      // 31: astore 3
      // 32: aload 0
      // 33: monitorexit
      // 34: aload 3
      // 35: athrow
      // try (2 -> 5): 29 null
      // try (7 -> 23): 29 null
   }

   @Override
   public void write(byte[] param1, int param2, int param3) {
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
      // 02: aload 0
      // 03: getfield com/google/api/client/util/LoggingByteArrayOutputStream.closed Z
      // 06: ifne 50
      // 09: bipush 1
      // 0a: istore 6
      // 0c: iload 6
      // 0e: invokestatic com/google/api/client/util/Preconditions.checkArgument (Z)V
      // 11: aload 0
      // 12: aload 0
      // 13: getfield com/google/api/client/util/LoggingByteArrayOutputStream.bytesWritten I
      // 16: iload 3
      // 17: iadd
      // 18: putfield com/google/api/client/util/LoggingByteArrayOutputStream.bytesWritten I
      // 1b: aload 0
      // 1c: getfield com/google/api/client/util/LoggingByteArrayOutputStream.count I
      // 1f: aload 0
      // 20: getfield com/google/api/client/util/LoggingByteArrayOutputStream.maximumBytesToLog I
      // 23: if_icmpge 4d
      // 26: aload 0
      // 27: getfield com/google/api/client/util/LoggingByteArrayOutputStream.count I
      // 2a: iload 3
      // 2b: iadd
      // 2c: istore 5
      // 2e: iload 3
      // 2f: istore 4
      // 31: iload 5
      // 33: aload 0
      // 34: getfield com/google/api/client/util/LoggingByteArrayOutputStream.maximumBytesToLog I
      // 37: if_icmple 45
      // 3a: iload 3
      // 3b: aload 0
      // 3c: getfield com/google/api/client/util/LoggingByteArrayOutputStream.maximumBytesToLog I
      // 3f: iload 5
      // 41: isub
      // 42: iadd
      // 43: istore 4
      // 45: aload 0
      // 46: aload 1
      // 47: iload 2
      // 48: iload 4
      // 4a: invokespecial java/io/ByteArrayOutputStream.write ([BII)V
      // 4d: aload 0
      // 4e: monitorexit
      // 4f: return
      // 50: bipush 0
      // 51: istore 6
      // 53: goto 0c
      // 56: astore 1
      // 57: aload 0
      // 58: monitorexit
      // 59: aload 1
      // 5a: athrow
      // try (2 -> 5): 49 null
      // try (7 -> 25): 49 null
      // try (27 -> 38): 49 null
      // try (38 -> 43): 49 null
   }
}
