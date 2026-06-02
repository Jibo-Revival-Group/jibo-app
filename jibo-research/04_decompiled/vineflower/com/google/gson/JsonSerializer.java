package com.google.gson;

import java.lang.reflect.Type;

public interface JsonSerializer<T> {
   JsonElement a(T var1, Type var2, JsonSerializationContext var3);
}
