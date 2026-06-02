package com.bumptech.glide;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.MultiTransformation;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.UnitTransformation;
import com.bumptech.glide.manager.Lifecycle;
import com.bumptech.glide.manager.RequestTracker;
import com.bumptech.glide.provider.ChildLoadProvider;
import com.bumptech.glide.provider.LoadProvider;
import com.bumptech.glide.request.GenericRequest;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.request.RequestCoordinator;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.ThumbnailRequestCoordinator;
import com.bumptech.glide.request.animation.GlideAnimationFactory;
import com.bumptech.glide.request.animation.NoAnimation;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.signature.EmptySignature;
import com.bumptech.glide.util.Util;

public class GenericRequestBuilder<ModelType, DataType, ResourceType, TranscodeType> implements Cloneable {
   private boolean A;
   private Drawable B;
   private int C;
   protected final Class<ModelType> a;
   protected final Context b;
   protected final Glide c;
   protected final Class<TranscodeType> d;
   protected final RequestTracker e;
   protected final Lifecycle f;
   private ChildLoadProvider<ModelType, DataType, ResourceType, TranscodeType> g;
   private ModelType h;
   private Key i;
   private boolean j;
   private int k;
   private int l;
   private RequestListener<? super ModelType, TranscodeType> m;
   private Float n;
   private GenericRequestBuilder<?, ?, ?, TranscodeType> o;
   private Float p;
   private Drawable q;
   private Drawable r;
   private Priority s;
   private boolean t;
   private GlideAnimationFactory<TranscodeType> u;
   private int v;
   private int w;
   private DiskCacheStrategy x;
   private Transformation<ResourceType> y;
   private boolean z;

   GenericRequestBuilder(
      Context var1,
      Class<ModelType> var2,
      LoadProvider<ModelType, DataType, ResourceType, TranscodeType> var3,
      Class<TranscodeType> var4,
      Glide var5,
      RequestTracker var6,
      Lifecycle var7
   ) {
      Object var8 = null;
      super();
      this.i = EmptySignature.a();
      this.p = 1.0F;
      this.s = null;
      this.t = true;
      this.u = NoAnimation.a();
      this.v = -1;
      this.w = -1;
      this.x = DiskCacheStrategy.RESULT;
      this.y = UnitTransformation.get();
      this.b = var1;
      this.a = var2;
      this.d = var4;
      this.c = var5;
      this.e = var6;
      this.f = var7;
      ChildLoadProvider var9 = (ChildLoadProvider)var8;
      if (var3 != null) {
         var9 = new ChildLoadProvider(var3);
      }

      this.g = var9;
      if (var1 == null) {
         throw new NullPointerException("Context can't be null");
      }

      if (var2 != null && var3 == null) {
         throw new NullPointerException("LoadProvider must not be null");
      }
   }

   private Priority a() {
      Priority var1;
      if (this.s == Priority.LOW) {
         var1 = Priority.NORMAL;
      } else if (this.s == Priority.NORMAL) {
         var1 = Priority.HIGH;
      } else {
         var1 = Priority.IMMEDIATE;
      }

      return var1;
   }

   private Request a(Target<TranscodeType> var1, float var2, Priority var3, RequestCoordinator var4) {
      return GenericRequest.a(
         this.g,
         this.h,
         this.i,
         this.b,
         var3,
         var1,
         var2,
         this.q,
         this.k,
         this.r,
         this.l,
         this.B,
         this.C,
         this.m,
         var4,
         this.c.b(),
         this.y,
         this.d,
         this.t,
         this.u,
         this.w,
         this.v,
         this.x
      );
   }

   private Request a(Target<TranscodeType> var1, ThumbnailRequestCoordinator var2) {
      Request var5;
      if (this.o != null) {
         if (this.A) {
            throw new IllegalStateException(
               "You cannot use a request as both the main request and a thumbnail, consider using clone() on the request(s) passed to thumbnail()"
            );
         }

         if (this.o.u.equals(NoAnimation.a())) {
            this.o.u = this.u;
         }

         if (this.o.s == null) {
            this.o.s = this.a();
         }

         if (Util.a(this.w, this.v) && !Util.a(this.o.w, this.o.v)) {
            this.o.b(this.w, this.v);
         }

         var2 = new ThumbnailRequestCoordinator(var2);
         Request var3 = this.a(var1, this.p, this.s, var2);
         this.A = true;
         Request var4 = this.o.a(var1, var2);
         this.A = false;
         var2.a(var3, var4);
         var5 = var2;
      } else if (this.n != null) {
         var2 = new ThumbnailRequestCoordinator(var2);
         var2.a(this.a(var1, this.p, this.s, var2), this.a(var1, this.n, this.a(), var2));
         var5 = var2;
      } else {
         var5 = this.a(var1, this.p, this.s, var2);
      }

      return var5;
   }

   private Request b(Target<TranscodeType> var1) {
      if (this.s == null) {
         this.s = Priority.NORMAL;
      }

      return this.a(var1, null);
   }

