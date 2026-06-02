package com.google.gson;

import java.lang.reflect.Type;

public interface JsonSerializationContext {
   JsonElement a(Object var1);

   JsonElement a(Object var1, Type var2);
}
