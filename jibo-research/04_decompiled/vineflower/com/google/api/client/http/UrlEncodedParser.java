package com.google.api.client.http;

import com.google.api.client.util.ArrayValueMap;
import com.google.api.client.util.Charsets;
import com.google.api.client.util.ClassInfo;
import com.google.api.client.util.Data;
import com.google.api.client.util.FieldInfo;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.ObjectParser;
import com.google.api.client.util.Preconditions;
import com.google.api.client.util.Throwables;
import com.google.api.client.util.Types;
import com.google.api.client.util.escape.CharEscapers;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class UrlEncodedParser implements ObjectParser {
   public static final String CONTENT_TYPE = "application/x-www-form-urlencoded";
   public static final String MEDIA_TYPE = new HttpMediaType("application/x-www-form-urlencoded").setCharsetParameter(Charsets.UTF_8).build();

   public static void parse(Reader var0, Object var1) throws IOException {
      Class var5 = var1.getClass();
      ClassInfo var9 = ClassInfo.of(var5);
      List var10 = Arrays.asList(var5);
      GenericData var4;
      if (GenericData.class.isAssignableFrom(var5)) {
         var4 = (GenericData)var1;
      } else {
         var4 = null;
      }

      Map var14;
      if (Map.class.isAssignableFrom(var5)) {
         var14 = (Map)var1;
      } else {
         var14 = null;
      }

      ArrayValueMap var11 = new ArrayValueMap(var1);
      StringWriter var6 = new StringWriter();
      StringWriter var7 = new StringWriter();
      boolean var2 = true;
      StringWriter var8 = var6;
      var6 = var7;

      while (true) {
         int var3 = var0.read();
         switch (var3) {
            case -1:
            case 38:
               String var13 = CharEscapers.decodeUri(var8.toString());
               if (var13.length() != 0) {
                  String var22 = CharEscapers.decodeUri(var6.toString());
                  FieldInfo var12 = var9.getFieldInfo(var13);
                  if (var12 != null) {
                     Type var23 = Data.resolveWildcardTypeOrTypeVariable(var10, var12.getGenericType());
                     if (Types.isArray(var23)) {
                        Class var16 = Types.getRawArrayComponentType(var10, Types.getArrayComponentType(var23));
                        var11.put(var12.getField(), var16, parseValue(var16, var10, var22));
                     } else if (Types.isAssignableToOrFrom(Types.getRawArrayComponentType(var10, var23), Iterable.class)) {
                        Collection var19 = (Collection)var12.getValue(var1);
                        Collection var17 = var19;
                        if (var19 == null) {
                           var17 = Data.newCollectionInstance(var23);
                           var12.setValue(var1, var17);
                        }

                        Type var20;
                        if (var23 == Object.class) {
                           var20 = null;
                        } else {
                           var20 = Types.getIterableParameter(var23);
                        }

                        var17.add(parseValue(var20, var10, var22));
                     } else {
                        var12.setValue(var1, parseValue(var23, var10, var22));
                     }
                  } else if (var14 != null) {
                     ArrayList var21 = (ArrayList)var14.get(var13);
                     ArrayList var18 = var21;
                     if (var21 == null) {
                        var18 = new ArrayList();
                        if (var4 != null) {
                           var4.set(var13, var18);
                        } else {
                           var14.put(var13, var18);
                        }
                     }

                     var18.add(var22);
                  }
               }

               var8 = new StringWriter();
               var6 = new StringWriter();
               if (var3 == -1) {
                  var11.setValues();
                  return;
               }

               var2 = true;
               break;
            case 61:
               var2 = false;
               break;
            default:
               if (var2) {
                  var8.write(var3);
               } else {
                  var6.write(var3);
               }
         }
      }
   }

   public static void parse(String var0, Object var1) {
      if (var0 != null) {
         try {
            StringReader var2 = new StringReader(var0);
            parse(var2, var1);
         } catch (IOException var3) {
            throw Throwables.propagate(var3);
         }
      }
   }

   private static Object parseValue(Type var0, List<Type> var1, String var2) {
      return Data.parsePrimitiveValue(Data.resolveWildcardTypeOrTypeVariable(var1, var0), var2);
   }

   @Override
   public <T> T parseAndClose(InputStream var1, Charset var2, Class<T> var3) throws IOException {
      return this.parseAndClose(new InputStreamReader(var1, var2), var3);
   }

   @Override
   public Object parseAndClose(InputStream var1, Charset var2, Type var3) throws IOException {
      return this.parseAndClose(new InputStreamReader(var1, var2), var3);
   }

   @Override
   public <T> T parseAndClose(Reader var1, Class<T> var2) throws IOException {
      return (T)this.parseAndClose(var1, (Type)var2);
   }

   @Override
   public Object parseAndClose(Reader var1, Type var2) throws IOException {
      Preconditions.checkArgument(var2 instanceof Class, "dataType has to be of type Class<?>");
      Object var3 = Types.newInstance((Class)var2);
      parse(new BufferedReader(var1), var3);
      return var3;
   }
}
