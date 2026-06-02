package com.bumptech.glide.load.model.file_descriptor;

import android.content.Context;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import com.bumptech.glide.load.model.GenericLoaderFactory;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.StringLoader;

public class FileDescriptorStringLoader extends StringLoader<ParcelFileDescriptor> implements FileDescriptorModelLoader<String> {
   public FileDescriptorStringLoader(ModelLoader<Uri, ParcelFileDescriptor> var1) {
      super(var1);
   }

   public static class Factory implements ModelLoaderFactory<String, ParcelFileDescriptor> {
      @Override
      public ModelLoader<String, ParcelFileDescriptor> build(Context var1, GenericLoaderFactory var2) {
         return new FileDescriptorStringLoader(var2.buildModelLoader(Uri.class, ParcelFileDescriptor.class));
      }

      @Override
      public void teardown() {
      }
   }
}
