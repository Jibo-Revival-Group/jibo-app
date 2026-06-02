package org.joda.time.chrono;

import java.io.IOException;
import java.io.ObjectInputStream;
import org.joda.time.Chronology;
import org.joda.time.DateTimeField;
import org.joda.time.DateTimeZone;
import org.joda.time.DurationField;

/* JADX INFO: loaded from: classes2.dex */
public abstract class AssembledChronology extends BaseChronology {

    /* JADX INFO: renamed from: A */
    private transient DateTimeField f15799A;

    /* JADX INFO: renamed from: B */
    private transient DateTimeField f15800B;

    /* JADX INFO: renamed from: C */
    private transient DateTimeField f15801C;

    /* JADX INFO: renamed from: D */
    private transient DateTimeField f15802D;

    /* JADX INFO: renamed from: E */
    private transient DateTimeField f15803E;

    /* JADX INFO: renamed from: F */
    private transient DateTimeField f15804F;

    /* JADX INFO: renamed from: G */
    private transient DateTimeField f15805G;

    /* JADX INFO: renamed from: H */
    private transient DateTimeField f15806H;

    /* JADX INFO: renamed from: I */
    private transient DateTimeField f15807I;

    /* JADX INFO: renamed from: J */
    private transient DateTimeField f15808J;

    /* JADX INFO: renamed from: K */
    private transient DateTimeField f15809K;

    /* JADX INFO: renamed from: L */
    private transient int f15810L;

    /* JADX INFO: renamed from: a */
    private final Chronology f15811a;

    /* JADX INFO: renamed from: b */
    private final Object f15812b;

    /* JADX INFO: renamed from: c */
    private transient DurationField f15813c;

    /* JADX INFO: renamed from: d */
    private transient DurationField f15814d;

    /* JADX INFO: renamed from: e */
    private transient DurationField f15815e;

    /* JADX INFO: renamed from: f */
    private transient DurationField f15816f;

    /* JADX INFO: renamed from: g */
    private transient DurationField f15817g;

    /* JADX INFO: renamed from: h */
    private transient DurationField f15818h;

    /* JADX INFO: renamed from: i */
    private transient DurationField f15819i;

    /* JADX INFO: renamed from: j */
    private transient DurationField f15820j;

    /* JADX INFO: renamed from: k */
    private transient DurationField f15821k;

    /* JADX INFO: renamed from: l */
    private transient DurationField f15822l;

    /* JADX INFO: renamed from: m */
    private transient DurationField f15823m;

    /* JADX INFO: renamed from: n */
    private transient DurationField f15824n;

    /* JADX INFO: renamed from: o */
    private transient DateTimeField f15825o;

    /* JADX INFO: renamed from: p */
    private transient DateTimeField f15826p;

    /* JADX INFO: renamed from: q */
    private transient DateTimeField f15827q;

    /* JADX INFO: renamed from: r */
    private transient DateTimeField f15828r;

    /* JADX INFO: renamed from: s */
    private transient DateTimeField f15829s;

    /* JADX INFO: renamed from: t */
    private transient DateTimeField f15830t;

    /* JADX INFO: renamed from: u */
    private transient DateTimeField f15831u;

    /* JADX INFO: renamed from: v */
    private transient DateTimeField f15832v;

    /* JADX INFO: renamed from: w */
    private transient DateTimeField f15833w;

    /* JADX INFO: renamed from: x */
    private transient DateTimeField f15834x;

    /* JADX INFO: renamed from: y */
    private transient DateTimeField f15835y;

    /* JADX INFO: renamed from: z */
    private transient DateTimeField f15836z;

    /* JADX INFO: renamed from: a */
    protected abstract void mo16618a(Fields fields);

    protected AssembledChronology(Chronology chronology, Object obj) {
        this.f15811a = chronology;
        this.f15812b = obj;
        m16615N();
    }

    @Override // org.joda.time.Chronology
    /* JADX INFO: renamed from: a */
    public DateTimeZone mo16407a() {
        Chronology chronology = this.f15811a;
        if (chronology != null) {
            return chronology.mo16407a();
        }
        return null;
    }

