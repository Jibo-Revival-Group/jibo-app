.class public Lcom/salesforce/android/knowledge/ui/internal/articledetail/ArticleDetailViewBinder;
.super Lcom/salesforce/android/knowledge/ui/internal/toolbar/ToolbarViewBinder;
.source "ArticleDetailViewBinder.java"

# interfaces
.implements Lcom/salesforce/android/knowledge/ui/internal/articledetail/ArticleDetailView;


# instance fields
.field protected a:Lcom/salesforce/android/knowledge/ui/internal/views/TintedCollapsingToolbarLayout;

.field private final b:Lcom/salesforce/android/knowledge/ui/internal/articledetail/ArticleDetailPresenter;

.field private c:Landroid/support/design/widget/AppBarLayout;

.field private d:Landroid/widget/ImageView;

.field private e:Landroid/view/View;

.field private f:Lcom/salesforce/android/knowledge/ui/ArticleWebView;

.field private g:Landroid/view/View;

.field private h:Landroid/view/View;

.field private i:Landroid/view/View;

.field private j:Landroid/view/View;

.field private k:Landroid/view/View;


# direct methods
.method private constructor <init>(Lcom/salesforce/android/knowledge/ui/internal/articledetail/ArticleDetailPresenter;)V
    .locals 0

    .prologue
    .line 62
    invoke-direct {p0, p1}, Lcom/salesforce/android/knowledge/ui/internal/toolbar/ToolbarViewBinder;-><init>(Lcom/salesforce/android/knowledge/ui/internal/toolbar/ToolbarPresenter;)V

    .line 63
    iput-object p1, p0, Lcom/salesforce/android/knowledge/ui/internal/articledetail/ArticleDetailViewBinder;->b:Lcom/salesforce/android/knowledge/ui/internal/articledetail/ArticleDetailPresenter;

    .line 64
    return-void
.end method

.method public static a(Lcom/salesforce/android/knowledge/ui/internal/articledetail/ArticleDetailPresenter;)Lcom/salesforce/android/knowledge/ui/internal/articledetail/ArticleDetailViewBinder;
    .locals 1

    .prologue
    .line 58
    new-instance v0, Lcom/salesforce/android/knowledge/ui/internal/articledetail/ArticleDetailViewBinder;

    invoke-direct {v0, p0}, Lcom/salesforce/android/knowledge/ui/internal/articledetail/ArticleDetailViewBinder;-><init>(Lcom/salesforce/android/knowledge/ui/internal/articledetail/ArticleDetailPresenter;)V

    return-object v0
.end method


# virtual methods
.method public a()Landroid/content/Context;
    .locals 1

    .prologue
    .line 189
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/articledetail/ArticleDetailViewBinder;->g:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->getContext()Landroid/content/Context;

    move-result-object v0

    return-object v0
.end method

