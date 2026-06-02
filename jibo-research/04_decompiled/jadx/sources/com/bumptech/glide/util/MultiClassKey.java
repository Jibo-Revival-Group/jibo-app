package com.bumptech.glide.util;

/* JADX INFO: loaded from: classes.dex */
public class MultiClassKey {

    /* JADX INFO: renamed from: a */
    private Class<?> f5007a;

    /* JADX INFO: renamed from: b */
    private Class<?> f5008b;

    public MultiClassKey() {
    }

    public MultiClassKey(Class<?> cls, Class<?> cls2) {
        m5584a(cls, cls2);
    }

    /* JADX INFO: renamed from: a */
    public void m5584a(Class<?> cls, Class<?> cls2) {
        this.f5007a = cls;
        this.f5008b = cls2;
    }

    public String toString() {
        return "MultiClassKey{first=" + this.f5007a + ", second=" + this.f5008b + '}';
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        MultiClassKey multiClassKey = (MultiClassKey) obj;
        return this.f5007a.equals(multiClassKey.f5007a) && this.f5008b.equals(multiClassKey.f5008b);
    }

    public int hashCode() {
        return (this.f5007a.hashCode() * 31) + this.f5008b.hashCode();
    }
}
