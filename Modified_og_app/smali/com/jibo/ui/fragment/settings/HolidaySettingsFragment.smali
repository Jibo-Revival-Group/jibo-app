.class public Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;
.super Lcom/jibo/ui/fragment/BaseFragment;
.source "HolidaySettingsFragment.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$HolidayComparator;,
        Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$SpacesItemDecoration;,
        Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$HolidaysAdapter;
    }
.end annotation


# static fields
.field public static final a:Ljava/lang/String;


# instance fields
.field b:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/jibo/aws/integration/aws/services/person/model/Holiday;",
            ">;"
        }
    .end annotation
.end field

.field private c:Lcom/jibo/aws/integration/aws/services/person/JiboPersonAsyncClient;

.field private d:Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$HolidaysAdapter;

.field private e:Lcom/jibo/aws/integration/aws/services/person/model/Holiday;

.field fastScroller:Lcom/jibo/ui/view/RecyclerViewFastScroller;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field list:Landroid/support/v7/widget/RecyclerView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 57
    const-class v0, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;->a:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 56
    invoke-direct {p0}, Lcom/jibo/ui/fragment/BaseFragment;-><init>()V

    .line 69
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;->b:Ljava/util/ArrayList;

    return-void
.end method

.method static synthetic a(Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;Ljava/util/List;Lcom/jibo/aws/integration/aws/services/person/model/Holiday;)I
    .locals 1

    .prologue
    .line 56
    invoke-direct {p0, p1, p2}, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;->a(Ljava/util/List;Lcom/jibo/aws/integration/aws/services/person/model/Holiday;)I

    move-result v0

    return v0
.end method

.method private a(Ljava/util/List;Lcom/jibo/aws/integration/aws/services/person/model/Holiday;)I
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/jibo/aws/integration/aws/services/person/model/Holiday;",
            ">;",
            "Lcom/jibo/aws/integration/aws/services/person/model/Holiday;",
            ")I"
        }
    .end annotation

    .prologue
    .line 589
    const-string v0, "birthday"

    invoke-direct {p0, v0}, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;->a(Ljava/lang/String;)Ljava/util/ArrayList;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    add-int/lit8 v0, v0, -0x2

    .line 590
    invoke-interface {p1, p2}, Ljava/util/List;->indexOf(Ljava/lang/Object;)I

    move-result v1

    sub-int v0, v1, v0

    return v0
.end method

.method static synthetic a(Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;Lcom/jibo/aws/integration/aws/services/person/model/Holiday;)Lcom/jibo/aws/integration/aws/services/person/model/Holiday;
    .locals 0

    .prologue
    .line 56
    iput-object p1, p0, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;->e:Lcom/jibo/aws/integration/aws/services/person/model/Holiday;

    return-object p1
.end method

.method static synthetic a(Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;)Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$HolidaysAdapter;
    .locals 1

    .prologue
    .line 56
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;->d:Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$HolidaysAdapter;

    return-object v0
.end method

.method static synthetic a(Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;Ljava/lang/String;)Ljava/util/ArrayList;
    .locals 1

    .prologue
    .line 56
    invoke-direct {p0, p1}, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;->a(Ljava/lang/String;)Ljava/util/ArrayList;

    move-result-object v0

    return-object v0
.end method

