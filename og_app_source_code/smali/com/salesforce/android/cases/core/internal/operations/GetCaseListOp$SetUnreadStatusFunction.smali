.class Lcom/salesforce/android/cases/core/internal/operations/GetCaseListOp$SetUnreadStatusFunction;
.super Ljava/lang/Object;
.source "GetCaseListOp.java"

# interfaces
.implements Lcom/salesforce/android/service/common/utilities/functional/Function;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/salesforce/android/cases/core/internal/operations/GetCaseListOp;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "SetUnreadStatusFunction"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/salesforce/android/service/common/utilities/functional/Function",
        "<",
        "Ljava/util/List",
        "<",
        "Lcom/salesforce/android/cases/core/model/CaseListRecord;",
        ">;",
        "Lcom/salesforce/android/service/common/utilities/control/Async",
        "<",
        "Ljava/util/List",
        "<",
        "Lcom/salesforce/android/cases/core/model/CaseListRecord;",
        ">;>;>;"
    }
.end annotation


# instance fields
.field final synthetic a:Lcom/salesforce/android/cases/core/internal/operations/GetCaseListOp;


# direct methods
.method private constructor <init>(Lcom/salesforce/android/cases/core/internal/operations/GetCaseListOp;)V
    .locals 0

    .prologue
    .line 82
    iput-object p1, p0, Lcom/salesforce/android/cases/core/internal/operations/GetCaseListOp$SetUnreadStatusFunction;->a:Lcom/salesforce/android/cases/core/internal/operations/GetCaseListOp;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/salesforce/android/cases/core/internal/operations/GetCaseListOp;Lcom/salesforce/android/cases/core/internal/operations/GetCaseListOp$1;)V
    .locals 0

    .prologue
    .line 82
    invoke-direct {p0, p1}, Lcom/salesforce/android/cases/core/internal/operations/GetCaseListOp$SetUnreadStatusFunction;-><init>(Lcom/salesforce/android/cases/core/internal/operations/GetCaseListOp;)V

    return-void
.end method

.method static synthetic a(Lcom/salesforce/android/cases/core/internal/operations/GetCaseListOp$SetUnreadStatusFunction;Lcom/salesforce/android/cases/core/model/CaseListRecord;Ljava/util/Date;Ljava/util/List;)Z
    .locals 1

    .prologue
    .line 82
    invoke-direct {p0, p1, p2, p3}, Lcom/salesforce/android/cases/core/internal/operations/GetCaseListOp$SetUnreadStatusFunction;->a(Lcom/salesforce/android/cases/core/model/CaseListRecord;Ljava/util/Date;Ljava/util/List;)Z

    move-result v0

    return v0
.end method

.method private a(Lcom/salesforce/android/cases/core/model/CaseListRecord;Ljava/util/Date;Ljava/util/List;)Z
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/salesforce/android/cases/core/model/CaseListRecord;",
            "Ljava/util/Date;",
            "Ljava/util/List",
            "<",
            "Lcom/salesforce/androidsdk/accounts/UserAccount;",
            ">;)Z"
        }
    .end annotation

    .prologue
    const/4 v1, 0x0

    .line 116
    invoke-interface {p1}, Lcom/salesforce/android/cases/core/model/CaseListRecord;->g()Lcom/salesforce/android/cases/core/model/CaseListFeedRecord;

    move-result-object v0

    .line 119
    if-eqz v0, :cond_0

    .line 120
    invoke-interface {v0}, Lcom/salesforce/android/cases/core/model/CaseListFeedRecord;->c()Ljava/util/Date;

    move-result-object v2

    if-nez v2, :cond_1

    :cond_0
    move v0, v1

    .line 142
    :goto_0
    return v0

    .line 125
    :cond_1
    invoke-virtual {v2, p2}, Ljava/util/Date;->after(Ljava/util/Date;)Z

    move-result v2

    if-nez v2, :cond_2

    move v0, v1

    .line 126
    goto :goto_0

    .line 130
    :cond_2
    invoke-interface {v0}, Lcom/salesforce/android/cases/core/model/CaseListFeedRecord;->b()Ljava/lang/String;

    move-result-object v2

    .line 131
    if-eqz v2, :cond_3

    invoke-virtual {v2}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_4

    :cond_3
    move v0, v1

    .line 132
    goto :goto_0

    .line 136
    :cond_4
    invoke-interface {p3}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :cond_5
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_6

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/salesforce/androidsdk/accounts/UserAccount;

    .line 137
    invoke-virtual {v0}, Lcom/salesforce/androidsdk/accounts/UserAccount;->g()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_5

    move v0, v1

    .line 138
    goto :goto_0

    .line 142
    :cond_6
    const/4 v0, 0x1

    goto :goto_0
