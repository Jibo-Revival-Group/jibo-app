package org.apache.http.entity;

import java.io.Serializable;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map.Entry;
import org.apache.http.Consts;
import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.annotation.Immutable;
import org.apache.http.message.BasicHeaderValueFormatter;
import org.apache.http.message.BasicHeaderValueParser;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.message.ParserCursor;
import org.apache.http.util.Args;
import org.apache.http.util.CharArrayBuffer;
import org.apache.http.util.TextUtils;

@Immutable
public final class ContentType implements Serializable {
   public static final ContentType APPLICATION_ATOM_XML = create("application/atom+xml", Consts.ISO_8859_1);
   public static final ContentType APPLICATION_FORM_URLENCODED = create("application/x-www-form-urlencoded", Consts.ISO_8859_1);
   public static final ContentType APPLICATION_JSON = create("application/json", Consts.UTF_8);
   public static final ContentType APPLICATION_OCTET_STREAM = create("application/octet-stream", (Charset)null);
   public static final ContentType APPLICATION_SVG_XML = create("application/svg+xml", Consts.ISO_8859_1);
   public static final ContentType APPLICATION_XHTML_XML = create("application/xhtml+xml", Consts.ISO_8859_1);
   public static final ContentType APPLICATION_XML = create("application/xml", Consts.ISO_8859_1);
   public static final ContentType DEFAULT_BINARY = APPLICATION_OCTET_STREAM;
   public static final ContentType DEFAULT_TEXT = ContentType.TEXT_PLAIN;
   public static final ContentType MULTIPART_FORM_DATA = create("multipart/form-data", Consts.ISO_8859_1);
   public static final ContentType TEXT_HTML = create("text/html", Consts.ISO_8859_1);
   public static final ContentType TEXT_PLAIN = create("text/plain", Consts.ISO_8859_1);
   public static final ContentType TEXT_XML = create("text/xml", Consts.ISO_8859_1);
   public static final ContentType WILDCARD = create("*/*", (Charset)null);
   private static final long serialVersionUID = -7768694718232371896L;
   private final Charset charset;
   private final String mimeType;
   private final NameValuePair[] params;

   ContentType(String var1, Charset var2) {
      this.mimeType = var1;
      this.charset = var2;
      this.params = null;
   }

   ContentType(String var1, Charset var2, NameValuePair[] var3) {
      this.mimeType = var1;
      this.charset = var2;
      this.params = var3;
   }

   public static ContentType create(String var0) {
      return new ContentType(var0, (Charset)null);
   }

   public static ContentType create(String var0, String var1) throws UnsupportedCharsetException {
      Charset var2;
      if (!TextUtils.isBlank(var1)) {
         var2 = Charset.forName(var1);
      } else {
         var2 = null;
      }

      return create(var0, var2);
   }

   public static ContentType create(String var0, Charset var1) {
      var0 = Args.notBlank(var0, "MIME type").toLowerCase(Locale.ROOT);
      Args.check(valid(var0), "MIME type may not contain reserved characters");
      return new ContentType(var0, var1);
   }

   public static ContentType create(String var0, NameValuePair... var1) throws UnsupportedCharsetException {
      Args.check(valid(Args.notBlank(var0, "MIME type").toLowerCase(Locale.ROOT)), "MIME type may not contain reserved characters");
      return create(var0, var1, true);
   }

   private static ContentType create(String var0, NameValuePair[] var1, boolean var2) {
      int var4 = var1.length;
      int var3 = 0;

      Charset var8;
      while (true) {
         if (var3 < var4) {
            NameValuePair var5 = var1[var3];
            if (!var5.getName().equalsIgnoreCase("charset")) {
               var3++;
               continue;
            }

            String var7 = var5.getValue();
            if (!TextUtils.isBlank(var7)) {
               try {
                  var8 = Charset.forName(var7);
               } catch (UnsupportedCharsetException var6) {
                  if (var2) {
                     throw var6;
                  }

                  var8 = null;
               }
               break;
            }
         }

         var8 = null;
         break;
      }

      if (var1 == null || var1.length <= 0) {
         var1 = null;
      }

      return new ContentType(var0, var8, var1);
   }

   private static ContentType create(HeaderElement var0, boolean var1) {
      return create(var0.getName(), var0.getParameters(), var1);
   }

