package com.jibo.p019ui.helpers.skills;

import android.content.Intent;
import android.net.Uri;
import android.text.Html;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.CompoundButton;
import com.crashlytics.android.Crashlytics;
import com.jibo.p019ui.activity.SingleFragmentActivity;
import com.jibo.p019ui.helpers.Items;
import com.jibo.p019ui.helpers.skills.DataItems;
import com.jibo.p019ui.helpers.skills.SkillsJsonParser;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes.dex */
public class Items {

    public static abstract class SkillSimpleItem extends Items.Item {
        protected final DataItems.DataItem mDataItem;

        public SkillSimpleItem(Items.ItemType itemType, View.OnClickListener onClickListener, DataItems.DataItem dataItem) {
            super(itemType, onClickListener);
            this.mDataItem = dataItem;
        }

        public SkillSimpleItem(Items.ItemType itemType, DataItems.DataItem dataItem) {
            this(itemType, null, dataItem);
        }

        public SkillSimpleItem(Items.ItemType itemType, View.OnClickListener onClickListener, CompoundButton.OnCheckedChangeListener onCheckedChangeListener, DataItems.DataItem dataItem) {
            super(itemType, onClickListener, onCheckedChangeListener);
            this.mDataItem = dataItem;
        }

        public DataItems.DataItem getDataItem() {
            return this.mDataItem;
        }

        public boolean isGroupDataItem() {
            return this.mDataItem instanceof DataItems.GroupDataItem;
        }

        public DataItems.GroupDataItem getGroupDataItem() {
            return (DataItems.GroupDataItem) this.mDataItem;
        }

        public CharSequence getTitle() {
            return getGroupDataItem().getTitle();
        }

        public CharSequence getSubtitle() {
            return getGroupDataItem().getSubtitle();
        }
    }

    public static class SkillFooterItem extends SkillSimpleItem {
        private int mLinkColor;

        public SkillFooterItem(View.OnClickListener onClickListener, DataItems.FooterDataItem footerDataItem) {
            super(Items.ItemType.skill_footer, onClickListener, footerDataItem);
            this.mLinkColor = -16777216;
        }

        public SkillFooterItem(DataItems.FooterDataItem footerDataItem) {
            this(null, footerDataItem);
        }

        public void setLinkColor(int i) {
            this.mLinkColor = i;
        }

