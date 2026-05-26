.class public Lcom/jibo/ui/fragment/tips/TipsFragment;
.super Lcom/jibo/ui/fragment/BaseFragment;
.source "TipsFragment.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/jibo/ui/fragment/tips/TipsFragment$TipChildViewHolder;,
        Lcom/jibo/ui/fragment/tips/TipsFragment$TipHeaderViewHolder;,
        Lcom/jibo/ui/fragment/tips/TipsFragment$ExpandableTipsAdapter;,
        Lcom/jibo/ui/fragment/tips/TipsFragment$TipVideoAdapter;,
        Lcom/jibo/ui/fragment/tips/TipsFragment$TipAdapter;,
        Lcom/jibo/ui/fragment/tips/TipsFragment$VideoTip;,
        Lcom/jibo/ui/fragment/tips/TipsFragment$Tip;,
        Lcom/jibo/ui/fragment/tips/TipsFragment$NextButtonTip;,
        Lcom/jibo/ui/fragment/tips/TipsFragment$NextButtonViewHolder;,
        Lcom/jibo/ui/fragment/tips/TipsFragment$SeparatorViewHolder;,
        Lcom/jibo/ui/fragment/tips/TipsFragment$TipVideoViewHolder;,
        Lcom/jibo/ui/fragment/tips/TipsFragment$TipViewHolder;
    }
.end annotation


# instance fields
.field protected a:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/jibo/ui/fragment/tips/TipsFragment$Tip;",
            ">;"
        }
    .end annotation
.end field

.field private b:Landroid/support/v7/widget/RecyclerView$Adapter;

.field private c:I

.field private d:Ljava/lang/String;

.field private e:Landroid/os/CountDownTimer;

.field list:Landroid/support/v7/widget/RecyclerView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 74
    invoke-direct {p0}, Lcom/jibo/ui/fragment/BaseFragment;-><init>()V

    .line 63
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/jibo/ui/fragment/tips/TipsFragment;->a:Ljava/util/List;

    .line 76
    return-void
.end method

.method static synthetic a(Lcom/jibo/ui/fragment/tips/TipsFragment;)Landroid/support/v7/widget/RecyclerView$Adapter;
    .locals 1

    .prologue
    .line 54
    iget-object v0, p0, Lcom/jibo/ui/fragment/tips/TipsFragment;->b:Landroid/support/v7/widget/RecyclerView$Adapter;

    return-object v0
.end method

.method static synthetic a(Lcom/jibo/ui/fragment/tips/TipsFragment;Ljava/lang/String;)Ljava/lang/String;
    .locals 0

    .prologue
    .line 54
    iput-object p1, p0, Lcom/jibo/ui/fragment/tips/TipsFragment;->d:Ljava/lang/String;

    return-object p1
.end method

