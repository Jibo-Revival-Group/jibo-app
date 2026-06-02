package com.jibo.ui.fragment.tips;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.bignerdranch.expandablerecyclerview.ChildViewHolder;
import com.bignerdranch.expandablerecyclerview.ExpandableRecyclerAdapter;
import com.bignerdranch.expandablerecyclerview.ParentViewHolder;
import com.bignerdranch.expandablerecyclerview.model.Parent;
import com.bumptech.glide.Glide;
import com.jibo.ui.activity.TipVideoActivity;
import com.jibo.ui.activity.TipsActivity;
import com.jibo.ui.fragment.BaseFragment;
import com.jibo.utils.ImageUtils;
import com.jibo.utils.SharedPreferencesUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TipsFragment extends BaseFragment {
   protected List<TipsFragment.Tip> a = new ArrayList<>();
   private RecyclerView.Adapter b;
   private int c;
   private String d;
   private CountDownTimer e;
   @BindView
   RecyclerView list;

   private void b() {
      this.e = (new CountDownTimer(this, 5000L, 5000L) {
         final TipsFragment a;

         {
            this.a = var1;
         }

         public void onFinish() {
            ((ExpandableRecyclerAdapter)this.a.b).e(0);
            this.a.a.get(0).a(false);
         }

         public void onTick(long var1) {
         }
      }).start();
   }

   private void q() {
      this.a.get(0).a(false);
      if (this.e != null) {
         this.e.cancel();
         this.e = null;
      }
   }

   protected RecyclerView.Adapter a() {
      RecyclerView.Adapter var1;
      if ("TAG_TIP4".equals(this.d)) {
         if (SharedPreferencesUtil.i(this.getContext())) {
            this.a.get(0).a(true);
            this.b();
            SharedPreferencesUtil.j(this.getContext());
         }

         var1 = new TipsFragment.ExpandableTipsAdapter(this, this.a);
      } else if ("TAG_TIP5".equals(this.d)) {
         var1 = new TipsFragment.TipVideoAdapter(this);
      } else {
         var1 = new TipsFragment.TipAdapter(this);
      }

      return var1;
   }

   @Override
   protected void a(ActionBar var1) {
      super.a(var1);
      var1.setDisplayHomeAsUpEnabled(true);
   }

   @Override
   protected String o() {
      return this.getString(this.c);
   }

   @Override
   public void onCreate(Bundle var1) {
      super.onCreate(var1);
      this.d = "TAG_TIP1";
      if (this.getArguments() != null) {
         this.d = this.getArguments().getString("ARGS_TAG");
      }

      this.setHasOptionsMenu(true);
   }

   @Override
   public void onCreateOptionsMenu(Menu var1, MenuInflater var2) {
      var2.inflate(2131492873, var1);
      super.onCreateOptionsMenu(var1, var2);
   }

   @Override
   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      return var1.inflate(2131427475, var2, false);
   }

   @Override
   public boolean onOptionsItemSelected(MenuItem var1) {
      boolean var2;
      if (2131296309 == var1.getItemId()) {
         this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(this.getString(2131755752))));
         var2 = true;
      } else {
         var2 = super.onOptionsItemSelected(var1);
      }

      return var2;
   }

   @Override
   public void onViewCreated(View var1, Bundle var2) {
      super.onViewCreated(var1, var2);
      LinearLayoutManager var3 = new LinearLayoutManager(this.getActivity(), 1, false);
      this.list.setHasFixedSize(true);
      this.list.setItemAnimator(new DefaultItemAnimator());
      this.list.setLayoutManager(var3);
      this.c = TipsContent.a(this.d);
      this.a = TipsContent.b(this.d);
      ((TipsActivity)this.getActivity()).a(TipsContent.c(this.d));
      this.b = this.a();
      this.list.setAdapter(this.b);
   }

   private class ExpandableTipsAdapter extends ExpandableRecyclerAdapter<TipsFragment.Tip, Integer, ParentViewHolder, TipsFragment.TipChildViewHolder> {
      final TipsFragment b;
      private final LayoutInflater c;

      public ExpandableTipsAdapter(TipsFragment var1, List var2) {
         super(var2);
         this.b = var1;
         this.c = LayoutInflater.from(var1.getContext());
      }

      @Override
      public int a(int var1) {
         if (this.b.a.get(var1) instanceof TipsFragment.NextButtonTip) {
            var1 = 4;
         } else {
            var1 = super.a(var1);
         }

         return var1;
      }

      @Override
      public ParentViewHolder a(ViewGroup var1, int var2) {
         ParentViewHolder var4;
         if (var2 == 4) {
            View var3 = this.c.inflate(2131427548, var1, false);
            var4 = this.b.new NextButtonViewHolder(this.b, var3);
         } else {
            View var5 = this.c.inflate(2131427552, var1, false);
            var4 = this.b.new TipHeaderViewHolder(this.b, var5);
         }

         return var4;
      }

      public void a(ParentViewHolder var1, int var2, TipsFragment.Tip var3) {
         if (var1 instanceof TipsFragment.TipHeaderViewHolder) {
            ((TipsFragment.TipHeaderViewHolder)var1).a(var3);
         } else if (var1 instanceof TipsFragment.NextButtonViewHolder) {
            ((TipsFragment.NextButtonViewHolder)var1).f();
         }
      }

      public void a(TipsFragment.TipChildViewHolder var1, int var2, int var3, Integer var4) {
         boolean var5;
         if (this.a().get(var2).a().size() - 1 == var3) {
            var5 = true;
         } else {
            var5 = false;
         }

         var1.a(var4, var5);
      }

      @Override
      public boolean b(int var1) {
         boolean var2;
         if (var1 == 4) {
            var2 = true;
         } else {
            var2 = super.b(var1);
         }

         return var2;
      }

      public TipsFragment.TipChildViewHolder c(ViewGroup var1, int var2) {
         View var3 = this.c.inflate(2131427551, var1, false);
         return this.b.new TipChildViewHolder(this.b, var3);
      }
   }

   public static class NextButtonTip extends TipsFragment.Tip {
      public NextButtonTip() {
         super(-1, -1);
      }
   }

   class NextButtonViewHolder extends ParentViewHolder {
      final TipsFragment c;
      private final int d;
      private final int e;
      @BindView
      Button nextButton;

      public NextButtonViewHolder(TipsFragment var1, View var2) {
         super(var2);
         this.c = var1;
         this.d = TipsListFragment.a.size();
         this.e = this.d - 1;
         ButterKnife.a(this, var2);
      }

      private void f() {
         int var1 = TipsListFragment.a.indexOf(this.c.d);
         int var2 = this.d;
         String var3 = this.c.getString(TipsContent.a(TipsListFragment.a.get((var1 + 1) % var2)));
         if (var1 == this.e) {
            this.nextButton.setText(this.c.getString(2131755070));
         } else {
            this.nextButton.setText(this.c.getString(2131756009, var3));
         }
      }

      @OnClick
      public void next(View var1) {
         int var3 = TipsListFragment.a.indexOf(this.c.d);
         int var2 = this.d;
         if (var3 == this.e) {
            this.c.getActivity().finish();
         } else {
            this.c.d = TipsListFragment.a.get((var3 + 1) % var2);
            Intent var4 = new Intent();
            var4.setClass(this.c.getContext(), TipsActivity.class);
            var4.putExtra("ARGS_TAG", this.c.d);
            this.c.startActivity(var4);
            this.c.getActivity().finish();
         }
      }
   }

   private class SeparatorViewHolder extends RecyclerView.ViewHolder {
      final TipsFragment a;

      public SeparatorViewHolder(TipsFragment var1, View var2) {
         super(var2);
         this.a = var1;
      }
   }

   public static class Tip implements Parent<Integer> {
      private int a;
      private int b;
      private int c;
      private int d = -1;
      private int e = -1;
      private int f;
      private List<Integer> g = null;
      private boolean h = false;

      public Tip(int var1, int var2) {
         this.a = var1;
         this.c = var2;
      }

      public Tip(int var1, int var2, int var3, int var4) {
         this(var1, var2);
         this.d = var3;
         this.e = var4;
      }

      public Tip(int var1, int var2, int var3, int var4, List<Integer> var5) {
         this.a = var1;
         this.b = var2;
         this.c = var3;
         this.f = var4;
         this.g = var5;
      }

      @Override
      public List<Integer> a() {
         List var1;
         if (this.g != null) {
            var1 = this.g;
         } else {
            var1 = Collections.EMPTY_LIST;
         }

         return var1;
      }

      public void a(boolean var1) {
         this.h = var1;
      }

      @Override
      public boolean b() {
         return this.h;
      }

      public int c() {
         return this.a;
      }

      public int d() {
         return this.c;
      }

      public int e() {
         return this.d;
      }

      public int f() {
         return this.e;
      }

      public int g() {
         return this.f;
      }

      public int h() {
         return this.b;
      }
   }

   private class TipAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
      final TipsFragment a;

      private TipAdapter(TipsFragment var1) {
         this.a = var1;
      }

      @Override
      public int getItemCount() {
         return this.a.a.size() + 1;
      }

      @Override
      public int getItemViewType(int var1) {
         byte var2;
         if (var1 == this.a.a.size()) {
            var2 = 2;
         } else if (this.a.a.get(var1) == null) {
            var2 = 1;
         } else {
            var2 = 0;
         }

         return var2;
      }

      @Override
      public void onBindViewHolder(RecyclerView.ViewHolder var1, int var2) {
         if (var1 instanceof TipsFragment.TipViewHolder) {
            ((TipsFragment.TipViewHolder)var1).a(this.a.a.get(var2));
         } else if (var1 instanceof TipsFragment.NextButtonViewHolder) {
            ((TipsFragment.NextButtonViewHolder)var1).f();
         }
      }

      @Override
      public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup var1, int var2) {
         RecyclerView.ViewHolder var4;
         if (var2 == 0) {
            View var3 = LayoutInflater.from(var1.getContext()).inflate(2131427547, var1, false);
            var4 = this.a.new TipViewHolder(this.a, var3);
         } else if (var2 == 2) {
            View var5 = LayoutInflater.from(var1.getContext()).inflate(2131427548, var1, false);
            var4 = this.a.new NextButtonViewHolder(this.a, var5);
         } else {
            View var6 = LayoutInflater.from(var1.getContext()).inflate(2131427549, var1, false);
            var4 = this.a.new SeparatorViewHolder(this.a, var6);
         }

         return var4;
      }
   }

   class TipChildViewHolder extends ChildViewHolder {
      final TipsFragment c;
      @BindView
      TextView text;

      public TipChildViewHolder(TipsFragment var1, View var2) {
         super(var2);
         this.c = var1;
         ButterKnife.a(this, var2);
      }

      public void a(Integer var1, boolean var2) {
         if (var2) {
            this.itemView
               .setPadding(
                  0,
                  this.itemView.getContext().getResources().getDimensionPixelSize(2131165321),
                  0,
                  this.itemView.getContext().getResources().getDimensionPixelSize(2131165263)
               );
         } else {
            this.itemView
               .setPadding(
                  0,
                  this.itemView.getContext().getResources().getDimensionPixelSize(2131165321),
                  0,
                  this.itemView.getContext().getResources().getDimensionPixelSize(2131165321)
               );
         }

         this.text.setText(var1);
      }
   }

   class TipHeaderViewHolder extends ParentViewHolder {
      final TipsFragment c;
      private TipsFragment.Tip d;
      @BindView
      ImageView icon;
      @BindView
      TextView subtitle;
      @BindView
      TextView title;

      public TipHeaderViewHolder(TipsFragment var1, View var2) {
         super(var2);
         this.c = var1;
         ButterKnife.a(this, var2);
      }

      private void f() {
         this.icon.setImageResource(this.d.d());
         this.subtitle.setTypeface(null, 0);
         this.subtitle.setTextColor(ImageUtils.b(this.itemView.getContext(), 2131099846));
         this.title.setTextColor(ImageUtils.b(this.itemView.getContext(), 2131099771));
      }

      private void g() {
         this.icon.setImageResource(this.d.g());
         this.subtitle.setTypeface(null, 1);
         this.subtitle.setTextColor(-16777216);
         this.title.setTextColor(ImageUtils.b(this.itemView.getContext(), 2131099789));
      }

      public void a(TipsFragment.Tip var1) {
         this.d = var1;
         this.title.setText(var1.c());
         this.subtitle.setText(var1.h());
         if (this.b()) {
            this.g();
         } else {
            this.f();
         }
      }

      @Override
      public void b(boolean var1) {
         super.b(var1);
         this.c.q();
         if (!var1) {
            this.g();
         } else {
            this.f();
         }
      }

      @Override
      public void onClick(View var1) {
         if (!this.b()) {
            ((TipsFragment.ExpandableTipsAdapter)this.c.list.getAdapter()).b();
         }

         super.onClick(var1);
      }
   }

   private class TipVideoAdapter extends TipsFragment.TipAdapter {
      final TipsFragment b;

      private TipVideoAdapter(TipsFragment var1) {
         super(var1);
         this.b = var1;
      }

      @Override
      public void onBindViewHolder(RecyclerView.ViewHolder var1, int var2) {
         if (this.getItemViewType(var2) == 0) {
            ((TipsFragment.TipVideoViewHolder)var1).a((TipsFragment.VideoTip)this.b.a.get(var2));
         } else {
            super.onBindViewHolder(var1, var2);
         }
      }

      @Override
      public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup var1, int var2) {
         RecyclerView.ViewHolder var4;
         if (var2 == 0) {
            View var3 = LayoutInflater.from(var1.getContext()).inflate(2131427550, var1, false);
            var4 = this.b.new TipVideoViewHolder(this.b, var3);
         } else {
            var4 = super.onCreateViewHolder(var1, var2);
         }

         return var4;
      }
   }

   class TipVideoViewHolder extends RecyclerView.ViewHolder {
      final TipsFragment a;
      @BindView
      RelativeLayout contentImage;
      @BindView
      ImageView image;
      @BindView
      TextView text;

      public TipVideoViewHolder(TipsFragment var1, View var2) {
         super(var2);
         this.a = var1;
         ButterKnife.a(this, var2);
      }

      public void a(TipsFragment.VideoTip var1) {
         this.text.setText(Html.fromHtml(this.a.getString(var1.c())));
         Glide.b(this.itemView.getContext()).a(Integer.valueOf(var1.d())).d().a(this.image);
         this.contentImage.setOnClickListener(new OnClickListener(this, var1) {
            final TipsFragment.VideoTip a;
            final TipsFragment.TipVideoViewHolder b;

            {
               this.b = var1;
               this.a = var2;
            }

            public void onClick(View var1) {
               Intent var2 = new Intent(this.b.a.getActivity(), TipVideoActivity.class);
               var2.putExtra("extra_video_url_res_id", this.a.i());
               this.b.a.startActivity(var2);
            }
         });
      }
   }

   class TipViewHolder extends RecyclerView.ViewHolder {
      final TipsFragment a;
      @BindView
      ImageView image;
      @BindView
      ImageView imageAboveTitle;
      @BindView
      TextView text;
      @BindView
      TextView title;

      public TipViewHolder(TipsFragment var1, View var2) {
         super(var2);
         this.a = var1;
         ButterKnife.a(this, var2);
      }

      public void a(TipsFragment.Tip var1) {
         byte var3 = 8;
         this.text.setText(Html.fromHtml(this.a.getString(var1.c())));
         Glide.b(this.itemView.getContext()).a(Integer.valueOf(var1.d())).d().a(this.image);
         TextView var4 = this.title;
         byte var2;
         if (var1.e() == -1) {
            var2 = 8;
         } else {
            var2 = 0;
         }

         var4.setVisibility(var2);
         if (var1.e() != -1) {
            this.title.setText(var1.e());
         }

         ImageView var6 = this.imageAboveTitle;
         if (var1.f() == -1) {
            var2 = var3;
         } else {
            var2 = 0;
         }

         var6.setVisibility(var2);
         if (var1.f() != -1) {
            Glide.b(this.itemView.getContext()).a(Integer.valueOf(var1.f())).d().a(this.imageAboveTitle);
         }
      }
   }

   public static class VideoTip extends TipsFragment.Tip {
      private int a;

      public VideoTip(int var1, int var2, int var3) {
         super(var1, var2);
         this.a = var3;
      }

      public VideoTip(int var1, int var2, int var3, int var4, int var5) {
         super(var1, var2, var3, var4);
         this.a = var5;
      }

      public int i() {
         return this.a;
      }
   }
}
