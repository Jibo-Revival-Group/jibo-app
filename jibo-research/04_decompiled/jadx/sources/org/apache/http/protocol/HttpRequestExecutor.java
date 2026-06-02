package org.apache.http.protocol;

import com.google.api.client.http.HttpMethods;
import java.io.IOException;
import org.apache.http.HttpClientConnection;
import org.apache.http.HttpException;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.annotation.Immutable;
import org.apache.http.util.Args;

/* JADX INFO: loaded from: classes2.dex */
@Immutable
public class HttpRequestExecutor {
    public static final int DEFAULT_WAIT_FOR_CONTINUE = 3000;
    private final int waitForContinue;

    public HttpRequestExecutor(int i) {
        this.waitForContinue = Args.positive(i, "Wait for continue time");
    }

    public HttpRequestExecutor() {
        this(DEFAULT_WAIT_FOR_CONTINUE);
    }

    protected boolean canResponseHaveBody(HttpRequest httpRequest, HttpResponse httpResponse) {
        int statusCode;
        return (HttpMethods.HEAD.equalsIgnoreCase(httpRequest.getRequestLine().getMethod()) || (statusCode = httpResponse.getStatusLine().getStatusCode()) < 200 || statusCode == 204 || statusCode == 304 || statusCode == 205) ? false : true;
    }

    public HttpResponse execute(HttpRequest httpRequest, HttpClientConnection httpClientConnection, HttpContext httpContext) throws HttpException, IOException {
        Args.notNull(httpRequest, "HTTP request");
        Args.notNull(httpClientConnection, "Client connection");
        Args.notNull(httpContext, "HTTP context");
        try {
            HttpResponse httpResponseDoSendRequest = doSendRequest(httpRequest, httpClientConnection, httpContext);
            if (httpResponseDoSendRequest == null) {
                return doReceiveResponse(httpRequest, httpClientConnection, httpContext);
            }
            return httpResponseDoSendRequest;
        } catch (IOException e) {
            closeConnection(httpClientConnection);
            throw e;
        } catch (RuntimeException e2) {
            closeConnection(httpClientConnection);
            throw e2;
        } catch (HttpException e3) {
            closeConnection(httpClientConnection);
            throw e3;
        }
    }

    private static void closeConnection(HttpClientConnection httpClientConnection) {
        try {
            httpClientConnection.close();
        } catch (IOException e) {
        }
    }

