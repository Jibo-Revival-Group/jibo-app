package com.segment.analytics;

import android.text.TextUtils;
import com.segment.analytics.internal.Utils;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.util.zip.GZIPOutputStream;

/* JADX INFO: loaded from: classes.dex */
class Client {
    final ConnectionFactory connectionFactory;
    final String writeKey;

    private static Connection createPostConnection(HttpURLConnection httpURLConnection) throws IOException {
        OutputStream outputStream;
        if (TextUtils.equals("gzip", httpURLConnection.getRequestProperty("Content-Encoding"))) {
            outputStream = new GZIPOutputStream(httpURLConnection.getOutputStream());
        } else {
            outputStream = httpURLConnection.getOutputStream();
        }
        return new Connection(httpURLConnection, null, outputStream) { // from class: com.segment.analytics.Client.1
            @Override // com.segment.analytics.Client.Connection, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                String fully;
                try {
                    int responseCode = this.connection.getResponseCode();
                    if (responseCode >= 300) {
                        try {
                            fully = Utils.readFully(Utils.getInputStream(this.connection));
                        } catch (IOException e) {
                            fully = "Could not read response body for rejected message: " + e.toString();
                        }
                        throw new HTTPException(responseCode, this.connection.getResponseMessage(), fully);
                    }
                } finally {
                    super.close();
                    this.f14466os.close();
                }
            }
        };
    }

    private static Connection createGetConnection(HttpURLConnection httpURLConnection) throws IOException {
        return new Connection(httpURLConnection, Utils.getInputStream(httpURLConnection), null) { // from class: com.segment.analytics.Client.2
            @Override // com.segment.analytics.Client.Connection, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                super.close();
                this.f14465is.close();
            }
        };
    }

    Client(String str, ConnectionFactory connectionFactory) {
        this.writeKey = str;
        this.connectionFactory = connectionFactory;
    }

    Connection upload() throws IOException {
        return createPostConnection(this.connectionFactory.upload(this.writeKey));
    }

    Connection attribution() throws IOException {
        return createPostConnection(this.connectionFactory.attribution(this.writeKey));
    }

    Connection fetchSettings() throws IOException {
        HttpURLConnection httpURLConnectionProjectSettings = this.connectionFactory.projectSettings(this.writeKey);
        int responseCode = httpURLConnectionProjectSettings.getResponseCode();
        if (responseCode != 200) {
            httpURLConnectionProjectSettings.disconnect();
            throw new IOException("HTTP " + responseCode + ": " + httpURLConnectionProjectSettings.getResponseMessage());
        }
        return createGetConnection(httpURLConnectionProjectSettings);
    }

    static class HTTPException extends IOException {
        final String responseBody;
        final int responseCode;
        final String responseMessage;

        HTTPException(int i, String str, String str2) {
            super("HTTP " + i + ": " + str + ". Response: " + str2);
            this.responseCode = i;
            this.responseMessage = str;
            this.responseBody = str2;
        }
    }

    static abstract class Connection implements Closeable {
        final HttpURLConnection connection;

        /* JADX INFO: renamed from: is */
        final InputStream f14465is;

        /* JADX INFO: renamed from: os */
        final OutputStream f14466os;

        Connection(HttpURLConnection httpURLConnection, InputStream inputStream, OutputStream outputStream) {
            if (httpURLConnection == null) {
                throw new IllegalArgumentException("connection == null");
            }
            this.connection = httpURLConnection;
            this.f14465is = inputStream;
            this.f14466os = outputStream;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.connection.disconnect();
        }
    }
}
