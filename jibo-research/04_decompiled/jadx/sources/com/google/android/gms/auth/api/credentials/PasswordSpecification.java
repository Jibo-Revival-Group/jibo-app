package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.TreeSet;

/* JADX INFO: loaded from: classes.dex */
public final class PasswordSpecification extends zzbfm implements ReflectedParcelable {
    public static final Parcelable.Creator<PasswordSpecification> CREATOR = new zzj();

    /* JADX INFO: renamed from: a */
    public static final PasswordSpecification f5946a = new zza().m6718a(12, 16).m6719a("abcdefghijkmnopqrstxyzABCDEFGHJKLMNPQRSTXY3456789").m6720a("abcdefghijkmnopqrstxyz", 1).m6720a("ABCDEFGHJKLMNPQRSTXY", 1).m6720a("3456789", 1).m6721a();

    /* JADX INFO: renamed from: b */
    private static PasswordSpecification f5947b = new zza().m6718a(12, 16).m6719a("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890").m6720a("abcdefghijklmnopqrstuvwxyz", 1).m6720a("ABCDEFGHIJKLMNOPQRSTUVWXYZ", 1).m6720a("1234567890", 1).m6721a();

    /* JADX INFO: renamed from: c */
    private String f5948c;

    /* JADX INFO: renamed from: d */
    private List<String> f5949d;

    /* JADX INFO: renamed from: e */
    private List<Integer> f5950e;

    /* JADX INFO: renamed from: f */
    private int f5951f;

    /* JADX INFO: renamed from: g */
    private int f5952g;

    /* JADX INFO: renamed from: h */
    private final int[] f5953h;

    /* JADX INFO: renamed from: i */
    private final Random f5954i;

    public static class zza {

        /* JADX INFO: renamed from: a */
        private final TreeSet<Character> f5955a = new TreeSet<>();

        /* JADX INFO: renamed from: b */
        private final List<String> f5956b = new ArrayList();

        /* JADX INFO: renamed from: c */
        private final List<Integer> f5957c = new ArrayList();

        /* JADX INFO: renamed from: d */
        private int f5958d = 12;

        /* JADX INFO: renamed from: e */
        private int f5959e = 16;

        /* JADX INFO: renamed from: a */
        private static TreeSet<Character> m6717a(String str, String str2) {
            if (TextUtils.isEmpty(str)) {
                throw new zzb(String.valueOf(str2).concat(" cannot be null or empty"));
            }
            TreeSet<Character> treeSet = new TreeSet<>();
            for (char c : str.toCharArray()) {
                if (PasswordSpecification.m6714a(c, 32, 126)) {
                    throw new zzb(String.valueOf(str2).concat(" must only contain ASCII printable characters"));
                }
                treeSet.add(Character.valueOf(c));
            }
            return treeSet;
        }

        /* JADX INFO: renamed from: a */
        public final zza m6718a(int i, int i2) {
            this.f5958d = 12;
            this.f5959e = 16;
            return this;
        }

        /* JADX INFO: renamed from: a */
        public final zza m6719a(String str) {
            this.f5955a.addAll(m6717a(str, "allowedChars"));
            return this;
        }

        /* JADX INFO: renamed from: a */
        public final zza m6720a(String str, int i) {
            this.f5956b.add(PasswordSpecification.m6715b(m6717a(str, "requiredChars")));
            this.f5957c.add(1);
            return this;
        }

        /* JADX INFO: renamed from: a */
        public final PasswordSpecification m6721a() {
            if (this.f5955a.isEmpty()) {
                throw new zzb("no allowed characters specified");
            }
            Iterator<Integer> it = this.f5957c.iterator();
            int iIntValue = 0;
            while (it.hasNext()) {
                iIntValue = it.next().intValue() + iIntValue;
            }
            if (iIntValue > this.f5959e) {
                throw new zzb("required character count cannot be greater than the max password size");
            }
            boolean[] zArr = new boolean[95];
            Iterator<String> it2 = this.f5956b.iterator();
            while (it2.hasNext()) {
                for (char c : it2.next().toCharArray()) {
                    if (zArr[c - ' ']) {
                        throw new zzb(new StringBuilder(58).append("character ").append(c).append(" occurs in more than one required character set").toString());
                    }
                    zArr[c - ' '] = true;
                }
            }
            return new PasswordSpecification(PasswordSpecification.m6715b(this.f5955a), this.f5956b, this.f5957c, this.f5958d, this.f5959e);
        }
    }

    public static class zzb extends Error {
        public zzb(String str) {
            super(str);
        }
    }

    PasswordSpecification(String str, List<String> list, List<Integer> list2, int i, int i2) {
        this.f5948c = str;
        this.f5949d = Collections.unmodifiableList(list);
        this.f5950e = Collections.unmodifiableList(list2);
        this.f5951f = i;
        this.f5952g = i2;
        int[] iArr = new int[95];
        Arrays.fill(iArr, -1);
        Iterator<String> it = this.f5949d.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            int length = it.next().toCharArray().length;
            for (int i4 = 0; i4 < length; i4++) {
                iArr[r5[i4] - ' '] = i3;
            }
            i3++;
        }
        this.f5953h = iArr;
        this.f5954i = new SecureRandom();
    }

    /* JADX INFO: renamed from: a */
    static /* synthetic */ boolean m6714a(int i, int i2, int i3) {
        return m6716b(i, 32, 126);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: b */
    public static String m6715b(Collection<Character> collection) {
        char[] cArr = new char[collection.size()];
        int i = 0;
        Iterator<Character> it = collection.iterator();
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                return new String(cArr);
            }
            i = i2 + 1;
            cArr[i2] = it.next().charValue();
        }
    }

    /* JADX INFO: renamed from: b */
    private static boolean m6716b(int i, int i2, int i3) {
        return i < 32 || i > 126;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iM7733a = zzbfp.m7733a(parcel);
        zzbfp.m7748a(parcel, 1, this.f5948c, false);
        zzbfp.m7760b(parcel, 2, this.f5949d, false);
        zzbfp.m7749a(parcel, 3, this.f5950e, false);
        zzbfp.m7738a(parcel, 4, this.f5951f);
        zzbfp.m7738a(parcel, 5, this.f5952g);
        zzbfp.m7734a(parcel, iM7733a);
    }
}
