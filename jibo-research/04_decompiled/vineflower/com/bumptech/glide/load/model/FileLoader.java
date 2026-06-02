package com.bumptech.glide.load.model;

import android.net.Uri;
import com.bumptech.glide.load.data.DataFetcher;
import java.io.File;

public class FileLoader<T> implements ModelLoader<File, T> {
   private final ModelLoader<Uri, T> uriLoader;

   public FileLoader(ModelLoader<Uri, T> var1) {
      this.uriLoader = var1;
   }

   public DataFetcher<T> getResourceFetcher(File var1, int var2, int var3) {
      return this.uriLoader.getResourceFetcher(Uri.fromFile(var1), var2, var3);
   }
}
