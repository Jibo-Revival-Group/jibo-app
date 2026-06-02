package io.fabric.sdk.android.services.events;

import android.content.Context;
import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.common.QueueFile;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QueueFileEventStorage implements EventsStorage {
   private final Context a;
   private final File b;
   private final String c;
   private final File d;
   private QueueFile e;
   private File f;

   public QueueFileEventStorage(Context var1, File var2, String var3, String var4) throws IOException {
      this.a = var1;
      this.b = var2;
      this.c = var4;
      this.d = new File(this.b, var3);
      this.e = new QueueFile(this.d);
      this.e();
   }

   private void a(File param1, File param2) throws IOException {
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
      // 00: aconst_null
      // 01: astore 5
      // 03: aconst_null
      // 04: astore 3
      // 05: new java/io/FileInputStream
      // 08: astore 4
      // 0a: aload 4
      // 0c: aload 1
      // 0d: invokespecial java/io/FileInputStream.<init> (Ljava/io/File;)V
      // 10: aload 5
      // 12: astore 3
      // 13: aload 0
      // 14: aload 2
      // 15: invokevirtual io/fabric/sdk/android/services/events/QueueFileEventStorage.a (Ljava/io/File;)Ljava/io/OutputStream;
      // 18: astore 2
      // 19: aload 2
      // 1a: astore 3
      // 1b: aload 4
      // 1d: aload 2
      // 1e: sipush 1024
      // 21: newarray 8
      // 23: invokestatic io/fabric/sdk/android/services/common/CommonUtils.a (Ljava/io/InputStream;Ljava/io/OutputStream;[B)V
      // 26: aload 4
      // 28: ldc "Failed to close file input stream"
      // 2a: invokestatic io/fabric/sdk/android/services/common/CommonUtils.a (Ljava/io/Closeable;Ljava/lang/String;)V
      // 2d: aload 2
      // 2e: ldc "Failed to close output stream"
      // 30: invokestatic io/fabric/sdk/android/services/common/CommonUtils.a (Ljava/io/Closeable;Ljava/lang/String;)V
      // 33: aload 1
      // 34: invokevirtual java/io/File.delete ()Z
      // 37: pop
      // 38: return
      // 39: astore 2
      // 3a: aconst_null
      // 3b: astore 4
      // 3d: aload 4
      // 3f: ldc "Failed to close file input stream"
      // 41: invokestatic io/fabric/sdk/android/services/common/CommonUtils.a (Ljava/io/Closeable;Ljava/lang/String;)V
      // 44: aload 3
      // 45: ldc "Failed to close output stream"
      // 47: invokestatic io/fabric/sdk/android/services/common/CommonUtils.a (Ljava/io/Closeable;Ljava/lang/String;)V
      // 4a: aload 1
      // 4b: invokevirtual java/io/File.delete ()Z
      // 4e: pop
      // 4f: aload 2
      // 50: athrow
      // 51: astore 2
      // 52: goto 3d
      // try (4 -> 9): 32 null
      // try (11 -> 15): 46 null
      // try (17 -> 22): 46 null
   }

   private void e() {
      this.f = new File(this.b, this.c);
      if (!this.f.exists()) {
         this.f.mkdirs();
      }
   }

   @Override
   public int a() {
      return this.e.a();
   }

   public OutputStream a(File var1) throws IOException {
      return new FileOutputStream(var1);
   }

   @Override
   public List<File> a(int var1) {
      ArrayList var5 = new ArrayList();
      File[] var4 = this.f.listFiles();
      int var3 = var4.length;

      for (int var2 = 0; var2 < var3; var2++) {
         var5.add(var4[var2]);
         if (var5.size() >= var1) {
            break;
         }
      }

      return var5;
   }

   @Override
   public void a(String var1) throws IOException {
      this.e.close();
      this.a(this.d, new File(this.f, var1));
      this.e = new QueueFile(this.d);
   }

   @Override
   public void a(List<File> var1) {
      for (File var3 : var1) {
         CommonUtils.a(this.a, String.format("deleting sent analytics file %s", var3.getName()));
         var3.delete();
      }
   }

   @Override
   public void a(byte[] var1) throws IOException {
      this.e.a(var1);
   }

   @Override
   public boolean a(int var1, int var2) {
      return this.e.a(var1, var2);
   }

   @Override
   public boolean b() {
      return this.e.b();
   }

   @Override
   public List<File> c() {
      return Arrays.asList(this.f.listFiles());
   }

   @Override
   public void d() {
      try {
         this.e.close();
      } catch (IOException var2) {
      }

      this.d.delete();
   }
}
