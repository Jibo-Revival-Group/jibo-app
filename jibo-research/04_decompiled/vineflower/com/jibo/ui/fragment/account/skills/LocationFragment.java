package com.jibo.ui.fragment.account.skills;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.TextView;
import butterknife.BindView;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.handlers.AsyncHandler;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.jibo.aws.integration.aws.services.account.model.Account;
import com.jibo.aws.integration.aws.services.loop.model.Loop;
import com.jibo.aws.integration.aws.services.skills.JiboSkillsAsyncClient;
import com.jibo.aws.integration.aws.services.skills.model.UpdateSettingsRequest;
import com.jibo.db.EntityData;
import com.jibo.ui.activity.SingleFragmentActivity;
import com.jibo.ui.helpers.skills.DataItems;
import com.jibo.ui.helpers.skills.SkillsJsonParser;
import com.jibo.utils.SharedPreferencesUtil;
import com.jibo.utils.Util;

public class LocationFragment extends com.jibo.ui.fragment.settings.LocationFragment {
   public static final String a = LocationFragment.class.getSimpleName();
   private DataItems.LocationDataItem b;
   private DataItems.LocationDataValue c;
   private JiboSkillsAsyncClient p;
   @BindView
   protected TextView txtLocation;
   @BindView
   protected TextView txtTimezone;

   @Override
   protected void a() {
      StringBuilder var2 = new StringBuilder();
      String var1;
      if (this.c != null && !TextUtils.isEmpty(this.c.getFriendlyLocation())) {
         var1 = this.c.getFriendlyLocation();
      } else {
         var1 = this.getString(2131755640);
      }

      var2.append(var1);
      this.txtLocation.setText(var2.toString());
      if (this.c != null && this.c.getFriendlyTimezone() != null) {
         var1 = this.c.getFriendlyTimezone().replace("\\/", "/");
      } else {
         var1 = "";
      }

      TextView var3 = this.txtTimezone;
      String var5 = var1;
      if (TextUtils.isEmpty(var1)) {
         var5 = this.getString(2131755802);
      }

      var3.setText(var5);
   }

   @Override
   protected void a(ActionBar var1) {
      super.a(var1);
      var1.setDisplayHomeAsUpEnabled(true);
   }

   @Override
   public void b(Bundle var1) {
      super.b(var1);
      if (SkillsJsonParser.isCreated()) {
         this.b = new Gson().a(var1.getString(DataItems.LocationDataItem.class.getSimpleName()), DataItems.LocationDataItem.class);
         SkillsJsonParser.getInstance().setItemDataValue(this.b);
         this.c = (DataItems.LocationDataValue)this.b.getDataValue();
      }
   }

   @Override
   protected String o() {
      return this.getString(2131756040);
   }

   @Override
   public void onSaveInstanceState(Bundle var1) {
      super.onSaveInstanceState(var1);
      var1.putString(DataItems.LocationDataItem.class.getSimpleName(), new Gson().b(this.b));
      var1.putBoolean("ARGS_SKILL_FRAGMENT", true);
   }

   @Override
   public void onViewCreated(View var1, Bundle var2) {
      super.onViewCreated(var1, var2);
      Account var3 = EntityData.a(this.getActivity()).i();
      if (var3 != null) {
         JiboSkillsAsyncClient var4 = new JiboSkillsAsyncClient(new BasicAWSCredentials(var3.getAccessKeyId(), var3.getSecretAccessKey()));
         this.p = var4;
         this.a(var4);
      }

      this.n = new com.jibo.ui.fragment.settings.LocationFragment.AsyncGeocoderTaskProcessor(this) {
         final LocationFragment a;

         {
            this.a = var1;
         }

         // $VF: Duplicated exception handlers to handle obfuscated exceptions
         @Override
         public void a(Bundle var1) {
            try {
               if (!this.a.d()) {
                  return;
               }
            } catch (Exception var11) {
               return;
            }

            SpannableStringBuilder var2x;
            try {
               String var3x = this.a.getString(2131755307);
               var2x = new SpannableStringBuilder(var3x);
               StyleSpan var4 = new StyleSpan(1);
               var2x.setSpan(var4, var3x.lastIndexOf(" "), var3x.length(), 33);
            } catch (Exception var10) {
               return;
            }

            label30: {
               if (var1 != null) {
                  try {
                     if (!var1.isEmpty()) {
                        break label30;
                     }
                  } catch (Exception var9) {
                     return;
                  }
               }

               try {
                  this.a.o.b(var2x);
               } catch (Exception var8) {
                  return;
               }
            }

            try {
               DataItems.LocationDataValue var14 = new DataItems.LocationDataValue(
                  var1.getDouble("lat"),
                  var1.getDouble("lng"),
                  var1.getString("city"),
                  var1.getString("state"),
                  var1.getString("country"),
                  var1.getString("timezone"),
                  Util.e(var1.getString("addressLine")),
                  Util.d(var1.getString("addressLine"))
               );
               Gson var12 = new Gson();
               JsonElement var5 = var12.a(var14);
               String var6 = this.a.b.getValueDefinition().getKey();
               UpdateSettingsRequest.UpdateSettingData.UpdateSettingValue var15 = new UpdateSettingsRequest.UpdateSettingData.UpdateSettingValue(
                  SkillsJsonParser.getInstance().getCurrentSkill().getSkillId(), this.a.b.getValueDefinition().getTarget(), var5
               );
               UpdateSettingsRequest.UpdateSettingData var13 = new UpdateSettingsRequest.UpdateSettingData(var6, var15);
               Loop var17 = SharedPreferencesUtil.f(this.a.getActivity());
               JiboSkillsAsyncClient var16 = this.a.p;
               String var18 = var17.getId();
               AsyncHandler var19 = new AsyncHandler<UpdateSettingsRequest, UpdateSettingsRequest.UpdateSettingData>(this, var2x, var14) {
                  final SpannableStringBuilder a;
                  final DataItems.LocationDataValue b;
                  final <unrepresentable> c;

                  {
                     this.c = var1;
                     this.a = var2x;
                     this.b = var3x;
                  }

                  public void a(UpdateSettingsRequest var1, UpdateSettingsRequest.UpdateSettingData var2x) {
                     SkillsJsonParser.getInstance().updateData(this.c.a.b.getValueDefinition().getKey(), this.b);
                     SkillsJsonParser.getInstance().setItemDataValue(this.c.a.b);
                     this.c.a.c = this.b;
                     this.c.a.a(new Runnable(this) {
                        final <unrepresentable> a;

                        {
                           this.a = var1;
                        }

                        @Override
                        public void run() {
                           this.a.c.a.a();
                           String var1x = this.a.c.a.getString(2131755532);
                           this.a.c.a.o.a(var1x);
                        }
                     });
                  }

                  @Override
                  public void onError(Exception var1) {
                     this.c.a.a(var1, "skills update skill", false);
                     this.c.a.o.b(this.a);
                  }
               };
               var16.updateSkill(var18, var13, var19);
            } catch (Exception var7) {
            }
         }
      };
   }

   @Override
   public void setManuallyClick(View var1) {
      this.a(new com.jibo.ui.fragment.settings.LocationFragment.ManualLocationFragmentListener(this) {
         final LocationFragment a;

         {
            this.a = var1;
         }

         @Override
         public void a(SingleFragmentActivity.Builder var1) {
            var1.a("ARGS_SKILL_FRAGMENT", true);
         }
      });
   }
}
