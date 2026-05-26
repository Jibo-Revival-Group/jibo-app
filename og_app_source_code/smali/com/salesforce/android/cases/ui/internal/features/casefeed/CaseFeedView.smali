.class public Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedView;
.super Landroid/support/design/widget/CoordinatorLayout;
.source "CaseFeedView.java"

# interfaces
.implements Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedContract$View;
.implements Lcom/salesforce/android/service/common/ui/internal/text/SalesforceTextWatcher$OnAfterTextChangedListener;


# instance fields
.field f:Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedContract$Presenter;

.field g:Lcom/salesforce/android/service/common/ui/views/SalesforceProgressSpinner;

.field h:Landroid/view/View;

.field i:Landroid/view/ViewGroup;

.field j:Landroid/view/ViewGroup;

.field k:Lcom/salesforce/android/service/common/ui/views/SalesforceTitleTextToolbar;

.field l:Landroid/support/v4/widget/SwipeRefreshLayout;

.field m:Landroid/widget/EditText;

.field n:Landroid/view/View;

.field o:Lcom/salesforce/android/service/common/ui/internal/messaging/MessageFeedAdapter;

.field p:Landroid/support/v7/widget/RecyclerView;

.field q:Lcom/salesforce/android/service/common/ui/internal/text/SalesforceTextWatcher;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 1

    .prologue
    .line 80
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 81
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 1

    .prologue
    .line 84
    const/4 v0, 0x0

    invoke-direct {p0, p1, p2, v0}, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 85
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    .locals 0

    .prologue
    .line 88
    invoke-direct {p0, p1, p2, p3}, Landroid/support/design/widget/CoordinatorLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 89
    invoke-direct {p0, p1}, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedView;->a(Landroid/content/Context;)V

    .line 90
    return-void
.end method

