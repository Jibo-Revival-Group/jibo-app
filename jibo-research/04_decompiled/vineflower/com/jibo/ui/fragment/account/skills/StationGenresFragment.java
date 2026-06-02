package com.jibo.ui.fragment.account.skills;

import android.content.Context;
import android.graphics.Rect;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.handlers.AsyncHandler;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.jibo.api.iheart.IHeartApiServiceGenerator;
import com.jibo.api.iheart.IHeartFileHelper;
import com.jibo.api.iheart.model.Genre;
import com.jibo.api.iheart.model.LocationConfig;
import com.jibo.aws.integration.aws.services.account.model.Account;
import com.jibo.aws.integration.aws.services.loop.model.Loop;
import com.jibo.aws.integration.aws.services.person.JiboPersonAsyncClient;
import com.jibo.aws.integration.aws.services.person.model.GetLoopPropertiesRequest;
import com.jibo.aws.integration.aws.services.robotProperties.JiboRobotPropertiesAsyncClient;
import com.jibo.aws.integration.aws.services.robotProperties.model.GetRobotRequest;
import com.jibo.aws.integration.aws.services.robotProperties.model.Robot;
import com.jibo.aws.integration.helpers.LoopHelper;
import com.jibo.aws.integration.helpers.RobotHelper;
import com.jibo.db.EntityData;
import com.jibo.ui.activity.BaseActivity;
import com.jibo.ui.fragment.BaseFragment;
import com.jibo.ui.helpers.AbstractItemRecycleViewAdapter;
import com.jibo.ui.helpers.Items;
import com.jibo.ui.helpers.ViewHolders;
import com.jibo.ui.view.proxima.ProximaHelper;
import com.jibo.utils.ErrorHelper;
import com.jibo.utils.SharedPreferencesUtil;
import com.jibo.utils.Util;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class StationGenresFragment extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener {
   public static final String a = StationGenresFragment.class.getSimpleName();
   private JiboRobotPropertiesAsyncClient b;
   private JiboPersonAsyncClient c;
   private List<Items.Item> d = new ArrayList<>();
   private AbstractItemRecycleViewAdapter.SimpleImplItemRecycleViewAdapter e;
   @BindView
   View emptyView;
   @BindView
   ImageView emptyViewIcon;
   @BindView
   TextView emptyViewTextInfo;
   @BindView
   TextView emptyViewTitle;
   private Robot l;
   @BindView
   RecyclerView list;
   private LocationConfig m;
   private List<Genre> n;
   private List<Genre> o;
   private JsonObject p;
   @BindView
   SwipeRefreshLayout swipeRefreshLayout;

   private SpannableStringBuilder a(Loop var1) {
      String var3 = this.getString(2131755845);
      SpannableStringBuilder var2 = new SpannableStringBuilder(var3);
      var2.setSpan(new Util.CustomTypefaceSpan("", ProximaHelper.c), 0, var3.length(), 33);
      var2.setSpan(new ForegroundColorSpan(this.getResources().getColor(2131099771)), 0, var3.length(), 33);
      var2.setSpan(new ClickableSpan(this, var1) {
         final Loop a;
         final StationGenresFragment b;

         {
            this.b = var1;
            this.a = var2x;
         }

         public void onClick(View var1) {
            Bundle var2x = new Bundle();
            var2x.putParcelable(Loop.class.getSimpleName(), this.a);
            var2x.putString("ARGS_LOCATION", RobotHelper.getLocation(this.b.l));
            var2x.putString("timezone", RobotHelper.getTimeZone(this.b.l));
            ((BaseActivity)this.b.getActivity()).c(com.jibo.ui.fragment.settings.LocationFragment.class, var2x);
         }

         public void updateDrawState(TextPaint var1) {
            var1.setUnderlineText(false);
         }
      }, 0, var3.length(), 33);
      return var2;
   }

   private void b() throws Exception {
      if (IHeartApiServiceGenerator.a(this.m.a(), null) == null) {
         throw new Exception("Empty iHeart apiUrl supplied");
      }

      this.n = IHeartFileHelper.a(this.getContext(), RobotHelper.getCountryCode(this.l));
   }

   private void q() {
      this.f();
      this.p = null;
      this.o = null;
      this.n = null;

      try {
         ArrayList var4 = new ArrayList();
         var4.add("com.jibo.music.stations");
         JiboPersonAsyncClient var1 = this.c;
         String var3 = this.k.getId();
         AsyncHandler var2 = new AsyncHandler<GetLoopPropertiesRequest, HashMap<String, JsonObject>>(this) {
            final StationGenresFragment a;

            {
               this.a = var1;
            }

            // $VF: Duplicated exception handlers to handle obfuscated exceptions
            public void a(GetLoopPropertiesRequest var1, HashMap<String, JsonObject> var2x) {
               label47:
               if (var2x != null) {
                  JsonArray var4x;
                  try {
                     if (var2x.isEmpty() || !var2x.containsKey("com.jibo.music.stations") || !((JsonObject)var2x.get("com.jibo.music.stations")).b("loops")) {
                        break label47;
                     }

                     this.a.p = (JsonObject)var2x.get("com.jibo.music.stations");
                     var4x = ((JsonObject)var2x.get("com.jibo.music.stations")).d("loops");
                  } catch (Exception var8) {
                     this.a.a(var8, "error parsing default for genres", false);
                     break label47;
                  }

                  int var3x = 0;

                  while (true) {
                     try {
                        if (var3x >= var4x.a()) {
                           break;
                        }

                        if (var4x.a(var3x).l().c("id").c().equals(this.a.k.getId())) {
                           StationGenresFragment var10 = this.a;
                           Gson var9 = new Gson();
                           JsonArray var5 = var4x.a(var3x).l().d("genres");
                           TypeToken var11 = new TypeToken<List<Genre>>(this) {
                              final <unrepresentable> a;

                              {
                                 this.a = var1;
                              }
                           };
                           var10.o = var9.a(var5, var11.getType());
                           break;
                        }
                     } catch (Exception var7) {
                        this.a.a(var7, "error parsing default for genres", false);
                        break;
                     }

                     var3x++;
                  }
               }

               try {
                  if (this.a.d()) {
                     this.a.b();
                  }
               } catch (Exception var6) {
                  this.a.a(var6, "error getting iHeart liveStationGenres", false);
               }

               this.a.s();
            }

            @Override
            public void onError(Exception var1) {
               this.a.a(var1, "get account properties", false);
               if (!ErrorHelper.b((AmazonServiceException)var1) && !ErrorHelper.a((AmazonServiceException)var1)) {
                  try {
                     if (this.a.d()) {
                        this.a.b();
                     }
                  } catch (Exception var2x) {
                     this.a.a(var2x, "error getting iHeart liveStationGenres", false);
                  }

                  this.a.s();
               }
            }
         };
         var1.getLoopProperties(var3, var4, var2);
      } catch (Exception var5) {
         this.a(var5, "error get account properties", false);
      }
   }

   private void r() {
      this.l = null;
      this.f();
      this.b
         .getRobot(
            this.k.getRobotFriendlyId(),
            new AsyncHandler<GetRobotRequest, Robot>(this) {
               final StationGenresFragment a;

               {
                  this.a = var1;
               }

               // $VF: Duplicated exception handlers to handle obfuscated exceptions
               public void a(GetRobotRequest var1, Robot var2) {
                  Location var11 = RobotHelper.getLatLon(var2);
                  if (var11 != null && this.a.d()) {
                     label49: {
                        JsonObject var4;
                        try {
                           var4 = var2.getPayload().e("locationOverride");
                           Geocoder var3 = new Geocoder(this.a.getActivity());
                           var12 = var3.getFromLocation(var11.getLatitude(), var11.getLongitude(), 1);
                           if (!this.a.d()) {
                              break label49;
                           }
                        } catch (Exception var10) {
                           this.a.l = null;
                           this.a.m = null;
                           this.a.a(var10, "error during geocoding", false);
                           this.a.s();
                           return;
                        }

                        label45:
                        if (var12 != null) {
                           Address var17;
                           label56: {
                              try {
                                 if (var12.isEmpty()) {
                                    break label45;
                                 }

                                 var17 = (Address)var12.get(0);
                                 var4.a("zipcode", var17.getPostalCode());
                                 var4.a("countryCode", var17.getCountryCode());
                                 if (var17.getMaxAddressLineIndex() >= 2) {
                                    var14 = var17.getAddressLine(1);
                                    break label56;
                                 }
                              } catch (Exception var9) {
                                 this.a.l = null;
                                 this.a.m = null;
                                 this.a.a(var9, "error during geocoding", false);
                                 this.a.s();
                                 return;
                              }

                              try {
                                 StringBuilder var13 = new StringBuilder();
                                 var14 = var13.append(var4.c("city").c())
                                    .append(", ")
                                    .append(var4.c("state").c())
                                    .append(" ")
                                    .append(var17.getPostalCode())
                                    .toString();
                              } catch (Exception var8) {
                                 this.a.l = null;
                                 this.a.m = null;
                                 this.a.a(var8, "error during geocoding", false);
                                 this.a.s();
                                 return;
                              }
                           }

                           try {
                              var4.a("addressLine", var14);
                              this.a.l = var2;
                              StationGenresFragment var16 = this.a;
                              String var18 = var17.getCountryCode().toUpperCase();
                              LocationConfig.Config var5 = new LocationConfig.Config(IHeartApiServiceGenerator.a(var17.getCountryCode().toUpperCase()));
                              LocationConfig var15 = new LocationConfig(var18, var5);
                              var16.m = var15;
                           } catch (Exception var7) {
                              this.a.l = null;
                              this.a.m = null;
                              this.a.a(var7, "error during geocoding", false);
                              this.a.s();
                              return;
                           }
                        }
                     }

                     try {
                        if (this.a.d()) {
                           this.a.q();
                        }
                     } catch (Exception var6) {
                        this.a.l = null;
                        this.a.m = null;
                        this.a.a(var6, "error during geocoding", false);
                        this.a.s();
                     }
                  } else {
                     this.a.s();
                  }
               }

               @Override
               public void onError(Exception var1) {
                  this.a.a(var1, "get robot", false);
                  if (!ErrorHelper.b((AmazonServiceException)var1) && !ErrorHelper.a((AmazonServiceException)var1)) {
                     this.a.s();
                  }
               }
            }
         );
   }

   private void s() {
      this.a(new Runnable(this) {
         final StationGenresFragment a;

         {
            this.a = var1;
         }

         @Override
         public void run() {
            this.a.g();
            this.a.emptyView.setVisibility(8);
            this.a.d.clear();
            this.a.d.add(new Items.SubheaderItem(this.a.getString(2131755779)));
            Loop var2 = SharedPreferencesUtil.f(this.a.getActivity());
            Account var3 = EntityData.a(this.a.getActivity()).i();
            boolean var1;
            if (var3 != null && LoopHelper.isOwner(var2, var3.getId())) {
               var1 = 1;
            } else {
               var1 = 0;
            }

            if (this.a.l != null && !TextUtils.isEmpty(RobotHelper.getCountryCode(this.a.l))) {
               if (this.a.m != null && TextUtils.isEmpty(this.a.m.a())) {
                  if (var1) {
                     this.a.d.add(new Items.TwoRowsSimpleItem(this.a.getString(2131755777), this.a.a(var2)));
                  } else {
                     this.a.d.add(new Items.TwoRowsSimpleItem(this.a.getString(2131755777), this.a.getString(2131755804)));
                  }
               } else if (this.a.n != null && !this.a.n.isEmpty()) {
                  for (Genre var6 : this.a.n) {
                     Items.AvatarTwoRowsSimpleItem var4 = new Items.AvatarTwoRowsSimpleItem(new OnClickListener(this, var6) {
                        final Genre a;
                        final <unrepresentable> b;

                        {
                           this.b = var1;
                           this.a = var2x;
                        }

                        public void onClick(View var1) {
                           Bundle var2x = new Bundle();
                           var2x.putParcelable(Robot.class.getSimpleName(), this.b.a.l);
                           var2x.putString(JsonObject.class.getSimpleName(), new Gson().a(this.b.a.p).toString());
                           var2x.putString(Genre.class.getSimpleName(), new Gson().b(this.a).toString());
                           var2x.putString(LocationConfig.class.getSimpleName(), new Gson().b(this.b.a.m).toString());
                           ((BaseActivity)this.b.a.getActivity()).c(StationsFragment.class, var2x);
                        }
                     }, var6.b(), "");
                     var4.a(2131231280);
                     if (this.a.o != null && !this.a.o.isEmpty() && this.a.o.indexOf(var6) >= 0) {
                        var1 = this.a.o.indexOf(var6);
                        var4.a(this.a.o.get(var1).c().b());
                        var4.a(this.a.o.get(var1).c().c());
                     }

                     this.a.d.add(var4);
                  }
               } else {
                  this.a.emptyView.setVisibility(0);
               }
            } else if (var1) {
               this.a.d.add(new Items.TwoRowsSimpleItem(this.a.getString(2131755798), this.a.a(var2)));
            } else {
               this.a.d.add(new Items.TwoRowsSimpleItem(this.a.getString(2131755798), this.a.getString(2131755804)));
            }

            this.a.e.notifyDataSetChanged();
         }
      });
   }

   @Override
   protected void a(ActionBar var1) {
      super.a(var1);
      var1.setDisplayHomeAsUpEnabled(true);
   }

   @Override
   public void b(Bundle var1) {
      super.b(var1);
      this.l = (Robot)var1.getParcelable(Robot.class.getSimpleName());
      if (var1.containsKey(LocationConfig.class.getSimpleName())) {
         this.m = new Gson().a(var1.getString(LocationConfig.class.getSimpleName()), LocationConfig.class);
      }

      if (var1.containsKey(Genre.class.getSimpleName())) {
         try {
            Gson var2 = new Gson();
            String var3 = var1.getString(Genre.class.getSimpleName());
            TypeToken var5 = new TypeToken<List<Genre>>(this) {
               final StationGenresFragment a;

               {
                  this.a = var1;
               }
            };
            this.n = var2.a(var3, var5.getType());
         } catch (Exception var4) {
         }
      }
   }

   @Override
   public void g() {
      super.g();
      this.swipeRefreshLayout.setRefreshing(false);
   }

   @Override
   public void n_() {
      this.swipeRefreshLayout.setRefreshing(true);
      this.r();
   }

   @Override
   protected String o() {
      return this.getString(2131756054);
   }

   @Override
   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      return var1.inflate(2131427460, var2, false);
   }

   @Override
   public void onPause() {
      super.onPause();
      this.swipeRefreshLayout.setRefreshing(false);
      this.p = null;
      this.o = null;
   }

   @Override
   public void onResume() {
      super.onResume();
      if (this.l == null || this.m == null || this.n == null || this.n.isEmpty() || TextUtils.isEmpty(RobotHelper.getCountryCode(this.l))) {
         this.r();
      } else if (this.p == null) {
         this.q();
      } else {
         this.s();
      }
   }

   @Override
   public void onSaveInstanceState(Bundle var1) {
      super.onSaveInstanceState(var1);
      var1.putParcelable(Robot.class.getSimpleName(), this.l);
      if (this.m != null) {
         var1.putString(LocationConfig.class.getSimpleName(), new Gson().b(this.m).toString());
      }

      if (this.n != null) {
         var1.putString(Genre.class.getSimpleName(), new Gson().b(this.n).toString());
      }
   }

   @Override
   public void onViewCreated(View var1, Bundle var2) {
      super.onViewCreated(var1, var2);
      this.k = SharedPreferencesUtil.f(this.getActivity());
      this.e = new AbstractItemRecycleViewAdapter.SimpleImplItemRecycleViewAdapter(this.d);
      this.list.setHasFixedSize(true);
      this.list.setItemAnimator(new DefaultItemAnimator());
      this.list.setLayoutManager(new LinearLayoutManager(this.getActivity(), 1, false));
      this.list.addItemDecoration(new StationGenresFragment.SpacesItemDecoration(this.getActivity(), 2131165462, 2131165263, 2131165366));
      this.list.setAdapter(this.e);
      this.swipeRefreshLayout.setOnRefreshListener(this);
      this.swipeRefreshLayout.setColorSchemeResources(2131099771, 2131099672, 2131099672, 2131099672);
      this.emptyViewTitle.setText(2131755869);
      this.emptyViewIcon.setImageResource(2131231019);
      this.emptyViewTextInfo.setText(2131755791);
      this.b = EntityData.a(this.getActivity()).g();
      Account var3 = EntityData.a(this.getActivity()).i();
      JiboPersonAsyncClient var4 = new JiboPersonAsyncClient(new BasicAWSCredentials(var3.getAccessKeyId(), var3.getSecretAccessKey()));
      this.c = var4;
      this.a(var4);
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
