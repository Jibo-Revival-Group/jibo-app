package com.google.api.client.googleapis.json;

import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpResponseException;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.util.Preconditions;
import java.io.IOException;

public class GoogleJsonResponseException extends HttpResponseException {
   private static final long serialVersionUID = 409811126989994864L;
   private final transient GoogleJsonError details;

   public GoogleJsonResponseException(HttpResponseException.Builder var1, GoogleJsonError var2) {
      super(var1);
      this.details = var2;
   }

   public static HttpResponse execute(JsonFactory var0, HttpRequest var1) throws GoogleJsonResponseException, IOException {
      Preconditions.checkNotNull(var0);
      boolean var2 = var1.getThrowExceptionOnExecuteError();
      if (var2) {
         var1.setThrowExceptionOnExecuteError(false);
      }

      HttpResponse var3 = var1.execute();
      var1.setThrowExceptionOnExecuteError(var2);
      if (var2 && !var3.isSuccessStatusCode()) {
         throw from(var0, var3);
      } else {
         return var3;
      }
   }

   public static GoogleJsonResponseException from(JsonFactory param0, HttpResponse param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 000: aconst_null
      // 001: astore 3
      // 002: aconst_null
      // 003: astore 2
      // 004: aconst_null
      // 005: astore 5
      // 007: new com/google/api/client/http/HttpResponseException$Builder
      // 00a: dup
      // 00b: aload 1
      // 00c: invokevirtual com/google/api/client/http/HttpResponse.getStatusCode ()I
      // 00f: aload 1
      // 010: invokevirtual com/google/api/client/http/HttpResponse.getStatusMessage ()Ljava/lang/String;
      // 013: aload 1
      // 014: invokevirtual com/google/api/client/http/HttpResponse.getHeaders ()Lcom/google/api/client/http/HttpHeaders;
      // 017: invokespecial com/google/api/client/http/HttpResponseException$Builder.<init> (ILjava/lang/String;Lcom/google/api/client/http/HttpHeaders;)V
      // 01a: astore 6
      // 01c: aload 0
      // 01d: invokestatic com/google/api/client/util/Preconditions.checkNotNull (Ljava/lang/Object;)Ljava/lang/Object;
      // 020: pop
      // 021: aload 1
      // 022: invokevirtual com/google/api/client/http/HttpResponse.isSuccessStatusCode ()Z
      // 025: ifne 146
      // 028: ldc "application/json; charset=UTF-8"
      // 02a: aload 1
      // 02b: invokevirtual com/google/api/client/http/HttpResponse.getContentType ()Ljava/lang/String;
      // 02e: invokestatic com/google/api/client/http/HttpMediaType.equalsIgnoreParameters (Ljava/lang/String;Ljava/lang/String;)Z
      // 031: ifeq 146
      // 034: aload 1
      // 035: invokevirtual com/google/api/client/http/HttpResponse.getContent ()Ljava/io/InputStream;
      // 038: astore 4
      // 03a: aload 4
      // 03c: ifnull 146
      // 03f: aload 0
      // 040: aload 1
      // 041: invokevirtual com/google/api/client/http/HttpResponse.getContent ()Ljava/io/InputStream;
      // 044: invokevirtual com/google/api/client/json/JsonFactory.createJsonParser (Ljava/io/InputStream;)Lcom/google/api/client/json/JsonParser;
      // 047: astore 3
      // 048: aload 3
      // 049: invokevirtual com/google/api/client/json/JsonParser.getCurrentToken ()Lcom/google/api/client/json/JsonToken;
      // 04c: astore 2
      // 04d: aload 2
      // 04e: astore 0
      // 04f: aload 2
      // 050: ifnonnull 058
      // 053: aload 3
      // 054: invokevirtual com/google/api/client/json/JsonParser.nextToken ()Lcom/google/api/client/json/JsonToken;
      // 057: astore 0
      // 058: aload 0
      // 059: ifnull 184
      // 05c: aload 3
      // 05d: ldc "error"
      // 05f: invokevirtual com/google/api/client/json/JsonParser.skipToKey (Ljava/lang/String;)V
      // 062: aload 3
      // 063: invokevirtual com/google/api/client/json/JsonParser.getCurrentToken ()Lcom/google/api/client/json/JsonToken;
      // 066: getstatic com/google/api/client/json/JsonToken.END_OBJECT Lcom/google/api/client/json/JsonToken;
      // 069: if_acmpeq 184
      // 06c: aload 3
      // 06d: ldc com/google/api/client/googleapis/json/GoogleJsonError
      // 06f: invokevirtual com/google/api/client/json/JsonParser.parseAndClose (Ljava/lang/Class;)Ljava/lang/Object;
      // 072: checkcast com/google/api/client/googleapis/json/GoogleJsonError
      // 075: astore 0
      // 076: aload 0
      // 077: astore 4
      // 079: aload 3
      // 07a: astore 2
      // 07b: aload 0
      // 07c: invokevirtual com/google/api/client/googleapis/json/GoogleJsonError.toPrettyString ()Ljava/lang/String;
      // 07f: astore 5
      // 081: aload 5
      // 083: astore 4
      // 085: aload 0
      // 086: astore 5
      // 088: aload 3
      // 089: ifnonnull 0ca
      // 08c: aload 1
      // 08d: invokevirtual com/google/api/client/http/HttpResponse.ignore ()V
      // 090: aload 5
      // 092: astore 2
      // 093: aload 4
      // 095: astore 0
      // 096: aload 1
      // 097: invokestatic com/google/api/client/http/HttpResponseException.computeMessageBuffer (Lcom/google/api/client/http/HttpResponse;)Ljava/lang/StringBuilder;
      // 09a: astore 1
      // 09b: aload 0
      // 09c: invokestatic com/google/api/client/util/Strings.isNullOrEmpty (Ljava/lang/String;)Z
      // 09f: ifne 0b5
      // 0a2: aload 1
      // 0a3: getstatic com/google/api/client/util/StringUtils.LINE_SEPARATOR Ljava/lang/String;
      // 0a6: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 0a9: aload 0
      // 0aa: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 0ad: pop
      // 0ae: aload 6
      // 0b0: aload 0
      // 0b1: invokevirtual com/google/api/client/http/HttpResponseException$Builder.setContent (Ljava/lang/String;)Lcom/google/api/client/http/HttpResponseException$Builder;
      // 0b4: pop
      // 0b5: aload 6
      // 0b7: aload 1
      // 0b8: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 0bb: invokevirtual com/google/api/client/http/HttpResponseException$Builder.setMessage (Ljava/lang/String;)Lcom/google/api/client/http/HttpResponseException$Builder;
      // 0be: pop
      // 0bf: new com/google/api/client/googleapis/json/GoogleJsonResponseException
      // 0c2: dup
      // 0c3: aload 6
      // 0c5: aload 2
      // 0c6: invokespecial com/google/api/client/googleapis/json/GoogleJsonResponseException.<init> (Lcom/google/api/client/http/HttpResponseException$Builder;Lcom/google/api/client/googleapis/json/GoogleJsonError;)V
      // 0c9: areturn
      // 0ca: aload 4
      // 0cc: astore 0
      // 0cd: aload 5
      // 0cf: astore 2
      // 0d0: aload 5
      // 0d2: ifnonnull 096
      // 0d5: aload 3
      // 0d6: invokevirtual com/google/api/client/json/JsonParser.close ()V
      // 0d9: aload 4
      // 0db: astore 0
      // 0dc: aload 5
      // 0de: astore 2
      // 0df: goto 096
      // 0e2: astore 3
      // 0e3: aload 5
      // 0e5: astore 2
      // 0e6: aload 4
      // 0e8: astore 0
      // 0e9: aload 3
      // 0ea: invokevirtual java/io/IOException.printStackTrace ()V
      // 0ed: goto 096
      // 0f0: astore 5
      // 0f2: aconst_null
      // 0f3: astore 3
      // 0f4: aconst_null
      // 0f5: astore 0
      // 0f6: aload 0
      // 0f7: astore 4
      // 0f9: aload 3
      // 0fa: astore 2
      // 0fb: aload 5
      // 0fd: invokevirtual java/io/IOException.printStackTrace ()V
      // 100: aload 3
      // 101: ifnonnull 10f
      // 104: aload 1
      // 105: invokevirtual com/google/api/client/http/HttpResponse.ignore ()V
      // 108: aload 0
      // 109: astore 2
      // 10a: aconst_null
      // 10b: astore 0
      // 10c: goto 096
      // 10f: aload 0
      // 110: ifnonnull 17d
      // 113: aload 3
      // 114: invokevirtual com/google/api/client/json/JsonParser.close ()V
      // 117: aload 0
      // 118: astore 2
      // 119: aconst_null
      // 11a: astore 0
      // 11b: goto 096
      // 11e: astore 4
      // 120: aconst_null
      // 121: astore 2
      // 122: aconst_null
      // 123: astore 0
      // 124: aload 2
      // 125: ifnonnull 13b
      // 128: aload 1
      // 129: invokevirtual com/google/api/client/http/HttpResponse.ignore ()V
      // 12c: aload 4
      // 12e: athrow
      // 12f: astore 3
      // 130: aconst_null
      // 131: astore 4
      // 133: aload 0
      // 134: astore 2
      // 135: aload 4
      // 137: astore 0
      // 138: goto 0e9
      // 13b: aload 0
      // 13c: ifnonnull 12c
      // 13f: aload 2
      // 140: invokevirtual com/google/api/client/json/JsonParser.close ()V
      // 143: goto 12c
      // 146: aload 1
      // 147: invokevirtual com/google/api/client/http/HttpResponse.parseAsString ()Ljava/lang/String;
      // 14a: astore 0
      // 14b: aload 3
      // 14c: astore 2
      // 14d: goto 096
      // 150: astore 3
      // 151: aconst_null
      // 152: astore 0
      // 153: goto 0e9
      // 156: astore 3
      // 157: aload 0
      // 158: astore 2
      // 159: aconst_null
      // 15a: astore 0
      // 15b: goto 0e9
      // 15e: astore 4
      // 160: aconst_null
      // 161: astore 0
      // 162: aload 3
      // 163: astore 2
      // 164: goto 124
      // 167: astore 3
      // 168: aload 4
      // 16a: astore 0
      // 16b: aload 3
      // 16c: astore 4
      // 16e: goto 124
      // 171: astore 5
      // 173: aconst_null
      // 174: astore 0
      // 175: goto 0f6
      // 178: astore 5
      // 17a: goto 0f6
      // 17d: aload 0
      // 17e: astore 2
      // 17f: aconst_null
      // 180: astore 0
      // 181: goto 096
      // 184: aconst_null
      // 185: astore 4
      // 187: goto 088
      // try (19 -> 30): 187 java/io/IOException
      // try (32 -> 37): 128 java/io/IOException
      // try (32 -> 37): 157 null
      // try (37 -> 40): 209 java/io/IOException
      // try (37 -> 40): 197 null
      // try (44 -> 47): 209 java/io/IOException
      // try (44 -> 47): 197 null
      // try (49 -> 61): 209 java/io/IOException
      // try (49 -> 61): 197 null
      // try (65 -> 68): 213 java/io/IOException
      // try (65 -> 68): 203 null
      // try (74 -> 76): 120 java/io/IOException
      // try (113 -> 115): 120 java/io/IOException
      // try (137 -> 139): 203 null
      // try (141 -> 143): 191 java/io/IOException
      // try (150 -> 152): 191 java/io/IOException
      // try (164 -> 166): 168 java/io/IOException
      // try (166 -> 168): 168 java/io/IOException
      // try (178 -> 180): 168 java/io/IOException
      // try (181 -> 184): 187 java/io/IOException
   }

   public final GoogleJsonError getDetails() {
      return this.details;
   }
}