.method static synthetic b(Lcom/jibo/ui/fragment/tips/TipsFragment;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 54
    iget-object v0, p0, Lcom/jibo/ui/fragment/tips/TipsFragment;->d:Ljava/lang/String;

    return-object v0
.end method

.method private b()V
    .locals 6

    .prologue
    const-wide/16 v2, 0x1388

    .line 149
    new-instance v0, Lcom/jibo/ui/fragment/tips/TipsFragment$1;

    move-object v1, p0

    move-wide v4, v2

    invoke-direct/range {v0 .. v5}, Lcom/jibo/ui/fragment/tips/TipsFragment$1;-><init>(Lcom/jibo/ui/fragment/tips/TipsFragment;JJ)V

    .line 160
    invoke-virtual {v0}, Lcom/jibo/ui/fragment/tips/TipsFragment$1;->start()Landroid/os/CountDownTimer;

    move-result-object v0

    iput-object v0, p0, Lcom/jibo/ui/fragment/tips/TipsFragment;->e:Landroid/os/CountDownTimer;

    .line 161
    return-void
.end method

.method static synthetic c(Lcom/jibo/ui/fragment/tips/TipsFragment;)V
    .locals 0

    .prologue
    .line 54
    invoke-direct {p0}, Lcom/jibo/ui/fragment/tips/TipsFragment;->q()V

    return-void
.end method

.method private q()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 164
    iget-object v0, p0, Lcom/jibo/ui/fragment/tips/TipsFragment;->a:Ljava/util/List;

    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/fragment/tips/TipsFragment$Tip;

    invoke-virtual {v0, v1}, Lcom/jibo/ui/fragment/tips/TipsFragment$Tip;->a(Z)V

    .line 166
    iget-object v0, p0, Lcom/jibo/ui/fragment/tips/TipsFragment;->e:Landroid/os/CountDownTimer;

    if-eqz v0, :cond_0

    .line 167
    iget-object v0, p0, Lcom/jibo/ui/fragment/tips/TipsFragment;->e:Landroid/os/CountDownTimer;

    invoke-virtual {v0}, Landroid/os/CountDownTimer;->cancel()V

    .line 168
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/jibo/ui/fragment/tips/TipsFragment;->e:Landroid/os/CountDownTimer;

    .line 170
    :cond_0
    return-void
.end method


# virtual methods
.method protected a()Landroid/support/v7/widget/RecyclerView$Adapter;
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 132
    const-string v0, "TAG_TIP4"

    iget-object v1, p0, Lcom/jibo/ui/fragment/tips/TipsFragment;->d:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 133
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/tips/TipsFragment;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Lcom/jibo/utils/SharedPreferencesUtil;->i(Landroid/content/Context;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 135
    iget-object v0, p0, Lcom/jibo/ui/fragment/tips/TipsFragment;->a:Ljava/util/List;

    const/4 v1, 0x0

    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/fragment/tips/TipsFragment$Tip;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Lcom/jibo/ui/fragment/tips/TipsFragment$Tip;->a(Z)V

    .line 136
    invoke-direct {p0}, Lcom/jibo/ui/fragment/tips/TipsFragment;->b()V

    .line 137
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/tips/TipsFragment;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Lcom/jibo/utils/SharedPreferencesUtil;->j(Landroid/content/Context;)V

    .line 140
    :cond_0
    new-instance v0, Lcom/jibo/ui/fragment/tips/TipsFragment$ExpandableTipsAdapter;

    iget-object v1, p0, Lcom/jibo/ui/fragment/tips/TipsFragment;->a:Ljava/util/List;

    invoke-direct {v0, p0, v1}, Lcom/jibo/ui/fragment/tips/TipsFragment$ExpandableTipsAdapter;-><init>(Lcom/jibo/ui/fragment/tips/TipsFragment;Ljava/util/List;)V

    .line 144
    :goto_0
    return-object v0

    .line 141
    :cond_1
    const-string v0, "TAG_TIP5"

    iget-object v1, p0, Lcom/jibo/ui/fragment/tips/TipsFragment;->d:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 142
    new-instance v0, Lcom/jibo/ui/fragment/tips/TipsFragment$TipVideoAdapter;

    invoke-direct {v0, p0, v2}, Lcom/jibo/ui/fragment/tips/TipsFragment$TipVideoAdapter;-><init>(Lcom/jibo/ui/fragment/tips/TipsFragment;Lcom/jibo/ui/fragment/tips/TipsFragment$1;)V

    goto :goto_0

    .line 144
    :cond_2
    new-instance v0, Lcom/jibo/ui/fragment/tips/TipsFragment$TipAdapter;

    invoke-direct {v0, p0, v2}, Lcom/jibo/ui/fragment/tips/TipsFragment$TipAdapter;-><init>(Lcom/jibo/ui/fragment/tips/TipsFragment;Lcom/jibo/ui/fragment/tips/TipsFragment$1;)V

    goto :goto_0
.end method

.method protected a(Landroid/support/v7/app/ActionBar;)V
    .locals 1

    .prologue
    .line 174
    invoke-super {p0, p1}, Lcom/jibo/ui/fragment/BaseFragment;->a(Landroid/support/v7/app/ActionBar;)V

    .line 175
    const/4 v0, 0x1

    invoke-virtual {p1, v0}, Landroid/support/v7/app/ActionBar;->setDisplayHomeAsUpEnabled(Z)V

    .line 176
    return-void
.end method

.method protected o()Ljava/lang/String;
    .locals 1

    .prologue
    .line 180
    iget v0, p0, Lcom/jibo/ui/fragment/tips/TipsFragment;->c:I

    invoke-virtual {p0, v0}, Lcom/jibo/ui/fragment/tips/TipsFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 2

    .prologue
    .line 80
    invoke-super {p0, p1}, Lcom/jibo/ui/fragment/BaseFragment;->onCreate(Landroid/os/Bundle;)V

    .line 81
    const-string v0, "TAG_TIP1"

    iput-object v0, p0, Lcom/jibo/ui/fragment/tips/TipsFragment;->d:Ljava/lang/String;

    .line 82
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/tips/TipsFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 83
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/tips/TipsFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    const-string v1, "ARGS_TAG"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/jibo/ui/fragment/tips/TipsFragment;->d:Ljava/lang/String;

    .line 85
    :cond_0
    const/4 v0, 0x1

    invoke-virtual {p0, v0}, Lcom/jibo/ui/fragment/tips/TipsFragment;->setHasOptionsMenu(Z)V

    .line 87
    return-void
.end method

.method public onCreateOptionsMenu(Landroid/view/Menu;Landroid/view/MenuInflater;)V
    .locals 1

    .prologue
    .line 116
    const v0, 0x7f0c0009

    invoke-virtual {p2, v0, p1}, Landroid/view/MenuInflater;->inflate(ILandroid/view/Menu;)V

    .line 117
    invoke-super {p0, p1, p2}, Lcom/jibo/ui/fragment/BaseFragment;->onCreateOptionsMenu(Landroid/view/Menu;Landroid/view/MenuInflater;)V

    .line 119
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 2

    .prologue
    .line 91
    const v0, 0x7f0b0093

    const/4 v1, 0x0

    invoke-virtual {p1, v0, p2, v1}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    return-object v0
.end method

.method public onOptionsItemSelected(Landroid/view/MenuItem;)Z
    .locals 3

    .prologue
    .line 123
    const v0, 0x7f090035

    invoke-interface {p1}, Landroid/view/MenuItem;->getItemId()I

    move-result v1

    if-ne v0, v1, :cond_0

    .line 124
    new-instance v0, Landroid/content/Intent;

    const-string v1, "android.intent.action.VIEW"

    const v2, 0x7f1002e8

    invoke-virtual {p0, v2}, Lcom/jibo/ui/fragment/tips/TipsFragment;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v2

    invoke-direct {v0, v1, v2}, Landroid/content/Intent;-><init>(Ljava/lang/String;Landroid/net/Uri;)V

    invoke-virtual {p0, v0}, Lcom/jibo/ui/fragment/tips/TipsFragment;->startActivity(Landroid/content/Intent;)V

    .line 125
    const/4 v0, 0x1

    .line 127
    :goto_0
    return v0

    :cond_0
    invoke-super {p0, p1}, Lcom/jibo/ui/fragment/BaseFragment;->onOptionsItemSelected(Landroid/view/MenuItem;)Z

    move-result v0

    goto :goto_0
.end method

.method public onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V
    .locals 4

    .prologue
    const/4 v3, 0x1

    .line 96
    invoke-super {p0, p1, p2}, Lcom/jibo/ui/fragment/BaseFragment;->onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V

    .line 98
    new-instance v0, Landroid/support/v7/widget/LinearLayoutManager;

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/tips/TipsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    const/4 v2, 0x0

    invoke-direct {v0, v1, v3, v2}, Landroid/support/v7/widget/LinearLayoutManager;-><init>(Landroid/content/Context;IZ)V

    .line 101
    iget-object v1, p0, Lcom/jibo/ui/fragment/tips/TipsFragment;->list:Landroid/support/v7/widget/RecyclerView;

    invoke-virtual {v1, v3}, Landroid/support/v7/widget/RecyclerView;->setHasFixedSize(Z)V

    .line 102
    iget-object v1, p0, Lcom/jibo/ui/fragment/tips/TipsFragment;->list:Landroid/support/v7/widget/RecyclerView;

    new-instance v2, Landroid/support/v7/widget/DefaultItemAnimator;

    invoke-direct {v2}, Landroid/support/v7/widget/DefaultItemAnimator;-><init>()V

    invoke-virtual {v1, v2}, Landroid/support/v7/widget/RecyclerView;->setItemAnimator(Landroid/support/v7/widget/RecyclerView$ItemAnimator;)V

    .line 103
    iget-object v1, p0, Lcom/jibo/ui/fragment/tips/TipsFragment;->list:Landroid/support/v7/widget/RecyclerView;

    invoke-virtual {v1, v0}, Landroid/support/v7/widget/RecyclerView;->setLayoutManager(Landroid/support/v7/widget/RecyclerView$LayoutManager;)V

    .line 105
    iget-object v0, p0, Lcom/jibo/ui/fragment/tips/TipsFragment;->d:Ljava/lang/String;

    invoke-static {v0}, Lcom/jibo/ui/fragment/tips/TipsContent;->a(Ljava/lang/String;)I

    move-result v0

    iput v0, p0, Lcom/jibo/ui/fragment/tips/TipsFragment;->c:I

    .line 106
    iget-object v0, p0, Lcom/jibo/ui/fragment/tips/TipsFragment;->d:Ljava/lang/String;

    invoke-static {v0}, Lcom/jibo/ui/fragment/tips/TipsContent;->b(Ljava/lang/String;)Ljava/util/List;

    move-result-object v0

    iput-object v0, p0, Lcom/jibo/ui/fragment/tips/TipsFragment;->a:Ljava/util/List;

    .line 108
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/tips/TipsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/activity/TipsActivity;

    iget-object v1, p0, Lcom/jibo/ui/fragment/tips/TipsFragment;->d:Ljava/lang/String;

    invoke-static {v1}, Lcom/jibo/ui/fragment/tips/TipsContent;->c(Ljava/lang/String;)Lcom/jibo/ui/fragment/tips/TipsFragment$Tip;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/jibo/ui/activity/TipsActivity;->a(Lcom/jibo/ui/fragment/tips/TipsFragment$Tip;)V

    .line 110
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/tips/TipsFragment;->a()Landroid/support/v7/widget/RecyclerView$Adapter;

    move-result-object v0

    iput-object v0, p0, Lcom/jibo/ui/fragment/tips/TipsFragment;->b:Landroid/support/v7/widget/RecyclerView$Adapter;

    .line 111
    iget-object v0, p0, Lcom/jibo/ui/fragment/tips/TipsFragment;->list:Landroid/support/v7/widget/RecyclerView;

    iget-object v1, p0, Lcom/jibo/ui/fragment/tips/TipsFragment;->b:Landroid/support/v7/widget/RecyclerView$Adapter;

    invoke-virtual {v0, v1}, Landroid/support/v7/widget/RecyclerView;->setAdapter(Landroid/support/v7/widget/RecyclerView$Adapter;)V

    .line 112
    return-void
.end method
