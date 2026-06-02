package com.bumptech.glide.load.model;

import com.bumptech.glide.load.data.DataFetcher;

public interface ModelLoader<T, Y> {
   DataFetcher<Y> getResourceFetcher(T var1, int var2, int var3);
}
