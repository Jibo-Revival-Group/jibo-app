.class public Lcom/jibo/ui/activity/PhotoViewerActivity;
.super Landroid/support/v7/app/AppCompatActivity;
.source "PhotoViewerActivity.java"

# interfaces
.implements Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapperClickListener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/jibo/ui/activity/PhotoViewerActivity$ZoomOutPageTransformer;,
        Lcom/jibo/ui/activity/PhotoViewerActivity$PhotoFragment;,
        Lcom/jibo/ui/activity/PhotoViewerActivity$MediaAdapter;
    }
.end annotation


# static fields
.field public static final a:Ljava/lang/String;

.field private static f:Landroid/util/SparseBooleanArray;


# instance fields
.field b:Lbutterknife/Unbinder;

.field c:I

.field d:Z

.field e:I

.field footer:Landroid/view/View;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field private g:I

.field private h:Lcom/jibo/ui/activity/PhotoViewerActivity$MediaAdapter;

.field private i:Lcom/jibo/aws/integration/aws/services/media/model/Media;

.field private j:Landroid/database/Cursor;

.field private k:I

.field private l:Landroid/database/ContentObserver;

.field private m:Lcom/jibo/aws/integration/aws/services/account/model/Account;

.field private n:Z

.field private o:Lcom/jibo/utils/NetworkStateReceiver;

.field pager:Landroid/support/v4/view/ViewPager;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field photoDateText:Landroid/widget/TextView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field toolbar:Landroid/support/v7/widget/Toolbar;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field transitionImage:Landroid/widget/ImageView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field viewNetworkDown:Landroid/view/View;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 74
    const-class v0, Lcom/jibo/ui/activity/PhotoViewerActivity;

    invoke-static {v0}, Lcom/jibo/utils/LogUtils;->a(Ljava/lang/Class;)Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/jibo/ui/activity/PhotoViewerActivity;->a:Ljava/lang/String;

    .line 104
    new-instance v0, Landroid/util/SparseBooleanArray;

    invoke-direct {v0}, Landroid/util/SparseBooleanArray;-><init>()V

    sput-object v0, Lcom/jibo/ui/activity/PhotoViewerActivity;->f:Landroid/util/SparseBooleanArray;

    return-void
.end method

.method public constructor <init>()V
    .locals 3

    .prologue
    const/4 v2, 0x1

    const/4 v1, 0x0

    .line 73
    invoke-direct {p0}, Landroid/support/v7/app/AppCompatActivity;-><init>()V

    .line 106
    iput v1, p0, Lcom/jibo/ui/activity/PhotoViewerActivity;->g:I

    .line 111
    const/16 v0, 0x600

    iput v0, p0, Lcom/jibo/ui/activity/PhotoViewerActivity;->k:I

    .line 114
    iput-boolean v2, p0, Lcom/jibo/ui/activity/PhotoViewerActivity;->d:Z

    .line 115
    iput v1, p0, Lcom/jibo/ui/activity/PhotoViewerActivity;->e:I

    .line 117
    new-instance v0, Lcom/jibo/ui/activity/PhotoViewerActivity$1;

    new-instance v1, Landroid/os/Handler;

    invoke-direct {v1}, Landroid/os/Handler;-><init>()V

    invoke-direct {v0, p0, v1}, Lcom/jibo/ui/activity/PhotoViewerActivity$1;-><init>(Lcom/jibo/ui/activity/PhotoViewerActivity;Landroid/os/Handler;)V

    iput-object v0, p0, Lcom/jibo/ui/activity/PhotoViewerActivity;->l:Landroid/database/ContentObserver;

    .line 129
    iput-boolean v2, p0, Lcom/jibo/ui/activity/PhotoViewerActivity;->n:Z

    .line 130
    new-instance v0, Lcom/jibo/ui/activity/PhotoViewerActivity$2;

    invoke-direct {v0, p0}, Lcom/jibo/ui/activity/PhotoViewerActivity$2;-><init>(Lcom/jibo/ui/activity/PhotoViewerActivity;)V

    iput-object v0, p0, Lcom/jibo/ui/activity/PhotoViewerActivity;->o:Lcom/jibo/utils/NetworkStateReceiver;

    return-void
.end method

.method static synthetic a(Lcom/jibo/ui/activity/PhotoViewerActivity;I)I
    .locals 0

    .prologue
    .line 73
    iput p1, p0, Lcom/jibo/ui/activity/PhotoViewerActivity;->g:I

    return p1
.end method

.method static synthetic a(Lcom/jibo/ui/activity/PhotoViewerActivity;)V
    .locals 0

    .prologue
    .line 73
    invoke-direct {p0}, Lcom/jibo/ui/activity/PhotoViewerActivity;->c()V

    return-void
.end method

.method static synthetic a(Lcom/jibo/ui/activity/PhotoViewerActivity;Z)Z
    .locals 0

    .prologue
    .line 73
    iput-boolean p1, p0, Lcom/jibo/ui/activity/PhotoViewerActivity;->n:Z

    return p1
.end method

.method static synthetic b(Lcom/jibo/ui/activity/PhotoViewerActivity;)I
    .locals 1

    .prologue
    .line 73
    iget v0, p0, Lcom/jibo/ui/activity/PhotoViewerActivity;->g:I

    return v0
.end method

.method static synthetic b()Landroid/util/SparseBooleanArray;
    .locals 1

    .prologue
    .line 73
    sget-object v0, Lcom/jibo/ui/activity/PhotoViewerActivity;->f:Landroid/util/SparseBooleanArray;

    return-object v0
.end method

