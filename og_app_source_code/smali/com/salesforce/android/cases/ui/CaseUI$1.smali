.class Lcom/salesforce/android/cases/ui/CaseUI$1;
.super Ljava/lang/Object;
.source "CaseUI.java"

# interfaces
.implements Lcom/salesforce/android/service/common/utilities/control/Async$ErrorHandler;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/salesforce/android/cases/ui/CaseUI;->a()Lcom/salesforce/android/service/common/utilities/control/Async;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/salesforce/android/cases/core/internal/util/ReturnValue;

.field final synthetic b:Lcom/salesforce/android/cases/ui/CaseUI;


# direct methods
.method constructor <init>(Lcom/salesforce/android/cases/ui/CaseUI;Lcom/salesforce/android/cases/core/internal/util/ReturnValue;)V
    .locals 0

    .prologue
    .line 118
    iput-object p1, p0, Lcom/salesforce/android/cases/ui/CaseUI$1;->b:Lcom/salesforce/android/cases/ui/CaseUI;

    iput-object p2, p0, Lcom/salesforce/android/cases/ui/CaseUI$1;->a:Lcom/salesforce/android/cases/core/internal/util/ReturnValue;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
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
    .line 120
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/CaseUI$1;->a:Lcom/salesforce/android/cases/core/internal/util/ReturnValue;

    invoke-virtual {v0, p2}, Lcom/salesforce/android/cases/core/internal/util/ReturnValue;->a(Ljava/lang/Throwable;)Lcom/salesforce/android/service/common/utilities/control/BasicAsync;

    .line 121
    return-void
.end method
