package com.jibo.ui.helpers;

import android.os.Bundle;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.jibo.aws.integration.aws.services.gqa.model.Attribution;
import com.jibo.aws.integration.aws.services.loop.model.Loop;
import com.jibo.aws.integration.aws.services.loop.model.Member;
import com.jibo.aws.integration.aws.services.notification.model.StatusContainer;
import com.jibo.aws.integration.aws.services.robotProperties.model.Robot;

public class Items {
   public static class AttributionItem extends Items.Item {
      private Attribution a;

      public AttributionItem(Attribution var1, OnClickListener var2) {
         super(Items.ItemType.attribution, var2);
         this.a = var1;
      }

      public Attribution a() {
         return this.a;
      }
   }

   public static class AvatarRadioTwoRowsSimpleItem extends Items.AvatarTwoRowsSimpleItem {
      private boolean a = false;

      public AvatarRadioTwoRowsSimpleItem(OnClickListener var1, String var2, String var3, boolean var4) {
         this(Items.ItemType.text_avatar_radio_double_row, var1, var2, var3, var4);
      }

      public AvatarRadioTwoRowsSimpleItem(Items.ItemType var1, OnClickListener var2, String var3, String var4, boolean var5) {
         super(var1, var2, var3, var4);
         this.a = var5;
      }

      public boolean b() {
         return this.a;
      }
   }

   public static class AvatarTwoRowsSimpleItem extends Items.TwoRowsSimpleItem {
      private String a = "";
      private int b = -1;

      public AvatarTwoRowsSimpleItem(OnClickListener var1, String var2, String var3) {
         this(Items.ItemType.text_avatar_double_row, var1, var2, var3);
      }

      public AvatarTwoRowsSimpleItem(Items.ItemType var1, OnClickListener var2, String var3, String var4) {
         super(var1, var2, var3, var4);
      }

      public void a(int var1) {
         this.b = var1;
      }

      public void a(String var1) {
         this.a = var1;
      }

      public String c() {
         return this.a;
      }

      public int d() {
         return this.b;
      }
   }

   public static class CheckboxDateItem extends Items.CheckboxItem {
      private OnLongClickListener a;
      private String b;

      public CheckboxDateItem(OnClickListener var1, OnLongClickListener var2, String var3, String var4, boolean var5) {
         super(Items.ItemType.checkbox_date_row_leftsided, var1, var3, var5);
         this.a = var2;
         this.b = var4;
      }

      public OnLongClickListener a() {
         return this.a;
      }

      public String b() {
         return this.b;
      }
   }

   public static class CheckboxItem extends Items.StateSwitchItem {
      public CheckboxItem(OnClickListener var1, String var2, boolean var3) {
         super(Items.ItemType.checkbox_row_leftsided, var1, var2, var3);
      }

      CheckboxItem(Items.ItemType var1, OnClickListener var2, String var3, boolean var4) {
         super(var1, var2, var3, var4);
      }
   }

   public static class DateItem extends Items.SimpleItem {
      public DateItem(String var1) {
         super(Items.ItemType.date, var1);
      }
   }

   public static class FooterItem extends Items.SimpleItem {
      protected CharSequence a;

      public FooterItem(CharSequence var1) {
         super(Items.ItemType.footer);
         this.a = var1;
      }

      public CharSequence a() {
         return this.a;
      }
   }

   public static class HeaderButtonItem extends Items.SimpleItem {
      private int a;

      public int a() {
         return this.a;
      }
   }

   public static class IconTextItem extends Items.Item {
      private int a = -1;
      private CharSequence b = "";

      public IconTextItem(Items.ItemType var1, OnClickListener var2, int var3, CharSequence var4) {
         super(var1, var2);
         this.a = var3;
         this.b = var4;
      }

      public int a() {
         return this.a;
      }

      public CharSequence b() {
         return this.b;
      }
   }

   public abstract static class Item {
      protected Items.ItemType mItemType;
      private OnCheckedChangeListener mOnCheckChangeListener;
      private OnClickListener mOnRowClickListener;

      protected Item(Items.ItemType var1) {
         this.mItemType = var1;
      }

      protected Item(Items.ItemType var1, OnClickListener var2) {
         this(var1);
         this.mOnRowClickListener = var2;
      }