    @Override // org.joda.time.chrono.BaseChronology, org.joda.time.Chronology
    /* JADX INFO: renamed from: a */
    public long mo16402a(int i, int i2, int i3, int i4) throws IllegalArgumentException {
        Chronology chronology = this.f15811a;
        return (chronology == null || (this.f15810L & 6) != 6) ? super.mo16402a(i, i2, i3, i4) : chronology.mo16402a(i, i2, i3, i4);
    }

    @Override // org.joda.time.chrono.BaseChronology, org.joda.time.Chronology
    /* JADX INFO: renamed from: a */
    public long mo16403a(int i, int i2, int i3, int i4, int i5, int i6, int i7) throws IllegalArgumentException {
        Chronology chronology = this.f15811a;
        return (chronology == null || (this.f15810L & 5) != 5) ? super.mo16403a(i, i2, i3, i4, i5, i6, i7) : chronology.mo16403a(i, i2, i3, i4, i5, i6, i7);
    }

    @Override // org.joda.time.chrono.BaseChronology, org.joda.time.Chronology
    /* JADX INFO: renamed from: a */
    public long mo16404a(long j, int i, int i2, int i3, int i4) throws IllegalArgumentException {
        Chronology chronology = this.f15811a;
        return (chronology == null || (this.f15810L & 1) != 1) ? super.mo16404a(j, i, i2, i3, i4) : chronology.mo16404a(j, i, i2, i3, i4);
    }

    @Override // org.joda.time.chrono.BaseChronology, org.joda.time.Chronology
    /* JADX INFO: renamed from: c */
    public final DurationField mo16409c() {
        return this.f15813c;
    }

    @Override // org.joda.time.chrono.BaseChronology, org.joda.time.Chronology
    /* JADX INFO: renamed from: d */
    public final DateTimeField mo16410d() {
        return this.f15825o;
    }

    @Override // org.joda.time.chrono.BaseChronology, org.joda.time.Chronology
    /* JADX INFO: renamed from: e */
    public final DateTimeField mo16411e() {
        return this.f15826p;
    }

    @Override // org.joda.time.chrono.BaseChronology, org.joda.time.Chronology
    /* JADX INFO: renamed from: f */
    public final DurationField mo16412f() {
        return this.f15814d;
    }

    @Override // org.joda.time.chrono.BaseChronology, org.joda.time.Chronology
    /* JADX INFO: renamed from: g */
    public final DateTimeField mo16413g() {
        return this.f15827q;
    }

    @Override // org.joda.time.chrono.BaseChronology, org.joda.time.Chronology
    /* JADX INFO: renamed from: h */
    public final DateTimeField mo16414h() {
        return this.f15828r;
    }

    @Override // org.joda.time.chrono.BaseChronology, org.joda.time.Chronology
    /* JADX INFO: renamed from: i */
    public final DurationField mo16415i() {
        return this.f15815e;
    }

    @Override // org.joda.time.chrono.BaseChronology, org.joda.time.Chronology
    /* JADX INFO: renamed from: j */
    public final DateTimeField mo16416j() {
        return this.f15829s;
    }

    @Override // org.joda.time.chrono.BaseChronology, org.joda.time.Chronology
    /* JADX INFO: renamed from: k */
    public final DateTimeField mo16417k() {
        return this.f15830t;
    }

    @Override // org.joda.time.chrono.BaseChronology, org.joda.time.Chronology
    /* JADX INFO: renamed from: l */
    public final DurationField mo16418l() {
        return this.f15816f;
    }

    @Override // org.joda.time.chrono.BaseChronology, org.joda.time.Chronology
    /* JADX INFO: renamed from: m */
    public final DateTimeField mo16419m() {
        return this.f15831u;
    }

    @Override // org.joda.time.chrono.BaseChronology, org.joda.time.Chronology
    /* JADX INFO: renamed from: n */
    public final DateTimeField mo16420n() {
        return this.f15832v;
    }

    @Override // org.joda.time.chrono.BaseChronology, org.joda.time.Chronology
    /* JADX INFO: renamed from: o */
    public final DurationField mo16421o() {
        return this.f15817g;
    }

