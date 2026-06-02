package com.jibo.p019ui.fragment.wifi;

import android.R;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.jibo.aws.integration.aws.services.loop.model.Loop;
import com.jibo.aws.integration.aws.services.oobe.model.TokenContainer;
import com.jibo.p019ui.activity.BaseActivity;
import com.jibo.utils.ImageUtils;
import com.jibo.utils.LogUtils;
import com.jibo.utils.QRCodeWriter;

/* JADX INFO: loaded from: classes.dex */
public class WiFiQRCodeFragment extends WiFiBaseQRCodeFragment {

    /* JADX INFO: renamed from: p */
    public static final String f11390p = LogUtils.m11405a(WiFiQRCodeFragment.class);

    @BindView
    View brightnessLess;

    @BindView
    View brightnessMore;

    @BindView
    View brightnessPanel;

    @BindView
    SeekBar brightnessSeekbar;

    @BindView
    ImageView btnDone;

    @BindView
    ImageView btnDone1;

    @BindView
    TextView btnNextCode;

    @BindView
    TextView btnPrevCode;

    @BindView
    View buttonsPanel;

    @BindView
    View multiCodeToolbar;

    @BindView
    View singleCodeToolbar;

    @BindView
    TextView txtProgress;

    @BindView
    View txtSingleCodeTitle;

    public final class QrCodeFragment_ViewBinding implements Unbinder {

        /* JADX INFO: renamed from: b */
        private QrCodeFragment f11397b;

        public QrCodeFragment_ViewBinding(QrCodeFragment qrCodeFragment, View view) {
            this.f11397b = qrCodeFragment;
            qrCodeFragment.text1 = (TextView) Utils.m5161b(view, R.id.text1, "field 'text1'", TextView.class);
            qrCodeFragment.imageQRCode = (ImageView) Utils.m5161b(view, com.jibo.R.id.imageQRCode, "field 'imageQRCode'", ImageView.class);
            qrCodeFragment.placeholder = Utils.m5158a(view, com.jibo.R.id.placeholder, "field 'placeholder'");
        }

        @Override // butterknife.Unbinder
        public void unbind() {
            QrCodeFragment qrCodeFragment = this.f11397b;
            if (qrCodeFragment == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.f11397b = null;
            qrCodeFragment.text1 = null;
            qrCodeFragment.imageQRCode = null;
            qrCodeFragment.placeholder = null;
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(com.jibo.R.layout.fragment_wifi_qr_code, viewGroup, false);
    }

    @Override // com.jibo.p019ui.fragment.BaseFragment, android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.btnDone.setImageDrawable(ImageUtils.m11392a(getActivity(), com.jibo.R.drawable.ic_check, com.jibo.R.color.jibo_blue));
        this.btnDone1.setImageDrawable(ImageUtils.m11392a(getActivity(), com.jibo.R.drawable.ic_check, com.jibo.R.color.jibo_blue));
        m11186u();
    }

    @Override // com.jibo.p019ui.fragment.wifi.WiFiBaseQRCodeFragment, com.jibo.p019ui.fragment.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        m11174a();
        m11175q();
    }

