.class public Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter;
.super Ljava/lang/Object;
.source "CasePublisherPresenter.java"

# interfaces
.implements Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherContract$Presenter;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter$CreateCaseHandler;,
        Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter$CaseLayoutDataHandler;
    }
.end annotation


# instance fields
.field a:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/salesforce/android/cases/ui/internal/features/publisher/viewmodel/CaseFieldViewModel;",
            ">;"
        }
    .end annotation
.end field

.field b:Ljava/lang/String;

.field c:Ljava/lang/ref/WeakReference;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/lang/ref/WeakReference",
            "<",
            "Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherContract$Presenter$Listener;",
            ">;"
        }
    .end annotation
.end field

.field d:Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherContract$View;

.field e:Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter$CaseLayoutDataHandler;

.field f:Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter$CreateCaseHandler;

.field g:Z

.field private final h:Lcom/salesforce/android/cases/ui/CaseUIClient;

.field private final i:Lcom/salesforce/android/cases/ui/internal/utils/HandlerFactory;

.field private j:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/salesforce/android/cases/core/model/CaseField;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Lcom/salesforce/android/cases/ui/CaseUIClient;Lcom/salesforce/android/cases/ui/internal/utils/HandlerFactory;)V
    .locals 1

    .prologue
    .line 85
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 78
    new-instance v0, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter$CaseLayoutDataHandler;

    invoke-direct {v0, p0}, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter$CaseLayoutDataHandler;-><init>(Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter;)V

    iput-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter;->e:Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter$CaseLayoutDataHandler;

    .line 79
    new-instance v0, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter$CreateCaseHandler;

    invoke-direct {v0, p0}, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter$CreateCaseHandler;-><init>(Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter;)V

    iput-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter;->f:Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter$CreateCaseHandler;

    .line 86
    iput-object p1, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter;->h:Lcom/salesforce/android/cases/ui/CaseUIClient;

    .line 87
    iput-object p2, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter;->i:Lcom/salesforce/android/cases/ui/internal/utils/HandlerFactory;

    .line 88
    new-instance v0, Lcom/salesforce/android/cases/ui/internal/features/publisher/NulledCasePublisherView;

    invoke-direct {v0}, Lcom/salesforce/android/cases/ui/internal/features/publisher/NulledCasePublisherView;-><init>()V

    iput-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter;->d:Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherContract$View;

    .line 89
    return-void
.end method

.method static synthetic a(Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter;)Lcom/salesforce/android/cases/ui/CaseUIClient;
    .locals 1

    .prologue
    .line 62
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter;->h:Lcom/salesforce/android/cases/ui/CaseUIClient;

    return-object v0
.end method

.method private a(Lcom/salesforce/android/cases/core/internal/model/CreateCaseRecordModel;)V
    .locals 8

    .prologue
    const/4 v5, 0x0

    .line 261
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter;->f:Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter$CreateCaseHandler;

    iput-object p1, v0, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter$CreateCaseHandler;->a:Lcom/salesforce/android/cases/core/internal/model/CreateCaseRecordModel;

    .line 264
    invoke-direct {p0}, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter;->n()V

    .line 266
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter;->h:Lcom/salesforce/android/cases/ui/CaseUIClient;

    invoke-interface {v0}, Lcom/salesforce/android/cases/ui/CaseUIClient;->b()Ljava/lang/String;

    move-result-object v0

    iget-object v1, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter;->h:Lcom/salesforce/android/cases/ui/CaseUIClient;

    .line 267
    invoke-interface {v1}, Lcom/salesforce/android/cases/ui/CaseUIClient;->d()Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter;->h:Lcom/salesforce/android/cases/ui/CaseUIClient;

    invoke-interface {v2}, Lcom/salesforce/android/cases/ui/CaseUIClient;->c()Ljava/lang/String;

    move-result-object v2

    invoke-direct {p0}, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter;->r()Ljava/lang/String;

    move-result-object v3

    const-string v4, "submit_started"

    const/4 v6, 0x0

    .line 268
    invoke-static {v6}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v7

    move-object v6, v5

    .line 266
    invoke-static/range {v0 .. v7}, Lcom/salesforce/android/cases/ui/CasesUIAnalyticsEmit;->a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V

    .line 271
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter;->i:Lcom/salesforce/android/cases/ui/internal/utils/HandlerFactory;

    invoke-static {}, Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/salesforce/android/cases/ui/internal/utils/HandlerFactory;->a(Landroid/os/Looper;)Landroid/os/Handler;

    move-result-object v0

    new-instance v1, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter$1;

    invoke-direct {v1, p0}, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter$1;-><init>(Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter;)V

    const-wide/16 v2, 0x5dc

    invoke-virtual {v0, v1, v2, v3}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    .line 276
    return-void
