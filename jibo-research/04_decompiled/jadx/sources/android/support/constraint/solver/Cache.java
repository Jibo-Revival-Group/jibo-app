package android.support.constraint.solver;

import android.support.constraint.solver.Pools;

/* JADX INFO: loaded from: classes.dex */
public class Cache {

    /* JADX INFO: renamed from: a */
    Pools.Pool<ArrayRow> f212a = new Pools.SimplePool(256);

    /* JADX INFO: renamed from: b */
    Pools.Pool<SolverVariable> f213b = new Pools.SimplePool(256);

    /* JADX INFO: renamed from: c */
    SolverVariable[] f214c = new SolverVariable[32];
}