.end method

.method private b(Ljava/util/List;)Lcom/salesforce/android/service/common/utilities/control/Async;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/salesforce/android/cases/core/model/CaseListRecord;",
            ">;)",
            "Lcom/salesforce/android/service/common/utilities/control/Async",
            "<",
            "Ljava/util/List",
            "<",
            "Lcom/salesforce/android/cases/core/model/CaseListRecord;",
            ">;>;"
        }
    .end annotation

    .prologue
    .line 90
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/operations/GetCaseListOp$SetUnreadStatusFunction;->a:Lcom/salesforce/android/cases/core/internal/operations/GetCaseListOp;

    iget-object v0, v0, Lcom/salesforce/android/cases/core/internal/operations/GetCaseListOp;->a:Lcom/salesforce/android/cases/core/internal/local/LocalRepository;

    if-nez v0, :cond_0

    .line 91
    invoke-static {}, Lcom/salesforce/android/service/common/utilities/control/BasicAsync;->h()Lcom/salesforce/android/service/common/utilities/control/BasicAsync;

    move-result-object v0

    .line 93
    :goto_0
    return-object v0

    :cond_0
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/operations/GetCaseListOp$SetUnreadStatusFunction;->a:Lcom/salesforce/android/cases/core/internal/operations/GetCaseListOp;

    iget-object v0, v0, Lcom/salesforce/android/cases/core/internal/operations/GetCaseListOp;->a:Lcom/salesforce/android/cases/core/internal/local/LocalRepository;

    invoke-interface {v0}, Lcom/salesforce/android/cases/core/internal/local/LocalRepository;->a()Lcom/salesforce/android/service/common/utilities/control/Async;

    move-result-object v0

    new-instance v1, Lcom/salesforce/android/cases/core/internal/operations/GetCaseListOp$SetUnreadStatusFunction$1;

    invoke-direct {v1, p0, p1}, Lcom/salesforce/android/cases/core/internal/operations/GetCaseListOp$SetUnreadStatusFunction$1;-><init>(Lcom/salesforce/android/cases/core/internal/operations/GetCaseListOp$SetUnreadStatusFunction;Ljava/util/List;)V

    .line 94
    invoke-interface {v0, v1}, Lcom/salesforce/android/service/common/utilities/control/Async;->b(Lcom/salesforce/android/service/common/utilities/functional/Function;)Lcom/salesforce/android/service/common/utilities/control/Async;

    move-result-object v0

    goto :goto_0
.end method


# virtual methods
.method public a(Ljava/util/List;)Lcom/salesforce/android/service/common/utilities/control/Async;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/salesforce/android/cases/core/model/CaseListRecord;",
            ">;)",
            "Lcom/salesforce/android/service/common/utilities/control/Async",
            "<",
            "Ljava/util/List",
            "<",
            "Lcom/salesforce/android/cases/core/model/CaseListRecord;",
            ">;>;"
        }
    .end annotation

    .prologue
    .line 86
    invoke-direct {p0, p1}, Lcom/salesforce/android/cases/core/internal/operations/GetCaseListOp$SetUnreadStatusFunction;->b(Ljava/util/List;)Lcom/salesforce/android/service/common/utilities/control/Async;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic a(Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1

    .prologue
    .line 82
    check-cast p1, Ljava/util/List;

    invoke-virtual {p0, p1}, Lcom/salesforce/android/cases/core/internal/operations/GetCaseListOp$SetUnreadStatusFunction;->a(Ljava/util/List;)Lcom/salesforce/android/service/common/utilities/control/Async;

    move-result-object v0

    return-object v0
.end method
