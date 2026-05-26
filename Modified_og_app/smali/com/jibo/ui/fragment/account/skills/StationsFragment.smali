.class public Lcom/jibo/ui/fragment/account/skills/StationsFragment;
.super Lcom/jibo/ui/fragment/BaseFragment;
.source "StationsFragment.java"

# interfaces
.implements Landroid/support/v4/widget/SwipeRefreshLayout$OnRefreshListener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/jibo/ui/fragment/account/skills/StationsFragment$SpacesItemDecoration;,
        Lcom/jibo/ui/fragment/account/skills/StationsFragment$StationItem;
    }
.end annotation


# static fields
.field public static final a:Ljava/lang/String;


# instance fields
.field private b:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/jibo/ui/helpers/Items$Item;",
            ">;"
        }
    .end annotation
.end field

.field private c:Lcom/jibo/ui/helpers/AbstractItemRecycleViewAdapter$SimpleImplItemRecycleViewAdapter;

.field private d:Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;

.field private e:Lcom/jibo/api/iheart/model/LocationConfig;

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

.field private l:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/jibo/api/iheart/model/Station;",
            ">;"
        }
    .end annotation
.end field

.field list:Landroid/support/v7/widget/RecyclerView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field private m:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/jibo/api/iheart/model/Station;",
            ">;"
        }
    .end annotation
.end field

.field private n:Lcom/jibo/api/iheart/model/Genre;

.field private o:Lcom/google/gson/JsonObject;

.field private p:Landroid/view/View$OnClickListener;

.field private q:Lcom/jibo/aws/integration/aws/services/person/JiboPersonAsyncClient;

.field swipeRefreshLayout:Landroid/support/v4/widget/SwipeRefreshLayout;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 64
    const-class v0, Lcom/jibo/ui/fragment/account/skills/StationsFragment;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/jibo/ui/fragment/account/skills/StationsFragment;->a:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 62
    invoke-direct {p0}, Lcom/jibo/ui/fragment/BaseFragment;-><init>()V

    .line 81
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/jibo/ui/fragment/account/skills/StationsFragment;->b:Ljava/util/List;

    .line 89
    new-instance v0, Lcom/jibo/ui/fragment/account/skills/StationsFragment$1;

    invoke-direct {v0, p0}, Lcom/jibo/ui/fragment/account/skills/StationsFragment$1;-><init>(Lcom/jibo/ui/fragment/account/skills/StationsFragment;)V

    iput-object v0, p0, Lcom/jibo/ui/fragment/account/skills/StationsFragment;->p:Landroid/view/View$OnClickListener;

    return-void
.end method

.method static synthetic a(Lcom/jibo/ui/fragment/account/skills/StationsFragment;)Lcom/google/gson/JsonObject;
    .locals 1

    .prologue
    .line 62
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/StationsFragment;->o:Lcom/google/gson/JsonObject;

    return-object v0
.end method

.method static synthetic a(Lcom/jibo/ui/fragment/account/skills/StationsFragment;Lcom/google/gson/JsonObject;)Lcom/google/gson/JsonObject;
    .locals 0

    .prologue
    .line 62
    iput-object p1, p0, Lcom/jibo/ui/fragment/account/skills/StationsFragment;->o:Lcom/google/gson/JsonObject;

    return-object p1
.end method

.method static synthetic a(Lcom/jibo/ui/fragment/account/skills/StationsFragment;Ljava/util/List;)Ljava/util/List;
    .locals 0

    .prologue
    .line 62
    iput-object p1, p0, Lcom/jibo/ui/fragment/account/skills/StationsFragment;->l:Ljava/util/List;

    return-object p1
.end method

.method static synthetic a(Lcom/jibo/ui/fragment/account/skills/StationsFragment;Ljava/lang/Throwable;Ljava/lang/String;Z)V
    .locals 0

    .prologue
    .line 62
    invoke-virtual {p0, p1, p2, p3}, Lcom/jibo/ui/fragment/account/skills/StationsFragment;->a(Ljava/lang/Throwable;Ljava/lang/String;Z)V

    return-void
.end method

