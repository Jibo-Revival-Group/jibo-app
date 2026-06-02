package com.jibo.ui.fragment.home;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.graphics.Rect;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.LoaderManager;
import android.support.v4.app.ShareCompat;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.FileProvider;
import android.support.v4.content.Loader;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.view.ActionMode;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.RelativeLayout.LayoutParams;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.crashlytics.android.Crashlytics;
import com.jibo.JiboAnalytics;
import com.jibo.aws.integration.aws.services.loop.model.Loop;
import com.jibo.aws.integration.aws.services.media.model.Media;
import com.jibo.aws.integration.helpers.LoopHelper;
import com.jibo.aws.integration.helpers.MediaHelper;
import com.jibo.aws.integration.util.KeyManager;
import com.jibo.db.DatabaseContract;
import com.jibo.db.EntityData;
import com.jibo.service.MediaDeletingService;
import com.jibo.service.SyncHelper;
import com.jibo.ui.activity.BaseActivity;
import com.jibo.ui.activity.PhotoViewerActivity;
import com.jibo.ui.fragment.BaseFragment;
import com.jibo.ui.fragment.dialog.DialogUtils;
import com.jibo.ui.fragment.dialog.DownloadProgressFragment;
import com.jibo.ui.fragment.dialog.passphrase.LoopPassphraseRestoreDialog;
import com.jibo.ui.fragment.dialog.passphrase.LoopPassphraseUtils;
import com.jibo.ui.helpers.RecyclerCursorAdapter;
import com.jibo.utils.ImageUtils;
import com.jibo.utils.SharedPreferencesUtil;
import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class MediaFragment
   extends BaseFragment
   implements LoaderManager.LoaderCallbacks<Cursor>,
   SwipeRefreshLayout.OnRefreshListener,
   LoopPassphraseRestoreDialog.BackupKeyRestoredListener {
   final int a;
   final int b;
   private MediaFragment.MomentsAdapter c;
   private Map<Integer, MediaFragment.HeaderItem> d = new HashMap<>();
   private Map<String, Loop> e = new HashMap<>();
   @BindView
   View emptyView;
   private boolean l;
   @BindView
   RecyclerView list;
   private Runnable m = new Runnable(this) {
      final MediaFragment a;

      {
         this.a = var1;
      }

      @Override
      public void run() {
         if (this.a.p().r() != null && this.a.n.a() == 0) {
            this.a.p().r().c();
         }
      }
   };
   private MediaFragment.PhotoSelector n = new MediaFragment.PhotoSelector();
   private ActionMode o;
   private ActionMode.Callback p = new ActionMode.Callback(this) {
      final MediaFragment a;

      {
         this.a = var1;
      }

      @Override
      public void a(ActionMode var1) {
         this.a.p().a(null);
         this.a.n.b();
         this.a.c.notifyItemRangeChanged(0, this.a.c.getItemCount(), this.a.p);
      }

      @Override
      public boolean a(ActionMode var1, Menu var2) {
         var1.a().inflate(2131492877, var2);
         ImageUtils.a(this.a.getActivity(), var2);
         return true;
      }

      @Override
      public boolean a(ActionMode var1, MenuItem var2) {
         boolean var3 = true;
         this.a.o = var1;
         switch (var2.getItemId()) {
            case 2131296292:
               DialogUtils.a(this.a, 117, this.a.getString(2131755629), this.a.getString(2131755625));
               break;
            case 2131296307:
               this.a.s();
               break;
            default:
               var1.c();
               var3 = false;
         }

         return var3;
      }

      @Override
      public boolean b(ActionMode var1, Menu var2) {
         int var3 = this.a.n.a();
         if (var3 > 0) {
            var1.b(this.a.getString(2131755776, var3));
         }

         this.a.c().postDelayed(this.a.m, 50L);
         return false;
      }
   };
   @BindView
   View progressView;
   private BroadcastReceiver q = new BroadcastReceiver(this) {
      final MediaFragment a;

      {
         this.a = var1;
      }

      public void onReceive(Context var1, Intent var2) {
         if ("ACTION_KEY_SAVED".equals(var2.getAction())) {
            this.a.getLoaderManager().b(2131296709, null, this.a);
         }
      }
   };
   private boolean r = false;
   private boolean s = true;
   @BindView
   SwipeRefreshLayout swipeRefreshLayout;
   private MediaFragment.PaginationAsyncTask t;
   private RecyclerView.OnScrollListener u = new RecyclerView.OnScrollListener(this) {
      final MediaFragment a;

      {
         this.a = var1;
      }

      @Override
      public void a(RecyclerView var1, int var2, int var3) {
         var2 = this.a.list.getChildAdapterPosition(this.a.list.getChildAt(this.a.list.getChildCount() - 1));
         if (!this.a.r && this.a.c.getItemCount() <= var2 + 2 && this.a.s && var3 > 0) {
            this.a.r = true;
            if (this.a.t != null) {
               this.a.t.cancel(true);
            }

            this.a.t = this.a.new PaginationAsyncTask(this.a);
            this.a.t.execute(new Void[0]);
         }
      }
   };
   private Handler v = new Handler(this) {
      final MediaFragment a;

      {
         this.a = var1;
      }

      public void handleMessage(Message var1) {
         if (this.a.d() && !LoopPassphraseUtils.a(this.a.getFragmentManager())) {
            if (var1.what == 1) {
               this.a.t();
            } else if (var1.what == 2) {
               this.a.u();
            }
         }
      }
   };
   @BindView
   View viewNoKey;

   public MediaFragment() {
      this.a = 1;
      this.b = 2;
   }

   private void a(int var1) {
      for (MediaFragment.HeaderItem var2 : this.d.values()) {
         if (var1 >= var2.d && var1 <= var2.e) {
            this.c.notifyItemRangeChanged(var2.d - 1, 1);
            break;
         }
      }
   }

   private void b() {
      if (this.list != null) {
         MediaFragment.CustomGridLayoutManager var2 = new MediaFragment.CustomGridLayoutManager(this.getActivity(), MediaFragment.ModesHelper.b(), 1, false);
         this.list.removeAllViewsInLayout();
         this.list.setHasFixedSize(true);
         this.list.removeOnScrollListener(this.u);
         this.list.addOnScrollListener(this.u);

         try {
            Field var3 = this.list.getClass().getDeclaredField("mItemDecorations");
            var3.setAccessible(true);
            ((ArrayList)var3.get(this.list)).clear();
         } catch (Exception var4) {
            Crashlytics.a(var4);
         }

         this.list.addItemDecoration(MediaFragment.ModesHelper.a(this.getActivity()));
         this.list.setItemAnimator(new DefaultItemAnimator());
         this.list.setLayoutManager(var2);
         RecyclerView var5 = this.list;
         boolean var1;
         if (!MediaFragment.ModesHelper.a()) {
            var1 = true;
         } else {
            var1 = false;
         }

         var5.setHapticFeedbackEnabled(var1);
         var2.a(new GridLayoutManager.SpanSizeLookup(this) {
            final MediaFragment b;

            {
               this.b = var1;
            }

            @Override
            public int a(int var1) {
               byte var3 = 0;
               int var2x = var3;
               if (this.b.list != null) {
                  var2x = var3;
                  if (this.b.list.getAdapter() != null) {
                     switch (this.b.list.getAdapter().getItemViewType(var1)) {
                        case 0:
                        case 2:
                           var2x = MediaFragment.ModesHelper.b();
                           break;
                        case 1:
                           var2x = var3;
                           if (this.b.list != null) {
                              var2x = var3;
                              if (this.b.list.getAdapter() != null) {
                                 var2x = ((MediaFragment.MomentsAdapter)this.b.list.getAdapter()).b(var1);
                              }
                           }
                           break;
                        default:
                           var2x = var3;
                     }
                  }
               }

               return var2x;
            }
         });
         this.c = new MediaFragment.MomentsAdapter(this, this, null, this.n);
         this.list.setAdapter(this.c);
         this.swipeRefreshLayout.setEnabled(MediaFragment.ModesHelper.a());
      }
   }

   private boolean b(Loop var1) {
      KeyManager var3 = KeyManager.getInstance(this.getContext(), EntityData.a(this.getActivity()).i().getId());

      try {
         var5 = var3.obtainKeyHolder(this.getContext(), var1.getId());
      } catch (Exception var4) {
         var5 = null;
      }

      boolean var2;
      if (var5 != null) {
         var2 = true;
      } else {
         var2 = false;
      }

      return var2;
   }

   private void q() {
      this.g();
      this.swipeRefreshLayout.setRefreshing(false);
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   private void r() {
      SparseBooleanArray var5 = this.n.c();
      ArrayList var3 = new ArrayList();

      for (int var1 = 0; var1 < var5.size(); var1++) {
         int var8;
         try {
            var8 = var5.keyAt(var1);
            if (!var5.get(var8, false)) {
               continue;
            }

            var8 = this.c.a(var8);
            if (this.c.a() == null) {
               continue;
            }
         } catch (Exception var7) {
            Crashlytics.a(var7);
            continue;
         }

         if (var8 >= 0) {
            try {
               this.c.a().moveToPosition(var8);
               var3.add(this.c.a().getString(this.c.a().getColumnIndex("_id")));
            } catch (Exception var6) {
               Crashlytics.a(var6);
            }
         }
      }

      if (var3.size() > 0) {
         String[] var4 = new String[var3.size()];
         var3.toArray(var4);
         MediaDeletingService.a(this.getActivity(), var4, false);
      }
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   private void s() {
      int var1 = 0;
      SparseBooleanArray var4 = this.n.c();
      ArrayList var3 = new ArrayList();

      while (var1 < var4.size()) {
         label31: {
            int var8;
            try {
               var8 = var4.keyAt(var1);
               if (!var4.get(var8, false)) {
                  break label31;
               }

               var8 = this.c.a(var8);
               if (this.c.a() == null) {
                  break label31;
               }
            } catch (Exception var7) {
               Crashlytics.a(var7);
               break label31;
            }

            if (var8 >= 0) {
               try {
                  this.c.a().moveToPosition(var8);
                  String var5 = this.c.a().getString(this.c.a().getColumnIndex("reference"));
                  if (!TextUtils.isEmpty(var5)) {
                     var3.add(var5);
                  }
               } catch (Exception var6) {
                  Crashlytics.a(var6);
               }
            }
         }

         var1++;
      }

      if (var3.size() > 0) {
         Bundle var10 = new Bundle();
         var10.putStringArrayList("ARG_IDS", var3);
         DownloadProgressFragment var9 = new DownloadProgressFragment();
         var9.setArguments(var10);
         var9.setTargetFragment(this, 118);
         var9.show(this.getFragmentManager(), DownloadProgressFragment.class.getSimpleName());
      }
   }

   private void t() {
      if (this.d()) {
         Loop var3 = SharedPreferencesUtil.f(this.getContext());
         Context var2 = this.getContext();
         String var5 = var3.getId();
         boolean var1;
         if (!this.l) {
            var1 = true;
         } else {
            var1 = false;
         }

         LoopPassphraseUtils.DialogType var4 = LoopPassphraseUtils.a(var2, var5, var1);
         if (var4 != null && !LoopPassphraseUtils.a(this.getFragmentManager()) && this.d()) {
            LoopPassphraseUtils.a(this, var4);
         }
      }
   }

   private void u() {
      if (this.d()) {
         Loop var1 = SharedPreferencesUtil.f(this.getContext());
         ArrayList var2 = new ArrayList();
         Collections.addAll(var2, SharedPreferencesUtil.m(this.getActivity()));
         if (var2.indexOf(var1.getId()) >= 0 && !LoopPassphraseUtils.a(this.getFragmentManager()) && this.d() && !this.b(var1)) {
            SharedPreferencesUtil.e(this.getActivity(), var1.getId());
            LoopPassphraseUtils.a(var1.getId(), this, new LoopPassphraseUtils.KeyBackupCheckListener(this, var1) {
               final Loop a;
               final MediaFragment b;

               {
                  this.b = var1;
                  this.a = var2x;
               }

               @Override
               public void a() {
                  if (!LoopPassphraseUtils.a(this.b.getFragmentManager()) && this.b.d()) {
                     LoopPassphraseUtils.a(this.b, LoopPassphraseUtils.DialogType.RESTORE_BY_TIMEOUT, this.a);
                  }
               }

               @Override
               public void b() {
                  if (!LoopPassphraseUtils.a(this.b.getFragmentManager()) && this.b.d()) {
                     LoopPassphraseUtils.a(this.b, LoopPassphraseUtils.DialogType.NO_BACKUP_BY_TIMEOUT, null);
                  }
               }
            });
         }
      }
   }

   @Override
   public Loader<Cursor> a(int var1, Bundle var2) {
      CursorLoader var3;
      switch (var1) {
         case 2131296709:
            var3 = new CursorLoader(this.getActivity(), DatabaseContract.EntityEntry.a(8), DatabaseContract.EntityEntry.a, null, null, null);
            break;
         case 2131296710:
         default:
            var3 = null;
            break;
         case 2131296711:
            var3 = new MediaFragment.MediaCursor(this.getActivity(), this.d, this.e);
      }

      return var3;
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   @Override
   public void a(int var1, int var2, Object var3) {
      super.a(var1, var2, var3);
      switch (var1) {
         case 117:
            JiboAnalytics.j(this.getActivity());
            this.r();
            break;
         case 118:
            label68:
            if (var3 != null) {
               ArrayList var5;
               try {
                  var5 = (ArrayList)var3;
                  if (var5.isEmpty()) {
                     Exception var19 = new Exception(this.getString(2131755257));
                     throw var19;
                  }
               } catch (Exception var14) {
                  DialogUtils.d(this, 104, this.getString(2131756022), this.getString(2131755257));
                  break label68;
               }

               ShareCompat.IntentBuilder var4;
               try {
                  var4 = ShareCompat.IntentBuilder.a(this.getActivity());
               } catch (Exception var13) {
                  DialogUtils.d(this, 104, this.getString(2131756022), this.getString(2131755257));
                  break label68;
               }

               Uri var15 = null;

               try {
                  var20 = var5.iterator();
               } catch (Exception var11) {
                  DialogUtils.d(this, 104, this.getString(2131756022), this.getString(2131755257));
                  break label68;
               }

               while (true) {
                  try {
                     if (!var20.hasNext()) {
                        break;
                     }

                     String var16 = (String)var20.next();
                     FragmentActivity var6 = this.getActivity();
                     File var7 = new File(var16);
                     var15 = FileProvider.a(var6, "com.jibo.fileprovider", var7);
                     var4.b(var15);
                  } catch (Exception var12) {
                     DialogUtils.d(this, 104, this.getString(2131756022), this.getString(2131755257));
                     break label68;
                  }
               }

               if (var15 != null) {
                  try {
                     var4.a(this.getActivity().getContentResolver().getType(var15));
                  } catch (Exception var10) {
                     DialogUtils.d(this, 104, this.getString(2131756022), this.getString(2131755257));
                     break label68;
                  }
               }

               try {
                  Intent var17 = var4.a(2131755850).b();
                  var17.addFlags(1);
                  if (var17.resolveActivity(this.getActivity().getPackageManager()) != null) {
                     this.startActivity(var17);
                     JiboAnalytics.e(this.getActivity());
                     break label68;
                  }
               } catch (Exception var9) {
                  DialogUtils.d(this, 104, this.getString(2131756022), this.getString(2131755257));
                  break label68;
               }

               try {
                  Exception var18 = new Exception(this.getString(2131755257));
                  throw var18;
               } catch (Exception var8) {
                  DialogUtils.d(this, 104, this.getString(2131756022), this.getString(2131755257));
               }
            }
      }

      if (this.o != null) {
         this.o.c();
      }
   }

   @Override
   public void a(Loader<Cursor> var1) {
      this.c.b(null);
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   public void a(Loader<Cursor> var1, Cursor var2) {
      int var3 = 0;
      if (var1.n() == 2131296709) {
         int var4;
         label93: {
            label114: {
               try {
                  this.e.clear();
               } catch (Exception var10) {
                  var12 = var10;
                  var3 = 0;
                  break label114;
               }

               label89:
               if (var2 != null) {
                  try {
                     if (var2.isClosed() || !var2.moveToFirst()) {
                        break label89;
                     }

                     var13 = EntityData.a(this.getActivity()).i();
                  } catch (Exception var11) {
                     var12 = var11;
                     var3 = 0;
                     break label114;
                  }

                  var3 = 0;

                  while (true) {
                     var4 = var3;

                     label110: {
                        Loop var6;
                        try {
                           if (var2.isAfterLast()) {
                              break label93;
                           }

                           EntityData.a(this.getContext());
                           var6 = EntityData.a(var2);
                           if (!LoopHelper.isMemberAccepted(var6, var13.getId())) {
                              break label110;
                           }

                           this.e.put(var6.getId(), var6);
                        } catch (Exception var9) {
                           var12 = var9;
                           break label114;
                        }

                        label67: {
                           try {
                              if (SharedPreferencesUtil.g(this.getActivity().getApplicationContext())) {
                                 KeyManager.getInstance(this.getActivity(), var13.getId())
                                    .obtainKeyHolder(this.getActivity().getApplicationContext(), var6.getId());
                                 break label67;
                              }
                           } catch (Exception var8) {
                              break label110;
                           }

                           var3++;
                           break label110;
                        }

                        var3++;
                     }

                     try {
                        var2.moveToNext();
                     } catch (Exception var7) {
                        var12 = var7;
                        break label114;
                     }
                  }
               }

               var4 = 0;
               break label93;
            }

            Crashlytics.a(var12);
            var4 = var3;
         }

         if (var4 != 0) {
            this.swipeRefreshLayout.setEnabled(true);
            this.viewNoKey.setVisibility(8);
            if (this.getLoaderManager().b(2131296711) != null) {
               this.getLoaderManager().b(2131296711, null, this);
            } else {
               this.getLoaderManager().a(2131296711, null, this);
            }
         } else {
            this.q();
            this.swipeRefreshLayout.setEnabled(false);
            this.viewNoKey.setVisibility(0);
            this.emptyView.setVisibility(8);
            this.getLoaderManager().a(2131296711);
         }

         this.v.sendEmptyMessage(2);
      } else if (var1.n() == 2131296711) {
         boolean var5;
         if (var2 != null && !var2.isClosed() && var2.getCount() != 0 && var2.moveToFirst()) {
            var5 = false;
         } else {
            var5 = true;
         }

         this.l = var5;
         View var14 = this.emptyView;
         if (!this.l) {
            var3 = 8;
         }

         var14.setVisibility(var3);
         this.getActivity().invalidateOptionsMenu();
         this.q();
         this.c.a(this.d);
         this.c.b(var2);
         this.v.sendEmptyMessage(1);
      }
   }

   @Override
   public void a(Loop var1) {
      this.getLoaderManager().b(2131296709, null, this);
   }

   @Override
   public void n_() {
      this.swipeRefreshLayout.setRefreshing(true);
      SyncHelper.a(this.getActivity(), null, true);
   }

   @Override
   public String o() {
      return this.getString(2131756052);
   }

   @Override
   public void onCreate(Bundle var1) {
      super.onCreate(var1);
      this.setHasOptionsMenu(true);
   }

   @Override
   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      return var1.inflate(2131427450, var2, false);
   }

   @Override
   public boolean onOptionsItemSelected(MenuItem var1) {
      boolean var2;
      if (var1.getItemId() != 2131296295 && var1.getItemId() != 2131296311) {
         var2 = super.onOptionsItemSelected(var1);
      } else {
         FragmentActivity var3 = this.getActivity();
         MediaFragment.ModesHelper.Mode var4;
         if (var1.getItemId() == 2131296295) {
            var4 = MediaFragment.ModesHelper.Mode.Gridview;
         } else {
            var4 = MediaFragment.ModesHelper.Mode.Timeline;
         }

         MediaFragment.ModesHelper.a(var3, var4);
         this.getActivity().invalidateOptionsMenu();
         this.getLoaderManager().a(2131296711);
         this.b();
         this.getLoaderManager().a(2131296711, null, this);
         var2 = true;
      }

      return var2;
   }

   @Override
   public void onPause() {
      super.onPause();
      if (this.t != null) {
         this.t.cancel(true);
         this.t = null;
      }

      LocalBroadcastManager.a(this.getActivity()).a(this.q);
      this.q();
   }

   @Override
   public void onResume() {
      super.onResume();
      LocalBroadcastManager var1 = LocalBroadcastManager.a(this.getActivity());
      IntentFilter var2 = new IntentFilter();
      var2.addAction("ACTION_KEY_SAVED");
      var1.a(this.q, var2);
      this.swipeRefreshLayout.setEnabled(MediaFragment.ModesHelper.a());
      SyncHelper.a(this.getActivity(), null, true);
      this.getLoaderManager().a(2131296709, null, this);
   }

   @Override
   public void onViewCreated(View var1, Bundle var2) {
      super.onViewCreated(var1, var2);
      this.b();
      ((BaseActivity)this.getActivity()).a(false);
      this.swipeRefreshLayout.setOnRefreshListener(this);
      this.swipeRefreshLayout.setColorSchemeResources(2131099771, 2131099672, 2131099672, 2131099672);
   }

   static class CustomGridLayoutManager extends GridLayoutManager {
      private boolean z = true;

      public CustomGridLayoutManager(Context var1, int var2, int var3, boolean var4) {
         super(var1, var2, var3, var4);
      }

      @Override
      public boolean f() {
         boolean var1;
         if (this.z && super.f()) {
            var1 = true;
         } else {
            var1 = false;
         }

         return var1;
      }
   }

   private static class EmptyViewHolder extends RecyclerView.ViewHolder {
      public EmptyViewHolder(View var1) {
         super(var1);
      }
   }

   private static class HeaderItem {
      public int a;
      public String b;
      public String c;
      public int d;
      public int e;

      public HeaderItem(int var1, String var2, int var3, int var4, String var5) {
         this.a = var1;
         this.b = var2;
         this.d = var3;
         this.e = var4;
         this.c = var5;
      }
   }

   class HeaderViewHolder extends RecyclerView.ViewHolder {
      final MediaFragment a;
      @BindView
      public TextView selectAll;
      @BindView
      public TextView text1;

      public HeaderViewHolder(MediaFragment var1, View var2, OnClickListener var3) {
         super(var2);
         this.a = var1;
         ButterKnife.a(this, var2);
         this.selectAll.setOnClickListener(var3);
      }

      public void a() {
         byte var2 = 0;
         MediaFragment.HeaderItem var3 = (MediaFragment.HeaderItem)this.selectAll.getTag();
         int var1 = var3.d;

         while (true) {
            if (var1 > var3.e) {
               var4 = false;
               break;
            }

            if (!this.a.n.a(var1)) {
               var4 = true;
               break;
            }

            var1++;
         }

         TextView var6 = this.selectAll;
         byte var5;
         if (var4) {
            var5 = var2;
         } else {
            var5 = 4;
         }

         var6.setVisibility(var5);
      }

      public void a(MediaFragment.HeaderItem var1) {
         this.text1.setText(var1.b);
         this.selectAll.setTag(var1);
         this.a();
      }
   }

   private static class MediaCursor extends CursorLoader {
      private Map<Integer, MediaFragment.HeaderItem> w;
      private Map<String, Loop> x;

      public MediaCursor(Context var1, Map<Integer, MediaFragment.HeaderItem> var2, Map<String, Loop> var3) {
         super(
            var1,
            DatabaseContract.MediaEntry.b,
            DatabaseContract.MediaEntry.a,
            "reference IS NOT NULL AND url IS NOT NULL AND type = ? AND loopId IN (" + b(var3) + ")",
            new String[]{"thumb"},
            "created DESC"
         );
         this.w = var2;
         this.x = var3;
      }

      private Map<Integer, MediaFragment.HeaderItem> C() {
         // $VF: Couldn't be decompiled
         // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
         // java.lang.RuntimeException: parsing failure!
         //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
         //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
         //
         // Bytecode:
         // 000: bipush 0
         // 001: istore 2
         // 002: new java/util/HashMap
         // 005: dup
         // 006: invokespecial java/util/HashMap.<init> ()V
         // 009: astore 10
         // 00b: aload 0
         // 00c: invokevirtual com/jibo/ui/fragment/home/MediaFragment$MediaCursor.m ()Landroid/content/Context;
         // 00f: invokestatic com/jibo/db/DatabaseHelper.a (Landroid/content/Context;)Lcom/jibo/db/DatabaseHelper;
         // 012: invokevirtual com/jibo/db/DatabaseHelper.getReadableDatabase ()Landroid/database/sqlite/SQLiteDatabase;
         // 015: astore 8
         // 017: new java/lang/StringBuilder
         // 01a: astore 9
         // 01c: aload 9
         // 01e: invokespecial java/lang/StringBuilder.<init> ()V
         // 021: aload 9
         // 023: ldc "reference IS NOT NULL AND url IS NOT NULL AND type = ? AND loopId IN ("
         // 025: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
         // 028: aload 0
         // 029: getfield com/jibo/ui/fragment/home/MediaFragment$MediaCursor.x Ljava/util/Map;
         // 02c: invokestatic com/jibo/ui/fragment/home/MediaFragment$MediaCursor.b (Ljava/util/Map;)Ljava/lang/String;
         // 02f: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
         // 032: ldc ")"
         // 034: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
         // 037: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
         // 03a: astore 9
         // 03c: aload 8
         // 03e: ldc "media"
         // 040: bipush 3
         // 041: anewarray 47
         // 044: dup
         // 045: bipush 0
         // 046: ldc "count(*) AS _count"
         // 048: aastore
         // 049: dup
         // 04a: bipush 1
         // 04b: ldc "created"
         // 04d: aastore
         // 04e: dup
         // 04f: bipush 2
         // 050: ldc "loopId"
         // 052: aastore
         // 053: aload 9
         // 055: bipush 1
         // 056: anewarray 47
         // 059: dup
         // 05a: bipush 0
         // 05b: ldc "thumb"
         // 05d: aastore
         // 05e: ldc "date(substr(created, 0, length(created) - 2), 'unixepoch') "
         // 060: aconst_null
         // 061: ldc "created DESC"
         // 063: aconst_null
         // 064: invokevirtual android/database/sqlite/SQLiteDatabase.query (Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
         // 067: astore 9
         // 069: aload 9
         // 06b: ifnull 078
         // 06e: aload 9
         // 070: invokeinterface android/database/Cursor.isClosed ()Z 1
         // 075: ifeq 094
         // 078: aload 9
         // 07a: invokeinterface android/database/Cursor.close ()V 1
         // 07f: aload 10
         // 081: areturn
         // 082: astore 8
         // 084: aload 8
         // 086: invokestatic com/crashlytics/android/Crashlytics.a (Ljava/lang/Throwable;)V
         // 089: aconst_null
         // 08a: astore 9
         // 08c: goto 069
         // 08f: astore 8
         // 091: aload 8
         // 093: athrow
         // 094: invokestatic java/util/Calendar.getInstance ()Ljava/util/Calendar;
         // 097: astore 11
         // 099: aload 11
         // 09b: bipush 1
         // 09c: invokevirtual java/util/Calendar.get (I)I
         // 09f: istore 6
         // 0a1: aload 11
         // 0a3: bipush 6
         // 0a5: invokevirtual java/util/Calendar.get (I)I
         // 0a8: istore 4
         // 0aa: aload 11
         // 0ac: bipush 6
         // 0ae: bipush -1
         // 0af: invokevirtual java/util/Calendar.add (II)V
         // 0b2: aload 11
         // 0b4: bipush 1
         // 0b5: invokevirtual java/util/Calendar.get (I)I
         // 0b8: istore 5
         // 0ba: aload 11
         // 0bc: bipush 6
         // 0be: invokevirtual java/util/Calendar.get (I)I
         // 0c1: istore 3
         // 0c2: aload 11
         // 0c4: bipush 6
         // 0c6: bipush 1
         // 0c7: invokevirtual java/util/Calendar.add (II)V
         // 0ca: aload 9
         // 0cc: invokeinterface android/database/Cursor.moveToFirst ()Z 1
         // 0d1: pop
         // 0d2: bipush 0
         // 0d3: istore 1
         // 0d4: aload 9
         // 0d6: invokeinterface android/database/Cursor.isAfterLast ()Z 1
         // 0db: ifne 1b7
         // 0de: aload 11
         // 0e0: aload 9
         // 0e2: bipush 1
         // 0e3: invokeinterface android/database/Cursor.getLong (I)J 2
         // 0e8: invokevirtual java/util/Calendar.setTimeInMillis (J)V
         // 0eb: iinc 2 1
         // 0ee: iload 6
         // 0f0: bipush 100
         // 0f2: imul
         // 0f3: iload 4
         // 0f5: iadd
         // 0f6: aload 11
         // 0f8: bipush 1
         // 0f9: invokevirtual java/util/Calendar.get (I)I
         // 0fc: bipush 100
         // 0fe: imul
         // 0ff: aload 11
         // 101: bipush 6
         // 103: invokevirtual java/util/Calendar.get (I)I
         // 106: iadd
         // 107: if_icmpne 17f
         // 10a: aload 0
         // 10b: invokevirtual com/jibo/ui/fragment/home/MediaFragment$MediaCursor.m ()Landroid/content/Context;
         // 10e: ldc 2131755865
         // 110: invokevirtual android/content/Context.getString (I)Ljava/lang/String;
         // 113: astore 8
         // 115: aload 0
         // 116: aload 9
         // 118: aload 9
         // 11a: ldc "loopId"
         // 11c: invokeinterface android/database/Cursor.getColumnIndex (Ljava/lang/String;)I 2
         // 121: invokeinterface android/database/Cursor.getString (I)Ljava/lang/String; 2
         // 126: invokespecial com/jibo/ui/fragment/home/MediaFragment$MediaCursor.a (Ljava/lang/String;)Ljava/lang/String;
         // 129: astore 13
         // 12b: new com/jibo/ui/fragment/home/MediaFragment$HeaderItem
         // 12e: astore 12
         // 130: aload 12
         // 132: aload 10
         // 134: invokeinterface java/util/Map.size ()I 1
         // 139: bipush 1
         // 13a: iadd
         // 13b: aload 8
         // 13d: iload 2
         // 13e: iload 1
         // 13f: iadd
         // 140: iload 2
         // 141: iload 1
         // 142: iadd
         // 143: aload 9
         // 145: bipush 0
         // 146: invokeinterface android/database/Cursor.getInt (I)I 2
         // 14b: iadd
         // 14c: bipush 1
         // 14d: isub
         // 14e: aload 13
         // 150: invokespecial com/jibo/ui/fragment/home/MediaFragment$HeaderItem.<init> (ILjava/lang/String;IILjava/lang/String;)V
         // 153: aload 10
         // 155: iload 1
         // 156: iload 2
         // 157: iadd
         // 158: bipush 1
         // 159: isub
         // 15a: invokestatic java/lang/Integer.valueOf (I)Ljava/lang/Integer;
         // 15d: aload 12
         // 15f: invokeinterface java/util/Map.put (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; 3
         // 164: pop
         // 165: aload 9
         // 167: bipush 0
         // 168: invokeinterface android/database/Cursor.getInt (I)I 2
         // 16d: istore 7
         // 16f: aload 9
         // 171: invokeinterface android/database/Cursor.moveToNext ()Z 1
         // 176: pop
         // 177: iload 7
         // 179: iload 1
         // 17a: iadd
         // 17b: istore 1
         // 17c: goto 0d4
         // 17f: iload 5
         // 181: bipush 100
         // 183: imul
         // 184: iload 3
         // 185: iadd
         // 186: aload 11
         // 188: bipush 1
         // 189: invokevirtual java/util/Calendar.get (I)I
         // 18c: bipush 100
         // 18e: imul
         // 18f: aload 11
         // 191: bipush 6
         // 193: invokevirtual java/util/Calendar.get (I)I
         // 196: iadd
         // 197: if_icmpne 1a8
         // 19a: aload 0
         // 19b: invokevirtual com/jibo/ui/fragment/home/MediaFragment$MediaCursor.m ()Landroid/content/Context;
         // 19e: ldc 2131755887
         // 1a0: invokevirtual android/content/Context.getString (I)Ljava/lang/String;
         // 1a3: astore 8
         // 1a5: goto 115
         // 1a8: aload 11
         // 1aa: invokevirtual java/util/Calendar.getTimeInMillis ()J
         // 1ad: ldc "EEE M/dd/yy"
         // 1af: invokestatic com/jibo/aws/integration/util/DateTimeUtils.getFormattedDate (JLjava/lang/String;)Ljava/lang/String;
         // 1b2: astore 8
         // 1b4: goto 115
         // 1b7: aload 9
         // 1b9: invokeinterface android/database/Cursor.close ()V 1
         // 1be: goto 07f
         // 1c1: astore 8
         // 1c3: aload 8
         // 1c5: invokestatic com/crashlytics/android/Crashlytics.a (Ljava/lang/Throwable;)V
         // 1c8: aload 9
         // 1ca: invokeinterface android/database/Cursor.close ()V 1
         // 1cf: goto 1be
         // 1d2: astore 8
         // 1d4: aload 9
         // 1d6: invokeinterface android/database/Cursor.close ()V 1
         // 1db: aload 8
         // 1dd: athrow
         // try (6 -> 55): 64 java/lang/Exception
         // try (6 -> 55): 70 null
         // try (65 -> 67): 70 null
         // try (99 -> 102): 215 java/lang/Exception
         // try (99 -> 102): 221 null
         // try (104 -> 112): 215 java/lang/Exception
         // try (104 -> 112): 221 null
         // try (113 -> 133): 215 java/lang/Exception
         // try (113 -> 133): 221 null
         // try (133 -> 180): 215 java/lang/Exception
         // try (133 -> 180): 221 null
         // try (185 -> 205): 215 java/lang/Exception
         // try (185 -> 205): 221 null
         // try (206 -> 211): 215 java/lang/Exception
         // try (206 -> 211): 221 null
         // try (216 -> 218): 221 null
      }

      private Map<Integer, MediaFragment.HeaderItem> D() {
         // $VF: Couldn't be decompiled
         // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
         // java.lang.RuntimeException: parsing failure!
         //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
         //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
         //
         // Bytecode:
         // 000: bipush 0
         // 001: istore 2
         // 002: new java/util/HashMap
         // 005: dup
         // 006: invokespecial java/util/HashMap.<init> ()V
         // 009: astore 5
         // 00b: aload 0
         // 00c: invokevirtual com/jibo/ui/fragment/home/MediaFragment$MediaCursor.m ()Landroid/content/Context;
         // 00f: invokestatic com/jibo/db/DatabaseHelper.a (Landroid/content/Context;)Lcom/jibo/db/DatabaseHelper;
         // 012: invokevirtual com/jibo/db/DatabaseHelper.getReadableDatabase ()Landroid/database/sqlite/SQLiteDatabase;
         // 015: astore 4
         // 017: new java/lang/StringBuilder
         // 01a: astore 6
         // 01c: aload 6
         // 01e: invokespecial java/lang/StringBuilder.<init> ()V
         // 021: aload 6
         // 023: ldc "type = ? AND loopId IN ("
         // 025: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
         // 028: aload 0
         // 029: getfield com/jibo/ui/fragment/home/MediaFragment$MediaCursor.x Ljava/util/Map;
         // 02c: invokestatic com/jibo/ui/fragment/home/MediaFragment$MediaCursor.b (Ljava/util/Map;)Ljava/lang/String;
         // 02f: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
         // 032: ldc ")"
         // 034: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
         // 037: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
         // 03a: astore 6
         // 03c: aload 4
         // 03e: ldc "media"
         // 040: bipush 3
         // 041: anewarray 47
         // 044: dup
         // 045: bipush 0
         // 046: ldc "count(*) AS _count"
         // 048: aastore
         // 049: dup
         // 04a: bipush 1
         // 04b: ldc "created"
         // 04d: aastore
         // 04e: dup
         // 04f: bipush 2
         // 050: ldc "loopId"
         // 052: aastore
         // 053: aload 6
         // 055: bipush 1
         // 056: anewarray 47
         // 059: dup
         // 05a: bipush 0
         // 05b: ldc "thumb"
         // 05d: aastore
         // 05e: ldc "strftime('%Y%m', substr(created, 0, length(created) - 2), 'unixepoch', 'localtime')"
         // 060: aconst_null
         // 061: ldc "created DESC"
         // 063: aconst_null
         // 064: invokevirtual android/database/sqlite/SQLiteDatabase.query (Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
         // 067: astore 4
         // 069: aload 4
         // 06b: ifnull 078
         // 06e: aload 4
         // 070: invokeinterface android/database/Cursor.isClosed ()Z 1
         // 075: ifeq 094
         // 078: aload 4
         // 07a: invokeinterface android/database/Cursor.close ()V 1
         // 07f: aload 5
         // 081: areturn
         // 082: astore 4
         // 084: aload 4
         // 086: invokestatic com/crashlytics/android/Crashlytics.a (Ljava/lang/Throwable;)V
         // 089: aconst_null
         // 08a: astore 4
         // 08c: goto 069
         // 08f: astore 4
         // 091: aload 4
         // 093: athrow
         // 094: invokestatic java/util/Calendar.getInstance ()Ljava/util/Calendar;
         // 097: astore 8
         // 099: aload 4
         // 09b: invokeinterface android/database/Cursor.moveToFirst ()Z 1
         // 0a0: pop
         // 0a1: bipush 0
         // 0a2: istore 1
         // 0a3: aload 4
         // 0a5: invokeinterface android/database/Cursor.isAfterLast ()Z 1
         // 0aa: ifne 11b
         // 0ad: aload 8
         // 0af: aload 4
         // 0b1: bipush 1
         // 0b2: invokeinterface android/database/Cursor.getLong (I)J 2
         // 0b7: invokevirtual java/util/Calendar.setTimeInMillis (J)V
         // 0ba: iinc 2 1
         // 0bd: aload 8
         // 0bf: bipush 2
         // 0c0: bipush 2
         // 0c1: invokestatic java/util/Locale.getDefault ()Ljava/util/Locale;
         // 0c4: invokevirtual java/util/Calendar.getDisplayName (IILjava/util/Locale;)Ljava/lang/String;
         // 0c7: astore 7
         // 0c9: new com/jibo/ui/fragment/home/MediaFragment$HeaderItem
         // 0cc: astore 6
         // 0ce: aload 6
         // 0d0: aload 5
         // 0d2: invokeinterface java/util/Map.size ()I 1
         // 0d7: bipush 1
         // 0d8: iadd
         // 0d9: aload 7
         // 0db: iload 2
         // 0dc: iload 1
         // 0dd: iadd
         // 0de: iload 2
         // 0df: iload 1
         // 0e0: iadd
         // 0e1: aload 4
         // 0e3: bipush 0
         // 0e4: invokeinterface android/database/Cursor.getInt (I)I 2
         // 0e9: iadd
         // 0ea: bipush 1
         // 0eb: isub
         // 0ec: ldc ""
         // 0ee: invokespecial com/jibo/ui/fragment/home/MediaFragment$HeaderItem.<init> (ILjava/lang/String;IILjava/lang/String;)V
         // 0f1: aload 5
         // 0f3: iload 1
         // 0f4: iload 2
         // 0f5: iadd
         // 0f6: bipush 1
         // 0f7: isub
         // 0f8: invokestatic java/lang/Integer.valueOf (I)Ljava/lang/Integer;
         // 0fb: aload 6
         // 0fd: invokeinterface java/util/Map.put (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; 3
         // 102: pop
         // 103: aload 4
         // 105: bipush 0
         // 106: invokeinterface android/database/Cursor.getInt (I)I 2
         // 10b: istore 3
         // 10c: aload 4
         // 10e: invokeinterface android/database/Cursor.moveToNext ()Z 1
         // 113: pop
         // 114: iload 3
         // 115: iload 1
         // 116: iadd
         // 117: istore 1
         // 118: goto 0a3
         // 11b: aload 4
         // 11d: invokeinterface android/database/Cursor.close ()V 1
         // 122: goto 07f
         // 125: astore 6
         // 127: aload 6
         // 129: invokestatic com/crashlytics/android/Crashlytics.a (Ljava/lang/Throwable;)V
         // 12c: aload 4
         // 12e: invokeinterface android/database/Cursor.close ()V 1
         // 133: goto 122
         // 136: astore 5
         // 138: aload 4
         // 13a: invokeinterface android/database/Cursor.close ()V 1
         // 13f: aload 5
         // 141: athrow
         // try (6 -> 55): 64 java/lang/Exception
         // try (6 -> 55): 70 null
         // try (65 -> 67): 70 null
         // try (75 -> 78): 142 java/lang/Exception
         // try (75 -> 78): 148 null
         // try (80 -> 88): 142 java/lang/Exception
         // try (80 -> 88): 148 null
         // try (89 -> 134): 142 java/lang/Exception
         // try (89 -> 134): 148 null
         // try (143 -> 145): 148 null
      }

      private String a(String var1) {
         Loop var2 = this.x.get(var1);
         if (var2 != null) {
            var1 = var2.getName();
         }

         return var1;
      }

      private static String b(Map<String, Loop> var0) {
         return "'" + TextUtils.join("','", var0.keySet()) + "'";
      }

      @Override
      public void f() {
         super.f();
      }

      @Override
      public Cursor h() {
         if (MediaFragment.ModesHelper.a()) {
            this.w.clear();
            this.w.putAll(this.C());
         } else {
            this.w.clear();
            this.w.putAll(this.D());
         }

         return super.h();
      }
   }

   public static class ModesHelper {
      private static final int[] a = new int[]{6, 4};
      private static final float[] b = new float[]{1.7777777F, 1.0F};
      private static MediaFragment.ModesHelper.Mode c = MediaFragment.ModesHelper.Mode.Timeline;

      public static RecyclerView.ItemDecoration a(Context var0) {
         return new MediaFragment.SpacesItemDecoration(var0, 2131165411);
      }

      public static void a(Context var0, MediaFragment.ModesHelper.Mode var1) {
         c = MediaFragment.ModesHelper.Mode.values()[var1.ordinal()];
         var0.getSharedPreferences(var0.getString(2131755063), 0).edit().putInt("PREF_MEDIA_TAB_MODE", var1.ordinal()).apply();
      }

      public static boolean a() {
         boolean var0;
         if (c == MediaFragment.ModesHelper.Mode.Timeline) {
            var0 = true;
         } else {
            var0 = false;
         }

         return var0;
      }

      public static int b() {
         return a[c.ordinal()];
      }

      public static float c() {
         return b[c.ordinal()];
      }

      public enum Mode {
         Gridview,
         Timeline;

         private static final MediaFragment.ModesHelper.Mode[] $VALUES = new MediaFragment.ModesHelper.Mode[]{
            MediaFragment.ModesHelper.Mode.Timeline, MediaFragment.ModesHelper.Mode.Gridview
         };
      }
   }

   public class MomentsAdapter extends RecyclerCursorAdapter<RecyclerView.ViewHolder> {
      final MediaFragment a;
      private final boolean d;
      private MediaFragment e;
      private MediaFragment.PhotoSelector f;
      private Map<Integer, MediaFragment.HeaderItem> g;
      private OnClickListener h;
      private OnClickListener i;
      private OnLongClickListener j;

      public MomentsAdapter(MediaFragment var1, MediaFragment var2, Cursor var3, MediaFragment.PhotoSelector var4) {
         super(var3);
         this.a = var1;
         this.g = new HashMap<>();
         this.h = new OnClickListener(this) {
            final MediaFragment.MomentsAdapter a;

            {
               this.a = var1;
            }

            public void onClick(View var1) {
               MediaFragment.HeaderItem var3x = (MediaFragment.HeaderItem)var1.getTag();

               for (int var2x = var3x.d; var2x <= var3x.e; var2x++) {
                  this.a.f.a(var2x, true);
               }

               if (this.a.a.p().r() == null) {
                  this.a.a.p().a(((AppCompatActivity)this.a.a.getActivity()).startSupportActionMode(this.a.a.p));
                  this.a.notifyItemRangeChanged(this.a.a(this.a.a.list.getChildAt(0)), this.a.a.list.getChildCount(), this.a.a.p);
               } else {
                  this.a.notifyItemChanged(var3x.d - 1);
                  this.a.notifyItemRangeChanged(var3x.d, var3x.e - var3x.d + 1, this.a.f);
               }

               this.a.a.p().s();
            }
         };
         this.i = new OnClickListener(this) {
            final MediaFragment.MomentsAdapter a;

            {
               this.a = var1;
            }

            public void onClick(View var1) {
               boolean var3 = true;
               int var2 = this.a.a(var1);
               if (var2 != -1 && this.a.a.list.getChildViewHolder(var1) instanceof MediaFragment.PhotoItemViewHolder) {
                  if (this.a.a.p().r() == null) {
                     Intent var4 = new Intent(this.a.a.getActivity(), PhotoViewerActivity.class);
                     var4.putExtra("media_indx", this.a.a(var2));
                     var4.setData(DatabaseContract.MediaEntry.b);
                     var4.putExtra("where", "url IS NOT NULL AND type = ? AND loopId IN (" + MediaFragment.MediaCursor.b(this.a.a.e) + ")");
                     var4.putExtra("where_args", new String[]{"image"});
                     var4.putExtra("projection", DatabaseContract.MediaEntry.a);
                     var4.putExtra("order", "created DESC");
                     this.a.a.startActivity(var4);
                  } else {
                     MediaFragment.PhotoSelector var5 = this.a.f;
                     if (this.a.f.a(var2)) {
                        var3 = false;
                     }

                     var5.a(var2, var3);
                     this.a.notifyItemChanged(var2, this.a.f);
                     this.a.a.p().s();
                  }

                  this.a.a.a(var2);
               }
            }
         };
         this.j = new OnLongClickListener(this) {
            final MediaFragment.MomentsAdapter a;

            {
               this.a = var1;
            }

            public boolean onLongClick(View var1) {
               int var2x = this.a.a(var1);
               if (var2x != -1 && this.a.a.list.findContainingViewHolder(var1) instanceof MediaFragment.PhotoItemViewHolder) {
                  this.a.a.list.performHapticFeedback(0);
                  this.a.f.a(var2x, true);
                  if (this.a.a.p().r() == null) {
                     this.a.a.p().a(((AppCompatActivity)this.a.a.getActivity()).startSupportActionMode(this.a.a.p));
                     this.a.notifyItemRangeChanged(0, this.a.a.c.getItemCount(), this.a.a.p);
                  } else {
                     this.a.notifyItemChanged(var2x, this.a.f);
                  }

                  this.a.a.p().s();
               }

               this.a.a.a(var2x);
               return true;
            }
         };
         this.e = var2;
         this.f = var4;
         this.d = SharedPreferencesUtil.g(var2.getActivity().getApplicationContext());
      }

      private int a(View var1) {
         int var2;
         if (var1 == null) {
            var2 = -1;
         } else {
            int var3 = this.a.list.getChildAdapterPosition(var1);
            var2 = var3;
            if (var3 == -1) {
               try {
                  var2 = this.a.list.getChildViewHolder(var1).getAdapterPosition();
               } catch (Exception var4) {
                  Crashlytics.a(var4);
                  var2 = var3;
               }
            }
         }

         return var2;
      }

      private int b(int var1) {
         byte var4 = 0;
         if (!MediaFragment.ModesHelper.a()) {
            var1 = 1;
         } else {
            int var2 = MediaFragment.ModesHelper.b();
            if (this.d() && MediaFragment.ModesHelper.a()) {
               Iterator var7 = this.g.entrySet().iterator();

               while (true) {
                  if (!var7.hasNext()) {
                     var1 = var2;
                     break;
                  }

                  MediaFragment.HeaderItem var8 = (MediaFragment.HeaderItem)((Entry)var7.next()).getValue();
                  if (var8.d <= var1 && var1 <= var8.e) {
                     int var5 = var1 - var8.d;
                     int var3 = var8.e - var8.d + 1;
                     var1 = var3 / 3;
                     int var6 = var3 % 3;
                     if (var6 == 2) {
                        var1 = 3;
                     } else if (var3 < 5) {
                        var1 = var3;
                     } else if (var6 == 1) {
                        var1 = 5;
                     } else if (var6 == 0) {
                        if (var1 == 2) {
                           var1 = 4;
                        } else {
                           var1 = 0;
                        }
                     } else {
                        var1 = 0;
                     }

                     if (var5 >= --var1 && var3 > 4) {
                        var1 = var2 / 3;
                     } else {
                        if (var3 > 4) {
                           var3 = var1;
                        }

                        byte var13;
                        if (var3 % 2 == 0) {
                           var13 = var4;
                        } else {
                           var13 = 1;
                        }

                        if (var5 >= var13) {
                           var1 = var2 / 2;
                        } else {
                           var1 = var2;
                        }
                     }
                     break;
                  }
               }
            } else {
               var1 = var2;
            }
         }

         return var1;
      }

      private boolean d() {
         boolean var1;
         if (this.g != null && this.g.size() != 0 && this.c()) {
            var1 = true;
         } else {
            var1 = false;
         }

         return var1;
      }

      public int a(int var1) {
         if (!this.d()) {
            var1 = -1;
         } else {
            Iterator var2 = this.g.entrySet().iterator();

            while (true) {
               if (!var2.hasNext()) {
                  var1 = -1;
                  break;
               }

               MediaFragment.HeaderItem var3 = (MediaFragment.HeaderItem)((Entry)var2.next()).getValue();
               if (var3.d <= var1 && var1 <= var3.e) {
                  var1 -= var3.a;
                  break;
               }
            }
         }

         return var1;
      }

      @Override
      public void a(RecyclerView.ViewHolder var1, Cursor var2) {
         if (var1 instanceof MediaFragment.PhotoItemViewHolder) {
            EntityData.a(var1.itemView.getContext());
            Media var3 = EntityData.c(var2);
            ((MediaFragment.PhotoItemViewHolder)var1).a(this.e.list.getWidth(), var3, this.d);
         }
      }

      public void a(Map<Integer, MediaFragment.HeaderItem> var1) {
         this.g.clear();
         this.g.putAll(var1);
      }

      @Override
      public int getItemCount() {
         int var1;
         if (!this.d()) {
            var1 = 0;
         } else {
            var1 = super.getItemCount() + this.g.size();
         }

         return var1;
      }

      @Override
      public int getItemViewType(int var1) {
         if (!this.d()) {
            var1 = -1;
         } else {
            Iterator var2 = this.g.entrySet().iterator();

            while (true) {
               if (!var2.hasNext()) {
                  var1 = -1;
                  break;
               }

               Entry var3 = (Entry)var2.next();
               MediaFragment.HeaderItem var4 = (MediaFragment.HeaderItem)var3.getValue();
               if ((Integer)var3.getKey() == var1) {
                  var1 = MediaFragment.ViewType.header.ordinal();
                  break;
               }

               if (var4.d <= var1 && var1 <= var4.e) {
                  var1 = MediaFragment.ViewType.media.ordinal();
                  break;
               }
            }
         }

         return var1;
      }

      @Override
      public void onBindViewHolder(RecyclerView.ViewHolder var1, int var2) {
         if (this.d() && this.getItemViewType(var2) != -1) {
            MediaFragment.ViewType var4 = MediaFragment.ViewType.values()[this.getItemViewType(var2)];
            switch (<unrepresentable>.a[var4.ordinal()]) {
               case 1:
                  ((MediaFragment.HeaderViewHolder)var1).a(this.g.get(var2));
                  break;
               case 2:
                  int var3 = this.a(var2);
                  var2 = this.b(var2);
                  if (var3 != -1) {
                     ((MediaFragment.PhotoItemViewHolder)var1).a(var2);
                     super.onBindViewHolder(var1, var3);
                  }
            }
         }
      }

      @Override
      public void onBindViewHolder(RecyclerView.ViewHolder var1, int var2, List<Object> var3) {
         if (this.d() && this.getItemViewType(var2) != -1) {
            if (var3 != null && !var3.isEmpty()) {
               MediaFragment.ViewType var4 = MediaFragment.ViewType.values()[this.getItemViewType(var2)];
               switch (<unrepresentable>.a[var4.ordinal()]) {
                  case 1:
                     if (var3.get(0) instanceof ActionMode.Callback) {
                        ((MediaFragment.HeaderViewHolder)var1).a();
                     }
                     break;
                  case 2:
                     if (var3.get(0) instanceof MediaFragment.PhotoSelector) {
                        ((MediaFragment.PhotoItemViewHolder)var1).a();
                     }

                     if (var3.get(0) instanceof ActionMode.Callback) {
                        ((MediaFragment.PhotoItemViewHolder)var1).a(true);
                        ((MediaFragment.PhotoItemViewHolder)var1).a();
                     }
               }
            } else {
               this.onBindViewHolder(var1, var2);
            }
         }
      }

      @Override
      public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup var1, int var2) {
         View var3 = null;
         RecyclerView.ViewHolder var5;
         if (this.d() && var2 != -1) {
            MediaFragment.ViewType var4 = MediaFragment.ViewType.values()[var2];
            switch (<unrepresentable>.a[var4.ordinal()]) {
               case 1:
                  LayoutInflater var9 = LayoutInflater.from(var1.getContext());
                  if (MediaFragment.ModesHelper.a()) {
                     var2 = 2131427546;
                  } else {
                     var2 = 2131427507;
                  }

                  View var6 = var9.inflate(var2, var1, false);
                  var5 = this.a.new HeaderViewHolder(this.a, var6, this.h);
                  break;
               case 2:
                  var3 = LayoutInflater.from(var1.getContext()).inflate(2131427527, var1, false);
                  var5 = new MediaFragment.PhotoItemViewHolder(this.e, var3, this.f, true);
                  var3.setOnClickListener(this.i);
                  var3.setOnLongClickListener(this.j);
                  break;
               default:
                  var5 = var3;
            }
         } else {
            var5 = new MediaFragment.EmptyViewHolder(new View(var1.getContext()));
         }

         return var5;
      }
   }

   class PaginationAsyncTask extends AsyncTask<Void, Void, Void> {
      final MediaFragment a;

      PaginationAsyncTask(MediaFragment var1) {
         this.a = var1;
      }

      protected Void a(Void... param1) {
         // $VF: Couldn't be decompiled
         // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
         // java.lang.RuntimeException: parsing failure!
         //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
         //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
         //
         // Bytecode:
         // 000: bipush 0
         // 001: istore 6
         // 003: aload 0
         // 004: getfield com/jibo/ui/fragment/home/MediaFragment$PaginationAsyncTask.a Lcom/jibo/ui/fragment/home/MediaFragment;
         // 007: invokestatic com/jibo/ui/fragment/home/MediaFragment.l (Lcom/jibo/ui/fragment/home/MediaFragment;)Ljava/util/Map;
         // 00a: invokeinterface java/util/Map.keySet ()Ljava/util/Set; 1
         // 00f: invokeinterface java/util/Set.iterator ()Ljava/util/Iterator; 1
         // 014: astore 9
         // 016: bipush 0
         // 017: istore 2
         // 018: aconst_null
         // 019: astore 1
         // 01a: aload 9
         // 01c: invokeinterface java/util/Iterator.hasNext ()Z 1
         // 021: ifeq 26e
         // 024: aload 9
         // 026: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
         // 02b: checkcast java/lang/String
         // 02e: astore 8
         // 030: aload 0
         // 031: invokevirtual com/jibo/ui/fragment/home/MediaFragment$PaginationAsyncTask.isCancelled ()Z
         // 034: ifne 041
         // 037: aload 0
         // 038: getfield com/jibo/ui/fragment/home/MediaFragment$PaginationAsyncTask.a Lcom/jibo/ui/fragment/home/MediaFragment;
         // 03b: invokevirtual com/jibo/ui/fragment/home/MediaFragment.d ()Z
         // 03e: ifne 043
         // 041: aconst_null
         // 042: areturn
         // 043: aload 0
         // 044: getfield com/jibo/ui/fragment/home/MediaFragment$PaginationAsyncTask.a Lcom/jibo/ui/fragment/home/MediaFragment;
         // 047: invokevirtual com/jibo/ui/fragment/home/MediaFragment.getActivity ()Landroid/support/v4/app/FragmentActivity;
         // 04a: invokevirtual android/support/v4/app/FragmentActivity.getContentResolver ()Landroid/content/ContentResolver;
         // 04d: getstatic com/jibo/db/DatabaseContract$MediaEntry.b Landroid/net/Uri;
         // 050: bipush 2
         // 051: anewarray 51
         // 054: dup
         // 055: bipush 0
         // 056: ldc "_id"
         // 058: aastore
         // 059: dup
         // 05a: bipush 1
         // 05b: ldc "created"
         // 05d: aastore
         // 05e: ldc "loopId = ?"
         // 060: bipush 1
         // 061: anewarray 51
         // 064: dup
         // 065: bipush 0
         // 066: aload 8
         // 068: aastore
         // 069: ldc "created ASC LIMIT 1"
         // 06b: invokevirtual android/content/ContentResolver.query (Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
         // 06e: astore 7
         // 070: iload 2
         // 071: istore 5
         // 073: aload 7
         // 075: ifnull 1fe
         // 078: iload 2
         // 079: istore 5
         // 07b: iload 2
         // 07c: istore 3
         // 07d: iload 2
         // 07e: istore 4
         // 080: aload 7
         // 082: astore 1
         // 083: aload 7
         // 085: invokeinterface android/database/Cursor.isClosed ()Z 1
         // 08a: ifne 1fe
         // 08d: iload 2
         // 08e: istore 5
         // 090: iload 2
         // 091: istore 3
         // 092: iload 2
         // 093: istore 4
         // 095: aload 7
         // 097: astore 1
         // 098: aload 7
         // 09a: invokeinterface android/database/Cursor.moveToFirst ()Z 1
         // 09f: ifeq 1fe
         // 0a2: iload 2
         // 0a3: istore 3
         // 0a4: iload 2
         // 0a5: istore 4
         // 0a7: aload 7
         // 0a9: astore 1
         // 0aa: aload 0
         // 0ab: getfield com/jibo/ui/fragment/home/MediaFragment$PaginationAsyncTask.a Lcom/jibo/ui/fragment/home/MediaFragment;
         // 0ae: invokevirtual com/jibo/ui/fragment/home/MediaFragment.getActivity ()Landroid/support/v4/app/FragmentActivity;
         // 0b1: invokestatic com/jibo/db/EntityData.a (Landroid/content/Context;)Lcom/jibo/db/EntityData;
         // 0b4: invokevirtual com/jibo/db/EntityData.e ()Lcom/jibo/aws/integration/aws/services/media/JiboMediaAsyncClient;
         // 0b7: bipush 1
         // 0b8: anewarray 51
         // 0bb: dup
         // 0bc: bipush 0
         // 0bd: aload 8
         // 0bf: aastore
         // 0c0: invokestatic java/util/Arrays.asList ([Ljava/lang/Object;)Ljava/util/List;
         // 0c3: aconst_null
         // 0c4: aload 7
         // 0c6: bipush 1
         // 0c7: invokeinterface android/database/Cursor.getLong (I)J 2
         // 0cc: invokestatic java/lang/Long.valueOf (J)Ljava/lang/Long;
         // 0cf: invokevirtual com/jibo/aws/integration/aws/services/media/JiboMediaAsyncClient.list (Ljava/util/List;Ljava/lang/Long;Ljava/lang/Long;)Ljava/util/List;
         // 0d2: astore 8
         // 0d4: iload 2
         // 0d5: istore 3
         // 0d6: iload 2
         // 0d7: istore 4
         // 0d9: aload 7
         // 0db: astore 1
         // 0dc: aload 0
         // 0dd: invokevirtual com/jibo/ui/fragment/home/MediaFragment$PaginationAsyncTask.isCancelled ()Z
         // 0e0: ifne 0f5
         // 0e3: iload 2
         // 0e4: istore 3
         // 0e5: iload 2
         // 0e6: istore 4
         // 0e8: aload 7
         // 0ea: astore 1
         // 0eb: aload 0
         // 0ec: getfield com/jibo/ui/fragment/home/MediaFragment$PaginationAsyncTask.a Lcom/jibo/ui/fragment/home/MediaFragment;
         // 0ef: invokevirtual com/jibo/ui/fragment/home/MediaFragment.d ()Z
         // 0f2: ifne 113
         // 0f5: iload 2
         // 0f6: istore 3
         // 0f7: iload 2
         // 0f8: istore 4
         // 0fa: aload 7
         // 0fc: astore 1
         // 0fd: aload 7
         // 0ff: invokeinterface android/database/Cursor.close ()V 1
         // 104: aload 7
         // 106: ifnull 041
         // 109: aload 7
         // 10b: invokeinterface android/database/Cursor.close ()V 1
         // 110: goto 041
         // 113: iload 2
         // 114: istore 5
         // 116: aload 8
         // 118: ifnull 1fe
         // 11b: iload 2
         // 11c: istore 5
         // 11e: iload 2
         // 11f: istore 3
         // 120: iload 2
         // 121: istore 4
         // 123: aload 7
         // 125: astore 1
         // 126: aload 8
         // 128: invokeinterface java/util/List.isEmpty ()Z 1
         // 12d: ifne 1fe
         // 130: iload 2
         // 131: istore 3
         // 132: iload 2
         // 133: istore 4
         // 135: aload 7
         // 137: astore 1
         // 138: iload 2
         // 139: aload 8
         // 13b: invokeinterface java/util/List.size ()I 1
         // 140: iadd
         // 141: istore 5
         // 143: iload 5
         // 145: istore 3
         // 146: iload 5
         // 148: istore 4
         // 14a: aload 7
         // 14c: astore 1
         // 14d: aload 0
         // 14e: invokevirtual com/jibo/ui/fragment/home/MediaFragment$PaginationAsyncTask.isCancelled ()Z
         // 151: ifne 168
         // 154: iload 5
         // 156: istore 3
         // 157: iload 5
         // 159: istore 4
         // 15b: aload 7
         // 15d: astore 1
         // 15e: aload 0
         // 15f: getfield com/jibo/ui/fragment/home/MediaFragment$PaginationAsyncTask.a Lcom/jibo/ui/fragment/home/MediaFragment;
         // 162: invokevirtual com/jibo/ui/fragment/home/MediaFragment.d ()Z
         // 165: ifne 188
         // 168: iload 5
         // 16a: istore 3
         // 16b: iload 5
         // 16d: istore 4
         // 16f: aload 7
         // 171: astore 1
         // 172: aload 7
         // 174: invokeinterface android/database/Cursor.close ()V 1
         // 179: aload 7
         // 17b: ifnull 041
         // 17e: aload 7
         // 180: invokeinterface android/database/Cursor.close ()V 1
         // 185: goto 041
         // 188: iload 5
         // 18a: istore 3
         // 18b: iload 5
         // 18d: istore 4
         // 18f: aload 7
         // 191: astore 1
         // 192: aload 0
         // 193: getfield com/jibo/ui/fragment/home/MediaFragment$PaginationAsyncTask.a Lcom/jibo/ui/fragment/home/MediaFragment;
         // 196: invokevirtual com/jibo/ui/fragment/home/MediaFragment.getActivity ()Landroid/support/v4/app/FragmentActivity;
         // 199: invokestatic com/jibo/db/EntityData.a (Landroid/content/Context;)Lcom/jibo/db/EntityData;
         // 19c: aload 8
         // 19e: bipush 0
         // 19f: invokevirtual com/jibo/db/EntityData.a (Ljava/util/List;Z)V
         // 1a2: iload 5
         // 1a4: istore 3
         // 1a5: iload 5
         // 1a7: istore 4
         // 1a9: aload 7
         // 1ab: astore 1
         // 1ac: aload 0
         // 1ad: invokevirtual com/jibo/ui/fragment/home/MediaFragment$PaginationAsyncTask.isCancelled ()Z
         // 1b0: ifne 1c7
         // 1b3: iload 5
         // 1b5: istore 3
         // 1b6: iload 5
         // 1b8: istore 4
         // 1ba: aload 7
         // 1bc: astore 1
         // 1bd: aload 0
         // 1be: getfield com/jibo/ui/fragment/home/MediaFragment$PaginationAsyncTask.a Lcom/jibo/ui/fragment/home/MediaFragment;
         // 1c1: invokevirtual com/jibo/ui/fragment/home/MediaFragment.d ()Z
         // 1c4: ifne 1e7
         // 1c7: iload 5
         // 1c9: istore 3
         // 1ca: iload 5
         // 1cc: istore 4
         // 1ce: aload 7
         // 1d0: astore 1
         // 1d1: aload 7
         // 1d3: invokeinterface android/database/Cursor.close ()V 1
         // 1d8: aload 7
         // 1da: ifnull 041
         // 1dd: aload 7
         // 1df: invokeinterface android/database/Cursor.close ()V 1
         // 1e4: goto 041
         // 1e7: iload 5
         // 1e9: istore 3
         // 1ea: iload 5
         // 1ec: istore 4
         // 1ee: aload 7
         // 1f0: astore 1
         // 1f1: aload 0
         // 1f2: getfield com/jibo/ui/fragment/home/MediaFragment$PaginationAsyncTask.a Lcom/jibo/ui/fragment/home/MediaFragment;
         // 1f5: invokevirtual com/jibo/ui/fragment/home/MediaFragment.getActivity ()Landroid/support/v4/app/FragmentActivity;
         // 1f8: invokestatic com/jibo/db/EntityData.a (Landroid/content/Context;)Lcom/jibo/db/EntityData;
         // 1fb: invokevirtual com/jibo/db/EntityData.j ()V
         // 1fe: iload 5
         // 200: istore 2
         // 201: aload 7
         // 203: astore 1
         // 204: aload 7
         // 206: ifnull 215
         // 209: aload 7
         // 20b: invokeinterface android/database/Cursor.close ()V 1
         // 210: aconst_null
         // 211: astore 1
         // 212: iload 5
         // 214: istore 2
         // 215: goto 01a
         // 218: astore 8
         // 21a: aload 7
         // 21c: astore 1
         // 21d: aload 8
         // 21f: invokestatic com/crashlytics/android/Crashlytics.a (Ljava/lang/Throwable;)V
         // 222: iload 3
         // 223: istore 2
         // 224: aload 7
         // 226: astore 1
         // 227: aload 7
         // 229: ifnull 215
         // 22c: aload 7
         // 22e: invokeinterface android/database/Cursor.close ()V 1
         // 233: aconst_null
         // 234: astore 1
         // 235: iload 3
         // 236: istore 2
         // 237: goto 215
         // 23a: astore 8
         // 23c: iload 4
         // 23e: istore 3
         // 23f: aload 7
         // 241: astore 1
         // 242: aload 8
         // 244: invokestatic com/crashlytics/android/Crashlytics.a (Ljava/lang/Throwable;)V
         // 247: iload 3
         // 248: istore 2
         // 249: aload 7
         // 24b: astore 1
         // 24c: aload 7
         // 24e: ifnull 215
         // 251: aload 7
         // 253: invokeinterface android/database/Cursor.close ()V 1
         // 258: aconst_null
         // 259: astore 1
         // 25a: iload 3
         // 25b: istore 2
         // 25c: goto 215
         // 25f: astore 7
         // 261: aload 1
         // 262: ifnull 26b
         // 265: aload 1
         // 266: invokeinterface android/database/Cursor.close ()V 1
         // 26b: aload 7
         // 26d: athrow
         // 26e: aload 0
         // 26f: getfield com/jibo/ui/fragment/home/MediaFragment$PaginationAsyncTask.a Lcom/jibo/ui/fragment/home/MediaFragment;
         // 272: astore 1
         // 273: iload 2
         // 274: ifle 27a
         // 277: bipush 1
         // 278: istore 6
         // 27a: aload 1
         // 27b: iload 6
         // 27d: invokestatic com/jibo/ui/fragment/home/MediaFragment.b (Lcom/jibo/ui/fragment/home/MediaFragment;Z)Z
         // 280: pop
         // 281: goto 041
         // 284: astore 7
         // 286: goto 261
         // 289: astore 8
         // 28b: iload 2
         // 28c: istore 3
         // 28d: aload 1
         // 28e: astore 7
         // 290: goto 23f
         // 293: astore 8
         // 295: iload 2
         // 296: istore 3
         // 297: aload 1
         // 298: astore 7
         // 29a: goto 21a
         // try (28 -> 53): 328 com/amazonaws/AmazonServiceException
         // try (28 -> 53): 322 java/lang/Exception
         // try (28 -> 53): 320 null
         // try (65 -> 68): 263 com/amazonaws/AmazonServiceException
         // try (65 -> 68): 281 java/lang/Exception
         // try (65 -> 68): 301 null
         // try (76 -> 79): 263 com/amazonaws/AmazonServiceException
         // try (76 -> 79): 281 java/lang/Exception
         // try (76 -> 79): 301 null
         // try (85 -> 104): 263 com/amazonaws/AmazonServiceException
         // try (85 -> 104): 281 java/lang/Exception
         // try (85 -> 104): 301 null
         // try (110 -> 113): 263 com/amazonaws/AmazonServiceException
         // try (110 -> 113): 281 java/lang/Exception
         // try (110 -> 113): 301 null
         // try (119 -> 123): 263 com/amazonaws/AmazonServiceException
         // try (119 -> 123): 281 java/lang/Exception
         // try (119 -> 123): 301 null
         // try (129 -> 131): 263 com/amazonaws/AmazonServiceException
         // try (129 -> 131): 281 java/lang/Exception
         // try (129 -> 131): 301 null
         // try (148 -> 151): 263 com/amazonaws/AmazonServiceException
         // try (148 -> 151): 281 java/lang/Exception
         // try (148 -> 151): 301 null
         // try (157 -> 162): 263 com/amazonaws/AmazonServiceException
         // try (157 -> 162): 281 java/lang/Exception
         // try (157 -> 162): 301 null
         // try (168 -> 171): 263 com/amazonaws/AmazonServiceException
         // try (168 -> 171): 281 java/lang/Exception
         // try (168 -> 171): 301 null
         // try (177 -> 181): 263 com/amazonaws/AmazonServiceException
         // try (177 -> 181): 281 java/lang/Exception
         // try (177 -> 181): 301 null
         // try (187 -> 189): 263 com/amazonaws/AmazonServiceException
         // try (187 -> 189): 281 java/lang/Exception
         // try (187 -> 189): 301 null
         // try (200 -> 207): 263 com/amazonaws/AmazonServiceException
         // try (200 -> 207): 281 java/lang/Exception
         // try (200 -> 207): 301 null
         // try (213 -> 216): 263 com/amazonaws/AmazonServiceException
         // try (213 -> 216): 281 java/lang/Exception
         // try (213 -> 216): 301 null
         // try (222 -> 226): 263 com/amazonaws/AmazonServiceException
         // try (222 -> 226): 281 java/lang/Exception
         // try (222 -> 226): 301 null
         // try (232 -> 234): 263 com/amazonaws/AmazonServiceException
         // try (232 -> 234): 281 java/lang/Exception
         // try (232 -> 234): 301 null
         // try (245 -> 250): 263 com/amazonaws/AmazonServiceException
         // try (245 -> 250): 281 java/lang/Exception
         // try (245 -> 250): 301 null
         // try (266 -> 268): 301 null
         // try (286 -> 288): 301 null
      }

      protected void a(Void var1) {
         if (!this.isCancelled() && this.a.d()) {
            this.a.r = false;
            this.a.progressView.setVisibility(4);
         }
      }

      protected void onPreExecute() {
         if (!this.isCancelled() && this.a.d()) {
            this.a.progressView.setVisibility(0);
         }
      }
   }

   static class PhotoItemViewHolder extends RecyclerView.ViewHolder {
      private MediaFragment a;
      private MediaFragment.PhotoSelector b;
      private boolean c;
      @BindView
      public TextView checkbox;
      private Media d;
      private int e;
      private float f;
      private float g;
      @BindView
      public ImageView photo;

      public PhotoItemViewHolder(MediaFragment var1, View var2, MediaFragment.PhotoSelector var3, boolean var4) {
         super(var2);
         this.a = var1;
         this.b = var3;
         this.c = var4;
         ButterKnife.a(this, var2);
         if (this.c) {
            int var5 = this.a.list.getWidth() / MediaFragment.ModesHelper.b() / 15;
            LayoutParams var6 = (LayoutParams)this.checkbox.getLayoutParams();
            var6.setMargins(var5, var5, 0, 0);
            this.checkbox.setLayoutParams(var6);
         }
      }

      public void a() {
         float var2 = 1.0F;
         if (this.c) {
            if (this.b.a(this.getAdapterPosition()) != this.checkbox.isSelected()) {
               ViewPropertyAnimator var3 = this.photo.animate().setDuration(200L);
               float var1;
               if (this.b.a(this.getAdapterPosition())) {
                  var1 = this.f;
               } else {
                  var1 = 1.0F;
               }

               var3 = var3.scaleX(var1);
               var1 = var2;
               if (this.b.a(this.getAdapterPosition())) {
                  var1 = this.g;
               }

               var3.scaleY(var1).start();
            }

            this.checkbox.setSelected(this.b.a(this.getAdapterPosition()));
         }
      }

      public void a(int var1) {
         this.e = var1;
      }

      public void a(int var1, Media var2, boolean var3) {
         this.d = var2;
         this.itemView.setTag(this.d);
         int var4 = MediaFragment.ModesHelper.b() / this.e;
         var4 = (var1 - (var4 + 1) * 2 * this.itemView.getResources().getDimensionPixelOffset(2131165411)) / var4;
         var1 = (int)(var4 / MediaFragment.ModesHelper.c());
         this.f = (var4 - this.itemView.getContext().getResources().getDimension(2131165265)) / var4;
         this.g = (var1 - this.itemView.getContext().getResources().getDimension(2131165267)) / var1;
         LayoutParams var6 = new LayoutParams(var4, var1);
         this.photo.setLayoutParams(var6);
         this.photo.requestLayout();
         this.a(false);
         String var7 = MediaHelper.getUrl(var3, this.d);
         Glide.b(this.itemView.getContext()).a(var7).a(new RequestListener<String, GlideDrawable>(this) {
            final MediaFragment.PhotoItemViewHolder a;

            {
               this.a = var1;
            }

            public boolean a(GlideDrawable var1, String var2x, Target<GlideDrawable> var3x, boolean var4x, boolean var5) {
               return false;
            }

            public boolean a(Exception var1, String var2x, Target<GlideDrawable> var3x, boolean var4x) {
               this.a.a.a(new Runnable(this) {
                  final <unrepresentable> a;

                  {
                     this.a = var1;
                  }

                  @Override
                  public void run() {
                     this.a.a.photo.setImageBitmap(null);
                  }
               });
               return false;
            }
         }).a().d().a(DiskCacheStrategy.ALL).a(this.photo);
      }

      public void a(boolean var1) {
         long var4 = 200L;
         float var3 = 1.0F;
         if (this.c) {
            if (this.a.p().r() != null) {
               this.checkbox.setSelected(this.b.a(this.getAdapterPosition()));
               this.checkbox.setVisibility(0);
               ViewPropertyAnimator var6 = this.photo.animate();
               if (!var1) {
                  var4 = 0L;
               }

               var6 = var6.setDuration(var4);
               float var2;
               if (this.checkbox.isSelected()) {
                  var2 = this.f;
               } else {
                  var2 = 1.0F;
               }

               var6 = var6.scaleX(var2);
               var2 = var3;
               if (this.checkbox.isSelected()) {
                  var2 = this.g;
               }

               var6.scaleY(var2).start();
            } else {
               this.checkbox.setVisibility(4);
               ViewPropertyAnimator var10 = this.photo.animate();
               if (!var1) {
                  var4 = 0L;
               }

               var10.setDuration(var4).scaleX(1.0F).scaleY(1.0F).start();
            }
         }
      }
   }

   private static class PhotoSelector {
      private SparseBooleanArray a = new SparseBooleanArray();

      private PhotoSelector() {
      }

      public int a() {
         int var2 = 0;
         int var1 = 0;

         while (var2 < this.a.size()) {
            int var3 = var1;
            if (this.a.valueAt(var2)) {
               var3 = var1 + 1;
            }

            var2++;
            var1 = var3;
         }

         return var1;
      }

      public void a(int var1, boolean var2) {
         this.a.put(var1, var2);
      }

      public boolean a(int var1) {
         return this.a.get(var1, false);
      }

      public void b() {
         this.a.clear();
      }

      public SparseBooleanArray c() {
         return this.a;
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
         var1.set(this.a, this.a, this.a, this.a);
      }
   }

   enum ViewType {
      header,
      media,
      pagination;

      private static final MediaFragment.ViewType[] $VALUES = new MediaFragment.ViewType[]{
         MediaFragment.ViewType.header, MediaFragment.ViewType.media, MediaFragment.ViewType.pagination
      };
   }
}
