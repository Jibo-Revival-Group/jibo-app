.class Lcom/salesforce/android/cases/core/internal/operations/GetListViewLabelOp$1;
.super Ljava/lang/Object;
.source "GetListViewLabelOp.java"

# interfaces
.implements Lcom/salesforce/android/service/common/utilities/functional/Function;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/salesforce/android/cases/core/internal/operations/GetListViewLabelOp;->a(Lcom/salesforce/android/cases/core/internal/remote/RemoteRepository;Lcom/salesforce/android/cases/core/requests/ListViewRequest;)Lcom/salesforce/android/service/common/utilities/control/Async;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/salesforce/android/service/common/utilities/functional/Function",
        "<",
        "Ljava/util/List",
        "<",
        "Lcom/salesforce/android/cases/core/model/ListView;",
        ">;",
        "Ljava/lang/String;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic a:Lcom/salesforce/android/cases/core/requests/ListViewRequest;

.field final synthetic b:Lcom/salesforce/android/cases/core/internal/operations/GetListViewLabelOp;


# direct methods
.method constructor <init>(Lcom/salesforce/android/cases/core/internal/operations/GetListViewLabelOp;Lcom/salesforce/android/cases/core/requests/ListViewRequest;)V
    .locals 0

    .prologue
    .line 55
    iput-object p1, p0, Lcom/salesforce/android/cases/core/internal/operations/GetListViewLabelOp$1;->b:Lcom/salesforce/android/cases/core/internal/operations/GetListViewLabelOp;

    iput-object p2, p0, Lcom/salesforce/android/cases/core/internal/operations/GetListViewLabelOp$1;->a:Lcom/salesforce/android/cases/core/requests/ListViewRequest;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public bridge synthetic a(Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1

    .prologue
    .line 55
    check-cast p1, Ljava/util/List;

    invoke-virtual {p0, p1}, Lcom/salesforce/android/cases/core/internal/operations/GetListViewLabelOp$1;->a(Ljava/util/List;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public a(Ljava/util/List;)Ljava/lang/String;
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/salesforce/android/cases/core/model/ListView;",
            ">;)",
            "Ljava/lang/String;"
        }
    .end annotation

    .prologue
    .line 58
    invoke-interface {p1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :cond_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_1

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/salesforce/android/cases/core/model/ListView;

    .line 59
    invoke-interface {v0}, Lcom/salesforce/android/cases/core/model/ListView;->a()Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Lcom/salesforce/android/cases/core/internal/operations/GetListViewLabelOp$1;->a:Lcom/salesforce/android/cases/core/requests/ListViewRequest;

    invoke-virtual {v3}, Lcom/salesforce/android/cases/core/requests/ListViewRequest;->a()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 60
    invoke-interface {v0}, Lcom/salesforce/android/cases/core/model/ListView;->c()Ljava/lang/String;

    move-result-object v0

    .line 63
    :goto_0
    return-object v0

    :cond_1
    const-string v0, ""

    goto :goto_0
.end method
