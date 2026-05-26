.class Lcom/salesforce/android/cases/ui/internal/features/shared/BaseActivityDelegate$1;
.super Ljava/lang/Object;
.source "BaseActivityDelegate.java"

# interfaces
.implements Lcom/salesforce/android/service/common/utilities/control/Async$ResultHandler;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/salesforce/android/cases/ui/internal/features/shared/BaseActivityDelegate;->a(Landroid/os/Bundle;)V
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
        "Lcom/salesforce/android/cases/ui/CaseUIClient;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic a:Lcom/salesforce/android/cases/ui/internal/features/shared/BaseActivityDelegate;


# direct methods
.method constructor <init>(Lcom/salesforce/android/cases/ui/internal/features/shared/BaseActivityDelegate;)V
    .locals 0

    .prologue
    .line 58
    iput-object p1, p0, Lcom/salesforce/android/cases/ui/internal/features/shared/BaseActivityDelegate$1;->a:Lcom/salesforce/android/cases/ui/internal/features/shared/BaseActivityDelegate;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Lcom/salesforce/android/service/common/utilities/control/Async;Lcom/salesforce/android/cases/ui/CaseUIClient;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/salesforce/android/service/common/utilities/control/Async",
            "<*>;",
            "Lcom/salesforce/android/cases/ui/CaseUIClient;",
            ")V"
        }
    .end annotation

    .prologue
    .line 60
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/shared/BaseActivityDelegate$1;->a:Lcom/salesforce/android/cases/ui/internal/features/shared/BaseActivityDelegate;

    invoke-static {v0, p2}, Lcom/salesforce/android/cases/ui/internal/features/shared/BaseActivityDelegate;->a(Lcom/salesforce/android/cases/ui/internal/features/shared/BaseActivityDelegate;Lcom/salesforce/android/cases/ui/CaseUIClient;)V

    .line 61
    return-void
.end method

.method public bridge synthetic a(Lcom/salesforce/android/service/common/utilities/control/Async;Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 58
    check-cast p2, Lcom/salesforce/android/cases/ui/CaseUIClient;

    invoke-virtual {p0, p1, p2}, Lcom/salesforce/android/cases/ui/internal/features/shared/BaseActivityDelegate$1;->a(Lcom/salesforce/android/service/common/utilities/control/Async;Lcom/salesforce/android/cases/ui/CaseUIClient;)V

    return-void
.end method