   public static ContentType get(HttpEntity var0) throws ParseException, UnsupportedCharsetException {
      Object var1 = null;
      ContentType var3;
      if (var0 == null) {
         var3 = (ContentType)var1;
      } else {
         Header var2 = var0.getContentType();
         var3 = (ContentType)var1;
         if (var2 != null) {
            HeaderElement[] var4 = var2.getElements();
            var3 = (ContentType)var1;
            if (var4.length > 0) {
               var3 = create(var4[0], true);
            }
         }
      }

      return var3;
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   public static ContentType getLenient(HttpEntity var0) {
      Object var1 = null;
      ContentType var5;
      if (var0 == null) {
         var5 = (ContentType)var1;
      } else {
         Header var2 = var0.getContentType();
         var5 = (ContentType)var1;
         if (var2 != null) {
            try {
               var6 = var2.getElements();
            } catch (ParseException var4) {
               Object var7 = var1;
               return (ContentType)var7;
            }

            var5 = (ContentType)var1;

            try {
               if (var6.length > 0) {
                  var5 = create(var6[0], false);
               }
            } catch (ParseException var3) {
               var5 = (ContentType)var1;
            }
         }
      }

      return var5;
   }

   public static ContentType getLenientOrDefault(HttpEntity var0) throws ParseException, UnsupportedCharsetException {
      ContentType var1 = get(var0);
      if (var1 == null) {
         var1 = DEFAULT_TEXT;
      }

      return var1;
   }

   public static ContentType getOrDefault(HttpEntity var0) throws ParseException, UnsupportedCharsetException {
      ContentType var1 = get(var0);
      if (var1 == null) {
         var1 = DEFAULT_TEXT;
      }

      return var1;
   }

   public static ContentType parse(String var0) throws ParseException, UnsupportedCharsetException {
      Args.notNull(var0, "Content type");
      CharArrayBuffer var1 = new CharArrayBuffer(var0.length());
      var1.append(var0);
      ParserCursor var2 = new ParserCursor(0, var0.length());
      HeaderElement[] var3 = BasicHeaderValueParser.INSTANCE.parseElements(var1, var2);
      if (var3.length > 0) {
         return create(var3[0], true);
      } else {
         throw new ParseException("Invalid content type: " + var0);
      }
   }

   private static boolean valid(String var0) {
      boolean var4 = false;
      int var1 = 0;

      boolean var3;
      while (true) {
         if (var1 >= var0.length()) {
            var3 = true;
            break;
         }

         char var2 = var0.charAt(var1);
         var3 = var4;
         if (var2 == '"') {
            break;
         }

         var3 = var4;
         if (var2 == ',') {
            break;
         }

         if (var2 == ';') {
            var3 = var4;
            break;
         }

         var1++;
      }

      return var3;
   }

   public Charset getCharset() {
      return this.charset;
   }

   public String getMimeType() {
      return this.mimeType;
   }

   public String getParameter(String var1) {
      Object var5 = null;
      Args.notEmpty(var1, "Parameter name");
      String var4;
      if (this.params == null) {
         var4 = (String)var5;
      } else {
         NameValuePair[] var6 = this.params;
         int var3 = var6.length;
         int var2 = 0;

         while (true) {
            var4 = (String)var5;
            if (var2 >= var3) {
               break;
            }

            NameValuePair var7 = var6[var2];
            if (var7.getName().equalsIgnoreCase(var1)) {
               var4 = var7.getValue();
               break;
            }

            var2++;
         }
      }

      return var4;
   }

   @Override
   public String toString() {
      CharArrayBuffer var1 = new CharArrayBuffer(64);
      var1.append(this.mimeType);
      if (this.params != null) {
         var1.append("; ");
         BasicHeaderValueFormatter.INSTANCE.formatParameters(var1, this.params, false);
      } else if (this.charset != null) {
         var1.append("; charset=");
         var1.append(this.charset.name());
      }

      return var1.toString();
   }

   public ContentType withCharset(String var1) {
      return create(this.getMimeType(), var1);
   }

   public ContentType withCharset(Charset var1) {
      return create(this.getMimeType(), var1);
   }

   public ContentType withParameters(NameValuePair... var1) throws UnsupportedCharsetException {
      byte var3 = 0;
      ContentType var8;
      if (var1.length == 0) {
         var8 = this;
      } else {
         LinkedHashMap var5 = new LinkedHashMap();
         if (this.params != null) {
            for (NameValuePair var6 : this.params) {
               var5.put(var6.getName(), var6.getValue());
            }
         }

         int var11 = var1.length;

         for (int var10 = var3; var10 < var11; var10++) {
            NameValuePair var13 = var1[var10];
            var5.put(var13.getName(), var13.getValue());
         }

         ArrayList var9 = new ArrayList(var5.size() + 1);
         if (this.charset != null && !var5.containsKey("charset")) {
            var9.add(new BasicNameValuePair("charset", this.charset.name()));
         }

         for (Entry var12 : var5.entrySet()) {
            var9.add(new BasicNameValuePair((String)var12.getKey(), (String)var12.getValue()));
         }

         var8 = create(this.getMimeType(), var9.toArray(new NameValuePair[var9.size()]), true);
      }

      return var8;
   }
}
