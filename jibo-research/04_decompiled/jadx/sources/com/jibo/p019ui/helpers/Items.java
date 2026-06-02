package com.jibo.p019ui.helpers;

import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import com.jibo.R;
import com.jibo.aws.integration.aws.services.gqa.model.Attribution;
import com.jibo.aws.integration.aws.services.loop.model.Loop;
import com.jibo.aws.integration.aws.services.loop.model.Member;
import com.jibo.aws.integration.aws.services.notification.model.StatusContainer;
import com.jibo.aws.integration.aws.services.robotProperties.model.Robot;

/* JADX INFO: loaded from: classes.dex */
public class Items {

    public static class JiboHeaderItem extends LoopBasedItem {
    }

    public enum ItemType {
        jiboheader(R.layout.item_loop_jibo_header),
        settings(R.layout.item_loop_settings),
        wifisettings(R.layout.item_loop_wifisettings),
        subheader(R.layout.item_subheader),
        member(R.layout.item_loop_member_jibo_details),
        invite(R.layout.item_loop_member_invite),
        footer(R.layout.item_loop_footer),
        searchRecap(R.layout.item_search_recap),
        date(R.layout.item_date),
        header_with_button(R.layout.item_header_with_button),
        attribution(R.layout.item_attribution),
        text_button(R.layout.item_text_button),
        text_button_small(R.layout.item_text_button_small),
        text_button_small_red(R.layout.item_text_button_small_red),
        suspended_loop(R.layout.item_suspended_jibo),
        setup_jibo(R.layout.item_jibo_newjibo),
        switch_row(R.layout.item_switch),
        checkbox_row_leftsided(R.layout.item_checkbox_leftsided),
        checkbox_date_row_leftsided(R.layout.item_checkbox_date_leftsided),
        text_greyed_row(R.layout.item_text_greyed_row),
        text_bold_single_row(R.layout.item_text_bold_single_row),
        text_double_row(R.layout.item_text_double_row),
        text_double_greyed_row(R.layout.item_text_double_greyed_row),
        text_avatar_double_row(R.layout.item_text_avatar_double_row),
        text_avatar_radio_double_row(R.layout.item_text_avatar_radio_double_row),
        add_custom_holiday(R.layout.item_custom_holiday_add),
        dialog_bottom_sheet_item(R.layout.item_bottom_sheet_dialog),
        skill(R.layout.item_text_avatar_double_row),
        skill_footer(R.layout.item_loop_footer),
        skill_switch(R.layout.item_switch),
        skill_address_location_text_field(R.layout.item_address_location_text_field),
        skill_toggle(R.layout.item_checkbox_leftsided),
        skill_choice(R.layout.item_pseudo_radio_group),
        skill_time(R.layout.item_time),
        skill_connectable(R.layout.item_connectable),
        skill_oauth(R.layout.item_text_avatar_double_row);

        int layoutId;

        public int getLayoutId() {
            return this.layoutId;
        }

        ItemType(int i) {
            this.layoutId = i;
        }
    }

    public static abstract class Item {
        protected ItemType mItemType;
        private CompoundButton.OnCheckedChangeListener mOnCheckChangeListener;
        private View.OnClickListener mOnRowClickListener;

        protected Item(ItemType itemType) {
            this.mItemType = itemType;
        }

        protected Item(ItemType itemType, View.OnClickListener onClickListener) {
            this(itemType);
            this.mOnRowClickListener = onClickListener;
        }

        protected Item(ItemType itemType, View.OnClickListener onClickListener, CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
            this(itemType);
            this.mOnRowClickListener = onClickListener;
            this.mOnCheckChangeListener = onCheckedChangeListener;
        }

        public ItemType getItemType() {
            return this.mItemType;
        }

        public View.OnClickListener getOnRowClickListener() {
            return this.mOnRowClickListener;
        }

        public CompoundButton.OnCheckedChangeListener getCheckChangeListener() {
            return this.mOnCheckChangeListener;
        }
    }

    public static class SimpleItem extends Item {

