package com.bumptech.glide.load.model.file_descriptor;

import android.content.Context;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import com.bumptech.glide.load.model.FileLoader;
import com.bumptech.glide.load.model.GenericLoaderFactory;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import java.io.File;

public class FileDescriptorFileLoader extends FileLoader<ParcelFileDescriptor> implements FileDescriptorModelLoader<File> {
   public FileDescriptorFileLoader(ModelLoader<Uri, ParcelFileDescriptor> var1) {
      super(var1);
   }

   public static class Factory implements ModelLoaderFactory<File, ParcelFileDescriptor> {
      @Override
      public ModelLoader<File, ParcelFileDescriptor> build(Context var1, GenericLoaderFactory var2) {
         return new FileDescriptorFileLoader(var2.buildModelLoader(Uri.class, ParcelFileDescriptor.class));
      }

      @Override
      public void teardown() {
      }
   }
}
