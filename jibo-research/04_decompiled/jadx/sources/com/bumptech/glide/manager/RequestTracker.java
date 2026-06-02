package com.bumptech.glide.manager;

import com.bumptech.glide.request.Request;
import com.bumptech.glide.util.Util;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public class RequestTracker {

    /* JADX INFO: renamed from: a */
    private final Set<Request> f4912a = Collections.newSetFromMap(new WeakHashMap());

    /* JADX INFO: renamed from: b */
    private final List<Request> f4913b = new ArrayList();

    /* JADX INFO: renamed from: c */
    private boolean f4914c;

    /* JADX INFO: renamed from: a */
    public void m5480a(Request request) {
        this.f4912a.add(request);
        if (!this.f4914c) {
            request.mo5519b();
        } else {
            this.f4913b.add(request);
        }
    }

    /* JADX INFO: renamed from: b */
    public void m5482b(Request request) {
        this.f4912a.remove(request);
        this.f4913b.remove(request);
    }

    /* JADX INFO: renamed from: a */
    public void m5479a() {
        this.f4914c = true;
        for (Request request : Util.m5590a(this.f4912a)) {
            if (request.mo5523f()) {
                request.mo5522e();
                this.f4913b.add(request);
            }
        }
    }

    /* JADX INFO: renamed from: b */
    public void m5481b() {
        this.f4914c = false;
        for (Request request : Util.m5590a(this.f4912a)) {
            if (!request.mo5524g() && !request.mo5526i() && !request.mo5523f()) {
                request.mo5519b();
            }
        }
        this.f4913b.clear();
    }

    /* JADX INFO: renamed from: c */
    public void m5483c() {
        Iterator it = Util.m5590a(this.f4912a).iterator();
        while (it.hasNext()) {
            ((Request) it.next()).mo5521d();
        }
        this.f4913b.clear();
    }

    /* JADX INFO: renamed from: d */
    public void m5484d() {
        for (Request request : Util.m5590a(this.f4912a)) {
            if (!request.mo5524g() && !request.mo5526i()) {
                request.mo5522e();
                if (!this.f4914c) {
                    request.mo5519b();
                } else {
                    this.f4913b.add(request);
                }
            }
        }
    }
}
