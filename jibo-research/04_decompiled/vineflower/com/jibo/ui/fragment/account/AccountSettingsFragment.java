package com.jibo.ui.fragment.account;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.TextView;
import butterknife.BindView;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.handlers.AsyncHandler;
import com.crashlytics.android.Crashlytics;
import com.jibo.JiboAnalytics;
import com.jibo.JiboSupport;
import com.jibo.aws.integration.aws.services.account.model.Account;
import com.jibo.aws.integration.aws.services.loop.model.Loop;
import com.jibo.aws.integration.aws.services.loop.model.Member;
import com.jibo.aws.integration.aws.services.loop.model.MemberAccount;
import com.jibo.aws.integration.aws.services.skills.JiboSkillsAsyncClient;
import com.jibo.aws.integration.aws.services.skills.model.GetSettingsRequest;
import com.jibo.aws.integration.helpers.LoopHelper;
import com.jibo.db.EntityData;
import com.jibo.ui.activity.BaseActivity;
import com.jibo.ui.activity.SingleFragmentActivity;
import com.jibo.ui.activity.TabbedActivity;
import com.jibo.ui.fragment.BaseFragment;
import com.jibo.ui.fragment.dialog.CantDeleteDialog;
import com.jibo.ui.helpers.Items;
import com.jibo.ui.helpers.ViewHolders;
import com.jibo.ui.helpers.skills.ItemFactory;
import com.jibo.ui.helpers.skills.SkillBasedRecycleViewAdapter;
import com.jibo.ui.helpers.skills.SkillsJsonParser;
import com.jibo.ui.view.RoundedImageView;
import com.jibo.ui.view.proxima.ProximaHelper;
import com.jibo.utils.ErrorHelper;
import com.jibo.utils.SharedPreferencesUtil;
import com.jibo.utils.Util;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AccountSettingsFragment extends BaseFragment {
   public static final String a = AccountSettingsFragment.class.getSimpleName();
   private List<Items.Item> b = new ArrayList<>();
   private ArrayList<Loop> c;
   private AccountSettingsFragment.SettingsItemsAdapter d;
   private Account e;
   private JiboSkillsAsyncClient l;
   @BindView
   RecyclerView list;

   private void b() {
      Loop var1 = SharedPreferencesUtil.f(this.getActivity());
      if ((SkillsJsonParser.getInstance().getViews(null) == null || SkillsJsonParser.getInstance().getViews(null).isEmpty()) && this.l != null && var1 != null) {
         this.f();
         this.l.getSkillsJson(var1.getId(), new AsyncHandler<GetSettingsRequest, String>(this) {
            final AccountSettingsFragment a;

            {
               this.a = var1;
            }

            public void a(GetSettingsRequest var1, String var2) {
               SkillsJsonParser.getInstance().parseSkills(var2);
               List var3 = new ItemFactory(null, null).getItems(SkillsJsonParser.getInstance().getViews(null));
               this.a.a(new Runnable(this, var3) {
                  final List a;
                  final <unrepresentable> b;

                  {
                     this.b = var1;
                     this.a = var2x;
                  }

                  @Override
                  public void run() {
                     this.b.a.g();
                     if (!this.a.isEmpty()) {
                        this.b.a.b.addAll(3, this.a);
                        this.b.a.d.notifyDataSetChanged();
                     }
                  }
               });
            }

            @Override
            public void onError(Exception var1) {
               this.a.a(new Runnable(this) {
                  final <unrepresentable> a;

                  {
                     this.a = var1;
                  }

                  @Override
                  public void run() {
                     this.a.a.g();
                  }
               });
               this.a.a(var1, "skills get skills json", false);
               if (!ErrorHelper.b((AmazonServiceException)var1) && !ErrorHelper.a((AmazonServiceException)var1)) {
               }
            }
         });
      }
   }

   private void q() {
      this.b.clear();
      Loop var3 = SharedPreferencesUtil.f(this.getActivity());
      this.b.add(new Items.SubheaderItem(2131755659));
      Member var2 = LoopHelper.getMemberForAccount(SharedPreferencesUtil.f(this.getActivity()), this.e);
      Member var1 = var2;
      if (var2 == null) {
         var1 = new Member();
         MemberAccount var7 = new MemberAccount();
         var7.setBirthday(this.e.getBirthday());
         var7.setEmail(this.e.getEmail());
         var7.setFirstName(this.e.getFirstName());
         var7.setGender(this.e.getGender());
         var7.setLastName(this.e.getLastName());
         var7.setNickName(this.e.getFullName());
         var7.setPhotoUrl(this.e.getPhotoUrl());
         var1.setAccount(var7);
         var1.setNickname(var7.getNickName());
      }

      Bundle var8 = new Bundle();
      var8.putString("string", this.getString(2131755771));
      this.b.add(new Items.MemberItem(new OnClickListener(this) {
         final AccountSettingsFragment a;

         {
            this.a = var1;
         }

         public void onClick(View var1) {
            ((BaseActivity)this.a.getActivity()).c(AccountSettingsDetailsFragment.class, null);
         }
      }, var3, var1, var8));
      this.b.add(new Items.SubheaderItem(2131755744));
      if (var3 != null && SkillsJsonParser.getInstance().getViews(null) != null && !SkillsJsonParser.getInstance().getViews(null).isEmpty()) {
         List var5 = new ItemFactory(null, null).getItems(SkillsJsonParser.getInstance().getViews(null));
         if (!var5.isEmpty()) {
            this.b.addAll(var5);
         }
      }

      this.b.add(new Items.SubheaderItem(2131755831));
      this.b.add(new Items.SwitchRowItem(new OnClickListener(this) {
         final AccountSettingsFragment a;

         {
            this.a = var1;
         }

         public void onClick(View var1) {
            FragmentActivity var4 = this.a.getActivity();
            boolean var2;
            if (!SharedPreferencesUtil.p(this.a.getActivity())) {
               var2 = true;
            } else {
               var2 = false;
            }

            SharedPreferencesUtil.a(var4, var2);

            for (Items.Item var3 : this.a.b) {
               if (var3 instanceof Items.SwitchRowItem) {
                  ((Items.SwitchRowItem)var3).a(SharedPreferencesUtil.p(this.a.getActivity()));
                  this.a.d.notifyItemChanged(this.a.b.indexOf(var3));
                  break;
               }
            }
         }
      }, 2131755810, SharedPreferencesUtil.p(this.getActivity())));
      this.b.add(new Items.SubheaderItem(2131755854));
      this.b.add(new Items.SimpleItem(Items.ItemType.text_bold_single_row, new OnClickListener(this) {
         final AccountSettingsFragment a;

         {
            this.a = var1;
         }

         public void onClick(View var1) {
            JiboAnalytics.h(this.a.getActivity());
            JiboSupport.a(this.a.getActivity());
         }
      }, 2131755788));
      this.b.add(new Items.SimpleItem(Items.ItemType.text_bold_single_row, new OnClickListener(this) {
         final AccountSettingsFragment a;

         {
            this.a = var1;
         }

         public void onClick(View var1) {
            JiboAnalytics.e(this.a.getActivity(), JiboAnalytics.aJ);
            JiboSupport.b(this.a.getActivity());
         }
      }, 2131755835));
      this.b.add(new Items.SimpleItem(Items.ItemType.text_bold_single_row, new OnClickListener(this) {
         final AccountSettingsFragment a;

         {
            this.a = var1;
         }

         public void onClick(View var1) {
            this.a.getActivity().setResult(TabbedActivity.c);
            this.a.getActivity().finish();
         }
      }, 2131755803));
      this.b.add(new Items.SimpleItem(Items.ItemType.text_button_small, new OnClickListener(this) {
         final AccountSettingsFragment a;

         {
            this.a = var1;
         }

         public void onClick(View var1) {
            Intent var2 = new Intent("android.intent.action.VIEW", Uri.parse(this.a.getString(2131755604)));
            this.a.startActivity(var2);
         }
      }, 2131755828));
      this.b.add(new Items.SimpleItem(Items.ItemType.text_button_small, new OnClickListener(this) {
         final AccountSettingsFragment a;

         {
            this.a = var1;
         }

         public void onClick(View var1) {
            Intent var2 = new Intent("android.intent.action.VIEW", Uri.parse(this.a.getString(2131755758)));
            this.a.startActivity(var2);
         }
      }, 2131755856));
      this.b.add(new Items.SimpleItem(Items.ItemType.text_button_small, new OnClickListener(this) {
         final AccountSettingsFragment a;

         {
            this.a = var1;
         }

         public void onClick(View var1) {
            Intent var2 = new Intent("android.intent.action.VIEW", Uri.parse(this.a.getString(2131755437)));
            this.a.startActivity(var2);
         }
      }, 2131755797));

      try {
         String var6 = this.getActivity().getPackageManager().getPackageInfo(this.getActivity().getPackageName(), 0).versionName;
         List var9 = this.b;
         Items.FooterItem var10 = new Items.FooterItem(this.getString(2131755765, var6));
         var9.add(var10);
      } catch (NameNotFoundException var4) {
         Crashlytics.a(var4);
      }

      this.b.add(new Items.SimpleItem(Items.ItemType.text_button_small_red, new OnClickListener(this) {
         final AccountSettingsFragment a;

         {
            this.a = var1;
         }

         public void onClick(View var1) {
            this.a.a();
         }
      }, 2131755087));
      this.d.notifyDataSetChanged();
   }

   public void a() {
      boolean var2;
      boolean var4;
      if (this.c != null) {
         Iterator var6 = this.c.iterator();
         boolean var1 = false;
         boolean var3 = false;

         while (true) {
            var2 = var1;
            var4 = var3;
            if (!var6.hasNext()) {
               break;
            }

            Loop var5 = (Loop)var6.next();
            if (LoopHelper.isOwner(var5, EntityData.a(this.getContext()).i().getId())) {
               if (var5.isSuspended()) {
                  var3 = true;
               } else {
                  var1 = true;
               }
            }
         }
      } else {
         var2 = false;
         var4 = false;
      }

      if (var2) {
         new CantDeleteDialog().show(this.getActivity().getSupportFragmentManager(), CantDeleteDialog.class.getSimpleName());
      } else {
         JiboAnalytics.a(this.getActivity());
         SingleFragmentActivity.Builder var7 = new SingleFragmentActivity.Builder(this, AccountDeleteFragment.class.getName());
         var7.a("ARG_IS_OWNER_AND_SUSPENDED", var4);
         var7.a(1002);
      }
   }

   @Override
   protected void a(ActionBar var1) {
      super.a(var1);
      var1.setDisplayHomeAsUpEnabled(true);
   }

   @Override
   protected String o() {
      return this.getString(2131756024);
   }

   @Override
   public void onCreate(Bundle var1) {
      super.onCreate(var1);
      if (this.getArguments().containsKey("ARG_LOOPS")) {
         this.c = this.getArguments().getParcelableArrayList("ARG_LOOPS");
      }

      this.e = EntityData.a(this.getActivity()).i();
   }

   @Override
   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      return var1.inflate(2131427459, var2, false);
   }

   @Override
   public void onResume() {
      super.onResume();
      this.b();
   }

   @Override
   public void onViewCreated(View var1, Bundle var2) {
      super.onViewCreated(var1, var2);
      this.d = new AccountSettingsFragment.SettingsItemsAdapter(
         this.b, LoopHelper.isOwner(SharedPreferencesUtil.f(this.getActivity()), EntityData.a(this.getContext()).i().getId())
      );
      this.list.setHasFixedSize(true);
      this.list.setItemAnimator(new DefaultItemAnimator());
      this.list.setLayoutManager(new LinearLayoutManager(this.getActivity(), 1, false));
      this.list.addItemDecoration(new AccountSettingsFragment.SettingsItemsAdapter.SpacesItemDecoration(this.getActivity(), 2131165263, 2131165366));
      this.list.setAdapter(this.d);
      if (this.e != null) {
         JiboSkillsAsyncClient var3 = new JiboSkillsAsyncClient(new BasicAWSCredentials(this.e.getAccessKeyId(), this.e.getSecretAccessKey()));
         this.l = var3;
         this.a(var3);
      }

      this.q();
   }

   public static class SettingsItemsAdapter extends SkillBasedRecycleViewAdapter {
      public SettingsItemsAdapter(List<Items.Item> var1, boolean var2) {
         super(var1, var2);
      }

      @Override
      protected ViewHolders.AbstractViewHolder getViewHolderByItem(View var1, Items.ItemType var2) {
         ViewHolders.AbstractViewHolder var3;
         switch (<unrepresentable>.a[var2.ordinal()]) {
            case 1:
               var3 = new AccountSettingsFragment.SettingsItemsAdapter.AvatarTwoRowsSimpleViewHolder(var1);
               break;
            case 2:
               var3 = new AccountSettingsFragment.SettingsItemsAdapter.LoopMemberSimpleViewHolder(var1);
               break;
            default:
               var3 = super.getViewHolderByItem(var1, var2);
         }

         return var3;
      }

      public static class AvatarTwoRowsSimpleViewHolder extends ViewHolders.AvatarTwoRowsSimpleViewHolder {
         public AvatarTwoRowsSimpleViewHolder(View var1) {
            super(var1);
            ProximaHelper.b(this.subtitle);
         }
      }

      public static class LoopMemberSimpleViewHolder extends ViewHolders.AbstractViewHolder {
         @BindView
         public RoundedImageView avatar;
         @BindView
         public TextView name;
         @BindView
         public TextView nickName;

         public LoopMemberSimpleViewHolder(View var1) {
            super(var1);
            this.nickName.setVisibility(0);
         }

         // $VF: Duplicated exception handlers to handle obfuscated exceptions
         @Override
         public void invalidateView() {
            Member var1 = ((Items.MemberItem)this.mItem).b();

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

            this.nickName.setText(((Items.MemberItem)this.mItem).c().getString("string"));
            Util.a(this.itemView.getContext(), this.avatar, var1);
         }
      }

      public static class SpacesItemDecoration extends RecyclerView.ItemDecoration {
         private int a;
         private int b;

         public SpacesItemDecoration(Context var1, int var2, int var3) {
            byte var4 = 0;
            super();
            if (var2 != -1) {
               var2 = var1.getResources().getDimensionPixelOffset(var2);
            } else {
               var2 = 0;
            }

            this.a = var2;
            var2 = var4;
            if (var3 != -1) {
               var2 = var1.getResources().getDimensionPixelOffset(var3);
            }

            this.b = var2;
         }

         @Override
         public void a(Rect var1, View var2, RecyclerView var3, RecyclerView.State var4) {
            if (var3.getChildAdapterPosition(var2) == var3.getAdapter().getItemCount() - 6) {
               var1.top = this.a;
            }

            if (var3.getChildAdapterPosition(var2) == var3.getAdapter().getItemCount() - 5) {
               var1.top = this.a / 2;
            }

            if (var3.getChildAdapterPosition(var2) == var3.getAdapter().getItemCount() - 2) {
               var1.top = this.a / 2;
            }

            var1.bottom = this.b;
            if (var3.getChildAdapterPosition(var2) == var3.getAdapter().getItemCount() - 1) {
               var1.top = this.a / 2;
               var1.bottom = this.a / 2;
            }
         }
      }
   }
}