    public void preProcess(HttpRequest httpRequest, HttpProcessor httpProcessor, HttpContext httpContext) throws HttpException, IOException {
        Args.notNull(httpRequest, "HTTP request");
        Args.notNull(httpProcessor, "HTTP processor");
        Args.notNull(httpContext, "HTTP context");
        httpContext.setAttribute("http.request", httpRequest);
        httpProcessor.process(httpRequest, httpContext);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x009a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected org.apache.http.HttpResponse doSendRequest(org.apache.http.HttpRequest r6, org.apache.http.HttpClientConnection r7, org.apache.http.protocol.HttpContext r8) throws org.apache.http.HttpException, java.io.IOException {
        /*
            r5 = this;
            r1 = 0
            java.lang.String r0 = "HTTP request"
            org.apache.http.util.Args.notNull(r6, r0)
            java.lang.String r0 = "Client connection"
            org.apache.http.util.Args.notNull(r7, r0)
            java.lang.String r0 = "HTTP context"
            org.apache.http.util.Args.notNull(r8, r0)
            java.lang.String r0 = "http.connection"
            r8.setAttribute(r0, r7)
            java.lang.String r0 = "http.request_sent"
            java.lang.Boolean r2 = java.lang.Boolean.FALSE
            r8.setAttribute(r0, r2)
            r7.sendRequestHeader(r6)
            boolean r0 = r6 instanceof org.apache.http.HttpEntityEnclosingRequest
            if (r0 == 0) goto L9d
            r2 = 1
            org.apache.http.RequestLine r0 = r6.getRequestLine()
            org.apache.http.ProtocolVersion r3 = r0.getProtocolVersion()
            r0 = r6
            org.apache.http.HttpEntityEnclosingRequest r0 = (org.apache.http.HttpEntityEnclosingRequest) r0
            boolean r0 = r0.expectContinue()
            if (r0 == 0) goto L9a
            org.apache.http.HttpVersion r0 = org.apache.http.HttpVersion.HTTP_1_0
            boolean r0 = r3.lessEquals(r0)
            if (r0 != 0) goto L9a
            r7.flush()
            int r0 = r5.waitForContinue
            boolean r0 = r7.isResponseAvailable(r0)
            if (r0 == 0) goto L9a
            org.apache.http.HttpResponse r3 = r7.receiveResponseHeader()
            boolean r0 = r5.canResponseHaveBody(r6, r3)
            if (r0 == 0) goto L55
            r7.receiveResponseEntity(r3)
        L55:
            org.apache.http.StatusLine r0 = r3.getStatusLine()
            int r0 = r0.getStatusCode()
            r4 = 200(0xc8, float:2.8E-43)
            if (r0 >= r4) goto L96
            r4 = 100
            if (r0 == r4) goto L82
            org.apache.http.ProtocolException r0 = new org.apache.http.ProtocolException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Unexpected response: "
            java.lang.StringBuilder r1 = r1.append(r2)
            org.apache.http.StatusLine r2 = r3.getStatusLine()
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L82:
            r0 = r1
            r1 = r2
        L84:
            if (r1 == 0) goto L8b
            org.apache.http.HttpEntityEnclosingRequest r6 = (org.apache.http.HttpEntityEnclosingRequest) r6
            r7.sendRequestEntity(r6)
        L8b:
            r7.flush()
            java.lang.String r1 = "http.request_sent"
            java.lang.Boolean r2 = java.lang.Boolean.TRUE
            r8.setAttribute(r1, r2)
            return r0
        L96:
            r0 = 0
            r1 = r0
            r0 = r3
            goto L84
        L9a:
            r0 = r1
            r1 = r2
            goto L84
        L9d:
            r0 = r1
            goto L8b
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.http.protocol.HttpRequestExecutor.doSendRequest(org.apache.http.HttpRequest, org.apache.http.HttpClientConnection, org.apache.http.protocol.HttpContext):org.apache.http.HttpResponse");
    }

    protected HttpResponse doReceiveResponse(HttpRequest httpRequest, HttpClientConnection httpClientConnection, HttpContext httpContext) throws HttpException, IOException {
        Args.notNull(httpRequest, "HTTP request");
        Args.notNull(httpClientConnection, "Client connection");
        Args.notNull(httpContext, "HTTP context");
        HttpResponse httpResponseReceiveResponseHeader = null;
        int statusCode = 0;
        while (true) {
            if (httpResponseReceiveResponseHeader == null || statusCode < 200) {
                httpResponseReceiveResponseHeader = httpClientConnection.receiveResponseHeader();
                if (canResponseHaveBody(httpRequest, httpResponseReceiveResponseHeader)) {
                    httpClientConnection.receiveResponseEntity(httpResponseReceiveResponseHeader);
                }
                statusCode = httpResponseReceiveResponseHeader.getStatusLine().getStatusCode();
            } else {
                return httpResponseReceiveResponseHeader;
            }
        }
    }

    public void postProcess(HttpResponse httpResponse, HttpProcessor httpProcessor, HttpContext httpContext) throws HttpException, IOException {
        Args.notNull(httpResponse, "HTTP response");
        Args.notNull(httpProcessor, "HTTP processor");
        Args.notNull(httpContext, "HTTP context");
        httpContext.setAttribute("http.response", httpResponse);
        httpProcessor.process(httpResponse, httpContext);
    }
}
