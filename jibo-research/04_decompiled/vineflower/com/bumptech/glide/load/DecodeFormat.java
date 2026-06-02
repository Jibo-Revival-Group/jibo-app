package com.bumptech.glide.load;

public enum DecodeFormat {
   @Deprecated
   ALWAYS_ARGB_8888,
   PREFER_ARGB_8888,
   PREFER_RGB_565;

   private static final DecodeFormat[] $VALUES = new DecodeFormat[]{DecodeFormat.ALWAYS_ARGB_8888, DecodeFormat.PREFER_ARGB_8888, DecodeFormat.PREFER_RGB_565};
   public static final DecodeFormat DEFAULT = DecodeFormat.PREFER_RGB_565;
}
