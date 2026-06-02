package com.jibo.ui.fragment.account.skills;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.BindView;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.handlers.AsyncHandler;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.jibo.aws.integration.aws.services.account.model.Account;
import com.jibo.aws.integration.aws.services.loop.model.Loop;
import com.jibo.aws.integration.aws.services.skills.JiboSkillsAsyncClient;
import com.jibo.aws.integration.aws.services.skills.model.DeleteSettingsRequest;
import com.jibo.aws.integration.aws.services.skills.model.UpdateSettingsRequest;
import com.jibo.aws.integration.helpers.LoopHelper;
import com.jibo.aws.integration.util.Commons;
import com.jibo.db.EntityData;
import com.jibo.ui.fragment.BaseFragment;
import com.jibo.ui.fragment.dialog.skills.MaterialTimePickerDialogFragment;
import com.jibo.ui.helpers.Items;
import com.jibo.ui.helpers.ViewHolders;
import com.jibo.ui.helpers.skills.DataItems;
import com.jibo.ui.helpers.skills.ItemFactory;
import com.jibo.ui.helpers.skills.SkillBasedRecycleViewAdapter;
import com.jibo.ui.helpers.skills.SkillsJsonParser;
import com.jibo.utils.SharedPreferencesUtil;
import java.util.ArrayList;
import java.util.List;

public class SkillSettingsFragment extends BaseFragment implements MaterialTimePickerDialogFragment.DataChangedListener {
   public static final String a = SkillSettingsFragment.class.getSimpleName();
   private List<Items.Item> b = new ArrayList<>();
   private SkillBasedRecycleViewAdapter c;
   private int[] d;
   private String e;
   private JiboSkillsAsyncClient l;
   @BindView
   RecyclerView list;
   private SkillSettingsFragment.DataPublisher m = new SkillSettingsFragment.DataPublisher(this) {
      final SkillSettingsFragment a;

      {
         this.a = var1;
      }

      @Override
      public void a(DataItems.DataItem var1, DataItems.DataValue var2, Commons.AsyncCallback<DataItems.DataValue> var3) {
         if (var1 != null && var2 != null) {
            this.a.f();
            JsonElement var5 = new Gson().a(var2);
            UpdateSettingsRequest.UpdateSettingData var6 = new UpdateSettingsRequest.UpdateSettingData(
               var1.getValueDefinition().getKey(),
               new UpdateSettingsRequest.UpdateSettingData.UpdateSettingValue(
                  SkillsJsonParser.getInstance().getCurrentSkill().getSkillId(), var1.getValueDefinition().getTarget(), var5
               )
            );
            Loop var4 = SharedPreferencesUtil.f(this.a.getActivity());
            this.a
               .l
               .updateSkill(
                  var4.getId(),
                  var6,
                  new AsyncHandler<UpdateSettingsRequest, UpdateSettingsRequest.UpdateSettingData>(this, var1, var2) {
                     final DataItems.DataItem a;
                     final DataItems.DataValue b;
                     final <unrepresentable> c;

                     {
                        this.c = var1;
                        this.a = var2x;
                        this.b = var3x;
                     }

                     public void a(UpdateSettingsRequest var1, UpdateSettingsRequest.UpdateSettingData var2x) {
                        SkillsJsonParser.getInstance().updateData(this.a.getValueDefinition().getKey(), this.b);
                        SkillsJsonParser.getInstance()
                           .setItemDataValue(((com.jibo.ui.helpers.skills.Items.SkillSimpleItem)this.c.a.b.get(this.a.getIndex())).getDataItem());
                        this.c.a.c.notifyItemChanged(this.a.getIndex());
                        this.c.a.g();
                     }

                     @Override
                     public void onError(Exception var1) {
                        this.c.a.a(var1, "skills update skill", true);
                     }
                  }
               );
         }
      }
   };
   private SkillSettingsFragment.DataPublisher n = new SkillSettingsFragment.DataPublisher(this) {
      final SkillSettingsFragment a;

      {
         this.a = var1;
      }

      @Override
      public void a(DataItems.DataItem var1, DataItems.DataValue var2, Commons.AsyncCallback<DataItems.DataValue> var3) {
         if (var1 != null) {
            this.a.f();
            String var4 = "*:workCalendar:*";
            if (var1.getValueDefinition().getKey().contains("personal")) {
               var4 = "*:personalCalendar:*";
            }

            DeleteSettingsRequest.DeleteSettingData var5 = new DeleteSettingsRequest.DeleteSettingData(
               var4,
               new DeleteSettingsRequest.DeleteSettingData.DeleteSettingValue(
                  SkillsJsonParser.getInstance().getCurrentSkill().getSkillId(), var1.getValueDefinition().getTarget()
               )
            );
            Loop var6 = SharedPreferencesUtil.f(this.a.getActivity());
            this.a
               .l
               .deleteSettings(
                  var6.getId(),
                  var5,
                  new AsyncHandler<DeleteSettingsRequest, DeleteSettingsRequest.DeleteSettingData>(this, var1) {
                     final DataItems.DataItem a;
                     final <unrepresentable> b;

                     {
                        this.b = var1;
                        this.a = var2x;
                     }

                     public void a(DeleteSettingsRequest var1, DeleteSettingsRequest.DeleteSettingData var2x) {
                        DataItems.ConnectableDataValue var3x = new DataItems.ConnectableDataValue();
                        var3x.setConnected(false);
                        SkillsJsonParser.getInstance().updateData(this.a.getValueDefinition().getKey(), var3x);
                        SkillsJsonParser.getInstance()
                           .setItemDataValue(((com.jibo.ui.helpers.skills.Items.SkillSimpleItem)this.b.a.b.get(this.a.getIndex())).getDataItem());
                        this.b.a.c.notifyItemChanged(this.a.getIndex());
                        this.b.a.g();
                     }

                     @Override
                     public void onError(Exception var1) {
                        this.b.a.a(var1, "skills delete skill", true);
                     }
                  }
               );
         }
      }
   };

