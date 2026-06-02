package com.jibo.ui.fragment.account.skills;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
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
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.jibo.api.iheart.IHeartApiServiceGenerator;
import com.jibo.api.iheart.model.Genre;
import com.jibo.api.iheart.model.LocationConfig;
import com.jibo.api.iheart.model.Station;
import com.jibo.aws.integration.aws.services.account.model.Account;
import com.jibo.aws.integration.aws.services.common.model.CommandResponse;
import com.jibo.aws.integration.aws.services.loop.model.Loop;
import com.jibo.aws.integration.aws.services.person.JiboPersonAsyncClient;
import com.jibo.aws.integration.aws.services.person.model.SetLoopPropertyRequest;
import com.jibo.aws.integration.aws.services.robotProperties.model.Robot;
import com.jibo.aws.integration.helpers.LoopHelper;
import com.jibo.aws.integration.helpers.RobotHelper;
import com.jibo.db.EntityData;
import com.jibo.ui.fragment.BaseFragment;
import com.jibo.ui.helpers.AbstractItemRecycleViewAdapter;
import com.jibo.ui.helpers.Items;
import com.jibo.ui.helpers.ViewHolders;
import com.jibo.utils.ErrorHelper;
import com.jibo.utils.SharedPreferencesUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StationsFragment extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener {
   public static final String a = StationsFragment.class.getSimpleName();
   private List<Items.Item> b = new ArrayList<>();
   private AbstractItemRecycleViewAdapter.SimpleImplItemRecycleViewAdapter c;
   private Robot d;
   private LocationConfig e;
   @BindView
   View emptyView;
   @BindView
   ImageView emptyViewIcon;
   @BindView
   TextView emptyViewTextInfo;
   @BindView
   TextView emptyViewTitle;
   private List<Station> l;
   @BindView
   RecyclerView list;
   private List<Station> m;
   private Genre n;
   private JsonObject o;
   private OnClickListener p = new OnClickListener(this) {
      final StationsFragment a;

      {
         this.a = var1;
      }

      public void onClick(View var1) {
         StationsFragment.StationItem var3 = (StationsFragment.StationItem)var1.getTag();
         String var4 = this.a.o.toString();
         JsonObject var2 = this.a.q();
         if (var2 != null) {
            this.a.f();
            var2.a("station", new Gson().a(new Station(var3.a().a(), var3.a().b(), var3.a().c(), var3.a().g())));
            this.a
               .q
               .setLoopProperty(this.a.k.getId(), "com.jibo.music.stations", this.a.o, new AsyncHandler<SetLoopPropertyRequest, CommandResponse>(this, var4) {
                  final String a;
                  final <unrepresentable> b;

                  {
                     this.b = var1;
                     this.a = var2x;
                  }

                  public void a(SetLoopPropertyRequest var1, CommandResponse var2x) {
                     this.b.a.s();
                  }

                  @Override
                  public void onError(Exception var1) {
                     this.b.a.a(var1, "set account properties", false);
                     if (!ErrorHelper.b((AmazonServiceException)var1) && !ErrorHelper.a((AmazonServiceException)var1)) {
                        try {
                           StationsFragment var4x = this.b.a;
                           JsonParser var2x = new JsonParser();
                           var4x.o = (JsonObject)var2x.a(this.a);
                        } catch (Exception var3x) {
                           this.b.a.o = null;
                        }

                        this.b.a.s();
                     }
                  }
               });
         }
      }
   };
   private JiboPersonAsyncClient q;
   @BindView
   SwipeRefreshLayout swipeRefreshLayout;

   private JsonObject b() {
      if (this.o != null && this.o.b("loops") && this.o.c("loops").h() && this.o.c("loops").m().a() > 0) {
         JsonArray var3 = this.o.d("loops");
         if (var3 != null) {
            for (int var1 = 0; var1 < var3.a(); var1++) {
               JsonObject var2 = var3.a(var1).l();
               if (var2.b("id") && this.k.getId().equals(var2.c("id").c())) {
                  return var2;
               }
            }
         }
      }

      return null;
   }

   private JsonObject q() {
      if (this.o != null && this.o.b("loops") && this.o.c("loops").h() && this.o.c("loops").m().a() > 0) {
         JsonObject var2 = this.b();
         JsonArray var4;
         if (var2 != null) {
            var4 = var2.d("genres");
         } else {
            var4 = null;
         }

         if (var4 != null) {
            for (int var1 = 0; var1 < var4.a(); var1++) {
               JsonObject var3 = var4.a(var1).l();
               if (var3.b("id") && this.n.a() == var3.c("id").f()) {
                  return var3;
               }
            }
         }
      }

      return null;
   }

   private void r() {
      this.f();
      this.l = null;
      this.m = null;
      IHeartApiServiceGenerator.IHeartStationsApiService var1 = IHeartApiServiceGenerator.a(this.e.a(), null);
      var1.a(RobotHelper.getCountryCode(this.d), RobotHelper.getZipcode(this.d), this.n.a()).a(new Callback<List<Station>>(this, var1) {
         final IHeartApiServiceGenerator.IHeartStationsApiService a;
         final StationsFragment b;

         {
            this.b = var1;
            this.a = var2;
         }

         @Override
         public void a(Call<List<Station>> var1, Throwable var2) {
            this.b.a(var2, "error getting iHeart liveStations", false);
            this.b.s();
         }

         @Override
         public void a(Call<List<Station>> var1, Response<List<Station>> var2) {
            if (this.b.d()) {
               if (var2.a()) {
                  this.b.l = (List<Station>)var2.b();
                  this.a.a(RobotHelper.getCountryCode(this.b.d), this.b.n.a()).a(new Callback<List<Station>>(this) {
                     final <unrepresentable> a;

                     {
                        this.a = var1;
                     }

                     @Override
                     public void a(Call<List<Station>> var1, Throwable var2x) {
                        this.a.b.a(var2x, "error getting iHeart liveStations", false);
                        this.a.b.s();
                     }

                     // $VF: Duplicated exception handlers to handle obfuscated exceptions
                     @Override
                     public void a(Call<List<Station>> var1, Response<List<Station>> var2) {
                        if (this.a.b.d()) {
                           label51: {
                              try {
                                 if (!var2.a()) {
                                    break label51;
                                 }

                                 StationsFragment var9 = this.a.b;
                                 ArrayList var4 = new ArrayList();
                                 var9.m = var4;
                                 var10 = ((List)var2.b()).iterator();
                              } catch (Exception var7) {
                                 this.a.b.a(var7, "error getting iHeart liveStations", false);
                                 break label51;
                              }

                              while (true) {
                                 Iterator var12;
                                 try {
                                    if (!var10.hasNext()) {
                                       break;
                                    }

                                    var11 = (Station)var10.next();
                                    var12 = this.a.b.l.iterator();
                                 } catch (Exception var5) {
                                    this.a.b.a(var5, "error getting iHeart liveStations", false);
                                    break;
                                 }

                                 boolean var3;
                                 label47: {
                                    label46: {
                                       try {
                                          while (var12.hasNext()) {
                                             if (((Station)var12.next()).a() == var11.a()) {
                                                break label46;
                                             }
                                          }
                                       } catch (Exception var8) {
                                          this.a.b.a(var8, "error getting iHeart liveStations", false);
                                          break;
                                       }

                                       var3 = false;
                                       break label47;
                                    }

                                    var3 = true;
                                 }

                                 if (!var3) {
                                    try {
                                       this.a.b.m.add(var11);
                                    } catch (Exception var6) {
                                       this.a.b.a(var6, "error getting iHeart liveStations", false);
                                       break;
                                    }
                                 }
                              }
                           }

                           this.a.b.s();
                        }
                     }
                  });
               } else {
                  this.b.s();
               }
            }
         }
      });
   }

   private void s() {
      this.a(
         new Runnable(this) {
            final StationsFragment a;

            {
               this.a = var1;
            }

            @Override
            public void run() {
               this.a.g();
               this.a.emptyView.setVisibility(8);
               this.a.b.clear();
               JsonObject var3 = this.a.q();
               Station var2;
               if (var3 != null) {
                  var2 = new Gson().a(var3, Genre.class).c();
               } else {
                  var2 = null;
               }

               if (this.a.l != null && this.a.m != null && this.a.n != null && this.a.n.a() != 0 && var3 != null) {
                  this.a.b.add(new Items.SubheaderItem(this.a.getString(2131755894)));
                  if (!this.a.l.isEmpty()) {
                     for (Station var10 : this.a.l) {
                        StationsFragment.StationItem var15 = new StationsFragment.StationItem(this.a.p, var10, var10.equals(var2));
                        var15.a(var10.c());
                        this.a.b.add(var15);
                     }
                  } else {
                     Loop var8 = SharedPreferencesUtil.f(this.a.getActivity());
                     Account var4 = EntityData.a(this.a.getActivity()).i();
                     boolean var1;
                     if (var4 != null && LoopHelper.isOwner(var8, var4.getId())) {
                        var1 = true;
                     } else {
                        var1 = false;
                     }

                     if (var1) {
                        List var7 = this.a.b;
                        Items.ItemType var5 = Items.ItemType.text_greyed_row;
                        StationsFragment var12 = this.a;
                        String var6 = this.a.n.b();
                        String var9;
                        if (TextUtils.isEmpty(RobotHelper.getAddressLine(this.a.d))) {
                           var9 = RobotHelper.getLocation(this.a.d);
                        } else {
                           var9 = RobotHelper.getAddressLine(this.a.d);
                        }

                        var7.add(new Items.SimpleItem(var5, var12.getString(2131755817, var6, var9)));
                     } else {
                        this.a
                           .b
                           .add(
                              new Items.TwoRowsSimpleItem(
                                 Items.ItemType.text_double_greyed_row, this.a.getString(2131755818, this.a.n.b()), this.a.getString(2131755804)
                              )
                           );
                     }
                  }

                  if (this.a.m != null && !this.a.m.isEmpty()) {
                     this.a.b.add(new Items.SubheaderItem(this.a.getString(2131755764)));

                     for (Station var11 : this.a.m) {
                        StationsFragment.StationItem var14 = new StationsFragment.StationItem(this.a.p, var11, var11.equals(var2));
                        var14.a(var11.c());
                        this.a.b.add(var14);
                     }
                  }
               } else {
                  this.a.emptyView.setVisibility(0);
               }

               this.a.c.notifyDataSetChanged();
            }
         }
      );
   }

   @Override
   protected void a(ActionBar var1) {
      super.a(var1);
      var1.setDisplayHomeAsUpEnabled(true);
   }

   @Override
   public void b(Bundle var1) {
      super.b(var1);
      Loop var2;
      if (this.k == null) {
         var2 = SharedPreferencesUtil.f(this.getActivity());
      } else {
         var2 = this.k;
      }

      this.k = var2;
      this.d = (Robot)var1.getParcelable(Robot.class.getSimpleName());
      this.e = new Gson().a(var1.getString(LocationConfig.class.getSimpleName()), LocationConfig.class);
      this.n = new Gson().a(var1.getString(Genre.class.getSimpleName()), Genre.class);
      Genre var10;
      if (this.n == null) {
         var10 = new Genre(0, null);
      } else {
         var10 = this.n;
      }

      this.n = var10;
      if (var1.containsKey("PARAM_STATIONS_LOCAL")) {
         try {
            Gson var3 = new Gson();
            String var11 = var1.getString("PARAM_STATIONS_LOCAL");
            TypeToken var4 = new TypeToken<List<Station>>(this) {
               final StationsFragment a;

               {
                  this.a = var1;
               }
            };
            this.l = var3.a(var11, var4.getType());
         } catch (Exception var7) {
         }
      }

      if (var1.containsKey("PARAM_STATIONS_ALL")) {
         try {
            Gson var12 = new Gson();
            String var16 = var1.getString("PARAM_STATIONS_ALL");
            TypeToken var15 = new TypeToken<List<Station>>(this) {
               final StationsFragment a;

               {
                  this.a = var1;
               }
            };
            this.m = var12.a(var16, var15.getType());
         } catch (Exception var6) {
         }
      }

      String var13 = var1.getString(JsonObject.class.getSimpleName());
      if (!TextUtils.isEmpty(var13) && !var13.equals("null")) {
         try {
            JsonParser var14 = new JsonParser();
            this.o = (JsonObject)var14.a(var1.getString(JsonObject.class.getSimpleName()));
         } catch (Exception var5) {
         }
      }

      String var8 = "{'id':'" + this.k.getId() + "', 'genres':[]}";
      if (this.o == null) {
         this.o = (JsonObject)new JsonParser().a("{'loops':[" + var8 + "]}");
      }

      if (!this.o.b("loops")) {
         this.o.a("loops", new JsonParser().a("[" + var8 + "]"));
      }

      if (this.b() == null) {
         this.o.c("loops").m().a(new JsonParser().a(var8));
      }

      if (this.q() == null) {
         JsonObject var9 = this.b();
         if (var9 != null) {
            var9.d("genres").a(new Gson().a(this.n));
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
      return this.n.b();
   }

   @Override
   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      return var1.inflate(2131427460, var2, false);
   }

   @Override
   public void onPause() {
      super.onPause();
      this.swipeRefreshLayout.setRefreshing(false);
   }

   @Override
   public void onResume() {
      super.onResume();
      if (this.l != null && (!this.l.isEmpty() || this.n == null || this.n.a() == 0)) {
         this.s();
      } else {
         this.r();
      }
   }

   @Override
   public void onSaveInstanceState(Bundle var1) {
      super.onSaveInstanceState(var1);
      var1.putParcelable(Robot.class.getSimpleName(), this.d);
      var1.putString(LocationConfig.class.getSimpleName(), new Gson().b(this.e).toString());
      var1.putString(Genre.class.getSimpleName(), new Gson().b(this.n).toString());
      var1.putString(JsonObject.class.getSimpleName(), this.o.toString());
      if (this.l != null) {
         var1.putString("PARAM_STATIONS_LOCAL", new Gson().b(this.l));
      }

      if (this.m != null) {
         var1.putString("PARAM_STATIONS_ALL", new Gson().b(this.m));
      }
   }

   @Override
   public void onViewCreated(View var1, Bundle var2) {
      super.onViewCreated(var1, var2);
      this.c = new AbstractItemRecycleViewAdapter.SimpleImplItemRecycleViewAdapter(this.b);
      this.list.setHasFixedSize(true);
      this.list.setItemAnimator(new DefaultItemAnimator());
      this.list.setLayoutManager(new LinearLayoutManager(this.getActivity(), 1, false));
      this.list.addItemDecoration(new StationsFragment.SpacesItemDecoration(this.getActivity(), 2131165462, 2131165263, 2131165366));
      this.list.setAdapter(this.c);
      this.swipeRefreshLayout.setOnRefreshListener(this);
      this.swipeRefreshLayout.setColorSchemeResources(2131099771, 2131099672, 2131099672, 2131099672);
      this.emptyViewTitle.setText(2131755869);
      this.emptyViewIcon.setImageResource(2131231019);
      this.emptyViewTextInfo.setText(2131755791);
      Account var3 = EntityData.a(this.getActivity()).i();
      JiboPersonAsyncClient var4 = new JiboPersonAsyncClient(new BasicAWSCredentials(var3.getAccessKeyId(), var3.getSecretAccessKey()));
      this.q = var4;
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

   private static class StationItem extends Items.AvatarRadioTwoRowsSimpleItem {
      private Station a;

      public StationItem(OnClickListener var1, Station var2, boolean var3) {
         super(var1, var2.b(), var2.f(), var3);
         this.a = var2;
      }

      public Station a() {
         return this.a;
      }
   }
}
