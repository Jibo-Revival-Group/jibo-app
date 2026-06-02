package android.support.constraint.solver;

import com.yalantis.ucrop.view.CropImageView;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class SolverVariable {

    /* JADX INFO: renamed from: i */
    private static int f233i = 1;

    /* JADX INFO: renamed from: d */
    public float f237d;

    /* JADX INFO: renamed from: f */
    Type f239f;

    /* JADX INFO: renamed from: j */
    private String f242j;

    /* JADX INFO: renamed from: a */
    public int f234a = -1;

    /* JADX INFO: renamed from: b */
    int f235b = -1;

    /* JADX INFO: renamed from: c */
    public int f236c = 0;

    /* JADX INFO: renamed from: e */
    float[] f238e = new float[6];

    /* JADX INFO: renamed from: g */
    ArrayRow[] f240g = new ArrayRow[8];

    /* JADX INFO: renamed from: h */
    int f241h = 0;

    public enum Type {
        UNRESTRICTED,
        CONSTANT,
        SLACK,
        ERROR,
        UNKNOWN
    }

    public SolverVariable(Type type) {
        this.f239f = type;
    }

    /* JADX INFO: renamed from: a */
    void m191a() {
        for (int i = 0; i < 6; i++) {
            this.f238e[i] = 0.0f;
        }
    }

    /* JADX INFO: renamed from: b */
    String m194b() {
        String str = this + "[";
        for (int i = 0; i < this.f238e.length; i++) {
            String str2 = str + this.f238e[i];
            if (i < this.f238e.length - 1) {
                str = str2 + ", ";
            } else {
                str = str2 + "] ";
            }
        }
        return str;
    }

    /* JADX INFO: renamed from: a */
    void m192a(ArrayRow arrayRow) {
        for (int i = 0; i < this.f241h; i++) {
            if (this.f240g[i] == arrayRow) {
                return;
            }
        }
        if (this.f241h >= this.f240g.length) {
            this.f240g = (ArrayRow[]) Arrays.copyOf(this.f240g, this.f240g.length * 2);
        }
        this.f240g[this.f241h] = arrayRow;
        this.f241h++;
    }

    /* JADX INFO: renamed from: b */
    void m195b(ArrayRow arrayRow) {
        for (int i = 0; i < this.f241h; i++) {
            if (this.f240g[i] == arrayRow) {
                for (int i2 = 0; i2 < (this.f241h - i) - 1; i2++) {
                    this.f240g[i + i2] = this.f240g[i + i2 + 1];
                }
                this.f241h--;
                return;
            }
        }
    }

    /* JADX INFO: renamed from: c */
    public void m196c() {
        this.f242j = null;
        this.f239f = Type.UNKNOWN;
        this.f236c = 0;
        this.f234a = -1;
        this.f235b = -1;
        this.f237d = CropImageView.DEFAULT_ASPECT_RATIO;
        this.f241h = 0;
    }

    /* JADX INFO: renamed from: a */
    public void m193a(Type type) {
        this.f239f = type;
    }

    public String toString() {
        return "" + this.f242j;
    }
}
