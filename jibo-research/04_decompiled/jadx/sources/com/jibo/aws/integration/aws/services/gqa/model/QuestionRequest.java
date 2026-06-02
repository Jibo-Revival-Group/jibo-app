package com.jibo.aws.integration.aws.services.gqa.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes.dex */
public class QuestionRequest extends GQABaseRequest {

    @SerializedName(m9428a = "Input")
    @Expose
    private String input;

    public QuestionRequest(String str) {
        this.input = str;
    }

    public String getInput() {
        return this.input;
    }

    public void setInput(String str) {
        this.input = str;
    }
}
