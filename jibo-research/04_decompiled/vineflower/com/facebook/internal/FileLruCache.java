package com.facebook.internal;

import com.facebook.FacebookSdk;
import com.facebook.LoggingBehavior;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.InvalidParameterException;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

public final class FileLruCache {
   private static final String HEADER_CACHEKEY_KEY = "key";
   private static final String HEADER_CACHE_CONTENT_TAG_KEY = "tag";
   static final String TAG = FileLruCache.class.getSimpleName();
   private static final AtomicLong bufferIndex = new AtomicLong();
   private final File directory;
   private boolean isTrimInProgress;
   private boolean isTrimPending;
   private AtomicLong lastClearCacheTime = new AtomicLong(0L);
   private final FileLruCache.Limits limits;
   private final Object lock;
   private final String tag;

   public FileLruCache(String var1, FileLruCache.Limits var2) {
      this.tag = var1;
      this.limits = var2;
      this.directory = new File(FacebookSdk.getCacheDir(), var1);
      this.lock = new Object();
      if (this.directory.mkdirs() || this.directory.isDirectory()) {
         FileLruCache.BufferFile.deleteAll(this.directory);
      }
   }

   private void postTrim() {
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
      // 00: aload 0
      // 01: getfield com/facebook/internal/FileLruCache.lock Ljava/lang/Object;
      // 04: astore 1
      // 05: aload 1
      // 06: monitorenter
      // 07: aload 0
      // 08: getfield com/facebook/internal/FileLruCache.isTrimPending Z
      // 0b: ifne 27
      // 0e: aload 0
      // 0f: bipush 1
      // 10: putfield com/facebook/internal/FileLruCache.isTrimPending Z
      // 13: invokestatic com/facebook/FacebookSdk.getExecutor ()Ljava/util/concurrent/Executor;
      // 16: astore 2
      // 17: new com/facebook/internal/FileLruCache$3
      // 1a: astore 3
      // 1b: aload 3
      // 1c: aload 0
      // 1d: invokespecial com/facebook/internal/FileLruCache$3.<init> (Lcom/facebook/internal/FileLruCache;)V
      // 20: aload 2
      // 21: aload 3
      // 22: invokeinterface java/util/concurrent/Executor.execute (Ljava/lang/Runnable;)V 2
      // 27: aload 1
      // 28: monitorexit
      // 29: return
      // 2a: astore 2
      // 2b: aload 1
      // 2c: monitorexit
      // 2d: aload 2
      // 2e: athrow
      // try (5 -> 21): 24 null
      // try (21 -> 23): 24 null
      // try (25 -> 27): 24 null
   }

   private void renameToTargetAndTrim(String var1, File var2) {
      if (!var2.renameTo(new File(this.directory, Utility.md5hash(var1)))) {
         var2.delete();
      }

      this.postTrim();
   }

