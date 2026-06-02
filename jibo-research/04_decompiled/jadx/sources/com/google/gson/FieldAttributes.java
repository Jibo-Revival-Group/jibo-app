package com.google.gson;

import com.google.gson.internal.C$Gson$Preconditions;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes.dex */
public final class FieldAttributes {

    /* JADX INFO: renamed from: a */
    private final Field f8783a;

    public FieldAttributes(Field field) {
        C$Gson$Preconditions.m9432a(field);
        this.f8783a = field;
    }
}
