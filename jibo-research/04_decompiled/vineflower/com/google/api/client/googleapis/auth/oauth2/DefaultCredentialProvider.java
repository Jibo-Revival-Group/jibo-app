package com.google.api.client.googleapis.auth.oauth2;

import com.google.api.client.auth.oauth2.TokenResponse;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.JsonObjectParser;
import com.google.api.client.util.Beta;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.security.AccessControlException;
import java.util.Locale;

@Beta
class DefaultCredentialProvider extends SystemEnvironmentProvider {
   static final String APP_ENGINE_CREDENTIAL_CLASS = "com.google.api.client.googleapis.extensions.appengine.auth.oauth2.AppIdentityCredential$AppEngineCredentialWrapper";
   static final String CLOUDSDK_CONFIG_DIRECTORY = "gcloud";
   static final String CLOUD_SHELL_ENV_VAR = "DEVSHELL_CLIENT_PORT";
   static final String CREDENTIAL_ENV_VAR = "GOOGLE_APPLICATION_CREDENTIALS";
   static final String HELP_PERMALINK = "https://developers.google.com/accounts/docs/application-default-credentials";
   static final String WELL_KNOWN_CREDENTIALS_FILE = "application_default_credentials.json";
   private GoogleCredential cachedCredential = null;
   private DefaultCredentialProvider.Environment detectedEnvironment = null;

   private final DefaultCredentialProvider.Environment detectEnvironment(HttpTransport var1) throws IOException {
      DefaultCredentialProvider.Environment var2;
      if (this.runningUsingEnvironmentVariable()) {
         var2 = DefaultCredentialProvider.Environment.ENVIRONMENT_VARIABLE;
      } else if (this.runningUsingWellKnownFile()) {
         var2 = DefaultCredentialProvider.Environment.WELL_KNOWN_FILE;
      } else if (this.runningOnAppEngine()) {
         var2 = DefaultCredentialProvider.Environment.APP_ENGINE;
      } else if (this.runningOnCloudShell()) {
         var2 = DefaultCredentialProvider.Environment.CLOUD_SHELL;
      } else if (OAuth2Utils.runningOnComputeEngine(var1, this)) {
         var2 = DefaultCredentialProvider.Environment.COMPUTE_ENGINE;
      } else {
         var2 = DefaultCredentialProvider.Environment.UNKNOWN;
      }

      return var2;
   }

   private final GoogleCredential getAppEngineCredential(HttpTransport var1, JsonFactory var2) throws IOException {
      try {
         return (GoogleCredential)this.forName(
               "com.google.api.client.googleapis.extensions.appengine.auth.oauth2.AppIdentityCredential$AppEngineCredentialWrapper"
            )
            .getConstructor(HttpTransport.class, JsonFactory.class)
            .newInstance(var1, var2);
      } catch (ClassNotFoundException var3) {
         var8 = var3;
      } catch (NoSuchMethodException var4) {
         var8 = var4;
      } catch (InstantiationException var5) {
         var8 = var5;
      } catch (IllegalAccessException var6) {
         var8 = var6;
      } catch (InvocationTargetException var7) {
         var8 = var7;
      }

      throw (IOException)OAuth2Utils.exceptionWithCause(
         new IOException(
            String.format(
               "Application Default Credentials failed to create the Google App Engine service account credentials class %s. Check that the component 'google-api-client-appengine' is deployed.",
               "com.google.api.client.googleapis.extensions.appengine.auth.oauth2.AppIdentityCredential$AppEngineCredentialWrapper"
            )
         ),
         var8
      );
   }

   private GoogleCredential getCloudShellCredential(JsonFactory var1) {
      return new CloudShellCredential(Integer.parseInt(this.getEnv("DEVSHELL_CLIENT_PORT")), var1);
   }

   private final GoogleCredential getComputeCredential(HttpTransport var1, JsonFactory var2) {
      return new DefaultCredentialProvider.ComputeGoogleCredential(var1, var2);
   }

