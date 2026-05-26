.class public Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter;
.super Ljava/lang/Object;
.source "CaseFeedPresenter.java"

# interfaces
.implements Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedContract$Presenter;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter$SetCaseReadHandler;,
        Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter$GetCaseFeedHandler;,
        Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter$PostCommentError;,
        Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter$PostCommentResult;,
        Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter$MapCaseFeedViewModelFunction;
    }
.end annotation


# instance fields
.field final a:Lcom/salesforce/android/cases/ui/internal/features/shared/PushNotificationBroadcastReceiver;

.field b:Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter$GetCaseFeedHandler;

.field c:Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedContract$View;

.field d:Ljava/lang/ref/WeakReference;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/lang/ref/WeakReference",
            "<",
            "Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedContract$Presenter$Listener;",
            ">;"
        }
    .end annotation
.end field

.field e:Lcom/salesforce/android/cases/ui/internal/features/casefeed/viewmodel/CaseFeedViewModel;

.field f:Z

.field g:Ljava/lang/String;

.field private final h:Lcom/salesforce/android/cases/ui/CaseUIClient;

.field private final i:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;


# direct methods
.method constructor <init>(Lcom/salesforce/android/cases/ui/CaseUIClient;)V
    .locals 1

    .prologue
    .line 69
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 61
    new-instance v0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter$GetCaseFeedHandler;

    invoke-direct {v0, p0}, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter$GetCaseFeedHandler;-><init>(Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter;)V

    iput-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter;->b:Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter$GetCaseFeedHandler;

    .line 67
    const-class v0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter;

    invoke-static {v0}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogging;->a(Ljava/lang/Class;)Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter;->i:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    .line 70
    iput-object p1, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter;->h:Lcom/salesforce/android/cases/ui/CaseUIClient;

    .line 71
    new-instance v0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/NullCaseFeedView;

    invoke-direct {v0}, Lcom/salesforce/android/cases/ui/internal/features/casefeed/NullCaseFeedView;-><init>()V

    iput-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter;->c:Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedContract$View;

    .line 72
    new-instance v0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter$1;

    invoke-direct {v0, p0}, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter$1;-><init>(Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter;)V

    iput-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter;->a:Lcom/salesforce/android/cases/ui/internal/features/shared/PushNotificationBroadcastReceiver;

    .line 79
    return-void
.end method

.method static synthetic a(Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter;)V
    .locals 0

    .prologue
    .line 57
    invoke-direct {p0}, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter;->l()V

    return-void
.end method

.method static synthetic a(Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter;Lcom/salesforce/android/cases/ui/internal/features/casefeed/viewmodel/CaseFeedViewModel;)V
    .locals 0

    .prologue
    .line 57
    invoke-direct {p0, p1}, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter;->a(Lcom/salesforce/android/cases/ui/internal/features/casefeed/viewmodel/CaseFeedViewModel;)V

    return-void
.end method