.method private a(Ljava/lang/String;)Ljava/util/ArrayList;
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/jibo/aws/integration/aws/services/person/model/Holiday;",
            ">;"
        }
    .end annotation

    .prologue
    .line 319
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 320
    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;->b:Ljava/util/ArrayList;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;->b:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_1

    :cond_0
    move-object v0, v1

    .line 327
    :goto_0
    return-object v0

    .line 322
    :cond_1
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;->b:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :cond_2
    :goto_1
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_3

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/aws/integration/aws/services/person/model/Holiday;

    .line 323
    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/person/model/Holiday;->getCategory()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {p1, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_2

    .line 324
    invoke-virtual {v1, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_1

    :cond_3
    move-object v0, v1

    .line 327
    goto :goto_0
.end method

.method private a()V
    .locals 3

    .prologue
    .line 223
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;->c:Lcom/jibo/aws/integration/aws/services/person/JiboPersonAsyncClient;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;->k:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    if-eqz v0, :cond_0

    .line 224
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;->f()V

    .line 225
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;->c:Lcom/jibo/aws/integration/aws/services/person/JiboPersonAsyncClient;

    iget-object v1, p0, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;->k:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-virtual {v1}, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;->getId()Ljava/lang/String;

    move-result-object v1

    new-instance v2, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$3;

    invoke-direct {v2, p0}, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$3;-><init>(Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;)V

    invoke-virtual {v0, v1, v2}, Lcom/jibo/aws/integration/aws/services/person/JiboPersonAsyncClient;->listHolidays(Ljava/lang/String;Lcom/amazonaws/handlers/AsyncHandler;)Ljava/util/concurrent/Future;

    .line 243
    :cond_0
    return-void
.end method

.method private a(Lcom/jibo/aws/integration/aws/services/person/model/Holiday;)V
    .locals 5

    .prologue
    .line 482
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;->b:Ljava/util/ArrayList;

    invoke-direct {p0, v0}, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;->b(Ljava/util/List;)Ljava/util/List;

    move-result-object v0

    .line 485
    invoke-interface {v0, p1}, Ljava/util/List;->remove(Ljava/lang/Object;)Z

    .line 488
    iget-object v1, p0, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;->c:Lcom/jibo/aws/integration/aws/services/person/JiboPersonAsyncClient;

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;->k:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    if-eqz v1, :cond_0

    .line 489
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;->f()V

    .line 490
    iget-object v1, p0, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;->c:Lcom/jibo/aws/integration/aws/services/person/JiboPersonAsyncClient;

    iget-object v2, p0, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;->k:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-virtual {v2}, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;->getId()Ljava/lang/String;

    move-result-object v2

    const-string v3, "customHolidays"

    invoke-static {v0}, Lcom/jibo/utils/CustomHolidaysUtils;->a(Ljava/util/List;)Lcom/google/gson/JsonObject;

    move-result-object v0

    new-instance v4, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$11;

    invoke-direct {v4, p0, p1}, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$11;-><init>(Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;Lcom/jibo/aws/integration/aws/services/person/model/Holiday;)V

    invoke-virtual {v1, v2, v3, v0, v4}, Lcom/jibo/aws/integration/aws/services/person/JiboPersonAsyncClient;->setLoopProperty(Ljava/lang/String;Ljava/lang/String;Lcom/google/gson/JsonObject;Lcom/amazonaws/handlers/AsyncHandler;)Ljava/util/concurrent/Future;

    .line 520
    :cond_0
    return-void
.end method

.method static synthetic a(Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;Ljava/lang/Throwable;Ljava/lang/String;Z)V
    .locals 0

    .prologue
    .line 56
    invoke-virtual {p0, p1, p2, p3}, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;->a(Ljava/lang/Throwable;Ljava/lang/String;Z)V

    return-void
.end method

.method static synthetic a(Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;Ljava/util/List;)V
    .locals 0

    .prologue
    .line 56
    invoke-direct {p0, p1}, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;->a(Ljava/util/List;)V

    return-void
.end method

.method static synthetic a(Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;Ljava/util/List;Ljava/util/List;)V
    .locals 0

    .prologue
    .line 56
    invoke-direct {p0, p1, p2}, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;->a(Ljava/util/List;Ljava/util/List;)V

    return-void
.end method

.method static synthetic a(Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;ZLcom/jibo/aws/integration/aws/services/person/model/Holiday;)V
    .locals 0

    .prologue
    .line 56
    invoke-direct {p0, p1, p2}, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;->a(ZLcom/jibo/aws/integration/aws/services/person/model/Holiday;)V

    return-void
.end method

.method static synthetic a(Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;ZLjava/util/List;)V
    .locals 0

    .prologue
    .line 56
    invoke-direct {p0, p1, p2}, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;->a(ZLjava/util/List;)V

    return-void
.end method

.method private a(Ljava/util/List;)V
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/jibo/aws/integration/aws/services/person/model/Holiday;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 448
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;->c:Lcom/jibo/aws/integration/aws/services/person/JiboPersonAsyncClient;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;->k:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    if-eqz v0, :cond_0

    .line 449
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;->f()V

    .line 450
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;->c:Lcom/jibo/aws/integration/aws/services/person/JiboPersonAsyncClient;

    iget-object v1, p0, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;->k:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-virtual {v1}, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;->getId()Ljava/lang/String;

    move-result-object v1

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/String;

    const/4 v3, 0x0

    const-string v4, "customHolidays"

    aput-object v4, v2, v3

    invoke-static {v2}, Ljava/util/Arrays;->asList([Ljava/lang/Object;)Ljava/util/List;

    move-result-object v2

    new-instance v3, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$10;

    invoke-direct {v3, p0, p1}, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$10;-><init>(Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;Ljava/util/List;)V

    invoke-virtual {v0, v1, v2, v3}, Lcom/jibo/aws/integration/aws/services/person/JiboPersonAsyncClient;->getLoopProperties(Ljava/lang/String;Ljava/util/List;Lcom/amazonaws/handlers/AsyncHandler;)Ljava/util/concurrent/Future;

    .line 475
    :cond_0
    return-void
.end method

.method private a(Ljava/util/List;Ljava/util/List;)V
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/jibo/aws/integration/aws/services/person/model/Holiday;",
            ">;",
            "Ljava/util/List",
            "<",
            "Lcom/jibo/aws/integration/aws/services/person/model/Holiday;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 301
    new-instance v1, Ljava/util/HashMap;

    invoke-direct {v1}, Ljava/util/HashMap;-><init>()V

    .line 302
    invoke-interface {p1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/aws/integration/aws/services/person/model/Holiday;

    .line 303
    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/person/model/Holiday;->getId()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v1, v3, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0

    .line 306
    :cond_0
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;->b:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->clear()V

    .line 307
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;->b:Ljava/util/ArrayList;

    invoke-interface {v1}, Ljava/util/Map;->values()Ljava/util/Collection;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->addAll(Ljava/util/Collection;)Z

    .line 308
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;->b:Ljava/util/ArrayList;

    invoke-virtual {v0, p2}, Ljava/util/ArrayList;->addAll(Ljava/util/Collection;)Z

    .line 309
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;->b:Ljava/util/ArrayList;

    new-instance v1, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$HolidayComparator;

    invoke-direct {v1}, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$HolidayComparator;-><init>()V

    invoke-static {v0, v1}, Ljava/util/Collections;->sort(Ljava/util/List;Ljava/util/Comparator;)V

    .line 310
    return-void
.end method

.method private a(ZLcom/jibo/aws/integration/aws/services/person/model/Holiday;)V
    .locals 5

    .prologue
    .line 527
    invoke-static {p1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    invoke-virtual {p2, v0}, Lcom/jibo/aws/integration/aws/services/person/model/Holiday;->setEnabled(Ljava/lang/Boolean;)V

    .line 530
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;->b:Ljava/util/ArrayList;

    invoke-direct {p0, v0}, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;->b(Ljava/util/List;)Ljava/util/List;

    move-result-object v0

    .line 532
    iget-object v1, p0, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;->c:Lcom/jibo/aws/integration/aws/services/person/JiboPersonAsyncClient;

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;->k:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    if-eqz v1, :cond_0

    .line 533
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;->f()V

    .line 534
    iget-object v1, p0, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;->c:Lcom/jibo/aws/integration/aws/services/person/JiboPersonAsyncClient;

    iget-object v2, p0, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;->k:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-virtual {v2}, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;->getId()Ljava/lang/String;

    move-result-object v2

    const-string v3, "customHolidays"

    invoke-static {v0}, Lcom/jibo/utils/CustomHolidaysUtils;->a(Ljava/util/List;)Lcom/google/gson/JsonObject;

    move-result-object v0

    new-instance v4, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$12;

    invoke-direct {v4, p0, p2, p1}, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$12;-><init>(Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;Lcom/jibo/aws/integration/aws/services/person/model/Holiday;Z)V

    invoke-virtual {v1, v2, v3, v0, v4}, Lcom/jibo/aws/integration/aws/services/person/JiboPersonAsyncClient;->setLoopProperty(Ljava/lang/String;Ljava/lang/String;Lcom/google/gson/JsonObject;Lcom/amazonaws/handlers/AsyncHandler;)Ljava/util/concurrent/Future;

    .line 565
    :cond_0
    return-void
.end method

.method private a(ZLjava/util/List;)V
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(Z",
            "Ljava/util/List",
            "<",
            "Lcom/jibo/aws/integration/aws/services/person/model/Holiday;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 252
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;->f()V

    .line 253
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 254
    invoke-interface {p2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/aws/integration/aws/services/person/model/Holiday;

    .line 255
    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/person/model/Holiday;->getId()Ljava/lang/String;

    move-result-object v0

    invoke-interface {v1, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 258
    :cond_0
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;->c:Lcom/jibo/aws/integration/aws/services/person/JiboPersonAsyncClient;

    iget-object v2, p0, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;->k:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-virtual {v2}, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;->getId()Ljava/lang/String;

    move-result-object v2

    new-instance v3, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$4;

    invoke-direct {v3, p0, p2, p1}, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$4;-><init>(Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;Ljava/util/List;Z)V

    invoke-virtual {v0, p1, v1, v2, v3}, Lcom/jibo/aws/integration/aws/services/person/JiboPersonAsyncClient;->switchHolidays(ZLjava/util/List;Ljava/lang/String;Lcom/amazonaws/handlers/AsyncHandler;)Ljava/util/concurrent/Future;

    .line 293
    return-void
.end method

.method static synthetic b(Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;Ljava/util/List;)Ljava/util/List;
    .locals 1

    .prologue
    .line 56
    invoke-direct {p0, p1}, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;->b(Ljava/util/List;)Ljava/util/List;

    move-result-object v0

    return-object v0
.end method

.method private b(Ljava/util/List;)Ljava/util/List;
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/jibo/aws/integration/aws/services/person/model/Holiday;",
            ">;)",
            "Ljava/util/List",
            "<",
            "Lcom/jibo/aws/integration/aws/services/person/model/Holiday;",
            ">;"
        }
    .end annotation

    .prologue
    .line 573
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 574
    invoke-interface {p1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :cond_0
    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_1

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/aws/integration/aws/services/person/model/Holiday;

    .line 575
    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/person/model/Holiday;->getCategory()Ljava/lang/String;

    move-result-object v3

    const-string v4, "custom"

    invoke-virtual {v3, v4}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 576
    invoke-virtual {v1, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 579
    :cond_1
    return-object v1
.end method

.method static synthetic b(Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;Ljava/lang/Throwable;Ljava/lang/String;Z)V
    .locals 0

    .prologue
    .line 56
    invoke-virtual {p0, p1, p2, p3}, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;->a(Ljava/lang/Throwable;Ljava/lang/String;Z)V

    return-void
.end method

.method private b()Z
    .locals 3

    .prologue
    const/4 v0, 0x0

    .line 337
    const-string v1, "birthday"

    invoke-direct {p0, v1}, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;->a(Ljava/lang/String;)Ljava/util/ArrayList;

    move-result-object v1

    .line 338
    if-eqz v1, :cond_0

    invoke-virtual {v1}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v2

    if-nez v2, :cond_0

    invoke-virtual {v1, v0}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/aws/integration/aws/services/person/model/Holiday;

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/person/model/Holiday;->getEnabled()Ljava/lang/Boolean;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    :cond_0
    return v0
.end method

.method static synthetic b(Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;)Z
    .locals 1

    .prologue
    .line 56
    invoke-direct {p0}, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;->b()Z

    move-result v0

    return v0
.end method

.method static synthetic c(Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;)Lcom/jibo/aws/integration/aws/services/loop/model/Loop;
    .locals 1

    .prologue
    .line 56
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;->k:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    return-object v0
.end method

.method static synthetic c(Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;Ljava/lang/Throwable;Ljava/lang/String;Z)V
    .locals 0

    .prologue
    .line 56
    invoke-virtual {p0, p1, p2, p3}, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;->a(Ljava/lang/Throwable;Ljava/lang/String;Z)V

    return-void
.end method

.method static synthetic c(Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;Ljava/util/List;)V
    .locals 0

    .prologue
    .line 56
    invoke-direct {p0, p1}, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;->c(Ljava/util/List;)V

    return-void
.end method

.method private c(Ljava/util/List;)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/jibo/aws/integration/aws/services/person/model/Holiday;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 597
    invoke-interface {p1}, Ljava/util/List;->size()I

    move-result v0

    move v1, v0

    :goto_0
    if-lez v1, :cond_1

    .line 598
    add-int/lit8 v0, v1, -0x1

    invoke-interface {p1, v0}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/aws/integration/aws/services/person/model/Holiday;

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/person/model/Holiday;->getCategory()Ljava/lang/String;

    move-result-object v0

    if-nez v0, :cond_0

    .line 599
    add-int/lit8 v0, v1, -0x1

    invoke-interface {p1, v0}, Ljava/util/List;->remove(I)Ljava/lang/Object;

    .line 597
    :cond_0
    add-int/lit8 v0, v1, -0x1

    move v1, v0

    goto :goto_0

    .line 602
    :cond_1
    return-void
.end method

.method static synthetic d(Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;)Lcom/jibo/aws/integration/aws/services/person/model/Holiday;
    .locals 1

    .prologue
    .line 56
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;->e:Lcom/jibo/aws/integration/aws/services/person/model/Holiday;

    return-object v0
.end method

.method static synthetic d(Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;Ljava/lang/Throwable;Ljava/lang/String;Z)V
    .locals 0

    .prologue
    .line 56
    invoke-virtual {p0, p1, p2, p3}, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;->a(Ljava/lang/Throwable;Ljava/lang/String;Z)V

    return-void
.end method

.method static synthetic e(Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;)V
    .locals 0

    .prologue
    .line 56
    invoke-direct {p0}, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;->q()V

    return-void
.end method

.method static synthetic e(Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;Ljava/lang/Throwable;Ljava/lang/String;Z)V
    .locals 0

    .prologue
    .line 56
    invoke-virtual {p0, p1, p2, p3}, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;->a(Ljava/lang/Throwable;Ljava/lang/String;Z)V

    return-void
.end method

.method private q()V
    .locals 8

    .prologue
    .line 346
    new-instance v0, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$5;

    invoke-direct {v0, p0}, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$5;-><init>(Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;)V

    .line 357
    new-instance v1, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$6;

    invoke-direct {v1, p0}, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$6;-><init>(Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;)V

    .line 371
    new-instance v6, Ljava/util/ArrayList;

    invoke-direct {v6}, Ljava/util/ArrayList;-><init>()V

    .line 372
    new-instance v2, Lcom/jibo/ui/helpers/Items$SwitchRowItem;

    const v3, 0x7f1002f9

    invoke-direct {p0}, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;->b()Z

    move-result v4

    invoke-direct {v2, v0, v3, v4}, Lcom/jibo/ui/helpers/Items$SwitchRowItem;-><init>(Landroid/view/View$OnClickListener;IZ)V

    invoke-interface {v6, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 373
    new-instance v0, Lcom/jibo/ui/helpers/Items$SimpleItem;

    sget-object v2, Lcom/jibo/ui/helpers/Items$ItemType;->add_custom_holiday:Lcom/jibo/ui/helpers/Items$ItemType;

    invoke-direct {v0, v2, v1}, Lcom/jibo/ui/helpers/Items$SimpleItem;-><init>(Lcom/jibo/ui/helpers/Items$ItemType;Landroid/view/View$OnClickListener;)V

    invoke-interface {v6, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 375
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;->b:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v7

    :cond_0
    :goto_0
    invoke-interface {v7}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_2

    invoke-interface {v7}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    move-object v5, v0

    check-cast v5, Lcom/jibo/aws/integration/aws/services/person/model/Holiday;

    .line 378
    invoke-virtual {v5}, Lcom/jibo/aws/integration/aws/services/person/model/Holiday;->getName()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 384
    invoke-virtual {v5}, Lcom/jibo/aws/integration/aws/services/person/model/Holiday;->getCategory()Ljava/lang/String;

    move-result-object v0

    const-string v1, "custom"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 385
    new-instance v0, Lcom/jibo/ui/helpers/Items$CheckboxItem;

    new-instance v1, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$7;

    invoke-direct {v1, p0, v5}, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$7;-><init>(Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;Lcom/jibo/aws/integration/aws/services/person/model/Holiday;)V

    .line 396
    invoke-virtual {v5}, Lcom/jibo/aws/integration/aws/services/person/model/Holiday;->getName()Ljava/lang/String;

    move-result-object v2

    .line 397
    invoke-virtual {v5}, Lcom/jibo/aws/integration/aws/services/person/model/Holiday;->getEnabled()Ljava/lang/Boolean;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v3

    invoke-direct {v0, v1, v2, v3}, Lcom/jibo/ui/helpers/Items$CheckboxItem;-><init>(Landroid/view/View$OnClickListener;Ljava/lang/String;Z)V

    .line 437
    :goto_1
    invoke-interface {v6, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 401
    :cond_1
    new-instance v0, Lcom/jibo/ui/helpers/Items$CheckboxDateItem;

    new-instance v1, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$8;

    invoke-direct {v1, p0, v5}, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$8;-><init>(Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;Lcom/jibo/aws/integration/aws/services/person/model/Holiday;)V

    new-instance v2, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$9;

    invoke-direct {v2, p0, v5}, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$9;-><init>(Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;Lcom/jibo/aws/integration/aws/services/person/model/Holiday;)V

    .line 432
    invoke-virtual {v5}, Lcom/jibo/aws/integration/aws/services/person/model/Holiday;->getName()Ljava/lang/String;

    move-result-object v3

    .line 433
    invoke-virtual {v5}, Lcom/jibo/aws/integration/aws/services/person/model/Holiday;->getDate()Ljava/lang/String;

    move-result-object v4

    .line 434
    invoke-virtual {v5}, Lcom/jibo/aws/integration/aws/services/person/model/Holiday;->getEnabled()Ljava/lang/Boolean;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v5

    invoke-direct/range {v0 .. v5}, Lcom/jibo/ui/helpers/Items$CheckboxDateItem;-><init>(Landroid/view/View$OnClickListener;Landroid/view/View$OnLongClickListener;Ljava/lang/String;Ljava/lang/String;Z)V

    goto :goto_1

    .line 441
    :cond_2
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;->d:Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$HolidaysAdapter;

    invoke-virtual {v0, v6}, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$HolidaysAdapter;->a(Ljava/util/List;)V

    .line 442
    return-void
.end method


# virtual methods
.method public a(IILjava/lang/Object;)V
    .locals 7

    .prologue
    const/16 v5, 0x7d

    const/4 v2, 0x1

    const/4 v0, 0x0

    const/4 v4, -0x1

    .line 176
    invoke-super {p0, p1, p2, p3}, Lcom/jibo/ui/fragment/BaseFragment;->a(IILjava/lang/Object;)V

    .line 179
    const/16 v1, 0x7c

    if-ne p1, v1, :cond_4

    .line 182
    if-nez p2, :cond_3

    .line 184
    iget-object v1, p0, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;->b:Ljava/util/ArrayList;

    invoke-direct {p0, v1}, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;->b(Ljava/util/List;)Ljava/util/List;

    move-result-object v1

    move v2, v0

    move v3, v4

    .line 188
    :goto_0
    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v0

    if-ge v2, v0, :cond_1

    if-ne v3, v4, :cond_1

    .line 189
    invoke-interface {v1, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/aws/integration/aws/services/person/model/Holiday;

    .line 190
    iget-object v5, p0, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;->e:Lcom/jibo/aws/integration/aws/services/person/model/Holiday;

    invoke-virtual {v5}, Lcom/jibo/aws/integration/aws/services/person/model/Holiday;->getName()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/person/model/Holiday;->getName()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_0

    iget-object v5, p0, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;->e:Lcom/jibo/aws/integration/aws/services/person/model/Holiday;

    invoke-virtual {v5}, Lcom/jibo/aws/integration/aws/services/person/model/Holiday;->getDate()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/person/model/Holiday;->getDate()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v5, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    move v3, v2

    .line 188
    :cond_0
    add-int/lit8 v0, v2, 0x1

    move v2, v0

    goto :goto_0

    .line 196
    :cond_1
    new-instance v2, Landroid/os/Bundle;

    invoke-direct {v2}, Landroid/os/Bundle;-><init>()V

    .line 197
    const-class v0, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    iget-object v4, p0, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;->k:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-virtual {v2, v0, v4}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 198
    const-string v4, "args_custom_holidays"

    move-object v0, v1

    check-cast v0, Ljava/util/ArrayList;

    invoke-virtual {v2, v4, v0}, Landroid/os/Bundle;->putSerializable(Ljava/lang/String;Ljava/io/Serializable;)V

    .line 199
    const-string v0, "args_custom_holidays_pos"

    invoke-virtual {v2, v0, v3}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 200
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/activity/BaseActivity;

    const-class v1, Lcom/jibo/ui/fragment/settings/CustomHolidaySettingsFragment;

    invoke-virtual {v0, v1, v2}, Lcom/jibo/ui/activity/BaseActivity;->a(Ljava/lang/Class;Landroid/os/Bundle;)V

    .line 215
    :cond_2
    :goto_1
    return-void

    .line 204
    :cond_3
    if-ne p2, v2, :cond_2

    .line 205
    const v1, 0x7f1000f6

    new-array v2, v2, [Ljava/lang/Object;

    iget-object v3, p0, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;->e:Lcom/jibo/aws/integration/aws/services/person/model/Holiday;

    .line 206
    invoke-virtual {v3}, Lcom/jibo/aws/integration/aws/services/person/model/Holiday;->getName()Ljava/lang/String;

    move-result-object v3

    aput-object v3, v2, v0

    invoke-virtual {p0, v1, v2}, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    const v1, 0x7f100269

    .line 207
    invoke-virtual {p0, v1}, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    const v2, 0x7f1000f7

    .line 208
    invoke-virtual {p0, v2}, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;->getString(I)Ljava/lang/String;

    move-result-object v2

    .line 205
    invoke-static {p0, v5, v0, v1, v2}, Lcom/jibo/ui/fragment/dialog/DialogUtils;->c(Landroid/support/v4/app/Fragment;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_1

    .line 212
    :cond_4
    if-ne p1, v5, :cond_2

    .line 213
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;->e:Lcom/jibo/aws/integration/aws/services/person/model/Holiday;

    invoke-direct {p0, v0}, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;->a(Lcom/jibo/aws/integration/aws/services/person/model/Holiday;)V

    goto :goto_1
.end method

.method protected a(Landroid/support/v7/app/ActionBar;)V
    .locals 1

    .prologue
    .line 165
    invoke-super {p0, p1}, Lcom/jibo/ui/fragment/BaseFragment;->a(Landroid/support/v7/app/ActionBar;)V

    .line 166
    const/4 v0, 0x1

    invoke-virtual {p1, v0}, Landroid/support/v7/app/ActionBar;->setDisplayHomeAsUpEnabled(Z)V

    .line 167
    return-void
.end method

.method public b(Landroid/os/Bundle;)V
    .locals 1

    .prologue
    .line 156
    invoke-super {p0, p1}, Lcom/jibo/ui/fragment/BaseFragment;->b(Landroid/os/Bundle;)V

    .line 158
    if-eqz p1, :cond_0

    const-string v0, "holidays"

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 159
    const-string v0, "holidays"

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->getParcelableArrayList(Ljava/lang/String;)Ljava/util/ArrayList;

    move-result-object v0

    iput-object v0, p0, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;->b:Ljava/util/ArrayList;

    .line 161
    :cond_0
    return-void
.end method

.method protected o()Ljava/lang/String;
    .locals 1

    .prologue
    .line 171
    const v0, 0x7f100405

    invoke-virtual {p0, v0}, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 2

    .prologue
    .line 76
    const v0, 0x7f0b0071

    const/4 v1, 0x0

    invoke-virtual {p1, v0, p2, v1}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    return-object v0
.end method

.method public onResume()V
    .locals 4

    .prologue
    .line 125
    invoke-super {p0}, Lcom/jibo/ui/fragment/BaseFragment;->onResume()V

    .line 127
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;->k:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    if-nez v0, :cond_0

    .line 128
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;->c()Landroid/os/Handler;

    move-result-object v0

    new-instance v1, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$2;

    invoke-direct {v1, p0}, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$2;-><init>(Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;)V

    const-wide/16 v2, 0x64

    invoke-virtual {v0, v1, v2, v3}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    .line 145
    :goto_0
    return-void

    .line 144
    :cond_0
    invoke-direct {p0}, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;->a()V

    goto :goto_0
.end method

.method public onSaveInstanceState(Landroid/os/Bundle;)V
    .locals 2

    .prologue
    .line 149
    invoke-super {p0, p1}, Lcom/jibo/ui/fragment/BaseFragment;->onSaveInstanceState(Landroid/os/Bundle;)V

    .line 151
    const-string v0, "holidays"

    iget-object v1, p0, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;->b:Ljava/util/ArrayList;

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putParcelableArrayList(Ljava/lang/String;Ljava/util/ArrayList;)V

    .line 152
    return-void
.end method

.method public onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V
    .locals 5

    .prologue
    const/4 v3, 0x1

    .line 81
    invoke-super {p0, p1, p2}, Lcom/jibo/ui/fragment/BaseFragment;->onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V

    .line 83
    new-instance v0, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$1;

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    const/4 v2, 0x0

    invoke-direct {v0, p0, v1, v3, v2}, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$1;-><init>(Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;Landroid/content/Context;IZ)V

    .line 102
    invoke-virtual {v0, v3}, Landroid/support/v7/widget/LinearLayoutManager;->b(I)V

    .line 103
    iget-object v1, p0, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;->list:Landroid/support/v7/widget/RecyclerView;

    invoke-virtual {v1, v3}, Landroid/support/v7/widget/RecyclerView;->setHasFixedSize(Z)V

    .line 104
    iget-object v1, p0, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;->list:Landroid/support/v7/widget/RecyclerView;

    new-instance v2, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$SpacesItemDecoration;

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v3

    const v4, 0x7f07004c

    invoke-direct {v2, v3, v4}, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$SpacesItemDecoration;-><init>(Landroid/content/Context;I)V

    invoke-virtual {v1, v2}, Landroid/support/v7/widget/RecyclerView;->addItemDecoration(Landroid/support/v7/widget/RecyclerView$ItemDecoration;)V

    .line 105
    iget-object v1, p0, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;->list:Landroid/support/v7/widget/RecyclerView;

    new-instance v2, Landroid/support/v7/widget/DefaultItemAnimator;

    invoke-direct {v2}, Landroid/support/v7/widget/DefaultItemAnimator;-><init>()V

    invoke-virtual {v1, v2}, Landroid/support/v7/widget/RecyclerView;->setItemAnimator(Landroid/support/v7/widget/RecyclerView$ItemAnimator;)V

    .line 106
    iget-object v1, p0, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;->list:Landroid/support/v7/widget/RecyclerView;

    invoke-virtual {v1, v0}, Landroid/support/v7/widget/RecyclerView;->setLayoutManager(Landroid/support/v7/widget/RecyclerView$LayoutManager;)V

    .line 108
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;->fastScroller:Lcom/jibo/ui/view/RecyclerViewFastScroller;

    iget-object v1, p0, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;->list:Landroid/support/v7/widget/RecyclerView;

    invoke-virtual {v0, v1}, Lcom/jibo/ui/view/RecyclerViewFastScroller;->setRecyclerView(Landroid/support/v7/widget/RecyclerView;)V

    .line 109
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;->fastScroller:Lcom/jibo/ui/view/RecyclerViewFastScroller;

    const v1, 0x7f0b013e

    const v2, 0x7f090130

    const v3, 0x7f090131

    invoke-virtual {v0, v1, v2, v3}, Lcom/jibo/ui/view/RecyclerViewFastScroller;->a(III)V

    .line 111
    new-instance v0, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$HolidaysAdapter;

    invoke-direct {v0}, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$HolidaysAdapter;-><init>()V

    iput-object v0, p0, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;->d:Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$HolidaysAdapter;

    .line 112
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;->list:Landroid/support/v7/widget/RecyclerView;

    iget-object v1, p0, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;->d:Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$HolidaysAdapter;

    invoke-virtual {v0, v1}, Landroid/support/v7/widget/RecyclerView;->setAdapter(Landroid/support/v7/widget/RecyclerView$Adapter;)V

    .line 114
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-static {v0}, Lcom/jibo/db/EntityData;->a(Landroid/content/Context;)Lcom/jibo/db/EntityData;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/db/EntityData;->i()Lcom/jibo/aws/integration/aws/services/account/model/Account;

    move-result-object v0

    .line 115
    new-instance v1, Lcom/jibo/aws/integration/aws/services/person/JiboPersonAsyncClient;

    new-instance v2, Lcom/amazonaws/auth/BasicAWSCredentials;

    .line 116
    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getAccessKeyId()Ljava/lang/String;

    move-result-object v3

    .line 117
    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getSecretAccessKey()Ljava/lang/String;

    move-result-object v0

    invoke-direct {v2, v3, v0}, Lcom/amazonaws/auth/BasicAWSCredentials;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-direct {v1, v2}, Lcom/jibo/aws/integration/aws/services/person/JiboPersonAsyncClient;-><init>(Lcom/amazonaws/auth/AWSCredentials;)V

    iput-object v1, p0, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;->c:Lcom/jibo/aws/integration/aws/services/person/JiboPersonAsyncClient;

    .line 115
    invoke-virtual {p0, v1}, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;->a(Lcom/jibo/aws/integration/aws/services/AbstractJiboAsyncClient;)V

    .line 120
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    iget-object v1, p0, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;->k:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-static {v0, v1}, Lcom/jibo/utils/LoopHolidaysAlarmReceiver;->b(Landroid/content/Context;Lcom/jibo/aws/integration/aws/services/loop/model/Loop;)V

    .line 121
    return-void
.end method
