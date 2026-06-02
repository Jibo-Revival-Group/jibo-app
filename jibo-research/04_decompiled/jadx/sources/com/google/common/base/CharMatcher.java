package com.google.common.base;

import java.util.Arrays;
import org.apache.http.message.TokenParser;

/* JADX INFO: loaded from: classes.dex */
public abstract class CharMatcher {

    /* JADX INFO: renamed from: a */
    @Deprecated
    public static final CharMatcher f8520a = m8987c();

    /* JADX INFO: renamed from: b */
    @Deprecated
    public static final CharMatcher f8521b = m8989d();

    /* JADX INFO: renamed from: c */
    @Deprecated
    public static final CharMatcher f8522c = m8991e();

    /* JADX INFO: renamed from: d */
    @Deprecated
    public static final CharMatcher f8523d = m8992f();

    /* JADX INFO: renamed from: e */
    @Deprecated
    public static final CharMatcher f8524e = m8993g();

    /* JADX INFO: renamed from: f */
    @Deprecated
    public static final CharMatcher f8525f = m8994h();

    /* JADX INFO: renamed from: g */
    @Deprecated
    public static final CharMatcher f8526g = m8995i();

    /* JADX INFO: renamed from: h */
    @Deprecated
    public static final CharMatcher f8527h = m8996j();

    /* JADX INFO: renamed from: i */
    @Deprecated
    public static final CharMatcher f8528i = m8997k();

    /* JADX INFO: renamed from: j */
    @Deprecated
    public static final CharMatcher f8529j = m8998l();

    /* JADX INFO: renamed from: k */
    @Deprecated
    public static final CharMatcher f8530k = m8999m();

    /* JADX INFO: renamed from: l */
    @Deprecated
    public static final CharMatcher f8531l = m9000n();

    /* JADX INFO: renamed from: m */
    @Deprecated
    public static final CharMatcher f8532m = m8984a();

    /* JADX INFO: renamed from: n */
    @Deprecated
    public static final CharMatcher f8533n = m8986b();

    /* JADX INFO: renamed from: b */
    public abstract boolean mo9002b(char c);

    /* JADX INFO: renamed from: a */
    public static CharMatcher m8984a() {
        return Any.f8534o;
    }

    /* JADX INFO: renamed from: b */
    public static CharMatcher m8986b() {
        return None.f8547o;
    }

    /* JADX INFO: renamed from: c */
    public static CharMatcher m8987c() {
        return Whitespace.f8553p;
    }

    /* JADX INFO: renamed from: d */
    public static CharMatcher m8989d() {
        return BreakingWhitespace.f8536o;
    }

    /* JADX INFO: renamed from: e */
    public static CharMatcher m8991e() {
        return Ascii.f8535o;
    }

    /* JADX INFO: renamed from: f */
    public static CharMatcher m8992f() {
        return Digit.f8537o;
    }

    /* JADX INFO: renamed from: g */
    public static CharMatcher m8993g() {
        return JavaDigit.f8540o;
    }

    /* JADX INFO: renamed from: h */
    public static CharMatcher m8994h() {
        return JavaLetter.f8542o;
    }

    /* JADX INFO: renamed from: i */
    public static CharMatcher m8995i() {
        return JavaLetterOrDigit.f8543o;
    }

    /* JADX INFO: renamed from: j */
    public static CharMatcher m8996j() {
        return JavaUpperCase.f8545o;
    }

    /* JADX INFO: renamed from: k */
    public static CharMatcher m8997k() {
        return JavaLowerCase.f8544o;
    }

    /* JADX INFO: renamed from: l */
    public static CharMatcher m8998l() {
        return JavaIsoControl.f8541o;
    }

    /* JADX INFO: renamed from: m */
    public static CharMatcher m8999m() {
        return Invisible.f8538o;
    }

    /* JADX INFO: renamed from: n */
    public static CharMatcher m9000n() {
        return SingleWidth.f8551o;
    }

    /* JADX INFO: renamed from: a */
    public static CharMatcher m8985a(char c) {
        return new C0697Is(c);
    }

    protected CharMatcher() {
    }

