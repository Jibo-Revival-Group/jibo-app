.class Lcom/salesforce/android/service/common/fetchsave/internal/operations/FetchSaveOp$SaveHandler;
.super Ljava/lang/Object;
.source "FetchSaveOp.java"

# interfaces
.implements Lcom/salesforce/android/service/common/utilities/control/Async$CompletionHandler;
.implements Lcom/salesforce/android/service/common/utilities/control/Async$ErrorHandler;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/salesforce/android/service/common/fetchsave/internal/operations/FetchSaveOp;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "SaveHandler"
.end annotation


# instance fields
.field final synthetic a:Lcom/salesforce/android/service/common/fetchsave/internal/operations/FetchSaveOp;


# direct methods
.method constructor <init>(Lcom/salesforce/android/service/common/fetchsave/internal/operations/FetchSaveOp;)V
    .locals 0

    .prologue
    .line 225
    iput-object p1, p0, Lcom/salesforce/android/service/common/fetchsave/internal/operations/FetchSaveOp$SaveHandler;->a:Lcom/salesforce/android/service/common/fetchsave/internal/operations/FetchSaveOp;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Lcom/salesforce/android/service/common/utilities/control/Async;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/salesforce/android/service/common/utilities/control/Async",
            "<*>;)V"
        }
    .end annotation

    .prologue
    .line 231
    iget-object v0, p0, Lcom/salesforce/android/service/common/fetchsave/internal/operations/FetchSaveOp$SaveHandler;->a:Lcom/salesforce/android/service/common/fetchsave/internal/operations/FetchSaveOp;

    invoke-virtual {v0}, Lcom/salesforce/android/service/common/fetchsave/internal/operations/FetchSaveOp;->l()V

    .line 232
    return-void
.end method

.method public a(Lcom/salesforce/android/service/common/utilities/control/Async;Ljava/lang/Throwable;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/salesforce/android/service/common/utilities/control/Async",
            "<*>;",
            "Ljava/lang/Throwable;",
            ")V"
        }
    .end annotation

    .prologue
    .line 227
    iget-object v0, p0, Lcom/salesforce/android/service/common/fetchsave/internal/operations/FetchSaveOp$SaveHandler;->a:Lcom/salesforce/android/service/common/fetchsave/internal/operations/FetchSaveOp;

    invoke-virtual {v0, p2}, Lcom/salesforce/android/service/common/fetchsave/internal/operations/FetchSaveOp;->d(Ljava/lang/Throwable;)V

    .line 228
    return-void
.end method
