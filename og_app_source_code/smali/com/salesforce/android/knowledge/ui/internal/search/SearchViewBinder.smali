.class public Lcom/salesforce/android/knowledge/ui/internal/search/SearchViewBinder;
.super Lcom/salesforce/android/knowledge/ui/internal/ViewBinder;
.source "SearchViewBinder.java"

# interfaces
.implements Lcom/salesforce/android/knowledge/ui/internal/search/SearchListController$OnArticleSelectedListener;
.implements Lcom/salesforce/android/knowledge/ui/internal/search/SearchView;
.implements Lcom/salesforce/android/knowledge/ui/internal/util/InfiniteScrollListener$BehaviorListener;
.implements Lcom/salesforce/android/service/common/ui/internal/text/SalesforceTextWatcher$OnAfterTextChangedListener;


# instance fields
.field private final a:Landroid/view/inputmethod/InputMethodManager;

.field private final b:Lcom/salesforce/android/knowledge/ui/internal/search/SearchPresenter;

.field private final c:Lcom/salesforce/android/knowledge/ui/internal/search/SearchListController;

.field private final d:Lcom/salesforce/android/service/common/ui/internal/text/SalesforceTextWatcher;

.field private e:Lcom/salesforce/android/knowledge/ui/internal/util/InfiniteScrollListener;

.field private f:Landroid/view/View;

.field private g:Landroid/widget/EditText;

.field private h:Landroid/view/View;

.field private i:Landroid/view/View;

.field private j:Landroid/view/View;

.field private k:Landroid/view/View;

.field private l:Landroid/support/v7/widget/RecyclerView;


# direct methods
.method private constructor <init>(Lcom/salesforce/android/knowledge/ui/internal/search/SearchPresenter;Lcom/salesforce/android/knowledge/ui/internal/search/SearchListController;Landroid/view/inputmethod/InputMethodManager;)V
    .locals 1

    .prologue
    .line 95
    invoke-direct {p0}, Lcom/salesforce/android/knowledge/ui/internal/ViewBinder;-><init>()V

    .line 63
    new-instance v0, Lcom/salesforce/android/service/common/ui/internal/text/SalesforceTextWatcher;

    invoke-direct {v0}, Lcom/salesforce/android/service/common/ui/internal/text/SalesforceTextWatcher;-><init>()V

    iput-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/search/SearchViewBinder;->d:Lcom/salesforce/android/service/common/ui/internal/text/SalesforceTextWatcher;

    .line 96
    iput-object p1, p0, Lcom/salesforce/android/knowledge/ui/internal/search/SearchViewBinder;->b:Lcom/salesforce/android/knowledge/ui/internal/search/SearchPresenter;

    .line 97
    iput-object p2, p0, Lcom/salesforce/android/knowledge/ui/internal/search/SearchViewBinder;->c:Lcom/salesforce/android/knowledge/ui/internal/search/SearchListController;

    .line 98
    iput-object p3, p0, Lcom/salesforce/android/knowledge/ui/internal/search/SearchViewBinder;->a:Landroid/view/inputmethod/InputMethodManager;

    .line 99
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/search/SearchViewBinder;->d:Lcom/salesforce/android/service/common/ui/internal/text/SalesforceTextWatcher;

    invoke-virtual {v0, p0}, Lcom/salesforce/android/service/common/ui/internal/text/SalesforceTextWatcher;->a(Lcom/salesforce/android/service/common/ui/internal/text/SalesforceTextWatcher$OnAfterTextChangedListener;)V

    .line 100
    return-void
.end method

.method public static a(Lcom/salesforce/android/knowledge/ui/internal/search/SearchPresenter;Landroid/view/inputmethod/InputMethodManager;)Lcom/salesforce/android/knowledge/ui/internal/search/SearchViewBinder;
    .locals 2

    .prologue
    .line 92
    new-instance v0, Lcom/salesforce/android/knowledge/ui/internal/search/SearchViewBinder;

    invoke-static {p0}, Lcom/salesforce/android/knowledge/ui/internal/search/SearchListController;->a(Lcom/salesforce/android/knowledge/ui/internal/search/SearchPresenter;)Lcom/salesforce/android/knowledge/ui/internal/search/SearchListController;

    move-result-object v1

    invoke-direct {v0, p0, v1, p1}, Lcom/salesforce/android/knowledge/ui/internal/search/SearchViewBinder;-><init>(Lcom/salesforce/android/knowledge/ui/internal/search/SearchPresenter;Lcom/salesforce/android/knowledge/ui/internal/search/SearchListController;Landroid/view/inputmethod/InputMethodManager;)V

    return-object v0
