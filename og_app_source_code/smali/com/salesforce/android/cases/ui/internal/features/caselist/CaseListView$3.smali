.class Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView$3;
.super Ljava/lang/Object;
.source "CaseListView.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView;->n()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView;


# direct methods
.method constructor <init>(Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView;)V
    .locals 0

    .prologue
    .line 181
    iput-object p1, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView$3;->a:Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 1

    .prologue
    .line 183
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView$3;->a:Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView;

    invoke-static {v0}, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView;->a(Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView;)Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListContract$Presenter;

    move-result-object v0

    invoke-interface {v0}, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListContract$Presenter;->h()V

    .line 184
    return-void
.end method
