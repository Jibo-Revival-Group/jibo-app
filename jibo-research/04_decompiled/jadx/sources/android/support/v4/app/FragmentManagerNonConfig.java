package android.support.v4.app;

import android.arch.lifecycle.ViewModelStore;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class FragmentManagerNonConfig {

    /* JADX INFO: renamed from: a */
    private final List<Fragment> f1543a;

    /* JADX INFO: renamed from: b */
    private final List<FragmentManagerNonConfig> f1544b;

    /* JADX INFO: renamed from: c */
    private final List<ViewModelStore> f1545c;

    FragmentManagerNonConfig(List<Fragment> list, List<FragmentManagerNonConfig> list2, List<ViewModelStore> list3) {
        this.f1543a = list;
        this.f1544b = list2;
        this.f1545c = list3;
    }

    /* JADX INFO: renamed from: a */
    List<Fragment> m1609a() {
        return this.f1543a;
    }

    /* JADX INFO: renamed from: b */
    List<FragmentManagerNonConfig> m1610b() {
        return this.f1544b;
    }

    /* JADX INFO: renamed from: c */
    List<ViewModelStore> m1611c() {
        return this.f1545c;
    }
}
