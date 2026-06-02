package com.google.android.gms.internal;

import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.common.util.zzb;
import com.google.android.gms.common.util.zzo;
import com.google.android.gms.common.util.zzp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public abstract class zzbgn {
   protected static <O, I> I a(zzbgo<I, O> var0, Object var1) {
      Object var2 = var1;
      if (zzbgo.a(var0) != null) {
         var2 = var0.a(var1);
      }

      return (I)var2;
   }

   private static void a(StringBuilder var0, zzbgo var1, Object var2) {
      if (var1.a == 11) {
         var0.append(var1.g.cast(var2).toString());
      } else if (var1.a == 7) {
         var0.append("\"");
         var0.append(zzo.a((String)var2));
         var0.append("\"");
      } else {
         var0.append(var2);
      }
   }

   private static void a(StringBuilder var0, zzbgo var1, ArrayList<Object> var2) {
      var0.append("[");
      int var3 = 0;

      for (int var4 = var2.size(); var3 < var4; var3++) {
         if (var3 > 0) {
            var0.append(",");
         }

         Object var5 = var2.get(var3);
         if (var5 != null) {
            a(var0, var1, var5);
         }
      }

      var0.append("]");
   }

   protected abstract Object a(String var1);

   public abstract Map<String, zzbgo<?, ?>> a();

   protected boolean a(zzbgo var1) {
      if (var1.c == 11) {
         if (var1.d) {
            String var3 = var1.e;
            throw new UnsupportedOperationException("Concrete type arrays not supported");
         } else {
            String var2 = var1.e;
            throw new UnsupportedOperationException("Concrete types not supported");
         }
      } else {
         return this.b(var1.e);
      }
   }

   protected Object b(zzbgo var1) {
      String var5 = var1.e;
      Object var9;
      if (var1.g != null) {
         this.a(var1.e);
         zzbq.a(true, "Concrete field shouldn't be value object: %s", var1.e);
         boolean var4 = var1.d;

         try {
            char var2 = Character.toUpperCase(var5.charAt(0));
            var5 = var5.substring(1);
            int var3 = String.valueOf(var5).length();
            var9 = new StringBuilder(var3 + 4);
            String var8 = var9.append("get").append(var2).append(var5).toString();
            var9 = (StringBuilder)this.getClass().getMethod(var8).invoke(this);
         } catch (Exception var6) {
            throw new RuntimeException(var6);
         }
      } else {
         var9 = (StringBuilder)this.a(var1.e);
      }

      return var9;
   }

   protected abstract boolean b(String var1);

   @Override
   public String toString() {
      Map var1 = this.a();
      StringBuilder var3 = new StringBuilder(100);

      for (String var2 : var1.keySet()) {
         zzbgo var4 = (zzbgo)var1.get(var2);
         if (this.a(var4)) {
            Object var5 = a(var4, this.b(var4));
            if (var3.length() == 0) {
               var3.append("{");
            } else {
               var3.append(",");
            }

            var3.append("\"").append(var2).append("\":");
            if (var5 == null) {
               var3.append("null");
            } else {
               switch (var4.c) {
                  case 8:
                     var3.append("\"").append(zzb.a((byte[])var5)).append("\"");
                     break;
                  case 9:
                     var3.append("\"").append(zzb.b((byte[])var5)).append("\"");
                     break;
                  case 10:
                     zzp.a(var3, (HashMap<String, String>)var5);
                     break;
                  default:
                     if (var4.b) {
                        a(var3, var4, (ArrayList<Object>)var5);
                     } else {
                        a(var3, var4, var5);
                     }
               }
            }
         }
      }

      if (var3.length() > 0) {
         var3.append("}");
      } else {
         var3.append("{}");
      }

      return var3.toString();
   }
}
