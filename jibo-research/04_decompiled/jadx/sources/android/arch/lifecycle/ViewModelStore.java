package android.arch.lifecycle;

import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class ViewModelStore {

    /* JADX INFO: renamed from: a */
    private final HashMap<String, ViewModel> f69a = new HashMap<>();

    /* JADX INFO: renamed from: a */
    final void m102a(String str, ViewModel viewModel) {
        ViewModel viewModel2 = this.f69a.get(str);
        if (viewModel2 != null) {
            viewModel2.mo96a();
        }
        this.f69a.put(str, viewModel);
    }

    /* JADX INFO: renamed from: a */
    final ViewModel m100a(String str) {
        return this.f69a.get(str);
    }

    /* JADX INFO: renamed from: a */
    public final void m101a() {
        Iterator<ViewModel> it = this.f69a.values().iterator();
        while (it.hasNext()) {
            it.next().mo96a();
        }
        this.f69a.clear();
    }
}
