package com.bumptech.glide.load.resource;

import com.bumptech.glide.load.Encoder;
import java.io.OutputStream;

public class NullEncoder<T> implements Encoder<T> {
   private static final NullEncoder<?> NULL_ENCODER = new NullEncoder();

   public static <T> Encoder<T> get() {
      return (Encoder<T>)NULL_ENCODER;
   }

   @Override
   public boolean encode(T var1, OutputStream var2) {
      return false;
   }

   @Override
   public String getId() {
      return "";
   }
}
