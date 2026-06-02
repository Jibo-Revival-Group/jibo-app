package com.segment.analytics;

import android.util.Base64;
import com.google.api.client.http.HttpMethods;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import org.apache.http.HttpHeaders;

/* JADX INFO: loaded from: classes.dex */
public class ConnectionFactory {
    private static final int DEFAULT_CONNECT_TIMEOUT_MILLIS = 15000;
    private static final int DEFAULT_READ_TIMEOUT_MILLIS = 20000;

    private String authorizationHeader(String str) {
        return "Basic " + Base64.encodeToString((str + ":").getBytes(), 2);
    }

    public HttpURLConnection projectSettings(String str) throws IOException {
        return openConnection("https://cdn-settings.segment.com/v1/projects/" + str + "/settings");
    }

    public HttpURLConnection upload(String str) throws IOException {
        HttpURLConnection httpURLConnectionOpenConnection = openConnection("https://api.segment.io/v1/import");
        httpURLConnectionOpenConnection.setRequestProperty(HttpHeaders.AUTHORIZATION, authorizationHeader(str));
        httpURLConnectionOpenConnection.setRequestProperty("Content-Encoding", "gzip");
        httpURLConnectionOpenConnection.setDoOutput(true);
        httpURLConnectionOpenConnection.setChunkedStreamingMode(0);
        return httpURLConnectionOpenConnection;
    }

    public HttpURLConnection attribution(String str) throws IOException {
        HttpURLConnection httpURLConnectionOpenConnection = openConnection("https://mobile-service.segment.com/v1/attribution");
        httpURLConnectionOpenConnection.setRequestProperty(HttpHeaders.AUTHORIZATION, authorizationHeader(str));
        httpURLConnectionOpenConnection.setRequestMethod(HttpMethods.POST);
        httpURLConnectionOpenConnection.setDoOutput(true);
        return httpURLConnectionOpenConnection;
    }

    protected HttpURLConnection openConnection(String str) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(new URL(str).openConnection()));
        httpURLConnection.setConnectTimeout(DEFAULT_CONNECT_TIMEOUT_MILLIS);
        httpURLConnection.setReadTimeout(DEFAULT_READ_TIMEOUT_MILLIS);
        httpURLConnection.setRequestProperty("Content-Type", "application/json");
        httpURLConnection.setDoInput(true);
        return httpURLConnection;
    }
}
