package com.facebook;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import com.facebook.internal.Logger;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

final class LegacyTokenHelper {
   public static final String APPLICATION_ID_KEY = "com.facebook.TokenCachingStrategy.ApplicationId";
   public static final String DECLINED_PERMISSIONS_KEY = "com.facebook.TokenCachingStrategy.DeclinedPermissions";
   public static final String DEFAULT_CACHE_KEY = "com.facebook.SharedPreferencesTokenCachingStrategy.DEFAULT_KEY";
   public static final String EXPIRATION_DATE_KEY = "com.facebook.TokenCachingStrategy.ExpirationDate";
   private static final long INVALID_BUNDLE_MILLISECONDS = Long.MIN_VALUE;
   private static final String IS_SSO_KEY = "com.facebook.TokenCachingStrategy.IsSSO";
   private static final String JSON_VALUE = "value";
   private static final String JSON_VALUE_ENUM_TYPE = "enumType";
   private static final String JSON_VALUE_TYPE = "valueType";
   public static final String LAST_REFRESH_DATE_KEY = "com.facebook.TokenCachingStrategy.LastRefreshDate";
   public static final String PERMISSIONS_KEY = "com.facebook.TokenCachingStrategy.Permissions";
   private static final String TAG = LegacyTokenHelper.class.getSimpleName();
   public static final String TOKEN_KEY = "com.facebook.TokenCachingStrategy.Token";
   public static final String TOKEN_SOURCE_KEY = "com.facebook.TokenCachingStrategy.AccessTokenSource";
   private static final String TYPE_BOOLEAN = "bool";
   private static final String TYPE_BOOLEAN_ARRAY = "bool[]";
   private static final String TYPE_BYTE = "byte";
   private static final String TYPE_BYTE_ARRAY = "byte[]";
   private static final String TYPE_CHAR = "char";
   private static final String TYPE_CHAR_ARRAY = "char[]";
   private static final String TYPE_DOUBLE = "double";
   private static final String TYPE_DOUBLE_ARRAY = "double[]";
   private static final String TYPE_ENUM = "enum";
   private static final String TYPE_FLOAT = "float";
   private static final String TYPE_FLOAT_ARRAY = "float[]";
   private static final String TYPE_INTEGER = "int";
   private static final String TYPE_INTEGER_ARRAY = "int[]";
   private static final String TYPE_LONG = "long";
   private static final String TYPE_LONG_ARRAY = "long[]";
   private static final String TYPE_SHORT = "short";
   private static final String TYPE_SHORT_ARRAY = "short[]";
   private static final String TYPE_STRING = "string";
   private static final String TYPE_STRING_LIST = "stringList";
   private SharedPreferences cache;
   private String cacheKey;

   public LegacyTokenHelper(Context var1) {
      this(var1, null);
   }

   public LegacyTokenHelper(Context var1, String var2) {
      Validate.notNull(var1, "context");
      String var3 = var2;
      if (Utility.isNullOrEmpty(var2)) {
         var3 = "com.facebook.SharedPreferencesTokenCachingStrategy.DEFAULT_KEY";
      }

      this.cacheKey = var3;
      Context var4 = var1.getApplicationContext();
      if (var4 != null) {
         var1 = var4;
      }

      this.cache = var1.getSharedPreferences(this.cacheKey, 0);
   }

