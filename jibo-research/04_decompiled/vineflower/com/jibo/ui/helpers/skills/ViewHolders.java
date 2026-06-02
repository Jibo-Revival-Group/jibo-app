package com.jibo.ui.helpers.skills;

import android.content.Context;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import butterknife.BindView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.jibo.ui.view.proxima.CustomFontTextView;
import com.jibo.ui.view.skills.SkillRadioGroup;
import com.jibo.utils.ImageUtils;

public class ViewHolders {
   public static class AbstractSkillViewHolder extends com.jibo.ui.helpers.ViewHolders.AbstractViewHolder {
      private boolean mIsOwner;
      @BindView
      protected TextView subtitle;
      @BindView
      protected TextView title;

      public AbstractSkillViewHolder(View var1, boolean var2) {
         super(var1);
         this.mIsOwner = var2;
      }

      protected CharSequence getSubtitle() {
         return ((Items.SkillSimpleItem)this.mItem).getSubtitle();
      }

      protected CharSequence getTitle() {
         return "";
      }

      @Override
      public void invalidateView() {
         View var2 = this.itemView;
         boolean var1;
         if (((Items.SkillSimpleItem)this.mItem).getDataItem().isOwner() && !this.mIsOwner) {
            var1 = false;
         } else {
            var1 = true;
         }

         var2.setEnabled(var1);
         this.populateTitle();
         this.populateSubtitle();
      }

      public boolean isOwner() {
         return this.mIsOwner;
      }

      protected void populateSubtitle() {
         if (this.subtitle != null) {
            this.subtitle.setVisibility(8);
         }

         if (((Items.SkillSimpleItem)this.mItem).isGroupDataItem() && !TextUtils.isEmpty(this.getSubtitle()) && this.subtitle != null) {
            this.subtitle.setVisibility(0);
            this.subtitle.setText(this.getSubtitle());
         }
      }

      protected void populateTitle() {
         TextView var2 = this.title;
         CharSequence var1;
         if (((Items.SkillSimpleItem)this.mItem).isGroupDataItem()) {
            var1 = ((Items.SkillSimpleItem)this.mItem).getTitle();
         } else {
            var1 = this.getTitle();
         }

         var2.setText(var1);
      }
   }

   public abstract static class AbstractStateViewHolder extends ViewHolders.AbstractSkillViewHolder {
      @BindView
      public CompoundButton compoundButton;

      public AbstractStateViewHolder(View var1, boolean var2) {
         super(var1, var2);
      }

      @Override
      public void invalidateView() {
         super.invalidateView();
         this.compoundButton.setChecked(((Items.StateItem)this.mItem).isChecked());
      }

      @Override
      public void setData(com.jibo.ui.helpers.Items.Item var1) {
         this.compoundButton.setTag(var1);
         super.setData(var1);
      }
   }

   public static class ChoiceViewHolder extends ViewHolders.AbstractSkillViewHolder {
      public ChoiceViewHolder(View var1, boolean var2) {
         super(var1, var2);
      }

      @Override
      public void invalidateView() {
         ((SkillRadioGroup)this.itemView).removeAllViews();
         ((SkillRadioGroup)this.itemView).a(((Items.ChoiceItem)this.mItem).getChoices(), ((Items.ChoiceItem)this.mItem).getSelectedValue());
      }

      @Override
      public void setData(com.jibo.ui.helpers.Items.Item var1) {
         super.setData(var1);
         this.itemView.setOnClickListener(this.mItem.getOnRowClickListener());
      }
   }

   public static class ConnectableViewHolder extends ViewHolders.AbstractSkillViewHolder {
      @BindView
      public CustomFontTextView summary;

      public ConnectableViewHolder(View var1, boolean var2) {
         super(var1, var2);
      }

      protected String getSubtitle() {
         return "";
      }

      @Override
      public void invalidateView() {
         super.invalidateView();
         CustomFontTextView var3 = this.summary;
         String var2;
         if (((Items.ConnectableItem)this.mItem).isChecked()) {
            var2 = "Connected";
         } else {
            var2 = "Not Connected";
         }

         var3.setText(var2);
         CustomFontTextView var4 = this.summary;
         Context var5 = this.itemView.getContext();
         int var1;
         if (((Items.ConnectableItem)this.mItem).isChecked()) {
            var1 = 2131099771;
         } else {
            var1 = 2131099846;
         }

         var4.setTextColor(ImageUtils.b(var5, var1));
      }
   }

   public static class FooterViewHolder extends ViewHolders.AbstractSkillViewHolder {
      public FooterViewHolder(View var1, boolean var2) {
         super(var1, var2);
      }

