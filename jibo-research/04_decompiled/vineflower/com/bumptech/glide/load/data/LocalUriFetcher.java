package com.bumptech.glide.load.data;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.util.Log;
import com.bumptech.glide.Priority;
import java.io.FileNotFoundException;
import java.io.IOException;

public abstract class LocalUriFetcher<T> implements DataFetcher<T> {
   private final Context context;
   private T data;
   private final Uri uri;

   public LocalUriFetcher(Context var1, Uri var2) {
      this.context = var1.getApplicationContext();
      this.uri = var2;
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
            if (Log.isLoggable("LocalUriFetcher", 2)) {
               Log.v("LocalUriFetcher", "failed to close data", var2);
            }
         }
      }
   }

   protected abstract void close(T var1) throws IOException;

   @Override
   public String getId() {
      return this.uri.toString();
   }

   @Override
   public final T loadData(Priority var1) throws Exception {
      ContentResolver var2 = this.context.getContentResolver();
      this.data = this.loadResource(this.uri, var2);
      return this.data;
   }

   protected abstract T loadResource(Uri var1, ContentResolver var2) throws FileNotFoundException;
}
