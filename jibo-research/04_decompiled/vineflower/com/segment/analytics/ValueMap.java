package com.segment.analytics;

import android.content.Context;
import android.content.SharedPreferences;
import com.segment.analytics.internal.Utils;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import org.json.JSONObject;

public class ValueMap implements Map<String, Object> {
   private final Map<String, Object> delegate;

   public ValueMap() {
      this.delegate = new LinkedHashMap<>();
   }

   public ValueMap(int var1) {
      this.delegate = new LinkedHashMap<>(var1);
   }

   public ValueMap(Map<String, Object> var1) {
      if (var1 == null) {
         throw new IllegalArgumentException("Map must not be null.");
      }

      this.delegate = var1;
   }

   private <T extends ValueMap> T coerceToValueMap(Object var1, Class<T> var2) {
      if (var1 == null) {
         var1 = null;
      } else if (var2.isAssignableFrom(var1.getClass())) {
         var1 = var1;
      } else if (var1 instanceof Map) {
         var1 = createValueMap(var1, var2);
      } else {
         var1 = null;
      }

      return (T)var1;
   }

   static <T extends ValueMap> T createValueMap(Map var0, Class<T> var1) {
      try {
         Constructor var2 = var1.getDeclaredConstructor(Map.class);
         var2.setAccessible(true);
         return (T)var2.newInstance(var0);
      } catch (Exception var3) {
         throw new AssertionError("Could not create instance of " + var1.getCanonicalName() + ".\n" + var3);
      }
   }

   @Override
   public void clear() {
      this.delegate.clear();
   }

   @Override
   public boolean containsKey(Object var1) {
      return this.delegate.containsKey(var1);
   }

   @Override
   public boolean containsValue(Object var1) {
      return this.delegate.containsValue(var1);
   }

   @Override
   public Set<Entry<String, Object>> entrySet() {
      return this.delegate.entrySet();
   }

   @Override
   public boolean equals(Object var1) {
      boolean var2;
      if (var1 != this && !this.delegate.equals(var1)) {
         var2 = false;
      } else {
         var2 = true;
      }

      return var2;
   }

   @Override
   public Object get(Object var1) {
      return this.delegate.get(var1);
   }

   public boolean getBoolean(String var1, boolean var2) {
      Object var3 = this.get(var1);
      if (var3 instanceof Boolean) {
         var2 = (Boolean)var3;
      } else if (var3 instanceof String) {
         var2 = Boolean.valueOf((String)var3);
      }

      return var2;
   }

   public char getChar(String var1, char var2) {
      Object var4 = this.get(var1);
      char var3;
      if (var4 instanceof Character) {
         var3 = (Character)var4;
      } else {
         var3 = var2;
         if (var4 != null) {
            var3 = var2;
            if (var4 instanceof String) {
               var3 = var2;
               if (((String)var4).length() == 1) {
                  var3 = ((String)var4).charAt(0);
               }
            }
         }
      }

      return var3;
   }

   public double getDouble(String var1, double var2) {
      Object var7 = this.get(var1);
      double var4;
      if (var7 instanceof Double) {
         var4 = (Double)var7;
      } else if (var7 instanceof Number) {
         var4 = ((Number)var7).doubleValue();
      } else {
         var4 = var2;
         if (var7 instanceof String) {
            try {
               var4 = Double.valueOf((String)var7);
            } catch (NumberFormatException var6) {
               var4 = var2;
            }
         }
      }

      return var4;
   }

   public <T extends Enum<T>> T getEnum(Class<T> var1, String var2) {
      if (var1 == null) {
         throw new IllegalArgumentException("enumType may not be null");
      }

      Object var4 = this.get(var2);
      Enum var3;
      if (var1.isInstance(var4)) {
         var3 = (Enum)var4;
      } else if (var4 instanceof String) {
         var3 = Enum.valueOf(var1, (String)var4);
      } else {
         var3 = null;
      }

      return (T)var3;
   }

   public float getFloat(String var1, float var2) {
      return Utils.coerceToFloat(this.get(var1), var2);
   }