   private void trim() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 000: aload 0
      // 001: getfield com/facebook/internal/FileLruCache.lock Ljava/lang/Object;
      // 004: astore 12
      // 006: aload 12
      // 008: monitorenter
      // 009: aload 0
      // 00a: bipush 0
      // 00b: putfield com/facebook/internal/FileLruCache.isTrimPending Z
      // 00e: aload 0
      // 00f: bipush 1
      // 010: putfield com/facebook/internal/FileLruCache.isTrimInProgress Z
      // 013: aload 12
      // 015: monitorexit
      // 016: getstatic com/facebook/LoggingBehavior.CACHE Lcom/facebook/LoggingBehavior;
      // 019: getstatic com/facebook/internal/FileLruCache.TAG Ljava/lang/String;
      // 01c: ldc "trim started"
      // 01e: invokestatic com/facebook/internal/Logger.log (Lcom/facebook/LoggingBehavior;Ljava/lang/String;Ljava/lang/String;)V
      // 021: new java/util/PriorityQueue
      // 024: astore 11
      // 026: aload 11
      // 028: invokespecial java/util/PriorityQueue.<init> ()V
      // 02b: lconst_0
      // 02c: lstore 3
      // 02d: lconst_0
      // 02e: lstore 7
      // 030: aload 0
      // 031: getfield com/facebook/internal/FileLruCache.directory Ljava/io/File;
      // 034: invokestatic com/facebook/internal/FileLruCache$BufferFile.excludeBufferFiles ()Ljava/io/FilenameFilter;
      // 037: invokevirtual java/io/File.listFiles (Ljava/io/FilenameFilter;)[Ljava/io/File;
      // 03a: astore 13
      // 03c: lload 7
      // 03e: lstore 5
      // 040: lload 3
      // 041: lstore 9
      // 043: aload 13
      // 045: ifnull 186
      // 048: aload 13
      // 04a: arraylength
      // 04b: istore 2
      // 04c: bipush 0
      // 04d: istore 1
      // 04e: lload 7
      // 050: lstore 5
      // 052: lload 3
      // 053: lstore 9
      // 055: iload 1
      // 056: iload 2
      // 057: if_icmpge 186
      // 05a: aload 13
      // 05c: iload 1
      // 05d: aaload
      // 05e: astore 15
      // 060: new com/facebook/internal/FileLruCache$ModifiedFile
      // 063: astore 14
      // 065: aload 14
      // 067: aload 15
      // 069: invokespecial com/facebook/internal/FileLruCache$ModifiedFile.<init> (Ljava/io/File;)V
      // 06c: aload 11
      // 06e: aload 14
      // 070: invokevirtual java/util/PriorityQueue.add (Ljava/lang/Object;)Z
      // 073: pop
      // 074: getstatic com/facebook/LoggingBehavior.CACHE Lcom/facebook/LoggingBehavior;
      // 077: astore 17
      // 079: getstatic com/facebook/internal/FileLruCache.TAG Ljava/lang/String;
      // 07c: astore 16
      // 07e: new java/lang/StringBuilder
      // 081: astore 12
      // 083: aload 12
      // 085: invokespecial java/lang/StringBuilder.<init> ()V
      // 088: aload 17
      // 08a: aload 16
      // 08c: aload 12
      // 08e: ldc "  trim considering time="
      // 090: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 093: aload 14
      // 095: invokevirtual com/facebook/internal/FileLruCache$ModifiedFile.getModified ()J
      // 098: invokestatic java/lang/Long.valueOf (J)Ljava/lang/Long;
      // 09b: invokevirtual java/lang/StringBuilder.append (Ljava/lang/Object;)Ljava/lang/StringBuilder;
      // 09e: ldc " name="
      // 0a0: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 0a3: aload 14
      // 0a5: invokevirtual com/facebook/internal/FileLruCache$ModifiedFile.getFile ()Ljava/io/File;
      // 0a8: invokevirtual java/io/File.getName ()Ljava/lang/String;
      // 0ab: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 0ae: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 0b1: invokestatic com/facebook/internal/Logger.log (Lcom/facebook/LoggingBehavior;Ljava/lang/String;Ljava/lang/String;)V
      // 0b4: aload 15
      // 0b6: invokevirtual java/io/File.length ()J
      // 0b9: lstore 5
      // 0bb: iinc 1 1
      // 0be: lconst_1
      // 0bf: lload 7
      // 0c1: ladd
      // 0c2: lstore 7
      // 0c4: lload 5
      // 0c6: lload 3
      // 0c7: ladd
      // 0c8: lstore 3
      // 0c9: goto 04e
      // 0cc: astore 11
      // 0ce: aload 12
      // 0d0: monitorexit
      // 0d1: aload 11
      // 0d3: athrow
      // 0d4: lload 9
      // 0d6: aload 0
      // 0d7: getfield com/facebook/internal/FileLruCache.limits Lcom/facebook/internal/FileLruCache$Limits;
      // 0da: invokevirtual com/facebook/internal/FileLruCache$Limits.getByteCount ()I
      // 0dd: i2l
      // 0de: lcmp
      // 0df: ifgt 0ef
      // 0e2: lload 3
      // 0e3: aload 0
      // 0e4: getfield com/facebook/internal/FileLruCache.limits Lcom/facebook/internal/FileLruCache$Limits;
      // 0e7: invokevirtual com/facebook/internal/FileLruCache$Limits.getFileCount ()I
      // 0ea: i2l
      // 0eb: lcmp
      // 0ec: ifle 140
      // 0ef: aload 11
      // 0f1: invokevirtual java/util/PriorityQueue.remove ()Ljava/lang/Object;
      // 0f4: checkcast com/facebook/internal/FileLruCache$ModifiedFile
      // 0f7: invokevirtual com/facebook/internal/FileLruCache$ModifiedFile.getFile ()Ljava/io/File;
      // 0fa: astore 15
      // 0fc: getstatic com/facebook/LoggingBehavior.CACHE Lcom/facebook/LoggingBehavior;
      // 0ff: astore 14
      // 101: getstatic com/facebook/internal/FileLruCache.TAG Ljava/lang/String;
      // 104: astore 13
      // 106: new java/lang/StringBuilder
      // 109: astore 12
      // 10b: aload 12
      // 10d: invokespecial java/lang/StringBuilder.<init> ()V
      // 110: aload 14
      // 112: aload 13
      // 114: aload 12
      // 116: ldc "  trim removing "
      // 118: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 11b: aload 15
      // 11d: invokevirtual java/io/File.getName ()Ljava/lang/String;
      // 120: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 123: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 126: invokestatic com/facebook/internal/Logger.log (Lcom/facebook/LoggingBehavior;Ljava/lang/String;Ljava/lang/String;)V
      // 129: lload 9
      // 12b: aload 15
      // 12d: invokevirtual java/io/File.length ()J
      // 130: lsub
      // 131: lstore 9
      // 133: aload 15
      // 135: invokevirtual java/io/File.delete ()Z
      // 138: pop
      // 139: lload 3
      // 13a: lconst_1
      // 13b: lsub
      // 13c: lstore 3
      // 13d: goto 0d4
      // 140: aload 0
      // 141: getfield com/facebook/internal/FileLruCache.lock Ljava/lang/Object;
      // 144: astore 12
      // 146: aload 12
      // 148: monitorenter
      // 149: aload 0
      // 14a: bipush 0
      // 14b: putfield com/facebook/internal/FileLruCache.isTrimInProgress Z
      // 14e: aload 0
      // 14f: getfield com/facebook/internal/FileLruCache.lock Ljava/lang/Object;
      // 152: invokevirtual java/lang/Object.notifyAll ()V
      // 155: aload 12
      // 157: monitorexit
      // 158: return
      // 159: astore 11
      // 15b: aload 12
      // 15d: monitorexit
      // 15e: aload 11
      // 160: athrow
      // 161: astore 12
      // 163: aload 0
      // 164: getfield com/facebook/internal/FileLruCache.lock Ljava/lang/Object;
      // 167: astore 11
      // 169: aload 11
      // 16b: monitorenter
      // 16c: aload 0
      // 16d: bipush 0
      // 16e: putfield com/facebook/internal/FileLruCache.isTrimInProgress Z
      // 171: aload 0
      // 172: getfield com/facebook/internal/FileLruCache.lock Ljava/lang/Object;
      // 175: invokevirtual java/lang/Object.notifyAll ()V
      // 178: aload 11
      // 17a: monitorexit
      // 17b: aload 12
      // 17d: athrow
      // 17e: astore 12
      // 180: aload 11
      // 182: monitorexit
      // 183: aload 12
      // 185: athrow
      // 186: lload 5
      // 188: lstore 3
      // 189: goto 0d4
      // try (5 -> 13): 99 null
      // try (13 -> 21): 173 null
      // try (25 -> 30): 173 null
      // try (36 -> 39): 173 null
      // try (52 -> 89): 173 null
      // try (100 -> 102): 99 null
      // try (104 -> 118): 173 null
      // try (118 -> 149): 173 null
      // try (159 -> 167): 168 null
      // try (169 -> 171): 168 null
      // try (179 -> 187): 189 null
      // try (190 -> 192): 189 null
   }

   public void clearCache() {
      File[] var1 = this.directory.listFiles(FileLruCache.BufferFile.excludeBufferFiles());
      this.lastClearCacheTime.set(System.currentTimeMillis());
      if (var1 != null) {
         FacebookSdk.getExecutor().execute(new Runnable(this, var1) {
            final FileLruCache this$0;
            final File[] val$filesToDelete;

            {
               this.this$0 = var1;
               this.val$filesToDelete = var2;
            }

            @Override
            public void run() {
               File[] var3 = this.val$filesToDelete;
               int var2 = var3.length;

               for (int var1x = 0; var1x < var2; var1x++) {
                  var3[var1x].delete();
               }
            }
         });
      }
   }

   public InputStream get(String var1) throws IOException {
      return this.get(var1, null);
   }

   public InputStream get(String param1, String param2) throws IOException {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
      //   at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
      //   at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
      //   at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
      //   at java.base/java.util.Objects.checkIndex(Objects.java:361)
      //   at java.base/java.util.ArrayList.remove(ArrayList.java:504)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.removeExceptionInstructionsEx(FinallyProcessor.java:1058)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.insertSemaphore(FinallyProcessor.java:351)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.iterateGraph(FinallyProcessor.java:98)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:185)
      //
      // Bytecode:
      // 00: aconst_null
      // 01: astore 7
      // 03: new java/io/File
      // 06: dup
      // 07: aload 0
      // 08: getfield com/facebook/internal/FileLruCache.directory Ljava/io/File;
      // 0b: aload 1
      // 0c: invokestatic com/facebook/internal/Utility.md5hash (Ljava/lang/String;)Ljava/lang/String;
      // 0f: invokespecial java/io/File.<init> (Ljava/io/File;Ljava/lang/String;)V
      // 12: astore 8
      // 14: new java/io/FileInputStream
      // 17: astore 6
      // 19: aload 6
      // 1b: aload 8
      // 1d: invokespecial java/io/FileInputStream.<init> (Ljava/io/File;)V
      // 20: new java/io/BufferedInputStream
      // 23: dup
      // 24: aload 6
      // 26: sipush 8192
      // 29: invokespecial java/io/BufferedInputStream.<init> (Ljava/io/InputStream;I)V
      // 2c: astore 6
      // 2e: aload 6
      // 30: invokestatic com/facebook/internal/FileLruCache$StreamHeader.readHeader (Ljava/io/InputStream;)Lorg/json/JSONObject;
      // 33: astore 9
      // 35: aload 9
      // 37: ifnonnull 44
      // 3a: aload 6
      // 3c: invokevirtual java/io/BufferedInputStream.close ()V
      // 3f: aload 7
      // 41: astore 1
      // 42: aload 1
      // 43: areturn
      // 44: aload 9
      // 46: ldc "key"
      // 48: invokevirtual org/json/JSONObject.optString (Ljava/lang/String;)Ljava/lang/String;
      // 4b: astore 10
      // 4d: aload 10
      // 4f: ifnull 5d
      // 52: aload 10
      // 54: aload 1
      // 55: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 58: istore 3
      // 59: iload 3
      // 5a: ifne 68
      // 5d: aload 6
      // 5f: invokevirtual java/io/BufferedInputStream.close ()V
      // 62: aload 7
      // 64: astore 1
      // 65: goto 42
      // 68: aload 9
      // 6a: ldc "tag"
      // 6c: aconst_null
      // 6d: invokevirtual org/json/JSONObject.optString (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
      // 70: astore 1
      // 71: aload 2
      // 72: ifnonnull 79
      // 75: aload 1
      // 76: ifnonnull 87
      // 79: aload 2
      // 7a: ifnull 92
      // 7d: aload 2
      // 7e: aload 1
      // 7f: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 82: istore 3
      // 83: iload 3
      // 84: ifne 92
      // 87: aload 6
      // 89: invokevirtual java/io/BufferedInputStream.close ()V
      // 8c: aload 7
      // 8e: astore 1
      // 8f: goto 42
      // 92: new java/util/Date
      // 95: astore 1
      // 96: aload 1
      // 97: invokespecial java/util/Date.<init> ()V
      // 9a: aload 1
      // 9b: invokevirtual java/util/Date.getTime ()J
      // 9e: lstore 4
      // a0: getstatic com/facebook/LoggingBehavior.CACHE Lcom/facebook/LoggingBehavior;
      // a3: astore 2
      // a4: getstatic com/facebook/internal/FileLruCache.TAG Ljava/lang/String;
      // a7: astore 7
      // a9: new java/lang/StringBuilder
      // ac: astore 1
      // ad: aload 1
      // ae: invokespecial java/lang/StringBuilder.<init> ()V
      // b1: aload 2
      // b2: aload 7
      // b4: aload 1
      // b5: ldc_w "Setting lastModified to "
      // b8: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // bb: lload 4
      // bd: invokestatic java/lang/Long.valueOf (J)Ljava/lang/Long;
      // c0: invokevirtual java/lang/StringBuilder.append (Ljava/lang/Object;)Ljava/lang/StringBuilder;
      // c3: ldc_w " for "
      // c6: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // c9: aload 8
      // cb: invokevirtual java/io/File.getName ()Ljava/lang/String;
      // ce: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // d1: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // d4: invokestatic com/facebook/internal/Logger.log (Lcom/facebook/LoggingBehavior;Ljava/lang/String;Ljava/lang/String;)V
      // d7: aload 8
      // d9: lload 4
      // db: invokevirtual java/io/File.setLastModified (J)Z
      // de: pop
      // df: aload 6
      // e1: astore 1
      // e2: goto 42
      // e5: astore 1
      // e6: aload 6
      // e8: invokevirtual java/io/BufferedInputStream.close ()V
      // eb: aload 1
      // ec: athrow
      // ed: astore 1
      // ee: aload 7
      // f0: astore 1
      // f1: goto 42
      // try (10 -> 15): 113 java/io/IOException
      // try (21 -> 24): 108 null
      // try (32 -> 36): 108 null
      // try (38 -> 42): 108 null
      // try (49 -> 54): 108 null
      // try (60 -> 64): 108 null
      // try (71 -> 105): 108 null
   }

   public String getLocation() {
      return this.directory.getPath();
   }

   public InputStream interceptAndPut(String var1, InputStream var2) throws IOException {
      return new FileLruCache.CopyingInputStream(var2, this.openPutStream(var1));
   }

   public OutputStream openPutStream(String var1) throws IOException {
      return this.openPutStream(var1, null);
   }

   public OutputStream openPutStream(String var1, String var2) throws IOException {
      File var4 = FileLruCache.BufferFile.newFile(this.directory);
      var4.delete();
      if (!var4.createNewFile()) {
         throw new IOException("Could not create file at " + var4.getAbsolutePath());
      }

      FileOutputStream var3;
      try {
         var3 = new FileOutputStream(var4);
      } catch (FileNotFoundException var11) {
         Logger.log(LoggingBehavior.CACHE, 5, TAG, "Error creating buffer output stream: " + var11);
         throw new IOException(var11.getMessage());
      }

      BufferedOutputStream var14 = new BufferedOutputStream(
         new FileLruCache.CloseCallbackOutputStream(var3, new FileLruCache.StreamCloseCallback(this, System.currentTimeMillis(), var4, var1) {
            final FileLruCache this$0;
            final File val$buffer;
            final long val$bufferFileCreateTime;
            final String val$key;

            {
               this.this$0 = var1;
               this.val$bufferFileCreateTime = var2x;
               this.val$buffer = var4x;
               this.val$key = var5;
            }

            @Override
            public void onClose() {
               if (this.val$bufferFileCreateTime < this.this$0.lastClearCacheTime.get()) {
                  this.val$buffer.delete();
               } else {
                  this.this$0.renameToTargetAndTrim(this.val$key, this.val$buffer);
               }
            }
         }), 8192
      );

      try {
         JSONObject var16 = new JSONObject();
         var16.put("key", var1);
         if (!Utility.isNullOrEmpty(var2)) {
            var16.put("tag", var2);
         }

         FileLruCache.StreamHeader.writeHeader(var14, var16);
         return var14;
      } catch (JSONException var9) {
         LoggingBehavior var12 = LoggingBehavior.CACHE;
         String var5 = TAG;
         StringBuilder var15 = new StringBuilder();
         Logger.log(var12, 5, var5, var15.append("Error creating JSON header for cache file: ").append(var9).toString());
         IOException var13 = new IOException(var9.getMessage());
         throw var13;
      } finally {
         var14.close();
      }
   }

   long sizeInBytesForTest() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 00: aload 0
      // 01: getfield com/facebook/internal/FileLruCache.lock Ljava/lang/Object;
      // 04: astore 8
      // 06: aload 8
      // 08: monitorenter
      // 09: aload 0
      // 0a: getfield com/facebook/internal/FileLruCache.isTrimPending Z
      // 0d: ifne 1b
      // 10: aload 0
      // 11: getfield com/facebook/internal/FileLruCache.isTrimInProgress Z
      // 14: istore 7
      // 16: iload 7
      // 18: ifeq 2a
      // 1b: aload 0
      // 1c: getfield com/facebook/internal/FileLruCache.lock Ljava/lang/Object;
      // 1f: invokevirtual java/lang/Object.wait ()V
      // 22: goto 09
      // 25: astore 9
      // 27: goto 09
      // 2a: aload 8
      // 2c: monitorexit
      // 2d: aload 0
      // 2e: getfield com/facebook/internal/FileLruCache.directory Ljava/io/File;
      // 31: invokevirtual java/io/File.listFiles ()[Ljava/io/File;
      // 34: astore 8
      // 36: lconst_0
      // 37: lstore 3
      // 38: lload 3
      // 39: lstore 5
      // 3b: aload 8
      // 3d: ifnull 6a
      // 40: aload 8
      // 42: arraylength
      // 43: istore 2
      // 44: bipush 0
      // 45: istore 1
      // 46: lload 3
      // 47: lstore 5
      // 49: iload 1
      // 4a: iload 2
      // 4b: if_icmpge 6a
      // 4e: aload 8
      // 50: iload 1
      // 51: aaload
      // 52: invokevirtual java/io/File.length ()J
      // 55: lstore 5
      // 57: iinc 1 1
      // 5a: lload 5
      // 5c: lload 3
      // 5d: ladd
      // 5e: lstore 3
      // 5f: goto 46
      // 62: astore 9
      // 64: aload 8
      // 66: monitorexit
      // 67: aload 9
      // 69: athrow
      // 6a: lload 5
      // 6c: lreturn
      // try (5 -> 11): 52 null
      // try (13 -> 16): 17 java/lang/InterruptedException
      // try (13 -> 16): 52 null
      // try (19 -> 21): 52 null
      // try (53 -> 55): 52 null
   }

   @Override
   public String toString() {
      return "{FileLruCache: tag:" + this.tag + " file:" + this.directory.getName() + "}";
   }

   private static class BufferFile {
      private static final String FILE_NAME_PREFIX = "buffer";
      private static final FilenameFilter filterExcludeBufferFiles = new FilenameFilter() {
         @Override
         public boolean accept(File var1, String var2) {
            boolean var3;
            if (!var2.startsWith("buffer")) {
               var3 = true;
            } else {
               var3 = false;
            }

            return var3;
         }
      };
      private static final FilenameFilter filterExcludeNonBufferFiles = new FilenameFilter() {
         @Override
         public boolean accept(File var1, String var2) {
            return var2.startsWith("buffer");
         }
      };

      static void deleteAll(File var0) {
         File[] var3 = var0.listFiles(excludeNonBufferFiles());
         if (var3 != null) {
            int var2 = var3.length;

            for (int var1 = 0; var1 < var2; var1++) {
               var3[var1].delete();
            }
         }
      }

      static FilenameFilter excludeBufferFiles() {
         return filterExcludeBufferFiles;
      }

      static FilenameFilter excludeNonBufferFiles() {
         return filterExcludeNonBufferFiles;
      }

      static File newFile(File var0) {
         return new File(var0, "buffer" + Long.valueOf(FileLruCache.bufferIndex.incrementAndGet()).toString());
      }
   }

   private static class CloseCallbackOutputStream extends OutputStream {
      final FileLruCache.StreamCloseCallback callback;
      final OutputStream innerStream;

      CloseCallbackOutputStream(OutputStream var1, FileLruCache.StreamCloseCallback var2) {
         this.innerStream = var1;
         this.callback = var2;
      }

      @Override
      public void close() throws IOException {
         try {
            this.innerStream.close();
         } finally {
            this.callback.onClose();
         }
      }

      @Override
      public void flush() throws IOException {
         this.innerStream.flush();
      }

      @Override
      public void write(int var1) throws IOException {
         this.innerStream.write(var1);
      }

      @Override
      public void write(byte[] var1) throws IOException {
         this.innerStream.write(var1);
      }

      @Override
      public void write(byte[] var1, int var2, int var3) throws IOException {
         this.innerStream.write(var1, var2, var3);
      }
   }

   private static final class CopyingInputStream extends InputStream {
      final InputStream input;
      final OutputStream output;

      CopyingInputStream(InputStream var1, OutputStream var2) {
         this.input = var1;
         this.output = var2;
      }

      @Override
      public int available() throws IOException {
         return this.input.available();
      }

      @Override
      public void close() throws IOException {
         try {
            this.input.close();
         } finally {
            this.output.close();
         }
      }

      @Override
      public void mark(int var1) {
         throw new UnsupportedOperationException();
      }

      @Override
      public boolean markSupported() {
         return false;
      }

      @Override
      public int read() throws IOException {
         int var1 = this.input.read();
         if (var1 >= 0) {
            this.output.write(var1);
         }

         return var1;
      }

      @Override
      public int read(byte[] var1) throws IOException {
         int var2 = this.input.read(var1);
         if (var2 > 0) {
            this.output.write(var1, 0, var2);
         }

         return var2;
      }

      @Override
      public int read(byte[] var1, int var2, int var3) throws IOException {
         var3 = this.input.read(var1, var2, var3);
         if (var3 > 0) {
            this.output.write(var1, var2, var3);
         }

         return var3;
      }

      @Override
      public void reset() {
         synchronized (this) {
            UnsupportedOperationException var1 = new UnsupportedOperationException();
            throw var1;
         }
      }

      @Override
      public long skip(long var1) throws IOException {
         byte[] var6 = new byte[1024];
         long var4 = 0L;

         while (var4 < var1) {
            int var3 = this.read(var6, 0, (int)Math.min(var1 - var4, var6.length));
            if (var3 < 0) {
               break;
            }

            var4 += var3;
         }

         return var4;
      }
   }

   public static final class Limits {
      private int byteCount;
      private int fileCount = 1024;

      public Limits() {
         this.byteCount = 1048576;
      }

      int getByteCount() {
         return this.byteCount;
      }

      int getFileCount() {
         return this.fileCount;
      }

      void setByteCount(int var1) {
         if (var1 < 0) {
            throw new InvalidParameterException("Cache byte-count limit must be >= 0");
         }

         this.byteCount = var1;
      }

      void setFileCount(int var1) {
         if (var1 < 0) {
            throw new InvalidParameterException("Cache file count limit must be >= 0");
         }

         this.fileCount = var1;
      }
   }

   private static final class ModifiedFile implements Comparable<FileLruCache.ModifiedFile> {
      private static final int HASH_MULTIPLIER = 37;
      private static final int HASH_SEED = 29;
      private final File file;
      private final long modified;

      ModifiedFile(File var1) {
         this.file = var1;
         this.modified = var1.lastModified();
      }

      public int compareTo(FileLruCache.ModifiedFile var1) {
         int var2;
         if (this.getModified() < var1.getModified()) {
            var2 = -1;
         } else if (this.getModified() > var1.getModified()) {
            var2 = 1;
         } else {
            var2 = this.getFile().compareTo(var1.getFile());
         }

         return var2;
      }

      @Override
      public boolean equals(Object var1) {
         boolean var2;
         if (var1 instanceof FileLruCache.ModifiedFile && this.compareTo((FileLruCache.ModifiedFile)var1) == 0) {
            var2 = true;
         } else {
            var2 = false;
         }

         return var2;
      }

      File getFile() {
         return this.file;
      }

      long getModified() {
         return this.modified;
      }

      @Override
      public int hashCode() {
         return (this.file.hashCode() + 1073) * 37 + (int)(this.modified % 2147483647L);
      }
   }

   private interface StreamCloseCallback {
      void onClose();
   }

   private static final class StreamHeader {
      private static final int HEADER_VERSION = 0;

      static JSONObject readHeader(InputStream var0) throws IOException {
         byte var3 = 0;
         JSONObject var9;
         if (var0.read() != 0) {
            var9 = null;
         } else {
            int var1 = 0;
            int var2 = 0;

            while (true) {
               if (var1 >= 3) {
                  byte[] var5 = new byte[var2];
                  var1 = var3;

                  while (var1 < var5.length) {
                     var2 = var0.read(var5, var1, var5.length - var1);
                     if (var2 < 1) {
                        Logger.log(LoggingBehavior.CACHE, FileLruCache.TAG, "readHeader: stream.read stopped at " + var1 + " when expected " + var5.length);
                        Object var15 = null;
                        return (JSONObject)var15;
                     }

                     var1 += var2;
                  }

                  JSONTokener var10 = new JSONTokener(new String(var5));

                  try {
                     Object var14 = var10.nextValue();
                     if (var14 instanceof JSONObject) {
                        var9 = (JSONObject)var14;
                        break;
                     }

                     LoggingBehavior var11 = LoggingBehavior.CACHE;
                     String var6 = FileLruCache.TAG;
                     StringBuilder var7 = new StringBuilder();
                     Logger.log(var11, var6, var7.append("readHeader: expected JSONObject, got ").append(var14.getClass().getCanonicalName()).toString());
                  } catch (JSONException var8) {
                     throw new IOException(var8.getMessage());
                  }

                  var9 = null;
                  break;
               }

               int var4 = var0.read();
               if (var4 == -1) {
                  Logger.log(LoggingBehavior.CACHE, FileLruCache.TAG, "readHeader: stream.read returned -1 while reading header size");
                  var9 = null;
                  break;
               }

               var2 = (var2 << 8) + (var4 & 0xFF);
               var1++;
            }
         }

         return var9;
      }

      static void writeHeader(OutputStream var0, JSONObject var1) throws IOException {
         byte[] var2 = var1.toString().getBytes();
         var0.write(0);
         var0.write(var2.length >> 16 & 0xFF);
         var0.write(var2.length >> 8 & 0xFF);
         var0.write(var2.length >> 0 & 0xFF);
         var0.write(var2);
      }
   }
}
