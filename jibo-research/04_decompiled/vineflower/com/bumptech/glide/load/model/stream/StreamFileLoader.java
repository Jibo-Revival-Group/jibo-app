package com.bumptech.glide.load.model.stream;

import android.content.Context;
import android.net.Uri;
import com.bumptech.glide.load.model.FileLoader;
import com.bumptech.glide.load.model.GenericLoaderFactory;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import java.io.File;
import java.io.InputStream;

public class StreamFileLoader extends FileLoader<InputStream> implements StreamModelLoader<File> {
   public StreamFileLoader(ModelLoader<Uri, InputStream> var1) {
      super(var1);
   }

   public static class Factory implements ModelLoaderFactory<File, InputStream> {
      @Override
      public ModelLoader<File, InputStream> build(Context var1, GenericLoaderFactory var2) {
         return new StreamFileLoader(var2.buildModelLoader(Uri.class, InputStream.class));
      }

      @Override
      public void teardown() {
      }
   }
}
