package com.bumptech.glide.load.data;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileDescriptorLocalUriFetcher extends LocalUriFetcher<ParcelFileDescriptor> {
   public FileDescriptorLocalUriFetcher(Context var1, Uri var2) {
      super(var1, var2);
   }

   protected ParcelFileDescriptor a(Uri var1, ContentResolver var2) throws FileNotFoundException {
      return var2.openAssetFileDescriptor(var1, "r").getParcelFileDescriptor();
   }

   protected void a(ParcelFileDescriptor var1) throws IOException {
      var1.close();
   }
}
