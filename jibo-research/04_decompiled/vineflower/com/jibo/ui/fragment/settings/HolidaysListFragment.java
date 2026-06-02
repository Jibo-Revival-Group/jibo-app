package com.jibo.ui.fragment.settings;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.handlers.AsyncHandler;
import com.jibo.JiboAnalytics;
import com.jibo.aws.integration.aws.services.account.model.Account;
import com.jibo.aws.integration.aws.services.common.model.CommandResponse;
import com.jibo.aws.integration.aws.services.person.JiboPersonAsyncClient;
import com.jibo.aws.integration.aws.services.person.model.Holiday;
import com.jibo.aws.integration.aws.services.person.model.HolidaysSwitchRequest;
import com.jibo.db.EntityData;
import com.jibo.ui.fragment.BaseFragment;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class HolidaysListFragment extends BaseFragment {
   public static final String a = HolidaysListFragment.class.getSimpleName();
   private JiboPersonAsyncClient b;
   private List<Holiday> c;
   private boolean d;
   @BindView
   RecyclerView list;

   private void a(boolean var1, List<Holiday> var2) {
      ArrayList var3 = new ArrayList();
      Iterator var4 = var2.iterator();

      while (var4.hasNext()) {
         var3.add(((Holiday)var4.next()).getId());
      }

      this.f();
      this.b.switchHolidays(var1, var3, this.k.getId(), new AsyncHandler<HolidaysSwitchRequest, CommandResponse>(this, var2, var1) {
         final List a;
         final boolean b;
         final HolidaysListFragment c;

         {
            this.c = var1;
            this.a = var2x;
            this.b = var3x;
         }

         public void a(HolidaysSwitchRequest var1, CommandResponse var2x) {
            this.c.a(new Runnable(this) {
               final <unrepresentable> a;

               {
                  this.a = var1;
               }

               @Override
               public void run() {
                  for (Holiday var2x : this.a.a) {
                     var2x.setEnabled(this.a.b);
                     JiboAnalytics.a(this.a.c.getActivity(), var2x.getName(), this.a.b);
                  }

                  this.a.c.getActivity().invalidateOptionsMenu();
                  this.a.c.list.getAdapter().notifyDataSetChanged();
                  this.a.c.g();
               }
            });
         }

         @Override
         public void onError(Exception var1) {
            this.c.a(var1, "switch holidays", true);
         }
      });
   }

   @Override
   protected void a(ActionBar var1) {
      super.a(var1);
      var1.setDisplayHomeAsUpEnabled(true);
   }

   @Override
   protected String o() {
      return this.getString(this.getArguments().getInt("ARG_TITLE"));
   }

   @Override
   public void onCreate(Bundle var1) {
      super.onCreate(var1);
      if (var1 != null) {
         this.c = var1.getParcelableArrayList("ARG_ARRAY");
      } else if (this.getArguments() != null) {
         this.c = this.getArguments().getParcelableArrayList("ARG_ARRAY");
      }
   }

   @Override
   public void onCreateOptionsMenu(Menu var1, MenuInflater var2) {
      super.onCreateOptionsMenu(var1, var2);
      var2.inflate(2131492875, var1);
      if (this.c != null && !this.c.isEmpty()) {
         this.d = true;
         Iterator var4 = this.c.iterator();

         while (var4.hasNext()) {
            if (!((Holiday)var4.next()).getEnabled()) {
               this.d = false;
               break;
            }
         }

         MenuItem var3 = var1.findItem(2131296298);
         String var5;
         if (this.d) {
            var5 = this.getString(2131755529);
         } else {
            var5 = this.getString(2131755528);
         }

         var3.setTitle(var5);
         var1.findItem(2131296298).setEnabled(true);
      }
   }

   @Override
   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      this.setHasOptionsMenu(true);
      return var1.inflate(2131427459, var2, false);
   }

   @Override
   public boolean onOptionsItemSelected(MenuItem var1) {
      boolean var3 = true;
      boolean var4;
      if (var1.getItemId() == 2131296298) {
         if (!this.d) {
            var4 = true;
         } else {
            var4 = false;
         }

         this.a(var4, this.c);
         var1.setEnabled(false);
         var4 = var3;
      } else {
         var4 = super.onOptionsItemSelected(var1);
      }

      return var4;
   }

   @Override
   public void onResume() {
      super.onResume();
      if (this.getArguments() == null || !this.getArguments().containsKey("ARG_ARRAY") || !this.getArguments().containsKey("ARG_TITLE") || this.c.isEmpty()) {
         this.getActivity().onBackPressed();
      }
   }

   @Override
   public void onSaveInstanceState(Bundle var1) {
      super.onSaveInstanceState(var1);
      var1.putParcelableArrayList("ARG_ARRAY", (ArrayList)this.c);
   }

   @Override
   public void onViewCreated(View var1, Bundle var2) {
      super.onViewCreated(var1, var2);
      LinearLayoutManager var3 = new LinearLayoutManager(this.getActivity());
      var3.b(1);
      this.list.setHasFixedSize(true);
      this.list.setItemAnimator(new DefaultItemAnimator());
      this.list.addItemDecoration(new HolidaysListFragment.SpacesItemDecoration(this.getActivity(), 2131165260));
      this.list.setLayoutManager(var3);
      HolidaysListFragment.HolidaysAdapter var4 = new HolidaysListFragment.HolidaysAdapter(this, this.c);
      this.list.setAdapter(var4);
      Account var5 = EntityData.a(this.getActivity()).i();
      JiboPersonAsyncClient var6 = new JiboPersonAsyncClient(new BasicAWSCredentials(var5.getAccessKeyId(), var5.getSecretAccessKey()));
      this.b = var6;
      this.a(var6);
   }

   private static class EmptyViewHolder extends RecyclerView.ViewHolder {
      public EmptyViewHolder(View var1) {
         super(var1);
      }
   }

   static class HolidayViewHolder extends RecyclerView.ViewHolder {
      private HolidaysListFragment a;
      private Holiday b;
      private OnClickListener c = new OnClickListener(this) {
         final HolidaysListFragment.HolidayViewHolder a;

         {
            this.a = var1;
         }

         public void onClick(View var1) {
            ArrayList var4 = new ArrayList();
            var4.add(this.a.b);
            HolidaysListFragment var3 = this.a.a;
            boolean var2;
            if (!this.a.b.getEnabled()) {
               var2 = true;
            } else {
               var2 = false;
            }

            var3.a(var2, var4);
         }
      };
      @BindView
      public CheckBox checkbox;
      @BindView
      public TextView text1;

      public HolidayViewHolder(View var1, HolidaysListFragment var2) {
         super(var1);
         this.a = var2;
         ButterKnife.a(this, var1);
         this.itemView.setOnClickListener(this.c);
         this.checkbox.setOnClickListener(this.c);
      }

      public void a(Holiday var1) {
         this.b = var1;
         this.checkbox.setChecked(this.b.getEnabled());
         this.text1.setText(var1.getName());
      }
   }

   public static class HolidaysAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
      private HolidaysListFragment a;
      private List<Holiday> b;

      public HolidaysAdapter(HolidaysListFragment var1, List<Holiday> var2) {
         this.a = var1;
         this.b = var2;
      }

      public Holiday a(int var1) {
         return this.b.get(var1);
      }

      @Override
      public int getItemCount() {
         return this.b.size();
      }

      @Override
      public int getItemViewType(int var1) {
         if (TextUtils.isEmpty(this.b.get(var1).getId())) {
            var1 = HolidaysListFragment.ItemType.empty.ordinal();
         } else {
            var1 = HolidaysListFragment.ItemType.holiday.ordinal();
         }

         return var1;
      }

      @Override
      public void onBindViewHolder(RecyclerView.ViewHolder var1, int var2) {
         if (var1 instanceof HolidaysListFragment.HolidayViewHolder) {
            ((HolidaysListFragment.HolidayViewHolder)var1).a(this.b.get(var2));
         }
      }

      @Override
      public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup var1, int var2) {
         RecyclerView.ViewHolder var4;
         if (var2 == HolidaysListFragment.ItemType.empty.ordinal()) {
            View var3 = new View(this.a.getActivity());
            var3.setLayoutParams(new RecyclerView.LayoutParams(-1, this.a.getResources().getDimensionPixelOffset(2131165260)));
            var4 = new HolidaysListFragment.EmptyViewHolder(var3);
         } else {
            var4 = new HolidaysListFragment.HolidayViewHolder(LayoutInflater.from(var1.getContext()).inflate(2131427503, var1, false), this.a);
         }

         return var4;
      }
   }

   enum ItemType {
      empty,
      holiday;

      private static final HolidaysListFragment.ItemType[] $VALUES = new HolidaysListFragment.ItemType[]{
         HolidaysListFragment.ItemType.empty, HolidaysListFragment.ItemType.holiday
      };
   }

   public static class SpacesItemDecoration extends RecyclerView.ItemDecoration {
      private int a;

      public SpacesItemDecoration(int var1) {
         this.a = var1;
      }

      public SpacesItemDecoration(Context var1, int var2) {
         this(var1.getResources().getDimensionPixelSize(var2));
      }

      @Override
      public void a(Rect var1, View var2, RecyclerView var3, RecyclerView.State var4) {
         super.a(var1, var2, var3, var4);
         if (var3.getChildAdapterPosition(var2) == 0) {
            var1.set(0, this.a, 0, 0);
         } else {
            int var5 = var3.getChildAdapterPosition(var2);
            Holiday var6 = ((HolidaysListFragment.HolidaysAdapter)var3.getAdapter()).a(var5);
            Holiday var7 = ((HolidaysListFragment.HolidaysAdapter)var3.getAdapter()).a(var5 - 1);
            if (var6.getSubcategory() != null && var7.getSubcategory() != null && !var6.getSubcategory().equals(var7.getSubcategory())) {
               var5 = this.a;
            } else {
               var5 = 0;
            }

            if (var3.getChildAdapterPosition(var2) == var3.getAdapter().getItemCount() - 1) {
               var1.set(0, var5, 0, this.a);
            } else {
               var1.set(0, var5, 0, 0);
            }
         }
      }
   }
}
