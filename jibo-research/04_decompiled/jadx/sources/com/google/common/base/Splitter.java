package com.google.common.base;

import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class Splitter {

    /* JADX INFO: renamed from: a */
    private final CharMatcher f8557a;

    /* JADX INFO: renamed from: b */
    private final boolean f8558b;

    /* JADX INFO: renamed from: c */
    private final Strategy f8559c;

    /* JADX INFO: renamed from: d */
    private final int f8560d;

    private interface Strategy {
        /* JADX INFO: renamed from: b */
        Iterator<String> mo9033b(Splitter splitter, CharSequence charSequence);
    }

    private Splitter(Strategy strategy) {
        this(strategy, false, CharMatcher.m8986b(), Integer.MAX_VALUE);
    }

    private Splitter(Strategy strategy, boolean z, CharMatcher charMatcher, int i) {
        this.f8559c = strategy;
        this.f8558b = z;
        this.f8557a = charMatcher;
        this.f8560d = i;
    }

    /* JADX INFO: renamed from: a */
    public static Splitter m9025a(char c) {
        return m9026a(CharMatcher.m8985a(c));
    }

    /* JADX INFO: renamed from: a */
    public static Splitter m9026a(final CharMatcher charMatcher) {
        Preconditions.m9015a(charMatcher);
        return new Splitter(new Strategy() { // from class: com.google.common.base.Splitter.1
            @Override // com.google.common.base.Splitter.Strategy
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public SplittingIterator mo9033b(Splitter splitter, CharSequence charSequence) {
                return new SplittingIterator(splitter, charSequence) { // from class: com.google.common.base.Splitter.1.1
                    @Override // com.google.common.base.Splitter.SplittingIterator
                    /* JADX INFO: renamed from: a */
                    int mo9034a(int i) {
                        return charMatcher.mo9001a(this.f8565b, i);
                    }

                    @Override // com.google.common.base.Splitter.SplittingIterator
                    /* JADX INFO: renamed from: b */
                    int mo9035b(int i) {
                        return i + 1;
                    }
                };
            }
        });
    }

    /* JADX INFO: renamed from: a */
    public Iterable<String> m9031a(final CharSequence charSequence) {
        Preconditions.m9015a(charSequence);
        return new Iterable<String>() { // from class: com.google.common.base.Splitter.5
            @Override // java.lang.Iterable
            public Iterator<String> iterator() {
                return Splitter.this.m9028b(charSequence);
            }

            public String toString() {
                return Joiner.m9005a(", ").m9008a(new StringBuilder().append('['), this).append(']').toString();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: b */
    public Iterator<String> m9028b(CharSequence charSequence) {
        return this.f8559c.mo9033b(this, charSequence);
    }

    private static abstract class SplittingIterator extends AbstractIterator<String> {

        /* JADX INFO: renamed from: b */
        final CharSequence f8565b;

        /* JADX INFO: renamed from: c */
        final CharMatcher f8566c;

        /* JADX INFO: renamed from: d */
        final boolean f8567d;

        /* JADX INFO: renamed from: e */
        int f8568e = 0;

        /* JADX INFO: renamed from: f */
        int f8569f;

        /* JADX INFO: renamed from: a */
        abstract int mo9034a(int i);

        /* JADX INFO: renamed from: b */
        abstract int mo9035b(int i);

        protected SplittingIterator(Splitter splitter, CharSequence charSequence) {
            this.f8566c = splitter.f8557a;
            this.f8567d = splitter.f8558b;
            this.f8569f = splitter.f8560d;
            this.f8565b = charSequence;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.base.AbstractIterator
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public String mo8982a() {
            int i = this.f8568e;
            while (this.f8568e != -1) {
                int iMo9034a = mo9034a(this.f8568e);
                if (iMo9034a == -1) {
                    iMo9034a = this.f8565b.length();
                    this.f8568e = -1;
                } else {
                    this.f8568e = mo9035b(iMo9034a);
                }
                if (this.f8568e == i) {
                    this.f8568e++;
                    if (this.f8568e > this.f8565b.length()) {
                        this.f8568e = -1;
                    }
                } else {
                    int i2 = i;
                    while (i2 < iMo9034a && this.f8566c.mo9002b(this.f8565b.charAt(i2))) {
                        i2++;
                    }
                    int length = iMo9034a;
                    while (length > i2 && this.f8566c.mo9002b(this.f8565b.charAt(length - 1))) {
                        length--;
                    }
                    if (this.f8567d && i2 == length) {
                        i = this.f8568e;
                    } else {
                        if (this.f8569f == 1) {
                            length = this.f8565b.length();
                            this.f8568e = -1;
                            while (length > i2 && this.f8566c.mo9002b(this.f8565b.charAt(length - 1))) {
                                length--;
                            }
                        } else {
                            this.f8569f--;
                        }
                        return this.f8565b.subSequence(i2, length).toString();
                    }
                }
            }
            return m8983b();
        }
    }
}
