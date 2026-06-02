package com.jibo.p019ui.fragment.tips;

import android.R;
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
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.bignerdranch.expandablerecyclerview.ChildViewHolder;
import com.bignerdranch.expandablerecyclerview.ExpandableRecyclerAdapter;
import com.bignerdranch.expandablerecyclerview.ParentViewHolder;
import com.bignerdranch.expandablerecyclerview.model.Parent;
import com.bumptech.glide.Glide;
import com.jibo.p019ui.activity.TipVideoActivity;
import com.jibo.p019ui.activity.TipsActivity;
import com.jibo.p019ui.fragment.BaseFragment;
import com.jibo.utils.ImageUtils;
import com.jibo.utils.SharedPreferencesUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class TipsFragment extends BaseFragment {

    /* JADX INFO: renamed from: a */
    protected List<Tip> f11145a = new ArrayList();

    /* JADX INFO: renamed from: b */
    private RecyclerView.Adapter f11146b;

    /* JADX INFO: renamed from: c */
    private int f11147c;

    /* JADX INFO: renamed from: d */
    private String f11148d;

    /* JADX INFO: renamed from: e */
    private CountDownTimer f11149e;

    @BindView
    RecyclerView list;

    public class TipChildViewHolder_ViewBinding implements Unbinder {

        /* JADX INFO: renamed from: b */
        private TipChildViewHolder f11171b;

        public TipChildViewHolder_ViewBinding(TipChildViewHolder tipChildViewHolder, View view) {
            this.f11171b = tipChildViewHolder;
            tipChildViewHolder.text = (TextView) Utils.m5161b(view, R.id.text1, "field 'text'", TextView.class);
        }

        @Override // butterknife.Unbinder
        public void unbind() {
            TipChildViewHolder tipChildViewHolder = this.f11171b;
            if (tipChildViewHolder == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.f11171b = null;
            tipChildViewHolder.text = null;
        }
    }

    public class TipViewHolder_ViewBinding implements Unbinder {

        /* JADX INFO: renamed from: b */
        private TipViewHolder f11181b;

        public TipViewHolder_ViewBinding(TipViewHolder tipViewHolder, View view) {
            this.f11181b = tipViewHolder;
            tipViewHolder.image = (ImageView) Utils.m5161b(view, com.jibo.R.id.image, "field 'image'", ImageView.class);
            tipViewHolder.text = (TextView) Utils.m5161b(view, R.id.text1, "field 'text'", TextView.class);
            tipViewHolder.title = (TextView) Utils.m5161b(view, R.id.title, "field 'title'", TextView.class);
            tipViewHolder.imageAboveTitle = (ImageView) Utils.m5161b(view, com.jibo.R.id.imageAboveTitle, "field 'imageAboveTitle'", ImageView.class);
        }

        @Override // butterknife.Unbinder
        public void unbind() {
            TipViewHolder tipViewHolder = this.f11181b;
            if (tipViewHolder == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.f11181b = null;
            tipViewHolder.image = null;
            tipViewHolder.text = null;
            tipViewHolder.title = null;
            tipViewHolder.imageAboveTitle = null;
        }
    }

    public class TipHeaderViewHolder_ViewBinding implements Unbinder {

        /* JADX INFO: renamed from: b */
        private TipHeaderViewHolder f11174b;

        public TipHeaderViewHolder_ViewBinding(TipHeaderViewHolder tipHeaderViewHolder, View view) {
            this.f11174b = tipHeaderViewHolder;
            tipHeaderViewHolder.icon = (ImageView) Utils.m5161b(view, com.jibo.R.id.icon, "field 'icon'", ImageView.class);
            tipHeaderViewHolder.title = (TextView) Utils.m5161b(view, com.jibo.R.id.title, "field 'title'", TextView.class);
            tipHeaderViewHolder.subtitle = (TextView) Utils.m5161b(view, com.jibo.R.id.subtitle, "field 'subtitle'", TextView.class);
        }

        @Override // butterknife.Unbinder
        public void unbind() {
            TipHeaderViewHolder tipHeaderViewHolder = this.f11174b;
            if (tipHeaderViewHolder == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.f11174b = null;
            tipHeaderViewHolder.icon = null;
            tipHeaderViewHolder.title = null;
            tipHeaderViewHolder.subtitle = null;
        }
    }

    public class TipVideoViewHolder_ViewBinding implements Unbinder {

        /* JADX INFO: renamed from: b */
        private TipVideoViewHolder f11179b;

        public TipVideoViewHolder_ViewBinding(TipVideoViewHolder tipVideoViewHolder, View view) {
            this.f11179b = tipVideoViewHolder;
            tipVideoViewHolder.text = (TextView) Utils.m5161b(view, R.id.text1, "field 'text'", TextView.class);
            tipVideoViewHolder.contentImage = (RelativeLayout) Utils.m5161b(view, com.jibo.R.id.contentImage, "field 'contentImage'", RelativeLayout.class);
            tipVideoViewHolder.image = (ImageView) Utils.m5161b(view, com.jibo.R.id.image, "field 'image'", ImageView.class);
        }

        @Override // butterknife.Unbinder
        public void unbind() {
            TipVideoViewHolder tipVideoViewHolder = this.f11179b;
            if (tipVideoViewHolder == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.f11179b = null;
            tipVideoViewHolder.text = null;
            tipVideoViewHolder.contentImage = null;
            tipVideoViewHolder.image = null;
        }
    }

    public class NextButtonViewHolder_ViewBinding implements Unbinder {

        /* JADX INFO: renamed from: b */
        private NextButtonViewHolder f11156b;

        /* JADX INFO: renamed from: c */
        private View f11157c;

        public NextButtonViewHolder_ViewBinding(final NextButtonViewHolder nextButtonViewHolder, View view) {
            this.f11156b = nextButtonViewHolder;
            View viewM5158a = Utils.m5158a(view, com.jibo.R.id.btnNext, "field 'nextButton' and method 'next'");
            nextButtonViewHolder.nextButton = (Button) Utils.m5162c(viewM5158a, com.jibo.R.id.btnNext, "field 'nextButton'", Button.class);
            this.f11157c = viewM5158a;
            viewM5158a.setOnClickListener(new DebouncingOnClickListener() { // from class: com.jibo.ui.fragment.tips.TipsFragment.NextButtonViewHolder_ViewBinding.1
                @Override // butterknife.internal.DebouncingOnClickListener
                /* JADX INFO: renamed from: a */
                public void mo5157a(View view2) {
                    nextButtonViewHolder.next(view2);
                }
            });
        }

        @Override // butterknife.Unbinder
        public void unbind() {
            NextButtonViewHolder nextButtonViewHolder = this.f11156b;
            if (nextButtonViewHolder == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.f11156b = null;
            nextButtonViewHolder.nextButton = null;
            this.f11157c.setOnClickListener(null);
            this.f11157c = null;
        }
    }

    @Override // com.jibo.p019ui.fragment.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f11148d = "TAG_TIP1";
        if (getArguments() != null) {
            this.f11148d = getArguments().getString("ARGS_TAG");
        }
        setHasOptionsMenu(true);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(com.jibo.R.layout.fragment_tips, viewGroup, false);
    }

    @Override // com.jibo.p019ui.fragment.BaseFragment, android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), 1, false);
        this.list.setHasFixedSize(true);
        this.list.setItemAnimator(new DefaultItemAnimator());
        this.list.setLayoutManager(linearLayoutManager);
        this.f11147c = TipsContent.m11078a(this.f11148d);
        this.f11145a = TipsContent.m11081b(this.f11148d);
        ((TipsActivity) getActivity()).m10313a(TipsContent.m11082c(this.f11148d));
        this.f11146b = m11092a();
        this.list.setAdapter(this.f11146b);
    }

    @Override // android.support.v4.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        menuInflater.inflate(com.jibo.R.menu.menu_action_support, menu);
        super.onCreateOptionsMenu(menu, menuInflater);
    }

    @Override // android.support.v4.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (com.jibo.R.id.action_support != menuItem.getItemId()) {
            return super.onOptionsItemSelected(menuItem);
        }
        startActivity(new Intent("android.intent.action.VIEW", Uri.parse(getString(com.jibo.R.string.support_url))));
        return true;
    }

    /* JADX INFO: renamed from: a */
    protected RecyclerView.Adapter m11092a() {
        if ("TAG_TIP4".equals(this.f11148d)) {
            if (SharedPreferencesUtil.m11449i(getContext())) {
                this.f11145a.get(0).m11098a(true);
                m11089b();
                SharedPreferencesUtil.m11450j(getContext());
            }
            return new ExpandableTipsAdapter(this.f11145a);
        }
        if ("TAG_TIP5".equals(this.f11148d)) {
            return new TipVideoAdapter();
        }
        return new TipAdapter();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.jibo.ui.fragment.tips.TipsFragment$1] */
    /* JADX INFO: renamed from: b */
    private void m11089b() {
        long j = 5000;
        this.f11149e = new CountDownTimer(j, j) { // from class: com.jibo.ui.fragment.tips.TipsFragment.1
            @Override // android.os.CountDownTimer
            public void onTick(long j2) {
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                ((ExpandableRecyclerAdapter) TipsFragment.this.f11146b).m5181e(0);
                TipsFragment.this.f11145a.get(0).m11098a(false);
            }
        }.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: q */
    public void m11091q() {
        this.f11145a.get(0).m11098a(false);
        if (this.f11149e != null) {
            this.f11149e.cancel();
            this.f11149e = null;
        }
    }

    @Override // com.jibo.p019ui.fragment.BaseFragment
    /* JADX INFO: renamed from: a */
    protected void mo10334a(ActionBar actionBar) {
        super.mo10334a(actionBar);
        actionBar.setDisplayHomeAsUpEnabled(true);
    }

    @Override // com.jibo.p019ui.fragment.BaseFragment
    /* JADX INFO: renamed from: o */
    protected String mo10353o() {
        return getString(this.f11147c);
    }

    class TipViewHolder extends RecyclerView.ViewHolder {

        @BindView
        ImageView image;

        @BindView
        ImageView imageAboveTitle;

        @BindView
        TextView text;

        @BindView
        TextView title;

        public TipViewHolder(View view) {
            super(view);
            ButterKnife.m5154a(this, view);
        }

        /* JADX INFO: renamed from: a */
        public void m11110a(Tip tip) {
            this.text.setText(Html.fromHtml(TipsFragment.this.getString(tip.m11099c())));
            Glide.m5254b(this.itemView.getContext()).m5278a(Integer.valueOf(tip.m11100d())).mo5239j().mo5216a(this.image);
            this.title.setVisibility(tip.m11101e() == -1 ? 8 : 0);
            if (tip.m11101e() != -1) {
                this.title.setText(tip.m11101e());
            }
            this.imageAboveTitle.setVisibility(tip.m11102f() != -1 ? 0 : 8);
            if (tip.m11102f() != -1) {
                Glide.m5254b(this.itemView.getContext()).m5278a(Integer.valueOf(tip.m11102f())).mo5239j().mo5216a(this.imageAboveTitle);
            }
        }
    }

    class TipVideoViewHolder extends RecyclerView.ViewHolder {

        @BindView
        RelativeLayout contentImage;

        @BindView
        ImageView image;

        @BindView
        TextView text;

        public TipVideoViewHolder(View view) {
            super(view);
            ButterKnife.m5154a(this, view);
        }

        /* JADX INFO: renamed from: a */
        public void m11109a(final VideoTip videoTip) {
            this.text.setText(Html.fromHtml(TipsFragment.this.getString(videoTip.m11099c())));
            Glide.m5254b(this.itemView.getContext()).m5278a(Integer.valueOf(videoTip.m11100d())).mo5239j().mo5216a(this.image);
            this.contentImage.setOnClickListener(new View.OnClickListener() { // from class: com.jibo.ui.fragment.tips.TipsFragment.TipVideoViewHolder.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Intent intent = new Intent(TipsFragment.this.getActivity(), (Class<?>) TipVideoActivity.class);
                    intent.putExtra("extra_video_url_res_id", videoTip.m11111i());
                    TipsFragment.this.startActivity(intent);
                }
            });
        }
    }

    private class SeparatorViewHolder extends RecyclerView.ViewHolder {
        public SeparatorViewHolder(View view) {
            super(view);
        }
    }

    class NextButtonViewHolder extends ParentViewHolder {

        /* JADX INFO: renamed from: d */
        private final int f11154d;

        /* JADX INFO: renamed from: e */
        private final int f11155e;

        @BindView
        Button nextButton;

        @OnClick
        public void next(View view) {
            int iIndexOf = TipsListFragment.f11195a.indexOf(TipsFragment.this.f11148d);
            int i = (iIndexOf + 1) % this.f11154d;
            if (iIndexOf == this.f11155e) {
                TipsFragment.this.getActivity().finish();
                return;
            }
            TipsFragment.this.f11148d = TipsListFragment.f11195a.get(i);
            Intent intent = new Intent();
            intent.setClass(TipsFragment.this.getContext(), TipsActivity.class);
            intent.putExtra("ARGS_TAG", TipsFragment.this.f11148d);
            TipsFragment.this.startActivity(intent);
            TipsFragment.this.getActivity().finish();
        }

        public NextButtonViewHolder(View view) {
            super(view);
            this.f11154d = TipsListFragment.f11195a.size();
            this.f11155e = this.f11154d - 1;
            ButterKnife.m5154a(this, view);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX INFO: renamed from: f */
        public void m11097f() {
            int iIndexOf = TipsListFragment.f11195a.indexOf(TipsFragment.this.f11148d);
            String string = TipsFragment.this.getString(TipsContent.m11078a(TipsListFragment.f11195a.get((iIndexOf + 1) % this.f11154d)));
            if (iIndexOf == this.f11155e) {
                this.nextButton.setText(TipsFragment.this.getString(com.jibo.R.string.back_to_tips_menu));
            } else {
                this.nextButton.setText(TipsFragment.this.getString(com.jibo.R.string.tips_next_button, string));
            }
        }
    }

    public static class NextButtonTip extends Tip {
        public NextButtonTip() {
            super(-1, -1);
        }
    }

    public static class Tip implements Parent<Integer> {

        /* JADX INFO: renamed from: a */
        private int f11161a;

        /* JADX INFO: renamed from: b */
        private int f11162b;

        /* JADX INFO: renamed from: c */
        private int f11163c;

        /* JADX INFO: renamed from: d */
        private int f11164d;

        /* JADX INFO: renamed from: e */
        private int f11165e;

        /* JADX INFO: renamed from: f */
        private int f11166f;

        /* JADX INFO: renamed from: g */
        private List<Integer> f11167g;

        /* JADX INFO: renamed from: h */
        private boolean f11168h;

        public Tip(int i, int i2) {
            this.f11164d = -1;
            this.f11165e = -1;
            this.f11167g = null;
            this.f11168h = false;
            this.f11161a = i;
            this.f11163c = i2;
        }

        public Tip(int i, int i2, int i3, int i4, List<Integer> list) {
            this.f11164d = -1;
            this.f11165e = -1;
            this.f11167g = null;
            this.f11168h = false;
            this.f11161a = i;
            this.f11162b = i2;
            this.f11163c = i3;
            this.f11166f = i4;
            this.f11167g = list;
        }

        public Tip(int i, int i2, int i3, int i4) {
            this(i, i2);
            this.f11164d = i3;
            this.f11165e = i4;
        }

        /* JADX INFO: renamed from: c */
        public int m11099c() {
            return this.f11161a;
        }

        /* JADX INFO: renamed from: d */
        public int m11100d() {
            return this.f11163c;
        }

        /* JADX INFO: renamed from: e */
        public int m11101e() {
            return this.f11164d;
        }

        /* JADX INFO: renamed from: f */
        public int m11102f() {
            return this.f11165e;
        }

        @Override // com.bignerdranch.expandablerecyclerview.model.Parent
        /* JADX INFO: renamed from: a */
        public List<Integer> mo5203a() {
            return this.f11167g != null ? this.f11167g : Collections.EMPTY_LIST;
        }

        @Override // com.bignerdranch.expandablerecyclerview.model.Parent
        /* JADX INFO: renamed from: b */
        public boolean mo5204b() {
            return this.f11168h;
        }

        /* JADX INFO: renamed from: g */
        public int m11103g() {
            return this.f11166f;
        }

        /* JADX INFO: renamed from: h */
        public int m11104h() {
            return this.f11162b;
        }

        /* JADX INFO: renamed from: a */
        public void m11098a(boolean z) {
            this.f11168h = z;
        }
    }

    public static class VideoTip extends Tip {

        /* JADX INFO: renamed from: a */
        private int f11182a;

        public VideoTip(int i, int i2, int i3) {
            super(i, i2);
            this.f11182a = i3;
        }

        public VideoTip(int i, int i2, int i3, int i4, int i5) {
            super(i, i2, i3, i4);
            this.f11182a = i5;
        }

        /* JADX INFO: renamed from: i */
        public int m11111i() {
            return this.f11182a;
        }
    }

    private class TipAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
        private TipAdapter() {
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            if (i == 0) {
                return TipsFragment.this.new TipViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(com.jibo.R.layout.item_tip, viewGroup, false));
            }
            if (i == 2) {
                return TipsFragment.this.new NextButtonViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(com.jibo.R.layout.item_tip_next, viewGroup, false));
            }
            return TipsFragment.this.new SeparatorViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(com.jibo.R.layout.item_tip_separator, viewGroup, false));
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
            if (viewHolder instanceof TipViewHolder) {
                ((TipViewHolder) viewHolder).m11110a(TipsFragment.this.f11145a.get(i));
            } else if (viewHolder instanceof NextButtonViewHolder) {
                ((NextButtonViewHolder) viewHolder).m11097f();
            }
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        public int getItemCount() {
            return TipsFragment.this.f11145a.size() + 1;
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            if (i == TipsFragment.this.f11145a.size()) {
                return 2;
            }
            return TipsFragment.this.f11145a.get(i) == null ? 1 : 0;
        }
    }

    private class TipVideoAdapter extends TipAdapter {
        private TipVideoAdapter() {
            super();
        }

        @Override // com.jibo.ui.fragment.tips.TipsFragment.TipAdapter, android.support.v7.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            if (i != 0) {
                return super.onCreateViewHolder(viewGroup, i);
            }
            return TipsFragment.this.new TipVideoViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(com.jibo.R.layout.item_tip_video, viewGroup, false));
        }

        @Override // com.jibo.ui.fragment.tips.TipsFragment.TipAdapter, android.support.v7.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
            if (getItemViewType(i) == 0) {
                ((TipVideoViewHolder) viewHolder).m11109a((VideoTip) TipsFragment.this.f11145a.get(i));
            } else {
                super.onBindViewHolder(viewHolder, i);
            }
        }
    }

    private class ExpandableTipsAdapter extends ExpandableRecyclerAdapter<Tip, Integer, ParentViewHolder, TipChildViewHolder> {

        /* JADX INFO: renamed from: c */
        private final LayoutInflater f11152c;

        public ExpandableTipsAdapter(List<Tip> list) {
            super(list);
            this.f11152c = LayoutInflater.from(TipsFragment.this.getContext());
        }

        @Override // com.bignerdranch.expandablerecyclerview.ExpandableRecyclerAdapter
        /* JADX INFO: renamed from: a */
        public ParentViewHolder mo5171a(ViewGroup viewGroup, int i) {
            if (i == 4) {
                return TipsFragment.this.new NextButtonViewHolder(this.f11152c.inflate(com.jibo.R.layout.item_tip_next, viewGroup, false));
            }
            return TipsFragment.this.new TipHeaderViewHolder(this.f11152c.inflate(com.jibo.R.layout.item_tips_header, viewGroup, false));
        }

        @Override // com.bignerdranch.expandablerecyclerview.ExpandableRecyclerAdapter
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public TipChildViewHolder mo5176b(ViewGroup viewGroup, int i) {
            return TipsFragment.this.new TipChildViewHolder(this.f11152c.inflate(com.jibo.R.layout.item_tips_child, viewGroup, false));
        }

        @Override // com.bignerdranch.expandablerecyclerview.ExpandableRecyclerAdapter
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void mo5174a(ParentViewHolder parentViewHolder, int i, Tip tip) {
            if (parentViewHolder instanceof TipHeaderViewHolder) {
                ((TipHeaderViewHolder) parentViewHolder).m11108a(tip);
            } else if (parentViewHolder instanceof NextButtonViewHolder) {
                ((NextButtonViewHolder) parentViewHolder).m11097f();
            }
        }

        @Override // com.bignerdranch.expandablerecyclerview.ExpandableRecyclerAdapter
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void mo5173a(TipChildViewHolder tipChildViewHolder, int i, int i2, Integer num) {
            tipChildViewHolder.m11105a(num, m5172a().get(i).mo5203a().size() + (-1) == i2);
        }

        @Override // com.bignerdranch.expandablerecyclerview.ExpandableRecyclerAdapter
        /* JADX INFO: renamed from: a */
        public int mo5169a(int i) {
            if (TipsFragment.this.f11145a.get(i) instanceof NextButtonTip) {
                return 4;
            }
            return super.mo5169a(i);
        }

        @Override // com.bignerdranch.expandablerecyclerview.ExpandableRecyclerAdapter
        /* JADX INFO: renamed from: b */
        public boolean mo5178b(int i) {
            if (i == 4) {
                return true;
            }
            return super.mo5178b(i);
        }
    }

    class TipHeaderViewHolder extends ParentViewHolder {

        /* JADX INFO: renamed from: d */
        private Tip f11173d;

        @BindView
        ImageView icon;

        @BindView
        TextView subtitle;

        @BindView
        TextView title;

        public TipHeaderViewHolder(View view) {
            super(view);
            ButterKnife.m5154a(this, view);
        }

        /* JADX INFO: renamed from: a */
        public void m11108a(Tip tip) {
            this.f11173d = tip;
            this.title.setText(tip.m11099c());
            this.subtitle.setText(tip.m11104h());
            if (m5192b()) {
                m11107g();
            } else {
                m11106f();
            }
        }

        /* JADX INFO: renamed from: f */
        private void m11106f() {
            this.icon.setImageResource(this.f11173d.m11100d());
            this.subtitle.setTypeface(null, 0);
            this.subtitle.setTextColor(ImageUtils.m11399b(this.itemView.getContext(), com.jibo.R.color.steel));
            this.title.setTextColor(ImageUtils.m11399b(this.itemView.getContext(), com.jibo.R.color.jibo_blue));
        }

        /* JADX INFO: renamed from: g */
        private void m11107g() {
            this.icon.setImageResource(this.f11173d.m11103g());
            this.subtitle.setTypeface(null, 1);
            this.subtitle.setTextColor(-16777216);
            this.title.setTextColor(ImageUtils.m11399b(this.itemView.getContext(), com.jibo.R.color.orange));
        }

        @Override // com.bignerdranch.expandablerecyclerview.ParentViewHolder
        /* JADX INFO: renamed from: b */
        public void mo5191b(boolean z) {
            super.mo5191b(z);
            TipsFragment.this.m11091q();
            if (!z) {
                m11107g();
            } else {
                m11106f();
            }
        }

        @Override // com.bignerdranch.expandablerecyclerview.ParentViewHolder, android.view.View.OnClickListener
        public void onClick(View view) {
            if (!m5192b()) {
                ((ExpandableTipsAdapter) TipsFragment.this.list.getAdapter()).m5177b();
            }
            super.onClick(view);
        }
    }

    class TipChildViewHolder extends ChildViewHolder {

        @BindView
        TextView text;

        public TipChildViewHolder(View view) {
            super(view);
            ButterKnife.m5154a(this, view);
        }

        /* JADX INFO: renamed from: a */
        public void m11105a(Integer num, boolean z) {
            if (z) {
                this.itemView.setPadding(0, this.itemView.getContext().getResources().getDimensionPixelSize(com.jibo.R.dimen.default_padding), 0, this.itemView.getContext().getResources().getDimensionPixelSize(com.jibo.R.dimen.activity_double_vertical_margin));
            } else {
                this.itemView.setPadding(0, this.itemView.getContext().getResources().getDimensionPixelSize(com.jibo.R.dimen.default_padding), 0, this.itemView.getContext().getResources().getDimensionPixelSize(com.jibo.R.dimen.default_padding));
            }
            this.text.setText(num.intValue());
        }
    }
}