   private void b() {
      this.b.clear();
      List var1 = new ItemFactory(this.d, this.m, this.n).getItems(SkillsJsonParser.getInstance().getViews(this.d));
      if (!var1.isEmpty()) {
         this.b.addAll(var1);
      }

      this.c.notifyDataSetChanged();
   }

   @Override
   protected void a(ActionBar var1) {
      super.a(var1);
      var1.setDisplayHomeAsUpEnabled(true);
   }

   @Override
   public void a(DataItems.DataItem var1, DataItems.DataValue var2) {
      this.m.a(var1, var2, null);
   }

   public int[] a() {
      return this.d;
   }

   @Override
   public void b(Bundle var1) {
      super.b(var1);
      this.d = var1.getIntArray("PARAM_PATH");
      this.e = var1.getString("PARAM_TITLE");
   }

   @Override
   protected String o() {
      return this.e;
   }

   @Override
   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      this.setHasOptionsMenu(true);
      return var1.inflate(2131427459, var2, false);
   }

   @Override
   public void onResume() {
      super.onResume();
      this.b();
   }

   @Override
   public void onSaveInstanceState(Bundle var1) {
      super.onSaveInstanceState(var1);
      var1.putIntArray("PARAM_PATH", this.d);
      var1.putString("PARAM_TITLE", this.e);
      var1.putBoolean("ARGS_SKILL_FRAGMENT", true);
   }

   @Override
   public void onViewCreated(View var1, Bundle var2) {
      super.onViewCreated(var1, var2);
      this.k = SharedPreferencesUtil.f(this.getActivity());
      this.c = new SkillBasedRecycleViewAdapter(this.b, LoopHelper.isOwner(this.k, EntityData.a(this.getContext()).i().getId()));
      this.list.setHasFixedSize(true);
      this.list.setItemAnimator(new DefaultItemAnimator());
      this.list.setLayoutManager(new LinearLayoutManager(this.getActivity(), 1, false));
      this.list.addItemDecoration(new SkillSettingsFragment.SpacesItemDecoration(this.getActivity(), 2131165462, 2131165263, 2131165366));
      this.list.setAdapter(this.c);
      Account var3 = EntityData.a(this.getActivity()).i();
      if (var3 != null) {
         JiboSkillsAsyncClient var4 = new JiboSkillsAsyncClient(new BasicAWSCredentials(var3.getAccessKeyId(), var3.getSecretAccessKey()));
         this.l = var4;
         this.a(var4);
      }
   }

   public interface DataPublisher {
      void a(DataItems.DataItem var1, DataItems.DataValue var2, Commons.AsyncCallback<DataItems.DataValue> var3);
   }

   public static class SpacesItemDecoration extends RecyclerView.ItemDecoration {
      private int a;
      private int b;
      private int c;

      public SpacesItemDecoration(Context var1, int var2, int var3, int var4) {
         byte var5 = 0;
         super();
         if (var2 != -1) {
            var2 = var1.getResources().getDimensionPixelOffset(var2);
         } else {
            var2 = 0;
         }

         this.a = var2;
         if (var3 != -1) {
            var2 = var1.getResources().getDimensionPixelOffset(var3);
         } else {
            var2 = 0;
         }

         this.b = var2;
         var2 = var5;
         if (var4 != -1) {
            var2 = var1.getResources().getDimensionPixelOffset(var4);
         }

         this.c = var2;
      }

      @Override
      public void a(Rect var1, View var2, RecyclerView var3, RecyclerView.State var4) {
         if (var3.getChildAdapterPosition(var2) == 0 && !(var3.findContainingViewHolder(var2) instanceof ViewHolders.SubheaderViewHolder)) {
            var1.top = this.a;
         }

         var1.bottom = this.c;
         if (var3.getChildAdapterPosition(var2) == var3.getAdapter().getItemCount() - 1) {
            var1.bottom = this.b / 2;
         }
      }
   }
}
