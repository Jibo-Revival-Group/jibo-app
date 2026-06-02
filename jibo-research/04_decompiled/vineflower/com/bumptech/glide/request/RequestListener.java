package com.bumptech.glide.request;

import com.bumptech.glide.request.target.Target;

public interface RequestListener<T, R> {
   boolean a(Exception var1, T var2, Target<R> var3, boolean var4);

   boolean a(R var1, T var2, Target<R> var3, boolean var4, boolean var5);
}
