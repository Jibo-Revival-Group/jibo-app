.class public Lcom/jibo/ui/fragment/home/MediaFragment;
.super Lcom/jibo/ui/fragment/BaseFragment;
.source "MediaFragment.java"

# interfaces
.implements Landroid/support/v4/app/LoaderManager$LoaderCallbacks;
.implements Landroid/support/v4/widget/SwipeRefreshLayout$OnRefreshListener;
.implements Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseRestoreDialog$BackupKeyRestoredListener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/jibo/ui/fragment/home/MediaFragment$PaginationAsyncTask;,
        Lcom/jibo/ui/fragment/home/MediaFragment$PhotoSelector;,
        Lcom/jibo/ui/fragment/home/MediaFragment$ModesHelper;,
        Lcom/jibo/ui/fragment/home/MediaFragment$SpacesItemDecoration;,
        Lcom/jibo/ui/fragment/home/MediaFragment$MediaCursor;,
        Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter;,
        Lcom/jibo/ui/fragment/home/MediaFragment$PhotoItemViewHolder;,
        Lcom/jibo/ui/fragment/home/MediaFragment$HeaderViewHolder;,
        Lcom/jibo/ui/fragment/home/MediaFragment$EmptyViewHolder;,
        Lcom/jibo/ui/fragment/home/MediaFragment$HeaderItem;,
        Lcom/jibo/ui/fragment/home/MediaFragment$ViewType;,
        Lcom/jibo/ui/fragment/home/MediaFragment$CustomGridLayoutManager;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/jibo/ui/fragment/BaseFragment;",
        "Landroid/support/v4/app/LoaderManager$LoaderCallbacks",
        "<",
        "Landroid/database/Cursor;",
        ">;",
        "Landroid/support/v4/widget/SwipeRefreshLayout$OnRefreshListener;",
        "Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseRestoreDialog$BackupKeyRestoredListener;"
    }
.end annotation


# instance fields
.field final a:I

.field final b:I

.field private c:Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter;

.field private d:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/Integer;",
            "Lcom/jibo/ui/fragment/home/MediaFragment$HeaderItem;",
            ">;"
        }
    .end annotation
.end field

.field private e:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lcom/jibo/aws/integration/aws/services/loop/model/Loop;",
            ">;"
        }
    .end annotation
.end field

.field emptyView:Landroid/view/View;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field private l:Z

.field list:Landroid/support/v7/widget/RecyclerView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field private m:Ljava/lang/Runnable;

.field private n:Lcom/jibo/ui/fragment/home/MediaFragment$PhotoSelector;

.field private o:Landroid/support/v7/view/ActionMode;

.field private p:Landroid/support/v7/view/ActionMode$Callback;

.field progressView:Landroid/view/View;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field private q:Landroid/content/BroadcastReceiver;

.field private r:Z

.field private s:Z

.field swipeRefreshLayout:Landroid/support/v4/widget/SwipeRefreshLayout;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field private t:Lcom/jibo/ui/fragment/home/MediaFragment$PaginationAsyncTask;

.field private u:Landroid/support/v7/widget/RecyclerView$OnScrollListener;

.field private v:Landroid/os/Handler;

.field viewNoKey:Landroid/view/View;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 3

    .prologue
    const/4 v2, 0x1

    .line 257
    invoke-direct {p0}, Lcom/jibo/ui/fragment/BaseFragment;-><init>()V

    .line 125
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/jibo/ui/fragment/home/MediaFragment;->d:Ljava/util/Map;

    .line 127
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/jibo/ui/fragment/home/MediaFragment;->e:Ljava/util/Map;

    .line 131
    new-instance v0, Lcom/jibo/ui/fragment/home/MediaFragment$1;

    invoke-direct {v0, p0}, Lcom/jibo/ui/fragment/home/MediaFragment$1;-><init>(Lcom/jibo/ui/fragment/home/MediaFragment;)V

    iput-object v0, p0, Lcom/jibo/ui/fragment/home/MediaFragment;->m:Ljava/lang/Runnable;

    .line 139
    new-instance v0, Lcom/jibo/ui/fragment/home/MediaFragment$PhotoSelector;

    const/4 v1, 0x0

    invoke-direct {v0, v1}, Lcom/jibo/ui/fragment/home/MediaFragment$PhotoSelector;-><init>(Lcom/jibo/ui/fragment/home/MediaFragment$1;)V

    iput-object v0, p0, Lcom/jibo/ui/fragment/home/MediaFragment;->n:Lcom/jibo/ui/fragment/home/MediaFragment$PhotoSelector;

    .line 141
    new-instance v0, Lcom/jibo/ui/fragment/home/MediaFragment$2;

    invoke-direct {v0, p0}, Lcom/jibo/ui/fragment/home/MediaFragment$2;-><init>(Lcom/jibo/ui/fragment/home/MediaFragment;)V

    iput-object v0, p0, Lcom/jibo/ui/fragment/home/MediaFragment;->p:Landroid/support/v7/view/ActionMode$Callback;

    .line 195
    new-instance v0, Lcom/jibo/ui/fragment/home/MediaFragment$3;

    invoke-direct {v0, p0}, Lcom/jibo/ui/fragment/home/MediaFragment$3;-><init>(Lcom/jibo/ui/fragment/home/MediaFragment;)V

    iput-object v0, p0, Lcom/jibo/ui/fragment/home/MediaFragment;->q:Landroid/content/BroadcastReceiver;

    .line 453
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/jibo/ui/fragment/home/MediaFragment;->r:Z

    iput-boolean v2, p0, Lcom/jibo/ui/fragment/home/MediaFragment;->s:Z

    .line 456
    new-instance v0, Lcom/jibo/ui/fragment/home/MediaFragment$4;

    invoke-direct {v0, p0}, Lcom/jibo/ui/fragment/home/MediaFragment$4;-><init>(Lcom/jibo/ui/fragment/home/MediaFragment;)V

    iput-object v0, p0, Lcom/jibo/ui/fragment/home/MediaFragment;->u:Landroid/support/v7/widget/RecyclerView$OnScrollListener;

    .line 1806
    new-instance v0, Lcom/jibo/ui/fragment/home/MediaFragment$7;

    invoke-direct {v0, p0}, Lcom/jibo/ui/fragment/home/MediaFragment$7;-><init>(Lcom/jibo/ui/fragment/home/MediaFragment;)V

    iput-object v0, p0, Lcom/jibo/ui/fragment/home/MediaFragment;->v:Landroid/os/Handler;

    .line 1819
    iput v2, p0, Lcom/jibo/ui/fragment/home/MediaFragment;->a:I

    .line 1820
    const/4 v0, 0x2

    iput v0, p0, Lcom/jibo/ui/fragment/home/MediaFragment;->b:I

    .line 258
    return-void
.end method

.method static synthetic a(Lcom/jibo/ui/fragment/home/MediaFragment;Landroid/support/v7/view/ActionMode;)Landroid/support/v7/view/ActionMode;
    .locals 0

    .prologue
    .line 106
    iput-object p1, p0, Lcom/jibo/ui/fragment/home/MediaFragment;->o:Landroid/support/v7/view/ActionMode;

    return-object p1
.end method

.method static synthetic a(Lcom/jibo/ui/fragment/home/MediaFragment;)Lcom/jibo/ui/activity/TabbedActivity;
    .locals 1

    .prologue
    .line 106
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/home/MediaFragment;->p()Lcom/jibo/ui/activity/TabbedActivity;

    move-result-object v0

    return-object v0
.end method

.method static synthetic a(Lcom/jibo/ui/fragment/home/MediaFragment;Lcom/jibo/ui/fragment/home/MediaFragment$PaginationAsyncTask;)Lcom/jibo/ui/fragment/home/MediaFragment$PaginationAsyncTask;
    .locals 0

    .prologue
    .line 106
    iput-object p1, p0, Lcom/jibo/ui/fragment/home/MediaFragment;->t:Lcom/jibo/ui/fragment/home/MediaFragment$PaginationAsyncTask;

    return-object p1
.end method

