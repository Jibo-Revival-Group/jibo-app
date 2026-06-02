package butterknife.internal;

import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public abstract class DebouncingOnClickListener implements View.OnClickListener {

    /* JADX INFO: renamed from: a */
    static boolean f4639a = true;

    /* JADX INFO: renamed from: b */
    private static final Runnable f4640b = new Runnable() { // from class: butterknife.internal.DebouncingOnClickListener.1
        @Override // java.lang.Runnable
        public void run() {
            DebouncingOnClickListener.f4639a = true;
        }
    };

    /* JADX INFO: renamed from: a */
    public abstract void mo5157a(View view);

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (f4639a) {
            f4639a = false;
            view.post(f4640b);
            mo5157a(view);
        }
    }
}
