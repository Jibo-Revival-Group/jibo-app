package android.support.v4.content;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.content.res.XmlResourceParser;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;
import org.xmlpull.v1.XmlPullParserException;

public class FileProvider extends ContentProvider {
   private static final String[] a = new String[]{"_display_name", "_size"};
   private static final File b = new File("/");
   private static HashMap<String, FileProvider.PathStrategy> c = new HashMap<>();
   private FileProvider.PathStrategy d;

   private static int a(String var0) {
      int var1;
      if ("r".equals(var0)) {
         var1 = 268435456;
      } else if ("w".equals(var0) || "wt".equals(var0)) {
         var1 = 738197504;
      } else if ("wa".equals(var0)) {
         var1 = 704643072;
      } else if ("rw".equals(var0)) {
         var1 = 939524096;
      } else {
         if (!"rwt".equals(var0)) {
            throw new IllegalArgumentException("Invalid mode: " + var0);
         }

         var1 = 1006632960;
      }

      return var1;
   }

   public static Uri a(Context var0, String var1, File var2) {
      return a(var0, var1).a(var2);
   }

   private static FileProvider.PathStrategy a(Context param0, String param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 00: getstatic android/support/v4/content/FileProvider.c Ljava/util/HashMap;
      // 03: astore 4
      // 05: aload 4
      // 07: monitorenter
      // 08: getstatic android/support/v4/content/FileProvider.c Ljava/util/HashMap;
      // 0b: aload 1
      // 0c: invokevirtual java/util/HashMap.get (Ljava/lang/Object;)Ljava/lang/Object;
      // 0f: checkcast android/support/v4/content/FileProvider$PathStrategy
      // 12: astore 3
      // 13: aload 3
      // 14: astore 2
      // 15: aload 3
      // 16: ifnonnull 28
      // 19: aload 0
      // 1a: aload 1
      // 1b: invokestatic android/support/v4/content/FileProvider.b (Landroid/content/Context;Ljava/lang/String;)Landroid/support/v4/content/FileProvider$PathStrategy;
      // 1e: astore 2
      // 1f: getstatic android/support/v4/content/FileProvider.c Ljava/util/HashMap;
      // 22: aload 1
      // 23: aload 2
      // 24: invokevirtual java/util/HashMap.put (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      // 27: pop
      // 28: aload 4
      // 2a: monitorexit
      // 2b: aload 2
      // 2c: areturn
      // 2d: astore 0
      // 2e: new java/lang/IllegalArgumentException
      // 31: astore 1
      // 32: aload 1
      // 33: ldc "Failed to parse android.support.FILE_PROVIDER_PATHS meta-data"
      // 35: aload 0
      // 36: invokespecial java/lang/IllegalArgumentException.<init> (Ljava/lang/String;Ljava/lang/Throwable;)V
      // 39: aload 1
      // 3a: athrow
      // 3b: astore 0
      // 3c: aload 4
      // 3e: monitorexit
      // 3f: aload 0
      // 40: athrow
      // 41: astore 1
      // 42: new java/lang/IllegalArgumentException
      // 45: astore 0
      // 46: aload 0
      // 47: ldc "Failed to parse android.support.FILE_PROVIDER_PATHS meta-data"
      // 49: aload 1
      // 4a: invokespecial java/lang/IllegalArgumentException.<init> (Ljava/lang/String;Ljava/lang/Throwable;)V
      // 4d: aload 0
      // 4e: athrow
      // try (4 -> 9): 35 null
      // try (13 -> 17): 26 java/io/IOException
      // try (13 -> 17): 40 org/xmlpull/v1/XmlPullParserException
      // try (13 -> 17): 35 null
      // try (17 -> 22): 35 null
      // try (22 -> 24): 35 null
      // try (27 -> 35): 35 null
      // try (36 -> 38): 35 null
      // try (41 -> 49): 35 null
   }

