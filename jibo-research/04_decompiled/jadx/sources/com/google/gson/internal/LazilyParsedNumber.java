package com.google.gson.internal;

import java.io.ObjectStreamException;
import java.math.BigDecimal;

/* JADX INFO: loaded from: classes.dex */
public final class LazilyParsedNumber extends Number {

    /* JADX INFO: renamed from: a */
    private final String f8869a;

    public LazilyParsedNumber(String str) {
        this.f8869a = str;
    }

    @Override // java.lang.Number
    public int intValue() {
        try {
            return Integer.parseInt(this.f8869a);
        } catch (NumberFormatException e) {
            try {
                return (int) Long.parseLong(this.f8869a);
            } catch (NumberFormatException e2) {
                return new BigDecimal(this.f8869a).intValue();
            }
        }
    }

    @Override // java.lang.Number
    public long longValue() {
        try {
            return Long.parseLong(this.f8869a);
        } catch (NumberFormatException e) {
            return new BigDecimal(this.f8869a).longValue();
        }
    }

    @Override // java.lang.Number
    public float floatValue() {
        return Float.parseFloat(this.f8869a);
    }

    @Override // java.lang.Number
    public double doubleValue() {
        return Double.parseDouble(this.f8869a);
    }

    public String toString() {
        return this.f8869a;
    }

    private Object writeReplace() throws ObjectStreamException {
        return new BigDecimal(this.f8869a);
    }

    public int hashCode() {
        return this.f8869a.hashCode();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LazilyParsedNumber)) {
            return false;
        }
        LazilyParsedNumber lazilyParsedNumber = (LazilyParsedNumber) obj;
        return this.f8869a == lazilyParsedNumber.f8869a || this.f8869a.equals(lazilyParsedNumber.f8869a);
    }
}
