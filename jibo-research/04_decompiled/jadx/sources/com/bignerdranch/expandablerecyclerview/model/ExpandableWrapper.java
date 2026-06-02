package com.bignerdranch.expandablerecyclerview.model;

import com.bignerdranch.expandablerecyclerview.model.Parent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ExpandableWrapper<P extends Parent<C>, C> {

    /* JADX INFO: renamed from: a */
    private P f4660a;

    /* JADX INFO: renamed from: b */
    private C f4661b;

    /* JADX INFO: renamed from: c */
    private boolean f4662c = true;

    /* JADX INFO: renamed from: d */
    private boolean f4663d = false;

    /* JADX INFO: renamed from: e */
    private List<ExpandableWrapper<P, C>> f4664e;

    public ExpandableWrapper(P p) {
        this.f4660a = p;
        this.f4664e = m5196a(p);
    }

    public ExpandableWrapper(C c) {
        this.f4661b = c;
    }

    /* JADX INFO: renamed from: a */
    public P m5197a() {
        return this.f4660a;
    }

    /* JADX INFO: renamed from: b */
    public C m5199b() {
        return this.f4661b;
    }

    /* JADX INFO: renamed from: c */
    public boolean m5200c() {
        return this.f4663d;
    }

    /* JADX INFO: renamed from: a */
    public void m5198a(boolean z) {
        this.f4663d = z;
    }

    /* JADX INFO: renamed from: d */
    public boolean m5201d() {
        return this.f4662c;
    }

    /* JADX INFO: renamed from: e */
    public List<ExpandableWrapper<P, C>> m5202e() {
        if (!this.f4662c) {
            throw new IllegalStateException("Parent not wrapped");
        }
        return this.f4664e;
    }

    /* JADX INFO: renamed from: a */
    private List<ExpandableWrapper<P, C>> m5196a(P p) {
        ArrayList arrayList = new ArrayList();
        Iterator<C> it = p.mo5203a().iterator();
        while (it.hasNext()) {
            arrayList.add(new ExpandableWrapper(it.next()));
        }
        return arrayList;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ExpandableWrapper expandableWrapper = (ExpandableWrapper) obj;
        if (this.f4660a == null ? expandableWrapper.f4660a != null : !this.f4660a.equals(expandableWrapper.f4660a)) {
            return false;
        }
        return this.f4661b != null ? this.f4661b.equals(expandableWrapper.f4661b) : expandableWrapper.f4661b == null;
    }

    public int hashCode() {
        return ((this.f4660a != null ? this.f4660a.hashCode() : 0) * 31) + (this.f4661b != null ? this.f4661b.hashCode() : 0);
    }
}
