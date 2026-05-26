.class public Lcom/jibo/ui/view/RecyclerViewFastScroller;
.super Landroid/widget/LinearLayout;
.source "RecyclerViewFastScroller.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/jibo/ui/view/RecyclerViewFastScroller$BubbleTextGetter;
    }
.end annotation


# instance fields
.field private a:Landroid/widget/TextView;

.field private b:Landroid/view/View;

.field private c:Landroid/support/v7/widget/RecyclerView;

.field private d:I

.field private e:Z

.field private f:Landroid/animation/ObjectAnimator;

.field private final g:Landroid/support/v7/widget/RecyclerView$OnScrollListener;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 1

    .prologue
    .line 49
    invoke-direct {p0, p1}, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V

    .line 29
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/jibo/ui/view/RecyclerViewFastScroller;->e:Z

    .line 30
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/jibo/ui/view/RecyclerViewFastScroller;->f:Landroid/animation/ObjectAnimator;

    .line 32
    new-instance v0, Lcom/jibo/ui/view/RecyclerViewFastScroller$1;

    invoke-direct {v0, p0}, Lcom/jibo/ui/view/RecyclerViewFastScroller$1;-><init>(Lcom/jibo/ui/view/RecyclerViewFastScroller;)V

    iput-object v0, p0, Lcom/jibo/ui/view/RecyclerViewFastScroller;->g:Landroid/support/v7/widget/RecyclerView$OnScrollListener;

    .line 50
    invoke-virtual {p0, p1}, Lcom/jibo/ui/view/RecyclerViewFastScroller;->a(Landroid/content/Context;)V

    .line 51
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 1

    .prologue
    .line 54
    invoke-direct {p0, p1, p2}, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 29
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/jibo/ui/view/RecyclerViewFastScroller;->e:Z

    .line 30
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/jibo/ui/view/RecyclerViewFastScroller;->f:Landroid/animation/ObjectAnimator;

    .line 32
    new-instance v0, Lcom/jibo/ui/view/RecyclerViewFastScroller$1;

    invoke-direct {v0, p0}, Lcom/jibo/ui/view/RecyclerViewFastScroller$1;-><init>(Lcom/jibo/ui/view/RecyclerViewFastScroller;)V

    iput-object v0, p0, Lcom/jibo/ui/view/RecyclerViewFastScroller;->g:Landroid/support/v7/widget/RecyclerView$OnScrollListener;

    .line 55
    invoke-virtual {p0, p1}, Lcom/jibo/ui/view/RecyclerViewFastScroller;->a(Landroid/content/Context;)V

    .line 56
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    .locals 1

    .prologue
    .line 44
    invoke-direct {p0, p1, p2, p3}, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 29
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/jibo/ui/view/RecyclerViewFastScroller;->e:Z

    .line 30
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/jibo/ui/view/RecyclerViewFastScroller;->f:Landroid/animation/ObjectAnimator;

    .line 32
    new-instance v0, Lcom/jibo/ui/view/RecyclerViewFastScroller$1;

    invoke-direct {v0, p0}, Lcom/jibo/ui/view/RecyclerViewFastScroller$1;-><init>(Lcom/jibo/ui/view/RecyclerViewFastScroller;)V

    iput-object v0, p0, Lcom/jibo/ui/view/RecyclerViewFastScroller;->g:Landroid/support/v7/widget/RecyclerView$OnScrollListener;

    .line 45
    invoke-virtual {p0, p1}, Lcom/jibo/ui/view/RecyclerViewFastScroller;->a(Landroid/content/Context;)V

    .line 46
    return-void
.end method

.method static synthetic a(Lcom/jibo/ui/view/RecyclerViewFastScroller;Landroid/animation/ObjectAnimator;)Landroid/animation/ObjectAnimator;
    .locals 0

    .prologue
    .line 21
    iput-object p1, p0, Lcom/jibo/ui/view/RecyclerViewFastScroller;->f:Landroid/animation/ObjectAnimator;

    return-object p1
