package com.bumptech.glide.load;

import java.io.OutputStream;

public interface Encoder<T> {
   boolean encode(T var1, OutputStream var2);

   String getId();
}
