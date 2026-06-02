package com.bumptech.glide.load.model;

import android.content.Context;
import android.net.Uri;
import com.bumptech.glide.load.data.DataFetcher;

public abstract class UriLoader<T> implements ModelLoader<Uri, T> {
   private final Context context;
   private final ModelLoader<GlideUrl, T> urlLoader;

   public UriLoader(Context var1, ModelLoader<GlideUrl, T> var2) {
      this.context = var1;
      this.urlLoader = var2;
   }

   private static boolean isLocalUri(String var0) {
      boolean var1;
      if (!"file".equals(var0) && !"content".equals(var0) && !"android.resource".equals(var0)) {
         var1 = false;
      } else {
         var1 = true;
      }

      return var1;
   }

   protected abstract DataFetcher<T> getAssetPathFetcher(Context var1, String var2);

   protected abstract DataFetcher<T> getLocalUriFetcher(Context var1, Uri var2);

   public final DataFetcher<T> getResourceFetcher(Uri var1, int var2, int var3) {
      String var6 = var1.getScheme();
      Object var5 = null;
      DataFetcher var4;
      if (isLocalUri(var6)) {
         if (AssetUriParser.isAssetUri(var1)) {
            String var7 = AssetUriParser.toAssetPath(var1);
            var4 = this.getAssetPathFetcher(this.context, var7);
         } else {
            var4 = this.getLocalUriFetcher(this.context, var1);
         }
      } else {
         var4 = (DataFetcher)var5;
         if (this.urlLoader != null) {
            if (!"http".equals(var6)) {
               var4 = (DataFetcher)var5;
               if (!"https".equals(var6)) {
                  return var4;
               }
            }

            var4 = this.urlLoader.getResourceFetcher(new GlideUrl(var1.toString()), var2, var3);
         }
      }

      return var4;
   }
}