.method private a(I)V
    .locals 3

    .prologue
    .line 1425
    iget-object v0, p0, Lcom/jibo/ui/fragment/home/MediaFragment;->d:Ljava/util/Map;

    invoke-interface {v0}, Ljava/util/Map;->values()Ljava/util/Collection;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :cond_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_1

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/fragment/home/MediaFragment$HeaderItem;

    .line 1426
    iget v2, v0, Lcom/jibo/ui/fragment/home/MediaFragment$HeaderItem;->d:I

    if-lt p1, v2, :cond_0

    iget v2, v0, Lcom/jibo/ui/fragment/home/MediaFragment$HeaderItem;->e:I

    if-gt p1, v2, :cond_0

    .line 1427
    iget-object v1, p0, Lcom/jibo/ui/fragment/home/MediaFragment;->c:Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter;

    iget v0, v0, Lcom/jibo/ui/fragment/home/MediaFragment$HeaderItem;->d:I

    add-int/lit8 v0, v0, -0x1

    const/4 v2, 0x1

    invoke-virtual {v1, v0, v2}, Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter;->notifyItemRangeChanged(II)V

    .line 1431
    :cond_1
    return-void
.end method

.method static synthetic a(Lcom/jibo/ui/fragment/home/MediaFragment;I)V
    .locals 0

    .prologue
    .line 106
    invoke-direct {p0, p1}, Lcom/jibo/ui/fragment/home/MediaFragment;->a(I)V

    return-void
.end method

.method static synthetic a(Lcom/jibo/ui/fragment/home/MediaFragment;Z)Z
    .locals 0

    .prologue
    .line 106
    iput-boolean p1, p0, Lcom/jibo/ui/fragment/home/MediaFragment;->r:Z

    return p1
.end method

.method static synthetic b(Lcom/jibo/ui/fragment/home/MediaFragment;)Lcom/jibo/ui/fragment/home/MediaFragment$PhotoSelector;
    .locals 1

    .prologue
    .line 106
    iget-object v0, p0, Lcom/jibo/ui/fragment/home/MediaFragment;->n:Lcom/jibo/ui/fragment/home/MediaFragment$PhotoSelector;

    return-object v0
.end method

