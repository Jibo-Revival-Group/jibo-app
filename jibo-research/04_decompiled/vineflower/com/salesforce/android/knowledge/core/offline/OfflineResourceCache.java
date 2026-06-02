package com.salesforce.android.knowledge.core.offline;

import com.jakewharton.disklrucache.DiskLruCache;
import com.salesforce.android.service.common.utilities.control.Async;
import com.salesforce.android.service.common.utilities.control.BasicAsync;
import com.salesforce.android.service.common.utilities.control.ResultReceiver;
import com.salesforce.android.service.common.utilities.functional.Function;
import com.salesforce.android.service.common.utilities.hashing.Murmur3_32;
import com.salesforce.android.service.common.utilities.logging.ServiceLogger;
import com.salesforce.android.service.common.utilities.logging.ServiceLogging;
import com.salesforce.android.service.common.utilities.threading.Job;
import com.salesforce.android.service.common.utilities.threading.JobQueue;
import com.salesforce.android.service.common.utilities.threading.PriorityThreadFactory;
import com.salesforce.android.service.common.utilities.validation.Arguments;
import com.salesforce.androidsdk.analytics.security.Encryptor;
import com.salesforce.androidsdk.app.SalesforceSDKManager;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Executors;
import okio.ByteString;
import okio.Okio;
import okio.Source;

public class OfflineResourceCache {
   static final ServiceLogger a = ServiceLogging.a(OfflineResourceCache.class);
   DiskLruCache b;
   final JobQueue c;
   final OfflineResourceConfig d;

   OfflineResourceCache(OfflineResourceConfig var1, JobQueue var2) {
      this.d = var1;
      this.c = var2;
   }

   public static OfflineResourceCache a(OfflineResourceConfig var0) {
      return new OfflineResourceCache(var0, new JobQueue(Executors.newFixedThreadPool(var0.e(), PriorityThreadFactory.a())));
   }

