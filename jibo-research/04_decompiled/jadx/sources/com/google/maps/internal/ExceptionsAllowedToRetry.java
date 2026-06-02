package com.google.maps.internal;

import com.google.maps.errors.ApiException;
import java.util.HashSet;

/* JADX INFO: loaded from: classes.dex */
public final class ExceptionsAllowedToRetry extends HashSet<Class<? extends ApiException>> {
    @Override // java.util.AbstractCollection
    public String toString() {
        StringBuilder sbAppend = new StringBuilder().append("ExceptionsAllowedToRetry[");
        Object[] array = toArray();
        for (int i = 0; i < array.length; i++) {
            sbAppend.append(array[i]);
            if (i < array.length - 1) {
                sbAppend.append(", ");
            }
        }
        sbAppend.append(']');
        return sbAppend.toString();
    }
}