   private GoogleCredential getCredentialUsingEnvironmentVariable(HttpTransport param1, JsonFactory param2) throws IOException {
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
      // 00: aload 0
      // 01: ldc "GOOGLE_APPLICATION_CREDENTIALS"
      // 03: invokevirtual com/google/api/client/googleapis/auth/oauth2/DefaultCredentialProvider.getEnv (Ljava/lang/String;)Ljava/lang/String;
      // 06: astore 5
      // 08: new java/io/FileInputStream
      // 0b: astore 4
      // 0d: aload 4
      // 0f: aload 5
      // 11: invokespecial java/io/FileInputStream.<init> (Ljava/lang/String;)V
      // 14: aload 4
      // 16: astore 3
      // 17: aload 4
      // 19: aload 1
      // 1a: aload 2
      // 1b: invokestatic com/google/api/client/googleapis/auth/oauth2/GoogleCredential.fromStream (Ljava/io/InputStream;Lcom/google/api/client/http/HttpTransport;Lcom/google/api/client/json/JsonFactory;)Lcom/google/api/client/googleapis/auth/oauth2/GoogleCredential;
      // 1e: astore 1
      // 1f: aload 4
      // 21: ifnull 29
      // 24: aload 4
      // 26: invokevirtual java/io/InputStream.close ()V
      // 29: aload 1
      // 2a: areturn
      // 2b: astore 2
      // 2c: aconst_null
      // 2d: astore 1
      // 2e: aload 1
      // 2f: astore 3
      // 30: new java/io/IOException
      // 33: astore 4
      // 35: aload 1
      // 36: astore 3
      // 37: aload 4
      // 39: ldc "Error reading credential file from environment variable %s, value '%s': %s"
      // 3b: bipush 3
      // 3c: anewarray 115
      // 3f: dup
      // 40: bipush 0
      // 41: ldc "GOOGLE_APPLICATION_CREDENTIALS"
      // 43: aastore
      // 44: dup
      // 45: bipush 1
      // 46: aload 5
      // 48: aastore
      // 49: dup
      // 4a: bipush 2
      // 4b: aload 2
      // 4c: invokevirtual java/io/IOException.getMessage ()Ljava/lang/String;
      // 4f: aastore
      // 50: invokestatic java/lang/String.format (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
      // 53: invokespecial java/io/IOException.<init> (Ljava/lang/String;)V
      // 56: aload 1
      // 57: astore 3
      // 58: aload 4
      // 5a: aload 2
      // 5b: invokestatic com/google/api/client/googleapis/auth/oauth2/OAuth2Utils.exceptionWithCause (Ljava/lang/Throwable;Ljava/lang/Throwable;)Ljava/lang/Throwable;
      // 5e: checkcast java/io/IOException
      // 61: athrow
      // 62: astore 1
      // 63: aload 3
      // 64: ifnull 6b
      // 67: aload 3
      // 68: invokevirtual java/io/InputStream.close ()V
      // 6b: aload 1
      // 6c: athrow
      // 6d: astore 1
      // 6e: aconst_null
      // 6f: astore 3
      // 70: goto 63
      // 73: astore 2
      // 74: aload 4
      // 76: astore 1
      // 77: goto 2e
      // try (4 -> 9): 22 java/io/IOException
      // try (4 -> 9): 64 null
      // try (11 -> 16): 68 java/io/IOException
      // try (11 -> 16): 57 null
      // try (27 -> 29): 57 null
      // try (31 -> 50): 57 null
      // try (52 -> 57): 57 null
   }

