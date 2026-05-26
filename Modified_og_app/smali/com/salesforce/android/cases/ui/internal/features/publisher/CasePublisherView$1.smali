.class Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherView$1;
.super Ljava/lang/Object;
.source "CasePublisherView.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherView;->h()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherView;


# direct methods
.method constructor <init>(Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherView;)V
    .locals 0

    .prologue
    .line 135
    iput-object p1, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherView$1;->a:Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 1

    .prologue
    .line 137
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherView$1;->a:Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherView;

    invoke-static {v0}, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherView;->a(Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherView;)Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherContract$Presenter;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 138
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherView$1;->a:Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherView;

    invoke-static {v0}, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherView;->a(Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherView;)Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherContract$Presenter;

    move-result-object v0

    invoke-interface {v0}, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherContract$Presenter;->c()V

    .line 140
    :cond_0
    return-void
.end method
