package com.bumptech.glide.load;

import com.bumptech.glide.load.engine.Resource;
import java.io.IOException;

public interface ResourceDecoder<T, Z> {
   Resource<Z> decode(T var1, int var2, int var3) throws IOException;

   String getId();
}