        @Override // com.jibo.ui.helpers.skills.Items.SkillSimpleItem
        public CharSequence getTitle() {
            int i;
            boolean z;
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(Html.fromHtml(this.mDataItem.getTitle()));
            if (((DataItems.FooterDataItem) this.mDataItem).getLinks() != null) {
                for (final DataItems.FooterDataItem.Link link : ((DataItems.FooterDataItem) this.mDataItem).getLinks()) {
                    if (!TextUtils.isEmpty(link.getPlaceholder())) {
                        boolean z2 = true;
                        int i2 = 0;
                        while (z2) {
                            int iIndexOf = spannableStringBuilder.toString().indexOf(link.getPlaceholder(), i2);
                            if (iIndexOf != -1) {
                                int length = link.getText().length() + iIndexOf;
                                spannableStringBuilder.delete(iIndexOf, link.getPlaceholder().length() + iIndexOf);
                                spannableStringBuilder.insert(iIndexOf, (CharSequence) link.getText());
                                spannableStringBuilder.setSpan(new ForegroundColorSpan(this.mLinkColor), iIndexOf, link.getText().length() + iIndexOf, 33);
                                spannableStringBuilder.setSpan(new ClickableSpan() { // from class: com.jibo.ui.helpers.skills.Items.SkillFooterItem.1
                                    @Override // android.text.style.ClickableSpan
                                    public void onClick(View view) {
                                        Class classForPlaceholder = SkillsJsonParser.TextLinksMatcher.getClassForPlaceholder(link.getPlaceholder());
                                        if (classForPlaceholder != null) {
                                            new SingleFragmentActivity.Builder(view.getContext(), classForPlaceholder.getName()).m10275a(999);
                                            return;
                                        }
                                        if (!TextUtils.isEmpty(link.getUrl())) {
                                            try {
                                                view.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(link.getUrl())));
                                            } catch (Exception e) {
                                                Crashlytics.m5597a((Throwable) e);
                                            }
                                        }
                                    }

                                    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                                    public void updateDrawState(TextPaint textPaint) {
                                        textPaint.setUnderlineText(false);
                                    }
                                }, iIndexOf, link.getText().length() + iIndexOf, 33);
                                i = length;
                                z = true;
                            } else {
                                i = i2;
                                z = false;
                            }
                            boolean z3 = z;
                            i2 = i;
                            z2 = z3;
                        }
                    }
                }
            }
            return spannableStringBuilder;
        }
    }

    public static abstract class StateItem extends SkillSimpleItem {
        public abstract boolean isChecked();

        public StateItem(Items.ItemType itemType, View.OnClickListener onClickListener, DataItems.DataItem dataItem) {
            super(itemType, onClickListener, dataItem);
        }

        public StateItem(Items.ItemType itemType, View.OnClickListener onClickListener, CompoundButton.OnCheckedChangeListener onCheckedChangeListener, DataItems.DataItem dataItem) {
            super(itemType, onClickListener, onCheckedChangeListener, dataItem);
        }
    }

    public static class SkillItem extends SkillSimpleItem {
        public SkillItem(View.OnClickListener onClickListener, DataItems.SkillViewDataItem skillViewDataItem) {
            super(Items.ItemType.skill, onClickListener, skillViewDataItem);
        }

        private DataItems.SkillViewDataItem getSkillViewDataItem() {
            return (DataItems.SkillViewDataItem) this.mDataItem;
        }

        public String getIcon() {
            return getSkillViewDataItem().getIcon();
        }
    }

    public static class SwitchItem extends StateItem {
        public SwitchItem(View.OnClickListener onClickListener, CompoundButton.OnCheckedChangeListener onCheckedChangeListener, DataItems.SwitchDataItem switchDataItem) {
            super(Items.ItemType.skill_switch, onClickListener, onCheckedChangeListener, switchDataItem);
        }

        @Override // com.jibo.ui.helpers.skills.Items.StateItem
        public boolean isChecked() {
            if (this.mDataItem == null || this.mDataItem.getDataValue() == null) {
                return false;
            }
            return ((DataItems.BooleanDataValue) this.mDataItem.getDataValue()).getValue();
        }

        private DataItems.SwitchDataItem getSwitchDataItem() {
            return (DataItems.SwitchDataItem) this.mDataItem;
        }

        public boolean hasChildren() {
            return (getSwitchDataItem().getChildViews() == null || getSwitchDataItem().getChildViews().isEmpty()) ? false : true;
        }
    }

    public static class LocationItem extends SkillSimpleItem {
        public LocationItem(Items.ItemType itemType, View.OnClickListener onClickListener, DataItems.DataItem dataItem) {
            super(itemType, onClickListener, dataItem);
        }

        public LocationItem(Items.ItemType itemType, DataItems.DataItem dataItem) {
            super(itemType, dataItem);
        }

        public LocationItem(View.OnClickListener onClickListener, DataItems.LocationDataItem locationDataItem) {
            this(Items.ItemType.skill_address_location_text_field, onClickListener, locationDataItem);
        }

        protected DataItems.LocationDataItem getLocationDataItem() {
            return (DataItems.LocationDataItem) this.mDataItem;
        }

        @Override // com.jibo.ui.helpers.skills.Items.SkillSimpleItem
        public String getTitle() {
            DataItems.LocationDataValue locationDataValue = (DataItems.LocationDataValue) getLocationDataItem().getDataValue();
            return locationDataValue != null ? locationDataValue.getFriendlyLocation() : "";
        }

        @Override // com.jibo.ui.helpers.skills.Items.SkillSimpleItem
        public String getSubtitle() {
            DataItems.LocationDataValue locationDataValue = (DataItems.LocationDataValue) getLocationDataItem().getDataValue();
            return locationDataValue != null ? locationDataValue.getFriendlyTimezone() : "";
        }
    }

    public static class ToggleItem extends StateItem {
        public ToggleItem(View.OnClickListener onClickListener, DataItems.ToggleDataItem toggleDataItem) {
            super(Items.ItemType.skill_toggle, onClickListener, toggleDataItem);
        }

        @Override // com.jibo.ui.helpers.skills.Items.StateItem
        public boolean isChecked() {
            if (this.mDataItem == null || this.mDataItem.getDataValue() == null) {
                return false;
            }
            return ((DataItems.BooleanDataValue) this.mDataItem.getDataValue()).getValue();
        }

        private DataItems.ToggleDataItem getToggleDataItem() {
            return (DataItems.ToggleDataItem) this.mDataItem;
        }

        @Override // com.jibo.ui.helpers.skills.Items.SkillSimpleItem
        public String getTitle() {
            return getToggleDataItem().getTitle();
        }
    }

    public static class ChoiceItem extends SkillSimpleItem {
        public ChoiceItem(View.OnClickListener onClickListener, DataItems.ChoiceDataItem choiceDataItem) {
            super(Items.ItemType.skill_choice, onClickListener, choiceDataItem);
        }

        private DataItems.ChoiceDataItem getChoiceDataItem() {
            return (DataItems.ChoiceDataItem) this.mDataItem;
        }

        public List<DataItems.ChoiceDataItem.ChoiceValueDataItem> getChoices() {
            return getChoiceDataItem().getChoices();
        }

        public int getSelectedValue() {
            if (getChoiceDataItem().getDataValue() != null) {
                return ((DataItems.IntegerDataValue) getChoiceDataItem().getDataValue()).getValue();
            }
            return -1;
        }
    }

    public static class TimeItem extends SkillSimpleItem {
        public TimeItem(View.OnClickListener onClickListener, DataItems.TimeDataItem timeDataItem) {
            super(Items.ItemType.skill_time, onClickListener, timeDataItem);
        }

        private DataItems.TimeDataItem getTimeDataItem() {
            return (DataItems.TimeDataItem) this.mDataItem;
        }

        public String getTime() {
            if (getTimeDataItem().getDataValue() == null) {
                return "";
            }
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("h:mm a");
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeZone(TimeZone.getTimeZone("GMT"));
            calendar.set(11, ((DataItems.TimeDataValue) getTimeDataItem().getDataValue()).getHour());
            calendar.set(12, ((DataItems.TimeDataValue) getTimeDataItem().getDataValue()).getMin());
            simpleDateFormat.format(calendar.getTime());
            return simpleDateFormat.format(calendar.getTime());
        }
    }

    public static class ConnectableItem extends StateItem {
        public ConnectableItem(View.OnClickListener onClickListener, DataItems.ConnectableDataItem connectableDataItem) {
            super(Items.ItemType.skill_connectable, onClickListener, connectableDataItem);
        }

        @Override // com.jibo.ui.helpers.skills.Items.StateItem
        public boolean isChecked() {
            if (this.mDataItem == null || this.mDataItem.getDataValue() == null) {
                return false;
            }
            return ((DataItems.ConnectableDataValue) getConnectableDataItem().getDataValue()).isConnected();
        }

        private DataItems.ConnectableDataItem getConnectableDataItem() {
            return (DataItems.ConnectableDataItem) this.mDataItem;
        }
    }

    public static class OauthItem extends SkillSimpleItem {
        public OauthItem(View.OnClickListener onClickListener, DataItems.OauthDataItem oauthDataItem) {
            super(Items.ItemType.skill_oauth, onClickListener, oauthDataItem);
        }

        private DataItems.OauthDataItem getOauthDataItem() {
            return (DataItems.OauthDataItem) this.mDataItem;
        }

        @Override // com.jibo.ui.helpers.skills.Items.SkillSimpleItem
        public String getTitle() {
            return getOauthDataItem() != null ? getOauthDataItem().getTitle() : "";
        }

        public String getIcon() {
            return getOauthDataItem() != null ? getOauthDataItem().getIcon() : "";
        }

        public String getOauthUrl() {
            return getOauthDataItem().getDataValue() != null ? ((DataItems.OauthDataValue) getOauthDataItem().getDataValue()).getAuthorizationUri() : "";
        }

        public String getCallbackUrl() {
            return getOauthDataItem().getDataValue() != null ? ((DataItems.OauthDataValue) getOauthDataItem().getDataValue()).getIosCallbackUri() : "";
        }
    }
}
