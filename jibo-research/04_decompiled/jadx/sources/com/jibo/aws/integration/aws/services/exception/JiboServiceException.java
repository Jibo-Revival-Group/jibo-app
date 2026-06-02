package com.jibo.aws.integration.aws.services.exception;

import com.amazonaws.AmazonServiceException;

/* JADX INFO: loaded from: classes.dex */
public class JiboServiceException extends AmazonServiceException {

    /* JADX INFO: renamed from: a */
    protected String f9416a;

    public JiboServiceException(String str) {
        super(str);
    }

    public JiboServiceException(String str, Exception exc) {
        super(str, exc);
    }

    public String getType() {
        return this.f9416a;
    }

    public void setType(String str) {
        this.f9416a = str;
    }
}