    @Override // org.joda.time.chrono.BaseChronology, org.joda.time.Chronology
    /* JADX INFO: renamed from: p */
    public final DateTimeField mo16422p() {
        return this.f15833w;
    }

    @Override // org.joda.time.chrono.BaseChronology, org.joda.time.Chronology
    /* JADX INFO: renamed from: q */
    public final DateTimeField mo16423q() {
        return this.f15834x;
    }

    @Override // org.joda.time.chrono.BaseChronology, org.joda.time.Chronology
    /* JADX INFO: renamed from: r */
    public final DateTimeField mo16424r() {
        return this.f15835y;
    }

    @Override // org.joda.time.chrono.BaseChronology, org.joda.time.Chronology
    /* JADX INFO: renamed from: s */
    public final DurationField mo16425s() {
        return this.f15818h;
    }

    @Override // org.joda.time.chrono.BaseChronology, org.joda.time.Chronology
    /* JADX INFO: renamed from: t */
    public final DateTimeField mo16426t() {
        return this.f15836z;
    }

    @Override // org.joda.time.chrono.BaseChronology, org.joda.time.Chronology
    /* JADX INFO: renamed from: u */
    public final DateTimeField mo16427u() {
        return this.f15799A;
    }

    @Override // org.joda.time.chrono.BaseChronology, org.joda.time.Chronology
    /* JADX INFO: renamed from: v */
    public final DateTimeField mo16428v() {
        return this.f15800B;
    }

    @Override // org.joda.time.chrono.BaseChronology, org.joda.time.Chronology
    /* JADX INFO: renamed from: w */
    public final DurationField mo16429w() {
        return this.f15819i;
    }

    @Override // org.joda.time.chrono.BaseChronology, org.joda.time.Chronology
    /* JADX INFO: renamed from: x */
    public final DateTimeField mo16430x() {
        return this.f15801C;
    }

    @Override // org.joda.time.chrono.BaseChronology, org.joda.time.Chronology
    /* JADX INFO: renamed from: y */
    public final DurationField mo16431y() {
        return this.f15820j;
    }

    @Override // org.joda.time.chrono.BaseChronology, org.joda.time.Chronology
    /* JADX INFO: renamed from: z */
    public final DateTimeField mo16432z() {
        return this.f15802D;
    }

    @Override // org.joda.time.chrono.BaseChronology, org.joda.time.Chronology
    /* JADX INFO: renamed from: A */
    public final DateTimeField mo16391A() {
        return this.f15803E;
    }

    @Override // org.joda.time.chrono.BaseChronology, org.joda.time.Chronology
    /* JADX INFO: renamed from: B */
    public final DurationField mo16392B() {
        return this.f15821k;
    }

    @Override // org.joda.time.chrono.BaseChronology, org.joda.time.Chronology
    /* JADX INFO: renamed from: C */
    public final DateTimeField mo16393C() {
        return this.f15804F;
    }

    @Override // org.joda.time.chrono.BaseChronology, org.joda.time.Chronology
    /* JADX INFO: renamed from: D */
    public final DurationField mo16394D() {
        return this.f15822l;
    }

    @Override // org.joda.time.chrono.BaseChronology, org.joda.time.Chronology
    /* JADX INFO: renamed from: E */
    public final DateTimeField mo16395E() {
        return this.f15805G;
    }

    @Override // org.joda.time.chrono.BaseChronology, org.joda.time.Chronology
    /* JADX INFO: renamed from: F */
    public final DateTimeField mo16396F() {
        return this.f15806H;
    }

    @Override // org.joda.time.chrono.BaseChronology, org.joda.time.Chronology
    /* JADX INFO: renamed from: G */
    public final DateTimeField mo16397G() {
        return this.f15807I;
    }

    @Override // org.joda.time.chrono.BaseChronology, org.joda.time.Chronology
    /* JADX INFO: renamed from: H */
    public final DurationField mo16398H() {
        return this.f15823m;
    }

