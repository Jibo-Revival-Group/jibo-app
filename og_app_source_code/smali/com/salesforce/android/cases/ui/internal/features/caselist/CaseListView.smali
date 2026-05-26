.class public Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView;
.super Landroid/support/design/widget/CoordinatorLayout;
.source "CaseListView.java"

# interfaces
.implements Landroid/support/v4/widget/SwipeRefreshLayout$OnRefreshListener;
.implements Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListContract$View;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView$SwipeCallback;
    }
.end annotation


# instance fields
.field f:Lcom/salesforce/android/service/common/ui/views/SalesforceTitleTextToolbar;

.field g:Lcom/salesforce/android/service/common/ui/views/SalesforceProgressSpinner;

.field h:Landroid/support/v4/widget/SwipeRefreshLayout;

.field i:Landroid/support/v7/widget/RecyclerView;

.field j:Landroid/view/ViewGroup;

.field k:Landroid/view/ViewGroup;

.field l:Landroid/view/ViewGroup;

.field m:Landroid/support/design/widget/Snackbar;

.field n:Landroid/support/design/widget/Snackbar;

.field o:Landroid/support/design/widget/Snackbar;

.field p:Landroid/support/design/widget/FloatingActionButton;

.field q:Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListAdapter;

.field private r:Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListContract$Presenter;

