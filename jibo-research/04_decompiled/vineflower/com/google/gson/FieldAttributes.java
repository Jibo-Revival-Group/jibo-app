package com.google.gson;

import com.google.gson.internal.$Gson$Preconditions;
import java.lang.reflect.Field;

public final class FieldAttributes {
   private final Field a;

   public FieldAttributes(Field var1) {
      $Gson$Preconditions.a(var1);
      this.a = var1;
   }
}
