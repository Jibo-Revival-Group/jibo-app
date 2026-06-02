package com.jibo.p019ui.helpers.skills;

import android.R;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.jibo.p019ui.helpers.Items;
import com.jibo.p019ui.helpers.ViewHolders;
import com.jibo.p019ui.helpers.skills.Items;
import com.jibo.p019ui.helpers.skills.SkillsJsonParser;
import com.jibo.p019ui.view.proxima.CustomFontTextView;
import com.jibo.p019ui.view.skills.SkillRadioGroup;
import com.jibo.utils.ImageUtils;

/* JADX INFO: loaded from: classes.dex */
public class ViewHolders {

    public class OauthViewHolder_ViewBinding extends AbstractSkillViewHolder_ViewBinding {
        private OauthViewHolder target;

        public OauthViewHolder_ViewBinding(OauthViewHolder oauthViewHolder, View view) {
            super(oauthViewHolder, view);
            this.target = oauthViewHolder;
            oauthViewHolder.icon = (ImageView) Utils.m5161b(view, R.id.icon, "field 'icon'", ImageView.class);
        }

        @Override // com.jibo.ui.helpers.skills.ViewHolders.AbstractSkillViewHolder_ViewBinding, butterknife.Unbinder
        public void unbind() {
            OauthViewHolder oauthViewHolder = this.target;
            if (oauthViewHolder == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.target = null;
            oauthViewHolder.icon = null;
            super.unbind();
        }
    }

    public class SkillViewHolder_ViewBinding extends AbstractSkillViewHolder_ViewBinding {
        private SkillViewHolder target;

        public SkillViewHolder_ViewBinding(SkillViewHolder skillViewHolder, View view) {
            super(skillViewHolder, view);
            this.target = skillViewHolder;
            skillViewHolder.icon = (ImageView) Utils.m5161b(view, R.id.icon, "field 'icon'", ImageView.class);
        }

        @Override // com.jibo.ui.helpers.skills.ViewHolders.AbstractSkillViewHolder_ViewBinding, butterknife.Unbinder
        public void unbind() {
            SkillViewHolder skillViewHolder = this.target;
            if (skillViewHolder == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.target = null;
            skillViewHolder.icon = null;
            super.unbind();
        }
    }

    public class ConnectableViewHolder_ViewBinding extends AbstractSkillViewHolder_ViewBinding {
        private ConnectableViewHolder target;

        public ConnectableViewHolder_ViewBinding(ConnectableViewHolder connectableViewHolder, View view) {
            super(connectableViewHolder, view);
            this.target = connectableViewHolder;
            connectableViewHolder.summary = (CustomFontTextView) Utils.m5161b(view, R.id.summary, "field 'summary'", CustomFontTextView.class);
        }

        @Override // com.jibo.ui.helpers.skills.ViewHolders.AbstractSkillViewHolder_ViewBinding, butterknife.Unbinder
        public void unbind() {
            ConnectableViewHolder connectableViewHolder = this.target;
            if (connectableViewHolder == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.target = null;
            connectableViewHolder.summary = null;
            super.unbind();
        }
    }

    public class AbstractSkillViewHolder_ViewBinding implements Unbinder {
        private AbstractSkillViewHolder target;

        public AbstractSkillViewHolder_ViewBinding(AbstractSkillViewHolder abstractSkillViewHolder, View view) {
            this.target = abstractSkillViewHolder;
            abstractSkillViewHolder.title = (TextView) Utils.m5159a(view, R.id.text1, "field 'title'", TextView.class);
            abstractSkillViewHolder.subtitle = (TextView) Utils.m5159a(view, R.id.text2, "field 'subtitle'", TextView.class);
        }

        @Override // butterknife.Unbinder
        public void unbind() {
            AbstractSkillViewHolder abstractSkillViewHolder = this.target;
            if (abstractSkillViewHolder == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.target = null;
            abstractSkillViewHolder.title = null;
            abstractSkillViewHolder.subtitle = null;
        }
    }

    public class AbstractStateViewHolder_ViewBinding extends AbstractSkillViewHolder_ViewBinding {
        private AbstractStateViewHolder target;

        public AbstractStateViewHolder_ViewBinding(AbstractStateViewHolder abstractStateViewHolder, View view) {
            super(abstractStateViewHolder, view);
            this.target = abstractStateViewHolder;
            abstractStateViewHolder.compoundButton = (CompoundButton) Utils.m5161b(view, com.jibo.R.id.compound_button, "field 'compoundButton'", CompoundButton.class);
        }

        @Override // com.jibo.ui.helpers.skills.ViewHolders.AbstractSkillViewHolder_ViewBinding, butterknife.Unbinder
        public void unbind() {
            AbstractStateViewHolder abstractStateViewHolder = this.target;
            if (abstractStateViewHolder == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.target = null;
            abstractStateViewHolder.compoundButton = null;
            super.unbind();
        }
    }

