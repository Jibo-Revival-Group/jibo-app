package okhttp3.internal.connection;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public final class RouteException extends RuntimeException {

    /* JADX INFO: renamed from: a */
    private static final Method f15340a;

    /* JADX INFO: renamed from: b */
    private IOException f15341b;

    static {
        Method declaredMethod;
        try {
            declaredMethod = Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class);
        } catch (Exception e) {
            declaredMethod = null;
        }
        f15340a = declaredMethod;
    }

    public RouteException(IOException iOException) {
        super(iOException);
        this.f15341b = iOException;
    }

    /* JADX INFO: renamed from: a */
    public IOException m15927a() {
        return this.f15341b;
    }

    /* JADX INFO: renamed from: a */
    public void m15928a(IOException iOException) {
        m15926a(iOException, this.f15341b);
        this.f15341b = iOException;
    }

    /* JADX INFO: renamed from: a */
    private void m15926a(IOException iOException, IOException iOException2) {
        if (f15340a != null) {
            try {
                f15340a.invoke(iOException, iOException2);
            } catch (IllegalAccessException e) {
            } catch (InvocationTargetException e2) {
            }
        }
    }
}