    @Override // org.joda.time.chrono.BaseChronology, org.joda.time.Chronology
    /* JADX INFO: renamed from: I */
    public final DateTimeField mo16399I() {
        return this.f15808J;
    }

    @Override // org.joda.time.chrono.BaseChronology, org.joda.time.Chronology
    /* JADX INFO: renamed from: J */
    public final DurationField mo16400J() {
        return this.f15824n;
    }

    @Override // org.joda.time.chrono.BaseChronology, org.joda.time.Chronology
    /* JADX INFO: renamed from: K */
    public final DateTimeField mo16401K() {
        return this.f15809K;
    }

    /* JADX INFO: renamed from: L */
    protected final Chronology m16616L() {
        return this.f15811a;
    }

    /* JADX INFO: renamed from: M */
    protected final Object m16617M() {
        return this.f15812b;
    }

    /* JADX INFO: renamed from: N */
    private void m16615N() {
        int i = 0;
        Fields fields = new Fields();
        if (this.f15811a != null) {
            fields.m16621a(this.f15811a);
        }
        mo16618a(fields);
        DurationField durationFieldMo16409c = fields.f15846a;
        if (durationFieldMo16409c == null) {
            durationFieldMo16409c = super.mo16409c();
        }
        this.f15813c = durationFieldMo16409c;
        DurationField durationFieldMo16412f = fields.f15847b;
        if (durationFieldMo16412f == null) {
            durationFieldMo16412f = super.mo16412f();
        }
        this.f15814d = durationFieldMo16412f;
        DurationField durationFieldMo16415i = fields.f15848c;
        if (durationFieldMo16415i == null) {
            durationFieldMo16415i = super.mo16415i();
        }
        this.f15815e = durationFieldMo16415i;
        DurationField durationFieldMo16418l = fields.f15849d;
        if (durationFieldMo16418l == null) {
            durationFieldMo16418l = super.mo16418l();
        }
        this.f15816f = durationFieldMo16418l;
        DurationField durationFieldMo16421o = fields.f15850e;
        if (durationFieldMo16421o == null) {
            durationFieldMo16421o = super.mo16421o();
        }
        this.f15817g = durationFieldMo16421o;
        DurationField durationFieldMo16425s = fields.f15851f;
        if (durationFieldMo16425s == null) {
            durationFieldMo16425s = super.mo16425s();
        }
        this.f15818h = durationFieldMo16425s;
        DurationField durationFieldMo16429w = fields.f15852g;
        if (durationFieldMo16429w == null) {
            durationFieldMo16429w = super.mo16429w();
        }
        this.f15819i = durationFieldMo16429w;
        DurationField durationFieldMo16431y = fields.f15853h;
        if (durationFieldMo16431y == null) {
            durationFieldMo16431y = super.mo16431y();
        }
        this.f15820j = durationFieldMo16431y;
        DurationField durationFieldMo16392B = fields.f15854i;
        if (durationFieldMo16392B == null) {
            durationFieldMo16392B = super.mo16392B();
        }
        this.f15821k = durationFieldMo16392B;
        DurationField durationFieldMo16394D = fields.f15855j;
        if (durationFieldMo16394D == null) {
            durationFieldMo16394D = super.mo16394D();
        }
        this.f15822l = durationFieldMo16394D;
        DurationField durationFieldMo16398H = fields.f15856k;
        if (durationFieldMo16398H == null) {
            durationFieldMo16398H = super.mo16398H();
        }
        this.f15823m = durationFieldMo16398H;
        DurationField durationFieldMo16400J = fields.f15857l;
        if (durationFieldMo16400J == null) {
            durationFieldMo16400J = super.mo16400J();
        }
        this.f15824n = durationFieldMo16400J;
        DateTimeField dateTimeFieldMo16410d = fields.f15858m;
        if (dateTimeFieldMo16410d == null) {
            dateTimeFieldMo16410d = super.mo16410d();
        }
        this.f15825o = dateTimeFieldMo16410d;
        DateTimeField dateTimeFieldMo16411e = fields.f15859n;
        if (dateTimeFieldMo16411e == null) {
            dateTimeFieldMo16411e = super.mo16411e();
        }
        this.f15826p = dateTimeFieldMo16411e;
        DateTimeField dateTimeFieldMo16413g = fields.f15860o;
        if (dateTimeFieldMo16413g == null) {
            dateTimeFieldMo16413g = super.mo16413g();
        }
        this.f15827q = dateTimeFieldMo16413g;
        DateTimeField dateTimeFieldMo16414h = fields.f15861p;
        if (dateTimeFieldMo16414h == null) {
            dateTimeFieldMo16414h = super.mo16414h();
        }
        this.f15828r = dateTimeFieldMo16414h;
        DateTimeField dateTimeFieldMo16416j = fields.f15862q;
        if (dateTimeFieldMo16416j == null) {
            dateTimeFieldMo16416j = super.mo16416j();
        }
        this.f15829s = dateTimeFieldMo16416j;
        DateTimeField dateTimeFieldMo16417k = fields.f15863r;
        if (dateTimeFieldMo16417k == null) {
            dateTimeFieldMo16417k = super.mo16417k();
        }
        this.f15830t = dateTimeFieldMo16417k;
        DateTimeField dateTimeFieldMo16419m = fields.f15864s;
        if (dateTimeFieldMo16419m == null) {
            dateTimeFieldMo16419m = super.mo16419m();
        }
        this.f15831u = dateTimeFieldMo16419m;
        DateTimeField dateTimeFieldMo16420n = fields.f15865t;
        if (dateTimeFieldMo16420n == null) {
            dateTimeFieldMo16420n = super.mo16420n();
        }
        this.f15832v = dateTimeFieldMo16420n;
        DateTimeField dateTimeFieldMo16422p = fields.f15866u;
        if (dateTimeFieldMo16422p == null) {
            dateTimeFieldMo16422p = super.mo16422p();
        }
        this.f15833w = dateTimeFieldMo16422p;
        DateTimeField dateTimeFieldMo16423q = fields.f15867v;
        if (dateTimeFieldMo16423q == null) {
            dateTimeFieldMo16423q = super.mo16423q();
        }
        this.f15834x = dateTimeFieldMo16423q;
        DateTimeField dateTimeFieldMo16424r = fields.f15868w;
        if (dateTimeFieldMo16424r == null) {
            dateTimeFieldMo16424r = super.mo16424r();
        }
        this.f15835y = dateTimeFieldMo16424r;
        DateTimeField dateTimeFieldMo16426t = fields.f15869x;
        if (dateTimeFieldMo16426t == null) {
            dateTimeFieldMo16426t = super.mo16426t();
        }
        this.f15836z = dateTimeFieldMo16426t;
        DateTimeField dateTimeFieldMo16427u = fields.f15870y;
        if (dateTimeFieldMo16427u == null) {
            dateTimeFieldMo16427u = super.mo16427u();
        }
        this.f15799A = dateTimeFieldMo16427u;
        DateTimeField dateTimeFieldMo16428v = fields.f15871z;
        if (dateTimeFieldMo16428v == null) {
            dateTimeFieldMo16428v = super.mo16428v();
        }
        this.f15800B = dateTimeFieldMo16428v;
        DateTimeField dateTimeFieldMo16430x = fields.f15837A;
        if (dateTimeFieldMo16430x == null) {
            dateTimeFieldMo16430x = super.mo16430x();
        }
        this.f15801C = dateTimeFieldMo16430x;
        DateTimeField dateTimeFieldMo16432z = fields.f15838B;
        if (dateTimeFieldMo16432z == null) {
            dateTimeFieldMo16432z = super.mo16432z();
        }
        this.f15802D = dateTimeFieldMo16432z;
        DateTimeField dateTimeFieldMo16391A = fields.f15839C;
        if (dateTimeFieldMo16391A == null) {
            dateTimeFieldMo16391A = super.mo16391A();
        }
        this.f15803E = dateTimeFieldMo16391A;
        DateTimeField dateTimeFieldMo16393C = fields.f15840D;
        if (dateTimeFieldMo16393C == null) {
            dateTimeFieldMo16393C = super.mo16393C();
        }
        this.f15804F = dateTimeFieldMo16393C;
        DateTimeField dateTimeFieldMo16395E = fields.f15841E;
        if (dateTimeFieldMo16395E == null) {
            dateTimeFieldMo16395E = super.mo16395E();
        }
        this.f15805G = dateTimeFieldMo16395E;
        DateTimeField dateTimeFieldMo16396F = fields.f15842F;
        if (dateTimeFieldMo16396F == null) {
            dateTimeFieldMo16396F = super.mo16396F();
        }
        this.f15806H = dateTimeFieldMo16396F;
        DateTimeField dateTimeFieldMo16397G = fields.f15843G;
        if (dateTimeFieldMo16397G == null) {
            dateTimeFieldMo16397G = super.mo16397G();
        }
        this.f15807I = dateTimeFieldMo16397G;
        DateTimeField dateTimeFieldMo16399I = fields.f15844H;
        if (dateTimeFieldMo16399I == null) {
            dateTimeFieldMo16399I = super.mo16399I();
        }
        this.f15808J = dateTimeFieldMo16399I;
        DateTimeField dateTimeFieldMo16401K = fields.f15845I;
        if (dateTimeFieldMo16401K == null) {
            dateTimeFieldMo16401K = super.mo16401K();
        }
        this.f15809K = dateTimeFieldMo16401K;
        if (this.f15811a != null) {
            int i2 = ((this.f15831u == this.f15811a.mo16419m() && this.f15829s == this.f15811a.mo16416j() && this.f15827q == this.f15811a.mo16413g() && this.f15825o == this.f15811a.mo16410d()) ? 1 : 0) | (this.f15826p == this.f15811a.mo16411e() ? 2 : 0);
            if (this.f15805G == this.f15811a.mo16395E() && this.f15804F == this.f15811a.mo16393C() && this.f15799A == this.f15811a.mo16427u()) {
                i = 4;
            }
            i |= i2;
        }
        this.f15810L = i;
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        m16615N();
    }