.end method

.method private f()V
    .locals 3

    .prologue
    .line 227
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/search/SearchViewBinder;->a:Landroid/view/inputmethod/InputMethodManager;

    iget-object v1, p0, Lcom/salesforce/android/knowledge/ui/internal/search/SearchViewBinder;->g:Landroid/widget/EditText;

    invoke-virtual {v1}, Landroid/widget/EditText;->getWindowToken()Landroid/os/IBinder;

    move-result-object v1

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/view/inputmethod/InputMethodManager;->hideSoftInputFromWindow(Landroid/os/IBinder;I)Z

    .line 228
    return-void
.end method


# virtual methods
.method public a()Landroid/content/Context;
    .locals 1

    .prologue
    .line 194
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/search/SearchViewBinder;->f:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->getContext()Landroid/content/Context;

    move-result-object v0

    return-object v0
.end method

.method public a(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 108
    sget v0, Lcom/salesforce/android/knowledge/ui/R$layout;->knowledge_fragment_search:I

    invoke-virtual {p1, v0, p2, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/search/SearchViewBinder;->f:Landroid/view/View;

    .line 109
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/search/SearchViewBinder;->f:Landroid/view/View;

    invoke-virtual {p0, v0}, Lcom/salesforce/android/knowledge/ui/internal/search/SearchViewBinder;->a(Landroid/view/View;)V

    .line 110
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/search/SearchViewBinder;->c:Lcom/salesforce/android/knowledge/ui/internal/search/SearchListController;

    invoke-virtual {v0, p0}, Lcom/salesforce/android/knowledge/ui/internal/search/SearchListController;->a(Lcom/salesforce/android/knowledge/ui/internal/search/SearchListController$OnArticleSelectedListener;)V

    .line 111
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/search/SearchViewBinder;->b:Lcom/salesforce/android/knowledge/ui/internal/search/SearchPresenter;

    invoke-interface {v0, p0}, Lcom/salesforce/android/knowledge/ui/internal/search/SearchPresenter;->b(Ljava/lang/Object;)V

    .line 113
    if-nez p3, :cond_0

    .line 115
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/search/SearchViewBinder;->g:Landroid/widget/EditText;

    invoke-virtual {v0}, Landroid/widget/EditText;->requestFocus()Z

    .line 116
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/search/SearchViewBinder;->a:Landroid/view/inputmethod/InputMethodManager;

    const/4 v1, 0x2

    invoke-virtual {v0, v1, v2}, Landroid/view/inputmethod/InputMethodManager;->toggleSoftInput(II)V

    .line 119
    :cond_0
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/search/SearchViewBinder;->f:Landroid/view/View;

    return-object v0
.end method

.method public a(I)V
    .locals 5

    .prologue
    const/4 v2, 0x4

    const/16 v3, 0x8

    const/4 v1, 0x0

    .line 182
    iget-object v4, p0, Lcom/salesforce/android/knowledge/ui/internal/search/SearchViewBinder;->l:Landroid/support/v7/widget/RecyclerView;

    const/4 v0, 0x2

    if-ne p1, v0, :cond_0

    move v0, v1

    :goto_0
    invoke-virtual {v4, v0}, Landroid/support/v7/widget/RecyclerView;->setVisibility(I)V

    .line 183
    iget-object v4, p0, Lcom/salesforce/android/knowledge/ui/internal/search/SearchViewBinder;->h:Landroid/view/View;

    if-nez p1, :cond_1

    move v0, v1

    :goto_1
    invoke-virtual {v4, v0}, Landroid/view/View;->setVisibility(I)V

    .line 184
    iget-object v4, p0, Lcom/salesforce/android/knowledge/ui/internal/search/SearchViewBinder;->i:Landroid/view/View;

    const/4 v0, 0x1

    if-ne p1, v0, :cond_2

    move v0, v1

    :goto_2
    invoke-virtual {v4, v0}, Landroid/view/View;->setVisibility(I)V

    .line 185
    iget-object v4, p0, Lcom/salesforce/android/knowledge/ui/internal/search/SearchViewBinder;->j:Landroid/view/View;

    const/4 v0, 0x3

    if-ne p1, v0, :cond_3

    move v0, v1

    :goto_3
    invoke-virtual {v4, v0}, Landroid/view/View;->setVisibility(I)V

    .line 186
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/search/SearchViewBinder;->k:Landroid/view/View;

    if-ne p1, v2, :cond_4

    :goto_4
    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 187
    return-void

    :cond_0
    move v0, v2

    .line 182
    goto :goto_0

    :cond_1
    move v0, v3

    .line 183
    goto :goto_1

    :cond_2
    move v0, v3

    .line 184
    goto :goto_2

    :cond_3
    move v0, v3

    .line 185
    goto :goto_3

    :cond_4
    move v1, v3

    .line 186
    goto :goto_4
.end method

.method public a(Landroid/os/Bundle;)V
    .locals 2

    .prologue
    .line 142
    invoke-super {p0, p1}, Lcom/salesforce/android/knowledge/ui/internal/ViewBinder;->a(Landroid/os/Bundle;)V

    .line 143
    const-string v0, "layout_manager_state"

    iget-object v1, p0, Lcom/salesforce/android/knowledge/ui/internal/search/SearchViewBinder;->l:Landroid/support/v7/widget/RecyclerView;

    invoke-virtual {v1}, Landroid/support/v7/widget/RecyclerView;->getLayoutManager()Landroid/support/v7/widget/RecyclerView$LayoutManager;

    move-result-object v1

    invoke-virtual {v1}, Landroid/support/v7/widget/RecyclerView$LayoutManager;->d()Landroid/os/Parcelable;

    move-result-object v1

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 144
    return-void
.end method

.method public a(Landroid/text/Editable;)V
    .locals 1

    .prologue
    .line 219
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/search/SearchViewBinder;->b:Lcom/salesforce/android/knowledge/ui/internal/search/SearchPresenter;

    invoke-interface {v0, p1}, Lcom/salesforce/android/knowledge/ui/internal/search/SearchPresenter;->a(Ljava/lang/CharSequence;)V

    .line 220
    return-void
.end method

.method a(Landroid/view/View;)V
    .locals 3

    .prologue
    .line 123
    sget v0, Lcom/salesforce/android/knowledge/ui/R$id;->knowledge_search_input:I

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/EditText;

    iput-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/search/SearchViewBinder;->g:Landroid/widget/EditText;

    .line 124
    sget v0, Lcom/salesforce/android/knowledge/ui/R$id;->knowledge_search_help:I

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/search/SearchViewBinder;->h:Landroid/view/View;

    .line 125
    sget v0, Lcom/salesforce/android/knowledge/ui/R$id;->knowledge_search_empty:I

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/search/SearchViewBinder;->i:Landroid/view/View;

    .line 126
    sget v0, Lcom/salesforce/android/knowledge/ui/R$id;->knowledge_error:I

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/search/SearchViewBinder;->j:Landroid/view/View;

    .line 127
    sget v0, Lcom/salesforce/android/knowledge/ui/R$id;->knowledge_indeterminate_progress:I

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/search/SearchViewBinder;->k:Landroid/view/View;

    .line 128
    sget v0, Lcom/salesforce/android/knowledge/ui/R$id;->knowledge_search_list:I

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/support/v7/widget/RecyclerView;

    iput-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/search/SearchViewBinder;->l:Landroid/support/v7/widget/RecyclerView;

    .line 130
    new-instance v0, Landroid/support/v7/widget/LinearLayoutManager;

    invoke-virtual {p0}, Lcom/salesforce/android/knowledge/ui/internal/search/SearchViewBinder;->a()Landroid/content/Context;

    move-result-object v1

    invoke-direct {v0, v1}, Landroid/support/v7/widget/LinearLayoutManager;-><init>(Landroid/content/Context;)V

    .line 131
    invoke-static {v0}, Lcom/salesforce/android/knowledge/ui/internal/util/InfiniteScrollListener;->a(Landroid/support/v7/widget/LinearLayoutManager;)Lcom/salesforce/android/knowledge/ui/internal/util/InfiniteScrollListener;

    move-result-object v1

    const/4 v2, 0x2

    .line 132
    invoke-virtual {v1, v2}, Lcom/salesforce/android/knowledge/ui/internal/util/InfiniteScrollListener;->a(I)Lcom/salesforce/android/knowledge/ui/internal/util/InfiniteScrollListener;

    move-result-object v1

    .line 133
    invoke-virtual {v1, p0}, Lcom/salesforce/android/knowledge/ui/internal/util/InfiniteScrollListener;->a(Lcom/salesforce/android/knowledge/ui/internal/util/InfiniteScrollListener$BehaviorListener;)Lcom/salesforce/android/knowledge/ui/internal/util/InfiniteScrollListener;

    move-result-object v1

    iput-object v1, p0, Lcom/salesforce/android/knowledge/ui/internal/search/SearchViewBinder;->e:Lcom/salesforce/android/knowledge/ui/internal/util/InfiniteScrollListener;

    .line 134
    iget-object v1, p0, Lcom/salesforce/android/knowledge/ui/internal/search/SearchViewBinder;->l:Landroid/support/v7/widget/RecyclerView;

    invoke-virtual {v1, v0}, Landroid/support/v7/widget/RecyclerView;->setLayoutManager(Landroid/support/v7/widget/RecyclerView$LayoutManager;)V

    .line 135
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/search/SearchViewBinder;->l:Landroid/support/v7/widget/RecyclerView;

    iget-object v1, p0, Lcom/salesforce/android/knowledge/ui/internal/search/SearchViewBinder;->c:Lcom/salesforce/android/knowledge/ui/internal/search/SearchListController;

    invoke-virtual {v1}, Lcom/salesforce/android/knowledge/ui/internal/search/SearchListController;->c()Lcom/salesforce/android/knowledge/ui/internal/util/ListController$Adapter;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/support/v7/widget/RecyclerView;->setAdapter(Landroid/support/v7/widget/RecyclerView$Adapter;)V

    .line 136
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/search/SearchViewBinder;->l:Landroid/support/v7/widget/RecyclerView;

    iget-object v1, p0, Lcom/salesforce/android/knowledge/ui/internal/search/SearchViewBinder;->e:Lcom/salesforce/android/knowledge/ui/internal/util/InfiniteScrollListener;

    invoke-virtual {v0, v1}, Landroid/support/v7/widget/RecyclerView;->addOnScrollListener(Landroid/support/v7/widget/RecyclerView$OnScrollListener;)V

    .line 138
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/search/SearchViewBinder;->g:Landroid/widget/EditText;

    iget-object v1, p0, Lcom/salesforce/android/knowledge/ui/internal/search/SearchViewBinder;->d:Lcom/salesforce/android/service/common/ui/internal/text/SalesforceTextWatcher;

    invoke-virtual {v0, v1}, Landroid/widget/EditText;->addTextChangedListener(Landroid/text/TextWatcher;)V

    .line 139
    return-void
.end method

.method public a(Lcom/salesforce/android/knowledge/core/model/ArticleSummary;)V
    .locals 1

    .prologue
    .line 210
    invoke-direct {p0}, Lcom/salesforce/android/knowledge/ui/internal/search/SearchViewBinder;->f()V

    .line 211
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/search/SearchViewBinder;->b:Lcom/salesforce/android/knowledge/ui/internal/search/SearchPresenter;

    invoke-interface {v0, p1}, Lcom/salesforce/android/knowledge/ui/internal/search/SearchPresenter;->a(Lcom/salesforce/android/knowledge/core/model/ArticleSummary;)V

    .line 212
    return-void
.end method

.method public a(Ljava/lang/CharSequence;)V
    .locals 1

    .prologue
    .line 190
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/search/SearchViewBinder;->g:Landroid/widget/EditText;

    invoke-virtual {v0, p1}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 191
    return-void
.end method

.method public a(Ljava/util/List;Z)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/salesforce/android/knowledge/core/model/ArticleSummary;",
            ">;Z)V"
        }
    .end annotation

    .prologue
    .line 165
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/search/SearchViewBinder;->c:Lcom/salesforce/android/knowledge/ui/internal/search/SearchListController;

    invoke-virtual {v0, p1, p2}, Lcom/salesforce/android/knowledge/ui/internal/search/SearchListController;->a(Ljava/util/List;Z)V

    .line 166
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/search/SearchViewBinder;->e:Lcom/salesforce/android/knowledge/ui/internal/util/InfiniteScrollListener;

    invoke-virtual {v0, p2}, Lcom/salesforce/android/knowledge/ui/internal/util/InfiniteScrollListener;->a(Z)V

    .line 167
    return-void
.end method

.method public b()V
    .locals 1

    .prologue
    .line 155
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/search/SearchViewBinder;->l:Landroid/support/v7/widget/RecyclerView;

    invoke-virtual {v0}, Landroid/support/v7/widget/RecyclerView;->stopScroll()V

    .line 156
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/search/SearchViewBinder;->b:Lcom/salesforce/android/knowledge/ui/internal/search/SearchPresenter;

    invoke-interface {v0, p0}, Lcom/salesforce/android/knowledge/ui/internal/search/SearchPresenter;->a(Ljava/lang/Object;)V

    .line 157
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/search/SearchViewBinder;->c:Lcom/salesforce/android/knowledge/ui/internal/search/SearchListController;

    invoke-virtual {v0, p0}, Lcom/salesforce/android/knowledge/ui/internal/search/SearchListController;->b(Lcom/salesforce/android/knowledge/ui/internal/search/SearchListController$OnArticleSelectedListener;)V

    .line 158
    return-void
.end method

.method public b(Landroid/os/Bundle;)V
    .locals 2

    .prologue
    .line 147
    invoke-super {p0, p1}, Lcom/salesforce/android/knowledge/ui/internal/ViewBinder;->b(Landroid/os/Bundle;)V

    .line 148
    invoke-virtual {p1}, Landroid/os/Bundle;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_0

    .line 149
    const-string v0, "layout_manager_state"

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v0

    .line 150
    iget-object v1, p0, Lcom/salesforce/android/knowledge/ui/internal/search/SearchViewBinder;->l:Landroid/support/v7/widget/RecyclerView;

    invoke-virtual {v1}, Landroid/support/v7/widget/RecyclerView;->getLayoutManager()Landroid/support/v7/widget/RecyclerView$LayoutManager;

    move-result-object v1

    invoke-virtual {v1, v0}, Landroid/support/v7/widget/RecyclerView$LayoutManager;->a(Landroid/os/Parcelable;)V

    .line 152
    :cond_0
    return-void
.end method

.method public b(Ljava/util/List;Z)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/salesforce/android/knowledge/core/model/ArticleSummary;",
            ">;Z)V"
        }
    .end annotation

    .prologue
    .line 170
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/search/SearchViewBinder;->c:Lcom/salesforce/android/knowledge/ui/internal/search/SearchListController;

    invoke-virtual {v0, p1, p2}, Lcom/salesforce/android/knowledge/ui/internal/search/SearchListController;->b(Ljava/util/List;Z)V

    .line 171
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/search/SearchViewBinder;->e:Lcom/salesforce/android/knowledge/ui/internal/util/InfiniteScrollListener;

    invoke-virtual {v0, p2}, Lcom/salesforce/android/knowledge/ui/internal/util/InfiniteScrollListener;->a(Z)V

    .line 172
    return-void
.end method

.method public c()V
    .locals 1

    .prologue
    .line 175
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/search/SearchViewBinder;->c:Lcom/salesforce/android/knowledge/ui/internal/search/SearchListController;

    invoke-virtual {v0}, Lcom/salesforce/android/knowledge/ui/internal/search/SearchListController;->b()V

    .line 176
    return-void
.end method

.method public s_()V
    .locals 1

    .prologue
    .line 202
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/search/SearchViewBinder;->b:Lcom/salesforce/android/knowledge/ui/internal/search/SearchPresenter;

    invoke-interface {v0}, Lcom/salesforce/android/knowledge/ui/internal/search/SearchPresenter;->a()V

    .line 203
    return-void
.end method
