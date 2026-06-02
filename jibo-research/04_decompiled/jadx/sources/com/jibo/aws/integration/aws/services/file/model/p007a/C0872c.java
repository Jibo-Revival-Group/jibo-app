package com.jibo.aws.integration.aws.services.file.model.p007a;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.http.HttpMethodName;
import com.jibo.aws.integration.aws.services.file.model.KeyRequest;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.entity.mime.MultipartEntityBuilder;

/* JADX INFO: renamed from: com.jibo.aws.integration.aws.services.file.model.a.c */
/* JADX INFO: loaded from: classes.dex */
public class C0872c {
    /* JADX INFO: renamed from: a */
    public Request<KeyRequest> m9972a(KeyRequest keyRequest) {
        if (keyRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        DefaultRequest defaultRequest = new DefaultRequest(keyRequest, "voicetraining");
        defaultRequest.setHttpMethod(HttpMethodName.POST);
        defaultRequest.setResourcePath("");
        defaultRequest.addHeader("Content-Type", "multipart/form-data;boundary=veWbX8w3UcqtKDWIlUqj2DvRQzayEePJqxnkRE");
        defaultRequest.addHeader(HttpHeaders.ACCEPT, "application/json");
        defaultRequest.addHeader("X-Amz-Target", keyRequest.getServicePrefix() + keyRequest.getClass().getSimpleName().replace("Request", ""));
        try {
            MultipartEntityBuilder multipartEntityBuilderCreate = MultipartEntityBuilder.create();
            multipartEntityBuilderCreate.setBoundary("veWbX8w3UcqtKDWIlUqj2DvRQzayEePJqxnkRE");
            multipartEntityBuilderCreate.addTextBody("key", keyRequest.getKey());
            HttpEntity httpEntityBuild = multipartEntityBuilderCreate.build();
            defaultRequest.addHeader("Content-Length", Long.toString(httpEntityBuild.getContentLength()));
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream((int) httpEntityBuild.getContentLength());
            httpEntityBuild.writeTo(byteArrayOutputStream);
            defaultRequest.setContent(new ByteArrayInputStream(byteArrayOutputStream.toByteArray()));
            return defaultRequest;
        } catch (Throwable th) {
            throw new AmazonClientException("Unable to marshall request to JSON: " + th.getMessage(), th);
        }
    }
}