   private static File a(File var0, String... var1) {
      for (String var4 : var1) {
         if (var4 != null) {
            var0 = new File(var0, var4);
         }
      }

      return var0;
   }

   private static Object[] a(Object[] var0, int var1) {
      Object[] var2 = new Object[var1];
      System.arraycopy(var0, 0, var2, 0, var1);
      return var2;
   }

   private static String[] a(String[] var0, int var1) {
      String[] var2 = new String[var1];
      System.arraycopy(var0, 0, var2, 0, var1);
      return var2;
   }

   private static FileProvider.PathStrategy b(Context var0, String var1) throws IOException, XmlPullParserException {
      FileProvider.SimplePathStrategy var3 = new FileProvider.SimplePathStrategy(var1);
      XmlResourceParser var4 = var0.getPackageManager()
         .resolveContentProvider(var1, 128)
         .loadXmlMetaData(var0.getPackageManager(), "android.support.FILE_PROVIDER_PATHS");
      if (var4 == null) {
         throw new IllegalArgumentException("Missing android.support.FILE_PROVIDER_PATHS meta-data");
      }

      while (true) {
         int var2 = var4.next();
         if (var2 == 1) {
            return var3;
         }

         if (var2 == 2) {
            var1 = var4.getName();
            String var6 = var4.getAttributeValue(null, "name");
            String var5 = var4.getAttributeValue(null, "path");
            File var8;
            if ("root-path".equals(var1)) {
               var8 = b;
            } else if ("files-path".equals(var1)) {
               var8 = var0.getFilesDir();
            } else if ("cache-path".equals(var1)) {
               var8 = var0.getCacheDir();
            } else if ("external-path".equals(var1)) {
               var8 = Environment.getExternalStorageDirectory();
            } else {
               label42: {
                  if ("external-files-path".equals(var1)) {
                     File[] var9 = ContextCompat.a(var0, null);
                     if (var9.length > 0) {
                        var8 = var9[0];
                        break label42;
                     }
                  } else if ("external-cache-path".equals(var1)) {
                     File[] var10 = ContextCompat.a(var0);
                     if (var10.length > 0) {
                        var8 = var10[0];
                        break label42;
                     }
                  } else if (VERSION.SDK_INT >= 21 && "external-media-path".equals(var1)) {
                     File[] var11 = var0.getExternalMediaDirs();
                     if (var11.length > 0) {
                        var8 = var11[0];
                        break label42;
                     }
                  }

                  var8 = null;
               }
            }

            if (var8 != null) {
               var3.a(var6, a(var8, new String[]{var5}));
            }
         }
      }
   }

   public void attachInfo(Context var1, ProviderInfo var2) {
      super.attachInfo(var1, var2);
      if (var2.exported) {
         throw new SecurityException("Provider must not be exported");
      }

      if (!var2.grantUriPermissions) {
         throw new SecurityException("Provider must grant uri permissions");
      }

      this.d = a(var1, var2.authority);
   }

   public int delete(Uri var1, String var2, String[] var3) {
      byte var4;
      if (this.d.a(var1).delete()) {
         var4 = 1;
      } else {
         var4 = 0;
      }

      return var4;
   }

   public String getType(Uri var1) {
      File var3 = this.d.a(var1);
      int var2 = var3.getName().lastIndexOf(46);
      if (var2 >= 0) {
         String var4 = var3.getName().substring(var2 + 1);
         String var5 = MimeTypeMap.getSingleton().getMimeTypeFromExtension(var4);
         if (var5 != null) {
            return var5;
         }
      }

      return "application/octet-stream";
   }

   public Uri insert(Uri var1, ContentValues var2) {
      throw new UnsupportedOperationException("No external inserts");
   }

   public boolean onCreate() {
      return true;
   }

   public ParcelFileDescriptor openFile(Uri var1, String var2) throws FileNotFoundException {
      return ParcelFileDescriptor.open(this.d.a(var1), a(var2));
   }