.method private b()V
    .locals 5

    .prologue
    const/4 v2, 0x0

    const/4 v1, 0x1

    .line 478
    iget-object v0, p0, Lcom/jibo/ui/fragment/home/MediaFragment;->list:Landroid/support/v7/widget/RecyclerView;

    if-nez v0, :cond_0

    .line 538
    :goto_0
    return-void

    .line 482
    :cond_0
    new-instance v3, Lcom/jibo/ui/fragment/home/MediaFragment$CustomGridLayoutManager;

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/home/MediaFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    .line 483
    invoke-static {}, Lcom/jibo/ui/fragment/home/MediaFragment$ModesHelper;->b()I

    move-result v4

    invoke-direct {v3, v0, v4, v1, v2}, Lcom/jibo/ui/fragment/home/MediaFragment$CustomGridLayoutManager;-><init>(Landroid/content/Context;IIZ)V

    .line 487
    iget-object v0, p0, Lcom/jibo/ui/fragment/home/MediaFragment;->list:Landroid/support/v7/widget/RecyclerView;

    invoke-virtual {v0}, Landroid/support/v7/widget/RecyclerView;->removeAllViewsInLayout()V

    .line 488
    iget-object v0, p0, Lcom/jibo/ui/fragment/home/MediaFragment;->list:Landroid/support/v7/widget/RecyclerView;

    invoke-virtual {v0, v1}, Landroid/support/v7/widget/RecyclerView;->setHasFixedSize(Z)V

    .line 495
    iget-object v0, p0, Lcom/jibo/ui/fragment/home/MediaFragment;->list:Landroid/support/v7/widget/RecyclerView;

    iget-object v4, p0, Lcom/jibo/ui/fragment/home/MediaFragment;->u:Landroid/support/v7/widget/RecyclerView$OnScrollListener;

    invoke-virtual {v0, v4}, Landroid/support/v7/widget/RecyclerView;->removeOnScrollListener(Landroid/support/v7/widget/RecyclerView$OnScrollListener;)V

    .line 496
    iget-object v0, p0, Lcom/jibo/ui/fragment/home/MediaFragment;->list:Landroid/support/v7/widget/RecyclerView;

    iget-object v4, p0, Lcom/jibo/ui/fragment/home/MediaFragment;->u:Landroid/support/v7/widget/RecyclerView$OnScrollListener;

    invoke-virtual {v0, v4}, Landroid/support/v7/widget/RecyclerView;->addOnScrollListener(Landroid/support/v7/widget/RecyclerView$OnScrollListener;)V

    .line 500
    :try_start_0
    iget-object v0, p0, Lcom/jibo/ui/fragment/home/MediaFragment;->list:Landroid/support/v7/widget/RecyclerView;

    invoke-virtual {v0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v0

    const-string v4, "mItemDecorations"

    invoke-virtual {v0, v4}, Ljava/lang/Class;->getDeclaredField(Ljava/lang/String;)Ljava/lang/reflect/Field;

    move-result-object v0

    .line 501
    const/4 v4, 0x1

    invoke-virtual {v0, v4}, Ljava/lang/reflect/Field;->setAccessible(Z)V

    .line 502
    iget-object v4, p0, Lcom/jibo/ui/fragment/home/MediaFragment;->list:Landroid/support/v7/widget/RecyclerView;

    invoke-virtual {v0, v4}, Ljava/lang/reflect/Field;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/ArrayList;

    .line 503
    invoke-virtual {v0}, Ljava/util/ArrayList;->clear()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 507
    :goto_1
    iget-object v0, p0, Lcom/jibo/ui/fragment/home/MediaFragment;->list:Landroid/support/v7/widget/RecyclerView;

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/home/MediaFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v4

    invoke-static {v4}, Lcom/jibo/ui/fragment/home/MediaFragment$ModesHelper;->a(Landroid/content/Context;)Landroid/support/v7/widget/RecyclerView$ItemDecoration;

    move-result-object v4

    invoke-virtual {v0, v4}, Landroid/support/v7/widget/RecyclerView;->addItemDecoration(Landroid/support/v7/widget/RecyclerView$ItemDecoration;)V

    .line 508
    iget-object v0, p0, Lcom/jibo/ui/fragment/home/MediaFragment;->list:Landroid/support/v7/widget/RecyclerView;

    new-instance v4, Landroid/support/v7/widget/DefaultItemAnimator;

    invoke-direct {v4}, Landroid/support/v7/widget/DefaultItemAnimator;-><init>()V

    invoke-virtual {v0, v4}, Landroid/support/v7/widget/RecyclerView;->setItemAnimator(Landroid/support/v7/widget/RecyclerView$ItemAnimator;)V

    .line 509
    iget-object v0, p0, Lcom/jibo/ui/fragment/home/MediaFragment;->list:Landroid/support/v7/widget/RecyclerView;

    invoke-virtual {v0, v3}, Landroid/support/v7/widget/RecyclerView;->setLayoutManager(Landroid/support/v7/widget/RecyclerView$LayoutManager;)V

    .line 511
    iget-object v4, p0, Lcom/jibo/ui/fragment/home/MediaFragment;->list:Landroid/support/v7/widget/RecyclerView;

    invoke-static {}, Lcom/jibo/ui/fragment/home/MediaFragment$ModesHelper;->a()Z

    move-result v0

    if-nez v0, :cond_1

    move v0, v1

    :goto_2
    invoke-virtual {v4, v0}, Landroid/support/v7/widget/RecyclerView;->setHapticFeedbackEnabled(Z)V

    .line 513
    new-instance v0, Lcom/jibo/ui/fragment/home/MediaFragment$5;

    invoke-direct {v0, p0}, Lcom/jibo/ui/fragment/home/MediaFragment$5;-><init>(Lcom/jibo/ui/fragment/home/MediaFragment;)V

    invoke-virtual {v3, v0}, Lcom/jibo/ui/fragment/home/MediaFragment$CustomGridLayoutManager;->a(Landroid/support/v7/widget/GridLayoutManager$SpanSizeLookup;)V

    .line 533
    new-instance v0, Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter;

    const/4 v1, 0x0

    iget-object v2, p0, Lcom/jibo/ui/fragment/home/MediaFragment;->n:Lcom/jibo/ui/fragment/home/MediaFragment$PhotoSelector;

    invoke-direct {v0, p0, p0, v1, v2}, Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter;-><init>(Lcom/jibo/ui/fragment/home/MediaFragment;Lcom/jibo/ui/fragment/home/MediaFragment;Landroid/database/Cursor;Lcom/jibo/ui/fragment/home/MediaFragment$PhotoSelector;)V

    iput-object v0, p0, Lcom/jibo/ui/fragment/home/MediaFragment;->c:Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter;

    .line 534
    iget-object v0, p0, Lcom/jibo/ui/fragment/home/MediaFragment;->list:Landroid/support/v7/widget/RecyclerView;

    iget-object v1, p0, Lcom/jibo/ui/fragment/home/MediaFragment;->c:Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter;

    invoke-virtual {v0, v1}, Landroid/support/v7/widget/RecyclerView;->setAdapter(Landroid/support/v7/widget/RecyclerView$Adapter;)V

    .line 537
    iget-object v0, p0, Lcom/jibo/ui/fragment/home/MediaFragment;->swipeRefreshLayout:Landroid/support/v4/widget/SwipeRefreshLayout;

    invoke-static {}, Lcom/jibo/ui/fragment/home/MediaFragment$ModesHelper;->a()Z

    move-result v1

    invoke-virtual {v0, v1}, Landroid/support/v4/widget/SwipeRefreshLayout;->setEnabled(Z)V

    goto/16 :goto_0

    .line 504
    :catch_0
    move-exception v0

    .line 505
    invoke-static {v0}, Lcom/crashlytics/android/Crashlytics;->a(Ljava/lang/Throwable;)V

    goto :goto_1

    :cond_1
    move v0, v2

    .line 511
    goto :goto_2
.end method

.method private b(Lcom/jibo/aws/integration/aws/services/loop/model/Loop;)Z
    .locals 3

    .prologue
    .line 899
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/home/MediaFragment;->getContext()Landroid/content/Context;

    move-result-object v0

    .line 900
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/home/MediaFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    invoke-static {v1}, Lcom/jibo/db/EntityData;->a(Landroid/content/Context;)Lcom/jibo/db/EntityData;

    move-result-object v1

    invoke-virtual {v1}, Lcom/jibo/db/EntityData;->i()Lcom/jibo/aws/integration/aws/services/account/model/Account;

    move-result-object v1

    invoke-virtual {v1}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getId()Ljava/lang/String;

    move-result-object v1

    .line 899
    invoke-static {v0, v1}, Lcom/jibo/aws/integration/util/KeyManager;->getInstance(Landroid/content/Context;Ljava/lang/String;)Lcom/jibo/aws/integration/util/KeyManager;

    move-result-object v0

    .line 904
    :try_start_0
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/home/MediaFragment;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-virtual {p1}, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;->getId()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lcom/jibo/aws/integration/util/KeyManager;->obtainKeyHolder(Landroid/content/Context;Ljava/lang/String;)Lcom/jibo/aws/integration/util/KeyManager$SymmetricKeyHolder;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    .line 909
    :goto_0
    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_1
    return v0

    .line 905
    :catch_0
    move-exception v0

    .line 906
    const/4 v0, 0x0

    goto :goto_0

    .line 909
    :cond_0
    const/4 v0, 0x0

    goto :goto_1
.end method

.method static synthetic b(Lcom/jibo/ui/fragment/home/MediaFragment;Z)Z
    .locals 0

    .prologue
    .line 106
    iput-boolean p1, p0, Lcom/jibo/ui/fragment/home/MediaFragment;->s:Z

    return p1
.end method

.method static synthetic c(Lcom/jibo/ui/fragment/home/MediaFragment;)Lcom/jibo/ui/activity/TabbedActivity;
    .locals 1

    .prologue
    .line 106
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/home/MediaFragment;->p()Lcom/jibo/ui/activity/TabbedActivity;

    move-result-object v0

    return-object v0
.end method

.method static synthetic d(Lcom/jibo/ui/fragment/home/MediaFragment;)Ljava/lang/Runnable;
    .locals 1

    .prologue
    .line 106
    iget-object v0, p0, Lcom/jibo/ui/fragment/home/MediaFragment;->m:Ljava/lang/Runnable;

    return-object v0
.end method

.method static synthetic e(Lcom/jibo/ui/fragment/home/MediaFragment;)V
    .locals 0

    .prologue
    .line 106
    invoke-direct {p0}, Lcom/jibo/ui/fragment/home/MediaFragment;->s()V

    return-void
.end method

.method static synthetic f(Lcom/jibo/ui/fragment/home/MediaFragment;)Lcom/jibo/ui/activity/TabbedActivity;
    .locals 1

    .prologue
    .line 106
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/home/MediaFragment;->p()Lcom/jibo/ui/activity/TabbedActivity;

    move-result-object v0

    return-object v0
.end method

.method static synthetic g(Lcom/jibo/ui/fragment/home/MediaFragment;)Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter;
    .locals 1

    .prologue
    .line 106
    iget-object v0, p0, Lcom/jibo/ui/fragment/home/MediaFragment;->c:Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter;

    return-object v0
.end method

.method static synthetic h(Lcom/jibo/ui/fragment/home/MediaFragment;)Landroid/support/v7/view/ActionMode$Callback;
    .locals 1

    .prologue
    .line 106
    iget-object v0, p0, Lcom/jibo/ui/fragment/home/MediaFragment;->p:Landroid/support/v7/view/ActionMode$Callback;

    return-object v0
.end method

.method static synthetic i(Lcom/jibo/ui/fragment/home/MediaFragment;)Z
    .locals 1

    .prologue
    .line 106
    iget-boolean v0, p0, Lcom/jibo/ui/fragment/home/MediaFragment;->r:Z

    return v0
.end method

.method static synthetic j(Lcom/jibo/ui/fragment/home/MediaFragment;)Z
    .locals 1

    .prologue
    .line 106
    iget-boolean v0, p0, Lcom/jibo/ui/fragment/home/MediaFragment;->s:Z

    return v0
.end method

.method static synthetic k(Lcom/jibo/ui/fragment/home/MediaFragment;)Lcom/jibo/ui/fragment/home/MediaFragment$PaginationAsyncTask;
    .locals 1

    .prologue
    .line 106
    iget-object v0, p0, Lcom/jibo/ui/fragment/home/MediaFragment;->t:Lcom/jibo/ui/fragment/home/MediaFragment$PaginationAsyncTask;

    return-object v0
.end method

.method static synthetic l(Lcom/jibo/ui/fragment/home/MediaFragment;)Ljava/util/Map;
    .locals 1

    .prologue
    .line 106
    iget-object v0, p0, Lcom/jibo/ui/fragment/home/MediaFragment;->e:Ljava/util/Map;

    return-object v0
.end method

.method static synthetic m(Lcom/jibo/ui/fragment/home/MediaFragment;)Lcom/jibo/ui/activity/TabbedActivity;
    .locals 1

    .prologue
    .line 106
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/home/MediaFragment;->p()Lcom/jibo/ui/activity/TabbedActivity;

    move-result-object v0

    return-object v0
.end method

.method static synthetic n(Lcom/jibo/ui/fragment/home/MediaFragment;)Lcom/jibo/ui/activity/TabbedActivity;
    .locals 1

    .prologue
    .line 106
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/home/MediaFragment;->p()Lcom/jibo/ui/activity/TabbedActivity;

    move-result-object v0

    return-object v0
.end method

.method static synthetic o(Lcom/jibo/ui/fragment/home/MediaFragment;)Lcom/jibo/ui/activity/TabbedActivity;
    .locals 1

    .prologue
    .line 106
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/home/MediaFragment;->p()Lcom/jibo/ui/activity/TabbedActivity;

    move-result-object v0

    return-object v0
.end method

.method static synthetic p(Lcom/jibo/ui/fragment/home/MediaFragment;)Lcom/jibo/ui/activity/TabbedActivity;
    .locals 1

    .prologue
    .line 106
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/home/MediaFragment;->p()Lcom/jibo/ui/activity/TabbedActivity;

    move-result-object v0

    return-object v0
.end method

.method static synthetic q(Lcom/jibo/ui/fragment/home/MediaFragment;)Lcom/jibo/ui/activity/TabbedActivity;
    .locals 1

    .prologue
    .line 106
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/home/MediaFragment;->p()Lcom/jibo/ui/activity/TabbedActivity;

    move-result-object v0

    return-object v0
.end method

.method private q()V
    .locals 2

    .prologue
    .line 541
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/home/MediaFragment;->g()V

    .line 542
    iget-object v0, p0, Lcom/jibo/ui/fragment/home/MediaFragment;->swipeRefreshLayout:Landroid/support/v4/widget/SwipeRefreshLayout;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/support/v4/widget/SwipeRefreshLayout;->setRefreshing(Z)V

    .line 543
    return-void
.end method

.method static synthetic r(Lcom/jibo/ui/fragment/home/MediaFragment;)Lcom/jibo/ui/activity/TabbedActivity;
    .locals 1

    .prologue
    .line 106
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/home/MediaFragment;->p()Lcom/jibo/ui/activity/TabbedActivity;

    move-result-object v0

    return-object v0
.end method

.method private r()V
    .locals 7

    .prologue
    const/4 v1, 0x0

    .line 550
    iget-object v0, p0, Lcom/jibo/ui/fragment/home/MediaFragment;->n:Lcom/jibo/ui/fragment/home/MediaFragment$PhotoSelector;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/home/MediaFragment$PhotoSelector;->c()Landroid/util/SparseBooleanArray;

    move-result-object v3

    .line 551
    new-instance v4, Ljava/util/ArrayList;

    invoke-direct {v4}, Ljava/util/ArrayList;-><init>()V

    move v0, v1

    .line 552
    :goto_0
    invoke-virtual {v3}, Landroid/util/SparseBooleanArray;->size()I

    move-result v2

    if-ge v0, v2, :cond_1

    .line 554
    :try_start_0
    invoke-virtual {v3, v0}, Landroid/util/SparseBooleanArray;->keyAt(I)I

    move-result v2

    .line 555
    const/4 v5, 0x0

    invoke-virtual {v3, v2, v5}, Landroid/util/SparseBooleanArray;->get(IZ)Z

    move-result v5

    if-eqz v5, :cond_0

    .line 557
    iget-object v5, p0, Lcom/jibo/ui/fragment/home/MediaFragment;->c:Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter;

    invoke-virtual {v5, v2}, Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter;->a(I)I

    move-result v2

    .line 559
    iget-object v5, p0, Lcom/jibo/ui/fragment/home/MediaFragment;->c:Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter;

    invoke-virtual {v5}, Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter;->a()Landroid/database/Cursor;

    move-result-object v5

    if-eqz v5, :cond_0

    if-ltz v2, :cond_0

    .line 561
    iget-object v5, p0, Lcom/jibo/ui/fragment/home/MediaFragment;->c:Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter;

    invoke-virtual {v5}, Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter;->a()Landroid/database/Cursor;

    move-result-object v5

    invoke-interface {v5, v2}, Landroid/database/Cursor;->moveToPosition(I)Z

    .line 562
    iget-object v2, p0, Lcom/jibo/ui/fragment/home/MediaFragment;->c:Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter;

    invoke-virtual {v2}, Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter;->a()Landroid/database/Cursor;

    move-result-object v2

    iget-object v5, p0, Lcom/jibo/ui/fragment/home/MediaFragment;->c:Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter;

    .line 563
    invoke-virtual {v5}, Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter;->a()Landroid/database/Cursor;

    move-result-object v5

    const-string v6, "_id"

    invoke-interface {v5, v6}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v5

    invoke-interface {v2, v5}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v2

    .line 562
    invoke-interface {v4, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 552
    :cond_0
    :goto_1
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 567
    :catch_0
    move-exception v2

    .line 568
    invoke-static {v2}, Lcom/crashlytics/android/Crashlytics;->a(Ljava/lang/Throwable;)V

    goto :goto_1

    .line 572
    :cond_1
    invoke-interface {v4}, Ljava/util/List;->size()I

    move-result v0

    if-lez v0, :cond_2

    .line 573
    invoke-interface {v4}, Ljava/util/List;->size()I

    move-result v0

    new-array v0, v0, [Ljava/lang/String;

    .line 574
    invoke-interface {v4, v0}, Ljava/util/List;->toArray([Ljava/lang/Object;)[Ljava/lang/Object;

    .line 575
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/home/MediaFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v2

    invoke-static {v2, v0, v1}, Lcom/jibo/service/MediaDeletingService;->a(Landroid/content/Context;[Ljava/lang/String;Z)V

    .line 577
    :cond_2
    return-void
.end method

.method static synthetic s(Lcom/jibo/ui/fragment/home/MediaFragment;)Lcom/jibo/ui/activity/TabbedActivity;
    .locals 1

    .prologue
    .line 106
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/home/MediaFragment;->p()Lcom/jibo/ui/activity/TabbedActivity;

    move-result-object v0

    return-object v0
.end method

.method private s()V
    .locals 6

    .prologue
    const/4 v1, 0x0

    .line 583
    iget-object v0, p0, Lcom/jibo/ui/fragment/home/MediaFragment;->n:Lcom/jibo/ui/fragment/home/MediaFragment$PhotoSelector;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/home/MediaFragment$PhotoSelector;->c()Landroid/util/SparseBooleanArray;

    move-result-object v3

    .line 584
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    .line 585
    :goto_0
    invoke-virtual {v3}, Landroid/util/SparseBooleanArray;->size()I

    move-result v2

    if-ge v1, v2, :cond_1

    .line 587
    :try_start_0
    invoke-virtual {v3, v1}, Landroid/util/SparseBooleanArray;->keyAt(I)I

    move-result v2

    .line 588
    const/4 v4, 0x0

    invoke-virtual {v3, v2, v4}, Landroid/util/SparseBooleanArray;->get(IZ)Z

    move-result v4

    if-eqz v4, :cond_0

    .line 590
    iget-object v4, p0, Lcom/jibo/ui/fragment/home/MediaFragment;->c:Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter;

    invoke-virtual {v4, v2}, Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter;->a(I)I

    move-result v2

    .line 592
    iget-object v4, p0, Lcom/jibo/ui/fragment/home/MediaFragment;->c:Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter;

    invoke-virtual {v4}, Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter;->a()Landroid/database/Cursor;

    move-result-object v4

    if-eqz v4, :cond_0

    if-ltz v2, :cond_0

    .line 594
    iget-object v4, p0, Lcom/jibo/ui/fragment/home/MediaFragment;->c:Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter;

    invoke-virtual {v4}, Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter;->a()Landroid/database/Cursor;

    move-result-object v4

    invoke-interface {v4, v2}, Landroid/database/Cursor;->moveToPosition(I)Z

    .line 596
    iget-object v2, p0, Lcom/jibo/ui/fragment/home/MediaFragment;->c:Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter;

    invoke-virtual {v2}, Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter;->a()Landroid/database/Cursor;

    move-result-object v2

    iget-object v4, p0, Lcom/jibo/ui/fragment/home/MediaFragment;->c:Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter;

    .line 597
    invoke-virtual {v4}, Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter;->a()Landroid/database/Cursor;

    move-result-object v4

    const-string v5, "reference"

    invoke-interface {v4, v5}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v4

    invoke-interface {v2, v4}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v2

    .line 600
    invoke-static {v2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v4

    if-nez v4, :cond_0

    .line 601
    invoke-interface {v0, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 585
    :cond_0
    :goto_1
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 604
    :catch_0
    move-exception v2

    .line 605
    invoke-static {v2}, Lcom/crashlytics/android/Crashlytics;->a(Ljava/lang/Throwable;)V

    goto :goto_1

    .line 609
    :cond_1
    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v1

    if-lez v1, :cond_2

    .line 610
    new-instance v1, Landroid/os/Bundle;

    invoke-direct {v1}, Landroid/os/Bundle;-><init>()V

    .line 611
    const-string v2, "ARG_IDS"

    check-cast v0, Ljava/util/ArrayList;

    invoke-virtual {v1, v2, v0}, Landroid/os/Bundle;->putStringArrayList(Ljava/lang/String;Ljava/util/ArrayList;)V

    .line 612
    new-instance v0, Lcom/jibo/ui/fragment/dialog/DownloadProgressFragment;

    invoke-direct {v0}, Lcom/jibo/ui/fragment/dialog/DownloadProgressFragment;-><init>()V

    .line 613
    invoke-virtual {v0, v1}, Lcom/jibo/ui/fragment/dialog/DownloadProgressFragment;->setArguments(Landroid/os/Bundle;)V

    .line 614
    const/16 v1, 0x76

    invoke-virtual {v0, p0, v1}, Lcom/jibo/ui/fragment/dialog/DownloadProgressFragment;->setTargetFragment(Landroid/support/v4/app/Fragment;I)V

    .line 615
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/home/MediaFragment;->getFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v1

    const-class v2, Lcom/jibo/ui/fragment/dialog/DownloadProgressFragment;

    invoke-virtual {v2}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lcom/jibo/ui/fragment/dialog/DownloadProgressFragment;->show(Landroid/support/v4/app/FragmentManager;Ljava/lang/String;)V

    .line 617
    :cond_2
    return-void
.end method

.method static synthetic t(Lcom/jibo/ui/fragment/home/MediaFragment;)Lcom/jibo/ui/activity/TabbedActivity;
    .locals 1

    .prologue
    .line 106
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/home/MediaFragment;->p()Lcom/jibo/ui/activity/TabbedActivity;

    move-result-object v0

    return-object v0
.end method

.method private t()V
    .locals 3

    .prologue
    .line 852
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/home/MediaFragment;->d()Z

    move-result v0

    if-nez v0, :cond_1

    .line 860
    :cond_0
    :goto_0
    return-void

    .line 854
    :cond_1
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/home/MediaFragment;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Lcom/jibo/utils/SharedPreferencesUtil;->f(Landroid/content/Context;)Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    move-result-object v0

    .line 856
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/home/MediaFragment;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;->getId()Ljava/lang/String;

    move-result-object v2

    iget-boolean v0, p0, Lcom/jibo/ui/fragment/home/MediaFragment;->l:Z

    if-nez v0, :cond_2

    const/4 v0, 0x1

    :goto_1
    invoke-static {v1, v2, v0}, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils;->a(Landroid/content/Context;Ljava/lang/String;Z)Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$DialogType;

    move-result-object v0

    .line 857
    if-eqz v0, :cond_0

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/home/MediaFragment;->getFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v1

    invoke-static {v1}, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils;->a(Landroid/support/v4/app/FragmentManager;)Z

    move-result v1

    if-nez v1, :cond_0

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/home/MediaFragment;->d()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 858
    invoke-static {p0, v0}, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils;->a(Landroid/support/v4/app/Fragment;Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$DialogType;)V

    goto :goto_0

    .line 856
    :cond_2
    const/4 v0, 0x0

    goto :goto_1
.end method

.method static synthetic u(Lcom/jibo/ui/fragment/home/MediaFragment;)Lcom/jibo/ui/activity/TabbedActivity;
    .locals 1

    .prologue
    .line 106
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/home/MediaFragment;->p()Lcom/jibo/ui/activity/TabbedActivity;

    move-result-object v0

    return-object v0
.end method

.method private u()V
    .locals 3

    .prologue
    .line 863
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/home/MediaFragment;->d()Z

    move-result v0

    if-nez v0, :cond_1

    .line 895
    :cond_0
    :goto_0
    return-void

    .line 865
    :cond_1
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/home/MediaFragment;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Lcom/jibo/utils/SharedPreferencesUtil;->f(Landroid/content/Context;)Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    move-result-object v0

    .line 866
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 867
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/home/MediaFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v2

    invoke-static {v2}, Lcom/jibo/utils/SharedPreferencesUtil;->m(Landroid/content/Context;)[Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Ljava/util/Collections;->addAll(Ljava/util/Collection;[Ljava/lang/Object;)Z

    .line 869
    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;->getId()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/util/ArrayList;->indexOf(Ljava/lang/Object;)I

    move-result v1

    if-ltz v1, :cond_0

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/home/MediaFragment;->getFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v1

    invoke-static {v1}, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils;->a(Landroid/support/v4/app/FragmentManager;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 870
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/home/MediaFragment;->d()Z

    move-result v1

    if-eqz v1, :cond_0

    invoke-direct {p0, v0}, Lcom/jibo/ui/fragment/home/MediaFragment;->b(Lcom/jibo/aws/integration/aws/services/loop/model/Loop;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 872
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/home/MediaFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;->getId()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lcom/jibo/utils/SharedPreferencesUtil;->e(Landroid/content/Context;Ljava/lang/String;)V

    .line 874
    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;->getId()Ljava/lang/String;

    move-result-object v1

    new-instance v2, Lcom/jibo/ui/fragment/home/MediaFragment$6;

    invoke-direct {v2, p0, v0}, Lcom/jibo/ui/fragment/home/MediaFragment$6;-><init>(Lcom/jibo/ui/fragment/home/MediaFragment;Lcom/jibo/aws/integration/aws/services/loop/model/Loop;)V

    invoke-static {v1, p0, v2}, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils;->a(Ljava/lang/String;Lcom/jibo/ui/fragment/BaseFragment;Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$KeyBackupCheckListener;)V

    goto :goto_0
.end method

.method static synthetic v(Lcom/jibo/ui/fragment/home/MediaFragment;)V
    .locals 0

    .prologue
    .line 106
    invoke-direct {p0}, Lcom/jibo/ui/fragment/home/MediaFragment;->t()V

    return-void
.end method

.method static synthetic w(Lcom/jibo/ui/fragment/home/MediaFragment;)V
    .locals 0

    .prologue
    .line 106
    invoke-direct {p0}, Lcom/jibo/ui/fragment/home/MediaFragment;->u()V

    return-void
.end method


# virtual methods
.method public a(ILandroid/os/Bundle;)Landroid/support/v4/content/Loader;
    .locals 7
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I",
            "Landroid/os/Bundle;",
            ")",
            "Landroid/support/v4/content/Loader",
            "<",
            "Landroid/database/Cursor;",
            ">;"
        }
    .end annotation

    .prologue
    const/4 v4, 0x0

    .line 329
    packed-switch p1, :pswitch_data_0

    :pswitch_0
    move-object v0, v4

    .line 337
    :goto_0
    return-object v0

    .line 331
    :pswitch_1
    new-instance v0, Landroid/support/v4/content/CursorLoader;

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/home/MediaFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    const/16 v2, 0x8

    .line 332
    invoke-static {v2}, Lcom/jibo/db/DatabaseContract$EntityEntry;->a(I)Landroid/net/Uri;

    move-result-object v2

    sget-object v3, Lcom/jibo/db/DatabaseContract$EntityEntry;->a:[Ljava/lang/String;

    move-object v5, v4

    move-object v6, v4

    invoke-direct/range {v0 .. v6}, Landroid/support/v4/content/CursorLoader;-><init>(Landroid/content/Context;Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 335
    :pswitch_2
    new-instance v0, Lcom/jibo/ui/fragment/home/MediaFragment$MediaCursor;

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/home/MediaFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    iget-object v2, p0, Lcom/jibo/ui/fragment/home/MediaFragment;->d:Ljava/util/Map;

    iget-object v3, p0, Lcom/jibo/ui/fragment/home/MediaFragment;->e:Ljava/util/Map;

    invoke-direct {v0, v1, v2, v3}, Lcom/jibo/ui/fragment/home/MediaFragment$MediaCursor;-><init>(Landroid/content/Context;Ljava/util/Map;Ljava/util/Map;)V

    goto :goto_0

    .line 329
    :pswitch_data_0
    .packed-switch 0x7f0901c5
        :pswitch_1
        :pswitch_0
        :pswitch_2
    .end packed-switch
.end method

.method public a(IILjava/lang/Object;)V
    .locals 7

    .prologue
    const v6, 0x7f1000f9

    .line 207
    invoke-super {p0, p1, p2, p3}, Lcom/jibo/ui/fragment/BaseFragment;->a(IILjava/lang/Object;)V

    .line 208
    packed-switch p1, :pswitch_data_0

    .line 251
    :cond_0
    :goto_0
    iget-object v0, p0, Lcom/jibo/ui/fragment/home/MediaFragment;->o:Landroid/support/v7/view/ActionMode;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/jibo/ui/fragment/home/MediaFragment;->o:Landroid/support/v7/view/ActionMode;

    invoke-virtual {v0}, Landroid/support/v7/view/ActionMode;->c()V

    .line 252
    :cond_1
    return-void

    .line 210
    :pswitch_0
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/home/MediaFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-static {v0}, Lcom/jibo/JiboAnalytics;->j(Landroid/content/Context;)V

    .line 211
    invoke-direct {p0}, Lcom/jibo/ui/fragment/home/MediaFragment;->r()V

    goto :goto_0

    .line 214
    :pswitch_1
    if-eqz p3, :cond_0

    .line 216
    :try_start_0
    check-cast p3, Ljava/util/ArrayList;

    .line 218
    invoke-virtual {p3}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_2

    .line 219
    new-instance v0, Ljava/lang/Exception;

    const v1, 0x7f1000f9

    invoke-virtual {p0, v1}, Lcom/jibo/ui/fragment/home/MediaFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/Exception;-><init>(Ljava/lang/String;)V

    throw v0
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 243
    :catch_0
    move-exception v0

    .line 244
    const/16 v0, 0x68

    const v1, 0x7f1003f6

    .line 245
    invoke-virtual {p0, v1}, Lcom/jibo/ui/fragment/home/MediaFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v6}, Lcom/jibo/ui/fragment/home/MediaFragment;->getString(I)Ljava/lang/String;

    move-result-object v2

    .line 244
    invoke-static {p0, v0, v1, v2}, Lcom/jibo/ui/fragment/dialog/DialogUtils;->d(Landroid/support/v4/app/Fragment;ILjava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 222
    :cond_2
    :try_start_1
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/home/MediaFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-static {v0}, Landroid/support/v4/app/ShareCompat$IntentBuilder;->a(Landroid/app/Activity;)Landroid/support/v4/app/ShareCompat$IntentBuilder;

    move-result-object v1

    .line 223
    const/4 v0, 0x0

    .line 225
    invoke-virtual {p3}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :goto_1
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_3

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 226
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/home/MediaFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v3

    const-string v4, "com.jibo.fileprovider"

    new-instance v5, Ljava/io/File;

    invoke-direct {v5, v0}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    invoke-static {v3, v4, v5}, Landroid/support/v4/content/FileProvider;->a(Landroid/content/Context;Ljava/lang/String;Ljava/io/File;)Landroid/net/Uri;

    move-result-object v0

    .line 227
    invoke-virtual {v1, v0}, Landroid/support/v4/app/ShareCompat$IntentBuilder;->b(Landroid/net/Uri;)Landroid/support/v4/app/ShareCompat$IntentBuilder;

    goto :goto_1

    .line 230
    :cond_3
    if-eqz v0, :cond_4

    .line 231
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/home/MediaFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v2

    invoke-virtual {v2}, Landroid/support/v4/app/FragmentActivity;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v2

    invoke-virtual {v2, v0}, Landroid/content/ContentResolver;->getType(Landroid/net/Uri;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Landroid/support/v4/app/ShareCompat$IntentBuilder;->a(Ljava/lang/String;)Landroid/support/v4/app/ShareCompat$IntentBuilder;

    .line 233
    :cond_4
    const v0, 0x7f10034a

    .line 234
    invoke-virtual {v1, v0}, Landroid/support/v4/app/ShareCompat$IntentBuilder;->a(I)Landroid/support/v4/app/ShareCompat$IntentBuilder;

    move-result-object v0

    .line 235
    invoke-virtual {v0}, Landroid/support/v4/app/ShareCompat$IntentBuilder;->b()Landroid/content/Intent;

    move-result-object v0

    .line 236
    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 237
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/home/MediaFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    invoke-virtual {v1}, Landroid/support/v4/app/FragmentActivity;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/content/Intent;->resolveActivity(Landroid/content/pm/PackageManager;)Landroid/content/ComponentName;

    move-result-object v1

    if-eqz v1, :cond_5

    .line 238
    invoke-virtual {p0, v0}, Lcom/jibo/ui/fragment/home/MediaFragment;->startActivity(Landroid/content/Intent;)V

    .line 239
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/home/MediaFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-static {v0}, Lcom/jibo/JiboAnalytics;->e(Landroid/content/Context;)V

    goto/16 :goto_0

    .line 241
    :cond_5
    new-instance v0, Ljava/lang/Exception;

    const v1, 0x7f1000f9

    invoke-virtual {p0, v1}, Lcom/jibo/ui/fragment/home/MediaFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/Exception;-><init>(Ljava/lang/String;)V

    throw v0
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0

    .line 208
    :pswitch_data_0
    .packed-switch 0x75
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method

.method public a(Landroid/support/v4/content/Loader;)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/support/v4/content/Loader",
            "<",
            "Landroid/database/Cursor;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 417
    iget-object v0, p0, Lcom/jibo/ui/fragment/home/MediaFragment;->c:Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter;->b(Landroid/database/Cursor;)Landroid/database/Cursor;

    .line 418
    return-void
.end method

.method public a(Landroid/support/v4/content/Loader;Landroid/database/Cursor;)V
    .locals 11
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/support/v4/content/Loader",
            "<",
            "Landroid/database/Cursor;",
            ">;",
            "Landroid/database/Cursor;",
            ")V"
        }
    .end annotation

    .prologue
    const/4 v9, 0x0

    const/16 v3, 0x8

    const/4 v2, 0x1

    const v8, 0x7f0901c7

    const/4 v1, 0x0

    .line 342
    invoke-virtual {p1}, Landroid/support/v4/content/Loader;->n()I

    move-result v0

    const v4, 0x7f0901c5

    if-ne v0, v4, :cond_5

    .line 348
    :try_start_0
    iget-object v0, p0, Lcom/jibo/ui/fragment/home/MediaFragment;->e:Ljava/util/Map;

    invoke-interface {v0}, Ljava/util/Map;->clear()V

    .line 350
    if-eqz p2, :cond_a

    invoke-interface {p2}, Landroid/database/Cursor;->isClosed()Z

    move-result v0

    if-nez v0, :cond_a

    invoke-interface {p2}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v0

    if-eqz v0, :cond_a

    .line 351
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/home/MediaFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-static {v0}, Lcom/jibo/db/EntityData;->a(Landroid/content/Context;)Lcom/jibo/db/EntityData;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/db/EntityData;->i()Lcom/jibo/aws/integration/aws/services/account/model/Account;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_1

    move-result-object v5

    move v0, v1

    .line 352
    :goto_0
    :try_start_1
    invoke-interface {p2}, Landroid/database/Cursor;->isAfterLast()Z

    move-result v4

    if-nez v4, :cond_1

    .line 353
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/home/MediaFragment;->getContext()Landroid/content/Context;

    move-result-object v4

    invoke-static {v4}, Lcom/jibo/db/EntityData;->a(Landroid/content/Context;)Lcom/jibo/db/EntityData;

    invoke-static {p2}, Lcom/jibo/db/EntityData;->a(Landroid/database/Cursor;)Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    move-result-object v4

    .line 354
    invoke-virtual {v5}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getId()Ljava/lang/String;

    move-result-object v6

    invoke-static {v4, v6}, Lcom/jibo/aws/integration/helpers/LoopHelper;->isMemberAccepted(Lcom/jibo/aws/integration/aws/services/loop/model/Loop;Ljava/lang/String;)Z

    move-result v6

    if-eqz v6, :cond_9

    .line 355
    iget-object v6, p0, Lcom/jibo/ui/fragment/home/MediaFragment;->e:Ljava/util/Map;

    invoke-virtual {v4}, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;->getId()Ljava/lang/String;

    move-result-object v7

    invoke-interface {v6, v7, v4}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_2

    .line 360
    :try_start_2
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/home/MediaFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v6

    invoke-virtual {v6}, Landroid/support/v4/app/FragmentActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v6

    invoke-static {v6}, Lcom/jibo/utils/SharedPreferencesUtil;->g(Landroid/content/Context;)Z

    move-result v6

    if-eqz v6, :cond_0

    .line 361
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/home/MediaFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v6

    invoke-virtual {v5}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getId()Ljava/lang/String;

    move-result-object v7

    invoke-static {v6, v7}, Lcom/jibo/aws/integration/util/KeyManager;->getInstance(Landroid/content/Context;Ljava/lang/String;)Lcom/jibo/aws/integration/util/KeyManager;

    move-result-object v6

    .line 362
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/home/MediaFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v7

    invoke-virtual {v7}, Landroid/support/v4/app/FragmentActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v7

    invoke-virtual {v4}, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;->getId()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v6, v7, v4}, Lcom/jibo/aws/integration/util/KeyManager;->obtainKeyHolder(Landroid/content/Context;Ljava/lang/String;)Lcom/jibo/aws/integration/util/KeyManager$SymmetricKeyHolder;
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_0

    .line 363
    add-int/lit8 v0, v0, 0x1

    :goto_1
    move v4, v0

    .line 371
    :goto_2
    :try_start_3
    invoke-interface {p2}, Landroid/database/Cursor;->moveToNext()Z
    :try_end_3
    .catch Ljava/lang/Exception; {:try_start_3 .. :try_end_3} :catch_3

    move v0, v4

    goto :goto_0

    .line 365
    :cond_0
    add-int/lit8 v0, v0, 0x1

    goto :goto_1

    .line 367
    :catch_0
    move-exception v4

    move v4, v0

    goto :goto_2

    .line 374
    :catch_1
    move-exception v0

    move v4, v1

    .line 375
    :goto_3
    invoke-static {v0}, Lcom/crashlytics/android/Crashlytics;->a(Ljava/lang/Throwable;)V

    move v0, v4

    .line 378
    :cond_1
    :goto_4
    if-eqz v0, :cond_4

    .line 380
    iget-object v0, p0, Lcom/jibo/ui/fragment/home/MediaFragment;->swipeRefreshLayout:Landroid/support/v4/widget/SwipeRefreshLayout;

    invoke-virtual {v0, v2}, Landroid/support/v4/widget/SwipeRefreshLayout;->setEnabled(Z)V

    .line 381
    iget-object v0, p0, Lcom/jibo/ui/fragment/home/MediaFragment;->viewNoKey:Landroid/view/View;

    invoke-virtual {v0, v3}, Landroid/view/View;->setVisibility(I)V

    .line 382
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/home/MediaFragment;->getLoaderManager()Landroid/support/v4/app/LoaderManager;

    move-result-object v0

    invoke-virtual {v0, v8}, Landroid/support/v4/app/LoaderManager;->b(I)Landroid/support/v4/content/Loader;

    move-result-object v0

    if-eqz v0, :cond_3

    .line 383
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/home/MediaFragment;->getLoaderManager()Landroid/support/v4/app/LoaderManager;

    move-result-object v0

    invoke-virtual {v0, v8, v9, p0}, Landroid/support/v4/app/LoaderManager;->b(ILandroid/os/Bundle;Landroid/support/v4/app/LoaderManager$LoaderCallbacks;)Landroid/support/v4/content/Loader;

    .line 396
    :goto_5
    iget-object v0, p0, Lcom/jibo/ui/fragment/home/MediaFragment;->v:Landroid/os/Handler;

    const/4 v1, 0x2

    invoke-virtual {v0, v1}, Landroid/os/Handler;->sendEmptyMessage(I)Z

    .line 413
    :cond_2
    :goto_6
    return-void

    .line 385
    :cond_3
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/home/MediaFragment;->getLoaderManager()Landroid/support/v4/app/LoaderManager;

    move-result-object v0

    invoke-virtual {v0, v8, v9, p0}, Landroid/support/v4/app/LoaderManager;->a(ILandroid/os/Bundle;Landroid/support/v4/app/LoaderManager$LoaderCallbacks;)Landroid/support/v4/content/Loader;

    goto :goto_5

    .line 389
    :cond_4
    invoke-direct {p0}, Lcom/jibo/ui/fragment/home/MediaFragment;->q()V

    .line 390
    iget-object v0, p0, Lcom/jibo/ui/fragment/home/MediaFragment;->swipeRefreshLayout:Landroid/support/v4/widget/SwipeRefreshLayout;

    invoke-virtual {v0, v1}, Landroid/support/v4/widget/SwipeRefreshLayout;->setEnabled(Z)V

    .line 391
    iget-object v0, p0, Lcom/jibo/ui/fragment/home/MediaFragment;->viewNoKey:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 392
    iget-object v0, p0, Lcom/jibo/ui/fragment/home/MediaFragment;->emptyView:Landroid/view/View;

    invoke-virtual {v0, v3}, Landroid/view/View;->setVisibility(I)V

    .line 393
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/home/MediaFragment;->getLoaderManager()Landroid/support/v4/app/LoaderManager;

    move-result-object v0

    invoke-virtual {v0, v8}, Landroid/support/v4/app/LoaderManager;->a(I)V

    goto :goto_5

    .line 398
    :cond_5
    invoke-virtual {p1}, Landroid/support/v4/content/Loader;->n()I

    move-result v0

    if-ne v0, v8, :cond_2

    .line 401
    if-eqz p2, :cond_6

    invoke-interface {p2}, Landroid/database/Cursor;->isClosed()Z

    move-result v0

    if-nez v0, :cond_6

    invoke-interface {p2}, Landroid/database/Cursor;->getCount()I

    move-result v0

    if-eqz v0, :cond_6

    invoke-interface {p2}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v0

    if-nez v0, :cond_7

    :cond_6
    move v0, v2

    :goto_7
    iput-boolean v0, p0, Lcom/jibo/ui/fragment/home/MediaFragment;->l:Z

    .line 402
    iget-object v0, p0, Lcom/jibo/ui/fragment/home/MediaFragment;->emptyView:Landroid/view/View;

    iget-boolean v4, p0, Lcom/jibo/ui/fragment/home/MediaFragment;->l:Z

    if-eqz v4, :cond_8

    :goto_8
    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 404
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/home/MediaFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentActivity;->invalidateOptionsMenu()V

    .line 406
    invoke-direct {p0}, Lcom/jibo/ui/fragment/home/MediaFragment;->q()V

    .line 408
    iget-object v0, p0, Lcom/jibo/ui/fragment/home/MediaFragment;->c:Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter;

    iget-object v1, p0, Lcom/jibo/ui/fragment/home/MediaFragment;->d:Ljava/util/Map;

    invoke-virtual {v0, v1}, Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter;->a(Ljava/util/Map;)V

    .line 409
    iget-object v0, p0, Lcom/jibo/ui/fragment/home/MediaFragment;->c:Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter;

    invoke-virtual {v0, p2}, Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter;->b(Landroid/database/Cursor;)Landroid/database/Cursor;

    .line 411
    iget-object v0, p0, Lcom/jibo/ui/fragment/home/MediaFragment;->v:Landroid/os/Handler;

    invoke-virtual {v0, v2}, Landroid/os/Handler;->sendEmptyMessage(I)Z

    goto :goto_6

    :cond_7
    move v0, v1

    .line 401
    goto :goto_7

    :cond_8
    move v1, v3

    .line 402
    goto :goto_8

    .line 374
    :catch_2
    move-exception v4

    move-object v10, v4

    move v4, v0

    move-object v0, v10

    goto/16 :goto_3

    :catch_3
    move-exception v0

    goto/16 :goto_3

    :cond_9
    move v4, v0

    goto/16 :goto_2

    :cond_a
    move v0, v1

    goto/16 :goto_4
.end method

.method public bridge synthetic a(Landroid/support/v4/content/Loader;Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 106
    check-cast p2, Landroid/database/Cursor;

    invoke-virtual {p0, p1, p2}, Lcom/jibo/ui/fragment/home/MediaFragment;->a(Landroid/support/v4/content/Loader;Landroid/database/Cursor;)V

    return-void
.end method

.method public a(Lcom/jibo/aws/integration/aws/services/loop/model/Loop;)V
    .locals 3

    .prologue
    .line 448
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/home/MediaFragment;->getLoaderManager()Landroid/support/v4/app/LoaderManager;

    move-result-object v0

    const v1, 0x7f0901c5

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2, p0}, Landroid/support/v4/app/LoaderManager;->b(ILandroid/os/Bundle;Landroid/support/v4/app/LoaderManager$LoaderCallbacks;)Landroid/support/v4/content/Loader;

    .line 449
    return-void
.end method

.method public n_()V
    .locals 3

    .prologue
    const/4 v2, 0x1

    .line 320
    iget-object v0, p0, Lcom/jibo/ui/fragment/home/MediaFragment;->swipeRefreshLayout:Landroid/support/v4/widget/SwipeRefreshLayout;

    invoke-virtual {v0, v2}, Landroid/support/v4/widget/SwipeRefreshLayout;->setRefreshing(Z)V

    .line 322
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/home/MediaFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    const/4 v1, 0x0

    invoke-static {v0, v1, v2}, Lcom/jibo/service/SyncHelper;->a(Landroid/content/Context;Ljava/lang/String;Z)V

    .line 325
    return-void
.end method

.method public o()Ljava/lang/String;
    .locals 1

    .prologue
    .line 422
    const v0, 0x7f100414

    invoke-virtual {p0, v0}, Lcom/jibo/ui/fragment/home/MediaFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 1

    .prologue
    .line 262
    invoke-super {p0, p1}, Lcom/jibo/ui/fragment/BaseFragment;->onCreate(Landroid/os/Bundle;)V

    .line 264
    const/4 v0, 0x1

    invoke-virtual {p0, v0}, Lcom/jibo/ui/fragment/home/MediaFragment;->setHasOptionsMenu(Z)V

    .line 265
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 2

    .prologue
    .line 270
    const v0, 0x7f0b007a

    const/4 v1, 0x0

    invoke-virtual {p1, v0, p2, v1}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    return-object v0
.end method

.method public onOptionsItemSelected(Landroid/view/MenuItem;)Z
    .locals 4

    .prologue
    const v3, 0x7f0901c7

    const v2, 0x7f090027

    .line 428
    invoke-interface {p1}, Landroid/view/MenuItem;->getItemId()I

    move-result v0

    if-eq v0, v2, :cond_0

    invoke-interface {p1}, Landroid/view/MenuItem;->getItemId()I

    move-result v0

    const v1, 0x7f090037

    if-ne v0, v1, :cond_2

    .line 429
    :cond_0
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/home/MediaFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    invoke-interface {p1}, Landroid/view/MenuItem;->getItemId()I

    move-result v0

    if-ne v0, v2, :cond_1

    sget-object v0, Lcom/jibo/ui/fragment/home/MediaFragment$ModesHelper$Mode;->Gridview:Lcom/jibo/ui/fragment/home/MediaFragment$ModesHelper$Mode;

    :goto_0
    invoke-static {v1, v0}, Lcom/jibo/ui/fragment/home/MediaFragment$ModesHelper;->a(Landroid/content/Context;Lcom/jibo/ui/fragment/home/MediaFragment$ModesHelper$Mode;)V

    .line 432
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/home/MediaFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentActivity;->invalidateOptionsMenu()V

    .line 434
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/home/MediaFragment;->getLoaderManager()Landroid/support/v4/app/LoaderManager;

    move-result-object v0

    invoke-virtual {v0, v3}, Landroid/support/v4/app/LoaderManager;->a(I)V

    .line 436
    invoke-direct {p0}, Lcom/jibo/ui/fragment/home/MediaFragment;->b()V

    .line 438
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/home/MediaFragment;->getLoaderManager()Landroid/support/v4/app/LoaderManager;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v3, v1, p0}, Landroid/support/v4/app/LoaderManager;->a(ILandroid/os/Bundle;Landroid/support/v4/app/LoaderManager$LoaderCallbacks;)Landroid/support/v4/content/Loader;

    .line 439
    const/4 v0, 0x1

    .line 442
    :goto_1
    return v0

    .line 429
    :cond_1
    sget-object v0, Lcom/jibo/ui/fragment/home/MediaFragment$ModesHelper$Mode;->Timeline:Lcom/jibo/ui/fragment/home/MediaFragment$ModesHelper$Mode;

    goto :goto_0

    .line 442
    :cond_2
    invoke-super {p0, p1}, Lcom/jibo/ui/fragment/BaseFragment;->onOptionsItemSelected(Landroid/view/MenuItem;)Z

    move-result v0

    goto :goto_1
.end method

.method public onPause()V
    .locals 2

    .prologue
    .line 305
    invoke-super {p0}, Lcom/jibo/ui/fragment/BaseFragment;->onPause()V

    .line 307
    iget-object v0, p0, Lcom/jibo/ui/fragment/home/MediaFragment;->t:Lcom/jibo/ui/fragment/home/MediaFragment$PaginationAsyncTask;

    if-eqz v0, :cond_0

    .line 308
    iget-object v0, p0, Lcom/jibo/ui/fragment/home/MediaFragment;->t:Lcom/jibo/ui/fragment/home/MediaFragment$PaginationAsyncTask;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Lcom/jibo/ui/fragment/home/MediaFragment$PaginationAsyncTask;->cancel(Z)Z

    .line 309
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/jibo/ui/fragment/home/MediaFragment;->t:Lcom/jibo/ui/fragment/home/MediaFragment$PaginationAsyncTask;

    .line 312
    :cond_0
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/home/MediaFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-static {v0}, Landroid/support/v4/content/LocalBroadcastManager;->a(Landroid/content/Context;)Landroid/support/v4/content/LocalBroadcastManager;

    move-result-object v0

    .line 313
    iget-object v1, p0, Lcom/jibo/ui/fragment/home/MediaFragment;->q:Landroid/content/BroadcastReceiver;

    invoke-virtual {v0, v1}, Landroid/support/v4/content/LocalBroadcastManager;->a(Landroid/content/BroadcastReceiver;)V

    .line 315
    invoke-direct {p0}, Lcom/jibo/ui/fragment/home/MediaFragment;->q()V

    .line 316
    return-void
.end method

.method public onResume()V
    .locals 4

    .prologue
    const/4 v3, 0x0

    .line 288
    invoke-super {p0}, Lcom/jibo/ui/fragment/BaseFragment;->onResume()V

    .line 290
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/home/MediaFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-static {v0}, Landroid/support/v4/content/LocalBroadcastManager;->a(Landroid/content/Context;)Landroid/support/v4/content/LocalBroadcastManager;

    move-result-object v0

    .line 291
    new-instance v1, Landroid/content/IntentFilter;

    invoke-direct {v1}, Landroid/content/IntentFilter;-><init>()V

    .line 292
    const-string v2, "ACTION_KEY_SAVED"

    invoke-virtual {v1, v2}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    .line 293
    iget-object v2, p0, Lcom/jibo/ui/fragment/home/MediaFragment;->q:Landroid/content/BroadcastReceiver;

    invoke-virtual {v0, v2, v1}, Landroid/support/v4/content/LocalBroadcastManager;->a(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)V

    .line 296
    iget-object v0, p0, Lcom/jibo/ui/fragment/home/MediaFragment;->swipeRefreshLayout:Landroid/support/v4/widget/SwipeRefreshLayout;

    invoke-static {}, Lcom/jibo/ui/fragment/home/MediaFragment$ModesHelper;->a()Z

    move-result v1

    invoke-virtual {v0, v1}, Landroid/support/v4/widget/SwipeRefreshLayout;->setEnabled(Z)V

    .line 298
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/home/MediaFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    const/4 v1, 0x1

    invoke-static {v0, v3, v1}, Lcom/jibo/service/SyncHelper;->a(Landroid/content/Context;Ljava/lang/String;Z)V

    .line 300
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/home/MediaFragment;->getLoaderManager()Landroid/support/v4/app/LoaderManager;

    move-result-object v0

    const v1, 0x7f0901c5

    invoke-virtual {v0, v1, v3, p0}, Landroid/support/v4/app/LoaderManager;->a(ILandroid/os/Bundle;Landroid/support/v4/app/LoaderManager$LoaderCallbacks;)Landroid/support/v4/content/Loader;

    .line 301
    return-void
.end method

.method public onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V
    .locals 2

    .prologue
    .line 275
    invoke-super {p0, p1, p2}, Lcom/jibo/ui/fragment/BaseFragment;->onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V

    .line 277
    invoke-direct {p0}, Lcom/jibo/ui/fragment/home/MediaFragment;->b()V

    .line 279
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/home/MediaFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/activity/BaseActivity;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/jibo/ui/activity/BaseActivity;->a(Z)V

    .line 281
    iget-object v0, p0, Lcom/jibo/ui/fragment/home/MediaFragment;->swipeRefreshLayout:Landroid/support/v4/widget/SwipeRefreshLayout;

    invoke-virtual {v0, p0}, Landroid/support/v4/widget/SwipeRefreshLayout;->setOnRefreshListener(Landroid/support/v4/widget/SwipeRefreshLayout$OnRefreshListener;)V

    .line 282
    iget-object v0, p0, Lcom/jibo/ui/fragment/home/MediaFragment;->swipeRefreshLayout:Landroid/support/v4/widget/SwipeRefreshLayout;

    const/4 v1, 0x4

    new-array v1, v1, [I

    fill-array-data v1, :array_0

    invoke-virtual {v0, v1}, Landroid/support/v4/widget/SwipeRefreshLayout;->setColorSchemeResources([I)V

    .line 284
    return-void

    .line 282
    nop

    :array_0
    .array-data 4
        0x7f06007b
        0x7f060018
        0x7f060018
        0x7f060018
    .end array-data
.end method