.method private c()V
    .locals 7

    .prologue
    .line 372
    :try_start_0
    iget-object v0, p0, Lcom/jibo/ui/activity/PhotoViewerActivity;->h:Lcom/jibo/ui/activity/PhotoViewerActivity$MediaAdapter;

    if-eqz v0, :cond_0

    .line 373
    iget-object v0, p0, Lcom/jibo/ui/activity/PhotoViewerActivity;->h:Lcom/jibo/ui/activity/PhotoViewerActivity$MediaAdapter;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/jibo/ui/activity/PhotoViewerActivity$MediaAdapter;->a(Landroid/database/Cursor;)Landroid/database/Cursor;

    .line 376
    :cond_0
    iget-object v0, p0, Lcom/jibo/ui/activity/PhotoViewerActivity;->j:Landroid/database/Cursor;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/jibo/ui/activity/PhotoViewerActivity;->j:Landroid/database/Cursor;

    invoke-interface {v0}, Landroid/database/Cursor;->isClosed()Z

    move-result v0

    if-nez v0, :cond_1

    iget-object v0, p0, Lcom/jibo/ui/activity/PhotoViewerActivity;->j:Landroid/database/Cursor;

    invoke-interface {v0}, Landroid/database/Cursor;->close()V

    .line 377
    :cond_1
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/jibo/ui/activity/PhotoViewerActivity;->j:Landroid/database/Cursor;

    .line 379
    invoke-virtual {p0}, Lcom/jibo/ui/activity/PhotoViewerActivity;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    .line 380
    invoke-virtual {p0}, Lcom/jibo/ui/activity/PhotoViewerActivity;->getIntent()Landroid/content/Intent;

    move-result-object v1

    invoke-virtual {v1}, Landroid/content/Intent;->getData()Landroid/net/Uri;

    move-result-object v1

    const/4 v2, 0x0

    .line 382
    invoke-virtual {p0}, Lcom/jibo/ui/activity/PhotoViewerActivity;->getIntent()Landroid/content/Intent;

    move-result-object v3

    const-string v4, "where"

    invoke-virtual {v3, v4}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 383
    invoke-virtual {p0}, Lcom/jibo/ui/activity/PhotoViewerActivity;->getIntent()Landroid/content/Intent;

    move-result-object v4

    const-string v5, "where_args"

    invoke-virtual {v4, v5}, Landroid/content/Intent;->getStringArrayExtra(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v4

    .line 384
    invoke-virtual {p0}, Lcom/jibo/ui/activity/PhotoViewerActivity;->getIntent()Landroid/content/Intent;

    move-result-object v5

    const-string v6, "order"

    invoke-virtual {v5, v6}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    .line 379
    invoke-virtual/range {v0 .. v5}, Landroid/content/ContentResolver;->query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v0

    iput-object v0, p0, Lcom/jibo/ui/activity/PhotoViewerActivity;->j:Landroid/database/Cursor;

    .line 386
    new-instance v0, Lcom/jibo/ui/activity/PhotoViewerActivity$MediaAdapter;

    invoke-virtual {p0}, Lcom/jibo/ui/activity/PhotoViewerActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v1

    const/4 v2, 0x0

    invoke-direct {v0, p0, v1, v2}, Lcom/jibo/ui/activity/PhotoViewerActivity$MediaAdapter;-><init>(Lcom/jibo/ui/activity/PhotoViewerActivity;Landroid/support/v4/app/FragmentManager;Landroid/database/Cursor;)V

    iput-object v0, p0, Lcom/jibo/ui/activity/PhotoViewerActivity;->h:Lcom/jibo/ui/activity/PhotoViewerActivity$MediaAdapter;

    .line 388
    iget-object v0, p0, Lcom/jibo/ui/activity/PhotoViewerActivity;->j:Landroid/database/Cursor;

    if-eqz v0, :cond_5

    iget-object v0, p0, Lcom/jibo/ui/activity/PhotoViewerActivity;->j:Landroid/database/Cursor;

    invoke-interface {v0}, Landroid/database/Cursor;->isClosed()Z

    move-result v0

    if-nez v0, :cond_5

    iget-object v0, p0, Lcom/jibo/ui/activity/PhotoViewerActivity;->j:Landroid/database/Cursor;

    invoke-interface {v0}, Landroid/database/Cursor;->getCount()I

    move-result v0

    if-lez v0, :cond_5

    iget-object v0, p0, Lcom/jibo/ui/activity/PhotoViewerActivity;->j:Landroid/database/Cursor;

    invoke-interface {v0}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v0

    if-eqz v0, :cond_5

    .line 389
    iget v0, p0, Lcom/jibo/ui/activity/PhotoViewerActivity;->g:I

    if-ltz v0, :cond_2

    iget v0, p0, Lcom/jibo/ui/activity/PhotoViewerActivity;->g:I

    :goto_0
    iput v0, p0, Lcom/jibo/ui/activity/PhotoViewerActivity;->g:I

    .line 390
    iget v0, p0, Lcom/jibo/ui/activity/PhotoViewerActivity;->g:I

    iget-object v1, p0, Lcom/jibo/ui/activity/PhotoViewerActivity;->j:Landroid/database/Cursor;

    invoke-interface {v1}, Landroid/database/Cursor;->getCount()I

    move-result v1

    if-lt v0, v1, :cond_3

    iget-object v0, p0, Lcom/jibo/ui/activity/PhotoViewerActivity;->j:Landroid/database/Cursor;

    invoke-interface {v0}, Landroid/database/Cursor;->getCount()I

    move-result v0

    add-int/lit8 v0, v0, -0x1

    :goto_1
    iput v0, p0, Lcom/jibo/ui/activity/PhotoViewerActivity;->g:I

    .line 392
    iget v0, p0, Lcom/jibo/ui/activity/PhotoViewerActivity;->g:I

    iget-object v1, p0, Lcom/jibo/ui/activity/PhotoViewerActivity;->j:Landroid/database/Cursor;

    invoke-interface {v1}, Landroid/database/Cursor;->getCount()I

    move-result v1

    if-ge v0, v1, :cond_4

    iget v0, p0, Lcom/jibo/ui/activity/PhotoViewerActivity;->g:I

    if-ltz v0, :cond_4

    .line 393
    iget-object v0, p0, Lcom/jibo/ui/activity/PhotoViewerActivity;->j:Landroid/database/Cursor;

    iget v1, p0, Lcom/jibo/ui/activity/PhotoViewerActivity;->g:I

    invoke-interface {v0, v1}, Landroid/database/Cursor;->moveToPosition(I)Z

    .line 394
    iget-object v0, p0, Lcom/jibo/ui/activity/PhotoViewerActivity;->pager:Landroid/support/v4/view/ViewPager;

    iget-object v1, p0, Lcom/jibo/ui/activity/PhotoViewerActivity;->h:Lcom/jibo/ui/activity/PhotoViewerActivity$MediaAdapter;

    invoke-virtual {v0, v1}, Landroid/support/v4/view/ViewPager;->setAdapter(Landroid/support/v4/view/PagerAdapter;)V

    .line 396
    iget-object v0, p0, Lcom/jibo/ui/activity/PhotoViewerActivity;->h:Lcom/jibo/ui/activity/PhotoViewerActivity$MediaAdapter;

    iget-object v1, p0, Lcom/jibo/ui/activity/PhotoViewerActivity;->j:Landroid/database/Cursor;

    invoke-virtual {v0, v1}, Lcom/jibo/ui/activity/PhotoViewerActivity$MediaAdapter;->a(Landroid/database/Cursor;)Landroid/database/Cursor;

    .line 407
    :goto_2
    return-void

    .line 389
    :cond_2
    const/4 v0, 0x0

    goto :goto_0

    .line 390
    :cond_3
    iget v0, p0, Lcom/jibo/ui/activity/PhotoViewerActivity;->g:I

    goto :goto_1

    .line 398
    :cond_4
    invoke-virtual {p0}, Lcom/jibo/ui/activity/PhotoViewerActivity;->finish()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_2

    .line 404
    :catch_0
    move-exception v0

    .line 405
    invoke-static {v0}, Lcom/crashlytics/android/Crashlytics;->a(Ljava/lang/Throwable;)V

    goto :goto_2

    .line 402
    :cond_5
    :try_start_1
    invoke-virtual {p0}, Lcom/jibo/ui/activity/PhotoViewerActivity;->finish()V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0

    goto :goto_2
.end method

.method static synthetic c(Lcom/jibo/ui/activity/PhotoViewerActivity;)V
    .locals 0

    .prologue
    .line 73
    invoke-direct {p0}, Lcom/jibo/ui/activity/PhotoViewerActivity;->i()V

    return-void
.end method

.method private d()I
    .locals 5

    .prologue
    .line 413
    const/4 v0, 0x0

    .line 414
    invoke-virtual {p0}, Lcom/jibo/ui/activity/PhotoViewerActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const-string v2, "status_bar_height"

    const-string v3, "dimen"

    const-string v4, "android"

    invoke-virtual {v1, v2, v3, v4}, Landroid/content/res/Resources;->getIdentifier(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I

    move-result v1

    .line 415
    if-lez v1, :cond_0

    .line 416
    invoke-virtual {p0}, Lcom/jibo/ui/activity/PhotoViewerActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v0

    .line 418
    :cond_0
    return v0
.end method

.method static synthetic d(Lcom/jibo/ui/activity/PhotoViewerActivity;)Z
    .locals 1

    .prologue
    .line 73
    iget-boolean v0, p0, Lcom/jibo/ui/activity/PhotoViewerActivity;->n:Z

    return v0
.end method

.method private e()I
    .locals 5

    .prologue
    .line 425
    invoke-static {p0}, Landroid/view/ViewConfiguration;->get(Landroid/content/Context;)Landroid/view/ViewConfiguration;

    move-result-object v0

    invoke-virtual {v0}, Landroid/view/ViewConfiguration;->hasPermanentMenuKey()Z

    move-result v1

    .line 426
    invoke-virtual {p0}, Lcom/jibo/ui/activity/PhotoViewerActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    .line 427
    invoke-virtual {p0}, Lcom/jibo/ui/activity/PhotoViewerActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/res/Resources;->getConfiguration()Landroid/content/res/Configuration;

    move-result-object v0

    iget v0, v0, Landroid/content/res/Configuration;->orientation:I

    const/4 v3, 0x1

    if-ne v0, v3, :cond_0

    const-string v0, "navigation_bar_height"

    :goto_0
    const-string v3, "dimen"

    const-string v4, "android"

    .line 426
    invoke-virtual {v2, v0, v3, v4}, Landroid/content/res/Resources;->getIdentifier(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I

    move-result v0

    .line 429
    if-lez v0, :cond_1

    if-nez v1, :cond_1

    .line 430
    invoke-virtual {p0}, Lcom/jibo/ui/activity/PhotoViewerActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-virtual {v1, v0}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v0

    .line 432
    :goto_1
    return v0

    .line 427
    :cond_0
    const-string v0, "navigation_bar_height_landscape"

    goto :goto_0

    .line 432
    :cond_1
    const/4 v0, 0x0

    goto :goto_1
.end method

.method static synthetic e(Lcom/jibo/ui/activity/PhotoViewerActivity;)Lcom/jibo/ui/activity/PhotoViewerActivity$MediaAdapter;
    .locals 1

    .prologue
    .line 73
    iget-object v0, p0, Lcom/jibo/ui/activity/PhotoViewerActivity;->h:Lcom/jibo/ui/activity/PhotoViewerActivity$MediaAdapter;

    return-object v0
.end method

.method private f()V
    .locals 1

    .prologue
    .line 439
    iget v0, p0, Lcom/jibo/ui/activity/PhotoViewerActivity;->k:I

    and-int/lit8 v0, v0, 0x4

    if-nez v0, :cond_0

    iget v0, p0, Lcom/jibo/ui/activity/PhotoViewerActivity;->k:I

    and-int/lit8 v0, v0, 0x2

    if-nez v0, :cond_0

    .line 441
    invoke-direct {p0}, Lcom/jibo/ui/activity/PhotoViewerActivity;->g()V

    .line 445
    :goto_0
    return-void

    .line 443
    :cond_0
    invoke-direct {p0}, Lcom/jibo/ui/activity/PhotoViewerActivity;->h()V

    goto :goto_0
.end method

.method static synthetic f(Lcom/jibo/ui/activity/PhotoViewerActivity;)V
    .locals 0

    .prologue
    .line 73
    invoke-direct {p0}, Lcom/jibo/ui/activity/PhotoViewerActivity;->g()V

    return-void
.end method

.method private g()V
    .locals 2

    .prologue
    .line 451
    iget v0, p0, Lcom/jibo/ui/activity/PhotoViewerActivity;->k:I

    or-int/lit8 v0, v0, 0x4

    or-int/lit16 v0, v0, 0x800

    or-int/lit8 v0, v0, 0x2

    iput v0, p0, Lcom/jibo/ui/activity/PhotoViewerActivity;->k:I

    .line 455
    invoke-virtual {p0}, Lcom/jibo/ui/activity/PhotoViewerActivity;->getWindow()Landroid/view/Window;

    move-result-object v0

    invoke-virtual {v0}, Landroid/view/Window;->getDecorView()Landroid/view/View;

    move-result-object v0

    iget v1, p0, Lcom/jibo/ui/activity/PhotoViewerActivity;->k:I

    invoke-virtual {v0, v1}, Landroid/view/View;->setSystemUiVisibility(I)V

    .line 456
    return-void
.end method

.method static synthetic g(Lcom/jibo/ui/activity/PhotoViewerActivity;)V
    .locals 0

    .prologue
    .line 73
    invoke-direct {p0}, Lcom/jibo/ui/activity/PhotoViewerActivity;->f()V

    return-void
.end method

.method private h()V
    .locals 2

    .prologue
    .line 462
    iget v0, p0, Lcom/jibo/ui/activity/PhotoViewerActivity;->k:I

    and-int/lit8 v0, v0, -0x5

    and-int/lit8 v0, v0, -0x3

    iput v0, p0, Lcom/jibo/ui/activity/PhotoViewerActivity;->k:I

    .line 466
    invoke-virtual {p0}, Lcom/jibo/ui/activity/PhotoViewerActivity;->getWindow()Landroid/view/Window;

    move-result-object v0

    invoke-virtual {v0}, Landroid/view/Window;->getDecorView()Landroid/view/View;

    move-result-object v0

    iget v1, p0, Lcom/jibo/ui/activity/PhotoViewerActivity;->k:I

    invoke-virtual {v0, v1}, Landroid/view/View;->setSystemUiVisibility(I)V

    .line 467
    return-void
.end method

.method private i()V
    .locals 8

    .prologue
    .line 474
    invoke-static {p0}, Lcom/jibo/db/EntityData;->a(Landroid/content/Context;)Lcom/jibo/db/EntityData;

    iget-object v0, p0, Lcom/jibo/ui/activity/PhotoViewerActivity;->h:Lcom/jibo/ui/activity/PhotoViewerActivity$MediaAdapter;

    invoke-virtual {v0}, Lcom/jibo/ui/activity/PhotoViewerActivity$MediaAdapter;->d()Landroid/database/Cursor;

    move-result-object v0

    invoke-static {v0}, Lcom/jibo/db/EntityData;->c(Landroid/database/Cursor;)Lcom/jibo/aws/integration/aws/services/media/model/Media;

    move-result-object v0

    iput-object v0, p0, Lcom/jibo/ui/activity/PhotoViewerActivity;->i:Lcom/jibo/aws/integration/aws/services/media/model/Media;

    .line 475
    iget-object v0, p0, Lcom/jibo/ui/activity/PhotoViewerActivity;->i:Lcom/jibo/aws/integration/aws/services/media/model/Media;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/jibo/ui/activity/PhotoViewerActivity;->h:Lcom/jibo/ui/activity/PhotoViewerActivity$MediaAdapter;

    invoke-virtual {v0}, Lcom/jibo/ui/activity/PhotoViewerActivity$MediaAdapter;->d()Landroid/database/Cursor;

    move-result-object v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/jibo/ui/activity/PhotoViewerActivity;->h:Lcom/jibo/ui/activity/PhotoViewerActivity$MediaAdapter;

    .line 476
    invoke-virtual {v0}, Lcom/jibo/ui/activity/PhotoViewerActivity$MediaAdapter;->d()Landroid/database/Cursor;

    move-result-object v0

    invoke-interface {v0}, Landroid/database/Cursor;->isClosed()Z

    move-result v0

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/jibo/ui/activity/PhotoViewerActivity;->h:Lcom/jibo/ui/activity/PhotoViewerActivity$MediaAdapter;

    invoke-virtual {v0}, Lcom/jibo/ui/activity/PhotoViewerActivity$MediaAdapter;->d()Landroid/database/Cursor;

    move-result-object v0

    invoke-interface {v0}, Landroid/database/Cursor;->getCount()I

    move-result v0

    if-nez v0, :cond_1

    .line 488
    :cond_0
    :goto_0
    return-void

    .line 478
    :cond_1
    invoke-virtual {p0}, Lcom/jibo/ui/activity/PhotoViewerActivity;->invalidateOptionsMenu()V

    .line 481
    :try_start_0
    iget-object v0, p0, Lcom/jibo/ui/activity/PhotoViewerActivity;->i:Lcom/jibo/aws/integration/aws/services/media/model/Media;

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/media/model/Media;->getCreated()Ljava/lang/Long;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Long;->longValue()J

    move-result-wide v0

    const-string v2, "M/d/yy"

    const-string v3, "hh:mm a"

    const/4 v4, 0x0

    const/4 v5, 0x3

    new-array v5, v5, [Ljava/lang/String;

    const/4 v6, 0x0

    const v7, 0x7f10036f

    .line 482
    invoke-virtual {p0, v7}, Lcom/jibo/ui/activity/PhotoViewerActivity;->getString(I)Ljava/lang/String;

    move-result-object v7

    aput-object v7, v5, v6

    const/4 v6, 0x1

    const v7, 0x7f100359

    invoke-virtual {p0, v7}, Lcom/jibo/ui/activity/PhotoViewerActivity;->getString(I)Ljava/lang/String;

    move-result-object v7

    aput-object v7, v5, v6

    const/4 v6, 0x2

    const v7, 0x7f10035a

    .line 483
    invoke-virtual {p0, v7}, Lcom/jibo/ui/activity/PhotoViewerActivity;->getString(I)Ljava/lang/String;

    move-result-object v7

    aput-object v7, v5, v6

    .line 481
    invoke-static/range {v0 .. v5}, Lcom/jibo/aws/integration/util/DateTimeUtils;->getDateTimeParts(JLjava/lang/String;Ljava/lang/String;Z[Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v0

    .line 484
    iget-object v1, p0, Lcom/jibo/ui/activity/PhotoViewerActivity;->photoDateText:Landroid/widget/TextView;

    const v2, 0x7f100204

    const/4 v3, 0x2

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    const/4 v5, 0x0

    aget-object v5, v0, v5

    aput-object v5, v3, v4

    const/4 v4, 0x1

    const/4 v5, 0x1

    aget-object v0, v0, v5

    aput-object v0, v3, v4

    invoke-virtual {p0, v2, v3}, Lcom/jibo/ui/activity/PhotoViewerActivity;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 485
    :catch_0
    move-exception v0

    .line 486
    iget-object v0, p0, Lcom/jibo/ui/activity/PhotoViewerActivity;->photoDateText:Landroid/widget/TextView;

    const-string v1, ""

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    goto :goto_0
.end method

.method private j()V
    .locals 5

    .prologue
    const v4, 0x7f1000f9

    .line 494
    invoke-virtual {p0}, Lcom/jibo/ui/activity/PhotoViewerActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Lcom/jibo/utils/SharedPreferencesUtil;->g(Landroid/content/Context;)Z

    move-result v0

    .line 496
    new-instance v1, Ljava/io/File;

    invoke-virtual {p0}, Lcom/jibo/ui/activity/PhotoViewerActivity;->getExternalCacheDir()Ljava/io/File;

    move-result-object v2

    iget-object v3, p0, Lcom/jibo/ui/activity/PhotoViewerActivity;->i:Lcom/jibo/aws/integration/aws/services/media/model/Media;

    invoke-static {v0, v3}, Lcom/jibo/aws/integration/helpers/MediaHelper;->getUrl(ZLcom/jibo/aws/integration/aws/services/media/model/Media;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/jibo/utils/OriginalKey;->a(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-direct {v1, v2, v0}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    .line 498
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p0}, Lcom/jibo/ui/activity/PhotoViewerActivity;->getExternalCacheDir()Ljava/io/File;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v2, "/"

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v2, "share"

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    iget-object v2, p0, Lcom/jibo/ui/activity/PhotoViewerActivity;->i:Lcom/jibo/aws/integration/aws/services/media/model/Media;

    invoke-static {v0, v2}, Lcom/jibo/aws/integration/helpers/MediaHelper;->getShareableFile(Ljava/lang/String;Lcom/jibo/aws/integration/aws/services/media/model/Media;)Ljava/io/File;

    move-result-object v0

    .line 500
    :try_start_0
    invoke-static {p0}, Lcom/jibo/JiboGlideModule;->b(Landroid/content/Context;)V

    .line 501
    invoke-virtual {v0}, Ljava/io/File;->exists()Z

    move-result v2

    if-nez v2, :cond_0

    .line 502
    invoke-static {v1, v0}, Lcom/jibo/utils/ImageUtils;->a(Ljava/io/File;Ljava/io/File;)V

    .line 505
    :cond_0
    const-string v1, "com.jibo.fileprovider"

    invoke-static {p0, v1, v0}, Landroid/support/v4/content/FileProvider;->a(Landroid/content/Context;Ljava/lang/String;Ljava/io/File;)Landroid/net/Uri;

    move-result-object v0

    .line 506
    invoke-static {p0}, Landroid/support/v4/app/ShareCompat$IntentBuilder;->a(Landroid/app/Activity;)Landroid/support/v4/app/ShareCompat$IntentBuilder;

    move-result-object v1

    .line 507
    invoke-virtual {p0}, Lcom/jibo/ui/activity/PhotoViewerActivity;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v2

    invoke-virtual {v2, v0}, Landroid/content/ContentResolver;->getType(Landroid/net/Uri;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/support/v4/app/ShareCompat$IntentBuilder;->a(Ljava/lang/String;)Landroid/support/v4/app/ShareCompat$IntentBuilder;

    move-result-object v1

    .line 508
    invoke-virtual {v1, v0}, Landroid/support/v4/app/ShareCompat$IntentBuilder;->a(Landroid/net/Uri;)Landroid/support/v4/app/ShareCompat$IntentBuilder;

    move-result-object v0

    const v1, 0x7f10034a

    .line 509
    invoke-virtual {v0, v1}, Landroid/support/v4/app/ShareCompat$IntentBuilder;->a(I)Landroid/support/v4/app/ShareCompat$IntentBuilder;

    move-result-object v0

    .line 510
    invoke-virtual {v0}, Landroid/support/v4/app/ShareCompat$IntentBuilder;->b()Landroid/content/Intent;

    move-result-object v0

    .line 511
    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 512
    invoke-virtual {p0}, Lcom/jibo/ui/activity/PhotoViewerActivity;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/content/Intent;->resolveActivity(Landroid/content/pm/PackageManager;)Landroid/content/ComponentName;

    move-result-object v1

    if-eqz v1, :cond_1

    .line 513
    invoke-virtual {p0, v0}, Lcom/jibo/ui/activity/PhotoViewerActivity;->startActivity(Landroid/content/Intent;)V

    .line 514
    invoke-static {p0}, Lcom/jibo/JiboAnalytics;->e(Landroid/content/Context;)V

    .line 523
    :goto_0
    return-void

    .line 516
    :cond_1
    new-instance v0, Ljava/lang/Exception;

    const v1, 0x7f1000f9

    invoke-virtual {p0, v1}, Lcom/jibo/ui/activity/PhotoViewerActivity;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/Exception;-><init>(Ljava/lang/String;)V

    throw v0
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 518
    :catch_0
    move-exception v0

    .line 519
    invoke-static {v0}, Lcom/crashlytics/android/Crashlytics;->a(Ljava/lang/Throwable;)V

    .line 520
    const/4 v0, 0x0

    invoke-virtual {p0}, Lcom/jibo/ui/activity/PhotoViewerActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v1

    const/16 v2, 0x68

    const v3, 0x7f1003f6

    .line 521
    invoke-virtual {p0, v3}, Lcom/jibo/ui/activity/PhotoViewerActivity;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {p0, v4}, Lcom/jibo/ui/activity/PhotoViewerActivity;->getString(I)Ljava/lang/String;

    move-result-object v4

    .line 520
    invoke-static {v0, v1, v2, v3, v4}, Lcom/jibo/ui/fragment/dialog/DialogUtils;->c(Landroid/support/v4/app/Fragment;Landroid/support/v4/app/FragmentManager;ILjava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method


# virtual methods
.method public a()V
    .locals 4

    .prologue
    const/16 v2, 0x8

    const/4 v1, 0x0

    .line 676
    iget-object v3, p0, Lcom/jibo/ui/activity/PhotoViewerActivity;->viewNetworkDown:Landroid/view/View;

    iget-boolean v0, p0, Lcom/jibo/ui/activity/PhotoViewerActivity;->n:Z

    if-nez v0, :cond_0

    move v0, v1

    :goto_0
    invoke-virtual {v3, v0}, Landroid/view/View;->setVisibility(I)V

    .line 678
    invoke-virtual {p0}, Lcom/jibo/ui/activity/PhotoViewerActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/res/Resources;->getConfiguration()Landroid/content/res/Configuration;

    move-result-object v0

    iget v0, v0, Landroid/content/res/Configuration;->orientation:I

    const/4 v3, 0x2

    if-ne v0, v3, :cond_1

    .line 679
    iget-object v0, p0, Lcom/jibo/ui/activity/PhotoViewerActivity;->toolbar:Landroid/support/v7/widget/Toolbar;

    invoke-virtual {v0, v2}, Landroid/support/v7/widget/Toolbar;->setVisibility(I)V

    .line 680
    iget-object v0, p0, Lcom/jibo/ui/activity/PhotoViewerActivity;->footer:Landroid/view/View;

    invoke-virtual {v0, v2}, Landroid/view/View;->setVisibility(I)V

    .line 681
    invoke-direct {p0}, Lcom/jibo/ui/activity/PhotoViewerActivity;->g()V

    .line 705
    :goto_1
    return-void

    :cond_0
    move v0, v2

    .line 676
    goto :goto_0

    .line 683
    :cond_1
    iget-object v0, p0, Lcom/jibo/ui/activity/PhotoViewerActivity;->toolbar:Landroid/support/v7/widget/Toolbar;

    invoke-virtual {v0, v1}, Landroid/support/v7/widget/Toolbar;->setVisibility(I)V

    .line 684
    iget-object v0, p0, Lcom/jibo/ui/activity/PhotoViewerActivity;->footer:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 685
    iget-boolean v0, p0, Lcom/jibo/ui/activity/PhotoViewerActivity;->d:Z

    if-eqz v0, :cond_2

    .line 687
    iget-object v0, p0, Lcom/jibo/ui/activity/PhotoViewerActivity;->toolbar:Landroid/support/v7/widget/Toolbar;

    invoke-virtual {v0}, Landroid/support/v7/widget/Toolbar;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v0

    check-cast v0, Landroid/widget/RelativeLayout$LayoutParams;

    .line 688
    iget v2, p0, Lcom/jibo/ui/activity/PhotoViewerActivity;->c:I

    invoke-virtual {v0, v1, v2, v1, v1}, Landroid/widget/RelativeLayout$LayoutParams;->setMargins(IIII)V

    .line 689
    iget-object v2, p0, Lcom/jibo/ui/activity/PhotoViewerActivity;->toolbar:Landroid/support/v7/widget/Toolbar;

    invoke-virtual {v2, v0}, Landroid/support/v7/widget/Toolbar;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 691
    iget-object v0, p0, Lcom/jibo/ui/activity/PhotoViewerActivity;->footer:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v0

    check-cast v0, Landroid/widget/RelativeLayout$LayoutParams;

    .line 692
    iget v2, p0, Lcom/jibo/ui/activity/PhotoViewerActivity;->e:I

    invoke-virtual {v0, v1, v1, v1, v2}, Landroid/widget/RelativeLayout$LayoutParams;->setMargins(IIII)V

    .line 693
    iget-object v1, p0, Lcom/jibo/ui/activity/PhotoViewerActivity;->footer:Landroid/view/View;

    invoke-virtual {v1, v0}, Landroid/view/View;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    goto :goto_1

    .line 696
    :cond_2
    iget-object v0, p0, Lcom/jibo/ui/activity/PhotoViewerActivity;->toolbar:Landroid/support/v7/widget/Toolbar;

    invoke-virtual {v0}, Landroid/support/v7/widget/Toolbar;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v0

    check-cast v0, Landroid/widget/RelativeLayout$LayoutParams;

    .line 697
    iget v2, p0, Lcom/jibo/ui/activity/PhotoViewerActivity;->c:I

    invoke-virtual {v0, v1, v2, v1, v1}, Landroid/widget/RelativeLayout$LayoutParams;->setMargins(IIII)V

    .line 698
    iget-object v2, p0, Lcom/jibo/ui/activity/PhotoViewerActivity;->toolbar:Landroid/support/v7/widget/Toolbar;

    invoke-virtual {v2, v0}, Landroid/support/v7/widget/Toolbar;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 700
    iget-object v0, p0, Lcom/jibo/ui/activity/PhotoViewerActivity;->footer:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v0

    check-cast v0, Landroid/widget/RelativeLayout$LayoutParams;

    .line 701
    invoke-virtual {v0, v1, v1, v1, v1}, Landroid/widget/RelativeLayout$LayoutParams;->setMargins(IIII)V

    .line 702
    iget-object v1, p0, Lcom/jibo/ui/activity/PhotoViewerActivity;->footer:Landroid/view/View;

    invoke-virtual {v1, v0}, Landroid/view/View;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    goto :goto_1
.end method

.method public a(IILjava/lang/Object;)V
    .locals 1

    .prologue
    .line 316
    const/16 v0, 0x64

    if-ne v0, p1, :cond_1

    .line 317
    sget v0, Lcom/jibo/ui/activity/BaseActivity;->d:I

    invoke-virtual {p0, v0}, Lcom/jibo/ui/activity/PhotoViewerActivity;->setResult(I)V

    .line 318
    invoke-virtual {p0}, Lcom/jibo/ui/activity/PhotoViewerActivity;->finish()V

    .line 323
    :cond_0
    :goto_0
    return-void

    .line 319
    :cond_1
    const/16 v0, 0x75

    if-ne v0, p1, :cond_0

    .line 320
    invoke-static {p0}, Lcom/jibo/JiboAnalytics;->j(Landroid/content/Context;)V

    .line 321
    iget-object v0, p0, Lcom/jibo/ui/activity/PhotoViewerActivity;->i:Lcom/jibo/aws/integration/aws/services/media/model/Media;

    invoke-static {p0, v0}, Lcom/jibo/service/MediaDeletingService;->a(Landroid/content/Context;Lcom/jibo/aws/integration/aws/services/media/model/Media;)V

    goto :goto_0
.end method

.method protected onCreate(Landroid/os/Bundle;)V
    .locals 5

    .prologue
    const/high16 v4, 0x4000000

    const/16 v3, 0x15

    const/4 v2, 0x0

    const-string v0, "com.jibo.ui.activity.PhotoViewerActivity"

    invoke-static {v0}, Lcom/google/firebase/perf/metrics/AppStartTrace;->setLauncherActivityOnCreateTime(Ljava/lang/String;)V

    .line 148
    invoke-super {p0, p1}, Landroid/support/v7/app/AppCompatActivity;->onCreate(Landroid/os/Bundle;)V

    .line 149
    const v0, 0x7f0b0022

    invoke-virtual {p0, v0}, Lcom/jibo/ui/activity/PhotoViewerActivity;->setContentView(I)V

    .line 151
    invoke-direct {p0}, Lcom/jibo/ui/activity/PhotoViewerActivity;->d()I

    move-result v0

    iput v0, p0, Lcom/jibo/ui/activity/PhotoViewerActivity;->c:I

    .line 152
    invoke-direct {p0}, Lcom/jibo/ui/activity/PhotoViewerActivity;->e()I

    move-result v0

    iput v0, p0, Lcom/jibo/ui/activity/PhotoViewerActivity;->e:I

    .line 154
    invoke-static {p0}, Lbutterknife/ButterKnife;->a(Landroid/app/Activity;)Lbutterknife/Unbinder;

    move-result-object v0

    iput-object v0, p0, Lcom/jibo/ui/activity/PhotoViewerActivity;->b:Lbutterknife/Unbinder;

    .line 156
    invoke-virtual {p0}, Lcom/jibo/ui/activity/PhotoViewerActivity;->getWindow()Landroid/view/Window;

    move-result-object v0

    invoke-virtual {v0}, Landroid/view/Window;->getDecorView()Landroid/view/View;

    move-result-object v0

    .line 157
    new-instance v1, Lcom/jibo/ui/activity/PhotoViewerActivity$3;

    invoke-direct {v1, p0}, Lcom/jibo/ui/activity/PhotoViewerActivity$3;-><init>(Lcom/jibo/ui/activity/PhotoViewerActivity;)V

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnSystemUiVisibilityChangeListener(Landroid/view/View$OnSystemUiVisibilityChangeListener;)V

    .line 187
    iget-object v0, p0, Lcom/jibo/ui/activity/PhotoViewerActivity;->toolbar:Landroid/support/v7/widget/Toolbar;

    invoke-virtual {p0, v0}, Lcom/jibo/ui/activity/PhotoViewerActivity;->setSupportActionBar(Landroid/support/v7/widget/Toolbar;)V

    .line 188
    invoke-virtual {p0}, Lcom/jibo/ui/activity/PhotoViewerActivity;->getSupportActionBar()Landroid/support/v7/app/ActionBar;

    move-result-object v0

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Landroid/support/v7/app/ActionBar;->setDisplayHomeAsUpEnabled(Z)V

    .line 191
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    if-lt v0, v3, :cond_0

    .line 192
    invoke-virtual {p0}, Lcom/jibo/ui/activity/PhotoViewerActivity;->getWindow()Landroid/view/Window;

    move-result-object v0

    invoke-virtual {v0, v4, v4}, Landroid/view/Window;->setFlags(II)V

    .line 197
    :cond_0
    invoke-virtual {p0}, Lcom/jibo/ui/activity/PhotoViewerActivity;->getWindowManager()Landroid/view/WindowManager;

    move-result-object v0

    invoke-interface {v0}, Landroid/view/WindowManager;->getDefaultDisplay()Landroid/view/Display;

    move-result-object v0

    .line 198
    new-instance v1, Landroid/graphics/Point;

    invoke-direct {v1}, Landroid/graphics/Point;-><init>()V

    .line 199
    invoke-virtual {v0, v1}, Landroid/view/Display;->getRealSize(Landroid/graphics/Point;)V

    .line 201
    iget v0, v1, Landroid/graphics/Point;->y:I

    sput v0, Lcom/jibo/ui/activity/PhotoViewerActivity$PhotoFragment;->a:I

    .line 202
    invoke-virtual {p0}, Lcom/jibo/ui/activity/PhotoViewerActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    .line 205
    invoke-direct {p0}, Lcom/jibo/ui/activity/PhotoViewerActivity;->g()V

    .line 206
    invoke-direct {p0}, Lcom/jibo/ui/activity/PhotoViewerActivity;->h()V

    .line 212
    invoke-virtual {p0}, Lcom/jibo/ui/activity/PhotoViewerActivity;->getIntent()Landroid/content/Intent;

    move-result-object v0

    const-string v1, "media_id"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_2

    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    if-lt v0, v3, :cond_2

    .line 221
    :goto_0
    invoke-static {p0}, Lcom/jibo/db/EntityData;->a(Landroid/content/Context;)Lcom/jibo/db/EntityData;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/db/EntityData;->i()Lcom/jibo/aws/integration/aws/services/account/model/Account;

    move-result-object v0

    iput-object v0, p0, Lcom/jibo/ui/activity/PhotoViewerActivity;->m:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    .line 223
    if-nez p1, :cond_3

    .line 224
    invoke-virtual {p0}, Lcom/jibo/ui/activity/PhotoViewerActivity;->getIntent()Landroid/content/Intent;

    move-result-object v0

    if-eqz v0, :cond_1

    invoke-virtual {p0}, Lcom/jibo/ui/activity/PhotoViewerActivity;->getIntent()Landroid/content/Intent;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v0

    if-eqz v0, :cond_1

    .line 225
    invoke-virtual {p0}, Lcom/jibo/ui/activity/PhotoViewerActivity;->getIntent()Landroid/content/Intent;

    move-result-object v0

    const-string v1, "media_indx"

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->getIntExtra(Ljava/lang/String;I)I

    move-result v0

    iput v0, p0, Lcom/jibo/ui/activity/PhotoViewerActivity;->g:I

    .line 231
    :cond_1
    :goto_1
    invoke-direct {p0}, Lcom/jibo/ui/activity/PhotoViewerActivity;->c()V

    .line 232
    iget-object v0, p0, Lcom/jibo/ui/activity/PhotoViewerActivity;->pager:Landroid/support/v4/view/ViewPager;

    iget v1, p0, Lcom/jibo/ui/activity/PhotoViewerActivity;->g:I

    invoke-virtual {v0, v1}, Landroid/support/v4/view/ViewPager;->setCurrentItem(I)V

    .line 233
    invoke-direct {p0}, Lcom/jibo/ui/activity/PhotoViewerActivity;->i()V

    .line 234
    iget-object v0, p0, Lcom/jibo/ui/activity/PhotoViewerActivity;->pager:Landroid/support/v4/view/ViewPager;

    new-instance v1, Lcom/jibo/ui/activity/PhotoViewerActivity$4;

    invoke-direct {v1, p0}, Lcom/jibo/ui/activity/PhotoViewerActivity$4;-><init>(Lcom/jibo/ui/activity/PhotoViewerActivity;)V

    invoke-virtual {v0, v1}, Landroid/support/v4/view/ViewPager;->a(Landroid/support/v4/view/ViewPager$OnPageChangeListener;)V

    .line 258
    iget-object v0, p0, Lcom/jibo/ui/activity/PhotoViewerActivity;->pager:Landroid/support/v4/view/ViewPager;

    new-instance v1, Lcom/jibo/ui/activity/PhotoViewerActivity$ZoomOutPageTransformer;

    invoke-direct {v1, p0}, Lcom/jibo/ui/activity/PhotoViewerActivity$ZoomOutPageTransformer;-><init>(Lcom/jibo/ui/activity/PhotoViewerActivity;)V

    invoke-virtual {v0, v2, v1}, Landroid/support/v4/view/ViewPager;->a(ZLandroid/support/v4/view/ViewPager$PageTransformer;)V

    .line 260
    invoke-virtual {p0}, Lcom/jibo/ui/activity/PhotoViewerActivity;->a()V

    .line 261
    return-void

    .line 218
    :cond_2
    iget-object v0, p0, Lcom/jibo/ui/activity/PhotoViewerActivity;->transitionImage:Landroid/widget/ImageView;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setVisibility(I)V

    goto :goto_0

    .line 228
    :cond_3
    const-string v0, "media_indx"

    invoke-virtual {p1, v0, v2}, Landroid/os/Bundle;->getInt(Ljava/lang/String;I)I

    move-result v0

    iput v0, p0, Lcom/jibo/ui/activity/PhotoViewerActivity;->g:I

    goto :goto_1
.end method

.method public onCreateOptionsMenu(Landroid/view/Menu;)Z
    .locals 8

    .prologue
    const v3, 0x7f0600df

    const v4, 0x7f06007d

    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 266
    invoke-virtual {p0}, Lcom/jibo/ui/activity/PhotoViewerActivity;->getMenuInflater()Landroid/view/MenuInflater;

    move-result-object v0

    const v5, 0x7f0c000e

    invoke-virtual {v0, v5, p1}, Landroid/view/MenuInflater;->inflate(ILandroid/view/Menu;)V

    .line 268
    const v0, 0x7f090033

    invoke-interface {p1, v0}, Landroid/view/Menu;->findItem(I)Landroid/view/MenuItem;

    move-result-object v5

    .line 269
    const v0, 0x7f090024

    invoke-interface {p1, v0}, Landroid/view/Menu;->findItem(I)Landroid/view/MenuItem;

    move-result-object v6

    .line 270
    invoke-static {p0, p1}, Lcom/jibo/utils/ImageUtils;->a(Landroid/content/Context;Landroid/view/Menu;)V

    .line 272
    iget-boolean v0, p0, Lcom/jibo/ui/activity/PhotoViewerActivity;->n:Z

    if-eqz v0, :cond_1

    sget-object v0, Lcom/jibo/ui/activity/PhotoViewerActivity;->f:Landroid/util/SparseBooleanArray;

    iget-object v7, p0, Lcom/jibo/ui/activity/PhotoViewerActivity;->pager:Landroid/support/v4/view/ViewPager;

    invoke-virtual {v7}, Landroid/support/v4/view/ViewPager;->getCurrentItem()I

    move-result v7

    invoke-virtual {v0, v7, v2}, Landroid/util/SparseBooleanArray;->get(IZ)Z

    move-result v0

    if-eqz v0, :cond_1

    move v0, v1

    :goto_0
    invoke-interface {v5, v0}, Landroid/view/MenuItem;->setEnabled(Z)Landroid/view/MenuItem;

    .line 274
    invoke-interface {v5}, Landroid/view/MenuItem;->isEnabled()Z

    move-result v0

    if-eqz v0, :cond_2

    move v0, v3

    .line 273
    :goto_1
    invoke-static {p0, v5, v0}, Lcom/jibo/utils/ImageUtils;->a(Landroid/content/Context;Landroid/view/MenuItem;I)V

    .line 275
    iget-boolean v0, p0, Lcom/jibo/ui/activity/PhotoViewerActivity;->n:Z

    if-eqz v0, :cond_3

    sget-object v0, Lcom/jibo/ui/activity/PhotoViewerActivity;->f:Landroid/util/SparseBooleanArray;

    iget-object v5, p0, Lcom/jibo/ui/activity/PhotoViewerActivity;->pager:Landroid/support/v4/view/ViewPager;

    invoke-virtual {v5}, Landroid/support/v4/view/ViewPager;->getCurrentItem()I

    move-result v5

    invoke-virtual {v0, v5, v2}, Landroid/util/SparseBooleanArray;->get(IZ)Z

    move-result v0

    if-eqz v0, :cond_3

    move v0, v1

    :goto_2
    invoke-interface {v6, v0}, Landroid/view/MenuItem;->setEnabled(Z)Landroid/view/MenuItem;

    .line 277
    invoke-interface {v6}, Landroid/view/MenuItem;->isEnabled()Z

    move-result v0

    if-eqz v0, :cond_4

    .line 276
    :goto_3
    invoke-static {p0, v6, v3}, Lcom/jibo/utils/ImageUtils;->a(Landroid/content/Context;Landroid/view/MenuItem;I)V

    .line 280
    iget-object v0, p0, Lcom/jibo/ui/activity/PhotoViewerActivity;->i:Lcom/jibo/aws/integration/aws/services/media/model/Media;

    if-eqz v0, :cond_6

    iget-object v0, p0, Lcom/jibo/ui/activity/PhotoViewerActivity;->i:Lcom/jibo/aws/integration/aws/services/media/model/Media;

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/media/model/Media;->getAccountId()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_6

    .line 281
    invoke-static {p0}, Lcom/jibo/db/EntityData;->a(Landroid/content/Context;)Lcom/jibo/db/EntityData;

    move-result-object v0

    iget-object v3, p0, Lcom/jibo/ui/activity/PhotoViewerActivity;->i:Lcom/jibo/aws/integration/aws/services/media/model/Media;

    invoke-virtual {v3}, Lcom/jibo/aws/integration/aws/services/media/model/Media;->getLoopId()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v3}, Lcom/jibo/db/EntityData;->c(Ljava/lang/String;)Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    move-result-object v0

    .line 282
    iget-object v3, p0, Lcom/jibo/ui/activity/PhotoViewerActivity;->m:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    invoke-virtual {v3}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getId()Ljava/lang/String;

    move-result-object v3

    invoke-static {v0, v3}, Lcom/jibo/aws/integration/helpers/LoopHelper;->isOwner(Lcom/jibo/aws/integration/aws/services/loop/model/Loop;Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/jibo/ui/activity/PhotoViewerActivity;->i:Lcom/jibo/aws/integration/aws/services/media/model/Media;

    .line 283
    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/media/model/Media;->getAccountId()Ljava/lang/String;

    move-result-object v0

    iget-object v3, p0, Lcom/jibo/ui/activity/PhotoViewerActivity;->m:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    invoke-virtual {v3}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getId()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_5

    .line 284
    :cond_0
    invoke-interface {v6, v1}, Landroid/view/MenuItem;->setVisible(Z)Landroid/view/MenuItem;

    .line 291
    :goto_4
    return v1

    :cond_1
    move v0, v2

    .line 272
    goto :goto_0

    :cond_2
    move v0, v4

    .line 274
    goto :goto_1

    :cond_3
    move v0, v2

    .line 275
    goto :goto_2

    :cond_4
    move v3, v4

    .line 277
    goto :goto_3

    .line 286
    :cond_5
    invoke-interface {v6, v2}, Landroid/view/MenuItem;->setVisible(Z)Landroid/view/MenuItem;

    goto :goto_4

    .line 289
    :cond_6
    invoke-interface {v6, v2}, Landroid/view/MenuItem;->setVisible(Z)Landroid/view/MenuItem;

    goto :goto_4
.end method

.method public onDestroy()V
    .locals 1

    .prologue
    .line 356
    invoke-super {p0}, Landroid/support/v7/app/AppCompatActivity;->onDestroy()V

    .line 359
    iget-object v0, p0, Lcom/jibo/ui/activity/PhotoViewerActivity;->j:Landroid/database/Cursor;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/jibo/ui/activity/PhotoViewerActivity;->j:Landroid/database/Cursor;

    invoke-interface {v0}, Landroid/database/Cursor;->isClosed()Z

    move-result v0

    if-nez v0, :cond_0

    .line 360
    iget-object v0, p0, Lcom/jibo/ui/activity/PhotoViewerActivity;->j:Landroid/database/Cursor;

    invoke-interface {v0}, Landroid/database/Cursor;->close()V

    .line 362
    :cond_0
    sget-object v0, Lcom/jibo/ui/activity/PhotoViewerActivity;->f:Landroid/util/SparseBooleanArray;

    invoke-virtual {v0}, Landroid/util/SparseBooleanArray;->clear()V

    .line 364
    iget-object v0, p0, Lcom/jibo/ui/activity/PhotoViewerActivity;->b:Lbutterknife/Unbinder;

    invoke-interface {v0}, Lbutterknife/Unbinder;->unbind()V

    .line 365
    return-void
.end method

.method public onOptionsItemSelected(Landroid/view/MenuItem;)Z
    .locals 6

    .prologue
    const/4 v0, 0x1

    .line 296
    invoke-interface {p1}, Landroid/view/MenuItem;->getItemId()I

    move-result v1

    .line 297
    sparse-switch v1, :sswitch_data_0

    .line 311
    invoke-super {p0, p1}, Landroid/support/v7/app/AppCompatActivity;->onOptionsItemSelected(Landroid/view/MenuItem;)Z

    move-result v0

    :goto_0
    return v0

    .line 299
    :sswitch_0
    invoke-virtual {p0}, Lcom/jibo/ui/activity/PhotoViewerActivity;->onBackPressed()V

    goto :goto_0

    .line 302
    :sswitch_1
    invoke-direct {p0}, Lcom/jibo/ui/activity/PhotoViewerActivity;->j()V

    goto :goto_0

    .line 305
    :sswitch_2
    const/4 v1, 0x0

    invoke-virtual {p0}, Lcom/jibo/ui/activity/PhotoViewerActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v2

    const/16 v3, 0x75

    const v4, 0x7f10026c

    .line 306
    invoke-virtual {p0, v4}, Lcom/jibo/ui/activity/PhotoViewerActivity;->getString(I)Ljava/lang/String;

    move-result-object v4

    const v5, 0x7f100269

    invoke-virtual {p0, v5}, Lcom/jibo/ui/activity/PhotoViewerActivity;->getString(I)Ljava/lang/String;

    move-result-object v5

    .line 305
    invoke-static {v1, v2, v3, v4, v5}, Lcom/jibo/ui/fragment/dialog/DialogUtils;->a(Landroid/support/v4/app/Fragment;Landroid/support/v4/app/FragmentManager;ILjava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 297
    :sswitch_data_0
    .sparse-switch
        0x102002c -> :sswitch_0
        0x7f090024 -> :sswitch_2
        0x7f090033 -> :sswitch_1
    .end sparse-switch
.end method

.method protected onPause()V
    .locals 2

    .prologue
    .line 347
    invoke-super {p0}, Landroid/support/v7/app/AppCompatActivity;->onPause()V

    .line 349
    iget-object v0, p0, Lcom/jibo/ui/activity/PhotoViewerActivity;->o:Lcom/jibo/utils/NetworkStateReceiver;

    invoke-virtual {p0, v0}, Lcom/jibo/ui/activity/PhotoViewerActivity;->unregisterReceiver(Landroid/content/BroadcastReceiver;)V

    .line 351
    invoke-virtual {p0}, Lcom/jibo/ui/activity/PhotoViewerActivity;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    iget-object v1, p0, Lcom/jibo/ui/activity/PhotoViewerActivity;->l:Landroid/database/ContentObserver;

    invoke-virtual {v0, v1}, Landroid/content/ContentResolver;->unregisterContentObserver(Landroid/database/ContentObserver;)V

    .line 352
    return-void
.end method

.method protected onResume()V
    .locals 4

    .prologue
    const-string v0, "com.jibo.ui.activity.PhotoViewerActivity"

    invoke-static {v0}, Lcom/google/firebase/perf/metrics/AppStartTrace;->setLauncherActivityOnResumeTime(Ljava/lang/String;)V

    .line 334
    invoke-super {p0}, Landroid/support/v7/app/AppCompatActivity;->onResume()V

    .line 337
    new-instance v0, Landroid/content/IntentFilter;

    invoke-direct {v0}, Landroid/content/IntentFilter;-><init>()V

    .line 338
    const-string v1, "android.net.conn.CONNECTIVITY_CHANGE"

    invoke-virtual {v0, v1}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    .line 339
    const-string v1, "android.net.wifi.WIFI_STATE_CHANGED"

    invoke-virtual {v0, v1}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    .line 340
    iget-object v1, p0, Lcom/jibo/ui/activity/PhotoViewerActivity;->o:Lcom/jibo/utils/NetworkStateReceiver;

    invoke-virtual {p0, v1, v0}, Lcom/jibo/ui/activity/PhotoViewerActivity;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;

    .line 342
    invoke-virtual {p0}, Lcom/jibo/ui/activity/PhotoViewerActivity;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    invoke-virtual {p0}, Lcom/jibo/ui/activity/PhotoViewerActivity;->getIntent()Landroid/content/Intent;

    move-result-object v1

    invoke-virtual {v1}, Landroid/content/Intent;->getData()Landroid/net/Uri;

    move-result-object v1

    const/4 v2, 0x1

    iget-object v3, p0, Lcom/jibo/ui/activity/PhotoViewerActivity;->l:Landroid/database/ContentObserver;

    invoke-virtual {v0, v1, v2, v3}, Landroid/content/ContentResolver;->registerContentObserver(Landroid/net/Uri;ZLandroid/database/ContentObserver;)V

    .line 343
    return-void
.end method

.method protected onSaveInstanceState(Landroid/os/Bundle;)V
    .locals 2

    .prologue
    .line 327
    invoke-super {p0, p1}, Landroid/support/v7/app/AppCompatActivity;->onSaveInstanceState(Landroid/os/Bundle;)V

    .line 329
    const-string v0, "media_indx"

    iget v1, p0, Lcom/jibo/ui/activity/PhotoViewerActivity;->g:I

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 330
    return-void
.end method

.method protected onStart()V
    .locals 1

    const-string v0, "com.jibo.ui.activity.PhotoViewerActivity"

    invoke-static {v0}, Lcom/google/firebase/perf/metrics/AppStartTrace;->setLauncherActivityOnStartTime(Ljava/lang/String;)V

    invoke-super {p0}, Landroid/support/v7/app/AppCompatActivity;->onStart()V

    return-void
.end method