   private void deserializeKey(String var1, Bundle var2) throws JSONException {
      byte var7 = 0;
      byte var6 = 0;
      byte var5 = 0;
      byte var9 = 0;
      int var4 = 0;
      byte var8 = 0;
      int var3 = 0;
      JSONObject var10 = new JSONObject(this.cache.getString(var1, "{}"));
      String var11 = var10.getString("valueType");
      if (var11.equals("bool")) {
         var2.putBoolean(var1, var10.getBoolean("value"));
      } else if (var11.equals("bool[]")) {
         JSONArray var24 = var10.getJSONArray("value");

         for (var35 = new boolean[var24.length()]; var3 < var35.length; var3++) {
            var35[var3] = var24.getBoolean(var3);
         }

         var2.putBooleanArray(var1, var35);
      } else if (var11.equals("byte")) {
         var2.putByte(var1, (byte)var10.getInt("value"));
      } else if (var11.equals("byte[]")) {
         JSONArray var25 = var10.getJSONArray("value");
         byte[] var36 = new byte[var25.length()];

         for (int var15 = var7; var15 < var36.length; var15++) {
            var36[var15] = (byte)var25.getInt(var15);
         }

         var2.putByteArray(var1, var36);
      } else if (var11.equals("short")) {
         var2.putShort(var1, (short)var10.getInt("value"));
      } else if (var11.equals("short[]")) {
         JSONArray var37 = var10.getJSONArray("value");
         short[] var26 = new short[var37.length()];

         for (int var16 = var6; var16 < var26.length; var16++) {
            var26[var16] = (short)var37.getInt(var16);
         }

         var2.putShortArray(var1, var26);
      } else if (var11.equals("int")) {
         var2.putInt(var1, var10.getInt("value"));
      } else if (var11.equals("int[]")) {
         JSONArray var38 = var10.getJSONArray("value");
         int[] var27 = new int[var38.length()];

         for (int var17 = var5; var17 < var27.length; var17++) {
            var27[var17] = var38.getInt(var17);
         }

         var2.putIntArray(var1, var27);
      } else if (var11.equals("long")) {
         var2.putLong(var1, var10.getLong("value"));
      } else if (var11.equals("long[]")) {
         JSONArray var39 = var10.getJSONArray("value");
         long[] var28 = new long[var39.length()];

         for (int var18 = var9; var18 < var28.length; var18++) {
            var28[var18] = var39.getLong(var18);
         }

         var2.putLongArray(var1, var28);
      } else if (var11.equals("float")) {
         var2.putFloat(var1, (float)var10.getDouble("value"));
      } else if (var11.equals("float[]")) {
         JSONArray var40 = var10.getJSONArray("value");
         float[] var29 = new float[var40.length()];

         for (int var19 = var4; var19 < var29.length; var19++) {
            var29[var19] = (float)var40.getDouble(var19);
         }

         var2.putFloatArray(var1, var29);
      } else if (var11.equals("double")) {
         var2.putDouble(var1, var10.getDouble("value"));
      } else if (var11.equals("double[]")) {
         JSONArray var30 = var10.getJSONArray("value");
         double[] var41 = new double[var30.length()];

         for (int var20 = var8; var20 < var41.length; var20++) {
            var41[var20] = var30.getDouble(var20);
         }

         var2.putDoubleArray(var1, var41);
      } else if (var11.equals("char")) {
         String var31 = var10.getString("value");
         if (var31 != null && var31.length() == 1) {
            var2.putChar(var1, var31.charAt(0));
         }
      } else if (var11.equals("char[]")) {
         JSONArray var32 = var10.getJSONArray("value");
         char[] var12 = new char[var32.length()];

         for (int var21 = 0; var21 < var12.length; var21++) {
            var11 = var32.getString(var21);
            if (var11 != null && var11.length() == 1) {
               var12[var21] = var11.charAt(0);
            }
         }

         var2.putCharArray(var1, var12);
      } else if (var11.equals("string")) {
         var2.putString(var1, var10.getString("value"));
      } else if (var11.equals("stringList")) {
         JSONArray var43 = var10.getJSONArray("value");
         var4 = var43.length();
         ArrayList var44 = new ArrayList(var4);

         for (int var22 = 0; var22 < var4; var22++) {
            Object var33 = var43.get(var22);
            String var34;
            if (var33 == JSONObject.NULL) {
               var34 = null;
            } else {
               var34 = (String)var33;
            }

            var44.add(var22, var34);
         }

         var2.putStringArrayList(var1, var44);
      } else if (var11.equals("enum")) {
         try {
            var2.putSerializable(var1, Enum.valueOf((Class<Serializable>)Class.forName(var10.getString("enumType")), var10.getString("value")));
         } catch (ClassNotFoundException var13) {
         } catch (IllegalArgumentException var14) {
         }
      }
   }

   public static String getApplicationId(Bundle var0) {
      Validate.notNull(var0, "bundle");
      return var0.getString("com.facebook.TokenCachingStrategy.ApplicationId");
   }

   static Date getDate(Bundle var0, String var1) {
      Object var4 = null;
      Date var5;
      if (var0 == null) {
         var5 = (Date)var4;
      } else {
         long var2 = var0.getLong(var1, Long.MIN_VALUE);
         var5 = (Date)var4;
         if (var2 != Long.MIN_VALUE) {
            var5 = new Date(var2);
         }
      }

      return var5;
   }

   public static Date getExpirationDate(Bundle var0) {
      Validate.notNull(var0, "bundle");
      return getDate(var0, "com.facebook.TokenCachingStrategy.ExpirationDate");
   }

   public static long getExpirationMilliseconds(Bundle var0) {
      Validate.notNull(var0, "bundle");
      return var0.getLong("com.facebook.TokenCachingStrategy.ExpirationDate");
   }

   public static Date getLastRefreshDate(Bundle var0) {
      Validate.notNull(var0, "bundle");
      return getDate(var0, "com.facebook.TokenCachingStrategy.LastRefreshDate");
   }

   public static long getLastRefreshMilliseconds(Bundle var0) {
      Validate.notNull(var0, "bundle");
      return var0.getLong("com.facebook.TokenCachingStrategy.LastRefreshDate");
   }

