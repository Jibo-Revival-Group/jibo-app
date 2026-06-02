package org.joda.time.format;

import java.io.IOException;
import org.apache.http.message.TokenParser;

/* JADX INFO: loaded from: classes2.dex */
public class FormatUtils {

    /* JADX INFO: renamed from: a */
    private static final double f16098a = Math.log(10.0d);

    /* JADX INFO: renamed from: a */
    public static void m16903a(StringBuffer stringBuffer, int i, int i2) {
        try {
            m16902a((Appendable) stringBuffer, i, i2);
        } catch (IOException e) {
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m16902a(Appendable appendable, int i, int i2) throws IOException {
        int iLog;
        if (i < 0) {
            appendable.append('-');
            if (i != Integer.MIN_VALUE) {
                i = -i;
            } else {
                while (i2 > 10) {
                    appendable.append('0');
                    i2--;
                }
                appendable.append("2147483648");
                return;
            }
        }
        if (i < 10) {
            while (i2 > 1) {
                appendable.append('0');
                i2--;
            }
            appendable.append((char) (i + 48));
            return;
        }
        if (i < 100) {
            while (i2 > 2) {
                appendable.append('0');
                i2--;
            }
            int i3 = ((i + 1) * 13421772) >> 27;
            appendable.append((char) (i3 + 48));
            appendable.append((char) (((i - (i3 << 3)) - (i3 << 1)) + 48));
            return;
        }
        if (i < 1000) {
            iLog = 3;
        } else if (i < 10000) {
            iLog = 4;
        } else {
            iLog = ((int) (Math.log(i) / f16098a)) + 1;
        }
        while (i2 > iLog) {
            appendable.append('0');
            i2--;
        }
        appendable.append(Integer.toString(i));
    }

    /* JADX INFO: renamed from: a */
    public static void m16901a(Appendable appendable, int i) throws IOException {
        if (i < 0) {
            appendable.append('-');
            if (i != Integer.MIN_VALUE) {
                i = -i;
            } else {
                appendable.append("2147483648");
                return;
            }
        }
        if (i < 10) {
            appendable.append((char) (i + 48));
        } else {
            if (i < 100) {
                int i2 = ((i + 1) * 13421772) >> 27;
                appendable.append((char) (i2 + 48));
                appendable.append((char) (((i - (i2 << 3)) - (i2 << 1)) + 48));
                return;
            }
            appendable.append(Integer.toString(i));
        }
    }

    /* JADX INFO: renamed from: a */
    static int m16899a(CharSequence charSequence, int i) {
        int iCharAt = charSequence.charAt(i) - '0';
        return (((iCharAt << 1) + (iCharAt << 3)) + charSequence.charAt(i + 1)) - 48;
    }

    /* JADX INFO: renamed from: a */
    static String m16900a(String str, int i) {
        int i2 = i + 32;
        String strConcat = str.length() <= i2 + 3 ? str : str.substring(0, i2).concat("...");
        if (i <= 0) {
            return "Invalid format: \"" + strConcat + TokenParser.DQUOTE;
        }
        if (i >= str.length()) {
            return "Invalid format: \"" + strConcat + "\" is too short";
        }
        return "Invalid format: \"" + strConcat + "\" is malformed at \"" + strConcat.substring(i) + TokenParser.DQUOTE;
    }
}