    public static class AbstractSkillViewHolder extends ViewHolders.AbstractViewHolder {
        private boolean mIsOwner;

        @BindView
        protected TextView subtitle;

        @BindView
        protected TextView title;

        public AbstractSkillViewHolder(View view, boolean z) {
            super(view);
            this.mIsOwner = z;
        }

        @Override // com.jibo.ui.helpers.ViewHolders.AbstractViewHolder
        public void invalidateView() {
            this.itemView.setEnabled(!((Items.SkillSimpleItem) this.mItem).getDataItem().isOwner() || this.mIsOwner);
            populateTitle();
            populateSubtitle();
        }

        protected CharSequence getTitle() {
            return "";
        }

        protected void populateTitle() {
            CharSequence title;
            TextView textView = this.title;
            if (((Items.SkillSimpleItem) this.mItem).isGroupDataItem()) {
                title = ((Items.SkillSimpleItem) this.mItem).getTitle();
            } else {
                title = getTitle();
            }
            textView.setText(title);
        }

        protected CharSequence getSubtitle() {
            return ((Items.SkillSimpleItem) this.mItem).getSubtitle();
        }

        protected void populateSubtitle() {
            if (this.subtitle != null) {
                this.subtitle.setVisibility(8);
            }
            if (((Items.SkillSimpleItem) this.mItem).isGroupDataItem() && !TextUtils.isEmpty(getSubtitle()) && this.subtitle != null) {
                this.subtitle.setVisibility(0);
                this.subtitle.setText(getSubtitle());
            }
        }

        public boolean isOwner() {
            return this.mIsOwner;
        }
    }

    public static class SkillViewHolder extends AbstractSkillViewHolder {

        @BindView
        protected ImageView icon;

        public SkillViewHolder(View view, boolean z) {
            super(view, z);
        }

        @Override // com.jibo.ui.helpers.skills.ViewHolders.AbstractSkillViewHolder, com.jibo.ui.helpers.ViewHolders.AbstractViewHolder
        public void invalidateView() {
            super.invalidateView();
            if (!TextUtils.isEmpty(((Items.SkillItem) this.mItem).getIcon())) {
                if (SkillsJsonParser.ImageUrlMatcher.isExternal(((Items.SkillItem) this.mItem).getIcon())) {
                    Glide.m5254b(this.itemView.getContext()).m5279a(((Items.SkillItem) this.mItem).getIcon()).mo5223b(DiskCacheStrategy.ALL).mo5239j().mo5216a(this.icon);
                } else if (SkillsJsonParser.ImageUrlMatcher.getImageForUrl(((Items.SkillItem) this.mItem).getIcon()) != -1) {
                    this.icon.setImageResource(SkillsJsonParser.ImageUrlMatcher.getImageForUrl(((Items.SkillItem) this.mItem).getIcon()));
                }
            }
        }
    }

    public static abstract class AbstractStateViewHolder extends AbstractSkillViewHolder {

        @BindView
        public CompoundButton compoundButton;

        public AbstractStateViewHolder(View view, boolean z) {
            super(view, z);
        }

        @Override // com.jibo.ui.helpers.ViewHolders.AbstractViewHolder
        public void setData(Items.Item item) {
            this.compoundButton.setTag(item);
            super.setData(item);
        }

        @Override // com.jibo.ui.helpers.skills.ViewHolders.AbstractSkillViewHolder, com.jibo.ui.helpers.ViewHolders.AbstractViewHolder
        public void invalidateView() {
            super.invalidateView();
            this.compoundButton.setChecked(((Items.StateItem) this.mItem).isChecked());
        }
    }

    public static class FooterViewHolder extends AbstractSkillViewHolder {
        public FooterViewHolder(View view, boolean z) {
            super(view, z);
        }

        @Override // com.jibo.ui.helpers.skills.ViewHolders.AbstractSkillViewHolder
        protected void populateTitle() {
            if (this.itemView.isEnabled()) {
                ((Items.SkillFooterItem) this.mItem).setLinkColor(ImageUtils.m11399b(this.itemView.getContext(), com.jibo.R.color.jibo_blue));
                this.title.setText(((Items.SkillFooterItem) this.mItem).getTitle(), TextView.BufferType.SPANNABLE);
                this.title.setMovementMethod(LinkMovementMethod.getInstance());
                this.itemView.setVisibility(0);
                return;
            }
            this.itemView.setVisibility(8);
        }
    }

    public static class SwitchViewHolder extends AbstractStateViewHolder {
        public SwitchViewHolder(View view, boolean z) {
            super(view, z);
        }

        @Override // com.jibo.ui.helpers.skills.ViewHolders.AbstractStateViewHolder, com.jibo.ui.helpers.ViewHolders.AbstractViewHolder
        public void setData(Items.Item item) {
            super.setData(item);
            if (this.mItem.getOnRowClickListener() != null) {
                this.compoundButton.setOnClickListener(this.mItem.getOnRowClickListener());
                this.compoundButton.setOnCheckedChangeListener(this.mItem.getCheckChangeListener());
            }
        }
    }

