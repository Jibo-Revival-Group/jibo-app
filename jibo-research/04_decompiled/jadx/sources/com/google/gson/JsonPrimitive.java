package com.google.gson;

import com.google.gson.internal.C$Gson$Preconditions;
import com.google.gson.internal.LazilyParsedNumber;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes.dex */
public final class JsonPrimitive extends JsonElement {

    /* JADX INFO: renamed from: a */
    private static final Class<?>[] f8821a = {Integer.TYPE, Long.TYPE, Short.TYPE, Float.TYPE, Double.TYPE, Byte.TYPE, Boolean.TYPE, Character.TYPE, Integer.class, Long.class, Short.class, Float.class, Double.class, Byte.class, Boolean.class, Character.class};

    /* JADX INFO: renamed from: b */
    private Object f8822b;

    public JsonPrimitive(Boolean bool) {
        m9416a(bool);
    }

    public JsonPrimitive(Number number) {
        m9416a(number);
    }

    public JsonPrimitive(String str) {
        m9416a(str);
    }

    JsonPrimitive(Object obj) {
        m9416a(obj);
    }

    /* JADX INFO: renamed from: a */
    void m9416a(Object obj) {
        if (obj instanceof Character) {
            this.f8822b = String.valueOf(((Character) obj).charValue());
        } else {
            C$Gson$Preconditions.m9433a((obj instanceof Number) || m9415b(obj));
            this.f8822b = obj;
        }
    }

    /* JADX INFO: renamed from: a */
    public boolean m9417a() {
        return this.f8822b instanceof Boolean;
    }

    @Override // com.google.gson.JsonElement
    /* JADX INFO: renamed from: o */
    Boolean mo9398o() {
        return (Boolean) this.f8822b;
    }

    @Override // com.google.gson.JsonElement
    /* JADX INFO: renamed from: g */
    public boolean mo9389g() {
        return m9417a() ? mo9398o().booleanValue() : Boolean.parseBoolean(mo9385c());
    }

    /* JADX INFO: renamed from: p */
    public boolean m9418p() {
        return this.f8822b instanceof Number;
    }

    @Override // com.google.gson.JsonElement
    /* JADX INFO: renamed from: b */
    public Number mo9384b() {
        return this.f8822b instanceof String ? new LazilyParsedNumber((String) this.f8822b) : (Number) this.f8822b;
    }

    /* JADX INFO: renamed from: q */
    public boolean m9419q() {
        return this.f8822b instanceof String;
    }

    @Override // com.google.gson.JsonElement
    /* JADX INFO: renamed from: c */
    public String mo9385c() {
        if (m9418p()) {
            return mo9384b().toString();
        }
        if (m9417a()) {
            return mo9398o().toString();
        }
        return (String) this.f8822b;
    }

    @Override // com.google.gson.JsonElement
    /* JADX INFO: renamed from: d */
    public double mo9386d() {
        return m9418p() ? mo9384b().doubleValue() : Double.parseDouble(mo9385c());
    }

    @Override // com.google.gson.JsonElement
    /* JADX INFO: renamed from: e */
    public long mo9387e() {
        return m9418p() ? mo9384b().longValue() : Long.parseLong(mo9385c());
    }

    @Override // com.google.gson.JsonElement
    /* JADX INFO: renamed from: f */
    public int mo9388f() {
        return m9418p() ? mo9384b().intValue() : Integer.parseInt(mo9385c());
    }

    /* JADX INFO: renamed from: b */
    private static boolean m9415b(Object obj) {
        if (obj instanceof String) {
            return true;
        }
        Class<?> cls = obj.getClass();
        for (Class<?> cls2 : f8821a) {
            if (cls2.isAssignableFrom(cls)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        if (this.f8822b == null) {
            return 31;
        }
        if (m9414a(this)) {
            long jLongValue = mo9384b().longValue();
            return (int) (jLongValue ^ (jLongValue >>> 32));
        }
        if (this.f8822b instanceof Number) {
            long jDoubleToLongBits = Double.doubleToLongBits(mo9384b().doubleValue());
            return (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
        }
        return this.f8822b.hashCode();
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        JsonPrimitive jsonPrimitive = (JsonPrimitive) obj;
        if (this.f8822b == null) {
            return jsonPrimitive.f8822b == null;
        }
        if (m9414a(this) && m9414a(jsonPrimitive)) {
            return mo9384b().longValue() == jsonPrimitive.mo9384b().longValue();
        }
        if ((this.f8822b instanceof Number) && (jsonPrimitive.f8822b instanceof Number)) {
            double dDoubleValue = mo9384b().doubleValue();
            double dDoubleValue2 = jsonPrimitive.mo9384b().doubleValue();
            if (dDoubleValue == dDoubleValue2 || (Double.isNaN(dDoubleValue) && Double.isNaN(dDoubleValue2))) {
                z = true;
            }
            return z;
        }
        return this.f8822b.equals(jsonPrimitive.f8822b);
    }

    /* JADX INFO: renamed from: a */
    private static boolean m9414a(JsonPrimitive jsonPrimitive) {
        if (!(jsonPrimitive.f8822b instanceof Number)) {
            return false;
        }
        Number number = (Number) jsonPrimitive.f8822b;
        return (number instanceof BigInteger) || (number instanceof Long) || (number instanceof Integer) || (number instanceof Short) || (number instanceof Byte);
    }
}
