package com.bumptech.glide.load.resource.file;

import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import java.io.File;

public class FileDecoder implements ResourceDecoder<File, File> {
   public Resource<File> a(File var1, int var2, int var3) {
      return new FileResource(var1);
   }

   @Override
   public String getId() {
      return "";
   }
}
