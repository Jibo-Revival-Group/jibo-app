package com.bumptech.glide.request;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.Engine;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.resource.transcode.ResourceTranscoder;
import com.bumptech.glide.provider.LoadProvider;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.animation.GlideAnimationFactory;
import com.bumptech.glide.request.target.SizeReadyCallback;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.util.LogTime;
import com.bumptech.glide.util.Util;
import java.io.Serializable;
import java.util.Queue;

public final class GenericRequest<A, T, Z, R> implements Request, ResourceCallback, SizeReadyCallback {
   private static final Queue<GenericRequest<?, ?, ?, ?>> a = Util.a(0);
   private Resource<?> A;
   private Engine.LoadStatus B;
   private long C;
   private GenericRequest.Status D;
   private final String b = String.valueOf(this.hashCode());
   private Key c;
   private Drawable d;
   private int e;
   private int f;
   private int g;
   private Context h;
   private Transformation<Z> i;
   private LoadProvider<A, T, Z, R> j;
   private RequestCoordinator k;
   private A l;
   private Class<R> m;
   private boolean n;
   private Priority o;
   private Target<R> p;
   private RequestListener<? super A, R> q;
   private float r;
   private Engine s;
   private GlideAnimationFactory<R> t;
   private int u;
   private int v;
   private DiskCacheStrategy w;
   private Drawable x;
   private Drawable y;
   private boolean z;

   private GenericRequest() {
   }

   public static <A, T, Z, R> GenericRequest<A, T, Z, R> a(
      LoadProvider<A, T, Z, R> var0,
      A var1,
      Key var2,
      Context var3,
      Priority var4,
      Target<R> var5,
      float var6,
      Drawable var7,
      int var8,
      Drawable var9,
      int var10,
      Drawable var11,
      int var12,
      RequestListener<? super A, R> var13,
      RequestCoordinator var14,
      Engine var15,
      Transformation<Z> var16,
      Class<R> var17,
      boolean var18,
      GlideAnimationFactory<R> var19,
      int var20,
      int var21,
      DiskCacheStrategy var22
   ) {
      GenericRequest var24 = a.poll();
      GenericRequest var23 = var24;
      if (var24 == null) {
         var23 = new GenericRequest();
      }

      var23.b(
         var0, var1, var2, var3, var4, var5, var6, var7, var8, var9, var10, var11, var12, var13, var14, var15, var16, var17, var18, var19, var20, var21, var22
      );
      return var23;
   }

   private void a(Resource var1) {
      this.s.release(var1);
      this.A = null;
   }

   private void a(Resource<?> var1, R var2) {
      boolean var3 = this.p();
      this.D = GenericRequest.Status.COMPLETE;
      this.A = var1;
      if (this.q == null || !this.q.a((R)var2, this.l, this.p, this.z, var3)) {
         GlideAnimation var4 = this.t.a(this.z, var3);
         this.p.onResourceReady((R)var2, var4);
      }

      this.q();
      if (Log.isLoggable("GenericRequest", 2)) {
         this.a("Resource ready in " + LogTime.a(this.C) + " size: " + var1.getSize() * 9.536743E-7F + " fromCache: " + this.z);
      }
   }

   private void a(Exception var1) {
      if (this.o()) {
         Drawable var3;
         if (this.l == null) {
            var3 = this.k();
         } else {
            var3 = null;
         }

         Drawable var2 = var3;
         if (var3 == null) {
            var2 = this.l();
         }

         var3 = var2;
         if (var2 == null) {
            var3 = this.m();
         }

         this.p.onLoadFailed(var1, var3);
      }
   }

   private void a(String var1) {
      Log.v("GenericRequest", var1 + " this: " + this.b);
   }

   private static void a(String var0, Object var1, String var2) {
      if (var1 == null) {
         StringBuilder var3 = new StringBuilder(var0);
         var3.append(" must not be null");
         if (var2 != null) {
            var3.append(", ");
            var3.append(var2);
         }

         throw new NullPointerException(var3.toString());
      }
   }

