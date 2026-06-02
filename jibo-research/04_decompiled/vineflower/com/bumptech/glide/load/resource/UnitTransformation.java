package com.bumptech.glide.load.resource;

import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.Resource;

public class UnitTransformation<T> implements Transformation<T> {
   private static final Transformation<?> TRANSFORMATION = new UnitTransformation();

   public static <T> UnitTransformation<T> get() {
      return (UnitTransformation<T>)TRANSFORMATION;
   }

   @Override
   public String getId() {
      return "";
   }

   @Override
   public Resource<T> transform(Resource<T> var1, int var2, int var3) {
      return var1;
   }
}