.field private s:I


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 1

    .prologue
    .line 86
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 87
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 1

    .prologue
    .line 90
    const/4 v0, 0x0

    invoke-direct {p0, p1, p2, v0}, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 91
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    .locals 0

    .prologue
    .line 94
    invoke-direct {p0, p1, p2, p3}, Landroid/support/design/widget/CoordinatorLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 95
    invoke-direct {p0, p1, p2, p3}, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView;->a(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 96
    return-void
.end method

.method static synthetic a(Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView;I)I
    .locals 0

    .prologue
    .line 62
    iput p1, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView;->s:I

    return p1
.end method

.method static synthetic a(Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView;)Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListContract$Presenter;
    .locals 1

    .prologue
    .line 62
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView;->r:Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListContract$Presenter;

    return-object v0
.end method

.method private a(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    .locals 5

    .prologue
    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 318
    invoke-virtual {p1}, Landroid/content/Context;->getTheme()Landroid/content/res/Resources$Theme;

    move-result-object v0

    new-array v1, v4, [I

    sget v2, Lcom/salesforce/android/cases/R$attr;->colorControlNormal:I

    aput v2, v1, v3

    .line 319
    invoke-virtual {v0, p2, v1, p3, v3}, Landroid/content/res/Resources$Theme;->obtainStyledAttributes(Landroid/util/AttributeSet;[III)Landroid/content/res/TypedArray;

    move-result-object v0

    .line 320
    invoke-virtual {v0}, Landroid/content/res/TypedArray;->recycle()V

    .line 322
    invoke-static {p1}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v0

    sget v1, Lcom/salesforce/android/cases/R$layout;->case_list_view:I

    invoke-virtual {v0, v1, p0, v4}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    .line 324
    sget v0, Lcom/salesforce/android/cases/R$id;->toolbar:I

    invoke-virtual {p0, v0}, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/salesforce/android/service/common/ui/views/SalesforceTitleTextToolbar;

    iput-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView;->f:Lcom/salesforce/android/service/common/ui/views/SalesforceTitleTextToolbar;

    .line 325
    sget v0, Lcom/salesforce/android/cases/R$id;->progress_spinner:I

    invoke-virtual {p0, v0}, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/salesforce/android/service/common/ui/views/SalesforceProgressSpinner;

    iput-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView;->g:Lcom/salesforce/android/service/common/ui/views/SalesforceProgressSpinner;

    .line 326
    sget v0, Lcom/salesforce/android/cases/R$id;->case_list_swipe_refresh:I

    invoke-virtual {p0, v0}, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/support/v4/widget/SwipeRefreshLayout;

    iput-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView;->h:Landroid/support/v4/widget/SwipeRefreshLayout;

    .line 327
    sget v0, Lcom/salesforce/android/cases/R$id;->case_list_recycler:I

    invoke-virtual {p0, v0}, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/support/v7/widget/RecyclerView;

    iput-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView;->i:Landroid/support/v7/widget/RecyclerView;

    .line 328
    sget v0, Lcom/salesforce/android/cases/R$id;->case_list_empty_view:I

    invoke-virtual {p0, v0}, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/view/ViewGroup;

    iput-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView;->j:Landroid/view/ViewGroup;

    .line 329
    sget v0, Lcom/salesforce/android/cases/R$id;->case_generic_error_view:I

    invoke-virtual {p0, v0}, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/view/ViewGroup;

    iput-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView;->k:Landroid/view/ViewGroup;

    .line 330
    sget v0, Lcom/salesforce/android/cases/R$id;->case_network_error_view:I

    invoke-virtual {p0, v0}, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/view/ViewGroup;

    iput-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView;->l:Landroid/view/ViewGroup;

    .line 331
    sget v0, Lcom/salesforce/android/cases/R$id;->create_case_button:I

    invoke-virtual {p0, v0}, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/support/design/widget/FloatingActionButton;

    iput-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView;->p:Landroid/support/design/widget/FloatingActionButton;

    .line 333
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView;->p:Landroid/support/design/widget/FloatingActionButton;

    if-eqz v0, :cond_0

    .line 334
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView;->p:Landroid/support/design/widget/FloatingActionButton;

    new-instance v1, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView$6;

    invoke-direct {v1, p0}, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView$6;-><init>(Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView;)V

    invoke-virtual {v0, v1}, Landroid/support/design/widget/FloatingActionButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 341
    :cond_0
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView;->f:Lcom/salesforce/android/service/common/ui/views/SalesforceTitleTextToolbar;

    if-eqz v0, :cond_1

    .line 342
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView;->f:Lcom/salesforce/android/service/common/ui/views/SalesforceTitleTextToolbar;

    .line 343
    invoke-virtual {p0}, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    sget v2, Lcom/salesforce/android/cases/R$drawable;->cases_ic_clear:I

    const/4 v3, 0x0

    invoke-static {v1, v2, v3}, Landroid/support/graphics/drawable/VectorDrawableCompat;->a(Landroid/content/res/Resources;ILandroid/content/res/Resources$Theme;)Landroid/support/graphics/drawable/VectorDrawableCompat;

    move-result-object v1

    .line 342
    invoke-virtual {v0, v1}, Lcom/salesforce/android/service/common/ui/views/SalesforceTitleTextToolbar;->setNavigationIcon(Landroid/graphics/drawable/Drawable;)V

    .line 344
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView;->f:Lcom/salesforce/android/service/common/ui/views/SalesforceTitleTextToolbar;

    new-instance v1, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView$7;

    invoke-direct {v1, p0}, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView$7;-><init>(Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView;)V

    invoke-virtual {v0, v1}, Lcom/salesforce/android/service/common/ui/views/SalesforceTitleTextToolbar;->setNavigationOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 349
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView;->f:Lcom/salesforce/android/service/common/ui/views/SalesforceTitleTextToolbar;

    sget v1, Lcom/salesforce/android/cases/R$string;->cases_close_button_text:I

    invoke-virtual {v0, v1}, Lcom/salesforce/android/service/common/ui/views/SalesforceTitleTextToolbar;->setNavigationContentDescription(I)V

    .line 352
    :cond_1
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView;->k:Landroid/view/ViewGroup;

    if-eqz v0, :cond_2

    .line 353
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView;->k:Landroid/view/ViewGroup;

    sget v1, Lcom/salesforce/android/cases/R$id;->case_generic_error_message:I

    .line 354
    invoke-virtual {v0, v1}, Landroid/view/ViewGroup;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    .line 355
    sget v1, Lcom/salesforce/android/cases/R$string;->cases_list_view_error_subtitle_text:I

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(I)V

    .line 358
    :cond_2
    invoke-direct {p0}, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView;->s()V

    .line 359
    invoke-direct {p0}, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView;->u()V

    .line 360
    return-void
.end method

.method private a(Landroid/support/design/widget/Snackbar;)V
    .locals 3

    .prologue
    .line 309
    .line 310
    invoke-virtual {p0}, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView;->getContext()Landroid/content/Context;

    move-result-object v0

    sget v1, Lcom/salesforce/android/cases/R$color;->cases_error_snackbar_background_color:I

    invoke-static {v0, v1}, Landroid/support/v4/content/ContextCompat;->c(Landroid/content/Context;I)I

    move-result v0

    .line 311
    invoke-virtual {p0}, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView;->getContext()Landroid/content/Context;

    move-result-object v1

    sget v2, Lcom/salesforce/android/cases/R$color;->cases_error_snackbar_text_color:I

    invoke-static {v1, v2}, Landroid/support/v4/content/ContextCompat;->c(Landroid/content/Context;I)I

    move-result v1

    .line 309
    invoke-static {p1, v0, v1}, Lcom/salesforce/android/cases/ui/internal/utils/ViewUtils;->a(Landroid/support/design/widget/Snackbar;II)V

    .line 312
    invoke-virtual {p1}, Landroid/support/design/widget/Snackbar;->c()V

    .line 313
    return-void
.end method

.method static synthetic b(Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView;)V
    .locals 0

    .prologue
    .line 62
    invoke-direct {p0}, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView;->t()V

    return-void
.end method

.method private s()V
    .locals 1

    .prologue
    .line 363
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView;->h:Landroid/support/v4/widget/SwipeRefreshLayout;

    if-eqz v0, :cond_0

    .line 364
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView;->h:Landroid/support/v4/widget/SwipeRefreshLayout;

    invoke-virtual {v0, p0}, Landroid/support/v4/widget/SwipeRefreshLayout;->setOnRefreshListener(Landroid/support/v4/widget/SwipeRefreshLayout$OnRefreshListener;)V

    .line 366
    :cond_0
    return-void
.end method

.method private t()V
    .locals 2

    .prologue
    .line 369
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView;->i:Landroid/support/v7/widget/RecyclerView;

    invoke-virtual {v0}, Landroid/support/v7/widget/RecyclerView;->getLayoutManager()Landroid/support/v7/widget/RecyclerView$LayoutManager;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/support/v7/widget/RecyclerView$LayoutManager;->e(I)V

    .line 370
    return-void
.end method

.method private u()V
    .locals 6

    .prologue
    const/4 v5, 0x0

    .line 373
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView;->i:Landroid/support/v7/widget/RecyclerView;

    if-eqz v0, :cond_0

    .line 374
    invoke-virtual {p0}, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    .line 375
    iget-object v1, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView;->i:Landroid/support/v7/widget/RecyclerView;

    new-instance v2, Landroid/support/v7/widget/LinearLayoutManager;

    .line 376
    invoke-virtual {p0}, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView;->getContext()Landroid/content/Context;

    move-result-object v3

    const/4 v4, 0x1

    invoke-direct {v2, v3, v4, v5}, Landroid/support/v7/widget/LinearLayoutManager;-><init>(Landroid/content/Context;IZ)V

    .line 375
    invoke-virtual {v1, v2}, Landroid/support/v7/widget/RecyclerView;->setLayoutManager(Landroid/support/v7/widget/RecyclerView$LayoutManager;)V

    .line 377
    iget-object v1, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView;->i:Landroid/support/v7/widget/RecyclerView;

    new-instance v2, Lcom/salesforce/android/cases/ui/internal/utils/VerticalDividerItemDecoration;

    .line 378
    invoke-virtual {p0}, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView;->getContext()Landroid/content/Context;

    move-result-object v3

    sget v4, Lcom/salesforce/android/cases/R$drawable;->cases_list_divider:I

    invoke-static {v3, v4}, Landroid/support/v4/content/ContextCompat;->a(Landroid/content/Context;I)Landroid/graphics/drawable/Drawable;

    move-result-object v3

    sget v4, Lcom/salesforce/android/cases/R$dimen;->cases_case_list_divider_left_padding:I

    .line 379
    invoke-virtual {v0, v4}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v0

    invoke-direct {v2, v3, v0, v5}, Lcom/salesforce/android/cases/ui/internal/utils/VerticalDividerItemDecoration;-><init>(Landroid/graphics/drawable/Drawable;II)V

    .line 377
    invoke-virtual {v1, v2}, Landroid/support/v7/widget/RecyclerView;->addItemDecoration(Landroid/support/v7/widget/RecyclerView$ItemDecoration;)V

    .line 380
    new-instance v0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView$8;

    invoke-virtual {p0}, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-direct {v0, p0, v1}, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView$8;-><init>(Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView;Landroid/content/Context;)V

    iput-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView;->q:Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListAdapter;

    .line 385
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView;->q:Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListAdapter;

    new-instance v1, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView$9;

    invoke-direct {v1, p0}, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView$9;-><init>(Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView;)V

    invoke-virtual {v0, v1}, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListAdapter;->registerAdapterDataObserver(Landroid/support/v7/widget/RecyclerView$AdapterDataObserver;)V

    .line 398
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView;->i:Landroid/support/v7/widget/RecyclerView;

    iget-object v1, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView;->q:Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListAdapter;

    invoke-virtual {v0, v1}, Landroid/support/v7/widget/RecyclerView;->setAdapter(Landroid/support/v7/widget/RecyclerView$Adapter;)V

    .line 401
    new-instance v0, Landroid/support/v7/widget/helper/ItemTouchHelper;

    new-instance v1, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView$SwipeCallback;

    invoke-direct {v1, p0}, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView$SwipeCallback;-><init>(Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView;)V

    invoke-direct {v0, v1}, Landroid/support/v7/widget/helper/ItemTouchHelper;-><init>(Landroid/support/v7/widget/helper/ItemTouchHelper$Callback;)V

    iget-object v1, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView;->i:Landroid/support/v7/widget/RecyclerView;

    invoke-virtual {v0, v1}, Landroid/support/v7/widget/helper/ItemTouchHelper;->a(Landroid/support/v7/widget/RecyclerView;)V

    .line 404
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView;->i:Landroid/support/v7/widget/RecyclerView;

    new-instance v1, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView$10;

    invoke-direct {v1, p0}, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView$10;-><init>(Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView;)V

    invoke-virtual {v0, v1}, Landroid/support/v7/widget/RecyclerView;->addOnScrollListener(Landroid/support/v7/widget/RecyclerView$OnScrollListener;)V

    .line 410
    :cond_0
    return-void
.end method


# virtual methods
.method public a(Lcom/salesforce/android/cases/ui/internal/features/caselist/viewmodel/CaseListItemViewModel;)V
    .locals 1

    .prologue
    .line 197
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView;->q:Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListAdapter;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView;->q:Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListAdapter;

    invoke-virtual {v0}, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListAdapter;->getItemCount()I

    move-result v0

    if-lez v0, :cond_0

    .line 198
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView;->q:Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListAdapter;

    invoke-virtual {v0, p1}, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListAdapter;->b(Lcom/salesforce/android/cases/ui/internal/features/caselist/viewmodel/CaseListItemViewModel;)V

    .line 200
    :cond_0
    return-void
.end method

.method public a(Lcom/salesforce/android/cases/ui/internal/features/caselist/viewmodel/CaseListItemViewModel;I)V
    .locals 1

    .prologue
    .line 209
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView;->q:Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListAdapter;

    if-eqz v0, :cond_0

    .line 210
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView;->q:Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListAdapter;

    invoke-virtual {v0, p1, p2}, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListAdapter;->a(Lcom/salesforce/android/cases/ui/internal/features/caselist/viewmodel/CaseListItemViewModel;I)V

    .line 212
    :cond_0
    return-void
.end method

.method public a(Lcom/salesforce/android/cases/ui/internal/features/caselist/viewmodel/CaseListViewModel;)V
    .locals 2

    .prologue
    .line 123
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView;->h:Landroid/support/v4/widget/SwipeRefreshLayout;

    invoke-static {v0}, Lcom/salesforce/android/cases/ui/internal/utils/ViewUtils;->b(Landroid/view/View;)V

    .line 124
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView;->i:Landroid/support/v7/widget/RecyclerView;

    invoke-static {v0}, Lcom/salesforce/android/cases/ui/internal/utils/ViewUtils;->b(Landroid/view/View;)V

    .line 127
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView;->i:Landroid/support/v7/widget/RecyclerView;

    invoke-virtual {v0}, Landroid/support/v7/widget/RecyclerView;->requestLayout()V

    .line 130
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView;->q:Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListAdapter;

    invoke-virtual {p1}, Lcom/salesforce/android/cases/ui/internal/features/caselist/viewmodel/CaseListViewModel;->a()Ljava/util/List;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListAdapter;->a(Ljava/util/List;)V

    .line 131
    return-void
.end method

.method b(I)V
    .locals 2

    .prologue
    .line 297
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView;->o:Landroid/support/design/widget/Snackbar;

    if-eqz v0, :cond_0

    .line 298
    iget v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView;->s:I

    invoke-static {p1}, Ljava/lang/Math;->abs(I)I

    move-result v1

    add-int/2addr v0, v1

    iput v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView;->s:I

    .line 301
    iget v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView;->s:I

    const/16 v1, 0xc8

    if-lt v0, v1, :cond_0

    .line 302
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView;->o:Landroid/support/design/widget/Snackbar;

    invoke-virtual {v0}, Landroid/support/design/widget/Snackbar;->d()V

    .line 303
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView;->o:Landroid/support/design/widget/Snackbar;

    .line 306
    :cond_0
    return-void
.end method

.method public b(Lcom/salesforce/android/cases/ui/internal/features/caselist/viewmodel/CaseListItemViewModel;)V
    .locals 1

    .prologue
    .line 203
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView;->q:Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListAdapter;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView;->q:Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListAdapter;

    invoke-virtual {v0}, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListAdapter;->getItemCount()I

    move-result v0

    if-lez v0, :cond_0

    .line 204
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView;->q:Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListAdapter;

    invoke-virtual {v0, p1}, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListAdapter;->c(Lcom/salesforce/android/cases/ui/internal/features/caselist/viewmodel/CaseListItemViewModel;)V

    .line 206
    :cond_0
    return-void
.end method

.method public c()V
    .locals 1

    .prologue
    .line 103
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView;->g:Lcom/salesforce/android/service/common/ui/views/SalesforceProgressSpinner;

    invoke-static {v0}, Lcom/salesforce/android/cases/ui/internal/utils/ViewUtils;->c(Landroid/view/View;)V

    .line 104
    return-void
.end method

.method public c(Lcom/salesforce/android/cases/ui/internal/features/caselist/viewmodel/CaseListItemViewModel;)V
    .locals 3

    .prologue
    .line 215
    sget v0, Lcom/salesforce/android/cases/R$string;->cases_case_list_item_removed_snackbar_message_text:I

    const/4 v1, -0x2

    .line 216
    invoke-static {p0, v0, v1}, Landroid/support/design/widget/Snackbar;->a(Landroid/view/View;II)Landroid/support/design/widget/Snackbar;

    move-result-object v0

    new-instance v1, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView$5;

    invoke-direct {v1, p0}, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView$5;-><init>(Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView;)V

    .line 218
    invoke-virtual {v0, v1}, Landroid/support/design/widget/Snackbar;->a(Landroid/support/design/widget/BaseTransientBottomBar$BaseCallback;)Landroid/support/design/widget/BaseTransientBottomBar;

    move-result-object v0

    check-cast v0, Landroid/support/design/widget/Snackbar;

    .line 233
    invoke-virtual {p0}, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView;->getContext()Landroid/content/Context;

    move-result-object v1

    sget v2, Lcom/salesforce/android/cases/R$color;->cases_default_snackbar_text_color:I

    invoke-static {v1, v2}, Landroid/support/v4/content/ContextCompat;->c(Landroid/content/Context;I)I

    move-result v1

    .line 232
    invoke-virtual {v0, v1}, Landroid/support/design/widget/Snackbar;->e(I)Landroid/support/design/widget/Snackbar;

    move-result-object v0

    sget v1, Lcom/salesforce/android/cases/R$string;->cases_snackbar_undo_action_text:I

    new-instance v2, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView$4;

    invoke-direct {v2, p0, p1}, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView$4;-><init>(Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView;Lcom/salesforce/android/cases/ui/internal/features/caselist/viewmodel/CaseListItemViewModel;)V

    .line 234
    invoke-virtual {v0, v1, v2}, Landroid/support/design/widget/Snackbar;->a(ILandroid/view/View$OnClickListener;)Landroid/support/design/widget/Snackbar;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView;->o:Landroid/support/design/widget/Snackbar;

    .line 241
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView;->o:Landroid/support/design/widget/Snackbar;

    .line 242
    invoke-virtual {p0}, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView;->getContext()Landroid/content/Context;

    move-result-object v1

    sget v2, Lcom/salesforce/android/cases/R$color;->cases_default_snackbar_text_color:I

    invoke-static {v1, v2}, Landroid/support/v4/content/ContextCompat;->c(Landroid/content/Context;I)I

    move-result v1

    .line 241
    invoke-static {v0, v1}, Lcom/salesforce/android/cases/ui/internal/utils/ViewUtils;->a(Landroid/support/design/widget/Snackbar;I)V

    .line 243
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView;->o:Landroid/support/design/widget/Snackbar;

    invoke-virtual {v0}, Landroid/support/design/widget/Snackbar;->c()V

    .line 244
    return-void
.end method

.method d(Lcom/salesforce/android/cases/ui/internal/features/caselist/viewmodel/CaseListItemViewModel;)V
    .locals 1

    .prologue
    .line 285
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView;->r:Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListContract$Presenter;

    if-eqz v0, :cond_0

    .line 286
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView;->r:Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListContract$Presenter;

    invoke-interface {v0, p1}, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListContract$Presenter;->a(Lcom/salesforce/android/cases/ui/internal/features/caselist/viewmodel/CaseListItemViewModel;)V

    .line 288
    :cond_0
    return-void
.end method

.method public e()V
    .locals 2

    .prologue
    .line 111
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView;->h:Landroid/support/v4/widget/SwipeRefreshLayout;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/support/v4/widget/SwipeRefreshLayout;->setRefreshing(Z)V

    .line 112
    return-void
.end method

.method e(Lcom/salesforce/android/cases/ui/internal/features/caselist/viewmodel/CaseListItemViewModel;)V
    .locals 1

    .prologue
    .line 291
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView;->r:Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListContract$Presenter;

    if-eqz v0, :cond_0

    .line 292
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView;->r:Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListContract$Presenter;

    invoke-interface {v0, p1}, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListContract$Presenter;->b(Lcom/salesforce/android/cases/ui/internal/features/caselist/viewmodel/CaseListItemViewModel;)V

    .line 294
    :cond_0
    return-void
.end method

.method public f()V
    .locals 1

    .prologue
    .line 115
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView;->p:Landroid/support/design/widget/FloatingActionButton;

    invoke-virtual {v0}, Landroid/support/design/widget/FloatingActionButton;->a()V

    .line 116
    return-void
.end method

.method public g()V
    .locals 1

    .prologue
    .line 119
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView;->p:Landroid/support/design/widget/FloatingActionButton;

    invoke-virtual {v0}, Landroid/support/design/widget/FloatingActionButton;->b()V

    .line 120
    return-void
.end method

.method public h()V
    .locals 1

    .prologue
    .line 134
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView;->h:Landroid/support/v4/widget/SwipeRefreshLayout;

    invoke-static {v0}, Lcom/salesforce/android/cases/ui/internal/utils/ViewUtils;->b(Landroid/view/View;)V

    .line 135
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView;->j:Landroid/view/ViewGroup;

    invoke-static {v0}, Lcom/salesforce/android/cases/ui/internal/utils/ViewUtils;->b(Landroid/view/View;)V

    .line 136
    return-void
.end method

.method public i()V
    .locals 1

    .prologue
    .line 139
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView;->j:Landroid/view/ViewGroup;

    invoke-static {v0}, Lcom/salesforce/android/cases/ui/internal/utils/ViewUtils;->c(Landroid/view/View;)V

    .line 140
    return-void
.end method

.method public j()V
    .locals 1

    .prologue
    .line 143
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView;->k:Landroid/view/ViewGroup;

    invoke-static {v0}, Lcom/salesforce/android/cases/ui/internal/utils/ViewUtils;->b(Landroid/view/View;)V

    .line 144
    return-void
.end method

.method public k()V
    .locals 3

    .prologue
    .line 147
    sget v0, Lcom/salesforce/android/cases/R$string;->cases_generic_error_title_text:I

    const/4 v1, -0x2

    .line 148
    invoke-static {p0, v0, v1}, Landroid/support/design/widget/Snackbar;->a(Landroid/view/View;II)Landroid/support/design/widget/Snackbar;

    move-result-object v0

    .line 149
    invoke-virtual {p0}, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView;->getContext()Landroid/content/Context;

    move-result-object v1

    sget v2, Lcom/salesforce/android/cases/R$color;->cases_error_snackbar_action_text_color:I

    invoke-static {v1, v2}, Landroid/support/v4/content/ContextCompat;->c(Landroid/content/Context;I)I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/support/design/widget/Snackbar;->e(I)Landroid/support/design/widget/Snackbar;

    move-result-object v0

    sget v1, Lcom/salesforce/android/cases/R$string;->cases_snackbar_retry_action_text:I

    new-instance v2, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView$1;

    invoke-direct {v2, p0}, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView$1;-><init>(Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView;)V

    .line 151
    invoke-virtual {v0, v1, v2}, Landroid/support/design/widget/Snackbar;->a(ILandroid/view/View$OnClickListener;)Landroid/support/design/widget/Snackbar;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView;->m:Landroid/support/design/widget/Snackbar;

    .line 157
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView;->m:Landroid/support/design/widget/Snackbar;

    invoke-direct {p0, v0}, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView;->a(Landroid/support/design/widget/Snackbar;)V

    .line 158
    return-void
.end method

.method public l()V
    .locals 1

    .prologue
    .line 161
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView;->l:Landroid/view/ViewGroup;

    invoke-static {v0}, Lcom/salesforce/android/cases/ui/internal/utils/ViewUtils;->b(Landroid/view/View;)V

    .line 162
    return-void
.end method

.method public l_()V
    .locals 1

    .prologue
    .line 99
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView;->g:Lcom/salesforce/android/service/common/ui/views/SalesforceProgressSpinner;

    invoke-static {v0}, Lcom/salesforce/android/cases/ui/internal/utils/ViewUtils;->b(Landroid/view/View;)V

    .line 100
    return-void
.end method

.method public m()V
    .locals 3

    .prologue
    .line 165
    sget v0, Lcom/salesforce/android/cases/R$string;->cases_network_error_title_text:I

    const/4 v1, -0x2

    invoke-static {p0, v0, v1}, Landroid/support/design/widget/Snackbar;->a(Landroid/view/View;II)Landroid/support/design/widget/Snackbar;

    move-result-object v0

    .line 167
    invoke-virtual {p0}, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView;->getContext()Landroid/content/Context;

    move-result-object v1

    sget v2, Lcom/salesforce/android/cases/R$color;->cases_error_snackbar_action_text_color:I

    invoke-static {v1, v2}, Landroid/support/v4/content/ContextCompat;->c(Landroid/content/Context;I)I

    move-result v1

    .line 166
    invoke-virtual {v0, v1}, Landroid/support/design/widget/Snackbar;->e(I)Landroid/support/design/widget/Snackbar;

    move-result-object v0

    sget v1, Lcom/salesforce/android/cases/R$string;->cases_snackbar_retry_action_text:I

    new-instance v2, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView$2;

    invoke-direct {v2, p0}, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView$2;-><init>(Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView;)V

    .line 168
    invoke-virtual {v0, v1, v2}, Landroid/support/design/widget/Snackbar;->a(ILandroid/view/View$OnClickListener;)Landroid/support/design/widget/Snackbar;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView;->n:Landroid/support/design/widget/Snackbar;

    .line 174
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView;->n:Landroid/support/design/widget/Snackbar;

    invoke-direct {p0, v0}, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView;->a(Landroid/support/design/widget/Snackbar;)V

    .line 175
    return-void
.end method

.method public m_()V
    .locals 2

    .prologue
    .line 107
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView;->h:Landroid/support/v4/widget/SwipeRefreshLayout;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Landroid/support/v4/widget/SwipeRefreshLayout;->setRefreshing(Z)V

    .line 108
    return-void
.end method

.method public n()V
    .locals 3

    .prologue
    .line 178
    sget v0, Lcom/salesforce/android/cases/R$string;->cases_case_list_out_of_date_snackbar_text:I

    const/4 v1, -0x2

    .line 179
    invoke-static {p0, v0, v1}, Landroid/support/design/widget/Snackbar;->a(Landroid/view/View;II)Landroid/support/design/widget/Snackbar;

    move-result-object v0

    sget v1, Lcom/salesforce/android/cases/R$string;->cases_snackbar_refresh_action_text:I

    new-instance v2, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView$3;

    invoke-direct {v2, p0}, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView$3;-><init>(Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView;)V

    .line 181
    invoke-virtual {v0, v1, v2}, Landroid/support/design/widget/Snackbar;->a(ILandroid/view/View$OnClickListener;)Landroid/support/design/widget/Snackbar;

    move-result-object v0

    .line 188
    invoke-virtual {p0}, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView;->getContext()Landroid/content/Context;

    move-result-object v1

    sget v2, Lcom/salesforce/android/cases/R$color;->cases_snackbar_refresh_text_color:I

    invoke-static {v1, v2}, Landroid/support/v4/content/ContextCompat;->c(Landroid/content/Context;I)I

    move-result v1

    .line 187
    invoke-static {v0, v1}, Lcom/salesforce/android/cases/ui/internal/utils/ViewUtils;->b(Landroid/support/design/widget/Snackbar;I)V

    .line 189
    invoke-virtual {v0}, Landroid/support/design/widget/Snackbar;->c()V

    .line 190
    return-void
.end method

.method public n_()V
    .locals 1

    .prologue
    .line 251
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView;->r:Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListContract$Presenter;

    if-eqz v0, :cond_0

    .line 252
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView;->r:Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListContract$Presenter;

    invoke-interface {v0}, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListContract$Presenter;->h()V

    .line 255
    :cond_0
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView;->o:Landroid/support/design/widget/Snackbar;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView;->o:Landroid/support/design/widget/Snackbar;

    invoke-virtual {v0}, Landroid/support/design/widget/Snackbar;->e()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 256
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView;->o:Landroid/support/design/widget/Snackbar;

    invoke-virtual {v0}, Landroid/support/design/widget/Snackbar;->d()V

    .line 258
    :cond_1
    return-void
.end method

.method o()V
    .locals 1

    .prologue
    .line 261
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView;->r:Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListContract$Presenter;

    if-eqz v0, :cond_0

    .line 262
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView;->r:Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListContract$Presenter;

    invoke-interface {v0}, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListContract$Presenter;->c()V

    .line 264
    :cond_0
    return-void
.end method

.method p()V
    .locals 1

    .prologue
    .line 267
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView;->r:Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListContract$Presenter;

    if-eqz v0, :cond_0

    .line 268
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView;->r:Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListContract$Presenter;

    invoke-interface {v0}, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListContract$Presenter;->f()V

    .line 270
    :cond_0
    return-void
.end method

.method q()V
    .locals 1

    .prologue
    .line 273
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView;->r:Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListContract$Presenter;

    if-eqz v0, :cond_0

    .line 274
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView;->r:Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListContract$Presenter;

    invoke-interface {v0}, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListContract$Presenter;->a()V

    .line 276
    :cond_0
    return-void
.end method

.method r()V
    .locals 1

    .prologue
    .line 279
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView;->r:Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListContract$Presenter;

    if-eqz v0, :cond_0

    .line 280
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView;->r:Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListContract$Presenter;

    invoke-interface {v0}, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListContract$Presenter;->b()V

    .line 282
    :cond_0
    return-void
.end method

.method public setPresenter(Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListContract$Presenter;)V
    .locals 0

    .prologue
    .line 193
    iput-object p1, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView;->r:Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListContract$Presenter;

    .line 194
    return-void
.end method

.method public setTitle(Ljava/lang/String;)V
    .locals 1

    .prologue
    .line 247
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView;->f:Lcom/salesforce/android/service/common/ui/views/SalesforceTitleTextToolbar;

    invoke-virtual {v0, p1}, Lcom/salesforce/android/service/common/ui/views/SalesforceTitleTextToolbar;->setTitleText(Ljava/lang/CharSequence;)V

    .line 248
    return-void
.end method