   static String b(String var0) {
      return Integer.toHexString(Murmur3_32.a(var0, 129492964));
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   private InputStream c(String var1) {
      Object var2 = null;

      try {
         var6 = this.b.a(var1);
      } catch (Exception var4) {
         a.d("Could not fetch cached bitmap: {}", var4);
         return (InputStream)var2;
      }

      InputStream var5;
      if (var6 == null) {
         var5 = (InputStream)var2;
      } else {
         try {
            var5 = var6.a(0);
         } catch (Exception var3) {
            a.d("Could not fetch cached bitmap: {}", var3);
            var5 = (InputStream)var2;
         }
      }

      return var5;
   }

   public Async<OfflineResourceCache> a() {
      Async var1;
      if (!this.d.b()) {
         var1 = BasicAsync.c(this);
      } else if (this.b != null) {
         var1 = BasicAsync.c(this);
      } else {
         var1 = this.c.a(new OfflineResourceCache.InitJob(this.d)).a(new Function<DiskLruCache, OfflineResourceCache>(this) {
            final OfflineResourceCache a;

            {
               this.a = var1;
            }

            public OfflineResourceCache a(DiskLruCache var1) {
               this.a.b = var1;
               return this.a;
            }
         });
      }

      return var1;
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   public InputStream a(String var1) {
      Object var3 = null;
      ByteArrayInputStream var2;
      if (!this.d.b()) {
         var2 = (InputStream)var3;
      } else {
         Arguments.a(this.b, "You must call init and wait for the result prior to using this class");
         InputStream var4 = this.c(b(var1));
         var2 = (InputStream)var3;
         if (var4 != null) {
            String var9 = SalesforceSDKManager.a().c(null);

            try {
               var10 = Encryptor.a(Okio.a(Okio.a(var4)).p().b(), var9);
            } catch (IOException var7) {
               a.e("Error reading Encrypted cached image, aborting. {}", var7.getMessage());
               var2 = (InputStream)var3;
               return var2;
            }

            if (var10 != null) {
               try {
                  ByteString var8 = ByteString.b(var10);
                  var2 = new ByteArrayInputStream(var8.i());
               } catch (IOException var5) {
                  a.e("Error reading Encrypted cached image, aborting. {}", var5.getMessage());
                  var2 = (InputStream)var3;
               }
            } else {
               try {
                  this.b.c(b(var1));
                  a.b("Error decrypting cached resources at {} ", var1);
               } catch (IOException var6) {
                  a.e("Error reading Encrypted cached image, aborting. {}", var6.getMessage());
                  var2 = (InputStream)var3;
                  return var2;
               }

               var2 = (InputStream)var3;
            }
         }
      }

      return var2;
   }

   public boolean a(String param1, Source param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 000: aconst_null
      // 001: astore 9
      // 003: aconst_null
      // 004: astore 8
      // 006: aconst_null
      // 007: astore 6
      // 009: bipush 1
      // 00a: istore 4
      // 00c: aload 0
      // 00d: getfield com/salesforce/android/knowledge/core/offline/OfflineResourceCache.b Lcom/jakewharton/disklrucache/DiskLruCache;
      // 010: ldc "You must call init and wait for the result prior to using this class"
      // 012: invokestatic com/salesforce/android/service/common/utilities/validation/Arguments.a (Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;
      // 015: pop
      // 016: aload 1
      // 017: invokestatic com/salesforce/android/knowledge/core/offline/OfflineResourceCache.b (Ljava/lang/String;)Ljava/lang/String;
      // 01a: astore 10
      // 01c: invokestatic com/salesforce/androidsdk/app/SalesforceSDKManager.a ()Lcom/salesforce/androidsdk/app/SalesforceSDKManager;
      // 01f: aconst_null
      // 020: invokevirtual com/salesforce/androidsdk/app/SalesforceSDKManager.c (Ljava/lang/String;)Ljava/lang/String;
      // 023: astore 11
      // 025: aload 9
      // 027: astore 5
      // 029: aload 0
      // 02a: getfield com/salesforce/android/knowledge/core/offline/OfflineResourceCache.b Lcom/jakewharton/disklrucache/DiskLruCache;
      // 02d: aload 10
      // 02f: invokevirtual com/jakewharton/disklrucache/DiskLruCache.b (Ljava/lang/String;)Lcom/jakewharton/disklrucache/DiskLruCache$Editor;
      // 032: astore 7
      // 034: aload 9
      // 036: astore 5
      // 038: aload 8
      // 03a: astore 6
      // 03c: aload 2
      // 03d: invokestatic okio/Okio.a (Lokio/Source;)Lokio/BufferedSource;
      // 040: invokeinterface okio/BufferedSource.p ()Lokio/ByteString; 1
      // 045: invokevirtual okio/ByteString.b ()Ljava/lang/String;
      // 048: aload 11
      // 04a: invokestatic com/salesforce/androidsdk/analytics/security/Encryptor.b (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
      // 04d: invokestatic okio/ByteString.b (Ljava/lang/String;)Lokio/ByteString;
      // 050: astore 11
      // 052: aload 9
      // 054: astore 5
      // 056: aload 8
      // 058: astore 6
      // 05a: aload 7
      // 05c: bipush 0
      // 05d: invokevirtual com/jakewharton/disklrucache/DiskLruCache$Editor.a (I)Ljava/io/OutputStream;
      // 060: invokestatic okio/Okio.a (Ljava/io/OutputStream;)Lokio/Sink;
      // 063: invokestatic okio/Okio.a (Lokio/Sink;)Lokio/BufferedSink;
      // 066: astore 2
      // 067: aload 2
      // 068: astore 5
      // 06a: aload 2
      // 06b: astore 6
      // 06d: aload 2
      // 06e: aload 11
      // 070: invokeinterface okio/BufferedSink.b (Lokio/ByteString;)Lokio/BufferedSink; 2
      // 075: pop
      // 076: aload 2
      // 077: astore 5
      // 079: aload 2
      // 07a: astore 6
      // 07c: aload 7
      // 07e: invokevirtual com/jakewharton/disklrucache/DiskLruCache$Editor.a ()V
      // 081: aload 2
      // 082: astore 5
      // 084: aload 2
      // 085: astore 6
      // 087: getstatic com/salesforce/android/knowledge/core/offline/OfflineResourceCache.a Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;
      // 08a: ldc "Cached resource {} at key {}, total cache size is now {}"
      // 08c: bipush 3
      // 08d: anewarray 4
      // 090: dup
      // 091: bipush 0
      // 092: aload 1
      // 093: aastore
      // 094: dup
      // 095: bipush 1
      // 096: aload 10
      // 098: aastore
      // 099: dup
      // 09a: bipush 2
      // 09b: aload 0
      // 09c: getfield com/salesforce/android/knowledge/core/offline/OfflineResourceCache.b Lcom/jakewharton/disklrucache/DiskLruCache;
      // 09f: invokevirtual com/jakewharton/disklrucache/DiskLruCache.a ()J
      // 0a2: invokestatic java/lang/Long.valueOf (J)Ljava/lang/Long;
      // 0a5: aastore
      // 0a6: invokeinterface com/salesforce/android/service/common/utilities/logging/ServiceLogger.a (Ljava/lang/String;[Ljava/lang/Object;)V 3
      // 0ab: iload 4
      // 0ad: istore 3
      // 0ae: aload 2
      // 0af: ifnull 0bb
      // 0b2: aload 2
      // 0b3: invokeinterface okio/BufferedSink.close ()V 1
      // 0b8: iload 4
      // 0ba: istore 3
      // 0bb: iload 3
      // 0bc: ireturn
      // 0bd: astore 2
      // 0be: aconst_null
      // 0bf: astore 2
      // 0c0: aload 6
      // 0c2: astore 5
      // 0c4: getstatic com/salesforce/android/knowledge/core/offline/OfflineResourceCache.a Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;
      // 0c7: ldc "Resource {} could not be written to cache at key {}."
      // 0c9: bipush 2
      // 0ca: anewarray 4
      // 0cd: dup
      // 0ce: bipush 0
      // 0cf: aload 1
      // 0d0: aastore
      // 0d1: dup
      // 0d2: bipush 1
      // 0d3: aload 10
      // 0d5: aastore
      // 0d6: invokeinterface com/salesforce/android/service/common/utilities/logging/ServiceLogger.d (Ljava/lang/String;[Ljava/lang/Object;)V 3
      // 0db: aload 2
      // 0dc: ifnull 0e7
      // 0df: aload 6
      // 0e1: astore 5
      // 0e3: aload 2
      // 0e4: invokevirtual com/jakewharton/disklrucache/DiskLruCache$Editor.b ()V
      // 0e7: aload 6
      // 0e9: ifnull 0f3
      // 0ec: aload 6
      // 0ee: invokeinterface okio/BufferedSink.close ()V 1
      // 0f3: bipush 0
      // 0f4: istore 3
      // 0f5: goto 0bb
      // 0f8: astore 1
      // 0f9: aload 5
      // 0fb: ifnull 105
      // 0fe: aload 5
      // 100: invokeinterface okio/BufferedSink.close ()V 1
      // 105: aload 1
      // 106: athrow
      // 107: astore 1
      // 108: iload 4
      // 10a: istore 3
      // 10b: goto 0bb
      // 10e: astore 1
      // 10f: goto 0e7
      // 112: astore 1
      // 113: goto 0f3
      // 116: astore 2
      // 117: goto 105
      // 11a: astore 2
      // 11b: aload 7
      // 11d: astore 2
      // 11e: goto 0c0
      // try (22 -> 27): 97 java/io/IOException
      // try (22 -> 27): 128 null
      // try (31 -> 39): 145 java/io/IOException
      // try (31 -> 39): 128 null
      // try (43 -> 49): 145 java/io/IOException
      // try (43 -> 49): 128 null
      // try (53 -> 57): 145 java/io/IOException
      // try (53 -> 57): 128 null
      // try (61 -> 63): 145 java/io/IOException
      // try (61 -> 63): 128 null
      // try (67 -> 87): 145 java/io/IOException
      // try (67 -> 87): 128 null
      // try (91 -> 93): 135 java/io/IOException
      // try (102 -> 115): 128 null
      // try (119 -> 121): 139 java/io/IOException
      // try (119 -> 121): 128 null
      // try (123 -> 125): 141 java/io/IOException
      // try (131 -> 133): 143 java/io/IOException
   }

   public Async<Void> b() {
      Arguments.a(this.b, "You must call init and wait for the result prior to using this class");
      return this.c.a(new OfflineResourceCache.DeleteJob(this.b));
   }

   private static class DeleteJob implements Job<Void> {
      private final DiskLruCache a;

      DeleteJob(DiskLruCache var1) {
         this.a = var1;
      }

      @Override
      public void a(ResultReceiver<Void> var1) {
         OfflineResourceCache.a.c("Deleting disk cache of size {}", this.a.a());

         try {
            this.a.b();
         } catch (IOException var3) {
            OfflineResourceCache.a.d("Could not delete disk cache {}", var3);
            var1.b(var3);
            return;
         }

         var1.b();
      }
   }

   private static class InitJob implements Job<DiskLruCache> {
      private final OfflineResourceConfig a;

      InitJob(OfflineResourceConfig var1) {
         this.a = var1;
      }

      @Override
      public void a(ResultReceiver<DiskLruCache> var1) {
         DiskLruCache var2;
         try {
            var2 = DiskLruCache.a(this.a.d(), 0, 1, this.a.c());
         } catch (Exception var3) {
            OfflineResourceCache.a.d("Exception initializing OfflineImageCache: {}", var3);
            var1.b(var3);
            return;
         }

         var1.b(var2).b();
      }
   }
}
