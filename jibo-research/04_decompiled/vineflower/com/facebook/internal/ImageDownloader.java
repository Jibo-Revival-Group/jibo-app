package com.facebook.internal;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class ImageDownloader {
   private static final int CACHE_READ_QUEUE_MAX_CONCURRENT = 2;
   private static final int DOWNLOAD_QUEUE_MAX_CONCURRENT = 8;
   private static WorkQueue cacheReadQueue = new WorkQueue(2);
   private static WorkQueue downloadQueue = new WorkQueue(8);
   private static Handler handler;
   private static final Map<ImageDownloader.RequestKey, ImageDownloader.DownloaderContext> pendingRequests = new HashMap<>();

   public static boolean cancelRequest(ImageRequest param0) {
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
      // 00: new com/facebook/internal/ImageDownloader$RequestKey
      // 03: dup
      // 04: aload 0
      // 05: invokevirtual com/facebook/internal/ImageRequest.getImageUri ()Landroid/net/Uri;
      // 08: aload 0
      // 09: invokevirtual com/facebook/internal/ImageRequest.getCallerTag ()Ljava/lang/Object;
      // 0c: invokespecial com/facebook/internal/ImageDownloader$RequestKey.<init> (Landroid/net/Uri;Ljava/lang/Object;)V
      // 0f: astore 2
      // 10: getstatic com/facebook/internal/ImageDownloader.pendingRequests Ljava/util/Map;
      // 13: astore 0
      // 14: aload 0
      // 15: monitorenter
      // 16: getstatic com/facebook/internal/ImageDownloader.pendingRequests Ljava/util/Map;
      // 19: aload 2
      // 1a: invokeinterface java/util/Map.get (Ljava/lang/Object;)Ljava/lang/Object; 2
      // 1f: checkcast com/facebook/internal/ImageDownloader$DownloaderContext
      // 22: astore 3
      // 23: aload 3
      // 24: ifnull 52
      // 27: aload 3
      // 28: getfield com/facebook/internal/ImageDownloader$DownloaderContext.workItem Lcom/facebook/internal/WorkQueue$WorkItem;
      // 2b: invokeinterface com/facebook/internal/WorkQueue$WorkItem.cancel ()Z 1
      // 30: ifeq 43
      // 33: getstatic com/facebook/internal/ImageDownloader.pendingRequests Ljava/util/Map;
      // 36: aload 2
      // 37: invokeinterface java/util/Map.remove (Ljava/lang/Object;)Ljava/lang/Object; 2
      // 3c: pop
      // 3d: bipush 1
      // 3e: istore 1
      // 3f: aload 0
      // 40: monitorexit
      // 41: iload 1
      // 42: ireturn
      // 43: aload 3
      // 44: bipush 1
      // 45: putfield com/facebook/internal/ImageDownloader$DownloaderContext.isCancelled Z
      // 48: bipush 1
      // 49: istore 1
      // 4a: goto 3f
      // 4d: astore 2
      // 4e: aload 0
      // 4f: monitorexit
      // 50: aload 2
      // 51: athrow
      // 52: bipush 0
      // 53: istore 1
      // 54: goto 3f
      // try (12 -> 17): 39 null
      // try (19 -> 27): 39 null
      // try (29 -> 31): 39 null
      // try (33 -> 36): 39 null
      // try (40 -> 42): 39 null
   }

   public static void clearCache(Context var0) {
      ImageResponseCache.clearCache(var0);
      UrlRedirectCache.clearCache();
   }

   private static void download(ImageDownloader.RequestKey param0, Context param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 000: aconst_null
      // 001: astore 10
      // 003: aconst_null
      // 004: astore 8
      // 006: aconst_null
      // 007: astore 9
      // 009: bipush 1
      // 00a: istore 2
      // 00b: bipush 1
      // 00c: istore 3
      // 00d: new java/net/URL
      // 010: astore 5
      // 012: aload 5
      // 014: aload 0
      // 015: getfield com/facebook/internal/ImageDownloader$RequestKey.uri Landroid/net/Uri;
      // 018: invokevirtual android/net/Uri.toString ()Ljava/lang/String;
      // 01b: invokespecial java/net/URL.<init> (Ljava/lang/String;)V
      // 01e: aload 5
      // 020: invokevirtual java/net/URL.openConnection ()Ljava/net/URLConnection;
      // 023: invokestatic com/google/firebase/perf/network/FirebasePerfUrlConnection.instrument (Ljava/lang/Object;)Ljava/lang/Object;
      // 026: checkcast java/net/URLConnection
      // 029: checkcast java/net/HttpURLConnection
      // 02c: astore 5
      // 02e: aload 5
      // 030: bipush 0
      // 031: invokevirtual java/net/HttpURLConnection.setInstanceFollowRedirects (Z)V
      // 034: aload 5
      // 036: invokevirtual java/net/HttpURLConnection.getResponseCode ()I
      // 039: lookupswitch 35 3 200 295 301 194 302 194
      // 05c: aload 5
      // 05e: invokevirtual java/net/HttpURLConnection.getErrorStream ()Ljava/io/InputStream;
      // 061: astore 6
      // 063: aload 6
      // 065: astore 7
      // 067: aload 6
      // 069: astore 8
      // 06b: new java/lang/StringBuilder
      // 06e: astore 11
      // 070: aload 6
      // 072: astore 7
      // 074: aload 6
      // 076: astore 8
      // 078: aload 11
      // 07a: invokespecial java/lang/StringBuilder.<init> ()V
      // 07d: aload 6
      // 07f: ifnull 1ba
      // 082: aload 6
      // 084: astore 7
      // 086: aload 6
      // 088: astore 8
      // 08a: new java/io/InputStreamReader
      // 08d: astore 12
      // 08f: aload 6
      // 091: astore 7
      // 093: aload 6
      // 095: astore 8
      // 097: aload 12
      // 099: aload 6
      // 09b: invokespecial java/io/InputStreamReader.<init> (Ljava/io/InputStream;)V
      // 09e: aload 6
      // 0a0: astore 7
      // 0a2: aload 6
      // 0a4: astore 8
      // 0a6: sipush 128
      // 0a9: newarray 5
      // 0ab: astore 1
      // 0ac: aload 6
      // 0ae: astore 7
      // 0b0: aload 6
      // 0b2: astore 8
      // 0b4: aload 12
      // 0b6: aload 1
      // 0b7: bipush 0
      // 0b8: aload 1
      // 0b9: arraylength
      // 0ba: invokevirtual java/io/InputStreamReader.read ([CII)I
      // 0bd: istore 4
      // 0bf: iload 4
      // 0c1: ifle 182
      // 0c4: aload 6
      // 0c6: astore 7
      // 0c8: aload 6
      // 0ca: astore 8
      // 0cc: aload 11
      // 0ce: aload 1
      // 0cf: bipush 0
      // 0d0: iload 4
      // 0d2: invokevirtual java/lang/StringBuilder.append ([CII)Ljava/lang/StringBuilder;
      // 0d5: pop
      // 0d6: goto 0ac
      // 0d9: astore 1
      // 0da: aload 7
      // 0dc: astore 6
      // 0de: iload 3
      // 0df: istore 2
      // 0e0: aload 6
      // 0e2: invokestatic com/facebook/internal/Utility.closeQuietly (Ljava/io/Closeable;)V
      // 0e5: aload 5
      // 0e7: invokestatic com/facebook/internal/Utility.disconnectQuietly (Ljava/net/URLConnection;)V
      // 0ea: aload 9
      // 0ec: astore 7
      // 0ee: iload 2
      // 0ef: ifeq 0fa
      // 0f2: aload 0
      // 0f3: aload 1
      // 0f4: aload 7
      // 0f6: bipush 0
      // 0f7: invokestatic com/facebook/internal/ImageDownloader.issueResponse (Lcom/facebook/internal/ImageDownloader$RequestKey;Ljava/lang/Exception;Landroid/graphics/Bitmap;Z)V
      // 0fa: return
      // 0fb: aload 5
      // 0fd: ldc "location"
      // 0ff: invokevirtual java/net/HttpURLConnection.getHeaderField (Ljava/lang/String;)Ljava/lang/String;
      // 102: astore 1
      // 103: aload 1
      // 104: invokestatic com/facebook/internal/Utility.isNullOrEmpty (Ljava/lang/String;)Z
      // 107: ifne 1fd
      // 10a: aload 1
      // 10b: invokestatic android/net/Uri.parse (Ljava/lang/String;)Landroid/net/Uri;
      // 10e: astore 1
      // 10f: aload 0
      // 110: getfield com/facebook/internal/ImageDownloader$RequestKey.uri Landroid/net/Uri;
      // 113: aload 1
      // 114: invokestatic com/facebook/internal/UrlRedirectCache.cacheUriRedirect (Landroid/net/Uri;Landroid/net/Uri;)V
      // 117: aload 0
      // 118: invokestatic com/facebook/internal/ImageDownloader.removePendingRequest (Lcom/facebook/internal/ImageDownloader$RequestKey;)Lcom/facebook/internal/ImageDownloader$DownloaderContext;
      // 11b: astore 6
      // 11d: aload 6
      // 11f: ifnull 148
      // 122: aload 6
      // 124: getfield com/facebook/internal/ImageDownloader$DownloaderContext.isCancelled Z
      // 127: ifne 148
      // 12a: aload 6
      // 12c: getfield com/facebook/internal/ImageDownloader$DownloaderContext.request Lcom/facebook/internal/ImageRequest;
      // 12f: astore 6
      // 131: new com/facebook/internal/ImageDownloader$RequestKey
      // 134: astore 7
      // 136: aload 7
      // 138: aload 1
      // 139: aload 0
      // 13a: getfield com/facebook/internal/ImageDownloader$RequestKey.tag Ljava/lang/Object;
      // 13d: invokespecial com/facebook/internal/ImageDownloader$RequestKey.<init> (Landroid/net/Uri;Ljava/lang/Object;)V
      // 140: aload 6
      // 142: aload 7
      // 144: bipush 0
      // 145: invokestatic com/facebook/internal/ImageDownloader.enqueueCacheRead (Lcom/facebook/internal/ImageRequest;Lcom/facebook/internal/ImageDownloader$RequestKey;Z)V
      // 148: bipush 0
      // 149: istore 2
      // 14a: aconst_null
      // 14b: astore 1
      // 14c: aconst_null
      // 14d: astore 6
      // 14f: aload 10
      // 151: astore 7
      // 153: aload 6
      // 155: invokestatic com/facebook/internal/Utility.closeQuietly (Ljava/io/Closeable;)V
      // 158: aload 5
      // 15a: invokestatic com/facebook/internal/Utility.disconnectQuietly (Ljava/net/URLConnection;)V
      // 15d: goto 0ee
      // 160: aload 1
      // 161: aload 5
      // 163: invokestatic com/facebook/internal/ImageResponseCache.interceptAndCacheImageStream (Landroid/content/Context;Ljava/net/HttpURLConnection;)Ljava/io/InputStream;
      // 166: astore 6
      // 168: aload 6
      // 16a: astore 7
      // 16c: aload 6
      // 16e: astore 8
      // 170: aload 6
      // 172: invokestatic android/graphics/BitmapFactory.decodeStream (Ljava/io/InputStream;)Landroid/graphics/Bitmap;
      // 175: astore 1
      // 176: aconst_null
      // 177: astore 8
      // 179: aload 1
      // 17a: astore 7
      // 17c: aload 8
      // 17e: astore 1
      // 17f: goto 153
      // 182: aload 6
      // 184: astore 7
      // 186: aload 6
      // 188: astore 8
      // 18a: aload 12
      // 18c: invokestatic com/facebook/internal/Utility.closeQuietly (Ljava/io/Closeable;)V
      // 18f: aload 6
      // 191: astore 7
      // 193: aload 6
      // 195: astore 8
      // 197: new com/facebook/FacebookException
      // 19a: dup
      // 19b: aload 11
      // 19d: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 1a0: invokespecial com/facebook/FacebookException.<init> (Ljava/lang/String;)V
      // 1a3: astore 1
      // 1a4: aload 10
      // 1a6: astore 7
      // 1a8: goto 153
      // 1ab: astore 0
      // 1ac: aload 5
      // 1ae: astore 1
      // 1af: aload 8
      // 1b1: invokestatic com/facebook/internal/Utility.closeQuietly (Ljava/io/Closeable;)V
      // 1b4: aload 1
      // 1b5: invokestatic com/facebook/internal/Utility.disconnectQuietly (Ljava/net/URLConnection;)V
      // 1b8: aload 0
      // 1b9: athrow
      // 1ba: aload 6
      // 1bc: astore 7
      // 1be: aload 6
      // 1c0: astore 8
      // 1c2: aload 11
      // 1c4: aload 1
      // 1c5: getstatic com/facebook/R$string.com_facebook_image_download_unknown_error I
      // 1c8: invokevirtual android/content/Context.getString (I)Ljava/lang/String;
      // 1cb: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 1ce: pop
      // 1cf: goto 18f
      // 1d2: astore 0
      // 1d3: aconst_null
      // 1d4: astore 1
      // 1d5: goto 1af
      // 1d8: astore 0
      // 1d9: aload 5
      // 1db: astore 1
      // 1dc: goto 1af
      // 1df: astore 1
      // 1e0: aconst_null
      // 1e1: astore 6
      // 1e3: aconst_null
      // 1e4: astore 5
      // 1e6: iload 3
      // 1e7: istore 2
      // 1e8: goto 0e0
      // 1eb: astore 1
      // 1ec: aconst_null
      // 1ed: astore 6
      // 1ef: iload 3
      // 1f0: istore 2
      // 1f1: goto 0e0
      // 1f4: astore 1
      // 1f5: aconst_null
      // 1f6: astore 6
      // 1f8: bipush 0
      // 1f9: istore 2
      // 1fa: goto 0e0
      // 1fd: bipush 0
      // 1fe: istore 2
      // 1ff: aconst_null
      // 200: astore 1
      // 201: aconst_null
      // 202: astore 6
      // 204: aload 10
      // 206: astore 7
      // 208: goto 153
      // try (10 -> 23): 223 java/io/IOException
      // try (10 -> 23): 215 null
      // try (23 -> 29): 231 java/io/IOException
      // try (23 -> 29): 219 null
      // try (29 -> 32): 231 java/io/IOException
      // try (29 -> 32): 219 null
      // try (36 -> 38): 90 java/io/IOException
      // try (36 -> 38): 195 null
      // try (42 -> 44): 90 java/io/IOException
      // try (42 -> 44): 195 null
      // try (50 -> 52): 90 java/io/IOException
      // try (50 -> 52): 195 null
      // try (56 -> 59): 90 java/io/IOException
      // try (56 -> 59): 195 null
      // try (63 -> 66): 90 java/io/IOException
      // try (63 -> 66): 195 null
      // try (70 -> 77): 90 java/io/IOException
      // try (70 -> 77): 195 null
      // try (83 -> 89): 90 java/io/IOException
      // try (83 -> 89): 195 null
      // try (109 -> 126): 237 java/io/IOException
      // try (109 -> 126): 219 null
      // try (128 -> 145): 237 java/io/IOException
      // try (128 -> 145): 219 null
      // try (158 -> 162): 231 java/io/IOException
      // try (158 -> 162): 219 null
      // try (166 -> 169): 90 java/io/IOException
      // try (166 -> 169): 195 null
      // try (180 -> 182): 90 java/io/IOException
      // try (180 -> 182): 195 null
      // try (186 -> 192): 90 java/io/IOException
      // try (186 -> 192): 195 null
      // try (208 -> 214): 90 java/io/IOException
      // try (208 -> 214): 195 null
   }

   public static void downloadAsync(ImageRequest param0) {
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
      // 01: ifnonnull 05
      // 04: return
      // 05: new com/facebook/internal/ImageDownloader$RequestKey
      // 08: dup
      // 09: aload 0
      // 0a: invokevirtual com/facebook/internal/ImageRequest.getImageUri ()Landroid/net/Uri;
      // 0d: aload 0
      // 0e: invokevirtual com/facebook/internal/ImageRequest.getCallerTag ()Ljava/lang/Object;
      // 11: invokespecial com/facebook/internal/ImageDownloader$RequestKey.<init> (Landroid/net/Uri;Ljava/lang/Object;)V
      // 14: astore 2
      // 15: getstatic com/facebook/internal/ImageDownloader.pendingRequests Ljava/util/Map;
      // 18: astore 1
      // 19: aload 1
      // 1a: monitorenter
      // 1b: getstatic com/facebook/internal/ImageDownloader.pendingRequests Ljava/util/Map;
      // 1e: aload 2
      // 1f: invokeinterface java/util/Map.get (Ljava/lang/Object;)Ljava/lang/Object; 2
      // 24: checkcast com/facebook/internal/ImageDownloader$DownloaderContext
      // 27: astore 3
      // 28: aload 3
      // 29: ifnull 49
      // 2c: aload 3
      // 2d: aload 0
      // 2e: putfield com/facebook/internal/ImageDownloader$DownloaderContext.request Lcom/facebook/internal/ImageRequest;
      // 31: aload 3
      // 32: bipush 0
      // 33: putfield com/facebook/internal/ImageDownloader$DownloaderContext.isCancelled Z
      // 36: aload 3
      // 37: getfield com/facebook/internal/ImageDownloader$DownloaderContext.workItem Lcom/facebook/internal/WorkQueue$WorkItem;
      // 3a: invokeinterface com/facebook/internal/WorkQueue$WorkItem.moveToFront ()V 1
      // 3f: aload 1
      // 40: monitorexit
      // 41: goto 04
      // 44: astore 0
      // 45: aload 1
      // 46: monitorexit
      // 47: aload 0
      // 48: athrow
      // 49: aload 0
      // 4a: aload 2
      // 4b: aload 0
      // 4c: invokevirtual com/facebook/internal/ImageRequest.isCachedRedirectAllowed ()Z
      // 4f: invokestatic com/facebook/internal/ImageDownloader.enqueueCacheRead (Lcom/facebook/internal/ImageRequest;Lcom/facebook/internal/ImageDownloader$RequestKey;Z)V
      // 52: goto 3f
      // try (15 -> 20): 34 null
      // try (22 -> 31): 34 null
      // try (31 -> 33): 34 null
      // try (35 -> 37): 34 null
      // try (39 -> 44): 34 null
   }

   private static void enqueueCacheRead(ImageRequest var0, ImageDownloader.RequestKey var1, boolean var2) {
      enqueueRequest(var0, var1, cacheReadQueue, new ImageDownloader.CacheReadWorkItem(var0.getContext(), var1, var2));
   }

   private static void enqueueDownload(ImageRequest var0, ImageDownloader.RequestKey var1) {
      enqueueRequest(var0, var1, downloadQueue, new ImageDownloader.DownloadImageWorkItem(var0.getContext(), var1));
   }

   private static void enqueueRequest(ImageRequest param0, ImageDownloader.RequestKey param1, WorkQueue param2, Runnable param3) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.NullPointerException: Cannot read field "id" because the return value of "org.jetbrains.java.decompiler.modules.decompiler.flow.FlattenStatementsHelper.getDirectNode(org.jetbrains.java.decompiler.modules.decompiler.stats.Statement)" is null
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:186)
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
      // 00: getstatic com/facebook/internal/ImageDownloader.pendingRequests Ljava/util/Map;
      // 03: astore 4
      // 05: aload 4
      // 07: monitorenter
      // 08: new com/facebook/internal/ImageDownloader$DownloaderContext
      // 0b: astore 5
      // 0d: aload 5
      // 0f: aconst_null
      // 10: invokespecial com/facebook/internal/ImageDownloader$DownloaderContext.<init> (Lcom/facebook/internal/ImageDownloader$1;)V
      // 13: aload 5
      // 15: aload 0
      // 16: putfield com/facebook/internal/ImageDownloader$DownloaderContext.request Lcom/facebook/internal/ImageRequest;
      // 19: getstatic com/facebook/internal/ImageDownloader.pendingRequests Ljava/util/Map;
      // 1c: aload 1
      // 1d: aload 5
      // 1f: invokeinterface java/util/Map.put (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; 3
      // 24: pop
      // 25: aload 5
      // 27: aload 2
      // 28: aload 3
      // 29: invokevirtual com/facebook/internal/WorkQueue.addActiveWorkItem (Ljava/lang/Runnable;)Lcom/facebook/internal/WorkQueue$WorkItem;
      // 2c: putfield com/facebook/internal/ImageDownloader$DownloaderContext.workItem Lcom/facebook/internal/WorkQueue$WorkItem;
      // 2f: aload 4
      // 31: monitorexit
      // 32: return
      // 33: astore 0
      // 34: aload 4
      // 36: monitorexit
      // 37: aload 0
      // 38: athrow
      // try (4 -> 24): 25 null
      // try (26 -> 28): 25 null
   }

   private static Handler getHandler() {
      synchronized (ImageDownloader.class) {
         if (handler == null) {
            Handler var0 = new Handler(Looper.getMainLooper());
            handler = var0;
         }

         return handler;
      }
   }

   private static void issueResponse(ImageDownloader.RequestKey var0, Exception var1, Bitmap var2, boolean var3) {
      ImageDownloader.DownloaderContext var5 = removePendingRequest(var0);
      if (var5 != null && !var5.isCancelled) {
         ImageRequest var6 = var5.request;
         ImageRequest.Callback var4 = var6.getCallback();
         if (var4 != null) {
            getHandler().post(new Runnable(var6, var1, var3, var2, var4) {
               final Bitmap val$bitmap;
               final ImageRequest.Callback val$callback;
               final Exception val$error;
               final boolean val$isCachedRedirect;
               final ImageRequest val$request;

               {
                  this.val$request = var1;
                  this.val$error = var2x;
                  this.val$isCachedRedirect = var3x;
                  this.val$bitmap = var4x;
                  this.val$callback = var5x;
               }

               @Override
               public void run() {
                  ImageResponse var1x = new ImageResponse(this.val$request, this.val$error, this.val$isCachedRedirect, this.val$bitmap);
                  this.val$callback.onCompleted(var1x);
               }
            });
         }
      }
   }

   public static void prioritizeRequest(ImageRequest param0) {
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
      // 00: new com/facebook/internal/ImageDownloader$RequestKey
      // 03: dup
      // 04: aload 0
      // 05: invokevirtual com/facebook/internal/ImageRequest.getImageUri ()Landroid/net/Uri;
      // 08: aload 0
      // 09: invokevirtual com/facebook/internal/ImageRequest.getCallerTag ()Ljava/lang/Object;
      // 0c: invokespecial com/facebook/internal/ImageDownloader$RequestKey.<init> (Landroid/net/Uri;Ljava/lang/Object;)V
      // 0f: astore 1
      // 10: getstatic com/facebook/internal/ImageDownloader.pendingRequests Ljava/util/Map;
      // 13: astore 0
      // 14: aload 0
      // 15: monitorenter
      // 16: getstatic com/facebook/internal/ImageDownloader.pendingRequests Ljava/util/Map;
      // 19: aload 1
      // 1a: invokeinterface java/util/Map.get (Ljava/lang/Object;)Ljava/lang/Object; 2
      // 1f: checkcast com/facebook/internal/ImageDownloader$DownloaderContext
      // 22: astore 1
      // 23: aload 1
      // 24: ifnull 30
      // 27: aload 1
      // 28: getfield com/facebook/internal/ImageDownloader$DownloaderContext.workItem Lcom/facebook/internal/WorkQueue$WorkItem;
      // 2b: invokeinterface com/facebook/internal/WorkQueue$WorkItem.moveToFront ()V 1
      // 30: aload 0
      // 31: monitorexit
      // 32: return
      // 33: astore 1
      // 34: aload 0
      // 35: monitorexit
      // 36: aload 1
      // 37: athrow
      // try (12 -> 17): 25 null
      // try (19 -> 22): 25 null
      // try (22 -> 24): 25 null
      // try (26 -> 28): 25 null
   }

   private static void readFromCache(ImageDownloader.RequestKey var0, Context var1, boolean var2) {
      InputStream var8;
      label27: {
         boolean var3 = false;
         if (var2) {
            Uri var4 = UrlRedirectCache.getRedirectedUri(var0.uri);
            if (var4 != null) {
               var8 = ImageResponseCache.getCachedImageStream(var4, var1);
               var2 = var3;
               if (var8 != null) {
                  var2 = true;
               }
               break label27;
            }
         }

         var2 = false;
         var8 = null;
      }

      if (!var2) {
         var8 = ImageResponseCache.getCachedImageStream(var0.uri, var1);
      }

      if (var8 != null) {
         Bitmap var5 = BitmapFactory.decodeStream(var8);
         Utility.closeQuietly(var8);
         issueResponse(var0, null, var5, var2);
      } else {
         ImageDownloader.DownloaderContext var6 = removePendingRequest(var0);
         if (var6 != null && !var6.isCancelled) {
            enqueueDownload(var6.request, var0);
         }
      }
   }

   private static ImageDownloader.DownloaderContext removePendingRequest(ImageDownloader.RequestKey param0) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.NullPointerException: Cannot read field "id" because the return value of "org.jetbrains.java.decompiler.modules.decompiler.flow.FlattenStatementsHelper.getDirectNode(org.jetbrains.java.decompiler.modules.decompiler.stats.Statement)" is null
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:186)
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
      // 00: getstatic com/facebook/internal/ImageDownloader.pendingRequests Ljava/util/Map;
      // 03: astore 1
      // 04: aload 1
      // 05: monitorenter
      // 06: getstatic com/facebook/internal/ImageDownloader.pendingRequests Ljava/util/Map;
      // 09: aload 0
      // 0a: invokeinterface java/util/Map.remove (Ljava/lang/Object;)Ljava/lang/Object; 2
      // 0f: checkcast com/facebook/internal/ImageDownloader$DownloaderContext
      // 12: astore 0
      // 13: aload 1
      // 14: monitorexit
      // 15: aload 0
      // 16: areturn
      // 17: astore 0
      // 18: aload 1
      // 19: monitorexit
      // 1a: aload 0
      // 1b: athrow
      // try (4 -> 11): 13 null
      // try (14 -> 16): 13 null
   }

   private static class CacheReadWorkItem implements Runnable {
      private boolean allowCachedRedirects;
      private Context context;
      private ImageDownloader.RequestKey key;

      CacheReadWorkItem(Context var1, ImageDownloader.RequestKey var2, boolean var3) {
         this.context = var1;
         this.key = var2;
         this.allowCachedRedirects = var3;
      }

      @Override
      public void run() {
         ImageDownloader.readFromCache(this.key, this.context, this.allowCachedRedirects);
      }
   }

   private static class DownloadImageWorkItem implements Runnable {
      private Context context;
      private ImageDownloader.RequestKey key;

      DownloadImageWorkItem(Context var1, ImageDownloader.RequestKey var2) {
         this.context = var1;
         this.key = var2;
      }

      @Override
      public void run() {
         ImageDownloader.download(this.key, this.context);
      }
   }

   private static class DownloaderContext {
      boolean isCancelled;
      ImageRequest request;
      WorkQueue.WorkItem workItem;

      private DownloaderContext() {
      }
   }

   private static class RequestKey {
      private static final int HASH_MULTIPLIER = 37;
      private static final int HASH_SEED = 29;
      Object tag;
      Uri uri;

      RequestKey(Uri var1, Object var2) {
         this.uri = var1;
         this.tag = var2;
      }

      @Override
      public boolean equals(Object var1) {
         boolean var3 = false;
         boolean var2 = var3;
         if (var1 != null) {
            var2 = var3;
            if (var1 instanceof ImageDownloader.RequestKey) {
               var1 = var1;
               var2 = var3;
               if (var1.uri == this.uri) {
                  var2 = var3;
                  if (var1.tag == this.tag) {
                     var2 = true;
                  }
               }
            }
         }

         return var2;
      }

      @Override
      public int hashCode() {
         return (this.uri.hashCode() + 1073) * 37 + this.tag.hashCode();
      }
   }
}
