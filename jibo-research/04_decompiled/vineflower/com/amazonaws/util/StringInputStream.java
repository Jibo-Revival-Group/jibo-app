package com.amazonaws.util;

import java.io.ByteArrayInputStream;

public class StringInputStream extends ByteArrayInputStream {
   private final String string;

   public StringInputStream(String var1) {
      super(var1.getBytes(StringUtils.UTF8));
      this.string = var1;
   }
}
