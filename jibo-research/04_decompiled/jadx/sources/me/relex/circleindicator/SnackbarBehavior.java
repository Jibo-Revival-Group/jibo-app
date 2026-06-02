package me.relex.circleindicator;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;
import com.yalantis.ucrop.view.CropImageView;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class SnackbarBehavior extends CoordinatorLayout.Behavior<CircleIndicator> {
    public SnackbarBehavior() {
    }

    public SnackbarBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public boolean mo478a(CoordinatorLayout coordinatorLayout, CircleIndicator circleIndicator, View view) {
        return view instanceof Snackbar.SnackbarLayout;
    }

    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public boolean mo481b(CoordinatorLayout coordinatorLayout, CircleIndicator circleIndicator, View view) {
        circleIndicator.setTranslationY(m15479a(coordinatorLayout, circleIndicator));
        return true;
    }

    /* JADX INFO: renamed from: a */
    private float m15479a(CoordinatorLayout coordinatorLayout, CircleIndicator circleIndicator) {
        float fMin = CropImageView.DEFAULT_ASPECT_RATIO;
        List<View> listM668c = coordinatorLayout.m668c(circleIndicator);
        int size = listM668c.size();
        int i = 0;
        while (i < size) {
            View view = listM668c.get(i);
            i++;
            fMin = ((view instanceof Snackbar.SnackbarLayout) && coordinatorLayout.m661a(circleIndicator, view)) ? Math.min(fMin, ViewCompat.m2605i(view) - view.getHeight()) : fMin;
        }
        return fMin;
    }
}
