package com.bumptech.glide.load;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;

public interface Key {
   @Override
   boolean equals(Object var1);

   @Override
   int hashCode();

   void updateDiskCacheKey(MessageDigest var1) throws UnsupportedEncodingException;
}
