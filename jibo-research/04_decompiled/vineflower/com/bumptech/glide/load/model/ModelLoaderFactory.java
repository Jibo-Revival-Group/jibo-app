package com.bumptech.glide.load.model;

import android.content.Context;

public interface ModelLoaderFactory<T, Y> {
   ModelLoader<T, Y> build(Context var1, GenericLoaderFactory var2);

   void teardown();
}