   GenericRequestBuilder<ModelType, DataType, ResourceType, TranscodeType> a(GlideAnimationFactory<TranscodeType> var1) {
      if (var1 == null) {
         throw new NullPointerException("Animation factory must not be null!");
      }

      this.u = var1;
      return this;
   }

   public Target<TranscodeType> a(ImageView var1) {
      Util.a();
      if (var1 == null) {
         throw new IllegalArgumentException("You must pass in a non null View");
      }

      if (!this.z && var1.getScaleType() != null) {
         switch (<unrepresentable>.a[var1.getScaleType().ordinal()]) {
            case 1:
               this.h();
               break;
            case 2:
            case 3:
            case 4:
               this.g();
         }
      }

      return this.a(this.c.a(var1, this.d));
   }

   public <Y extends Target<TranscodeType>> Y a(Y var1) {
      Util.a();
      if (var1 == null) {
         throw new IllegalArgumentException("You must pass in a non null Target");
      }

      if (!this.j) {
         throw new IllegalArgumentException("You must first set a model (try #load())");
      }

      Request var2 = var1.getRequest();
      if (var2 != null) {
         var2.d();
         this.e.b(var2);
         var2.a();
      }

      var2 = this.b(var1);
      var1.setRequest(var2);
      this.f.a(var1);
      this.e.a(var2);
      return (Y)var1;
   }

   public GenericRequestBuilder<ModelType, DataType, ResourceType, TranscodeType> b(int var1, int var2) {
      if (!Util.a(var1, var2)) {
         throw new IllegalArgumentException("Width and height must be Target#SIZE_ORIGINAL or > 0");
      }

      this.w = var1;
      this.v = var2;
      return this;
   }

   public GenericRequestBuilder<ModelType, DataType, ResourceType, TranscodeType> b(Encoder<DataType> var1) {
      if (this.g != null) {
         this.g.a(var1);
      }

      return this;
   }

   public GenericRequestBuilder<ModelType, DataType, ResourceType, TranscodeType> b(Key var1) {
      if (var1 == null) {
         throw new NullPointerException("Signature must not be null");
      }

      this.i = var1;
      return this;
   }

   public GenericRequestBuilder<ModelType, DataType, ResourceType, TranscodeType> b(ResourceDecoder<DataType, ResourceType> var1) {
      if (this.g != null) {
         this.g.a(var1);
      }

      return this;
   }

   public GenericRequestBuilder<ModelType, DataType, ResourceType, TranscodeType> b(DiskCacheStrategy var1) {
      this.x = var1;
      return this;
   }

   public GenericRequestBuilder<ModelType, DataType, ResourceType, TranscodeType> b(RequestListener<? super ModelType, TranscodeType> var1) {
      this.m = var1;
      return this;
   }

   public GenericRequestBuilder<ModelType, DataType, ResourceType, TranscodeType> b(ModelType var1) {
      this.h = (ModelType)var1;
      this.j = true;
      return this;
   }

   public GenericRequestBuilder<ModelType, DataType, ResourceType, TranscodeType> b(boolean var1) {
      if (!var1) {
         var1 = true;
      } else {
         var1 = false;
      }

      this.t = var1;
      return this;
   }

   public GenericRequestBuilder<ModelType, DataType, ResourceType, TranscodeType> b(Transformation<ResourceType>... var1) {
      this.z = true;
      if (var1.length == 1) {
         this.y = var1[0];
      } else {
         this.y = new MultiTransformation<>(var1);
      }

      return this;
   }

   public GenericRequestBuilder<ModelType, DataType, ResourceType, TranscodeType> d(int var1) {
      this.l = var1;
      return this;
   }

   public GenericRequestBuilder<ModelType, DataType, ResourceType, TranscodeType> e(int var1) {
      this.C = var1;
      return this;
   }

   public GenericRequestBuilder<ModelType, DataType, ResourceType, TranscodeType> f(int var1) {
      this.k = var1;
      return this;
   }

   void g() {
   }

   void h() {
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   public GenericRequestBuilder<ModelType, DataType, ResourceType, TranscodeType> i() {
      ChildLoadProvider var1;
      GenericRequestBuilder var2;
      label20: {
         try {
            var2 = (GenericRequestBuilder)super.clone();
            if (this.g != null) {
               var1 = this.g.c();
               break label20;
            }
         } catch (CloneNotSupportedException var4) {
            throw new RuntimeException(var4);
         }

         var1 = null;
      }

      try {
         var2.g = var1;
         return var2;
      } catch (CloneNotSupportedException var3) {
         throw new RuntimeException(var3);
      }
   }

   public GenericRequestBuilder<ModelType, DataType, ResourceType, TranscodeType> j() {
      return this.a(NoAnimation.a());
   }

   public GenericRequestBuilder<ModelType, DataType, ResourceType, TranscodeType> k() {
      return this.b(UnitTransformation.get());
   }
}
