package com.jibo.aws.integration.aws.services.common.model.p005a;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.http.HttpMethodName;
import com.amazonaws.util.StringInputStream;
import com.google.gson.Gson;
import com.jibo.aws.integration.aws.services.common.model.JiboRequestAbstract;
import org.apache.http.HttpHeaders;
import org.apache.http.protocol.HTTP;

/* JADX INFO: renamed from: com.jibo.aws.integration.aws.services.common.model.a.e */
/* JADX INFO: loaded from: classes.dex */
public class C0855e {
    /* JADX INFO: renamed from: a */
    public Request<JiboRequestAbstract> mo9956a(JiboRequestAbstract jiboRequestAbstract) {
        if (jiboRequestAbstract == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        DefaultRequest defaultRequest = new DefaultRequest(jiboRequestAbstract, jiboRequestAbstract.getServiceAbbr());
        defaultRequest.setHttpMethod(HttpMethodName.POST);
        defaultRequest.setResourcePath("");
        defaultRequest.addHeader("Content-Type", "application/json");
        defaultRequest.addHeader(HttpHeaders.ACCEPT, "application/json");
        defaultRequest.addHeader("X-Amz-Target", jiboRequestAbstract.getServicePrefix() + jiboRequestAbstract.getServiceMethodName());
        try {
            String strMo9961b = mo9961b(jiboRequestAbstract);
            byte[] bytes = strMo9961b.getBytes(HTTP.UTF_8);
            defaultRequest.setContent(new StringInputStream(strMo9961b));
            defaultRequest.addHeader("Content-Length", Integer.toString(bytes.length));
            return defaultRequest;
        } catch (Throwable th) {
            throw new AmazonClientException("Unable to marshall request to JSON: " + th.getMessage(), th);
        }
    }

    /* JADX INFO: renamed from: b */
    protected String mo9961b(JiboRequestAbstract jiboRequestAbstract) {
        return new Gson().m9362b(jiboRequestAbstract).toString().replace("\\\\", "\\");
    }
}
