package com.amazonaws.http;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.http.HttpResponse;
import com.facebook.internal.Utility;
import com.google.api.client.http.HttpMethods;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URLConnection;
import java.security.GeneralSecurityException;
import java.security.cert.X509Certificate;
import java.util.List;
import java.util.Map;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

/* JADX INFO: loaded from: classes.dex */
public class UrlHttpClient implements HttpClient {
    private final ClientConfiguration config;

    /* JADX INFO: renamed from: sc */
    private SSLContext f4644sc = null;

    static class AllowAllHostnameVerifier implements HostnameVerifier {
        AllowAllHostnameVerifier() {
        }

        @Override // javax.net.ssl.HostnameVerifier
        public boolean verify(String str, SSLSession sSLSession) {
            return true;
        }
    }

    static class TrustAllManager implements X509TrustManager {
        TrustAllManager() {
        }

        @Override // javax.net.ssl.X509TrustManager
        public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
        }

        @Override // javax.net.ssl.X509TrustManager
        public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
        }

        @Override // javax.net.ssl.X509TrustManager
        public X509Certificate[] getAcceptedIssuers() {
            return null;
        }
    }

    public UrlHttpClient(ClientConfiguration clientConfiguration) {
        this.config = clientConfiguration;
    }

    private void disableCertificateValidation(HttpsURLConnection httpsURLConnection) {
        if (this.f4644sc == null) {
            TrustManager[] trustManagerArr = {new TrustAllManager()};
            try {
                this.f4644sc = SSLContext.getInstance("TLS");
                this.f4644sc.init(null, trustManagerArr, null);
            } catch (GeneralSecurityException e) {
                throw new RuntimeException(e);
            }
        }
        httpsURLConnection.setSSLSocketFactory(this.f4644sc.getSocketFactory());
        httpsURLConnection.setHostnameVerifier(new AllowAllHostnameVerifier());
    }

    private void write(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[Utility.DEFAULT_STREAM_BUFFER_SIZE];
        while (true) {
            int i = inputStream.read(bArr);
            if (i == -1) {
                return;
            } else {
                outputStream.write(bArr, 0, i);
            }
        }
    }

    HttpURLConnection applyHeadersAndMethod(HttpRequest httpRequest, HttpURLConnection httpURLConnection) throws ProtocolException {
        if (httpRequest.getHeaders() != null && !httpRequest.getHeaders().isEmpty()) {
            for (Map.Entry<String, String> entry : httpRequest.getHeaders().entrySet()) {
                String key = entry.getKey();
                if (!key.equals("Content-Length") && !key.equals("Host")) {
                    if (key.equals("Expect")) {
                    }
                    httpURLConnection.setRequestProperty(key, entry.getValue());
                }
            }
        }
        httpURLConnection.setRequestMethod(httpRequest.getMethod());
        return httpURLConnection;
    }

    void configureConnection(HttpURLConnection httpURLConnection) {
        httpURLConnection.setConnectTimeout(this.config.getConnectionTimeout());
        httpURLConnection.setReadTimeout(this.config.getSocketTimeout());
        httpURLConnection.setInstanceFollowRedirects(false);
        httpURLConnection.setUseCaches(false);
        if (httpURLConnection instanceof HttpsURLConnection) {
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) httpURLConnection;
            if (System.getProperty("com.amazonaws.sdk.disableCertChecking") != null) {
                disableCertificateValidation(httpsURLConnection);
            }
        }
    }

    HttpResponse createHttpResponse(HttpRequest httpRequest, HttpURLConnection httpURLConnection) throws IOException {
        String responseMessage = httpURLConnection.getResponseMessage();
        int responseCode = httpURLConnection.getResponseCode();
        InputStream errorStream = httpURLConnection.getErrorStream();
        if (errorStream == null && !httpRequest.getMethod().equals(HttpMethods.HEAD)) {
            try {
                errorStream = httpURLConnection.getInputStream();
            } catch (IOException e) {
            }
        }
        HttpResponse.Builder builderContent = HttpResponse.builder().statusCode(responseCode).statusText(responseMessage).content(errorStream);
        for (Map.Entry<String, List<String>> entry : httpURLConnection.getHeaderFields().entrySet()) {
            if (entry.getKey() != null) {
                builderContent.header(entry.getKey(), entry.getValue().get(0));
            }
        }
        return builderContent.build();
    }

    @Override // com.amazonaws.http.HttpClient
    public HttpResponse execute(HttpRequest httpRequest) throws ProtocolException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(httpRequest.getUri().toURL().openConnection()));
        configureConnection(httpURLConnection);
        applyHeadersAndMethod(httpRequest, httpURLConnection);
        writeContentToConnection(httpRequest, httpURLConnection);
        return createHttpResponse(httpRequest, httpURLConnection);
    }

    @Override // com.amazonaws.http.HttpClient
    public void shutdown() {
    }

    void writeContentToConnection(HttpRequest httpRequest, HttpURLConnection httpURLConnection) {
        OutputStream outputStream = null;
        try {
            if (httpRequest.getContent() != null && httpRequest.getContentLength() >= 0) {
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setFixedLengthStreamingMode((int) httpRequest.getContentLength());
                outputStream = httpURLConnection.getOutputStream();
                write(httpRequest.getContent(), outputStream);
            }
            try {
                if (httpRequest.getContent() != null) {
                    httpRequest.getContent().close();
                }
                if (outputStream != null) {
                    outputStream.flush();
                    outputStream.close();
                }
            } catch (IOException e) {
            }
        } catch (Throwable th) {
            try {
                if (httpRequest.getContent() != null) {
                    httpRequest.getContent().close();
                }
                if (outputStream != null) {
                    outputStream.flush();
                    outputStream.close();
                }
            } catch (IOException e2) {
            }
            throw th;
        }
    }
}
