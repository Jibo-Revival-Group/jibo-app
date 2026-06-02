package com.jibo.aws.integration.aws.services.common.model;

import com.google.gson.annotations.Expose;

/* JADX INFO: loaded from: classes.dex */
public abstract class NameRequestAbstract extends JiboRequestAbstract {

    @Expose
    private String name;

    public NameRequestAbstract(String str) {
        this.name = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof NameRequestAbstract)) {
            return false;
        }
        NameRequestAbstract nameRequestAbstract = (NameRequestAbstract) obj;
        if ((nameRequestAbstract.getName() == null) ^ (getName() == null)) {
            return false;
        }
        return nameRequestAbstract.getName() == null || nameRequestAbstract.getName().equals(getName());
    }

    public String getName() {
        return this.name;
    }

    public int hashCode() {
        return (getName() == null ? 0 : getName().hashCode()) + 31;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String toString() {
        return "NameRequest {name='" + this.name + "'}";
    }
}
