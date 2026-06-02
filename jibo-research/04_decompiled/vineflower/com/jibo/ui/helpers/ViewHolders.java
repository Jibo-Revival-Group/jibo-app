package com.jibo.ui.helpers;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.Animator.AnimatorListener;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView.BufferType;
import butterknife.BindView;
import butterknife.ButterKnife;
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
import com.jibo.ui.activity.GuidedExperienceActivity;
import com.jibo.ui.view.RoundedImageView;
import com.jibo.ui.view.proxima.CustomFontTextView;
import com.jibo.utils.CustomHolidaysUtils;
import com.jibo.utils.ImageUtils;
import com.jibo.utils.LogUtils;
import com.jibo.utils.UIUtils;
import com.jibo.utils.Util;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Date;
import java.util.concurrent.atomic.AtomicBoolean;

public class ViewHolders {
   public abstract static class AbstractViewHolder extends RecyclerView.ViewHolder {
      protected Items.Item mItem;

      public AbstractViewHolder(View var1) {
         super(var1);
         ButterKnife.a(this, var1);
      }

      protected abstract void invalidateView();

      public void setData(Items.Item var1) {
         this.mItem = var1;
         this.itemView.setTag(var1);
         this.itemView.setOnDragListener(null);
         this.itemView.setOnTouchListener(null);
         if (this.mItem.getOnRowClickListener() != null) {
            this.itemView.setOnClickListener(this.mItem.getOnRowClickListener());
         }

         this.invalidateView();
      }
   }

   public static class AttributionViewHolder extends ViewHolders.AbstractViewHolder {
      private AnimationDrawable a;
      @BindView
      public RadioGroup attributionRadioGroup;
      private Interpolator b = new AccelerateInterpolator();
      @BindView
      public CardView backCard;
      private Interpolator c = new DecelerateInterpolator();
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

      public AttributionViewHolder(View var1) {
         super(var1);
         this.a = (AnimationDrawable)this.jiboImage.getDrawable();
      }

      private int a(String var1) {
         int var2;
         if ("bing".equalsIgnoreCase(var1)) {
            var2 = 2131231012;
         } else {
            var2 = 2131231013;
         }

         return var2;
      }

      private void a() {
         LayoutParams var1 = (LayoutParams)this.backCard.getLayoutParams();
         var1.height = this.firstCard.getMeasuredHeight();
         this.backCard.setLayoutParams(var1);
         this.b();
         this.attributionRadioGroup.setOnCheckedChangeListener(new OnCheckedChangeListener(this) {
            final ViewHolders.AttributionViewHolder a;

            {
               this.a = var1;
            }

            public void onCheckedChanged(RadioGroup var1, int var2) {
               this.a.a.stop();
               this.a.jiboImage.setVisibility(8);
               this.a.submit.setVisibility(0);
               switch (var2) {
                  case 2131296580:
                  case 2131296743:
               }
            }
         });
         this.jiboImage.post(new Runnable(this) {
            final ViewHolders.AttributionViewHolder a;

            {
               this.a = var1;
            }

            @Override
            public void run() {
               this.a.a.start();
            }
         });
         this.submit.setOnClickListener(new OnClickListener(this) {
            final ViewHolders.AttributionViewHolder a;

            {
               this.a = var1;
            }

            public void onClick(View var1) {
               this.a.b();
            }
         });
      }

      private String b(String var1) {
         String var2 = "";

         try {
            URI var3 = new URI(var1);
            var1 = var3.getHost();
         } catch (URISyntaxException var4) {
            LogUtils.a(this.getClass().getSimpleName(), "Error while getting domain name", var4);
            var4.printStackTrace();
            var1 = var2;
         }

         return var1;
      }

      private void b() {
         CardView var1;
         CardView var2;
         if (this.firstCard.getVisibility() == 8) {
            var2 = this.backCard;
            var1 = this.firstCard;
         } else {
            var1 = this.backCard;
            var2 = this.firstCard;
         }

         ObjectAnimator var3 = ObjectAnimator.ofFloat(var2, "rotationY", new float[]{0.0F, 90.0F});
         var3.setDuration(500L);
         var3.setInterpolator(this.b);
         ObjectAnimator var4 = ObjectAnimator.ofFloat(var1, "rotationY", new float[]{-90.0F, 0.0F});
         var4.setDuration(500L);
         var4.setInterpolator(this.c);
         var3.addListener(new AnimatorListenerAdapter(this, var2, var4, var1) {
            final View a;
            final ObjectAnimator b;
            final View c;
            final ViewHolders.AttributionViewHolder d;

            {
               this.d = var1;
               this.a = var2x;
               this.b = var3x;
               this.c = var4x;
            }

            public void onAnimationEnd(Animator var1) {
               this.a.setVisibility(8);
               this.b.start();
               this.c.setVisibility(0);
            }
         });
         var3.start();
      }

