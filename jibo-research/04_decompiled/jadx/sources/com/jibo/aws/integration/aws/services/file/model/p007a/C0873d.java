package com.jibo.aws.integration.aws.services.file.model.p007a;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.http.HttpMethodName;
import com.jibo.aws.integration.aws.services.file.model.UploadFileRequest;
import com.jibo.aws.integration.util.Commons;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.entity.mime.MultipartEntityBuilder;

/* JADX INFO: renamed from: com.jibo.aws.integration.aws.services.file.model.a.d */
/* JADX INFO: loaded from: classes.dex */
public class C0873d {
    /* JADX INFO: renamed from: a */
    public Request<UploadFileRequest> m9973a(UploadFileRequest uploadFileRequest) {
        if (uploadFileRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        DefaultRequest defaultRequest = new DefaultRequest(uploadFileRequest, "voicetraining");
        defaultRequest.setHttpMethod(HttpMethodName.POST);
        defaultRequest.setResourcePath("");
        defaultRequest.addHeader("Content-Type", "multipart/form-data;boundary=veWbX8w3UcqtKDWIlUqj2DvRQzayEePJqxnkRE");
        defaultRequest.addHeader(HttpHeaders.ACCEPT, "application/json");
        defaultRequest.addHeader("X-Amz-Target", Commons.TARGET_PREFIX_PLACEHOLDER + uploadFileRequest.getClass().getSimpleName().replace("Request", ""));
        try {
            MultipartEntityBuilder multipartEntityBuilderCreate = MultipartEntityBuilder.create();
            multipartEntityBuilderCreate.setBoundary("veWbX8w3UcqtKDWIlUqj2DvRQzayEePJqxnkRE");
            multipartEntityBuilderCreate.addTextBody("key", uploadFileRequest.getKey());
            multipartEntityBuilderCreate.addBinaryBody("body", uploadFileRequest.getBody());
            HttpEntity httpEntityBuild = multipartEntityBuilderCreate.build();
            defaultRequest.addHeader("Content-Length", Long.toString(httpEntityBuild.getContentLength()));
            defaultRequest.setContent(httpEntityBuild.getContent());
            return defaultRequest;
        } catch (Throwable th) {
            throw new AmazonClientException("Unable to marshall request to JSON: " + th.getMessage(), th);
        }
    }
}
