package android.support.multidex;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build.VERSION;
import android.util.Log;
import dalvik.system.DexFile;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipFile;

public final class MultiDex {
   private static final Set<File> a = new HashSet<>();
   private static final boolean b = a(System.getProperty("java.vm.version"));

   private static File a(Context var0, File var1, String var2) throws IOException {
      var1 = new File(var1, "code_cache");

      label13: {
         try {
            a(var1);
         } catch (IOException var3) {
            var4 = new File(var0.getFilesDir(), "code_cache");
            a(var4);
            break label13;
         }

         var4 = var1;
      }

      File var5 = new File(var4, var2);
      a(var5);
      return var5;
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   public static void a(Context var0) {
      Log.i("MultiDex", "Installing application");
      if (b) {
         Log.i("MultiDex", "VM has multidex support, MultiDex support library is disabled.");
      } else {
         if (VERSION.SDK_INT < 4) {
            throw new RuntimeException("MultiDex installation failed. SDK " + VERSION.SDK_INT + " is unsupported. Min SDK version is " + 4 + ".");
         }

         ApplicationInfo var3;
         try {
            var3 = b(var0);
         } catch (Exception var6) {
            Log.e("MultiDex", "MultiDex installation failure", var6);
            throw new RuntimeException("MultiDex installation failed (" + var6.getMessage() + ").");
         }

         if (var3 == null) {
            try {
               Log.i("MultiDex", "No ApplicationInfo available, i.e. running on a test Context: MultiDex support library is disabled.");
            } catch (Exception var5) {
               Log.e("MultiDex", "MultiDex installation failure", var5);
               throw new RuntimeException("MultiDex installation failed (" + var5.getMessage() + ").");
            }
         } else {
            try {
               File var2 = new File(var3.sourceDir);
               File var1 = new File(var3.dataDir);
               a(var0, var2, var1, "secondary-dexes", "", true);
            } catch (Exception var4) {
               Log.e("MultiDex", "MultiDex installation failure", var4);
               throw new RuntimeException("MultiDex installation failed (" + var4.getMessage() + ").");
            }

            Log.i("MultiDex", "install done");
         }
      }
   }

   private static void a(Context param0, File param1, File param2, String param3, String param4, boolean param5) throws IOException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException, InstantiationException {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 000: getstatic android/support/multidex/MultiDex.a Ljava/util/Set;
      // 003: astore 6
      // 005: aload 6
      // 007: monitorenter
      // 008: getstatic android/support/multidex/MultiDex.a Ljava/util/Set;
      // 00b: aload 1
      // 00c: invokeinterface java/util/Set.contains (Ljava/lang/Object;)Z 2
      // 011: ifeq 018
      // 014: aload 6
      // 016: monitorexit
      // 017: return
      // 018: getstatic android/support/multidex/MultiDex.a Ljava/util/Set;
      // 01b: aload 1
      // 01c: invokeinterface java/util/Set.add (Ljava/lang/Object;)Z 2
      // 021: pop
      // 022: getstatic android/os/Build$VERSION.SDK_INT I
      // 025: bipush 20
      // 027: if_icmple 070
      // 02a: new java/lang/StringBuilder
      // 02d: astore 7
      // 02f: aload 7
      // 031: invokespecial java/lang/StringBuilder.<init> ()V
      // 034: ldc "MultiDex"
      // 036: aload 7
      // 038: ldc "MultiDex is not guaranteed to work in SDK version "
      // 03a: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 03d: getstatic android/os/Build$VERSION.SDK_INT I
      // 040: invokevirtual java/lang/StringBuilder.append (I)Ljava/lang/StringBuilder;
      // 043: ldc ": SDK version higher than "
      // 045: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 048: bipush 20
      // 04a: invokevirtual java/lang/StringBuilder.append (I)Ljava/lang/StringBuilder;
      // 04d: ldc " should be backed by "
      // 04f: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 052: ldc "runtime with built-in multidex capabilty but it's not the "
      // 054: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 057: ldc "case here: java.vm.version=\""
      // 059: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 05c: ldc "java.vm.version"
      // 05e: invokestatic java/lang/System.getProperty (Ljava/lang/String;)Ljava/lang/String;
      // 061: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 064: ldc "\""
      // 066: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 069: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 06c: invokestatic android/util/Log.w (Ljava/lang/String;Ljava/lang/String;)I
      // 06f: pop
      // 070: aload 0
      // 071: invokevirtual android/content/Context.getClassLoader ()Ljava/lang/ClassLoader;
      // 074: astore 7
      // 076: aload 7
      // 078: ifnonnull 09f
      // 07b: ldc "MultiDex"
      // 07d: ldc "Context class loader is null. Must be running in test mode. Skip patching."
      // 07f: invokestatic android/util/Log.e (Ljava/lang/String;Ljava/lang/String;)I
      // 082: pop
      // 083: aload 6
      // 085: monitorexit
      // 086: goto 017
      // 089: astore 0
      // 08a: aload 6
      // 08c: monitorexit
      // 08d: aload 0
      // 08e: athrow
      // 08f: astore 0
      // 090: ldc "MultiDex"
      // 092: ldc "Failure while trying to obtain Context class loader. Must be running in test mode. Skip patching."
      // 094: aload 0
      // 095: invokestatic android/util/Log.w (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
      // 098: pop
      // 099: aload 6
      // 09b: monitorexit
      // 09c: goto 017
      // 09f: aload 0
      // 0a0: invokestatic android/support/multidex/MultiDex.c (Landroid/content/Context;)V
      // 0a3: aload 0
      // 0a4: aload 2
      // 0a5: aload 3
      // 0a6: invokestatic android/support/multidex/MultiDex.a (Landroid/content/Context;Ljava/io/File;Ljava/lang/String;)Ljava/io/File;
      // 0a9: astore 3
      // 0aa: new android/support/multidex/MultiDexExtractor
      // 0ad: astore 2
      // 0ae: aload 2
      // 0af: aload 1
      // 0b0: aload 3
      // 0b1: invokespecial android/support/multidex/MultiDexExtractor.<init> (Ljava/io/File;Ljava/io/File;)V
      // 0b4: aconst_null
      // 0b5: astore 1
      // 0b6: aload 2
      // 0b7: aload 0
      // 0b8: aload 4
      // 0ba: bipush 0
      // 0bb: invokevirtual android/support/multidex/MultiDexExtractor.a (Landroid/content/Context;Ljava/lang/String;Z)Ljava/util/List;
      // 0be: astore 8
      // 0c0: aload 7
      // 0c2: aload 3
      // 0c3: aload 8
      // 0c5: invokestatic android/support/multidex/MultiDex.a (Ljava/lang/ClassLoader;Ljava/io/File;Ljava/util/List;)V
      // 0c8: aload 2
      // 0c9: invokevirtual android/support/multidex/MultiDexExtractor.close ()V
      // 0cc: aload 1
      // 0cd: astore 0
      // 0ce: aload 0
      // 0cf: ifnull 10f
      // 0d2: aload 0
      // 0d3: athrow
      // 0d4: astore 8
      // 0d6: ldc "MultiDex"
      // 0d8: ldc "Something went wrong when trying to clear old MultiDex extraction, continuing without cleaning."
      // 0da: aload 8
      // 0dc: invokestatic android/util/Log.w (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
      // 0df: pop
      // 0e0: goto 0a3
      // 0e3: astore 8
      // 0e5: iload 5
      // 0e7: ifne 0f4
      // 0ea: aload 8
      // 0ec: athrow
      // 0ed: astore 0
      // 0ee: aload 2
      // 0ef: invokevirtual android/support/multidex/MultiDexExtractor.close ()V
      // 0f2: aload 0
      // 0f3: athrow
      // 0f4: ldc "MultiDex"
      // 0f6: ldc "Failed to install extracted secondary dex files, retrying with forced extraction"
      // 0f8: aload 8
      // 0fa: invokestatic android/util/Log.w (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
      // 0fd: pop
      // 0fe: aload 7
      // 100: aload 3
      // 101: aload 2
      // 102: aload 0
      // 103: aload 4
      // 105: bipush 1
      // 106: invokevirtual android/support/multidex/MultiDexExtractor.a (Landroid/content/Context;Ljava/lang/String;Z)Ljava/util/List;
      // 109: invokestatic android/support/multidex/MultiDex.a (Ljava/lang/ClassLoader;Ljava/io/File;Ljava/util/List;)V
      // 10c: goto 0c8
      // 10f: aload 6
      // 111: monitorexit
      // 112: goto 017
      // 115: astore 0
      // 116: goto 0ce
      // 119: astore 1
      // 11a: goto 0f2
      // try (4 -> 10): 58 null
      // try (11 -> 46): 58 null
      // try (46 -> 49): 63 java/lang/RuntimeException
      // try (46 -> 49): 58 null
      // try (51 -> 57): 58 null
      // try (59 -> 61): 58 null
      // try (64 -> 71): 58 null
      // try (72 -> 74): 105 java/lang/Throwable
      // try (72 -> 74): 58 null
      // try (74 -> 85): 58 null
      // try (87 -> 93): 117 null
      // try (93 -> 97): 112 java/io/IOException
      // try (93 -> 97): 117 null
      // try (97 -> 99): 139 java/io/IOException
      // try (97 -> 99): 58 null
      // try (103 -> 105): 58 null
      // try (106 -> 111): 58 null
      // try (115 -> 117): 117 null
      // try (118 -> 120): 141 java/io/IOException
      // try (118 -> 120): 58 null
      // try (120 -> 122): 58 null
      // try (122 -> 135): 117 null
      // try (136 -> 138): 58 null
   }

   private static void a(File var0) throws IOException {
      var0.mkdir();
      if (!var0.isDirectory()) {
         File var1 = var0.getParentFile();
         if (var1 == null) {
            Log.e("MultiDex", "Failed to create dir " + var0.getPath() + ". Parent file is null.");
         } else {
            Log.e(
               "MultiDex",
               "Failed to create dir "
                  + var0.getPath()
                  + ". parent file is a dir "
                  + var1.isDirectory()
                  + ", a file "
                  + var1.isFile()
                  + ", exists "
                  + var1.exists()
                  + ", readable "
                  + var1.canRead()
                  + ", writable "
                  + var1.canWrite()
            );
         }

         throw new IOException("Failed to create directory " + var0.getPath());
      }
   }

   private static void a(ClassLoader var0, File var1, List<? extends File> var2) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException, IOException, SecurityException, ClassNotFoundException, InstantiationException {
      if (!var2.isEmpty()) {
         if (VERSION.SDK_INT >= 19) {
            MultiDex.V19.a(var0, var2, var1);
         } else if (VERSION.SDK_INT >= 14) {
            MultiDex.V14.a(var0, var2);
         } else {
            MultiDex.V4.a(var0, var2);
         }
      }
   }

   static boolean a(String var0) {
      boolean var4 = false;
      boolean var3 = var4;
      if (var0 != null) {
         Matcher var5 = Pattern.compile("(\\d+)\\.(\\d+)(\\.\\d+)?").matcher(var0);
         var3 = var4;
         label29:
         if (var5.matches()) {
            int var1;
            int var2;
            try {
               var2 = Integer.parseInt(var5.group(1));
               var1 = Integer.parseInt(var5.group(2));
            } catch (NumberFormatException var6) {
               var3 = var4;
               break label29;
            }

            if (var2 <= 2) {
               var3 = var4;
               if (var2 != 2) {
                  break label29;
               }

               var3 = var4;
               if (var1 < 1) {
                  break label29;
               }
            }

            var3 = true;
         }
      }

      StringBuilder var8 = new StringBuilder().append("VM with version ").append(var0);
      if (var3) {
         var0 = " has multidex support";
      } else {
         var0 = " does not have multidex support";
      }

      Log.i("MultiDex", var8.append(var0).toString());
      return var3;
   }

   private static ApplicationInfo b(Context var0) {
      try {
         var2 = var0.getApplicationInfo();
      } catch (RuntimeException var1) {
         Log.w("MultiDex", "Failure while trying to obtain ApplicationInfo from Context. Must be running in test mode. Skip patching.", var1);
         var2 = null;
      }

      return var2;
   }

   private static Field b(Object var0, String var1) throws NoSuchFieldException {
      for (Class var2 = var0.getClass(); var2 != null; var2 = var2.getSuperclass()) {
         try {
            Field var3 = var2.getDeclaredField(var1);
            if (!var3.isAccessible()) {
               var3.setAccessible(true);
            }

            return var3;
         } catch (NoSuchFieldException var4) {
         }
      }

      throw new NoSuchFieldException("Field " + var1 + " not found in " + var0.getClass());
   }

   private static Method b(Object var0, String var1, Class<?>... var2) throws NoSuchMethodException {
      for (Class var3 = var0.getClass(); var3 != null; var3 = var3.getSuperclass()) {
         try {
            Method var4 = var3.getDeclaredMethod(var1, var2);
            if (!var4.isAccessible()) {
               var4.setAccessible(true);
            }

            return var4;
         } catch (NoSuchMethodException var5) {
         }
      }

      throw new NoSuchMethodException("Method " + var1 + " with parameters " + Arrays.<Class>asList(var2) + " not found in " + var0.getClass());
   }

   private static void b(Object var0, String var1, Object[] var2) throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
      Field var3 = b(var0, var1);
      Object[] var5 = (Object[])var3.get(var0);
      Object[] var4 = (Object[])Array.newInstance(var5.getClass().getComponentType(), var5.length + var2.length);
      System.arraycopy(var5, 0, var4, 0, var5.length);
      System.arraycopy(var2, 0, var4, var5.length, var2.length);
      var3.set(var0, var4);
   }

