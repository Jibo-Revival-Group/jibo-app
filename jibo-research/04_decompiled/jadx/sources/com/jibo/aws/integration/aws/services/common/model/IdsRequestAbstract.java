package com.jibo.aws.integration.aws.services.common.model;

import com.google.gson.annotations.Expose;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class IdsRequestAbstract extends JiboRequestAbstract {

    @Expose
    private List<String> ids;

    public IdsRequestAbstract(List<String> list) {
        this.ids = list;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof IdsRequestAbstract)) {
            return false;
        }
        IdsRequestAbstract idsRequestAbstract = (IdsRequestAbstract) obj;
        if ((idsRequestAbstract.getIds() == null) ^ (getIds() == null)) {
            return false;
        }
        return idsRequestAbstract.getIds() == null || idsRequestAbstract.getIds().equals(getIds());
    }

    public List<String> getIds() {
        return this.ids;
    }

    public int hashCode() {
        return (getIds() == null ? 0 : getIds().hashCode()) + 31;
    }

    public void setIds(List<String> list) {
        this.ids = list;
    }

    public String toString() {
        return "IdsRequest {ids='" + this.ids.toString() + "'}";
    }
}
