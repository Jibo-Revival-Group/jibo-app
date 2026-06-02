package com.google.android.gms.internal;

import android.content.ContentValues;
import android.database.sqlite.SQLiteException;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import com.google.android.gms.common.internal.zzbq;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.PatternSyntaxException;

/* JADX INFO: loaded from: classes.dex */
final class zzcgk extends zzcjl {
    zzcgk(zzcim zzcimVar) {
        super(zzcimVar);
    }

    /* JADX INFO: renamed from: a */
    private final Boolean m7927a(double d, zzclu zzcluVar) {
        try {
            return m7934a(new BigDecimal(d), zzcluVar, Math.ulp(d));
        } catch (NumberFormatException e) {
            return null;
        }
    }

    /* JADX INFO: renamed from: a */
    private final Boolean m7928a(long j, zzclu zzcluVar) {
        try {
            return m7934a(new BigDecimal(j), zzcluVar, 0.0d);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: a */
    private final Boolean m7929a(zzcls zzclsVar, zzcmb zzcmbVar, long j) {
        Boolean boolM7932a;
        if (zzclsVar.f7623d != null) {
            Boolean boolM7928a = m7928a(j, zzclsVar.f7623d);
            if (boolM7928a == null) {
                return null;
            }
            if (!boolM7928a.booleanValue()) {
                return false;
            }
        }
        HashSet hashSet = new HashSet();
        for (zzclt zzcltVar : zzclsVar.f7622c) {
            if (TextUtils.isEmpty(zzcltVar.f7629d)) {
                mo7872t().m8097A().m8109a("null or empty param name in filter. event", mo7867o().m8090a(zzcmbVar.f7664b));
                return null;
            }
            hashSet.add(zzcltVar.f7629d);
        }
        ArrayMap arrayMap = new ArrayMap();
        for (zzcmc zzcmcVar : zzcmbVar.f7663a) {
            if (hashSet.contains(zzcmcVar.f7669a)) {
                if (zzcmcVar.f7671c != null) {
                    arrayMap.put(zzcmcVar.f7669a, zzcmcVar.f7671c);
                } else if (zzcmcVar.f7672d != null) {
                    arrayMap.put(zzcmcVar.f7669a, zzcmcVar.f7672d);
                } else {
                    if (zzcmcVar.f7670b == null) {
                        mo7872t().m8097A().m8110a("Unknown value for param. event, param", mo7867o().m8090a(zzcmbVar.f7664b), mo7867o().m8091b(zzcmcVar.f7669a));
                        return null;
                    }
                    arrayMap.put(zzcmcVar.f7669a, zzcmcVar.f7670b);
                }
            }
        }
        for (zzclt zzcltVar2 : zzclsVar.f7622c) {
            boolean zEquals = Boolean.TRUE.equals(zzcltVar2.f7628c);
            String str = zzcltVar2.f7629d;
            if (TextUtils.isEmpty(str)) {
                mo7872t().m8097A().m8109a("Event has empty param name. event", mo7867o().m8090a(zzcmbVar.f7664b));
                return null;
            }
            V v = arrayMap.get(str);
            if (v instanceof Long) {
                if (zzcltVar2.f7627b == null) {
                    mo7872t().m8097A().m8110a("No number filter for long param. event, param", mo7867o().m8090a(zzcmbVar.f7664b), mo7867o().m8091b(str));
                    return null;
                }
                Boolean boolM7928a2 = m7928a(((Long) v).longValue(), zzcltVar2.f7627b);
                if (boolM7928a2 == null) {
                    return null;
                }
                if ((!boolM7928a2.booleanValue()) ^ zEquals) {
                    return false;
                }
            } else if (v instanceof Double) {
                if (zzcltVar2.f7627b == null) {
                    mo7872t().m8097A().m8110a("No number filter for double param. event, param", mo7867o().m8090a(zzcmbVar.f7664b), mo7867o().m8091b(str));
                    return null;
                }
                Boolean boolM7927a = m7927a(((Double) v).doubleValue(), zzcltVar2.f7627b);
                if (boolM7927a == null) {
                    return null;
                }
                if ((!boolM7927a.booleanValue()) ^ zEquals) {
                    return false;
                }
            } else {
                if (!(v instanceof String)) {
                    if (v == 0) {
                        mo7872t().m8101E().m8110a("Missing param for filter. event, param", mo7867o().m8090a(zzcmbVar.f7664b), mo7867o().m8091b(str));
                        return false;
                    }
                    mo7872t().m8097A().m8110a("Unknown param type. event, param", mo7867o().m8090a(zzcmbVar.f7664b), mo7867o().m8091b(str));
                    return null;
                }
                if (zzcltVar2.f7626a != null) {
                    boolM7932a = m7933a((String) v, zzcltVar2.f7626a);
                } else {
                    if (zzcltVar2.f7627b == null) {
                        mo7872t().m8097A().m8110a("No filter for String param. event, param", mo7867o().m8090a(zzcmbVar.f7664b), mo7867o().m8091b(str));
                        return null;
                    }
                    if (!zzclq.m8411k((String) v)) {
                        mo7872t().m8097A().m8110a("Invalid param value for number filter. event, param", mo7867o().m8090a(zzcmbVar.f7664b), mo7867o().m8091b(str));
                        return null;
                    }
                    boolM7932a = m7932a((String) v, zzcltVar2.f7627b);
                }
                if (boolM7932a == null) {
                    return null;
                }
                if ((!boolM7932a.booleanValue()) ^ zEquals) {
                    return false;
                }
            }
        }
        return true;
    }

    /* JADX INFO: renamed from: a */
    private static Boolean m7930a(Boolean bool, boolean z) {
        if (bool == null) {
            return null;
        }
        return Boolean.valueOf(bool.booleanValue() ^ z);
    }

    /* JADX INFO: renamed from: a */
    private final Boolean m7931a(String str, int i, boolean z, String str2, List<String> list, String str3) {
        if (str == null) {
            return null;
        }
        if (i == 6) {
            if (list == null || list.size() == 0) {
                return null;
            }
        } else if (str2 == null) {
            return null;
        }
        if (!z && i != 1) {
            str = str.toUpperCase(Locale.ENGLISH);
        }
        switch (i) {
            case 1:
                try {
                } catch (PatternSyntaxException e) {
                    mo7872t().m8097A().m8109a("Invalid regular expression in REGEXP audience filter. expression", str3);
                    return null;
                }
                break;
        }
        return null;
    }

    /* JADX INFO: renamed from: a */
    private final Boolean m7932a(String str, zzclu zzcluVar) {
        if (!zzclq.m8411k(str)) {
            return null;
        }
        try {
            return m7934a(new BigDecimal(str), zzcluVar, 0.0d);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    /* JADX INFO: renamed from: a */
    private final Boolean m7933a(String str, zzclw zzclwVar) {
        List<String> arrayList;
        zzbq.m7373a(zzclwVar);
        if (str == null || zzclwVar.f7639a == null || zzclwVar.f7639a.intValue() == 0) {
            return null;
        }
        if (zzclwVar.f7639a.intValue() == 6) {
            if (zzclwVar.f7642d == null || zzclwVar.f7642d.length == 0) {
                return null;
            }
        } else if (zzclwVar.f7640b == null) {
            return null;
        }
        int iIntValue = zzclwVar.f7639a.intValue();
        boolean z = zzclwVar.f7641c != null && zzclwVar.f7641c.booleanValue();
        String upperCase = (z || iIntValue == 1 || iIntValue == 6) ? zzclwVar.f7640b : zzclwVar.f7640b.toUpperCase(Locale.ENGLISH);
        if (zzclwVar.f7642d == null) {
            arrayList = null;
        } else {
            String[] strArr = zzclwVar.f7642d;
            if (z) {
                arrayList = Arrays.asList(strArr);
            } else {
                arrayList = new ArrayList<>();
                for (String str2 : strArr) {
                    arrayList.add(str2.toUpperCase(Locale.ENGLISH));
                }
            }
        }
        return m7931a(str, iIntValue, z, upperCase, arrayList, iIntValue == 1 ? upperCase : null);
    }

    /* JADX INFO: renamed from: a */
    private static Boolean m7934a(BigDecimal bigDecimal, zzclu zzcluVar, double d) {
        BigDecimal bigDecimal2;
        BigDecimal bigDecimal3;
        BigDecimal bigDecimal4;
        zzbq.m7373a(zzcluVar);
        if (zzcluVar.f7630a == null || zzcluVar.f7630a.intValue() == 0) {
            return null;
        }
        if (zzcluVar.f7630a.intValue() == 4) {
            if (zzcluVar.f7633d == null || zzcluVar.f7634e == null) {
                return null;
            }
        } else if (zzcluVar.f7632c == null) {
            return null;
        }
        int iIntValue = zzcluVar.f7630a.intValue();
        if (zzcluVar.f7630a.intValue() == 4) {
            if (!zzclq.m8411k(zzcluVar.f7633d) || !zzclq.m8411k(zzcluVar.f7634e)) {
                return null;
            }
            try {
                bigDecimal2 = new BigDecimal(zzcluVar.f7633d);
                bigDecimal4 = new BigDecimal(zzcluVar.f7634e);
                bigDecimal3 = null;
            } catch (NumberFormatException e) {
                return null;
            }
        } else {
            if (!zzclq.m8411k(zzcluVar.f7632c)) {
                return null;
            }
            try {
                bigDecimal2 = null;
                bigDecimal3 = new BigDecimal(zzcluVar.f7632c);
                bigDecimal4 = null;
            } catch (NumberFormatException e2) {
                return null;
            }
        }
        if (iIntValue != 4) {
            if (bigDecimal3 != null) {
            }
            return null;
        }
        if (bigDecimal2 == null) {
            return null;
        }
        switch (iIntValue) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                if (d == 0.0d) {
                }
                break;
            case 4:
                break;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: a */
    final zzcma[] m7935a(String str, zzcmb[] zzcmbVarArr, zzcmg[] zzcmgVarArr) {
        Map<Integer, List<zzclv>> map;
        Boolean boolM7930a;
        zzcgw zzcgwVarM8024a;
        Map<Integer, List<zzcls>> map2;
        zzbq.m7375a(str);
        HashSet hashSet = new HashSet();
        ArrayMap arrayMap = new ArrayMap();
        ArrayMap arrayMap2 = new ArrayMap();
        ArrayMap arrayMap3 = new ArrayMap();
        Map<Integer, zzcmf> mapM8001e = mo7866n().m8001e(str);
        if (mapM8001e != null) {
            Iterator<Integer> it = mapM8001e.keySet().iterator();
            while (it.hasNext()) {
                int iIntValue = it.next().intValue();
                zzcmf zzcmfVar = mapM8001e.get(Integer.valueOf(iIntValue));
                BitSet bitSet = (BitSet) arrayMap2.get(Integer.valueOf(iIntValue));
                BitSet bitSet2 = (BitSet) arrayMap3.get(Integer.valueOf(iIntValue));
                if (bitSet == null) {
                    bitSet = new BitSet();
                    arrayMap2.put(Integer.valueOf(iIntValue), bitSet);
                    bitSet2 = new BitSet();
                    arrayMap3.put(Integer.valueOf(iIntValue), bitSet2);
                }
                for (int i = 0; i < (zzcmfVar.f7711a.length << 6); i++) {
                    if (zzclq.m8399a(zzcmfVar.f7711a, i)) {
                        mo7872t().m8101E().m8110a("Filter already evaluated. audience ID, filter ID", Integer.valueOf(iIntValue), Integer.valueOf(i));
                        bitSet2.set(i);
                        if (zzclq.m8399a(zzcmfVar.f7712b, i)) {
                            bitSet.set(i);
                        }
                    }
                }
                zzcma zzcmaVar = new zzcma();
                arrayMap.put(Integer.valueOf(iIntValue), zzcmaVar);
                zzcmaVar.f7661d = false;
                zzcmaVar.f7660c = zzcmfVar;
                zzcmaVar.f7659b = new zzcmf();
                zzcmaVar.f7659b.f7712b = zzclq.m8401a(bitSet);
                zzcmaVar.f7659b.f7711a = zzclq.m8401a(bitSet2);
            }
        }
        if (zzcmbVarArr != null) {
            ArrayMap arrayMap4 = new ArrayMap();
            int length = zzcmbVarArr.length;
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= length) {
                    break;
                }
                zzcmb zzcmbVar = zzcmbVarArr[i3];
                zzcgw zzcgwVarM7979a = mo7866n().m7979a(str, zzcmbVar.f7664b);
                if (zzcgwVarM7979a == null) {
                    mo7872t().m8097A().m8110a("Event aggregate wasn't created during raw event logging. appId, event", zzchm.m8093a(str), mo7867o().m8090a(zzcmbVar.f7664b));
                    zzcgwVarM8024a = new zzcgw(str, zzcmbVar.f7664b, 1L, 1L, zzcmbVar.f7665c.longValue(), 0L, null, null, null);
                } else {
                    zzcgwVarM8024a = zzcgwVarM7979a.m8024a();
                }
                mo7866n().m7986a(zzcgwVarM8024a);
                long j = zzcgwVarM8024a.f7146c;
                Map<Integer, List<zzcls>> map3 = (Map) arrayMap4.get(zzcmbVar.f7664b);
                if (map3 == null) {
                    Map<Integer, List<zzcls>> mapM8003f = mo7866n().m8003f(str, zzcmbVar.f7664b);
                    if (mapM8003f == null) {
                        mapM8003f = new ArrayMap<>();
                    }
                    arrayMap4.put(zzcmbVar.f7664b, mapM8003f);
                    map2 = mapM8003f;
                } else {
                    map2 = map3;
                }
                Iterator<Integer> it2 = map2.keySet().iterator();
                while (it2.hasNext()) {
                    int iIntValue2 = it2.next().intValue();
                    if (hashSet.contains(Integer.valueOf(iIntValue2))) {
                        mo7872t().m8101E().m8109a("Skipping failed audience ID", Integer.valueOf(iIntValue2));
                    } else {
                        zzcma zzcmaVar2 = (zzcma) arrayMap.get(Integer.valueOf(iIntValue2));
                        BitSet bitSet3 = (BitSet) arrayMap2.get(Integer.valueOf(iIntValue2));
                        BitSet bitSet4 = (BitSet) arrayMap3.get(Integer.valueOf(iIntValue2));
                        if (zzcmaVar2 == null) {
                            zzcma zzcmaVar3 = new zzcma();
                            arrayMap.put(Integer.valueOf(iIntValue2), zzcmaVar3);
                            zzcmaVar3.f7661d = true;
                            bitSet3 = new BitSet();
                            arrayMap2.put(Integer.valueOf(iIntValue2), bitSet3);
                            bitSet4 = new BitSet();
                            arrayMap3.put(Integer.valueOf(iIntValue2), bitSet4);
                        }
                        for (zzcls zzclsVar : map2.get(Integer.valueOf(iIntValue2))) {
                            if (mo7872t().m8105a(2)) {
                                mo7872t().m8101E().m8111a("Evaluating filter. audience, filter, event", Integer.valueOf(iIntValue2), zzclsVar.f7620a, mo7867o().m8090a(zzclsVar.f7621b));
                                mo7872t().m8101E().m8109a("Filter definition", mo7867o().m8087a(zzclsVar));
                            }
                            if (zzclsVar.f7620a == null || zzclsVar.f7620a.intValue() > 256) {
                                mo7872t().m8097A().m8110a("Invalid event filter ID. appId, id", zzchm.m8093a(str), String.valueOf(zzclsVar.f7620a));
                            } else if (bitSet3.get(zzclsVar.f7620a.intValue())) {
                                mo7872t().m8101E().m8110a("Event filter already evaluated true. audience ID, filter ID", Integer.valueOf(iIntValue2), zzclsVar.f7620a);
                            } else {
                                Boolean boolM7929a = m7929a(zzclsVar, zzcmbVar, j);
                                mo7872t().m8101E().m8109a("Event filter result", boolM7929a == null ? "null" : boolM7929a);
                                if (boolM7929a == null) {
                                    hashSet.add(Integer.valueOf(iIntValue2));
                                } else {
                                    bitSet4.set(zzclsVar.f7620a.intValue());
                                    if (boolM7929a.booleanValue()) {
                                        bitSet3.set(zzclsVar.f7620a.intValue());
                                    }
                                }
                            }
                        }
                    }
                }
                i2 = i3 + 1;
            }
        }
        if (zzcmgVarArr != null) {
            ArrayMap arrayMap5 = new ArrayMap();
            for (zzcmg zzcmgVar : zzcmgVarArr) {
                Map<Integer, List<zzclv>> map4 = (Map) arrayMap5.get(zzcmgVar.f7715b);
                if (map4 == null) {
                    Map<Integer, List<zzclv>> mapM8004g = mo7866n().m8004g(str, zzcmgVar.f7715b);
                    if (mapM8004g == null) {
                        mapM8004g = new ArrayMap<>();
                    }
                    arrayMap5.put(zzcmgVar.f7715b, mapM8004g);
                    map = mapM8004g;
                } else {
                    map = map4;
                }
                Iterator<Integer> it3 = map.keySet().iterator();
                while (it3.hasNext()) {
                    int iIntValue3 = it3.next().intValue();
                    if (hashSet.contains(Integer.valueOf(iIntValue3))) {
                        mo7872t().m8101E().m8109a("Skipping failed audience ID", Integer.valueOf(iIntValue3));
                    } else {
                        zzcma zzcmaVar4 = (zzcma) arrayMap.get(Integer.valueOf(iIntValue3));
                        BitSet bitSet5 = (BitSet) arrayMap2.get(Integer.valueOf(iIntValue3));
                        BitSet bitSet6 = (BitSet) arrayMap3.get(Integer.valueOf(iIntValue3));
                        if (zzcmaVar4 == null) {
                            zzcma zzcmaVar5 = new zzcma();
                            arrayMap.put(Integer.valueOf(iIntValue3), zzcmaVar5);
                            zzcmaVar5.f7661d = true;
                            bitSet5 = new BitSet();
                            arrayMap2.put(Integer.valueOf(iIntValue3), bitSet5);
                            bitSet6 = new BitSet();
                            arrayMap3.put(Integer.valueOf(iIntValue3), bitSet6);
                        }
                        for (zzclv zzclvVar : map.get(Integer.valueOf(iIntValue3))) {
                            if (mo7872t().m8105a(2)) {
                                mo7872t().m8101E().m8111a("Evaluating filter. audience, filter, property", Integer.valueOf(iIntValue3), zzclvVar.f7636a, mo7867o().m8092c(zzclvVar.f7637b));
                                mo7872t().m8101E().m8109a("Filter definition", mo7867o().m8088a(zzclvVar));
                            }
                            if (zzclvVar.f7636a == null || zzclvVar.f7636a.intValue() > 256) {
                                mo7872t().m8097A().m8110a("Invalid property filter ID. appId, id", zzchm.m8093a(str), String.valueOf(zzclvVar.f7636a));
                                hashSet.add(Integer.valueOf(iIntValue3));
                                break;
                            }
                            if (bitSet5.get(zzclvVar.f7636a.intValue())) {
                                mo7872t().m8101E().m8110a("Property filter already evaluated true. audience ID, filter ID", Integer.valueOf(iIntValue3), zzclvVar.f7636a);
                            } else {
                                zzclt zzcltVar = zzclvVar.f7638c;
                                if (zzcltVar == null) {
                                    mo7872t().m8097A().m8109a("Missing property filter. property", mo7867o().m8092c(zzcmgVar.f7715b));
                                    boolM7930a = null;
                                } else {
                                    boolean zEquals = Boolean.TRUE.equals(zzcltVar.f7628c);
                                    if (zzcmgVar.f7717d != null) {
                                        if (zzcltVar.f7627b == null) {
                                            mo7872t().m8097A().m8109a("No number filter for long property. property", mo7867o().m8092c(zzcmgVar.f7715b));
                                            boolM7930a = null;
                                        } else {
                                            boolM7930a = m7930a(m7928a(zzcmgVar.f7717d.longValue(), zzcltVar.f7627b), zEquals);
                                        }
                                    } else if (zzcmgVar.f7718e != null) {
                                        if (zzcltVar.f7627b == null) {
                                            mo7872t().m8097A().m8109a("No number filter for double property. property", mo7867o().m8092c(zzcmgVar.f7715b));
                                            boolM7930a = null;
                                        } else {
                                            boolM7930a = m7930a(m7927a(zzcmgVar.f7718e.doubleValue(), zzcltVar.f7627b), zEquals);
                                        }
                                    } else if (zzcmgVar.f7716c == null) {
                                        mo7872t().m8097A().m8109a("User property has no value, property", mo7867o().m8092c(zzcmgVar.f7715b));
                                        boolM7930a = null;
                                    } else if (zzcltVar.f7626a == null) {
                                        if (zzcltVar.f7627b == null) {
                                            mo7872t().m8097A().m8109a("No string or number filter defined. property", mo7867o().m8092c(zzcmgVar.f7715b));
                                        } else if (zzclq.m8411k(zzcmgVar.f7716c)) {
                                            boolM7930a = m7930a(m7932a(zzcmgVar.f7716c, zzcltVar.f7627b), zEquals);
                                        } else {
                                            mo7872t().m8097A().m8110a("Invalid user property value for Numeric number filter. property, value", mo7867o().m8092c(zzcmgVar.f7715b), zzcmgVar.f7716c);
                                        }
                                        boolM7930a = null;
                                    } else {
                                        boolM7930a = m7930a(m7933a(zzcmgVar.f7716c, zzcltVar.f7626a), zEquals);
                                    }
                                }
                                mo7872t().m8101E().m8109a("Property filter result", boolM7930a == null ? "null" : boolM7930a);
                                if (boolM7930a == null) {
                                    hashSet.add(Integer.valueOf(iIntValue3));
                                } else {
                                    bitSet6.set(zzclvVar.f7636a.intValue());
                                    if (boolM7930a.booleanValue()) {
                                        bitSet5.set(zzclvVar.f7636a.intValue());
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        zzcma[] zzcmaVarArr = new zzcma[arrayMap2.size()];
        Iterator it4 = arrayMap2.keySet().iterator();
        int i4 = 0;
        while (it4.hasNext()) {
            int iIntValue4 = ((Integer) it4.next()).intValue();
            if (!hashSet.contains(Integer.valueOf(iIntValue4))) {
                zzcma zzcmaVar6 = (zzcma) arrayMap.get(Integer.valueOf(iIntValue4));
                zzcma zzcmaVar7 = zzcmaVar6 == null ? new zzcma() : zzcmaVar6;
                int i5 = i4 + 1;
                zzcmaVarArr[i4] = zzcmaVar7;
                zzcmaVar7.f7658a = Integer.valueOf(iIntValue4);
                zzcmaVar7.f7659b = new zzcmf();
                zzcmaVar7.f7659b.f7712b = zzclq.m8401a((BitSet) arrayMap2.get(Integer.valueOf(iIntValue4)));
                zzcmaVar7.f7659b.f7711a = zzclq.m8401a((BitSet) arrayMap3.get(Integer.valueOf(iIntValue4)));
                zzcgo zzcgoVarMo7866n = mo7866n();
                zzcmf zzcmfVar2 = zzcmaVar7.f7659b;
                zzcgoVarMo7866n.m8259Q();
                zzcgoVarMo7866n.mo7855c();
                zzbq.m7375a(str);
                zzbq.m7373a(zzcmfVar2);
                try {
                    byte[] bArr = new byte[zzcmfVar2.m8713f()];
                    zzfjk zzfjkVarM8648a = zzfjk.m8648a(bArr, 0, bArr.length);
                    zzcmfVar2.mo8447a(zzfjkVarM8648a);
                    zzfjkVarM8648a.m8664a();
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("app_id", str);
                    contentValues.put("audience_id", Integer.valueOf(iIntValue4));
                    contentValues.put("current_results", bArr);
                    try {
                        if (zzcgoVarMo7866n.m7968A().insertWithOnConflict("audience_filter_values", null, contentValues, 5) == -1) {
                            zzcgoVarMo7866n.mo7872t().m8106y().m8109a("Failed to insert filter results (got -1). appId", zzchm.m8093a(str));
                        }
                        i4 = i5;
                    } catch (SQLiteException e) {
                        zzcgoVarMo7866n.mo7872t().m8106y().m8110a("Error storing filter results. appId", zzchm.m8093a(str), e);
                        i4 = i5;
                    }
                } catch (IOException e2) {
                    zzcgoVarMo7866n.mo7872t().m8106y().m8110a("Configuration loss. Failed to serialize filter results. appId", zzchm.m8093a(str), e2);
                    i4 = i5;
                }
            }
        }
        return (zzcma[]) Arrays.copyOf(zzcmaVarArr, i4);
    }

    @Override // com.google.android.gms.internal.zzcjl
    /* JADX INFO: renamed from: w */
    protected final boolean mo7936w() {
        return false;
    }
}
