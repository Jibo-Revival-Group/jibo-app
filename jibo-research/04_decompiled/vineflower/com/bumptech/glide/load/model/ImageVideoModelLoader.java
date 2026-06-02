package com.bumptech.glide.load.model;

import android.os.ParcelFileDescriptor;
import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.data.DataFetcher;
import java.io.InputStream;

public class ImageVideoModelLoader<A> implements ModelLoader<A, ImageVideoWrapper> {
   private final ModelLoader<A, ParcelFileDescriptor> fileDescriptorLoader;
   private final ModelLoader<A, InputStream> streamLoader;

   public ImageVideoModelLoader(ModelLoader<A, InputStream> var1, ModelLoader<A, ParcelFileDescriptor> var2) {
      if (var1 == null && var2 == null) {
         throw new NullPointerException("At least one of streamLoader and fileDescriptorLoader must be non null");
      }

      this.streamLoader = var1;
      this.fileDescriptorLoader = var2;
   }

   @Override
   public DataFetcher<ImageVideoWrapper> getResourceFetcher(A var1, int var2, int var3) {
      ImageVideoModelLoader.ImageVideoFetcher var5 = null;
      DataFetcher var4;
      if (this.streamLoader != null) {
         var4 = this.streamLoader.getResourceFetcher((A)var1, var2, var3);
      } else {
         var4 = null;
      }

      if (this.fileDescriptorLoader != null) {
         var1 = this.fileDescriptorLoader.getResourceFetcher((A)var1, var2, var3);
      } else {
         var1 = null;
      }

      if (var4 != null || var1 != null) {
         var5 = new ImageVideoModelLoader.ImageVideoFetcher(var4, var1);
      }

      return var5;
   }

   static class ImageVideoFetcher implements DataFetcher<ImageVideoWrapper> {
      private final DataFetcher<ParcelFileDescriptor> fileDescriptorFetcher;
      private final DataFetcher<InputStream> streamFetcher;

      public ImageVideoFetcher(DataFetcher<InputStream> var1, DataFetcher<ParcelFileDescriptor> var2) {
         this.streamFetcher = var1;
         this.fileDescriptorFetcher = var2;
      }

      @Override
      public void cancel() {
         if (this.streamFetcher != null) {
            this.streamFetcher.cancel();
         }

         if (this.fileDescriptorFetcher != null) {
            this.fileDescriptorFetcher.cancel();
         }
      }

      @Override
      public void cleanup() {
         if (this.streamFetcher != null) {
            this.streamFetcher.cleanup();
         }

         if (this.fileDescriptorFetcher != null) {
            this.fileDescriptorFetcher.cleanup();
         }
      }

      @Override
      public String getId() {
         String var1;
         if (this.streamFetcher != null) {
            var1 = this.streamFetcher.getId();
         } else {
            var1 = this.fileDescriptorFetcher.getId();
         }

         return var1;
      }

      public ImageVideoWrapper loadData(Priority var1) throws Exception {
         InputStream var2;
         Object var4;
         label38: {
            var4 = null;
            if (this.streamFetcher != null) {
               try {
                  var2 = this.streamFetcher.loadData(var1);
                  break label38;
               } catch (Exception var6) {
                  if (Log.isLoggable("IVML", 2)) {
                     Log.v("IVML", "Exception fetching input stream, trying ParcelFileDescriptor", var6);
                  }

                  if (this.fileDescriptorFetcher == null) {
                     throw var6;
                  }
               }
            }

            var2 = null;
         }

         ParcelFileDescriptor var3 = (ParcelFileDescriptor)var4;
         if (this.fileDescriptorFetcher != null) {
            try {
               var3 = this.fileDescriptorFetcher.loadData(var1);
            } catch (Exception var5) {
               if (Log.isLoggable("IVML", 2)) {
                  Log.v("IVML", "Exception fetching ParcelFileDescriptor", var5);
               }

               var3 = (ParcelFileDescriptor)var4;
               if (var2 == null) {
                  throw var5;
               }
            }
         }

         return new ImageVideoWrapper(var2, var3);
      }
   }
}
