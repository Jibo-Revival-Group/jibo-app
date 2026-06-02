package com.bumptech.glide;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.widget.ImageView;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.engine.Engine;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.engine.cache.MemoryCache;
import com.bumptech.glide.load.engine.prefill.BitmapPreFiller;
import com.bumptech.glide.load.model.GenericLoaderFactory;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.ImageVideoWrapper;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.file_descriptor.FileDescriptorFileLoader;
import com.bumptech.glide.load.model.file_descriptor.FileDescriptorResourceLoader;
import com.bumptech.glide.load.model.file_descriptor.FileDescriptorStringLoader;
import com.bumptech.glide.load.model.file_descriptor.FileDescriptorUriLoader;
import com.bumptech.glide.load.model.stream.HttpUrlGlideUrlLoader;
import com.bumptech.glide.load.model.stream.StreamByteArrayLoader;
import com.bumptech.glide.load.model.stream.StreamFileLoader;
import com.bumptech.glide.load.model.stream.StreamResourceLoader;
import com.bumptech.glide.load.model.stream.StreamStringLoader;
import com.bumptech.glide.load.model.stream.StreamUriLoader;
import com.bumptech.glide.load.model.stream.StreamUrlLoader;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.FileDescriptorBitmapDataLoadProvider;
import com.bumptech.glide.load.resource.bitmap.FitCenter;
import com.bumptech.glide.load.resource.bitmap.GlideBitmapDrawable;
import com.bumptech.glide.load.resource.bitmap.ImageVideoDataLoadProvider;
import com.bumptech.glide.load.resource.bitmap.StreamBitmapDataLoadProvider;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.load.resource.file.StreamFileDataLoadProvider;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.load.resource.gif.GifDrawableLoadProvider;
import com.bumptech.glide.load.resource.gifbitmap.GifBitmapWrapper;
import com.bumptech.glide.load.resource.gifbitmap.GifBitmapWrapperTransformation;
import com.bumptech.glide.load.resource.gifbitmap.ImageVideoGifDrawableLoadProvider;
import com.bumptech.glide.load.resource.transcode.GifBitmapWrapperDrawableTranscoder;
import com.bumptech.glide.load.resource.transcode.GlideBitmapDrawableTranscoder;
import com.bumptech.glide.load.resource.transcode.ResourceTranscoder;
import com.bumptech.glide.load.resource.transcode.TranscoderRegistry;
import com.bumptech.glide.manager.RequestManagerRetriever;
import com.bumptech.glide.provider.DataLoadProvider;
import com.bumptech.glide.provider.DataLoadProviderRegistry;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.request.target.ImageViewTargetFactory;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.util.Util;
import java.io.File;
import java.io.InputStream;
import java.net.URL;

public class Glide {
   private static volatile Glide a;
   private final GenericLoaderFactory b;
   private final Engine c;
   private final BitmapPool d;
   private final MemoryCache e;
   private final DecodeFormat f;
   private final ImageViewTargetFactory g = new ImageViewTargetFactory();
   private final TranscoderRegistry h = new TranscoderRegistry();
   private final DataLoadProviderRegistry i;
   private final CenterCrop j;
   private final GifBitmapWrapperTransformation k;
   private final FitCenter l;
   private final GifBitmapWrapperTransformation m;
   private final Handler n;
   private final BitmapPreFiller o;