    public static final class Fields {

        /* JADX INFO: renamed from: A */
        public DateTimeField f15837A;

        /* JADX INFO: renamed from: B */
        public DateTimeField f15838B;

        /* JADX INFO: renamed from: C */
        public DateTimeField f15839C;

        /* JADX INFO: renamed from: D */
        public DateTimeField f15840D;

        /* JADX INFO: renamed from: E */
        public DateTimeField f15841E;

        /* JADX INFO: renamed from: F */
        public DateTimeField f15842F;

        /* JADX INFO: renamed from: G */
        public DateTimeField f15843G;

        /* JADX INFO: renamed from: H */
        public DateTimeField f15844H;

        /* JADX INFO: renamed from: I */
        public DateTimeField f15845I;

        /* JADX INFO: renamed from: a */
        public DurationField f15846a;

        /* JADX INFO: renamed from: b */
        public DurationField f15847b;

        /* JADX INFO: renamed from: c */
        public DurationField f15848c;

        /* JADX INFO: renamed from: d */
        public DurationField f15849d;

        /* JADX INFO: renamed from: e */
        public DurationField f15850e;

        /* JADX INFO: renamed from: f */
        public DurationField f15851f;

        /* JADX INFO: renamed from: g */
        public DurationField f15852g;

        /* JADX INFO: renamed from: h */
        public DurationField f15853h;