.method public a(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 2

    .prologue
    .line 94
    sget v0, Lcom/salesforce/android/knowledge/ui/R$layout;->knowledge_fragment_article_detail:I

    const/4 v1, 0x0

    invoke-virtual {p1, v0, p2, v1}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/articledetail/ArticleDetailViewBinder;->g:Landroid/view/View;

    .line 95
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/articledetail/ArticleDetailViewBinder;->g:Landroid/view/View;

    invoke-virtual {p0, v0}, Lcom/salesforce/android/knowledge/ui/internal/articledetail/ArticleDetailViewBinder;->a(Landroid/view/View;)V

    .line 96
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/articledetail/ArticleDetailViewBinder;->b:Lcom/salesforce/android/knowledge/ui/internal/articledetail/ArticleDetailPresenter;

    invoke-interface {v0, p0}, Lcom/salesforce/android/knowledge/ui/internal/articledetail/ArticleDetailPresenter;->b(Ljava/lang/Object;)V

    .line 97
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/articledetail/ArticleDetailViewBinder;->g:Landroid/view/View;

    return-object v0
.end method

.method public a(Lcom/salesforce/android/knowledge/ui/KnowledgeUIClient;Lcom/salesforce/android/knowledge/core/model/ArticleDetails;)Lcom/salesforce/android/service/common/utilities/control/Async;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/salesforce/android/knowledge/ui/KnowledgeUIClient;",
            "Lcom/salesforce/android/knowledge/core/model/ArticleDetails;",
            ")",
            "Lcom/salesforce/android/service/common/utilities/control/Async",
            "<",
            "Ljava/lang/Void;",
            ">;"
        }
    .end annotation

    .prologue
    .line 181
    new-instance v0, Lcom/salesforce/android/knowledge/ui/ArticleWebViewConfiguration$Builder;

    invoke-interface {p1}, Lcom/salesforce/android/knowledge/ui/KnowledgeUIClient;->c()Lcom/salesforce/android/knowledge/core/KnowledgeClient;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/salesforce/android/knowledge/ui/ArticleWebViewConfiguration$Builder;-><init>(Lcom/salesforce/android/knowledge/core/KnowledgeClient;)V

    .line 182
    invoke-interface {p1}, Lcom/salesforce/android/knowledge/ui/KnowledgeUIClient;->d()Lcom/salesforce/android/knowledge/ui/KnowledgeCssProvider;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/salesforce/android/knowledge/ui/ArticleWebViewConfiguration$Builder;->a(Lcom/salesforce/android/knowledge/ui/KnowledgeCssProvider;)Lcom/salesforce/android/knowledge/ui/ArticleWebViewConfiguration$Builder;

    move-result-object v0

    .line 183
    invoke-interface {p1}, Lcom/salesforce/android/knowledge/ui/KnowledgeUIClient;->e()Lcom/salesforce/android/knowledge/ui/KnowledgeJsProvider;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/salesforce/android/knowledge/ui/ArticleWebViewConfiguration$Builder;->a(Lcom/salesforce/android/knowledge/ui/KnowledgeJsProvider;)Lcom/salesforce/android/knowledge/ui/ArticleWebViewConfiguration$Builder;

    move-result-object v0

    .line 184
    invoke-virtual {v0}, Lcom/salesforce/android/knowledge/ui/ArticleWebViewConfiguration$Builder;->a()Lcom/salesforce/android/knowledge/ui/ArticleWebViewConfiguration;

    move-result-object v0

    .line 185
    iget-object v1, p0, Lcom/salesforce/android/knowledge/ui/internal/articledetail/ArticleDetailViewBinder;->f:Lcom/salesforce/android/knowledge/ui/ArticleWebView;

    invoke-virtual {v1, p2, v0}, Lcom/salesforce/android/knowledge/ui/ArticleWebView;->a(Lcom/salesforce/android/knowledge/core/model/ArticleDetails;Lcom/salesforce/android/knowledge/ui/ArticleWebViewConfiguration;)Lcom/salesforce/android/service/common/utilities/control/Async;

    move-result-object v0

    return-object v0
.end method

.method public a(I)V
    .locals 4

    .prologue
    const/16 v2, 0x8

    const/4 v1, 0x0

    .line 152
    iget-object v3, p0, Lcom/salesforce/android/knowledge/ui/internal/articledetail/ArticleDetailViewBinder;->f:Lcom/salesforce/android/knowledge/ui/ArticleWebView;

    const/4 v0, 0x1

    if-ne p1, v0, :cond_2

    move v0, v1

    :goto_0
    invoke-virtual {v3, v0}, Lcom/salesforce/android/knowledge/ui/ArticleWebView;->setVisibility(I)V

    .line 153
    iget-object v3, p0, Lcom/salesforce/android/knowledge/ui/internal/articledetail/ArticleDetailViewBinder;->h:Landroid/view/View;

    if-nez p1, :cond_3

    move v0, v1

    :goto_1
    invoke-virtual {v3, v0}, Landroid/view/View;->setVisibility(I)V

    .line 154
    iget-object v3, p0, Lcom/salesforce/android/knowledge/ui/internal/articledetail/ArticleDetailViewBinder;->i:Landroid/view/View;

    const/4 v0, 0x2

    if-ne p1, v0, :cond_4

    move v0, v1

    :goto_2
    invoke-virtual {v3, v0}, Landroid/view/View;->setVisibility(I)V

    .line 155
    iget-object v3, p0, Lcom/salesforce/android/knowledge/ui/internal/articledetail/ArticleDetailViewBinder;->j:Landroid/view/View;

    const/4 v0, 0x3

    if-ne p1, v0, :cond_5

    move v0, v1

    :goto_3
    invoke-virtual {v3, v0}, Landroid/view/View;->setVisibility(I)V

    .line 156
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/articledetail/ArticleDetailViewBinder;->k:Landroid/view/View;

    const/4 v3, 0x4

    if-ne p1, v3, :cond_0

    move v2, v1

    :cond_0
    invoke-virtual {v0, v2}, Landroid/view/View;->setVisibility(I)V

    .line 158
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/articledetail/ArticleDetailViewBinder;->f:Lcom/salesforce/android/knowledge/ui/ArticleWebView;

    invoke-virtual {v0}, Lcom/salesforce/android/knowledge/ui/ArticleWebView;->getVisibility()I

    move-result v0

    if-eqz v0, :cond_1

    .line 160
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/articledetail/ArticleDetailViewBinder;->c:Landroid/support/design/widget/AppBarLayout;

    invoke-virtual {v0, v1}, Landroid/support/design/widget/AppBarLayout;->setExpanded(Z)V

    .line 162
    :cond_1
    return-void

    :cond_2
    move v0, v2

    .line 152
    goto :goto_0

    :cond_3
    move v0, v2

    .line 153
    goto :goto_1

    :cond_4
    move v0, v2

    .line 154
    goto :goto_2

    :cond_5
    move v0, v2

    .line 155
    goto :goto_3
