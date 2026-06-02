package com.jibo.ui.helpers.skills;

import android.content.Intent;
import android.net.Uri;
import android.text.Html;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.crashlytics.android.Crashlytics;
import com.jibo.ui.activity.SingleFragmentActivity;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

public class Items {
   public static class ChoiceItem extends Items.SkillSimpleItem {
      public ChoiceItem(OnClickListener var1, DataItems.ChoiceDataItem var2) {
         super(com.jibo.ui.helpers.Items.ItemType.skill_choice, var1, var2);
      }

      private DataItems.ChoiceDataItem getChoiceDataItem() {
         return (DataItems.ChoiceDataItem)this.mDataItem;
      }

      public List<DataItems.ChoiceDataItem.ChoiceValueDataItem> getChoices() {
         return this.getChoiceDataItem().getChoices();
      }

      public int getSelectedValue() {
         int var1;
         if (this.getChoiceDataItem().getDataValue() != null) {
            var1 = ((DataItems.IntegerDataValue)this.getChoiceDataItem().getDataValue()).getValue();
         } else {
            var1 = -1;
         }

         return var1;
      }
   }

   public static class ConnectableItem extends Items.StateItem {
      public ConnectableItem(OnClickListener var1, DataItems.ConnectableDataItem var2) {
         super(com.jibo.ui.helpers.Items.ItemType.skill_connectable, var1, var2);
      }

      private DataItems.ConnectableDataItem getConnectableDataItem() {
         return (DataItems.ConnectableDataItem)this.mDataItem;
      }

      @Override
      public boolean isChecked() {
         boolean var1;
         if (this.mDataItem != null && this.mDataItem.getDataValue() != null) {
            var1 = ((DataItems.ConnectableDataValue)this.getConnectableDataItem().getDataValue()).isConnected();
         } else {
            var1 = false;
         }

         return var1;
      }
   }

   public static class LocationItem extends Items.SkillSimpleItem {
      public LocationItem(OnClickListener var1, DataItems.LocationDataItem var2) {
         this(com.jibo.ui.helpers.Items.ItemType.skill_address_location_text_field, var1, var2);
      }

      public LocationItem(com.jibo.ui.helpers.Items.ItemType var1, OnClickListener var2, DataItems.DataItem var3) {
         super(var1, var2, var3);
      }

      public LocationItem(com.jibo.ui.helpers.Items.ItemType var1, DataItems.DataItem var2) {
         super(var1, var2);
      }

      protected DataItems.LocationDataItem getLocationDataItem() {
         return (DataItems.LocationDataItem)this.mDataItem;
      }

      public String getSubtitle() {
         DataItems.LocationDataValue var1 = (DataItems.LocationDataValue)this.getLocationDataItem().getDataValue();
         String var2;
         if (var1 != null) {
            var2 = var1.getFriendlyTimezone();
         } else {
            var2 = "";
         }

         return var2;
      }

      public String getTitle() {
         DataItems.LocationDataValue var1 = (DataItems.LocationDataValue)this.getLocationDataItem().getDataValue();
         String var2;
         if (var1 != null) {
            var2 = var1.getFriendlyLocation();
         } else {
            var2 = "";
         }

         return var2;
      }
   }

   public static class OauthItem extends Items.SkillSimpleItem {
      public OauthItem(OnClickListener var1, DataItems.OauthDataItem var2) {
         super(com.jibo.ui.helpers.Items.ItemType.skill_oauth, var1, var2);
      }

      private DataItems.OauthDataItem getOauthDataItem() {
         return (DataItems.OauthDataItem)this.mDataItem;
      }

      public String getCallbackUrl() {
         String var1;
         if (this.getOauthDataItem().getDataValue() != null) {
            var1 = ((DataItems.OauthDataValue)this.getOauthDataItem().getDataValue()).getIosCallbackUri();
         } else {
            var1 = "";
         }

         return var1;
      }

      public String getIcon() {
         String var1;
         if (this.getOauthDataItem() != null) {
            var1 = this.getOauthDataItem().getIcon();
         } else {
            var1 = "";
         }

         return var1;
      }

      public String getOauthUrl() {
         String var1;
         if (this.getOauthDataItem().getDataValue() != null) {
            var1 = ((DataItems.OauthDataValue)this.getOauthDataItem().getDataValue()).getAuthorizationUri();
         } else {
            var1 = "";
         }

         return var1;
      }

