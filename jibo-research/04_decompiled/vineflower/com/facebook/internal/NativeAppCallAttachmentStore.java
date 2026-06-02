package com.facebook.internal;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.net.Uri;
import android.util.Log;
import com.facebook.FacebookContentProvider;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.UUID;

public final class NativeAppCallAttachmentStore {
   static final String ATTACHMENTS_DIR_NAME = "com.facebook.NativeAppCallAttachmentStore.files";
   private static final String TAG = NativeAppCallAttachmentStore.class.getName();
   private static File attachmentsDirectory;

   private NativeAppCallAttachmentStore() {
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   public static void addAttachments(Collection<NativeAppCallAttachmentStore.Attachment> var0) {
      if (var0 != null && var0.size() != 0) {
         if (attachmentsDirectory == null) {
            cleanupAllAttachments();
         }

         ensureAttachmentsDirectoryExists();
         ArrayList var1 = new ArrayList();

         label67: {
            Iterator var3;
            try {
               var3 = var0.iterator();
            } catch (IOException var7) {
               var8 = var7;
               Log.e(TAG, "Got unexpected exception:" + var7);
               Iterator var10 = var1.iterator();
               break label67;
            }

            while (true) {
               File var2;
               try {
                  while (true) {
                     if (!var3.hasNext()) {
                        return;
                     }

                     var9 = (NativeAppCallAttachmentStore.Attachment)var3.next();
                     if (var9.shouldCreateFile) {
                        var2 = getAttachmentFile(var9.callId, var9.attachmentName, true);
                        var1.add(var2);
                        if (var9.bitmap != null) {
                           processAttachmentBitmap(var9.bitmap, var2);
                           continue;
                        }
                        break;
                     }
                  }
               } catch (IOException var6) {
                  var8 = var6;
                  Log.e(TAG, "Got unexpected exception:" + var6);
                  Iterator var12 = var1.iterator();
                  break;
               }

               try {
                  if (var9.originalUri != null) {
                     processAttachmentFile(var9.originalUri, var9.isContentUri, var2);
                  }
               } catch (IOException var5) {
                  var8 = var5;
                  Log.e(TAG, "Got unexpected exception:" + var5);
                  break;
               }
            }
         }

         for (File var11 : var1) {
            try {
               var11.delete();
            } catch (Exception var4) {
            }
         }

         throw new FacebookException(var8);
      }
   }

   public static void cleanupAllAttachments() {
      Utility.deleteDirectory(getAttachmentsDirectory());
   }

   public static void cleanupAttachmentsForCall(UUID var0) {
      File var1 = getAttachmentsDirectoryForCall(var0, false);
      if (var1 != null) {
         Utility.deleteDirectory(var1);
      }
   }

   public static NativeAppCallAttachmentStore.Attachment createAttachment(UUID var0, Bitmap var1) {
      Validate.notNull(var0, "callId");
      Validate.notNull(var1, "attachmentBitmap");
      return new NativeAppCallAttachmentStore.Attachment(var0, var1, null);
   }

   public static NativeAppCallAttachmentStore.Attachment createAttachment(UUID var0, Uri var1) {
      Validate.notNull(var0, "callId");
      Validate.notNull(var1, "attachmentUri");
      return new NativeAppCallAttachmentStore.Attachment(var0, null, var1);
   }

   static File ensureAttachmentsDirectoryExists() {
      File var0 = getAttachmentsDirectory();
      var0.mkdirs();
      return var0;
   }

   static File getAttachmentFile(UUID var0, String var1, boolean var2) throws IOException {
      Object var3 = null;
      File var4 = getAttachmentsDirectoryForCall(var0, var2);
      File var6;
      if (var4 == null) {
         var6 = (File)var3;
      } else {
         try {
            var6 = new File(var4, URLEncoder.encode(var1, "UTF-8"));
         } catch (UnsupportedEncodingException var5) {
            var6 = (File)var3;
         }
      }

      return var6;
   }

   static File getAttachmentsDirectory() {
      synchronized (NativeAppCallAttachmentStore.class) {
         if (attachmentsDirectory == null) {
            File var0 = new File(FacebookSdk.getApplicationContext().getCacheDir(), "com.facebook.NativeAppCallAttachmentStore.files");
            attachmentsDirectory = var0;
         }

         return attachmentsDirectory;
      }
   }

   static File getAttachmentsDirectoryForCall(UUID var0, boolean var1) {
      File var3;
      if (attachmentsDirectory == null) {
         var3 = null;
      } else {
         File var2 = new File(attachmentsDirectory, var0.toString());
         var3 = var2;
         if (var1) {
            var3 = var2;
            if (!var2.exists()) {
               var2.mkdirs();
               var3 = var2;
            }
         }
      }

      return var3;
   }

   public static File openAttachment(UUID var0, String var1) throws FileNotFoundException {
      if (!Utility.isNullOrEmpty(var1) && var0 != null) {
         try {
            return getAttachmentFile(var0, var1, false);
         } catch (IOException var2) {
            throw new FileNotFoundException();
         }
      } else {
         throw new FileNotFoundException();
      }
   }

   private static void processAttachmentBitmap(Bitmap var0, File var1) throws IOException {
      FileOutputStream var4 = new FileOutputStream(var1);

      try {
         var0.compress(CompressFormat.JPEG, 100, var4);
      } finally {
         Utility.closeQuietly(var4);
      }
   }

   private static void processAttachmentFile(Uri param0, boolean param1, File param2) throws IOException {
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
      // 00: new java/io/FileOutputStream
      // 03: dup
      // 04: aload 2
      // 05: invokespecial java/io/FileOutputStream.<init> (Ljava/io/File;)V
      // 08: astore 3
      // 09: iload 1
      // 0a: ifne 26
      // 0d: new java/io/FileInputStream
      // 10: astore 2
      // 11: aload 2
      // 12: aload 0
      // 13: invokevirtual android/net/Uri.getPath ()Ljava/lang/String;
      // 16: invokespecial java/io/FileInputStream.<init> (Ljava/lang/String;)V
      // 19: aload 2
      // 1a: astore 0
      // 1b: aload 0
      // 1c: aload 3
      // 1d: invokestatic com/facebook/internal/Utility.copyAndCloseInputStream (Ljava/io/InputStream;Ljava/io/OutputStream;)I
      // 20: pop
      // 21: aload 3
      // 22: invokestatic com/facebook/internal/Utility.closeQuietly (Ljava/io/Closeable;)V
      // 25: return
      // 26: invokestatic com/facebook/FacebookSdk.getApplicationContext ()Landroid/content/Context;
      // 29: invokevirtual android/content/Context.getContentResolver ()Landroid/content/ContentResolver;
      // 2c: aload 0
      // 2d: invokevirtual android/content/ContentResolver.openInputStream (Landroid/net/Uri;)Ljava/io/InputStream;
      // 30: astore 0
      // 31: goto 1b
      // 34: astore 0
      // 35: aload 3
      // 36: invokestatic com/facebook/internal/Utility.closeQuietly (Ljava/io/Closeable;)V
      // 39: aload 0
      // 3a: athrow
      // try (7 -> 13): 28 null
      // try (15 -> 19): 28 null
      // try (22 -> 27): 28 null
   }

   public static final class Attachment {
      private final String attachmentName;
      private final String attachmentUrl;
      private Bitmap bitmap;
      private final UUID callId;
      private boolean isContentUri;
      private Uri originalUri;
      private boolean shouldCreateFile;

      private Attachment(UUID var1, Bitmap var2, Uri var3) {
         boolean var4 = true;
         super();
         this.callId = var1;
         this.bitmap = var2;
         this.originalUri = var3;
         if (var3 != null) {
            String var6 = var3.getScheme();
            if ("content".equalsIgnoreCase(var6)) {
               this.isContentUri = true;
               if (var3.getAuthority() == null || var3.getAuthority().startsWith("media")) {
                  var4 = false;
               }

               this.shouldCreateFile = var4;
            } else if ("file".equalsIgnoreCase(var3.getScheme())) {
               this.shouldCreateFile = true;
            } else if (!Utility.isWebUri(var3)) {
               throw new FacebookException("Unsupported scheme for media Uri : " + var6);
            }
         } else {
            if (var2 == null) {
               throw new FacebookException("Cannot share media without a bitmap or Uri set");
            }

            this.shouldCreateFile = true;
         }

         String var7;
         if (!this.shouldCreateFile) {
            var7 = null;
         } else {
            var7 = UUID.randomUUID().toString();
         }

         this.attachmentName = var7;
         String var5;
         if (!this.shouldCreateFile) {
            var5 = this.originalUri.toString();
         } else {
            var5 = FacebookContentProvider.getAttachmentUrl(FacebookSdk.getApplicationId(), var1, this.attachmentName);
         }

         this.attachmentUrl = var5;
      }

      public String getAttachmentUrl() {
         return this.attachmentUrl;
      }
   }
}
