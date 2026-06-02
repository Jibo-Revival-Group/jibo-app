package com.jibo.p019ui.fragment.account.skills;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.TextView;
import butterknife.BindView;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.handlers.AsyncHandler;
import com.google.gson.Gson;
import com.jibo.R;
import com.jibo.aws.integration.aws.services.account.model.Account;
import com.jibo.aws.integration.aws.services.skills.JiboSkillsAsyncClient;
import com.jibo.aws.integration.aws.services.skills.model.UpdateSettingsRequest;
import com.jibo.aws.integration.helpers.RobotHelper;
import com.jibo.p018db.EntityData;
import com.jibo.p019ui.activity.SingleFragmentActivity;
import com.jibo.p019ui.fragment.settings.LocationFragment;
import com.jibo.p019ui.helpers.skills.DataItems;
import com.jibo.p019ui.helpers.skills.SkillsJsonParser;
import com.jibo.utils.SharedPreferencesUtil;
import com.jibo.utils.Util;

/* JADX INFO: loaded from: classes.dex */
public class LocationFragment extends com.jibo.p019ui.fragment.settings.LocationFragment {

    /* JADX INFO: renamed from: a */
    public static final String f10047a = LocationFragment.class.getSimpleName();

    /* JADX INFO: renamed from: b */
    private DataItems.LocationDataItem f10048b;

    /* JADX INFO: renamed from: c */
    private DataItems.LocationDataValue f10049c;

    /* JADX INFO: renamed from: p */
    private JiboSkillsAsyncClient f10050p;

    @BindView
    protected TextView txtLocation;

    @BindView
    protected TextView txtTimezone;

