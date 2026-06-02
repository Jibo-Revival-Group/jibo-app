package com.google.gson;

import com.google.gson.reflect.TypeToken;

/* JADX INFO: loaded from: classes.dex */
public interface TypeAdapterFactory {
    /* JADX INFO: renamed from: a */
    <T> TypeAdapter<T> mo9423a(Gson gson, TypeToken<T> typeToken);
}
