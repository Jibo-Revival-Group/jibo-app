package com.bumptech.glide.load.model;

import com.bumptech.glide.load.data.DataFetcher;
import java.net.URL;

public class UrlLoader<T> implements ModelLoader<URL, T> {
   private final ModelLoader<GlideUrl, T> glideUrlLoader;

   public UrlLoader(ModelLoader<GlideUrl, T> var1) {
      this.glideUrlLoader = var1;
   }

   public DataFetcher<T> getResourceFetcher(URL var1, int var2, int var3) {
      return this.glideUrlLoader.getResourceFetcher(new GlideUrl(var1), var2, var3);
   }
}
