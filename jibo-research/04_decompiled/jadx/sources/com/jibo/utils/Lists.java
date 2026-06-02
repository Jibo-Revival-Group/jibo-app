package com.jibo.utils;

import java.util.ArrayList;
import java.util.Collections;

/* JADX INFO: loaded from: classes.dex */
public class Lists {
    /* JADX INFO: renamed from: a */
    public static <E> ArrayList<E> m11403a() {
        return new ArrayList<>();
    }

    /* JADX INFO: renamed from: a */
    public static <E> ArrayList<E> m11404a(E... eArr) {
        ArrayList<E> arrayList = new ArrayList<>(((eArr.length * 110) / 100) + 5);
        Collections.addAll(arrayList, eArr);
        return arrayList;
    }
}
