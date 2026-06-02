package android.support.constraint.solver;

import android.support.constraint.solver.SolverVariable;
import com.yalantis.ucrop.view.CropImageView;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class Goal {

    /* JADX INFO: renamed from: a */
    ArrayList<SolverVariable> f215a = new ArrayList<>();

    /* JADX INFO: renamed from: a */
    SolverVariable m156a() {
        int size = this.f215a.size();
        int i = 0;
        int i2 = 0;
        SolverVariable solverVariable = null;
        while (i < size) {
            SolverVariable solverVariable2 = this.f215a.get(i);
            SolverVariable solverVariable3 = solverVariable;
            for (int i3 = 5; i3 >= 0; i3--) {
                float f = solverVariable2.f238e[i3];
                if (solverVariable3 == null && f < CropImageView.DEFAULT_ASPECT_RATIO && i3 >= i2) {
                    i2 = i3;
                    solverVariable3 = solverVariable2;
                }
                if (f > CropImageView.DEFAULT_ASPECT_RATIO && i3 > i2) {
                    i2 = i3;
                    solverVariable3 = null;
                }
            }
            i++;
            solverVariable = solverVariable3;
        }
        return solverVariable;
    }

    /* JADX INFO: renamed from: b */
    private void m155b(LinearSystem linearSystem) {
        this.f215a.clear();
        for (int i = 1; i < linearSystem.f218b; i++) {
            SolverVariable solverVariable = linearSystem.f219c.f214c[i];
            for (int i2 = 0; i2 < 6; i2++) {
                solverVariable.f238e[i2] = 0.0f;
            }
            solverVariable.f238e[solverVariable.f236c] = 1.0f;
            if (solverVariable.f239f == SolverVariable.Type.ERROR) {
                this.f215a.add(solverVariable);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    void m157a(LinearSystem linearSystem) {
        m155b(linearSystem);
        int size = this.f215a.size();
        for (int i = 0; i < size; i++) {
            SolverVariable solverVariable = this.f215a.get(i);
            if (solverVariable.f235b != -1) {
                ArrayLinkedVariables arrayLinkedVariables = linearSystem.m172a(solverVariable.f235b).f210d;
                int i2 = arrayLinkedVariables.f196a;
                for (int i3 = 0; i3 < i2; i3++) {
                    SolverVariable solverVariableM122a = arrayLinkedVariables.m122a(i3);
                    if (solverVariableM122a != null) {
                        float fM129b = arrayLinkedVariables.m129b(i3);
                        for (int i4 = 0; i4 < 6; i4++) {
                            float[] fArr = solverVariableM122a.f238e;
                            fArr[i4] = fArr[i4] + (solverVariable.f238e[i4] * fM129b);
                        }
                        if (!this.f215a.contains(solverVariableM122a)) {
                            this.f215a.add(solverVariableM122a);
                        }
                    }
                }
                solverVariable.m191a();
            }
        }
    }

    public String toString() {
        int size = this.f215a.size();
        String str = "Goal: ";
        for (int i = 0; i < size; i++) {
            str = str + this.f215a.get(i).m194b();
        }
        return str;
    }
}
