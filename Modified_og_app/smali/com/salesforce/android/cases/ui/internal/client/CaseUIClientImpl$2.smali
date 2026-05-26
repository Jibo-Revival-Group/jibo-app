.class Lcom/salesforce/android/cases/ui/internal/client/CaseUIClientImpl$2;
.super Ljava/lang/Object;
.source "CaseUIClientImpl.java"

# interfaces
.implements Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker$OnStopListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/salesforce/android/cases/ui/internal/client/CaseUIClientImpl;-><init>(Landroid/content/Context;Lcom/salesforce/android/cases/ui/CaseUIConfiguration;Lcom/salesforce/android/cases/core/CaseClient;Lcom/salesforce/android/cases/ui/internal/features/shared/manager/PresenterManager;Lcom/salesforce/android/service/common/utilities/internal/android/notification/SalesforceNotificationBuilder$Builder;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/salesforce/android/cases/ui/internal/logging/LiveAgentCasesLogger;

.field final synthetic b:Lcom/salesforce/android/cases/ui/internal/client/CaseUIClientImpl;


# direct methods
.method constructor <init>(Lcom/salesforce/android/cases/ui/internal/client/CaseUIClientImpl;Lcom/salesforce/android/cases/ui/internal/logging/LiveAgentCasesLogger;)V
    .locals 0

    .prologue
    .line 129
    iput-object p1, p0, Lcom/salesforce/android/cases/ui/internal/client/CaseUIClientImpl$2;->b:Lcom/salesforce/android/cases/ui/internal/client/CaseUIClientImpl;

    iput-object p2, p0, Lcom/salesforce/android/cases/ui/internal/client/CaseUIClientImpl$2;->a:Lcom/salesforce/android/cases/ui/internal/logging/LiveAgentCasesLogger;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Landroid/app/Activity;)V
    .locals 1

    .prologue
    .line 131
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/client/CaseUIClientImpl$2;->b:Lcom/salesforce/android/cases/ui/internal/client/CaseUIClientImpl;

    invoke-static {v0}, Lcom/salesforce/android/cases/ui/internal/client/CaseUIClientImpl;->a(Lcom/salesforce/android/cases/ui/internal/client/CaseUIClientImpl;)Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker;

    move-result-object v0

    invoke-virtual {v0}, Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker;->b()Landroid/app/Activity;

    move-result-object v0

    instance-of v0, v0, Lcom/salesforce/android/cases/ui/internal/features/shared/CasesSdkActivity;

    if-nez v0, :cond_0

    .line 132
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/client/CaseUIClientImpl$2;->a:Lcom/salesforce/android/cases/ui/internal/logging/LiveAgentCasesLogger;

    invoke-virtual {v0}, Lcom/salesforce/android/cases/ui/internal/logging/LiveAgentCasesLogger;->b()V

    .line 134
    :cond_0
    return-void
.end method
