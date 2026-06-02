package com.jibo.p019ui.helpers;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.graphics.drawable.AnimationDrawable;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.crashlytics.android.Crashlytics;
import com.jibo.aws.integration.aws.services.account.model.Account;
import com.jibo.aws.integration.aws.services.gqa.model.Attribution;
import com.jibo.aws.integration.aws.services.loop.model.Loop;
import com.jibo.aws.integration.aws.services.loop.model.Member;
import com.jibo.aws.integration.aws.services.loop.model.MemberAccount;
import com.jibo.aws.integration.aws.services.notification.model.StatusContainer;
import com.jibo.aws.integration.helpers.LoopHelper;
import com.jibo.aws.integration.helpers.RobotHelper;
import com.jibo.aws.integration.util.DateTimeUtils;
import com.jibo.p019ui.activity.GuidedExperienceActivity;
import com.jibo.p019ui.helpers.Items;
import com.jibo.p019ui.view.RoundedImageView;
import com.jibo.p019ui.view.proxima.CustomFontTextView;
import com.jibo.utils.CustomHolidaysUtils;
import com.jibo.utils.ImageUtils;
import com.jibo.utils.LogUtils;
import com.jibo.utils.UIUtils;
import com.jibo.utils.Util;
import com.yalantis.ucrop.view.CropImageView;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Date;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public class ViewHolders {

    public class AvatarTwoRowsSimpleViewHolder_ViewBinding extends TwoRowsSimpleViewHolder_ViewBinding {

        /* JADX INFO: renamed from: b */
        private AvatarTwoRowsSimpleViewHolder f11490b;

        public AvatarTwoRowsSimpleViewHolder_ViewBinding(AvatarTwoRowsSimpleViewHolder avatarTwoRowsSimpleViewHolder, View view) {
            super(avatarTwoRowsSimpleViewHolder, view);
            this.f11490b = avatarTwoRowsSimpleViewHolder;
            avatarTwoRowsSimpleViewHolder.icon = (ImageView) Utils.m5161b(view, R.id.icon, "field 'icon'", ImageView.class);
        }

        @Override // com.jibo.ui.helpers.ViewHolders.TwoRowsSimpleViewHolder_ViewBinding, butterknife.Unbinder
        public void unbind() {
            AvatarTwoRowsSimpleViewHolder avatarTwoRowsSimpleViewHolder = this.f11490b;
            if (avatarTwoRowsSimpleViewHolder == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.f11490b = null;
            avatarTwoRowsSimpleViewHolder.icon = null;
            super.unbind();
        }
    }

    public class HeaderButtonViewHolder_ViewBinding extends SimpleViewHolder_ViewBinding {

        /* JADX INFO: renamed from: b */
        private HeaderButtonViewHolder f11492b;

        public HeaderButtonViewHolder_ViewBinding(HeaderButtonViewHolder headerButtonViewHolder, View view) {
            super(headerButtonViewHolder, view);
            this.f11492b = headerButtonViewHolder;
            headerButtonViewHolder.button = (TextView) Utils.m5161b(view, R.id.button1, "field 'button'", TextView.class);
        }

        @Override // com.jibo.ui.helpers.ViewHolders.SimpleViewHolder_ViewBinding, butterknife.Unbinder
        public void unbind() {
            HeaderButtonViewHolder headerButtonViewHolder = this.f11492b;
            if (headerButtonViewHolder == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.f11492b = null;
            headerButtonViewHolder.button = null;
            super.unbind();
        }
    }

    public class InviteMemberViewHolder_ViewBinding extends SimpleViewHolder_ViewBinding {

        /* JADX INFO: renamed from: b */
        private InviteMemberViewHolder f11496b;

        public InviteMemberViewHolder_ViewBinding(InviteMemberViewHolder inviteMemberViewHolder, View view) {
            super(inviteMemberViewHolder, view);
            this.f11496b = inviteMemberViewHolder;
            inviteMemberViewHolder.pulseView = Utils.m5158a(view, com.jibo.R.id.pulse, "field 'pulseView'");
        }

        @Override // com.jibo.ui.helpers.ViewHolders.SimpleViewHolder_ViewBinding, butterknife.Unbinder
        public void unbind() {
            InviteMemberViewHolder inviteMemberViewHolder = this.f11496b;
            if (inviteMemberViewHolder == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.f11496b = null;
            inviteMemberViewHolder.pulseView = null;
            super.unbind();
        }
    }

    public class SwitchStateWithDateViewHolder_ViewBinding extends SwitchStateViewHolder_ViewBinding {

        /* JADX INFO: renamed from: b */
        private SwitchStateWithDateViewHolder f11506b;

        public SwitchStateWithDateViewHolder_ViewBinding(SwitchStateWithDateViewHolder switchStateWithDateViewHolder, View view) {
            super(switchStateWithDateViewHolder, view);
            this.f11506b = switchStateWithDateViewHolder;
            switchStateWithDateViewHolder.dateText = (CustomFontTextView) Utils.m5161b(view, R.id.text2, "field 'dateText'", CustomFontTextView.class);
        }

        @Override // com.jibo.ui.helpers.ViewHolders.SwitchStateViewHolder_ViewBinding, com.jibo.ui.helpers.ViewHolders.SimpleViewHolder_ViewBinding, butterknife.Unbinder
        public void unbind() {
            SwitchStateWithDateViewHolder switchStateWithDateViewHolder = this.f11506b;
            if (switchStateWithDateViewHolder == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.f11506b = null;
            switchStateWithDateViewHolder.dateText = null;
            super.unbind();
        }
    }

    public class AvatarRadioTwoRowsSimpleViewHolder_ViewBinding extends AvatarTwoRowsSimpleViewHolder_ViewBinding {

        /* JADX INFO: renamed from: b */
        private AvatarRadioTwoRowsSimpleViewHolder f11489b;

        public AvatarRadioTwoRowsSimpleViewHolder_ViewBinding(AvatarRadioTwoRowsSimpleViewHolder avatarRadioTwoRowsSimpleViewHolder, View view) {
            super(avatarRadioTwoRowsSimpleViewHolder, view);
            this.f11489b = avatarRadioTwoRowsSimpleViewHolder;
            avatarRadioTwoRowsSimpleViewHolder.mCompoundButton = (CompoundButton) Utils.m5161b(view, com.jibo.R.id.compound_button, "field 'mCompoundButton'", CompoundButton.class);
        }

        @Override // com.jibo.ui.helpers.ViewHolders.AvatarTwoRowsSimpleViewHolder_ViewBinding, com.jibo.ui.helpers.ViewHolders.TwoRowsSimpleViewHolder_ViewBinding, butterknife.Unbinder
        public void unbind() {
            AvatarRadioTwoRowsSimpleViewHolder avatarRadioTwoRowsSimpleViewHolder = this.f11489b;
            if (avatarRadioTwoRowsSimpleViewHolder == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.f11489b = null;
            avatarRadioTwoRowsSimpleViewHolder.mCompoundButton = null;
            super.unbind();
        }
    }

    public class FooterViewHolder_ViewBinding implements Unbinder {

        /* JADX INFO: renamed from: b */
        private FooterViewHolder f11491b;

        public FooterViewHolder_ViewBinding(FooterViewHolder footerViewHolder, View view) {
            this.f11491b = footerViewHolder;
            footerViewHolder.footer = (TextView) Utils.m5161b(view, R.id.text1, "field 'footer'", TextView.class);
        }

        @Override // butterknife.Unbinder
        public void unbind() {
            FooterViewHolder footerViewHolder = this.f11491b;
            if (footerViewHolder == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.f11491b = null;
            footerViewHolder.footer = null;
        }
    }

    public class JiboHeaderViewHolder_ViewBinding implements Unbinder {

        /* JADX INFO: renamed from: b */
        private JiboHeaderViewHolder f11497b;

        public JiboHeaderViewHolder_ViewBinding(JiboHeaderViewHolder jiboHeaderViewHolder, View view) {
            this.f11497b = jiboHeaderViewHolder;
            jiboHeaderViewHolder.name = (TextView) Utils.m5161b(view, R.id.text1, "field 'name'", TextView.class);
            jiboHeaderViewHolder.status = (TextView) Utils.m5161b(view, R.id.text2, "field 'status'", TextView.class);
        }

        @Override // butterknife.Unbinder
        public void unbind() {
            JiboHeaderViewHolder jiboHeaderViewHolder = this.f11497b;
            if (jiboHeaderViewHolder == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.f11497b = null;
            jiboHeaderViewHolder.name = null;
            jiboHeaderViewHolder.status = null;
        }
    }

    public class SimpleViewHolder_ViewBinding implements Unbinder {

        /* JADX INFO: renamed from: b */
        private SimpleViewHolder f11503b;

        public SimpleViewHolder_ViewBinding(SimpleViewHolder simpleViewHolder, View view) {
            this.f11503b = simpleViewHolder;
            simpleViewHolder.text = (CustomFontTextView) Utils.m5161b(view, R.id.text1, "field 'text'", CustomFontTextView.class);
        }

        @Override // butterknife.Unbinder
        public void unbind() {
            SimpleViewHolder simpleViewHolder = this.f11503b;
            if (simpleViewHolder == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.f11503b = null;
            simpleViewHolder.text = null;
        }
    }

    public class SwitchStateViewHolder_ViewBinding extends SimpleViewHolder_ViewBinding {

        /* JADX INFO: renamed from: b */
        private SwitchStateViewHolder f11505b;

        public SwitchStateViewHolder_ViewBinding(SwitchStateViewHolder switchStateViewHolder, View view) {
            super(switchStateViewHolder, view);
            this.f11505b = switchStateViewHolder;
            switchStateViewHolder.mCompoundButton = (CompoundButton) Utils.m5161b(view, com.jibo.R.id.compound_button, "field 'mCompoundButton'", CompoundButton.class);
        }

        @Override // com.jibo.ui.helpers.ViewHolders.SimpleViewHolder_ViewBinding, butterknife.Unbinder
        public void unbind() {
            SwitchStateViewHolder switchStateViewHolder = this.f11505b;
            if (switchStateViewHolder == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.f11505b = null;
            switchStateViewHolder.mCompoundButton = null;
            super.unbind();
        }
    }

    public class TwoRowsSimpleViewHolder_ViewBinding implements Unbinder {

        /* JADX INFO: renamed from: b */
        private TwoRowsSimpleViewHolder f11507b;

        public TwoRowsSimpleViewHolder_ViewBinding(TwoRowsSimpleViewHolder twoRowsSimpleViewHolder, View view) {
            this.f11507b = twoRowsSimpleViewHolder;
            twoRowsSimpleViewHolder.title = (CustomFontTextView) Utils.m5161b(view, R.id.text1, "field 'title'", CustomFontTextView.class);
            twoRowsSimpleViewHolder.subtitle = (CustomFontTextView) Utils.m5161b(view, R.id.text2, "field 'subtitle'", CustomFontTextView.class);
        }

        @Override // butterknife.Unbinder
        public void unbind() {
            TwoRowsSimpleViewHolder twoRowsSimpleViewHolder = this.f11507b;
            if (twoRowsSimpleViewHolder == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.f11507b = null;
            twoRowsSimpleViewHolder.title = null;
            twoRowsSimpleViewHolder.subtitle = null;
        }
    }

    public class WifiSettingsViewHolder_ViewBinding implements Unbinder {

        /* JADX INFO: renamed from: b */
        private WifiSettingsViewHolder f11508b;

        public WifiSettingsViewHolder_ViewBinding(WifiSettingsViewHolder wifiSettingsViewHolder, View view) {
            this.f11508b = wifiSettingsViewHolder;
            wifiSettingsViewHolder.name = (TextView) Utils.m5161b(view, R.id.text1, "field 'name'", TextView.class);
        }

        @Override // butterknife.Unbinder
        public void unbind() {
            WifiSettingsViewHolder wifiSettingsViewHolder = this.f11508b;
            if (wifiSettingsViewHolder == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.f11508b = null;
            wifiSettingsViewHolder.name = null;
        }
    }

    public class JiboSettingsViewHolder_ViewBinding implements Unbinder {

        /* JADX INFO: renamed from: b */
        private JiboSettingsViewHolder f11498b;

        public JiboSettingsViewHolder_ViewBinding(JiboSettingsViewHolder jiboSettingsViewHolder, View view) {
            this.f11498b = jiboSettingsViewHolder;
            jiboSettingsViewHolder.avatar = (ImageView) Utils.m5161b(view, com.jibo.R.id.icon, "field 'avatar'", ImageView.class);
        }

        @Override // butterknife.Unbinder
        public void unbind() {
            JiboSettingsViewHolder jiboSettingsViewHolder = this.f11498b;
            if (jiboSettingsViewHolder == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.f11498b = null;
            jiboSettingsViewHolder.avatar = null;
        }
    }

    public class LoopMemberSimpleViewHolder_ViewBinding implements Unbinder {

        /* JADX INFO: renamed from: b */
        private LoopMemberSimpleViewHolder f11499b;

        public LoopMemberSimpleViewHolder_ViewBinding(LoopMemberSimpleViewHolder loopMemberSimpleViewHolder, View view) {
            this.f11499b = loopMemberSimpleViewHolder;
            loopMemberSimpleViewHolder.avatar = (RoundedImageView) Utils.m5161b(view, R.id.icon, "field 'avatar'", RoundedImageView.class);
            loopMemberSimpleViewHolder.name = (TextView) Utils.m5161b(view, R.id.text1, "field 'name'", TextView.class);
            loopMemberSimpleViewHolder.nickName = (TextView) Utils.m5161b(view, R.id.text2, "field 'nickName'", TextView.class);
        }

        @Override // butterknife.Unbinder
        public void unbind() {
            LoopMemberSimpleViewHolder loopMemberSimpleViewHolder = this.f11499b;
            if (loopMemberSimpleViewHolder == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.f11499b = null;
            loopMemberSimpleViewHolder.avatar = null;
            loopMemberSimpleViewHolder.name = null;
            loopMemberSimpleViewHolder.nickName = null;
        }
    }

    public class SuspendedJiboViewHolder_ViewBinding implements Unbinder {

        /* JADX INFO: renamed from: b */
        private SuspendedJiboViewHolder f11504b;

        public SuspendedJiboViewHolder_ViewBinding(SuspendedJiboViewHolder suspendedJiboViewHolder, View view) {
            this.f11504b = suspendedJiboViewHolder;
            suspendedJiboViewHolder.avatar = (ImageView) Utils.m5161b(view, R.id.icon, "field 'avatar'", ImageView.class);
            suspendedJiboViewHolder.titleText = (TextView) Utils.m5161b(view, R.id.text1, "field 'titleText'", TextView.class);
        }

        @Override // butterknife.Unbinder
        public void unbind() {
            SuspendedJiboViewHolder suspendedJiboViewHolder = this.f11504b;
            if (suspendedJiboViewHolder == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.f11504b = null;
            suspendedJiboViewHolder.avatar = null;
            suspendedJiboViewHolder.titleText = null;
        }
    }

    public class OptionsBottomSheetDialogViewHolder_ViewBinding implements Unbinder {

        /* JADX INFO: renamed from: b */
        private OptionsBottomSheetDialogViewHolder f11502b;

        public OptionsBottomSheetDialogViewHolder_ViewBinding(OptionsBottomSheetDialogViewHolder optionsBottomSheetDialogViewHolder, View view) {
            this.f11502b = optionsBottomSheetDialogViewHolder;
            optionsBottomSheetDialogViewHolder.item = Utils.m5158a(view, com.jibo.R.id.item, "field 'item'");
            optionsBottomSheetDialogViewHolder.tvItem = (TextView) Utils.m5161b(view, com.jibo.R.id.tvItem, "field 'tvItem'", TextView.class);
            optionsBottomSheetDialogViewHolder.ivItem = (ImageView) Utils.m5161b(view, com.jibo.R.id.ivItem, "field 'ivItem'", ImageView.class);
        }

        @Override // butterknife.Unbinder
        public void unbind() {
            OptionsBottomSheetDialogViewHolder optionsBottomSheetDialogViewHolder = this.f11502b;
            if (optionsBottomSheetDialogViewHolder == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.f11502b = null;
            optionsBottomSheetDialogViewHolder.item = null;
            optionsBottomSheetDialogViewHolder.tvItem = null;
            optionsBottomSheetDialogViewHolder.ivItem = null;
        }
    }

    public class LoopMemberViewHolder_ViewBinding implements Unbinder {

        /* JADX INFO: renamed from: b */
        private LoopMemberViewHolder f11501b;

        public LoopMemberViewHolder_ViewBinding(LoopMemberViewHolder loopMemberViewHolder, View view) {
            this.f11501b = loopMemberViewHolder;
            loopMemberViewHolder.avatar = (RoundedImageView) Utils.m5161b(view, R.id.icon, "field 'avatar'", RoundedImageView.class);
            loopMemberViewHolder.name = (TextView) Utils.m5161b(view, R.id.text1, "field 'name'", TextView.class);
            loopMemberViewHolder.nickName = (TextView) Utils.m5161b(view, R.id.text2, "field 'nickName'", TextView.class);
            loopMemberViewHolder.textStatus = (TextView) Utils.m5161b(view, com.jibo.R.id.textStatus, "field 'textStatus'", TextView.class);
            loopMemberViewHolder.smartphone = (ImageView) Utils.m5159a(view, R.id.icon1, "field 'smartphone'", ImageView.class);
        }

        @Override // butterknife.Unbinder
        public void unbind() {
            LoopMemberViewHolder loopMemberViewHolder = this.f11501b;
            if (loopMemberViewHolder == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.f11501b = null;
            loopMemberViewHolder.avatar = null;
            loopMemberViewHolder.name = null;
            loopMemberViewHolder.nickName = null;
            loopMemberViewHolder.textStatus = null;
            loopMemberViewHolder.smartphone = null;
        }
    }

    public class AttributionViewHolder_ViewBinding implements Unbinder {

        /* JADX INFO: renamed from: b */
        private AttributionViewHolder f11488b;

        public AttributionViewHolder_ViewBinding(AttributionViewHolder attributionViewHolder, View view) {
            this.f11488b = attributionViewHolder;
            attributionViewHolder.serviceIcon = (ImageView) Utils.m5161b(view, com.jibo.R.id.icon, "field 'serviceIcon'", ImageView.class);
            attributionViewHolder.titleText = (TextView) Utils.m5161b(view, com.jibo.R.id.title, "field 'titleText'", TextView.class);
            attributionViewHolder.urlText = (TextView) Utils.m5161b(view, com.jibo.R.id.url, "field 'urlText'", TextView.class);
            attributionViewHolder.dateText = (TextView) Utils.m5161b(view, com.jibo.R.id.date, "field 'dateText'", TextView.class);
            attributionViewHolder.image = (ImageView) Utils.m5161b(view, com.jibo.R.id.image, "field 'image'", ImageView.class);
            attributionViewHolder.imageDivider = Utils.m5158a(view, com.jibo.R.id.image_divider, "field 'imageDivider'");
            attributionViewHolder.wasItCorrectButton = (CustomFontTextView) Utils.m5161b(view, com.jibo.R.id.wasItCorrectButton, "field 'wasItCorrectButton'", CustomFontTextView.class);
            attributionViewHolder.jiboImage = (ImageView) Utils.m5161b(view, com.jibo.R.id.jiboImage, "field 'jiboImage'", ImageView.class);
            attributionViewHolder.attributionRadioGroup = (RadioGroup) Utils.m5161b(view, com.jibo.R.id.attributionRadioGroup, "field 'attributionRadioGroup'", RadioGroup.class);
            attributionViewHolder.firstCard = (CardView) Utils.m5161b(view, com.jibo.R.id.firstCard, "field 'firstCard'", CardView.class);
            attributionViewHolder.backCard = (CardView) Utils.m5161b(view, com.jibo.R.id.backCard, "field 'backCard'", CardView.class);
            attributionViewHolder.submit = (CustomFontTextView) Utils.m5161b(view, com.jibo.R.id.submit, "field 'submit'", CustomFontTextView.class);
        }

        @Override // butterknife.Unbinder
        public void unbind() {
            AttributionViewHolder attributionViewHolder = this.f11488b;
            if (attributionViewHolder == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.f11488b = null;
            attributionViewHolder.serviceIcon = null;
            attributionViewHolder.titleText = null;
            attributionViewHolder.urlText = null;
            attributionViewHolder.dateText = null;
            attributionViewHolder.image = null;
            attributionViewHolder.imageDivider = null;
            attributionViewHolder.wasItCorrectButton = null;
            attributionViewHolder.jiboImage = null;
            attributionViewHolder.attributionRadioGroup = null;
            attributionViewHolder.firstCard = null;
            attributionViewHolder.backCard = null;
            attributionViewHolder.submit = null;
        }
    }

    public static abstract class AbstractViewHolder extends RecyclerView.ViewHolder {
        protected Items.Item mItem;

        protected abstract void invalidateView();

        public AbstractViewHolder(View view) {
            super(view);
            ButterKnife.m5154a(this, view);
        }

        public void setData(Items.Item item) {
            this.mItem = item;
            this.itemView.setTag(item);
            this.itemView.setOnDragListener(null);
            this.itemView.setOnTouchListener(null);
            if (this.mItem.getOnRowClickListener() != null) {
                this.itemView.setOnClickListener(this.mItem.getOnRowClickListener());
            }
            invalidateView();
        }
    }

    public static class SimpleViewHolder extends AbstractViewHolder {

        @BindView
        public CustomFontTextView text;

        public SimpleViewHolder(View view) {
            super(view);
        }

        @Override // com.jibo.ui.helpers.ViewHolders.AbstractViewHolder
        public void invalidateView() {
            if (((Items.SimpleItem) this.mItem).m11213d() != -1) {
                this.text.setText(((Items.SimpleItem) this.mItem).m11213d());
            } else if (!TextUtils.isEmpty(((Items.SimpleItem) this.mItem).m11214e())) {
                if (((Items.SimpleItem) this.mItem).m11214e() instanceof SpannableStringBuilder) {
                    this.text.setMovementMethod(LinkMovementMethod.getInstance());
                }
                this.text.setText(((Items.SimpleItem) this.mItem).m11214e());
            }
        }
    }

    public static class TwoRowsSimpleViewHolder extends AbstractViewHolder {

        @BindView
        public CustomFontTextView subtitle;

        @BindView
        public CustomFontTextView title;

        public TwoRowsSimpleViewHolder(View view) {
            super(view);
        }

        @Override // com.jibo.ui.helpers.ViewHolders.AbstractViewHolder
        public void invalidateView() {
            if (((Items.TwoRowsSimpleItem) this.mItem).m11219e() instanceof SpannableStringBuilder) {
                this.title.setMovementMethod(LinkMovementMethod.getInstance());
            }
            this.title.setText(((Items.TwoRowsSimpleItem) this.mItem).m11219e());
            if (TextUtils.isEmpty(((Items.TwoRowsSimpleItem) this.mItem).m11220f())) {
                this.subtitle.setVisibility(8);
                return;
            }
            if (((Items.TwoRowsSimpleItem) this.mItem).m11220f() instanceof SpannableStringBuilder) {
                this.subtitle.setMovementMethod(LinkMovementMethod.getInstance());
            }
            this.subtitle.setText(((Items.TwoRowsSimpleItem) this.mItem).m11220f());
            this.subtitle.setVisibility(0);
        }
    }

    public static class AvatarTwoRowsSimpleViewHolder extends TwoRowsSimpleViewHolder {

        @BindView
        public ImageView icon;

        public AvatarTwoRowsSimpleViewHolder(View view) {
            super(view);
        }

        @Override // com.jibo.ui.helpers.ViewHolders.TwoRowsSimpleViewHolder, com.jibo.ui.helpers.ViewHolders.AbstractViewHolder
        public void invalidateView() {
            super.invalidateView();
            if (!TextUtils.isEmpty(((Items.AvatarTwoRowsSimpleItem) this.mItem).m11200c())) {
                Glide.m5254b(this.itemView.getContext()).m5279a(((Items.AvatarTwoRowsSimpleItem) this.mItem).m11200c()).mo5240k().mo5223b(DiskCacheStrategy.ALL).mo5216a(this.icon);
            } else if (((Items.AvatarTwoRowsSimpleItem) this.mItem).m11201d() != -1) {
                this.icon.setImageResource(((Items.AvatarTwoRowsSimpleItem) this.mItem).m11201d());
            } else {
                this.icon.setImageBitmap(null);
            }
        }
    }

    public static class AttributionViewHolder extends AbstractViewHolder {

        /* JADX INFO: renamed from: a */
        private AnimationDrawable f11477a;

        @BindView
        public RadioGroup attributionRadioGroup;

        /* JADX INFO: renamed from: b */
        private Interpolator f11478b;

        @BindView
        public CardView backCard;

        /* JADX INFO: renamed from: c */
        private Interpolator f11479c;

        @BindView
        public TextView dateText;

        @BindView
        public CardView firstCard;

        @BindView
        public ImageView image;

        @BindView
        public View imageDivider;

        @BindView
        public ImageView jiboImage;

        @BindView
        public ImageView serviceIcon;

        @BindView
        public CustomFontTextView submit;

        @BindView
        public TextView titleText;

        @BindView
        public TextView urlText;

        @BindView
        public CustomFontTextView wasItCorrectButton;

        public AttributionViewHolder(View view) {
            super(view);
            this.f11478b = new AccelerateInterpolator();
            this.f11479c = new DecelerateInterpolator();
            this.f11477a = (AnimationDrawable) this.jiboImage.getDrawable();
        }

        @Override // com.jibo.ui.helpers.ViewHolders.AbstractViewHolder
        public void invalidateView() {
            Attribution attributionM11196a = ((Items.AttributionItem) this.mItem).m11196a();
            this.titleText.setText(attributionM11196a.getQuery());
            if (attributionM11196a.getService().equals("Wolfram Alpha")) {
                this.urlText.setText(com.jibo.R.string.computed_by_wolfram);
            } else {
                this.urlText.setText(m11235b(attributionM11196a.getUrl()));
            }
            this.dateText.setText(UIUtils.f11694c.format(new Date(attributionM11196a.getTimestamp())));
            this.serviceIcon.setImageResource(m11231a(attributionM11196a.getService()));
            if (!TextUtils.isEmpty(attributionM11196a.getImage_url())) {
                this.image.setVisibility(0);
                this.imageDivider.setVisibility(0);
                Glide.m5254b(this.itemView.getContext()).m5279a(attributionM11196a.getImage_url()).mo5216a(this.image);
            } else {
                this.image.setVisibility(8);
                this.imageDivider.setVisibility(8);
            }
            this.wasItCorrectButton.setOnClickListener(new View.OnClickListener() { // from class: com.jibo.ui.helpers.ViewHolders.AttributionViewHolder.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    AttributionViewHolder.this.wasItCorrectButton.setVisibility(8);
                    AttributionViewHolder.this.m11232a();
                }
            });
        }

        /* JADX INFO: renamed from: a */
        private int m11231a(String str) {
            return "bing".equalsIgnoreCase(str) ? com.jibo.R.drawable.ic_gqaa_bing_logo : com.jibo.R.drawable.ic_gqaa_wolfram_logo;
        }

        /* JADX INFO: renamed from: b */
        private String m11235b(String str) {
            try {
                return new URI(str).getHost();
            } catch (URISyntaxException e) {
                LogUtils.m11408a(getClass().getSimpleName(), "Error while getting domain name", e);
                e.printStackTrace();
                return "";
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX INFO: renamed from: a */
        public void m11232a() {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.backCard.getLayoutParams();
            layoutParams.height = this.firstCard.getMeasuredHeight();
            this.backCard.setLayoutParams(layoutParams);
            m11236b();
            this.attributionRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: com.jibo.ui.helpers.ViewHolders.AttributionViewHolder.2
                /* JADX WARN: Failed to find 'out' block for switch in B:3:0x001a. Please report as an issue. */
                @Override // android.widget.RadioGroup.OnCheckedChangeListener
                public void onCheckedChanged(RadioGroup radioGroup, int i) {
                    AttributionViewHolder.this.f11477a.stop();
                    AttributionViewHolder.this.jiboImage.setVisibility(8);
                    AttributionViewHolder.this.submit.setVisibility(0);
                    switch (i) {
                    }
                }
            });
            this.jiboImage.post(new Runnable() { // from class: com.jibo.ui.helpers.ViewHolders.AttributionViewHolder.3
                @Override // java.lang.Runnable
                public void run() {
                    AttributionViewHolder.this.f11477a.start();
                }
            });
            this.submit.setOnClickListener(new View.OnClickListener() { // from class: com.jibo.ui.helpers.ViewHolders.AttributionViewHolder.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    AttributionViewHolder.this.m11236b();
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX INFO: renamed from: b */
        public void m11236b() {
            final CardView cardView;
            final CardView cardView2;
            if (this.firstCard.getVisibility() == 8) {
                cardView2 = this.backCard;
                cardView = this.firstCard;
            } else {
                cardView = this.backCard;
                cardView2 = this.firstCard;
            }
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(cardView2, "rotationY", CropImageView.DEFAULT_ASPECT_RATIO, 90.0f);
            objectAnimatorOfFloat.setDuration(500L);
            objectAnimatorOfFloat.setInterpolator(this.f11478b);
            final ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(cardView, "rotationY", -90.0f, CropImageView.DEFAULT_ASPECT_RATIO);
            objectAnimatorOfFloat2.setDuration(500L);
            objectAnimatorOfFloat2.setInterpolator(this.f11479c);
            objectAnimatorOfFloat.addListener(new AnimatorListenerAdapter() { // from class: com.jibo.ui.helpers.ViewHolders.AttributionViewHolder.5
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    cardView2.setVisibility(8);
                    objectAnimatorOfFloat2.start();
                    cardView.setVisibility(0);
                }
            });
            objectAnimatorOfFloat.start();
        }
    }

    public static class JiboHeaderViewHolder extends AbstractViewHolder {

        @BindView
        public TextView name;

        @BindView
        public TextView status;

        public JiboHeaderViewHolder(View view) {
            super(view);
        }

        @Override // com.jibo.ui.helpers.ViewHolders.AbstractViewHolder
        protected void invalidateView() {
            this.name.setText(this.itemView.getContext().getString(com.jibo.R.string.invitation_to_join) + "\n" + ((Items.JiboHeaderItem) this.mItem).m11210a().getName());
            this.status.setText("");
        }
    }

    public static class SubheaderViewHolder extends SimpleViewHolder {
        public SubheaderViewHolder(View view) {
            super(view);
        }
    }

    public static class DateViewHolder extends SimpleViewHolder {
        public DateViewHolder(View view) {
            super(view);
        }
    }

    public static class JiboSettingsViewHolder extends AbstractViewHolder {

        @BindView
        public ImageView avatar;

        public JiboSettingsViewHolder(View view) {
            super(view);
        }

        @Override // com.jibo.ui.helpers.ViewHolders.AbstractViewHolder
        public void invalidateView() {
            Items.JiboSettingsItem jiboSettingsItem = (Items.JiboSettingsItem) this.mItem;
            if (jiboSettingsItem.m11208a() != null) {
                this.avatar.setImageLevel(RobotHelper.getAvatar(jiboSettingsItem.m11208a()));
            }
        }
    }

    public static class HeaderButtonViewHolder extends SimpleViewHolder {

        @BindView
        public TextView button;

        public HeaderButtonViewHolder(View view) {
            super(view);
        }

        @Override // com.jibo.ui.helpers.ViewHolders.AbstractViewHolder
        public void setData(Items.Item item) {
            super.setData(item);
            this.itemView.setOnClickListener(null);
            if (this.mItem.getOnRowClickListener() != null) {
                this.button.setOnClickListener(this.mItem.getOnRowClickListener());
            }
        }

        @Override // com.jibo.ui.helpers.ViewHolders.SimpleViewHolder, com.jibo.ui.helpers.ViewHolders.AbstractViewHolder
        public void invalidateView() {
            super.invalidateView();
            this.button.setText(((Items.HeaderButtonItem) this.mItem).m11205a());
        }
    }

    public static class WifiSettingsViewHolder extends AbstractViewHolder {

        @BindView
        public TextView name;

        public WifiSettingsViewHolder(View view) {
            super(view);
        }

        @Override // com.jibo.ui.helpers.ViewHolders.AbstractViewHolder
        public void invalidateView() {
            String string;
            Items.WifiSettingsItem wifiSettingsItem = (Items.WifiSettingsItem) this.mItem;
            StatusContainer statusContainerM11224b = wifiSettingsItem.m11224b();
            TextView textView = this.name;
            if (statusContainerM11224b != null && statusContainerM11224b.getConnected().booleanValue()) {
                string = RobotHelper.getWifiName(wifiSettingsItem.m11221a());
            } else {
                string = this.itemView.getContext().getString(com.jibo.R.string.jibo_status_no_connection);
            }
            textView.setText(string);
            this.name.setTextColor(ImageUtils.m11399b(this.itemView.getContext(), (statusContainerM11224b == null || !statusContainerM11224b.getConnected().booleanValue()) ? com.jibo.R.color.firecracker : com.jibo.R.color.steel));
        }
    }

    public static class LoopMemberViewHolder extends AbstractViewHolder {

        /* JADX INFO: renamed from: a */
        private final Account f11500a;

        @BindView
        public RoundedImageView avatar;

        @BindView
        public TextView name;

        @BindView
        public TextView nickName;

        @BindView
        public ImageView smartphone;

        @BindView
        public TextView textStatus;

        public LoopMemberViewHolder(View view, Account account) {
            super(view);
            this.f11500a = account;
            view.setLongClickable(true);
            this.nickName.setVisibility(8);
            this.textStatus.setVisibility(0);
        }

        @Override // com.jibo.ui.helpers.ViewHolders.AbstractViewHolder
        public void invalidateView() {
            Member memberM11211b = ((Items.MemberItem) this.mItem).m11211b();
            Loop loopA = ((Items.MemberItem) this.mItem).m11210a();
            try {
                MemberAccount account = memberM11211b.getAccount();
                if (!TextUtils.isEmpty(memberM11211b.getNickname())) {
                    Util.m11491a(this.name, memberM11211b.getNickname());
                } else if (account == null) {
                    this.name.setText("");
                } else {
                    Util.m11491a(this.name, account.getFirstName());
                }
                Util.m11490a(this.itemView.getContext(), this.avatar, memberM11211b);
                this.textStatus.setText("");
                this.textStatus.setTextColor(ImageUtils.m11399b(this.itemView.getContext(), com.jibo.R.color.steel));
                this.smartphone.setVisibility(8);
                if (memberM11211b.getAccount() != null) {
                    boolean zIsOwner = LoopHelper.isOwner(loopA, memberM11211b.getAccountId());
                    LoopHelper.isOwner(loopA, this.f11500a.getId());
                    if (memberM11211b.getAccountId() != null && memberM11211b.getAccountId().equals(this.f11500a.getId())) {
                        this.textStatus.setText(com.jibo.R.string.item_loop_member_status_you);
                        return;
                    }
                    if (zIsOwner) {
                        this.textStatus.setText(com.jibo.R.string.item_loop_member_status_owner);
                        return;
                    }
                    if (DateTimeUtils.isAdult(memberM11211b.getAccount().getBirthday())) {
                        if (!TextUtils.isEmpty(memberM11211b.getAccount().getEmail())) {
                            this.smartphone.setVisibility(0);
                        }
                    } else if (memberM11211b.getStatus() == Member.InvitationStatus.invited && this.f11500a.getId().equals(loopA.getOwner())) {
                        this.textStatus.setText(com.jibo.R.string.item_loop_member_status_pending);
                        this.textStatus.setTextColor(ImageUtils.m11399b(this.itemView.getContext(), com.jibo.R.color.firecracker));
                    }
                }
            } catch (Exception e) {
                Crashlytics.m5597a((Throwable) e);
            }
        }
    }

    public static class LoopMemberSimpleViewHolder extends AbstractViewHolder {

        @BindView
        public RoundedImageView avatar;

        @BindView
        public TextView name;

        @BindView
        public TextView nickName;

        @Override // com.jibo.ui.helpers.ViewHolders.AbstractViewHolder
        public void invalidateView() {
            Member memberM11211b = ((Items.MemberItem) this.mItem).m11211b();
            ((Items.MemberItem) this.mItem).m11210a();
            try {
                MemberAccount account = memberM11211b.getAccount();
                if (!TextUtils.isEmpty(memberM11211b.getNickname())) {
                    Util.m11491a(this.name, memberM11211b.getNickname());
                } else if (account == null) {
                    this.name.setText("");
                } else {
                    Util.m11491a(this.name, account.getFirstName());
                }
            } catch (Exception e) {
                Crashlytics.m5597a((Throwable) e);
            }
            Util.m11490a(this.itemView.getContext(), this.avatar, memberM11211b);
        }
    }

    public static class FooterViewHolder extends AbstractViewHolder {

        @BindView
        public TextView footer;

        public FooterViewHolder(View view) {
            super(view);
        }

        @Override // com.jibo.ui.helpers.ViewHolders.AbstractViewHolder
        public void invalidateView() {
            Items.FooterItem footerItem = (Items.FooterItem) this.mItem;
            if (footerItem.m11204a() instanceof SpannableStringBuilder) {
                this.footer.setText(footerItem.m11204a(), TextView.BufferType.SPANNABLE);
                this.footer.setMovementMethod(LinkMovementMethod.getInstance());
            } else {
                this.footer.setText(footerItem.m11204a());
                this.footer.setMovementMethod(null);
            }
        }

        /* JADX INFO: renamed from: a */
        public void m11238a(int i) {
            this.footer.setTextColor(i);
        }
    }

    public static class InviteMemberViewHolder extends SimpleViewHolder {

        /* JADX INFO: renamed from: a */
        private AtomicBoolean f11493a;

        @BindView
        View pulseView;

        public InviteMemberViewHolder(View view) {
            super(view);
            this.f11493a = new AtomicBoolean(false);
        }

        @Override // com.jibo.ui.helpers.ViewHolders.SimpleViewHolder, com.jibo.ui.helpers.ViewHolders.AbstractViewHolder
        public void invalidateView() {
            super.invalidateView();
            if ((this.itemView.getContext() instanceof GuidedExperienceActivity) && !this.f11493a.get()) {
                this.f11493a.set(true);
                this.pulseView.setAlpha(1.0f);
                this.pulseView.setScaleX(1.0f);
                this.pulseView.setScaleY(1.0f);
                this.pulseView.animate().alpha(CropImageView.DEFAULT_ASPECT_RATIO).scaleY(1.6f).scaleX(1.6f).setDuration(1000L).setListener(new Animator.AnimatorListener() { // from class: com.jibo.ui.helpers.ViewHolders.InviteMemberViewHolder.1
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        InviteMemberViewHolder.this.pulseView.postDelayed(new Runnable() { // from class: com.jibo.ui.helpers.ViewHolders.InviteMemberViewHolder.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                InviteMemberViewHolder.this.f11493a.set(false);
                                InviteMemberViewHolder.this.invalidateView();
                            }
                        }, 500L);
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                        InviteMemberViewHolder.this.pulseView.setAlpha(CropImageView.DEFAULT_ASPECT_RATIO);
                        InviteMemberViewHolder.this.pulseView.setScaleX(1.0f);
                        InviteMemberViewHolder.this.pulseView.setScaleY(1.0f);
                        InviteMemberViewHolder.this.pulseView.removeCallbacks(null);
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                    }
                }).start();
            }
        }
    }

    public static class SuspendedJiboViewHolder extends AbstractViewHolder {

        @BindView
        ImageView avatar;

        @BindView
        TextView titleText;

        public SuspendedJiboViewHolder(View view) {
            super(view);
        }

        @Override // com.jibo.ui.helpers.ViewHolders.AbstractViewHolder
        public void invalidateView() {
            this.titleText.setText(this.itemView.getContext().getResources().getString(com.jibo.R.string.reconnect_to, ((Items.SuspendedLoopItem) this.mItem).m11217a().getName()));
        }

        /* JADX INFO: renamed from: a */
        public void m11240a(int i) {
            this.avatar.setImageLevel(i);
        }
    }

    public static class SwitchStateViewHolder extends SimpleViewHolder {

        @BindView
        public CompoundButton mCompoundButton;

        public SwitchStateViewHolder(View view) {
            super(view);
        }

        @Override // com.jibo.ui.helpers.ViewHolders.AbstractViewHolder
        public void setData(Items.Item item) {
            super.setData(item);
        }

        @Override // com.jibo.ui.helpers.ViewHolders.SimpleViewHolder, com.jibo.ui.helpers.ViewHolders.AbstractViewHolder
        public void invalidateView() {
            super.invalidateView();
            this.mCompoundButton.setChecked(((Items.StateSwitchItem) this.mItem).m11216c());
            if (this.mItem.getOnRowClickListener() != null) {
                this.mCompoundButton.setClickable(false);
            }
        }
    }

    public static class SwitchStateWithDateViewHolder extends SwitchStateViewHolder {

        @BindView
        public CustomFontTextView dateText;

        public SwitchStateWithDateViewHolder(View view) {
            super(view);
        }

        @Override // com.jibo.ui.helpers.ViewHolders.SwitchStateViewHolder, com.jibo.ui.helpers.ViewHolders.AbstractViewHolder
        public void setData(Items.Item item) {
            super.setData(item);
            Items.CheckboxDateItem checkboxDateItem = this.mItem instanceof Items.CheckboxDateItem ? (Items.CheckboxDateItem) this.mItem : null;
            if (checkboxDateItem != null) {
                if (!TextUtils.isEmpty(checkboxDateItem.m11203b())) {
                    this.dateText.setText(DateTimeUtils.getBirthdayString(CustomHolidaysUtils.m11377a(checkboxDateItem.m11203b()), "MMMM d, yyyy"));
                }
                if (checkboxDateItem.m11202a() != null) {
                    this.itemView.setOnLongClickListener(checkboxDateItem.m11202a());
                }
            }
        }
    }

    public static class AvatarRadioTwoRowsSimpleViewHolder extends AvatarTwoRowsSimpleViewHolder {

        @BindView
        public CompoundButton mCompoundButton;

        public AvatarRadioTwoRowsSimpleViewHolder(View view) {
            super(view);
        }

        @Override // com.jibo.ui.helpers.ViewHolders.AbstractViewHolder
        public void setData(Items.Item item) {
            super.setData(item);
            this.mCompoundButton.setClickable(false);
        }

        @Override // com.jibo.ui.helpers.ViewHolders.AvatarTwoRowsSimpleViewHolder, com.jibo.ui.helpers.ViewHolders.TwoRowsSimpleViewHolder, com.jibo.ui.helpers.ViewHolders.AbstractViewHolder
        public void invalidateView() {
            super.invalidateView();
            this.mCompoundButton.setChecked(((Items.AvatarRadioTwoRowsSimpleItem) this.mItem).m11197b());
        }
    }

    public static class OptionsBottomSheetDialogViewHolder extends AbstractViewHolder {

        @BindView
        View item;

        @BindView
        public ImageView ivItem;

        @BindView
        public TextView tvItem;

        public OptionsBottomSheetDialogViewHolder(View view) {
            super(view);
        }

        @Override // com.jibo.ui.helpers.ViewHolders.AbstractViewHolder
        public void setData(Items.Item item) {
            super.setData(item);
            if (item instanceof Items.IconTextItem) {
                this.tvItem.setText(((Items.IconTextItem) item).m11207b());
                this.ivItem.setImageResource(((Items.IconTextItem) item).m11206a());
            }
        }

        @Override // com.jibo.ui.helpers.ViewHolders.AbstractViewHolder
        protected void invalidateView() {
        }
    }
}
