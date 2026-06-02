package com.jibo.p019ui.view;

import android.R;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;

/* JADX INFO: loaded from: classes.dex */
public class BottomPanelButton_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b */
    private BottomPanelButton f11524b;

    public BottomPanelButton_ViewBinding(BottomPanelButton bottomPanelButton) {
        this(bottomPanelButton, bottomPanelButton);
    }

    public BottomPanelButton_ViewBinding(BottomPanelButton bottomPanelButton, View view) {
        this.f11524b = bottomPanelButton;
        bottomPanelButton.text = (TextView) Utils.m5161b(view, R.id.text1, "field 'text'", TextView.class);
        bottomPanelButton.icon = (ImageView) Utils.m5161b(view, R.id.icon, "field 'icon'", ImageView.class);
        bottomPanelButton.badge = (TextView) Utils.m5161b(view, R.id.text2, "field 'badge'", TextView.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        BottomPanelButton bottomPanelButton = this.f11524b;
        if (bottomPanelButton == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f11524b = null;
        bottomPanelButton.text = null;
        bottomPanelButton.icon = null;
        bottomPanelButton.badge = null;
    }
}
