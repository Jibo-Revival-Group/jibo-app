package com.salesforce.android.knowledge.p022ui.internal.toolbar;

import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import com.salesforce.android.knowledge.p022ui.R;
import com.salesforce.android.knowledge.p022ui.internal.ViewBinder;

/* JADX INFO: loaded from: classes.dex */
public abstract class ToolbarViewBinder extends ViewBinder implements ToolbarView {

    /* JADX INFO: renamed from: a */
    private final ToolbarPresenter f13412a;

    @Override // com.salesforce.android.knowledge.p022ui.internal.ViewBinder
    /* JADX INFO: renamed from: d */
    public abstract Toolbar mo13419d();

    protected ToolbarViewBinder(ToolbarPresenter toolbarPresenter) {
        this.f13412a = toolbarPresenter;
    }

    @Override // com.salesforce.android.knowledge.p022ui.internal.ViewBinder
    /* JADX INFO: renamed from: t_ */
    public boolean mo13421t_() {
        return true;
    }

    @Override // com.salesforce.android.knowledge.p022ui.internal.ViewBinder
    /* JADX INFO: renamed from: a */
    public void mo13415a(Menu menu, MenuInflater menuInflater) {
        menuInflater.inflate(R.menu.knowledge_menu, menu);
    }

    @Override // com.salesforce.android.knowledge.p022ui.internal.ViewBinder
    /* JADX INFO: renamed from: a */
    public boolean mo13416a(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == R.id.knowledge_action_search) {
            this.f13412a.mo13445d();
            return true;
        }
        if (itemId == 16908332) {
            this.f13412a.mo13446e();
            return true;
        }
        return false;
    }

    @Override // com.salesforce.android.knowledge.p022ui.internal.toolbar.ToolbarView
    /* JADX INFO: renamed from: a */
    public void mo13686a(boolean z) {
        Toolbar toolbarMo13419d = mo13419d();
        if (z) {
            toolbarMo13419d.setNavigationIcon(R.drawable.knowledge_ic_home);
        } else {
            toolbarMo13419d.setNavigationIcon(R.drawable.knowledge_ic_nav_back);
        }
    }
}