   Glide(Engine var1, MemoryCache var2, BitmapPool var3, Context var4, DecodeFormat var5) {
      this.c = var1;
      this.d = var3;
      this.e = var2;
      this.f = var5;
      this.b = new GenericLoaderFactory(var4);
      this.n = new Handler(Looper.getMainLooper());
      this.o = new BitmapPreFiller(var2, var3, var5);
      this.i = new DataLoadProviderRegistry();
      StreamBitmapDataLoadProvider var6 = new StreamBitmapDataLoadProvider(var3, var5);
      this.i.a(InputStream.class, Bitmap.class, var6);
      FileDescriptorBitmapDataLoadProvider var8 = new FileDescriptorBitmapDataLoadProvider(var3, var5);
      this.i.a(ParcelFileDescriptor.class, Bitmap.class, var8);
      ImageVideoDataLoadProvider var7 = new ImageVideoDataLoadProvider(var6, var8);
      this.i.a(ImageVideoWrapper.class, Bitmap.class, var7);
      GifDrawableLoadProvider var9 = new GifDrawableLoadProvider(var4, var3);
      this.i.a(InputStream.class, GifDrawable.class, var9);
      this.i.a(ImageVideoWrapper.class, GifBitmapWrapper.class, new ImageVideoGifDrawableLoadProvider(var7, var9, var3));
      this.i.a(InputStream.class, File.class, new StreamFileDataLoadProvider());
      this.a(File.class, ParcelFileDescriptor.class, new FileDescriptorFileLoader.Factory());
      this.a(File.class, InputStream.class, new StreamFileLoader.Factory());
      this.a(int.class, ParcelFileDescriptor.class, new FileDescriptorResourceLoader.Factory());
      this.a(int.class, InputStream.class, new StreamResourceLoader.Factory());
      this.a(Integer.class, ParcelFileDescriptor.class, new FileDescriptorResourceLoader.Factory());
      this.a(Integer.class, InputStream.class, new StreamResourceLoader.Factory());
      this.a(String.class, ParcelFileDescriptor.class, new FileDescriptorStringLoader.Factory());
      this.a(String.class, InputStream.class, new StreamStringLoader.Factory());
      this.a(Uri.class, ParcelFileDescriptor.class, new FileDescriptorUriLoader.Factory());
      this.a(Uri.class, InputStream.class, new StreamUriLoader.Factory());
      this.a(URL.class, InputStream.class, new StreamUrlLoader.Factory());
      this.a(GlideUrl.class, InputStream.class, new HttpUrlGlideUrlLoader.Factory());
      this.a(byte[].class, InputStream.class, new StreamByteArrayLoader.Factory());
      this.h.register(Bitmap.class, GlideBitmapDrawable.class, new GlideBitmapDrawableTranscoder(var4.getResources(), var3));
      this.h
         .register(
            GifBitmapWrapper.class, GlideDrawable.class, new GifBitmapWrapperDrawableTranscoder(new GlideBitmapDrawableTranscoder(var4.getResources(), var3))
         );
      this.j = new CenterCrop(var3);
      this.k = new GifBitmapWrapperTransformation(var3, this.j);
      this.l = new FitCenter(var3);
      this.m = new GifBitmapWrapperTransformation(var3, this.l);
   }

