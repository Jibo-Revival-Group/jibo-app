package okhttp3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import okhttp3.internal.Util;

/* JADX INFO: loaded from: classes2.dex */
public final class Headers {

    /* JADX INFO: renamed from: a */
    private final String[] f15074a;

    Headers(Builder builder) {
        this.f15074a = (String[]) builder.f15075a.toArray(new String[builder.f15075a.size()]);
    }

    private Headers(String[] strArr) {
        this.f15074a = strArr;
    }

    /* JADX INFO: renamed from: a */
    public String m15619a(String str) {
        return m15615a(this.f15074a, str);
    }

    /* JADX INFO: renamed from: a */
    public int m15617a() {
        return this.f15074a.length / 2;
    }

    /* JADX INFO: renamed from: a */
    public String m15618a(int i) {
        return this.f15074a[i * 2];
    }

    /* JADX INFO: renamed from: b */
    public String m15620b(int i) {
        return this.f15074a[(i * 2) + 1];
    }

    /* JADX INFO: renamed from: b */
    public List<String> m15621b(String str) {
        int iM15617a = m15617a();
        ArrayList arrayList = null;
        for (int i = 0; i < iM15617a; i++) {
            if (str.equalsIgnoreCase(m15618a(i))) {
                if (arrayList == null) {
                    arrayList = new ArrayList(2);
                }
                arrayList.add(m15620b(i));
            }
        }
        if (arrayList != null) {
            return Collections.unmodifiableList(arrayList);
        }
        return Collections.emptyList();
    }

    /* JADX INFO: renamed from: b */
    public Builder m15622b() {
        Builder builder = new Builder();
        Collections.addAll(builder.f15075a, this.f15074a);
        return builder;
    }

    public boolean equals(Object obj) {
        return (obj instanceof Headers) && Arrays.equals(((Headers) obj).f15074a, this.f15074a);
    }

    public int hashCode() {
        return Arrays.hashCode(this.f15074a);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        int iM15617a = m15617a();
        for (int i = 0; i < iM15617a; i++) {
            sb.append(m15618a(i)).append(": ").append(m15620b(i)).append("\n");
        }
        return sb.toString();
    }

    /* JADX INFO: renamed from: a */
    private static String m15615a(String[] strArr, String str) {
        for (int length = strArr.length - 2; length >= 0; length -= 2) {
            if (str.equalsIgnoreCase(strArr[length])) {
                return strArr[length + 1];
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: a */
    public static Headers m15616a(String... strArr) {
        if (strArr == null) {
            throw new NullPointerException("namesAndValues == null");
        }
        if (strArr.length % 2 != 0) {
            throw new IllegalArgumentException("Expected alternating header names and values");
        }
        String[] strArr2 = (String[]) strArr.clone();
        for (int i = 0; i < strArr2.length; i++) {
            if (strArr2[i] == null) {
                throw new IllegalArgumentException("Headers cannot be null");
            }
            strArr2[i] = strArr2[i].trim();
        }
        for (int i2 = 0; i2 < strArr2.length; i2 += 2) {
            String str = strArr2[i2];
            String str2 = strArr2[i2 + 1];
            if (str.length() == 0 || str.indexOf(0) != -1 || str2.indexOf(0) != -1) {
                throw new IllegalArgumentException("Unexpected header: " + str + ": " + str2);
            }
        }
        return new Headers(strArr2);
    }

    public static final class Builder {

        /* JADX INFO: renamed from: a */
        final List<String> f15075a = new ArrayList(20);

        /* JADX INFO: renamed from: a */
        Builder m15624a(String str) {
            int iIndexOf = str.indexOf(":", 1);
            if (iIndexOf != -1) {
                return m15628b(str.substring(0, iIndexOf), str.substring(iIndexOf + 1));
            }
            if (str.startsWith(":")) {
                return m15628b("", str.substring(1));
            }
            return m15628b("", str);
        }

        /* JADX INFO: renamed from: a */
        public Builder m15625a(String str, String str2) {
            m15623d(str, str2);
            return m15628b(str, str2);
        }

        /* JADX INFO: renamed from: b */
        Builder m15628b(String str, String str2) {
            this.f15075a.add(str);
            this.f15075a.add(str2.trim());
            return this;
        }

        /* JADX INFO: renamed from: b */
        public Builder m15627b(String str) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.f15075a.size()) {
                    if (str.equalsIgnoreCase(this.f15075a.get(i2))) {
                        this.f15075a.remove(i2);
                        this.f15075a.remove(i2);
                        i2 -= 2;
                    }
                    i = i2 + 2;
                } else {
                    return this;
                }
            }
        }

        /* JADX INFO: renamed from: c */
        public Builder m15630c(String str, String str2) {
            m15623d(str, str2);
            m15627b(str);
            m15628b(str, str2);
            return this;
        }

        /* JADX INFO: renamed from: d */
        private void m15623d(String str, String str2) {
            if (str == null) {
                throw new NullPointerException("name == null");
            }
            if (str.isEmpty()) {
                throw new IllegalArgumentException("name is empty");
            }
            int length = str.length();
            for (int i = 0; i < length; i++) {
                char cCharAt = str.charAt(i);
                if (cCharAt <= ' ' || cCharAt >= 127) {
                    throw new IllegalArgumentException(Util.m15836a("Unexpected char %#04x at %d in header name: %s", Integer.valueOf(cCharAt), Integer.valueOf(i), str));
                }
            }
            if (str2 == null) {
                throw new NullPointerException("value for name " + str + " == null");
            }
            int length2 = str2.length();
            for (int i2 = 0; i2 < length2; i2++) {
                char cCharAt2 = str2.charAt(i2);
                if ((cCharAt2 <= 31 && cCharAt2 != '\t') || cCharAt2 >= 127) {
                    throw new IllegalArgumentException(Util.m15836a("Unexpected char %#04x at %d in %s value: %s", Integer.valueOf(cCharAt2), Integer.valueOf(i2), str, str2));
                }
            }
        }

        /* JADX INFO: renamed from: c */
        public String m15629c(String str) {
            for (int size = this.f15075a.size() - 2; size >= 0; size -= 2) {
                if (str.equalsIgnoreCase(this.f15075a.get(size))) {
                    return this.f15075a.get(size + 1);
                }
            }
            return null;
        }

        /* JADX INFO: renamed from: a */
        public Headers m15626a() {
            return new Headers(this);
        }
    }
}