   private static void c(Context var0) throws Exception {
      File var5 = new File(var0.getFilesDir(), "secondary-dexes");
      if (var5.isDirectory()) {
         Log.i("MultiDex", "Clearing old secondary dex dir (" + var5.getPath() + ").");
         File[] var3 = var5.listFiles();
         if (var3 == null) {
            Log.w("MultiDex", "Failed to list secondary dex dir content (" + var5.getPath() + ").");
         } else {
            for (File var4 : var3) {
               Log.i("MultiDex", "Trying to delete old file " + var4.getPath() + " of size " + var4.length());
               if (!var4.delete()) {
                  Log.w("MultiDex", "Failed to delete old file " + var4.getPath());
               } else {
                  Log.i("MultiDex", "Deleted old file " + var4.getPath());
               }
            }

            if (!var5.delete()) {
               Log.w("MultiDex", "Failed to delete secondary dex dir " + var5.getPath());
            } else {
               Log.i("MultiDex", "Deleted old secondary dex dir " + var5.getPath());
            }
         }
      }
   }

   private static final class V14 {
      private static final int a = ".zip".length();
      private final MultiDex.V14.ElementConstructor b;

      private V14() throws ClassNotFoundException, SecurityException, NoSuchMethodException {
         Class var2 = Class.forName("dalvik.system.DexPathList$Element");

         MultiDex.V14.ElementConstructor var1;
         try {
            var1 = new MultiDex.V14.ICSElementConstructor(var2);
         } catch (NoSuchMethodException var4) {
            try {
               var1 = new MultiDex.V14.JBMR11ElementConstructor(var2);
            } catch (NoSuchMethodException var3) {
               var1 = new MultiDex.V14.JBMR2ElementConstructor(var2);
            }
         }

         this.b = var1;
      }