.end method

.method private a(Lcom/salesforce/android/cases/core/model/CaseLayoutData;)V
    .locals 5

    .prologue
    .line 180
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter;->h:Lcom/salesforce/android/cases/ui/CaseUIClient;

    invoke-interface {v0}, Lcom/salesforce/android/cases/ui/CaseUIClient;->b()Ljava/lang/String;

    move-result-object v0

    iget-object v1, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter;->h:Lcom/salesforce/android/cases/ui/CaseUIClient;

    .line 181
    invoke-interface {v1}, Lcom/salesforce/android/cases/ui/CaseUIClient;->d()Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter;->h:Lcom/salesforce/android/cases/ui/CaseUIClient;

    invoke-interface {v2}, Lcom/salesforce/android/cases/ui/CaseUIClient;->c()Ljava/lang/String;

    move-result-object v2

    invoke-direct {p0}, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter;->r()Ljava/lang/String;

    move-result-object v3

    const-string v4, "publisher_loaded"

    .line 180
    invoke-static {v0, v1, v2, v3, v4}, Lcom/salesforce/android/cases/ui/CasesUIAnalyticsEmit;->a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 185
    invoke-direct {p0, p1}, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter;->b(Lcom/salesforce/android/cases/core/model/CaseLayoutData;)V

    .line 188
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter;->d:Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherContract$View;

    invoke-interface {v0}, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherContract$View;->q_()V

    .line 191
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter;->d:Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherContract$View;

    invoke-interface {v0}, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherContract$View;->c()V

    .line 194
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter;->f:Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter$CreateCaseHandler;

    invoke-virtual {v0}, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter$CreateCaseHandler;->i()Z

    move-result v0

    if-nez v0, :cond_0

    .line 195
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter;->d:Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherContract$View;

    invoke-interface {v0}, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherContract$View;->m()V

    .line 197
    :cond_0
    return-void
.end method

.method static synthetic a(Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter;Lcom/salesforce/android/cases/core/model/CaseLayoutData;)V
    .locals 0

    .prologue
    .line 62
    invoke-direct {p0, p1}, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter;->a(Lcom/salesforce/android/cases/core/model/CaseLayoutData;)V

    return-void
.end method