   public Cursor query(Uri var1, String[] var2, String var3, String[] var4, String var5) {
      File var14 = this.d.a(var1);
      String[] var10 = var2;
      if (var2 == null) {
         var10 = a;
      }

      var4 = new String[var10.length];
      Object[] var12 = new Object[var10.length];
      int var9 = var10.length;
      int var7 = 0;
      int var6 = 0;

      while (var7 < var9) {
         var5 = var10[var7];
         if ("_display_name".equals(var5)) {
            var4[var6] = "_display_name";
            int var8 = var6 + 1;
            var12[var6] = var14.getName();
            var6 = var8;
         } else if ("_size".equals(var5)) {
            var4[var6] = "_size";
            int var18 = var6 + 1;
            var12[var6] = var14.length();
            var6 = var18;
         }

         var7++;
      }

      String[] var15 = a(var4, var6);
      Object[] var11 = a(var12, var6);
      MatrixCursor var13 = new MatrixCursor(var15, 1);
      var13.addRow(var11);
      return var13;
   }

   public int update(Uri var1, ContentValues var2, String var3, String[] var4) {
      throw new UnsupportedOperationException("No external updates");
   }

   interface PathStrategy {
      Uri a(File var1);

      File a(Uri var1);
   }

   static class SimplePathStrategy implements FileProvider.PathStrategy {
      private final String a;
      private final HashMap<String, File> b = new HashMap<>();

      SimplePathStrategy(String var1) {
         this.a = var1;
      }

      @Override
      public Uri a(File var1) {
         String var4;
         try {
            var4 = var1.getCanonicalPath();
         } catch (IOException var7) {
            throw new IllegalArgumentException("Failed to resolve canonical path for " + var1);
         }

         Entry var8 = null;

         for (Entry var3 : this.b.entrySet()) {
            Entry var2;
            label35: {
               String var6 = ((File)var3.getValue()).getPath();
               if (var4.startsWith(var6)) {
                  var2 = var3;
                  if (var8 == null) {
                     break label35;
                  }

                  if (var6.length() > ((File)var8.getValue()).getPath().length()) {
                     var2 = var3;
                     break label35;
                  }
               }

               var2 = var8;
            }

            var8 = var2;
         }

         if (var8 == null) {
            throw new IllegalArgumentException("Failed to find configured root that contains " + var4);
         }

         String var10 = ((File)var8.getValue()).getPath();
         if (var10.endsWith("/")) {
            var10 = var4.substring(var10.length());
         } else {
            var10 = var4.substring(var10.length() + 1);
         }

         String var9 = Uri.encode((String)var8.getKey()) + '/' + Uri.encode(var10, "/");
         return new Builder().scheme("content").authority(this.a).encodedPath(var9).build();
      }

      @Override
      public File a(Uri var1) {
         String var4 = var1.getEncodedPath();
         int var2 = var4.indexOf(47, 1);
         String var3 = Uri.decode(var4.substring(1, var2));
         var4 = Uri.decode(var4.substring(var2 + 1));
         File var7 = this.b.get(var3);
         if (var7 == null) {
            throw new IllegalArgumentException("Unable to find configured root for " + var1);
         }

         File var6 = new File(var7, var4);

         try {
            var9 = var6.getCanonicalFile();
         } catch (IOException var5) {
            throw new IllegalArgumentException("Failed to resolve canonical path for " + var6);
         }

         if (!var9.getPath().startsWith(var7.getPath())) {
            throw new SecurityException("Resolved path jumped beyond configured root");
         } else {
            return var9;
         }
      }

      void a(String var1, File var2) {
         if (TextUtils.isEmpty(var1)) {
            throw new IllegalArgumentException("Name must not be empty");
         }

         File var3;
         try {
            var3 = var2.getCanonicalFile();
         } catch (IOException var4) {
            throw new IllegalArgumentException("Failed to resolve canonical path for " + var2, var4);
         }

         this.b.put(var1, var3);
      }
   }
}
