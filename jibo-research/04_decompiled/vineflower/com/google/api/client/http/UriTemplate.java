package com.google.api.client.http;

import com.google.api.client.repackaged.com.google.common.base.Splitter;
import com.google.api.client.util.Data;
import com.google.api.client.util.FieldInfo;
import com.google.api.client.util.Preconditions;
import com.google.api.client.util.Types;
import com.google.api.client.util.escape.CharEscapers;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.ListIterator;
import java.util.Map;
import java.util.Map.Entry;

public class UriTemplate {
   private static final String COMPOSITE_NON_EXPLODE_JOINER = ",";
   static final Map<Character, UriTemplate.CompositeOutput> COMPOSITE_PREFIXES = new HashMap<>();

   static {
      UriTemplate.CompositeOutput.values();
   }

   public static String expand(String var0, Object var1, boolean var2) {
      Map var12 = getMap(var1);
      StringBuilder var13 = new StringBuilder();
      int var3 = 0;
      int var7 = var0.length();

      while (true) {
         if (var3 < var7) {
            int var4 = var0.indexOf(123, var3);
            if (var4 != -1) {
               var13.append(var0.substring(var3, var4));
               int var8 = var0.indexOf(125, var4 + 2);
               var1 = var0.substring(var4 + 1, var8);
               UriTemplate.CompositeOutput var11 = getCompositeOutput(var1);
               ListIterator var14 = Splitter.on(',').splitToList(var1).listIterator();
               boolean var21 = true;

               while (var14.hasNext()) {
                  var1 = (String)var14.next();
                  boolean var9 = var1.endsWith("*");
                  if (var14.nextIndex() == 1) {
                     var4 = var11.getVarNameStartIndex();
                  } else {
                     var4 = 0;
                  }

                  int var6 = var1.length();
                  int var5 = var6;
                  if (var9) {
                     var5 = var6 - 1;
                  }

                  String var15 = var1.substring(var4, var5);
                  Object var10 = var12.remove(var15);
                  if (var10 != null) {
                     if (!var21) {
                        var13.append(var11.getExplodeJoiner());
                     } else {
                        var13.append(var11.getOutputPrefix());
                        var21 = false;
                     }

                     if (var10 instanceof Iterator) {
                        var1 = getListPropertyValue(var15, (Iterator<?>)var10, var9, var11);
                     } else if (var10 instanceof Iterable || var10.getClass().isArray()) {
                        var1 = getListPropertyValue(var15, Types.iterableOf(var10).iterator(), var9, var11);
                     } else if (var10.getClass().isEnum()) {
                        var1 = var10;
                        if (FieldInfo.of((Enum<?>)var10).getName() != null) {
                           var1 = var10;
                           if (var11.requiresVarAssignment()) {
                              var1 = String.format("%s=%s", var15, var10);
                           }

                           var1 = CharEscapers.escapeUriPath(var1.toString());
                        }
                     } else if (!Data.isValueOfPrimitiveType(var10)) {
                        var1 = getMapPropertyValue(var15, getMap(var10), var9, var11);
                     } else {
                        var1 = var10;
                        if (var11.requiresVarAssignment()) {
                           var1 = String.format("%s=%s", var15, var10);
                        }

                        if (var11.getReservedExpansion()) {
                           var1 = CharEscapers.escapeUriPathWithoutReserved(var1.toString());
                        } else {
                           var1 = CharEscapers.escapeUriPath(var1.toString());
                        }
                     }

                     var13.append(var1);
                  }
               }

               var3 = var8 + 1;
               continue;
            }

            if (var3 == 0 && !var2) {
               break;
            }

            var13.append(var0.substring(var3));
         }

         if (var2) {
            GenericUrl.addQueryParams(var12.entrySet(), var13);
         }

         var0 = var13.toString();
         break;
      }

      return var0;
   }

   public static String expand(String var0, String var1, Object var2, boolean var3) {
      if (var1.startsWith("/")) {
         GenericUrl var4 = new GenericUrl(var0);
         var4.setRawPath(null);
         var0 = String.valueOf(var4.build());
         var1 = String.valueOf(var1);
         if (var1.length() != 0) {
            var0 = var0.concat(var1);
         } else {
            var0 = new String(var0);
         }
      } else if (!var1.startsWith("http://") && !var1.startsWith("https://")) {
         var0 = String.valueOf(var0);
         var1 = String.valueOf(var1);
         if (var1.length() != 0) {
            var0 = var0.concat(var1);
         } else {
            var0 = new String(var0);
         }
      } else {
         var0 = var1;
      }

      return expand(var0, var2, var3);
   }

   static UriTemplate.CompositeOutput getCompositeOutput(String var0) {
      UriTemplate.CompositeOutput var1 = COMPOSITE_PREFIXES.get(var0.charAt(0));
      UriTemplate.CompositeOutput var2 = var1;
      if (var1 == null) {
         var2 = UriTemplate.CompositeOutput.SIMPLE;
      }

      return var2;
   }