    public static class ToggleViewHolder extends AbstractStateViewHolder {
        public ToggleViewHolder(View view, boolean z) {
            super(view, z);
            ((CompoundButton) view.findViewById(com.jibo.R.id.compound_button)).setClickable(false);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.jibo.ui.helpers.skills.ViewHolders.AbstractSkillViewHolder
        public String getTitle() {
            return ((Items.ToggleItem) this.mItem).getTitle();
        }
    }

    public static class LocationViewHolder extends AbstractSkillViewHolder {
        public LocationViewHolder(View view, boolean z) {
            super(view, z);
            this.title.setSingleLine(false);
            this.title.setMaxLines(2);
        }

        @Override // com.jibo.ui.helpers.skills.ViewHolders.AbstractSkillViewHolder
        protected void populateTitle() {
            this.title.setText(getTitle());
            if (TextUtils.isEmpty(this.title.getText())) {
                this.title.setHint(com.jibo.R.string.manual_location_hint);
            }
        }

        @Override // com.jibo.ui.helpers.skills.ViewHolders.AbstractSkillViewHolder
        protected CharSequence getTitle() {
            String title = ((Items.LocationItem) this.mItem).getTitle();
            return TextUtils.isEmpty(title) ? "" : title;
        }

        @Override // com.jibo.ui.helpers.skills.ViewHolders.AbstractSkillViewHolder
        protected void populateSubtitle() {
            super.populateSubtitle();
        }

        @Override // com.jibo.ui.helpers.skills.ViewHolders.AbstractSkillViewHolder
        protected CharSequence getSubtitle() {
            CharSequence subtitle = super.getSubtitle();
            return TextUtils.isEmpty(subtitle) ? "" : subtitle;
        }
    }

    public static class ChoiceViewHolder extends AbstractSkillViewHolder {
        public ChoiceViewHolder(View view, boolean z) {
            super(view, z);
        }

        @Override // com.jibo.ui.helpers.ViewHolders.AbstractViewHolder
        public void setData(Items.Item item) {
            super.setData(item);
            this.itemView.setOnClickListener(this.mItem.getOnRowClickListener());
        }

        @Override // com.jibo.ui.helpers.skills.ViewHolders.AbstractSkillViewHolder, com.jibo.ui.helpers.ViewHolders.AbstractViewHolder
        public void invalidateView() {
            ((SkillRadioGroup) this.itemView).removeAllViews();
            ((SkillRadioGroup) this.itemView).m11376a(((Items.ChoiceItem) this.mItem).getChoices(), ((Items.ChoiceItem) this.mItem).getSelectedValue());
        }
    }

    public static class TimeViewHolder extends AbstractSkillViewHolder {
        public TimeViewHolder(View view, boolean z) {
            super(view, z);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.jibo.ui.helpers.skills.ViewHolders.AbstractSkillViewHolder
        public String getTitle() {
            return ((Items.TimeItem) this.mItem).getTime();
        }
    }

    public static class ConnectableViewHolder extends AbstractSkillViewHolder {

        @BindView
        public CustomFontTextView summary;

        public ConnectableViewHolder(View view, boolean z) {
            super(view, z);
        }

        @Override // com.jibo.ui.helpers.skills.ViewHolders.AbstractSkillViewHolder, com.jibo.ui.helpers.ViewHolders.AbstractViewHolder
        public void invalidateView() {
            super.invalidateView();
            this.summary.setText(((Items.ConnectableItem) this.mItem).isChecked() ? "Connected" : "Not Connected");
            this.summary.setTextColor(ImageUtils.m11399b(this.itemView.getContext(), ((Items.ConnectableItem) this.mItem).isChecked() ? com.jibo.R.color.jibo_blue : com.jibo.R.color.steel));
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.jibo.ui.helpers.skills.ViewHolders.AbstractSkillViewHolder
        public String getSubtitle() {
            return "";
        }
    }

    public static class OauthViewHolder extends AbstractSkillViewHolder {

        @BindView
        public ImageView icon;

        public OauthViewHolder(View view, boolean z) {
            super(view, z);
        }

        @Override // com.jibo.ui.helpers.skills.ViewHolders.AbstractSkillViewHolder, com.jibo.ui.helpers.ViewHolders.AbstractViewHolder
        public void invalidateView() {
            super.invalidateView();
            if (((Items.OauthItem) this.mItem).getIcon().contains("google")) {
                this.icon.setImageResource(com.jibo.R.drawable.google_icon);
            } else if (((Items.OauthItem) this.mItem).getIcon().contains("outlook")) {
                this.icon.setImageResource(com.jibo.R.drawable.outlook_icon);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.jibo.ui.helpers.skills.ViewHolders.AbstractSkillViewHolder
        public String getTitle() {
            return ((Items.OauthItem) this.mItem).getTitle();
        }
    }
}
