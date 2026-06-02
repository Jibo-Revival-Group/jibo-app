package com.google.gson;

import com.google.gson.internal.C$Gson$Preconditions;
import com.google.gson.internal.Excluder;
import com.google.gson.internal.bind.TreeTypeAdapter;
import com.google.gson.internal.bind.TypeAdapters;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class GsonBuilder {

    /* JADX INFO: renamed from: h */
    private String f8809h;

    /* JADX INFO: renamed from: a */
    private Excluder f8802a = Excluder.f8855a;

    /* JADX INFO: renamed from: b */
    private LongSerializationPolicy f8803b = LongSerializationPolicy.DEFAULT;

    /* JADX INFO: renamed from: c */
    private FieldNamingStrategy f8804c = FieldNamingPolicy.IDENTITY;

    /* JADX INFO: renamed from: d */
    private final Map<Type, InstanceCreator<?>> f8805d = new HashMap();

    /* JADX INFO: renamed from: e */
    private final List<TypeAdapterFactory> f8806e = new ArrayList();

    /* JADX INFO: renamed from: f */
    private final List<TypeAdapterFactory> f8807f = new ArrayList();

    /* JADX INFO: renamed from: g */
    private boolean f8808g = false;

    /* JADX INFO: renamed from: i */
    private int f8810i = 2;

    /* JADX INFO: renamed from: j */
    private int f8811j = 2;

    /* JADX INFO: renamed from: k */
    private boolean f8812k = false;

    /* JADX INFO: renamed from: l */
    private boolean f8813l = false;

    /* JADX INFO: renamed from: m */
    private boolean f8814m = true;

    /* JADX INFO: renamed from: n */
    private boolean f8815n = false;

    /* JADX INFO: renamed from: o */
    private boolean f8816o = false;

    /* JADX INFO: renamed from: p */
    private boolean f8817p = false;

    /* JADX INFO: renamed from: a */
    public GsonBuilder m9377a(FieldNamingPolicy fieldNamingPolicy) {
        this.f8804c = fieldNamingPolicy;
        return this;
    }

    /* JADX INFO: renamed from: a */
    public GsonBuilder m9379a(String str) {
        this.f8809h = str;
        return this;
    }

    /* JADX INFO: renamed from: a */
    public GsonBuilder m9380a(Type type, Object obj) {
        C$Gson$Preconditions.m9433a((obj instanceof JsonSerializer) || (obj instanceof JsonDeserializer) || (obj instanceof InstanceCreator) || (obj instanceof TypeAdapter));
        if (obj instanceof InstanceCreator) {
            this.f8805d.put(type, (InstanceCreator) obj);
        }
        if ((obj instanceof JsonSerializer) || (obj instanceof JsonDeserializer)) {
            this.f8806e.add(TreeTypeAdapter.m9553a(TypeToken.get(type), obj));
        }
        if (obj instanceof TypeAdapter) {
            this.f8806e.add(TypeAdapters.m9556a(TypeToken.get(type), (TypeAdapter) obj));
        }
        return this;
    }

    /* JADX INFO: renamed from: a */
    public GsonBuilder m9378a(Class<?> cls, Object obj) {
        C$Gson$Preconditions.m9433a((obj instanceof JsonSerializer) || (obj instanceof JsonDeserializer) || (obj instanceof TypeAdapter));
        if ((obj instanceof JsonDeserializer) || (obj instanceof JsonSerializer)) {
            this.f8807f.add(TreeTypeAdapter.m9554a(cls, obj));
        }
        if (obj instanceof TypeAdapter) {
            this.f8806e.add(TypeAdapters.m9559b(cls, (TypeAdapter) obj));
        }
        return this;
    }

    /* JADX INFO: renamed from: a */
    public Gson m9376a() {
        List<TypeAdapterFactory> arrayList = new ArrayList<>(this.f8806e.size() + this.f8807f.size() + 3);
        arrayList.addAll(this.f8806e);
        Collections.reverse(arrayList);
        ArrayList arrayList2 = new ArrayList(this.f8807f);
        Collections.reverse(arrayList2);
        arrayList.addAll(arrayList2);
        m9375a(this.f8809h, this.f8810i, this.f8811j, arrayList);
        return new Gson(this.f8802a, this.f8804c, this.f8805d, this.f8808g, this.f8812k, this.f8816o, this.f8814m, this.f8815n, this.f8817p, this.f8813l, this.f8803b, arrayList);
    }

    /* JADX INFO: renamed from: a */
    private void m9375a(String str, int i, int i2, List<TypeAdapterFactory> list) {
        DefaultDateTypeAdapter defaultDateTypeAdapter;
        DefaultDateTypeAdapter defaultDateTypeAdapter2;
        DefaultDateTypeAdapter defaultDateTypeAdapter3;
        if (str != null && !"".equals(str.trim())) {
            defaultDateTypeAdapter = new DefaultDateTypeAdapter(Date.class, str);
            defaultDateTypeAdapter2 = new DefaultDateTypeAdapter(Timestamp.class, str);
            defaultDateTypeAdapter3 = new DefaultDateTypeAdapter(java.sql.Date.class, str);
        } else if (i != 2 && i2 != 2) {
            defaultDateTypeAdapter = new DefaultDateTypeAdapter((Class<? extends Date>) Date.class, i, i2);
            defaultDateTypeAdapter2 = new DefaultDateTypeAdapter((Class<? extends Date>) Timestamp.class, i, i2);
            defaultDateTypeAdapter3 = new DefaultDateTypeAdapter((Class<? extends Date>) java.sql.Date.class, i, i2);
        } else {
            return;
        }
        list.add(TypeAdapters.m9557a(Date.class, defaultDateTypeAdapter));
        list.add(TypeAdapters.m9557a(Timestamp.class, defaultDateTypeAdapter2));
        list.add(TypeAdapters.m9557a(java.sql.Date.class, defaultDateTypeAdapter3));
    }
}
