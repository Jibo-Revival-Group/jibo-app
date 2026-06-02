package com.google.android.gms.internal;

import java.util.Iterator;

public abstract class zzbgq extends zzbgn implements zzbfq {
   @Override
   public Object a(String var1) {
      return null;
   }

   @Override
   public boolean b(String var1) {
      return false;
   }

   public final int describeContents() {
      return 0;
   }

   @Override
   public boolean equals(Object var1) {
      boolean var2;
      if (this == var1) {
         var2 = true;
      } else if (!this.getClass().isInstance(var1)) {
         var2 = false;
      } else {
         var1 = var1;
         Iterator var3 = this.a().values().iterator();

         while (true) {
            if (!var3.hasNext()) {
               var2 = true;
               break;
            }

            zzbgo var4 = (zzbgo)var3.next();
            if (this.a(var4)) {
               if (!var1.a(var4)) {
                  var2 = false;
                  break;
               }

               if (!this.b(var4).equals(var1.b(var4))) {
                  var2 = false;
                  break;
               }
            } else if (var1.a(var4)) {
               var2 = false;
               break;
            }
         }
      }

      return var2;
   }

   @Override
   public int hashCode() {
      Iterator var2 = this.a().values().iterator();
      int var1 = 0;

      while (var2.hasNext()) {
         zzbgo var3 = (zzbgo)var2.next();
         if (this.a(var3)) {
            var1 = this.b(var3).hashCode() + var1 * 31;
         }
      }

      return var1;
   }
}
