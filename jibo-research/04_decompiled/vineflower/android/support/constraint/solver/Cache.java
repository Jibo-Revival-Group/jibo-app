package android.support.constraint.solver;

public class Cache {
   Pools.Pool<ArrayRow> a = new Pools.SimplePool<>(256);
   Pools.Pool<SolverVariable> b = new Pools.SimplePool<>(256);
   SolverVariable[] c = new SolverVariable[32];
}
