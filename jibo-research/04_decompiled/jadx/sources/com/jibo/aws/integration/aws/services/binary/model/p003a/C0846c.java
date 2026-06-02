package com.jibo.aws.integration.aws.services.binary.model.p003a;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.http.HttpMethodName;
import com.jibo.aws.integration.aws.services.binary.model.CreateBinaryRequest;
import com.jibo.aws.integration.aws.services.binary.p002a.C0842a;
import com.jibo.aws.integration.aws.services.common.model.JiboRequestAbstract;
import com.jibo.aws.integration.aws.services.common.model.p005a.C0855e;
import java.io.FileInputStream;
import org.apache.http.HttpHeaders;

/* JADX INFO: renamed from: com.jibo.aws.integration.aws.services.binary.model.a.c */
/* JADX INFO: loaded from: classes.dex */
public class C0846c extends C0855e {
    @Override // com.jibo.aws.integration.aws.services.common.model.p005a.C0855e
    /* JADX INFO: renamed from: a */
    public Request<JiboRequestAbstract> mo9956a(JiboRequestAbstract jiboRequestAbstract) {
        if (jiboRequestAbstract == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        CreateBinaryRequest createBinaryRequest = (CreateBinaryRequest) jiboRequestAbstract;
        DefaultRequest defaultRequest = new DefaultRequest(jiboRequestAbstract, jiboRequestAbstract.getServiceAbbr());
        defaultRequest.setHttpMethod(HttpMethodName.POST);
        defaultRequest.setResourcePath("");
        defaultRequest.addHeader("Content-Type", C0842a.m9951a().m9952a(createBinaryRequest.getBody()));
        defaultRequest.addHeader("Content-Encoding", "aws-chunked");
        defaultRequest.addHeader("Proxy-Connection", "keep-alive");
        defaultRequest.addHeader("Connection", "keep-alive");
        defaultRequest.addHeader(HttpHeaders.PRAGMA, "no-cache");
        defaultRequest.addHeader(HttpHeaders.CACHE_CONTROL, "no-cache");
        defaultRequest.addHeader("Transfer-Encoding", "Chunked");
        defaultRequest.addHeader(HttpHeaders.ACCEPT, "application/json");
        defaultRequest.addHeader("x-amz-content-sha256", "required");
        mo9940a(defaultRequest, createBinaryRequest);
        defaultRequest.addHeader("X-Amz-Target", jiboRequestAbstract.getServicePrefix() + jiboRequestAbstract.getServiceMethodName());
        if (createBinaryRequest.getMeta() != null && !createBinaryRequest.getMeta().isEmpty()) {
            for (String str : createBinaryRequest.getMeta().keySet()) {
                defaultRequest.addHeader("x-meta" + str, createBinaryRequest.getMeta().get(str));
            }
        }
        try {
            defaultRequest.addHeader("Content-Length", Long.toString(createBinaryRequest.getBody().length()));
            defaultRequest.addHeader("x-amz-decoded-content-length", Long.toString(createBinaryRequest.getBody().length()));
            defaultRequest.setContent(new FileInputStream(createBinaryRequest.getBody()));
            return defaultRequest;
        } catch (Throwable th) {
            throw new AmazonClientException("Unable to marshall request to JSON: " + th.getMessage(), th);
        }
    }

    /* JADX INFO: renamed from: a */
    protected void mo9940a(Request<JiboRequestAbstract> request, CreateBinaryRequest createBinaryRequest) {
        request.addHeader("x-path", createBinaryRequest.getPath());
    }
}
