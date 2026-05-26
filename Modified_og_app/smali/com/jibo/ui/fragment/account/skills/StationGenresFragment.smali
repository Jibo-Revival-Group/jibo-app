.class public Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;
.super Lcom/jibo/ui/fragment/BaseFragment;
.source "StationGenresFragment.java"

# interfaces
.implements Landroid/support/v4/widget/SwipeRefreshLayout$OnRefreshListener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/jibo/ui/fragment/account/skills/StationGenresFragment$SpacesItemDecoration;
    }
.end annotation


# static fields
.field public static final a:Ljava/lang/String;


# instance fields
.field private b:Lcom/jibo/aws/integration/aws/services/robotProperties/JiboRobotPropertiesAsyncClient;

.field private c:Lcom/jibo/aws/integration/aws/services/person/JiboPersonAsyncClient;

.field private d:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/jibo/ui/helpers/Items$Item;",
            ">;"
        }
    .end annotation
.end field

.field private e:Lcom/jibo/ui/helpers/AbstractItemRecycleViewAdapter$SimpleImplItemRecycleViewAdapter;

.field emptyView:Landroid/view/View;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field emptyViewIcon:Landroid/widget/ImageView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field emptyViewTextInfo:Landroid/widget/TextView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field emptyViewTitle:Landroid/widget/TextView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field private l:Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;

.field list:Landroid/support/v7/widget/RecyclerView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field private m:Lcom/jibo/api/iheart/model/LocationConfig;

.field private n:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/jibo/api/iheart/model/Genre;",
            ">;"
        }
    .end annotation
.end field

.field private o:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/jibo/api/iheart/model/Genre;",
            ">;"
        }
    .end annotation
.end field

.field private p:Lcom/google/gson/JsonObject;

.field swipeRefreshLayout:Landroid/support/v4/widget/SwipeRefreshLayout;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 71
    const-class v0, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;->a:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 69
    invoke-direct {p0}, Lcom/jibo/ui/fragment/BaseFragment;-><init>()V

    .line 89
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;->d:Ljava/util/List;

    return-void
.end method

.method private a(Lcom/jibo/aws/integration/aws/services/loop/model/Loop;)Landroid/text/SpannableStringBuilder;
    .locals 7

    .prologue
    const/16 v6, 0x21

    const/4 v5, 0x0

    .line 440
    const v0, 0x7f100345

    invoke-virtual {p0, v0}, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    .line 441
    new-instance v1, Landroid/text/SpannableStringBuilder;

    invoke-direct {v1, v0}, Landroid/text/SpannableStringBuilder;-><init>(Ljava/lang/CharSequence;)V

    .line 442
    new-instance v2, Lcom/jibo/utils/Util$CustomTypefaceSpan;

    const-string v3, ""

    sget-object v4, Lcom/jibo/ui/view/proxima/ProximaHelper;->c:Landroid/graphics/Typeface;

    invoke-direct {v2, v3, v4}, Lcom/jibo/utils/Util$CustomTypefaceSpan;-><init>(Ljava/lang/String;Landroid/graphics/Typeface;)V

    .line 443
    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v3

    .line 442
    invoke-virtual {v1, v2, v5, v3, v6}, Landroid/text/SpannableStringBuilder;->setSpan(Ljava/lang/Object;III)V

    .line 444
    new-instance v2, Landroid/text/style/ForegroundColorSpan;

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    const v4, 0x7f06007b

    invoke-virtual {v3, v4}, Landroid/content/res/Resources;->getColor(I)I

    move-result v3

    invoke-direct {v2, v3}, Landroid/text/style/ForegroundColorSpan;-><init>(I)V

    .line 445
    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v3

    .line 444
    invoke-virtual {v1, v2, v5, v3, v6}, Landroid/text/SpannableStringBuilder;->setSpan(Ljava/lang/Object;III)V

    .line 446
    new-instance v2, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment$5;

    invoke-direct {v2, p0, p1}, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment$5;-><init>(Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;Lcom/jibo/aws/integration/aws/services/loop/model/Loop;)V

    .line 462
    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v0

    .line 446
    invoke-virtual {v1, v2, v5, v0, v6}, Landroid/text/SpannableStringBuilder;->setSpan(Ljava/lang/Object;III)V

    .line 463
    return-object v1
.end method