        /* JADX INFO: renamed from: a */
        private int f11460a;

        /* JADX INFO: renamed from: b */
        private CharSequence f11461b;

        public SimpleItem(ItemType itemType) {
            super(itemType);
            this.f11460a = -1;
            this.f11461b = "";
        }

        public SimpleItem(ItemType itemType, View.OnClickListener onClickListener) {
            super(itemType, onClickListener);
            this.f11460a = -1;
            this.f11461b = "";
        }

        public SimpleItem(ItemType itemType, int i) {
            this(itemType);
            this.f11460a = i;
        }

        public SimpleItem(ItemType itemType, CharSequence charSequence) {
            this(itemType);
            this.f11461b = charSequence;
        }

        public SimpleItem(ItemType itemType, View.OnClickListener onClickListener, int i) {
            this(itemType, onClickListener);
            this.f11460a = i;
        }

        public SimpleItem(ItemType itemType, View.OnClickListener onClickListener, CharSequence charSequence) {
            this(itemType, onClickListener);
            this.f11461b = charSequence;
        }

        /* JADX INFO: renamed from: d */
        public int m11213d() {
            return this.f11460a;
        }

        /* JADX INFO: renamed from: e */
        public CharSequence m11214e() {
            return this.f11461b;
        }
    }

    public static class TwoRowsSimpleItem extends Item {

        /* JADX INFO: renamed from: a */
        private CharSequence f11464a;

        /* JADX INFO: renamed from: b */
        private CharSequence f11465b;

        public TwoRowsSimpleItem(ItemType itemType, CharSequence charSequence, CharSequence charSequence2) {
            super(itemType);
            this.f11464a = "";
            this.f11465b = "";
            this.f11464a = charSequence;
            this.f11465b = charSequence2;
        }

        public TwoRowsSimpleItem(ItemType itemType, View.OnClickListener onClickListener, CharSequence charSequence, CharSequence charSequence2) {
            super(itemType, onClickListener);
            this.f11464a = "";
            this.f11465b = "";
            this.f11464a = charSequence;
            this.f11465b = charSequence2;
        }

        public TwoRowsSimpleItem(CharSequence charSequence, CharSequence charSequence2) {
            this(ItemType.text_double_row, charSequence, charSequence2);
        }

        /* JADX INFO: renamed from: e */
        public CharSequence m11219e() {
            return this.f11464a;
        }

        /* JADX INFO: renamed from: f */
        public CharSequence m11220f() {
            return this.f11465b;
        }

        /* JADX INFO: renamed from: a */
        public void m11218a(CharSequence charSequence) {
            this.f11465b = charSequence;
        }
    }

    public static class AvatarTwoRowsSimpleItem extends TwoRowsSimpleItem {

        /* JADX INFO: renamed from: a */
        private String f11448a;

        /* JADX INFO: renamed from: b */
        private int f11449b;

        public AvatarTwoRowsSimpleItem(ItemType itemType, View.OnClickListener onClickListener, String str, String str2) {
            super(itemType, onClickListener, str, str2);
            this.f11448a = "";
            this.f11449b = -1;
        }

        public AvatarTwoRowsSimpleItem(View.OnClickListener onClickListener, String str, String str2) {
            this(ItemType.text_avatar_double_row, onClickListener, str, str2);
        }

        /* JADX INFO: renamed from: c */
        public String m11200c() {
            return this.f11448a;
        }

        /* JADX INFO: renamed from: a */
        public void m11199a(String str) {
            this.f11448a = str;
        }

        /* JADX INFO: renamed from: d */
        public int m11201d() {
            return this.f11449b;
        }

        /* JADX INFO: renamed from: a */
        public void m11198a(int i) {
            this.f11449b = i;
        }
    }

    public static class SubheaderItem extends SimpleItem {
        public SubheaderItem(int i) {
            super(ItemType.subheader, i);
        }

        public SubheaderItem(String str) {
            super(ItemType.subheader, str);
        }
    }

    public static class AttributionItem extends Item {

        /* JADX INFO: renamed from: a */
        private Attribution f11446a;