.end method

.method private a()V
    .locals 3

    .prologue
    .line 156
    iget-object v0, p0, Lcom/jibo/ui/view/RecyclerViewFastScroller;->a:Landroid/widget/TextView;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/jibo/ui/view/RecyclerViewFastScroller;->b:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->isSelected()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 163
    :cond_0
    :goto_0
    return-void

    .line 159
    :cond_1
    iget-object v0, p0, Lcom/jibo/ui/view/RecyclerViewFastScroller;->c:Landroid/support/v7/widget/RecyclerView;

    invoke-virtual {v0}, Landroid/support/v7/widget/RecyclerView;->computeVerticalScrollOffset()I

    move-result v0

    .line 160
    iget-object v1, p0, Lcom/jibo/ui/view/RecyclerViewFastScroller;->c:Landroid/support/v7/widget/RecyclerView;

    invoke-virtual {v1}, Landroid/support/v7/widget/RecyclerView;->computeVerticalScrollRange()I

    move-result v1

    .line 161
    int-to-float v0, v0

    int-to-float v1, v1

    iget v2, p0, Lcom/jibo/ui/view/RecyclerViewFastScroller;->d:I

    int-to-float v2, v2

    sub-float/2addr v1, v2

    div-float/2addr v0, v1

    .line 162
    iget v1, p0, Lcom/jibo/ui/view/RecyclerViewFastScroller;->d:I

    int-to-float v1, v1

    mul-float/2addr v0, v1

    invoke-direct {p0, v0}, Lcom/jibo/ui/view/RecyclerViewFastScroller;->setBubbleAndHandlePosition(F)V

    goto :goto_0
.end method

.method static synthetic a(Lcom/jibo/ui/view/RecyclerViewFastScroller;)V
    .locals 0

    .prologue
    .line 21
    invoke-direct {p0}, Lcom/jibo/ui/view/RecyclerViewFastScroller;->a()V

    return-void
.end method

.method private b(III)I
    .locals 1

    .prologue
    .line 151
    invoke-static {p1, p3}, Ljava/lang/Math;->max(II)I

    move-result v0

    .line 152
    invoke-static {v0, p2}, Ljava/lang/Math;->min(II)I

    move-result v0

    return v0
.end method

.method static synthetic b(Lcom/jibo/ui/view/RecyclerViewFastScroller;)Landroid/widget/TextView;
    .locals 1

    .prologue
    .line 21
    iget-object v0, p0, Lcom/jibo/ui/view/RecyclerViewFastScroller;->a:Landroid/widget/TextView;

    return-object v0
.end method