.method private a(Lcom/salesforce/android/cases/ui/internal/features/casefeed/viewmodel/CaseFeedViewModel;)V
    .locals 6

    .prologue
    .line 165
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter;->h:Lcom/salesforce/android/cases/ui/CaseUIClient;

    invoke-interface {v0}, Lcom/salesforce/android/cases/ui/CaseUIClient;->b()Ljava/lang/String;

    move-result-object v0

    iget-object v1, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter;->h:Lcom/salesforce/android/cases/ui/CaseUIClient;

    invoke-interface {v1}, Lcom/salesforce/android/cases/ui/CaseUIClient;->d()Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter;->h:Lcom/salesforce/android/cases/ui/CaseUIClient;

    .line 166
    invoke-interface {v2}, Lcom/salesforce/android/cases/ui/CaseUIClient;->c()Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter;->h:Lcom/salesforce/android/cases/ui/CaseUIClient;

    .line 167
    invoke-interface {v3}, Lcom/salesforce/android/cases/ui/CaseUIClient;->e()Z

    move-result v3

    if-eqz v3, :cond_2

    const-string v3, "authenticated"

    :goto_0
    const-string v4, "detail_loaded"

    iget-object v5, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter;->g:Ljava/lang/String;

    .line 165
    invoke-static/range {v0 .. v5}, Lcom/salesforce/android/cases/ui/CasesUIAnalyticsEmit;->c(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 170
    invoke-virtual {p1}, Lcom/salesforce/android/cases/ui/internal/features/casefeed/viewmodel/CaseFeedViewModel;->b()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 171
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter;->c:Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedContract$View;

    invoke-virtual {p1}, Lcom/salesforce/android/cases/ui/internal/features/casefeed/viewmodel/CaseFeedViewModel;->b()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedContract$View;->setTitle(Ljava/lang/String;)V

    .line 174
    :cond_0
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter;->c:Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedContract$View;

    invoke-interface {v0}, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedContract$View;->i_()V

    .line 175
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter;->c:Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedContract$View;

    invoke-interface {v0}, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedContract$View;->e()V

    .line 176
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter;->c:Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedContract$View;

    invoke-interface {v0}, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedContract$View;->f()V

    .line 177
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter;->c:Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedContract$View;

    invoke-interface {v0}, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedContract$View;->j_()V

    .line 178
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter;->c:Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedContract$View;

    invoke-virtual {p1}, Lcom/salesforce/android/cases/ui/internal/features/casefeed/viewmodel/CaseFeedViewModel;->a()Ljava/util/List;

    move-result-object v1

    invoke-interface {v0, v1}, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedContract$View;->a(Ljava/util/List;)V

    .line 180
    iget-boolean v0, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter;->f:Z

    if-eqz v0, :cond_1

    .line 181
    invoke-direct {p0}, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter;->k()V

    .line 185
    new-instance v0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter$SetCaseReadHandler;

    iget-object v1, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter;->g:Ljava/lang/String;

    invoke-direct {v0, p0, v1}, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter$SetCaseReadHandler;-><init>(Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter;Ljava/lang/String;)V

    .line 186
    iget-object v1, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter;->h:Lcom/salesforce/android/cases/ui/CaseUIClient;

    invoke-interface {v1}, Lcom/salesforce/android/cases/ui/CaseUIClient;->a()Lcom/salesforce/android/cases/core/CaseClient;

    move-result-object v1

    iget-object v2, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter;->g:Ljava/lang/String;

    .line 188
    invoke-virtual {p1}, Lcom/salesforce/android/cases/ui/internal/features/casefeed/viewmodel/CaseFeedViewModel;->c()Ljava/util/Date;

    move-result-object v3

    invoke-static {v2, v3}, Lcom/salesforce/android/cases/core/requests/SetCaseLastReadDateRequest;->a(Ljava/lang/String;Ljava/util/Date;)Lcom/salesforce/android/cases/core/requests/SetCaseLastReadDateRequest;

    move-result-object v2

    .line 187
    invoke-interface {v1, v2}, Lcom/salesforce/android/cases/core/CaseClient;->a(Lcom/salesforce/android/cases/core/requests/SetCaseLastReadDateRequest;)Lcom/salesforce/android/service/common/utilities/control/Async;

    move-result-object v1

    .line 189
    invoke-interface {v1, v0}, Lcom/salesforce/android/service/common/utilities/control/Async;->a(Lcom/salesforce/android/service/common/utilities/control/Async$CompletionHandler;)Lcom/salesforce/android/service/common/utilities/control/Async;

    move-result-object v1

    .line 190
    invoke-interface {v1, v0}, Lcom/salesforce/android/service/common/utilities/control/Async;->a(Lcom/salesforce/android/service/common/utilities/control/Async$ErrorHandler;)Lcom/salesforce/android/service/common/utilities/control/Async;

    .line 192
    :cond_1
    return-void

    .line 167
    :cond_2
    const-string v3, "guest"

    goto :goto_0
.end method

.method static synthetic b(Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter;)Lcom/salesforce/android/cases/ui/CaseUIClient;
    .locals 1

    .prologue
    .line 57
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter;->h:Lcom/salesforce/android/cases/ui/CaseUIClient;

    return-object v0
.end method

.method static synthetic c(Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter;)V
    .locals 0

    .prologue
    .line 57
    invoke-direct {p0}, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter;->h()V

    return-void
.end method

.method static synthetic d(Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter;)V
    .locals 0

    .prologue
    .line 57
    invoke-direct {p0}, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter;->j()V

    return-void
.end method

.method static synthetic e(Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter;)V
    .locals 0

    .prologue
    .line 57
    invoke-direct {p0}, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter;->i()V

    return-void
.end method

.method static synthetic f(Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter;)Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;
    .locals 1

    .prologue
    .line 57
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter;->i:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    return-object v0
.end method

.method private g()V
    .locals 6

    .prologue
    .line 151
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter;->d:Ljava/lang/ref/WeakReference;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter;->d:Ljava/lang/ref/WeakReference;

    invoke-virtual {v0}, Ljava/lang/ref/WeakReference;->get()Ljava/lang/Object;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 152
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter;->h:Lcom/salesforce/android/cases/ui/CaseUIClient;

    invoke-interface {v0}, Lcom/salesforce/android/cases/ui/CaseUIClient;->b()Ljava/lang/String;

    move-result-object v0

    iget-object v1, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter;->h:Lcom/salesforce/android/cases/ui/CaseUIClient;

    .line 153
    invoke-interface {v1}, Lcom/salesforce/android/cases/ui/CaseUIClient;->d()Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter;->h:Lcom/salesforce/android/cases/ui/CaseUIClient;

    invoke-interface {v2}, Lcom/salesforce/android/cases/ui/CaseUIClient;->c()Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter;->h:Lcom/salesforce/android/cases/ui/CaseUIClient;

    .line 154
    invoke-interface {v3}, Lcom/salesforce/android/cases/ui/CaseUIClient;->e()Z

    move-result v3

    if-eqz v3, :cond_1

    const-string v3, "authenticated"

    :goto_0
    const-string v4, "detail_dismissed"

    iget-object v5, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter;->g:Ljava/lang/String;

    .line 152
    invoke-static/range {v0 .. v5}, Lcom/salesforce/android/cases/ui/CasesUIAnalyticsEmit;->c(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 156
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter;->d:Ljava/lang/ref/WeakReference;

    invoke-virtual {v0}, Ljava/lang/ref/WeakReference;->get()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedContract$Presenter$Listener;

    invoke-interface {v0}, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedContract$Presenter$Listener;->b()V

    .line 158
    :cond_0
    return-void

    .line 154
    :cond_1
    const-string v3, "guest"

    goto :goto_0
.end method

.method private h()V
    .locals 1

    .prologue
    .line 161
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter;->c:Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedContract$View;

    invoke-interface {v0}, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedContract$View;->h_()V

    .line 162
    return-void
.end method

.method private i()V
    .locals 1

    .prologue
    .line 195
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter;->c:Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedContract$View;

    invoke-interface {v0}, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedContract$View;->i_()V

    .line 196
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter;->c:Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedContract$View;

    invoke-interface {v0}, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedContract$View;->k_()V

    .line 197
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter;->c:Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedContract$View;

    invoke-interface {v0}, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedContract$View;->f()V

    .line 198
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter;->c:Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedContract$View;

    invoke-interface {v0}, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedContract$View;->g()V

    .line 199
    iget-boolean v0, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter;->f:Z

    if-eqz v0, :cond_0

    .line 200
    invoke-direct {p0}, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter;->k()V

    .line 202
    :cond_0
    return-void
.end method

.method private j()V
    .locals 1

    .prologue
    .line 205
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter;->c:Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedContract$View;

    invoke-interface {v0}, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedContract$View;->i_()V

    .line 206
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter;->c:Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedContract$View;

    invoke-interface {v0}, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedContract$View;->k_()V

    .line 207
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter;->c:Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedContract$View;

    invoke-interface {v0}, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedContract$View;->e()V

    .line 208
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter;->c:Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedContract$View;

    invoke-interface {v0}, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedContract$View;->h()V

    .line 209
    iget-boolean v0, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter;->f:Z

    if-eqz v0, :cond_0

    .line 210
    invoke-direct {p0}, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter;->k()V

    .line 212
    :cond_0
    return-void
.end method

.method private k()V
    .locals 1

    .prologue
    .line 215
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter;->c:Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedContract$View;

    invoke-interface {v0}, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedContract$View;->i()V

    .line 216
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter;->f:Z

    .line 217
    return-void
.end method

.method private l()V
    .locals 6

    .prologue
    .line 220
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter;->h:Lcom/salesforce/android/cases/ui/CaseUIClient;

    invoke-interface {v0}, Lcom/salesforce/android/cases/ui/CaseUIClient;->b()Ljava/lang/String;

    move-result-object v0

    iget-object v1, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter;->h:Lcom/salesforce/android/cases/ui/CaseUIClient;

    .line 221
    invoke-interface {v1}, Lcom/salesforce/android/cases/ui/CaseUIClient;->d()Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter;->h:Lcom/salesforce/android/cases/ui/CaseUIClient;

    invoke-interface {v2}, Lcom/salesforce/android/cases/ui/CaseUIClient;->c()Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter;->h:Lcom/salesforce/android/cases/ui/CaseUIClient;

    .line 222
    invoke-interface {v3}, Lcom/salesforce/android/cases/ui/CaseUIClient;->e()Z

    move-result v3

    if-eqz v3, :cond_0

    const-string v3, "authenticated"

    :goto_0
    const-string v4, "customer"

    iget-object v5, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter;->g:Ljava/lang/String;

    .line 220
    invoke-static/range {v0 .. v5}, Lcom/salesforce/android/cases/ui/CasesUIAnalyticsEmit;->a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 224
    return-void

    .line 222
    :cond_0
    const-string v3, "guest"

    goto :goto_0
.end method


# virtual methods
.method public a()V
    .locals 1

    .prologue
    .line 107
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter;->c:Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedContract$View;

    invoke-interface {v0}, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedContract$View;->o()V

    .line 108
    invoke-direct {p0}, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter;->g()V

    .line 109
    return-void
.end method

.method public a(Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedContract$Presenter$Listener;)V
    .locals 1

    .prologue
    .line 112
    new-instance v0, Ljava/lang/ref/WeakReference;

    invoke-direct {v0, p1}, Ljava/lang/ref/WeakReference;-><init>(Ljava/lang/Object;)V

    iput-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter;->d:Ljava/lang/ref/WeakReference;

    .line 113
    return-void
.end method

.method public a(Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedContract$View;)V
    .locals 6

    .prologue
    .line 87
    invoke-interface {p1, p0}, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedContract$View;->setPresenter(Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedContract$Presenter;)V

    .line 88
    iput-object p1, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter;->c:Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedContract$View;

    .line 89
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter;->a:Lcom/salesforce/android/cases/ui/internal/features/shared/PushNotificationBroadcastReceiver;

    invoke-interface {p1}, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedContract$View;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/salesforce/android/cases/ui/internal/features/shared/PushNotificationBroadcastReceiver;->a(Landroid/content/Context;)V

    .line 90
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter;->h:Lcom/salesforce/android/cases/ui/CaseUIClient;

    invoke-interface {v0}, Lcom/salesforce/android/cases/ui/CaseUIClient;->b()Ljava/lang/String;

    move-result-object v0

    iget-object v1, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter;->h:Lcom/salesforce/android/cases/ui/CaseUIClient;

    invoke-interface {v1}, Lcom/salesforce/android/cases/ui/CaseUIClient;->d()Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter;->h:Lcom/salesforce/android/cases/ui/CaseUIClient;

    .line 91
    invoke-interface {v2}, Lcom/salesforce/android/cases/ui/CaseUIClient;->c()Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter;->h:Lcom/salesforce/android/cases/ui/CaseUIClient;

    .line 92
    invoke-interface {v3}, Lcom/salesforce/android/cases/ui/CaseUIClient;->e()Z

    move-result v3

    if-eqz v3, :cond_0

    const-string v3, "authenticated"

    :goto_0
    const-string v4, "detail_launched"

    iget-object v5, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter;->g:Ljava/lang/String;

    .line 90
    invoke-static/range {v0 .. v5}, Lcom/salesforce/android/cases/ui/CasesUIAnalyticsEmit;->c(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 94
    return-void

    .line 92
    :cond_0
    const-string v3, "guest"

    goto :goto_0
.end method

.method public bridge synthetic a(Lcom/salesforce/android/cases/ui/internal/features/shared/BaseView;)V
    .locals 0

    .prologue
    .line 57
    check-cast p1, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedContract$View;

    invoke-virtual {p0, p1}, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter;->a(Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedContract$View;)V

    return-void
.end method

.method public synthetic a(Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 57
    check-cast p1, Ljava/lang/String;

    invoke-virtual {p0, p1}, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter;->b(Ljava/lang/String;)V

    return-void
.end method

.method public a(Ljava/lang/String;)V
    .locals 3

    .prologue
    .line 128
    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 142
    :goto_0
    return-void

    .line 132
    :cond_0
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter;->c:Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedContract$View;

    invoke-interface {v0}, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedContract$View;->l()V

    .line 134
    new-instance v0, Lcom/salesforce/android/cases/core/requests/CommentPostRequest$CommentPostRequestBuilder;

    iget-object v1, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter;->e:Lcom/salesforce/android/cases/ui/internal/features/casefeed/viewmodel/CaseFeedViewModel;

    .line 135
    invoke-virtual {v1}, Lcom/salesforce/android/cases/ui/internal/features/casefeed/viewmodel/CaseFeedViewModel;->d()Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter;->g:Ljava/lang/String;

    invoke-direct {v0, v1, v2, p1}, Lcom/salesforce/android/cases/core/requests/CommentPostRequest$CommentPostRequestBuilder;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 136
    invoke-virtual {v0}, Lcom/salesforce/android/cases/core/requests/CommentPostRequest$CommentPostRequestBuilder;->b()Lcom/salesforce/android/cases/core/requests/CommentPostRequest;

    move-result-object v0

    .line 138
    iget-object v1, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter;->h:Lcom/salesforce/android/cases/ui/CaseUIClient;

    invoke-interface {v1}, Lcom/salesforce/android/cases/ui/CaseUIClient;->a()Lcom/salesforce/android/cases/core/CaseClient;

    move-result-object v1

    .line 139
    invoke-interface {v1, v0}, Lcom/salesforce/android/cases/core/CaseClient;->a(Lcom/salesforce/android/cases/core/requests/CommentPostRequest;)Lcom/salesforce/android/service/common/utilities/control/Async;

    move-result-object v0

    new-instance v1, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter$PostCommentResult;

    iget-object v2, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter;->e:Lcom/salesforce/android/cases/ui/internal/features/casefeed/viewmodel/CaseFeedViewModel;

    invoke-direct {v1, p0, v2}, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter$PostCommentResult;-><init>(Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter;Lcom/salesforce/android/cases/ui/internal/features/casefeed/viewmodel/CaseFeedViewModel;)V

    .line 140
    invoke-interface {v0, v1}, Lcom/salesforce/android/service/common/utilities/control/Async;->a(Lcom/salesforce/android/service/common/utilities/control/Async$ResultHandler;)Lcom/salesforce/android/service/common/utilities/control/Async;

    move-result-object v0

    new-instance v1, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter$PostCommentError;

    invoke-direct {v1, p0}, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter$PostCommentError;-><init>(Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter;)V

    .line 141
    invoke-interface {v0, v1}, Lcom/salesforce/android/service/common/utilities/control/Async;->a(Lcom/salesforce/android/service/common/utilities/control/Async$ErrorHandler;)Lcom/salesforce/android/service/common/utilities/control/Async;

    goto :goto_0
.end method

.method public b()V
    .locals 1

    .prologue
    .line 116
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter;->d:Ljava/lang/ref/WeakReference;

    if-eqz v0, :cond_0

    .line 117
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter;->d:Ljava/lang/ref/WeakReference;

    invoke-virtual {v0}, Ljava/lang/ref/WeakReference;->clear()V

    .line 118
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter;->d:Ljava/lang/ref/WeakReference;

    .line 120
    :cond_0
    return-void
.end method

.method public b(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 82
    iput-object p1, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter;->g:Ljava/lang/String;

    .line 83
    invoke-virtual {p0}, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter;->f()V

    .line 84
    return-void
.end method

.method public c()V
    .locals 2

    .prologue
    .line 145
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter;->f:Z

    .line 146
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter;->b:Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter$GetCaseFeedHandler;

    invoke-virtual {v0}, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter$GetCaseFeedHandler;->e()V

    .line 147
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter;->b:Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter$GetCaseFeedHandler;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter$GetCaseFeedHandler;->a(Z)V

    .line 148
    return-void
.end method

.method public d()V
    .locals 0

    .prologue
    .line 98
    return-void
.end method

.method public e()V
    .locals 2

    .prologue
    .line 101
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter;->a:Lcom/salesforce/android/cases/ui/internal/features/shared/PushNotificationBroadcastReceiver;

    iget-object v1, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter;->c:Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedContract$View;

    invoke-interface {v1}, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedContract$View;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/salesforce/android/cases/ui/internal/features/shared/PushNotificationBroadcastReceiver;->b(Landroid/content/Context;)V

    .line 102
    new-instance v0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/NullCaseFeedView;

    invoke-direct {v0}, Lcom/salesforce/android/cases/ui/internal/features/casefeed/NullCaseFeedView;-><init>()V

    iput-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter;->c:Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedContract$View;

    .line 103
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter;->b:Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter$GetCaseFeedHandler;

    invoke-virtual {v0}, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter$GetCaseFeedHandler;->e()V

    .line 104
    return-void
.end method

.method public f()V
    .locals 2

    .prologue
    .line 123
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter;->b:Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter$GetCaseFeedHandler;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter$GetCaseFeedHandler;->a(Z)V

    .line 124
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter;->f:Z

    .line 125
    return-void
.end method
