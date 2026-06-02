package com.google.android.gms.internal;

import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.common.util.zzb;
import com.google.android.gms.common.util.zzo;
import com.google.android.gms.common.util.zzp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzbgn {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: a */
    protected static <O, I> I m7780a(zzbgo<I, O> zzbgoVar, Object obj) {
        return ((zzbgo) zzbgoVar).f6959k != null ? zzbgoVar.m7794a(obj) : obj;
    }

    /* JADX INFO: renamed from: a */
    private static void m7781a(StringBuilder sb, zzbgo zzbgoVar, Object obj) {
        if (zzbgoVar.f6949a == 11) {
            sb.append(zzbgoVar.f6955g.cast(obj).toString());
        } else {
            if (zzbgoVar.f6949a != 7) {
                sb.append(obj);
                return;
            }
            sb.append("\"");
            sb.append(zzo.m7508a((String) obj));
            sb.append("\"");
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m7782a(StringBuilder sb, zzbgo zzbgoVar, ArrayList<Object> arrayList) {
        sb.append("[");
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                sb.append(",");
            }
            Object obj = arrayList.get(i);
            if (obj != null) {
                m7781a(sb, zzbgoVar, obj);
            }
        }
        sb.append("]");
    }

    /* JADX INFO: renamed from: a */
    protected abstract Object mo7783a(String str);

    /* JADX INFO: renamed from: a */
    public abstract Map<String, zzbgo<?, ?>> mo6679a();

    /* JADX INFO: renamed from: a */
    protected boolean mo6680a(zzbgo zzbgoVar) {
        if (zzbgoVar.f6951c != 11) {
            return mo7784b(zzbgoVar.f6953e);
        }
        if (zzbgoVar.f6952d) {
            String str = zzbgoVar.f6953e;
            throw new UnsupportedOperationException("Concrete type arrays not supported");
        }
        String str2 = zzbgoVar.f6953e;
        throw new UnsupportedOperationException("Concrete types not supported");
    }

    /* JADX INFO: renamed from: b */
    protected Object mo6681b(zzbgo zzbgoVar) {
        String str = zzbgoVar.f6953e;
        if (zzbgoVar.f6955g == null) {
            return mo7783a(zzbgoVar.f6953e);
        }
        mo7783a(zzbgoVar.f6953e);
        zzbq.m7380a(true, "Concrete field shouldn't be value object: %s", zzbgoVar.f6953e);
        boolean z = zzbgoVar.f6952d;
        try {
            char upperCase = Character.toUpperCase(str.charAt(0));
            String strSubstring = str.substring(1);
            return getClass().getMethod(new StringBuilder(String.valueOf(strSubstring).length() + 4).append("get").append(upperCase).append(strSubstring).toString(), new Class[0]).invoke(this, new Object[0]);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /* JADX INFO: renamed from: b */
    protected abstract boolean mo7784b(String str);

    public String toString() {
        Map<String, zzbgo<?, ?>> mapMo6679a = mo6679a();
        StringBuilder sb = new StringBuilder(100);
        for (String str : mapMo6679a.keySet()) {
            zzbgo<?, ?> zzbgoVar = mapMo6679a.get(str);
            if (mo6680a(zzbgoVar)) {
                Object objM7780a = m7780a(zzbgoVar, mo6681b(zzbgoVar));
                if (sb.length() == 0) {
                    sb.append("{");
                } else {
                    sb.append(",");
                }
                sb.append("\"").append(str).append("\":");
                if (objM7780a != null) {
                    switch (zzbgoVar.f6951c) {
                        case 8:
                            sb.append("\"").append(zzb.m7493a((byte[]) objM7780a)).append("\"");
                            break;
                        case 9:
                            sb.append("\"").append(zzb.m7494b((byte[]) objM7780a)).append("\"");
                            break;
                        case 10:
                            zzp.m7509a(sb, (HashMap) objM7780a);
                            break;
                        default:
                            if (zzbgoVar.f6950b) {
                                m7782a(sb, (zzbgo) zzbgoVar, (ArrayList<Object>) objM7780a);
                            } else {
                                m7781a(sb, zzbgoVar, objM7780a);
                            }
                            break;
                    }
                } else {
                    sb.append("null");
                }
            }
        }
        if (sb.length() > 0) {
            sb.append("}");
        } else {
            sb.append("{}");
        }
        return sb.toString();
    }
}
