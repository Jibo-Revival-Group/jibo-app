package com.bumptech.glide.load;

import com.bumptech.glide.load.engine.Resource;

public interface Transformation<T> {
   String getId();

   Resource<T> transform(Resource<T> var1, int var2, int var3);
}
