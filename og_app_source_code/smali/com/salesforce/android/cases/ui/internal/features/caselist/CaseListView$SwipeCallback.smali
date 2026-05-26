.class Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView$SwipeCallback;
.super Landroid/support/v7/widget/helper/ItemTouchHelper$SimpleCallback;
.source "CaseListView.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "SwipeCallback"
.end annotation


# instance fields
.field final synthetic a:Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView;

.field private b:Landroid/graphics/drawable/Drawable;

.field private c:Landroid/graphics/drawable/Drawable;

.field private d:I


# direct methods
.method constructor <init>(Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView;)V
    .locals 3

    .prologue
    .line 422
    iput-object p1, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView$SwipeCallback;->a:Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView;

    .line 423
    const/4 v0, 0x0

    const/16 v1, 0xc

    invoke-direct {p0, v0, v1}, Landroid/support/v7/widget/helper/ItemTouchHelper$SimpleCallback;-><init>(II)V

    .line 424
    new-instance v0, Landroid/graphics/drawable/ColorDrawable;

    .line 425
    invoke-virtual {p1}, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView;->getContext()Landroid/content/Context;

    move-result-object v1

    sget v2, Lcom/salesforce/android/cases/R$color;->salesforce_feedback_secondary:I

    invoke-static {v1, v2}, Landroid/support/v4/content/ContextCompat;->c(Landroid/content/Context;I)I

    move-result v1

    invoke-direct {v0, v1}, Landroid/graphics/drawable/ColorDrawable;-><init>(I)V

    iput-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView$SwipeCallback;->b:Landroid/graphics/drawable/Drawable;

    .line 426
    invoke-virtual {p1}, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    sget v1, Lcom/salesforce/android/cases/R$drawable;->cases_ic_check:I

    .line 427
    invoke-virtual {p1}, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView;->getContext()Landroid/content/Context;

    move-result-object v2

    invoke-virtual {v2}, Landroid/content/Context;->getTheme()Landroid/content/res/Resources$Theme;

    move-result-object v2

    .line 426
    invoke-static {v0, v1, v2}, Landroid/support/graphics/drawable/VectorDrawableCompat;->a(Landroid/content/res/Resources;ILandroid/content/res/Resources$Theme;)Landroid/support/graphics/drawable/VectorDrawableCompat;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView$SwipeCallback;->c:Landroid/graphics/drawable/Drawable;

    .line 429
    invoke-virtual {p1}, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    sget v1, Lcom/salesforce/android/cases/R$dimen;->cases_case_list_check_horizontal_margin:I

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v0

    iput v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView$SwipeCallback;->d:I

    .line 430
    return-void
.end method


