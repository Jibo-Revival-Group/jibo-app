package com.amazonaws.auth;

import com.amazonaws.AmazonClientException;
import com.amazonaws.Request;
import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.TimeZone;
import java.util.TreeMap;
import java.util.Map.Entry;

public class QueryStringSigner extends AbstractAWSSigner implements Signer {
   private Date overriddenDate;

   private String calculateStringToSignV1(Map<String, String> var1) {
      StringBuilder var2 = new StringBuilder();
      TreeMap var3 = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
      var3.putAll(var1);

      for (Entry var4 : var3.entrySet()) {
         var2.append((String)var4.getKey());
         var2.append((String)var4.getValue());
      }

      return var2.toString();
   }

   private String calculateStringToSignV2(Request<?> var1) {
      URI var4 = var1.getEndpoint();
      Map var2 = var1.getParameters();
      StringBuilder var3 = new StringBuilder();
      var3.append("POST").append("\n");
      var3.append(this.getCanonicalizedEndpoint(var4)).append("\n");
      var3.append(this.getCanonicalizedResourcePath(var1)).append("\n");
      var3.append(this.getCanonicalizedQueryString(var2));
      return var3.toString();
   }

   private String getCanonicalizedResourcePath(Request<?> var1) {
      String var2 = "";
      if (var1.getEndpoint().getPath() != null) {
         var2 = "" + var1.getEndpoint().getPath();
      }

      String var4;
      if (var1.getResourcePath() != null) {
         String var3 = var2;
         if (var2.length() > 0) {
            var3 = var2;
            if (!var2.endsWith("/")) {
               var3 = var2;
               if (!var1.getResourcePath().startsWith("/")) {
                  var3 = var2 + "/";
               }
            }
         }

         var4 = var3 + var1.getResourcePath();
      } else {
         var4 = var2;
         if (!var2.endsWith("/")) {
            var4 = var2 + "/";
         }
      }

      var2 = var4;
      if (!var4.startsWith("/")) {
         var2 = "/" + var4;
      }

      String var5 = var2;
      if (var2.startsWith("//")) {
         var5 = var2.substring(1);
      }

      return var5;
   }

   private String getFormattedTimestamp(int var1) {
      SimpleDateFormat var2 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
      var2.setTimeZone(TimeZone.getTimeZone("UTC"));
      String var3;
      if (this.overriddenDate != null) {
         var3 = var2.format(this.overriddenDate);
      } else {
         var3 = var2.format(this.getSignatureDate(var1));
      }

      return var3;
   }

   @Override
   protected void addSessionCredentials(Request<?> var1, AWSSessionCredentials var2) {
      var1.addParameter("SecurityToken", var2.getSessionToken());
   }

   @Override
   public void sign(Request<?> var1, AWSCredentials var2) {
      this.sign(var1, SignatureVersion.V2, SigningAlgorithm.HmacSHA256, var2);
   }

   public void sign(Request<?> var1, SignatureVersion var2, SigningAlgorithm var3, AWSCredentials var4) {
      if (!(var4 instanceof AnonymousAWSCredentials)) {
         var4 = this.sanitizeCredentials(var4);
         var1.addParameter("AWSAccessKeyId", var4.getAWSAccessKeyId());
         var1.addParameter("SignatureVersion", var2.toString());
         var1.addParameter("Timestamp", this.getFormattedTimestamp(this.getTimeOffset(var1)));
         if (var4 instanceof AWSSessionCredentials) {
            this.addSessionCredentials(var1, (AWSSessionCredentials)var4);
         }

         String var5;
         if (var2.equals(SignatureVersion.V1)) {
            var5 = this.calculateStringToSignV1(var1.getParameters());
         } else {
            if (!var2.equals(SignatureVersion.V2)) {
               throw new AmazonClientException("Invalid Signature Version specified");
            }

            var1.addParameter("SignatureMethod", var3.toString());
            var5 = this.calculateStringToSignV2(var1);
         }

         var1.addParameter("Signature", this.signAndBase64Encode(var5, var4.getAWSSecretKey(), var3));
      }
   }
}