.method static synthetic a(Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 62
    invoke-direct {p0, p1}, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter;->a(Ljava/lang/String;)V

    return-void
.end method

.method private a(Ljava/lang/String;)V
    .locals 8

    .prologue
    .line 289
    invoke-direct {p0}, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter;->s()I

    move-result v6

    .line 290
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter;->h:Lcom/salesforce/android/cases/ui/CaseUIClient;

    invoke-interface {v0}, Lcom/salesforce/android/cases/ui/CaseUIClient;->b()Ljava/lang/String;

    move-result-object v0

    iget-object v1, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter;->h:Lcom/salesforce/android/cases/ui/CaseUIClient;

    .line 291
    invoke-interface {v1}, Lcom/salesforce/android/cases/ui/CaseUIClient;->d()Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter;->h:Lcom/salesforce/android/cases/ui/CaseUIClient;

    invoke-interface {v2}, Lcom/salesforce/android/cases/ui/CaseUIClient;->c()Ljava/lang/String;

    move-result-object v2

    invoke-direct {p0}, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter;->r()Ljava/lang/String;

    move-result-object v3

    const-string v4, "submit_complete"

    const-string v5, "success"

    .line 292
    invoke-static {v6}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v7

    move-object v6, p1

    .line 290
    invoke-static/range {v0 .. v7}, Lcom/salesforce/android/cases/ui/CasesUIAnalyticsEmit;->a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V

    .line 294
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter;->g:Z

    .line 297
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter;->d:Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherContract$View;

    invoke-interface {v0}, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherContract$View;->r_()V

    .line 300
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter;->d:Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherContract$View;

    invoke-interface {v0}, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherContract$View;->k()V

    .line 303
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter;->h:Lcom/salesforce/android/cases/ui/CaseUIClient;

    invoke-interface {v0}, Lcom/salesforce/android/cases/ui/CaseUIClient;->e()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 306
    invoke-direct {p0}, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter;->q()V

    .line 312
    :goto_0
    return-void

    .line 310
    :cond_0
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter;->d:Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherContract$View;

    invoke-interface {v0}, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherContract$View;->g()V

    goto :goto_0
.end method

.method private b(Ljava/lang/String;)I
    .locals 2

    .prologue
    .line 431
    invoke-virtual {p1}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v0

    const-string v1, "\\s+"

    invoke-virtual {v0, v1}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v0

    .line 432
    array-length v0, v0

    return v0
.end method

.method private b(Lcom/salesforce/android/cases/core/model/CaseLayoutData;)V
    .locals 5

    .prologue
    const/4 v2, 0x0

    .line 335
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter;->a:Ljava/util/List;

    .line 336
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter;->j:Ljava/util/List;

    .line 339
    invoke-interface {p1}, Lcom/salesforce/android/cases/core/model/CaseLayoutData;->a()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :cond_0
    :goto_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_4

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/salesforce/android/cases/core/model/CaseField;

    .line 343
    invoke-interface {v0}, Lcom/salesforce/android/cases/core/model/CaseField;->f()Lcom/salesforce/android/cases/core/model/CaseFieldType;

    move-result-object v1

    invoke-virtual {v1}, Lcom/salesforce/android/cases/core/model/CaseFieldType;->isTextField()Z

    move-result v1

    if-eqz v1, :cond_1

    iget-object v1, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter;->h:Lcom/salesforce/android/cases/ui/CaseUIClient;

    invoke-interface {v1}, Lcom/salesforce/android/cases/ui/CaseUIClient;->e()Z

    move-result v1

    if-nez v1, :cond_1

    .line 344
    invoke-interface {v0, v2}, Lcom/salesforce/android/cases/core/model/CaseField;->a(Ljava/lang/String;)V

    .line 348
    :cond_1
    invoke-interface {v0}, Lcom/salesforce/android/cases/core/model/CaseField;->e()Z

    move-result v1

    if-nez v1, :cond_0

    .line 350
    invoke-direct {p0}, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter;->p()Ljava/util/Map;

    move-result-object v1

    invoke-interface {v0}, Lcom/salesforce/android/cases/core/model/CaseField;->a()Ljava/lang/String;

    move-result-object v4

    invoke-interface {v1, v4}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_2

    .line 352
    const/4 v1, 0x1

    invoke-interface {v0, v1}, Lcom/salesforce/android/cases/core/model/CaseField;->a(Z)V

    .line 353
    invoke-direct {p0}, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter;->p()Ljava/util/Map;

    move-result-object v1

    invoke-interface {v0}, Lcom/salesforce/android/cases/core/model/CaseField;->a()Ljava/lang/String;

    move-result-object v4

    invoke-interface {v1, v4}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    invoke-interface {v0, v1}, Lcom/salesforce/android/cases/core/model/CaseField;->a(Ljava/lang/String;)V

    .line 354
    iget-object v1, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter;->j:Ljava/util/List;

    invoke-interface {v1, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 361
    :cond_2
    sget-object v1, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter$2;->a:[I

    invoke-interface {v0}, Lcom/salesforce/android/cases/core/model/CaseField;->f()Lcom/salesforce/android/cases/core/model/CaseFieldType;

    move-result-object v4

    invoke-virtual {v4}, Lcom/salesforce/android/cases/core/model/CaseFieldType;->ordinal()I

    move-result v4

    aget v1, v1, v4

    packed-switch v1, :pswitch_data_0

    move-object v1, v2

    .line 374
    :goto_1
    if-eqz v1, :cond_0

    .line 377
    invoke-interface {v0}, Lcom/salesforce/android/cases/core/model/CaseField;->a()Ljava/lang/String;

    move-result-object v0

    iget-object v4, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter;->b:Ljava/lang/String;

    invoke-virtual {v0, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_3

    .line 378
    invoke-interface {v1}, Lcom/salesforce/android/cases/ui/internal/features/publisher/viewmodel/CaseFieldViewModel;->c()V

    .line 382
    :cond_3
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter;->a:Ljava/util/List;

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 365
    :pswitch_0
    iget-object v1, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter;->d:Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherContract$View;

    invoke-interface {v1, v0}, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherContract$View;->a(Lcom/salesforce/android/cases/core/model/CaseField;)Lcom/salesforce/android/cases/ui/internal/features/publisher/viewmodel/CaseTextInputViewModel;

    move-result-object v1

    goto :goto_1

    .line 369
    :pswitch_1
    iget-object v1, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter;->d:Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherContract$View;

    invoke-interface {v1, v0}, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherContract$View;->b(Lcom/salesforce/android/cases/core/model/CaseField;)Lcom/salesforce/android/cases/ui/internal/features/publisher/viewmodel/CasePickListViewModel;

    move-result-object v1

    goto :goto_1

    .line 385
    :cond_4
    return-void

    .line 361
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_0
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method

.method static synthetic b(Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter;)V
    .locals 0

    .prologue
    .line 62
    invoke-direct {p0}, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter;->i()V

    return-void
.end method

.method static synthetic c(Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter;)V
    .locals 0

    .prologue
    .line 62
    invoke-direct {p0}, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter;->k()V

    return-void
.end method

.method static synthetic d(Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter;)V
    .locals 0

    .prologue
    .line 62
    invoke-direct {p0}, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter;->j()V

    return-void
.end method

.method static synthetic e(Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter;)V
    .locals 0

    .prologue
    .line 62
    invoke-direct {p0}, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter;->n()V

    return-void
.end method

.method static synthetic f(Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter;)V
    .locals 0

    .prologue
    .line 62
    invoke-direct {p0}, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter;->o()V

    return-void
.end method

.method private i()V
    .locals 1

    .prologue
    .line 173
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter;->d:Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherContract$View;

    invoke-interface {v0}, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherContract$View;->p_()V

    .line 176
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter;->d:Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherContract$View;

    invoke-interface {v0}, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherContract$View;->l()V

    .line 177
    return-void
.end method

.method private j()V
    .locals 1

    .prologue
    .line 202
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter;->d:Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherContract$View;

    invoke-interface {v0}, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherContract$View;->q_()V

    .line 205
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter;->d:Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherContract$View;

    invoke-interface {v0}, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherContract$View;->e()V

    .line 206
    return-void
.end method

.method private k()V
    .locals 1

    .prologue
    .line 211
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter;->d:Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherContract$View;

    invoke-interface {v0}, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherContract$View;->q_()V

    .line 214
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter;->d:Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherContract$View;

    invoke-interface {v0}, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherContract$View;->f()V

    .line 215
    return-void
.end method

.method private l()V
    .locals 4

    .prologue
    .line 220
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter;->f:Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter$CreateCaseHandler;

    invoke-virtual {v0}, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter$CreateCaseHandler;->e()V

    .line 223
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter;->d:Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherContract$View;

    invoke-interface {v0}, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherContract$View;->i()V

    .line 226
    invoke-direct {p0}, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter;->m()Z

    move-result v0

    if-eqz v0, :cond_2

    .line 227
    new-instance v1, Lcom/salesforce/android/cases/core/internal/model/CreateCaseRecordModel$Builder;

    invoke-direct {v1}, Lcom/salesforce/android/cases/core/internal/model/CreateCaseRecordModel$Builder;-><init>()V

    .line 230
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter;->a:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/salesforce/android/cases/ui/internal/features/publisher/viewmodel/CaseFieldViewModel;

    .line 231
    invoke-interface {v0}, Lcom/salesforce/android/cases/ui/internal/features/publisher/viewmodel/CaseFieldViewModel;->d()Lcom/salesforce/android/cases/core/model/CaseField;

    move-result-object v3

    invoke-interface {v3}, Lcom/salesforce/android/cases/core/model/CaseField;->a()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v0}, Lcom/salesforce/android/cases/ui/internal/features/publisher/viewmodel/CaseFieldViewModel;->f()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v3, v0}, Lcom/salesforce/android/cases/core/internal/model/CreateCaseRecordModel$Builder;->a(Ljava/lang/String;Ljava/lang/String;)Lcom/salesforce/android/cases/core/internal/model/CreateCaseRecordModel$Builder;

    goto :goto_0

    .line 235
    :cond_0
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter;->j:Ljava/util/List;

    if-eqz v0, :cond_1

    .line 236
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter;->j:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :goto_1
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_1

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/salesforce/android/cases/core/model/CaseField;

    .line 237
    invoke-interface {v0}, Lcom/salesforce/android/cases/core/model/CaseField;->a()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v0}, Lcom/salesforce/android/cases/core/model/CaseField;->h()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v3, v0}, Lcom/salesforce/android/cases/core/internal/model/CreateCaseRecordModel$Builder;->a(Ljava/lang/String;Ljava/lang/String;)Lcom/salesforce/android/cases/core/internal/model/CreateCaseRecordModel$Builder;

    goto :goto_1

    .line 242
    :cond_1
    invoke-virtual {v1}, Lcom/salesforce/android/cases/core/internal/model/CreateCaseRecordModel$Builder;->a()Lcom/salesforce/android/cases/core/internal/model/CreateCaseRecordModel;

    move-result-object v0

    invoke-direct {p0, v0}, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter;->a(Lcom/salesforce/android/cases/core/internal/model/CreateCaseRecordModel;)V

    .line 244
    :cond_2
    return-void
