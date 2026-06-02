package com.bumptech.glide.load.resource;

import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.engine.Resource;
import java.io.OutputStream;

public class NullResourceEncoder<T> implements ResourceEncoder<T> {
   private static final NullResourceEncoder<?> NULL_ENCODER = new NullResourceEncoder();

   public static <T> NullResourceEncoder<T> get() {
      return (NullResourceEncoder<T>)NULL_ENCODER;
   }

   public boolean encode(Resource<T> var1, OutputStream var2) {
      return false;
   }

   @Override
   public String getId() {
      return "";
   }
}
