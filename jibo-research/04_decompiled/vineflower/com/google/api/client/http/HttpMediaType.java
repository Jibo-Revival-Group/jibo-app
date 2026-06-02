package com.google.api.client.http;

import com.google.api.client.util.Preconditions;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class HttpMediaType {
   private static final Pattern FULL_MEDIA_TYPE_REGEX;
   private static final Pattern PARAMETER_REGEX;
   private static final Pattern TOKEN_REGEX = Pattern.compile("[\\p{ASCII}&&[^\\p{Cntrl} ;/=\\[\\]\\(\\)\\<\\>\\@\\,\\:\\\"\\?\\=]]+");
   private static final Pattern TYPE_REGEX = Pattern.compile("[\\w!#$&.+\\-\\^_]+|[*]");
   private String cachedBuildResult;
   private final SortedMap<String, String> parameters;
   private String subType;
   private String type = "application";

   static {
      String var0 = String.valueOf(String.valueOf("[^\\s/=;\"]+"));
      String var1 = String.valueOf(String.valueOf("[^\\s/=;\"]+"));
      String var2 = String.valueOf(String.valueOf(";.*"));
      FULL_MEDIA_TYPE_REGEX = Pattern.compile(
         new StringBuilder(var0.length() + 14 + var1.length() + var2.length())
            .append("\\s*(")
            .append(var0)
            .append(")/(")
            .append(var1)
            .append(")")
            .append("\\s*(")
            .append(var2)
            .append(")?")
            .toString(),
         32
      );
      var0 = String.valueOf(String.valueOf("\"([^\"]*)\""));
      var1 = String.valueOf(String.valueOf("[^\\s;\"]*"));
      var1 = new StringBuilder(var0.length() + 1 + var1.length()).append(var0).append("|").append(var1).toString();
      var0 = String.valueOf(String.valueOf("[^\\s/=;\"]+"));
      var1 = String.valueOf(String.valueOf(var1));
      PARAMETER_REGEX = Pattern.compile(
         new StringBuilder(var0.length() + 12 + var1.length()).append("\\s*;\\s*(").append(var0).append(")").append("=(").append(var1).append(")").toString()
      );
   }

   public HttpMediaType(String var1) {
      this.subType = "octet-stream";
      this.parameters = new TreeMap<>();
      this.fromString(var1);
   }

   public HttpMediaType(String var1, String var2) {
      this.subType = "octet-stream";
      this.parameters = new TreeMap<>();
      this.setType(var1);
      this.setSubType(var2);
   }

   public static boolean equalsIgnoreParameters(String var0, String var1) {
      boolean var2;
      if ((var0 != null || var1 != null) && (var0 == null || var1 == null || !new HttpMediaType(var0).equalsIgnoreParameters(new HttpMediaType(var1)))) {
         var2 = false;
      } else {
         var2 = true;
      }

      return var2;
   }

   private HttpMediaType fromString(String var1) {
      Matcher var5 = FULL_MEDIA_TYPE_REGEX.matcher(var1);
      Preconditions.checkArgument(var5.matches(), "Type must be in the 'maintype/subtype; parameter=value' format");
      this.setType(var5.group(1));
      this.setSubType(var5.group(2));
      var1 = var5.group(3);
      if (var1 != null) {
         Matcher var3 = PARAMETER_REGEX.matcher(var1);

         while (var3.find()) {
            String var4 = var3.group(1);
            String var2 = var3.group(3);
            var1 = var2;
            if (var2 == null) {
               var1 = var3.group(2);
            }

            this.setParameter(var4, var1);
         }
      }

      return this;
   }

   static boolean matchesToken(String var0) {
      return TOKEN_REGEX.matcher(var0).matches();
   }

   private static String quoteString(String var0) {
      var0 = String.valueOf(String.valueOf(var0.replace("\\", "\\\\").replace("\"", "\\\"")));
      return new StringBuilder(var0.length() + 2).append("\"").append(var0).append("\"").toString();
   }

   public String build() {
      String var1;
      if (this.cachedBuildResult != null) {
         var1 = this.cachedBuildResult;
      } else {
         StringBuilder var4 = new StringBuilder();
         var4.append(this.type);
         var4.append('/');
         var4.append(this.subType);
         if (this.parameters != null) {
            for (Entry var5 : this.parameters.entrySet()) {
               String var2 = (String)var5.getValue();
               var4.append("; ");
               var4.append((String)var5.getKey());
               var4.append("=");
               var1 = var2;
               if (!matchesToken(var2)) {
                  var1 = quoteString(var2);
               }

               var4.append(var1);
            }
         }

         this.cachedBuildResult = var4.toString();
         var1 = this.cachedBuildResult;
      }

      return var1;
   }

   public void clearParameters() {
      this.cachedBuildResult = null;
      this.parameters.clear();
   }

   @Override
   public boolean equals(Object var1) {
      boolean var3 = false;
      boolean var2;
      if (!(var1 instanceof HttpMediaType)) {
         var2 = var3;
      } else {
         var1 = var1;
         var2 = var3;
         if (this.equalsIgnoreParameters(var1)) {
            var2 = var3;
            if (this.parameters.equals(var1.parameters)) {
               var2 = true;
            }
         }
      }

      return var2;
   }

   public boolean equalsIgnoreParameters(HttpMediaType var1) {
      boolean var2;
      if (var1 != null && this.getType().equalsIgnoreCase(var1.getType()) && this.getSubType().equalsIgnoreCase(var1.getSubType())) {
         var2 = true;
      } else {
         var2 = false;
      }

      return var2;
   }

   public Charset getCharsetParameter() {
      String var1 = this.getParameter("charset");
      Charset var2;
      if (var1 == null) {
         var2 = null;
      } else {
         var2 = Charset.forName(var1);
      }

      return var2;
   }

   public String getParameter(String var1) {
      return this.parameters.get(var1.toLowerCase());
   }

   public Map<String, String> getParameters() {
      return Collections.unmodifiableMap(this.parameters);
   }

   public String getSubType() {
      return this.subType;
   }

   public String getType() {
      return this.type;
   }

   @Override
   public int hashCode() {
      return this.build().hashCode();
   }

   public HttpMediaType removeParameter(String var1) {
      this.cachedBuildResult = null;
      this.parameters.remove(var1.toLowerCase());
      return this;
   }

   public HttpMediaType setCharsetParameter(Charset var1) {
      String var2;
      if (var1 == null) {
         var2 = null;
      } else {
         var2 = var1.name();
      }

      this.setParameter("charset", var2);
      return this;
   }

   public HttpMediaType setParameter(String var1, String var2) {
      if (var2 == null) {
         this.removeParameter(var1);
      } else {
         Preconditions.checkArgument(TOKEN_REGEX.matcher(var1).matches(), "Name contains reserved characters");
         this.cachedBuildResult = null;
         this.parameters.put(var1.toLowerCase(), var2);
      }

      return this;
   }

   public HttpMediaType setSubType(String var1) {
      Preconditions.checkArgument(TYPE_REGEX.matcher(var1).matches(), "Subtype contains reserved characters");
      this.subType = var1;
      this.cachedBuildResult = null;
      return this;
   }

   public HttpMediaType setType(String var1) {
      Preconditions.checkArgument(TYPE_REGEX.matcher(var1).matches(), "Type contains reserved characters");
      this.type = var1;
      this.cachedBuildResult = null;
      return this;
   }

   @Override
   public String toString() {
      return this.build();
   }
}
