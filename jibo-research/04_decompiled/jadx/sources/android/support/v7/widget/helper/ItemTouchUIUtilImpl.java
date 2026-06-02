package android.support.v7.widget.helper;

import android.graphics.Canvas;
import android.support.v4.view.ViewCompat;
import android.support.v7.recyclerview.R;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.yalantis.ucrop.view.CropImageView;

/* JADX INFO: loaded from: classes.dex */
class ItemTouchUIUtilImpl {

    static class Api21Impl extends BaseImpl {
        Api21Impl() {
        }

        @Override // android.support.v7.widget.helper.ItemTouchUIUtilImpl.BaseImpl, android.support.v7.widget.helper.ItemTouchUIUtil
        /* JADX INFO: renamed from: a */
        public void mo5095a(Canvas canvas, RecyclerView recyclerView, View view, float f, float f2, int i, boolean z) {
            if (z && view.getTag(R.id.item_touch_helper_previous_elevation) == null) {
                Float fValueOf = Float.valueOf(ViewCompat.m2609m(view));
                ViewCompat.m2574a(view, 1.0f + m5099a(recyclerView, view));
                view.setTag(R.id.item_touch_helper_previous_elevation, fValueOf);
            }
            super.mo5095a(canvas, recyclerView, view, f, f2, i, z);
        }

        /* JADX INFO: renamed from: a */
        private float m5099a(RecyclerView recyclerView, View view) {
            int childCount = recyclerView.getChildCount();
            float f = 0.0f;
            for (int i = 0; i < childCount; i++) {
                View childAt = recyclerView.getChildAt(i);
                if (childAt != view) {
                    float fM2609m = ViewCompat.m2609m(childAt);
                    if (fM2609m > f) {
                        f = fM2609m;
                    }
                }
            }
            return f;
        }

        @Override // android.support.v7.widget.helper.ItemTouchUIUtilImpl.BaseImpl, android.support.v7.widget.helper.ItemTouchUIUtil
        /* JADX INFO: renamed from: a */
        public void mo5096a(View view) {
            Object tag = view.getTag(R.id.item_touch_helper_previous_elevation);
            if (tag != null && (tag instanceof Float)) {
                ViewCompat.m2574a(view, ((Float) tag).floatValue());
            }
            view.setTag(R.id.item_touch_helper_previous_elevation, null);
            super.mo5096a(view);
        }
    }

    static class BaseImpl implements ItemTouchUIUtil {
        BaseImpl() {
        }

        @Override // android.support.v7.widget.helper.ItemTouchUIUtil
        /* JADX INFO: renamed from: a */
        public void mo5096a(View view) {
            view.setTranslationX(CropImageView.DEFAULT_ASPECT_RATIO);
            view.setTranslationY(CropImageView.DEFAULT_ASPECT_RATIO);
        }

        @Override // android.support.v7.widget.helper.ItemTouchUIUtil
        /* JADX INFO: renamed from: b */
        public void mo5098b(View view) {
        }

        @Override // android.support.v7.widget.helper.ItemTouchUIUtil
        /* JADX INFO: renamed from: a */
        public void mo5095a(Canvas canvas, RecyclerView recyclerView, View view, float f, float f2, int i, boolean z) {
            view.setTranslationX(f);
            view.setTranslationY(f2);
        }

        @Override // android.support.v7.widget.helper.ItemTouchUIUtil
        /* JADX INFO: renamed from: b */
        public void mo5097b(Canvas canvas, RecyclerView recyclerView, View view, float f, float f2, int i, boolean z) {
        }
    }
}
