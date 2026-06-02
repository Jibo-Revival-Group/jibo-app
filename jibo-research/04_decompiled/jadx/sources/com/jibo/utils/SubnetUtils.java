package com.jibo.utils;

import com.yalantis.ucrop.util.FileUtils;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public class SubnetUtils {

    /* JADX INFO: renamed from: a */
    private static final Pattern f11685a = Pattern.compile("(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})");

    /* JADX INFO: renamed from: b */
    private static final Pattern f11686b = Pattern.compile("(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})/(\\d{1,3})");

    /* JADX INFO: renamed from: c */
    private int f11687c = 0;

    /* JADX INFO: renamed from: d */
    private int f11688d = 0;

    /* JADX INFO: renamed from: e */
    private int f11689e = 0;

    /* JADX INFO: renamed from: f */
    private int f11690f = 0;

    public SubnetUtils(String str, String str2) {
        m11464a(m11462a(str, str2));
    }

    /* JADX INFO: renamed from: a */
    public final SubnetInfo m11469a() {
        return new SubnetInfo();
    }

    /* JADX INFO: renamed from: a */
    private void m11464a(String str) {
        Matcher matcher = f11686b.matcher(str);
        if (matcher.matches()) {
            this.f11688d = m11460a(matcher);
            int iM11458a = m11458a(Integer.parseInt(matcher.group(5)), 0, 31);
            for (int i = 0; i < iM11458a; i++) {
                this.f11687c |= 1 << (31 - i);
            }
            this.f11689e = this.f11688d & this.f11687c;
            this.f11690f = this.f11689e | (this.f11687c ^ (-1));
            return;
        }
        throw new IllegalArgumentException("Could not parse [" + str + "]");
    }

    /* JADX INFO: renamed from: b */
    private int m11466b(String str) {
        Matcher matcher = f11685a.matcher(str);
        if (matcher.matches()) {
            return m11460a(matcher);
        }
        throw new IllegalArgumentException("Could not parse [" + str + "]");
    }

    /* JADX INFO: renamed from: a */
    private int m11460a(Matcher matcher) {
        int iM11458a = 0;
        for (int i = 1; i <= 4; i++) {
            iM11458a |= (m11458a(Integer.parseInt(matcher.group(i)), 0, 255) & 255) << ((4 - i) * 8);
        }
        return iM11458a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: b */
    public int[] m11467b(int i) {
        int[] iArr = new int[4];
        for (int i2 = 3; i2 >= 0; i2--) {
            iArr[i2] = iArr[i2] | ((i >>> ((3 - i2) * 8)) & 255);
        }
        return iArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public String m11463a(int[] iArr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < iArr.length; i++) {
            sb.append(iArr[i]);
            if (i != iArr.length - 1) {
                sb.append(FileUtils.HIDDEN_PREFIX);
            }
        }
        return sb.toString();
    }

    /* JADX INFO: renamed from: a */
    private int m11458a(int i, int i2, int i3) {
        if (i >= i2 && i <= i3) {
            return i;
        }
        throw new IllegalArgumentException("Value out of range: [" + i + "]");
    }

    /* JADX INFO: renamed from: a */
    int m11468a(int i) {
        int i2 = i - ((i >>> 1) & 1431655765);
        int i3 = ((i2 >>> 2) & 858993459) + (i2 & 858993459);
        int i4 = (i3 + (i3 >>> 4)) & 252645135;
        int i5 = i4 + (i4 >>> 8);
        return (i5 + (i5 >>> 16)) & 63;
    }

    /* JADX INFO: renamed from: a */
    private String m11462a(String str, String str2) {
        return str + "/" + m11468a(m11466b(str2));
    }

    public final class SubnetInfo {
        private SubnetInfo() {
        }

        /* JADX INFO: renamed from: b */
        private int m11470b() {
            return SubnetUtils.this.f11689e;
        }

        /* JADX INFO: renamed from: a */
        public String m11471a() {
            return SubnetUtils.this.m11463a(SubnetUtils.this.m11467b(m11470b()));
        }
    }
}