    @Override // com.jibo.p019ui.fragment.wifi.WiFiBaseQRCodeFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
    }

    @Override // android.support.v4.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (com.jibo.R.id.action_help != menuItem.getItemId()) {
            return super.onOptionsItemSelected(menuItem);
        }
        ((BaseActivity) getActivity()).m10193c(WiFiHelpFragment.class, null);
        return true;
    }

    @Override // com.jibo.p019ui.fragment.wifi.WiFiBaseQRCodeFragment, com.jibo.p019ui.fragment.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        m11157b();
    }

    @Override // com.jibo.p019ui.fragment.wifi.WiFiBaseQRCodeFragment, com.jibo.p019ui.fragment.wifi.WiFiBaseFragment, com.jibo.p019ui.fragment.BaseFragment
    /* JADX INFO: renamed from: a */
    protected void mo10334a(ActionBar actionBar) {
        super.mo10334a(actionBar);
    }

    @Override // com.jibo.p019ui.fragment.BaseFragment
    /* JADX INFO: renamed from: o */
    protected String mo10353o() {
        return "";
    }

    @OnClick
    public void onCloseClick() {
        mo10346h();
    }

    @OnClick
    public void onBtnDoneClick(View view) {
        Bundle bundle = new Bundle();
        bundle.putParcelable(Loop.class.getSimpleName(), this.f9934k);
        bundle.putSerializable(TokenContainer.class.getSimpleName(), this.f11326n);
        ((BaseActivity) getActivity()).m10187a(WiFiJiboConnectingFragment.class, bundle);
    }

    @OnClick
    public void onBtnNextCodeClick(View view) {
        this.f11324l++;
        m11185t();
    }

    @OnClick
    public void onBtnPrevCodeClick(View view) {
        this.f11324l--;
        m11185t();
    }

    @Override // com.jibo.p019ui.fragment.wifi.WiFiBaseQRCodeFragment
    /* JADX INFO: renamed from: s */
    protected void mo11177s() {
        if (m10342d()) {
            m11185t();
        }
    }

    /* JADX INFO: renamed from: t */
    private void m11185t() {
        this.txtSingleCodeTitle.setVisibility(8);
        this.singleCodeToolbar.setVisibility(4);
        this.multiCodeToolbar.setVisibility(8);
        this.btnNextCode.setEnabled(false);
        this.btnPrevCode.setEnabled(false);
        this.buttonsPanel.setVisibility(8);
        this.f11324l = this.f11324l >= this.f11325m.size() + (-1) ? this.f11325m.size() - 1 : this.f11324l;
        this.f11324l = this.f11324l < 0 ? 0 : this.f11324l;
        if (this.f11325m.size() > 1) {
            this.btnDone1.setVisibility(8);
            this.btnNextCode.setVisibility(0);
            this.multiCodeToolbar.setVisibility(0);
            this.txtProgress.setText(String.valueOf(this.f11324l + 1));
            this.buttonsPanel.setVisibility(0);
            if (this.f11324l + 1 < this.f11325m.size()) {
                this.btnNextCode.setEnabled(true);
            }
            if (this.f11324l - 1 >= 0) {
                this.btnPrevCode.setEnabled(true);
            }
            if (this.f11324l == this.f11325m.size() - 1) {
                this.btnNextCode.setVisibility(8);
                this.btnDone1.setVisibility(0);
            }
            this.brightnessLess.setLayoutParams(new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(com.jibo.R.dimen.seekbar_size_small), getResources().getDimensionPixelSize(com.jibo.R.dimen.seekbar_size_small)));
            this.brightnessMore.setLayoutParams(new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(com.jibo.R.dimen.seekbar_size_small), getResources().getDimensionPixelSize(com.jibo.R.dimen.seekbar_size_small)));
        } else {
            this.singleCodeToolbar.setVisibility(0);
            this.txtSingleCodeTitle.setVisibility(0);
            this.brightnessLess.setLayoutParams(new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(com.jibo.R.dimen.seekbar_size_normal), getResources().getDimensionPixelSize(com.jibo.R.dimen.seekbar_size_normal)));
            this.brightnessMore.setLayoutParams(new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(com.jibo.R.dimen.seekbar_size_normal), getResources().getDimensionPixelSize(com.jibo.R.dimen.seekbar_size_normal)));
        }
        FragmentTransaction fragmentTransactionMo1471a = getChildFragmentManager().mo1471a();
        Bundle bundle = new Bundle();
        bundle.putInt("ARG_INDX", this.f11324l + 1);
        bundle.putInt("ARG_COUNT", this.f11325m.size());
        bundle.putString("ARG_DATA", this.f11325m.get(this.f11324l));
        fragmentTransactionMo1471a.mo1378b(com.jibo.R.id.fragment_code, Fragment.instantiate(getActivity(), QrCodeFragment.class.getName(), bundle));
        fragmentTransactionMo1471a.mo1385d();
        m10341c().postDelayed(new Runnable() { // from class: com.jibo.ui.fragment.wifi.WiFiQRCodeFragment.2
            @Override // java.lang.Runnable
            public void run() {
                WiFiQRCodeFragment.this.brightnessPanel.setVisibility(0);
            }
        }, 200L);
    }

    public static final class QrCodeFragment extends Fragment {

        /* JADX INFO: renamed from: a */
        Unbinder f11393a;

        /* JADX INFO: renamed from: b */
        private int f11394b;

        /* JADX INFO: renamed from: c */
        private int f11395c;

        /* JADX INFO: renamed from: d */
        private String f11396d;

        @BindView
        ImageView imageQRCode;

        @BindView
        View placeholder;

        @BindView
        TextView text1;

        @Override // android.support.v4.app.Fragment
        public void onCreate(Bundle bundle) {
            super.onCreate(bundle);
            if (getArguments() != null) {
                this.f11394b = getArguments().getInt("ARG_COUNT", 1);
                this.f11395c = getArguments().getInt("ARG_INDX", 1);
                this.f11396d = getArguments().getString("ARG_DATA", "");
            }
        }

        @Override // android.support.v4.app.Fragment
        public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            return layoutInflater.inflate(com.jibo.R.layout.fragment_wifi_qr_code_ncode, viewGroup, false);
        }

        @Override // android.support.v4.app.Fragment
        public void onViewCreated(View view, Bundle bundle) {
            super.onViewCreated(view, bundle);
            this.f11393a = ButterKnife.m5154a(this, view);
            int i = this.f11394b == 1 ? com.jibo.R.string.msg_show_qr_code_to_jibo : -1;
            if (i == -1) {
                if (this.f11395c == 1) {
                    i = com.jibo.R.string.msg_show_qr_code_to_jibo_step_1;
                } else {
                    i = this.f11395c == this.f11394b ? com.jibo.R.string.msg_show_qr_code_to_jibo_step_last : com.jibo.R.string.msg_show_qr_code_to_jibo_step_N;
                }
            }
            this.text1.setText(i);
            if (this.f11394b > 1) {
                this.placeholder.setVisibility(0);
                this.text1.setMinLines(3);
                this.text1.setPadding(getResources().getDimensionPixelSize(com.jibo.R.dimen.activity_horizontal_margin), 0, getResources().getDimensionPixelSize(com.jibo.R.dimen.activity_horizontal_margin), getResources().getDimensionPixelSize(com.jibo.R.dimen.activity_horizontal_margin));
            } else {
                this.placeholder.setVisibility(8);
                this.text1.setMinLines(0);
                this.text1.setPadding(getResources().getDimensionPixelSize(com.jibo.R.dimen.activity_horizontal_margin), getResources().getDimensionPixelSize(com.jibo.R.dimen.activity_double_vertical_margin), getResources().getDimensionPixelSize(com.jibo.R.dimen.activity_horizontal_margin), 0);
            }
            m11187a();
        }

        @Override // android.support.v4.app.Fragment
        public void onDestroyView() {
            super.onDestroyView();
            this.f11393a.unbind();
        }

        /* JADX INFO: renamed from: a */
        private void m11187a() {
            int color;
            try {
                Display defaultDisplay = ((WindowManager) getActivity().getSystemService("window")).getDefaultDisplay();
                Point point = new Point();
                defaultDisplay.getSize(point);
                int i = point.x;
                int i2 = point.y;
                int dimensionPixelSize = i - (getResources().getDimensionPixelSize(com.jibo.R.dimen.activity_horizontal_margin) * 2);
                BitMatrix bitMatrixM11423a = new QRCodeWriter().m11423a(this.f11396d, BarcodeFormat.QR_CODE, dimensionPixelSize, dimensionPixelSize);
                if (Build.VERSION.SDK_INT >= 23) {
                    color = getResources().getColor(R.color.black, getActivity().getTheme());
                } else {
                    color = getResources().getColor(R.color.black);
                }
                int iM9674a = bitMatrixM11423a.m9674a();
                int iM9679b = bitMatrixM11423a.m9679b();
                int[] iArr = new int[iM9674a * iM9679b];
                for (int i3 = 0; i3 < iM9679b; i3++) {
                    int i4 = i3 * iM9674a;
                    for (int i5 = 0; i5 < iM9674a; i5++) {
                        iArr[i4 + i5] = bitMatrixM11423a.m9678a(i5, i3) ? color : -1;
                    }
                }
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iM9674a, iM9679b, Bitmap.Config.ARGB_8888);
                bitmapCreateBitmap.setPixels(iArr, 0, iM9674a, 0, 0, iM9674a, iM9679b);
                this.imageQRCode.setImageBitmap(bitmapCreateBitmap);
            } catch (WriterException e) {
                LogUtils.m11408a(WiFiQRCodeFragment.f11390p, "generateCode", e);
            }
        }
    }

    /* JADX INFO: renamed from: u */
    private void m11186u() {
        WindowManager.LayoutParams attributes = getActivity().getWindow().getAttributes();
        attributes.screenBrightness = 0.75f;
        getActivity().getWindow().setAttributes(attributes);
        this.brightnessSeekbar.setMax(100);
        this.brightnessSeekbar.setProgress(75);
        this.brightnessSeekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.jibo.ui.fragment.wifi.WiFiQRCodeFragment.5
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                WindowManager.LayoutParams attributes2 = WiFiQRCodeFragment.this.getActivity().getWindow().getAttributes();
                attributes2.screenBrightness = i / 100.0f;
                WiFiQRCodeFragment.this.getActivity().getWindow().setAttributes(attributes2);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
    }
}
