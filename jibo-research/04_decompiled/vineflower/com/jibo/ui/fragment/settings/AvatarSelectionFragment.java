package com.jibo.ui.fragment.settings;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import butterknife.BindView;
import com.amazonaws.handlers.AsyncHandler;
import com.jibo.aws.integration.aws.services.robotProperties.model.GetRobotRequest;
import com.jibo.aws.integration.aws.services.robotProperties.model.Robot;
import com.jibo.aws.integration.helpers.RobotHelper;
import com.jibo.ui.fragment.avatar.AvatarsAdapter;
import com.jibo.ui.fragment.avatar.AvatarsLocationBaseFragment;
import com.jibo.utils.ImageUtils;

public class AvatarSelectionFragment extends AvatarsLocationBaseFragment {
   public static final String c = AvatarSelectionFragment.class.getSimpleName();
   @BindView
   ImageView jiboAvatar;
   private boolean p = false;

   private void b() {
      this.a(true);
      this.a.getRobot(this.k.getRobotFriendlyId(), new AsyncHandler<GetRobotRequest, Robot>(this) {
         final AvatarSelectionFragment a;

         {
            this.a = var1;
         }

         public void a(GetRobotRequest var1, Robot var2) {
            this.a.b = var2;
            this.a.a(new Runnable(this) {
               final <unrepresentable> a;

               {
                  this.a = var1;
               }

               @Override
               public void run() {
                  this.a.a.g();
                  this.a.a.jiboAvatar.setImageLevel(RobotHelper.getAvatar(this.a.a.b));
                  ((AvatarsAdapter)this.a.a.list.getAdapter()).a(RobotHelper.getAvatar(this.a.a.b));
                  this.a.a.list.getAdapter().notifyDataSetChanged();
               }
            });
         }

         @Override
         public void onError(Exception var1) {
            this.a.a(var1, "get robot", false);
         }
      });
   }

   @Override
   protected void a(ActionBar var1) {
      super.a(var1);
      boolean var2;
      if (!this.p) {
         var2 = true;
      } else {
         var2 = false;
      }

      var1.setDisplayHomeAsUpEnabled(var2);
   }

   @Override
   public void b(int var1) {
      this.jiboAvatar.setImageLevel(var1);
   }

   @Override
   protected String o() {
      return this.getString(2131756026);
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

      boolean var2;
      if (this.getActivity().getSupportFragmentManager().e() <= 0) {
         var2 = true;
      } else {
         var2 = false;
      }

      this.p = var2;
   }

   @Override
   public void onCreateOptionsMenu(Menu var1, MenuInflater var2) {
      super.onCreateOptionsMenu(var1, var2);
      if (this.p) {
         var2.inflate(2131492867, var1);
         ImageUtils.a(this.getActivity(), var1);
      }
   }

   @Override
   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      return var1.inflate(2131427425, var2, false);
   }

   @Override
   public boolean onOptionsItemSelected(MenuItem var1) {
      boolean var2;
      if (var1.getItemId() == 2131296294) {
         this.getActivity().onBackPressed();
         var2 = true;
      } else {
         var2 = super.onOptionsItemSelected(var1);
      }

      return var2;
   }

   @Override
   public void onResume() {
      super.onResume();
      if (this.k == null) {
         this.getActivity().onBackPressed();
      } else if (this.b == null) {
         this.b();
      }
   }

   @Override
   public void onSaveInstanceState(Bundle var1) {
      super.onSaveInstanceState(var1);
      var1.putParcelable(Robot.class.getSimpleName(), this.b);
   }

   @Override
   public void onViewCreated(View var1, Bundle var2) {
      super.onViewCreated(var1, var2);
      this.jiboAvatar.setImageLevel(RobotHelper.getAvatar(this.b));
   }
}
