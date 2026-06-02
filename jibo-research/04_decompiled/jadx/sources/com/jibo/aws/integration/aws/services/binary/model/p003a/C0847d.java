package com.jibo.aws.integration.aws.services.binary.model.p003a;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.http.HttpMethodName;
import com.amazonaws.util.StringInputStream;
import com.google.gson.Gson;
import com.jibo.aws.integration.aws.services.binary.model.PathRequest;
import org.apache.http.HttpHeaders;
import org.apache.http.protocol.HTTP;

/* JADX INFO: renamed from: com.jibo.aws.integration.aws.services.binary.model.a.d */
/* JADX INFO: loaded from: classes.dex */
public class C0847d {
    /* JADX INFO: renamed from: a */
    public Request<PathRequest> m9957a(PathRequest pathRequest) {
        if (pathRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        DefaultRequest defaultRequest = new DefaultRequest(pathRequest, "voicetraining");
        defaultRequest.setHttpMethod(HttpMethodName.POST);
        defaultRequest.setResourcePath("");
        defaultRequest.addHeader("Content-Type", "application/json");
        defaultRequest.addHeader(HttpHeaders.ACCEPT, "application/json");
        defaultRequest.addHeader("X-Amz-Target", pathRequest.getServicePrefix() + pathRequest.getClass().getSimpleName().replace("BinaryRequest", ""));
        try {
            String string = new Gson().m9362b(pathRequest).toString();
            byte[] bytes = string.getBytes(HTTP.UTF_8);
            defaultRequest.setContent(new StringInputStream(string));
            defaultRequest.addHeader("Content-Length", Integer.toString(bytes.length));
            return defaultRequest;
        } catch (Throwable th) {
            throw new AmazonClientException("Unable to marshall request to JSON: " + th.getMessage(), th);
        }
    }
}