        /* JADX INFO: renamed from: i */
        public DurationField f15854i;

        /* JADX INFO: renamed from: j */
        public DurationField f15855j;

        /* JADX INFO: renamed from: k */
        public DurationField f15856k;

        /* JADX INFO: renamed from: l */
        public DurationField f15857l;

        /* JADX INFO: renamed from: m */
        public DateTimeField f15858m;

        /* JADX INFO: renamed from: n */
        public DateTimeField f15859n;

        /* JADX INFO: renamed from: o */
        public DateTimeField f15860o;

        /* JADX INFO: renamed from: p */
        public DateTimeField f15861p;

        /* JADX INFO: renamed from: q */
        public DateTimeField f15862q;

        /* JADX INFO: renamed from: r */
        public DateTimeField f15863r;

        /* JADX INFO: renamed from: s */
        public DateTimeField f15864s;

        /* JADX INFO: renamed from: t */
        public DateTimeField f15865t;

        /* JADX INFO: renamed from: u */
        public DateTimeField f15866u;

        /* JADX INFO: renamed from: v */
        public DateTimeField f15867v;

        /* JADX INFO: renamed from: w */
        public DateTimeField f15868w;

        /* JADX INFO: renamed from: x */
        public DateTimeField f15869x;

        /* JADX INFO: renamed from: y */
        public DateTimeField f15870y;

