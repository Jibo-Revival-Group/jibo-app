.class Lcom/salesforce/android/knowledge/ui/internal/articledetail/ArticleDetailViewBinder$1;
.super Ljava/lang/Object;
.source "ArticleDetailViewBinder.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/salesforce/android/knowledge/ui/internal/articledetail/ArticleDetailViewBinder;->a(Landroid/view/View;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/salesforce/android/knowledge/ui/internal/articledetail/ArticleDetailViewBinder;


# direct methods
.method constructor <init>(Lcom/salesforce/android/knowledge/ui/internal/articledetail/ArticleDetailViewBinder;)V
    .locals 0

    .prologue
    .line 122
    iput-object p1, p0, Lcom/salesforce/android/knowledge/ui/internal/articledetail/ArticleDetailViewBinder$1;->a:Lcom/salesforce/android/knowledge/ui/internal/articledetail/ArticleDetailViewBinder;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 1

    .prologue
    .line 124
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/articledetail/ArticleDetailViewBinder$1;->a:Lcom/salesforce/android/knowledge/ui/internal/articledetail/ArticleDetailViewBinder;

    iget-object v0, v0, Lcom/salesforce/android/knowledge/ui/internal/articledetail/ArticleDetailViewBinder;->a:Lcom/salesforce/android/knowledge/ui/internal/views/TintedCollapsingToolbarLayout;

    invoke-virtual {v0}, Lcom/salesforce/android/knowledge/ui/internal/views/TintedCollapsingToolbarLayout;->requestLayout()V

    .line 125
    return-void
.end method