.method private a(Landroid/content/Context;)V
    .locals 5

    .prologue
    const/4 v4, 0x0

    .line 210
    invoke-static {p1}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v0

    sget v1, Lcom/salesforce/android/cases/R$layout;->case_feed_view:I

    const/4 v2, 0x1

    invoke-virtual {v0, v1, p0, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    .line 213
    sget v0, Lcom/salesforce/android/cases/R$id;->toolbar:I

    invoke-virtual {p0, v0}, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/salesforce/android/service/common/ui/views/SalesforceTitleTextToolbar;

    iput-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedView;->k:Lcom/salesforce/android/service/common/ui/views/SalesforceTitleTextToolbar;

    .line 214
    sget v0, Lcom/salesforce/android/cases/R$id;->case_feed_container:I

    invoke-virtual {p0, v0}, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedView;->h:Landroid/view/View;

    .line 215
    sget v0, Lcom/salesforce/android/cases/R$id;->recycler_view:I

    invoke-virtual {p0, v0}, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/support/v7/widget/RecyclerView;

    iput-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedView;->p:Landroid/support/v7/widget/RecyclerView;

    .line 216
    sget v0, Lcom/salesforce/android/cases/R$id;->progress_spinner:I

    invoke-virtual {p0, v0}, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/salesforce/android/service/common/ui/views/SalesforceProgressSpinner;

    iput-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedView;->g:Lcom/salesforce/android/service/common/ui/views/SalesforceProgressSpinner;

    .line 217
    sget v0, Lcom/salesforce/android/cases/R$id;->case_generic_error_view:I

    invoke-virtual {p0, v0}, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/view/ViewGroup;

    iput-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedView;->i:Landroid/view/ViewGroup;

    .line 218
    sget v0, Lcom/salesforce/android/cases/R$id;->case_network_error_view:I

    invoke-virtual {p0, v0}, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/view/ViewGroup;

    iput-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedView;->j:Landroid/view/ViewGroup;

    .line 219
    sget v0, Lcom/salesforce/android/cases/R$id;->salesforce_message_input:I

    invoke-virtual {p0, v0}, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/EditText;

    iput-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedView;->m:Landroid/widget/EditText;

    .line 220
    sget v0, Lcom/salesforce/android/cases/R$id;->salesforce_send_message_button:I

    invoke-virtual {p0, v0}, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedView;->n:Landroid/view/View;

    .line 222
    new-instance v0, Lcom/salesforce/android/service/common/ui/internal/text/SalesforceTextWatcher;

    invoke-direct {v0}, Lcom/salesforce/android/service/common/ui/internal/text/SalesforceTextWatcher;-><init>()V

    iput-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedView;->q:Lcom/salesforce/android/service/common/ui/internal/text/SalesforceTextWatcher;

    .line 223
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedView;->q:Lcom/salesforce/android/service/common/ui/internal/text/SalesforceTextWatcher;

    invoke-virtual {v0, p0}, Lcom/salesforce/android/service/common/ui/internal/text/SalesforceTextWatcher;->a(Lcom/salesforce/android/service/common/ui/internal/text/SalesforceTextWatcher$OnAfterTextChangedListener;)V

    .line 225
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedView;->m:Landroid/widget/EditText;

    if-eqz v0, :cond_0

    .line 227
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedView;->m:Landroid/widget/EditText;

    invoke-virtual {v0}, Landroid/widget/EditText;->getBackground()Landroid/graphics/drawable/Drawable;

    move-result-object v0

    .line 228
    invoke-virtual {p1}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    sget v2, Lcom/salesforce/android/cases/R$color;->salesforce_contrast_secondary:I

    invoke-static {v1, v2}, Landroid/support/v4/content/ContextCompat;->c(Landroid/content/Context;I)I

    move-result v1

    sget-object v2, Landroid/graphics/PorterDuff$Mode;->SRC_IN:Landroid/graphics/PorterDuff$Mode;

    invoke-virtual {v0, v1, v2}, Landroid/graphics/drawable/Drawable;->setColorFilter(ILandroid/graphics/PorterDuff$Mode;)V

    .line 233
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedView;->m:Landroid/widget/EditText;

    invoke-virtual {v0}, Landroid/widget/EditText;->getBackground()Landroid/graphics/drawable/Drawable;

    move-result-object v0

    .line 238
    iget-object v1, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedView;->m:Landroid/widget/EditText;

    invoke-virtual {v1, v4}, Landroid/widget/EditText;->setHorizontallyScrolling(Z)V

    .line 239
    iget-object v1, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedView;->m:Landroid/widget/EditText;

    const v2, 0x7fffffff

    invoke-virtual {v1, v2}, Landroid/widget/EditText;->setMaxLines(I)V

    .line 241
    iget-object v1, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedView;->m:Landroid/widget/EditText;

    iget-object v2, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedView;->q:Lcom/salesforce/android/service/common/ui/internal/text/SalesforceTextWatcher;

    invoke-virtual {v1, v2}, Landroid/widget/EditText;->addTextChangedListener(Landroid/text/TextWatcher;)V

    .line 243
    iget-object v1, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedView;->m:Landroid/widget/EditText;

    new-instance v2, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedView$2;

    invoke-direct {v2, p0}, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedView$2;-><init>(Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedView;)V

    invoke-virtual {v1, v2}, Landroid/widget/EditText;->setOnEditorActionListener(Landroid/widget/TextView$OnEditorActionListener;)V

    .line 254
    iget-object v1, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedView;->m:Landroid/widget/EditText;

    new-instance v2, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedView$3;

    invoke-direct {v2, p0, p1, v0}, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedView$3;-><init>(Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedView;Landroid/content/Context;Landroid/graphics/drawable/Drawable;)V

    invoke-virtual {v1, v2}, Landroid/widget/EditText;->setOnFocusChangeListener(Landroid/view/View$OnFocusChangeListener;)V

    .line 266
    :cond_0
    sget v0, Lcom/salesforce/android/cases/R$id;->swipe_refresh_layout:I

    invoke-virtual {p0, v0}, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/support/v4/widget/SwipeRefreshLayout;

    iput-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedView;->l:Landroid/support/v4/widget/SwipeRefreshLayout;

    .line 267
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedView;->l:Landroid/support/v4/widget/SwipeRefreshLayout;

    if-eqz v0, :cond_1

    .line 268
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedView;->l:Landroid/support/v4/widget/SwipeRefreshLayout;

    new-instance v1, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedView$4;

    invoke-direct {v1, p0}, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedView$4;-><init>(Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedView;)V

    invoke-virtual {v0, v1}, Landroid/support/v4/widget/SwipeRefreshLayout;->setOnRefreshListener(Landroid/support/v4/widget/SwipeRefreshLayout$OnRefreshListener;)V

    .line 276
    :cond_1
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedView;->k:Lcom/salesforce/android/service/common/ui/views/SalesforceTitleTextToolbar;

    if-eqz v0, :cond_2

    .line 277
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedView;->k:Lcom/salesforce/android/service/common/ui/views/SalesforceTitleTextToolbar;

    .line 278
    invoke-virtual {p0}, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedView;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    sget v2, Lcom/salesforce/android/cases/R$drawable;->cases_ic_arrow_back:I

    const/4 v3, 0x0

    invoke-static {v1, v2, v3}, Landroid/support/graphics/drawable/VectorDrawableCompat;->a(Landroid/content/res/Resources;ILandroid/content/res/Resources$Theme;)Landroid/support/graphics/drawable/VectorDrawableCompat;

    move-result-object v1

    .line 277
    invoke-virtual {v0, v1}, Lcom/salesforce/android/service/common/ui/views/SalesforceTitleTextToolbar;->setNavigationIcon(Landroid/graphics/drawable/Drawable;)V

    .line 279
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedView;->k:Lcom/salesforce/android/service/common/ui/views/SalesforceTitleTextToolbar;

    new-instance v1, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedView$5;

    invoke-direct {v1, p0}, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedView$5;-><init>(Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedView;)V

    invoke-virtual {v0, v1}, Lcom/salesforce/android/service/common/ui/views/SalesforceTitleTextToolbar;->setNavigationOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 284
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedView;->k:Lcom/salesforce/android/service/common/ui/views/SalesforceTitleTextToolbar;

    sget v1, Lcom/salesforce/android/cases/R$string;->cases_navigate_back_content_description:I

    invoke-virtual {v0, v1}, Lcom/salesforce/android/service/common/ui/views/SalesforceTitleTextToolbar;->setNavigationContentDescription(I)V

    .line 287
    :cond_2
    new-instance v0, Lcom/salesforce/android/service/common/ui/internal/messaging/MessageFeedAdapter$Builder;

    invoke-direct {v0}, Lcom/salesforce/android/service/common/ui/internal/messaging/MessageFeedAdapter$Builder;-><init>()V

    new-instance v1, Lcom/salesforce/android/cases/ui/internal/features/casefeed/adapter/MessageViewFactory;

    invoke-direct {v1}, Lcom/salesforce/android/cases/ui/internal/features/casefeed/adapter/MessageViewFactory;-><init>()V

    .line 288
    invoke-virtual {v0, v1}, Lcom/salesforce/android/service/common/ui/internal/messaging/MessageFeedAdapter$Builder;->a(Lcom/salesforce/android/service/common/ui/internal/messaging/ViewHolderFactory;)Lcom/salesforce/android/service/common/ui/internal/messaging/MessageFeedAdapter$Builder;

    move-result-object v0

    new-instance v1, Lcom/salesforce/android/service/common/ui/internal/android/LayoutInflaterFactory;

    invoke-direct {v1}, Lcom/salesforce/android/service/common/ui/internal/android/LayoutInflaterFactory;-><init>()V

    .line 289
    invoke-virtual {v0, v1}, Lcom/salesforce/android/service/common/ui/internal/messaging/MessageFeedAdapter$Builder;->a(Lcom/salesforce/android/service/common/ui/internal/android/LayoutInflaterFactory;)Lcom/salesforce/android/service/common/ui/internal/messaging/MessageFeedAdapter$Builder;

    move-result-object v0

    .line 290
    invoke-virtual {v0}, Lcom/salesforce/android/service/common/ui/internal/messaging/MessageFeedAdapter$Builder;->a()Lcom/salesforce/android/service/common/ui/internal/messaging/MessageFeedAdapter;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedView;->o:Lcom/salesforce/android/service/common/ui/internal/messaging/MessageFeedAdapter;

    .line 292
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedView;->p:Landroid/support/v7/widget/RecyclerView;

    if-eqz v0, :cond_3

    .line 293
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedView;->o:Lcom/salesforce/android/service/common/ui/internal/messaging/MessageFeedAdapter;

    iget-object v1, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedView;->p:Landroid/support/v7/widget/RecyclerView;

    invoke-virtual {v0, v1}, Lcom/salesforce/android/service/common/ui/internal/messaging/MessageFeedAdapter;->a(Landroid/support/v7/widget/RecyclerView;)V

    .line 296
    :cond_3
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedView;->n:Landroid/view/View;

    if-eqz v0, :cond_4

    .line 297
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedView;->n:Landroid/view/View;

    invoke-virtual {v0, v4}, Landroid/view/View;->setEnabled(Z)V

    .line 298
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedView;->n:Landroid/view/View;

    new-instance v1, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedView$6;

    invoke-direct {v1, p0}, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedView$6;-><init>(Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedView;)V

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 304
    :cond_4
    return-void
.end method

.method static synthetic a(Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedView;)V
    .locals 0

    .prologue
    .line 63
    invoke-direct {p0}, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedView;->q()V

    return-void
.end method

.method private q()V
    .locals 1

    .prologue
    .line 313
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedView;->m:Landroid/widget/EditText;

    invoke-virtual {v0}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    .line 314
    invoke-virtual {p0, v0}, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedView;->a(Ljava/lang/String;)V

    .line 315
    return-void
.end method


# virtual methods
.method public a(Landroid/text/Editable;)V
    .locals 2

    .prologue
    .line 204
    invoke-interface {p1}, Landroid/text/Editable;->length()I

    move-result v0

    if-lez v0, :cond_0

    const/4 v0, 0x1

    .line 205
    :goto_0
    iget-object v1, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedView;->n:Landroid/view/View;

    invoke-virtual {v1, v0}, Landroid/view/View;->setEnabled(Z)V

    .line 206
    return-void

    .line 204
    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public a(Ljava/lang/Object;)V
    .locals 2

    .prologue
    .line 160
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedView;->o:Lcom/salesforce/android/service/common/ui/internal/messaging/MessageFeedAdapter;

    invoke-virtual {v0, p1}, Lcom/salesforce/android/service/common/ui/internal/messaging/MessageFeedAdapter;->a(Ljava/lang/Object;)V

    .line 161
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedView;->p:Landroid/support/v7/widget/RecyclerView;

    invoke-virtual {v0}, Landroid/support/v7/widget/RecyclerView;->getLayoutManager()Landroid/support/v7/widget/RecyclerView$LayoutManager;

    move-result-object v0

    iget-object v1, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedView;->o:Lcom/salesforce/android/service/common/ui/internal/messaging/MessageFeedAdapter;

    invoke-virtual {v1}, Lcom/salesforce/android/service/common/ui/internal/messaging/MessageFeedAdapter;->getItemCount()I

    move-result v1

    add-int/lit8 v1, v1, -0x1

    invoke-virtual {v0, v1}, Landroid/support/v7/widget/RecyclerView$LayoutManager;->e(I)V

    .line 162
    return-void
.end method

.method a(Ljava/lang/String;)V
    .locals 1

    .prologue
    .line 307
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedView;->f:Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedContract$Presenter;

    if-eqz v0, :cond_0

    invoke-static {p1}, Lcom/salesforce/android/cases/core/internal/util/StringUtils;->b(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 308
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedView;->f:Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedContract$Presenter;

    invoke-interface {v0, p1}, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedContract$Presenter;->a(Ljava/lang/String;)V

    .line 310
    :cond_0
    return-void
.end method

.method public a(Ljava/util/List;)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Ljava/lang/Object;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 137
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedView;->o:Lcom/salesforce/android/service/common/ui/internal/messaging/MessageFeedAdapter;

    invoke-virtual {v0}, Lcom/salesforce/android/service/common/ui/internal/messaging/MessageFeedAdapter;->a()V

    .line 138
    invoke-interface {p1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_0

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    .line 139
    invoke-virtual {p0, v1}, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedView;->a(Ljava/lang/Object;)V

    goto :goto_0

    .line 141
    :cond_0
    return-void
.end method

.method public e()V
    .locals 1

    .prologue
    .line 109
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedView;->i:Landroid/view/ViewGroup;

    invoke-static {v0}, Lcom/salesforce/android/cases/ui/internal/utils/ViewUtils;->c(Landroid/view/View;)V

    .line 110
    return-void
.end method

.method public f()V
    .locals 1

    .prologue
    .line 113
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedView;->j:Landroid/view/ViewGroup;

    invoke-static {v0}, Lcom/salesforce/android/cases/ui/internal/utils/ViewUtils;->c(Landroid/view/View;)V

    .line 114
    return-void
.end method

.method public g()V
    .locals 1

    .prologue
    .line 117
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedView;->i:Landroid/view/ViewGroup;

    invoke-static {v0}, Lcom/salesforce/android/cases/ui/internal/utils/ViewUtils;->b(Landroid/view/View;)V

    .line 118
    return-void
.end method

.method public getApplicationContext()Landroid/content/Context;
    .locals 1

    .prologue
    .line 152
    invoke-virtual {p0}, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedView;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    return-object v0
.end method

.method public h()V
    .locals 1

    .prologue
    .line 121
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedView;->j:Landroid/view/ViewGroup;

    invoke-static {v0}, Lcom/salesforce/android/cases/ui/internal/utils/ViewUtils;->b(Landroid/view/View;)V

    .line 122
    return-void
.end method

.method public h_()V
    .locals 1

    .prologue
    .line 93
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedView;->g:Lcom/salesforce/android/service/common/ui/views/SalesforceProgressSpinner;

    invoke-static {v0}, Lcom/salesforce/android/cases/ui/internal/utils/ViewUtils;->b(Landroid/view/View;)V

    .line 94
    return-void
.end method

.method public i()V
    .locals 2

    .prologue
    .line 148
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedView;->l:Landroid/support/v4/widget/SwipeRefreshLayout;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/support/v4/widget/SwipeRefreshLayout;->setRefreshing(Z)V

    .line 149
    return-void
.end method

.method public i_()V
    .locals 1

    .prologue
    .line 97
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedView;->g:Lcom/salesforce/android/service/common/ui/views/SalesforceProgressSpinner;

    invoke-static {v0}, Lcom/salesforce/android/cases/ui/internal/utils/ViewUtils;->c(Landroid/view/View;)V

    .line 98
    return-void
.end method

.method public j()V
    .locals 2

    .prologue
    .line 165
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedView;->m:Landroid/widget/EditText;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Landroid/widget/EditText;->setEnabled(Z)V

    .line 166
    return-void
.end method

.method public j_()V
    .locals 1

    .prologue
    .line 101
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedView;->h:Landroid/view/View;

    invoke-static {v0}, Lcom/salesforce/android/cases/ui/internal/utils/ViewUtils;->b(Landroid/view/View;)V

    .line 102
    return-void
.end method

.method public k()V
    .locals 4

    .prologue
    .line 181
    sget v0, Lcom/salesforce/android/cases/R$string;->cases_post_comment_error_snackbar_text:I

    const/4 v1, -0x2

    .line 182
    invoke-static {p0, v0, v1}, Landroid/support/design/widget/Snackbar;->a(Landroid/view/View;II)Landroid/support/design/widget/Snackbar;

    move-result-object v0

    .line 184
    invoke-virtual {p0}, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedView;->getContext()Landroid/content/Context;

    move-result-object v1

    sget v2, Lcom/salesforce/android/cases/R$color;->cases_error_snackbar_action_text_color:I

    invoke-static {v1, v2}, Landroid/support/v4/content/ContextCompat;->c(Landroid/content/Context;I)I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/support/design/widget/Snackbar;->e(I)Landroid/support/design/widget/Snackbar;

    move-result-object v0

    sget v1, Lcom/salesforce/android/cases/R$string;->cases_snackbar_retry_action_text:I

    new-instance v2, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedView$1;

    invoke-direct {v2, p0}, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedView$1;-><init>(Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedView;)V

    .line 186
    invoke-virtual {v0, v1, v2}, Landroid/support/design/widget/Snackbar;->a(ILandroid/view/View$OnClickListener;)Landroid/support/design/widget/Snackbar;

    move-result-object v0

    .line 194
    invoke-virtual {p0}, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedView;->getContext()Landroid/content/Context;

    move-result-object v1

    sget v2, Lcom/salesforce/android/cases/R$color;->cases_error_snackbar_background_color:I

    invoke-static {v1, v2}, Landroid/support/v4/content/ContextCompat;->c(Landroid/content/Context;I)I

    move-result v1

    .line 195
    invoke-virtual {p0}, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedView;->getContext()Landroid/content/Context;

    move-result-object v2

    sget v3, Lcom/salesforce/android/cases/R$color;->cases_error_snackbar_text_color:I

    invoke-static {v2, v3}, Landroid/support/v4/content/ContextCompat;->c(Landroid/content/Context;I)I

    move-result v2

    .line 193
    invoke-static {v0, v1, v2}, Lcom/salesforce/android/cases/ui/internal/utils/ViewUtils;->a(Landroid/support/design/widget/Snackbar;II)V

    .line 196
    invoke-virtual {v0}, Landroid/support/design/widget/Snackbar;->c()V

    .line 197
    return-void
.end method

.method public k_()V
    .locals 1

    .prologue
    .line 105
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedView;->h:Landroid/view/View;

    invoke-static {v0}, Lcom/salesforce/android/cases/ui/internal/utils/ViewUtils;->c(Landroid/view/View;)V

    .line 106
    return-void
.end method

.method public l()V
    .locals 2

    .prologue
    .line 169
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedView;->n:Landroid/view/View;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/view/View;->setEnabled(Z)V

    .line 170
    return-void
.end method

.method public m()V
    .locals 2

    .prologue
    .line 173
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedView;->n:Landroid/view/View;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Landroid/view/View;->setEnabled(Z)V

    .line 174
    return-void
.end method

.method public n()V
    .locals 2

    .prologue
    .line 177
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedView;->m:Landroid/widget/EditText;

    const-string v1, ""

    invoke-virtual {v0, v1}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 178
    return-void
.end method

.method public o()V
    .locals 0

    .prologue
    .line 200
    invoke-static {p0}, Lcom/salesforce/android/cases/ui/internal/utils/ViewUtils;->a(Landroid/view/View;)V

    .line 201
    return-void
.end method

.method public p()V
    .locals 1

    .prologue
    .line 156
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedView;->f:Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedContract$Presenter;

    invoke-interface {v0}, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedContract$Presenter;->a()V

    .line 157
    return-void
.end method

.method public setCaseId(Ljava/lang/String;)V
    .locals 2

    .prologue
    .line 129
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedView;->f:Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedContract$Presenter;

    if-eqz v0, :cond_0

    if-eqz p1, :cond_0

    .line 130
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedView;->f:Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedContract$Presenter;

    invoke-interface {v0, p1}, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedContract$Presenter;->a(Ljava/lang/Object;)V

    .line 134
    return-void

    .line 132
    :cond_0
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "CaseFeedContract.Presenter and caseId cannot be null."

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public setPresenter(Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedContract$Presenter;)V
    .locals 0

    .prologue
    .line 125
    iput-object p1, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedView;->f:Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedContract$Presenter;

    .line 126
    return-void
.end method

.method public setTitle(Ljava/lang/String;)V
    .locals 1

    .prologue
    .line 144
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedView;->k:Lcom/salesforce/android/service/common/ui/views/SalesforceTitleTextToolbar;

    invoke-virtual {v0, p1}, Lcom/salesforce/android/service/common/ui/views/SalesforceTitleTextToolbar;->setTitleText(Ljava/lang/CharSequence;)V

    .line 145
    return-void
.end method
