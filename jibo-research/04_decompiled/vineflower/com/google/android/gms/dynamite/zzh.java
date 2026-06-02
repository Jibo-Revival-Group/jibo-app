package com.google.android.gms.dynamite;

import dalvik.system.PathClassLoader;

final class zzh extends PathClassLoader {
   zzh(String var1, ClassLoader var2) {
      super(var1, var2);
   }

   protected final Class<?> loadClass(String var1, boolean var2) throws ClassNotFoundException {
      if (!var1.startsWith("java.") && !var1.startsWith("android.")) {
         Class var3;
         try {
            var3 = this.findClass(var1);
         } catch (ClassNotFoundException var4) {
            return super.loadClass(var1, var2);
         }

         return var3;
      } else {
         return super.loadClass(var1, var2);
      }
   }
}