.method static synthetic a(Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;Lcom/jibo/aws/integration/aws/services/loop/model/Loop;)Landroid/text/SpannableStringBuilder;
    .locals 1

    .prologue
    .line 69
    invoke-direct {p0, p1}, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;->a(Lcom/jibo/aws/integration/aws/services/loop/model/Loop;)Landroid/text/SpannableStringBuilder;

    move-result-object v0

    return-object v0
.end method

.method static synthetic a(Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;Lcom/google/gson/JsonObject;)Lcom/google/gson/JsonObject;
    .locals 0

    .prologue
    .line 69
    iput-object p1, p0, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;->p:Lcom/google/gson/JsonObject;

    return-object p1
.end method

.method static synthetic a(Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;Lcom/jibo/api/iheart/model/LocationConfig;)Lcom/jibo/api/iheart/model/LocationConfig;
    .locals 0

    .prologue
    .line 69
    iput-object p1, p0, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;->m:Lcom/jibo/api/iheart/model/LocationConfig;

    return-object p1
.end method

.method static synthetic a(Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;)Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;
    .locals 0

    .prologue
    .line 69
    iput-object p1, p0, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;->l:Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;

    return-object p1
.end method

.method static synthetic a(Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;Ljava/util/List;)Ljava/util/List;
    .locals 0

    .prologue
    .line 69
    iput-object p1, p0, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;->o:Ljava/util/List;

    return-object p1
.end method

.method static synthetic a(Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;)V
    .locals 0
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 69
    invoke-direct {p0}, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;->b()V

    return-void
.end method

.method static synthetic a(Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;Ljava/lang/Throwable;Ljava/lang/String;Z)V
    .locals 0

    .prologue
    .line 69
    invoke-virtual {p0, p1, p2, p3}, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;->a(Ljava/lang/Throwable;Ljava/lang/String;Z)V

    return-void
.end method

.method private b()V
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 217
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;->m:Lcom/jibo/api/iheart/model/LocationConfig;

    .line 218
    invoke-virtual {v0}, Lcom/jibo/api/iheart/model/LocationConfig;->a()Ljava/lang/String;

    move-result-object v0

    const/4 v1, 0x0

    invoke-static {v0, v1}, Lcom/jibo/api/iheart/IHeartApiServiceGenerator;->a(Ljava/lang/String;Lokhttp3/Interceptor;)Lcom/jibo/api/iheart/IHeartApiServiceGenerator$IHeartStationsApiService;

    move-result-object v0

    .line 220
    if-nez v0, :cond_0

    new-instance v0, Ljava/lang/Exception;

    const-string v1, "Empty iHeart apiUrl supplied"

    invoke-direct {v0, v1}, Ljava/lang/Exception;-><init>(Ljava/lang/String;)V

    throw v0

    .line 230
    :cond_0
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;->getContext()Landroid/content/Context;

    move-result-object v0

    iget-object v1, p0, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;->l:Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;

    invoke-static {v1}, Lcom/jibo/aws/integration/helpers/RobotHelper;->getCountryCode(Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;)Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/jibo/api/iheart/IHeartFileHelper;->a(Landroid/content/Context;Ljava/lang/String;)Ljava/util/List;

    move-result-object v0

    iput-object v0, p0, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;->n:Ljava/util/List;

    .line 232
    return-void
.end method

.method static synthetic b(Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;)V
    .locals 0

    .prologue
    .line 69
    invoke-direct {p0}, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;->s()V

    return-void
.end method

.method static synthetic b(Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;Ljava/lang/Throwable;Ljava/lang/String;Z)V
    .locals 0

    .prologue
    .line 69
    invoke-virtual {p0, p1, p2, p3}, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;->a(Ljava/lang/Throwable;Ljava/lang/String;Z)V

    return-void
.end method

.method static synthetic c(Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;)Lcom/jibo/aws/integration/aws/services/loop/model/Loop;
    .locals 1

    .prologue
    .line 69
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;->k:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    return-object v0
.end method

.method static synthetic c(Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;Ljava/lang/Throwable;Ljava/lang/String;Z)V
    .locals 0

    .prologue
    .line 69
    invoke-virtual {p0, p1, p2, p3}, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;->a(Ljava/lang/Throwable;Ljava/lang/String;Z)V

    return-void
.end method

.method static synthetic d(Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;)V
    .locals 0

    .prologue
    .line 69
    invoke-direct {p0}, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;->q()V

    return-void
.end method

.method static synthetic d(Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;Ljava/lang/Throwable;Ljava/lang/String;Z)V
    .locals 0

    .prologue
    .line 69
    invoke-virtual {p0, p1, p2, p3}, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;->a(Ljava/lang/Throwable;Ljava/lang/String;Z)V

    return-void
