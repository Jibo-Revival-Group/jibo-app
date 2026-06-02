package com.jibo.aws.integration.aws.services.collision.model;

import com.google.gson.annotations.Expose;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class MatchRequest extends JiboCollisionRequest {

    @Expose
    private List<String> existingNames;

    @Expose
    private String name;

    public MatchRequest(List<String> list, String str) {
        this.existingNames = list;
        this.name = str;
    }

    public List<String> getExistingNames() {
        return this.existingNames;
    }

    public String getName() {
        return this.name;
    }

    public int hashCode() {
        return (((getExistingNames() == null ? 0 : getExistingNames().hashCode()) + 31) * 31) + (getName() != null ? getName().hashCode() : 0);
    }

    public void setExistingNames(List<String> list) {
        this.existingNames = list;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String toString() {
        return "MatchRequest {name='" + this.name + "'}";
    }
}
