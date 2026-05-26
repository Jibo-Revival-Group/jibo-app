.class public Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter;
.super Ljava/lang/Object;
.source "CaseListPresenter.java"

# interfaces
.implements Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListContract$Presenter;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter$SetCaseHiddenHandler;,
        Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter$SetCaseReadHandler;,
        Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter$CaseListDataHandler;,
        Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter$CaseListLabelHandler;,
        Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter$CaseListComparator;
    }
.end annotation


# instance fields
.field a:Lcom/salesforce/android/cases/ui/internal/features/shared/PushNotificationBroadcastReceiver;

.field b:Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListContract$View;

.field c:Ljava/lang/ref/WeakReference;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/lang/ref/WeakReference",
            "<",
            "Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListContract$Presenter$Listener;",
            ">;"
        }
    .end annotation
.end field

.field d:Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter$CaseListDataHandler;

.field e:Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter$CaseListLabelHandler;

.field f:Z

.field g:Z

.field h:Lcom/salesforce/android/cases/ui/internal/features/caselist/viewmodel/CaseListViewModel;

.field private final i:Ljava/util/Comparator;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Comparator",
            "<",
            "Lcom/salesforce/android/cases/ui/internal/features/caselist/viewmodel/CaseListItemViewModel;",
            ">;"
        }
    .end annotation
.end field

.field private final j:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

.field private final k:Lcom/salesforce/android/cases/ui/CaseUIClient;


# direct methods
.method public constructor <init>(Lcom/salesforce/android/cases/ui/CaseUIClient;)V
    .locals 2

    .prologue
    .line 77
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 63
    new-instance v0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter$CaseListComparator;

    const/4 v1, 0x0

    invoke-direct {v0, v1}, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter$CaseListComparator;-><init>(Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter$1;)V

    iput-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter;->i:Ljava/util/Comparator;

    .line 64
    const-class v0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter;

    invoke-static {v0}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogging;->a(Ljava/lang/Class;)Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter;->j:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    .line 70
    new-instance v0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter$CaseListDataHandler;

    invoke-direct {v0, p0}, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter$CaseListDataHandler;-><init>(Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter;)V

    iput-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter;->d:Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter$CaseListDataHandler;

    .line 71
    new-instance v0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter$CaseListLabelHandler;

    invoke-direct {v0, p0}, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter$CaseListLabelHandler;-><init>(Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter;)V

    iput-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter;->e:Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter$CaseListLabelHandler;

    .line 78
    iput-object p1, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter;->k:Lcom/salesforce/android/cases/ui/CaseUIClient;

    .line 79
    new-instance v0, Lcom/salesforce/android/cases/ui/internal/features/caselist/NullCaseListContractView;

    invoke-direct {v0}, Lcom/salesforce/android/cases/ui/internal/features/caselist/NullCaseListContractView;-><init>()V

    iput-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter;->b:Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListContract$View;

    .line 80
    new-instance v0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter$1;

    invoke-direct {v0, p0}, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter$1;-><init>(Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter;)V

    iput-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter;->a:Lcom/salesforce/android/cases/ui/internal/features/shared/PushNotificationBroadcastReceiver;

    .line 85
    return-void
.end method

.method static synthetic a(Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter;)Lcom/salesforce/android/cases/ui/CaseUIClient;
    .locals 1

    .prologue
    .line 61
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter;->k:Lcom/salesforce/android/cases/ui/CaseUIClient;

    return-object v0
.end method

.method static synthetic a(Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter;Lcom/salesforce/android/cases/ui/internal/features/caselist/viewmodel/CaseListItemViewModel;)V
    .locals 0

    .prologue
    .line 61
    invoke-direct {p0, p1}, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter;->e(Lcom/salesforce/android/cases/ui/internal/features/caselist/viewmodel/CaseListItemViewModel;)V

    return-void
.end method

.method static synthetic a(Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter;Lcom/salesforce/android/cases/ui/internal/features/caselist/viewmodel/CaseListViewModel;)V
    .locals 0

    .prologue
    .line 61
    invoke-direct {p0, p1}, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter;->a(Lcom/salesforce/android/cases/ui/internal/features/caselist/viewmodel/CaseListViewModel;)V

    return-void
