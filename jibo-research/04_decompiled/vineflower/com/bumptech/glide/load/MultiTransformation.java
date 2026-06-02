package com.bumptech.glide.load;

import com.bumptech.glide.load.engine.Resource;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public class MultiTransformation<T> implements Transformation<T> {
   private String id;
   private final Collection<? extends Transformation<T>> transformations;

   @SafeVarargs
   public MultiTransformation(Transformation<T>... var1) {
      if (var1.length < 1) {
         throw new IllegalArgumentException("MultiTransformation must contain at least one Transformation");
      }

      this.transformations = Arrays.asList(var1);
   }

   @Override
   public String getId() {
      if (this.id == null) {
         StringBuilder var1 = new StringBuilder();
         Iterator var2 = this.transformations.iterator();

         while (var2.hasNext()) {
            var1.append(((Transformation)var2.next()).getId());
         }

         this.id = var1.toString();
      }

      return this.id;
   }

   @Override
   public Resource<T> transform(Resource<T> var1, int var2, int var3) {
      Iterator var6 = this.transformations.iterator();
      Resource var4 = var1;

      while (var6.hasNext()) {
         Resource var5 = ((Transformation)var6.next()).transform(var4, var2, var3);
         if (var4 != null && !var4.equals(var1) && !var4.equals(var5)) {
            var4.recycle();
         }

         var4 = var5;
      }

      return var4;
   }
}
