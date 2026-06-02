package com.jibo.ui.fragment.avatar;

import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.View.OnClickListener;
import butterknife.BindView;
import com.amazonaws.handlers.AsyncHandler;
import com.jibo.aws.integration.aws.services.common.model.CommandResponse;
import com.jibo.aws.integration.aws.services.robotProperties.JiboRobotPropertiesAsyncClient;
import com.jibo.aws.integration.aws.services.robotProperties.model.CreateRobotRequest;
import com.jibo.aws.integration.aws.services.robotProperties.model.Robot;
import com.jibo.aws.integration.helpers.RobotHelper;
import com.jibo.db.EntityData;
import com.jibo.ui.fragment.dialog.CircleProgressFragment;
import com.jibo.ui.fragment.settings.LocationFragment;
import com.jibo.utils.SharedPreferencesUtil;

public abstract class AvatarsLocationBaseFragment extends LocationFragment {
   protected JiboRobotPropertiesAsyncClient a;
   protected Robot b;
   @BindView
   protected RecyclerView list;

   public abstract void b(int var1);

   @Override
   protected String o() {
      return null;
   }

   @Override
   public void onCreate(Bundle var1) {
      super.onCreate(var1);
      this.setHasOptionsMenu(true);
      if (var1 != null) {
         this.b = (Robot)var1.getParcelable(Robot.class.getSimpleName());
      } else if (this.getArguments() != null) {
         this.b = (Robot)this.getArguments().getParcelable(Robot.class.getSimpleName());
      }

      if (EntityData.a(this.getActivity()).i() != null) {
         this.a = EntityData.a(this.getActivity()).g();
      }

      this.k = SharedPreferencesUtil.f(this.getActivity());
   }

   @Override
   public void onViewCreated(View var1, Bundle var2) {
      super.onViewCreated(var1, var2);
      GridLayoutManager var3 = new GridLayoutManager(this.getActivity(), 4, 1, false);
      this.list.setHasFixedSize(true);
      this.list.setItemAnimator(new DefaultItemAnimator());
      this.list.setLayoutManager(var3);
      this.list.setAdapter(new AvatarsAdapter(2131427510, RobotHelper.getAvatar(this.b), new OnClickListener(this) {
         final AvatarsLocationBaseFragment a;

         {
            this.a = var1;
         }

         public void onClick(View var1) {
            if (this.a.o != null) {
               this.a.o.a();
               this.a.o = null;
            }

            this.a.o = new CircleProgressFragment();
            String var3x = this.a.getString(2131755068);
            this.a.o.c(var3x);
            this.a.o.show(this.a.getActivity().getSupportFragmentManager(), "CircleFragment");
            int var2x = (Integer)var1.getTag();
            if (this.a.b != null) {
               this.a.b.getPayload().a("avatar", var2x);
            }

            this.a.a.updateRobot(this.a.b, new AsyncHandler<CreateRobotRequest, CommandResponse>(this, var2x) {
               final int a;
               final <unrepresentable> b;

               {
                  this.b = var1;
                  this.a = var2x;
               }

               public void a(CreateRobotRequest var1, CommandResponse var2x) {
                  this.b.a.a(new Runnable(this) {
                     final <unrepresentable> a;

                     {
                        this.a = var1;
                     }

                     @Override
                     public void run() {
                        String var1x = this.a.b.a.getString(2131755069);
                        this.a.b.a.o.a(var1x);
                        this.a.b.a.o = null;
                        this.a.b.a.b(this.a.a);
                        ((AvatarsAdapter)this.a.b.a.list.getAdapter()).a(this.a.a);
                        this.a.b.a.list.getAdapter().notifyDataSetChanged();
                     }
                  });
               }

               @Override
               public void onError(Exception var1) {
                  this.b.a.a(var1, "robot update", true);
                  String var2x = this.b.a.getString(2131755067);
                  this.b.a.o.a(var2x);
                  this.b.a.o = null;
               }
            });
         }
      }));
      this.getActivity().setResult(-1);
   }
}
