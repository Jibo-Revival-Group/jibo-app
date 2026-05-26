.class Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView$8;
.super Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListAdapter;
.source "CaseListView.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView;->u()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView;


# direct methods
.method constructor <init>(Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView;Landroid/content/Context;)V
    .locals 0

    .prologue
    .line 380
    iput-object p1, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView$8;->a:Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView;

    invoke-direct {p0, p2}, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListAdapter;-><init>(Landroid/content/Context;)V

    return-void
.end method


# virtual methods
.method a(Lcom/salesforce/android/cases/ui/internal/features/caselist/viewmodel/CaseListItemViewModel;)V
    .locals 1

    .prologue
    .line 382
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView$8;->a:Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView;

    invoke-virtual {v0, p1}, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView;->d(Lcom/salesforce/android/cases/ui/internal/features/caselist/viewmodel/CaseListItemViewModel;)V

    .line 383
    return-void
.end method