      public String getTitle() {
         String var1;
         if (this.getOauthDataItem() != null) {
            var1 = this.getOauthDataItem().getTitle();
         } else {
            var1 = "";
         }

         return var1;
      }
   }

   public static class SkillFooterItem extends Items.SkillSimpleItem {
      private int mLinkColor = -16777216;

      public SkillFooterItem(OnClickListener var1, DataItems.FooterDataItem var2) {
         super(com.jibo.ui.helpers.Items.ItemType.skill_footer, var1, var2);
      }

      public SkillFooterItem(DataItems.FooterDataItem var1) {
         this(null, var1);
      }

      @Override
      public CharSequence getTitle() {
         SpannableStringBuilder var5 = new SpannableStringBuilder(Html.fromHtml(this.mDataItem.getTitle()));
         if (((DataItems.FooterDataItem)this.mDataItem).getLinks() != null) {
            for (DataItems.FooterDataItem.Link var4 : ((DataItems.FooterDataItem)this.mDataItem).getLinks()) {
               if (!TextUtils.isEmpty(var4.getPlaceholder())) {
                  int var2 = 1;
                  int var1 = 0;

                  while (var2) {
                     var2 = var5.toString().indexOf(var4.getPlaceholder(), var1);
                     boolean var8;
                     if (var2 != -1) {
                        var8 = var4.getText().length();
                        var5.delete(var2, var4.getPlaceholder().length() + var2);
                        var5.insert(var2, var4.getText());
                        var5.setSpan(new ForegroundColorSpan(this.mLinkColor), var2, var4.getText().length() + var2, 33);
                        var5.setSpan(new ClickableSpan(this, var4) {
                           final Items.SkillFooterItem this$0;
                           final DataItems.FooterDataItem.Link val$intentLink;

                           {
                              this.this$0 = var1;
                              this.val$intentLink = var2x;
                           }

                           public void onClick(View var1) {
                              Class var2x = SkillsJsonParser.TextLinksMatcher.getClassForPlaceholder(this.val$intentLink.getPlaceholder());
                              if (var2x != null) {
                                 new SingleFragmentActivity.Builder(var1.getContext(), var2x.getName()).a(999);
                              } else if (!TextUtils.isEmpty(this.val$intentLink.getUrl())) {
                                 try {
                                    Uri var5x = Uri.parse(this.val$intentLink.getUrl());
                                    Intent var3 = new Intent("android.intent.action.VIEW", var5x);
                                    var1.getContext().startActivity(var3);
                                 } catch (Exception var4x) {
                                    Crashlytics.a(var4x);
                                 }
                              }
                           }

                           public void updateDrawState(TextPaint var1) {
                              var1.setUnderlineText(false);
                           }
                        }, var2, var4.getText().length() + var2, 33);
                        var2 = var8 + var2;
                        var8 = 1;
                     } else {
                        var2 = var1;
                        var8 = 0;
                     }

                     int var3 = var2;
                     var2 = var8;
                     var1 = var3;
                  }
               }
            }
         }

         return var5;
      }

      public void setLinkColor(int var1) {
         this.mLinkColor = var1;
      }
   }

   public static class SkillItem extends Items.SkillSimpleItem {
      public SkillItem(OnClickListener var1, DataItems.SkillViewDataItem var2) {
         super(com.jibo.ui.helpers.Items.ItemType.skill, var1, var2);
      }

      private DataItems.SkillViewDataItem getSkillViewDataItem() {
         return (DataItems.SkillViewDataItem)this.mDataItem;
      }

      public String getIcon() {
         return this.getSkillViewDataItem().getIcon();
      }
   }

   public abstract static class SkillSimpleItem extends com.jibo.ui.helpers.Items.Item {
      protected final DataItems.DataItem mDataItem;

      public SkillSimpleItem(com.jibo.ui.helpers.Items.ItemType var1, OnClickListener var2, OnCheckedChangeListener var3, DataItems.DataItem var4) {
         super(var1, var2, var3);
         this.mDataItem = var4;
      }