      private static String a(File var0) {
         File var1 = var0.getParentFile();
         String var2 = var0.getName();
         return new File(var1, var2.substring(0, var2.length() - a) + ".dex").getPath();
      }

      static void a(ClassLoader var0, List<? extends File> var1) throws IOException, SecurityException, IllegalArgumentException, ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchFieldException {
         Object var4 = MultiDex.b(var0, "pathList").get(var0);
         Object[] var5 = new MultiDex.V14().a(var1);

         try {
            MultiDex.b(var4, "dexElements", var5);
         } catch (NoSuchFieldException var3) {
            Log.w("MultiDex", "Failed find field 'dexElements' attempting 'pathElements'", var3);
            MultiDex.b(var4, "pathElements", var5);
         }
      }

      private Object[] a(List<? extends File> var1) throws IOException, SecurityException, IllegalArgumentException, InstantiationException, IllegalAccessException, InvocationTargetException {
         Object[] var4 = new Object[var1.size()];

         for (int var2 = 0; var2 < var4.length; var2++) {
            File var3 = (File)var1.get(var2);
            var4[var2] = this.b.a(var3, DexFile.loadDex(var3.getPath(), a(var3), 0));
         }

         return var4;
      }

      private interface ElementConstructor {
         Object a(File var1, DexFile var2) throws IllegalArgumentException, InstantiationException, IllegalAccessException, InvocationTargetException, IOException;
      }

