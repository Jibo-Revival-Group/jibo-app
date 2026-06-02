package com.google.zxing;

public enum EncodeHintType {
   AZTEC_LAYERS,
   CHARACTER_SET,
   DATA_MATRIX_SHAPE,
   ERROR_CORRECTION,
   MARGIN,
   @Deprecated
   MAX_SIZE,
   @Deprecated
   MIN_SIZE,
   PDF417_COMPACT,
   PDF417_COMPACTION,
   PDF417_DIMENSIONS;

   private static final EncodeHintType[] $VALUES = new EncodeHintType[]{
      EncodeHintType.ERROR_CORRECTION,
      EncodeHintType.CHARACTER_SET,
      EncodeHintType.DATA_MATRIX_SHAPE,
      EncodeHintType.MIN_SIZE,
      EncodeHintType.MAX_SIZE,
      EncodeHintType.MARGIN,
      EncodeHintType.PDF417_COMPACT,
      EncodeHintType.PDF417_COMPACTION,
      EncodeHintType.PDF417_DIMENSIONS,
      EncodeHintType.AZTEC_LAYERS
   };
}
