package com.bumptech.glide.load.data;

import android.content.res.AssetManager;
import android.util.Log;
import com.bumptech.glide.Priority;
import java.io.IOException;

public abstract class AssetPathFetcher<T> implements DataFetcher<T> {
   private final AssetManager assetManager;
   private final String assetPath;
   private T data;

   public AssetPathFetcher(AssetManager var1, String var2) {
      this.assetManager = var1;
      this.assetPath = var2;
   }

   @Override
   public void cancel() {
   }

   @Override
   public void cleanup() {
      if (this.data != null) {
         try {
            this.close(this.data);
         } catch (IOException var2) {
            if (Log.isLoggable("AssetUriFetcher", 2)) {
               Log.v("AssetUriFetcher", "Failed to close data", var2);
            }
         }
      }
   }

   protected abstract void close(T var1) throws IOException;

   @Override
   public String getId() {
      return this.assetPath;
   }

   @Override
   public T loadData(Priority var1) throws Exception {
      this.data = this.loadResource(this.assetManager, this.assetPath);
      return this.data;
   }

   protected abstract T loadResource(AssetManager var1, String var2) throws IOException;
}