.end method

.method static synthetic a(Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 61
    invoke-direct {p0, p1}, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter;->a(Ljava/lang/String;)V

    return-void
.end method

.method private a(Lcom/salesforce/android/cases/ui/internal/features/caselist/viewmodel/CaseListViewModel;)V
    .locals 6

    .prologue
    .line 215
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter;->k:Lcom/salesforce/android/cases/ui/CaseUIClient;

    invoke-interface {v0}, Lcom/salesforce/android/cases/ui/CaseUIClient;->b()Ljava/lang/String;

    move-result-object v0

    iget-object v1, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter;->k:Lcom/salesforce/android/cases/ui/CaseUIClient;

    invoke-interface {v1}, Lcom/salesforce/android/cases/ui/CaseUIClient;->d()Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter;->k:Lcom/salesforce/android/cases/ui/CaseUIClient;

    .line 216
    invoke-interface {v2}, Lcom/salesforce/android/cases/ui/CaseUIClient;->c()Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter;->k:Lcom/salesforce/android/cases/ui/CaseUIClient;

    .line 217
    invoke-interface {v3}, Lcom/salesforce/android/cases/ui/CaseUIClient;->e()Z

    move-result v3

    if-eqz v3, :cond_0

    const-string v3, "authenticated"

    :goto_0
    const-string v4, "list_loaded"

    .line 218
    invoke-virtual {p1}, Lcom/salesforce/android/cases/ui/internal/features/caselist/viewmodel/CaseListViewModel;->a()Ljava/util/List;

    move-result-object v5

    invoke-interface {v5}, Ljava/util/List;->size()I

    move-result v5

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    .line 215
    invoke-static/range {v0 .. v5}, Lcom/salesforce/android/cases/ui/CasesUIAnalyticsEmit;->a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V

    .line 220
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter;->b:Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListContract$View;

    invoke-interface {v0}, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListContract$View;->c()V

    .line 222
    invoke-virtual {p1}, Lcom/salesforce/android/cases/ui/internal/features/caselist/viewmodel/CaseListViewModel;->a()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 223
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter;->b:Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListContract$View;

    invoke-interface {v0}, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListContract$View;->h()V

    .line 228
    :goto_1
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter;->b:Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListContract$View;

    invoke-interface {v0}, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListContract$View;->f()V

    .line 229
    return-void

    .line 217
    :cond_0
    const-string v3, "guest"

    goto :goto_0

    .line 225
    :cond_1
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter;->b:Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListContract$View;

    invoke-interface {v0}, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListContract$View;->i()V

    .line 226
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter;->b:Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListContract$View;

    invoke-interface {v0, p1}, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListContract$View;->a(Lcom/salesforce/android/cases/ui/internal/features/caselist/viewmodel/CaseListViewModel;)V

    goto :goto_1
.end method

.method private a(Ljava/lang/String;)V
    .locals 1

    .prologue
    .line 202
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter;->b:Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListContract$View;

    invoke-interface {v0, p1}, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListContract$View;->setTitle(Ljava/lang/String;)V

    .line 203
    return-void
.end method

.method static synthetic b(Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter;)V
    .locals 0

    .prologue
    .line 61
    invoke-direct {p0}, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter;->j()V

    return-void
.end method

.method static synthetic b(Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter;Lcom/salesforce/android/cases/ui/internal/features/caselist/viewmodel/CaseListItemViewModel;)V
    .locals 0

    .prologue
    .line 61
    invoke-direct {p0, p1}, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter;->f(Lcom/salesforce/android/cases/ui/internal/features/caselist/viewmodel/CaseListItemViewModel;)V

    return-void
.end method

.method static synthetic c(Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter;)V
    .locals 0

    .prologue
    .line 61
    invoke-direct {p0}, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter;->k()V

    return-void
.end method

.method static synthetic c(Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter;Lcom/salesforce/android/cases/ui/internal/features/caselist/viewmodel/CaseListItemViewModel;)V
    .locals 0

    .prologue
    .line 61
    invoke-direct {p0, p1}, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter;->g(Lcom/salesforce/android/cases/ui/internal/features/caselist/viewmodel/CaseListItemViewModel;)V

    return-void
.end method

.method static synthetic d(Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter;)V
    .locals 0

    .prologue
    .line 61
    invoke-direct {p0}, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter;->l()V

    return-void
.end method

.method private d(Lcom/salesforce/android/cases/ui/internal/features/caselist/viewmodel/CaseListItemViewModel;)V
    .locals 4

    .prologue
    .line 271
    invoke-virtual {p1}, Lcom/salesforce/android/cases/ui/internal/features/caselist/viewmodel/CaseListItemViewModel;->c()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/salesforce/android/cases/core/internal/util/StringUtils;->a(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 282
    :goto_0
    return-void

    .line 274
    :cond_0
    new-instance v1, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter$SetCaseReadHandler;

    invoke-direct {v1, p0, p1}, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter$SetCaseReadHandler;-><init>(Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter;Lcom/salesforce/android/cases/ui/internal/features/caselist/viewmodel/CaseListItemViewModel;)V

    .line 277
    invoke-virtual {p1}, Lcom/salesforce/android/cases/ui/internal/features/caselist/viewmodel/CaseListItemViewModel;->g()Ljava/util/Date;

    move-result-object v0

    if-nez v0, :cond_1

    new-instance v0, Ljava/util/Date;

    invoke-direct {v0}, Ljava/util/Date;-><init>()V

    .line 278
    :goto_1
    iget-object v2, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter;->k:Lcom/salesforce/android/cases/ui/CaseUIClient;

    invoke-interface {v2}, Lcom/salesforce/android/cases/ui/CaseUIClient;->a()Lcom/salesforce/android/cases/core/CaseClient;

    move-result-object v2

    .line 279
    invoke-virtual {p1}, Lcom/salesforce/android/cases/ui/internal/features/caselist/viewmodel/CaseListItemViewModel;->c()Ljava/lang/String;

    move-result-object v3

    invoke-static {v3, v0}, Lcom/salesforce/android/cases/core/requests/SetCaseLastReadDateRequest;->a(Ljava/lang/String;Ljava/util/Date;)Lcom/salesforce/android/cases/core/requests/SetCaseLastReadDateRequest;

    move-result-object v0

    invoke-interface {v2, v0}, Lcom/salesforce/android/cases/core/CaseClient;->a(Lcom/salesforce/android/cases/core/requests/SetCaseLastReadDateRequest;)Lcom/salesforce/android/service/common/utilities/control/Async;

    move-result-object v0

    .line 280
    invoke-interface {v0, v1}, Lcom/salesforce/android/service/common/utilities/control/Async;->a(Lcom/salesforce/android/service/common/utilities/control/Async$CompletionHandler;)Lcom/salesforce/android/service/common/utilities/control/Async;

    move-result-object v0

    .line 281
    invoke-interface {v0, v1}, Lcom/salesforce/android/service/common/utilities/control/Async;->a(Lcom/salesforce/android/service/common/utilities/control/Async$ErrorHandler;)Lcom/salesforce/android/service/common/utilities/control/Async;

    goto :goto_0

    .line 277
    :cond_1
    invoke-virtual {p1}, Lcom/salesforce/android/cases/ui/internal/features/caselist/viewmodel/CaseListItemViewModel;->g()Ljava/util/Date;

    move-result-object v0

    goto :goto_1
.end method

.method static synthetic e(Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter;)V
    .locals 0

    .prologue
    .line 61
    invoke-direct {p0}, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter;->m()V

    return-void
.end method

.method private e(Lcom/salesforce/android/cases/ui/internal/features/caselist/viewmodel/CaseListItemViewModel;)V
    .locals 1

    .prologue
    .line 285
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter;->b:Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListContract$View;

    invoke-interface {v0, p1}, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListContract$View;->a(Lcom/salesforce/android/cases/ui/internal/features/caselist/viewmodel/CaseListItemViewModel;)V

    .line 286
    return-void
.end method

.method static synthetic f(Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter;)Ljava/util/Comparator;
    .locals 1

    .prologue
    .line 61
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter;->i:Ljava/util/Comparator;

    return-object v0
.end method

.method private f(Lcom/salesforce/android/cases/ui/internal/features/caselist/viewmodel/CaseListItemViewModel;)V
    .locals 1

    .prologue
    .line 289
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter;->h:Lcom/salesforce/android/cases/ui/internal/features/caselist/viewmodel/CaseListViewModel;

    invoke-virtual {v0}, Lcom/salesforce/android/cases/ui/internal/features/caselist/viewmodel/CaseListViewModel;->a()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0, p1}, Ljava/util/List;->remove(Ljava/lang/Object;)Z

    .line 290
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter;->b:Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListContract$View;

    invoke-interface {v0, p1}, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListContract$View;->b(Lcom/salesforce/android/cases/ui/internal/features/caselist/viewmodel/CaseListItemViewModel;)V

    .line 291
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter;->b:Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListContract$View;

    invoke-interface {v0, p1}, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListContract$View;->c(Lcom/salesforce/android/cases/ui/internal/features/caselist/viewmodel/CaseListItemViewModel;)V

    .line 294
    invoke-direct {p0, p1}, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter;->d(Lcom/salesforce/android/cases/ui/internal/features/caselist/viewmodel/CaseListItemViewModel;)V

    .line 295
    return-void
.end method

.method static synthetic g(Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter;)Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;
    .locals 1

    .prologue
    .line 61
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter;->j:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    return-object v0
.end method

.method private g(Lcom/salesforce/android/cases/ui/internal/features/caselist/viewmodel/CaseListItemViewModel;)V
    .locals 2

    .prologue
    .line 298
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter;->h:Lcom/salesforce/android/cases/ui/internal/features/caselist/viewmodel/CaseListViewModel;

    invoke-virtual {v0}, Lcom/salesforce/android/cases/ui/internal/features/caselist/viewmodel/CaseListViewModel;->a()Ljava/util/List;

    move-result-object v0

    .line 299
    invoke-interface {v0, p1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 300
    iget-object v1, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter;->i:Ljava/util/Comparator;

    invoke-static {v0, v1}, Ljava/util/Collections;->sort(Ljava/util/List;Ljava/util/Comparator;)V

    .line 301
    invoke-interface {v0, p1}, Ljava/util/List;->indexOf(Ljava/lang/Object;)I

    move-result v0

    .line 302
    if-ltz v0, :cond_0

    .line 303
    iget-object v1, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter;->b:Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListContract$View;

    invoke-interface {v1, p1, v0}, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListContract$View;->a(Lcom/salesforce/android/cases/ui/internal/features/caselist/viewmodel/CaseListItemViewModel;I)V

    .line 305
    :cond_0
    return-void
.end method

.method private j()V
    .locals 1

    .prologue
    .line 206
    iget-boolean v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter;->f:Z

    if-eqz v0, :cond_0

    .line 207
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter;->b:Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListContract$View;

    invoke-interface {v0}, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListContract$View;->m_()V

    .line 212
    :goto_0
    return-void

    .line 209
    :cond_0
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter;->b:Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListContract$View;

    invoke-interface {v0}, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListContract$View;->l_()V

    .line 210
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter;->b:Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListContract$View;

    invoke-interface {v0}, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListContract$View;->g()V

    goto :goto_0
.end method

.method private k()V
    .locals 1

    .prologue
    .line 232
    iget-boolean v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter;->f:Z

    if-eqz v0, :cond_0

    .line 233
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter;->b:Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListContract$View;

    invoke-interface {v0}, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListContract$View;->m()V

    .line 237
    :goto_0
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter;->b:Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListContract$View;

    invoke-interface {v0}, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListContract$View;->f()V

    .line 238
    invoke-direct {p0}, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter;->m()V

    .line 239
    return-void

    .line 235
    :cond_0
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter;->b:Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListContract$View;

    invoke-interface {v0}, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListContract$View;->l()V

    goto :goto_0
.end method

.method private l()V
    .locals 1

    .prologue
    .line 242
    iget-boolean v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter;->f:Z

    if-eqz v0, :cond_0

    .line 243
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter;->b:Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListContract$View;

    invoke-interface {v0}, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListContract$View;->k()V

    .line 247
    :goto_0
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter;->b:Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListContract$View;

    invoke-interface {v0}, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListContract$View;->f()V

    .line 248
    invoke-direct {p0}, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter;->m()V

    .line 249
    return-void

    .line 245
    :cond_0
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter;->b:Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListContract$View;

    invoke-interface {v0}, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListContract$View;->j()V

    goto :goto_0
.end method

.method private m()V
    .locals 1

    .prologue
    .line 252
    iget-boolean v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter;->f:Z

    if-eqz v0, :cond_0

    .line 253
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter;->b:Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListContract$View;

    invoke-interface {v0}, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListContract$View;->e()V

    .line 254
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter;->f:Z

    .line 258
    :goto_0
    return-void

    .line 256
    :cond_0
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter;->b:Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListContract$View;

    invoke-interface {v0}, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListContract$View;->c()V

    goto :goto_0
.end method

.method private n()V
    .locals 6

    .prologue
    .line 261
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter;->c:Ljava/lang/ref/WeakReference;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter;->c:Ljava/lang/ref/WeakReference;

    invoke-virtual {v0}, Ljava/lang/ref/WeakReference;->get()Ljava/lang/Object;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 262
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter;->k:Lcom/salesforce/android/cases/ui/CaseUIClient;

    invoke-interface {v0}, Lcom/salesforce/android/cases/ui/CaseUIClient;->b()Ljava/lang/String;

    move-result-object v0

    iget-object v1, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter;->k:Lcom/salesforce/android/cases/ui/CaseUIClient;

    invoke-interface {v1}, Lcom/salesforce/android/cases/ui/CaseUIClient;->d()Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter;->k:Lcom/salesforce/android/cases/ui/CaseUIClient;

    .line 263
    invoke-interface {v2}, Lcom/salesforce/android/cases/ui/CaseUIClient;->c()Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter;->k:Lcom/salesforce/android/cases/ui/CaseUIClient;

    .line 264
    invoke-interface {v3}, Lcom/salesforce/android/cases/ui/CaseUIClient;->e()Z

    move-result v3

    if-eqz v3, :cond_1

    const-string v3, "authenticated"

    :goto_0
    const-string v4, "list_dismissed"

    const/4 v5, 0x0

    .line 262
    invoke-static/range {v0 .. v5}, Lcom/salesforce/android/cases/ui/CasesUIAnalyticsEmit;->a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V

    .line 266
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter;->c:Ljava/lang/ref/WeakReference;

    invoke-virtual {v0}, Ljava/lang/ref/WeakReference;->get()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListContract$Presenter$Listener;

    invoke-interface {v0}, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListContract$Presenter$Listener;->d()V

    .line 268
    :cond_0
    return-void

    .line 264
    :cond_1
    const-string v3, "guest"

    goto :goto_0
.end method


# virtual methods
.method public a()V
    .locals 2

    .prologue
    .line 123
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter;->b:Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListContract$View;

    invoke-interface {v0}, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListContract$View;->getContext()Landroid/content/Context;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 124
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter;->k:Lcom/salesforce/android/cases/ui/CaseUIClient;

    iget-object v1, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter;->b:Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListContract$View;

    invoke-interface {v1}, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListContract$View;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-interface {v0, v1}, Lcom/salesforce/android/cases/ui/CaseUIClient;->b(Landroid/content/Context;)V

    .line 126
    :cond_0
    return-void
.end method

.method public a(Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListContract$Presenter$Listener;)V
    .locals 1

    .prologue
    .line 181
    new-instance v0, Ljava/lang/ref/WeakReference;

    invoke-direct {v0, p1}, Ljava/lang/ref/WeakReference;-><init>(Ljava/lang/Object;)V

    iput-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter;->c:Ljava/lang/ref/WeakReference;

    .line 182
    return-void
.end method

.method public a(Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListContract$View;)V
    .locals 6

    .prologue
    .line 90
    invoke-interface {p1, p0}, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListContract$View;->setPresenter(Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListContract$Presenter;)V

    .line 91
    iput-object p1, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter;->b:Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListContract$View;

    .line 92
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter;->d:Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter$CaseListDataHandler;

    invoke-virtual {v0}, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter$CaseListDataHandler;->d()V

    .line 93
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter;->e:Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter$CaseListLabelHandler;

    invoke-virtual {v0}, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter$CaseListLabelHandler;->d()V

    .line 94
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter;->g:Z

    .line 95
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter;->a:Lcom/salesforce/android/cases/ui/internal/features/shared/PushNotificationBroadcastReceiver;

    invoke-interface {p1}, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListContract$View;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/salesforce/android/cases/ui/internal/features/shared/PushNotificationBroadcastReceiver;->a(Landroid/content/Context;)V

    .line 97
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter;->k:Lcom/salesforce/android/cases/ui/CaseUIClient;

    invoke-interface {v0}, Lcom/salesforce/android/cases/ui/CaseUIClient;->b()Ljava/lang/String;

    move-result-object v0

    iget-object v1, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter;->k:Lcom/salesforce/android/cases/ui/CaseUIClient;

    invoke-interface {v1}, Lcom/salesforce/android/cases/ui/CaseUIClient;->d()Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter;->k:Lcom/salesforce/android/cases/ui/CaseUIClient;

    .line 98
    invoke-interface {v2}, Lcom/salesforce/android/cases/ui/CaseUIClient;->c()Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter;->k:Lcom/salesforce/android/cases/ui/CaseUIClient;

    .line 99
    invoke-interface {v3}, Lcom/salesforce/android/cases/ui/CaseUIClient;->e()Z

    move-result v3

    if-eqz v3, :cond_0

    const-string v3, "authenticated"

    :goto_0
    const-string v4, "list_launched"

    const/4 v5, 0x0

    .line 97
    invoke-static/range {v0 .. v5}, Lcom/salesforce/android/cases/ui/CasesUIAnalyticsEmit;->a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V

    .line 101
    return-void

    .line 99
    :cond_0
    const-string v3, "guest"

    goto :goto_0
.end method

.method public a(Lcom/salesforce/android/cases/ui/internal/features/caselist/viewmodel/CaseListItemViewModel;)V
    .locals 3

    .prologue
    .line 141
    invoke-virtual {p1}, Lcom/salesforce/android/cases/ui/internal/features/caselist/viewmodel/CaseListItemViewModel;->c()Ljava/lang/String;

    move-result-object v0

    .line 142
    invoke-static {v0}, Lcom/salesforce/android/cases/core/internal/util/StringUtils;->a(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 143
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter;->j:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    const-string v1, "Case list item without case id was clicked."

    invoke-interface {v0, v1}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;->d(Ljava/lang/String;)V

    .line 150
    :cond_0
    :goto_0
    return-void

    .line 146
    :cond_1
    invoke-direct {p0, p1}, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter;->d(Lcom/salesforce/android/cases/ui/internal/features/caselist/viewmodel/CaseListItemViewModel;)V

    .line 147
    iget-object v1, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter;->b:Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListContract$View;

    invoke-interface {v1}, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListContract$View;->getContext()Landroid/content/Context;

    move-result-object v1

    if-eqz v1, :cond_0

    .line 148
    iget-object v1, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter;->k:Lcom/salesforce/android/cases/ui/CaseUIClient;

    iget-object v2, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter;->b:Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListContract$View;

    invoke-interface {v2}, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListContract$View;->getContext()Landroid/content/Context;

    move-result-object v2

    invoke-interface {v1, v2, v0}, Lcom/salesforce/android/cases/ui/CaseUIClient;->a(Landroid/content/Context;Ljava/lang/String;)V

    goto :goto_0
.end method

.method public bridge synthetic a(Lcom/salesforce/android/cases/ui/internal/features/shared/BaseView;)V
    .locals 0

    .prologue
    .line 61
    check-cast p1, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListContract$View;

    invoke-virtual {p0, p1}, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter;->a(Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListContract$View;)V

    return-void
.end method

.method public bridge synthetic a(Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 61
    check-cast p1, Ljava/lang/Void;

    invoke-virtual {p0, p1}, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter;->a(Ljava/lang/Void;)V

    return-void
.end method

.method public a(Ljava/lang/Void;)V
    .locals 0

    .prologue
    .line 87
    return-void
.end method

.method public b()V
    .locals 0

    .prologue
    .line 129
    invoke-direct {p0}, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter;->n()V

    .line 130
    return-void
.end method

.method public b(Lcom/salesforce/android/cases/ui/internal/features/caselist/viewmodel/CaseListItemViewModel;)V
    .locals 4

    .prologue
    const/4 v3, 0x1

    .line 153
    invoke-virtual {p1}, Lcom/salesforce/android/cases/ui/internal/features/caselist/viewmodel/CaseListItemViewModel;->c()Ljava/lang/String;

    move-result-object v0

    .line 154
    invoke-static {v0}, Lcom/salesforce/android/cases/core/internal/util/StringUtils;->a(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 155
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter;->j:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    const-string v1, "Case list item without case id was swiped."

    invoke-interface {v0, v1}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;->d(Ljava/lang/String;)V

    .line 163
    :goto_0
    return-void

    .line 158
    :cond_0
    new-instance v1, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter$SetCaseHiddenHandler;

    invoke-direct {v1, p0, p1, v3}, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter$SetCaseHiddenHandler;-><init>(Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter;Lcom/salesforce/android/cases/ui/internal/features/caselist/viewmodel/CaseListItemViewModel;Z)V

    .line 159
    iget-object v2, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter;->k:Lcom/salesforce/android/cases/ui/CaseUIClient;

    invoke-interface {v2}, Lcom/salesforce/android/cases/ui/CaseUIClient;->a()Lcom/salesforce/android/cases/core/CaseClient;

    move-result-object v2

    .line 160
    invoke-static {v0, v3}, Lcom/salesforce/android/cases/core/requests/SetCaseHiddenRequest;->a(Ljava/lang/String;Z)Lcom/salesforce/android/cases/core/requests/SetCaseHiddenRequest;

    move-result-object v0

    invoke-interface {v2, v0}, Lcom/salesforce/android/cases/core/CaseClient;->a(Lcom/salesforce/android/cases/core/requests/SetCaseHiddenRequest;)Lcom/salesforce/android/service/common/utilities/control/Async;

    move-result-object v0

    .line 161
    invoke-interface {v0, v1}, Lcom/salesforce/android/service/common/utilities/control/Async;->a(Lcom/salesforce/android/service/common/utilities/control/Async$CompletionHandler;)Lcom/salesforce/android/service/common/utilities/control/Async;

    move-result-object v0

    .line 162
    invoke-interface {v0, v1}, Lcom/salesforce/android/service/common/utilities/control/Async;->a(Lcom/salesforce/android/service/common/utilities/control/Async$ErrorHandler;)Lcom/salesforce/android/service/common/utilities/control/Async;

    goto :goto_0
.end method

.method public c()V
    .locals 0

    .prologue
    .line 133
    invoke-virtual {p0}, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter;->h()V

    .line 134
    return-void
.end method

.method public c(Lcom/salesforce/android/cases/ui/internal/features/caselist/viewmodel/CaseListItemViewModel;)V
    .locals 4

    .prologue
    const/4 v3, 0x0

    .line 166
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter;->h:Lcom/salesforce/android/cases/ui/internal/features/caselist/viewmodel/CaseListViewModel;

    if-eqz v0, :cond_0

    .line 167
    invoke-virtual {p1}, Lcom/salesforce/android/cases/ui/internal/features/caselist/viewmodel/CaseListItemViewModel;->c()Ljava/lang/String;

    move-result-object v0

    .line 168
    invoke-static {v0}, Lcom/salesforce/android/cases/core/internal/util/StringUtils;->a(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 169
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter;->j:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    const-string v1, "Case list item without case id was unhidden."

    invoke-interface {v0, v1}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;->d(Ljava/lang/String;)V

    .line 178
    :cond_0
    :goto_0
    return-void

    .line 172
    :cond_1
    new-instance v1, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter$SetCaseHiddenHandler;

    invoke-direct {v1, p0, p1, v3}, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter$SetCaseHiddenHandler;-><init>(Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter;Lcom/salesforce/android/cases/ui/internal/features/caselist/viewmodel/CaseListItemViewModel;Z)V

    .line 173
    iget-object v2, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter;->k:Lcom/salesforce/android/cases/ui/CaseUIClient;

    invoke-interface {v2}, Lcom/salesforce/android/cases/ui/CaseUIClient;->a()Lcom/salesforce/android/cases/core/CaseClient;

    move-result-object v2

    .line 174
    invoke-static {v0, v3}, Lcom/salesforce/android/cases/core/requests/SetCaseHiddenRequest;->a(Ljava/lang/String;Z)Lcom/salesforce/android/cases/core/requests/SetCaseHiddenRequest;

    move-result-object v0

    invoke-interface {v2, v0}, Lcom/salesforce/android/cases/core/CaseClient;->a(Lcom/salesforce/android/cases/core/requests/SetCaseHiddenRequest;)Lcom/salesforce/android/service/common/utilities/control/Async;

    move-result-object v0

    .line 175
    invoke-interface {v0, v1}, Lcom/salesforce/android/service/common/utilities/control/Async;->a(Lcom/salesforce/android/service/common/utilities/control/Async$CompletionHandler;)Lcom/salesforce/android/service/common/utilities/control/Async;

    move-result-object v0

    .line 176
    invoke-interface {v0, v1}, Lcom/salesforce/android/service/common/utilities/control/Async;->a(Lcom/salesforce/android/service/common/utilities/control/Async$ErrorHandler;)Lcom/salesforce/android/service/common/utilities/control/Async;

    goto :goto_0
.end method

.method public d()V
    .locals 1

    .prologue
    .line 112
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter;->g:Z

    .line 113
    return-void
.end method

.method public e()V
    .locals 2

    .prologue
    .line 116
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter;->a:Lcom/salesforce/android/cases/ui/internal/features/shared/PushNotificationBroadcastReceiver;

    iget-object v1, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter;->b:Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListContract$View;

    invoke-interface {v1}, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListContract$View;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/salesforce/android/cases/ui/internal/features/shared/PushNotificationBroadcastReceiver;->b(Landroid/content/Context;)V

    .line 117
    new-instance v0, Lcom/salesforce/android/cases/ui/internal/features/caselist/NullCaseListContractView;

    invoke-direct {v0}, Lcom/salesforce/android/cases/ui/internal/features/caselist/NullCaseListContractView;-><init>()V

    iput-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter;->b:Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListContract$View;

    .line 118
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter;->d:Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter$CaseListDataHandler;

    invoke-virtual {v0}, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter$CaseListDataHandler;->e()V

    .line 119
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter;->e:Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter$CaseListLabelHandler;

    invoke-virtual {v0}, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter$CaseListLabelHandler;->e()V

    .line 120
    return-void
.end method

.method public f()V
    .locals 0

    .prologue
    .line 137
    invoke-virtual {p0}, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter;->h()V

    .line 138
    return-void
.end method

.method public g()V
    .locals 1

    .prologue
    .line 185
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter;->c:Ljava/lang/ref/WeakReference;

    if-eqz v0, :cond_0

    .line 186
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter;->c:Ljava/lang/ref/WeakReference;

    invoke-virtual {v0}, Ljava/lang/ref/WeakReference;->clear()V

    .line 187
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter;->c:Ljava/lang/ref/WeakReference;

    .line 189
    :cond_0
    return-void
.end method

.method public h()V
    .locals 1

    .prologue
    .line 194
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter;->d:Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter$CaseListDataHandler;

    invoke-virtual {v0}, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter$CaseListDataHandler;->h()Z

    move-result v0

    if-nez v0, :cond_0

    .line 195
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter;->f:Z

    .line 196
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter;->d:Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter$CaseListDataHandler;

    invoke-virtual {v0}, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter$CaseListDataHandler;->e()V

    .line 197
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter;->d:Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter$CaseListDataHandler;

    invoke-virtual {v0}, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter$CaseListDataHandler;->d()V

    .line 199
    :cond_0
    return-void
.end method

.method public i()V
    .locals 1

    .prologue
    .line 104
    iget-boolean v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter;->g:Z

    if-eqz v0, :cond_0

    .line 105
    invoke-virtual {p0}, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter;->h()V

    .line 107
    :cond_0
    return-void
.end method
