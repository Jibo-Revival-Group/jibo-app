package com.google.gson.internal;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.Since;
import com.google.gson.annotations.Until;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class Excluder implements TypeAdapterFactory, Cloneable {

    /* JADX INFO: renamed from: a */
    public static final Excluder f8855a = new Excluder();

    /* JADX INFO: renamed from: e */
    private boolean f8859e;

    /* JADX INFO: renamed from: b */
    private double f8856b = -1.0d;

    /* JADX INFO: renamed from: c */
    private int f8857c = 136;

    /* JADX INFO: renamed from: d */
    private boolean f8858d = true;

    /* JADX INFO: renamed from: f */
    private List<ExclusionStrategy> f8860f = Collections.emptyList();

    /* JADX INFO: renamed from: g */
    private List<ExclusionStrategy> f8861g = Collections.emptyList();

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Excluder clone() {
        try {
            return (Excluder) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    @Override // com.google.gson.TypeAdapterFactory
    /* JADX INFO: renamed from: a */
    public <T> TypeAdapter<T> mo9423a(final Gson gson, final TypeToken<T> typeToken) {
        Class<? super T> rawType = typeToken.getRawType();
        final boolean zM9467a = m9467a((Class<?>) rawType, true);
        final boolean zM9467a2 = m9467a((Class<?>) rawType, false);
        if (zM9467a || zM9467a2) {
            return new TypeAdapter<T>() { // from class: com.google.gson.internal.Excluder.1

                /* JADX INFO: renamed from: f */
                private TypeAdapter<T> f8867f;

                @Override // com.google.gson.TypeAdapter
                public T read(JsonReader jsonReader) throws IOException {
                    if (!zM9467a2) {
                        return m9469a().read(jsonReader);
                    }
                    jsonReader.mo9519n();
                    return null;
                }

                @Override // com.google.gson.TypeAdapter
                public void write(JsonWriter jsonWriter, T t) throws IOException {
                    if (zM9467a) {
                        jsonWriter.mo9535f();
                    } else {
                        m9469a().write(jsonWriter, t);
                    }
                }

                /* JADX INFO: renamed from: a */
                private TypeAdapter<T> m9469a() {
                    TypeAdapter<T> typeAdapter = this.f8867f;
                    if (typeAdapter != null) {
                        return typeAdapter;
                    }
                    TypeAdapter<T> typeAdapterM9345a = gson.m9345a(Excluder.this, typeToken);
                    this.f8867f = typeAdapterM9345a;
                    return typeAdapterM9345a;
                }
            };
        }
        return null;
    }

    /* JADX INFO: renamed from: a */
    public boolean m9468a(Field field, boolean z) {
        Expose expose;
        if ((this.f8857c & field.getModifiers()) != 0) {
            return true;
        }
        if ((this.f8856b == -1.0d || m9461a((Since) field.getAnnotation(Since.class), (Until) field.getAnnotation(Until.class))) && !field.isSynthetic()) {
            if (this.f8859e && ((expose = (Expose) field.getAnnotation(Expose.class)) == null || (!z ? expose.m9425b() : expose.m9424a()))) {
                return true;
            }
            if ((this.f8858d || !m9464b(field.getType())) && !m9463a(field.getType())) {
                List<ExclusionStrategy> list = z ? this.f8860f : this.f8861g;
                if (!list.isEmpty()) {
                    FieldAttributes fieldAttributes = new FieldAttributes(field);
                    Iterator<ExclusionStrategy> it = list.iterator();
                    while (it.hasNext()) {
                        if (it.next().m9334a(fieldAttributes)) {
                            return true;
                        }
                    }
                }
                return false;
            }
            return true;
        }
        return true;
    }

    /* JADX INFO: renamed from: a */
    public boolean m9467a(Class<?> cls, boolean z) {
        if (this.f8856b != -1.0d && !m9461a((Since) cls.getAnnotation(Since.class), (Until) cls.getAnnotation(Until.class))) {
            return true;
        }
        if ((this.f8858d || !m9464b(cls)) && !m9463a(cls)) {
            Iterator<ExclusionStrategy> it = (z ? this.f8860f : this.f8861g).iterator();
            while (it.hasNext()) {
                if (it.next().m9335a(cls)) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    /* JADX INFO: renamed from: a */
    private boolean m9463a(Class<?> cls) {
        return !Enum.class.isAssignableFrom(cls) && (cls.isAnonymousClass() || cls.isLocalClass());
    }

    /* JADX INFO: renamed from: b */
    private boolean m9464b(Class<?> cls) {
        return cls.isMemberClass() && !m9465c(cls);
    }

    /* JADX INFO: renamed from: c */
    private boolean m9465c(Class<?> cls) {
        return (cls.getModifiers() & 8) != 0;
    }

    /* JADX INFO: renamed from: a */
    private boolean m9461a(Since since, Until until) {
        return m9460a(since) && m9462a(until);
    }

    /* JADX INFO: renamed from: a */
    private boolean m9460a(Since since) {
        return since == null || since.m9430a() <= this.f8856b;
    }

    /* JADX INFO: renamed from: a */
    private boolean m9462a(Until until) {
        return until == null || until.m9431a() > this.f8856b;
    }
}
