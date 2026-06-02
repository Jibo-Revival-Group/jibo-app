package com.jibo.ui.fragment.jibos.adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Rect;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.amazonaws.handlers.AsyncHandler;
import com.jibo.aws.integration.aws.services.account.model.Account;
import com.jibo.aws.integration.aws.services.loop.model.Loop;
import com.jibo.aws.integration.aws.services.loop.model.Member;
import com.jibo.aws.integration.aws.services.loop.model.RemoveRequest;
import com.jibo.aws.integration.aws.services.robotProperties.model.Robot;
import com.jibo.aws.integration.helpers.LoopHelper;
import com.jibo.aws.integration.helpers.RobotHelper;
import com.jibo.db.EntityData;
import com.jibo.utils.ImageUtils;
import com.jibo.utils.SharedPreferencesUtil;
import com.jibo.utils.Util;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class JibosListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
   private Account a;
   private List<Loop> b = new ArrayList<>();
   private List<Loop> c = new ArrayList<>();
   private List<Loop> d = new ArrayList<>();
   private OnClickListener e;
   private SparseIntArray f = new SparseIntArray();

   public JibosListAdapter(OnClickListener var1) {
      this.e = var1;
   }

   public int a() {
      return this.b.size();
   }

   public Loop a(int var1) {
      int var3 = this.b.size();
      int var2 = this.c.size();
      Loop var4;
      if (var1 < var2) {
         var4 = this.c.get(var1);
      } else if (var1 < var2 + var3) {
         var4 = this.b.get(var1 - var2);
      } else {
         var4 = this.d.get(var1 - var2 - var3);
      }

      return var4;
   }

   public void a(Account var1, List<Loop> var2) {
      this.a = var1;
      this.b.clear();
      this.c.clear();
      this.d.clear();
      if (var2 != null && var1 != null) {
         for (Loop var4 : var2) {
            if (var1.getId().equals(var4.getOwner())) {
               this.b.add(var4);
            } else if (!var4.isSuspended()) {
               if (LoopHelper.isMemberInvited(var4, var1.getId())) {
                  this.c.add(var4);
               } else {
                  this.d.add(var4);
               }
            }
         }
      }
   }

   public void a(String var1, Robot var2) {
      int var6 = this.b.size();
      int var5 = this.c.size();
      Iterator var8 = this.c.iterator();

      int var3;
      while (true) {
         if (var8.hasNext()) {
            Loop var7 = (Loop)var8.next();
            if (var7.getRobotFriendlyId() == null || !var7.getRobotFriendlyId().equals(var1)) {
               continue;
            }

            var3 = this.c.indexOf(var7);
            break;
         }

         var3 = -1;
         break;
      }

      int var4 = var3;
      if (var3 == -1) {
         var8 = this.b.iterator();

         while (true) {
            var4 = var3;
            if (!var8.hasNext()) {
               break;
            }

            Loop var9 = (Loop)var8.next();
            if (var9.getRobotFriendlyId() != null && var9.getRobotFriendlyId().equals(var1)) {
               var4 = var5 + this.b.indexOf(var9);
               break;
            }
         }
      }

      if (var4 == -1) {
         for (Loop var10 : this.d) {
            if (var10.getRobotFriendlyId() != null && var10.getRobotFriendlyId().equals(var1)) {
               var4 = this.d.indexOf(var10) + var5 + var6;
               break;
            }
         }
      }

      if (var4 != -1) {
         this.f.put(var4, RobotHelper.getAvatar(var2));
         this.notifyItemChanged(var4, var2);
      }
   }

   public int b() {
      return this.d.size();
   }

   public List<Loop> c() {
      return this.c;
   }

   @Override
   public int getItemCount() {
      return this.d.size() + this.b.size() + this.c.size() + 1;
   }

   @Override
   public int getItemViewType(int var1) {
      int var2 = this.b.size();
      int var3 = this.c.size();
      if (var1 < var3) {
         var1 = JibosListAdapter.JiboItemTypes.invitedLoop.ordinal();
      } else if (var1 < var3 + var2) {
         var1 = JibosListAdapter.JiboItemTypes.myLoop.ordinal();
      } else if (var1 >= var2 + var3 && var1 < this.getItemCount() - 1) {
         var1 = JibosListAdapter.JiboItemTypes.joinedLoop.ordinal();
      } else {
         var1 = JibosListAdapter.JiboItemTypes.newjibo.ordinal();
      }

      return var1;
   }

   @Override
   public void onBindViewHolder(RecyclerView.ViewHolder var1, int var2) {
      JibosListAdapter.JiboItemTypes var3 = JibosListAdapter.JiboItemTypes.values()[this.getItemViewType(var2)];
      switch (<unrepresentable>.a[var3.ordinal()]) {
         case 1:
         case 2:
         case 3:
            ((JibosListAdapter.JiboViewHolder)var1).a(this.a(var2), this.a, this.e);
            ((JibosListAdapter.JiboViewHolder)var1).a(this.f.get(var2, 0));
      }
   }

   @Override
   public void onBindViewHolder(RecyclerView.ViewHolder var1, int var2, List<Object> var3) {
      JibosListAdapter.JiboItemTypes var4 = JibosListAdapter.JiboItemTypes.values()[this.getItemViewType(var2)];
      switch (<unrepresentable>.a[var4.ordinal()]) {
         case 1:
         case 2:
         case 3:
            if (var3 == null || var3.isEmpty()) {
               this.onBindViewHolder(var1, var2);
            } else if (var3.get(0) instanceof Robot) {
               ((JibosListAdapter.JiboViewHolder)var1).a(this.f.get(var2, 0));
            }
      }
   }

   @Override
   public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup var1, int var2) {
      Object var3 = null;
      JibosListAdapter.JiboItemTypes var4 = JibosListAdapter.JiboItemTypes.values()[var2];
      RecyclerView.ViewHolder var5;
      switch (<unrepresentable>.a[var4.ordinal()]) {
         case 1:
         case 2:
            var5 = new JibosListAdapter.JiboViewHolder(LayoutInflater.from(var1.getContext()).inflate(2131427509, var1, false));
            break;
         case 3:
            var5 = new JibosListAdapter.JiboViewHolder(LayoutInflater.from(var1.getContext()).inflate(2131427512, var1, false));
            break;
         case 4:
            var5 = new JibosListAdapter.SetupJiboViewHolder(LayoutInflater.from(var1.getContext()).inflate(2131427513, var1, false), this.e);
            break;
         default:
            var5 = (RecyclerView.ViewHolder)var3;
      }

      return var5;
   }

   private enum JiboItemTypes {
      invitedLoop,
      joinedLoop,
      myLoop,
      newjibo;

      private static final JibosListAdapter.JiboItemTypes[] $VALUES = new JibosListAdapter.JiboItemTypes[]{
         JibosListAdapter.JiboItemTypes.myLoop,
         JibosListAdapter.JiboItemTypes.invitedLoop,
         JibosListAdapter.JiboItemTypes.joinedLoop,
         JibosListAdapter.JiboItemTypes.newjibo
      };
   }

   public static class JiboViewHolder extends RecyclerView.ViewHolder {
      @BindView
      ImageView avatar;
      @BindView
      ImageView checkbox;
      @BindView
      TextView loopSuspended;
      @BindView
      TextView ownerText;
      @BindView
      TextView titleText;

      public JiboViewHolder(View var1) {
         super(var1);
         ButterKnife.a(this, var1);
         if (this.checkbox != null) {
            this.checkbox.setImageDrawable(ImageUtils.a(var1.getContext(), 2131231002, 2131099771));
         }
      }

      public void a(int var1) {
         this.avatar.setImageLevel(var1);
      }

      public void a(Loop var1, Account var2, OnClickListener var3) {
         byte var5 = 8;
         Util.b(this.titleText, var1.getName());
         this.itemView.setTag(var1);
         if (this.checkbox != null) {
            if (var1.equals(SharedPreferencesUtil.f(this.itemView.getContext()))) {
               this.checkbox.setVisibility(0);
            } else {
               this.checkbox.setVisibility(8);
            }
         }

         if (this.loopSuspended != null) {
            TextView var6 = this.loopSuspended;
            byte var4;
            if (var1.isSuspended()) {
               var4 = 0;
            } else {
               var4 = 8;
            }

            var6.setVisibility(var4);
            var6 = this.ownerText;
            if (var1.isSuspended()) {
               var4 = var5;
            } else {
               var4 = 0;
            }

            var6.setVisibility(var4);
         }

         if (LoopHelper.isOwner(var1, var2.getId())) {
            this.ownerText
               .setText(
                  this.itemView.getContext().getResources().getString(2131755384) + ": " + this.itemView.getContext().getResources().getString(2131755386)
               );
         } else {
            Member var11 = LoopHelper.getOwner(var1);
            TextView var7 = this.ownerText;
            String var13;
            if (var11 != null) {
               StringBuilder var8 = new StringBuilder().append(this.itemView.getContext().getResources().getString(2131755384)).append(": ");
               String var12;
               if (TextUtils.isEmpty(var11.getNickname())) {
                  var12 = var11.getAccount().getFullName();
               } else {
                  var12 = var11.getNickname();
               }

               var13 = var8.append(var12).toString();
            } else {
               var13 = "";
            }

            var7.setText(var13);
         }

         this.itemView.setOnClickListener(var3);
         this.itemView
            .setOnLongClickListener(
               new OnLongClickListener(this, var2, var1) {
                  final Account a;
                  final Loop b;
                  final JibosListAdapter.JiboViewHolder c;

                  {
                     this.c = var1;
                     this.a = var2x;
                     this.b = var3x;
                  }

                  public boolean onLongClick(View var1) {
                     if (this.a.getId().equals(this.b.getOwner()) && this.b.isSuspended()) {
                        new AlertDialog.Builder(this.c.itemView.getContext())
                           .a("Warning")
                           .b("Do you want to delete this loop?")
                           .a(false)
                           .b("Cancel", null)
                           .a("Ok", new android.content.DialogInterface.OnClickListener(this) {
                              final <unrepresentable> a;

                              {
                                 this.a = var1;
                              }

                              public void onClick(DialogInterface var1, int var2x) {
                                 if (var2x == -1) {
                                    EntityData.a(this.a.c.itemView.getContext()).b().removeLoop(this.a.b.getId(), new AsyncHandler<RemoveRequest, Loop>(this) {
                                       final <unrepresentable> a;

                                       {
                                          this.a = var1;
                                       }

                                       public void a(RemoveRequest var1, Loop var2x) {
                                          EntityData.a(this.a.a.c.itemView.getContext()).b(var2x.getId());
                                       }

                                       @Override
                                       public void onError(Exception var1) {
                                       }
                                    });
                                 }
                              }
                           })
                           .c();
                     }

                     return true;
                  }
               }
            );
      }
   }

   public static class SetupJiboViewHolder extends RecyclerView.ViewHolder {
      public SetupJiboViewHolder(View var1, OnClickListener var2) {
         super(var1);
         this.itemView.setOnClickListener(var2);
      }
   }

   public static class SpacesItemDecoration extends RecyclerView.ItemDecoration {
      private int a;

      public SpacesItemDecoration(Context var1, int var2) {
         if (var2 != -1) {
            var2 = var1.getResources().getDimensionPixelOffset(var2);
         } else {
            var2 = 0;
         }

         this.a = var2;
      }

      @Override
      public void a(Rect var1, View var2, RecyclerView var3, RecyclerView.State var4) {
         if (var3.getChildAdapterPosition(var2) < var3.getAdapter().getItemCount() - 1) {
            var1.bottom = this.a;
         }
      }
   }
}
