package com.amazonaws.auth;

import com.amazonaws.AmazonClientException;
import com.amazonaws.Request;
import com.amazonaws.util.AwsHostNameUtils;
import com.amazonaws.util.BinaryUtils;
import com.amazonaws.util.DateUtils;
import com.amazonaws.util.HttpUtils;
import com.jibo.aws.integration.util.a;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

public class AWS4Signer extends AbstractAWSSigner implements RegionAwareSigner, ServiceAwareSigner {
   public static final String TAG = a.a(AWS4Signer.class);
   protected boolean doubleUrlEncode;
   protected Date overriddenDate;
   protected String regionName;
   protected String serviceName;

   public AWS4Signer() {
      this(true);
   }

   public AWS4Signer(boolean var1) {
      this.doubleUrlEncode = var1;
   }

   protected void addHostHeader(Request<?> var1) {
      String var3 = var1.getEndpoint().getHost();
      String var2 = var3;
      if (HttpUtils.isUsingNonDefaultPort(var1.getEndpoint())) {
         var2 = var3 + ":" + var1.getEndpoint().getPort();
      }

      var1.addHeader("Host", var2);
   }

   @Override
   protected void addSessionCredentials(Request<?> var1, AWSSessionCredentials var2) {
      var1.addHeader("x-amz-security-token", var2.getSessionToken());
   }

   protected String calculateContentHash(Request<?> var1) {
      String var4;
      if (var1.getHeaders().get("Content-Type") != null && var1.getHeaders().get("Content-Type").startsWith("multipart")) {
         var4 = "UNSIGNED-PAYLOAD";
      } else if (var1.getHeaders().get("x-path") == null && var1.getHeaders().get("x-key") == null && var1.getContent().markSupported()) {
         InputStream var2 = this.getBinaryRequestPayloadStream(var1);
         var2.mark(-1);
         var4 = BinaryUtils.toHex(this.hash(var2));

         try {
            var2.reset();
         } catch (IOException var3) {
            throw new AmazonClientException("Unable to reset stream after calculating AWS4 signature", var3);
         }
      } else {
         var4 = "STREAMING-AWS4-HMAC-SHA256-PAYLOAD";
      }

      return var4;
   }

   protected final AWS4Signer.HeaderSigningResult computeSignature(Request<?> var1, String var2, String var3, String var4, String var5, AWSCredentials var6) {
      String var9 = this.extractRegionName(var1.getEndpoint());
      String var8 = this.extractServiceName(var1.getEndpoint());
      String var7 = var2 + "/" + var9 + "/" + var8 + "/" + "aws4_request";
      String var10 = this.getStringToSign(var4, var3, var7, this.getCanonicalRequest(var1, var5));
      byte[] var11 = this.sign(
         "aws4_request",
         this.sign(
            var8,
            this.sign(var9, this.sign(var2, ("AWS4" + var6.getAWSSecretKey()).getBytes(), SigningAlgorithm.HmacSHA256), SigningAlgorithm.HmacSHA256),
            SigningAlgorithm.HmacSHA256
         ),
         SigningAlgorithm.HmacSHA256
      );
      return new AWS4Signer.HeaderSigningResult(var3, var7, var11, this.sign(var10.getBytes(), var11, SigningAlgorithm.HmacSHA256));
   }

   protected String extractRegionName(URI var1) {
      String var2;
      if (this.regionName != null) {
         var2 = this.regionName;
      } else {
         var2 = AwsHostNameUtils.parseRegionName(var1.getHost(), this.serviceName);
      }

      return var2;
   }

   protected String extractServiceName(URI var1) {
      String var2;
      if (this.serviceName != null) {
         var2 = this.serviceName;
      } else {
         var2 = AwsHostNameUtils.parseServiceName(var1);
      }

      return var2;
   }

   protected String getCanonicalRequest(Request<?> var1, String var2) {
      String var3 = HttpUtils.appendUri(var1.getEndpoint().getPath(), var1.getResourcePath());
      String var4 = var1.getHttpMethod().toString()
         + "\n"
         + this.getCanonicalizedResourcePath(var3, this.doubleUrlEncode)
         + "\n"
         + this.getCanonicalizedQueryString(var1)
         + "\n"
         + this.getCanonicalizedHeaderString(var1)
         + "\n"
         + this.getSignedHeadersString(var1)
         + "\n"
         + var2;
      a.a(TAG, "AWS4 Canonical Request: '\"" + var4 + "\"");
      return var4;
   }

