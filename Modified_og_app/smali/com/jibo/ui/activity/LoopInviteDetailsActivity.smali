.class public Lcom/jibo/ui/activity/LoopInviteDetailsActivity;
.super Lcom/jibo/ui/activity/BaseActivity;
.source "LoopInviteDetailsActivity.java"


# instance fields
.field buttonAccept:Landroid/view/View;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field buttonDecline:Landroid/view/View;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field private h:Lcom/jibo/ui/fragment/jibos/adapter/LoopMembersListAdapter;

.field private i:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

.field private j:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/jibo/ui/helpers/Items$Item;",
            ">;"
        }
    .end annotation
.end field

.field private k:Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

.field private l:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/jibo/aws/integration/aws/services/loop/model/Loop;",
            ">;"
        }
    .end annotation
.end field

.field private m:Z

.field private n:Z

.field recyclerView:Landroid/support/v7/widget/RecyclerView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 41
    invoke-direct {p0}, Lcom/jibo/ui/activity/BaseActivity;-><init>()V

    .line 52
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/jibo/ui/activity/LoopInviteDetailsActivity;->j:Ljava/util/List;

    .line 65
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/jibo/ui/activity/LoopInviteDetailsActivity;->n:Z

    return-void
.end method

.method static synthetic a(Lcom/jibo/ui/activity/LoopInviteDetailsActivity;Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;)Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;
    .locals 0

    .prologue
    .line 41
    iput-object p1, p0, Lcom/jibo/ui/activity/LoopInviteDetailsActivity;->k:Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    return-object p1
.end method

.method static synthetic a(Lcom/jibo/ui/activity/LoopInviteDetailsActivity;)V
    .locals 0

    .prologue
    .line 41
    invoke-direct {p0}, Lcom/jibo/ui/activity/LoopInviteDetailsActivity;->s()V

    return-void
.end method

.method static synthetic a(Lcom/jibo/ui/activity/LoopInviteDetailsActivity;Z)Z
    .locals 0

    .prologue
    .line 41
    iput-boolean p1, p0, Lcom/jibo/ui/activity/LoopInviteDetailsActivity;->m:Z

    return p1
.end method

.method static synthetic b(Lcom/jibo/ui/activity/LoopInviteDetailsActivity;)Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;
    .locals 1

    .prologue
    .line 41
    iget-object v0, p0, Lcom/jibo/ui/activity/LoopInviteDetailsActivity;->k:Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    return-object v0
.end method

.method static synthetic c(Lcom/jibo/ui/activity/LoopInviteDetailsActivity;)Lcom/jibo/aws/integration/aws/services/loop/model/Loop;
    .locals 1

    .prologue
    .line 41
    iget-object v0, p0, Lcom/jibo/ui/activity/LoopInviteDetailsActivity;->i:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    return-object v0
.end method

