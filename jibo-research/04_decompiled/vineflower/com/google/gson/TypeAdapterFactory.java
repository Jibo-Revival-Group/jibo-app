package com.google.gson;

import com.google.gson.reflect.TypeToken;

public interface TypeAdapterFactory {
   <T> TypeAdapter<T> a(Gson var1, TypeToken<T> var2);
}
