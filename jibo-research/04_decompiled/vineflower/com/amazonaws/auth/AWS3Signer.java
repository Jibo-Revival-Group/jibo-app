package com.amazonaws.auth;

import com.amazonaws.Request;
import com.amazonaws.util.DateUtils;
import com.amazonaws.util.HttpUtils;
import com.jibo.aws.integration.util.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.TreeMap;
import java.util.UUID;
import java.util.Map.Entry;

public class AWS3Signer extends AbstractAWSSigner {
   public static final String TAG = a.a(AWS3Signer.class);
   private String overriddenDate;

   private String getSignedHeadersComponent(Request<?> var1) {
      StringBuilder var3 = new StringBuilder();
      var3.append("SignedHeaders=");
      Iterator var5 = this.getHeadersForStringToSign(var1).iterator();

      for (boolean var2 = true; var5.hasNext(); var2 = false) {
         String var4 = (String)var5.next();
         if (!var2) {
            var3.append(";");
         }

         var3.append(var4);
      }

      return var3.toString();
   }

   @Override
   protected void addSessionCredentials(Request<?> var1, AWSSessionCredentials var2) {
      var1.addHeader("x-amz-security-token", var2.getSessionToken());
   }

   protected String getCanonicalizedHeadersForStringToSign(Request<?> var1) {
      List var4 = this.getHeadersForStringToSign(var1);

      for (int var2 = 0; var2 < var4.size(); var2++) {
         var4.set(var2, ((String)var4.get(var2)).toLowerCase());
      }

      TreeMap var3 = new TreeMap();

      for (Entry var6 : var1.getHeaders().entrySet()) {
         if (var4.contains(((String)var6.getKey()).toLowerCase())) {
            var3.put(((String)var6.getKey()).toLowerCase(), var6.getValue());
         }
      }

      StringBuilder var7 = new StringBuilder();

      for (Entry var9 : var3.entrySet()) {
         var7.append(((String)var9.getKey()).toLowerCase()).append(":").append((String)var9.getValue()).append("\n");
      }

      return var7.toString();
   }

   protected List<String> getHeadersForStringToSign(Request<?> var1) {
      ArrayList var2 = new ArrayList();
      Iterator var4 = var1.getHeaders().entrySet().iterator();

      while (var4.hasNext()) {
         String var5 = (String)((Entry)var4.next()).getKey();
         String var3 = var5.toLowerCase();
         if (var3.startsWith("x-amz") || var3.equals("host")) {
            var2.add(var5);
         }
      }

      Collections.sort(var2);
      return var2;
   }

   @Override
   public void sign(Request<?> var1, AWSCredentials var2) {
      if (!(var2 instanceof AnonymousAWSCredentials)) {
         AWSCredentials var4 = this.sanitizeCredentials(var2);
         SigningAlgorithm var5 = SigningAlgorithm.HmacSHA256;
         UUID.randomUUID().toString();
         String var6 = DateUtils.formatRFC822Date(this.getSignatureDate(this.getTimeOffset(var1)));
         if (this.overriddenDate != null) {
            var6 = this.overriddenDate;
         }

         var1.addHeader("Date", var6);
         var1.addHeader("X-Amz-Date", var6);
         String var3 = var1.getEndpoint().getHost();
         String var7 = var3;
         if (HttpUtils.isUsingNonDefaultPort(var1.getEndpoint())) {
            var7 = var3 + ":" + var1.getEndpoint().getPort();
         }

         var1.addHeader("Host", var7);
         if (var4 instanceof AWSSessionCredentials) {
            this.addSessionCredentials(var1, (AWSSessionCredentials)var4);
         }

         String var8 = HttpUtils.appendUri(var1.getEndpoint().getPath(), var1.getResourcePath());
         var3 = var1.getHttpMethod().toString()
            + "\n"
            + this.getCanonicalizedResourcePath(var8)
            + "\n"
            + this.getCanonicalizedQueryString(var1.getParameters())
            + "\n"
            + this.getCanonicalizedHeadersForStringToSign(var1)
            + "\n"
            + this.getRequestPayloadWithoutQueryParams(var1);
         byte[] var9 = this.hash(var3);
         a.a(TAG, "Calculated StringToSign: " + var3);
         String var10 = this.signAndBase64Encode(var9, var4.getAWSSecretKey(), var5);
         StringBuilder var12 = new StringBuilder();
         var12.append("AWS3").append(" ");
         var12.append("AWSAccessKeyId=" + var4.getAWSAccessKeyId() + ",");
         var12.append("Algorithm=" + var5.toString() + ",");
         var12.append(this.getSignedHeadersComponent(var1) + ",");
         var12.append("Signature=" + var10);
         var1.addHeader("X-Amzn-Authorization", var12.toString());
      }
   }
}
