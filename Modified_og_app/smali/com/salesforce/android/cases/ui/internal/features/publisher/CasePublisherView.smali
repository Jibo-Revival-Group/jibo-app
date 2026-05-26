.class public Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherView;
.super Landroid/support/design/widget/CoordinatorLayout;
.source "CasePublisherView.java"

# interfaces
.implements Landroid/support/v7/widget/Toolbar$OnMenuItemClickListener;
.implements Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherContract$View;
.implements Lcom/salesforce/android/cases/ui/internal/features/publisher/SalesforceConfirmationDialogFragment$SalesforceConfirmationDialogListener;


# instance fields
.field f:Lcom/salesforce/android/service/common/ui/views/SalesforceTitleTextToolbar;

.field g:Lcom/salesforce/android/service/common/ui/views/SalesforceProgressSpinner;

.field h:Landroid/widget/ScrollView;

.field i:Landroid/widget/LinearLayout;

.field j:Landroid/view/ViewGroup;

.field k:Landroid/view/ViewGroup;

.field l:Landroid/view/ViewGroup;

.field m:Landroid/view/MenuItem;

.field n:Landroid/support/design/widget/Snackbar;

.field private o:I

.field private p:Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherContract$Presenter;

.field private q:Landroid/support/v4/app/FragmentManager;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 1

    .prologue
    .line 90
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 91
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 1

    .prologue
    .line 94
    const/4 v0, 0x0

    invoke-direct {p0, p1, p2, v0}, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 95
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    .locals 0

    .prologue
    .line 98
    invoke-direct {p0, p1, p2, p3}, Landroid/support/design/widget/CoordinatorLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 99
    invoke-direct {p0, p1}, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherView;->a(Landroid/content/Context;)V

    .line 100
    return-void
.end method

.method static synthetic a(Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherView;)Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherContract$Presenter;
    .locals 1

    .prologue
    .line 62
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherView;->p:Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherContract$Presenter;

    return-object v0
.end method