.method private q()V
    .locals 8

    .prologue
    .line 179
    const/4 v0, 0x0

    invoke-virtual {p0}, Lcom/jibo/ui/activity/LoopInviteDetailsActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v1

    const/16 v2, 0x67

    const v3, 0x7f1001f4

    invoke-virtual {p0, v3}, Lcom/jibo/ui/activity/LoopInviteDetailsActivity;->getString(I)Ljava/lang/String;

    move-result-object v3

    const v4, 0x7f1001f5

    const/4 v5, 0x1

    new-array v5, v5, [Ljava/lang/Object;

    const/4 v6, 0x0

    iget-object v7, p0, Lcom/jibo/ui/activity/LoopInviteDetailsActivity;->i:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    .line 180
    invoke-virtual {v7}, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;->getName()Ljava/lang/String;

    move-result-object v7

    aput-object v7, v5, v6

    invoke-virtual {p0, v4, v5}, Lcom/jibo/ui/activity/LoopInviteDetailsActivity;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    .line 179
    invoke-static {v0, v1, v2, v3, v4}, Lcom/jibo/ui/fragment/dialog/DialogUtils;->c(Landroid/support/v4/app/Fragment;Landroid/support/v4/app/FragmentManager;ILjava/lang/String;Ljava/lang/String;)V

    .line 181
    return-void
.end method

.method private r()V
    .locals 8

    .prologue
    const/4 v7, 0x1

    const/4 v6, 0x0

    .line 241
    iget-object v0, p0, Lcom/jibo/ui/activity/LoopInviteDetailsActivity;->buttonAccept:Landroid/view/View;

    invoke-virtual {v0, v7}, Landroid/view/View;->setClickable(Z)V

    .line 242
    iget-object v0, p0, Lcom/jibo/ui/activity/LoopInviteDetailsActivity;->buttonDecline:Landroid/view/View;

    invoke-virtual {v0, v7}, Landroid/view/View;->setClickable(Z)V

    .line 244
    iget-object v0, p0, Lcom/jibo/ui/activity/LoopInviteDetailsActivity;->l:Ljava/util/List;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/jibo/ui/activity/LoopInviteDetailsActivity;->l:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_1

    :cond_0
    iget-object v0, p0, Lcom/jibo/ui/activity/LoopInviteDetailsActivity;->i:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    :goto_0
    iput-object v0, p0, Lcom/jibo/ui/activity/LoopInviteDetailsActivity;->i:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    .line 245
    invoke-static {p0}, Lcom/jibo/db/EntityData;->a(Landroid/content/Context;)Lcom/jibo/db/EntityData;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/db/EntityData;->i()Lcom/jibo/aws/integration/aws/services/account/model/Account;

    move-result-object v1

    .line 246
    iget-object v0, p0, Lcom/jibo/ui/activity/LoopInviteDetailsActivity;->i:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-virtual {v1}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getId()Ljava/lang/String;

    move-result-object v2

    invoke-static {v0, v2}, Lcom/jibo/aws/integration/helpers/LoopHelper;->getMemberByIdOrEmail(Lcom/jibo/aws/integration/aws/services/loop/model/Loop;Ljava/lang/String;)Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    move-result-object v0

    .line 248
    iget-object v2, p0, Lcom/jibo/ui/activity/LoopInviteDetailsActivity;->j:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->clear()V

    .line 249
    iget-object v2, p0, Lcom/jibo/ui/activity/LoopInviteDetailsActivity;->j:Ljava/util/List;

    new-instance v3, Lcom/jibo/ui/helpers/Items$SubheaderItem;

    const v4, 0x7f100158

    invoke-direct {v3, v4}, Lcom/jibo/ui/helpers/Items$SubheaderItem;-><init>(I)V

    invoke-interface {v2, v3}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 250
    iget-object v2, p0, Lcom/jibo/ui/activity/LoopInviteDetailsActivity;->i:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-static {v2, v0}, Lcom/jibo/aws/integration/helpers/LoopHelper;->sortMembers(Lcom/jibo/aws/integration/aws/services/loop/model/Loop;Lcom/jibo/aws/integration/aws/services/loop/model/Member;)Ljava/util/List;

    move-result-object v2

    .line 252
    invoke-interface {v2, v0}, Ljava/util/List;->remove(Ljava/lang/Object;)Z

    .line 253
    invoke-interface {v2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :goto_1
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_2

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    .line 254
    iget-object v3, p0, Lcom/jibo/ui/activity/LoopInviteDetailsActivity;->j:Ljava/util/List;

    new-instance v4, Lcom/jibo/ui/helpers/Items$MemberItem;

    iget-object v5, p0, Lcom/jibo/ui/activity/LoopInviteDetailsActivity;->i:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-direct {v4, v5, v0}, Lcom/jibo/ui/helpers/Items$MemberItem;-><init>(Lcom/jibo/aws/integration/aws/services/loop/model/Loop;Lcom/jibo/aws/integration/aws/services/loop/model/Member;)V

    invoke-interface {v3, v4}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_1

    .line 244
    :cond_1
    iget-object v0, p0, Lcom/jibo/ui/activity/LoopInviteDetailsActivity;->l:Ljava/util/List;

    invoke-interface {v0, v6}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    goto :goto_0

    .line 256
    :cond_2
    iget-object v0, p0, Lcom/jibo/ui/activity/LoopInviteDetailsActivity;->j:Ljava/util/List;

    new-instance v2, Lcom/jibo/ui/helpers/Items$FooterItem;

    const v3, 0x7f1001f1

    invoke-virtual {p0, v3}, Lcom/jibo/ui/activity/LoopInviteDetailsActivity;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Lcom/jibo/ui/helpers/Items$FooterItem;-><init>(Ljava/lang/CharSequence;)V

    invoke-interface {v0, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 257
    new-instance v0, Lcom/jibo/ui/fragment/jibos/adapter/LoopMembersListAdapter;

    iget-object v2, p0, Lcom/jibo/ui/activity/LoopInviteDetailsActivity;->j:Ljava/util/List;

    iget-object v3, p0, Lcom/jibo/ui/activity/LoopInviteDetailsActivity;->i:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-direct {v0, v2, v3, v1}, Lcom/jibo/ui/fragment/jibos/adapter/LoopMembersListAdapter;-><init>(Ljava/util/List;Lcom/jibo/aws/integration/aws/services/loop/model/Loop;Lcom/jibo/aws/integration/aws/services/account/model/Account;)V

    iput-object v0, p0, Lcom/jibo/ui/activity/LoopInviteDetailsActivity;->h:Lcom/jibo/ui/fragment/jibos/adapter/LoopMembersListAdapter;

    .line 258
    iget-object v0, p0, Lcom/jibo/ui/activity/LoopInviteDetailsActivity;->recyclerView:Landroid/support/v7/widget/RecyclerView;

    iget-object v1, p0, Lcom/jibo/ui/activity/LoopInviteDetailsActivity;->h:Lcom/jibo/ui/fragment/jibos/adapter/LoopMembersListAdapter;

    invoke-virtual {v0, v1}, Landroid/support/v7/widget/RecyclerView;->setAdapter(Landroid/support/v7/widget/RecyclerView$Adapter;)V

    .line 260
    iget-boolean v0, p0, Lcom/jibo/ui/activity/LoopInviteDetailsActivity;->m:Z

    if-eqz v0, :cond_3

    .line 261
    invoke-virtual {p0}, Lcom/jibo/ui/activity/LoopInviteDetailsActivity;->getSupportActionBar()Landroid/support/v7/app/ActionBar;

    move-result-object v0

    invoke-virtual {v0, v7}, Landroid/support/v7/app/ActionBar;->setDisplayHomeAsUpEnabled(Z)V

    .line 262
    invoke-virtual {p0}, Lcom/jibo/ui/activity/LoopInviteDetailsActivity;->getSupportActionBar()Landroid/support/v7/app/ActionBar;

    move-result-object v0

    const v1, 0x7f080282

    invoke-virtual {v0, v1}, Landroid/support/v7/app/ActionBar;->setHomeAsUpIndicator(I)V

    .line 270
    :goto_2
    invoke-virtual {p0}, Lcom/jibo/ui/activity/LoopInviteDetailsActivity;->getSupportActionBar()Landroid/support/v7/app/ActionBar;

    move-result-object v0

    const v1, 0x7f10040b

    new-array v2, v7, [Ljava/lang/Object;

    iget-object v3, p0, Lcom/jibo/ui/activity/LoopInviteDetailsActivity;->i:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-virtual {v3}, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;->getName()Ljava/lang/String;

    move-result-object v3

    aput-object v3, v2, v6

    invoke-virtual {p0, v1, v2}, Lcom/jibo/ui/activity/LoopInviteDetailsActivity;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/support/v7/app/ActionBar;->setTitle(Ljava/lang/CharSequence;)V

    .line 271
    return-void

    .line 264
    :cond_3
    invoke-virtual {p0}, Lcom/jibo/ui/activity/LoopInviteDetailsActivity;->getSupportActionBar()Landroid/support/v7/app/ActionBar;

    move-result-object v0

    invoke-virtual {v0, v6}, Landroid/support/v7/app/ActionBar;->setDisplayShowHomeEnabled(Z)V

    .line 265
    invoke-virtual {p0}, Lcom/jibo/ui/activity/LoopInviteDetailsActivity;->getSupportActionBar()Landroid/support/v7/app/ActionBar;

    move-result-object v0

    invoke-virtual {v0, v6}, Landroid/support/v7/app/ActionBar;->setHomeButtonEnabled(Z)V

    .line 266
    invoke-virtual {p0}, Lcom/jibo/ui/activity/LoopInviteDetailsActivity;->getSupportActionBar()Landroid/support/v7/app/ActionBar;

    move-result-object v0

    invoke-virtual {v0, v6}, Landroid/support/v7/app/ActionBar;->setDisplayHomeAsUpEnabled(Z)V

    .line 267
    invoke-virtual {p0}, Lcom/jibo/ui/activity/LoopInviteDetailsActivity;->getSupportActionBar()Landroid/support/v7/app/ActionBar;

    move-result-object v0

    invoke-virtual {v0, v6}, Landroid/support/v7/app/ActionBar;->setHomeAsUpIndicator(I)V

    goto :goto_2
.end method

.method private s()V
    .locals 2

    .prologue
    .line 274
    iget-object v0, p0, Lcom/jibo/ui/activity/LoopInviteDetailsActivity;->l:Ljava/util/List;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/jibo/ui/activity/LoopInviteDetailsActivity;->l:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    const/4 v1, 0x1

    if-le v0, v1, :cond_0

    .line 275
    iget-object v0, p0, Lcom/jibo/ui/activity/LoopInviteDetailsActivity;->l:Ljava/util/List;

    const/4 v1, 0x0

    invoke-interface {v0, v1}, Ljava/util/List;->remove(I)Ljava/lang/Object;

    .line 276
    invoke-direct {p0}, Lcom/jibo/ui/activity/LoopInviteDetailsActivity;->r()V

    .line 283
    :goto_0
    return-void

    .line 278
    :cond_0
    iget-boolean v0, p0, Lcom/jibo/ui/activity/LoopInviteDetailsActivity;->n:Z

    if-eqz v0, :cond_1

    .line 279
    invoke-virtual {p0}, Lcom/jibo/ui/activity/LoopInviteDetailsActivity;->getIntent()Landroid/content/Intent;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v0

    const-string v1, "ARG_EXTRAS"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getBundle(Ljava/lang/String;)Landroid/os/Bundle;

    move-result-object v0

    invoke-static {p0, v0}, Lcom/jibo/ui/activity/TabbedActivity;->a(Landroid/app/Activity;Landroid/os/Bundle;)V

    .line 281
    :cond_1
    invoke-virtual {p0}, Lcom/jibo/ui/activity/LoopInviteDetailsActivity;->onBackPressed()V

    goto :goto_0
.end method

.method private t()V
    .locals 3

    .prologue
    .line 286
    const-string v0, "notification"

    .line 287
    invoke-virtual {p0, v0}, Lcom/jibo/ui/activity/LoopInviteDetailsActivity;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/app/NotificationManager;

    .line 289
    iget-object v1, p0, Lcom/jibo/ui/activity/LoopInviteDetailsActivity;->i:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-virtual {v1}, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;->getId()Ljava/lang/String;

    move-result-object v1

    const/4 v2, 0x2

    invoke-virtual {v0, v1, v2}, Landroid/app/NotificationManager;->cancel(Ljava/lang/String;I)V

    .line 290
    return-void
.end method


# virtual methods
.method protected onCreate(Landroid/os/Bundle;)V
    .locals 5

    .prologue
    const/4 v2, 0x1

    const/4 v1, 0x0

    const-string v0, "com.jibo.ui.activity.LoopInviteDetailsActivity"

    invoke-static {v0}, Lcom/google/firebase/perf/metrics/AppStartTrace;->setLauncherActivityOnCreateTime(Ljava/lang/String;)V

    .line 69
    invoke-virtual {p0}, Lcom/jibo/ui/activity/LoopInviteDetailsActivity;->getIntent()Landroid/content/Intent;

    move-result-object v0

    sget-object v3, Lcom/jibo/ui/activity/LoopInviteDetailsActivity;->b:Ljava/lang/String;

    const v4, 0x7f0b0020

    invoke-virtual {v0, v3, v4}, Landroid/content/Intent;->putExtra(Ljava/lang/String;I)Landroid/content/Intent;

    .line 70
    invoke-super {p0, p1}, Lcom/jibo/ui/activity/BaseActivity;->onCreate(Landroid/os/Bundle;)V

    .line 72
    const/4 v0, 0x0

    .line 73
    invoke-virtual {p0}, Lcom/jibo/ui/activity/LoopInviteDetailsActivity;->getIntent()Landroid/content/Intent;

    move-result-object v3

    if-eqz v3, :cond_3

    .line 74
    invoke-virtual {p0}, Lcom/jibo/ui/activity/LoopInviteDetailsActivity;->getIntent()Landroid/content/Intent;

    move-result-object v0

    const-class v3, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-virtual {v3}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v3}, Landroid/content/Intent;->getParcelableExtra(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v0

    check-cast v0, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    iput-object v0, p0, Lcom/jibo/ui/activity/LoopInviteDetailsActivity;->i:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    .line 75
    invoke-virtual {p0}, Lcom/jibo/ui/activity/LoopInviteDetailsActivity;->getIntent()Landroid/content/Intent;

    move-result-object v0

    const-string v3, " ARGS_LOOPS_LIST"

    invoke-virtual {v0, v3}, Landroid/content/Intent;->getParcelableArrayListExtra(Ljava/lang/String;)Ljava/util/ArrayList;

    move-result-object v0

    .line 76
    invoke-virtual {p0}, Lcom/jibo/ui/activity/LoopInviteDetailsActivity;->getIntent()Landroid/content/Intent;

    move-result-object v3

    const-string v4, " ARGS_HAS_ACCEPTED_LOOPS"

    invoke-virtual {v3, v4, v1}, Landroid/content/Intent;->getBooleanExtra(Ljava/lang/String;Z)Z

    move-result v3

    iput-boolean v3, p0, Lcom/jibo/ui/activity/LoopInviteDetailsActivity;->m:Z

    .line 82
    :cond_0
    :goto_0
    iget-boolean v3, p0, Lcom/jibo/ui/activity/LoopInviteDetailsActivity;->m:Z

    if-nez v3, :cond_1

    move v1, v2

    :cond_1
    iput-boolean v1, p0, Lcom/jibo/ui/activity/LoopInviteDetailsActivity;->n:Z

    .line 84
    if-eqz v0, :cond_2

    .line 85
    new-instance v1, Ljava/util/LinkedList;

    invoke-direct {v1, v0}, Ljava/util/LinkedList;-><init>(Ljava/util/Collection;)V

    iput-object v1, p0, Lcom/jibo/ui/activity/LoopInviteDetailsActivity;->l:Ljava/util/List;

    .line 88
    :cond_2
    invoke-virtual {p0}, Lcom/jibo/ui/activity/LoopInviteDetailsActivity;->getSupportActionBar()Landroid/support/v7/app/ActionBar;

    move-result-object v0

    invoke-virtual {v0, v2}, Landroid/support/v7/app/ActionBar;->setDisplayHomeAsUpEnabled(Z)V

    .line 90
    iget-object v0, p0, Lcom/jibo/ui/activity/LoopInviteDetailsActivity;->recyclerView:Landroid/support/v7/widget/RecyclerView;

    invoke-virtual {v0, v2}, Landroid/support/v7/widget/RecyclerView;->setHasFixedSize(Z)V

    .line 91
    iget-object v0, p0, Lcom/jibo/ui/activity/LoopInviteDetailsActivity;->recyclerView:Landroid/support/v7/widget/RecyclerView;

    new-instance v1, Landroid/support/v7/widget/LinearLayoutManager;

    invoke-direct {v1, p0}, Landroid/support/v7/widget/LinearLayoutManager;-><init>(Landroid/content/Context;)V

    invoke-virtual {v0, v1}, Landroid/support/v7/widget/RecyclerView;->setLayoutManager(Landroid/support/v7/widget/RecyclerView$LayoutManager;)V

    .line 92
    iget-object v0, p0, Lcom/jibo/ui/activity/LoopInviteDetailsActivity;->recyclerView:Landroid/support/v7/widget/RecyclerView;

    new-instance v1, Lcom/jibo/ui/fragment/jibos/adapter/LoopMembersListAdapter$SpacesItemDecoration;

    const/4 v2, -0x1

    const v3, 0x7f07004f

    const v4, 0x7f0700b6

    invoke-direct {v1, p0, v2, v3, v4}, Lcom/jibo/ui/fragment/jibos/adapter/LoopMembersListAdapter$SpacesItemDecoration;-><init>(Landroid/content/Context;III)V

    invoke-virtual {v0, v1}, Landroid/support/v7/widget/RecyclerView;->addItemDecoration(Landroid/support/v7/widget/RecyclerView$ItemDecoration;)V

    .line 95
    invoke-direct {p0}, Lcom/jibo/ui/activity/LoopInviteDetailsActivity;->r()V

    .line 96
    return-void

    .line 77
    :cond_3
    if-eqz p1, :cond_0

    .line 78
    const-class v0, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v0

    check-cast v0, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    iput-object v0, p0, Lcom/jibo/ui/activity/LoopInviteDetailsActivity;->i:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    .line 79
    const-string v0, " ARGS_LOOPS_LIST"

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->getParcelableArrayList(Ljava/lang/String;)Ljava/util/ArrayList;

    move-result-object v0

    .line 80
    const-string v3, " ARGS_HAS_ACCEPTED_LOOPS"

    invoke-virtual {p1, v3, v1}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;Z)Z

    move-result v3

    iput-boolean v3, p0, Lcom/jibo/ui/activity/LoopInviteDetailsActivity;->m:Z

    goto :goto_0
.end method

.method public onDeclineClick(Landroid/view/View;)V
    .locals 5
    .annotation build Lbutterknife/OnClick;
    .end annotation

    .prologue
    const/4 v4, 0x0

    .line 185
    iget-object v0, p0, Lcom/jibo/ui/activity/LoopInviteDetailsActivity;->i:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;->isSuspended()Ljava/lang/Boolean;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 186
    invoke-direct {p0}, Lcom/jibo/ui/activity/LoopInviteDetailsActivity;->q()V

    .line 236
    :goto_0
    return-void

    .line 190
    :cond_0
    iget-object v0, p0, Lcom/jibo/ui/activity/LoopInviteDetailsActivity;->buttonAccept:Landroid/view/View;

    invoke-virtual {v0, v4}, Landroid/view/View;->setClickable(Z)V

    .line 191
    iget-object v0, p0, Lcom/jibo/ui/activity/LoopInviteDetailsActivity;->buttonDecline:Landroid/view/View;

    invoke-virtual {v0, v4}, Landroid/view/View;->setClickable(Z)V

    .line 193
    invoke-direct {p0}, Lcom/jibo/ui/activity/LoopInviteDetailsActivity;->t()V

    .line 195
    iget-object v0, p0, Lcom/jibo/ui/activity/LoopInviteDetailsActivity;->k:Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    if-nez v0, :cond_1

    .line 196
    new-instance v0, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    invoke-direct {v0}, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;-><init>()V

    iput-object v0, p0, Lcom/jibo/ui/activity/LoopInviteDetailsActivity;->k:Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    .line 198
    iget-object v0, p0, Lcom/jibo/ui/activity/LoopInviteDetailsActivity;->k:Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    const v1, 0x7f1000e9

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Object;

    iget-object v3, p0, Lcom/jibo/ui/activity/LoopInviteDetailsActivity;->i:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-virtual {v3}, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;->getName()Ljava/lang/String;

    move-result-object v3

    aput-object v3, v2, v4

    invoke-virtual {p0, v1, v2}, Lcom/jibo/ui/activity/LoopInviteDetailsActivity;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;->c(Ljava/lang/String;)V

    .line 199
    iget-object v0, p0, Lcom/jibo/ui/activity/LoopInviteDetailsActivity;->k:Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    invoke-virtual {p0}, Lcom/jibo/ui/activity/LoopInviteDetailsActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v1

    const-string v2, "CircleFragment"

    invoke-virtual {v0, v1, v2}, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;->show(Landroid/support/v4/app/FragmentManager;Ljava/lang/String;)V

    .line 200
    iget-object v0, p0, Lcom/jibo/ui/activity/LoopInviteDetailsActivity;->k:Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    new-instance v1, Lcom/jibo/ui/activity/LoopInviteDetailsActivity$3;

    invoke-direct {v1, p0}, Lcom/jibo/ui/activity/LoopInviteDetailsActivity$3;-><init>(Lcom/jibo/ui/activity/LoopInviteDetailsActivity;)V

    invoke-virtual {v0, v1}, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;->a(Lcom/jibo/ui/fragment/dialog/CircleProgressFragment$OnDismissListener;)V

    .line 214
    :cond_1
    invoke-static {p0}, Lcom/jibo/db/EntityData;->a(Landroid/content/Context;)Lcom/jibo/db/EntityData;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/db/EntityData;->b()Lcom/jibo/aws/integration/aws/services/loop/JiboLoopAsyncClient;

    move-result-object v0

    iget-object v1, p0, Lcom/jibo/ui/activity/LoopInviteDetailsActivity;->i:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-virtual {v1}, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;->getId()Ljava/lang/String;

    move-result-object v1

    new-instance v2, Lcom/jibo/ui/activity/LoopInviteDetailsActivity$4;

    invoke-direct {v2, p0}, Lcom/jibo/ui/activity/LoopInviteDetailsActivity$4;-><init>(Lcom/jibo/ui/activity/LoopInviteDetailsActivity;)V

    invoke-virtual {v0, v1, v2}, Lcom/jibo/aws/integration/aws/services/loop/JiboLoopAsyncClient;->declineInvitation(Ljava/lang/String;Lcom/amazonaws/handlers/AsyncHandler;)Ljava/util/concurrent/Future;

    goto :goto_0
.end method

.method public onJoinClick(Landroid/view/View;)V
    .locals 5
    .annotation build Lbutterknife/OnClick;
    .end annotation

    .prologue
    const/4 v4, 0x0

    .line 110
    iget-object v0, p0, Lcom/jibo/ui/activity/LoopInviteDetailsActivity;->i:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;->isSuspended()Ljava/lang/Boolean;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 111
    invoke-direct {p0}, Lcom/jibo/ui/activity/LoopInviteDetailsActivity;->q()V

    .line 176
    :goto_0
    return-void

    .line 115
    :cond_0
    iget-object v0, p0, Lcom/jibo/ui/activity/LoopInviteDetailsActivity;->buttonAccept:Landroid/view/View;

    invoke-virtual {v0, v4}, Landroid/view/View;->setClickable(Z)V

    .line 116
    iget-object v0, p0, Lcom/jibo/ui/activity/LoopInviteDetailsActivity;->buttonDecline:Landroid/view/View;

    invoke-virtual {v0, v4}, Landroid/view/View;->setClickable(Z)V

    .line 118
    invoke-direct {p0}, Lcom/jibo/ui/activity/LoopInviteDetailsActivity;->t()V

    .line 120
    iget-object v0, p0, Lcom/jibo/ui/activity/LoopInviteDetailsActivity;->k:Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    if-nez v0, :cond_1

    .line 121
    new-instance v0, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    invoke-direct {v0}, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;-><init>()V

    iput-object v0, p0, Lcom/jibo/ui/activity/LoopInviteDetailsActivity;->k:Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    .line 123
    iget-object v0, p0, Lcom/jibo/ui/activity/LoopInviteDetailsActivity;->k:Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    const v1, 0x7f1001ba

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Object;

    iget-object v3, p0, Lcom/jibo/ui/activity/LoopInviteDetailsActivity;->i:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-virtual {v3}, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;->getName()Ljava/lang/String;

    move-result-object v3

    aput-object v3, v2, v4

    invoke-virtual {p0, v1, v2}, Lcom/jibo/ui/activity/LoopInviteDetailsActivity;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;->c(Ljava/lang/String;)V

    .line 124
    iget-object v0, p0, Lcom/jibo/ui/activity/LoopInviteDetailsActivity;->k:Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    invoke-virtual {p0}, Lcom/jibo/ui/activity/LoopInviteDetailsActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v1

    const-string v2, "CircleFragment"

    invoke-virtual {v0, v1, v2}, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;->show(Landroid/support/v4/app/FragmentManager;Ljava/lang/String;)V

    .line 125
    iget-object v0, p0, Lcom/jibo/ui/activity/LoopInviteDetailsActivity;->k:Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    new-instance v1, Lcom/jibo/ui/activity/LoopInviteDetailsActivity$1;

    invoke-direct {v1, p0}, Lcom/jibo/ui/activity/LoopInviteDetailsActivity$1;-><init>(Lcom/jibo/ui/activity/LoopInviteDetailsActivity;)V

    invoke-virtual {v0, v1}, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;->a(Lcom/jibo/ui/fragment/dialog/CircleProgressFragment$OnDismissListener;)V

    .line 139
    :cond_1
    invoke-static {p0}, Lcom/jibo/db/EntityData;->a(Landroid/content/Context;)Lcom/jibo/db/EntityData;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/db/EntityData;->b()Lcom/jibo/aws/integration/aws/services/loop/JiboLoopAsyncClient;

    move-result-object v0

    iget-object v1, p0, Lcom/jibo/ui/activity/LoopInviteDetailsActivity;->i:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-virtual {v1}, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;->getId()Ljava/lang/String;

    move-result-object v1

    new-instance v2, Lcom/jibo/ui/activity/LoopInviteDetailsActivity$2;

    invoke-direct {v2, p0}, Lcom/jibo/ui/activity/LoopInviteDetailsActivity$2;-><init>(Lcom/jibo/ui/activity/LoopInviteDetailsActivity;)V

    invoke-virtual {v0, v1, v2}, Lcom/jibo/aws/integration/aws/services/loop/JiboLoopAsyncClient;->acceptInvitation(Ljava/lang/String;Lcom/amazonaws/handlers/AsyncHandler;)Ljava/util/concurrent/Future;

    goto :goto_0
.end method

.method public onOptionsItemSelected(Landroid/view/MenuItem;)Z
    .locals 2

    .prologue
    .line 100
    const v0, 0x102002c

    invoke-interface {p1}, Landroid/view/MenuItem;->getItemId()I

    move-result v1

    if-ne v0, v1, :cond_0

    .line 101
    invoke-virtual {p0}, Lcom/jibo/ui/activity/LoopInviteDetailsActivity;->finish()V

    .line 102
    const/4 v0, 0x1

    .line 104
    :goto_0
    return v0

    :cond_0
    invoke-super {p0, p1}, Lcom/jibo/ui/activity/BaseActivity;->onOptionsItemSelected(Landroid/view/MenuItem;)Z

    move-result v0

    goto :goto_0
.end method

.method protected onResume()V
    .locals 1

    const-string v0, "com.jibo.ui.activity.LoopInviteDetailsActivity"

    invoke-static {v0}, Lcom/google/firebase/perf/metrics/AppStartTrace;->setLauncherActivityOnResumeTime(Ljava/lang/String;)V

    invoke-super {p0}, Lcom/jibo/ui/activity/BaseActivity;->onResume()V

    return-void
.end method

.method protected onStart()V
    .locals 1

    const-string v0, "com.jibo.ui.activity.LoopInviteDetailsActivity"

    invoke-static {v0}, Lcom/google/firebase/perf/metrics/AppStartTrace;->setLauncherActivityOnStartTime(Ljava/lang/String;)V

    invoke-super {p0}, Lcom/jibo/ui/activity/BaseActivity;->onStart()V

    return-void
.end method
