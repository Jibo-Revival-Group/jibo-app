package com.bumptech.glide.load.data;

import android.content.res.AssetManager;
import android.os.ParcelFileDescriptor;
import java.io.IOException;

public class FileDescriptorAssetPathFetcher extends AssetPathFetcher<ParcelFileDescriptor> {
   public FileDescriptorAssetPathFetcher(AssetManager var1, String var2) {
      super(var1, var2);
   }

   protected ParcelFileDescriptor a(AssetManager var1, String var2) throws IOException {
      return var1.openFd(var2).getParcelFileDescriptor();
   }

   protected void a(ParcelFileDescriptor var1) throws IOException {
      var1.close();
   }
}
