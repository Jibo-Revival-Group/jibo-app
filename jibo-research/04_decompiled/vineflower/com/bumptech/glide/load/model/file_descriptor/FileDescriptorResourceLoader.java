package com.bumptech.glide.load.model.file_descriptor;

import android.content.Context;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import com.bumptech.glide.load.model.GenericLoaderFactory;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.ResourceLoader;

public class FileDescriptorResourceLoader extends ResourceLoader<ParcelFileDescriptor> implements FileDescriptorModelLoader<Integer> {
   public FileDescriptorResourceLoader(Context var1, ModelLoader<Uri, ParcelFileDescriptor> var2) {
      super(var1, var2);
   }

   public static class Factory implements ModelLoaderFactory<Integer, ParcelFileDescriptor> {
      @Override
      public ModelLoader<Integer, ParcelFileDescriptor> build(Context var1, GenericLoaderFactory var2) {
         return new FileDescriptorResourceLoader(var1, var2.buildModelLoader(Uri.class, ParcelFileDescriptor.class));
      }

      @Override
      public void teardown() {
      }
   }
}
