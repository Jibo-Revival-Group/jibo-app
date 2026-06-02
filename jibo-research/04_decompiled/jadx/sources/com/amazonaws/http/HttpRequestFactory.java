package com.amazonaws.http;

import com.amazonaws.AmazonClientException;
import com.amazonaws.ClientConfiguration;
import com.amazonaws.Request;
import com.amazonaws.util.HttpUtils;
import com.amazonaws.util.StringUtils;
import com.facebook.appevents.AppEventsConstants;
import com.google.api.client.http.HttpMethods;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.HttpHeaders;
import org.apache.http.protocol.HTTP;

/* JADX INFO: loaded from: classes.dex */
public class HttpRequestFactory {
    private void configureHeaders(Map<String, String> map, Request<?> request, ExecutionContext executionContext, ClientConfiguration clientConfiguration) {
        URI endpoint = request.getEndpoint();
        String host = endpoint.getHost();
        if (HttpUtils.isUsingNonDefaultPort(endpoint)) {
            host = host + ":" + endpoint.getPort();
        }
        map.put("Host", host);
        for (Map.Entry<String, String> entry : request.getHeaders().entrySet()) {
            map.put(entry.getKey(), entry.getValue());
        }
        if (map.get("Content-Type") == null || map.get("Content-Type").isEmpty()) {
            map.put("Content-Type", "application/x-www-form-urlencoded; charset=" + HTTP.UTF_8.toLowerCase());
        }
        if (executionContext == null || executionContext.getContextUserAgent() == null) {
            return;
        }
        map.put("User-Agent", createUserAgentString(clientConfiguration, executionContext.getContextUserAgent()));
    }

    private String createUserAgentString(ClientConfiguration clientConfiguration, String str) {
        return clientConfiguration.getUserAgent().contains(str) ? clientConfiguration.getUserAgent() : clientConfiguration.getUserAgent() + " " + str;
    }

    public HttpRequest createHttpRequest(Request<?> request, ClientConfiguration clientConfiguration, ExecutionContext executionContext) {
        InputStream inputStream;
        String str;
        String strAppendUri = HttpUtils.appendUri(request.getEndpoint().toString(), request.getResourcePath(), true);
        String strEncodeParameters = HttpUtils.encodeParameters(request);
        String str2 = (strEncodeParameters == null || !(!(request.getHttpMethod() == HttpMethodName.POST) || (request.getContent() != null))) ? strAppendUri : strAppendUri + "?" + strEncodeParameters;
        InputStream content = request.getContent();
        String string = request.getHttpMethod().toString();
        if (string.equals(HttpMethods.POST) && request.getContent() == null && strEncodeParameters != null) {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(strEncodeParameters.getBytes(StringUtils.UTF8));
            request.addHeader("Content-Length", String.valueOf(strEncodeParameters.length()));
            inputStream = byteArrayInputStream;
        } else {
            inputStream = content;
        }
        if ((string.equals(HttpMethods.POST) || string.equals(HttpMethods.PUT)) && ((str = request.getHeaders().get("Content-Length")) == null || str.isEmpty())) {
            if (inputStream != null) {
                throw new AmazonClientException("Unknown content-length");
            }
            request.addHeader("Content-Length", AppEventsConstants.EVENT_PARAM_VALUE_NO);
        }
        if (request.getHeaders().get(HttpHeaders.ACCEPT_ENCODING) == null) {
            request.addHeader(HttpHeaders.ACCEPT_ENCODING, "gzip");
        }
        HashMap map = new HashMap();
        configureHeaders(map, request, executionContext, clientConfiguration);
        return new HttpRequest(string, URI.create(str2), map, inputStream);
    }
}
