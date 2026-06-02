package com.google.api.client.http;

import com.google.api.client.util.ArrayValueMap;
import com.google.api.client.util.Base64;
import com.google.api.client.util.ClassInfo;
import com.google.api.client.util.Data;
import com.google.api.client.util.FieldInfo;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.Key;
import com.google.api.client.util.Preconditions;
import com.google.api.client.util.StringUtils;
import com.google.api.client.util.Throwables;
import com.google.api.client.util.Types;
import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HttpHeaders extends GenericData {
   @Key("Accept")
   private List<String> accept;
   @Key("Accept-Encoding")
   private List<String> acceptEncoding = new ArrayList<>(Collections.singleton("gzip"));
   @Key("Age")
   private List<Long> age;
   @Key("WWW-Authenticate")
   private List<String> authenticate;
   @Key("Authorization")
   private List<String> authorization;
   @Key("Cache-Control")
   private List<String> cacheControl;
   @Key("Content-Encoding")
   private List<String> contentEncoding;
   @Key("Content-Length")
   private List<Long> contentLength;
   @Key("Content-MD5")
   private List<String> contentMD5;
   @Key("Content-Range")
   private List<String> contentRange;
   @Key("Content-Type")
   private List<String> contentType;
   @Key("Cookie")
   private List<String> cookie;
   @Key("Date")
   private List<String> date;
   @Key("ETag")
   private List<String> etag;
   @Key("Expires")
   private List<String> expires;
   @Key("If-Match")
   private List<String> ifMatch;
   @Key("If-Modified-Since")
   private List<String> ifModifiedSince;
   @Key("If-None-Match")
   private List<String> ifNoneMatch;
   @Key("If-Range")
   private List<String> ifRange;
   @Key("If-Unmodified-Since")
   private List<String> ifUnmodifiedSince;
   @Key("Last-Modified")
   private List<String> lastModified;
   @Key("Location")
   private List<String> location;
   @Key("MIME-Version")
   private List<String> mimeVersion;
   @Key("Range")
   private List<String> range;
   @Key("Retry-After")
   private List<String> retryAfter;
   @Key("User-Agent")
   private List<String> userAgent;

   public HttpHeaders() {
      super(EnumSet.of(GenericData.Flags.IGNORE_CASE));
   }

   private static void addHeader(Logger var0, StringBuilder var1, StringBuilder var2, LowLevelHttpRequest var3, String var4, Object var5, Writer var6) throws IOException {
      if (var5 != null && !Data.isNull(var5)) {
         var5 = toStringValue(var5);
         String var7;
         if (!"Authorization".equalsIgnoreCase(var4) && !"Cookie".equalsIgnoreCase(var4) || var0 != null && var0.isLoggable(Level.ALL)) {
            var7 = var5;
         } else {
            var7 = "<Not Logged>";
         }

         if (var1 != null) {
            var1.append(var4).append(": ");
            var1.append(var7);
            var1.append(StringUtils.LINE_SEPARATOR);
         }

         if (var2 != null) {
            var2.append(" -H '").append(var4).append(": ").append(var7).append("'");
         }

         if (var3 != null) {
            var3.addHeader(var4, var5);
         }

         if (var6 != null) {
            var6.write(var4);
            var6.write(": ");
            var6.write(var5);
            var6.write("\r\n");
         }
      }
   }

   private <T> List<T> getAsList(T var1) {
      if (var1 == null) {
         var1 = null;
      } else {
         ArrayList var2 = new ArrayList();
         var2.add(var1);
         var1 = var2;
      }

      return var1;
   }

   private <T> T getFirstHeaderValue(List<T> var1) {
      Object var2;
      if (var1 == null) {
         var2 = null;
      } else {
         var2 = var1.get(0);
      }

      return (T)var2;
   }

   private static Object parseValue(Type var0, List<Type> var1, String var2) {
      return Data.parsePrimitiveValue(Data.resolveWildcardTypeOrTypeVariable(var1, var0), var2);
   }

   static void serializeHeaders(HttpHeaders var0, StringBuilder var1, StringBuilder var2, Logger var3, LowLevelHttpRequest var4) throws IOException {
      serializeHeaders(var0, var1, var2, var3, var4, null);
   }

   static void serializeHeaders(HttpHeaders var0, StringBuilder var1, StringBuilder var2, Logger var3, LowLevelHttpRequest var4, Writer var5) throws IOException {
      HashSet var8 = new HashSet();

      for (Entry var9 : var0.entrySet()) {
         String var6 = (String)var9.getKey();
         Preconditions.checkArgument(var8.add(var6), "multiple headers of the same name (headers are case insensitive): %s", var6);
         Iterator var11 = (Iterator)var9.getValue();
         if (var11 != null) {
            FieldInfo var10 = var0.getClassInfo().getFieldInfo(var6);
            if (var10 != null) {
               var6 = var10.getName();
            }

            Class var13 = var11.getClass();
            if (!(var11 instanceof Iterable) && !var13.isArray()) {
               addHeader(var3, var1, var2, var4, var6, var11, var5);
            } else {
               var11 = Types.iterableOf(var11).iterator();

               while (var11.hasNext()) {
                  addHeader(var3, var1, var2, var4, var6, var11.next(), var5);
               }
            }
         }
      }

      if (var5 != null) {
         var5.flush();
      }
   }

   public static void serializeHeadersForMultipartRequests(HttpHeaders var0, StringBuilder var1, Logger var2, Writer var3) throws IOException {
      serializeHeaders(var0, var1, null, var2, null, var3);
   }

   private static String toStringValue(Object var0) {
      String var1;
      if (var0 instanceof Enum) {
         var1 = FieldInfo.of((Enum<?>)var0).getName();
      } else {
         var1 = var0.toString();
      }

      return var1;
   }

   public HttpHeaders clone() {
      return (HttpHeaders)super.clone();
   }

   public final void fromHttpHeaders(HttpHeaders var1) {
      try {
         HttpHeaders.ParseHeaderState var3 = new HttpHeaders.ParseHeaderState(this, null);
         HttpHeaders.HeaderParsingFakeLevelHttpRequest var2 = new HttpHeaders.HeaderParsingFakeLevelHttpRequest(this, var3);
         serializeHeaders(var1, null, null, null, var2);
         var3.finish();
      } catch (IOException var4) {
         throw Throwables.propagate(var4);
      }
   }

   public final void fromHttpResponse(LowLevelHttpResponse var1, StringBuilder var2) throws IOException {
      this.clear();
      HttpHeaders.ParseHeaderState var5 = new HttpHeaders.ParseHeaderState(this, var2);
      int var4 = var1.getHeaderCount();

      for (int var3 = 0; var3 < var4; var3++) {
         this.parseHeader(var1.getHeaderName(var3), var1.getHeaderValue(var3), var5);
      }

      var5.finish();
   }

   public final String getAccept() {
      return this.getFirstHeaderValue(this.accept);
   }

   public final String getAcceptEncoding() {
      return this.getFirstHeaderValue(this.acceptEncoding);
   }

   public final Long getAge() {
      return this.getFirstHeaderValue(this.age);
   }

   public final String getAuthenticate() {
      return this.getFirstHeaderValue(this.authenticate);
   }

   public final List<String> getAuthenticateAsList() {
      return this.authenticate;
   }

   public final String getAuthorization() {
      return this.getFirstHeaderValue(this.authorization);
   }

   public final List<String> getAuthorizationAsList() {
      return this.authorization;
   }

   public final String getCacheControl() {
      return this.getFirstHeaderValue(this.cacheControl);
   }

   public final String getContentEncoding() {
      return this.getFirstHeaderValue(this.contentEncoding);
   }

   public final Long getContentLength() {
      return this.getFirstHeaderValue(this.contentLength);
   }

   public final String getContentMD5() {
      return this.getFirstHeaderValue(this.contentMD5);
   }

   public final String getContentRange() {
      return this.getFirstHeaderValue(this.contentRange);
   }

   public final String getContentType() {
      return this.getFirstHeaderValue(this.contentType);
   }

   public final String getCookie() {
      return this.getFirstHeaderValue(this.cookie);
   }

   public final String getDate() {
      return this.getFirstHeaderValue(this.date);
   }

   public final String getETag() {
      return this.getFirstHeaderValue(this.etag);
   }

   public final String getExpires() {
      return this.getFirstHeaderValue(this.expires);
   }

   public String getFirstHeaderStringValue(String var1) {
      String var3 = (String)this.get(var1.toLowerCase());
      if (var3 == null) {
         var3 = null;
      } else {
         Class var2 = var3.getClass();
         if (var3 instanceof Iterable || var2.isArray()) {
            Iterator var5 = Types.iterableOf(var3).iterator();
            if (var5.hasNext()) {
               var3 = toStringValue(var5.next());
               return var3;
            }
         }

         var3 = toStringValue(var3);
      }

      return var3;
   }

   public List<String> getHeaderStringValues(String var1) {
      List var3 = (List)this.get(var1.toLowerCase());
      if (var3 == null) {
         var3 = Collections.emptyList();
      } else {
         Class var2 = var3.getClass();
         if (!(var3 instanceof Iterable) && !var2.isArray()) {
            var3 = Collections.singletonList(toStringValue(var3));
         } else {
            ArrayList var6 = new ArrayList();
            Iterator var5 = Types.iterableOf(var3).iterator();

            while (var5.hasNext()) {
               var6.add(toStringValue(var5.next()));
            }

            var3 = Collections.unmodifiableList(var6);
         }
      }

      return var3;
   }

   public final String getIfMatch() {
      return this.getFirstHeaderValue(this.ifMatch);
   }

   public final String getIfModifiedSince() {
      return this.getFirstHeaderValue(this.ifModifiedSince);
   }

   public final String getIfNoneMatch() {
      return this.getFirstHeaderValue(this.ifNoneMatch);
   }

   public final String getIfRange() {
      return this.getFirstHeaderValue(this.ifRange);
   }

   public final String getIfUnmodifiedSince() {
      return this.getFirstHeaderValue(this.ifUnmodifiedSince);
   }

   public final String getLastModified() {
      return this.getFirstHeaderValue(this.lastModified);
   }

   public final String getLocation() {
      return this.getFirstHeaderValue(this.location);
   }

   public final String getMimeVersion() {
      return this.getFirstHeaderValue(this.mimeVersion);
   }

   public final String getRange() {
      return this.getFirstHeaderValue(this.range);
   }

   public final String getRetryAfter() {
      return this.getFirstHeaderValue(this.retryAfter);
   }

   public final String getUserAgent() {
      return this.getFirstHeaderValue(this.userAgent);
   }

   void parseHeader(String var1, String var2, HttpHeaders.ParseHeaderState var3) {
      ArrayList var4 = var3.context;
      ClassInfo var6 = var3.classInfo;
      ArrayValueMap var5 = var3.arrayValueMap;
      StringBuilder var8 = var3.logger;
      if (var8 != null) {
         String var11 = String.valueOf(String.valueOf(var1));
         String var7 = String.valueOf(String.valueOf(var2));
         var8.append(new StringBuilder(var11.length() + 2 + var7.length()).append(var11).append(": ").append(var7).toString())
            .append(StringUtils.LINE_SEPARATOR);
      }

      FieldInfo var16 = var6.getFieldInfo(var1);
      if (var16 != null) {
         Type var17 = Data.resolveWildcardTypeOrTypeVariable(var4, var16.getGenericType());
         if (Types.isArray(var17)) {
            Class var9 = Types.getRawArrayComponentType(var4, Types.getArrayComponentType(var17));
            var5.put(var16.getField(), var9, parseValue(var9, var4, var2));
         } else if (Types.isAssignableToOrFrom(Types.getRawArrayComponentType(var4, var17), Iterable.class)) {
            Collection var12 = (Collection)var16.getValue(this);
            Collection var10 = var12;
            if (var12 == null) {
               var10 = Data.newCollectionInstance(var17);
               var16.setValue(this, var10);
            }

            Type var13;
            if (var17 == Object.class) {
               var13 = null;
            } else {
               var13 = Types.getIterableParameter(var17);
            }

            var10.add(parseValue(var13, var4, var2));
         } else {
            var16.setValue(this, parseValue(var17, var4, var2));
         }
      } else {
         var4 = (ArrayList)this.get(var1);
         ArrayList var14 = var4;
         if (var4 == null) {
            var14 = new ArrayList();
            this.set(var1, var14);
         }

         var14.add(var2);
      }
   }

   public HttpHeaders set(String var1, Object var2) {
      return (HttpHeaders)super.set(var1, var2);
   }

   public HttpHeaders setAccept(String var1) {
      this.accept = this.getAsList(var1);
      return this;
   }

   public HttpHeaders setAcceptEncoding(String var1) {
      this.acceptEncoding = this.getAsList(var1);
      return this;
   }

   public HttpHeaders setAge(Long var1) {
      this.age = this.getAsList(var1);
      return this;
   }

   public HttpHeaders setAuthenticate(String var1) {
      this.authenticate = this.getAsList(var1);
      return this;
   }

   public HttpHeaders setAuthorization(String var1) {
      return this.setAuthorization(this.getAsList(var1));
   }

   public HttpHeaders setAuthorization(List<String> var1) {
      this.authorization = var1;
      return this;
   }

   public HttpHeaders setBasicAuthentication(String var1, String var2) {
      var1 = String.valueOf(String.valueOf(Preconditions.checkNotNull(var1)));
      var2 = String.valueOf(String.valueOf(Preconditions.checkNotNull(var2)));
      var1 = String.valueOf(
         Base64.encodeBase64String(
            StringUtils.getBytesUtf8(new StringBuilder(var1.length() + 1 + var2.length()).append(var1).append(":").append(var2).toString())
         )
      );
      if (var1.length() != 0) {
         var1 = "Basic ".concat(var1);
      } else {
         var1 = new String("Basic ");
      }

      return this.setAuthorization(var1);
   }

   public HttpHeaders setCacheControl(String var1) {
      this.cacheControl = this.getAsList(var1);
      return this;
   }

   public HttpHeaders setContentEncoding(String var1) {
      this.contentEncoding = this.getAsList(var1);
      return this;
   }

   public HttpHeaders setContentLength(Long var1) {
      this.contentLength = this.getAsList(var1);
      return this;
   }

   public HttpHeaders setContentMD5(String var1) {
      this.contentMD5 = this.getAsList(var1);
      return this;
   }

   public HttpHeaders setContentRange(String var1) {
      this.contentRange = this.getAsList(var1);
      return this;
   }

   public HttpHeaders setContentType(String var1) {
      this.contentType = this.getAsList(var1);
      return this;
   }

   public HttpHeaders setCookie(String var1) {
      this.cookie = this.getAsList(var1);
      return this;
   }

   public HttpHeaders setDate(String var1) {
      this.date = this.getAsList(var1);
      return this;
   }

   public HttpHeaders setETag(String var1) {
      this.etag = this.getAsList(var1);
      return this;
   }

   public HttpHeaders setExpires(String var1) {
      this.expires = this.getAsList(var1);
      return this;
   }

   public HttpHeaders setIfMatch(String var1) {
      this.ifMatch = this.getAsList(var1);
      return this;
   }

   public HttpHeaders setIfModifiedSince(String var1) {
      this.ifModifiedSince = this.getAsList(var1);
      return this;
   }

   public HttpHeaders setIfNoneMatch(String var1) {
      this.ifNoneMatch = this.getAsList(var1);
      return this;
   }

   public HttpHeaders setIfRange(String var1) {
      this.ifRange = this.getAsList(var1);
      return this;
   }

   public HttpHeaders setIfUnmodifiedSince(String var1) {
      this.ifUnmodifiedSince = this.getAsList(var1);
      return this;
   }

   public HttpHeaders setLastModified(String var1) {
      this.lastModified = this.getAsList(var1);
      return this;
   }

   public HttpHeaders setLocation(String var1) {
      this.location = this.getAsList(var1);
      return this;
   }

   public HttpHeaders setMimeVersion(String var1) {
      this.mimeVersion = this.getAsList(var1);
      return this;
   }

   public HttpHeaders setRange(String var1) {
      this.range = this.getAsList(var1);
      return this;
   }

   public HttpHeaders setRetryAfter(String var1) {
      this.retryAfter = this.getAsList(var1);
      return this;
   }

   public HttpHeaders setUserAgent(String var1) {
      this.userAgent = this.getAsList(var1);
      return this;
   }

   private static class HeaderParsingFakeLevelHttpRequest extends LowLevelHttpRequest {
      private final HttpHeaders.ParseHeaderState state;
      private final HttpHeaders target;

      HeaderParsingFakeLevelHttpRequest(HttpHeaders var1, HttpHeaders.ParseHeaderState var2) {
         this.target = var1;
         this.state = var2;
      }

      @Override
      public void addHeader(String var1, String var2) {
         this.target.parseHeader(var1, var2, this.state);
      }

      @Override
      public LowLevelHttpResponse execute() throws IOException {
         throw new UnsupportedOperationException();
      }
   }

   private static final class ParseHeaderState {
      final ArrayValueMap arrayValueMap;
      final ClassInfo classInfo;
      final List<Type> context;
      final StringBuilder logger;

      public ParseHeaderState(HttpHeaders var1, StringBuilder var2) {
         Class var3 = var1.getClass();
         this.context = Arrays.asList(var3);
         this.classInfo = ClassInfo.of(var3, true);
         this.logger = var2;
         this.arrayValueMap = new ArrayValueMap(var1);
      }

      void finish() {
         this.arrayValueMap.setValues();
      }
   }
}