      private static class ICSElementConstructor implements MultiDex.V14.ElementConstructor {
         private final Constructor<?> a;

         ICSElementConstructor(Class<?> var1) throws SecurityException, NoSuchMethodException {
            this.a = var1.getConstructor(File.class, ZipFile.class, DexFile.class);
            this.a.setAccessible(true);
         }

         @Override
         public Object a(File var1, DexFile var2) throws IllegalArgumentException, InstantiationException, IllegalAccessException, InvocationTargetException, IOException {
            return this.a.newInstance(var1, new ZipFile(var1), var2);
         }
      }

      private static class JBMR11ElementConstructor implements MultiDex.V14.ElementConstructor {
         private final Constructor<?> a;

         JBMR11ElementConstructor(Class<?> var1) throws SecurityException, NoSuchMethodException {
            this.a = var1.getConstructor(File.class, File.class, DexFile.class);
            this.a.setAccessible(true);
         }

         @Override
         public Object a(File var1, DexFile var2) throws IllegalArgumentException, InstantiationException, IllegalAccessException, InvocationTargetException {
            return this.a.newInstance(var1, var1, var2);
         }
      }

      private static class JBMR2ElementConstructor implements MultiDex.V14.ElementConstructor {
         private final Constructor<?> a;

         JBMR2ElementConstructor(Class<?> var1) throws SecurityException, NoSuchMethodException {
            this.a = var1.getConstructor(File.class, boolean.class, File.class, DexFile.class);
            this.a.setAccessible(true);
         }

