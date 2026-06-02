package com.bumptech.glide.load.model.stream;

import android.content.Context;
import android.net.Uri;
import com.bumptech.glide.load.model.GenericLoaderFactory;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.StringLoader;
import java.io.InputStream;

public class StreamStringLoader extends StringLoader<InputStream> implements StreamModelLoader<String> {
   public StreamStringLoader(ModelLoader<Uri, InputStream> var1) {
      super(var1);
   }

   public static class Factory implements ModelLoaderFactory<String, InputStream> {
      @Override
      public ModelLoader<String, InputStream> build(Context var1, GenericLoaderFactory var2) {
         return new StreamStringLoader(var2.buildModelLoader(Uri.class, InputStream.class));
      }

      @Override
      public void teardown() {
      }
   }
}
