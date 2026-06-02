package com.bumptech.glide.load.data;

import android.content.res.AssetManager;
import java.io.IOException;
import java.io.InputStream;

public class StreamAssetPathFetcher extends AssetPathFetcher<InputStream> {
   public StreamAssetPathFetcher(AssetManager var1, String var2) {
      super(var1, var2);
   }

   protected InputStream a(AssetManager var1, String var2) throws IOException {
      return var1.open(var2);
   }

   protected void a(InputStream var1) throws IOException {
      var1.close();
   }
}
