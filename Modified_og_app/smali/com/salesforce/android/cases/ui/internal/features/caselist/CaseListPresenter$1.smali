.class Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter$1;
.super Lcom/salesforce/android/cases/ui/internal/features/shared/PushNotificationBroadcastReceiver;
.source "CaseListPresenter.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter;-><init>(Lcom/salesforce/android/cases/ui/CaseUIClient;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter;


# direct methods
.method constructor <init>(Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter;)V
    .locals 0

    .prologue
    .line 80
    iput-object p1, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter$1;->a:Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter;

    invoke-direct {p0}, Lcom/salesforce/android/cases/ui/internal/features/shared/PushNotificationBroadcastReceiver;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Lcom/salesforce/android/cases/core/model/PushNotification;)V
    .locals 1

    .prologue
    .line 82
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter$1;->a:Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter;

    iget-object v0, v0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter;->b:Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListContract$View;

    invoke-interface {v0}, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListContract$View;->n()V

    .line 83
    return-void
.end method
