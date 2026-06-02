package com.bumptech.glide.provider;

import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.resource.transcode.ResourceTranscoder;
import java.io.File;

public class FixedLoadProvider<A, T, Z, R> implements LoadProvider<A, T, Z, R> {
   private final ModelLoader<A, T> a;
   private final ResourceTranscoder<Z, R> b;
   private final DataLoadProvider<T, Z> c;

   public FixedLoadProvider(ModelLoader<A, T> var1, ResourceTranscoder<Z, R> var2, DataLoadProvider<T, Z> var3) {
      if (var1 == null) {
         throw new NullPointerException("ModelLoader must not be null");
      }

      this.a = var1;
      if (var2 == null) {
         throw new NullPointerException("Transcoder must not be null");
      }

      this.b = var2;
      if (var3 == null) {
         throw new NullPointerException("DataLoadProvider must not be null");
      }

      this.c = var3;
   }

   @Override
   public ModelLoader<A, T> a() {
      return this.a;
   }

   @Override
   public ResourceTranscoder<Z, R> b() {
      return this.b;
   }

   @Override
   public ResourceDecoder<File, Z> getCacheDecoder() {
      return this.c.getCacheDecoder();
   }

   @Override
   public ResourceEncoder<Z> getEncoder() {
      return this.c.getEncoder();
   }

   @Override
   public ResourceDecoder<T, Z> getSourceDecoder() {
      return this.c.getSourceDecoder();
   }

   @Override
   public Encoder<T> getSourceEncoder() {
      return this.c.getSourceEncoder();
   }
}
