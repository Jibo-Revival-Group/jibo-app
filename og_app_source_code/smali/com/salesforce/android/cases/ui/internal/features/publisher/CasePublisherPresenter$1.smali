.class Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter$1;
.super Ljava/lang/Object;
.source "CasePublisherPresenter.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter;->a(Lcom/salesforce/android/cases/core/internal/model/CreateCaseRecordModel;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter;


# direct methods
.method constructor <init>(Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter;)V
    .locals 0

    .prologue
    .line 271
    iput-object p1, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter$1;->a:Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 1

    .prologue
    .line 273
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter$1;->a:Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter;

    iget-object v0, v0, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter;->f:Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter$CreateCaseHandler;

    invoke-virtual {v0}, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter$CreateCaseHandler;->d()V

    .line 274
    return-void
.end method