        public AttributionItem(Attribution attribution, View.OnClickListener onClickListener) {
            super(ItemType.attribution, onClickListener);
            this.f11446a = attribution;
        }

        /* JADX INFO: renamed from: a */
        public Attribution m11196a() {
            return this.f11446a;
        }
    }

    public static class DateItem extends SimpleItem {
        public DateItem(String str) {
            super(ItemType.date, str);
        }
    }

    public static class HeaderButtonItem extends SimpleItem {

        /* JADX INFO: renamed from: a */
        private int f11453a;

        /* JADX INFO: renamed from: a */
        public int m11205a() {
            return this.f11453a;
        }
    }

    public static abstract class LoopBasedItem extends SimpleItem {

        /* JADX INFO: renamed from: a */
        private Loop f11457a;

        public LoopBasedItem(ItemType itemType, Loop loop) {
            super(itemType);
            this.f11457a = loop;
        }

        public LoopBasedItem(ItemType itemType, View.OnClickListener onClickListener, Loop loop) {
            super(itemType, onClickListener);
            this.f11457a = loop;
        }

        /* JADX INFO: renamed from: a */
        public Loop m11210a() {
            return this.f11457a;
        }
    }

    public static class WifiSettingsItem extends Item {

        /* JADX INFO: renamed from: a */
        private Robot f11466a;

        /* JADX INFO: renamed from: b */
        private StatusContainer f11467b;

        public WifiSettingsItem() {
            super(ItemType.wifisettings);
        }

        public WifiSettingsItem(View.OnClickListener onClickListener) {
            super(ItemType.wifisettings, onClickListener);
        }

        /* JADX INFO: renamed from: a */
        public Robot m11221a() {
            return this.f11466a;
        }

        /* JADX INFO: renamed from: a */
        public void m11223a(Robot robot) {
            this.f11466a = robot;
        }

        /* JADX INFO: renamed from: b */
        public StatusContainer m11224b() {
            return this.f11467b;
        }

        /* JADX INFO: renamed from: a */
        public void m11222a(StatusContainer statusContainer) {
            this.f11467b = statusContainer;
        }
    }

    public static class JiboSettingsItem extends Item {

        /* JADX INFO: renamed from: a */
        private Robot f11456a;

        public JiboSettingsItem() {
            super(ItemType.settings);
        }

        public JiboSettingsItem(View.OnClickListener onClickListener, Robot robot) {
            super(ItemType.settings, onClickListener);
            this.f11456a = robot;
        }

        /* JADX INFO: renamed from: a */
        public Robot m11208a() {
            return this.f11456a;
        }

        /* JADX INFO: renamed from: a */
        public void m11209a(Robot robot) {
            this.f11456a = robot;
        }
    }

    public static class MemberItem extends LoopBasedItem {

        /* JADX INFO: renamed from: a */
        private Member f11458a;

        /* JADX INFO: renamed from: b */
        private Bundle f11459b;

        public MemberItem(Loop loop, Member member) {
            super(ItemType.member, loop);
            this.f11458a = member;
        }

        public MemberItem(View.OnClickListener onClickListener, Loop loop, Member member) {
            super(ItemType.member, onClickListener, loop);
            this.f11458a = member;
        }

        public MemberItem(View.OnClickListener onClickListener, Loop loop, Member member, Bundle bundle) {
            this(onClickListener, loop, member);
            this.f11459b = bundle;
        }

        /* JADX INFO: renamed from: b */
        public Member m11211b() {
            return this.f11458a;
        }

        /* JADX INFO: renamed from: c */
        public Bundle m11212c() {
            return this.f11459b;
        }
    }

    public static class FooterItem extends SimpleItem {

        /* JADX INFO: renamed from: a */
        protected CharSequence f11452a;

        public FooterItem(CharSequence charSequence) {
            super(ItemType.footer);
            this.f11452a = charSequence;
        }

        /* JADX INFO: renamed from: a */
        public CharSequence m11204a() {
            return this.f11452a;
        }
    }

    public static class SuspendedLoopItem extends Item {

