package com.amazonaws.auth;

import com.amazonaws.AmazonClientException;
import com.amazonaws.Request;
import com.amazonaws.SDKGlobalConfiguration;
import com.amazonaws.internal.SdkDigestInputStream;
import com.amazonaws.util.Base64;
import com.amazonaws.util.HttpUtils;
import com.amazonaws.util.StringInputStream;
import com.amazonaws.util.StringUtils;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.URI;
import java.security.MessageDigest;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public abstract class AbstractAWSSigner implements Signer {
   protected abstract void addSessionCredentials(Request<?> var1, AWSSessionCredentials var2);

   protected InputStream getBinaryRequestPayloadStream(Request<?> var1) {
      InputStream var3;
      if (HttpUtils.usePayloadForQueryParameters(var1)) {
         String var2 = HttpUtils.encodeParameters(var1);
         if (var2 == null) {
            var3 = new ByteArrayInputStream(new byte[0]);
         } else {
            var3 = new ByteArrayInputStream(var2.getBytes(StringUtils.UTF8));
         }
      } else {
         var3 = this.getBinaryRequestPayloadStreamWithoutQueryParams(var1);
      }

      return var3;
   }

   // $VF: Handled exception range with multiple entry points by splitting it
   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   protected InputStream getBinaryRequestPayloadStreamWithoutQueryParams(Request<?> var1) {
      InputStream var3;
      try {
         var3 = var1.getContent();
      } catch (Exception var7) {
         throw new AmazonClientException("Unable to read request payload to sign request: " + var7.getMessage(), var7);
      }

      InputStream var2;
      if (var3 == null) {
         try {
            var2 = new ByteArrayInputStream(new byte[0]);
         } catch (Exception var6) {
            throw new AmazonClientException("Unable to read request payload to sign request: " + var6.getMessage(), var6);
         }
      } else {
         label46: {
            var2 = var3;

            try {
               if (var3 instanceof StringInputStream) {
                  break label46;
               }

               if (!var3.markSupported()) {
                  AmazonClientException var9 = new AmazonClientException("Unable to read request payload to sign request.");
                  throw var9;
               }
            } catch (Exception var8) {
               throw new AmazonClientException("Unable to read request payload to sign request: " + var8.getMessage(), var8);
            }

            try {
               var2 = var1.getContent();
            } catch (Exception var5) {
               throw new AmazonClientException("Unable to read request payload to sign request: " + var5.getMessage(), var5);
            }
         }
      }

      try {
         return var2;
      } catch (Exception var4) {
         throw new AmazonClientException("Unable to read request payload to sign request: " + var4.getMessage(), var4);
      }
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   protected byte[] getBinaryRequestPayloadWithoutQueryParams(Request<?> var1) {
      InputStream var9 = this.getBinaryRequestPayloadStreamWithoutQueryParams(var1);

      byte[] var3;
      ByteArrayOutputStream var4;
      try {
         var9.mark(-1);
         var4 = new ByteArrayOutputStream();
         var3 = new byte[5120];
      } catch (Exception var8) {
         throw new AmazonClientException("Unable to read request payload to sign request: " + var8.getMessage(), var8);
      }

      while (true) {
         int var2;
         try {
            var2 = var9.read(var3);
         } catch (Exception var6) {
            throw new AmazonClientException("Unable to read request payload to sign request: " + var6.getMessage(), var6);
         }

         if (var2 == -1) {
            try {
               var4.close();
               var9.reset();
               return var4.toByteArray();
            } catch (Exception var5) {
               throw new AmazonClientException("Unable to read request payload to sign request: " + var5.getMessage(), var5);
            }
         }

         try {
            var4.write(var3, 0, var2);
         } catch (Exception var7) {
            throw new AmazonClientException("Unable to read request payload to sign request: " + var7.getMessage(), var7);
         }
      }
   }

   protected String getCanonicalizedEndpoint(URI var1) {
      String var3 = var1.getHost().toLowerCase();
      String var2 = var3;
      if (HttpUtils.isUsingNonDefaultPort(var1)) {
         var2 = var3 + ":" + var1.getPort();
      }

      return var2;
   }

   protected String getCanonicalizedQueryString(Request<?> var1) {
      String var2;
      if (HttpUtils.usePayloadForQueryParameters(var1)) {
         var2 = "";
      } else {
         var2 = this.getCanonicalizedQueryString(var1.getParameters());
      }

      return var2;
   }

   protected String getCanonicalizedQueryString(Map<String, String> var1) {
      TreeMap var2 = new TreeMap();

      for (Entry var4 : var1.entrySet()) {
         String var3 = (String)var4.getKey();
         String var9 = (String)var4.getValue();
         var2.put(HttpUtils.urlEncode(var3, false), HttpUtils.urlEncode(var9, false));
      }

      StringBuilder var6 = new StringBuilder();
      Iterator var8 = var2.entrySet().iterator();

      while (var8.hasNext()) {
         Entry var7 = (Entry)var8.next();
         var6.append((String)var7.getKey());
         var6.append("=");
         var6.append((String)var7.getValue());
         if (var8.hasNext()) {
            var6.append("&");
         }
      }

      return var6.toString();
   }

   protected String getCanonicalizedResourcePath(String var1) {
      return this.getCanonicalizedResourcePath(var1, true);
   }

   protected String getCanonicalizedResourcePath(String var1, boolean var2) {
      if (var1 != null && var1.length() != 0) {
         String var3 = var1;
         if (var2) {
            var3 = HttpUtils.urlEncode(var1, true);
         }

         var1 = var3;
         if (!var3.startsWith("/")) {
            var1 = "/".concat(var3);
         }
      } else {
         var1 = "/";
      }

      return var1;
   }

   protected String getRequestPayloadWithoutQueryParams(Request<?> var1) {
      return this.newString(this.getBinaryRequestPayloadWithoutQueryParams(var1));
   }

   protected Date getSignatureDate(int var1) {
      Date var3 = new Date();
      Date var2 = var3;
      if (var1 != 0) {
         var2 = new Date(var3.getTime() - var1 * 1000);
      }

      return var2;
   }

   protected int getTimeOffset(Request<?> var1) {
      int var2 = var1.getTimeOffset();
      if (SDKGlobalConfiguration.getGlobalTimeOffset() != 0) {
         var2 = SDKGlobalConfiguration.getGlobalTimeOffset();
      }

      return var2;
   }

   protected byte[] hash(InputStream var1) {
      try {
         MessageDigest var3 = MessageDigest.getInstance("SHA-256");
         SdkDigestInputStream var2 = new SdkDigestInputStream(var1, var3);
         byte[] var5 = new byte[1024];

         while (var2.read(var5) > -1) {
         }

         return var2.getMessageDigest().digest();
      } catch (Exception var4) {
         throw new AmazonClientException("Unable to compute hash while signing request: " + var4.getMessage(), var4);
      }
   }

   public byte[] hash(String var1) {
      try {
         MessageDigest var2 = MessageDigest.getInstance("SHA-256");
         var2.update(var1.getBytes(StringUtils.UTF8));
         return var2.digest();
      } catch (Exception var3) {
         throw new AmazonClientException("Unable to compute hash while signing request: " + var3.getMessage(), var3);
      }
   }

   protected String newString(byte[] var1) {
      return new String(var1, StringUtils.UTF8);
   }

   protected AWSCredentials sanitizeCredentials(AWSCredentials param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
      //   at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
      //   at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
      //   at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
      //   at java.base/java.util.Objects.checkIndex(Objects.java:361)
      //   at java.base/java.util.ArrayList.remove(ArrayList.java:504)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.removeExceptionInstructionsEx(FinallyProcessor.java:1058)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.verifyFinallyEx(FinallyProcessor.java:573)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.iterateGraph(FinallyProcessor.java:90)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:185)
      //
      // Bytecode:
      // 00: aconst_null
      // 01: astore 2
      // 02: aload 1
      // 03: monitorenter
      // 04: aload 1
      // 05: invokeinterface com/amazonaws/auth/AWSCredentials.getAWSAccessKeyId ()Ljava/lang/String; 1
      // 0a: astore 4
      // 0c: aload 1
      // 0d: invokeinterface com/amazonaws/auth/AWSCredentials.getAWSSecretKey ()Ljava/lang/String; 1
      // 12: astore 3
      // 13: aload 1
      // 14: instanceof com/amazonaws/auth/AWSSessionCredentials
      // 17: ifeq 24
      // 1a: aload 1
      // 1b: checkcast com/amazonaws/auth/AWSSessionCredentials
      // 1e: invokeinterface com/amazonaws/auth/AWSSessionCredentials.getSessionToken ()Ljava/lang/String; 1
      // 23: astore 2
      // 24: aload 1
      // 25: monitorexit
      // 26: aload 3
      // 27: ifnull 74
      // 2a: aload 3
      // 2b: invokevirtual java/lang/String.trim ()Ljava/lang/String;
      // 2e: astore 3
      // 2f: aload 4
      // 31: ifnull 71
      // 34: aload 4
      // 36: invokevirtual java/lang/String.trim ()Ljava/lang/String;
      // 39: astore 4
      // 3b: aload 2
      // 3c: astore 5
      // 3e: aload 2
      // 3f: ifnull 48
      // 42: aload 2
      // 43: invokevirtual java/lang/String.trim ()Ljava/lang/String;
      // 46: astore 5
      // 48: aload 1
      // 49: instanceof com/amazonaws/auth/AWSSessionCredentials
      // 4c: ifeq 63
      // 4f: new com/amazonaws/auth/BasicSessionCredentials
      // 52: dup
      // 53: aload 4
      // 55: aload 3
      // 56: aload 5
      // 58: invokespecial com/amazonaws/auth/BasicSessionCredentials.<init> (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
      // 5b: astore 1
      // 5c: aload 1
      // 5d: areturn
      // 5e: astore 2
      // 5f: aload 1
      // 60: monitorexit
      // 61: aload 2
      // 62: athrow
      // 63: new com/amazonaws/auth/BasicAWSCredentials
      // 66: dup
      // 67: aload 4
      // 69: aload 3
      // 6a: invokespecial com/amazonaws/auth/BasicAWSCredentials.<init> (Ljava/lang/String;Ljava/lang/String;)V
      // 6d: astore 1
      // 6e: goto 5c
      // 71: goto 3b
      // 74: goto 2f
      // try (4 -> 10): 48 null
      // try (10 -> 17): 48 null
      // try (17 -> 19): 48 null
      // try (49 -> 51): 48 null
   }

   public byte[] sign(String var1, byte[] var2, SigningAlgorithm var3) {
      try {
         return this.sign(var1.getBytes(StringUtils.UTF8), var2, var3);
      } catch (Exception var4) {
         throw new AmazonClientException("Unable to calculate a request signature: " + var4.getMessage(), var4);
      }
   }

   protected byte[] sign(byte[] var1, byte[] var2, SigningAlgorithm var3) {
      try {
         Mac var4 = Mac.getInstance(var3.toString());
         SecretKeySpec var5 = new SecretKeySpec(var2, var3.toString());
         var4.init(var5);
         return var4.doFinal(var1);
      } catch (Exception var6) {
         throw new AmazonClientException("Unable to calculate a request signature: " + var6.getMessage(), var6);
      }
   }

   protected String signAndBase64Encode(String var1, String var2, SigningAlgorithm var3) {
      return this.signAndBase64Encode(var1.getBytes(StringUtils.UTF8), var2, var3);
   }

   protected String signAndBase64Encode(byte[] var1, String var2, SigningAlgorithm var3) {
      try {
         return Base64.encodeAsString(this.sign(var1, var2.getBytes(StringUtils.UTF8), var3));
      } catch (Exception var4) {
         throw new AmazonClientException("Unable to calculate a request signature: " + var4.getMessage(), var4);
      }
   }
}
