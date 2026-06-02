package android.support.constraint.solver;

import android.support.constraint.solver.SolverVariable;
import com.facebook.appevents.AppEventsConstants;
import com.yalantis.ucrop.view.CropImageView;

/* JADX INFO: loaded from: classes.dex */
public class ArrayRow {

    /* JADX INFO: renamed from: d */
    final ArrayLinkedVariables f210d;

    /* JADX INFO: renamed from: a */
    SolverVariable f207a = null;

    /* JADX INFO: renamed from: b */
    float f208b = CropImageView.DEFAULT_ASPECT_RATIO;

    /* JADX INFO: renamed from: c */
    boolean f209c = false;

    /* JADX INFO: renamed from: e */
    boolean f211e = false;

    public ArrayRow(Cache cache) {
        this.f210d = new ArrayLinkedVariables(this, cache);
    }

    /* JADX INFO: renamed from: a */
    void m143a() {
        this.f210d.m125a(this);
    }

    /* JADX INFO: renamed from: b */
    boolean m149b() {
        return this.f207a != null && (this.f207a.f239f == SolverVariable.Type.UNRESTRICTED || this.f208b >= CropImageView.DEFAULT_ASPECT_RATIO);
    }

    public String toString() {
        return m151c();
    }

    /* JADX INFO: renamed from: c */
    String m151c() {
        String str;
        boolean z;
        float f;
        String str2;
        String str3 = (this.f207a == null ? "" + AppEventsConstants.EVENT_PARAM_VALUE_NO : "" + this.f207a) + " = ";
        if (this.f208b != CropImageView.DEFAULT_ASPECT_RATIO) {
            str = str3 + this.f208b;
            z = true;
        } else {
            str = str3;
            z = false;
        }
        int i = this.f210d.f196a;
        String str4 = str;
        for (int i2 = 0; i2 < i; i2++) {
            SolverVariable solverVariableM122a = this.f210d.m122a(i2);
            if (solverVariableM122a != null) {
                float fM129b = this.f210d.m129b(i2);
                String string = solverVariableM122a.toString();
                if (z) {
                    if (fM129b > CropImageView.DEFAULT_ASPECT_RATIO) {
                        str4 = str4 + " + ";
                        f = fM129b;
                    } else {
                        str4 = str4 + " - ";
                        f = fM129b * (-1.0f);
                    }
                } else if (fM129b < CropImageView.DEFAULT_ASPECT_RATIO) {
                    str4 = str4 + "- ";
                    f = fM129b * (-1.0f);
                } else {
                    f = fM129b;
                }
                if (f == 1.0f) {
                    str2 = str4 + string;
                } else {
                    str2 = str4 + f + " " + string;
                }
                str4 = str2;
                z = true;
            }
        }
        if (!z) {
            return str4 + "0.0";
        }
        return str4;
    }

    /* JADX INFO: renamed from: d */
    public void m152d() {
        this.f207a = null;
        this.f210d.m123a();
        this.f208b = CropImageView.DEFAULT_ASPECT_RATIO;
        this.f211e = false;
    }

    /* JADX INFO: renamed from: a */
    boolean m145a(SolverVariable solverVariable) {
        return this.f210d.m132b(solverVariable);
    }

    /* JADX INFO: renamed from: a */
    ArrayRow m136a(SolverVariable solverVariable, int i) {
        this.f207a = solverVariable;
        solverVariable.f237d = i;
        this.f208b = i;
        this.f211e = true;
        return this;
    }

    /* JADX INFO: renamed from: b */
    public ArrayRow m146b(SolverVariable solverVariable, int i) {
        if (i < 0) {
            this.f208b = i * (-1);
            this.f210d.m128a(solverVariable, 1.0f);
        } else {
            this.f208b = i;
            this.f210d.m128a(solverVariable, -1.0f);
        }
        return this;
    }

    /* JADX INFO: renamed from: a */
    public ArrayRow m138a(SolverVariable solverVariable, SolverVariable solverVariable2, int i) {
        boolean z = false;
        if (i != 0) {
            if (i < 0) {
                i *= -1;
                z = true;
            }
            this.f208b = i;
        }
        if (!z) {
            this.f210d.m128a(solverVariable, -1.0f);
            this.f210d.m128a(solverVariable2, 1.0f);
        } else {
            this.f210d.m128a(solverVariable, 1.0f);
            this.f210d.m128a(solverVariable2, -1.0f);
        }
        return this;
    }

    /* JADX INFO: renamed from: c */
    ArrayRow m150c(SolverVariable solverVariable, int i) {
        this.f210d.m128a(solverVariable, i);
        return this;
    }

    /* JADX INFO: renamed from: a */
    public ArrayRow m141a(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, int i) {
        boolean z = false;
        if (i != 0) {
            if (i < 0) {
                i *= -1;
                z = true;
            }
            this.f208b = i;
        }
        if (!z) {
            this.f210d.m128a(solverVariable, -1.0f);
            this.f210d.m128a(solverVariable2, 1.0f);
            this.f210d.m128a(solverVariable3, 1.0f);
        } else {
            this.f210d.m128a(solverVariable, 1.0f);
            this.f210d.m128a(solverVariable2, -1.0f);
            this.f210d.m128a(solverVariable3, -1.0f);
        }
        return this;
    }