.end method

.method private m()Z
    .locals 3

    .prologue
    .line 249
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter;->a:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :cond_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_1

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/salesforce/android/cases/ui/internal/features/publisher/viewmodel/CaseFieldViewModel;

    .line 250
    invoke-interface {v0}, Lcom/salesforce/android/cases/ui/internal/features/publisher/viewmodel/CaseFieldViewModel;->e()Z

    move-result v2

    if-nez v2, :cond_0

    .line 251
    invoke-interface {v0}, Lcom/salesforce/android/cases/ui/internal/features/publisher/viewmodel/CaseFieldViewModel;->c()V

    .line 252
    const/4 v0, 0x0

    .line 255
    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x1

    goto :goto_0
.end method

.method private n()V
    .locals 1

    .prologue
    .line 279
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter;->g:Z

    .line 282
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter;->d:Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherContract$View;

    invoke-interface {v0}, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherContract$View;->j()V

    .line 285
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter;->d:Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherContract$View;

    invoke-interface {v0}, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherContract$View;->l()V

    .line 286
    return-void
.end method

.method private o()V
    .locals 8

    .prologue
    .line 315
    invoke-direct {p0}, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter;->s()I

    move-result v7

    .line 316
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter;->h:Lcom/salesforce/android/cases/ui/CaseUIClient;

    invoke-interface {v0}, Lcom/salesforce/android/cases/ui/CaseUIClient;->b()Ljava/lang/String;

    move-result-object v0

    iget-object v1, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter;->h:Lcom/salesforce/android/cases/ui/CaseUIClient;

    .line 317
    invoke-interface {v1}, Lcom/salesforce/android/cases/ui/CaseUIClient;->d()Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter;->h:Lcom/salesforce/android/cases/ui/CaseUIClient;

    invoke-interface {v2}, Lcom/salesforce/android/cases/ui/CaseUIClient;->c()Ljava/lang/String;

    move-result-object v2

    invoke-direct {p0}, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter;->r()Ljava/lang/String;

    move-result-object v3

    const-string v4, "submit_complete"

    const-string v5, "failure"

    const/4 v6, 0x0

    .line 318
    invoke-static {v7}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v7

    .line 316
    invoke-static/range {v0 .. v7}, Lcom/salesforce/android/cases/ui/CasesUIAnalyticsEmit;->a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V

    .line 320
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter;->g:Z

    .line 323
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter;->d:Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherContract$View;

    invoke-interface {v0}, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherContract$View;->k()V

    .line 326
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter;->d:Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherContract$View;

    invoke-interface {v0}, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherContract$View;->h()V

    .line 329
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter;->d:Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherContract$View;

    invoke-interface {v0}, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherContract$View;->m()V

    .line 330
    return-void