    @Override // com.jibo.p019ui.fragment.settings.LocationFragment, com.jibo.p019ui.fragment.BaseFragment, android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        Account accountM10134i = EntityData.m10089a(getActivity()).m10134i();
        if (accountM10134i != null) {
            JiboSkillsAsyncClient jiboSkillsAsyncClient = new JiboSkillsAsyncClient(new BasicAWSCredentials(accountM10134i.getAccessKeyId(), accountM10134i.getSecretAccessKey()));
            this.f10050p = jiboSkillsAsyncClient;
            m10336a(jiboSkillsAsyncClient);
        }
        this.f11032n = new C10671();
    }

    /* JADX INFO: renamed from: com.jibo.ui.fragment.account.skills.LocationFragment$1 */
    class C10671 implements LocationFragment.AsyncGeocoderTaskProcessor {
        C10671() {
        }

        @Override // com.jibo.ui.fragment.settings.LocationFragment.AsyncGeocoderTaskProcessor
        /* JADX INFO: renamed from: a */
        public void mo10394a(Bundle bundle) {
            try {
                if (LocationFragment.this.m10342d()) {
                    String string = LocationFragment.this.getString(R.string.error_message_could_not_get_location);
                    final SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(string);
                    spannableStringBuilder.setSpan(new StyleSpan(1), string.lastIndexOf(" "), string.length(), 33);
                    if (bundle == null || bundle.isEmpty()) {
                        LocationFragment.this.f11033o.m10506b(spannableStringBuilder);
                    }
                    final DataItems.LocationDataValue locationDataValue = new DataItems.LocationDataValue(Double.valueOf(bundle.getDouble(RobotHelper.FIELD_LATITUDE)), Double.valueOf(bundle.getDouble(RobotHelper.FIELD_LONGITUDE)), bundle.getString(RobotHelper.FIELD_CITY), bundle.getString("state"), bundle.getString(RobotHelper.FIELD_COUNTRY), bundle.getString(RobotHelper.FIELD_TIMEZONE), Util.m11499e(bundle.getString(RobotHelper.FIELD_ADDRESS_LINE)), Util.m11498d(bundle.getString(RobotHelper.FIELD_ADDRESS_LINE)));
                    LocationFragment.this.f10050p.updateSkill(SharedPreferencesUtil.m11443f(LocationFragment.this.getActivity()).getId(), new UpdateSettingsRequest.UpdateSettingData(LocationFragment.this.f10048b.getValueDefinition().getKey(), new UpdateSettingsRequest.UpdateSettingData.UpdateSettingValue(SkillsJsonParser.getInstance().getCurrentSkill().getSkillId(), LocationFragment.this.f10048b.getValueDefinition().getTarget(), new Gson().m9343a(locationDataValue))), new AsyncHandler<UpdateSettingsRequest, UpdateSettingsRequest.UpdateSettingData>() { // from class: com.jibo.ui.fragment.account.skills.LocationFragment.1.1
                        @Override // com.amazonaws.handlers.AsyncHandler
                        public void onError(Exception exc) {
                            LocationFragment.this.m10338a((Throwable) exc, "skills update skill", false);
                            LocationFragment.this.f11033o.m10506b(spannableStringBuilder);
                        }

                        @Override // com.amazonaws.handlers.AsyncHandler
                        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                        public void onSuccess(UpdateSettingsRequest updateSettingsRequest, UpdateSettingsRequest.UpdateSettingData updateSettingData) {
                            SkillsJsonParser.getInstance().updateData(LocationFragment.this.f10048b.getValueDefinition().getKey(), locationDataValue);
                            SkillsJsonParser.getInstance().setItemDataValue(LocationFragment.this.f10048b);
                            LocationFragment.this.f10049c = locationDataValue;
                            LocationFragment.this.m10337a(new Runnable() { // from class: com.jibo.ui.fragment.account.skills.LocationFragment.1.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    LocationFragment.this.mo10393a();
                                    LocationFragment.this.f11033o.m10505a(LocationFragment.this.getString(R.string.message_location_set));
                                }
                            });
                        }
                    });
                }
            } catch (Exception e) {
            }
        }
    }

    @Override // com.jibo.p019ui.fragment.settings.LocationFragment, com.jibo.p019ui.fragment.BaseFragment, android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString(DataItems.LocationDataItem.class.getSimpleName(), new Gson().m9362b(this.f10048b));
        bundle.putBoolean("ARGS_SKILL_FRAGMENT", true);
    }

    @Override // com.jibo.p019ui.fragment.BaseFragment
    /* JADX INFO: renamed from: b */
    public void mo10340b(Bundle bundle) {
        super.mo10340b(bundle);
        if (SkillsJsonParser.isCreated()) {
            this.f10048b = (DataItems.LocationDataItem) new Gson().m9355a(bundle.getString(DataItems.LocationDataItem.class.getSimpleName()), DataItems.LocationDataItem.class);
            SkillsJsonParser.getInstance().setItemDataValue(this.f10048b);
            this.f10049c = (DataItems.LocationDataValue) this.f10048b.getDataValue();
        }
    }

    @Override // com.jibo.p019ui.fragment.settings.LocationFragment, com.jibo.p019ui.fragment.BaseFragment
    /* JADX INFO: renamed from: a */
    protected void mo10334a(ActionBar actionBar) {
        super.mo10334a(actionBar);
        actionBar.setDisplayHomeAsUpEnabled(true);
    }

    @Override // com.jibo.p019ui.fragment.settings.LocationFragment, com.jibo.p019ui.fragment.BaseFragment
    /* JADX INFO: renamed from: o */
    protected String mo10353o() {
        return getString(R.string.title_location);
    }

    @Override // com.jibo.p019ui.fragment.settings.LocationFragment
    /* JADX INFO: renamed from: a */
    protected void mo10393a() {
        String string;
        StringBuilder sb = new StringBuilder();
        if (this.f10049c == null || TextUtils.isEmpty(this.f10049c.getFriendlyLocation())) {
            string = getString(R.string.robot_info_not_available);
        } else {
            string = this.f10049c.getFriendlyLocation();
        }
        sb.append(string);
        this.txtLocation.setText(sb.toString());
        String strReplace = (this.f10049c == null || this.f10049c.getFriendlyTimezone() == null) ? "" : this.f10049c.getFriendlyTimezone().replace("\\/", "/");
        TextView textView = this.txtTimezone;
        if (TextUtils.isEmpty(strReplace)) {
            strReplace = getString(R.string.text_location_not_set);
        }
        textView.setText(strReplace);
    }

    @Override // com.jibo.p019ui.fragment.settings.LocationFragment
    public void setManuallyClick(View view) {
        m11031a(new LocationFragment.ManualLocationFragmentListener() { // from class: com.jibo.ui.fragment.account.skills.LocationFragment.2
            @Override // com.jibo.ui.fragment.settings.LocationFragment.ManualLocationFragmentListener
            /* JADX INFO: renamed from: a */
            public void mo10396a(SingleFragmentActivity.Builder builder) {
                builder.m10274a("ARGS_SKILL_FRAGMENT", true);
            }
        });
    }
}