    /* JADX INFO: renamed from: b */
    public ArrayRow m147b(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, int i) {
        boolean z = false;
        if (i != 0) {
            if (i < 0) {
                i *= -1;
                z = true;
            }
            this.f208b = i;
        }
        if (!z) {
            this.f210d.m128a(solverVariable, -1.0f);
            this.f210d.m128a(solverVariable2, 1.0f);
            this.f210d.m128a(solverVariable3, -1.0f);
        } else {
            this.f210d.m128a(solverVariable, 1.0f);
            this.f210d.m128a(solverVariable2, -1.0f);
            this.f210d.m128a(solverVariable3, 1.0f);
        }
        return this;
    }

    /* JADX INFO: renamed from: a */
    public ArrayRow m135a(float f, float f2, float f3, SolverVariable solverVariable, int i, SolverVariable solverVariable2, int i2, SolverVariable solverVariable3, int i3, SolverVariable solverVariable4, int i4) {
        if (f2 == CropImageView.DEFAULT_ASPECT_RATIO || f == f3) {
            this.f208b = ((-i) - i2) + i3 + i4;
            this.f210d.m128a(solverVariable, 1.0f);
            this.f210d.m128a(solverVariable2, -1.0f);
            this.f210d.m128a(solverVariable4, 1.0f);
            this.f210d.m128a(solverVariable3, -1.0f);
        } else {
            float f4 = (f / f2) / (f3 / f2);
            this.f208b = ((-i) - i2) + (i3 * f4) + (i4 * f4);
            this.f210d.m128a(solverVariable, 1.0f);
            this.f210d.m128a(solverVariable2, -1.0f);
            this.f210d.m128a(solverVariable4, f4);
            this.f210d.m128a(solverVariable3, -f4);
        }
        return this;
    }

    /* JADX INFO: renamed from: a */
    ArrayRow m139a(SolverVariable solverVariable, SolverVariable solverVariable2, int i, float f, SolverVariable solverVariable3, SolverVariable solverVariable4, int i2) {
        if (solverVariable2 == solverVariable3) {
            this.f210d.m128a(solverVariable, 1.0f);
            this.f210d.m128a(solverVariable4, 1.0f);
            this.f210d.m128a(solverVariable2, -2.0f);
        } else if (f == 0.5f) {
            this.f210d.m128a(solverVariable, 1.0f);
            this.f210d.m128a(solverVariable2, -1.0f);
            this.f210d.m128a(solverVariable3, -1.0f);
            this.f210d.m128a(solverVariable4, 1.0f);
            if (i > 0 || i2 > 0) {
                this.f208b = (-i) + i2;
            }
        } else if (f <= CropImageView.DEFAULT_ASPECT_RATIO) {
            this.f210d.m128a(solverVariable, -1.0f);
            this.f210d.m128a(solverVariable2, 1.0f);
            this.f208b = i;
        } else if (f >= 1.0f) {
            this.f210d.m128a(solverVariable3, -1.0f);
            this.f210d.m128a(solverVariable4, 1.0f);
            this.f208b = i2;
        } else {
            this.f210d.m128a(solverVariable, (1.0f - f) * 1.0f);
            this.f210d.m128a(solverVariable2, (1.0f - f) * (-1.0f));
            this.f210d.m128a(solverVariable3, (-1.0f) * f);
            this.f210d.m128a(solverVariable4, 1.0f * f);
            if (i > 0 || i2 > 0) {
                this.f208b = ((-i) * (1.0f - f)) + (i2 * f);
            }
        }
        return this;
    }

    /* JADX INFO: renamed from: a */
    public ArrayRow m137a(SolverVariable solverVariable, SolverVariable solverVariable2) {
        this.f210d.m128a(solverVariable, 1.0f);
        this.f210d.m128a(solverVariable2, -1.0f);
        return this;
    }

    /* JADX INFO: renamed from: a */
    ArrayRow m140a(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, float f) {
        this.f210d.m128a(solverVariable, -1.0f);
        this.f210d.m128a(solverVariable2, 1.0f - f);
        this.f210d.m128a(solverVariable3, f);
        return this;
    }

    /* JADX INFO: renamed from: a */
    public ArrayRow m142a(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, SolverVariable solverVariable4, float f) {
        this.f210d.m128a(solverVariable, -1.0f);
        this.f210d.m128a(solverVariable2, 1.0f);
        this.f210d.m128a(solverVariable3, f);
        this.f210d.m128a(solverVariable4, -f);
        return this;
    }

    /* JADX INFO: renamed from: a */
    boolean m144a(ArrayRow arrayRow) {
        this.f210d.m126a(this, arrayRow);
        return true;
    }

    /* JADX INFO: renamed from: e */
    void m153e() {
        if (this.f208b < CropImageView.DEFAULT_ASPECT_RATIO) {
            this.f208b *= -1.0f;
            this.f210d.m130b();
        }
    }

    /* JADX INFO: renamed from: f */
    void m154f() {
        SolverVariable solverVariableM134c = this.f210d.m134c();
        if (solverVariableM134c != null) {
            m148b(solverVariableM134c);
        }
        if (this.f210d.f196a == 0) {
            this.f211e = true;
        }
    }

    /* JADX INFO: renamed from: b */
    void m148b(SolverVariable solverVariable) {
        if (this.f207a != null) {
            this.f210d.m128a(this.f207a, -1.0f);
            this.f207a = null;
        }
        float fM121a = this.f210d.m121a(solverVariable) * (-1.0f);
        this.f207a = solverVariable;
        if (fM121a != 1.0f) {
            this.f208b /= fM121a;
            this.f210d.m124a(fM121a);
        }
    }
}