.end method

.method public a(Landroid/graphics/drawable/Drawable;)V
    .locals 2

    .prologue
    .line 169
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/articledetail/ArticleDetailViewBinder;->d:Landroid/widget/ImageView;

    invoke-virtual {v0, p1}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 175
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/articledetail/ArticleDetailViewBinder;->e:Landroid/view/View;

    sget v1, Lcom/salesforce/android/knowledge/ui/R$drawable;->knowledge_header_gradient:I

    invoke-virtual {v0, v1}, Landroid/view/View;->setBackgroundResource(I)V

    .line 176
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/articledetail/ArticleDetailViewBinder;->c:Landroid/support/design/widget/AppBarLayout;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Landroid/support/design/widget/AppBarLayout;->setExpanded(Z)V

    .line 177
    return-void
.end method

.method public a(Landroid/view/Menu;Landroid/view/MenuInflater;)V
    .locals 1

    .prologue
    .line 134
    invoke-super {p0, p1, p2}, Lcom/salesforce/android/knowledge/ui/internal/toolbar/ToolbarViewBinder;->a(Landroid/view/Menu;Landroid/view/MenuInflater;)V

    .line 135
    sget v0, Lcom/salesforce/android/knowledge/ui/R$menu;->knowledge_article_menu:I

    invoke-virtual {p2, v0, p1}, Landroid/view/MenuInflater;->inflate(ILandroid/view/Menu;)V

    .line 136
    return-void
.end method

