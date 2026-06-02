package com.segment.analytics;

import android.util.JsonReader;
import android.util.JsonToken;
import android.util.JsonWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Cartographer {
   static final Cartographer INSTANCE = new Cartographer.Builder().lenient(true).prettyPrint(false).build();
   private final boolean isLenient;
   private final boolean prettyPrint;

   Cartographer(boolean var1, boolean var2) {
      this.isLenient = var1;
      this.prettyPrint = var2;
   }

   private static void arrayToWriter(Object var0, JsonWriter var1) throws IOException {
      var1.beginArray();
      int var2 = 0;

      for (int var3 = Array.getLength(var0); var2 < var3; var2++) {
         writeValue(Array.get(var0, var2), var1);
      }

      var1.endArray();
   }

   private static void listToWriter(List<?> var0, JsonWriter var1) throws IOException {
      var1.beginArray();
      Iterator var2 = var0.iterator();

      while (var2.hasNext()) {
         writeValue(var2.next(), var1);
      }

      var1.endArray();
   }

   private static void mapToWriter(Map<?, ?> var0, JsonWriter var1) throws IOException {
      var1.beginObject();

      for (Entry var3 : var0.entrySet()) {
         var1.name(String.valueOf(var3.getKey()));
         writeValue(var3.getValue(), var1);
      }

      var1.endObject();
   }

   private static Object readValue(JsonReader var0) throws IOException {
      JsonToken var1 = var0.peek();
      Object var2;
      switch (<unrepresentable>.$SwitchMap$android$util$JsonToken[var1.ordinal()]) {
         case 1:
            var2 = readerToMap(var0);
            break;
         case 2:
            var2 = readerToList(var0);
            break;
         case 3:
            var2 = var0.nextBoolean();
            break;
         case 4:
            var0.nextNull();
            var2 = null;
            break;
         case 5:
            var2 = var0.nextDouble();
            break;
         case 6:
            var2 = var0.nextString();
            break;
         default:
            throw new IllegalStateException("Invalid token " + var1);
      }

      return var2;
   }

   private static List<Object> readerToList(JsonReader var0) throws IOException {
      ArrayList var1 = new ArrayList();
      var0.beginArray();

      while (var0.hasNext()) {
         var1.add(readValue(var0));
      }

      var0.endArray();
      return var1;
   }

   private static Map<String, Object> readerToMap(JsonReader var0) throws IOException {
      LinkedHashMap var1 = new LinkedHashMap();
      var0.beginObject();

      while (var0.hasNext()) {
         var1.put(var0.nextName(), readValue(var0));
      }

      var0.endObject();
      return var1;
   }

   private static void writeValue(Object var0, JsonWriter var1) throws IOException {
      if (var0 == null) {
         var1.nullValue();
      } else if (var0 instanceof Number) {
         var1.value((Number)var0);
      } else if (var0 instanceof Boolean) {
         var1.value((Boolean)var0);
      } else if (var0 instanceof List) {
         listToWriter((List<?>)var0, var1);
      } else if (var0 instanceof Map) {
         mapToWriter((Map<?, ?>)var0, var1);
      } else if (var0.getClass().isArray()) {
         arrayToWriter(var0, var1);
      } else {
         var1.value(String.valueOf(var0));
      }
   }

   public Map<String, Object> fromJson(Reader var1) throws IOException {
      if (var1 == null) {
         throw new IllegalArgumentException("reader == null");
      }

      JsonReader var2 = new JsonReader(var1);
      var2.setLenient(this.isLenient);

      try {
         return readerToMap(var2);
      } finally {
         var1.close();
      }
   }

   public Map<String, Object> fromJson(String var1) throws IOException {
      if (var1 == null) {
         throw new IllegalArgumentException("json == null");
      } else if (var1.length() == 0) {
         throw new IllegalArgumentException("json empty");
      } else {
         return this.fromJson(new StringReader(var1));
      }
   }

   public String toJson(Map<?, ?> var1) {
      StringWriter var2 = new StringWriter();

      try {
         this.toJson(var1, var2);
      } catch (IOException var3) {
         throw new AssertionError(var3);
      }

      return var2.toString();
   }

   public void toJson(Map<?, ?> var1, Writer var2) throws IOException {
      if (var1 == null) {
         throw new IllegalArgumentException("map == null");
      }

      if (var2 == null) {
         throw new IllegalArgumentException("writer == null");
      }

      JsonWriter var5 = new JsonWriter(var2);
      var5.setLenient(this.isLenient);
      if (this.prettyPrint) {
         var5.setIndent("  ");
      }

      try {
         mapToWriter(var1, var5);
      } finally {
         var5.close();
      }
   }

   public static class Builder {
      private boolean isLenient;
      private boolean prettyPrint;

      public Cartographer build() {
         return new Cartographer(this.isLenient, this.prettyPrint);
      }

      public Cartographer.Builder lenient(boolean var1) {
         this.isLenient = var1;
         return this;
      }

      public Cartographer.Builder prettyPrint(boolean var1) {
         this.prettyPrint = var1;
         return this;
      }
   }
}
