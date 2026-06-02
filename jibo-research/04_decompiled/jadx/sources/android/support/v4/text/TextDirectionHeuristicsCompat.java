package android.support.v4.text;

import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class TextDirectionHeuristicsCompat {

    /* JADX INFO: renamed from: a */
    public static final TextDirectionHeuristicCompat f2168a = new TextDirectionHeuristicInternal(null, false);

    /* JADX INFO: renamed from: b */
    public static final TextDirectionHeuristicCompat f2169b = new TextDirectionHeuristicInternal(null, true);

    /* JADX INFO: renamed from: c */
    public static final TextDirectionHeuristicCompat f2170c = new TextDirectionHeuristicInternal(FirstStrong.f2177a, false);

    /* JADX INFO: renamed from: d */
    public static final TextDirectionHeuristicCompat f2171d = new TextDirectionHeuristicInternal(FirstStrong.f2177a, true);

    /* JADX INFO: renamed from: e */
    public static final TextDirectionHeuristicCompat f2172e = new TextDirectionHeuristicInternal(AnyStrong.f2174a, false);

    /* JADX INFO: renamed from: f */
    public static final TextDirectionHeuristicCompat f2173f = TextDirectionHeuristicLocale.f2180a;

    private interface TextDirectionAlgorithm {
        /* JADX INFO: renamed from: a */
        int mo2368a(CharSequence charSequence, int i, int i2);
    }

    /* JADX INFO: renamed from: a */
    static int m2366a(int i) {
        switch (i) {
            case 0:
                return 1;
            case 1:
            case 2:
                return 0;
            default:
                return 2;
        }
    }

    /* JADX INFO: renamed from: b */
    static int m2367b(int i) {
        switch (i) {
            case 0:
            case 14:
            case 15:
                return 1;
            case 1:
            case 2:
            case 16:
            case 17:
                return 0;
            default:
                return 2;
        }
    }

    private static abstract class TextDirectionHeuristicImpl implements TextDirectionHeuristicCompat {

        /* JADX INFO: renamed from: a */
        private final TextDirectionAlgorithm f2178a;

        /* JADX INFO: renamed from: a */
        protected abstract boolean mo2370a();

        TextDirectionHeuristicImpl(TextDirectionAlgorithm textDirectionAlgorithm) {
            this.f2178a = textDirectionAlgorithm;
        }

        @Override // android.support.v4.text.TextDirectionHeuristicCompat
        /* JADX INFO: renamed from: a */
        public boolean mo2365a(CharSequence charSequence, int i, int i2) {
            if (charSequence == null || i < 0 || i2 < 0 || charSequence.length() - i2 < i) {
                throw new IllegalArgumentException();
            }
            return this.f2178a == null ? mo2370a() : m2369b(charSequence, i, i2);
        }

        /* JADX INFO: renamed from: b */
        private boolean m2369b(CharSequence charSequence, int i, int i2) {
            switch (this.f2178a.mo2368a(charSequence, i, i2)) {
                case 0:
                    return true;
                case 1:
                    return false;
                default:
                    return mo2370a();
            }
        }
    }

    private static class TextDirectionHeuristicInternal extends TextDirectionHeuristicImpl {

        /* JADX INFO: renamed from: a */
        private final boolean f2179a;

        TextDirectionHeuristicInternal(TextDirectionAlgorithm textDirectionAlgorithm, boolean z) {
            super(textDirectionAlgorithm);
            this.f2179a = z;
        }

        @Override // android.support.v4.text.TextDirectionHeuristicsCompat.TextDirectionHeuristicImpl
        /* JADX INFO: renamed from: a */
        protected boolean mo2370a() {
            return this.f2179a;
        }
    }

    private static class FirstStrong implements TextDirectionAlgorithm {

        /* JADX INFO: renamed from: a */
        static final FirstStrong f2177a = new FirstStrong();

        @Override // android.support.v4.text.TextDirectionHeuristicsCompat.TextDirectionAlgorithm
        /* JADX INFO: renamed from: a */
        public int mo2368a(CharSequence charSequence, int i, int i2) {
            int i3 = i + i2;
            int iM2367b = 2;
            while (i < i3 && iM2367b == 2) {
                iM2367b = TextDirectionHeuristicsCompat.m2367b(Character.getDirectionality(charSequence.charAt(i)));
                i++;
            }
            return iM2367b;
        }

        private FirstStrong() {
        }
    }

    private static class AnyStrong implements TextDirectionAlgorithm {

        /* JADX INFO: renamed from: a */
        static final AnyStrong f2174a = new AnyStrong(true);

        /* JADX INFO: renamed from: b */
        static final AnyStrong f2175b = new AnyStrong(false);

        /* JADX INFO: renamed from: c */
        private final boolean f2176c;

        @Override // android.support.v4.text.TextDirectionHeuristicsCompat.TextDirectionAlgorithm
        /* JADX INFO: renamed from: a */
        public int mo2368a(CharSequence charSequence, int i, int i2) {
            int i3 = i + i2;
            boolean z = false;
            while (i < i3) {
                switch (TextDirectionHeuristicsCompat.m2366a(Character.getDirectionality(charSequence.charAt(i)))) {
                    case 0:
                        if (this.f2176c) {
                            return 0;
                        }
                        z = true;
                        break;
                    case 1:
                        if (!this.f2176c) {
                            return 1;
                        }
                        z = true;
                        break;
                        break;
                }
                i++;
            }
            if (z) {
                return !this.f2176c ? 0 : 1;
            }
            return 2;
        }

        private AnyStrong(boolean z) {
            this.f2176c = z;
        }
    }

    private static class TextDirectionHeuristicLocale extends TextDirectionHeuristicImpl {

        /* JADX INFO: renamed from: a */
        static final TextDirectionHeuristicLocale f2180a = new TextDirectionHeuristicLocale();

        TextDirectionHeuristicLocale() {
            super(null);
        }

        @Override // android.support.v4.text.TextDirectionHeuristicsCompat.TextDirectionHeuristicImpl
        /* JADX INFO: renamed from: a */
        protected boolean mo2370a() {
            return TextUtilsCompat.m2371a(Locale.getDefault()) == 1;
        }
    }
}
