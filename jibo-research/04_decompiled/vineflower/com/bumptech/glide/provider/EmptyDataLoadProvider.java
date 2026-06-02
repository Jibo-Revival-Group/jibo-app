package com.bumptech.glide.provider;

import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.ResourceEncoder;
import java.io.File;

public class EmptyDataLoadProvider<T, Z> implements DataLoadProvider<T, Z> {
   private static final DataLoadProvider<?, ?> a = new EmptyDataLoadProvider();

   public static <T, Z> DataLoadProvider<T, Z> a() {
      return (DataLoadProvider<T, Z>)a;
   }

   @Override
   public ResourceDecoder<File, Z> getCacheDecoder() {
      return null;
   }

   @Override
   public ResourceEncoder<Z> getEncoder() {
      return null;
   }

   @Override
   public ResourceDecoder<T, Z> getSourceDecoder() {
      return null;
   }

   @Override
   public Encoder<T> getSourceEncoder() {
      return null;
   }
}
