package com.bumptech.glide.provider;

import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.resource.transcode.ResourceTranscoder;
import java.io.File;

public class ChildLoadProvider<A, T, Z, R> implements LoadProvider<A, T, Z, R>, Cloneable {
   private final LoadProvider<A, T, Z, R> a;
   private ResourceDecoder<File, Z> b;
   private ResourceDecoder<T, Z> c;
   private ResourceEncoder<Z> d;
   private ResourceTranscoder<Z, R> e;
   private Encoder<T> f;

   public ChildLoadProvider(LoadProvider<A, T, Z, R> var1) {
      this.a = var1;
   }

   @Override
   public ModelLoader<A, T> a() {
      return this.a.a();
   }

   public void a(Encoder<T> var1) {
      this.f = var1;
   }

   public void a(ResourceDecoder<T, Z> var1) {
      this.c = var1;
   }

   @Override
   public ResourceTranscoder<Z, R> b() {
      ResourceTranscoder var1;
      if (this.e != null) {
         var1 = this.e;
      } else {
         var1 = this.a.b();
      }

      return var1;
   }

   public ChildLoadProvider<A, T, Z, R> c() {
      try {
         return (ChildLoadProvider<A, T, Z, R>)super.clone();
      } catch (CloneNotSupportedException var2) {
         throw new RuntimeException(var2);
      }
   }

   @Override
   public ResourceDecoder<File, Z> getCacheDecoder() {
      ResourceDecoder var1;
      if (this.b != null) {
         var1 = this.b;
      } else {
         var1 = this.a.getCacheDecoder();
      }

      return var1;
   }

   @Override
   public ResourceEncoder<Z> getEncoder() {
      ResourceEncoder var1;
      if (this.d != null) {
         var1 = this.d;
      } else {
         var1 = this.a.getEncoder();
      }

      return var1;
   }

   @Override
   public ResourceDecoder<T, Z> getSourceDecoder() {
      ResourceDecoder var1;
      if (this.c != null) {
         var1 = this.c;
      } else {
         var1 = this.a.getSourceDecoder();
      }

      return var1;
   }

   @Override
   public Encoder<T> getSourceEncoder() {
      Encoder var1;
      if (this.f != null) {
         var1 = this.f;
      } else {
         var1 = this.a.getSourceEncoder();
      }

      return var1;
   }
}
