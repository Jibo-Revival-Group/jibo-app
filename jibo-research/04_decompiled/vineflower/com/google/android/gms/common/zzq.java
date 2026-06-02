package com.google.android.gms.common;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.util.Log;
import com.google.android.gms.internal.zzbhf;

public class zzq {
   private static zzq a;
   private final Context b;

   private zzq(Context var1) {
      this.b = var1.getApplicationContext();
   }

   static zzh a(PackageInfo var0, zzh... var1) {
      int var2 = 0;
      zzh var3;
      if (var0.signatures == null) {
         var3 = null;
      } else if (var0.signatures.length != 1) {
         Log.w("GoogleSignatureVerifier", "Package has more than one signature.");
         var3 = null;
      } else {
         zzi var4 = new zzi(var0.signatures[0].toByteArray());

         while (true) {
            if (var2 >= var1.length) {
               var3 = null;
               break;
            }

            if (var1[var2].equals(var4)) {
               var3 = var1[var2];
               break;
            }

            var2++;
         }
      }

      return var3;
   }

   public static zzq a(Context param0) {
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
      // 01: invokestatic com/google/android/gms/common/internal/zzbq.a (Ljava/lang/Object;)Ljava/lang/Object;
      // 04: pop
      // 05: ldc com/google/android/gms/common/zzq
      // 07: monitorenter
      // 08: getstatic com/google/android/gms/common/zzq.a Lcom/google/android/gms/common/zzq;
      // 0b: ifnonnull 1f
      // 0e: aload 0
      // 0f: invokestatic com/google/android/gms/common/zzg.a (Landroid/content/Context;)V
      // 12: new com/google/android/gms/common/zzq
      // 15: astore 1
      // 16: aload 1
      // 17: aload 0
      // 18: invokespecial com/google/android/gms/common/zzq.<init> (Landroid/content/Context;)V
      // 1b: aload 1
      // 1c: putstatic com/google/android/gms/common/zzq.a Lcom/google/android/gms/common/zzq;
      // 1f: ldc com/google/android/gms/common/zzq
      // 21: monitorexit
      // 22: getstatic com/google/android/gms/common/zzq.a Lcom/google/android/gms/common/zzq;
      // 25: areturn
      // 26: astore 0
      // 27: ldc com/google/android/gms/common/zzq
      // 29: monitorexit
      // 2a: aload 0
      // 2b: athrow
      // try (5 -> 16): 20 null
      // try (16 -> 18): 20 null
      // try (21 -> 23): 20 null
   }

   private static boolean a(PackageInfo var0, boolean var1) {
      boolean var2 = true;
      if (var0 != null && var0.signatures != null) {
         zzh var3;
         if (var1) {
            var3 = a(var0, zzk.a);
         } else {
            var3 = a(var0, zzk.a[0]);
         }

         if (var3 != null) {
            return var2;
         }
      }

      return false;
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   private final boolean a(String var1) {
      boolean var2 = false;

      try {
         var8 = zzbhf.a(this.b).b(var1, 64);
      } catch (NameNotFoundException var7) {
         return var2;
      }

      if (var8 != null) {
         boolean var9;
         label60: {
            try {
               if (zzp.zzch(this.b)) {
                  var9 = b(var8, true);
                  break label60;
               }
            } catch (NameNotFoundException var6) {
               return var2;
            }

            try {
               var9 = b(var8, false);
            } catch (NameNotFoundException var5) {
               return var2;
            }

            if (!var9) {
               try {
                  if (b(var8, true)) {
                     Log.w("GoogleSignatureVerifier", "Test-keys aren't accepted on this build.");
                  }
               } catch (NameNotFoundException var4) {
                  return var2;
               }
            }

            var2 = var9;
            return var2;
         }

         var2 = var9;
      }

      return var2;
   }

   private static boolean b(PackageInfo var0, boolean var1) {
      boolean var3 = false;
      if (var0.signatures.length != 1) {
         Log.w("GoogleSignatureVerifier", "Package has more than one signature.");
      } else {
         zzi var4 = new zzi(var0.signatures[0].toByteArray());
         String var5 = var0.packageName;
         boolean var2;
         if (var1) {
            var2 = zzg.b(var5, var4);
         } else {
            var2 = zzg.a(var5, var4);
         }

         var3 = var2;
         if (!var2) {
            Log.d("GoogleSignatureVerifier", new StringBuilder(27).append("Cert not in list. atk=").append(var1).toString());
            var3 = var2;
         }
      }

      return var3;
   }

   public final boolean a(int var1) {
      boolean var4 = false;
      String[] var5 = zzbhf.a(this.b).a(var1);
      boolean var3 = var4;
      if (var5 != null) {
         if (var5.length == 0) {
            var3 = var4;
         } else {
            int var2 = var5.length;
            var1 = 0;

            while (true) {
               var3 = var4;
               if (var1 >= var2) {
                  break;
               }

               if (this.a(var5[var1])) {
                  var3 = true;
                  break;
               }

               var1++;
            }
         }
      }

      return var3;
   }

   public final boolean a(PackageInfo var1) {
      boolean var3 = false;
      boolean var2;
      if (var1 == null) {
         var2 = var3;
      } else if (a(var1, false)) {
         var2 = true;
      } else {
         var2 = var3;
         if (a(var1, true)) {
            if (zzp.zzch(this.b)) {
               var2 = true;
            } else {
               Log.w("GoogleSignatureVerifier", "Test-keys aren't accepted on this build.");
               var2 = var3;
            }
         }
      }

      return var2;
   }
}
