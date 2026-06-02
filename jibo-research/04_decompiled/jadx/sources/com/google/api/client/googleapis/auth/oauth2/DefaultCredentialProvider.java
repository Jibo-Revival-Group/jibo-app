package com.google.api.client.googleapis.auth.oauth2;

import com.google.api.client.auth.oauth2.TokenResponse;
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
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

/* JADX INFO: loaded from: classes.dex */
@Beta
class DefaultCredentialProvider extends SystemEnvironmentProvider {
    static final String APP_ENGINE_CREDENTIAL_CLASS = "com.google.api.client.googleapis.extensions.appengine.auth.oauth2.AppIdentityCredential$AppEngineCredentialWrapper";
    static final String CLOUDSDK_CONFIG_DIRECTORY = "gcloud";
    static final String CLOUD_SHELL_ENV_VAR = "DEVSHELL_CLIENT_PORT";
    static final String CREDENTIAL_ENV_VAR = "GOOGLE_APPLICATION_CREDENTIALS";
    static final String HELP_PERMALINK = "https://developers.google.com/accounts/docs/application-default-credentials";
    static final String WELL_KNOWN_CREDENTIALS_FILE = "application_default_credentials.json";
    private GoogleCredential cachedCredential = null;
    private Environment detectedEnvironment = null;

    private enum Environment {
        UNKNOWN,
        ENVIRONMENT_VARIABLE,
        WELL_KNOWN_FILE,
        CLOUD_SHELL,
        APP_ENGINE,
        COMPUTE_ENGINE
    }

    DefaultCredentialProvider() {
    }

    final GoogleCredential getDefaultCredential(HttpTransport httpTransport, JsonFactory jsonFactory) throws IOException {
        synchronized (this) {
            if (this.cachedCredential == null) {
                this.cachedCredential = getDefaultCredentialUnsynchronized(httpTransport, jsonFactory);
            }
            if (this.cachedCredential != null) {
                return this.cachedCredential;
            }
            throw new IOException(String.format("The Application Default Credentials are not available. They are available if running on Google App Engine, Google Compute Engine, or Google Cloud Shell. Otherwise, the environment variable %s must be defined pointing to a file defining the credentials. See %s for more information.", CREDENTIAL_ENV_VAR, HELP_PERMALINK));
        }
    }

    private final GoogleCredential getDefaultCredentialUnsynchronized(HttpTransport httpTransport, JsonFactory jsonFactory) throws IOException {
        if (this.detectedEnvironment == null) {
            this.detectedEnvironment = detectEnvironment(httpTransport);
        }
        switch (this.detectedEnvironment) {
            case ENVIRONMENT_VARIABLE:
                return getCredentialUsingEnvironmentVariable(httpTransport, jsonFactory);
            case WELL_KNOWN_FILE:
                return getCredentialUsingWellKnownFile(httpTransport, jsonFactory);
            case APP_ENGINE:
                return getAppEngineCredential(httpTransport, jsonFactory);
            case CLOUD_SHELL:
                return getCloudShellCredential(jsonFactory);
            case COMPUTE_ENGINE:
                return getComputeCredential(httpTransport, jsonFactory);
            default:
                return null;
        }
    }

    private final File getWellKnownCredentialsFile() {
        File file;
        if (getProperty("os.name", "").toLowerCase(Locale.US).indexOf("windows") >= 0) {
            file = new File(new File(getEnv("APPDATA")), CLOUDSDK_CONFIG_DIRECTORY);
        } else {
            file = new File(new File(getProperty("user.home", ""), ".config"), CLOUDSDK_CONFIG_DIRECTORY);
        }
        return new File(file, WELL_KNOWN_CREDENTIALS_FILE);
    }

    boolean fileExists(File file) {
        return file.exists() && !file.isDirectory();
    }

    String getProperty(String str, String str2) {
        return System.getProperty(str, str2);
    }

    Class<?> forName(String str) throws ClassNotFoundException {
        return Class.forName(str);
    }

    private final Environment detectEnvironment(HttpTransport httpTransport) throws IOException {
        if (runningUsingEnvironmentVariable()) {
            return Environment.ENVIRONMENT_VARIABLE;
        }
        if (runningUsingWellKnownFile()) {
            return Environment.WELL_KNOWN_FILE;
        }
        if (runningOnAppEngine()) {
            return Environment.APP_ENGINE;
        }
        if (runningOnCloudShell()) {
            return Environment.CLOUD_SHELL;
        }
        if (OAuth2Utils.runningOnComputeEngine(httpTransport, this)) {
            return Environment.COMPUTE_ENGINE;
        }
        return Environment.UNKNOWN;
    }