.end method

.method private p()Ljava/util/Map;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 388
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter;->h:Lcom/salesforce/android/cases/ui/CaseUIClient;

    invoke-interface {v0}, Lcom/salesforce/android/cases/ui/CaseUIClient;->a()Lcom/salesforce/android/cases/core/CaseClient;

    move-result-object v0

    invoke-interface {v0}, Lcom/salesforce/android/cases/core/CaseClient;->a()Lcom/salesforce/android/cases/core/CaseClientCallbacks;

    move-result-object v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter;->h:Lcom/salesforce/android/cases/ui/CaseUIClient;

    .line 389
    invoke-interface {v0}, Lcom/salesforce/android/cases/ui/CaseUIClient;->a()Lcom/salesforce/android/cases/core/CaseClient;

    move-result-object v0

    invoke-interface {v0}, Lcom/salesforce/android/cases/core/CaseClient;->a()Lcom/salesforce/android/cases/core/CaseClientCallbacks;

    move-result-object v0

    invoke-interface {v0}, Lcom/salesforce/android/cases/core/CaseClientCallbacks;->a()Ljava/util/Map;

    move-result-object v0

    if-nez v0, :cond_1

    .line 391
    :cond_0
    invoke-static {}, Ljava/util/Collections;->emptyMap()Ljava/util/Map;

    move-result-object v0

    .line 393
    :goto_0
    return-object v0

    :cond_1
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter;->h:Lcom/salesforce/android/cases/ui/CaseUIClient;

    invoke-interface {v0}, Lcom/salesforce/android/cases/ui/CaseUIClient;->a()Lcom/salesforce/android/cases/core/CaseClient;

    move-result-object v0

    invoke-interface {v0}, Lcom/salesforce/android/cases/core/CaseClient;->a()Lcom/salesforce/android/cases/core/CaseClientCallbacks;

    move-result-object v0

    invoke-interface {v0}, Lcom/salesforce/android/cases/core/CaseClientCallbacks;->a()Ljava/util/Map;

    move-result-object v0

    goto :goto_0