.method a(Landroid/view/View;)V
    .locals 2

    .prologue
    .line 106
    sget v0, Lcom/salesforce/android/knowledge/ui/R$id;->knowledge_article_detail_app_bar_layout:I

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/support/design/widget/AppBarLayout;

    iput-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/articledetail/ArticleDetailViewBinder;->c:Landroid/support/design/widget/AppBarLayout;

    .line 107
    sget v0, Lcom/salesforce/android/knowledge/ui/R$id;->knowledge_article_collapsing_toolbar:I

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/salesforce/android/knowledge/ui/internal/views/TintedCollapsingToolbarLayout;

    iput-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/articledetail/ArticleDetailViewBinder;->a:Lcom/salesforce/android/knowledge/ui/internal/views/TintedCollapsingToolbarLayout;

    .line 108
    sget v0, Lcom/salesforce/android/knowledge/ui/R$id;->knowledge_article_header_gradient:I

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/articledetail/ArticleDetailViewBinder;->e:Landroid/view/View;

    .line 109
    sget v0, Lcom/salesforce/android/knowledge/ui/R$id;->knowledge_article_header_image:I

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/articledetail/ArticleDetailViewBinder;->d:Landroid/widget/ImageView;

    .line 111
    sget v0, Lcom/salesforce/android/knowledge/ui/R$id;->knowledge_indeterminate_progress:I

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/articledetail/ArticleDetailViewBinder;->h:Landroid/view/View;

    .line 112
    sget v0, Lcom/salesforce/android/knowledge/ui/R$id;->knowledge_empty_article:I

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/articledetail/ArticleDetailViewBinder;->i:Landroid/view/View;

    .line 113
    sget v0, Lcom/salesforce/android/knowledge/ui/R$id;->knowledge_error:I

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/articledetail/ArticleDetailViewBinder;->j:Landroid/view/View;

    .line 114
    sget v0, Lcom/salesforce/android/knowledge/ui/R$id;->knowledge_network_error:I

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/articledetail/ArticleDetailViewBinder;->k:Landroid/view/View;

    .line 115
    sget v0, Lcom/salesforce/android/knowledge/ui/R$id;->knowledge_article_webview:I

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/salesforce/android/knowledge/ui/ArticleWebView;

    iput-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/articledetail/ArticleDetailViewBinder;->f:Lcom/salesforce/android/knowledge/ui/ArticleWebView;

    .line 122
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/articledetail/ArticleDetailViewBinder;->a:Lcom/salesforce/android/knowledge/ui/internal/views/TintedCollapsingToolbarLayout;

    new-instance v1, Lcom/salesforce/android/knowledge/ui/internal/articledetail/ArticleDetailViewBinder$1;

    invoke-direct {v1, p0}, Lcom/salesforce/android/knowledge/ui/internal/articledetail/ArticleDetailViewBinder$1;-><init>(Lcom/salesforce/android/knowledge/ui/internal/articledetail/ArticleDetailViewBinder;)V

    invoke-virtual {v0, v1}, Lcom/salesforce/android/knowledge/ui/internal/views/TintedCollapsingToolbarLayout;->post(Ljava/lang/Runnable;)Z

    .line 127
    return-void
.end method

.method public a(Ljava/lang/String;)V
    .locals 1

    .prologue
    .line 165
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/articledetail/ArticleDetailViewBinder;->a:Lcom/salesforce/android/knowledge/ui/internal/views/TintedCollapsingToolbarLayout;

    invoke-virtual {v0, p1}, Lcom/salesforce/android/knowledge/ui/internal/views/TintedCollapsingToolbarLayout;->setTitle(Ljava/lang/CharSequence;)V

    .line 166
    return-void
.end method

.method public a(Landroid/view/MenuItem;)Z
    .locals 2

    .prologue
    .line 139
    invoke-interface {p1}, Landroid/view/MenuItem;->getItemId()I

    move-result v0

    sget v1, Lcom/salesforce/android/knowledge/ui/R$id;->knowledge_action_minimize:I

    if-ne v0, v1, :cond_0

    .line 140
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/articledetail/ArticleDetailViewBinder;->b:Lcom/salesforce/android/knowledge/ui/internal/articledetail/ArticleDetailPresenter;

    invoke-interface {v0}, Lcom/salesforce/android/knowledge/ui/internal/articledetail/ArticleDetailPresenter;->a()V

    .line 141
    const/4 v0, 0x1

    .line 144
    :goto_0
    return v0

    :cond_0
    invoke-super {p0, p1}, Lcom/salesforce/android/knowledge/ui/internal/toolbar/ToolbarViewBinder;->a(Landroid/view/MenuItem;)Z

    move-result v0

    goto :goto_0
.end method

.method public b()V
    .locals 1

    .prologue
    .line 101
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/articledetail/ArticleDetailViewBinder;->b:Lcom/salesforce/android/knowledge/ui/internal/articledetail/ArticleDetailPresenter;

    invoke-interface {v0, p0}, Lcom/salesforce/android/knowledge/ui/internal/articledetail/ArticleDetailPresenter;->a(Ljava/lang/Object;)V

    .line 102
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/articledetail/ArticleDetailViewBinder;->f:Lcom/salesforce/android/knowledge/ui/ArticleWebView;

    invoke-virtual {v0}, Lcom/salesforce/android/knowledge/ui/ArticleWebView;->a()V

    .line 103
    return-void
.end method

.method public d()Landroid/support/v7/widget/Toolbar;
    .locals 2

    .prologue
    .line 130
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/articledetail/ArticleDetailViewBinder;->g:Landroid/view/View;

    sget v1, Lcom/salesforce/android/knowledge/ui/R$id;->knowledge_article_toolbar:I

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/support/v7/widget/Toolbar;

    return-object v0
.end method
