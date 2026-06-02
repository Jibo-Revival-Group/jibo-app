package com.jibo.aws.integration.aws.services.common.model;

/* JADX INFO: loaded from: classes.dex */
public abstract class IdRequestAbstract extends JiboRequestAbstract {
    public IdRequestAbstract(String str) {
        setId(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof IdRequestAbstract)) {
            return false;
        }
        IdRequestAbstract idRequestAbstract = (IdRequestAbstract) obj;
        if ((idRequestAbstract.getId() == null) ^ (getId() == null)) {
            return false;
        }
        return idRequestAbstract.getId() == null || idRequestAbstract.getId().equals(getId());
    }

    public abstract String getId();

    public int hashCode() {
        return (getId() == null ? 0 : getId().hashCode()) + 31;
    }

    public abstract void setId(String str);

    public abstract String toString();
}
