package com.google.android.gms.internal;

import android.content.Context;
import android.util.Log;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.protocol.HTTP;

/* JADX INFO: loaded from: classes.dex */
public final class zzbeu implements zzbeb {

    /* JADX INFO: renamed from: a */
    private static final Charset f6906a = Charset.forName(HTTP.UTF_8);

    /* JADX INFO: renamed from: b */
    private static final zzcup f6907b = new zzcup(zzcue.m8469a("com.google.android.gms.clearcut.public")).m8493a("gms:playlog:service:sampling_").m8494b("LogSampling__");

    /* JADX INFO: renamed from: d */
    private static Map<String, zzcui<String>> f6908d = null;

    /* JADX INFO: renamed from: e */
    private static Boolean f6909e = null;

    /* JADX INFO: renamed from: f */
    private static Long f6910f = null;

    /* JADX INFO: renamed from: c */
    private final Context f6911c;

    public zzbeu(Context context) {
        this.f6911c = context;
        if (f6908d == null) {
            f6908d = new HashMap();
        }
        if (this.f6911c != null) {
            zzcui.m8473a(this.f6911c);
        }
    }

    /* JADX INFO: renamed from: a */
    private static zzbev m7689a(String str) {
        int i = 0;
        if (str == null) {
            return null;
        }
        String strSubstring = "";
        int iIndexOf = str.indexOf(44);
        if (iIndexOf >= 0) {
            strSubstring = str.substring(0, iIndexOf);
            i = iIndexOf + 1;
        }
        int iIndexOf2 = str.indexOf(47, i);
        if (iIndexOf2 <= 0) {
            String strValueOf = String.valueOf(str);
            Log.e("LogSamplerImpl", strValueOf.length() != 0 ? "Failed to parse the rule: ".concat(strValueOf) : new String("Failed to parse the rule: "));
            return null;
        }
        try {
            long j = Long.parseLong(str.substring(i, iIndexOf2));
            long j2 = Long.parseLong(str.substring(iIndexOf2 + 1));
            if (j >= 0 && j2 >= 0) {
                return new zzbev(strSubstring, j, j2);
            }
            Log.e("LogSamplerImpl", new StringBuilder(72).append("negative values not supported: ").append(j).append("/").append(j2).toString());
            return null;
        } catch (NumberFormatException e) {
            String strValueOf2 = String.valueOf(str);
            Log.e("LogSamplerImpl", strValueOf2.length() != 0 ? "parseLong() failed while parsing: ".concat(strValueOf2) : new String("parseLong() failed while parsing: "), e);
            return null;
        }
    }

    /* JADX INFO: renamed from: a */
    private static boolean m7690a(Context context) {
        if (f6909e == null) {
            f6909e = Boolean.valueOf(zzbhf.m7816a(context).m7809a("com.google.android.providers.gsf.permission.READ_GSERVICES") == 0);
        }
        return f6909e.booleanValue();
    }

    @Override // com.google.android.gms.internal.zzbeb
    /* JADX INFO: renamed from: a */
    public final boolean mo7669a(String str, int i) {
        String strM8480a;
        long jLongValue;
        long jM7684a;
        if (str == null || str.isEmpty()) {
            str = i >= 0 ? String.valueOf(i) : null;
        }
        if (str == null) {
            return true;
        }
        if (this.f6911c == null || !m7690a(this.f6911c)) {
            strM8480a = null;
        } else {
            zzcui<String> zzcuiVarM8492a = f6908d.get(str);
            if (zzcuiVarM8492a == null) {
                zzcuiVarM8492a = f6907b.m8492a(str, null);
                f6908d.put(str, zzcuiVarM8492a);
            }
            strM8480a = zzcuiVarM8492a.m8480a();
        }
        zzbev zzbevVarM7689a = m7689a(strM8480a);
        if (zzbevVarM7689a == null) {
            return true;
        }
        String str2 = zzbevVarM7689a.f6912a;
        Context context = this.f6911c;
        if (f6910f != null) {
            jLongValue = f6910f.longValue();
        } else if (context != null) {
            if (m7690a(context)) {
                f6910f = Long.valueOf(zzdmf.m8513a(context.getContentResolver(), "android_id", 0L));
            } else {
                f6910f = 0L;
            }
            jLongValue = f6910f.longValue();
        } else {
            jLongValue = 0;
        }
        if (str2 == null || str2.isEmpty()) {
            jM7684a = zzbep.m7684a(ByteBuffer.allocate(8).putLong(jLongValue).array());
        } else {
            byte[] bytes = str2.getBytes(f6906a);
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(bytes.length + 8);
            byteBufferAllocate.put(bytes);
            byteBufferAllocate.putLong(jLongValue);
            jM7684a = zzbep.m7684a(byteBufferAllocate.array());
        }
        long j = zzbevVarM7689a.f6913b;
        long j2 = zzbevVarM7689a.f6914c;
        if (j < 0 || j2 < 0) {
            throw new IllegalArgumentException(new StringBuilder(72).append("negative values not supported: ").append(j).append("/").append(j2).toString());
        }
        if (j2 > 0) {
            if ((jM7684a >= 0 ? jM7684a % j2 : (((jM7684a & Long.MAX_VALUE) % j2) + ((Long.MAX_VALUE % j2) + 1)) % j2) < j) {
                return true;
            }
        }
        return false;
    }
}
