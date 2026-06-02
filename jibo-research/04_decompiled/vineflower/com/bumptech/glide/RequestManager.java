package com.bumptech.glide;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.manager.ConnectivityMonitor;
import com.bumptech.glide.manager.ConnectivityMonitorFactory;
import com.bumptech.glide.manager.Lifecycle;
import com.bumptech.glide.manager.LifecycleListener;
import com.bumptech.glide.manager.RequestManagerTreeNode;
import com.bumptech.glide.manager.RequestTracker;
import com.bumptech.glide.signature.ApplicationVersionSignature;
import com.bumptech.glide.util.Util;

public class RequestManager implements LifecycleListener {
   private final Context a;
   private final Lifecycle b;
   private final RequestManagerTreeNode c;
   private final RequestTracker d;
   private final Glide e;
   private final RequestManager.OptionsApplier f;
   private RequestManager.DefaultOptions g;

   public RequestManager(Context var1, Lifecycle var2, RequestManagerTreeNode var3) {
      this(var1, var2, var3, new RequestTracker(), new ConnectivityMonitorFactory());
   }

   RequestManager(Context var1, Lifecycle var2, RequestManagerTreeNode var3, RequestTracker var4, ConnectivityMonitorFactory var5) {
      this.a = var1.getApplicationContext();
      this.b = var2;
      this.c = var3;
      this.d = var4;
      this.e = Glide.a(var1);
      this.f = new RequestManager.OptionsApplier(this);
      ConnectivityMonitor var6 = var5.a(var1, new RequestManager.RequestManagerConnectivityListener(var4));
      if (Util.c()) {
         new Handler(Looper.getMainLooper()).post(new Runnable(this, var2) {
            final Lifecycle a;
            final RequestManager b;

            {
               this.b = var1;
               this.a = var2x;
            }

            @Override
            public void run() {
               this.a.a(this.b);
            }
         });
      } else {
         var2.a(this);
      }

      var2.a(var6);
   }

   private <T> DrawableTypeRequest<T> a(Class<T> var1) {
      ModelLoader var2 = Glide.a(var1, this.a);
      ModelLoader var3 = Glide.b(var1, this.a);
      if (var1 != null && var2 == null && var3 == null) {
         throw new IllegalArgumentException(
            "Unknown type "
               + var1
               + ". You must provide a Model of a type for"
               + " which there is a registered ModelLoader, if you are using a custom model, you must first call"
               + " Glide#register with a ModelLoaderFactory for your custom model class"
         );
      } else {
         return this.f.a(new DrawableTypeRequest<>(var1, var2, var3, this.a, this.e, this.d, this.b, this.f));
      }
   }

   private static <T> Class<T> b(T var0) {
      if (var0 != null) {
         var0 = var0.getClass();
      } else {
         var0 = null;
      }

      return var0;
   }

   public DrawableTypeRequest<Integer> a(Integer var1) {
      return (DrawableTypeRequest<Integer>)this.e().a(var1);
   }

   public DrawableTypeRequest<String> a(String var1) {
      return (DrawableTypeRequest<String>)this.d().a(var1);
   }

   public <A, T> RequestManager.GenericModelRequest<A, T> a(ModelLoader<A, T> var1, Class<T> var2) {
      return new RequestManager.GenericModelRequest<>(this, var1, var2);
   }

   public void a() {
      this.e.e();
   }

   public void a(int var1) {
      this.e.a(var1);
   }

   public void b() {
      Util.a();
      this.d.a();
   }

   public void c() {
      Util.a();
      this.d.b();
   }

   public DrawableTypeRequest<String> d() {
      return this.a(String.class);
   }

   public DrawableTypeRequest<Integer> e() {
      return (DrawableTypeRequest<Integer>)this.a(Integer.class).a(ApplicationVersionSignature.a(this.a));
   }

   @Override
   public void onDestroy() {
      this.d.c();
   }

   @Override
   public void onStart() {
      this.c();
   }

   @Override
   public void onStop() {
      this.b();
   }

   public interface DefaultOptions {
      <T> void a(GenericRequestBuilder<T, ?, ?, ?> var1);
   }

   public final class GenericModelRequest<A, T> {
      final RequestManager a;
      private final ModelLoader<A, T> b;
      private final Class<T> c;

      GenericModelRequest(RequestManager var1, ModelLoader var2, Class var3) {
         this.a = var1;
         this.b = var2;
         this.c = var3;
      }

      public RequestManager.GenericModelRequest<A, T>.GenericTypeRequest a(A var1) {
         return new RequestManager.GenericModelRequest.GenericTypeRequest(this, var1);
      }

      public final class GenericTypeRequest {
         final RequestManager.GenericModelRequest a;
         private final A b;
         private final Class<A> c;
         private final boolean d;

         GenericTypeRequest(A var1, Object var2) {
            this.a = var1;
            this.d = true;
            this.b = (A)var2;
            this.c = (Class<A>)RequestManager.b(var2);
         }

         public <Z> GenericTranscodeRequest<A, T, Z> a(Class<Z> var1) {
            GenericTranscodeRequest var2 = this.a
               .a
               .f
               .a(new GenericTranscodeRequest<>(this.a.a.a, this.a.a.e, this.c, this.a.b, this.a.c, var1, this.a.a.d, this.a.a.b, this.a.a.f));
            if (this.d) {
               var2.b(this.b);
            }

            return var2;
         }
      }
   }

   class OptionsApplier {
      final RequestManager a;

      OptionsApplier(RequestManager var1) {
         this.a = var1;
      }

      public <A, X extends GenericRequestBuilder<A, ?, ?, ?>> X a(X var1) {
         if (this.a.g != null) {
            this.a.g.a(var1);
         }

         return (X)var1;
      }
   }

   private static class RequestManagerConnectivityListener implements ConnectivityMonitor.ConnectivityListener {
      private final RequestTracker a;

      public RequestManagerConnectivityListener(RequestTracker var1) {
         this.a = var1;
      }

      @Override
      public void a(boolean var1) {
         if (var1) {
            this.a.d();
         }
      }
   }
}
