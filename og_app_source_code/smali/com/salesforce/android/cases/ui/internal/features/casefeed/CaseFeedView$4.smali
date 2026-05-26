.class Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedView$4;
.super Ljava/lang/Object;
.source "CaseFeedView.java"

# interfaces
.implements Landroid/support/v4/widget/SwipeRefreshLayout$OnRefreshListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedView;->a(Landroid/content/Context;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedView;


# direct methods
.method constructor <init>(Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedView;)V
    .locals 0

    .prologue
    .line 268
    iput-object p1, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedView$4;->a:Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public n_()V
    .locals 1

    .prologue
    .line 270
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedView$4;->a:Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedView;

    iget-object v0, v0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedView;->f:Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedContract$Presenter;

    invoke-interface {v0}, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedContract$Presenter;->c()V

    .line 271
    return-void
.end method
