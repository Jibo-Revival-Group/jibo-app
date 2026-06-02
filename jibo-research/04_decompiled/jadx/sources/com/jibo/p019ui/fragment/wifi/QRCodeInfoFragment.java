package com.jibo.p019ui.fragment.wifi;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.TextView;
import butterknife.OnClick;
import com.jibo.R;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class QRCodeInfoFragment extends WiFiBaseFragment {

    /* JADX INFO: renamed from: a */
    private final ArrayList<View> f11267a;

    @Override // com.jibo.p019ui.fragment.wifi.WiFiBaseFragment, com.jibo.p019ui.fragment.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_wifi_qr_info, viewGroup, false);
    }

    @OnClick
    public void onContinue(View view) {
        getActivity().finish();
    }

    @Override // com.jibo.p019ui.fragment.BaseFragment
    /* JADX INFO: renamed from: o */
    protected String mo10353o() {
        return getString(R.string.title_your_loops);
    }

    @Override // com.jibo.p019ui.fragment.wifi.WiFiBaseFragment, com.jibo.p019ui.fragment.BaseFragment
    /* JADX INFO: renamed from: a */
    protected void mo10334a(ActionBar actionBar) {
        super.mo10334a(actionBar);
        m11134b(actionBar);
    }

    /* JADX INFO: renamed from: b */
    private void m11134b(ActionBar actionBar) {
        actionBar.setBackgroundDrawable(new ColorDrawable(-1));
        actionBar.setHomeAsUpIndicator(R.drawable.arrow_blue);
    }

    @Override // android.support.v4.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        menuInflater.inflate(R.menu.menu_action_help, menu);
        super.onCreateOptionsMenu(menu, menuInflater);
        TextView textView = !this.f11267a.isEmpty() ? (TextView) this.f11267a.get(0) : null;
        if (textView != null) {
            textView.setTextColor(getResources().getColor(R.color.jibo_blue));
        } else {
            final View decorView = getActivity().getWindow().getDecorView();
            decorView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.jibo.ui.fragment.wifi.QRCodeInfoFragment.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    decorView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    decorView.findViewsWithText(QRCodeInfoFragment.this.f11267a, QRCodeInfoFragment.this.getString(R.string.action_help), 2);
                    QRCodeInfoFragment.this.getActivity().invalidateOptionsMenu();
                }
            });
        }
    }

    @Override // android.support.v4.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (R.id.action_help != menuItem.getItemId()) {
            return super.onOptionsItemSelected(menuItem);
        }
        startActivity(new Intent("android.intent.action.VIEW", Uri.parse(getString(R.string.support_url))));
        return true;
    }
}