      @Override
      public void invalidateView() {
         Attribution var1 = ((Items.AttributionItem)this.mItem).a();
         this.titleText.setText(var1.getQuery());
         if (var1.getService().equals("Wolfram Alpha")) {
            this.urlText.setText(2131755221);
         } else {
            this.urlText.setText(this.b(var1.getUrl()));
         }

         this.dateText.setText(UIUtils.c.format(new Date(var1.getTimestamp())));
         this.serviceIcon.setImageResource(this.a(var1.getService()));
         if (!TextUtils.isEmpty(var1.getImage_url())) {
            this.image.setVisibility(0);
            this.imageDivider.setVisibility(0);
            Glide.b(this.itemView.getContext()).a(var1.getImage_url()).a(this.image);
         } else {
            this.image.setVisibility(8);
            this.imageDivider.setVisibility(8);
         }

         this.wasItCorrectButton.setOnClickListener(new OnClickListener(this) {
            final ViewHolders.AttributionViewHolder a;

            {
               this.a = var1;
            }

            public void onClick(View var1) {
               this.a.wasItCorrectButton.setVisibility(8);
               this.a.a();
            }
         });
      }
   }

   public static class AvatarRadioTwoRowsSimpleViewHolder extends ViewHolders.AvatarTwoRowsSimpleViewHolder {
      @BindView
      public CompoundButton mCompoundButton;

      public AvatarRadioTwoRowsSimpleViewHolder(View var1) {
         super(var1);
      }

      @Override
      public void invalidateView() {
         super.invalidateView();
         this.mCompoundButton.setChecked(((Items.AvatarRadioTwoRowsSimpleItem)this.mItem).b());
      }

      @Override
      public void setData(Items.Item var1) {
         super.setData(var1);
         this.mCompoundButton.setClickable(false);
      }
   }

   public static class AvatarTwoRowsSimpleViewHolder extends ViewHolders.TwoRowsSimpleViewHolder {
      @BindView
      public ImageView icon;

      public AvatarTwoRowsSimpleViewHolder(View var1) {
         super(var1);
      }

      @Override
      public void invalidateView() {
         super.invalidateView();
         if (!TextUtils.isEmpty(((Items.AvatarTwoRowsSimpleItem)this.mItem).c())) {
            Glide.b(this.itemView.getContext()).a(((Items.AvatarTwoRowsSimpleItem)this.mItem).c()).e().a(DiskCacheStrategy.ALL).a(this.icon);
         } else if (((Items.AvatarTwoRowsSimpleItem)this.mItem).d() != -1) {
            this.icon.setImageResource(((Items.AvatarTwoRowsSimpleItem)this.mItem).d());
         } else {
            this.icon.setImageBitmap(null);
         }
      }
   }

   public static class DateViewHolder extends ViewHolders.SimpleViewHolder {
      public DateViewHolder(View var1) {
         super(var1);
      }
   }

   public static class FooterViewHolder extends ViewHolders.AbstractViewHolder {
      @BindView
      public TextView footer;

      public FooterViewHolder(View var1) {
         super(var1);
      }

      public void a(int var1) {
         this.footer.setTextColor(var1);
      }

      @Override
      public void invalidateView() {
         Items.FooterItem var1 = (Items.FooterItem)this.mItem;
         if (var1.a() instanceof SpannableStringBuilder) {
            this.footer.setText(var1.a(), BufferType.SPANNABLE);
            this.footer.setMovementMethod(LinkMovementMethod.getInstance());
         } else {
            this.footer.setText(var1.a());
            this.footer.setMovementMethod(null);
         }
      }
   }

   public static class HeaderButtonViewHolder extends ViewHolders.SimpleViewHolder {
      @BindView
      public TextView button;

      public HeaderButtonViewHolder(View var1) {
         super(var1);
      }