.method private b()V
    .locals 4

    .prologue
    .line 175
    iget-object v0, p0, Lcom/jibo/ui/view/RecyclerViewFastScroller;->a:Landroid/widget/TextView;

    if-nez v0, :cond_0

    .line 182
    :goto_0
    return-void

    .line 177
    :cond_0
    iget-object v0, p0, Lcom/jibo/ui/view/RecyclerViewFastScroller;->a:Landroid/widget/TextView;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setVisibility(I)V

    .line 178
    iget-object v0, p0, Lcom/jibo/ui/view/RecyclerViewFastScroller;->f:Landroid/animation/ObjectAnimator;

    if-eqz v0, :cond_1

    .line 179
    iget-object v0, p0, Lcom/jibo/ui/view/RecyclerViewFastScroller;->f:Landroid/animation/ObjectAnimator;

    invoke-virtual {v0}, Landroid/animation/ObjectAnimator;->cancel()V

    .line 180
    :cond_1
    iget-object v0, p0, Lcom/jibo/ui/view/RecyclerViewFastScroller;->a:Landroid/widget/TextView;

    const-string v1, "alpha"

    const/4 v2, 0x2

    new-array v2, v2, [F

    fill-array-data v2, :array_0

    invoke-static {v0, v1, v2}, Landroid/animation/ObjectAnimator;->ofFloat(Ljava/lang/Object;Ljava/lang/String;[F)Landroid/animation/ObjectAnimator;

    move-result-object v0

    const-wide/16 v2, 0x64

    invoke-virtual {v0, v2, v3}, Landroid/animation/ObjectAnimator;->setDuration(J)Landroid/animation/ObjectAnimator;

    move-result-object v0

    iput-object v0, p0, Lcom/jibo/ui/view/RecyclerViewFastScroller;->f:Landroid/animation/ObjectAnimator;

    .line 181
    iget-object v0, p0, Lcom/jibo/ui/view/RecyclerViewFastScroller;->f:Landroid/animation/ObjectAnimator;

    invoke-virtual {v0}, Landroid/animation/ObjectAnimator;->start()V

    goto :goto_0

    .line 180
    :array_0
    .array-data 4
        0x0
        0x3f800000    # 1.0f
    .end array-data
.end method

.method private c()V
    .locals 4

    .prologue
    .line 185
    iget-object v0, p0, Lcom/jibo/ui/view/RecyclerViewFastScroller;->a:Landroid/widget/TextView;

    if-nez v0, :cond_0

    .line 206
    :goto_0
    return-void

    .line 187
    :cond_0
    iget-object v0, p0, Lcom/jibo/ui/view/RecyclerViewFastScroller;->f:Landroid/animation/ObjectAnimator;

    if-eqz v0, :cond_1

    .line 188
    iget-object v0, p0, Lcom/jibo/ui/view/RecyclerViewFastScroller;->f:Landroid/animation/ObjectAnimator;

    invoke-virtual {v0}, Landroid/animation/ObjectAnimator;->cancel()V

    .line 189
    :cond_1
    iget-object v0, p0, Lcom/jibo/ui/view/RecyclerViewFastScroller;->a:Landroid/widget/TextView;

    const-string v1, "alpha"

    const/4 v2, 0x2

    new-array v2, v2, [F

    fill-array-data v2, :array_0

    invoke-static {v0, v1, v2}, Landroid/animation/ObjectAnimator;->ofFloat(Ljava/lang/Object;Ljava/lang/String;[F)Landroid/animation/ObjectAnimator;

    move-result-object v0

    const-wide/16 v2, 0x64

    invoke-virtual {v0, v2, v3}, Landroid/animation/ObjectAnimator;->setDuration(J)Landroid/animation/ObjectAnimator;

    move-result-object v0

    iput-object v0, p0, Lcom/jibo/ui/view/RecyclerViewFastScroller;->f:Landroid/animation/ObjectAnimator;

    .line 190
    iget-object v0, p0, Lcom/jibo/ui/view/RecyclerViewFastScroller;->f:Landroid/animation/ObjectAnimator;

    new-instance v1, Lcom/jibo/ui/view/RecyclerViewFastScroller$2;

    invoke-direct {v1, p0}, Lcom/jibo/ui/view/RecyclerViewFastScroller$2;-><init>(Lcom/jibo/ui/view/RecyclerViewFastScroller;)V

    invoke-virtual {v0, v1}, Landroid/animation/ObjectAnimator;->addListener(Landroid/animation/Animator$AnimatorListener;)V

    .line 205
    iget-object v0, p0, Lcom/jibo/ui/view/RecyclerViewFastScroller;->f:Landroid/animation/ObjectAnimator;

    invoke-virtual {v0}, Landroid/animation/ObjectAnimator;->start()V

    goto :goto_0

    .line 189
    :array_0
    .array-data 4
        0x3f800000    # 1.0f
        0x0
    .end array-data
.end method

.method private setBubbleAndHandlePosition(F)V
    .locals 5

    .prologue
    const/4 v4, 0x0

    .line 166
    iget-object v0, p0, Lcom/jibo/ui/view/RecyclerViewFastScroller;->b:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->getHeight()I

    move-result v0

    .line 167
    iget-object v1, p0, Lcom/jibo/ui/view/RecyclerViewFastScroller;->b:Landroid/view/View;

    iget v2, p0, Lcom/jibo/ui/view/RecyclerViewFastScroller;->d:I

    sub-int/2addr v2, v0

    div-int/lit8 v3, v0, 0x2

    int-to-float v3, v3

    sub-float v3, p1, v3

    float-to-int v3, v3

    invoke-direct {p0, v4, v2, v3}, Lcom/jibo/ui/view/RecyclerViewFastScroller;->b(III)I

    move-result v2

    int-to-float v2, v2

    invoke-virtual {v1, v2}, Landroid/view/View;->setY(F)V

    .line 168
    iget-object v1, p0, Lcom/jibo/ui/view/RecyclerViewFastScroller;->a:Landroid/widget/TextView;

    if-eqz v1, :cond_0

    .line 169
    iget-object v1, p0, Lcom/jibo/ui/view/RecyclerViewFastScroller;->a:Landroid/widget/TextView;

    invoke-virtual {v1}, Landroid/widget/TextView;->getHeight()I

    move-result v1

    .line 170
    iget-object v2, p0, Lcom/jibo/ui/view/RecyclerViewFastScroller;->a:Landroid/widget/TextView;

    iget v3, p0, Lcom/jibo/ui/view/RecyclerViewFastScroller;->d:I

    sub-int/2addr v3, v1

    div-int/lit8 v0, v0, 0x2

    sub-int v0, v3, v0

    int-to-float v1, v1

    sub-float v1, p1, v1

    float-to-int v1, v1

    invoke-direct {p0, v4, v0, v1}, Lcom/jibo/ui/view/RecyclerViewFastScroller;->b(III)I

    move-result v0

    int-to-float v0, v0

    invoke-virtual {v2, v0}, Landroid/widget/TextView;->setY(F)V

    .line 172
    :cond_0
    return-void
.end method

.method private setRecyclerViewPosition(F)V
    .locals 4

    .prologue
    const/4 v0, 0x0

    const/4 v3, 0x0

    .line 129
    iget-object v1, p0, Lcom/jibo/ui/view/RecyclerViewFastScroller;->c:Landroid/support/v7/widget/RecyclerView;

    if-eqz v1, :cond_0

    .line 130
    iget-object v1, p0, Lcom/jibo/ui/view/RecyclerViewFastScroller;->c:Landroid/support/v7/widget/RecyclerView;

    invoke-virtual {v1}, Landroid/support/v7/widget/RecyclerView;->getAdapter()Landroid/support/v7/widget/RecyclerView$Adapter;

    move-result-object v1

    invoke-virtual {v1}, Landroid/support/v7/widget/RecyclerView$Adapter;->getItemCount()I

    move-result v1

    .line 132
    iget-object v2, p0, Lcom/jibo/ui/view/RecyclerViewFastScroller;->b:Landroid/view/View;

    invoke-virtual {v2}, Landroid/view/View;->getY()F

    move-result v2

    cmpl-float v2, v2, v0

    if-nez v2, :cond_1

    .line 138
    :goto_0
    add-int/lit8 v2, v1, -0x1

    int-to-float v1, v1

    mul-float/2addr v0, v1

    float-to-int v0, v0

    invoke-direct {p0, v3, v2, v0}, Lcom/jibo/ui/view/RecyclerViewFastScroller;->b(III)I

    move-result v1

    .line 139
    iget-object v0, p0, Lcom/jibo/ui/view/RecyclerViewFastScroller;->c:Landroid/support/v7/widget/RecyclerView;

    invoke-virtual {v0}, Landroid/support/v7/widget/RecyclerView;->getLayoutManager()Landroid/support/v7/widget/RecyclerView$LayoutManager;

    move-result-object v0

    check-cast v0, Landroid/support/v7/widget/LinearLayoutManager;

    invoke-virtual {v0, v1, v3}, Landroid/support/v7/widget/LinearLayoutManager;->b(II)V

    .line 140
    iget-object v0, p0, Lcom/jibo/ui/view/RecyclerViewFastScroller;->c:Landroid/support/v7/widget/RecyclerView;

    invoke-virtual {v0}, Landroid/support/v7/widget/RecyclerView;->getAdapter()Landroid/support/v7/widget/RecyclerView$Adapter;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/view/RecyclerViewFastScroller$BubbleTextGetter;

    invoke-interface {v0, v1}, Lcom/jibo/ui/view/RecyclerViewFastScroller$BubbleTextGetter;->c(I)Ljava/lang/String;

    move-result-object v0

    .line 141
    iget-object v1, p0, Lcom/jibo/ui/view/RecyclerViewFastScroller;->a:Landroid/widget/TextView;

    if-eqz v1, :cond_3

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-nez v1, :cond_3

    .line 142
    iget-object v1, p0, Lcom/jibo/ui/view/RecyclerViewFastScroller;->a:Landroid/widget/TextView;

    invoke-virtual {v1, v0}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 143
    iget-object v0, p0, Lcom/jibo/ui/view/RecyclerViewFastScroller;->a:Landroid/widget/TextView;

    invoke-virtual {v0, v3}, Landroid/widget/TextView;->setVisibility(I)V

    .line 148
    :cond_0
    :goto_1
    return-void

    .line 134
    :cond_1
    iget-object v0, p0, Lcom/jibo/ui/view/RecyclerViewFastScroller;->b:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->getY()F

    move-result v0

    iget-object v2, p0, Lcom/jibo/ui/view/RecyclerViewFastScroller;->b:Landroid/view/View;

    invoke-virtual {v2}, Landroid/view/View;->getHeight()I

    move-result v2

    int-to-float v2, v2

    add-float/2addr v0, v2

    iget v2, p0, Lcom/jibo/ui/view/RecyclerViewFastScroller;->d:I

    add-int/lit8 v2, v2, -0x5

    int-to-float v2, v2

    cmpl-float v0, v0, v2

    if-ltz v0, :cond_2

    .line 135
    const/high16 v0, 0x3f800000    # 1.0f

    goto :goto_0

    .line 137
    :cond_2
    iget v0, p0, Lcom/jibo/ui/view/RecyclerViewFastScroller;->d:I

    int-to-float v0, v0

    div-float v0, p1, v0

    goto :goto_0

    .line 145
    :cond_3
    iget-object v0, p0, Lcom/jibo/ui/view/RecyclerViewFastScroller;->a:Landroid/widget/TextView;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setVisibility(I)V

    goto :goto_1
.end method


# virtual methods
.method public a(III)V
    .locals 2

    .prologue
    .line 67
    invoke-virtual {p0}, Lcom/jibo/ui/view/RecyclerViewFastScroller;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v0

    .line 68
    const/4 v1, 0x1

    invoke-virtual {v0, p1, p0, v1}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    .line 69
    invoke-virtual {p0, p2}, Lcom/jibo/ui/view/RecyclerViewFastScroller;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/jibo/ui/view/RecyclerViewFastScroller;->a:Landroid/widget/TextView;

    .line 70
    iget-object v0, p0, Lcom/jibo/ui/view/RecyclerViewFastScroller;->a:Landroid/widget/TextView;

    if-eqz v0, :cond_0

    .line 71
    iget-object v0, p0, Lcom/jibo/ui/view/RecyclerViewFastScroller;->a:Landroid/widget/TextView;

    const/4 v1, 0x4

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setVisibility(I)V

    .line 72
    :cond_0
    invoke-virtual {p0, p3}, Lcom/jibo/ui/view/RecyclerViewFastScroller;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/jibo/ui/view/RecyclerViewFastScroller;->b:Landroid/view/View;

    .line 73
    return-void
.end method

.method protected a(Landroid/content/Context;)V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 59
    iget-boolean v0, p0, Lcom/jibo/ui/view/RecyclerViewFastScroller;->e:Z

    if-eqz v0, :cond_0

    .line 64
    :goto_0
    return-void

    .line 61
    :cond_0
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/jibo/ui/view/RecyclerViewFastScroller;->e:Z

    .line 62
    invoke-virtual {p0, v1}, Lcom/jibo/ui/view/RecyclerViewFastScroller;->setOrientation(I)V

    .line 63
    invoke-virtual {p0, v1}, Lcom/jibo/ui/view/RecyclerViewFastScroller;->setClipChildren(Z)V

    goto :goto_0
.end method

.method protected onDetachedFromWindow()V
    .locals 2

    .prologue
    .line 121
    invoke-super {p0}, Landroid/widget/LinearLayout;->onDetachedFromWindow()V

    .line 122
    iget-object v0, p0, Lcom/jibo/ui/view/RecyclerViewFastScroller;->c:Landroid/support/v7/widget/RecyclerView;

    if-eqz v0, :cond_0

    .line 123
    iget-object v0, p0, Lcom/jibo/ui/view/RecyclerViewFastScroller;->c:Landroid/support/v7/widget/RecyclerView;

    iget-object v1, p0, Lcom/jibo/ui/view/RecyclerViewFastScroller;->g:Landroid/support/v7/widget/RecyclerView$OnScrollListener;

    invoke-virtual {v0, v1}, Landroid/support/v7/widget/RecyclerView;->removeOnScrollListener(Landroid/support/v7/widget/RecyclerView$OnScrollListener;)V

    .line 124
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/jibo/ui/view/RecyclerViewFastScroller;->c:Landroid/support/v7/widget/RecyclerView;

    .line 126
    :cond_0
    return-void
.end method

.method protected onSizeChanged(IIII)V
    .locals 0

    .prologue
    .line 77
    invoke-super {p0, p1, p2, p3, p4}, Landroid/widget/LinearLayout;->onSizeChanged(IIII)V

    .line 78
    iput p2, p0, Lcom/jibo/ui/view/RecyclerViewFastScroller;->d:I

    .line 79
    invoke-direct {p0}, Lcom/jibo/ui/view/RecyclerViewFastScroller;->a()V

    .line 80
    return-void
.end method

.method public onTouchEvent(Landroid/view/MotionEvent;)Z
    .locals 5

    .prologue
    const/4 v0, 0x0

    const/4 v1, 0x1

    .line 84
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getAction()I

    move-result v2

    .line 85
    packed-switch v2, :pswitch_data_0

    .line 105
    invoke-super {p0, p1}, Landroid/widget/LinearLayout;->onTouchEvent(Landroid/view/MotionEvent;)Z

    move-result v0

    :cond_0
    :goto_0
    return v0

    .line 87
    :pswitch_0
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getX()F

    move-result v2

    iget-object v3, p0, Lcom/jibo/ui/view/RecyclerViewFastScroller;->b:Landroid/view/View;

    invoke-virtual {v3}, Landroid/view/View;->getX()F

    move-result v3

    iget-object v4, p0, Lcom/jibo/ui/view/RecyclerViewFastScroller;->b:Landroid/view/View;

    invoke-static {v4}, Landroid/support/v4/view/ViewCompat;->g(Landroid/view/View;)I

    move-result v4

    int-to-float v4, v4

    sub-float/2addr v3, v4

    cmpg-float v2, v2, v3

    if-ltz v2, :cond_0

    .line 89
    iget-object v0, p0, Lcom/jibo/ui/view/RecyclerViewFastScroller;->f:Landroid/animation/ObjectAnimator;

    if-eqz v0, :cond_1

    .line 90
    iget-object v0, p0, Lcom/jibo/ui/view/RecyclerViewFastScroller;->f:Landroid/animation/ObjectAnimator;

    invoke-virtual {v0}, Landroid/animation/ObjectAnimator;->cancel()V

    .line 91
    :cond_1
    iget-object v0, p0, Lcom/jibo/ui/view/RecyclerViewFastScroller;->a:Landroid/widget/TextView;

    if-eqz v0, :cond_2

    iget-object v0, p0, Lcom/jibo/ui/view/RecyclerViewFastScroller;->a:Landroid/widget/TextView;

    invoke-virtual {v0}, Landroid/widget/TextView;->getVisibility()I

    move-result v0

    const/4 v2, 0x4

    if-ne v0, v2, :cond_2

    .line 92
    invoke-direct {p0}, Lcom/jibo/ui/view/RecyclerViewFastScroller;->b()V

    .line 93
    :cond_2
    iget-object v0, p0, Lcom/jibo/ui/view/RecyclerViewFastScroller;->b:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setSelected(Z)V

    .line 95
    :pswitch_1
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v0

    .line 96
    invoke-direct {p0, v0}, Lcom/jibo/ui/view/RecyclerViewFastScroller;->setBubbleAndHandlePosition(F)V

    .line 97
    invoke-direct {p0, v0}, Lcom/jibo/ui/view/RecyclerViewFastScroller;->setRecyclerViewPosition(F)V

    move v0, v1

    .line 98
    goto :goto_0

    .line 101
    :pswitch_2
    iget-object v2, p0, Lcom/jibo/ui/view/RecyclerViewFastScroller;->b:Landroid/view/View;

    invoke-virtual {v2, v0}, Landroid/view/View;->setSelected(Z)V

    .line 102
    invoke-direct {p0}, Lcom/jibo/ui/view/RecyclerViewFastScroller;->c()V

    move v0, v1

    .line 103
    goto :goto_0

    .line 85
    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_2
        :pswitch_1
        :pswitch_2
    .end packed-switch
.end method

.method public setRecyclerView(Landroid/support/v7/widget/RecyclerView;)V
    .locals 2

    .prologue
    .line 109
    iget-object v0, p0, Lcom/jibo/ui/view/RecyclerViewFastScroller;->c:Landroid/support/v7/widget/RecyclerView;

    if-eq v0, p1, :cond_1

    .line 110
    iget-object v0, p0, Lcom/jibo/ui/view/RecyclerViewFastScroller;->c:Landroid/support/v7/widget/RecyclerView;

    if-eqz v0, :cond_0

    .line 111
    iget-object v0, p0, Lcom/jibo/ui/view/RecyclerViewFastScroller;->c:Landroid/support/v7/widget/RecyclerView;

    iget-object v1, p0, Lcom/jibo/ui/view/RecyclerViewFastScroller;->g:Landroid/support/v7/widget/RecyclerView$OnScrollListener;

    invoke-virtual {v0, v1}, Landroid/support/v7/widget/RecyclerView;->removeOnScrollListener(Landroid/support/v7/widget/RecyclerView$OnScrollListener;)V

    .line 112
    :cond_0
    iput-object p1, p0, Lcom/jibo/ui/view/RecyclerViewFastScroller;->c:Landroid/support/v7/widget/RecyclerView;

    .line 113
    iget-object v0, p0, Lcom/jibo/ui/view/RecyclerViewFastScroller;->c:Landroid/support/v7/widget/RecyclerView;

    if-nez v0, :cond_2

    .line 117
    :cond_1
    :goto_0
    return-void

    .line 115
    :cond_2
    iget-object v0, p0, Lcom/jibo/ui/view/RecyclerViewFastScroller;->g:Landroid/support/v7/widget/RecyclerView$OnScrollListener;

    invoke-virtual {p1, v0}, Landroid/support/v7/widget/RecyclerView;->addOnScrollListener(Landroid/support/v7/widget/RecyclerView$OnScrollListener;)V

    goto :goto_0
.end method