   private GoogleCredential getCredentialUsingWellKnownFile(HttpTransport param1, JsonFactory param2) throws IOException {
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
      // 00: aload 0
      // 01: invokespecial com/google/api/client/googleapis/auth/oauth2/DefaultCredentialProvider.getWellKnownCredentialsFile ()Ljava/io/File;
      // 04: astore 5
      // 06: new java/io/FileInputStream
      // 09: astore 4
      // 0b: aload 4
      // 0d: aload 5
      // 0f: invokespecial java/io/FileInputStream.<init> (Ljava/io/File;)V
      // 12: aload 4
      // 14: astore 3
      // 15: aload 4
      // 17: aload 1
      // 18: aload 2
      // 19: invokestatic com/google/api/client/googleapis/auth/oauth2/GoogleCredential.fromStream (Ljava/io/InputStream;Lcom/google/api/client/http/HttpTransport;Lcom/google/api/client/json/JsonFactory;)Lcom/google/api/client/googleapis/auth/oauth2/GoogleCredential;
      // 1c: astore 1
      // 1d: aload 4
      // 1f: ifnull 27
      // 22: aload 4
      // 24: invokevirtual java/io/InputStream.close ()V
      // 27: aload 1
      // 28: areturn
      // 29: astore 2
      // 2a: aconst_null
      // 2b: astore 1
      // 2c: aload 1
      // 2d: astore 3
      // 2e: new java/io/IOException
      // 31: astore 4
      // 33: aload 1
      // 34: astore 3
      // 35: aload 4
      // 37: ldc "Error reading credential file from location %s: %s"
      // 39: bipush 2
      // 3a: anewarray 115
      // 3d: dup
      // 3e: bipush 0
      // 3f: aload 5
      // 41: aastore
      // 42: dup
      // 43: bipush 1
      // 44: aload 2
      // 45: invokevirtual java/io/IOException.getMessage ()Ljava/lang/String;
      // 48: aastore
      // 49: invokestatic java/lang/String.format (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
      // 4c: invokespecial java/io/IOException.<init> (Ljava/lang/String;)V
      // 4f: aload 1
      // 50: astore 3
      // 51: aload 4
      // 53: athrow
      // 54: astore 1
      // 55: aload 3
      // 56: ifnull 5d
      // 59: aload 3
      // 5a: invokevirtual java/io/InputStream.close ()V
      // 5d: aload 1
      // 5e: athrow
      // 5f: astore 1
      // 60: aconst_null
      // 61: astore 3
      // 62: goto 55
      // 65: astore 2
      // 66: aload 4
      // 68: astore 1
      // 69: goto 2c
      // try (3 -> 8): 21 java/io/IOException
      // try (3 -> 8): 56 null
      // try (10 -> 15): 60 java/io/IOException
      // try (10 -> 15): 49 null
      // try (26 -> 28): 49 null
      // try (30 -> 45): 49 null
      // try (47 -> 49): 49 null
   }

   private final GoogleCredential getDefaultCredentialUnsynchronized(HttpTransport var1, JsonFactory var2) throws IOException {
      if (this.detectedEnvironment == null) {
         this.detectedEnvironment = this.detectEnvironment(var1);
      }

      GoogleCredential var3;
      switch (<unrepresentable>.$SwitchMap$com$google$api$client$googleapis$auth$oauth2$DefaultCredentialProvider$Environment[this.detectedEnvironment
         .ordinal()]) {
         case 1:
            var3 = this.getCredentialUsingEnvironmentVariable(var1, var2);
            break;
         case 2:
            var3 = this.getCredentialUsingWellKnownFile(var1, var2);
            break;
         case 3:
            var3 = this.getAppEngineCredential(var1, var2);
            break;
         case 4:
            var3 = this.getCloudShellCredential(var2);
            break;
         case 5:
            var3 = this.getComputeCredential(var1, var2);
            break;
         default:
            var3 = null;
      }

      return var3;
   }

   private final File getWellKnownCredentialsFile() {
      File var1;
      if (this.getProperty("os.name", "").toLowerCase(Locale.US).indexOf("windows") >= 0) {
         var1 = new File(new File(this.getEnv("APPDATA")), "gcloud");
      } else {
         var1 = new File(new File(this.getProperty("user.home", ""), ".config"), "gcloud");
      }

      return new File(var1, "application_default_credentials.json");
   }