   private static String getListPropertyValue(String var0, Iterator<?> var1, boolean var2, UriTemplate.CompositeOutput var3) {
      if (!var1.hasNext()) {
         var0 = "";
      } else {
         StringBuilder var6 = new StringBuilder();
         String var4;
         if (var2) {
            var4 = var3.getExplodeJoiner();
         } else {
            String var5 = ",";
            var4 = var5;
            if (var3.requiresVarAssignment()) {
               var6.append(CharEscapers.escapeUriPath(var0));
               var6.append("=");
               var4 = var5;
            }
         }

         while (var1.hasNext()) {
            if (var2 && var3.requiresVarAssignment()) {
               var6.append(CharEscapers.escapeUriPath(var0));
               var6.append("=");
            }

            var6.append(var3.getEncodedValue(var1.next().toString()));
            if (var1.hasNext()) {
               var6.append(var4);
            }
         }

         var0 = var6.toString();
      }

      return var0;
   }

   private static Map<String, Object> getMap(Object var0) {
      LinkedHashMap var1 = new LinkedHashMap();

      for (var0 : Data.mapOf(var0).entrySet()) {
         Object var3 = var0.getValue();
         if (var3 != null && !Data.isNull(var3)) {
            var1.put(var0.getKey(), var3);
         }
      }

      return var1;
   }

   private static String getMapPropertyValue(String var0, Map<String, Object> var1, boolean var2, UriTemplate.CompositeOutput var3) {
      if (var1.isEmpty()) {
         var0 = "";
      } else {
         StringBuilder var5 = new StringBuilder();
         String var4;
         if (var2) {
            var4 = var3.getExplodeJoiner();
            var0 = "=";
         } else {
            if (var3.requiresVarAssignment()) {
               var5.append(CharEscapers.escapeUriPath(var0));
               var5.append("=");
            }

            var0 = ",";
            var4 = ",";
         }

         Iterator var6 = var1.entrySet().iterator();

         while (var6.hasNext()) {
            Entry var7 = (Entry)var6.next();
            String var10 = var3.getEncodedValue((String)var7.getKey());
            String var11 = var3.getEncodedValue(var7.getValue().toString());
            var5.append(var10);
            var5.append(var0);
            var5.append(var11);
            if (var6.hasNext()) {
               var5.append(var4);
            }
         }

         var0 = var5.toString();
      }

      return var0;
   }

   private enum CompositeOutput {
      AMP('&', "&", "&", true, false),
      DOT('.', ".", ".", false, false),
      FORWARD_SLASH('/', "/", "/", false, false),
      HASH('#', "#", ",", false, true),
      PLUS('+', "", ",", false, true),
      QUERY('?', "?", "&", true, false),
      SEMI_COLON(';', ";", ";", true, false),
      SIMPLE(null, "", ",", false, false);

      private static final UriTemplate.CompositeOutput[] $VALUES = new UriTemplate.CompositeOutput[]{
         UriTemplate.CompositeOutput.PLUS,
         UriTemplate.CompositeOutput.HASH,
         UriTemplate.CompositeOutput.DOT,
         UriTemplate.CompositeOutput.FORWARD_SLASH,
         UriTemplate.CompositeOutput.SEMI_COLON,
         UriTemplate.CompositeOutput.QUERY,
         UriTemplate.CompositeOutput.AMP,
         UriTemplate.CompositeOutput.SIMPLE
      };
      private final String explodeJoiner;
      private final String outputPrefix;
      private final Character propertyPrefix;
      private final boolean requiresVarAssignment;
      private final boolean reservedExpansion;

      CompositeOutput(Character var3, String var4, String var5, boolean var6, boolean var7) {
         this.propertyPrefix = var3;
         this.outputPrefix = Preconditions.checkNotNull(var4);
         this.explodeJoiner = Preconditions.checkNotNull(var5);
         this.requiresVarAssignment = var6;
         this.reservedExpansion = var7;
         if (var3 != null) {
            UriTemplate.COMPOSITE_PREFIXES.put(var3, this);
         }
      }

      String getEncodedValue(String var1) {
         if (this.reservedExpansion) {
            var1 = CharEscapers.escapeUriPath(var1);
         } else {
            var1 = CharEscapers.escapeUri(var1);
         }

         return var1;
      }

      String getExplodeJoiner() {
         return this.explodeJoiner;
      }

      String getOutputPrefix() {
         return this.outputPrefix;
      }

      boolean getReservedExpansion() {
         return this.reservedExpansion;
      }

      int getVarNameStartIndex() {
         byte var1;
         if (this.propertyPrefix == null) {
            var1 = 0;
         } else {
            var1 = 1;
         }

         return var1;
      }

      boolean requiresVarAssignment() {
         return this.requiresVarAssignment;
      }
   }
}