        /* JADX INFO: renamed from: a */
        private Loop f11463a;

        public SuspendedLoopItem(View.OnClickListener onClickListener, Loop loop) {
            super(ItemType.suspended_loop, onClickListener);
            this.f11463a = loop;
        }

        /* JADX INFO: renamed from: a */
        public Loop m11217a() {
            return this.f11463a;
        }
    }

    public static abstract class StateSwitchItem extends SimpleItem {

        /* JADX INFO: renamed from: a */
        private boolean f11462a;

        public StateSwitchItem(ItemType itemType, View.OnClickListener onClickListener, int i, boolean z) {
            super(itemType, onClickListener, i);
            this.f11462a = false;
            this.f11462a = z;
        }

        public StateSwitchItem(ItemType itemType, View.OnClickListener onClickListener, String str, boolean z) {
            super(itemType, onClickListener, str);
            this.f11462a = false;
            this.f11462a = z;
        }

        /* JADX INFO: renamed from: c */
        public boolean m11216c() {
            return this.f11462a;
        }

        /* JADX INFO: renamed from: a */
        public void m11215a(boolean z) {
            this.f11462a = z;
        }
    }

    public static class SwitchRowItem extends StateSwitchItem {
        public SwitchRowItem(View.OnClickListener onClickListener, int i, boolean z) {
            super(ItemType.switch_row, onClickListener, i, z);
        }
    }

    public static class CheckboxItem extends StateSwitchItem {
        public CheckboxItem(View.OnClickListener onClickListener, String str, boolean z) {
            super(ItemType.checkbox_row_leftsided, onClickListener, str, z);
        }

        CheckboxItem(ItemType itemType, View.OnClickListener onClickListener, String str, boolean z) {
            super(itemType, onClickListener, str, z);
        }
    }

    public static class CheckboxDateItem extends CheckboxItem {

        /* JADX INFO: renamed from: a */
        private View.OnLongClickListener f11450a;

        /* JADX INFO: renamed from: b */
        private String f11451b;

        public CheckboxDateItem(View.OnClickListener onClickListener, View.OnLongClickListener onLongClickListener, String str, String str2, boolean z) {
            super(ItemType.checkbox_date_row_leftsided, onClickListener, str, z);
            this.f11450a = onLongClickListener;
            this.f11451b = str2;
        }

        /* JADX INFO: renamed from: a */
        public View.OnLongClickListener m11202a() {
            return this.f11450a;
        }

        /* JADX INFO: renamed from: b */
        public String m11203b() {
            return this.f11451b;
        }
    }

    public static class AvatarRadioTwoRowsSimpleItem extends AvatarTwoRowsSimpleItem {

        /* JADX INFO: renamed from: a */
        private boolean f11447a;

        public AvatarRadioTwoRowsSimpleItem(ItemType itemType, View.OnClickListener onClickListener, String str, String str2, boolean z) {
            super(itemType, onClickListener, str, str2);
            this.f11447a = false;
            this.f11447a = z;
        }

        public AvatarRadioTwoRowsSimpleItem(View.OnClickListener onClickListener, String str, String str2, boolean z) {
            this(ItemType.text_avatar_radio_double_row, onClickListener, str, str2, z);
        }

        /* JADX INFO: renamed from: b */
        public boolean m11197b() {
            return this.f11447a;
        }
    }

    public static class IconTextItem extends Item {

        /* JADX INFO: renamed from: a */
        private int f11454a;

        /* JADX INFO: renamed from: b */
        private CharSequence f11455b;

        public IconTextItem(ItemType itemType, View.OnClickListener onClickListener, int i, CharSequence charSequence) {
            super(itemType, onClickListener);
            this.f11454a = -1;
            this.f11455b = "";
            this.f11454a = i;
            this.f11455b = charSequence;
        }

        /* JADX INFO: renamed from: a */
        public int m11206a() {
            return this.f11454a;
        }

        /* JADX INFO: renamed from: b */
        public CharSequence m11207b() {
            return this.f11455b;
        }
    }
}