      @Override
      protected void populateTitle() {
         if (this.itemView.isEnabled()) {
            ((Items.SkillFooterItem)this.mItem).setLinkColor(ImageUtils.b(this.itemView.getContext(), 2131099771));
            this.title.setText(((Items.SkillFooterItem)this.mItem).getTitle(), BufferType.SPANNABLE);
            this.title.setMovementMethod(LinkMovementMethod.getInstance());
            this.itemView.setVisibility(0);
         } else {
            this.itemView.setVisibility(8);
         }
      }
   }

   public static class LocationViewHolder extends ViewHolders.AbstractSkillViewHolder {
      public LocationViewHolder(View var1, boolean var2) {
         super(var1, var2);
         this.title.setSingleLine(false);
         this.title.setMaxLines(2);
      }

      @Override
      protected CharSequence getSubtitle() {
         CharSequence var2 = super.getSubtitle();
         CharSequence var1 = var2;
         if (TextUtils.isEmpty(var2)) {
            var1 = "";
         }

         return var1;
      }

      @Override
      protected CharSequence getTitle() {
         String var2 = ((Items.LocationItem)this.mItem).getTitle();
         String var1 = var2;
         if (TextUtils.isEmpty(var2)) {
            var1 = "";
         }

         return var1;
      }

      @Override
      protected void populateSubtitle() {
         super.populateSubtitle();
      }

      @Override
      protected void populateTitle() {
         this.title.setText(this.getTitle());
         if (TextUtils.isEmpty(this.title.getText())) {
            this.title.setHint(2131755523);
         }
      }
   }

   public static class OauthViewHolder extends ViewHolders.AbstractSkillViewHolder {
      @BindView
      public ImageView icon;

      public OauthViewHolder(View var1, boolean var2) {
         super(var1, var2);
      }

      protected String getTitle() {
         return ((Items.OauthItem)this.mItem).getTitle();
      }

      @Override
      public void invalidateView() {
         super.invalidateView();
         if (((Items.OauthItem)this.mItem).getIcon().contains("google")) {
            this.icon.setImageResource(2131230981);
         } else if (((Items.OauthItem)this.mItem).getIcon().contains("outlook")) {
            this.icon.setImageResource(2131231258);
         }
      }
   }

   public static class SkillViewHolder extends ViewHolders.AbstractSkillViewHolder {
      @BindView
      protected ImageView icon;

      public SkillViewHolder(View var1, boolean var2) {
         super(var1, var2);
      }

      @Override
      public void invalidateView() {
         super.invalidateView();
         if (!TextUtils.isEmpty(((Items.SkillItem)this.mItem).getIcon())) {
            if (SkillsJsonParser.ImageUrlMatcher.isExternal(((Items.SkillItem)this.mItem).getIcon())) {
               Glide.b(this.itemView.getContext()).a(((Items.SkillItem)this.mItem).getIcon()).a(DiskCacheStrategy.ALL).d().a(this.icon);
            } else if (SkillsJsonParser.ImageUrlMatcher.getImageForUrl(((Items.SkillItem)this.mItem).getIcon()) != -1) {
               this.icon.setImageResource(SkillsJsonParser.ImageUrlMatcher.getImageForUrl(((Items.SkillItem)this.mItem).getIcon()));
            }
         }
      }
   }

   public static class SwitchViewHolder extends ViewHolders.AbstractStateViewHolder {
      public SwitchViewHolder(View var1, boolean var2) {
         super(var1, var2);
      }

      @Override
      public void setData(com.jibo.ui.helpers.Items.Item var1) {
         super.setData(var1);
         if (this.mItem.getOnRowClickListener() != null) {
            this.compoundButton.setOnClickListener(this.mItem.getOnRowClickListener());
            this.compoundButton.setOnCheckedChangeListener(this.mItem.getCheckChangeListener());
         }
      }
   }

   public static class TimeViewHolder extends ViewHolders.AbstractSkillViewHolder {
      public TimeViewHolder(View var1, boolean var2) {
         super(var1, var2);
      }

      protected String getTitle() {
         return ((Items.TimeItem)this.mItem).getTime();
      }
   }

   public static class ToggleViewHolder extends ViewHolders.AbstractStateViewHolder {
      public ToggleViewHolder(View var1, boolean var2) {
         super(var1, var2);
         ((CompoundButton)var1.findViewById(2131296486)).setClickable(false);
      }

      protected String getTitle() {
         return ((Items.ToggleItem)this.mItem).getTitle();
      }
   }
}
