package com.google.gson;

import java.lang.reflect.Type;

public interface JsonDeserializationContext {
   <T> T a(JsonElement var1, Type var2) throws JsonParseException;
}
