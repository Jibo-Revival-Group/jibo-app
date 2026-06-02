package com.jibo.aws.integration.aws.services.loop.model;

/* JADX INFO: loaded from: classes.dex */
public class RemoveRequest extends JiboLoopRequest {
    public RemoveRequest(String str) {
        super(str);
    }

    @Override // com.jibo.aws.integration.aws.services.common.model.JiboRequestAbstract
    public String getServiceMethodName() {
        return "RemoveLoop";
    }
}