   private void b(
      LoadProvider<A, T, Z, R> var1,
      A var2,
      Key var3,
      Context var4,
      Priority var5,
      Target<R> var6,
      float var7,
      Drawable var8,
      int var9,
      Drawable var10,
      int var11,
      Drawable var12,
      int var13,
      RequestListener<? super A, R> var14,
      RequestCoordinator var15,
      Engine var16,
      Transformation<Z> var17,
      Class<R> var18,
      boolean var19,
      GlideAnimationFactory<R> var20,
      int var21,
      int var22,
      DiskCacheStrategy var23
   ) {
      this.j = var1;
      this.l = (A)var2;
      this.c = var3;
      this.d = var12;
      this.e = var13;
      this.h = var4.getApplicationContext();
      this.o = var5;
      this.p = var6;
      this.r = var7;
      this.x = var8;
      this.f = var9;
      this.y = var10;
      this.g = var11;
      this.q = var14;
      this.k = var15;
      this.s = var16;
      this.i = var17;
      this.m = var18;
      this.n = var19;
      this.t = var20;
      this.u = var21;
      this.v = var22;
      this.w = var23;
      this.D = GenericRequest.Status.PENDING;
      if (var2 != null) {
         a("ModelLoader", var1.a(), "try .using(ModelLoader)");
         a("Transcoder", var1.b(), "try .as*(Class).transcode(ResourceTranscoder)");
         a("Transformation", var17, "try .transform(UnitTransformation.get())");
         if (var23.cacheSource()) {
            a("SourceEncoder", var1.getSourceEncoder(), "try .sourceEncoder(Encoder) or .diskCacheStrategy(NONE/RESULT)");
         } else {
            a("SourceDecoder", var1.getSourceDecoder(), "try .decoder/.imageDecoder/.videoDecoder(ResourceDecoder) or .diskCacheStrategy(ALL/SOURCE)");
         }

         if (var23.cacheSource() || var23.cacheResult()) {
            a("CacheDecoder", var1.getCacheDecoder(), "try .cacheDecoder(ResouceDecoder) or .diskCacheStrategy(NONE)");
         }

         if (var23.cacheResult()) {
            a("Encoder", var1.getEncoder(), "try .encode(ResourceEncoder) or .diskCacheStrategy(NONE/SOURCE)");
         }
      }
   }

   private Drawable k() {
      if (this.d == null && this.e > 0) {
         this.d = this.h.getResources().getDrawable(this.e);
      }

      return this.d;
   }

   private Drawable l() {
      if (this.y == null && this.g > 0) {
         this.y = this.h.getResources().getDrawable(this.g);
      }

      return this.y;
   }

   private Drawable m() {
      if (this.x == null && this.f > 0) {
         this.x = this.h.getResources().getDrawable(this.f);
      }

      return this.x;
   }

   private boolean n() {
      boolean var1;
      if (this.k != null && !this.k.a(this)) {
         var1 = false;
      } else {
         var1 = true;
      }

      return var1;
   }

   private boolean o() {
      boolean var1;
      if (this.k != null && !this.k.b(this)) {
         var1 = false;
      } else {
         var1 = true;
      }

      return var1;
   }

   private boolean p() {
      boolean var1;
      if (this.k != null && this.k.c()) {
         var1 = false;
      } else {
         var1 = true;
      }

      return var1;
   }

   private void q() {
      if (this.k != null) {
         this.k.c(this);
      }
   }

   @Override
   public void a() {
      this.j = null;
      this.l = null;
      this.h = null;
      this.p = null;
      this.x = null;
      this.y = null;
      this.d = null;
      this.q = null;
      this.k = null;
      this.i = null;
      this.t = null;
      this.z = false;
      this.B = null;
      a.offer(this);
   }

   @Override
   public void a(int var1, int var2) {
      if (Log.isLoggable("GenericRequest", 2)) {
         this.a("Got onSizeReady in " + LogTime.a(this.C));
      }

      if (this.D == GenericRequest.Status.WAITING_FOR_SIZE) {
         this.D = GenericRequest.Status.RUNNING;
         var1 = Math.round(this.r * var1);
         var2 = Math.round(this.r * var2);
         DataFetcher var4 = this.j.a().getResourceFetcher(this.l, var1, var2);
         if (var4 == null) {
            this.onException(new Exception("Failed to load model: '" + this.l + "'"));
         } else {
            ResourceTranscoder var5 = this.j.b();
            if (Log.isLoggable("GenericRequest", 2)) {
               this.a("finished setup for calling load in " + LogTime.a(this.C));
            }

            this.z = true;
            this.B = this.s.load(this.c, var1, var2, var4, this.j, this.i, var5, this.o, this.n, this.w, this);
            boolean var3;
            if (this.A != null) {
               var3 = true;
            } else {
               var3 = false;
            }

            this.z = var3;
            if (Log.isLoggable("GenericRequest", 2)) {
               this.a("finished onSizeReady in " + LogTime.a(this.C));
            }
         }
      }
   }