      @Override
      public void invalidateView() {
         super.invalidateView();
         this.button.setText(((Items.HeaderButtonItem)this.mItem).a());
      }

      @Override
      public void setData(Items.Item var1) {
         super.setData(var1);
         this.itemView.setOnClickListener(null);
         if (this.mItem.getOnRowClickListener() != null) {
            this.button.setOnClickListener(this.mItem.getOnRowClickListener());
         }
      }
   }

   public static class InviteMemberViewHolder extends ViewHolders.SimpleViewHolder {
      private AtomicBoolean a = new AtomicBoolean(false);
      @BindView
      View pulseView;

      public InviteMemberViewHolder(View var1) {
         super(var1);
      }

      @Override
      public void invalidateView() {
         super.invalidateView();
         if (this.itemView.getContext() instanceof GuidedExperienceActivity && !this.a.get()) {
            this.a.set(true);
            this.pulseView.setAlpha(1.0F);
            this.pulseView.setScaleX(1.0F);
            this.pulseView.setScaleY(1.0F);
            this.pulseView.animate().alpha(0.0F).scaleY(1.6F).scaleX(1.6F).setDuration(1000L).setListener(new AnimatorListener(this) {
               final ViewHolders.InviteMemberViewHolder a;

               {
                  this.a = var1;
               }

               public void onAnimationCancel(Animator var1) {
                  this.a.pulseView.setAlpha(0.0F);
                  this.a.pulseView.setScaleX(1.0F);
                  this.a.pulseView.setScaleY(1.0F);
                  this.a.pulseView.removeCallbacks(null);
               }

               public void onAnimationEnd(Animator var1) {
                  this.a.pulseView.postDelayed(new Runnable(this) {
                     final <unrepresentable> a;

                     {
                        this.a = var1;
                     }

                     @Override
                     public void run() {
                        this.a.a.a.set(false);
                        this.a.a.invalidateView();
                     }
                  }, 500L);
               }

               public void onAnimationRepeat(Animator var1) {
               }

               public void onAnimationStart(Animator var1) {
               }
            }).start();
         }
      }
   }

   public static class JiboHeaderViewHolder extends ViewHolders.AbstractViewHolder {
      @BindView
      public TextView name;
      @BindView
      public TextView status;

      public JiboHeaderViewHolder(View var1) {
         super(var1);
      }

      @Override
      protected void invalidateView() {
         this.name.setText(this.itemView.getContext().getString(2131755376) + "\n" + ((Items.JiboHeaderItem)this.mItem).a().getName());
         this.status.setText("");
      }
   }

   public static class JiboSettingsViewHolder extends ViewHolders.AbstractViewHolder {
      @BindView
      public ImageView avatar;

      public JiboSettingsViewHolder(View var1) {
         super(var1);
      }

      @Override
      public void invalidateView() {
         Items.JiboSettingsItem var1 = (Items.JiboSettingsItem)this.mItem;
         if (var1.a() != null) {
            this.avatar.setImageLevel(RobotHelper.getAvatar(var1.a()));
         }
      }
   }

   public static class LoopMemberSimpleViewHolder extends ViewHolders.AbstractViewHolder {
      @BindView
      public RoundedImageView avatar;
      @BindView
      public TextView name;
      @BindView
      public TextView nickName;

      // $VF: Duplicated exception handlers to handle obfuscated exceptions
      @Override
      public void invalidateView() {
         Member var1 = ((Items.MemberItem)this.mItem).b();
         ((Items.MemberItem)this.mItem).a();

         label28: {
            MemberAccount var2;
            try {
               var2 = var1.getAccount();
               if (!TextUtils.isEmpty(var1.getNickname())) {
                  Util.a(this.name, var1.getNickname());
                  break label28;
               }
            } catch (Exception var5) {
               Crashlytics.a(var5);
               break label28;
            }

            if (var2 == null) {
               try {
                  this.name.setText("");
               } catch (Exception var4) {
                  Crashlytics.a(var4);
               }
            } else {
               try {
                  Util.a(this.name, var2.getFirstName());
               } catch (Exception var3) {
                  Crashlytics.a(var3);
               }
            }
         }

         Util.a(this.itemView.getContext(), this.avatar, var1);
      }
   }

   public static class LoopMemberViewHolder extends ViewHolders.AbstractViewHolder {
      private final Account a;
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

