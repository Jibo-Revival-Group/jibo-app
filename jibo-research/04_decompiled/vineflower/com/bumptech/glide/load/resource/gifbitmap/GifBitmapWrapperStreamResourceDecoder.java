package com.bumptech.glide.load.resource.gifbitmap;

import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.model.ImageVideoWrapper;
import java.io.IOException;
import java.io.InputStream;

public class GifBitmapWrapperStreamResourceDecoder implements ResourceDecoder<InputStream, GifBitmapWrapper> {
   private final ResourceDecoder<ImageVideoWrapper, GifBitmapWrapper> gifBitmapDecoder;

   public GifBitmapWrapperStreamResourceDecoder(ResourceDecoder<ImageVideoWrapper, GifBitmapWrapper> var1) {
      this.gifBitmapDecoder = var1;
   }

   public Resource<GifBitmapWrapper> decode(InputStream var1, int var2, int var3) throws IOException {
      return this.gifBitmapDecoder.decode(new ImageVideoWrapper(var1, null), var2, var3);
   }

   @Override
   public String getId() {
      return this.gifBitmapDecoder.getId();
   }
}