.end method

.method static synthetic e(Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;)Ljava/util/List;
    .locals 1

    .prologue
    .line 69
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;->d:Ljava/util/List;

    return-object v0
.end method

.method static synthetic e(Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;Ljava/lang/Throwable;Ljava/lang/String;Z)V
    .locals 0

    .prologue
    .line 69
    invoke-virtual {p0, p1, p2, p3}, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;->a(Ljava/lang/Throwable;Ljava/lang/String;Z)V

    return-void
.end method

.method static synthetic f(Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;)Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;
    .locals 1

    .prologue
    .line 69
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;->l:Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;

    return-object v0
.end method

.method static synthetic f(Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;Ljava/lang/Throwable;Ljava/lang/String;Z)V
    .locals 0

    .prologue
    .line 69
    invoke-virtual {p0, p1, p2, p3}, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;->a(Ljava/lang/Throwable;Ljava/lang/String;Z)V

    return-void
.end method

.method static synthetic g(Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;)Lcom/jibo/api/iheart/model/LocationConfig;
    .locals 1

    .prologue
    .line 69
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;->m:Lcom/jibo/api/iheart/model/LocationConfig;

    return-object v0
.end method

.method static synthetic h(Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;)Ljava/util/List;
    .locals 1

    .prologue
    .line 69
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;->n:Ljava/util/List;

    return-object v0
.end method

.method static synthetic i(Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;)Lcom/google/gson/JsonObject;
    .locals 1

    .prologue
    .line 69
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;->p:Lcom/google/gson/JsonObject;

    return-object v0
.end method

.method static synthetic j(Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;)Ljava/util/List;
    .locals 1

    .prologue
    .line 69
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;->o:Ljava/util/List;

    return-object v0
.end method

.method static synthetic k(Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;)Lcom/jibo/ui/helpers/AbstractItemRecycleViewAdapter$SimpleImplItemRecycleViewAdapter;
    .locals 1

    .prologue
    .line 69
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;->e:Lcom/jibo/ui/helpers/AbstractItemRecycleViewAdapter$SimpleImplItemRecycleViewAdapter;

    return-object v0
.end method

.method private q()V
    .locals 4

    .prologue
    const/4 v0, 0x0

    .line 235
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;->f()V

    .line 236
    iput-object v0, p0, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;->p:Lcom/google/gson/JsonObject;

    .line 237
    iput-object v0, p0, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;->o:Ljava/util/List;

    .line 238
    iput-object v0, p0, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;->n:Ljava/util/List;

    .line 241
    :try_start_0
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    .line 242
    const-string v1, "com.jibo.music.stations"

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 243
    iget-object v1, p0, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;->c:Lcom/jibo/aws/integration/aws/services/person/JiboPersonAsyncClient;

    iget-object v2, p0, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;->k:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-virtual {v2}, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;->getId()Ljava/lang/String;

    move-result-object v2

    new-instance v3, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment$2;

    invoke-direct {v3, p0}, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment$2;-><init>(Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;)V

    invoke-virtual {v1, v2, v0, v3}, Lcom/jibo/aws/integration/aws/services/person/JiboPersonAsyncClient;->getLoopProperties(Ljava/lang/String;Ljava/util/List;Lcom/amazonaws/handlers/AsyncHandler;)Ljava/util/concurrent/Future;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 301
    :goto_0
    return-void

    .line 298
    :catch_0
    move-exception v0

    .line 299
    const-string v1, "error get account properties"

    const/4 v2, 0x0

    invoke-virtual {p0, v0, v1, v2}, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;->a(Ljava/lang/Throwable;Ljava/lang/String;Z)V

    goto :goto_0
.end method

.method private r()V
    .locals 3

    .prologue
    .line 305
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;->l:Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;

    .line 307
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;->f()V

    .line 309
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;->b:Lcom/jibo/aws/integration/aws/services/robotProperties/JiboRobotPropertiesAsyncClient;

    iget-object v1, p0, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;->k:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-virtual {v1}, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;->getRobotFriendlyId()Ljava/lang/String;

    move-result-object v1

    new-instance v2, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment$3;

    invoke-direct {v2, p0}, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment$3;-><init>(Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;)V

    invoke-virtual {v0, v1, v2}, Lcom/jibo/aws/integration/aws/services/robotProperties/JiboRobotPropertiesAsyncClient;->getRobot(Ljava/lang/String;Lcom/amazonaws/handlers/AsyncHandler;)Ljava/util/concurrent/Future;

    .line 366
    return-void