      public LoopMemberViewHolder(View var1, Account var2) {
         super(var1);
         this.a = var2;
         var1.setLongClickable(true);
         this.nickName.setVisibility(8);
         this.textStatus.setVisibility(0);
      }

      // $VF: Duplicated exception handlers to handle obfuscated exceptions
      @Override
      public void invalidateView() {
         Member var4 = ((Items.MemberItem)this.mItem).b();
         Loop var5 = ((Items.MemberItem)this.mItem).a();

         label91: {
            MemberAccount var3;
            try {
               var3 = var4.getAccount();
               if (!TextUtils.isEmpty(var4.getNickname())) {
                  Util.a(this.name, var4.getNickname());
                  break label91;
               }
            } catch (Exception var14) {
               Crashlytics.a(var14);
               return;
            }

            if (var3 == null) {
               try {
                  this.name.setText("");
               } catch (Exception var13) {
                  Crashlytics.a(var13);
                  return;
               }
            } else {
               try {
                  Util.a(this.name, var3.getFirstName());
               } catch (Exception var12) {
                  Crashlytics.a(var12);
                  return;
               }
            }
         }

         try {
            Util.a(this.itemView.getContext(), this.avatar, var4);
            this.textStatus.setText("");
            this.textStatus.setTextColor(ImageUtils.b(this.itemView.getContext(), 2131099846));
            this.smartphone.setVisibility(8);
            if (var4.getAccount() == null) {
               return;
            }
         } catch (Exception var11) {
            Crashlytics.a(var11);
            return;
         }

         boolean var1;
         boolean var2;
         label74: {
            label73: {
               try {
                  var2 = LoopHelper.isOwner(var5, var4.getAccountId());
                  LoopHelper.isOwner(var5, this.a.getId());
                  if (var4.getAccountId() != null && var4.getAccountId().equals(this.a.getId())) {
                     break label73;
                  }
               } catch (Exception var10) {
                  Crashlytics.a(var10);
                  return;
               }

               var1 = false;
               break label74;
            }

            var1 = true;
         }

         if (var1) {
            try {
               this.textStatus.setText(2131755386);
            } catch (Exception var8) {
               Crashlytics.a(var8);
            }
         } else if (var2) {
            try {
               this.textStatus.setText(2131755384);
            } catch (Exception var7) {
               Crashlytics.a(var7);
            }
         } else {
            try {
               if (DateTimeUtils.isAdult(var4.getAccount().getBirthday())) {
                  if (!TextUtils.isEmpty(var4.getAccount().getEmail())) {
                     this.smartphone.setVisibility(0);
                  }

                  return;
               }
            } catch (Exception var9) {
               Crashlytics.a(var9);
               return;
            }

            try {
               if (var4.getStatus() == Member.InvitationStatus.invited && this.a.getId().equals(var5.getOwner())) {
                  this.textStatus.setText(2131755385);
                  this.textStatus.setTextColor(ImageUtils.b(this.itemView.getContext(), 2131099764));
               }
            } catch (Exception var6) {
               Crashlytics.a(var6);
            }
         }
      }
   }

   public static class OptionsBottomSheetDialogViewHolder extends ViewHolders.AbstractViewHolder {
      @BindView
      View item;
      @BindView
      public ImageView ivItem;
      @BindView
      public TextView tvItem;

      public OptionsBottomSheetDialogViewHolder(View var1) {
         super(var1);
      }

      @Override
      protected void invalidateView() {
      }

      @Override
      public void setData(Items.Item var1) {
         super.setData(var1);
         if (var1 instanceof Items.IconTextItem) {
            this.tvItem.setText(((Items.IconTextItem)var1).b());
            this.ivItem.setImageResource(((Items.IconTextItem)var1).a());
         }
      }
   }

   public static class SimpleViewHolder extends ViewHolders.AbstractViewHolder {
      @BindView
      public CustomFontTextView text;

      public SimpleViewHolder(View var1) {
         super(var1);
      }

      @Override
      public void invalidateView() {
         if (((Items.SimpleItem)this.mItem).d() != -1) {
            this.text.setText(((Items.SimpleItem)this.mItem).d());
         } else if (!TextUtils.isEmpty(((Items.SimpleItem)this.mItem).e())) {
            if (((Items.SimpleItem)this.mItem).e() instanceof SpannableStringBuilder) {
               this.text.setMovementMethod(LinkMovementMethod.getInstance());
            }

            this.text.setText(((Items.SimpleItem)this.mItem).e());
         }
      }
   }