# virtual methods
.method public a(Landroid/graphics/Canvas;Landroid/support/v7/widget/RecyclerView;Landroid/support/v7/widget/RecyclerView$ViewHolder;FFIZ)V
    .locals 12

    .prologue
    .line 448
    const/4 v1, 0x1

    move/from16 v0, p6

    if-ne v0, v1, :cond_0

    .line 452
    iget-object v1, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView$SwipeCallback;->a:Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView;

    iget-object v2, v1, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView;->h:Landroid/support/v4/widget/SwipeRefreshLayout;

    if-nez p7, :cond_1

    const/4 v1, 0x1

    :goto_0
    invoke-virtual {v2, v1}, Landroid/support/v4/widget/SwipeRefreshLayout;->setEnabled(Z)V

    .line 454
    iget-object v1, p3, Landroid/support/v7/widget/RecyclerView$ViewHolder;->itemView:Landroid/view/View;

    .line 457
    invoke-static/range {p4 .. p4}, Ljava/lang/Math;->abs(F)F

    move-result v2

    invoke-virtual {v1}, Landroid/view/View;->getWidth()I

    move-result v3

    int-to-float v3, v3

    div-float/2addr v2, v3

    .line 460
    invoke-virtual {v1}, Landroid/view/View;->getBottom()I

    move-result v3

    invoke-virtual {v1}, Landroid/view/View;->getTop()I

    move-result v4

    sub-int v4, v3, v4

    .line 461
    invoke-virtual {v1}, Landroid/view/View;->getRight()I

    move-result v3

    .line 462
    invoke-virtual {v1}, Landroid/view/View;->getLeft()I

    move-result v5

    .line 463
    invoke-virtual {v1}, Landroid/view/View;->getTop()I

    move-result v6

    .line 464
    invoke-virtual {v1}, Landroid/view/View;->getBottom()I

    move-result v7

    .line 471
    const/high16 v8, 0x3f000000    # 0.5f

    mul-float/2addr v8, v2

    .line 472
    iget-object v9, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView$SwipeCallback;->c:Landroid/graphics/drawable/Drawable;

    invoke-virtual {v9}, Landroid/graphics/drawable/Drawable;->getIntrinsicWidth()I

    move-result v9

    .line 473
    iget-object v10, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView$SwipeCallback;->c:Landroid/graphics/drawable/Drawable;

    invoke-virtual {v10}, Landroid/graphics/drawable/Drawable;->getIntrinsicHeight()I

    move-result v10

    .line 478
    int-to-float v11, v9

    int-to-float v9, v9

    mul-float/2addr v9, v8

    add-float/2addr v9, v11

    float-to-int v9, v9

    .line 479
    int-to-float v11, v10

    int-to-float v10, v10

    mul-float/2addr v8, v10

    add-float/2addr v8, v11

    float-to-int v8, v8

    .line 480
    sub-int/2addr v4, v8

    div-int/lit8 v4, v4, 0x2

    add-int v10, v6, v4

    .line 481
    add-int/2addr v8, v10

    .line 484
    const/high16 v4, 0x437f0000    # 255.0f

    mul-float/2addr v2, v4

    float-to-int v11, v2

    .line 487
    const/4 v2, 0x0

    cmpl-float v2, p4, v2

    if-lez v2, :cond_2

    .line 488
    invoke-virtual {v1}, Landroid/view/View;->getLeft()I

    move-result v4

    .line 489
    move/from16 v0, p4

    float-to-int v3, v0

    .line 490
    iget v1, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView$SwipeCallback;->d:I

    add-int v2, v5, v1

    .line 491
    add-int v1, v2, v9

    .line 500
    :goto_1
    iget-object v5, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView$SwipeCallback;->b:Landroid/graphics/drawable/Drawable;

    invoke-virtual {v5, v4, v6, v3, v7}, Landroid/graphics/drawable/Drawable;->setBounds(IIII)V

    .line 501
    iget-object v3, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView$SwipeCallback;->b:Landroid/graphics/drawable/Drawable;

    invoke-virtual {v3, p1}, Landroid/graphics/drawable/Drawable;->draw(Landroid/graphics/Canvas;)V

    .line 504
    iget-object v3, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView$SwipeCallback;->c:Landroid/graphics/drawable/Drawable;

    invoke-virtual {v3, v2, v10, v1, v8}, Landroid/graphics/drawable/Drawable;->setBounds(IIII)V

    .line 505
    iget-object v1, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView$SwipeCallback;->c:Landroid/graphics/drawable/Drawable;

    invoke-virtual {v1, v11}, Landroid/graphics/drawable/Drawable;->setAlpha(I)V

    .line 506
    iget-object v1, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView$SwipeCallback;->c:Landroid/graphics/drawable/Drawable;

    invoke-virtual {v1, p1}, Landroid/graphics/drawable/Drawable;->draw(Landroid/graphics/Canvas;)V

    .line 508
    invoke-super/range {p0 .. p7}, Landroid/support/v7/widget/helper/ItemTouchHelper$SimpleCallback;->a(Landroid/graphics/Canvas;Landroid/support/v7/widget/RecyclerView;Landroid/support/v7/widget/RecyclerView$ViewHolder;FFIZ)V

    .line 510
    :cond_0
    return-void

    .line 452
    :cond_1
    const/4 v1, 0x0

    goto :goto_0

    .line 493
    :cond_2
    int-to-float v1, v3

    add-float v1, v1, p4

    float-to-int v4, v1

    .line 495
    iget v1, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView$SwipeCallback;->d:I

    sub-int v1, v3, v1

    .line 496
    sub-int v2, v1, v9

    goto :goto_1
.end method

.method public a(Landroid/support/v7/widget/RecyclerView$ViewHolder;I)V
    .locals 2

    .prologue
    .line 439
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView$SwipeCallback;->a:Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView;

    iget-object v0, v0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView;->q:Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListAdapter;

    invoke-virtual {p1}, Landroid/support/v7/widget/RecyclerView$ViewHolder;->getAdapterPosition()I

    move-result v1

    invoke-virtual {v0, v1}, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListAdapter;->a(I)Lcom/salesforce/android/cases/ui/internal/features/caselist/viewmodel/CaseListItemViewModel;

    move-result-object v0

    .line 440
    if-eqz v0, :cond_0

    .line 441
    iget-object v1, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView$SwipeCallback;->a:Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView;

    invoke-virtual {v1, v0}, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView;->e(Lcom/salesforce/android/cases/ui/internal/features/caselist/viewmodel/CaseListItemViewModel;)V

    .line 443
    :cond_0
    return-void
.end method

.method public b(Landroid/support/v7/widget/RecyclerView;Landroid/support/v7/widget/RecyclerView$ViewHolder;Landroid/support/v7/widget/RecyclerView$ViewHolder;)Z
    .locals 1

    .prologue
    .line 435
    const/4 v0, 0x0

    return v0
.end method