   public static Glide a(Context param0) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.NullPointerException: Cannot invoke "org.jetbrains.java.decompiler.util.collections.fixed.FastFixedSet.contains(Object)" because "predset" is null
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.FastExtendedPostdominanceHelper.lambda$removeErroneousNodes$1(FastExtendedPostdominanceHelper.java:231)
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.FastExtendedPostdominanceHelper.iterateReachability(FastExtendedPostdominanceHelper.java:373)
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.FastExtendedPostdominanceHelper.removeErroneousNodes(FastExtendedPostdominanceHelper.java:207)
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.FastExtendedPostdominanceHelper.getExtendedPostdominators(FastExtendedPostdominanceHelper.java:63)
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.findGeneralStatement(DomHelper.java:537)
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.processStatement(DomHelper.java:472)
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.processStatement(DomHelper.java:379)
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:208)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 00: getstatic com/bumptech/glide/Glide.a Lcom/bumptech/glide/Glide;
      // 03: ifnonnull 83
      // 06: ldc com/bumptech/glide/Glide
      // 08: monitorenter
      // 09: getstatic com/bumptech/glide/Glide.a Lcom/bumptech/glide/Glide;
      // 0c: ifnonnull 80
      // 0f: aload 0
      // 10: invokevirtual android/content/Context.getApplicationContext ()Landroid/content/Context;
      // 13: astore 0
      // 14: new com/bumptech/glide/module/ManifestParser
      // 17: astore 1
      // 18: aload 1
      // 19: aload 0
      // 1a: invokespecial com/bumptech/glide/module/ManifestParser.<init> (Landroid/content/Context;)V
      // 1d: aload 1
      // 1e: invokevirtual com/bumptech/glide/module/ManifestParser.a ()Ljava/util/List;
      // 21: astore 2
      // 22: new com/bumptech/glide/GlideBuilder
      // 25: astore 1
      // 26: aload 1
      // 27: aload 0
      // 28: invokespecial com/bumptech/glide/GlideBuilder.<init> (Landroid/content/Context;)V
      // 2b: aload 2
      // 2c: invokeinterface java/util/List.iterator ()Ljava/util/Iterator; 1
      // 31: astore 3
      // 32: aload 3
      // 33: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 38: ifeq 54
      // 3b: aload 3
      // 3c: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 41: checkcast com/bumptech/glide/module/GlideModule
      // 44: aload 0
      // 45: aload 1
      // 46: invokeinterface com/bumptech/glide/module/GlideModule.a (Landroid/content/Context;Lcom/bumptech/glide/GlideBuilder;)V 3
      // 4b: goto 32
      // 4e: astore 0
      // 4f: ldc com/bumptech/glide/Glide
      // 51: monitorexit
      // 52: aload 0
      // 53: athrow
      // 54: aload 1
      // 55: invokevirtual com/bumptech/glide/GlideBuilder.a ()Lcom/bumptech/glide/Glide;
      // 58: putstatic com/bumptech/glide/Glide.a Lcom/bumptech/glide/Glide;
      // 5b: aload 2
      // 5c: invokeinterface java/util/List.iterator ()Ljava/util/Iterator; 1
      // 61: astore 1
      // 62: aload 1
      // 63: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 68: ifeq 80
      // 6b: aload 1
      // 6c: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 71: checkcast com/bumptech/glide/module/GlideModule
      // 74: aload 0
      // 75: getstatic com/bumptech/glide/Glide.a Lcom/bumptech/glide/Glide;
      // 78: invokeinterface com/bumptech/glide/module/GlideModule.a (Landroid/content/Context;Lcom/bumptech/glide/Glide;)V 3
      // 7d: goto 62
      // 80: ldc com/bumptech/glide/Glide
      // 82: monitorexit
      // 83: getstatic com/bumptech/glide/Glide.a Lcom/bumptech/glide/Glide;
      // 86: areturn
      // try (4 -> 25): 35 null
      // try (25 -> 34): 35 null
      // try (36 -> 38): 35 null
      // try (40 -> 46): 35 null
      // try (46 -> 55): 35 null
      // try (56 -> 58): 35 null
   }

   public static RequestManager a(FragmentActivity var0) {
      return RequestManagerRetriever.a().a(var0);
   }

   public static <T> ModelLoader<T, InputStream> a(Class<T> var0, Context var1) {
      return a(var0, InputStream.class, var1);
   }

   public static <T, Y> ModelLoader<T, Y> a(Class<T> var0, Class<Y> var1, Context var2) {
      ModelLoader var3;
      if (var0 == null) {
         if (Log.isLoggable("Glide", 3)) {
            Log.d("Glide", "Unable to load null model, setting placeholder only");
         }

         var3 = null;
      } else {
         var3 = a(var2).f().buildModelLoader(var0, var1);
      }

      return var3;
   }

   public static void a(Target<?> var0) {
      Util.a();
      Request var1 = var0.getRequest();
      if (var1 != null) {
         var1.d();
         var0.setRequest(null);
      }
   }

   public static RequestManager b(Context var0) {
      return RequestManagerRetriever.a().a(var0);
   }

   public static <T> ModelLoader<T, ParcelFileDescriptor> b(Class<T> var0, Context var1) {
      return a(var0, ParcelFileDescriptor.class, var1);
   }

   private GenericLoaderFactory f() {
      return this.b;
   }

   public BitmapPool a() {
      return this.d;
   }

   <Z, R> ResourceTranscoder<Z, R> a(Class<Z> var1, Class<R> var2) {
      return this.h.get(var1, var2);
   }

   <R> Target<R> a(ImageView var1, Class<R> var2) {
      return this.g.a(var1, var2);
   }

   public void a(int var1) {
      Util.a();
      this.e.trimMemory(var1);
      this.d.trimMemory(var1);
   }

   public <T, Y> void a(Class<T> var1, Class<Y> var2, ModelLoaderFactory<T, Y> var3) {
      ModelLoaderFactory var4 = this.b.register(var1, var2, var3);
      if (var4 != null) {
         var4.teardown();
      }
   }

   Engine b() {
      return this.c;
   }

   <T, Z> DataLoadProvider<T, Z> b(Class<T> var1, Class<Z> var2) {
      return this.i.a(var1, var2);
   }

   GifBitmapWrapperTransformation c() {
      return this.k;
   }

   GifBitmapWrapperTransformation d() {
      return this.m;
   }

   public void e() {
      Util.a();
      this.e.clearMemory();
      this.d.clearMemory();
   }
}
