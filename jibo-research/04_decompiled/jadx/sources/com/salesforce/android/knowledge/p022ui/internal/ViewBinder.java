package com.salesforce.android.knowledge.p022ui.internal;

import android.R;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes.dex */
public abstract class ViewBinder {
    /* JADX INFO: renamed from: a */
    public abstract View mo13413a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle);

    /* JADX INFO: renamed from: b */
    public abstract void mo13417b();

    /* JADX INFO: renamed from: a */
    public void mo13415a(Menu menu, MenuInflater menuInflater) {
    }

    /* JADX INFO: renamed from: a */
    public boolean mo13416a(MenuItem menuItem) {
        return false;
    }

    /* JADX INFO: renamed from: t_ */
    public boolean mo13421t_() {
        return false;
    }

    /* JADX INFO: renamed from: d */
    public Toolbar mo13419d() {
        return null;
    }

    /* JADX INFO: renamed from: e */
    public int mo13420e() {
        return R.color.white;
    }

    /* JADX INFO: renamed from: a */
    public void mo13414a(Bundle bundle) {
    }

    /* JADX INFO: renamed from: b */
    public void mo13418b(Bundle bundle) {
    }
}