        /* JADX INFO: renamed from: z */
        public DateTimeField f15871z;

        Fields() {
        }

        /* JADX INFO: renamed from: a */
        public void m16621a(Chronology chronology) {
            DurationField durationFieldMo16409c = chronology.mo16409c();
            if (m16620a(durationFieldMo16409c)) {
                this.f15846a = durationFieldMo16409c;
            }
            DurationField durationFieldMo16412f = chronology.mo16412f();
            if (m16620a(durationFieldMo16412f)) {
                this.f15847b = durationFieldMo16412f;
            }
            DurationField durationFieldMo16415i = chronology.mo16415i();
            if (m16620a(durationFieldMo16415i)) {
                this.f15848c = durationFieldMo16415i;
            }
            DurationField durationFieldMo16418l = chronology.mo16418l();
            if (m16620a(durationFieldMo16418l)) {
                this.f15849d = durationFieldMo16418l;
            }
            DurationField durationFieldMo16421o = chronology.mo16421o();
            if (m16620a(durationFieldMo16421o)) {
                this.f15850e = durationFieldMo16421o;
            }
            DurationField durationFieldMo16425s = chronology.mo16425s();
            if (m16620a(durationFieldMo16425s)) {
                this.f15851f = durationFieldMo16425s;
            }
            DurationField durationFieldMo16429w = chronology.mo16429w();
            if (m16620a(durationFieldMo16429w)) {
                this.f15852g = durationFieldMo16429w;
            }
            DurationField durationFieldMo16431y = chronology.mo16431y();
            if (m16620a(durationFieldMo16431y)) {
                this.f15853h = durationFieldMo16431y;
            }
            DurationField durationFieldMo16392B = chronology.mo16392B();
            if (m16620a(durationFieldMo16392B)) {
                this.f15854i = durationFieldMo16392B;
            }
            DurationField durationFieldMo16394D = chronology.mo16394D();
            if (m16620a(durationFieldMo16394D)) {
                this.f15855j = durationFieldMo16394D;
            }
            DurationField durationFieldMo16398H = chronology.mo16398H();
            if (m16620a(durationFieldMo16398H)) {
                this.f15856k = durationFieldMo16398H;
            }
            DurationField durationFieldMo16400J = chronology.mo16400J();
            if (m16620a(durationFieldMo16400J)) {
                this.f15857l = durationFieldMo16400J;
            }
            DateTimeField dateTimeFieldMo16410d = chronology.mo16410d();
            if (m16619a(dateTimeFieldMo16410d)) {
                this.f15858m = dateTimeFieldMo16410d;
            }
            DateTimeField dateTimeFieldMo16411e = chronology.mo16411e();
            if (m16619a(dateTimeFieldMo16411e)) {
                this.f15859n = dateTimeFieldMo16411e;
            }
            DateTimeField dateTimeFieldMo16413g = chronology.mo16413g();
            if (m16619a(dateTimeFieldMo16413g)) {
                this.f15860o = dateTimeFieldMo16413g;
            }
            DateTimeField dateTimeFieldMo16414h = chronology.mo16414h();
            if (m16619a(dateTimeFieldMo16414h)) {
                this.f15861p = dateTimeFieldMo16414h;
            }
            DateTimeField dateTimeFieldMo16416j = chronology.mo16416j();
            if (m16619a(dateTimeFieldMo16416j)) {
                this.f15862q = dateTimeFieldMo16416j;
            }
            DateTimeField dateTimeFieldMo16417k = chronology.mo16417k();
            if (m16619a(dateTimeFieldMo16417k)) {
                this.f15863r = dateTimeFieldMo16417k;
            }
            DateTimeField dateTimeFieldMo16419m = chronology.mo16419m();
            if (m16619a(dateTimeFieldMo16419m)) {
                this.f15864s = dateTimeFieldMo16419m;
            }
            DateTimeField dateTimeFieldMo16420n = chronology.mo16420n();
            if (m16619a(dateTimeFieldMo16420n)) {
                this.f15865t = dateTimeFieldMo16420n;
            }
            DateTimeField dateTimeFieldMo16422p = chronology.mo16422p();
            if (m16619a(dateTimeFieldMo16422p)) {
                this.f15866u = dateTimeFieldMo16422p;
            }
            DateTimeField dateTimeFieldMo16423q = chronology.mo16423q();
            if (m16619a(dateTimeFieldMo16423q)) {
                this.f15867v = dateTimeFieldMo16423q;
            }
            DateTimeField dateTimeFieldMo16424r = chronology.mo16424r();
            if (m16619a(dateTimeFieldMo16424r)) {
                this.f15868w = dateTimeFieldMo16424r;
            }
            DateTimeField dateTimeFieldMo16426t = chronology.mo16426t();
            if (m16619a(dateTimeFieldMo16426t)) {
                this.f15869x = dateTimeFieldMo16426t;
            }
            DateTimeField dateTimeFieldMo16427u = chronology.mo16427u();
            if (m16619a(dateTimeFieldMo16427u)) {
                this.f15870y = dateTimeFieldMo16427u;
            }
            DateTimeField dateTimeFieldMo16428v = chronology.mo16428v();
            if (m16619a(dateTimeFieldMo16428v)) {
                this.f15871z = dateTimeFieldMo16428v;
            }
            DateTimeField dateTimeFieldMo16430x = chronology.mo16430x();
            if (m16619a(dateTimeFieldMo16430x)) {
                this.f15837A = dateTimeFieldMo16430x;
            }
            DateTimeField dateTimeFieldMo16432z = chronology.mo16432z();
            if (m16619a(dateTimeFieldMo16432z)) {
                this.f15838B = dateTimeFieldMo16432z;
            }
            DateTimeField dateTimeFieldMo16391A = chronology.mo16391A();
            if (m16619a(dateTimeFieldMo16391A)) {
                this.f15839C = dateTimeFieldMo16391A;
            }
            DateTimeField dateTimeFieldMo16393C = chronology.mo16393C();
            if (m16619a(dateTimeFieldMo16393C)) {
                this.f15840D = dateTimeFieldMo16393C;
            }
            DateTimeField dateTimeFieldMo16395E = chronology.mo16395E();
            if (m16619a(dateTimeFieldMo16395E)) {
                this.f15841E = dateTimeFieldMo16395E;
            }
            DateTimeField dateTimeFieldMo16396F = chronology.mo16396F();
            if (m16619a(dateTimeFieldMo16396F)) {
                this.f15842F = dateTimeFieldMo16396F;
            }
            DateTimeField dateTimeFieldMo16397G = chronology.mo16397G();
            if (m16619a(dateTimeFieldMo16397G)) {
                this.f15843G = dateTimeFieldMo16397G;
            }
            DateTimeField dateTimeFieldMo16399I = chronology.mo16399I();
            if (m16619a(dateTimeFieldMo16399I)) {
                this.f15844H = dateTimeFieldMo16399I;
            }
            DateTimeField dateTimeFieldMo16401K = chronology.mo16401K();
            if (m16619a(dateTimeFieldMo16401K)) {
                this.f15845I = dateTimeFieldMo16401K;
            }
        }

        /* JADX INFO: renamed from: a */
        private static boolean m16620a(DurationField durationField) {
            if (durationField == null) {
                return false;
            }
            return durationField.mo16558b();
        }

        /* JADX INFO: renamed from: a */
        private static boolean m16619a(DateTimeField dateTimeField) {
            if (dateTimeField == null) {
                return false;
            }
            return dateTimeField.mo16451c();
        }
    }
}