    /* JADX INFO: renamed from: a */
    public int mo9001a(CharSequence charSequence, int i) {
        int length = charSequence.length();
        Preconditions.m9013a(i, length);
        for (int i2 = i; i2 < length; i2++) {
            if (mo9002b(charSequence.charAt(i2))) {
                return i2;
            }
        }
        return -1;
    }

    public String toString() {
        return super.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: d */
    public static String m8990d(char c) {
        char[] cArr = {TokenParser.ESCAPE, 'u', 0, 0, 0, 0};
        for (int i = 0; i < 4; i++) {
            cArr[5 - i] = "0123456789ABCDEF".charAt(c & 15);
            c = (char) (c >> 4);
        }
        return String.copyValueOf(cArr);
    }

    static abstract class FastMatcher extends CharMatcher {
        FastMatcher() {
        }
    }

    static abstract class NamedFastMatcher extends FastMatcher {

        /* JADX INFO: renamed from: o */
        private final String f8546o;

        NamedFastMatcher(String str) {
            this.f8546o = (String) Preconditions.m9015a(str);
        }

        @Override // com.google.common.base.CharMatcher
        public final String toString() {
            return this.f8546o;
        }
    }

    private static final class Any extends NamedFastMatcher {

        /* JADX INFO: renamed from: o */
        static final Any f8534o = new Any();

        private Any() {
            super("CharMatcher.any()");
        }

        @Override // com.google.common.base.CharMatcher
        /* JADX INFO: renamed from: b */
        public boolean mo9002b(char c) {
            return true;
        }

        @Override // com.google.common.base.CharMatcher
        /* JADX INFO: renamed from: a */
        public int mo9001a(CharSequence charSequence, int i) {
            int length = charSequence.length();
            Preconditions.m9013a(i, length);
            if (i == length) {
                return -1;
            }
            return i;
        }
    }

    private static final class None extends NamedFastMatcher {

        /* JADX INFO: renamed from: o */
        static final None f8547o = new None();

        private None() {
            super("CharMatcher.none()");
        }

        @Override // com.google.common.base.CharMatcher
        /* JADX INFO: renamed from: b */
        public boolean mo9002b(char c) {
            return false;
        }

        @Override // com.google.common.base.CharMatcher
        /* JADX INFO: renamed from: a */
        public int mo9001a(CharSequence charSequence, int i) {
            Preconditions.m9013a(i, charSequence.length());
            return -1;
        }
    }

    static final class Whitespace extends NamedFastMatcher {

        /* JADX INFO: renamed from: o */
        static final int f8552o = Integer.numberOfLeadingZeros("\u2002\u3000\r\u0085\u200a\u2005\u2000\u3000\u2029\u000b\u3000\u2008\u2003\u205f\u3000\u1680\t \u2006\u2001  \f\u2009\u3000\u2004\u3000\u3000\u2028\n \u3000".length() - 1);

        /* JADX INFO: renamed from: p */
        static final Whitespace f8553p = new Whitespace();

        Whitespace() {
            super("CharMatcher.whitespace()");
        }

        @Override // com.google.common.base.CharMatcher
        /* JADX INFO: renamed from: b */
        public boolean mo9002b(char c) {
            return "\u2002\u3000\r\u0085\u200a\u2005\u2000\u3000\u2029\u000b\u3000\u2008\u2003\u205f\u3000\u1680\t \u2006\u2001  \f\u2009\u3000\u2004\u3000\u3000\u2028\n \u3000".charAt((48906 * c) >>> f8552o) == c;
        }
    }

    private static final class BreakingWhitespace extends CharMatcher {

        /* JADX INFO: renamed from: o */
        static final CharMatcher f8536o = new BreakingWhitespace();

        private BreakingWhitespace() {
        }

        @Override // com.google.common.base.CharMatcher
        /* JADX INFO: renamed from: b */
        public boolean mo9002b(char c) {
            switch (c) {
                case '\t':
                case '\n':
                case 11:
                case '\f':
                case '\r':
                case ' ':
                case 133:
                case 5760:
                case 8232:
                case 8233:
                case 8287:
                case 12288:
                    break;
                case 8199:
                    break;
                default:
                    if (c < 8192 || c > 8202) {
                    }
                    break;
            }
            return true;
        }

        @Override // com.google.common.base.CharMatcher
        public String toString() {
            return "CharMatcher.breakingWhitespace()";
        }
    }

    private static final class Ascii extends NamedFastMatcher {

        /* JADX INFO: renamed from: o */
        static final Ascii f8535o = new Ascii();

        Ascii() {
            super("CharMatcher.ascii()");
        }

        @Override // com.google.common.base.CharMatcher
        /* JADX INFO: renamed from: b */
        public boolean mo9002b(char c) {
            return c <= 127;
        }
    }

    private static class RangesMatcher extends CharMatcher {

        /* JADX INFO: renamed from: o */
        private final String f8548o;

        /* JADX INFO: renamed from: p */
        private final char[] f8549p;

        /* JADX INFO: renamed from: q */
        private final char[] f8550q;

        RangesMatcher(String str, char[] cArr, char[] cArr2) {
            this.f8548o = str;
            this.f8549p = cArr;
            this.f8550q = cArr2;
            Preconditions.m9017a(cArr.length == cArr2.length);
            for (int i = 0; i < cArr.length; i++) {
                Preconditions.m9017a(cArr[i] <= cArr2[i]);
                if (i + 1 < cArr.length) {
                    Preconditions.m9017a(cArr2[i] < cArr[i + 1]);
                }
            }
        }

        @Override // com.google.common.base.CharMatcher
        /* JADX INFO: renamed from: b */
        public boolean mo9002b(char c) {
            int iBinarySearch = Arrays.binarySearch(this.f8549p, c);
            if (iBinarySearch >= 0) {
                return true;
            }
            int i = (iBinarySearch ^ (-1)) - 1;
            return i >= 0 && c <= this.f8550q[i];
        }

        @Override // com.google.common.base.CharMatcher
        public String toString() {
            return this.f8548o;
        }
    }

    private static final class Digit extends RangesMatcher {

        /* JADX INFO: renamed from: o */
        static final Digit f8537o = new Digit();

        /* JADX INFO: renamed from: o */
        private static char[] m9003o() {
            return "0٠۰߀०০੦૦୦௦౦೦൦๐໐༠၀႐០᠐᥆᧐᭐᮰᱀᱐꘠꣐꤀꩐０".toCharArray();
        }

        /* JADX INFO: renamed from: p */
        private static char[] m9004p() {
            char[] cArr = new char["0٠۰߀०০੦૦୦௦౦೦൦๐໐༠၀႐០᠐᥆᧐᭐᮰᱀᱐꘠꣐꤀꩐０".length()];
            for (int i = 0; i < "0٠۰߀०০੦૦୦௦౦೦൦๐໐༠၀႐០᠐᥆᧐᭐᮰᱀᱐꘠꣐꤀꩐０".length(); i++) {
                cArr[i] = (char) ("0٠۰߀०০੦૦୦௦౦೦൦๐໐༠၀႐០᠐᥆᧐᭐᮰᱀᱐꘠꣐꤀꩐０".charAt(i) + '\t');
            }
            return cArr;
        }

        private Digit() {
            super("CharMatcher.digit()", m9003o(), m9004p());
        }
    }

    private static final class JavaDigit extends CharMatcher {

        /* JADX INFO: renamed from: o */
        static final JavaDigit f8540o = new JavaDigit();

        private JavaDigit() {
        }

        @Override // com.google.common.base.CharMatcher
        /* JADX INFO: renamed from: b */
        public boolean mo9002b(char c) {
            return Character.isDigit(c);
        }

        @Override // com.google.common.base.CharMatcher
        public String toString() {
            return "CharMatcher.javaDigit()";
        }
    }

    private static final class JavaLetter extends CharMatcher {

        /* JADX INFO: renamed from: o */
        static final JavaLetter f8542o = new JavaLetter();

        private JavaLetter() {
        }

        @Override // com.google.common.base.CharMatcher
        /* JADX INFO: renamed from: b */
        public boolean mo9002b(char c) {
            return Character.isLetter(c);
        }

        @Override // com.google.common.base.CharMatcher
        public String toString() {
            return "CharMatcher.javaLetter()";
        }
    }

    private static final class JavaLetterOrDigit extends CharMatcher {

        /* JADX INFO: renamed from: o */
        static final JavaLetterOrDigit f8543o = new JavaLetterOrDigit();

        private JavaLetterOrDigit() {
        }

        @Override // com.google.common.base.CharMatcher
        /* JADX INFO: renamed from: b */
        public boolean mo9002b(char c) {
            return Character.isLetterOrDigit(c);
        }

        @Override // com.google.common.base.CharMatcher
        public String toString() {
            return "CharMatcher.javaLetterOrDigit()";
        }
    }

    private static final class JavaUpperCase extends CharMatcher {

        /* JADX INFO: renamed from: o */
        static final JavaUpperCase f8545o = new JavaUpperCase();

        private JavaUpperCase() {
        }

        @Override // com.google.common.base.CharMatcher
        /* JADX INFO: renamed from: b */
        public boolean mo9002b(char c) {
            return Character.isUpperCase(c);
        }

        @Override // com.google.common.base.CharMatcher
        public String toString() {
            return "CharMatcher.javaUpperCase()";
        }
    }

    private static final class JavaLowerCase extends CharMatcher {

        /* JADX INFO: renamed from: o */
        static final JavaLowerCase f8544o = new JavaLowerCase();

        private JavaLowerCase() {
        }

        @Override // com.google.common.base.CharMatcher
        /* JADX INFO: renamed from: b */
        public boolean mo9002b(char c) {
            return Character.isLowerCase(c);
        }

        @Override // com.google.common.base.CharMatcher
        public String toString() {
            return "CharMatcher.javaLowerCase()";
        }
    }

    private static final class JavaIsoControl extends NamedFastMatcher {

        /* JADX INFO: renamed from: o */
        static final JavaIsoControl f8541o = new JavaIsoControl();

        private JavaIsoControl() {
            super("CharMatcher.javaIsoControl()");
        }

        @Override // com.google.common.base.CharMatcher
        /* JADX INFO: renamed from: b */
        public boolean mo9002b(char c) {
            return c <= 31 || (c >= 127 && c <= 159);
        }
    }

    private static final class Invisible extends RangesMatcher {

        /* JADX INFO: renamed from: o */
        static final Invisible f8538o = new Invisible();

        private Invisible() {
            super("CharMatcher.invisible()", "\u0000\u007f\u00ad\u0600\u061c\u06dd\u070f\u1680\u180e\u2000\u2028\u205f\u2066\u2067\u2068\u2069\u206a\u3000\ud800\ufeff\ufff9\ufffa".toCharArray(), "  \u00ad\u0604\u061c\u06dd\u070f\u1680\u180e\u200f \u2064\u2066\u2067\u2068\u2069\u206f\u3000\uf8ff\ufeff\ufff9\ufffb".toCharArray());
        }
    }

    private static final class SingleWidth extends RangesMatcher {

        /* JADX INFO: renamed from: o */
        static final SingleWidth f8551o = new SingleWidth();

        private SingleWidth() {
            super("CharMatcher.singleWidth()", "\u0000־א׳\u0600ݐ\u0e00Ḁ℀ﭐﹰ｡".toCharArray(), "ӹ־ת״ۿݿ\u0e7f₯℺\ufdff\ufeffￜ".toCharArray());
        }
    }

    /* JADX INFO: renamed from: com.google.common.base.CharMatcher$Is */
    private static final class C0697Is extends FastMatcher {

        /* JADX INFO: renamed from: o */
        private final char f8539o;

        C0697Is(char c) {
            this.f8539o = c;
        }

        @Override // com.google.common.base.CharMatcher
        /* JADX INFO: renamed from: b */
        public boolean mo9002b(char c) {
            return c == this.f8539o;
        }

        @Override // com.google.common.base.CharMatcher
        public String toString() {
            return "CharMatcher.is('" + CharMatcher.m8990d(this.f8539o) + "')";
        }
    }
}