      protected Item(Items.ItemType var1, OnClickListener var2, OnCheckedChangeListener var3) {
         this(var1);
         this.mOnRowClickListener = var2;
         this.mOnCheckChangeListener = var3;
      }

      public OnCheckedChangeListener getCheckChangeListener() {
         return this.mOnCheckChangeListener;
      }

      public Items.ItemType getItemType() {
         return this.mItemType;
      }

      public OnClickListener getOnRowClickListener() {
         return this.mOnRowClickListener;
      }
   }

   public enum ItemType {
      add_custom_holiday(2131427505),
      attribution(2131427500),
      checkbox_date_row_leftsided(2131427502),
      checkbox_row_leftsided(2131427503),
      date(2131427506),
      dialog_bottom_sheet_item(2131427501),
      footer(2131427514),
      header_with_button(2131427508),
      invite(2131427517),
      jiboheader(2131427516),
      member(2131427518),
      searchRecap(2131427531),
      settings(2131427519),
      setup_jibo(2131427513),
      skill(2131427536),
      skill_address_location_text_field(2131427499),
      skill_choice(2131427529),
      skill_connectable(2131427504),
      skill_footer(2131427514),
      skill_oauth(2131427536),
      skill_switch(2131427535),
      skill_time(2131427545),
      skill_toggle(2131427503),
      subheader(2131427533),
      suspended_loop(2131427534),
      switch_row(2131427535),
      text_avatar_double_row(2131427536),
      text_avatar_radio_double_row(2131427537),
      text_bold_single_row(2131427538),
      text_button(2131427539),
      text_button_small(2131427540),
      text_button_small_red(2131427541),
      text_double_greyed_row(2131427542),
      text_double_row(2131427543),
      text_greyed_row(2131427544),
      wifisettings(2131427520);

      private static final Items.ItemType[] $VALUES = new Items.ItemType[]{
         Items.ItemType.jiboheader,
         Items.ItemType.settings,
         Items.ItemType.wifisettings,
         Items.ItemType.subheader,
         Items.ItemType.member,
         Items.ItemType.invite,
         Items.ItemType.footer,
         Items.ItemType.searchRecap,
         Items.ItemType.date,
         Items.ItemType.header_with_button,
         Items.ItemType.attribution,
         Items.ItemType.text_button,
         Items.ItemType.text_button_small,
         Items.ItemType.text_button_small_red,
         Items.ItemType.suspended_loop,
         Items.ItemType.setup_jibo,
         Items.ItemType.switch_row,
         Items.ItemType.checkbox_row_leftsided,
         Items.ItemType.checkbox_date_row_leftsided,
         Items.ItemType.text_greyed_row,
         Items.ItemType.text_bold_single_row,
         Items.ItemType.text_double_row,
         Items.ItemType.text_double_greyed_row,
         Items.ItemType.text_avatar_double_row,
         Items.ItemType.text_avatar_radio_double_row,
         Items.ItemType.add_custom_holiday,
         Items.ItemType.dialog_bottom_sheet_item,
         Items.ItemType.skill,
         Items.ItemType.skill_footer,
         Items.ItemType.skill_switch,
         Items.ItemType.skill_address_location_text_field,
         Items.ItemType.skill_toggle,
         Items.ItemType.skill_choice,
         Items.ItemType.skill_time,
         Items.ItemType.skill_connectable,
         Items.ItemType.skill_oauth
      };
      int layoutId;

      ItemType(int var3) {
         this.layoutId = var3;
      }

      public int getLayoutId() {
         return this.layoutId;
      }
   }

   public static class JiboHeaderItem extends Items.LoopBasedItem {
   }

   public static class JiboSettingsItem extends Items.Item {
      private Robot a;

      public JiboSettingsItem() {
         super(Items.ItemType.settings);
      }

      public JiboSettingsItem(OnClickListener var1, Robot var2) {
         super(Items.ItemType.settings, var1);
         this.a = var2;
      }

      public Robot a() {
         return this.a;
      }

      public void a(Robot var1) {
         this.a = var1;
      }
   }

   public abstract static class LoopBasedItem extends Items.SimpleItem {
      private Loop a;

      public LoopBasedItem(Items.ItemType var1, OnClickListener var2, Loop var3) {
         super(var1, var2);
         this.a = var3;
      }

      public LoopBasedItem(Items.ItemType var1, Loop var2) {
         super(var1);
         this.a = var2;
      }

