package com.jibo.aws.integration.aws.services.account.model;

import com.google.gson.annotations.Expose;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class IdsRequestOptional extends JiboAccountRequest {

    @Expose
    private List<String> ids;

    public IdsRequestOptional(List<String> list) {
        this.ids = list;
    }
}