   public int getInt(String var1, int var2) {
      Object var5 = this.get(var1);
      int var3;
      if (var5 instanceof Integer) {
         var3 = (Integer)var5;
      } else if (var5 instanceof Number) {
         var3 = ((Number)var5).intValue();
      } else {
         var3 = var2;
         if (var5 instanceof String) {
            try {
               var3 = Integer.valueOf((String)var5);
            } catch (NumberFormatException var4) {
               var3 = var2;
            }
         }
      }

      return var3;
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   public <T extends ValueMap> List<T> getList(Object var1, Class<T> var2) {
      var1 = this.get(var1);
      if (var1 instanceof List) {
         List var3 = (List)var1;

         Iterator var4;
         try {
            var1 = new ArrayList();
            var4 = var3.iterator();
         } catch (Exception var7) {
            return null;
         }

         while (true) {
            try {
               if (!var4.hasNext()) {
                  return var1;
               }

               var10 = this.coerceToValueMap(var4.next(), var2);
            } catch (Exception var6) {
               break;
            }

            if (var10 != null) {
               try {
                  var1.add(var10);
               } catch (Exception var5) {
                  break;
               }
            }
         }
      }

      return null;
   }

   public long getLong(String var1, long var2) {
      Object var7 = this.get(var1);
      long var4;
      if (var7 instanceof Long) {
         var4 = (Long)var7;
      } else if (var7 instanceof Number) {
         var4 = ((Number)var7).longValue();
      } else {
         var4 = var2;
         if (var7 instanceof String) {
            try {
               var4 = Long.valueOf((String)var7);
            } catch (NumberFormatException var6) {
               var4 = var2;
            }
         }
      }

      return var4;
   }

   public String getString(String var1) {
      var1 = (String)this.get(var1);
      if (var1 instanceof String) {
         var1 = var1;
      } else if (var1 != null) {
         var1 = String.valueOf(var1);
      } else {
         var1 = null;
      }

      return var1;
   }

   public ValueMap getValueMap(Object var1) {
      var1 = this.get(var1);
      if (var1 instanceof ValueMap) {
         var1 = (ValueMap)var1;
      } else if (var1 instanceof Map) {
         var1 = new ValueMap((Map<String, Object>)var1);
      } else {
         var1 = null;
      }

      return var1;
   }

   public <T extends ValueMap> T getValueMap(String var1, Class<T> var2) {
      return this.coerceToValueMap(this.get(var1), var2);
   }

   @Override
   public int hashCode() {
      return this.delegate.hashCode();
   }

   @Override
   public boolean isEmpty() {
      return this.delegate.isEmpty();
   }

   @Override
   public Set<String> keySet() {
      return this.delegate.keySet();
   }

   public Object put(String var1, Object var2) {
      return this.delegate.put(var1, var2);
   }

   @Override
   public void putAll(Map<? extends String, ?> var1) {
      this.delegate.putAll(var1);
   }

   public ValueMap putValue(String var1, Object var2) {
      this.delegate.put(var1, var2);
      return this;
   }

   @Override
   public Object remove(Object var1) {
      return this.delegate.remove(var1);
   }

   @Override
   public int size() {
      return this.delegate.size();
   }

   public JSONObject toJsonObject() {
      return Utils.toJsonObject(this.delegate);
   }

   @Override
   public String toString() {
      return this.delegate.toString();
   }

   public Map<String, String> toStringMap() {
      HashMap var1 = new HashMap();

      for (Entry var2 : this.entrySet()) {
         var1.put(var2.getKey(), String.valueOf(var2.getValue()));
      }

      return var1;
   }

   @Override
   public Collection<Object> values() {
      return this.delegate.values();
   }

   static class Cache<T extends ValueMap> {
      private final Cartographer cartographer;
      private final Class<T> clazz;
      private final String key;
      private final SharedPreferences preferences;
      private T value;

      Cache(Context var1, Cartographer var2, String var3, String var4, Class<T> var5) {
         this.cartographer = var2;
         this.preferences = Utils.getSegmentSharedPreferences(var1, var4);
         this.key = var3;
         this.clazz = var5;
      }

      T create(Map<String, Object> var1) {
         return ValueMap.createValueMap(var1, this.clazz);
      }

      void delete() {
         this.preferences.edit().remove(this.key).apply();
      }

      T get() {
         Object var1 = null;
         if (this.value == null) {
            String var2 = this.preferences.getString(this.key, null);
            if (Utils.isNullOrEmpty(var2)) {
               return (T)var1;
            }

            try {
               this.value = this.create(this.cartographer.fromJson(var2));
            } catch (IOException var3) {
               return (T)var1;
            }
         }

         return this.value;
      }

      boolean isSet() {
         return this.preferences.contains(this.key);
      }

      void set(T var1) {
         this.value = (T)var1;
         String var2 = this.cartographer.toJson(var1);
         this.preferences.edit().putString(this.key, var2).apply();
      }
   }
}
