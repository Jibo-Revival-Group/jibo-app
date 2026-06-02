package com.google.gson;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class JsonArray extends JsonElement implements Iterable<JsonElement> {

    /* JADX INFO: renamed from: a */
    private final List<JsonElement> f8818a = new ArrayList();

    /* JADX INFO: renamed from: a */
    public void m9383a(JsonElement jsonElement) {
        if (jsonElement == null) {
            jsonElement = JsonNull.f8819a;
        }
        this.f8818a.add(jsonElement);
    }

    /* JADX INFO: renamed from: a */
    public int m9381a() {
        return this.f8818a.size();
    }

    @Override // java.lang.Iterable
    public Iterator<JsonElement> iterator() {
        return this.f8818a.iterator();
    }

    /* JADX INFO: renamed from: a */
    public JsonElement m9382a(int i) {
        return this.f8818a.get(i);
    }

    @Override // com.google.gson.JsonElement
    /* JADX INFO: renamed from: b */
    public Number mo9384b() {
        if (this.f8818a.size() == 1) {
            return this.f8818a.get(0).mo9384b();
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.JsonElement
    /* JADX INFO: renamed from: c */
    public String mo9385c() {
        if (this.f8818a.size() == 1) {
            return this.f8818a.get(0).mo9385c();
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.JsonElement
    /* JADX INFO: renamed from: d */
    public double mo9386d() {
        if (this.f8818a.size() == 1) {
            return this.f8818a.get(0).mo9386d();
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.JsonElement
    /* JADX INFO: renamed from: e */
    public long mo9387e() {
        if (this.f8818a.size() == 1) {
            return this.f8818a.get(0).mo9387e();
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.JsonElement
    /* JADX INFO: renamed from: f */
    public int mo9388f() {
        if (this.f8818a.size() == 1) {
            return this.f8818a.get(0).mo9388f();
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.JsonElement
    /* JADX INFO: renamed from: g */
    public boolean mo9389g() {
        if (this.f8818a.size() == 1) {
            return this.f8818a.get(0).mo9389g();
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof JsonArray) && ((JsonArray) obj).f8818a.equals(this.f8818a));
    }

    public int hashCode() {
        return this.f8818a.hashCode();
    }
}
