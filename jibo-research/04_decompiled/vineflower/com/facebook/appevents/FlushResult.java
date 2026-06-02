package com.facebook.appevents;

public enum FlushResult {
   NO_CONNECTIVITY,
   SERVER_ERROR,
   SUCCESS,
   UNKNOWN_ERROR;

   private static final FlushResult[] $VALUES = new FlushResult[]{
      FlushResult.SUCCESS, FlushResult.SERVER_ERROR, FlushResult.NO_CONNECTIVITY, FlushResult.UNKNOWN_ERROR
   };
}