.end method

.method private s()V
    .locals 1

    .prologue
    .line 370
    new-instance v0, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment$4;

    invoke-direct {v0, p0}, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment$4;-><init>(Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;)V

    invoke-virtual {p0, v0}, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;->a(Ljava/lang/Runnable;)V

    .line 436
    return-void
.end method


# virtual methods
.method protected a(Landroid/support/v7/app/ActionBar;)V
    .locals 1

    .prologue
    .line 190
    invoke-super {p0, p1}, Lcom/jibo/ui/fragment/BaseFragment;->a(Landroid/support/v7/app/ActionBar;)V

    .line 191
    const/4 v0, 0x1

    invoke-virtual {p1, v0}, Landroid/support/v7/app/ActionBar;->setDisplayHomeAsUpEnabled(Z)V

    .line 192
    return-void
.end method

.method public b(Landroid/os/Bundle;)V
    .locals 3

    .prologue
    .line 159
    invoke-super {p0, p1}, Lcom/jibo/ui/fragment/BaseFragment;->b(Landroid/os/Bundle;)V

    .line 161
    const-class v0, Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v0

    check-cast v0, Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;

    iput-object v0, p0, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;->l:Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;

    .line 162
    const-class v0, Lcom/jibo/api/iheart/model/LocationConfig;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 163
    new-instance v0, Lcom/google/gson/Gson;

    invoke-direct {v0}, Lcom/google/gson/Gson;-><init>()V

    const-class v1, Lcom/jibo/api/iheart/model/LocationConfig;

    invoke-virtual {v1}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p1, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    const-class v2, Lcom/jibo/api/iheart/model/LocationConfig;

    invoke-virtual {v0, v1, v2}, Lcom/google/gson/Gson;->a(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/api/iheart/model/LocationConfig;

    iput-object v0, p0, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;->m:Lcom/jibo/api/iheart/model/LocationConfig;

    .line 165
    :cond_0
    const-class v0, Lcom/jibo/api/iheart/model/Genre;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 167
    :try_start_0
    new-instance v0, Lcom/google/gson/Gson;

    invoke-direct {v0}, Lcom/google/gson/Gson;-><init>()V

    const-class v1, Lcom/jibo/api/iheart/model/Genre;

    invoke-virtual {v1}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p1, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    new-instance v2, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment$1;

    invoke-direct {v2, p0}, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment$1;-><init>(Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;)V

    .line 168
    invoke-virtual {v2}, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment$1;->getType()Ljava/lang/reflect/Type;

    move-result-object v2

    .line 167
    invoke-virtual {v0, v1, v2}, Lcom/google/gson/Gson;->a(Ljava/lang/String;Ljava/lang/reflect/Type;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/List;

    iput-object v0, p0, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;->n:Ljava/util/List;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 173
    :cond_1
    :goto_0
    return-void

    .line 169
    :catch_0
    move-exception v0

    goto :goto_0
.end method

.method public g()V
    .locals 2

    .prologue
    .line 208
    invoke-super {p0}, Lcom/jibo/ui/fragment/BaseFragment;->g()V

    .line 210
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;->swipeRefreshLayout:Landroid/support/v4/widget/SwipeRefreshLayout;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/support/v4/widget/SwipeRefreshLayout;->setRefreshing(Z)V

    .line 211
    return-void
.end method

.method public n_()V
    .locals 2

    .prologue
    .line 201
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;->swipeRefreshLayout:Landroid/support/v4/widget/SwipeRefreshLayout;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Landroid/support/v4/widget/SwipeRefreshLayout;->setRefreshing(Z)V

    .line 203
    invoke-direct {p0}, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;->r()V

    .line 204
    return-void
.end method

.method protected o()Ljava/lang/String;
    .locals 1

    .prologue
    .line 196
    const v0, 0x7f100416

    invoke-virtual {p0, v0}, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 2

    .prologue
    .line 99
    const v0, 0x7f0b0084

    const/4 v1, 0x0

    invoke-virtual {p1, v0, p2, v1}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    return-object v0
.end method

.method public onPause()V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 149
    invoke-super {p0}, Lcom/jibo/ui/fragment/BaseFragment;->onPause()V

    .line 151
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;->swipeRefreshLayout:Landroid/support/v4/widget/SwipeRefreshLayout;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/support/v4/widget/SwipeRefreshLayout;->setRefreshing(Z)V

    .line 153
    iput-object v2, p0, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;->p:Lcom/google/gson/JsonObject;

    .line 154
    iput-object v2, p0, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;->o:Ljava/util/List;

    .line 155
    return-void
.end method

.method public onResume()V
    .locals 1

    .prologue
    .line 135
    invoke-super {p0}, Lcom/jibo/ui/fragment/BaseFragment;->onResume()V

    .line 137
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;->l:Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;->m:Lcom/jibo/api/iheart/model/LocationConfig;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;->n:Ljava/util/List;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;->n:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;->l:Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;

    .line 138
    invoke-static {v0}, Lcom/jibo/aws/integration/helpers/RobotHelper;->getCountryCode(Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 139
    :cond_0
    invoke-direct {p0}, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;->r()V

    .line 145
    :goto_0
    return-void

    .line 140
    :cond_1
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;->p:Lcom/google/gson/JsonObject;

    if-nez v0, :cond_2

    .line 141
    invoke-direct {p0}, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;->q()V

    goto :goto_0

    .line 143
    :cond_2
    invoke-direct {p0}, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;->s()V

    goto :goto_0
.end method

.method public onSaveInstanceState(Landroid/os/Bundle;)V
    .locals 3

    .prologue
    .line 177
    invoke-super {p0, p1}, Lcom/jibo/ui/fragment/BaseFragment;->onSaveInstanceState(Landroid/os/Bundle;)V

    .line 179
    const-class v0, Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    iget-object v1, p0, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;->l:Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 180
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;->m:Lcom/jibo/api/iheart/model/LocationConfig;

    if-eqz v0, :cond_0

    .line 181
    const-class v0, Lcom/jibo/api/iheart/model/LocationConfig;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    new-instance v1, Lcom/google/gson/Gson;

    invoke-direct {v1}, Lcom/google/gson/Gson;-><init>()V

    iget-object v2, p0, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;->m:Lcom/jibo/api/iheart/model/LocationConfig;

    invoke-virtual {v1, v2}, Lcom/google/gson/Gson;->b(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/String;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 183
    :cond_0
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;->n:Ljava/util/List;

    if-eqz v0, :cond_1

    .line 184
    const-class v0, Lcom/jibo/api/iheart/model/Genre;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    new-instance v1, Lcom/google/gson/Gson;

    invoke-direct {v1}, Lcom/google/gson/Gson;-><init>()V

    iget-object v2, p0, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;->n:Ljava/util/List;

    invoke-virtual {v1, v2}, Lcom/google/gson/Gson;->b(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/String;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 186
    :cond_1
    return-void
.end method

.method public onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V
    .locals 6

    .prologue
    const/4 v4, 0x1

    .line 104
    invoke-super {p0, p1, p2}, Lcom/jibo/ui/fragment/BaseFragment;->onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V

    .line 106
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-static {v0}, Lcom/jibo/utils/SharedPreferencesUtil;->f(Landroid/content/Context;)Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    move-result-object v0

    iput-object v0, p0, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;->k:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    .line 108
    new-instance v0, Lcom/jibo/ui/helpers/AbstractItemRecycleViewAdapter$SimpleImplItemRecycleViewAdapter;

    iget-object v1, p0, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;->d:Ljava/util/List;

    invoke-direct {v0, v1}, Lcom/jibo/ui/helpers/AbstractItemRecycleViewAdapter$SimpleImplItemRecycleViewAdapter;-><init>(Ljava/util/List;)V

    iput-object v0, p0, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;->e:Lcom/jibo/ui/helpers/AbstractItemRecycleViewAdapter$SimpleImplItemRecycleViewAdapter;

    .line 109
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;->list:Landroid/support/v7/widget/RecyclerView;

    invoke-virtual {v0, v4}, Landroid/support/v7/widget/RecyclerView;->setHasFixedSize(Z)V

    .line 110
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;->list:Landroid/support/v7/widget/RecyclerView;

    new-instance v1, Landroid/support/v7/widget/DefaultItemAnimator;

    invoke-direct {v1}, Landroid/support/v7/widget/DefaultItemAnimator;-><init>()V

    invoke-virtual {v0, v1}, Landroid/support/v7/widget/RecyclerView;->setItemAnimator(Landroid/support/v7/widget/RecyclerView$ItemAnimator;)V

    .line 111
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;->list:Landroid/support/v7/widget/RecyclerView;

    new-instance v1, Landroid/support/v7/widget/LinearLayoutManager;

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v2

    const/4 v3, 0x0

    invoke-direct {v1, v2, v4, v3}, Landroid/support/v7/widget/LinearLayoutManager;-><init>(Landroid/content/Context;IZ)V

    invoke-virtual {v0, v1}, Landroid/support/v7/widget/RecyclerView;->setLayoutManager(Landroid/support/v7/widget/RecyclerView$LayoutManager;)V

    .line 112
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;->list:Landroid/support/v7/widget/RecyclerView;

    new-instance v1, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment$SpacesItemDecoration;

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v2

    const v3, 0x7f070116

    const v4, 0x7f07004f

    const v5, 0x7f0700b6

    invoke-direct {v1, v2, v3, v4, v5}, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment$SpacesItemDecoration;-><init>(Landroid/content/Context;III)V

    invoke-virtual {v0, v1}, Landroid/support/v7/widget/RecyclerView;->addItemDecoration(Landroid/support/v7/widget/RecyclerView$ItemDecoration;)V

    .line 116
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;->list:Landroid/support/v7/widget/RecyclerView;

    iget-object v1, p0, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;->e:Lcom/jibo/ui/helpers/AbstractItemRecycleViewAdapter$SimpleImplItemRecycleViewAdapter;

    invoke-virtual {v0, v1}, Landroid/support/v7/widget/RecyclerView;->setAdapter(Landroid/support/v7/widget/RecyclerView$Adapter;)V

    .line 118
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;->swipeRefreshLayout:Landroid/support/v4/widget/SwipeRefreshLayout;

    invoke-virtual {v0, p0}, Landroid/support/v4/widget/SwipeRefreshLayout;->setOnRefreshListener(Landroid/support/v4/widget/SwipeRefreshLayout$OnRefreshListener;)V

    .line 119
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;->swipeRefreshLayout:Landroid/support/v4/widget/SwipeRefreshLayout;

    const/4 v1, 0x4

    new-array v1, v1, [I

    fill-array-data v1, :array_0

    invoke-virtual {v0, v1}, Landroid/support/v4/widget/SwipeRefreshLayout;->setColorSchemeResources([I)V

    .line 122
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;->emptyViewTitle:Landroid/widget/TextView;

    const v1, 0x7f10035d

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(I)V

    .line 123
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;->emptyViewIcon:Landroid/widget/ImageView;

    const v1, 0x7f08012b

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 124
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;->emptyViewTextInfo:Landroid/widget/TextView;

    const v1, 0x7f10030f

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(I)V

    .line 126
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-static {v0}, Lcom/jibo/db/EntityData;->a(Landroid/content/Context;)Lcom/jibo/db/EntityData;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/db/EntityData;->g()Lcom/jibo/aws/integration/aws/services/robotProperties/JiboRobotPropertiesAsyncClient;

    move-result-object v0

    iput-object v0, p0, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;->b:Lcom/jibo/aws/integration/aws/services/robotProperties/JiboRobotPropertiesAsyncClient;

    .line 127
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-static {v0}, Lcom/jibo/db/EntityData;->a(Landroid/content/Context;)Lcom/jibo/db/EntityData;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/db/EntityData;->i()Lcom/jibo/aws/integration/aws/services/account/model/Account;

    move-result-object v0

    .line 128
    new-instance v1, Lcom/jibo/aws/integration/aws/services/person/JiboPersonAsyncClient;

    new-instance v2, Lcom/amazonaws/auth/BasicAWSCredentials;

    .line 129
    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getAccessKeyId()Ljava/lang/String;

    move-result-object v3

    .line 130
    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getSecretAccessKey()Ljava/lang/String;

    move-result-object v0

    invoke-direct {v2, v3, v0}, Lcom/amazonaws/auth/BasicAWSCredentials;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-direct {v1, v2}, Lcom/jibo/aws/integration/aws/services/person/JiboPersonAsyncClient;-><init>(Lcom/amazonaws/auth/AWSCredentials;)V

    iput-object v1, p0, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;->c:Lcom/jibo/aws/integration/aws/services/person/JiboPersonAsyncClient;

    .line 128
    invoke-virtual {p0, v1}, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;->a(Lcom/jibo/aws/integration/aws/services/AbstractJiboAsyncClient;)V

    .line 131
    return-void

    .line 119
    nop

    :array_0
    .array-data 4
        0x7f06007b
        0x7f060018
        0x7f060018
        0x7f060018
    .end array-data
.end method
