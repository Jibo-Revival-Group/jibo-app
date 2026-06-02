package com.jibo.ui.fragment.wifi;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.SparseIntArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import butterknife.BindView;
import com.amazonaws.handlers.AsyncHandler;
import com.jibo.aws.integration.aws.services.key.model.Backup;
import com.jibo.aws.integration.aws.services.key.model.RestoreRequest;
import com.jibo.aws.integration.aws.services.loop.model.Loop;
import com.jibo.aws.integration.aws.services.robotProperties.model.GetRobotRequest;
import com.jibo.aws.integration.aws.services.robotProperties.model.Robot;
import com.jibo.aws.integration.helpers.RobotHelper;
import com.jibo.aws.integration.util.KeyManager;
import com.jibo.db.EntityData;
import com.jibo.ui.activity.BaseActivity;
import com.jibo.ui.activity.WifiActivity;
import com.jibo.ui.fragment.dialog.passphrase.LoopPassphraseRestoreDialog;
import com.jibo.ui.fragment.dialog.passphrase.LoopPassphraseUtils;
import com.jibo.ui.helpers.Items;
import com.jibo.ui.helpers.ViewHolders;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SetupOrReconnectFragment extends WiFiBaseFragment implements LoopPassphraseRestoreDialog.BackupKeyRestoredListener {
   private List<Items.Item> a = new ArrayList<>();
   private ArrayList<Loop> b;
   private SetupOrReconnectFragment.JibosListAdapter c;
   private OnClickListener l = new OnClickListener(this) {
      final SetupOrReconnectFragment a;

      {
         this.a = var1;
      }

      public void onClick(View var1) {
         Loop var3 = ((Items.SuspendedLoopItem)var1.getTag()).a();
         KeyManager var5 = KeyManager.getInstance(this.a.getContext(), EntityData.a(this.a.getActivity()).i().getId());

         try {
            var6 = var5.obtainKeyHolder(this.a.getContext(), var3.getId());
         } catch (Exception var4) {
            var6 = null;
         }

         boolean var2;
         if (var6 != null) {
            var2 = true;
         } else {
            var2 = false;
         }

         if (var2) {
            this.a.b(var3);
         } else {
            this.a.f();
            EntityData.a(this.a.getContext()).d().restoreEncryptedKey(var3.getId(), null, new AsyncHandler<RestoreRequest, Backup>(this, var3) {
               final Loop a;
               final <unrepresentable> b;

               {
                  this.b = var1;
                  this.a = var2x;
               }

               public void a(RestoreRequest var1, Backup var2x) {
                  this.b.a.a(new Runnable(this) {
                     final <unrepresentable> a;

                     {
                        this.a = var1;
                     }

                     @Override
                     public void run() {
                        this.a.b.a.g();
                        LoopPassphraseUtils.a(this.a.b.a, LoopPassphraseUtils.DialogType.ON_RECONNECT_TO_JIBO, this.a.a);
                     }
                  });
               }

               @Override
               public void onError(Exception var1) {
                  this.b.a.a(new Runnable(this, var1) {
                     final Exception a;
                     final <unrepresentable> b;

                     {
                        this.b = var1;
                        this.a = var2x;
                     }

                     @Override
                     public void run() {
                        this.b.b.a.a(this.a, "Error restoring key", true);
                     }
                  });
               }
            });
         }
      }
   };
   @BindView
   RecyclerView list;

   private void a() {
      this.a.clear();
      if (this.b != null && !this.b.isEmpty()) {
         this.a.add(new Items.FooterItem(this.getString(2131755661)));
         this.a.add(new Items.SubheaderItem(2131755651));

         for (Loop var1 : this.b) {
            this.a.add(new Items.SuspendedLoopItem(this.l, var1));
         }

         Iterator var3 = this.b.iterator();

         while (var3.hasNext()) {
            this.c((Loop)var3.next());
         }
      } else {
         this.a.add(new Items.FooterItem(this.getString(2131755615)));
      }

      this.a.add(new Items.SimpleItem(Items.ItemType.setup_jibo, new OnClickListener(this) {
         final SetupOrReconnectFragment a;

         {
            this.a = var1;
         }

         public void onClick(View var1) {
            ((WifiActivity)this.a.getActivity()).q();
         }
      }));
      this.a.add(new Items.SimpleItem(Items.ItemType.text_button, new OnClickListener(this) {
         final SetupOrReconnectFragment a;

         {
            this.a = var1;
         }

         public void onClick(View var1) {
            Intent var2 = new Intent("android.intent.action.VIEW", Uri.parse(this.a.getString(2131755752)));
            this.a.startActivity(var2);
         }
      }, 2131755485));
      this.c.notifyDataSetChanged();
   }

   private void b(Loop var1) {
      Bundle var2 = new Bundle();
      var2.putParcelable(Loop.class.getSimpleName(), this.k);
      ((WifiActivity)this.getActivity()).a(WifiActivity.Mode.RECONNECT_SUSPENDED);
      ((BaseActivity)this.getActivity()).c(NetworkSelectionFragment.class, var2);
   }

   private void c(Loop var1) {
      EntityData.a(this.getActivity()).g().getRobot(var1.getRobotFriendlyId(), new AsyncHandler<GetRobotRequest, Robot>(this, var1) {
         final Loop a;
         final SetupOrReconnectFragment b;

         {
            this.b = var1;
            this.a = var2;
         }

         public void a(GetRobotRequest var1, Robot var2) {
            this.b.a(new Runnable(this, var2) {
               final Robot a;
               final <unrepresentable> b;

               {
                  this.b = var1;
                  this.a = var2x;
               }

               @Override
               public void run() {
                  if (this.a != null) {
                     this.b.b.c.a(this.b.a.getRobotFriendlyId(), this.a);
                  }
               }
            });
         }

         @Override
         public void onError(Exception var1) {
            this.b.a(var1, "get robot", false);
         }
      });
   }

   @Override
   protected void a(ActionBar var1) {
      super.a(var1);
      var1.setDisplayHomeAsUpEnabled(true);
   }

   @Override
   public void a(Loop var1) {
      this.b(var1);
   }

   @Override
   public void b(Bundle var1) {
      super.b(var1);
      this.b = var1.getParcelableArrayList("ARGS_SUSPENDED_LOOP_LIST");
   }

   @Override
   protected String o() {
      return this.getString(2131755657);
   }

   @Override
   public void onCreate(Bundle var1) {
      super.onCreate(var1);
   }

   @Override
   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      return var1.inflate(2131427459, var2, false);
   }

   @Override
   public void onViewCreated(View var1, Bundle var2) {
      super.onViewCreated(var1, var2);
      this.c = new SetupOrReconnectFragment.JibosListAdapter(this.a);
      this.list.setHasFixedSize(true);
      this.list.setItemAnimator(new DefaultItemAnimator());
      this.list.setLayoutManager(new LinearLayoutManager(this.getActivity(), 1, false));
      this.list.addItemDecoration(new SetupOrReconnectFragment.JibosListAdapter.SpacesItemDecoration(this.getActivity(), 2131165263, 2131165366));
      this.list.setAdapter(this.c);
      this.a();
   }

   public static class JibosListAdapter extends RecyclerView.Adapter<ViewHolders.AbstractViewHolder> {
      private final List<Items.Item> a;
      private SparseIntArray b = new SparseIntArray();

      public JibosListAdapter(List<Items.Item> var1) {
         this.a = var1;
      }

      public ViewHolders.AbstractViewHolder a(ViewGroup var1, int var2) {
         Object var3 = null;
         Items.ItemType var4 = Items.ItemType.values()[var2];
         View var5 = LayoutInflater.from(var1.getContext()).inflate(var4.getLayoutId(), var1, false);
         ViewHolders.AbstractViewHolder var6;
         switch (<unrepresentable>.a[var4.ordinal()]) {
            case 1:
               var6 = new ViewHolders.SubheaderViewHolder(var5);
               break;
            case 2:
               var6 = new ViewHolders.SuspendedJiboViewHolder(var5);
               break;
            case 3:
               var6 = new ViewHolders.SimpleViewHolder(var5);
               ((ViewHolders.SimpleViewHolder)var6).text.setTextColor(-16777216);
               break;
            case 4:
               var6 = new ViewHolders.FooterViewHolder(var5);
               break;
            case 5:
               var6 = new ViewHolders.SimpleViewHolder(var5);
               break;
            default:
               var6 = (ViewHolders.AbstractViewHolder)var3;
         }

         return var6;
      }

      public void a(ViewHolders.AbstractViewHolder var1, int var2) {
         var1.setData(this.a.get(var2));
      }

      public void a(ViewHolders.AbstractViewHolder var1, int var2, List<Object> var3) {
         Items.ItemType var4 = Items.ItemType.values()[this.getItemViewType(var2)];
         switch (<unrepresentable>.a[var4.ordinal()]) {
            case 2:
               if (var3 == null || var3.isEmpty()) {
                  this.a(var1, var2);
               } else if (var3.get(0) instanceof Robot) {
                  ((ViewHolders.SuspendedJiboViewHolder)var1).a(this.b.get(var2, 0));
               }
               break;
            default:
               this.a(var1, var2);
         }
      }

      public void a(String var1, Robot var2) {
         Iterator var4 = this.a.iterator();

         int var3;
         while (true) {
            if (var4.hasNext()) {
               Items.Item var5 = (Items.Item)var4.next();
               if (!(var5 instanceof Items.SuspendedLoopItem)
                  || ((Items.SuspendedLoopItem)var5).a().getRobotFriendlyId() == null
                  || !((Items.SuspendedLoopItem)var5).a().getRobotFriendlyId().equals(var1)) {
                  continue;
               }

               var3 = this.a.indexOf(var5);
               break;
            }

            var3 = -1;
            break;
         }

         if (var3 != -1) {
            this.b.put(var3, RobotHelper.getAvatar(var2));
            this.notifyItemChanged(var3, var2);
         }
      }

      @Override
      public int getItemCount() {
         return this.a.size();
      }

      @Override
      public int getItemViewType(int var1) {
         return this.a.get(var1).getItemType().ordinal();
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
            if (var3.findContainingViewHolder(var2) instanceof ViewHolders.SuspendedJiboViewHolder) {
               var1.bottom = this.b;
            }

            if (var3.getAdapter().getItemCount() == 3 && var3.getChildAdapterPosition(var2) == var3.getAdapter().getItemCount() - 2) {
               var1.top = this.a;
            } else if (var3.getChildAdapterPosition(var2) == var3.getAdapter().getItemCount() - 1) {
               var1.bottom = this.a;
            }
         }
      }
   }
}