    private boolean runningUsingEnvironmentVariable() throws IOException {
        String env = getEnv(CREDENTIAL_ENV_VAR);
        if (env == null || env.length() == 0) {
            return false;
        }
        try {
            File file = new File(env);
            if (!file.exists() || file.isDirectory()) {
                throw new IOException(String.format("Error reading credential file from environment variable %s, value '%s': File does not exist.", CREDENTIAL_ENV_VAR, env));
            }
            return true;
        } catch (AccessControlException e) {
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x003f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private com.google.api.client.googleapis.auth.oauth2.GoogleCredential getCredentialUsingEnvironmentVariable(com.google.api.client.http.HttpTransport r9, com.google.api.client.json.JsonFactory r10) throws java.lang.Throwable {
        /*
            r8 = this;
            java.lang.String r0 = "GOOGLE_APPLICATION_CREDENTIALS"
            java.lang.String r3 = r8.getEnv(r0)
            r2 = 0
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch: java.io.IOException -> L16 java.lang.Throwable -> L43
            r1.<init>(r3)     // Catch: java.io.IOException -> L16 java.lang.Throwable -> L43
            com.google.api.client.googleapis.auth.oauth2.GoogleCredential r0 = com.google.api.client.googleapis.auth.oauth2.GoogleCredential.fromStream(r1, r9, r10)     // Catch: java.lang.Throwable -> L3c java.io.IOException -> L46
            if (r1 == 0) goto L15
            r1.close()
        L15:
            return r0
        L16:
            r0 = move-exception
            r1 = r2
        L18:
            java.io.IOException r2 = new java.io.IOException     // Catch: java.lang.Throwable -> L3c
            java.lang.String r4 = "Error reading credential file from environment variable %s, value '%s': %s"
            r5 = 3
            java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch: java.lang.Throwable -> L3c
            r6 = 0
            java.lang.String r7 = "GOOGLE_APPLICATION_CREDENTIALS"
            r5[r6] = r7     // Catch: java.lang.Throwable -> L3c
            r6 = 1
            r5[r6] = r3     // Catch: java.lang.Throwable -> L3c
            r3 = 2
            java.lang.String r6 = r0.getMessage()     // Catch: java.lang.Throwable -> L3c
            r5[r3] = r6     // Catch: java.lang.Throwable -> L3c
            java.lang.String r3 = java.lang.String.format(r4, r5)     // Catch: java.lang.Throwable -> L3c
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L3c
            java.lang.Throwable r0 = com.google.api.client.googleapis.auth.oauth2.OAuth2Utils.exceptionWithCause(r2, r0)     // Catch: java.lang.Throwable -> L3c
            java.io.IOException r0 = (java.io.IOException) r0     // Catch: java.lang.Throwable -> L3c
            throw r0     // Catch: java.lang.Throwable -> L3c
        L3c:
            r0 = move-exception
        L3d:
            if (r1 == 0) goto L42
            r1.close()
        L42:
            throw r0
        L43:
            r0 = move-exception
            r1 = r2
            goto L3d
        L46:
            r0 = move-exception
            goto L18
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.api.client.googleapis.auth.oauth2.DefaultCredentialProvider.getCredentialUsingEnvironmentVariable(com.google.api.client.http.HttpTransport, com.google.api.client.json.JsonFactory):com.google.api.client.googleapis.auth.oauth2.GoogleCredential");
    }

    private boolean runningUsingWellKnownFile() {
        try {
            return fileExists(getWellKnownCredentialsFile());
        } catch (AccessControlException e) {
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0032  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private com.google.api.client.googleapis.auth.oauth2.GoogleCredential getCredentialUsingWellKnownFile(com.google.api.client.http.HttpTransport r8, com.google.api.client.json.JsonFactory r9) throws java.lang.Throwable {
        /*
            r7 = this;
            java.io.File r3 = r7.getWellKnownCredentialsFile()
            r2 = 0
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch: java.io.IOException -> L14 java.lang.Throwable -> L36
            r1.<init>(r3)     // Catch: java.io.IOException -> L14 java.lang.Throwable -> L36
            com.google.api.client.googleapis.auth.oauth2.GoogleCredential r0 = com.google.api.client.googleapis.auth.oauth2.GoogleCredential.fromStream(r1, r8, r9)     // Catch: java.lang.Throwable -> L2f java.io.IOException -> L39
            if (r1 == 0) goto L13
            r1.close()
        L13:
            return r0
        L14:
            r0 = move-exception
            r1 = r2
        L16:
            java.io.IOException r2 = new java.io.IOException     // Catch: java.lang.Throwable -> L2f
            java.lang.String r4 = "Error reading credential file from location %s: %s"
            r5 = 2
            java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch: java.lang.Throwable -> L2f
            r6 = 0
            r5[r6] = r3     // Catch: java.lang.Throwable -> L2f
            r3 = 1
            java.lang.String r0 = r0.getMessage()     // Catch: java.lang.Throwable -> L2f
            r5[r3] = r0     // Catch: java.lang.Throwable -> L2f
            java.lang.String r0 = java.lang.String.format(r4, r5)     // Catch: java.lang.Throwable -> L2f
            r2.<init>(r0)     // Catch: java.lang.Throwable -> L2f
            throw r2     // Catch: java.lang.Throwable -> L2f
        L2f:
            r0 = move-exception
        L30:
            if (r1 == 0) goto L35
            r1.close()
        L35:
            throw r0
        L36:
            r0 = move-exception
            r1 = r2
            goto L30
        L39:
            r0 = move-exception
            goto L16
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.api.client.googleapis.auth.oauth2.DefaultCredentialProvider.getCredentialUsingWellKnownFile(com.google.api.client.http.HttpTransport, com.google.api.client.json.JsonFactory):com.google.api.client.googleapis.auth.oauth2.GoogleCredential");
    }

    private boolean runningOnAppEngine() {
        try {
            try {
                Field field = forName("com.google.appengine.api.utils.SystemProperty").getField("environment");
                return field.getType().getMethod("value", new Class[0]).invoke(field.get(null), new Object[0]) != null;
            } catch (IllegalAccessException | IllegalArgumentException | NoSuchFieldException | NoSuchMethodException | SecurityException | InvocationTargetException e) {
                throw ((RuntimeException) OAuth2Utils.exceptionWithCause(new RuntimeException(String.format("Unexpcted error trying to determine if runnning on Google App Engine: %s", e.getMessage())), e));
            }
        } catch (ClassNotFoundException e2) {
            return false;
        }
    }

    private final GoogleCredential getAppEngineCredential(HttpTransport httpTransport, JsonFactory jsonFactory) throws IOException {
        try {
            return (GoogleCredential) forName(APP_ENGINE_CREDENTIAL_CLASS).getConstructor(HttpTransport.class, JsonFactory.class).newInstance(httpTransport, jsonFactory);
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e) {
            throw ((IOException) OAuth2Utils.exceptionWithCause(new IOException(String.format("Application Default Credentials failed to create the Google App Engine service account credentials class %s. Check that the component 'google-api-client-appengine' is deployed.", APP_ENGINE_CREDENTIAL_CLASS)), e));
        }
    }

    private boolean runningOnCloudShell() {
        return getEnv(CLOUD_SHELL_ENV_VAR) != null;
    }

    private GoogleCredential getCloudShellCredential(JsonFactory jsonFactory) {
        return new CloudShellCredential(Integer.parseInt(getEnv(CLOUD_SHELL_ENV_VAR)), jsonFactory);
    }

    private final GoogleCredential getComputeCredential(HttpTransport httpTransport, JsonFactory jsonFactory) {
        return new ComputeGoogleCredential(httpTransport, jsonFactory);
    }

    private static class ComputeGoogleCredential extends GoogleCredential {
        private static final String TOKEN_SERVER_ENCODED_URL = String.valueOf(OAuth2Utils.getMetadataServerUrl()).concat("/computeMetadata/v1/instance/service-accounts/default/token");

        ComputeGoogleCredential(HttpTransport httpTransport, JsonFactory jsonFactory) {
            super(new GoogleCredential.Builder().setTransport(httpTransport).setJsonFactory(jsonFactory).setTokenServerEncodedUrl(TOKEN_SERVER_ENCODED_URL));
        }

        @Override // com.google.api.client.googleapis.auth.oauth2.GoogleCredential, com.google.api.client.auth.oauth2.Credential
        protected TokenResponse executeRefreshToken() throws Throwable {
            HttpRequest httpRequestBuildGetRequest = getTransport().createRequestFactory().buildGetRequest(new GenericUrl(getTokenServerEncodedUrl()));
            JsonObjectParser jsonObjectParser = new JsonObjectParser(getJsonFactory());
            httpRequestBuildGetRequest.setParser(jsonObjectParser);
            httpRequestBuildGetRequest.getHeaders().set("Metadata-Flavor", "Google");
            httpRequestBuildGetRequest.setThrowExceptionOnExecuteError(false);
            HttpResponse httpResponseExecute = httpRequestBuildGetRequest.execute();
            int statusCode = httpResponseExecute.getStatusCode();
            if (statusCode == 200) {
                InputStream content = httpResponseExecute.getContent();
                if (content == null) {
                    throw new IOException("Empty content from metadata token server request.");
                }
                return (TokenResponse) jsonObjectParser.parseAndClose(content, httpResponseExecute.getContentCharset(), TokenResponse.class);
            }
            if (statusCode == 404) {
                throw new IOException(String.format("Error code %s trying to get security access token from Compute Engine metadata for the default service account. This may be because the virtual machine instance does not have permission scopes specified.", Integer.valueOf(statusCode)));
            }
            throw new IOException(String.format("Unexpected Error code %s trying to get security access token from Compute Engine metadata for the default service account: %s", Integer.valueOf(statusCode), httpResponseExecute.parseAsString()));
        }
    }
}