      public Loop a() {
         return this.a;
      }
   }

   public static class MemberItem extends Items.LoopBasedItem {
      private Member a;
      private Bundle b;

      public MemberItem(OnClickListener var1, Loop var2, Member var3) {
         super(Items.ItemType.member, var1, var2);
         this.a = var3;
      }

      public MemberItem(OnClickListener var1, Loop var2, Member var3, Bundle var4) {
         this(var1, var2, var3);
         this.b = var4;
      }

      public MemberItem(Loop var1, Member var2) {
         super(Items.ItemType.member, var1);
         this.a = var2;
      }

      public Member b() {
         return this.a;
      }

      public Bundle c() {
         return this.b;
      }
   }

   public static class SimpleItem extends Items.Item {
      private int a = -1;
      private CharSequence b = "";

      public SimpleItem(Items.ItemType var1) {
         super(var1);
      }

      public SimpleItem(Items.ItemType var1, int var2) {
         this(var1);
         this.a = var2;
      }

      public SimpleItem(Items.ItemType var1, OnClickListener var2) {
         super(var1, var2);
      }

      public SimpleItem(Items.ItemType var1, OnClickListener var2, int var3) {
         this(var1, var2);
         this.a = var3;
      }

      public SimpleItem(Items.ItemType var1, OnClickListener var2, CharSequence var3) {
         this(var1, var2);
         this.b = var3;
      }

      public SimpleItem(Items.ItemType var1, CharSequence var2) {
         this(var1);
         this.b = var2;
      }

      public int d() {
         return this.a;
      }

      public CharSequence e() {
         return this.b;
      }
   }

   public abstract static class StateSwitchItem extends Items.SimpleItem {
      private boolean a = false;

      public StateSwitchItem(Items.ItemType var1, OnClickListener var2, int var3, boolean var4) {
         super(var1, var2, var3);
         this.a = var4;
      }

      public StateSwitchItem(Items.ItemType var1, OnClickListener var2, String var3, boolean var4) {
         super(var1, var2, var3);
         this.a = var4;
      }

      public void a(boolean var1) {
         this.a = var1;
      }

      public boolean c() {
         return this.a;
      }
   }

   public static class SubheaderItem extends Items.SimpleItem {
      public SubheaderItem(int var1) {
         super(Items.ItemType.subheader, var1);
      }

      public SubheaderItem(String var1) {
         super(Items.ItemType.subheader, var1);
      }
   }

   public static class SuspendedLoopItem extends Items.Item {
      private Loop a;

      public SuspendedLoopItem(OnClickListener var1, Loop var2) {
         super(Items.ItemType.suspended_loop, var1);
         this.a = var2;
      }

      public Loop a() {
         return this.a;
      }
   }

   public static class SwitchRowItem extends Items.StateSwitchItem {
      public SwitchRowItem(OnClickListener var1, int var2, boolean var3) {
         super(Items.ItemType.switch_row, var1, var2, var3);
      }
   }

   public static class TwoRowsSimpleItem extends Items.Item {
      private CharSequence a = "";
      private CharSequence b = "";

      public TwoRowsSimpleItem(Items.ItemType var1, OnClickListener var2, CharSequence var3, CharSequence var4) {
         super(var1, var2);
         this.a = var3;
         this.b = var4;
      }

      public TwoRowsSimpleItem(Items.ItemType var1, CharSequence var2, CharSequence var3) {
         super(var1);
         this.a = var2;
         this.b = var3;
      }

      public TwoRowsSimpleItem(CharSequence var1, CharSequence var2) {
         this(Items.ItemType.text_double_row, var1, var2);
      }

      public void a(CharSequence var1) {
         this.b = var1;
      }

      public CharSequence e() {
         return this.a;
      }

      public CharSequence f() {
         return this.b;
      }
   }

   public static class WifiSettingsItem extends Items.Item {
      private Robot a;
      private StatusContainer b;

      public WifiSettingsItem() {
         super(Items.ItemType.wifisettings);
      }

      public WifiSettingsItem(OnClickListener var1) {
         super(Items.ItemType.wifisettings, var1);
      }

      public Robot a() {
         return this.a;
      }

      public void a(StatusContainer var1) {
         this.b = var1;
      }

      public void a(Robot var1) {
         this.a = var1;
      }

      public StatusContainer b() {
         return this.b;
      }
   }
}
