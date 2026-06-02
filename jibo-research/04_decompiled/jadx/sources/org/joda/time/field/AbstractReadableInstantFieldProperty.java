package org.joda.time.field;

import java.io.Serializable;
import java.util.Locale;
import org.joda.time.Chronology;
import org.joda.time.DateTimeField;
import org.joda.time.DateTimeFieldType;

/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractReadableInstantFieldProperty implements Serializable {
    /* JADX INFO: renamed from: a */
    public abstract DateTimeField mo16599a();

    /* JADX INFO: renamed from: b */
    protected abstract long mo16601b();

    /* JADX INFO: renamed from: d */
    public DateTimeFieldType m16739d() {
        return mo16599a().mo16442a();
    }

    /* JADX INFO: renamed from: e */
    public String m16740e() {
        return mo16599a().mo16444b();
    }

    /* JADX INFO: renamed from: c */
    protected Chronology mo16602c() {
        throw new UnsupportedOperationException("The method getChronology() was added in v1.4 and needs to be implemented by subclasses of AbstractReadableInstantFieldProperty");
    }

    /* JADX INFO: renamed from: f */
    public int m16741f() {
        return mo16599a().mo16434a(mo16601b());
    }

    /* JADX INFO: renamed from: a */
    public String m16736a(Locale locale) {
        return mo16599a().mo16440a(mo16601b(), locale);
    }

    /* JADX INFO: renamed from: b */
    public String m16737b(Locale locale) {
        return mo16599a().mo16446b(mo16601b(), locale);
    }

    /* JADX INFO: renamed from: g */
    public int m16742g() {
        return mo16599a().mo16458g();
    }

    /* JADX INFO: renamed from: h */
    public int m16743h() {
        return mo16599a().mo16460h();
    }

    /* JADX INFO: renamed from: c */
    public int m16738c(Locale locale) {
        return mo16599a().mo16435a(locale);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AbstractReadableInstantFieldProperty)) {
            return false;
        }
        AbstractReadableInstantFieldProperty abstractReadableInstantFieldProperty = (AbstractReadableInstantFieldProperty) obj;
        return m16741f() == abstractReadableInstantFieldProperty.m16741f() && m16739d().equals(abstractReadableInstantFieldProperty.m16739d()) && FieldUtils.m16757a(mo16602c(), abstractReadableInstantFieldProperty.mo16602c());
    }

    public int hashCode() {
        return (m16741f() * 17) + m16739d().hashCode() + mo16602c().hashCode();
    }

    public String toString() {
        return "Property[" + m16740e() + "]";
    }
}