.end method

.method private q()V
    .locals 5

    .prologue
    .line 397
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter;->h:Lcom/salesforce/android/cases/ui/CaseUIClient;

    invoke-interface {v0}, Lcom/salesforce/android/cases/ui/CaseUIClient;->b()Ljava/lang/String;

    move-result-object v0

    .line 398
    iget-object v1, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter;->h:Lcom/salesforce/android/cases/ui/CaseUIClient;

    invoke-interface {v1}, Lcom/salesforce/android/cases/ui/CaseUIClient;->d()Ljava/lang/String;

    move-result-object v1

    .line 399
    iget-object v2, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter;->h:Lcom/salesforce/android/cases/ui/CaseUIClient;

    invoke-interface {v2}, Lcom/salesforce/android/cases/ui/CaseUIClient;->c()Ljava/lang/String;

    move-result-object v2

    .line 400
    invoke-direct {p0}, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter;->r()Ljava/lang/String;

    move-result-object v3

    .line 401
    const-string v4, "publisher_dismissed"

    invoke-static {v0, v1, v2, v3, v4}, Lcom/salesforce/android/cases/ui/CasesUIAnalyticsEmit;->a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 404
    invoke-direct {p0}, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter;->s()I

    move-result v4

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    .line 403
    invoke-static {v0, v1, v2, v3, v4}, Lcom/salesforce/android/cases/ui/CasesUIAnalyticsEmit;->a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V

    .line 406
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter;->c:Ljava/lang/ref/WeakReference;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter;->c:Ljava/lang/ref/WeakReference;

    invoke-virtual {v0}, Ljava/lang/ref/WeakReference;->get()Ljava/lang/Object;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 407
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter;->c:Ljava/lang/ref/WeakReference;

    invoke-virtual {v0}, Ljava/lang/ref/WeakReference;->get()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherContract$Presenter$Listener;

    invoke-interface {v0}, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherContract$Presenter$Listener;->d()V

    .line 409
    :cond_0
    return-void
.end method