   @Override
   public void b() {
      this.C = LogTime.a();
      if (this.l == null) {
         this.onException(null);
      } else {
         this.D = GenericRequest.Status.WAITING_FOR_SIZE;
         if (Util.a(this.u, this.v)) {
            this.a(this.u, this.v);
         } else {
            this.p.getSize(this);
         }

         if (!this.g() && !this.j() && this.o()) {
            this.p.onLoadStarted(this.m());
         }

         if (Log.isLoggable("GenericRequest", 2)) {
            this.a("finished run method in " + LogTime.a(this.C));
         }
      }
   }

   void c() {
      this.D = GenericRequest.Status.CANCELLED;
      if (this.B != null) {
         this.B.cancel();
         this.B = null;
      }
   }

   @Override
   public void d() {
      Util.a();
      if (this.D != GenericRequest.Status.CLEARED) {
         this.c();
         if (this.A != null) {
            this.a(this.A);
         }

         if (this.o()) {
            this.p.onLoadCleared(this.m());
         }

         this.D = GenericRequest.Status.CLEARED;
      }
   }

   @Override
   public void e() {
      this.d();
      this.D = GenericRequest.Status.PAUSED;
   }

   @Override
   public boolean f() {
      boolean var1;
      if (this.D != GenericRequest.Status.RUNNING && this.D != GenericRequest.Status.WAITING_FOR_SIZE) {
         var1 = false;
      } else {
         var1 = true;
      }

      return var1;
   }

   @Override
   public boolean g() {
      boolean var1;
      if (this.D == GenericRequest.Status.COMPLETE) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   @Override
   public boolean h() {
      return this.g();
   }

   @Override
   public boolean i() {
      boolean var1;
      if (this.D != GenericRequest.Status.CANCELLED && this.D != GenericRequest.Status.CLEARED) {
         var1 = false;
      } else {
         var1 = true;
      }

      return var1;
   }

   public boolean j() {
      boolean var1;
      if (this.D == GenericRequest.Status.FAILED) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   @Override
   public void onException(Exception var1) {
      if (Log.isLoggable("GenericRequest", 3)) {
         Log.d("GenericRequest", "load failed", var1);
      }

      this.D = GenericRequest.Status.FAILED;
      if (this.q == null || !this.q.a(var1, this.l, this.p, this.p())) {
         this.a(var1);
      }
   }

   @Override
   public void onResourceReady(Resource<?> var1) {
      if (var1 == null) {
         this.onException(new Exception("Expected to receive a Resource<R> with an object of " + this.m + " inside, but instead got null."));
      } else {
         Object var3 = var1.get();
         if (var3 == null || !this.m.isAssignableFrom(var3.getClass())) {
            this.a(var1);
            StringBuilder var4 = new StringBuilder().append("Expected to receive an object of ").append(this.m).append(" but instead got ");
            Serializable var2;
            if (var3 != null) {
               var2 = var3.getClass();
            } else {
               var2 = "";
            }

            var2 = var4.append(var2).append("{").append(var3).append("}").append(" inside Resource{").append(var1).append("}.");
            String var5;
            if (var3 != null) {
               var5 = "";
            } else {
               var5 = " To indicate failure return a null Resource object, rather than a Resource object containing null data.";
            }

            this.onException(new Exception(var2.append(var5).toString()));
         } else if (!this.n()) {
            this.a(var1);
            this.D = GenericRequest.Status.COMPLETE;
         } else {
            this.a(var1, (R)var3);
         }
      }
   }

   private enum Status {
      CANCELLED,
      CLEARED,
      COMPLETE,
      FAILED,
      PAUSED,
      PENDING,
      RUNNING,
      WAITING_FOR_SIZE;

      private static final GenericRequest.Status[] $VALUES = new GenericRequest.Status[]{
         GenericRequest.Status.PENDING,
         GenericRequest.Status.RUNNING,
         GenericRequest.Status.WAITING_FOR_SIZE,
         GenericRequest.Status.COMPLETE,
         GenericRequest.Status.FAILED,
         GenericRequest.Status.CANCELLED,
         GenericRequest.Status.CLEARED,
         GenericRequest.Status.PAUSED
      };
   }
}
