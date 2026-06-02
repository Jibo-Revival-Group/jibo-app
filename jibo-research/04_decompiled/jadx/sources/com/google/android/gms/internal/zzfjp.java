package com.google.android.gms.internal;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
final class zzfjp implements Cloneable {

    /* JADX INFO: renamed from: a */
    private zzfjn<?, ?> f7961a;

    /* JADX INFO: renamed from: b */
    private Object f7962b;

    /* JADX INFO: renamed from: c */
    private List<zzfju> f7963c = new ArrayList();

    zzfjp() {
    }

    /* JADX INFO: renamed from: b */
    private final byte[] m8691b() throws IOException {
        byte[] bArr = new byte[m8693a()];
        m8694a(zzfjk.m8647a(bArr));
        return bArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public zzfjp clone() {
        int i = 0;
        zzfjp zzfjpVar = new zzfjp();
        try {
            zzfjpVar.f7961a = this.f7961a;
            if (this.f7963c == null) {
                zzfjpVar.f7963c = null;
            } else {
                zzfjpVar.f7963c.addAll(this.f7963c);
            }
            if (this.f7962b != null) {
                if (this.f7962b instanceof zzfjs) {
                    zzfjpVar.f7962b = (zzfjs) ((zzfjs) this.f7962b).clone();
                } else if (this.f7962b instanceof byte[]) {
                    zzfjpVar.f7962b = ((byte[]) this.f7962b).clone();
                } else if (this.f7962b instanceof byte[][]) {
                    byte[][] bArr = (byte[][]) this.f7962b;
                    byte[][] bArr2 = new byte[bArr.length][];
                    zzfjpVar.f7962b = bArr2;
                    for (int i2 = 0; i2 < bArr.length; i2++) {
                        bArr2[i2] = (byte[]) bArr[i2].clone();
                    }
                } else if (this.f7962b instanceof boolean[]) {
                    zzfjpVar.f7962b = ((boolean[]) this.f7962b).clone();
                } else if (this.f7962b instanceof int[]) {
                    zzfjpVar.f7962b = ((int[]) this.f7962b).clone();
                } else if (this.f7962b instanceof long[]) {
                    zzfjpVar.f7962b = ((long[]) this.f7962b).clone();
                } else if (this.f7962b instanceof float[]) {
                    zzfjpVar.f7962b = ((float[]) this.f7962b).clone();
                } else if (this.f7962b instanceof double[]) {
                    zzfjpVar.f7962b = ((double[]) this.f7962b).clone();
                } else if (this.f7962b instanceof zzfjs[]) {
                    zzfjs[] zzfjsVarArr = (zzfjs[]) this.f7962b;
                    zzfjs[] zzfjsVarArr2 = new zzfjs[zzfjsVarArr.length];
                    zzfjpVar.f7962b = zzfjsVarArr2;
                    while (true) {
                        int i3 = i;
                        if (i3 >= zzfjsVarArr.length) {
                            break;
                        }
                        zzfjsVarArr2[i3] = (zzfjs) zzfjsVarArr[i3].clone();
                        i = i3 + 1;
                    }
                }
            }
            return zzfjpVar;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    /* JADX INFO: renamed from: a */
    final int m8693a() {
        int length = 0;
        if (this.f7962b != null) {
            zzfjn<?, ?> zzfjnVar = this.f7961a;
            Object obj = this.f7962b;
            if (!zzfjnVar.f7954c) {
                return zzfjnVar.m8682a(obj);
            }
            int length2 = Array.getLength(obj);
            for (int i = 0; i < length2; i++) {
                if (Array.get(obj, i) != null) {
                    length += zzfjnVar.m8682a(Array.get(obj, i));
                }
            }
            return length;
        }
        Iterator<zzfju> it = this.f7963c.iterator();
        while (true) {
            int i2 = length;
            if (!it.hasNext()) {
                return i2;
            }
            zzfju next = it.next();
            length = next.f7969b.length + zzfjk.m8659d(next.f7968a) + 0 + i2;
        }
    }

    /* JADX INFO: renamed from: a */
    final void m8694a(zzfjk zzfjkVar) throws IOException {
        if (this.f7962b == null) {
            for (zzfju zzfjuVar : this.f7963c) {
                zzfjkVar.m8675c(zzfjuVar.f7968a);
                zzfjkVar.m8678c(zzfjuVar.f7969b);
            }
            return;
        }
        zzfjn<?, ?> zzfjnVar = this.f7961a;
        Object obj = this.f7962b;
        if (!zzfjnVar.f7954c) {
            zzfjnVar.m8683a(obj, zzfjkVar);
            return;
        }
        int length = Array.getLength(obj);
        for (int i = 0; i < length; i++) {
            Object obj2 = Array.get(obj, i);
            if (obj2 != null) {
                zzfjnVar.m8683a(obj2, zzfjkVar);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    final void m8695a(zzfju zzfjuVar) {
        this.f7963c.add(zzfjuVar);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzfjp)) {
            return false;
        }
        zzfjp zzfjpVar = (zzfjp) obj;
        if (this.f7962b != null && zzfjpVar.f7962b != null) {
            if (this.f7961a == zzfjpVar.f7961a) {
                return !this.f7961a.f7952a.isArray() ? this.f7962b.equals(zzfjpVar.f7962b) : this.f7962b instanceof byte[] ? Arrays.equals((byte[]) this.f7962b, (byte[]) zzfjpVar.f7962b) : this.f7962b instanceof int[] ? Arrays.equals((int[]) this.f7962b, (int[]) zzfjpVar.f7962b) : this.f7962b instanceof long[] ? Arrays.equals((long[]) this.f7962b, (long[]) zzfjpVar.f7962b) : this.f7962b instanceof float[] ? Arrays.equals((float[]) this.f7962b, (float[]) zzfjpVar.f7962b) : this.f7962b instanceof double[] ? Arrays.equals((double[]) this.f7962b, (double[]) zzfjpVar.f7962b) : this.f7962b instanceof boolean[] ? Arrays.equals((boolean[]) this.f7962b, (boolean[]) zzfjpVar.f7962b) : Arrays.deepEquals((Object[]) this.f7962b, (Object[]) zzfjpVar.f7962b);
            }
            return false;
        }
        if (this.f7963c != null && zzfjpVar.f7963c != null) {
            return this.f7963c.equals(zzfjpVar.f7963c);
        }
        try {
            return Arrays.equals(m8691b(), zzfjpVar.m8691b());
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    public final int hashCode() {
        try {
            return Arrays.hashCode(m8691b()) + 527;
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }
}
