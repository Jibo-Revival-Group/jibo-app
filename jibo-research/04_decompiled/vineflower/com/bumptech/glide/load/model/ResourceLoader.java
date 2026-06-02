package com.bumptech.glide.load.model;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.net.Uri;
import android.util.Log;
import com.bumptech.glide.load.data.DataFetcher;

public class ResourceLoader<T> implements ModelLoader<Integer, T> {
   private final Resources resources;
   private final ModelLoader<Uri, T> uriLoader;

   public ResourceLoader(Context var1, ModelLoader<Uri, T> var2) {
      this(var1.getResources(), var2);
   }

   public ResourceLoader(Resources var1, ModelLoader<Uri, T> var2) {
      this.resources = var1;
      this.uriLoader = var2;
   }

   public DataFetcher<T> getResourceFetcher(Integer var1, int var2, int var3) {
      DataFetcher var4 = null;

      label23: {
         Uri var8;
         try {
            StringBuilder var5 = new StringBuilder();
            var8 = Uri.parse(
               var5.append("android.resource://")
                  .append(this.resources.getResourcePackageName(var1))
                  .append('/')
                  .append(this.resources.getResourceTypeName(var1))
                  .append('/')
                  .append(this.resources.getResourceEntryName(var1))
                  .toString()
            );
         } catch (NotFoundException var6) {
            if (Log.isLoggable("ResourceLoader", 5)) {
               Log.w("ResourceLoader", "Received invalid resource id: " + var1, var6);
            }

            var7 = null;
            break label23;
         }

         var7 = var8;
      }

      if (var7 != null) {
         var4 = this.uriLoader.getResourceFetcher(var7, var2, var3);
      }

      return var4;
   }
}