   private boolean runningOnAppEngine() {
      boolean var1 = true;

      Class var2;
      try {
         var2 = this.forName("com.google.appengine.api.utils.SystemProperty");
      } catch (ClassNotFoundException var4) {
         var1 = false;
         return var1;
      }

      label31: {
         try {
            Field var12 = var2.getField("environment");
            Object var3 = var12.get(null);
            var13 = var12.getType().getMethod("value").invoke(var3);
            break label31;
         } catch (NoSuchFieldException var5) {
            var11 = var5;
         } catch (SecurityException var6) {
            var11 = var6;
         } catch (IllegalArgumentException var7) {
            var11 = var7;
         } catch (IllegalAccessException var8) {
            var11 = var8;
         } catch (NoSuchMethodException var9) {
            var11 = var9;
         } catch (InvocationTargetException var10) {
            var11 = var10;
         }

         throw (RuntimeException)OAuth2Utils.exceptionWithCause(
            new RuntimeException(String.format("Unexpcted error trying to determine if runnning on Google App Engine: %s", var11.getMessage())), var11
         );
      }

      if (var13 == null) {
         var1 = false;
      }

      return var1;
   }

   private boolean runningOnCloudShell() {
      boolean var1;
      if (this.getEnv("DEVSHELL_CLIENT_PORT") != null) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   private boolean runningUsingEnvironmentVariable() throws IOException {
      boolean var1 = true;
      String var2 = this.getEnv("GOOGLE_APPLICATION_CREDENTIALS");
      if (var2 != null && var2.length() != 0) {
         try {
            File var3 = new File(var2);
            if (!var3.exists() || var3.isDirectory()) {
               IOException var5 = new IOException(
                  String.format(
                     "Error reading credential file from environment variable %s, value '%s': File does not exist.", "GOOGLE_APPLICATION_CREDENTIALS", var2
                  )
               );
               throw var5;
            }
         } catch (AccessControlException var4) {
            var1 = false;
         }
      } else {
         var1 = false;
      }

      return var1;
   }

   private boolean runningUsingWellKnownFile() {
      File var2 = this.getWellKnownCredentialsFile();

      boolean var1;
      try {
         var1 = this.fileExists(var2);
      } catch (AccessControlException var3) {
         var1 = false;
      }

      return var1;
   }

   boolean fileExists(File var1) {
      boolean var2;
      if (var1.exists() && !var1.isDirectory()) {
         var2 = true;
      } else {
         var2 = false;
      }

      return var2;
   }

   Class<?> forName(String var1) throws ClassNotFoundException {
      return Class.forName(var1);
   }

   final GoogleCredential getDefaultCredential(HttpTransport param1, JsonFactory param2) throws IOException {
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
      // 00: aload 0
      // 01: monitorenter
      // 02: aload 0
      // 03: getfield com/google/api/client/googleapis/auth/oauth2/DefaultCredentialProvider.cachedCredential Lcom/google/api/client/googleapis/auth/oauth2/GoogleCredential;
      // 06: ifnonnull 13
      // 09: aload 0
      // 0a: aload 0
      // 0b: aload 1
      // 0c: aload 2
      // 0d: invokespecial com/google/api/client/googleapis/auth/oauth2/DefaultCredentialProvider.getDefaultCredentialUnsynchronized (Lcom/google/api/client/http/HttpTransport;Lcom/google/api/client/json/JsonFactory;)Lcom/google/api/client/googleapis/auth/oauth2/GoogleCredential;
      // 10: putfield com/google/api/client/googleapis/auth/oauth2/DefaultCredentialProvider.cachedCredential Lcom/google/api/client/googleapis/auth/oauth2/GoogleCredential;
      // 13: aload 0
      // 14: getfield com/google/api/client/googleapis/auth/oauth2/DefaultCredentialProvider.cachedCredential Lcom/google/api/client/googleapis/auth/oauth2/GoogleCredential;
      // 17: ifnull 23
      // 1a: aload 0
      // 1b: getfield com/google/api/client/googleapis/auth/oauth2/DefaultCredentialProvider.cachedCredential Lcom/google/api/client/googleapis/auth/oauth2/GoogleCredential;
      // 1e: astore 1
      // 1f: aload 0
      // 20: monitorexit
      // 21: aload 1
      // 22: areturn
      // 23: aload 0
      // 24: monitorexit
      // 25: new java/io/IOException
      // 28: dup
      // 29: ldc_w "The Application Default Credentials are not available. They are available if running on Google App Engine, Google Compute Engine, or Google Cloud Shell. Otherwise, the environment variable %s must be defined pointing to a file defining the credentials. See %s for more information."
      // 2c: bipush 2
      // 2d: anewarray 115
      // 30: dup
      // 31: bipush 0
      // 32: ldc "GOOGLE_APPLICATION_CREDENTIALS"
      // 34: aastore
      // 35: dup
      // 36: bipush 1
      // 37: ldc "https://developers.google.com/accounts/docs/application-default-credentials"
      // 39: aastore
      // 3a: invokestatic java/lang/String.format (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
      // 3d: invokespecial java/io/IOException.<init> (Ljava/lang/String;)V
      // 40: athrow
      // 41: astore 1
      // 42: aload 0
      // 43: monitorexit
      // 44: aload 1
      // 45: athrow
      // try (2 -> 11): 39 null
      // try (11 -> 19): 39 null
      // try (21 -> 23): 39 null
      // try (40 -> 42): 39 null
   }

   String getProperty(String var1, String var2) {
      return System.getProperty(var1, var2);
   }

   private static class ComputeGoogleCredential extends GoogleCredential {
      private static final String TOKEN_SERVER_ENCODED_URL = String.valueOf(OAuth2Utils.getMetadataServerUrl())
         .concat("/computeMetadata/v1/instance/service-accounts/default/token");

      ComputeGoogleCredential(HttpTransport var1, JsonFactory var2) {
         super(new GoogleCredential.Builder().setTransport(var1).setJsonFactory(var2).setTokenServerEncodedUrl(TOKEN_SERVER_ENCODED_URL));
      }

      @Override
      protected TokenResponse executeRefreshToken() throws IOException {
         GenericUrl var2 = new GenericUrl(this.getTokenServerEncodedUrl());
         HttpRequest var3 = this.getTransport().createRequestFactory().buildGetRequest(var2);
         JsonObjectParser var5 = new JsonObjectParser(this.getJsonFactory());
         var3.setParser(var5);
         var3.getHeaders().set("Metadata-Flavor", "Google");
         var3.setThrowExceptionOnExecuteError(false);
         HttpResponse var4 = var3.execute();
         int var1 = var4.getStatusCode();
         if (var1 == 200) {
            InputStream var6 = var4.getContent();
            if (var6 == null) {
               throw new IOException("Empty content from metadata token server request.");
            } else {
               return var5.parseAndClose(var6, var4.getContentCharset(), TokenResponse.class);
            }
         } else if (var1 == 404) {
            throw new IOException(
               String.format(
                  "Error code %s trying to get security access token from Compute Engine metadata for the default service account. This may be because the virtual machine instance does not have permission scopes specified.",
                  var1
               )
            );
         } else {
            throw new IOException(
               String.format(
                  "Unexpected Error code %s trying to get security access token from Compute Engine metadata for the default service account: %s",
                  var1,
                  var4.parseAsString()
               )
            );
         }
      }
   }

   private enum Environment {
      APP_ENGINE,
      CLOUD_SHELL,
      COMPUTE_ENGINE,
      ENVIRONMENT_VARIABLE,
      UNKNOWN,
      WELL_KNOWN_FILE;

      private static final DefaultCredentialProvider.Environment[] $VALUES = new DefaultCredentialProvider.Environment[]{
         DefaultCredentialProvider.Environment.UNKNOWN,
         DefaultCredentialProvider.Environment.ENVIRONMENT_VARIABLE,
         DefaultCredentialProvider.Environment.WELL_KNOWN_FILE,
         DefaultCredentialProvider.Environment.CLOUD_SHELL,
         DefaultCredentialProvider.Environment.APP_ENGINE,
         DefaultCredentialProvider.Environment.COMPUTE_ENGINE
      };
   }
}
