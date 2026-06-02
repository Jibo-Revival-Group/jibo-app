package com.google.api.client.json;

import com.google.api.client.util.ClassInfo;
import com.google.api.client.util.Data;
import com.google.api.client.util.DateTime;
import com.google.api.client.util.FieldInfo;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.Preconditions;
import com.google.api.client.util.Types;
import java.io.IOException;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public abstract class JsonGenerator {
   private void serialize(boolean var1, Object var2) throws IOException {
      boolean var7 = true;
      if (var2 != null) {
         Class var8 = var2.getClass();
         if (Data.isNull(var2)) {
            this.writeNull();
         } else if (var2 instanceof String) {
            this.writeString((String)var2);
         } else if (var2 instanceof Number) {
            if (var1) {
               this.writeString(var2.toString());
            } else if (var2 instanceof BigDecimal) {
               this.writeNumber((BigDecimal)var2);
            } else if (var2 instanceof BigInteger) {
               this.writeNumber((BigInteger)var2);
            } else if (var2 instanceof Long) {
               this.writeNumber((Long)var2);
            } else if (var2 instanceof Float) {
               float var5 = ((Number)var2).floatValue();
               if (!Float.isInfinite(var5) && !Float.isNaN(var5)) {
                  var1 = true;
               } else {
                  var1 = false;
               }

               Preconditions.checkArgument(var1);
               this.writeNumber(var5);
            } else if (!(var2 instanceof Integer) && !(var2 instanceof Short) && !(var2 instanceof Byte)) {
               double var3 = ((Number)var2).doubleValue();
               if (!Double.isInfinite(var3) && !Double.isNaN(var3)) {
                  var1 = var7;
               } else {
                  var1 = false;
               }

               Preconditions.checkArgument(var1);
               this.writeNumber(var3);
            } else {
               this.writeNumber(((Number)var2).intValue());
            }
         } else if (var2 instanceof Boolean) {
            this.writeBoolean((Boolean)var2);
         } else if (var2 instanceof DateTime) {
            this.writeString(((DateTime)var2).toStringRfc3339());
         } else if (var2 instanceof Iterable || var8.isArray()) {
            this.writeStartArray();
            Iterator var16 = Types.iterableOf(var2).iterator();

            while (var16.hasNext()) {
               this.serialize(var1, var16.next());
            }

            this.writeEndArray();
         } else if (var8.isEnum()) {
            String var14 = FieldInfo.of((Enum<?>)var2).getName();
            if (var14 == null) {
               this.writeNull();
            } else {
               this.writeString(var14);
            }
         } else {
            this.writeStartObject();
            boolean var6;
            if (var2 instanceof Map && !(var2 instanceof GenericData)) {
               var6 = true;
            } else {
               var6 = false;
            }

            ClassInfo var18;
            if (var6) {
               var18 = null;
            } else {
               var18 = ClassInfo.of(var8);
            }

            for (Entry var10 : Data.mapOf(var2).entrySet()) {
               Object var9 = var10.getValue();
               if (var9 != null) {
                  String var11 = (String)var10.getKey();
                  if (var6) {
                     var7 = var1;
                  } else {
                     Field var19 = var18.getField(var11);
                     if (var19 != null && var19.getAnnotation(JsonString.class) != null) {
                        var7 = true;
                     } else {
                        var7 = false;
                     }
                  }

                  this.writeFieldName(var11);
                  this.serialize(var7, var9);
               }
            }

            this.writeEndObject();
         }
      }
   }

   public abstract void close() throws IOException;

   public void enablePrettyPrint() throws IOException {
   }

   public abstract void flush() throws IOException;

   public abstract JsonFactory getFactory();

   public final void serialize(Object var1) throws IOException {
      this.serialize(false, var1);
   }

   public abstract void writeBoolean(boolean var1) throws IOException;

   public abstract void writeEndArray() throws IOException;

   public abstract void writeEndObject() throws IOException;

   public abstract void writeFieldName(String var1) throws IOException;

   public abstract void writeNull() throws IOException;

   public abstract void writeNumber(double var1) throws IOException;

   public abstract void writeNumber(float var1) throws IOException;

   public abstract void writeNumber(int var1) throws IOException;

   public abstract void writeNumber(long var1) throws IOException;

   public abstract void writeNumber(String var1) throws IOException;

   public abstract void writeNumber(BigDecimal var1) throws IOException;

   public abstract void writeNumber(BigInteger var1) throws IOException;

   public abstract void writeStartArray() throws IOException;

   public abstract void writeStartObject() throws IOException;

   public abstract void writeString(String var1) throws IOException;
}
