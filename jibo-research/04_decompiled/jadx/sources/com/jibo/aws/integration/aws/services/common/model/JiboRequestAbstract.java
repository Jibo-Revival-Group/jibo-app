package com.jibo.aws.integration.aws.services.common.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public abstract class JiboRequestAbstract extends AmazonWebServiceRequest implements Serializable {
    public abstract String getServiceAbbr();

    public String getServiceMethodName() {
        return getClass().getSimpleName().replace("Request", "");
    }

    public abstract String getServicePrefix();
}