.method private r()Ljava/lang/String;
    .locals 1

    .prologue
    .line 412
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter;->h:Lcom/salesforce/android/cases/ui/CaseUIClient;

    invoke-interface {v0}, Lcom/salesforce/android/cases/ui/CaseUIClient;->e()Z

    move-result v0

    if-eqz v0, :cond_0

    const-string v0, "authenticated"

    :goto_0
    return-object v0

    :cond_0
    const-string v0, "guest"

    goto :goto_0
.end method

.method private s()I
    .locals 4

    .prologue
    const/4 v0, 0x0

    .line 417
    .line 418
    iget-object v1, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter;->a:Ljava/util/List;

    if-nez v1, :cond_0

    .line 427
    :goto_0
    return v0

    .line 421
    :cond_0
    iget-object v1, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter;->a:Ljava/util/List;

    invoke-interface {v1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    move v1, v0

    :goto_1
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_1

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/salesforce/android/cases/ui/internal/features/publisher/viewmodel/CaseFieldViewModel;

    .line 422
    invoke-interface {v0}, Lcom/salesforce/android/cases/ui/internal/features/publisher/viewmodel/CaseFieldViewModel;->f()Ljava/lang/String;

    move-result-object v0

    .line 423
    if-eqz v0, :cond_2

    invoke-virtual {v0}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/String;->isEmpty()Z

    move-result v3

    if-nez v3, :cond_2

    .line 424
    invoke-direct {p0, v0}, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter;->b(Ljava/lang/String;)I

    move-result v0

    add-int/2addr v1, v0

    move v0, v1

    :goto_2
    move v1, v0

    .line 426
    goto :goto_1

    :cond_1
    move v0, v1

    .line 427
    goto :goto_0

    :cond_2
    move v0, v1

    goto :goto_2
.end method


# virtual methods
.method public a()V
    .locals 0

    .prologue
    .line 141
    invoke-direct {p0}, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter;->l()V

    .line 142
    return-void
.end method

.method public a(Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherContract$Presenter$Listener;)V
    .locals 1

    .prologue
    .line 130
    new-instance v0, Ljava/lang/ref/WeakReference;

    invoke-direct {v0, p1}, Ljava/lang/ref/WeakReference;-><init>(Ljava/lang/Object;)V

    iput-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter;->c:Ljava/lang/ref/WeakReference;

    .line 131
    return-void
.end method

.method public a(Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherContract$View;)V
    .locals 5

    .prologue
    .line 94
    invoke-interface {p1, p0}, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherContract$View;->setPresenter(Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherContract$Presenter;)V

    .line 95
    iput-object p1, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter;->d:Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherContract$View;

    .line 98
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter;->e:Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter$CaseLayoutDataHandler;

    invoke-virtual {v0}, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter$CaseLayoutDataHandler;->d()V

    .line 101
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter;->f:Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter$CreateCaseHandler;

    invoke-virtual {v0}, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter$CreateCaseHandler;->i()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 102
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter;->f:Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter$CreateCaseHandler;

    invoke-virtual {v0}, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter$CreateCaseHandler;->d()V

    .line 105
    :cond_0
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter;->h:Lcom/salesforce/android/cases/ui/CaseUIClient;

    invoke-interface {v0}, Lcom/salesforce/android/cases/ui/CaseUIClient;->b()Ljava/lang/String;

    move-result-object v0

    iget-object v1, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter;->h:Lcom/salesforce/android/cases/ui/CaseUIClient;

    .line 106
    invoke-interface {v1}, Lcom/salesforce/android/cases/ui/CaseUIClient;->d()Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter;->h:Lcom/salesforce/android/cases/ui/CaseUIClient;

    invoke-interface {v2}, Lcom/salesforce/android/cases/ui/CaseUIClient;->c()Ljava/lang/String;

    move-result-object v2

    invoke-direct {p0}, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter;->r()Ljava/lang/String;

    move-result-object v3

    const-string v4, "publisher_launched"

    .line 105
    invoke-static {v0, v1, v2, v3, v4}, Lcom/salesforce/android/cases/ui/CasesUIAnalyticsEmit;->a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 108
    return-void
.end method

.method public bridge synthetic a(Lcom/salesforce/android/cases/ui/internal/features/shared/BaseView;)V
    .locals 0

    .prologue
    .line 62
    check-cast p1, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherContract$View;

    invoke-virtual {p0, p1}, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter;->a(Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherContract$View;)V

    return-void
.end method

.method public bridge synthetic a(Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 62
    check-cast p1, Ljava/lang/Void;

    invoke-virtual {p0, p1}, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter;->a(Ljava/lang/Void;)V

    return-void
.end method

.method public a(Ljava/lang/Void;)V
    .locals 0

    .prologue
    .line 91
    return-void
.end method

.method public b()V
    .locals 0

    .prologue
    .line 145
    invoke-direct {p0}, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter;->q()V

    .line 146
    return-void
.end method

.method public c()V
    .locals 0

    .prologue
    .line 149
    invoke-direct {p0}, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter;->l()V

    .line 150
    return-void
.end method

.method public d()V
    .locals 3

    .prologue
    .line 113
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter;->a:Ljava/util/List;

    invoke-static {v0}, Lcom/salesforce/android/cases/ui/internal/utils/CollectionUtils;->a(Ljava/util/Collection;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 114
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter;->a:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :cond_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_1

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/salesforce/android/cases/ui/internal/features/publisher/viewmodel/CaseFieldViewModel;

    .line 115
    invoke-interface {v0}, Lcom/salesforce/android/cases/ui/internal/features/publisher/viewmodel/CaseFieldViewModel;->b()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 116
    invoke-interface {v0}, Lcom/salesforce/android/cases/ui/internal/features/publisher/viewmodel/CaseFieldViewModel;->d()Lcom/salesforce/android/cases/core/model/CaseField;

    move-result-object v0

    invoke-interface {v0}, Lcom/salesforce/android/cases/core/model/CaseField;->a()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter;->b:Ljava/lang/String;

    .line 121
    :cond_1
    return-void
.end method

.method public e()V
    .locals 1

    .prologue
    .line 124
    new-instance v0, Lcom/salesforce/android/cases/ui/internal/features/publisher/NulledCasePublisherView;

    invoke-direct {v0}, Lcom/salesforce/android/cases/ui/internal/features/publisher/NulledCasePublisherView;-><init>()V

    iput-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter;->d:Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherContract$View;

    .line 125
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter;->e:Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter$CaseLayoutDataHandler;

    invoke-virtual {v0}, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter$CaseLayoutDataHandler;->e()V

    .line 126
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter;->f:Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter$CreateCaseHandler;

    invoke-virtual {v0}, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter$CreateCaseHandler;->e()V

    .line 127
    return-void
.end method

.method public f()V
    .locals 1

    .prologue
    .line 134
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter;->c:Ljava/lang/ref/WeakReference;

    if-eqz v0, :cond_0

    .line 135
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter;->c:Ljava/lang/ref/WeakReference;

    invoke-virtual {v0}, Ljava/lang/ref/WeakReference;->clear()V

    .line 136
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter;->c:Ljava/lang/ref/WeakReference;

    .line 138
    :cond_0
    return-void
.end method

.method public g()Z
    .locals 2

    .prologue
    .line 153
    iget-boolean v0, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter;->g:Z

    if-nez v0, :cond_1

    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter;->a:Ljava/util/List;

    invoke-static {v0}, Lcom/salesforce/android/cases/ui/internal/utils/CollectionUtils;->a(Ljava/util/Collection;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 154
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter;->a:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :cond_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_1

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/salesforce/android/cases/ui/internal/features/publisher/viewmodel/CaseFieldViewModel;

    .line 155
    invoke-interface {v0}, Lcom/salesforce/android/cases/ui/internal/features/publisher/viewmodel/CaseFieldViewModel;->g()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 156
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter;->d:Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherContract$View;

    invoke-interface {v0}, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherContract$View;->n()V

    .line 157
    const/4 v0, 0x1

    .line 163
    :goto_0
    return v0

    .line 162
    :cond_1
    invoke-direct {p0}, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter;->q()V

    .line 163
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public h()V
    .locals 0

    .prologue
    .line 167
    invoke-direct {p0}, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter;->q()V

    .line 168
    return-void
.end method
