.class public Lcom/salesforce/android/knowledge/ui/internal/views/ArticleItemView;
.super Landroid/widget/RelativeLayout;
.source "ArticleItemView.java"


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 0

    .prologue
    .line 46
    invoke-direct {p0, p1}, Landroid/widget/RelativeLayout;-><init>(Landroid/content/Context;)V

    .line 47
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 0

    .prologue
    .line 50
    invoke-direct {p0, p1, p2}, Landroid/widget/RelativeLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 51
    return-void
.end method


# virtual methods
.method public a(Lcom/salesforce/android/knowledge/core/model/ArticleSummary;Landroid/graphics/drawable/Drawable;)V
    .locals 4

    .prologue
    .line 54
    sget v0, Lcom/salesforce/android/knowledge/ui/R$id;->knowledge_article_item_title:I

    invoke-static {p0, v0}, Lcom/salesforce/android/knowledge/ui/internal/views/ViewUtil;->a(Landroid/view/View;I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    .line 55
    sget v1, Lcom/salesforce/android/knowledge/ui/R$id;->knowledge_article_item_summary:I

    invoke-static {p0, v1}, Lcom/salesforce/android/knowledge/ui/internal/views/ViewUtil;->a(Landroid/view/View;I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/TextView;

    .line 56
    sget v2, Lcom/salesforce/android/knowledge/ui/R$id;->knowledge_article_item_thumbnail:I

    invoke-static {p0, v2}, Lcom/salesforce/android/knowledge/ui/internal/views/ViewUtil;->a(Landroid/view/View;I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/ImageView;

    .line 58
    if-eqz v0, :cond_0

    .line 59
    invoke-interface {p1}, Lcom/salesforce/android/knowledge/core/model/ArticleSummary;->i()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v3}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 64
    new-instance v3, Lcom/salesforce/android/knowledge/ui/internal/views/ArticleItemView$1;

    invoke-direct {v3, p0, v1, v0, p1}, Lcom/salesforce/android/knowledge/ui/internal/views/ArticleItemView$1;-><init>(Lcom/salesforce/android/knowledge/ui/internal/views/ArticleItemView;Landroid/widget/TextView;Landroid/widget/TextView;Lcom/salesforce/android/knowledge/core/model/ArticleSummary;)V

    invoke-virtual {v0, v3}, Landroid/widget/TextView;->addOnLayoutChangeListener(Landroid/view/View$OnLayoutChangeListener;)V

    .line 81
    :cond_0
    if-eqz v1, :cond_1

    .line 82
    invoke-interface {p1}, Lcom/salesforce/android/knowledge/core/model/ArticleSummary;->j()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 84
    :cond_1
    if-eqz v2, :cond_2

    .line 85
    if-nez p2, :cond_3

    const/16 v0, 0x8

    :goto_0
    invoke-virtual {v2, v0}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 86
    invoke-virtual {v2, p2}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 88
    :cond_2
    return-void

    .line 85
    :cond_3
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public setOnClickListener(Landroid/view/View$OnClickListener;)V
    .locals 1

    .prologue
    .line 92
    invoke-virtual {p0}, Lcom/salesforce/android/knowledge/ui/internal/views/ArticleItemView;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0, p1}, Lcom/salesforce/android/knowledge/ui/internal/util/AnimatedOnClickListener;->a(Landroid/content/Context;Landroid/view/View$OnClickListener;)Lcom/salesforce/android/knowledge/ui/internal/util/AnimatedOnClickListener;

    move-result-object v0

    invoke-super {p0, v0}, Landroid/widget/RelativeLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 93
    return-void
.end method