      public SkillSimpleItem(com.jibo.ui.helpers.Items.ItemType var1, OnClickListener var2, DataItems.DataItem var3) {
         super(var1, var2);
         this.mDataItem = var3;
      }

      public SkillSimpleItem(com.jibo.ui.helpers.Items.ItemType var1, DataItems.DataItem var2) {
         this(var1, null, var2);
      }

      public DataItems.DataItem getDataItem() {
         return this.mDataItem;
      }

      public DataItems.GroupDataItem getGroupDataItem() {
         return (DataItems.GroupDataItem)this.mDataItem;
      }

      public CharSequence getSubtitle() {
         return this.getGroupDataItem().getSubtitle();
      }

      public CharSequence getTitle() {
         return this.getGroupDataItem().getTitle();
      }

      public boolean isGroupDataItem() {
         return this.mDataItem instanceof DataItems.GroupDataItem;
      }
   }

   public abstract static class StateItem extends Items.SkillSimpleItem {
      public StateItem(com.jibo.ui.helpers.Items.ItemType var1, OnClickListener var2, OnCheckedChangeListener var3, DataItems.DataItem var4) {
         super(var1, var2, var3, var4);
      }

      public StateItem(com.jibo.ui.helpers.Items.ItemType var1, OnClickListener var2, DataItems.DataItem var3) {
         super(var1, var2, var3);
      }

      public abstract boolean isChecked();
   }

   public static class SwitchItem extends Items.StateItem {
      public SwitchItem(OnClickListener var1, OnCheckedChangeListener var2, DataItems.SwitchDataItem var3) {
         super(com.jibo.ui.helpers.Items.ItemType.skill_switch, var1, var2, var3);
      }

      private DataItems.SwitchDataItem getSwitchDataItem() {
         return (DataItems.SwitchDataItem)this.mDataItem;
      }

      public boolean hasChildren() {
         boolean var1;
         if (this.getSwitchDataItem().getChildViews() != null && !this.getSwitchDataItem().getChildViews().isEmpty()) {
            var1 = true;
         } else {
            var1 = false;
         }

         return var1;
      }

      @Override
      public boolean isChecked() {
         boolean var1;
         if (this.mDataItem != null && this.mDataItem.getDataValue() != null) {
            var1 = ((DataItems.BooleanDataValue)this.mDataItem.getDataValue()).getValue();
         } else {
            var1 = false;
         }

         return var1;
      }
   }

   public static class TimeItem extends Items.SkillSimpleItem {
      public TimeItem(OnClickListener var1, DataItems.TimeDataItem var2) {
         super(com.jibo.ui.helpers.Items.ItemType.skill_time, var1, var2);
      }

      private DataItems.TimeDataItem getTimeDataItem() {
         return (DataItems.TimeDataItem)this.mDataItem;
      }

      public String getTime() {
         String var3;
         if (this.getTimeDataItem().getDataValue() != null) {
            SimpleDateFormat var2 = new SimpleDateFormat("h:mm a");
            var2.setTimeZone(TimeZone.getTimeZone("GMT"));
            Calendar var1 = Calendar.getInstance();
            var1.setTimeZone(TimeZone.getTimeZone("GMT"));
            var1.set(11, ((DataItems.TimeDataValue)this.getTimeDataItem().getDataValue()).getHour());
            var1.set(12, ((DataItems.TimeDataValue)this.getTimeDataItem().getDataValue()).getMin());
            var2.format(var1.getTime());
            var3 = var2.format(var1.getTime());
         } else {
            var3 = "";
         }

         return var3;
      }
   }

   public static class ToggleItem extends Items.StateItem {
      public ToggleItem(OnClickListener var1, DataItems.ToggleDataItem var2) {
         super(com.jibo.ui.helpers.Items.ItemType.skill_toggle, var1, var2);
      }

      private DataItems.ToggleDataItem getToggleDataItem() {
         return (DataItems.ToggleDataItem)this.mDataItem;
      }

      public String getTitle() {
         return this.getToggleDataItem().getTitle();
      }

      @Override
      public boolean isChecked() {
         boolean var1;
         if (this.mDataItem != null && this.mDataItem.getDataValue() != null) {
            var1 = ((DataItems.BooleanDataValue)this.mDataItem.getDataValue()).getValue();
         } else {
            var1 = false;
         }

         return var1;
      }
   }
}
