.class Lcom/salesforce/android/knowledge/ui/internal/views/ArticleItemView$1;
.super Ljava/lang/Object;
.source "ArticleItemView.java"

# interfaces
.implements Landroid/view/View$OnLayoutChangeListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/salesforce/android/knowledge/ui/internal/views/ArticleItemView;->a(Lcom/salesforce/android/knowledge/core/model/ArticleSummary;Landroid/graphics/drawable/Drawable;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Landroid/widget/TextView;

.field final synthetic b:Landroid/widget/TextView;

.field final synthetic c:Lcom/salesforce/android/knowledge/core/model/ArticleSummary;

.field final synthetic d:Lcom/salesforce/android/knowledge/ui/internal/views/ArticleItemView;


# direct methods
.method constructor <init>(Lcom/salesforce/android/knowledge/ui/internal/views/ArticleItemView;Landroid/widget/TextView;Landroid/widget/TextView;Lcom/salesforce/android/knowledge/core/model/ArticleSummary;)V
    .locals 0

    .prologue
    .line 64
    iput-object p1, p0, Lcom/salesforce/android/knowledge/ui/internal/views/ArticleItemView$1;->d:Lcom/salesforce/android/knowledge/ui/internal/views/ArticleItemView;

    iput-object p2, p0, Lcom/salesforce/android/knowledge/ui/internal/views/ArticleItemView$1;->a:Landroid/widget/TextView;

    iput-object p3, p0, Lcom/salesforce/android/knowledge/ui/internal/views/ArticleItemView$1;->b:Landroid/widget/TextView;

    iput-object p4, p0, Lcom/salesforce/android/knowledge/ui/internal/views/ArticleItemView$1;->c:Lcom/salesforce/android/knowledge/core/model/ArticleSummary;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onLayoutChange(Landroid/view/View;IIIIIIII)V
    .locals 2

    .prologue
    .line 67
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/views/ArticleItemView$1;->a:Landroid/widget/TextView;

    if-eqz v0, :cond_0

    .line 70
    const/4 v0, 0x1

    iget-object v1, p0, Lcom/salesforce/android/knowledge/ui/internal/views/ArticleItemView$1;->b:Landroid/widget/TextView;

    invoke-virtual {v1}, Landroid/widget/TextView;->getLineCount()I

    move-result v1

    rsub-int/lit8 v1, v1, 0x3

    invoke-static {v0, v1}, Ljava/lang/Math;->max(II)I

    move-result v0

    .line 71
    iget-object v1, p0, Lcom/salesforce/android/knowledge/ui/internal/views/ArticleItemView$1;->a:Landroid/widget/TextView;

    invoke-virtual {v1, v0}, Landroid/widget/TextView;->setMaxLines(I)V

    .line 75
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/views/ArticleItemView$1;->a:Landroid/widget/TextView;

    iget-object v1, p0, Lcom/salesforce/android/knowledge/ui/internal/views/ArticleItemView$1;->c:Lcom/salesforce/android/knowledge/core/model/ArticleSummary;

    invoke-interface {v1}, Lcom/salesforce/android/knowledge/core/model/ArticleSummary;->j()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 77
    :cond_0
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/views/ArticleItemView$1;->b:Landroid/widget/TextView;

    invoke-virtual {v0, p0}, Landroid/widget/TextView;->removeOnLayoutChangeListener(Landroid/view/View$OnLayoutChangeListener;)V

    .line 78
    return-void
.end method
