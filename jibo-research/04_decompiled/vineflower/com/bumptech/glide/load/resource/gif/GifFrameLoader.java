package com.bumptech.glide.load.resource.gif;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.os.Handler.Callback;
import com.bumptech.glide.GenericRequestBuilder;
import com.bumptech.glide.Glide;
import com.bumptech.glide.gifdecoder.GifDecoder;
import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.NullEncoder;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.util.UUID;

class GifFrameLoader {
   private final GifFrameLoader.FrameCallback callback;
   private GifFrameLoader.DelayTarget current;
   private final GifDecoder gifDecoder;
   private final Handler handler;
   private boolean isCleared;
   private boolean isLoadPending;
   private boolean isRunning = false;
   private GenericRequestBuilder<GifDecoder, GifDecoder, Bitmap, Bitmap> requestBuilder;

   public GifFrameLoader(Context var1, GifFrameLoader.FrameCallback var2, GifDecoder var3, int var4, int var5) {
      this(var2, var3, null, getRequestBuilder(var1, var3, var4, var5, Glide.a(var1).a()));
   }

   GifFrameLoader(GifFrameLoader.FrameCallback var1, GifDecoder var2, Handler var3, GenericRequestBuilder<GifDecoder, GifDecoder, Bitmap, Bitmap> var4) {
      this.isLoadPending = false;
      Handler var5 = var3;
      if (var3 == null) {
         var5 = new Handler(Looper.getMainLooper(), new GifFrameLoader.FrameLoaderCallback(this));
      }

      this.callback = var1;
      this.gifDecoder = var2;
      this.handler = var5;
      this.requestBuilder = var4;
   }

   private static GenericRequestBuilder<GifDecoder, GifDecoder, Bitmap, Bitmap> getRequestBuilder(
      Context var0, GifDecoder var1, int var2, int var3, BitmapPool var4
   ) {
      GifFrameResourceDecoder var6 = new GifFrameResourceDecoder(var4);
      GifFrameModelLoader var5 = new GifFrameModelLoader();
      Encoder var7 = NullEncoder.get();
      return Glide.b(var0).a(var5, GifDecoder.class).a(var1).a(Bitmap.class).b(var7).b(var6).b(true).b(DiskCacheStrategy.NONE).b(var2, var3);
   }

   private void loadNextFrame() {
      if (this.isRunning && !this.isLoadPending) {
         this.isLoadPending = true;
         this.gifDecoder.a();
         long var1 = SystemClock.uptimeMillis();
         long var3 = this.gifDecoder.b();
         GifFrameLoader.DelayTarget var5 = new GifFrameLoader.DelayTarget(this.handler, this.gifDecoder.d(), var1 + var3);
         this.requestBuilder.b(new GifFrameLoader.FrameSignature()).a(var5);
      }
   }

   public void clear() {
      this.stop();
      if (this.current != null) {
         Glide.a(this.current);
         this.current = null;
      }

      this.isCleared = true;
   }

   public Bitmap getCurrentFrame() {
      Bitmap var1;
      if (this.current != null) {
         var1 = this.current.getResource();
      } else {
         var1 = null;
      }

      return var1;
   }

   void onFrameReady(GifFrameLoader.DelayTarget var1) {
      if (this.isCleared) {
         this.handler.obtainMessage(2, var1).sendToTarget();
      } else {
         GifFrameLoader.DelayTarget var2 = this.current;
         this.current = var1;
         this.callback.onFrameReady(var1.index);
         if (var2 != null) {
            this.handler.obtainMessage(2, var2).sendToTarget();
         }

         this.isLoadPending = false;
         this.loadNextFrame();
      }
   }

   public void setFrameTransformation(Transformation<Bitmap> var1) {
      if (var1 == null) {
         throw new NullPointerException("Transformation must not be null");
      }

      this.requestBuilder = this.requestBuilder.b(var1);
   }

   public void start() {
      if (!this.isRunning) {
         this.isRunning = true;
         this.isCleared = false;
         this.loadNextFrame();
      }
   }

   public void stop() {
      this.isRunning = false;
   }

   static class DelayTarget extends SimpleTarget<Bitmap> {
      private final Handler handler;
      private final int index;
      private Bitmap resource;
      private final long targetTime;

      public DelayTarget(Handler var1, int var2, long var3) {
         this.handler = var1;
         this.index = var2;
         this.targetTime = var3;
      }

      public Bitmap getResource() {
         return this.resource;
      }

      public void onResourceReady(Bitmap var1, GlideAnimation<? super Bitmap> var2) {
         this.resource = var1;
         Message var3 = this.handler.obtainMessage(1, this);
         this.handler.sendMessageAtTime(var3, this.targetTime);
      }
   }

   public interface FrameCallback {
      void onFrameReady(int var1);
   }

   private class FrameLoaderCallback implements Callback {
      final GifFrameLoader this$0;

      private FrameLoaderCallback(GifFrameLoader var1) {
         this.this$0 = var1;
      }

      public boolean handleMessage(Message var1) {
         boolean var2;
         if (var1.what == 1) {
            GifFrameLoader.DelayTarget var3 = (GifFrameLoader.DelayTarget)var1.obj;
            this.this$0.onFrameReady(var3);
            var2 = true;
         } else {
            if (var1.what == 2) {
               Glide.a((GifFrameLoader.DelayTarget)var1.obj);
            }

            var2 = false;
         }

         return var2;
      }
   }

   static class FrameSignature implements Key {
      private final UUID uuid;

      public FrameSignature() {
         this(UUID.randomUUID());
      }

      FrameSignature(UUID var1) {
         this.uuid = var1;
      }

      @Override
      public boolean equals(Object var1) {
         boolean var2;
         if (var1 instanceof GifFrameLoader.FrameSignature) {
            var2 = ((GifFrameLoader.FrameSignature)var1).uuid.equals(this.uuid);
         } else {
            var2 = false;
         }

         return var2;
      }

      @Override
      public int hashCode() {
         return this.uuid.hashCode();
      }

      @Override
      public void updateDiskCacheKey(MessageDigest var1) throws UnsupportedEncodingException {
         throw new UnsupportedOperationException("Not implemented");
      }
   }
}