         @Override
         public Object a(File var1, DexFile var2) throws IllegalArgumentException, InstantiationException, IllegalAccessException, InvocationTargetException {
            return this.a.newInstance(var1, Boolean.FALSE, var1, var2);
         }
      }
   }

   private static final class V19 {
      static void a(ClassLoader var0, List<? extends File> var1, File var2) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException, IOException {
         Object var4 = MultiDex.b(var0, "pathList").get(var0);
         ArrayList var3 = new ArrayList();
         MultiDex.b(var4, "dexElements", a(var4, new ArrayList<>(var1), var2, var3));
         if (var3.size() > 0) {
            Iterator var5 = var3.iterator();

            while (var5.hasNext()) {
               Log.w("MultiDex", "Exception in makeDexElement", (IOException)var5.next());
            }

            Field var8 = MultiDex.b(var4, "dexElementsSuppressedExceptions");
            IOException[] var9 = (IOException[])var8.get(var4);
            IOException[] var6;
            if (var9 == null) {
               var6 = var3.toArray(new IOException[var3.size()]);
            } else {
               var6 = new IOException[var3.size() + var9.length];
               var3.toArray(var6);
               System.arraycopy(var9, 0, var6, var3.size(), var9.length);
            }

            var8.set(var4, var6);
            IOException var7 = new IOException("I/O exception during makeDexElement");
            var7.initCause((Throwable)var3.get(0));
            throw var7;
         }
      }

      private static Object[] a(Object var0, ArrayList<File> var1, File var2, ArrayList<IOException> var3) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
         return (Object[])MultiDex.b(var0, "makeDexElements", ArrayList.class, File.class, ArrayList.class).invoke(var0, var1, var2, var3);
      }
   }

   private static final class V4 {
      static void a(ClassLoader var0, List<? extends File> var1) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, IOException {
         int var2 = var1.size();
         Field var7 = MultiDex.b(var0, "path");
         StringBuilder var8 = new StringBuilder((String)var7.get(var0));
         String[] var4 = new String[var2];
         File[] var6 = new File[var2];
         ZipFile[] var5 = new ZipFile[var2];
         DexFile[] var3 = new DexFile[var2];
         ListIterator var11 = var1.listIterator();

         while (var11.hasNext()) {
            File var10 = (File)var11.next();
            String var9 = var10.getAbsolutePath();
            var8.append(':').append(var9);
            var2 = var11.previousIndex();
            var4[var2] = var9;
            var6[var2] = var10;
            var5[var2] = new ZipFile(var10);
            var3[var2] = DexFile.loadDex(var9, var9 + ".dex", 0);
         }

         var7.set(var0, var8.toString());
         MultiDex.b(var0, "mPaths", var4);
         MultiDex.b(var0, "mFiles", var6);
         MultiDex.b(var0, "mZips", var5);
         MultiDex.b(var0, "mDexs", var3);
      }
   }
}
