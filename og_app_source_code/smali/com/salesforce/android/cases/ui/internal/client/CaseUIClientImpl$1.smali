.class Lcom/salesforce/android/cases/ui/internal/client/CaseUIClientImpl$1;
.super Ljava/lang/Object;
.source "CaseUIClientImpl.java"

# interfaces
.implements Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker$OnStartListener;


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
    .line 122
    iput-object p1, p0, Lcom/salesforce/android/cases/ui/internal/client/CaseUIClientImpl$1;->b:Lcom/salesforce/android/cases/ui/internal/client/CaseUIClientImpl;

    iput-object p2, p0, Lcom/salesforce/android/cases/ui/internal/client/CaseUIClientImpl$1;->a:Lcom/salesforce/android/cases/ui/internal/logging/LiveAgentCasesLogger;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Landroid/app/Activity;)V
    .locals 1

    .prologue
    .line 124
    instance-of v0, p1, Lcom/salesforce/android/cases/ui/internal/features/shared/CasesSdkActivity;

    if-eqz v0, :cond_0

    .line 125
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/client/CaseUIClientImpl$1;->a:Lcom/salesforce/android/cases/ui/internal/logging/LiveAgentCasesLogger;

    invoke-virtual {v0}, Lcom/salesforce/android/cases/ui/internal/logging/LiveAgentCasesLogger;->a()V

    .line 127
    :cond_0
    return-void
.end method
