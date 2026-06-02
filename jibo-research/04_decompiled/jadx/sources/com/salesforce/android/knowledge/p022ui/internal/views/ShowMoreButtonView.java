package com.salesforce.android.knowledge.p022ui.internal.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.salesforce.android.service.common.p023ui.views.SalesforceTextView;

/* JADX INFO: loaded from: classes.dex */
public class ShowMoreButtonView extends SalesforceTextView {
    public ShowMoreButtonView(Context context) {
        super(context);
    }

    public ShowMoreButtonView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ShowMoreButtonView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            animate().alpha(0.5f).setDuration(100L).start();
        } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
            animate().alpha(1.0f).setDuration(100L).start();
        }
        return super.onTouchEvent(motionEvent);
    }
}
