package com.google.api.client.auth.oauth2;

import com.google.api.client.http.HttpMediaType;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpResponseException;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.JsonObjectParser;
import com.google.api.client.util.Preconditions;
import com.google.api.client.util.StringUtils;
import com.google.api.client.util.Strings;
import java.io.IOException;

public class TokenResponseException extends HttpResponseException {
   private static final long serialVersionUID = 4020689092957439244L;
   private final transient TokenErrorResponse details;

   TokenResponseException(HttpResponseException.Builder var1, TokenErrorResponse var2) {
      super(var1);
      this.details = var2;
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   public static TokenResponseException from(JsonFactory var0, HttpResponse var1) {
      TokenErrorResponse var2 = null;
      HttpResponseException.Builder var4 = new HttpResponseException.Builder(var1.getStatusCode(), var1.getStatusMessage(), var1.getHeaders());
      Preconditions.checkNotNull(var0);
      String var3 = var1.getContentType();

      label47: {
         label51: {
            label45: {
               label44: {
                  try {
                     if (var1.isSuccessStatusCode()) {
                        break label44;
                     }
                  } catch (IOException var8) {
                     var12 = var8;
                     var9 = null;
                     break label51;
                  }

                  if (var3 != null) {
                     try {
                        if (var1.getContent() != null && HttpMediaType.equalsIgnoreParameters("application/json; charset=UTF-8", var3)) {
                           JsonObjectParser var13 = new JsonObjectParser(var0);
                           var9 = var13.parseAndClose(var1.getContent(), var1.getContentCharset(), TokenErrorResponse.class);
                           break label45;
                        }
                     } catch (IOException var7) {
                        var12 = var7;
                        var9 = null;
                        break label51;
                     }
                  }
               }

               try {
                  var10 = var1.parseAsString();
                  break label47;
               } catch (IOException var6) {
                  var12 = var6;
                  var9 = null;
                  break label51;
               }
            }

            try {
               var3 = var9.toPrettyString();
            } catch (IOException var5) {
               var12 = var5;
               break label51;
            }

            var2 = var9;
            var10 = var3;
            break label47;
         }

         var12.printStackTrace();
         var2 = var9;
         var10 = null;
      }

      StringBuilder var11 = HttpResponseException.computeMessageBuffer(var1);
      if (!Strings.isNullOrEmpty(var10)) {
         var11.append(StringUtils.LINE_SEPARATOR).append(var10);
         var4.setContent(var10);
      }

      var4.setMessage(var11.toString());
      return new TokenResponseException(var4, var2);
   }

   public final TokenErrorResponse getDetails() {
      return this.details;
   }
}
