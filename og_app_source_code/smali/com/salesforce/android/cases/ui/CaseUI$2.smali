.class Lcom/salesforce/android/cases/ui/CaseUI$2;
.super Ljava/lang/Object;
.source "CaseUI.java"

# interfaces
.implements Lcom/salesforce/android/service/common/utilities/control/Async$ResultHandler;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/salesforce/android/cases/ui/CaseUI;->a()Lcom/salesforce/android/service/common/utilities/control/Async;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/salesforce/android/service/common/utilities/control/Async$ResultHandler",
        "<",
        "Lcom/salesforce/android/cases/core/CaseClient;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic a:Lcom/salesforce/android/cases/core/internal/util/ReturnValue;

.field final synthetic b:Lcom/salesforce/android/cases/ui/CaseUI;


# direct methods
.method constructor <init>(Lcom/salesforce/android/cases/ui/CaseUI;Lcom/salesforce/android/cases/core/internal/util/ReturnValue;)V
    .locals 0

    .prologue
    .line 108
    iput-object p1, p0, Lcom/salesforce/android/cases/ui/CaseUI$2;->b:Lcom/salesforce/android/cases/ui/CaseUI;

    iput-object p2, p0, Lcom/salesforce/android/cases/ui/CaseUI$2;->a:Lcom/salesforce/android/cases/core/internal/util/ReturnValue;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Lcom/salesforce/android/service/common/utilities/control/Async;Lcom/salesforce/android/cases/core/CaseClient;)V
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/salesforce/android/service/common/utilities/control/Async",
            "<*>;",
            "Lcom/salesforce/android/cases/core/CaseClient;",
            ")V"
        }
    .end annotation

    .prologue
    .line 110
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/CaseUI$2;->b:Lcom/salesforce/android/cases/ui/CaseUI;

    iget-object v1, p0, Lcom/salesforce/android/cases/ui/CaseUI$2;->b:Lcom/salesforce/android/cases/ui/CaseUI;

    invoke-static {v1}, Lcom/salesforce/android/cases/ui/CaseUI;->a(Lcom/salesforce/android/cases/ui/CaseUI;)Landroid/content/Context;

    move-result-object v1

    iget-object v2, p0, Lcom/salesforce/android/cases/ui/CaseUI$2;->b:Lcom/salesforce/android/cases/ui/CaseUI;

    invoke-static {v2}, Lcom/salesforce/android/cases/ui/CaseUI;->b(Lcom/salesforce/android/cases/ui/CaseUI;)Lcom/salesforce/android/cases/ui/CaseUIConfiguration;

    move-result-object v2

    invoke-static {v1, v2, p2}, Lcom/salesforce/android/cases/ui/internal/client/CaseUIClientImpl;->a(Landroid/content/Context;Lcom/salesforce/android/cases/ui/CaseUIConfiguration;Lcom/salesforce/android/cases/core/CaseClient;)Lcom/salesforce/android/cases/ui/internal/client/CaseUIClientImpl;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/salesforce/android/cases/ui/CaseUI;->a(Lcom/salesforce/android/cases/ui/CaseUI;Lcom/salesforce/android/cases/ui/CaseUIClient;)Lcom/salesforce/android/cases/ui/CaseUIClient;

    .line 111
    instance-of v0, p2, Lcom/salesforce/android/cases/core/internal/client/CaseClientImpl;

    if-eqz v0, :cond_0

    .line 112
    check-cast p2, Lcom/salesforce/android/cases/core/internal/client/CaseClientImpl;

    iget-object v0, p0, Lcom/salesforce/android/cases/ui/CaseUI$2;->b:Lcom/salesforce/android/cases/ui/CaseUI;

    .line 113
    invoke-static {v0}, Lcom/salesforce/android/cases/ui/CaseUI;->c(Lcom/salesforce/android/cases/ui/CaseUI;)Lcom/salesforce/android/cases/ui/CaseUIClient;

    move-result-object v0

    check-cast v0, Lcom/salesforce/android/cases/ui/internal/client/CaseUIClientImpl;

    .line 112
    invoke-virtual {p2, v0}, Lcom/salesforce/android/cases/core/internal/client/CaseClientImpl;->a(Lcom/salesforce/android/cases/core/NotificationHandler;)V

    .line 115
    :cond_0
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/CaseUI$2;->a:Lcom/salesforce/android/cases/core/internal/util/ReturnValue;

    iget-object v1, p0, Lcom/salesforce/android/cases/ui/CaseUI$2;->b:Lcom/salesforce/android/cases/ui/CaseUI;

    invoke-static {v1}, Lcom/salesforce/android/cases/ui/CaseUI;->c(Lcom/salesforce/android/cases/ui/CaseUI;)Lcom/salesforce/android/cases/ui/CaseUIClient;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/salesforce/android/cases/core/internal/util/ReturnValue;->a(Ljava/lang/Object;)Lcom/salesforce/android/service/common/utilities/control/BasicAsync;

    .line 116
    return-void
.end method

.method public bridge synthetic a(Lcom/salesforce/android/service/common/utilities/control/Async;Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 108
    check-cast p2, Lcom/salesforce/android/cases/core/CaseClient;

    invoke-virtual {p0, p1, p2}, Lcom/salesforce/android/cases/ui/CaseUI$2;->a(Lcom/salesforce/android/service/common/utilities/control/Async;Lcom/salesforce/android/cases/core/CaseClient;)V

    return-void
.end method