   public static class SubheaderViewHolder extends ViewHolders.SimpleViewHolder {
      public SubheaderViewHolder(View var1) {
         super(var1);
      }
   }

   public static class SuspendedJiboViewHolder extends ViewHolders.AbstractViewHolder {
      @BindView
      ImageView avatar;
      @BindView
      TextView titleText;

      public SuspendedJiboViewHolder(View var1) {
         super(var1);
      }

      public void a(int var1) {
         this.avatar.setImageLevel(var1);
      }

      @Override
      public void invalidateView() {
         Loop var1 = ((Items.SuspendedLoopItem)this.mItem).a();
         this.titleText.setText(this.itemView.getContext().getResources().getString(2131755616, new Object[]{var1.getName()}));
      }
   }

   public static class SwitchStateViewHolder extends ViewHolders.SimpleViewHolder {
      @BindView
      public CompoundButton mCompoundButton;

      public SwitchStateViewHolder(View var1) {
         super(var1);
      }

      @Override
      public void invalidateView() {
         super.invalidateView();
         this.mCompoundButton.setChecked(((Items.StateSwitchItem)this.mItem).c());
         if (this.mItem.getOnRowClickListener() != null) {
            this.mCompoundButton.setClickable(false);
         }
      }

      @Override
      public void setData(Items.Item var1) {
         super.setData(var1);
      }
   }

   public static class SwitchStateWithDateViewHolder extends ViewHolders.SwitchStateViewHolder {
      @BindView
      public CustomFontTextView dateText;

      public SwitchStateWithDateViewHolder(View var1) {
         super(var1);
      }

      @Override
      public void setData(Items.Item var1) {
         super.setData(var1);
         if (this.mItem instanceof Items.CheckboxDateItem) {
            var1 = (Items.CheckboxDateItem)this.mItem;
         } else {
            var1 = null;
         }

         if (var1 != null) {
            if (!TextUtils.isEmpty(var1.b())) {
               this.dateText.setText(DateTimeUtils.getBirthdayString(CustomHolidaysUtils.a(var1.b()), "MMMM d, yyyy"));
            }

            if (var1.a() != null) {
               this.itemView.setOnLongClickListener(var1.a());
            }
         }
      }
   }

   public static class TwoRowsSimpleViewHolder extends ViewHolders.AbstractViewHolder {
      @BindView
      public CustomFontTextView subtitle;
      @BindView
      public CustomFontTextView title;

      public TwoRowsSimpleViewHolder(View var1) {
         super(var1);
      }

      @Override
      public void invalidateView() {
         if (((Items.TwoRowsSimpleItem)this.mItem).e() instanceof SpannableStringBuilder) {
            this.title.setMovementMethod(LinkMovementMethod.getInstance());
         }

         this.title.setText(((Items.TwoRowsSimpleItem)this.mItem).e());
         if (TextUtils.isEmpty(((Items.TwoRowsSimpleItem)this.mItem).f())) {
            this.subtitle.setVisibility(8);
         } else {
            if (((Items.TwoRowsSimpleItem)this.mItem).f() instanceof SpannableStringBuilder) {
               this.subtitle.setMovementMethod(LinkMovementMethod.getInstance());
            }

            this.subtitle.setText(((Items.TwoRowsSimpleItem)this.mItem).f());
            this.subtitle.setVisibility(0);
         }
      }
   }

   public static class WifiSettingsViewHolder extends ViewHolders.AbstractViewHolder {
      @BindView
      public TextView name;

      public WifiSettingsViewHolder(View var1) {
         super(var1);
      }

      @Override
      public void invalidateView() {
         Items.WifiSettingsItem var2 = (Items.WifiSettingsItem)this.mItem;
         StatusContainer var3 = var2.b();
         TextView var4 = this.name;
         String var5;
         if (var3 != null && var3.getConnected()) {
            var5 = RobotHelper.getWifiName(var2.a());
         } else {
            var5 = this.itemView.getContext().getString(2131755444);
         }

         var4.setText(var5);
         var4 = this.name;
         Context var6 = this.itemView.getContext();
         int var1;
         if (var3 != null && var3.getConnected()) {
            var1 = 2131099846;
         } else {
            var1 = 2131099764;
         }

         var4.setTextColor(ImageUtils.b(var6, var1));
      }
   }
}
