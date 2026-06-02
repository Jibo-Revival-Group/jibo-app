package com.facebook.internal;

import com.facebook.FacebookException;
import java.util.Iterator;
import java.util.LinkedList;

public class CollectionMapper {
   private CollectionMapper() {
   }

   public static <T> void iterate(CollectionMapper.Collection<T> var0, CollectionMapper.ValueMapper var1, CollectionMapper.OnMapperCompleteListener var2) {
      Mutable var4 = new Mutable<>(false);
      Mutable var3 = new Mutable<>(1);
      var2 = new CollectionMapper.OnMapperCompleteListener(var4, var3, var2) {
         final Mutable val$didReturnError;
         final CollectionMapper.OnMapperCompleteListener val$onMapperCompleteListener;
         final Mutable val$pendingJobCount;

         {
            this.val$didReturnError = var1;
            this.val$pendingJobCount = var2x;
            this.val$onMapperCompleteListener = var3x;
         }

         @Override
         public void onComplete() {
            if (!(Boolean)this.val$didReturnError.value) {
               Mutable var1x = this.val$pendingJobCount;
               Integer var2x = (Integer)this.val$pendingJobCount.value - 1;
               var1x.value = (T)var2x;
               if (var2x == 0) {
                  this.val$onMapperCompleteListener.onComplete();
               }
            }
         }

         @Override
         public void onError(FacebookException var1) {
            if (!(Boolean)this.val$didReturnError.value) {
               this.val$didReturnError.value = (T)true;
               this.val$onMapperCompleteListener.onError(var1);
            }
         }
      };
      Iterator var5 = var0.keyIterator();
      LinkedList var9 = new LinkedList();

      while (var5.hasNext()) {
         var9.add(var5.next());
      }

      for (Integer var6 : var9) {
         Object var11 = var0.get(var6);
         CollectionMapper.OnMapValueCompleteListener var7 = new CollectionMapper.OnMapValueCompleteListener(var0, var6, var2) {
            final CollectionMapper.Collection val$collection;
            final CollectionMapper.OnMapperCompleteListener val$jobCompleteListener;
            final Object val$key;

            {
               this.val$collection = var1;
               this.val$key = var2x;
               this.val$jobCompleteListener = var3x;
            }

            @Override
            public void onComplete(Object var1) {
               this.val$collection.set(this.val$key, var1, this.val$jobCompleteListener);
               this.val$jobCompleteListener.onComplete();
            }

            @Override
            public void onError(FacebookException var1) {
               this.val$jobCompleteListener.onError(var1);
            }
         };
         var6 = (Integer)var3.value;
         var3.value = (T)(Integer)var3.value + 1;
         var1.mapValue(var11, var7);
      }

      var2.onComplete();
   }

   public interface Collection<T> {
      Object get(T var1);

      Iterator<T> keyIterator();

      void set(T var1, Object var2, CollectionMapper.OnErrorListener var3);
   }

   public interface OnErrorListener {
      void onError(FacebookException var1);
   }

   public interface OnMapValueCompleteListener extends CollectionMapper.OnErrorListener {
      void onComplete(Object var1);
   }

   public interface OnMapperCompleteListener extends CollectionMapper.OnErrorListener {
      void onComplete();
   }

   public interface ValueMapper {
      void mapValue(Object var1, CollectionMapper.OnMapValueCompleteListener var2);
   }
}