   public static Set<String> getPermissions(Bundle var0) {
      Validate.notNull(var0, "bundle");
      ArrayList var1 = var0.getStringArrayList("com.facebook.TokenCachingStrategy.Permissions");
      HashSet var2;
      if (var1 == null) {
         var2 = null;
      } else {
         var2 = new HashSet(var1);
      }

      return var2;
   }

   public static AccessTokenSource getSource(Bundle var0) {
      Validate.notNull(var0, "bundle");
      AccessTokenSource var1;
      if (var0.containsKey("com.facebook.TokenCachingStrategy.AccessTokenSource")) {
         var1 = (AccessTokenSource)var0.getSerializable("com.facebook.TokenCachingStrategy.AccessTokenSource");
      } else if (var0.getBoolean("com.facebook.TokenCachingStrategy.IsSSO")) {
         var1 = AccessTokenSource.FACEBOOK_APPLICATION_WEB;
      } else {
         var1 = AccessTokenSource.WEB_VIEW;
      }

      return var1;
   }

   public static String getToken(Bundle var0) {
      Validate.notNull(var0, "bundle");
      return var0.getString("com.facebook.TokenCachingStrategy.Token");
   }

   public static boolean hasTokenInformation(Bundle var0) {
      boolean var2 = false;
      boolean var1;
      if (var0 == null) {
         var1 = var2;
      } else {
         String var3 = var0.getString("com.facebook.TokenCachingStrategy.Token");
         var1 = var2;
         if (var3 != null) {
            var1 = var2;
            if (var3.length() != 0) {
               var1 = var2;
               if (var0.getLong("com.facebook.TokenCachingStrategy.ExpirationDate", 0L) != 0L) {
                  var1 = true;
               }
            }
         }
      }

      return var1;
   }

   public static void putApplicationId(Bundle var0, String var1) {
      Validate.notNull(var0, "bundle");
      var0.putString("com.facebook.TokenCachingStrategy.ApplicationId", var1);
   }

   static void putDate(Bundle var0, String var1, Date var2) {
      var0.putLong(var1, var2.getTime());
   }

   public static void putDeclinedPermissions(Bundle var0, Collection<String> var1) {
      Validate.notNull(var0, "bundle");
      Validate.notNull(var1, "value");
      var0.putStringArrayList("com.facebook.TokenCachingStrategy.DeclinedPermissions", new ArrayList(var1));
   }

   public static void putExpirationDate(Bundle var0, Date var1) {
      Validate.notNull(var0, "bundle");
      Validate.notNull(var1, "value");
      putDate(var0, "com.facebook.TokenCachingStrategy.ExpirationDate", var1);
   }

   public static void putExpirationMilliseconds(Bundle var0, long var1) {
      Validate.notNull(var0, "bundle");
      var0.putLong("com.facebook.TokenCachingStrategy.ExpirationDate", var1);
   }

   public static void putLastRefreshDate(Bundle var0, Date var1) {
      Validate.notNull(var0, "bundle");
      Validate.notNull(var1, "value");
      putDate(var0, "com.facebook.TokenCachingStrategy.LastRefreshDate", var1);
   }

   public static void putLastRefreshMilliseconds(Bundle var0, long var1) {
      Validate.notNull(var0, "bundle");
      var0.putLong("com.facebook.TokenCachingStrategy.LastRefreshDate", var1);
   }

   public static void putPermissions(Bundle var0, Collection<String> var1) {
      Validate.notNull(var0, "bundle");
      Validate.notNull(var1, "value");
      var0.putStringArrayList("com.facebook.TokenCachingStrategy.Permissions", new ArrayList(var1));
   }

   public static void putSource(Bundle var0, AccessTokenSource var1) {
      Validate.notNull(var0, "bundle");
      var0.putSerializable("com.facebook.TokenCachingStrategy.AccessTokenSource", var1);
   }

   public static void putToken(Bundle var0, String var1) {
      Validate.notNull(var0, "bundle");
      Validate.notNull(var1, "value");
      var0.putString("com.facebook.TokenCachingStrategy.Token", var1);
   }

