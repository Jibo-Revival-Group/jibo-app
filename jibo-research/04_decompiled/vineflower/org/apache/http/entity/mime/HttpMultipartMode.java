package org.apache.http.entity.mime;

public enum HttpMultipartMode {
   BROWSER_COMPATIBLE,
   RFC6532,
   STRICT;

   private static final HttpMultipartMode[] $VALUES = new HttpMultipartMode[]{
      HttpMultipartMode.STRICT, HttpMultipartMode.BROWSER_COMPATIBLE, HttpMultipartMode.RFC6532
   };
}
