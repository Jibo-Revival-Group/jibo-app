package com.mixpanel.android.viewcrawler;

import android.view.View;
import com.mixpanel.android.util.MPLog;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class Caller {
   private final String a;
   private final Object[] b;
   private final Class<?> c;
   private final Class<?> d;
   private final Method e;

   public Caller(Class<?> var1, String var2, Object[] var3, Class<?> var4) throws NoSuchMethodException {
      this.a = var2;
      this.b = var3;
      this.c = var4;
      this.e = this.b(var1);
      if (this.e == null) {
         throw new NoSuchMethodException("Method " + var1.getName() + "." + this.a + " doesn't exit");
      }

      this.d = this.e.getDeclaringClass();
   }

   private static Class<?> a(Class<?> var0) {
      Class var1;
      if (var0 == Byte.class) {
         var1 = byte.class;
      } else if (var0 == Short.class) {
         var1 = short.class;
      } else if (var0 == Integer.class) {
         var1 = int.class;
      } else if (var0 == Long.class) {
         var1 = long.class;
      } else if (var0 == Float.class) {
         var1 = float.class;
      } else if (var0 == Double.class) {
         var1 = double.class;
      } else if (var0 == Boolean.class) {
         var1 = boolean.class;
      } else {
         var1 = var0;
         if (var0 == Character.class) {
            var1 = char.class;
         }
      }

      return var1;
   }

   private Method b(Class<?> var1) {
      Class[] var6 = new Class[this.b.length];

      for (int var2 = 0; var2 < this.b.length; var2++) {
         var6[var2] = this.b[var2].getClass();
      }

      Method[] var8 = var1.getMethods();
      int var4 = var8.length;
      int var11 = 0;

      while (true) {
         if (var11 >= var4) {
            var10 = null;
            break;
         }

         var10 = var8[var11];
         String var9 = var10.getName();
         Class[] var7 = var10.getParameterTypes();
         if (var9.equals(this.a) && var7.length == this.b.length && a(this.c).isAssignableFrom(a(var10.getReturnType()))) {
            boolean var5 = true;

            for (int var3 = 0; var3 < var7.length && var5; var3++) {
               Class var12 = a(var6[var3]);
               var5 = a(var7[var3]).isAssignableFrom(var12);
            }

            if (var5) {
               break;
            }
         }

         var11++;
      }

      return var10;
   }

   public Object a(View var1) {
      return this.a(var1, this.b);
   }

   public Object a(View var1, Object[] var2) {
      Class var3 = var1.getClass();
      if (this.d.isAssignableFrom(var3)) {
         try {
            return this.e.invoke(var1, var2);
         } catch (IllegalAccessException var4) {
            MPLog.e("MixpanelABTest.Caller", "Method " + this.e.getName() + " appears not to be public", var4);
         } catch (IllegalArgumentException var5) {
            MPLog.e("MixpanelABTest.Caller", "Method " + this.e.getName() + " called with arguments of the wrong type", var5);
         } catch (InvocationTargetException var6) {
            MPLog.e("MixpanelABTest.Caller", "Method " + this.e.getName() + " threw an exception", var6);
         }
      }

      return null;
   }

   public boolean a(Object[] var1) {
      boolean var4 = false;
      Class[] var5 = this.e.getParameterTypes();
      boolean var3;
      if (var1.length != var5.length) {
         var3 = var4;
      } else {
         int var2 = 0;

         while (true) {
            if (var2 >= var1.length) {
               var3 = true;
               break;
            }

            Class var6 = a(var5[var2]);
            if (var1[var2] == null) {
               var3 = var4;
               if (var6 == byte.class) {
                  break;
               }

               var3 = var4;
               if (var6 == short.class) {
                  break;
               }

               var3 = var4;
               if (var6 == int.class) {
                  break;
               }

               var3 = var4;
               if (var6 == long.class) {
                  break;
               }

               var3 = var4;
               if (var6 == float.class) {
                  break;
               }

               var3 = var4;
               if (var6 == double.class) {
                  break;
               }

               var3 = var4;
               if (var6 == boolean.class) {
                  break;
               }

               var3 = var4;
               if (var6 == char.class) {
                  break;
               }
            } else if (!var6.isAssignableFrom(a(var1[var2].getClass()))) {
               var3 = var4;
               break;
            }

            var2++;
         }
      }

      return var3;
   }

   public Object[] a() {
      return this.b;
   }

   @Override
   public String toString() {
      return "[Caller " + this.a + "(" + this.b + ")]";
   }
}