   private void serializeKey(String var1, Bundle var2, Editor var3) throws JSONException {
      Object var12 = null;
      byte var9 = 0;
      int var6 = 0;
      int var5 = 0;
      byte var8 = 0;
      byte var11 = 0;
      byte var7 = 0;
      byte var10 = 0;
      int var4 = 0;
      Object var14 = var2.get(var1);
      if (var14 != null) {
         JSONObject var15 = new JSONObject();
         JSONArray var17;
         if (var14 instanceof Byte) {
            var15.put("value", ((Byte)var14).intValue());
            var17 = null;
            var12 = "byte";
         } else if (var14 instanceof Short) {
            var15.put("value", ((Short)var14).intValue());
            var17 = null;
            var12 = "short";
         } else if (var14 instanceof Integer) {
            var15.put("value", (Integer)var14);
            var17 = null;
            var12 = "int";
         } else if (var14 instanceof Long) {
            var15.put("value", (Long)var14);
            var17 = null;
            var12 = "long";
         } else if (var14 instanceof Float) {
            var15.put("value", ((Float)var14).doubleValue());
            var17 = null;
            var12 = "float";
         } else if (var14 instanceof Double) {
            var15.put("value", (Double)var14);
            var17 = null;
            var12 = "double";
         } else if (var14 instanceof Boolean) {
            var15.put("value", (Boolean)var14);
            var17 = null;
            var12 = "bool";
         } else if (var14 instanceof Character) {
            var15.put("value", var14.toString());
            var17 = null;
            var12 = "char";
         } else if (var14 instanceof String) {
            var15.put("value", (String)var14);
            var17 = null;
            var12 = "string";
         } else if (var14 instanceof Enum) {
            var15.put("value", var14.toString());
            var15.put("enumType", var14.getClass().getName());
            var17 = null;
            var12 = "enum";
         } else {
            var17 = new JSONArray();
            if (var14 instanceof byte[]) {
               var12 = "byte[]";
               byte[] var41 = (byte[])var14;

               for (int var31 = var41.length; var4 < var31; var4++) {
                  var17.put(var41[var4]);
               }
            } else if (var14 instanceof short[]) {
               var12 = "short[]";
               short[] var40 = (short[])var14;
               var5 = var40.length;

               for (int var24 = var9; var24 < var5; var24++) {
                  var17.put(var40[var24]);
               }
            } else if (var14 instanceof int[]) {
               var12 = "int[]";
               int[] var39 = (int[])var14;
               var5 = var39.length;

               for (int var23 = var6; var23 < var5; var23++) {
                  var17.put(var39[var23]);
               }
            } else if (var14 instanceof long[]) {
               var12 = "long[]";
               long[] var38 = (long[])var14;
               var6 = var38.length;

               for (int var22 = var5; var22 < var6; var22++) {
                  var17.put(var38[var22]);
               }
            } else if (var14 instanceof float[]) {
               var12 = "float[]";
               float[] var37 = (float[])var14;
               var5 = var37.length;

               for (int var21 = var8; var21 < var5; var21++) {
                  var17.put(var37[var21]);
               }
            } else if (var14 instanceof double[]) {
               var12 = "double[]";
               double[] var36 = (double[])var14;
               var5 = var36.length;

               for (int var20 = var11; var20 < var5; var20++) {
                  var17.put(var36[var20]);
               }
            } else if (var14 instanceof boolean[]) {
               var12 = "bool[]";
               boolean[] var35 = (boolean[])var14;
               var5 = var35.length;

               for (int var19 = var7; var19 < var5; var19++) {
                  var17.put(var35[var19]);
               }
            } else if (var14 instanceof char[]) {
               var12 = "char[]";
               char[] var34 = (char[])var14;
               var5 = var34.length;

               for (int var18 = var10; var18 < var5; var18++) {
                  var17.put(String.valueOf(var34[var18]));
               }
            } else if (!(var14 instanceof List)) {
               var17 = null;
            } else {
               String var13 = "stringList";

               for (String var42 : (List)var14) {
                  var12 = var42;
                  if (var42 == null) {
                     var12 = JSONObject.NULL;
                  }

                  var17.put(var12);
               }

               var12 = var13;
            }
         }

         if (var12 != null) {
            var15.put("valueType", var12);
            if (var17 != null) {
               var15.putOpt("value", var17);
            }

            var3.putString(var1, var15.toString());
         }
      }
   }

   public void clear() {
      this.cache.edit().clear().apply();
   }

   public Bundle load() {
      Bundle var1 = new Bundle();

      for (String var2 : this.cache.getAll().keySet()) {
         try {
            this.deserializeKey(var2, var1);
         } catch (JSONException var4) {
            Logger.log(LoggingBehavior.CACHE, 5, TAG, "Error reading cached value for key: '" + var2 + "' -- " + var4);
            var1 = null;
            break;
         }
      }

      return var1;
   }

   public void save(Bundle var1) {
      Validate.notNull(var1, "bundle");
      Editor var3 = this.cache.edit();
      Iterator var4 = var1.keySet().iterator();

      while (true) {
         if (!var4.hasNext()) {
            var3.apply();
            break;
         }

         String var2 = (String)var4.next();

         try {
            this.serializeKey(var2, var1, var3);
         } catch (JSONException var5) {
            Logger.log(LoggingBehavior.CACHE, 5, TAG, "Error processing value for key: '" + var2 + "' -- " + var5);
            break;
         }
      }
   }
}