   protected String getCanonicalizedHeaderString(Request<?> var1) {
      ArrayList var3 = new ArrayList();
      var3.addAll(var1.getHeaders().keySet());
      Collections.sort(var3, String.CASE_INSENSITIVE_ORDER);
      StringBuilder var2 = new StringBuilder();

      for (String var5 : var3) {
         if (this.needsSign(var5)) {
            String var6 = var5.toLowerCase().replaceAll("\\s+", " ");
            var5 = var1.getHeaders().get(var5);
            var2.append(var6).append(":");
            if (var5 != null) {
               var2.append(var5.replaceAll("\\s+", " "));
            }

            var2.append("\n");
         }
      }

      return var2.toString();
   }

   protected final long getDateFromRequest(Request<?> var1) {
      Date var2 = this.getSignatureDate(this.getTimeOffset(var1));
      if (this.overriddenDate != null) {
         var2 = this.overriddenDate;
      }

      return var2.getTime();
   }

   protected final String getDateStamp(long var1) {
      return DateUtils.format("yyyyMMdd", new Date(var1));
   }

   protected String getScope(Request<?> var1, String var2) {
      String var3 = this.extractRegionName(var1.getEndpoint());
      String var4 = this.extractServiceName(var1.getEndpoint());
      return var2 + "/" + var3 + "/" + var4 + "/" + "aws4_request";
   }

   protected String getSignedHeadersString(Request<?> var1) {
      ArrayList var2 = new ArrayList();
      var2.addAll(var1.getHeaders().keySet());
      Collections.sort(var2, String.CASE_INSENSITIVE_ORDER);
      StringBuilder var4 = new StringBuilder();

      for (String var5 : var2) {
         if (this.needsSign(var5)) {
            if (var4.length() > 0) {
               var4.append(";");
            }

            var4.append(var5.toLowerCase());
         }
      }

      return var4.toString();
   }

   protected String getStringToSign(String var1, String var2, String var3, String var4) {
      var1 = var1 + "\n" + var2 + "\n" + var3 + "\n" + BinaryUtils.toHex(this.hash(var4));
      a.a(TAG, "AWS4 String to Sign: '\"" + var1 + "\"");
      return var1;
   }

   protected final String getTimeStamp(long var1) {
      return DateUtils.format("yyyyMMdd'T'HHmmss'Z'", new Date(var1));
   }

   boolean needsSign(String var1) {
      boolean var2;
      if (!var1.equalsIgnoreCase("date")
         && !var1.equalsIgnoreCase("Content-MD5")
         && !var1.equalsIgnoreCase("host")
         && !var1.startsWith("x-amz")
         && !var1.startsWith("X-Amz")) {
         var2 = false;
      } else {
         var2 = true;
      }

      return var2;
   }

   protected void processRequestPayload(Request<?> var1, AWS4Signer.HeaderSigningResult var2) {
   }

   @Override
   public void setRegionName(String var1) {
      this.regionName = var1;
   }

   @Override
   public void setServiceName(String var1) {
      this.serviceName = var1;
   }

   @Override
   public void sign(Request<?> var1, AWSCredentials var2) {
      if (!(var2 instanceof AnonymousAWSCredentials)) {
         AWSCredentials var5 = this.sanitizeCredentials(var2);
         if (var5 instanceof AWSSessionCredentials) {
            this.addSessionCredentials(var1, (AWSSessionCredentials)var5);
         }

         this.addHostHeader(var1);
         long var3 = this.getDateFromRequest(var1);
         String var8 = this.getDateStamp(var3);
         String var7 = this.getScope(var1, var8);
         String var6 = this.calculateContentHash(var1);
         String var9 = this.getTimeStamp(var3);
         var1.addHeader("X-Amz-Date", var9);
         if (var1.getHeaders().get("x-amz-content-sha256") != null && var1.getHeaders().get("x-amz-content-sha256").equals("required")) {
            var1.addHeader("x-amz-content-sha256", var6);
         }

         var7 = var5.getAWSAccessKeyId() + "/" + var7;
         AWS4Signer.HeaderSigningResult var10 = this.computeSignature(var1, var8, var9, "AWS4-HMAC-SHA256", var6, var5);
         var6 = "Credential=" + var7;
         String var11 = "SignedHeaders=" + this.getSignedHeadersString(var1);
         var7 = "Signature=" + BinaryUtils.toHex(var10.getSignature());
         var1.addHeader("Authorization", "AWS4-HMAC-SHA256 " + var6 + ", " + var11 + ", " + var7);
         this.processRequestPayload(var1, var10);
      }
   }

   protected static class HeaderSigningResult {
      private String dateTime;
      private byte[] kSigning;
      private String scope;
      private byte[] signature;

      public HeaderSigningResult(String var1, String var2, byte[] var3, byte[] var4) {
         this.dateTime = var1;
         this.scope = var2;
         this.kSigning = var3;
         this.signature = var4;
      }

      public byte[] getSignature() {
         byte[] var1 = new byte[this.signature.length];
         System.arraycopy(this.signature, 0, var1, 0, this.signature.length);
         return var1;
      }
   }
}