.method private a(Landroid/content/Context;)V
    .locals 5

    .prologue
    const/4 v4, 0x1

    .line 292
    .line 293
    invoke-virtual {p1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    sget v1, Lcom/salesforce/android/cases/R$dimen;->cases_case_publisher_field_spacing:I

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v0

    iput v0, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherView;->o:I

    .line 296
    invoke-virtual {p0}, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherView;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v0

    sget v1, Lcom/salesforce/android/cases/R$layout;->case_publisher_view:I

    invoke-virtual {v0, v1, p0, v4}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    .line 299
    sget v0, Lcom/salesforce/android/cases/R$id;->toolbar:I

    invoke-virtual {p0, v0}, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/salesforce/android/service/common/ui/views/SalesforceTitleTextToolbar;

    iput-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherView;->f:Lcom/salesforce/android/service/common/ui/views/SalesforceTitleTextToolbar;

    .line 300
    sget v0, Lcom/salesforce/android/cases/R$id;->progress_spinner:I

    invoke-virtual {p0, v0}, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/salesforce/android/service/common/ui/views/SalesforceProgressSpinner;

    iput-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherView;->g:Lcom/salesforce/android/service/common/ui/views/SalesforceProgressSpinner;

    .line 301
    sget v0, Lcom/salesforce/android/cases/R$id;->case_layout_frame:I

    invoke-virtual {p0, v0}, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ScrollView;

    iput-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherView;->h:Landroid/widget/ScrollView;

    .line 302
    sget v0, Lcom/salesforce/android/cases/R$id;->case_layout_container:I

    invoke-virtual {p0, v0}, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherView;->i:Landroid/widget/LinearLayout;

    .line 303
    sget v0, Lcom/salesforce/android/cases/R$id;->case_generic_error_view:I

    invoke-virtual {p0, v0}, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/view/ViewGroup;

    iput-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherView;->j:Landroid/view/ViewGroup;

    .line 304
    sget v0, Lcom/salesforce/android/cases/R$id;->case_network_error_view:I

    invoke-virtual {p0, v0}, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/view/ViewGroup;

    iput-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherView;->k:Landroid/view/ViewGroup;

    .line 305
    sget v0, Lcom/salesforce/android/cases/R$id;->case_created_view:I

    invoke-virtual {p0, v0}, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/view/ViewGroup;

    iput-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherView;->l:Landroid/view/ViewGroup;

    .line 308
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherView;->f:Lcom/salesforce/android/service/common/ui/views/SalesforceTitleTextToolbar;

    if-eqz v0, :cond_0

    .line 309
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherView;->f:Lcom/salesforce/android/service/common/ui/views/SalesforceTitleTextToolbar;

    sget v1, Lcom/salesforce/android/cases/R$string;->cases_cancel_button_text:I

    invoke-virtual {v0, v1}, Lcom/salesforce/android/service/common/ui/views/SalesforceTitleTextToolbar;->setNavigationContentDescription(I)V

    .line 310
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherView;->f:Lcom/salesforce/android/service/common/ui/views/SalesforceTitleTextToolbar;

    .line 311
    invoke-virtual {p0}, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherView;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    sget v2, Lcom/salesforce/android/cases/R$drawable;->cases_ic_clear:I

    const/4 v3, 0x0

    invoke-static {v1, v2, v3}, Landroid/support/graphics/drawable/VectorDrawableCompat;->a(Landroid/content/res/Resources;ILandroid/content/res/Resources$Theme;)Landroid/support/graphics/drawable/VectorDrawableCompat;

    move-result-object v1

    .line 310
    invoke-virtual {v0, v1}, Lcom/salesforce/android/service/common/ui/views/SalesforceTitleTextToolbar;->setNavigationIcon(Landroid/graphics/drawable/Drawable;)V

    .line 312
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherView;->f:Lcom/salesforce/android/service/common/ui/views/SalesforceTitleTextToolbar;

    new-instance v1, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherView$2;

    invoke-direct {v1, p0}, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherView$2;-><init>(Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherView;)V

    invoke-virtual {v0, v1}, Lcom/salesforce/android/service/common/ui/views/SalesforceTitleTextToolbar;->setNavigationOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 317
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherView;->f:Lcom/salesforce/android/service/common/ui/views/SalesforceTitleTextToolbar;

    sget v1, Lcom/salesforce/android/cases/R$menu;->case_publisher_menu:I

    invoke-virtual {v0, v1}, Lcom/salesforce/android/service/common/ui/views/SalesforceTitleTextToolbar;->inflateMenu(I)V

    .line 318
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherView;->f:Lcom/salesforce/android/service/common/ui/views/SalesforceTitleTextToolbar;

    invoke-virtual {v0, p0}, Lcom/salesforce/android/service/common/ui/views/SalesforceTitleTextToolbar;->setOnMenuItemClickListener(Landroid/support/v7/widget/Toolbar$OnMenuItemClickListener;)V

    .line 319
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherView;->f:Lcom/salesforce/android/service/common/ui/views/SalesforceTitleTextToolbar;

    invoke-virtual {v0}, Lcom/salesforce/android/service/common/ui/views/SalesforceTitleTextToolbar;->getMenu()Landroid/view/Menu;

    move-result-object v0

    .line 320
    invoke-virtual {p0}, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherView;->getContext()Landroid/content/Context;

    move-result-object v1

    sget v2, Lcom/salesforce/android/cases/R$color;->salesforce_contrast_primary:I

    invoke-static {v1, v2}, Landroid/support/v4/content/ContextCompat;->c(Landroid/content/Context;I)I

    move-result v1

    new-array v2, v4, [I

    const/4 v3, 0x0

    sget v4, Lcom/salesforce/android/cases/R$id;->action_send:I

    aput v4, v2, v3

    .line 319
    invoke-static {v0, v1, v2}, Lcom/salesforce/android/cases/ui/internal/utils/DrawableUtils;->a(Landroid/view/Menu;I[I)V

    .line 322
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherView;->f:Lcom/salesforce/android/service/common/ui/views/SalesforceTitleTextToolbar;

    invoke-virtual {v0}, Lcom/salesforce/android/service/common/ui/views/SalesforceTitleTextToolbar;->getMenu()Landroid/view/Menu;

    move-result-object v0

    sget v1, Lcom/salesforce/android/cases/R$id;->action_send:I

    invoke-interface {v0, v1}, Landroid/view/Menu;->findItem(I)Landroid/view/MenuItem;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherView;->m:Landroid/view/MenuItem;

    .line 324
    :cond_0
    return-void
.end method

.method private a(Lcom/salesforce/android/cases/ui/internal/features/publisher/viewmodel/CaseFieldViewModel;)V
    .locals 3

    .prologue
    .line 271
    new-instance v0, Landroid/widget/LinearLayout$LayoutParams;

    const/4 v1, -0x1

    const/4 v2, -0x2

    invoke-direct {v0, v1, v2}, Landroid/widget/LinearLayout$LayoutParams;-><init>(II)V

    .line 273
    iget v1, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherView;->o:I

    iput v1, v0, Landroid/widget/LinearLayout$LayoutParams;->bottomMargin:I

    .line 276
    iget-object v1, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherView;->i:Landroid/widget/LinearLayout;

    invoke-interface {p1}, Lcom/salesforce/android/cases/ui/internal/features/publisher/viewmodel/CaseFieldViewModel;->a()Landroid/view/View;

    move-result-object v2

    invoke-virtual {v1, v2, v0}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V

    .line 277
    return-void
.end method

.method private getCreatingCaseDialogFragment()Lcom/salesforce/android/cases/ui/internal/features/shared/SalesforceProgressDialogFragment;
    .locals 2

    .prologue
    .line 280
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherView;->q:Landroid/support/v4/app/FragmentManager;

    const-string v1, "createCaseDialogFragment"

    invoke-virtual {v0, v1}, Landroid/support/v4/app/FragmentManager;->a(Ljava/lang/String;)Landroid/support/v4/app/Fragment;

    move-result-object v0

    check-cast v0, Lcom/salesforce/android/cases/ui/internal/features/shared/SalesforceProgressDialogFragment;

    return-object v0
.end method

.method private getDiscardCaseDialogFragment()Lcom/salesforce/android/cases/ui/internal/features/publisher/SalesforceConfirmationDialogFragment;
    .locals 2

    .prologue
    .line 285
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherView;->q:Landroid/support/v4/app/FragmentManager;

    const-string v1, "discardCaseDialogFragment"

    invoke-virtual {v0, v1}, Landroid/support/v4/app/FragmentManager;->a(Ljava/lang/String;)Landroid/support/v4/app/Fragment;

    move-result-object v0

    check-cast v0, Lcom/salesforce/android/cases/ui/internal/features/publisher/SalesforceConfirmationDialogFragment;

    return-object v0
.end method

.method private q()V
    .locals 1

    .prologue
    .line 327
    invoke-direct {p0}, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherView;->getDiscardCaseDialogFragment()Lcom/salesforce/android/cases/ui/internal/features/publisher/SalesforceConfirmationDialogFragment;

    move-result-object v0

    .line 328
    if-eqz v0, :cond_0

    .line 329
    invoke-virtual {v0, p0}, Lcom/salesforce/android/cases/ui/internal/features/publisher/SalesforceConfirmationDialogFragment;->a(Lcom/salesforce/android/cases/ui/internal/features/publisher/SalesforceConfirmationDialogFragment$SalesforceConfirmationDialogListener;)V

    .line 331
    :cond_0
    return-void
.end method


# virtual methods
.method public a(Lcom/salesforce/android/cases/core/model/CaseField;)Lcom/salesforce/android/cases/ui/internal/features/publisher/viewmodel/CaseTextInputViewModel;
    .locals 4

    .prologue
    .line 184
    invoke-interface {p1}, Lcom/salesforce/android/cases/core/model/CaseField;->f()Lcom/salesforce/android/cases/core/model/CaseFieldType;

    move-result-object v0

    .line 185
    sget-object v1, Lcom/salesforce/android/cases/core/model/CaseFieldType;->TEXT:Lcom/salesforce/android/cases/core/model/CaseFieldType;

    if-eq v0, v1, :cond_0

    sget-object v1, Lcom/salesforce/android/cases/core/model/CaseFieldType;->EMAIL:Lcom/salesforce/android/cases/core/model/CaseFieldType;

    if-eq v0, v1, :cond_0

    sget-object v1, Lcom/salesforce/android/cases/core/model/CaseFieldType;->TEXT_AREA:Lcom/salesforce/android/cases/core/model/CaseFieldType;

    if-eq v0, v1, :cond_0

    .line 188
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "CaseField must be of type CaseFieldType.TEXT, CaseFieldType.EMAIL or CaseFieldType.TEXT_AREA."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 194
    :cond_0
    invoke-virtual {p0}, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherView;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v0

    sget v1, Lcom/salesforce/android/cases/R$layout;->case_text_input_view:I

    const/4 v2, 0x0

    const/4 v3, 0x0

    .line 195
    invoke-virtual {v0, v1, v2, v3}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/salesforce/android/service/common/ui/views/SalesforceTextInputLayout;

    .line 198
    new-instance v1, Lcom/salesforce/android/cases/ui/internal/features/publisher/viewmodel/CaseTextInputViewModel;

    invoke-direct {v1, v0, p1}, Lcom/salesforce/android/cases/ui/internal/features/publisher/viewmodel/CaseTextInputViewModel;-><init>(Lcom/salesforce/android/service/common/ui/views/SalesforceTextInputLayout;Lcom/salesforce/android/cases/core/model/CaseField;)V

    .line 201
    invoke-direct {p0, v1}, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherView;->a(Lcom/salesforce/android/cases/ui/internal/features/publisher/viewmodel/CaseFieldViewModel;)V

    .line 203
    return-object v1
.end method

.method public a(Landroid/view/MenuItem;)Z
    .locals 2

    .prologue
    .line 252
    invoke-interface {p1}, Landroid/view/MenuItem;->getItemId()I

    move-result v0

    .line 253
    sget v1, Lcom/salesforce/android/cases/R$id;->action_send:I

    if-ne v1, v0, :cond_1

    .line 254
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherView;->p:Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherContract$Presenter;

    if-eqz v0, :cond_0

    .line 255
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherView;->p:Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherContract$Presenter;

    invoke-interface {v0}, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherContract$Presenter;->a()V

    .line 257
    :cond_0
    const/4 v0, 0x1

    .line 259
    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public b(Lcom/salesforce/android/cases/core/model/CaseField;)Lcom/salesforce/android/cases/ui/internal/features/publisher/viewmodel/CasePickListViewModel;
    .locals 4

    .prologue
    .line 209
    invoke-interface {p1}, Lcom/salesforce/android/cases/core/model/CaseField;->f()Lcom/salesforce/android/cases/core/model/CaseFieldType;

    move-result-object v0

    sget-object v1, Lcom/salesforce/android/cases/core/model/CaseFieldType;->PICK_LIST:Lcom/salesforce/android/cases/core/model/CaseFieldType;

    if-eq v0, v1, :cond_0

    .line 210
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "CaseField must be of type CaseFieldType.PICK_LIST."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 215
    :cond_0
    invoke-virtual {p0}, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherView;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v0

    sget v1, Lcom/salesforce/android/cases/R$layout;->case_pick_list_view:I

    const/4 v2, 0x0

    const/4 v3, 0x0

    .line 216
    invoke-virtual {v0, v1, v2, v3}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/salesforce/android/service/common/ui/views/SalesforcePickListView;

    .line 219
    new-instance v1, Lcom/salesforce/android/cases/ui/internal/features/publisher/viewmodel/CasePickListViewModel;

    invoke-direct {v1, v0, p1}, Lcom/salesforce/android/cases/ui/internal/features/publisher/viewmodel/CasePickListViewModel;-><init>(Lcom/salesforce/android/service/common/ui/views/SalesforcePickListView;Lcom/salesforce/android/cases/core/model/CaseField;)V

    .line 222
    invoke-direct {p0, v1}, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherView;->a(Lcom/salesforce/android/cases/ui/internal/features/publisher/viewmodel/CaseFieldViewModel;)V

    .line 224
    return-object v1
.end method

.method public c()V
    .locals 1

    .prologue
    .line 111
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherView;->h:Landroid/widget/ScrollView;

    invoke-static {v0}, Lcom/salesforce/android/cases/ui/internal/utils/ViewUtils;->b(Landroid/view/View;)V

    .line 112
    return-void
.end method

.method public e()V
    .locals 1

    .prologue
    .line 119
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherView;->j:Landroid/view/ViewGroup;

    invoke-static {v0}, Lcom/salesforce/android/cases/ui/internal/utils/ViewUtils;->b(Landroid/view/View;)V

    .line 120
    return-void
.end method

.method public f()V
    .locals 1

    .prologue
    .line 123
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherView;->k:Landroid/view/ViewGroup;

    invoke-static {v0}, Lcom/salesforce/android/cases/ui/internal/utils/ViewUtils;->b(Landroid/view/View;)V

    .line 124
    return-void
.end method

.method public g()V
    .locals 1

    .prologue
    .line 127
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherView;->l:Landroid/view/ViewGroup;

    invoke-static {v0}, Lcom/salesforce/android/cases/ui/internal/utils/ViewUtils;->b(Landroid/view/View;)V

    .line 128
    return-void
.end method

.method public h()V
    .locals 4

    .prologue
    .line 131
    sget v0, Lcom/salesforce/android/cases/R$string;->cases_case_create_error_snackbar_text:I

    const/4 v1, -0x2

    invoke-static {p0, v0, v1}, Landroid/support/design/widget/Snackbar;->a(Landroid/view/View;II)Landroid/support/design/widget/Snackbar;

    move-result-object v0

    .line 134
    invoke-virtual {p0}, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherView;->getContext()Landroid/content/Context;

    move-result-object v1

    sget v2, Lcom/salesforce/android/cases/R$color;->cases_error_snackbar_action_text_color:I

    invoke-static {v1, v2}, Landroid/support/v4/content/ContextCompat;->c(Landroid/content/Context;I)I

    move-result v1

    .line 133
    invoke-virtual {v0, v1}, Landroid/support/design/widget/Snackbar;->e(I)Landroid/support/design/widget/Snackbar;

    move-result-object v0

    sget v1, Lcom/salesforce/android/cases/R$string;->cases_snackbar_retry_action_text:I

    new-instance v2, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherView$1;

    invoke-direct {v2, p0}, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherView$1;-><init>(Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherView;)V

    .line 135
    invoke-virtual {v0, v1, v2}, Landroid/support/design/widget/Snackbar;->a(ILandroid/view/View$OnClickListener;)Landroid/support/design/widget/Snackbar;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherView;->n:Landroid/support/design/widget/Snackbar;

    .line 144
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherView;->n:Landroid/support/design/widget/Snackbar;

    .line 145
    invoke-virtual {p0}, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherView;->getContext()Landroid/content/Context;

    move-result-object v1

    sget v2, Lcom/salesforce/android/cases/R$color;->cases_error_snackbar_background_color:I

    invoke-static {v1, v2}, Landroid/support/v4/content/ContextCompat;->c(Landroid/content/Context;I)I

    move-result v1

    .line 146
    invoke-virtual {p0}, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherView;->getContext()Landroid/content/Context;

    move-result-object v2

    sget v3, Lcom/salesforce/android/cases/R$color;->cases_error_snackbar_text_color:I

    invoke-static {v2, v3}, Landroid/support/v4/content/ContextCompat;->c(Landroid/content/Context;I)I

    move-result v2

    .line 144
    invoke-static {v0, v1, v2}, Lcom/salesforce/android/cases/ui/internal/utils/ViewUtils;->a(Landroid/support/design/widget/Snackbar;II)V

    .line 147
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherView;->n:Landroid/support/design/widget/Snackbar;

    invoke-virtual {v0}, Landroid/support/design/widget/Snackbar;->c()V

    .line 148
    return-void
.end method

.method public i()V
    .locals 1

    .prologue
    .line 151
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherView;->n:Landroid/support/design/widget/Snackbar;

    if-eqz v0, :cond_0

    .line 152
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherView;->n:Landroid/support/design/widget/Snackbar;

    invoke-virtual {v0}, Landroid/support/design/widget/Snackbar;->d()V

    .line 154
    :cond_0
    return-void
.end method

.method public j()V
    .locals 3

    .prologue
    .line 157
    invoke-direct {p0}, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherView;->getCreatingCaseDialogFragment()Lcom/salesforce/android/cases/ui/internal/features/shared/SalesforceProgressDialogFragment;

    move-result-object v0

    .line 158
    if-nez v0, :cond_0

    .line 159
    sget v0, Lcom/salesforce/android/cases/R$string;->cases_creating_case_progress_dialog_title_text:I

    sget v1, Lcom/salesforce/android/cases/R$string;->cases_creating_case_progress_dialog_message_text:I

    invoke-static {v0, v1}, Lcom/salesforce/android/cases/ui/internal/features/shared/SalesforceProgressDialogFragment;->a(II)Lcom/salesforce/android/cases/ui/internal/features/shared/SalesforceProgressDialogFragment;

    move-result-object v0

    .line 162
    iget-object v1, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherView;->q:Landroid/support/v4/app/FragmentManager;

    const-string v2, "createCaseDialogFragment"

    invoke-virtual {v0, v1, v2}, Lcom/salesforce/android/cases/ui/internal/features/shared/SalesforceProgressDialogFragment;->show(Landroid/support/v4/app/FragmentManager;Ljava/lang/String;)V

    .line 164
    :cond_0
    return-void
.end method

.method public k()V
    .locals 1

    .prologue
    .line 167
    invoke-direct {p0}, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherView;->getCreatingCaseDialogFragment()Lcom/salesforce/android/cases/ui/internal/features/shared/SalesforceProgressDialogFragment;

    move-result-object v0

    .line 168
    if-eqz v0, :cond_0

    .line 169
    invoke-virtual {v0}, Lcom/salesforce/android/cases/ui/internal/features/shared/SalesforceProgressDialogFragment;->dismiss()V

    .line 171
    :cond_0
    return-void
.end method

.method public l()V
    .locals 2

    .prologue
    .line 174
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherView;->m:Landroid/view/MenuItem;

    const/4 v1, 0x0

    invoke-interface {v0, v1}, Landroid/view/MenuItem;->setVisible(Z)Landroid/view/MenuItem;

    .line 175
    return-void
.end method

.method public m()V
    .locals 2

    .prologue
    .line 178
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherView;->m:Landroid/view/MenuItem;

    const/4 v1, 0x1

    invoke-interface {v0, v1}, Landroid/view/MenuItem;->setVisible(Z)Landroid/view/MenuItem;

    .line 179
    return-void
.end method

.method public n()V
    .locals 3

    .prologue
    .line 237
    invoke-direct {p0}, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherView;->getDiscardCaseDialogFragment()Lcom/salesforce/android/cases/ui/internal/features/publisher/SalesforceConfirmationDialogFragment;

    move-result-object v0

    .line 238
    if-nez v0, :cond_0

    .line 239
    sget v0, Lcom/salesforce/android/cases/R$string;->cases_discard_case_confirmation_dialog_title_text:I

    sget v1, Lcom/salesforce/android/cases/R$string;->case_discard_case_confirmation_dialog_message_text:I

    invoke-static {v0, v1}, Lcom/salesforce/android/cases/ui/internal/features/publisher/SalesforceConfirmationDialogFragment;->a(II)Lcom/salesforce/android/cases/ui/internal/features/publisher/SalesforceConfirmationDialogFragment;

    move-result-object v0

    .line 242
    invoke-virtual {v0, p0}, Lcom/salesforce/android/cases/ui/internal/features/publisher/SalesforceConfirmationDialogFragment;->a(Lcom/salesforce/android/cases/ui/internal/features/publisher/SalesforceConfirmationDialogFragment$SalesforceConfirmationDialogListener;)V

    .line 243
    iget-object v1, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherView;->q:Landroid/support/v4/app/FragmentManager;

    const-string v2, "discardCaseDialogFragment"

    invoke-virtual {v0, v1, v2}, Lcom/salesforce/android/cases/ui/internal/features/publisher/SalesforceConfirmationDialogFragment;->show(Landroid/support/v4/app/FragmentManager;Ljava/lang/String;)V

    .line 245
    :cond_0
    return-void
.end method

.method public o()V
    .locals 1

    .prologue
    .line 248
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherView;->p:Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherContract$Presenter;

    invoke-interface {v0}, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherContract$Presenter;->h()V

    .line 249
    return-void
.end method

.method p()V
    .locals 1

    .prologue
    .line 263
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherView;->p:Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherContract$Presenter;

    if-eqz v0, :cond_0

    .line 264
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherView;->p:Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherContract$Presenter;

    invoke-interface {v0}, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherContract$Presenter;->b()V

    .line 266
    :cond_0
    return-void
.end method

.method public p_()V
    .locals 1

    .prologue
    .line 103
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherView;->g:Lcom/salesforce/android/service/common/ui/views/SalesforceProgressSpinner;

    invoke-static {v0}, Lcom/salesforce/android/cases/ui/internal/utils/ViewUtils;->b(Landroid/view/View;)V

    .line 104
    return-void
.end method

.method public q_()V
    .locals 1

    .prologue
    .line 107
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherView;->g:Lcom/salesforce/android/service/common/ui/views/SalesforceProgressSpinner;

    invoke-static {v0}, Lcom/salesforce/android/cases/ui/internal/utils/ViewUtils;->c(Landroid/view/View;)V

    .line 108
    return-void
.end method

.method public r_()V
    .locals 1

    .prologue
    .line 115
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherView;->h:Landroid/widget/ScrollView;

    invoke-static {v0}, Lcom/salesforce/android/cases/ui/internal/utils/ViewUtils;->c(Landroid/view/View;)V

    .line 116
    return-void
.end method

.method public setFragmentManager(Landroid/support/v4/app/FragmentManager;)V
    .locals 0

    .prologue
    .line 232
    iput-object p1, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherView;->q:Landroid/support/v4/app/FragmentManager;

    .line 233
    invoke-direct {p0}, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherView;->q()V

    .line 234
    return-void
.end method

.method public setPresenter(Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherContract$Presenter;)V
    .locals 0

    .prologue
    .line 228
    iput-object p1, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherView;->p:Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherContract$Presenter;

    .line 229
    return-void
.end method
