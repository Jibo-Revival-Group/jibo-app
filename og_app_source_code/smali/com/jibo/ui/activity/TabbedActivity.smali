.class public Lcom/jibo/ui/activity/TabbedActivity;
.super Lcom/jibo/ui/activity/BaseActivity;
.source "TabbedActivity.java"

# interfaces
.implements Landroid/app/LoaderManager$LoaderCallbacks;
.implements Lcom/jibo/ui/activity/BaseActivity$OnDoubleBackButtonListener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/jibo/ui/activity/TabbedActivity$TabsState;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/jibo/ui/activity/BaseActivity;",
        "Landroid/app/LoaderManager$LoaderCallbacks",
        "<",
        "Landroid/database/Cursor;",
        ">;",
        "Lcom/jibo/ui/activity/BaseActivity$OnDoubleBackButtonListener;"
    }
.end annotation


# static fields
.field private static final h:[Z

.field private static final i:[Z

.field private static l:[Z

.field private static m:[Z

.field private static n:[Ljava/lang/String;

.field private static o:[Ljava/lang/String;


# instance fields
.field private j:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/jibo/aws/integration/aws/services/loop/model/Loop;",
            ">;"
        }
    .end annotation
.end field

.field jiboList:Landroid/support/v7/widget/RecyclerView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field jiboListContainer:Landroid/view/View;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field private k:Landroid/os/CountDownTimer;

.field mSelectorDimmer:Landroid/view/View;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field private p:I

.field private q:Lcom/jibo/ui/activity/TabbedActivity$TabsState;

.field private r:Landroid/support/v4/app/Fragment;

.field private s:Ljava/lang/String;

.field private t:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

.field tabs:Landroid/widget/LinearLayout;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field private u:Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter;

.field private v:Landroid/support/v7/view/ActionMode;

.field private w:Z

.field private x:Landroid/view/View$OnClickListener;

.field private y:Landroid/view/View$OnClickListener;

.field private z:Landroid/view/View$OnClickListener;


# direct methods
.method static constructor <clinit>()V
    .locals 6

    .prologue
    const/4 v5, 0x3

    const/4 v4, 0x2

    const/4 v3, 0x1

    const/4 v2, 0x0

    const/4 v1, 0x4

    .line 74
    new-array v0, v1, [Z

    fill-array-data v0, :array_0

    sput-object v0, Lcom/jibo/ui/activity/TabbedActivity;->h:[Z

    .line 75
    new-array v0, v1, [Z

    fill-array-data v0, :array_1

    sput-object v0, Lcom/jibo/ui/activity/TabbedActivity;->i:[Z

    .line 81
    sget-object v0, Lcom/jibo/ui/activity/TabbedActivity;->i:[Z

    check-cast v0, [Z

    sput-object v0, Lcom/jibo/ui/activity/TabbedActivity;->l:[Z

    .line 82
    new-array v0, v1, [Z

    fill-array-data v0, :array_2

    sput-object v0, Lcom/jibo/ui/activity/TabbedActivity;->m:[Z

    .line 84
    new-array v0, v1, [Ljava/lang/String;

    const-class v1, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;

    invoke-virtual {v1}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v1

    aput-object v1, v0, v2

    const-class v1, Lcom/jibo/ui/fragment/home/MediaFragment;

    invoke-virtual {v1}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v1

    aput-object v1, v0, v3

    const-class v1, Lcom/jibo/ui/fragment/tips/TipsListFragment;

    invoke-virtual {v1}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v1

    aput-object v1, v0, v4

    const-class v1, Lcom/jibo/ui/fragment/tips/TipsListFragment;

    invoke-virtual {v1}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v1

    aput-object v1, v0, v5

    sput-object v0, Lcom/jibo/ui/activity/TabbedActivity;->n:[Ljava/lang/String;

    .line 86
    new-array v0, v5, [Ljava/lang/String;

    const-class v1, Lcom/jibo/ui/fragment/jibos/NoLoopsFragment;

    invoke-virtual {v1}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v1

    aput-object v1, v0, v2

    const-class v1, Lcom/jibo/ui/fragment/home/MediaFragment;

    invoke-virtual {v1}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v1

    aput-object v1, v0, v3

    const-class v1, Lcom/jibo/ui/fragment/tips/TipsListFragment;

    invoke-virtual {v1}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v1

    aput-object v1, v0, v4

    sput-object v0, Lcom/jibo/ui/activity/TabbedActivity;->o:[Ljava/lang/String;

    return-void

    .line 74
    nop

    :array_0
    .array-data 1
        0x1t
        0x1t
        0x1t
        0x1t
    .end array-data

    .line 75
    :array_1
    .array-data 1
        0x1t
        0x1t
        0x1t
        0x1t
    .end array-data

    .line 82
    :array_2
    .array-data 1
        0x1t
        0x0t
        0x1t
        0x1t
    .end array-data
.end method

.method public constructor <init>()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 58
    invoke-direct {p0}, Lcom/jibo/ui/activity/BaseActivity;-><init>()V

    .line 88
    const/4 v0, -0x1

    iput v0, p0, Lcom/jibo/ui/activity/TabbedActivity;->p:I

    .line 89
    iput-object v1, p0, Lcom/jibo/ui/activity/TabbedActivity;->q:Lcom/jibo/ui/activity/TabbedActivity$TabsState;

    .line 109
    iput-object v1, p0, Lcom/jibo/ui/activity/TabbedActivity;->s:Ljava/lang/String;

    .line 110
    iput-object v1, p0, Lcom/jibo/ui/activity/TabbedActivity;->t:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    .line 115
    new-instance v0, Lcom/jibo/ui/activity/TabbedActivity$1;

    invoke-direct {v0, p0}, Lcom/jibo/ui/activity/TabbedActivity$1;-><init>(Lcom/jibo/ui/activity/TabbedActivity;)V

    iput-object v0, p0, Lcom/jibo/ui/activity/TabbedActivity;->x:Landroid/view/View$OnClickListener;

    .line 122
    new-instance v0, Lcom/jibo/ui/activity/TabbedActivity$2;

    invoke-direct {v0, p0}, Lcom/jibo/ui/activity/TabbedActivity$2;-><init>(Lcom/jibo/ui/activity/TabbedActivity;)V

    iput-object v0, p0, Lcom/jibo/ui/activity/TabbedActivity;->y:Landroid/view/View$OnClickListener;

    .line 435
    new-instance v0, Lcom/jibo/ui/activity/TabbedActivity$5;

    invoke-direct {v0, p0}, Lcom/jibo/ui/activity/TabbedActivity$5;-><init>(Lcom/jibo/ui/activity/TabbedActivity;)V

    iput-object v0, p0, Lcom/jibo/ui/activity/TabbedActivity;->z:Landroid/view/View$OnClickListener;

    return-void
.end method

.method private A()V
    .locals 1

    .prologue
    .line 460
    iget-object v0, p0, Lcom/jibo/ui/activity/TabbedActivity;->v:Landroid/support/v7/view/ActionMode;

    if-eqz v0, :cond_0

    .line 461
    iget-object v0, p0, Lcom/jibo/ui/activity/TabbedActivity;->v:Landroid/support/v7/view/ActionMode;

    invoke-virtual {v0}, Landroid/support/v7/view/ActionMode;->c()V

    .line 463
    :cond_0
    return-void
.end method

.method private B()V
    .locals 1

    .prologue
    .line 533
    invoke-direct {p0}, Lcom/jibo/ui/activity/TabbedActivity;->z()V

    .line 534
    iget-object v0, p0, Lcom/jibo/ui/activity/TabbedActivity;->jiboList:Landroid/support/v7/widget/RecyclerView;

    invoke-virtual {v0}, Landroid/support/v7/widget/RecyclerView;->getTag()Ljava/lang/Object;

    move-result-object v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/jibo/ui/activity/TabbedActivity;->jiboList:Landroid/support/v7/widget/RecyclerView;

    invoke-virtual {v0}, Landroid/support/v7/widget/RecyclerView;->getTag()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Boolean;

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 540
    :goto_0
    return-void

    .line 535
    :cond_0
    iget-object v0, p0, Lcom/jibo/ui/activity/TabbedActivity;->jiboListContainer:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->isShown()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 536
    invoke-direct {p0}, Lcom/jibo/ui/activity/TabbedActivity;->D()V

    goto :goto_0

    .line 538
    :cond_1
    invoke-direct {p0}, Lcom/jibo/ui/activity/TabbedActivity;->C()V

    goto :goto_0
.end method

.method private C()V
    .locals 10

    .prologue
    const-wide/16 v8, 0x258

    const/4 v6, 0x0

    const/4 v5, 0x0

    const/4 v4, 0x0

    .line 543
    iget-object v0, p0, Lcom/jibo/ui/activity/TabbedActivity;->jiboList:Landroid/support/v7/widget/RecyclerView;

    const/4 v1, 0x1

    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/support/v7/widget/RecyclerView;->setTag(Ljava/lang/Object;)V

    .line 544
    iget-object v0, p0, Lcom/jibo/ui/activity/TabbedActivity;->mSelectorDimmer:Landroid/view/View;

    if-eqz v0, :cond_0

    .line 545
    iget-object v0, p0, Lcom/jibo/ui/activity/TabbedActivity;->mSelectorDimmer:Landroid/view/View;

    invoke-virtual {v0, v5}, Landroid/view/View;->setAlpha(F)V

    .line 546
    iget-object v0, p0, Lcom/jibo/ui/activity/TabbedActivity;->mSelectorDimmer:Landroid/view/View;

    invoke-virtual {v0, v6}, Landroid/view/View;->setVisibility(I)V

    .line 548
    iget-object v0, p0, Lcom/jibo/ui/activity/TabbedActivity;->mSelectorDimmer:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->animate()Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    const/high16 v1, 0x3f800000    # 1.0f

    invoke-virtual {v0, v1}, Landroid/view/ViewPropertyAnimator;->alpha(F)Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    invoke-virtual {v0, v4}, Landroid/view/ViewPropertyAnimator;->setListener(Landroid/animation/Animator$AnimatorListener;)Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    const-wide/16 v2, 0x1f4

    invoke-virtual {v0, v2, v3}, Landroid/view/ViewPropertyAnimator;->setDuration(J)Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    invoke-virtual {v0}, Landroid/view/ViewPropertyAnimator;->start()V

    .line 551
    :cond_0
    iget-object v0, p0, Lcom/jibo/ui/activity/TabbedActivity;->jiboListContainer:Landroid/view/View;

    iget-object v1, p0, Lcom/jibo/ui/activity/TabbedActivity;->u:Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter;

    invoke-virtual {v1}, Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter;->getItemCount()I

    move-result v1

    neg-int v1, v1

    invoke-virtual {p0}, Lcom/jibo/ui/activity/TabbedActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f070087

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getDimensionPixelOffset(I)I

    move-result v2

    mul-int/2addr v1, v2

    int-to-float v1, v1

    invoke-virtual {v0, v1}, Landroid/view/View;->setY(F)V

    .line 553
    iget-object v0, p0, Lcom/jibo/ui/activity/TabbedActivity;->jiboListContainer:Landroid/view/View;

    invoke-virtual {v0, v6}, Landroid/view/View;->setVisibility(I)V

    .line 554
    iget-object v0, p0, Lcom/jibo/ui/activity/TabbedActivity;->jiboListContainer:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->animate()Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    invoke-virtual {v0, v5}, Landroid/view/ViewPropertyAnimator;->y(F)Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    invoke-virtual {v0, v8, v9}, Landroid/view/ViewPropertyAnimator;->setDuration(J)Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    invoke-virtual {v0, v4}, Landroid/view/ViewPropertyAnimator;->setListener(Landroid/animation/Animator$AnimatorListener;)Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    new-instance v1, Landroid/view/animation/DecelerateInterpolator;

    invoke-direct {v1}, Landroid/view/animation/DecelerateInterpolator;-><init>()V

    invoke-virtual {v0, v1}, Landroid/view/ViewPropertyAnimator;->setInterpolator(Landroid/animation/TimeInterpolator;)Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    invoke-virtual {v0}, Landroid/view/ViewPropertyAnimator;->start()V

    .line 555
    iget-object v0, p0, Lcom/jibo/ui/activity/TabbedActivity;->jiboList:Landroid/support/v7/widget/RecyclerView;

    new-instance v1, Lcom/jibo/ui/activity/TabbedActivity$6;

    invoke-direct {v1, p0}, Lcom/jibo/ui/activity/TabbedActivity$6;-><init>(Lcom/jibo/ui/activity/TabbedActivity;)V

    invoke-virtual {v0, v1, v8, v9}, Landroid/support/v7/widget/RecyclerView;->postDelayed(Ljava/lang/Runnable;J)Z

    .line 563
    invoke-virtual {p0}, Lcom/jibo/ui/activity/TabbedActivity;->a()Landroid/widget/TextView;

    move-result-object v0

    .line 564
    if-eqz v0, :cond_1

    .line 565
    const v1, 0x7f08011e

    const v2, 0x7f0600df

    .line 566
    invoke-static {p0, v1, v2}, Lcom/jibo/utils/ImageUtils;->a(Landroid/content/Context;II)Landroid/graphics/drawable/Drawable;

    move-result-object v1

    .line 565
    invoke-virtual {v0, v4, v4, v1, v4}, Landroid/widget/TextView;->setCompoundDrawablesWithIntrinsicBounds(Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)V

    .line 568
    :cond_1
    return-void
.end method

.method private D()V
    .locals 5

    .prologue
    const/4 v4, 0x0

    .line 571
    iget-object v0, p0, Lcom/jibo/ui/activity/TabbedActivity;->jiboList:Landroid/support/v7/widget/RecyclerView;

    const/4 v1, 0x1

    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/support/v7/widget/RecyclerView;->setTag(Ljava/lang/Object;)V

    .line 572
    iget-object v0, p0, Lcom/jibo/ui/activity/TabbedActivity;->mSelectorDimmer:Landroid/view/View;

    if-eqz v0, :cond_0

    .line 573
    iget-object v0, p0, Lcom/jibo/ui/activity/TabbedActivity;->mSelectorDimmer:Landroid/view/View;

    const/high16 v1, 0x3f800000    # 1.0f

    invoke-virtual {v0, v1}, Landroid/view/View;->setAlpha(F)V

    .line 574
    iget-object v0, p0, Lcom/jibo/ui/activity/TabbedActivity;->mSelectorDimmer:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->animate()Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/view/ViewPropertyAnimator;->alpha(F)Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    const-wide/16 v2, 0x1f4

    invoke-virtual {v0, v2, v3}, Landroid/view/ViewPropertyAnimator;->setDuration(J)Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    new-instance v1, Lcom/jibo/ui/activity/TabbedActivity$7;

    invoke-direct {v1, p0}, Lcom/jibo/ui/activity/TabbedActivity$7;-><init>(Lcom/jibo/ui/activity/TabbedActivity;)V

    invoke-virtual {v0, v1}, Landroid/view/ViewPropertyAnimator;->setListener(Landroid/animation/Animator$AnimatorListener;)Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    .line 590
    invoke-virtual {v0}, Landroid/view/ViewPropertyAnimator;->start()V

    .line 593
    :cond_0
    iget-object v0, p0, Lcom/jibo/ui/activity/TabbedActivity;->jiboListContainer:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->animate()Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    iget-object v1, p0, Lcom/jibo/ui/activity/TabbedActivity;->u:Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter;

    invoke-virtual {v1}, Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter;->getItemCount()I

    move-result v1

    neg-int v1, v1

    invoke-virtual {p0}, Lcom/jibo/ui/activity/TabbedActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f070087

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getDimensionPixelOffset(I)I

    move-result v2

    mul-int/2addr v1, v2

    int-to-float v1, v1

    invoke-virtual {v0, v1}, Landroid/view/ViewPropertyAnimator;->y(F)Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    const-wide/16 v2, 0x190

    .line 594
    invoke-virtual {v0, v2, v3}, Landroid/view/ViewPropertyAnimator;->setDuration(J)Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    new-instance v1, Lcom/jibo/ui/activity/TabbedActivity$8;

    invoke-direct {v1, p0}, Lcom/jibo/ui/activity/TabbedActivity$8;-><init>(Lcom/jibo/ui/activity/TabbedActivity;)V

    invoke-virtual {v0, v1}, Landroid/view/ViewPropertyAnimator;->setListener(Landroid/animation/Animator$AnimatorListener;)Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    new-instance v1, Landroid/view/animation/AccelerateInterpolator;

    invoke-direct {v1}, Landroid/view/animation/AccelerateInterpolator;-><init>()V

    .line 606
    invoke-virtual {v0, v1}, Landroid/view/ViewPropertyAnimator;->setInterpolator(Landroid/animation/TimeInterpolator;)Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    invoke-virtual {v0}, Landroid/view/ViewPropertyAnimator;->start()V

    .line 607
    iget-object v0, p0, Lcom/jibo/ui/activity/TabbedActivity;->jiboList:Landroid/support/v7/widget/RecyclerView;

    new-instance v1, Lcom/jibo/ui/activity/TabbedActivity$9;

    invoke-direct {v1, p0}, Lcom/jibo/ui/activity/TabbedActivity$9;-><init>(Lcom/jibo/ui/activity/TabbedActivity;)V

    const-wide/16 v2, 0x258

    invoke-virtual {v0, v1, v2, v3}, Landroid/support/v7/widget/RecyclerView;->postDelayed(Ljava/lang/Runnable;J)Z

    .line 615
    invoke-virtual {p0}, Lcom/jibo/ui/activity/TabbedActivity;->a()Landroid/widget/TextView;

    move-result-object v0

    .line 616
    if-eqz v0, :cond_1

    .line 617
    const v1, 0x7f08011d

    const v2, 0x7f0600df

    .line 618
    invoke-static {p0, v1, v2}, Lcom/jibo/utils/ImageUtils;->a(Landroid/content/Context;II)Landroid/graphics/drawable/Drawable;

    move-result-object v1

    .line 617
    invoke-virtual {v0, v4, v4, v1, v4}, Landroid/widget/TextView;->setCompoundDrawablesWithIntrinsicBounds(Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)V

    .line 621
    :cond_1
    return-void
.end method

.method private E()V
    .locals 4

    .prologue
    const/16 v1, 0x8

    const/4 v3, 0x0

    .line 624
    iget-object v0, p0, Lcom/jibo/ui/activity/TabbedActivity;->mSelectorDimmer:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 625
    iget-object v0, p0, Lcom/jibo/ui/activity/TabbedActivity;->jiboListContainer:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 628
    invoke-virtual {p0}, Lcom/jibo/ui/activity/TabbedActivity;->a()Landroid/widget/TextView;

    move-result-object v0

    .line 629
    if-eqz v0, :cond_0

    .line 630
    const v1, 0x7f08011d

    const v2, 0x7f0600df

    .line 631
    invoke-static {p0, v1, v2}, Lcom/jibo/utils/ImageUtils;->a(Landroid/content/Context;II)Landroid/graphics/drawable/Drawable;

    move-result-object v1

    .line 630
    invoke-virtual {v0, v3, v3, v1, v3}, Landroid/widget/TextView;->setCompoundDrawablesWithIntrinsicBounds(Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)V

    .line 633
    :cond_0
    return-void
.end method

.method private F()V
    .locals 2

    .prologue
    .line 636
    iget-object v0, p0, Lcom/jibo/ui/activity/TabbedActivity;->j:Ljava/util/ArrayList;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/jibo/ui/activity/TabbedActivity;->j:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 641
    :cond_0
    return-void

    .line 638
    :cond_1
    iget-object v0, p0, Lcom/jibo/ui/activity/TabbedActivity;->j:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    .line 639
    invoke-direct {p0, v0}, Lcom/jibo/ui/activity/TabbedActivity;->a(Lcom/jibo/aws/integration/aws/services/loop/model/Loop;)V

    goto :goto_0
.end method

.method private a(I)V
    .locals 5

    .prologue
    const/4 v1, 0x0

    const/4 v4, 0x0

    .line 479
    iget-object v0, p0, Lcom/jibo/ui/activity/TabbedActivity;->mSelectorDimmer:Landroid/view/View;

    invoke-virtual {v0, v4}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 482
    invoke-virtual {p0}, Lcom/jibo/ui/activity/TabbedActivity;->a()Landroid/widget/TextView;

    move-result-object v0

    .line 483
    invoke-virtual {p0}, Lcom/jibo/ui/activity/TabbedActivity;->getSupportActionBar()Landroid/support/v7/app/ActionBar;

    move-result-object v2

    const-string v3, ""

    invoke-virtual {v2, v3}, Landroid/support/v7/app/ActionBar;->setSubtitle(Ljava/lang/CharSequence;)V

    .line 484
    if-eqz v0, :cond_1

    .line 485
    if-nez p1, :cond_2

    .line 486
    invoke-virtual {p0}, Lcom/jibo/ui/activity/TabbedActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f070089

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v2

    invoke-virtual {v0, v2}, Landroid/widget/TextView;->setCompoundDrawablePadding(I)V

    .line 487
    const v2, 0x7f08011d

    const v3, 0x7f0600df

    .line 488
    invoke-static {p0, v2, v3}, Lcom/jibo/utils/ImageUtils;->a(Landroid/content/Context;II)Landroid/graphics/drawable/Drawable;

    move-result-object v2

    .line 487
    invoke-virtual {v0, v4, v4, v2, v4}, Landroid/widget/TextView;->setCompoundDrawablesWithIntrinsicBounds(Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)V

    .line 489
    invoke-virtual {v0}, Landroid/widget/TextView;->getParent()Landroid/view/ViewParent;

    move-result-object v2

    if-eqz v2, :cond_0

    .line 490
    invoke-virtual {v0}, Landroid/widget/TextView;->getParent()Landroid/view/ViewParent;

    move-result-object v0

    check-cast v0, Landroid/view/View;

    iget-object v2, p0, Lcom/jibo/ui/activity/TabbedActivity;->x:Landroid/view/View$OnClickListener;

    invoke-virtual {v0, v2}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 492
    :cond_0
    iget-object v0, p0, Lcom/jibo/ui/activity/TabbedActivity;->mSelectorDimmer:Landroid/view/View;

    iget-object v2, p0, Lcom/jibo/ui/activity/TabbedActivity;->x:Landroid/view/View$OnClickListener;

    invoke-virtual {v0, v2}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 502
    :cond_1
    :goto_0
    invoke-direct {p0, p1}, Lcom/jibo/ui/activity/TabbedActivity;->b(I)V

    move v0, v1

    .line 505
    :goto_1
    sget-object v2, Lcom/jibo/ui/activity/TabbedActivity;->n:[Ljava/lang/String;

    array-length v2, v2

    if-ge v0, v2, :cond_3

    .line 506
    iget-object v2, p0, Lcom/jibo/ui/activity/TabbedActivity;->tabs:Landroid/widget/LinearLayout;

    invoke-virtual {v2, v0}, Landroid/widget/LinearLayout;->getChildAt(I)Landroid/view/View;

    move-result-object v2

    invoke-virtual {v2, v1}, Landroid/view/View;->setSelected(Z)V

    .line 505
    add-int/lit8 v0, v0, 0x1

    goto :goto_1

    .line 494
    :cond_2
    invoke-virtual {v0, v4, v4, v4, v4}, Landroid/widget/TextView;->setCompoundDrawablesWithIntrinsicBounds(Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)V

    .line 495
    invoke-virtual {v0}, Landroid/widget/TextView;->getParent()Landroid/view/ViewParent;

    move-result-object v0

    check-cast v0, Landroid/view/View;

    invoke-virtual {v0, v4}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    goto :goto_0

    .line 509
    :cond_3
    iget-object v0, p0, Lcom/jibo/ui/activity/TabbedActivity;->tabs:Landroid/widget/LinearLayout;

    invoke-virtual {v0, p1}, Landroid/widget/LinearLayout;->getChildAt(I)Landroid/view/View;

    move-result-object v0

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Landroid/view/View;->setSelected(Z)V

    .line 511
    return-void
.end method

.method private a(IZ)V
    .locals 1

    .prologue
    .line 443
    const/4 v0, 0x3

    if-ne p1, v0, :cond_1

    .line 444
    sget-object v0, Lcom/jibo/JiboAnalytics;->aI:Ljava/lang/String;

    invoke-static {p0, v0}, Lcom/jibo/JiboAnalytics;->e(Landroid/content/Context;Ljava/lang/String;)V

    .line 445
    invoke-static {p0}, Lcom/jibo/JiboSupport;->a(Landroid/app/Activity;)V

    .line 457
    :cond_0
    :goto_0
    return-void

    .line 447
    :cond_1
    iget v0, p0, Lcom/jibo/ui/activity/TabbedActivity;->p:I

    if-ne v0, p1, :cond_2

    if-eqz p2, :cond_0

    .line 448
    :cond_2
    invoke-virtual {p0}, Lcom/jibo/ui/activity/TabbedActivity;->f()V

    .line 450
    invoke-direct {p0, p1}, Lcom/jibo/ui/activity/TabbedActivity;->a(I)V

    .line 452
    iput p1, p0, Lcom/jibo/ui/activity/TabbedActivity;->p:I

    .line 454
    invoke-direct {p0}, Lcom/jibo/ui/activity/TabbedActivity;->A()V

    goto :goto_0
.end method

.method public static a(Landroid/app/Activity;Landroid/os/Bundle;)V
    .locals 2

    .prologue
    .line 131
    new-instance v0, Landroid/content/Intent;

    const-class v1, Lcom/jibo/ui/activity/TabbedActivity;

    invoke-direct {v0, p0, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 132
    const v1, 0x14008000

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setFlags(I)Landroid/content/Intent;

    .line 134
    const-string v1, "ARG_EXTRAS"

    invoke-virtual {v0, v1, p1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Landroid/os/Bundle;)Landroid/content/Intent;

    .line 135
    invoke-virtual {p0, v0}, Landroid/app/Activity;->startActivity(Landroid/content/Intent;)V

    .line 136
    invoke-virtual {p0}, Landroid/app/Activity;->finish()V

    .line 137
    return-void
.end method

.method private a(Lcom/jibo/aws/integration/aws/services/loop/model/Loop;)V
    .locals 3

    .prologue
    .line 644
    if-nez p1, :cond_0

    .line 663
    :goto_0
    return-void

    .line 646
    :cond_0
    invoke-static {p0}, Lcom/jibo/db/EntityData;->a(Landroid/content/Context;)Lcom/jibo/db/EntityData;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/db/EntityData;->g()Lcom/jibo/aws/integration/aws/services/robotProperties/JiboRobotPropertiesAsyncClient;

    move-result-object v0

    invoke-virtual {p1}, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;->getRobotFriendlyId()Ljava/lang/String;

    move-result-object v1

    new-instance v2, Lcom/jibo/ui/activity/TabbedActivity$10;

    invoke-direct {v2, p0}, Lcom/jibo/ui/activity/TabbedActivity$10;-><init>(Lcom/jibo/ui/activity/TabbedActivity;)V

    invoke-virtual {v0, v1, v2}, Lcom/jibo/aws/integration/aws/services/robotProperties/JiboRobotPropertiesAsyncClient;->getRobot(Ljava/lang/String;Lcom/amazonaws/handlers/AsyncHandler;)Ljava/util/concurrent/Future;

    goto :goto_0
.end method

.method private a(Lcom/jibo/ui/activity/TabbedActivity$TabsState;)V
    .locals 5

    .prologue
    const/4 v2, 0x0

    .line 396
    invoke-virtual {p0}, Lcom/jibo/ui/activity/TabbedActivity;->isFinishing()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 433
    :cond_0
    return-void

    .line 398
    :cond_1
    sget-object v0, Lcom/jibo/ui/activity/TabbedActivity$TabsState;->initial:Lcom/jibo/ui/activity/TabbedActivity$TabsState;

    if-ne p1, v0, :cond_5

    sget-object v0, Lcom/jibo/ui/activity/TabbedActivity;->m:[Z

    .line 403
    :goto_0
    iget v1, p0, Lcom/jibo/ui/activity/TabbedActivity;->p:I

    const/4 v3, -0x1

    if-ne v1, v3, :cond_6

    .line 404
    sget-object v1, Lcom/jibo/ui/activity/TabbedActivity$TabsState;->initial:Lcom/jibo/ui/activity/TabbedActivity$TabsState;

    if-ne p1, v1, :cond_2

    :cond_2
    move v1, v2

    .line 410
    :goto_1
    iget-object v3, p0, Lcom/jibo/ui/activity/TabbedActivity;->q:Lcom/jibo/ui/activity/TabbedActivity$TabsState;

    if-eq p1, v3, :cond_4

    .line 412
    iput-object p1, p0, Lcom/jibo/ui/activity/TabbedActivity;->q:Lcom/jibo/ui/activity/TabbedActivity$TabsState;

    .line 417
    invoke-virtual {p0}, Lcom/jibo/ui/activity/TabbedActivity;->q()Landroid/os/Bundle;

    move-result-object v3

    if-eqz v3, :cond_3

    .line 418
    invoke-virtual {p0}, Lcom/jibo/ui/activity/TabbedActivity;->q()Landroid/os/Bundle;

    move-result-object v3

    const-string v4, "ARG_TAB_SELECTED"

    invoke-virtual {v3, v4, v1}, Landroid/os/Bundle;->getInt(Ljava/lang/String;I)I

    move-result v1

    .line 422
    :cond_3
    const/4 v3, 0x1

    invoke-direct {p0, v1, v3}, Lcom/jibo/ui/activity/TabbedActivity;->a(IZ)V

    :cond_4
    move v1, v2

    .line 425
    :goto_2
    sget-object v3, Lcom/jibo/ui/activity/TabbedActivity;->n:[Ljava/lang/String;

    array-length v3, v3

    if-ge v1, v3, :cond_0

    .line 428
    iget-object v3, p0, Lcom/jibo/ui/activity/TabbedActivity;->tabs:Landroid/widget/LinearLayout;

    invoke-virtual {v3, v1}, Landroid/widget/LinearLayout;->getChildAt(I)Landroid/view/View;

    move-result-object v4

    aget-boolean v3, v0, v1

    if-eqz v3, :cond_7

    move v3, v2

    :goto_3
    invoke-virtual {v4, v3}, Landroid/view/View;->setVisibility(I)V

    .line 430
    iget-object v3, p0, Lcom/jibo/ui/activity/TabbedActivity;->tabs:Landroid/widget/LinearLayout;

    invoke-virtual {v3, v1}, Landroid/widget/LinearLayout;->getChildAt(I)Landroid/view/View;

    move-result-object v3

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    invoke-virtual {v3, v4}, Landroid/view/View;->setTag(Ljava/lang/Object;)V

    .line 431
    iget-object v3, p0, Lcom/jibo/ui/activity/TabbedActivity;->tabs:Landroid/widget/LinearLayout;

    invoke-virtual {v3, v1}, Landroid/widget/LinearLayout;->getChildAt(I)Landroid/view/View;

    move-result-object v3

    iget-object v4, p0, Lcom/jibo/ui/activity/TabbedActivity;->z:Landroid/view/View$OnClickListener;

    invoke-virtual {v3, v4}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 425
    add-int/lit8 v1, v1, 0x1

    goto :goto_2

    .line 398
    :cond_5
    sget-object v0, Lcom/jibo/ui/activity/TabbedActivity;->l:[Z

    goto :goto_0

    .line 406
    :cond_6
    iget v1, p0, Lcom/jibo/ui/activity/TabbedActivity;->p:I

    goto :goto_1

    .line 428
    :cond_7
    const/16 v3, 0x8

    goto :goto_3
.end method

.method static synthetic a(Lcom/jibo/ui/activity/TabbedActivity;)V
    .locals 0

    .prologue
    .line 58
    invoke-direct {p0}, Lcom/jibo/ui/activity/TabbedActivity;->B()V

    return-void
.end method

.method static synthetic a(Lcom/jibo/ui/activity/TabbedActivity;IZ)V
    .locals 0

    .prologue
    .line 58
    invoke-direct {p0, p1, p2}, Lcom/jibo/ui/activity/TabbedActivity;->a(IZ)V

    return-void
.end method

.method static synthetic a(Lcom/jibo/ui/activity/TabbedActivity;Lcom/jibo/aws/integration/aws/services/loop/model/Loop;)V
    .locals 0

    .prologue
    .line 58
    invoke-direct {p0, p1}, Lcom/jibo/ui/activity/TabbedActivity;->d(Lcom/jibo/aws/integration/aws/services/loop/model/Loop;)V

    return-void
.end method

.method private b(I)V
    .locals 4

    .prologue
    .line 515
    const/4 v0, 0x1

    if-ne p1, v0, :cond_1

    .line 516
    invoke-static {p0}, Lcom/jibo/JiboAnalytics;->d(Landroid/content/Context;)V

    .line 521
    :cond_0
    :goto_0
    invoke-virtual {p0}, Lcom/jibo/ui/activity/TabbedActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentManager;->a()Landroid/support/v4/app/FragmentTransaction;

    move-result-object v0

    .line 522
    iget-object v1, p0, Lcom/jibo/ui/activity/TabbedActivity;->q:Lcom/jibo/ui/activity/TabbedActivity$TabsState;

    sget-object v2, Lcom/jibo/ui/activity/TabbedActivity$TabsState;->complete:Lcom/jibo/ui/activity/TabbedActivity$TabsState;

    if-ne v1, v2, :cond_2

    .line 523
    sget-object v1, Lcom/jibo/ui/activity/TabbedActivity;->n:[Ljava/lang/String;

    aget-object v1, v1, p1

    invoke-virtual {p0}, Lcom/jibo/ui/activity/TabbedActivity;->getIntent()Landroid/content/Intent;

    move-result-object v2

    invoke-virtual {v2}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v2

    invoke-static {p0, v1, v2}, Landroid/support/v4/app/Fragment;->instantiate(Landroid/content/Context;Ljava/lang/String;Landroid/os/Bundle;)Landroid/support/v4/app/Fragment;

    move-result-object v1

    iput-object v1, p0, Lcom/jibo/ui/activity/TabbedActivity;->r:Landroid/support/v4/app/Fragment;

    .line 527
    :goto_1
    const v1, 0x7f09013f

    iget-object v2, p0, Lcom/jibo/ui/activity/TabbedActivity;->r:Landroid/support/v4/app/Fragment;

    iget-object v3, p0, Lcom/jibo/ui/activity/TabbedActivity;->r:Landroid/support/v4/app/Fragment;

    invoke-virtual {v3}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v3

    .line 528
    invoke-virtual {v3}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v3

    .line 527
    invoke-virtual {v0, v1, v2, v3}, Landroid/support/v4/app/FragmentTransaction;->b(ILandroid/support/v4/app/Fragment;Ljava/lang/String;)Landroid/support/v4/app/FragmentTransaction;

    move-result-object v0

    .line 529
    invoke-virtual {v0}, Landroid/support/v4/app/FragmentTransaction;->d()I

    .line 530
    return-void

    .line 517
    :cond_1
    const/4 v0, 0x2

    if-ne p1, v0, :cond_0

    .line 518
    invoke-static {p0}, Lcom/jibo/JiboAnalytics;->g(Landroid/content/Context;)V

    goto :goto_0

    .line 525
    :cond_2
    sget-object v1, Lcom/jibo/ui/activity/TabbedActivity;->o:[Ljava/lang/String;

    aget-object v1, v1, p1

    invoke-virtual {p0}, Lcom/jibo/ui/activity/TabbedActivity;->getIntent()Landroid/content/Intent;

    move-result-object v2

    invoke-virtual {v2}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v2

    invoke-static {p0, v1, v2}, Landroid/support/v4/app/Fragment;->instantiate(Landroid/content/Context;Ljava/lang/String;Landroid/os/Bundle;)Landroid/support/v4/app/Fragment;

    move-result-object v1

    iput-object v1, p0, Lcom/jibo/ui/activity/TabbedActivity;->r:Landroid/support/v4/app/Fragment;

    goto :goto_1
.end method

.method private b(Lcom/jibo/aws/integration/aws/services/loop/model/Loop;)V
    .locals 3

    .prologue
    .line 666
    invoke-virtual {p0}, Lcom/jibo/ui/activity/TabbedActivity;->l()V

    .line 668
    new-instance v0, Landroid/content/Intent;

    invoke-direct {v0}, Landroid/content/Intent;-><init>()V

    .line 669
    const-string v1, " ARGS_LOOPS_LIST"

    invoke-direct {p0, p1}, Lcom/jibo/ui/activity/TabbedActivity;->c(Lcom/jibo/aws/integration/aws/services/loop/model/Loop;)Ljava/util/ArrayList;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/io/Serializable;)Landroid/content/Intent;

    .line 670
    const-string v1, " ARGS_HAS_ACCEPTED_LOOPS"

    const/4 v2, 0x1

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Z)Landroid/content/Intent;

    .line 671
    const-class v1, Lcom/jibo/ui/activity/LoopInviteDetailsActivity;

    invoke-virtual {v0, p0, v1}, Landroid/content/Intent;->setClass(Landroid/content/Context;Ljava/lang/Class;)Landroid/content/Intent;

    .line 672
    const/16 v1, 0x3ee

    invoke-virtual {p0, v0, v1}, Lcom/jibo/ui/activity/TabbedActivity;->startActivityForResult(Landroid/content/Intent;I)V

    .line 673
    return-void
.end method

.method static synthetic b(Lcom/jibo/ui/activity/TabbedActivity;)V
    .locals 0

    .prologue
    .line 58
    invoke-direct {p0}, Lcom/jibo/ui/activity/TabbedActivity;->D()V

    return-void
.end method

.method static synthetic b(Lcom/jibo/ui/activity/TabbedActivity;Lcom/jibo/aws/integration/aws/services/loop/model/Loop;)V
    .locals 0

    .prologue
    .line 58
    invoke-direct {p0, p1}, Lcom/jibo/ui/activity/TabbedActivity;->b(Lcom/jibo/aws/integration/aws/services/loop/model/Loop;)V

    return-void
.end method

.method static synthetic c(Lcom/jibo/ui/activity/TabbedActivity;)Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter;
    .locals 1

    .prologue
    .line 58
    iget-object v0, p0, Lcom/jibo/ui/activity/TabbedActivity;->u:Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter;

    return-object v0
.end method

.method private c(Lcom/jibo/aws/integration/aws/services/loop/model/Loop;)Ljava/util/ArrayList;
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/jibo/aws/integration/aws/services/loop/model/Loop;",
            ")",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/jibo/aws/integration/aws/services/loop/model/Loop;",
            ">;"
        }
    .end annotation

    .prologue
    .line 676
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 677
    invoke-static {p0}, Lcom/jibo/db/EntityData;->a(Landroid/content/Context;)Lcom/jibo/db/EntityData;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/db/EntityData;->i()Lcom/jibo/aws/integration/aws/services/account/model/Account;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getEmail()Ljava/lang/String;

    move-result-object v2

    .line 678
    invoke-virtual {v1, p1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 679
    iget-object v0, p0, Lcom/jibo/ui/activity/TabbedActivity;->u:Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter;->c()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :cond_0
    :goto_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_1

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    .line 680
    invoke-virtual {v0, p1}, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-nez v4, :cond_0

    invoke-static {v0, v2}, Lcom/jibo/aws/integration/helpers/LoopHelper;->isMemberInvited(Lcom/jibo/aws/integration/aws/services/loop/model/Loop;Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_0

    .line 681
    invoke-virtual {v1, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 685
    :cond_1
    return-object v1
.end method

.method private d(Lcom/jibo/aws/integration/aws/services/loop/model/Loop;)V
    .locals 2

    .prologue
    .line 691
    if-eqz p1, :cond_1

    .line 692
    invoke-direct {p0}, Lcom/jibo/ui/activity/TabbedActivity;->D()V

    .line 694
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 695
    const-class v1, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-virtual {v1}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1, p1}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 696
    invoke-static {p0}, Lcom/jibo/db/EntityData;->a(Landroid/content/Context;)Lcom/jibo/db/EntityData;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/db/EntityData;->i()Lcom/jibo/aws/integration/aws/services/account/model/Account;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getId()Ljava/lang/String;

    move-result-object v0

    invoke-static {p1, v0}, Lcom/jibo/aws/integration/helpers/LoopHelper;->isMemberInvited(Lcom/jibo/aws/integration/aws/services/loop/model/Loop;Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 697
    invoke-direct {p0, p1}, Lcom/jibo/ui/activity/TabbedActivity;->b(Lcom/jibo/aws/integration/aws/services/loop/model/Loop;)V

    .line 708
    :goto_0
    return-void

    .line 699
    :cond_0
    invoke-static {p0}, Lcom/jibo/db/EntityData;->a(Landroid/content/Context;)Lcom/jibo/db/EntityData;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/jibo/db/EntityData;->a(Lcom/jibo/aws/integration/aws/services/loop/model/Loop;)V

    goto :goto_0

    .line 704
    :cond_1
    invoke-direct {p0}, Lcom/jibo/ui/activity/TabbedActivity;->E()V

    .line 706
    iget-object v0, p0, Lcom/jibo/ui/activity/TabbedActivity;->j:Ljava/util/ArrayList;

    invoke-static {p0, v0}, Lcom/jibo/ui/activity/WifiActivity;->a(Landroid/app/Activity;Ljava/util/ArrayList;)V

    goto :goto_0
.end method

.method private y()V
    .locals 6

    .prologue
    const-wide/16 v2, 0xbb8

    .line 256
    new-instance v0, Lcom/jibo/ui/activity/TabbedActivity$3;

    move-object v1, p0

    move-wide v4, v2

    invoke-direct/range {v0 .. v5}, Lcom/jibo/ui/activity/TabbedActivity$3;-><init>(Lcom/jibo/ui/activity/TabbedActivity;JJ)V

    .line 266
    invoke-virtual {v0}, Lcom/jibo/ui/activity/TabbedActivity$3;->start()Landroid/os/CountDownTimer;

    move-result-object v0

    iput-object v0, p0, Lcom/jibo/ui/activity/TabbedActivity;->k:Landroid/os/CountDownTimer;

    .line 267
    return-void
.end method

.method private z()V
    .locals 1

    .prologue
    .line 270
    iget-object v0, p0, Lcom/jibo/ui/activity/TabbedActivity;->k:Landroid/os/CountDownTimer;

    if-eqz v0, :cond_0

    .line 271
    iget-object v0, p0, Lcom/jibo/ui/activity/TabbedActivity;->k:Landroid/os/CountDownTimer;

    invoke-virtual {v0}, Landroid/os/CountDownTimer;->cancel()V

    .line 272
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/jibo/ui/activity/TabbedActivity;->k:Landroid/os/CountDownTimer;

    .line 274
    :cond_0
    return-void
.end method


# virtual methods
.method public a(Landroid/content/Loader;Landroid/database/Cursor;)V
    .locals 9
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Loader",
            "<",
            "Landroid/database/Cursor;",
            ">;",
            "Landroid/database/Cursor;",
            ")V"
        }
    .end annotation

    .prologue
    const/4 v3, 0x1

    const/4 v0, 0x0

    .line 301
    invoke-virtual {p1}, Landroid/content/Loader;->getId()I

    move-result v1

    const v2, 0x7f0901c3

    if-ne v1, v2, :cond_3

    .line 302
    if-eqz p2, :cond_2

    invoke-interface {p2}, Landroid/database/Cursor;->isClosed()Z

    move-result v1

    if-nez v1, :cond_2

    .line 303
    invoke-interface {p2}, Landroid/database/Cursor;->moveToFirst()Z

    move v1, v0

    .line 305
    :goto_0
    invoke-interface {p2}, Landroid/database/Cursor;->isAfterLast()Z

    move-result v2

    if-nez v2, :cond_1

    .line 307
    invoke-interface {p2, v0}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v2

    const-string v3, "TEMP_SENDING"

    invoke-virtual {v2, v3}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v2

    if-nez v2, :cond_0

    .line 308
    invoke-interface {p2, v0}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v2

    const-string v3, "TEMP_FAILED"

    invoke-virtual {v2, v3}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v2

    if-nez v2, :cond_0

    .line 309
    add-int/lit8 v1, v1, 0x1

    .line 310
    :cond_0
    invoke-interface {p2}, Landroid/database/Cursor;->moveToNext()Z

    goto :goto_0

    .line 314
    :cond_1
    iget-object v2, p0, Lcom/jibo/ui/activity/TabbedActivity;->tabs:Landroid/widget/LinearLayout;

    invoke-virtual {v2, v0}, Landroid/widget/LinearLayout;->getChildAt(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/view/BottomPanelButton;

    invoke-virtual {v0, v1}, Lcom/jibo/ui/view/BottomPanelButton;->setBadgeNumber(I)V

    .line 380
    :cond_2
    :goto_1
    return-void

    .line 316
    :cond_3
    invoke-virtual {p1}, Landroid/content/Loader;->getId()I

    move-result v1

    const v2, 0x7f0901c1

    if-ne v1, v2, :cond_5

    .line 318
    if-eqz p2, :cond_4

    invoke-interface {p2}, Landroid/database/Cursor;->isClosed()Z

    move-result v0

    if-nez v0, :cond_4

    invoke-interface {p2}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v0

    if-nez v0, :cond_2

    .line 319
    :cond_4
    invoke-virtual {p0}, Lcom/jibo/ui/activity/TabbedActivity;->isFinishing()Z

    move-result v0

    if-nez v0, :cond_2

    .line 320
    sget-object v0, Lcom/jibo/ui/activity/OnBoardingActivity;->j:Ljava/lang/String;

    invoke-static {p0, v0, v3}, Lcom/jibo/ui/activity/OnBoardingActivity;->a(Landroid/content/Context;Ljava/lang/String;Z)V

    goto :goto_1

    .line 325
    :cond_5
    invoke-virtual {p1}, Landroid/content/Loader;->getId()I

    move-result v1

    const v2, 0x7f0901c5

    if-ne v1, v2, :cond_2

    .line 326
    new-instance v4, Ljava/util/ArrayList;

    invoke-direct {v4}, Ljava/util/ArrayList;-><init>()V

    .line 327
    invoke-static {p0}, Lcom/jibo/db/EntityData;->a(Landroid/content/Context;)Lcom/jibo/db/EntityData;

    move-result-object v1

    invoke-virtual {v1}, Lcom/jibo/db/EntityData;->i()Lcom/jibo/aws/integration/aws/services/account/model/Account;

    move-result-object v5

    .line 328
    invoke-static {p0}, Lcom/jibo/utils/SharedPreferencesUtil;->f(Landroid/content/Context;)Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    move-result-object v1

    iput-object v1, p0, Lcom/jibo/ui/activity/TabbedActivity;->t:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    .line 330
    const/4 v1, 0x0

    .line 332
    if-eqz p2, :cond_8

    invoke-interface {p2}, Landroid/database/Cursor;->isClosed()Z

    move-result v2

    if-nez v2, :cond_8

    invoke-interface {p2}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v2

    if-eqz v2, :cond_8

    .line 334
    :cond_6
    :goto_2
    invoke-interface {p2}, Landroid/database/Cursor;->isAfterLast()Z

    move-result v2

    if-nez v2, :cond_8

    .line 335
    invoke-static {p0}, Lcom/jibo/db/EntityData;->a(Landroid/content/Context;)Lcom/jibo/db/EntityData;

    invoke-static {p2}, Lcom/jibo/db/EntityData;->a(Landroid/database/Cursor;)Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    move-result-object v2

    .line 336
    invoke-virtual {v4, v2}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 337
    iget-object v6, p0, Lcom/jibo/ui/activity/TabbedActivity;->s:Ljava/lang/String;

    if-eqz v6, :cond_7

    iget-object v6, p0, Lcom/jibo/ui/activity/TabbedActivity;->s:Ljava/lang/String;

    invoke-virtual {v2}, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;->getId()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v6

    if-eqz v6, :cond_7

    .line 338
    iput-object v2, p0, Lcom/jibo/ui/activity/TabbedActivity;->t:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    .line 339
    iget-object v6, p0, Lcom/jibo/ui/activity/TabbedActivity;->t:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-static {p0, v6}, Lcom/jibo/utils/SharedPreferencesUtil;->a(Landroid/content/Context;Lcom/jibo/aws/integration/aws/services/loop/model/Loop;)V

    .line 341
    :cond_7
    invoke-interface {p2}, Landroid/database/Cursor;->moveToNext()Z

    .line 344
    invoke-virtual {p0}, Lcom/jibo/ui/activity/TabbedActivity;->q()Landroid/os/Bundle;

    move-result-object v6

    if-eqz v6, :cond_6

    .line 345
    invoke-virtual {v2}, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;->getId()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {p0}, Lcom/jibo/ui/activity/TabbedActivity;->q()Landroid/os/Bundle;

    move-result-object v7

    const-string v8, "ARG_ENTITY_SELECTED"

    invoke-virtual {v7, v8}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_6

    .line 346
    invoke-static {p0}, Lcom/jibo/db/EntityData;->a(Landroid/content/Context;)Lcom/jibo/db/EntityData;

    move-result-object v6

    invoke-virtual {v6}, Lcom/jibo/db/EntityData;->i()Lcom/jibo/aws/integration/aws/services/account/model/Account;

    move-result-object v6

    invoke-virtual {v6}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getId()Ljava/lang/String;

    move-result-object v6

    invoke-static {v2, v6}, Lcom/jibo/aws/integration/helpers/LoopHelper;->isMemberInvited(Lcom/jibo/aws/integration/aws/services/loop/model/Loop;Ljava/lang/String;)Z

    move-result v6

    if-eqz v6, :cond_6

    move-object v1, v2

    .line 347
    goto :goto_2

    .line 353
    :cond_8
    iput-object v4, p0, Lcom/jibo/ui/activity/TabbedActivity;->j:Ljava/util/ArrayList;

    .line 354
    iget-object v2, p0, Lcom/jibo/ui/activity/TabbedActivity;->u:Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter;

    invoke-virtual {v2, v5, v4}, Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter;->a(Lcom/jibo/aws/integration/aws/services/account/model/Account;Ljava/util/List;)V

    .line 355
    iget-object v2, p0, Lcom/jibo/ui/activity/TabbedActivity;->u:Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter;

    invoke-virtual {v2}, Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter;->notifyDataSetChanged()V

    .line 357
    invoke-direct {p0}, Lcom/jibo/ui/activity/TabbedActivity;->F()V

    .line 359
    iget-object v2, p0, Lcom/jibo/ui/activity/TabbedActivity;->t:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    if-nez v2, :cond_a

    sget-object v2, Lcom/jibo/ui/activity/TabbedActivity$TabsState;->initial:Lcom/jibo/ui/activity/TabbedActivity$TabsState;

    :goto_3
    invoke-direct {p0, v2}, Lcom/jibo/ui/activity/TabbedActivity;->a(Lcom/jibo/ui/activity/TabbedActivity$TabsState;)V

    .line 361
    if-eqz v1, :cond_9

    .line 362
    invoke-virtual {p0}, Lcom/jibo/ui/activity/TabbedActivity;->q()Landroid/os/Bundle;

    move-result-object v2

    const-string v4, "ARG_ENTITY_SELECTED"

    invoke-virtual {v2, v4}, Landroid/os/Bundle;->remove(Ljava/lang/String;)V

    .line 364
    iget-object v2, p0, Lcom/jibo/ui/activity/TabbedActivity;->jiboList:Landroid/support/v7/widget/RecyclerView;

    new-instance v4, Lcom/jibo/ui/activity/TabbedActivity$4;

    invoke-direct {v4, p0, v1}, Lcom/jibo/ui/activity/TabbedActivity$4;-><init>(Lcom/jibo/ui/activity/TabbedActivity;Lcom/jibo/aws/integration/aws/services/loop/model/Loop;)V

    const-wide/16 v6, 0x1f4

    invoke-virtual {v2, v4, v6, v7}, Landroid/support/v7/widget/RecyclerView;->postDelayed(Ljava/lang/Runnable;J)Z

    .line 373
    :cond_9
    invoke-virtual {p0}, Lcom/jibo/ui/activity/TabbedActivity;->t()Z

    move-result v2

    if-eqz v2, :cond_2

    .line 375
    invoke-static {p0}, Lcom/jibo/db/EntityData;->a(Landroid/content/Context;)Lcom/jibo/db/EntityData;

    move-result-object v2

    invoke-virtual {v2}, Lcom/jibo/db/EntityData;->i()Lcom/jibo/aws/integration/aws/services/account/model/Account;

    move-result-object v2

    if-nez v1, :cond_b

    move v1, v3

    .line 376
    :goto_4
    invoke-static {p0}, Lcom/jibo/utils/SharedPreferencesUtil;->e(Landroid/content/Context;)I

    move-result v3

    .line 374
    invoke-static {p0, v2, v1, v3}, Lcom/jibo/JiboAnalytics;->a(Landroid/content/Context;Lcom/jibo/aws/integration/aws/services/account/model/Account;ZI)V

    .line 377
    invoke-virtual {p0, v0}, Lcom/jibo/ui/activity/TabbedActivity;->b(Z)V

    goto/16 :goto_1

    .line 359
    :cond_a
    sget-object v2, Lcom/jibo/ui/activity/TabbedActivity$TabsState;->complete:Lcom/jibo/ui/activity/TabbedActivity$TabsState;

    goto :goto_3

    :cond_b
    move v1, v0

    .line 375
    goto :goto_4
.end method

.method public a(Landroid/support/v7/view/ActionMode;)V
    .locals 0

    .prologue
    .line 466
    iput-object p1, p0, Lcom/jibo/ui/activity/TabbedActivity;->v:Landroid/support/v7/view/ActionMode;

    .line 467
    return-void
.end method

.method public b(Z)V
    .locals 0

    .prologue
    .line 715
    iput-boolean p1, p0, Lcom/jibo/ui/activity/TabbedActivity;->w:Z

    .line 716
    return-void
.end method

.method public e()V
    .locals 0

    .prologue
    .line 389
    invoke-virtual {p0}, Lcom/jibo/ui/activity/TabbedActivity;->d()V

    .line 390
    return-void
.end method

.method protected onActivityResult(IILandroid/content/Intent;)V
    .locals 2

    .prologue
    .line 231
    invoke-super {p0, p1, p2, p3}, Lcom/jibo/ui/activity/BaseActivity;->onActivityResult(IILandroid/content/Intent;)V

    .line 233
    const/4 v0, -0x1

    if-ne p2, v0, :cond_1

    .line 234
    if-eqz p3, :cond_0

    .line 235
    const-string v0, "ARG_TAB_SELECTED"

    invoke-virtual {p3, v0}, Landroid/content/Intent;->hasExtra(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 236
    const-string v0, "ARG_TAB_SELECTED"

    const/4 v1, 0x0

    invoke-virtual {p3, v0, v1}, Landroid/content/Intent;->getIntExtra(Ljava/lang/String;I)I

    move-result v0

    .line 237
    const/4 v1, 0x1

    invoke-direct {p0, v0, v1}, Lcom/jibo/ui/activity/TabbedActivity;->a(IZ)V

    .line 240
    :cond_0
    const/16 v0, 0x3e9

    if-ne p1, v0, :cond_2

    .line 241
    invoke-static {p0}, Lcom/jibo/service/SyncHelper;->b(Landroid/content/Context;)V

    .line 253
    :cond_1
    :goto_0
    return-void

    .line 244
    :cond_2
    const/16 v0, 0x3eb

    if-ne p1, v0, :cond_3

    if-eqz p3, :cond_3

    .line 245
    invoke-virtual {p3}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v0

    const-class v1, Lcom/jibo/ui/fragment/settings/AvatarSelectionFragment;

    invoke-virtual {v1}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_3

    .line 246
    iget-object v0, p0, Lcom/jibo/ui/activity/TabbedActivity;->t:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-direct {p0, v0}, Lcom/jibo/ui/activity/TabbedActivity;->a(Lcom/jibo/aws/integration/aws/services/loop/model/Loop;)V

    goto :goto_0

    .line 247
    :cond_3
    const/16 v0, 0x3ee

    if-ne p1, v0, :cond_1

    .line 248
    invoke-direct {p0}, Lcom/jibo/ui/activity/TabbedActivity;->C()V

    .line 249
    invoke-direct {p0}, Lcom/jibo/ui/activity/TabbedActivity;->y()V

    goto :goto_0
.end method

.method public onBackPressed()V
    .locals 1

    .prologue
    .line 222
    iget-object v0, p0, Lcom/jibo/ui/activity/TabbedActivity;->jiboList:Landroid/support/v7/widget/RecyclerView;

    invoke-virtual {v0}, Landroid/support/v7/widget/RecyclerView;->isShown()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 223
    invoke-direct {p0}, Lcom/jibo/ui/activity/TabbedActivity;->D()V

    .line 227
    :goto_0
    return-void

    .line 225
    :cond_0
    invoke-super {p0}, Lcom/jibo/ui/activity/BaseActivity;->onBackPressed()V

    goto :goto_0
.end method

.method protected onCreate(Landroid/os/Bundle;)V
    .locals 8

    .prologue
    const v7, 0x7f070051

    const/4 v6, 0x1

    const/4 v5, -0x1

    const/4 v1, 0x0

    const/4 v4, 0x0

    const-string v0, "com.jibo.ui.activity.TabbedActivity"

    invoke-static {v0}, Lcom/google/firebase/perf/metrics/AppStartTrace;->setLauncherActivityOnCreateTime(Ljava/lang/String;)V

    .line 144
    invoke-virtual {p0}, Lcom/jibo/ui/activity/TabbedActivity;->getIntent()Landroid/content/Intent;

    move-result-object v0

    sget-object v2, Lcom/jibo/ui/activity/BaseActivity;->b:Ljava/lang/String;

    const v3, 0x7f0b0023

    invoke-virtual {v0, v2, v3}, Landroid/content/Intent;->putExtra(Ljava/lang/String;I)Landroid/content/Intent;

    .line 145
    invoke-super {p0, p1}, Lcom/jibo/ui/activity/BaseActivity;->onCreate(Landroid/os/Bundle;)V

    .line 147
    iget-object v0, p0, Lcom/jibo/ui/activity/TabbedActivity;->e:Landroid/support/v7/widget/Toolbar;

    invoke-virtual {p0}, Lcom/jibo/ui/activity/TabbedActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    invoke-virtual {v2, v7}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v2

    .line 148
    invoke-virtual {p0}, Lcom/jibo/ui/activity/TabbedActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    invoke-virtual {v3, v7}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v3

    .line 147
    invoke-virtual {v0, v2, v3}, Landroid/support/v7/widget/Toolbar;->setContentInsetsAbsolute(II)V

    .line 150
    invoke-virtual {p0}, Lcom/jibo/ui/activity/TabbedActivity;->getSupportActionBar()Landroid/support/v7/app/ActionBar;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 151
    invoke-virtual {p0}, Lcom/jibo/ui/activity/TabbedActivity;->getSupportActionBar()Landroid/support/v7/app/ActionBar;

    move-result-object v0

    invoke-virtual {v0, v4}, Landroid/support/v7/app/ActionBar;->setDefaultDisplayHomeAsUpEnabled(Z)V

    .line 152
    invoke-virtual {p0}, Lcom/jibo/ui/activity/TabbedActivity;->getSupportActionBar()Landroid/support/v7/app/ActionBar;

    move-result-object v0

    invoke-virtual {v0, v4}, Landroid/support/v7/app/ActionBar;->setDisplayHomeAsUpEnabled(Z)V

    .line 153
    invoke-virtual {p0}, Lcom/jibo/ui/activity/TabbedActivity;->getSupportActionBar()Landroid/support/v7/app/ActionBar;

    move-result-object v0

    invoke-virtual {v0, v1}, Landroid/support/v7/app/ActionBar;->setIcon(Landroid/graphics/drawable/Drawable;)V

    .line 156
    :cond_0
    invoke-virtual {p0}, Lcom/jibo/ui/activity/TabbedActivity;->getIntent()Landroid/content/Intent;

    move-result-object v0

    if-eqz v0, :cond_3

    invoke-virtual {p0}, Lcom/jibo/ui/activity/TabbedActivity;->getIntent()Landroid/content/Intent;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v0

    if-eqz v0, :cond_3

    .line 157
    invoke-virtual {p0}, Lcom/jibo/ui/activity/TabbedActivity;->getIntent()Landroid/content/Intent;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v0

    .line 158
    if-eqz v0, :cond_3

    const-string v2, "ARG_EXTRAS"

    invoke-virtual {v0, v2}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_3

    .line 159
    const-string v2, "ARG_EXTRAS"

    invoke-virtual {v0, v2}, Landroid/os/Bundle;->getBundle(Ljava/lang/String;)Landroid/os/Bundle;

    move-result-object v2

    .line 160
    if-eqz v2, :cond_3

    .line 161
    sget-object v3, Lcom/jibo/ui/fragment/AvatarBaseFragment;->a:Ljava/lang/String;

    invoke-virtual {v2, v3}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_1

    .line 162
    sget-object v3, Lcom/jibo/ui/fragment/AvatarBaseFragment;->a:Ljava/lang/String;

    invoke-virtual {v2, v3, v4}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;Z)Z

    move-result v3

    iput-boolean v3, p0, Lcom/jibo/ui/activity/TabbedActivity;->w:Z

    .line 163
    const-string v3, "ARG_EXTRAS"

    invoke-virtual {v0, v3}, Landroid/os/Bundle;->remove(Ljava/lang/String;)V

    .line 165
    :cond_1
    const-string v0, "ARG_FROM_NOTIFICATION"

    invoke-virtual {v2, v0}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 166
    sget-object v0, Lcom/jibo/JiboAnalytics;->aB:Ljava/lang/String;

    invoke-static {p0, v0}, Lcom/jibo/JiboAnalytics;->c(Landroid/content/Context;Ljava/lang/String;)V

    .line 168
    :cond_2
    const-string v0, "ARG_LOOP_ID"

    invoke-virtual {v2, v0}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_3

    .line 169
    const-string v0, "ARG_LOOP_ID"

    invoke-virtual {v2, v0}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/jibo/ui/activity/TabbedActivity;->s:Ljava/lang/String;

    .line 175
    :cond_3
    iput v5, p0, Lcom/jibo/ui/activity/TabbedActivity;->p:I

    .line 177
    if-nez p1, :cond_5

    .line 178
    invoke-virtual {p0}, Lcom/jibo/ui/activity/TabbedActivity;->getIntent()Landroid/content/Intent;

    move-result-object v0

    if-eqz v0, :cond_4

    invoke-virtual {p0}, Lcom/jibo/ui/activity/TabbedActivity;->getIntent()Landroid/content/Intent;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v0

    if-eqz v0, :cond_4

    .line 179
    invoke-virtual {p0}, Lcom/jibo/ui/activity/TabbedActivity;->getIntent()Landroid/content/Intent;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v0

    const-string v2, "ARG_CURRENT_TAB"

    invoke-virtual {v0, v2, v5}, Landroid/os/Bundle;->getInt(Ljava/lang/String;I)I

    move-result v0

    iput v0, p0, Lcom/jibo/ui/activity/TabbedActivity;->p:I

    .line 190
    :cond_4
    :goto_0
    new-instance v0, Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter;

    iget-object v2, p0, Lcom/jibo/ui/activity/TabbedActivity;->y:Landroid/view/View$OnClickListener;

    invoke-direct {v0, v2}, Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter;-><init>(Landroid/view/View$OnClickListener;)V

    iput-object v0, p0, Lcom/jibo/ui/activity/TabbedActivity;->u:Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter;

    .line 191
    new-instance v0, Landroid/support/v7/widget/LinearLayoutManager;

    invoke-direct {v0, p0, v6, v4}, Landroid/support/v7/widget/LinearLayoutManager;-><init>(Landroid/content/Context;IZ)V

    .line 192
    iget-object v2, p0, Lcom/jibo/ui/activity/TabbedActivity;->jiboList:Landroid/support/v7/widget/RecyclerView;

    new-instance v3, Landroid/support/v7/widget/DefaultItemAnimator;

    invoke-direct {v3}, Landroid/support/v7/widget/DefaultItemAnimator;-><init>()V

    invoke-virtual {v2, v3}, Landroid/support/v7/widget/RecyclerView;->setItemAnimator(Landroid/support/v7/widget/RecyclerView$ItemAnimator;)V

    .line 193
    iget-object v2, p0, Lcom/jibo/ui/activity/TabbedActivity;->jiboList:Landroid/support/v7/widget/RecyclerView;

    new-instance v3, Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter$SpacesItemDecoration;

    const v4, 0x7f0700b6

    invoke-direct {v3, p0, v4}, Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter$SpacesItemDecoration;-><init>(Landroid/content/Context;I)V

    invoke-virtual {v2, v3}, Landroid/support/v7/widget/RecyclerView;->addItemDecoration(Landroid/support/v7/widget/RecyclerView$ItemDecoration;)V

    .line 194
    iget-object v2, p0, Lcom/jibo/ui/activity/TabbedActivity;->jiboList:Landroid/support/v7/widget/RecyclerView;

    invoke-virtual {v2, v0}, Landroid/support/v7/widget/RecyclerView;->setLayoutManager(Landroid/support/v7/widget/RecyclerView$LayoutManager;)V

    .line 195
    iget-object v0, p0, Lcom/jibo/ui/activity/TabbedActivity;->jiboList:Landroid/support/v7/widget/RecyclerView;

    iget-object v2, p0, Lcom/jibo/ui/activity/TabbedActivity;->u:Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter;

    invoke-virtual {v0, v2}, Landroid/support/v7/widget/RecyclerView;->setAdapter(Landroid/support/v7/widget/RecyclerView$Adapter;)V

    .line 197
    invoke-virtual {p0}, Lcom/jibo/ui/activity/TabbedActivity;->getLoaderManager()Landroid/app/LoaderManager;

    move-result-object v0

    const v2, 0x7f0901c1

    invoke-virtual {v0, v2, v1, p0}, Landroid/app/LoaderManager;->initLoader(ILandroid/os/Bundle;Landroid/app/LoaderManager$LoaderCallbacks;)Landroid/content/Loader;

    .line 198
    invoke-virtual {p0}, Lcom/jibo/ui/activity/TabbedActivity;->getLoaderManager()Landroid/app/LoaderManager;

    move-result-object v0

    const v2, 0x7f0901c5

    invoke-virtual {v0, v2, v1, p0}, Landroid/app/LoaderManager;->initLoader(ILandroid/os/Bundle;Landroid/app/LoaderManager$LoaderCallbacks;)Landroid/content/Loader;

    .line 199
    invoke-virtual {p0}, Lcom/jibo/ui/activity/TabbedActivity;->getLoaderManager()Landroid/app/LoaderManager;

    move-result-object v0

    const v2, 0x7f0901c3

    invoke-virtual {v0, v2, v1, p0}, Landroid/app/LoaderManager;->initLoader(ILandroid/os/Bundle;Landroid/app/LoaderManager$LoaderCallbacks;)Landroid/content/Loader;

    .line 200
    return-void

    .line 184
    :cond_5
    const-string v0, "ARG_CURRENT_TAB"

    invoke-virtual {p1, v0, v4}, Landroid/os/Bundle;->getInt(Ljava/lang/String;I)I

    move-result v0

    iput v0, p0, Lcom/jibo/ui/activity/TabbedActivity;->p:I

    .line 185
    const-string v0, "ARG_TABS_STATE"

    invoke-virtual {p1, v0, v5}, Landroid/os/Bundle;->getInt(Ljava/lang/String;I)I

    move-result v0

    if-ne v0, v5, :cond_6

    move-object v0, v1

    .line 186
    :goto_1
    iput-object v0, p0, Lcom/jibo/ui/activity/TabbedActivity;->q:Lcom/jibo/ui/activity/TabbedActivity$TabsState;

    .line 187
    iget v0, p0, Lcom/jibo/ui/activity/TabbedActivity;->p:I

    invoke-direct {p0, v0, v6}, Lcom/jibo/ui/activity/TabbedActivity;->a(IZ)V

    goto :goto_0

    .line 186
    :cond_6
    invoke-static {}, Lcom/jibo/ui/activity/TabbedActivity$TabsState;->values()[Lcom/jibo/ui/activity/TabbedActivity$TabsState;

    move-result-object v0

    const-string v2, "ARG_TABS_STATE"

    invoke-virtual {p1, v2, v4}, Landroid/os/Bundle;->getInt(Ljava/lang/String;I)I

    move-result v2

    aget-object v0, v0, v2

    goto :goto_1
.end method

.method public onCreateLoader(ILandroid/os/Bundle;)Landroid/content/Loader;
    .locals 12
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I",
            "Landroid/os/Bundle;",
            ")",
            "Landroid/content/Loader",
            "<",
            "Landroid/database/Cursor;",
            ">;"
        }
    .end annotation

    .prologue
    const/4 v1, 0x1

    const/4 v4, 0x0

    .line 279
    packed-switch p1, :pswitch_data_0

    :pswitch_0
    move-object v0, v4

    .line 296
    :goto_0
    return-object v0

    .line 281
    :pswitch_1
    new-instance v0, Landroid/content/CursorLoader;

    invoke-static {v1}, Lcom/jibo/db/DatabaseContract$EntityEntry;->a(I)Landroid/net/Uri;

    move-result-object v2

    sget-object v3, Lcom/jibo/db/DatabaseContract$EntityEntry;->a:[Ljava/lang/String;

    move-object v1, p0

    move-object v5, v4

    move-object v6, v4

    invoke-direct/range {v0 .. v6}, Landroid/content/CursorLoader;-><init>(Landroid/content/Context;Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 286
    :pswitch_2
    new-instance v0, Landroid/content/CursorLoader;

    const/16 v1, 0x8

    invoke-static {v1}, Lcom/jibo/db/DatabaseContract$EntityEntry;->a(I)Landroid/net/Uri;

    move-result-object v2

    sget-object v3, Lcom/jibo/db/DatabaseContract$EntityEntry;->a:[Ljava/lang/String;

    const-string v6, "_id"

    move-object v1, p0

    move-object v5, v4

    invoke-direct/range {v0 .. v6}, Landroid/content/CursorLoader;-><init>(Landroid/content/Context;Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 291
    :pswitch_3
    new-instance v5, Landroid/content/CursorLoader;

    sget-object v7, Lcom/jibo/db/DatabaseContract$JotEntry;->a:Landroid/net/Uri;

    new-array v8, v1, [Ljava/lang/String;

    const/4 v0, 0x0

    const-string v1, "_id"

    aput-object v1, v8, v0

    const-string v9, "is_read = 0"

    move-object v6, p0

    move-object v10, v4

    move-object v11, v4

    invoke-direct/range {v5 .. v11}, Landroid/content/CursorLoader;-><init>(Landroid/content/Context;Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)V

    move-object v0, v5

    goto :goto_0

    .line 279
    nop

    :pswitch_data_0
    .packed-switch 0x7f0901c1
        :pswitch_1
        :pswitch_0
        :pswitch_3
        :pswitch_0
        :pswitch_2
    .end packed-switch
.end method

.method public synthetic onLoadFinished(Landroid/content/Loader;Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 58
    check-cast p2, Landroid/database/Cursor;

    invoke-virtual {p0, p1, p2}, Lcom/jibo/ui/activity/TabbedActivity;->a(Landroid/content/Loader;Landroid/database/Cursor;)V

    return-void
.end method

.method public onLoaderReset(Landroid/content/Loader;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Loader",
            "<",
            "Landroid/database/Cursor;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 385
    return-void
.end method

.method protected onNewIntent(Landroid/content/Intent;)V
    .locals 0

    .prologue
    .line 204
    invoke-super {p0, p1}, Lcom/jibo/ui/activity/BaseActivity;->onNewIntent(Landroid/content/Intent;)V

    .line 206
    return-void
.end method

.method protected onResume()V
    .locals 1

    .prologue
    const-string v0, "com.jibo.ui.activity.TabbedActivity"

    invoke-static {v0}, Lcom/google/firebase/perf/metrics/AppStartTrace;->setLauncherActivityOnResumeTime(Ljava/lang/String;)V

    .line 210
    invoke-super {p0}, Lcom/jibo/ui/activity/BaseActivity;->onResume()V

    .line 211
    invoke-virtual {p0}, Lcom/jibo/ui/activity/TabbedActivity;->v()V

    .line 212
    return-void
.end method

.method public onSaveInstanceState(Landroid/os/Bundle;)V
    .locals 2

    .prologue
    .line 736
    invoke-super {p0, p1}, Lcom/jibo/ui/activity/BaseActivity;->onSaveInstanceState(Landroid/os/Bundle;)V

    .line 737
    const-string v0, "ARG_CURRENT_TAB"

    iget v1, p0, Lcom/jibo/ui/activity/TabbedActivity;->p:I

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 738
    const-string v1, "ARG_TABS_STATE"

    iget-object v0, p0, Lcom/jibo/ui/activity/TabbedActivity;->q:Lcom/jibo/ui/activity/TabbedActivity$TabsState;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/jibo/ui/activity/TabbedActivity;->q:Lcom/jibo/ui/activity/TabbedActivity$TabsState;

    invoke-virtual {v0}, Lcom/jibo/ui/activity/TabbedActivity$TabsState;->ordinal()I

    move-result v0

    :goto_0
    invoke-virtual {p1, v1, v0}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 739
    return-void

    .line 738
    :cond_0
    const/4 v0, -0x1

    goto :goto_0
.end method

.method protected onStart()V
    .locals 1

    const-string v0, "com.jibo.ui.activity.TabbedActivity"

    invoke-static {v0}, Lcom/google/firebase/perf/metrics/AppStartTrace;->setLauncherActivityOnStartTime(Ljava/lang/String;)V

    invoke-super {p0}, Lcom/jibo/ui/activity/BaseActivity;->onStart()V

    return-void
.end method

.method public q()Landroid/os/Bundle;
    .locals 2

    .prologue
    .line 215
    invoke-virtual {p0}, Lcom/jibo/ui/activity/TabbedActivity;->getIntent()Landroid/content/Intent;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v0

    const-string v1, "ARG_EXTRAS"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getBundle(Ljava/lang/String;)Landroid/os/Bundle;

    move-result-object v0

    return-object v0
.end method

.method public r()Landroid/support/v7/view/ActionMode;
    .locals 1

    .prologue
    .line 470
    iget-object v0, p0, Lcom/jibo/ui/activity/TabbedActivity;->v:Landroid/support/v7/view/ActionMode;

    return-object v0
.end method

.method public s()V
    .locals 1

    .prologue
    .line 474
    iget-object v0, p0, Lcom/jibo/ui/activity/TabbedActivity;->v:Landroid/support/v7/view/ActionMode;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/jibo/ui/activity/TabbedActivity;->v:Landroid/support/v7/view/ActionMode;

    invoke-virtual {v0}, Landroid/support/v7/view/ActionMode;->d()V

    .line 475
    :cond_0
    return-void
.end method

.method public t()Z
    .locals 1

    .prologue
    .line 711
    iget-boolean v0, p0, Lcom/jibo/ui/activity/TabbedActivity;->w:Z

    return v0
.end method

.method public u()V
    .locals 2

    .prologue
    .line 719
    const/4 v0, 0x2

    const/4 v1, 0x0

    invoke-direct {p0, v0, v1}, Lcom/jibo/ui/activity/TabbedActivity;->a(IZ)V

    .line 720
    return-void
.end method

.method protected v()V
    .locals 3

    .prologue
    .line 747
    invoke-virtual {p0}, Lcom/jibo/ui/activity/TabbedActivity;->p()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 749
    const v0, 0x7f100037

    invoke-virtual {p0, v0}, Lcom/jibo/ui/activity/TabbedActivity;->getString(I)Ljava/lang/String;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {p0, v0, v1}, Lcom/jibo/ui/activity/TabbedActivity;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v0

    const-string v1, "PREF_PUSH_SERVICE_TOKEN"

    const/4 v2, 0x0

    .line 750
    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 749
    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 752
    new-instance v0, Landroid/content/Intent;

    const-class v1, Lcom/jibo/service/DeviceRegistrationService;

    invoke-direct {v0, p0, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 753
    invoke-virtual {p0, v0}, Lcom/jibo/ui/activity/TabbedActivity;->startService(Landroid/content/Intent;)Landroid/content/ComponentName;

    .line 759
    :cond_0
    return-void
.end method

.method public w()V
    .locals 0

    .prologue
    .line 766
    return-void
.end method

.method public x()Ljava/util/ArrayList;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/jibo/aws/integration/aws/services/loop/model/Loop;",
            ">;"
        }
    .end annotation

    .prologue
    .line 769
    iget-object v0, p0, Lcom/jibo/ui/activity/TabbedActivity;->j:Ljava/util/ArrayList;

    return-object v0
.end method