.method private b()Lcom/google/gson/JsonObject;
    .locals 5

    .prologue
    .line 287
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/StationsFragment;->o:Lcom/google/gson/JsonObject;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/StationsFragment;->o:Lcom/google/gson/JsonObject;

    const-string v1, "loops"

    invoke-virtual {v0, v1}, Lcom/google/gson/JsonObject;->b(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/StationsFragment;->o:Lcom/google/gson/JsonObject;

    const-string v1, "loops"

    .line 288
    invoke-virtual {v0, v1}, Lcom/google/gson/JsonObject;->c(Ljava/lang/String;)Lcom/google/gson/JsonElement;

    move-result-object v0

    invoke-virtual {v0}, Lcom/google/gson/JsonElement;->h()Z

    move-result v0

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/StationsFragment;->o:Lcom/google/gson/JsonObject;

    const-string v1, "loops"

    .line 289
    invoke-virtual {v0, v1}, Lcom/google/gson/JsonObject;->c(Ljava/lang/String;)Lcom/google/gson/JsonElement;

    move-result-object v0

    invoke-virtual {v0}, Lcom/google/gson/JsonElement;->m()Lcom/google/gson/JsonArray;

    move-result-object v0

    invoke-virtual {v0}, Lcom/google/gson/JsonArray;->a()I

    move-result v0

    if-lez v0, :cond_1

    .line 290
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/StationsFragment;->o:Lcom/google/gson/JsonObject;

    const-string v1, "loops"

    invoke-virtual {v0, v1}, Lcom/google/gson/JsonObject;->d(Ljava/lang/String;)Lcom/google/gson/JsonArray;

    move-result-object v2

    .line 291
    if-eqz v2, :cond_1

    .line 292
    const/4 v0, 0x0

    :goto_0
    invoke-virtual {v2}, Lcom/google/gson/JsonArray;->a()I

    move-result v1

    if-ge v0, v1, :cond_1

    .line 293
    invoke-virtual {v2, v0}, Lcom/google/gson/JsonArray;->a(I)Lcom/google/gson/JsonElement;

    move-result-object v1

    invoke-virtual {v1}, Lcom/google/gson/JsonElement;->l()Lcom/google/gson/JsonObject;

    move-result-object v1

    .line 294
    const-string v3, "id"

    invoke-virtual {v1, v3}, Lcom/google/gson/JsonObject;->b(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_0

    iget-object v3, p0, Lcom/jibo/ui/fragment/account/skills/StationsFragment;->k:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-virtual {v3}, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;->getId()Ljava/lang/String;

    move-result-object v3

    const-string v4, "id"

    invoke-virtual {v1, v4}, Lcom/google/gson/JsonObject;->c(Ljava/lang/String;)Lcom/google/gson/JsonElement;

    move-result-object v4

    invoke-virtual {v4}, Lcom/google/gson/JsonElement;->c()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_0

    move-object v0, v1

    .line 300
    :goto_1
    return-object v0

    .line 292
    :cond_0
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 300
    :cond_1
    const/4 v0, 0x0

    goto :goto_1
.end method

.method static synthetic b(Lcom/jibo/ui/fragment/account/skills/StationsFragment;)Lcom/google/gson/JsonObject;
    .locals 1

    .prologue
    .line 62
    invoke-direct {p0}, Lcom/jibo/ui/fragment/account/skills/StationsFragment;->q()Lcom/google/gson/JsonObject;

    move-result-object v0

    return-object v0
.end method

.method static synthetic b(Lcom/jibo/ui/fragment/account/skills/StationsFragment;Ljava/util/List;)Ljava/util/List;
    .locals 0

    .prologue
    .line 62
    iput-object p1, p0, Lcom/jibo/ui/fragment/account/skills/StationsFragment;->m:Ljava/util/List;

    return-object p1
.end method

.method static synthetic b(Lcom/jibo/ui/fragment/account/skills/StationsFragment;Ljava/lang/Throwable;Ljava/lang/String;Z)V
    .locals 0

    .prologue
    .line 62
    invoke-virtual {p0, p1, p2, p3}, Lcom/jibo/ui/fragment/account/skills/StationsFragment;->a(Ljava/lang/Throwable;Ljava/lang/String;Z)V

    return-void
.end method

.method static synthetic c(Lcom/jibo/ui/fragment/account/skills/StationsFragment;)Lcom/jibo/aws/integration/aws/services/loop/model/Loop;
    .locals 1

    .prologue
    .line 62
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/StationsFragment;->k:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    return-object v0
.end method

.method static synthetic c(Lcom/jibo/ui/fragment/account/skills/StationsFragment;Ljava/lang/Throwable;Ljava/lang/String;Z)V
    .locals 0

    .prologue
    .line 62
    invoke-virtual {p0, p1, p2, p3}, Lcom/jibo/ui/fragment/account/skills/StationsFragment;->a(Ljava/lang/Throwable;Ljava/lang/String;Z)V

    return-void
.end method

.method static synthetic d(Lcom/jibo/ui/fragment/account/skills/StationsFragment;)V
    .locals 0

    .prologue
    .line 62
    invoke-direct {p0}, Lcom/jibo/ui/fragment/account/skills/StationsFragment;->s()V

    return-void
.end method

.method static synthetic d(Lcom/jibo/ui/fragment/account/skills/StationsFragment;Ljava/lang/Throwable;Ljava/lang/String;Z)V
    .locals 0

    .prologue
    .line 62
    invoke-virtual {p0, p1, p2, p3}, Lcom/jibo/ui/fragment/account/skills/StationsFragment;->a(Ljava/lang/Throwable;Ljava/lang/String;Z)V

    return-void
.end method

.method static synthetic e(Lcom/jibo/ui/fragment/account/skills/StationsFragment;)Lcom/jibo/aws/integration/aws/services/person/JiboPersonAsyncClient;
    .locals 1

    .prologue
    .line 62
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/StationsFragment;->q:Lcom/jibo/aws/integration/aws/services/person/JiboPersonAsyncClient;

    return-object v0
.end method

.method static synthetic f(Lcom/jibo/ui/fragment/account/skills/StationsFragment;)Ljava/util/List;
    .locals 1

    .prologue
    .line 62
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/StationsFragment;->l:Ljava/util/List;

    return-object v0
.end method

.method static synthetic g(Lcom/jibo/ui/fragment/account/skills/StationsFragment;)Ljava/util/List;
    .locals 1

    .prologue
    .line 62
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/StationsFragment;->m:Ljava/util/List;

    return-object v0
.end method

.method static synthetic h(Lcom/jibo/ui/fragment/account/skills/StationsFragment;)Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;
    .locals 1

    .prologue
    .line 62
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/StationsFragment;->d:Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;

    return-object v0
.end method

.method static synthetic i(Lcom/jibo/ui/fragment/account/skills/StationsFragment;)Lcom/jibo/api/iheart/model/Genre;
    .locals 1

    .prologue
    .line 62
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/StationsFragment;->n:Lcom/jibo/api/iheart/model/Genre;

    return-object v0
.end method

.method static synthetic j(Lcom/jibo/ui/fragment/account/skills/StationsFragment;)Ljava/util/List;
    .locals 1

    .prologue
    .line 62
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/StationsFragment;->b:Ljava/util/List;

    return-object v0
.end method

.method static synthetic k(Lcom/jibo/ui/fragment/account/skills/StationsFragment;)Landroid/view/View$OnClickListener;
    .locals 1

    .prologue
    .line 62
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/StationsFragment;->p:Landroid/view/View$OnClickListener;

    return-object v0
.end method

.method static synthetic l(Lcom/jibo/ui/fragment/account/skills/StationsFragment;)Lcom/jibo/ui/helpers/AbstractItemRecycleViewAdapter$SimpleImplItemRecycleViewAdapter;
    .locals 1

    .prologue
    .line 62
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/StationsFragment;->c:Lcom/jibo/ui/helpers/AbstractItemRecycleViewAdapter$SimpleImplItemRecycleViewAdapter;

    return-object v0
.end method

.method private q()Lcom/google/gson/JsonObject;
    .locals 6

    .prologue
    const/4 v2, 0x0

    .line 309
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/StationsFragment;->o:Lcom/google/gson/JsonObject;

    if-eqz v0, :cond_2

    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/StationsFragment;->o:Lcom/google/gson/JsonObject;

    const-string v1, "loops"

    invoke-virtual {v0, v1}, Lcom/google/gson/JsonObject;->b(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_2

    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/StationsFragment;->o:Lcom/google/gson/JsonObject;

    const-string v1, "loops"

    .line 310
    invoke-virtual {v0, v1}, Lcom/google/gson/JsonObject;->c(Ljava/lang/String;)Lcom/google/gson/JsonElement;

    move-result-object v0

    invoke-virtual {v0}, Lcom/google/gson/JsonElement;->h()Z

    move-result v0

    if-eqz v0, :cond_2

    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/StationsFragment;->o:Lcom/google/gson/JsonObject;

    const-string v1, "loops"

    .line 311
    invoke-virtual {v0, v1}, Lcom/google/gson/JsonObject;->c(Ljava/lang/String;)Lcom/google/gson/JsonElement;

    move-result-object v0

    invoke-virtual {v0}, Lcom/google/gson/JsonElement;->m()Lcom/google/gson/JsonArray;

    move-result-object v0

    invoke-virtual {v0}, Lcom/google/gson/JsonArray;->a()I

    move-result v0

    if-lez v0, :cond_2

    .line 314
    invoke-direct {p0}, Lcom/jibo/ui/fragment/account/skills/StationsFragment;->b()Lcom/google/gson/JsonObject;

    move-result-object v0

    .line 315
    if-eqz v0, :cond_0

    const-string v1, "genres"

    invoke-virtual {v0, v1}, Lcom/google/gson/JsonObject;->d(Ljava/lang/String;)Lcom/google/gson/JsonArray;

    move-result-object v0

    move-object v3, v0

    .line 316
    :goto_0
    if-eqz v3, :cond_2

    .line 317
    const/4 v0, 0x0

    :goto_1
    invoke-virtual {v3}, Lcom/google/gson/JsonArray;->a()I

    move-result v1

    if-ge v0, v1, :cond_2

    .line 318
    invoke-virtual {v3, v0}, Lcom/google/gson/JsonArray;->a(I)Lcom/google/gson/JsonElement;

    move-result-object v1

    invoke-virtual {v1}, Lcom/google/gson/JsonElement;->l()Lcom/google/gson/JsonObject;

    move-result-object v1

    .line 319
    const-string v4, "id"

    invoke-virtual {v1, v4}, Lcom/google/gson/JsonObject;->b(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_1

    iget-object v4, p0, Lcom/jibo/ui/fragment/account/skills/StationsFragment;->n:Lcom/jibo/api/iheart/model/Genre;

    invoke-virtual {v4}, Lcom/jibo/api/iheart/model/Genre;->a()I

    move-result v4

    const-string v5, "id"

    invoke-virtual {v1, v5}, Lcom/google/gson/JsonObject;->c(Ljava/lang/String;)Lcom/google/gson/JsonElement;

    move-result-object v5

    invoke-virtual {v5}, Lcom/google/gson/JsonElement;->f()I

    move-result v5

    if-ne v4, v5, :cond_1

    move-object v0, v1

    .line 325
    :goto_2
    return-object v0

    :cond_0
    move-object v3, v2

    .line 315
    goto :goto_0

    .line 317
    :cond_1
    add-int/lit8 v0, v0, 0x1

    goto :goto_1

    :cond_2
    move-object v0, v2

    .line 325
    goto :goto_2
.end method

.method private r()V
    .locals 4

    .prologue
    const/4 v1, 0x0

    .line 329
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/account/skills/StationsFragment;->f()V

    .line 331
    iput-object v1, p0, Lcom/jibo/ui/fragment/account/skills/StationsFragment;->l:Ljava/util/List;

    .line 332
    iput-object v1, p0, Lcom/jibo/ui/fragment/account/skills/StationsFragment;->m:Ljava/util/List;

    .line 334
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/StationsFragment;->e:Lcom/jibo/api/iheart/model/LocationConfig;

    .line 335
    invoke-virtual {v0}, Lcom/jibo/api/iheart/model/LocationConfig;->a()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0, v1}, Lcom/jibo/api/iheart/IHeartApiServiceGenerator;->a(Ljava/lang/String;Lokhttp3/Interceptor;)Lcom/jibo/api/iheart/IHeartApiServiceGenerator$IHeartStationsApiService;

    move-result-object v0

    .line 336
    iget-object v1, p0, Lcom/jibo/ui/fragment/account/skills/StationsFragment;->d:Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;

    invoke-static {v1}, Lcom/jibo/aws/integration/helpers/RobotHelper;->getCountryCode(Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;)Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Lcom/jibo/ui/fragment/account/skills/StationsFragment;->d:Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;

    invoke-static {v2}, Lcom/jibo/aws/integration/helpers/RobotHelper;->getZipcode(Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;)Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Lcom/jibo/ui/fragment/account/skills/StationsFragment;->n:Lcom/jibo/api/iheart/model/Genre;

    .line 337
    invoke-virtual {v3}, Lcom/jibo/api/iheart/model/Genre;->a()I

    move-result v3

    .line 336
    invoke-interface {v0, v1, v2, v3}, Lcom/jibo/api/iheart/IHeartApiServiceGenerator$IHeartStationsApiService;->a(Ljava/lang/String;Ljava/lang/String;I)Lretrofit2/Call;

    move-result-object v1

    new-instance v2, Lcom/jibo/ui/fragment/account/skills/StationsFragment$4;

    invoke-direct {v2, p0, v0}, Lcom/jibo/ui/fragment/account/skills/StationsFragment$4;-><init>(Lcom/jibo/ui/fragment/account/skills/StationsFragment;Lcom/jibo/api/iheart/IHeartApiServiceGenerator$IHeartStationsApiService;)V

    .line 337
    invoke-interface {v1, v2}, Lretrofit2/Call;->a(Lretrofit2/Callback;)V

    .line 395
    return-void
.end method

.method private s()V
    .locals 1

    .prologue
    .line 399
    new-instance v0, Lcom/jibo/ui/fragment/account/skills/StationsFragment$5;

    invoke-direct {v0, p0}, Lcom/jibo/ui/fragment/account/skills/StationsFragment$5;-><init>(Lcom/jibo/ui/fragment/account/skills/StationsFragment;)V

    invoke-virtual {p0, v0}, Lcom/jibo/ui/fragment/account/skills/StationsFragment;->a(Ljava/lang/Runnable;)V

    .line 461
    return-void
.end method


# virtual methods
.method protected a(Landroid/support/v7/app/ActionBar;)V
    .locals 1

    .prologue
    .line 261
    invoke-super {p0, p1}, Lcom/jibo/ui/fragment/BaseFragment;->a(Landroid/support/v7/app/ActionBar;)V

    .line 262
    const/4 v0, 0x1

    invoke-virtual {p1, v0}, Landroid/support/v7/app/ActionBar;->setDisplayHomeAsUpEnabled(Z)V

    .line 263
    return-void
.end method

.method public b(Landroid/os/Bundle;)V
    .locals 6

    .prologue
    .line 183
    invoke-super {p0, p1}, Lcom/jibo/ui/fragment/BaseFragment;->b(Landroid/os/Bundle;)V

    .line 185
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/StationsFragment;->k:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    if-nez v0, :cond_7

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/account/skills/StationsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-static {v0}, Lcom/jibo/utils/SharedPreferencesUtil;->f(Landroid/content/Context;)Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    move-result-object v0

    :goto_0
    iput-object v0, p0, Lcom/jibo/ui/fragment/account/skills/StationsFragment;->k:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    .line 186
    const-class v0, Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v0

    check-cast v0, Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;

    iput-object v0, p0, Lcom/jibo/ui/fragment/account/skills/StationsFragment;->d:Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;

    .line 187
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

    iput-object v0, p0, Lcom/jibo/ui/fragment/account/skills/StationsFragment;->e:Lcom/jibo/api/iheart/model/LocationConfig;

    .line 188
    new-instance v0, Lcom/google/gson/Gson;

    invoke-direct {v0}, Lcom/google/gson/Gson;-><init>()V

    const-class v1, Lcom/jibo/api/iheart/model/Genre;

    invoke-virtual {v1}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p1, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    const-class v2, Lcom/jibo/api/iheart/model/Genre;

    invoke-virtual {v0, v1, v2}, Lcom/google/gson/Gson;->a(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/api/iheart/model/Genre;

    iput-object v0, p0, Lcom/jibo/ui/fragment/account/skills/StationsFragment;->n:Lcom/jibo/api/iheart/model/Genre;

    .line 189
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/StationsFragment;->n:Lcom/jibo/api/iheart/model/Genre;

    if-nez v0, :cond_8

    new-instance v0, Lcom/jibo/api/iheart/model/Genre;

    const/4 v1, 0x0

    const/4 v2, 0x0

    invoke-direct {v0, v1, v2}, Lcom/jibo/api/iheart/model/Genre;-><init>(ILjava/lang/String;)V

    :goto_1
    iput-object v0, p0, Lcom/jibo/ui/fragment/account/skills/StationsFragment;->n:Lcom/jibo/api/iheart/model/Genre;

    .line 191
    const-string v0, "PARAM_STATIONS_LOCAL"

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 193
    :try_start_0
    new-instance v0, Lcom/google/gson/Gson;

    invoke-direct {v0}, Lcom/google/gson/Gson;-><init>()V

    const-string v1, "PARAM_STATIONS_LOCAL"

    invoke-virtual {p1, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    new-instance v2, Lcom/jibo/ui/fragment/account/skills/StationsFragment$2;

    invoke-direct {v2, p0}, Lcom/jibo/ui/fragment/account/skills/StationsFragment$2;-><init>(Lcom/jibo/ui/fragment/account/skills/StationsFragment;)V

    .line 194
    invoke-virtual {v2}, Lcom/jibo/ui/fragment/account/skills/StationsFragment$2;->getType()Ljava/lang/reflect/Type;

    move-result-object v2

    .line 193
    invoke-virtual {v0, v1, v2}, Lcom/google/gson/Gson;->a(Ljava/lang/String;Ljava/lang/reflect/Type;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/List;

    iput-object v0, p0, Lcom/jibo/ui/fragment/account/skills/StationsFragment;->l:Ljava/util/List;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_2

    .line 199
    :cond_0
    :goto_2
    const-string v0, "PARAM_STATIONS_ALL"

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 201
    :try_start_1
    new-instance v0, Lcom/google/gson/Gson;

    invoke-direct {v0}, Lcom/google/gson/Gson;-><init>()V

    const-string v1, "PARAM_STATIONS_ALL"

    invoke-virtual {p1, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    new-instance v2, Lcom/jibo/ui/fragment/account/skills/StationsFragment$3;

    invoke-direct {v2, p0}, Lcom/jibo/ui/fragment/account/skills/StationsFragment$3;-><init>(Lcom/jibo/ui/fragment/account/skills/StationsFragment;)V

    .line 202
    invoke-virtual {v2}, Lcom/jibo/ui/fragment/account/skills/StationsFragment$3;->getType()Ljava/lang/reflect/Type;

    move-result-object v2

    .line 201
    invoke-virtual {v0, v1, v2}, Lcom/google/gson/Gson;->a(Ljava/lang/String;Ljava/lang/reflect/Type;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/List;

    iput-object v0, p0, Lcom/jibo/ui/fragment/account/skills/StationsFragment;->m:Ljava/util/List;
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_1

    .line 209
    :cond_1
    :goto_3
    const-class v0, Lcom/google/gson/JsonObject;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 210
    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-nez v1, :cond_2

    const-string v1, "null"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_2

    .line 212
    :try_start_2
    new-instance v0, Lcom/google/gson/JsonParser;

    invoke-direct {v0}, Lcom/google/gson/JsonParser;-><init>()V

    const-class v1, Lcom/google/gson/JsonObject;

    invoke-virtual {v1}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p1, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/google/gson/JsonParser;->a(Ljava/lang/String;)Lcom/google/gson/JsonElement;

    move-result-object v0

    check-cast v0, Lcom/google/gson/JsonObject;

    iput-object v0, p0, Lcom/jibo/ui/fragment/account/skills/StationsFragment;->o:Lcom/google/gson/JsonObject;
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_0

    .line 220
    :cond_2
    :goto_4
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "{\'id\':\'"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/jibo/ui/fragment/account/skills/StationsFragment;->k:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-virtual {v1}, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;->getId()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "\', \'genres\':[]}"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 221
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/StationsFragment;->o:Lcom/google/gson/JsonObject;

    if-nez v0, :cond_3

    .line 222
    new-instance v0, Lcom/google/gson/JsonParser;

    invoke-direct {v0}, Lcom/google/gson/JsonParser;-><init>()V

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "{\'loops\':["

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "]}"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Lcom/google/gson/JsonParser;->a(Ljava/lang/String;)Lcom/google/gson/JsonElement;

    move-result-object v0

    check-cast v0, Lcom/google/gson/JsonObject;

    iput-object v0, p0, Lcom/jibo/ui/fragment/account/skills/StationsFragment;->o:Lcom/google/gson/JsonObject;

    .line 225
    :cond_3
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/StationsFragment;->o:Lcom/google/gson/JsonObject;

    const-string v2, "loops"

    invoke-virtual {v0, v2}, Lcom/google/gson/JsonObject;->b(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_4

    .line 226
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/StationsFragment;->o:Lcom/google/gson/JsonObject;

    const-string v2, "loops"

    new-instance v3, Lcom/google/gson/JsonParser;

    invoke-direct {v3}, Lcom/google/gson/JsonParser;-><init>()V

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "["

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, "]"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Lcom/google/gson/JsonParser;->a(Ljava/lang/String;)Lcom/google/gson/JsonElement;

    move-result-object v3

    invoke-virtual {v0, v2, v3}, Lcom/google/gson/JsonObject;->a(Ljava/lang/String;Lcom/google/gson/JsonElement;)V

    .line 229
    :cond_4
    invoke-direct {p0}, Lcom/jibo/ui/fragment/account/skills/StationsFragment;->b()Lcom/google/gson/JsonObject;

    move-result-object v0

    if-nez v0, :cond_5

    .line 230
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/StationsFragment;->o:Lcom/google/gson/JsonObject;

    const-string v2, "loops"

    invoke-virtual {v0, v2}, Lcom/google/gson/JsonObject;->c(Ljava/lang/String;)Lcom/google/gson/JsonElement;

    move-result-object v0

    invoke-virtual {v0}, Lcom/google/gson/JsonElement;->m()Lcom/google/gson/JsonArray;

    move-result-object v0

    new-instance v2, Lcom/google/gson/JsonParser;

    invoke-direct {v2}, Lcom/google/gson/JsonParser;-><init>()V

    invoke-virtual {v2, v1}, Lcom/google/gson/JsonParser;->a(Ljava/lang/String;)Lcom/google/gson/JsonElement;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/google/gson/JsonArray;->a(Lcom/google/gson/JsonElement;)V

    .line 234
    :cond_5
    invoke-direct {p0}, Lcom/jibo/ui/fragment/account/skills/StationsFragment;->q()Lcom/google/gson/JsonObject;

    move-result-object v0

    if-nez v0, :cond_6

    .line 235
    invoke-direct {p0}, Lcom/jibo/ui/fragment/account/skills/StationsFragment;->b()Lcom/google/gson/JsonObject;

    move-result-object v0

    .line 236
    if-eqz v0, :cond_6

    .line 237
    const-string v1, "genres"

    invoke-virtual {v0, v1}, Lcom/google/gson/JsonObject;->d(Ljava/lang/String;)Lcom/google/gson/JsonArray;

    move-result-object v0

    new-instance v1, Lcom/google/gson/Gson;

    invoke-direct {v1}, Lcom/google/gson/Gson;-><init>()V

    iget-object v2, p0, Lcom/jibo/ui/fragment/account/skills/StationsFragment;->n:Lcom/jibo/api/iheart/model/Genre;

    invoke-virtual {v1, v2}, Lcom/google/gson/Gson;->a(Ljava/lang/Object;)Lcom/google/gson/JsonElement;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/google/gson/JsonArray;->a(Lcom/google/gson/JsonElement;)V

    .line 240
    :cond_6
    return-void

    .line 185
    :cond_7
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/StationsFragment;->k:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    goto/16 :goto_0

    .line 189
    :cond_8
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/StationsFragment;->n:Lcom/jibo/api/iheart/model/Genre;

    goto/16 :goto_1

    .line 213
    :catch_0
    move-exception v0

    goto/16 :goto_4

    .line 203
    :catch_1
    move-exception v0

    goto/16 :goto_3

    .line 195
    :catch_2
    move-exception v0

    goto/16 :goto_2
.end method

.method public g()V
    .locals 2

    .prologue
    .line 279
    invoke-super {p0}, Lcom/jibo/ui/fragment/BaseFragment;->g()V

    .line 281
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/StationsFragment;->swipeRefreshLayout:Landroid/support/v4/widget/SwipeRefreshLayout;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/support/v4/widget/SwipeRefreshLayout;->setRefreshing(Z)V

    .line 282
    return-void
.end method

.method public n_()V
    .locals 2

    .prologue
    .line 272
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/StationsFragment;->swipeRefreshLayout:Landroid/support/v4/widget/SwipeRefreshLayout;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Landroid/support/v4/widget/SwipeRefreshLayout;->setRefreshing(Z)V

    .line 274
    invoke-direct {p0}, Lcom/jibo/ui/fragment/account/skills/StationsFragment;->r()V

    .line 275
    return-void
.end method

.method protected o()Ljava/lang/String;
    .locals 1

    .prologue
    .line 267
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/StationsFragment;->n:Lcom/jibo/api/iheart/model/Genre;

    invoke-virtual {v0}, Lcom/jibo/api/iheart/model/Genre;->b()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 2

    .prologue
    .line 132
    const v0, 0x7f0b0084

    const/4 v1, 0x0

    invoke-virtual {p1, v0, p2, v1}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    return-object v0
.end method

.method public onPause()V
    .locals 2

    .prologue
    .line 176
    invoke-super {p0}, Lcom/jibo/ui/fragment/BaseFragment;->onPause()V

    .line 178
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/StationsFragment;->swipeRefreshLayout:Landroid/support/v4/widget/SwipeRefreshLayout;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/support/v4/widget/SwipeRefreshLayout;->setRefreshing(Z)V

    .line 179
    return-void
.end method

.method public onResume()V
    .locals 1

    .prologue
    .line 165
    invoke-super {p0}, Lcom/jibo/ui/fragment/BaseFragment;->onResume()V

    .line 167
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/StationsFragment;->l:Ljava/util/List;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/StationsFragment;->l:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/StationsFragment;->n:Lcom/jibo/api/iheart/model/Genre;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/StationsFragment;->n:Lcom/jibo/api/iheart/model/Genre;

    invoke-virtual {v0}, Lcom/jibo/api/iheart/model/Genre;->a()I

    move-result v0

    if-eqz v0, :cond_1

    .line 168
    :cond_0
    invoke-direct {p0}, Lcom/jibo/ui/fragment/account/skills/StationsFragment;->r()V

    .line 172
    :goto_0
    return-void

    .line 170
    :cond_1
    invoke-direct {p0}, Lcom/jibo/ui/fragment/account/skills/StationsFragment;->s()V

    goto :goto_0
.end method

.method public onSaveInstanceState(Landroid/os/Bundle;)V
    .locals 3

    .prologue
    .line 244
    invoke-super {p0, p1}, Lcom/jibo/ui/fragment/BaseFragment;->onSaveInstanceState(Landroid/os/Bundle;)V

    .line 246
    const-class v0, Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    iget-object v1, p0, Lcom/jibo/ui/fragment/account/skills/StationsFragment;->d:Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 247
    const-class v0, Lcom/jibo/api/iheart/model/LocationConfig;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    new-instance v1, Lcom/google/gson/Gson;

    invoke-direct {v1}, Lcom/google/gson/Gson;-><init>()V

    iget-object v2, p0, Lcom/jibo/ui/fragment/account/skills/StationsFragment;->e:Lcom/jibo/api/iheart/model/LocationConfig;

    invoke-virtual {v1, v2}, Lcom/google/gson/Gson;->b(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/String;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 248
    const-class v0, Lcom/jibo/api/iheart/model/Genre;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    new-instance v1, Lcom/google/gson/Gson;

    invoke-direct {v1}, Lcom/google/gson/Gson;-><init>()V

    iget-object v2, p0, Lcom/jibo/ui/fragment/account/skills/StationsFragment;->n:Lcom/jibo/api/iheart/model/Genre;

    invoke-virtual {v1, v2}, Lcom/google/gson/Gson;->b(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/String;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 249
    const-class v0, Lcom/google/gson/JsonObject;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    iget-object v1, p0, Lcom/jibo/ui/fragment/account/skills/StationsFragment;->o:Lcom/google/gson/JsonObject;

    invoke-virtual {v1}, Lcom/google/gson/JsonObject;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 251
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/StationsFragment;->l:Ljava/util/List;

    if-eqz v0, :cond_0

    .line 252
    const-string v0, "PARAM_STATIONS_LOCAL"

    new-instance v1, Lcom/google/gson/Gson;

    invoke-direct {v1}, Lcom/google/gson/Gson;-><init>()V

    iget-object v2, p0, Lcom/jibo/ui/fragment/account/skills/StationsFragment;->l:Ljava/util/List;

    invoke-virtual {v1, v2}, Lcom/google/gson/Gson;->b(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 254
    :cond_0
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/StationsFragment;->m:Ljava/util/List;

    if-eqz v0, :cond_1

    .line 255
    const-string v0, "PARAM_STATIONS_ALL"

    new-instance v1, Lcom/google/gson/Gson;

    invoke-direct {v1}, Lcom/google/gson/Gson;-><init>()V

    iget-object v2, p0, Lcom/jibo/ui/fragment/account/skills/StationsFragment;->m:Ljava/util/List;

    invoke-virtual {v1, v2}, Lcom/google/gson/Gson;->b(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 257
    :cond_1
    return-void
.end method

.method public onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V
    .locals 6

    .prologue
    const/4 v4, 0x1

    .line 137
    invoke-super {p0, p1, p2}, Lcom/jibo/ui/fragment/BaseFragment;->onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V

    .line 139
    new-instance v0, Lcom/jibo/ui/helpers/AbstractItemRecycleViewAdapter$SimpleImplItemRecycleViewAdapter;

    iget-object v1, p0, Lcom/jibo/ui/fragment/account/skills/StationsFragment;->b:Ljava/util/List;

    invoke-direct {v0, v1}, Lcom/jibo/ui/helpers/AbstractItemRecycleViewAdapter$SimpleImplItemRecycleViewAdapter;-><init>(Ljava/util/List;)V

    iput-object v0, p0, Lcom/jibo/ui/fragment/account/skills/StationsFragment;->c:Lcom/jibo/ui/helpers/AbstractItemRecycleViewAdapter$SimpleImplItemRecycleViewAdapter;

    .line 140
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/StationsFragment;->list:Landroid/support/v7/widget/RecyclerView;

    invoke-virtual {v0, v4}, Landroid/support/v7/widget/RecyclerView;->setHasFixedSize(Z)V

    .line 141
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/StationsFragment;->list:Landroid/support/v7/widget/RecyclerView;

    new-instance v1, Landroid/support/v7/widget/DefaultItemAnimator;

    invoke-direct {v1}, Landroid/support/v7/widget/DefaultItemAnimator;-><init>()V

    invoke-virtual {v0, v1}, Landroid/support/v7/widget/RecyclerView;->setItemAnimator(Landroid/support/v7/widget/RecyclerView$ItemAnimator;)V

    .line 142
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/StationsFragment;->list:Landroid/support/v7/widget/RecyclerView;

    new-instance v1, Landroid/support/v7/widget/LinearLayoutManager;

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/account/skills/StationsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v2

    const/4 v3, 0x0

    invoke-direct {v1, v2, v4, v3}, Landroid/support/v7/widget/LinearLayoutManager;-><init>(Landroid/content/Context;IZ)V

    invoke-virtual {v0, v1}, Landroid/support/v7/widget/RecyclerView;->setLayoutManager(Landroid/support/v7/widget/RecyclerView$LayoutManager;)V

    .line 143
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/StationsFragment;->list:Landroid/support/v7/widget/RecyclerView;

    new-instance v1, Lcom/jibo/ui/fragment/account/skills/StationsFragment$SpacesItemDecoration;

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/account/skills/StationsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v2

    const v3, 0x7f070116

    const v4, 0x7f07004f

    const v5, 0x7f0700b6

    invoke-direct {v1, v2, v3, v4, v5}, Lcom/jibo/ui/fragment/account/skills/StationsFragment$SpacesItemDecoration;-><init>(Landroid/content/Context;III)V

    invoke-virtual {v0, v1}, Landroid/support/v7/widget/RecyclerView;->addItemDecoration(Landroid/support/v7/widget/RecyclerView$ItemDecoration;)V

    .line 147
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/StationsFragment;->list:Landroid/support/v7/widget/RecyclerView;

    iget-object v1, p0, Lcom/jibo/ui/fragment/account/skills/StationsFragment;->c:Lcom/jibo/ui/helpers/AbstractItemRecycleViewAdapter$SimpleImplItemRecycleViewAdapter;

    invoke-virtual {v0, v1}, Landroid/support/v7/widget/RecyclerView;->setAdapter(Landroid/support/v7/widget/RecyclerView$Adapter;)V

    .line 149
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/StationsFragment;->swipeRefreshLayout:Landroid/support/v4/widget/SwipeRefreshLayout;

    invoke-virtual {v0, p0}, Landroid/support/v4/widget/SwipeRefreshLayout;->setOnRefreshListener(Landroid/support/v4/widget/SwipeRefreshLayout$OnRefreshListener;)V

    .line 150
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/StationsFragment;->swipeRefreshLayout:Landroid/support/v4/widget/SwipeRefreshLayout;

    const/4 v1, 0x4

    new-array v1, v1, [I

    fill-array-data v1, :array_0

    invoke-virtual {v0, v1}, Landroid/support/v4/widget/SwipeRefreshLayout;->setColorSchemeResources([I)V

    .line 153
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/StationsFragment;->emptyViewTitle:Landroid/widget/TextView;

    const v1, 0x7f10035d

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(I)V

    .line 154
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/StationsFragment;->emptyViewIcon:Landroid/widget/ImageView;

    const v1, 0x7f08012b

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 155
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/StationsFragment;->emptyViewTextInfo:Landroid/widget/TextView;

    const v1, 0x7f10030f

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(I)V

    .line 157
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/account/skills/StationsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-static {v0}, Lcom/jibo/db/EntityData;->a(Landroid/content/Context;)Lcom/jibo/db/EntityData;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/db/EntityData;->i()Lcom/jibo/aws/integration/aws/services/account/model/Account;

    move-result-object v0

    .line 158
    new-instance v1, Lcom/jibo/aws/integration/aws/services/person/JiboPersonAsyncClient;

    new-instance v2, Lcom/amazonaws/auth/BasicAWSCredentials;

    .line 159
    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getAccessKeyId()Ljava/lang/String;

    move-result-object v3

    .line 160
    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getSecretAccessKey()Ljava/lang/String;

    move-result-object v0

    invoke-direct {v2, v3, v0}, Lcom/amazonaws/auth/BasicAWSCredentials;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-direct {v1, v2}, Lcom/jibo/aws/integration/aws/services/person/JiboPersonAsyncClient;-><init>(Lcom/amazonaws/auth/AWSCredentials;)V

    iput-object v1, p0, Lcom/jibo/ui/fragment/account/skills/StationsFragment;->q:Lcom/jibo/aws/integration/aws/services/person/JiboPersonAsyncClient;

    .line 158
    invoke-virtual {p0, v1}, Lcom/jibo/ui/fragment/account/skills/StationsFragment;->a(Lcom/jibo/aws/integration/aws/services/AbstractJiboAsyncClient;)V

    .line 161
    return-void

    .line 150
    nop

    :array_0
    .array-data 4
        0x7f06007b
        0x7f060018
        0x7f060018
        0x7f060018
    .end array-data
.end method
