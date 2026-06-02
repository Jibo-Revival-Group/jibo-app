package com.google.api.client.http;

import com.google.api.client.util.Data;
import com.google.api.client.util.FieldInfo;
import com.google.api.client.util.Preconditions;
import com.google.api.client.util.Types;
import com.google.api.client.util.escape.CharEscapers;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class UrlEncodedContent extends AbstractHttpContent {
   private Object data;

   public UrlEncodedContent(Object var1) {
      super(UrlEncodedParser.MEDIA_TYPE);
      this.setData(var1);
   }

   private static boolean appendParam(boolean var0, Writer var1, String var2, Object var3) throws IOException {
      boolean var4 = var0;
      if (var3 != null) {
         if (Data.isNull(var3)) {
            var4 = var0;
         } else {
            if (var0) {
               var0 = false;
            } else {
               var1.write("&");
            }

            var1.write(var2);
            if (var3 instanceof Enum) {
               var2 = FieldInfo.of((Enum<?>)var3).getName();
            } else {
               var2 = var3.toString();
            }

            var2 = CharEscapers.escapeUri(var2);
            var4 = var0;
            if (var2.length() != 0) {
               var1.write("=");
               var1.write(var2);
               var4 = var0;
            }
         }
      }

      return var4;
   }

   public static UrlEncodedContent getContent(HttpRequest var0) {
      HttpContent var1 = var0.getContent();
      UrlEncodedContent var2;
      if (var1 != null) {
         var2 = (UrlEncodedContent)var1;
      } else {
         UrlEncodedContent var3 = new UrlEncodedContent(new HashMap());
         var0.setContent(var3);
         var2 = var3;
      }

      return var2;
   }

   public final Object getData() {
      return this.data;
   }

   public UrlEncodedContent setData(Object var1) {
      this.data = Preconditions.checkNotNull(var1);
      return this;
   }

   public UrlEncodedContent setMediaType(HttpMediaType var1) {
      super.setMediaType(var1);
      return this;
   }

   @Override
   public void writeTo(OutputStream var1) throws IOException {
      BufferedWriter var7 = new BufferedWriter(new OutputStreamWriter(var1, this.getCharset()));
      Iterator var3 = Data.mapOf(this.data).entrySet().iterator();
      boolean var2 = true;

      while (var3.hasNext()) {
         Entry var5 = (Entry)var3.next();
         Iterator var4 = (Iterator)var5.getValue();
         if (var4 != null) {
            String var9 = CharEscapers.escapeUri((String)var5.getKey());
            Class var6 = var4.getClass();
            if (!(var4 instanceof Iterable) && !var6.isArray()) {
               var2 = appendParam(var2, var7, var9, var4);
            } else {
               var4 = Types.iterableOf(var4).iterator();

               while (var4.hasNext()) {
                  var2 = appendParam(var2, var7, var9, var4.next());
               }
            }
         }
      }

      var7.flush();
   }
}
