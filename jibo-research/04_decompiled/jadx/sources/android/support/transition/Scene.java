package android.support.transition;

import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes.dex */
public class Scene {

    /* JADX INFO: renamed from: a */
    private ViewGroup f1237a;

    /* JADX INFO: renamed from: b */
    private Runnable f1238b;

    /* JADX INFO: renamed from: a */
    public void m1189a() {
        if (m1187a(this.f1237a) == this && this.f1238b != null) {
            this.f1238b.run();
        }
    }

    /* JADX INFO: renamed from: a */
    static void m1188a(View view, Scene scene) {
        view.setTag(R.id.transition_current_scene, scene);
    }

    /* JADX INFO: renamed from: a */
    static Scene m1187a(View view) {
        return (Scene) view.getTag(R.id.transition_current_scene);
    }
}
