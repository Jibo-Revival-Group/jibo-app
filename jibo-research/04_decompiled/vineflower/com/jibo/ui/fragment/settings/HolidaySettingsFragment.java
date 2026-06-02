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
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.CompoundButton;
import butterknife.BindView;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.handlers.AsyncHandler;
import com.google.gson.JsonObject;
import com.jibo.JiboAnalytics;
import com.jibo.aws.integration.aws.services.account.model.Account;
import com.jibo.aws.integration.aws.services.common.model.CommandResponse;
import com.jibo.aws.integration.aws.services.loop.model.Loop;
import com.jibo.aws.integration.aws.services.person.JiboPersonAsyncClient;
import com.jibo.aws.integration.aws.services.person.model.GetLoopPropertiesRequest;
import com.jibo.aws.integration.aws.services.person.model.Holiday;
import com.jibo.aws.integration.aws.services.person.model.HolidaysSwitchRequest;
import com.jibo.aws.integration.aws.services.person.model.ListHolidaysRequest;
import com.jibo.aws.integration.aws.services.person.model.SetLoopPropertyRequest;
import com.jibo.db.EntityData;
import com.jibo.ui.activity.BaseActivity;
import com.jibo.ui.fragment.BaseFragment;
import com.jibo.ui.fragment.dialog.DialogUtils;
import com.jibo.ui.helpers.Items;
import com.jibo.ui.helpers.ViewHolders;
import com.jibo.ui.view.RecyclerViewFastScroller;
import com.jibo.utils.CustomHolidaysUtils;
import com.jibo.utils.LoopHolidaysAlarmReceiver;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class HolidaySettingsFragment extends BaseFragment {
   public static final String a = HolidaySettingsFragment.class.getSimpleName();
   ArrayList<Holiday> b = new ArrayList<>();
   private JiboPersonAsyncClient c;
   private HolidaySettingsFragment.HolidaysAdapter d;
   private Holiday e;
   @BindView
   RecyclerViewFastScroller fastScroller;
   @BindView
   RecyclerView list;

   private int a(List<Holiday> var1, Holiday var2) {
      int var3 = this.a("birthday").size();
      return var1.indexOf(var2) - (var3 - 2);
   }

   private ArrayList<Holiday> a(String var1) {
      ArrayList var3 = new ArrayList();
      if (!TextUtils.isEmpty(var1) && this.b != null && !this.b.isEmpty()) {
         for (Holiday var4 : this.b) {
            if (var1.equals(var4.getCategory())) {
               var3.add(var4);
            }
         }
      }

      return var3;
   }

   private void a() {
      if (this.c != null && this.k != null) {
         this.f();
         this.c.listHolidays(this.k.getId(), new AsyncHandler<ListHolidaysRequest, List<Holiday>>(this) {
            final HolidaySettingsFragment a;

            {
               this.a = var1;
            }

            public void a(ListHolidaysRequest var1, List<Holiday> var2) {
               this.a.a(new Runnable(this, var2) {
                  final List a;
                  final <unrepresentable> b;

                  {
                     this.b = var1;
                     this.a = var2x;
                  }

                  @Override
                  public void run() {
                     this.b.a.a(this.a);
                  }
               });
            }

            @Override
            public void onError(Exception var1) {
               this.a.a(var1, "list holidays", true);
            }
         });
      }
   }

   private void a(Holiday var1) {
      List var2 = this.b(this.b);
      var2.remove(var1);
      if (this.c != null && this.k != null) {
         this.f();
         this.c
            .setLoopProperty(
               this.k.getId(), "customHolidays", CustomHolidaysUtils.a(var2), new AsyncHandler<SetLoopPropertyRequest, CommandResponse>(this, var1) {
                  final Holiday a;
                  final HolidaySettingsFragment b;

                  {
                     this.b = var1;
                     this.a = var2x;
                  }

                  public void a(SetLoopPropertyRequest var1, CommandResponse var2x) {
                     this.b.a(new Runnable(this) {
                        final <unrepresentable> a;

                        {
                           this.a = var1;
                        }

                        @Override
                        public void run() {
                           int var1x = this.a.b.a(this.a.b.b, this.a.a);
                           this.a.b.b.remove(this.a.a);
                           ((HolidaySettingsFragment.HolidaysAdapter)this.a.b.list.getAdapter()).b(var1x);
                           this.a.b.list.getAdapter().notifyItemRemoved(var1x);
                           this.a.b.g();
                        }
                     });
                  }

                  @Override
                  public void onError(Exception var1) {
                     this.b.a(var1, "remove custom holidays", true);
                  }
               }
            );
      }
   }

   private void a(List<Holiday> var1) {
      if (this.c != null && this.k != null) {
         this.f();
         this.c
            .getLoopProperties(
               this.k.getId(), Arrays.asList("customHolidays"), new AsyncHandler<GetLoopPropertiesRequest, HashMap<String, JsonObject>>(this, var1) {
                  final List a;
                  final HolidaySettingsFragment b;

                  {
                     this.b = var1;
                     this.a = var2;
                  }

                  public void a(GetLoopPropertiesRequest var1, HashMap<String, JsonObject> var2) {
                     this.b.a(new Runnable(this, var2) {
                        final HashMap a;
                        final <unrepresentable> b;

                        {
                           this.b = var1;
                           this.a = var2x;
                        }

                        @Override
                        public void run() {
                           List var1x = CustomHolidaysUtils.a(this.a);
                           this.b.b.c(var1x);
                           this.b.b.a(this.b.a, var1x);
                           this.b.b.q();
                           this.b.b.g();
                        }
                     });
                  }

                  @Override
                  public void onError(Exception var1) {
                     this.b.a(var1, "list custom holidays", false);
                     ArrayList var2 = new ArrayList();
                     this.b.a(this.a, var2);
                     this.b.q();
                  }
               }
            );
      }
   }

   private void a(List<Holiday> var1, List<Holiday> var2) {
      HashMap var3 = new HashMap();

      for (Holiday var5 : var1) {
         var3.put(var5.getId(), var5);
      }

      this.b.clear();
      this.b.addAll(var3.values());
      this.b.addAll(var2);
      Collections.sort(this.b, new HolidaySettingsFragment.HolidayComparator());
   }

   private void a(boolean var1, Holiday var2) {
      var2.setEnabled(var1);
      List var3 = this.b(this.b);
      if (this.c != null && this.k != null) {
         this.f();
         this.c
            .setLoopProperty(
               this.k.getId(), "customHolidays", CustomHolidaysUtils.a(var3), new AsyncHandler<SetLoopPropertyRequest, CommandResponse>(this, var2, var1) {
                  final Holiday a;
                  final boolean b;
                  final HolidaySettingsFragment c;

                  {
                     this.c = var1;
                     this.a = var2x;
                     this.b = var3x;
                  }

                  public void a(SetLoopPropertyRequest var1, CommandResponse var2x) {
                     this.c.a(new Runnable(this) {
                        final <unrepresentable> a;

                        {
                           this.a = var1;
                        }

                        @Override
                        public void run() {
                           int var1x = this.a.c.a(this.a.c.b, this.a.a);
                           Items.Item var2x = ((HolidaySettingsFragment.HolidaysAdapter)this.a.c.list.getAdapter()).a(var1x);
                           if (var2x != null) {
                              ((Items.StateSwitchItem)var2x).a(this.a.b);
                           }

                           this.a.c.list.getAdapter().notifyItemChanged(var1x);
                           this.a.c.g();
                        }
                     });
                  }

                  @Override
                  public void onError(Exception var1) {
                     Holiday var3x = this.a;
                     boolean var2x;
                     if (!this.b) {
                        var2x = true;
                     } else {
                        var2x = false;
                     }

                     var3x.setEnabled(var2x);
                     this.c.a(var1, "switch custom holidays", true);
                  }
               }
            );
      }
   }

   private void a(boolean var1, List<Holiday> var2) {
      this.f();
      ArrayList var3 = new ArrayList();
      Iterator var4 = var2.iterator();

      while (var4.hasNext()) {
         var3.add(((Holiday)var4.next()).getId());
      }

      this.c.switchHolidays(var1, var3, this.k.getId(), new AsyncHandler<HolidaysSwitchRequest, CommandResponse>(this, var2, var1) {
         final List a;
         final boolean b;
         final HolidaySettingsFragment c;

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
                     if (this.a.c.b.indexOf(var2x) != -1 && !var2x.getCategory().equals("birthday")) {
                        int var1x = this.a.c.a(this.a.c.b, var2x);
                        Items.Item var3x = ((HolidaySettingsFragment.HolidaysAdapter)this.a.c.list.getAdapter()).a(var1x);
                        if (var3x != null) {
                           ((Items.StateSwitchItem)var3x).a(this.a.b);
                        }

                        this.a.c.list.getAdapter().notifyItemChanged(var1x);
                     }

                     JiboAnalytics.a(this.a.c.getActivity(), var2x.getName(), this.a.b);
                  }

                  ((Items.StateSwitchItem)((HolidaySettingsFragment.HolidaysAdapter)this.a.c.list.getAdapter()).a(0)).a(this.a.c.b());
                  this.a.c.list.getAdapter().notifyItemChanged(0);
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

   private List<Holiday> b(List<Holiday> var1) {
      ArrayList var2 = new ArrayList();

      for (Holiday var4 : var1) {
         if (var4.getCategory().equalsIgnoreCase("custom")) {
            var2.add(var4);
         }
      }

      return var2;
   }

   private boolean b() {
      boolean var2 = false;
      ArrayList var3 = this.a("birthday");
      boolean var1 = var2;
      if (var3 != null) {
         var1 = var2;
         if (!var3.isEmpty()) {
            var1 = ((Holiday)var3.get(0)).getEnabled();
         }
      }

      return var1;
   }

   private void c(List<Holiday> var1) {
      for (int var2 = var1.size(); var2 > 0; var2--) {
         if (((Holiday)var1.get(var2 - 1)).getCategory() == null) {
            var1.remove(var2 - 1);
         }
      }
   }

   private void q() {
      OnClickListener var3 = new OnClickListener(this) {
         final HolidaySettingsFragment a;

         {
            this.a = var1;
         }

         public void onClick(View var1) {
            if (var1 instanceof CompoundButton) {
               this.a.a(((CompoundButton)var1).isChecked(), this.a.a("birthday"));
            } else if (var1.getTag() instanceof Items.SwitchRowItem) {
               HolidaySettingsFragment var3x = this.a;
               boolean var2;
               if (!this.a.b()) {
                  var2 = true;
               } else {
                  var2 = false;
               }

               var3x.a(var2, this.a.a("birthday"));
            }
         }
      };
      OnClickListener var1 = new OnClickListener(this) {
         final HolidaySettingsFragment a;

         {
            this.a = var1;
         }

         public void onClick(View var1) {
            List var3 = this.a.b(this.a.b);
            Bundle var2 = new Bundle();
            var2.putParcelable(Loop.class.getSimpleName(), this.a.k);
            var2.putSerializable("args_custom_holidays", (ArrayList)var3);
            ((BaseActivity)this.a.getActivity()).a(CustomHolidaySettingsFragment.class, var2);
         }
      };
      ArrayList var2 = new ArrayList();
      var2.add(new Items.SwitchRowItem(var3, 2131755769, this.b()));
      var2.add(new Items.SimpleItem(Items.ItemType.add_custom_holiday, var1));

      for (Holiday var4 : this.b) {
         if (!TextUtils.isEmpty(var4.getName())) {
            Items.CheckboxItem var5;
            if (!var4.getCategory().equalsIgnoreCase("custom")) {
               var5 = new Items.CheckboxItem(new OnClickListener(this, var4) {
                  final Holiday a;
                  final HolidaySettingsFragment b;

                  {
                     this.b = var1;
                     this.a = var2x;
                  }

                  public void onClick(View var1) {
                     boolean var3 = true;
                     ArrayList var4 = new ArrayList();
                     var4.add(this.a);
                     HolidaySettingsFragment var5 = this.b;
                     boolean var2;
                     if (!this.a.getEnabled()) {
                        var2 = true;
                     } else {
                        var2 = false;
                     }

                     var5.a(var2, var4);
                     this.b.e = this.a;
                     HolidaySettingsFragment var6 = this.b;
                     if (!this.b.e.getEnabled()) {
                        var2 = var3;
                     } else {
                        var2 = false;
                     }

                     var6.a(var2, this.b.e);
                  }
               }, var4.getName(), var4.getEnabled());
            } else {
               var5 = new Items.CheckboxDateItem(new OnClickListener(this, var4) {
                  final Holiday a;
                  final HolidaySettingsFragment b;

                  {
                     this.b = var1;
                     this.a = var2;
                  }

                  public void onClick(View var1) {
                     this.b.e = this.a;
                     HolidaySettingsFragment var3 = this.b;
                     boolean var2;
                     if (!this.b.e.getEnabled()) {
                        var2 = true;
                     } else {
                        var2 = false;
                     }

                     var3.a(var2, this.b.e);
                  }
               }, new OnLongClickListener(this, var4) {
                  final Holiday a;
                  final HolidaySettingsFragment b;

                  {
                     this.b = var1;
                     this.a = var2;
                  }

                  public boolean onLongClick(View var1) {
                     this.b.e = this.a;
                     String var2x = this.b.getString(2131755048);
                     String var3x = this.b.getString(2131755625);
                     DialogUtils.a(this.b, 124, this.b.e.getName(), new int[]{2131231034, 2131231078}, new String[]{var2x, var3x});
                     return true;
                  }
               }, var4.getName(), var4.getDate(), var4.getEnabled());
            }

            var2.add(var5);
         }
      }

      this.d.a(var2);
   }

   @Override
   public void a(int var1, int var2, Object var3) {
      super.a(var1, var2, var3);
      if (var1 == 124) {
         if (var2 == 0) {
            var3 = this.b(this.b);
            var1 = 0;
            int var4 = -1;

            while (var1 < var3.size() && var4 == -1) {
               Holiday var5 = (Holiday)var3.get(var1);
               var2 = var4;
               if (this.e.getName().equals(var5.getName())) {
                  var2 = var4;
                  if (this.e.getDate().equals(var5.getDate())) {
                     var2 = var1;
                  }
               }

               var1++;
               var4 = var2;
            }

            Bundle var9 = new Bundle();
            var9.putParcelable(Loop.class.getSimpleName(), this.k);
            var9.putSerializable("args_custom_holidays", var3);
            var9.putInt("args_custom_holidays_pos", var4);
            ((BaseActivity)this.getActivity()).a(CustomHolidaySettingsFragment.class, var9);
         } else if (var2 == 1) {
            DialogUtils.c(this, 125, this.getString(2131755254, this.e.getName()), this.getString(2131755625), this.getString(2131755255));
         }
      } else if (var1 == 125) {
         this.a(this.e);
      }
   }

   @Override
   protected void a(ActionBar var1) {
      super.a(var1);
      var1.setDisplayHomeAsUpEnabled(true);
   }

   @Override
   public void b(Bundle var1) {
      super.b(var1);
      if (var1 != null && var1.containsKey("holidays")) {
         this.b = var1.getParcelableArrayList("holidays");
      }
   }

   @Override
   protected String o() {
      return this.getString(2131756037);
   }

   @Override
   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      return var1.inflate(2131427441, var2, false);
   }

   @Override
   public void onResume() {
      super.onResume();
      if (this.k == null) {
         this.c().postDelayed(new Runnable(this) {
            final HolidaySettingsFragment a;

            {
               this.a = var1;
            }

            @Override
            public void run() {
               this.a.getActivity().onBackPressed();
            }
         }, 100L);
      } else {
         this.a();
      }
   }

   @Override
   public void onSaveInstanceState(Bundle var1) {
      super.onSaveInstanceState(var1);
      var1.putParcelableArrayList("holidays", this.b);
   }

   @Override
   public void onViewCreated(View var1, Bundle var2) {
      super.onViewCreated(var1, var2);
      LinearLayoutManager var3 = new LinearLayoutManager(this, this.getActivity(), 1, false) {
         final HolidaySettingsFragment a;

         {
            this.a = var1;
         }

         @Override
         public void c(RecyclerView.Recycler var1, RecyclerView.State var2x) {
            byte var3x = 8;
            super.c(var1, var2x);
            int var4 = this.m();
            if (var4 != 0) {
               if (var4 == -1) {
                  this.a.fastScroller.setVisibility(8);
               }
            } else {
               int var5 = this.n();
               RecyclerViewFastScroller var6 = this.a.fastScroller;
               if (this.a.d.getItemCount() > var5 - var4 + 1) {
                  var3x = 0;
               }

               var6.setVisibility(var3x);
            }
         }
      };
      var3.b(1);
      this.list.setHasFixedSize(true);
      this.list.addItemDecoration(new HolidaySettingsFragment.SpacesItemDecoration(this.getActivity(), 2131165260));
      this.list.setItemAnimator(new DefaultItemAnimator());
      this.list.setLayoutManager(var3);
      this.fastScroller.setRecyclerView(this.list);
      this.fastScroller.a(2131427646, 2131296560, 2131296561);
      this.d = new HolidaySettingsFragment.HolidaysAdapter();
      this.list.setAdapter(this.d);
      Account var4 = EntityData.a(this.getActivity()).i();
      JiboPersonAsyncClient var5 = new JiboPersonAsyncClient(new BasicAWSCredentials(var4.getAccessKeyId(), var4.getSecretAccessKey()));
      this.c = var5;
      this.a(var5);
      LoopHolidaysAlarmReceiver.b(this.getActivity(), this.k);
   }

   public static class HolidayComparator implements Comparator<Holiday> {
      public int a(Holiday var1, Holiday var2) {
         String var3;
         if (var1.getName() != null) {
            var3 = var1.getName();
         } else {
            var3 = "";
         }

         String var4;
         if (var2.getName() != null) {
            var4 = var2.getName();
         } else {
            var4 = "";
         }

         return var3.compareTo(var4);
      }
   }

   public static class HolidaysAdapter extends RecyclerView.Adapter<ViewHolders.AbstractViewHolder> implements RecyclerViewFastScroller.BubbleTextGetter {
      private List<Items.Item> a = new ArrayList<>();

      public Items.Item a(int var1) {
         Items.Item var2;
         if (var1 >= 0 && var1 < this.a.size()) {
            var2 = this.a.get(var1);
         } else {
            var2 = null;
         }

         return var2;
      }

      public ViewHolders.AbstractViewHolder a(ViewGroup var1, int var2) {
         Items.ItemType var3 = Items.ItemType.values()[var2];
         View var4 = LayoutInflater.from(var1.getContext()).inflate(var3.getLayoutId(), var1, false);
         ViewHolders.SimpleViewHolder var5;
         switch (<unrepresentable>.a[var3.ordinal()]) {
            case 1:
            case 2:
               var5 = new ViewHolders.SwitchStateViewHolder(var4);
               break;
            case 3:
               var5 = new ViewHolders.SwitchStateWithDateViewHolder(var4);
               break;
            default:
               var5 = new ViewHolders.SimpleViewHolder(var4);
         }

         return var5;
      }

      public void a(ViewHolders.AbstractViewHolder var1, int var2) {
         var1.setData(this.a.get(var2));
      }

      public void a(List<Items.Item> var1) {
         this.a.clear();
         this.a.addAll(var1);
         this.notifyDataSetChanged();
      }

      public void b(int var1) {
         if (var1 >= 0 && var1 < this.a.size()) {
            this.a.remove(var1);
         }
      }

      @Override
      public String c(int var1) {
         Items.Item var2;
         if (var1 > 0 && var1 < this.a.size()) {
            var2 = this.a.get(var1);
         } else {
            var2 = null;
         }

         String var3;
         if (var2 != null && var2 instanceof Items.CheckboxItem) {
            var3 = ((Items.CheckboxItem)var2).e().toString().substring(0, 1);
         } else {
            var3 = "";
         }

         return var3;
      }

      @Override
      public int getItemCount() {
         int var1;
         if (this.a == null) {
            var1 = 0;
         } else {
            var1 = this.a.size();
         }

         return var1;
      }

      @Override
      public int getItemViewType(int var1) {
         return this.a.get(var1).getItemType().ordinal();
      }
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
         if (var3.getChildAdapterPosition(var2) != 0 && var3.getChildAdapterPosition(var2) != 1 && var3.getChildAdapterPosition(var2) != 2) {
            if (var3.getChildAdapterPosition(var2) == var3.getAdapter().getItemCount() - 1) {
               var1.set(0, 0, 0, this.a);
            }
         } else {
            var1.set(0, this.a, 0, 0);
         }
      }
   }
}
