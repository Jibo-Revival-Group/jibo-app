.class public Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButton;
.super Landroid/widget/Button;
.source "SalesforceFloatingActionButton.java"


# instance fields
.field private final a:I

.field private final b:I

.field private final c:I

.field private final d:I

.field private final e:Landroid/graphics/drawable/Drawable;

.field private final f:Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl;


# direct methods
.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 87
    invoke-direct {p0, p1, p2}, Landroid/widget/Button;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 89
    invoke-virtual {p1}, Landroid/content/Context;->getTheme()Landroid/content/res/Resources$Theme;

    move-result-object v0

    sget-object v1, Lcom/salesforce/android/service/common/ui/R$styleable;->SalesforceFloatingActionButton:[I

    invoke-virtual {v0, p2, v1, v2, v2}, Landroid/content/res/Resources$Theme;->obtainStyledAttributes(Landroid/util/AttributeSet;[III)Landroid/content/res/TypedArray;

    move-result-object v1

    .line 96
    :try_start_0
    sget v0, Lcom/salesforce/android/service/common/ui/R$styleable;->SalesforceFloatingActionButton_salesforce_background_unselected:I

    sget v2, Lcom/salesforce/android/service/common/ui/R$color;->salesforce_contrast_primary:I

    invoke-direct {p0, v1, v0, v2}, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButton;->a(Landroid/content/res/TypedArray;II)I

    move-result v0

    iput v0, p0, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButton;->a:I

    .line 97
    sget v0, Lcom/salesforce/android/service/common/ui/R$styleable;->SalesforceFloatingActionButton_salesforce_background_selected:I

    sget v2, Lcom/salesforce/android/service/common/ui/R$color;->salesforce_feedback_primary:I

    invoke-direct {p0, v1, v0, v2}, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButton;->a(Landroid/content/res/TypedArray;II)I

    move-result v0

    iput v0, p0, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButton;->b:I

    .line 98
    sget v0, Lcom/salesforce/android/service/common/ui/R$styleable;->SalesforceFloatingActionButton_salesforce_src_color_unselected:I

    sget v2, Lcom/salesforce/android/service/common/ui/R$color;->salesforce_contrast_inverted:I

    invoke-direct {p0, v1, v0, v2}, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButton;->a(Landroid/content/res/TypedArray;II)I

    move-result v0

    iput v0, p0, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButton;->c:I

    .line 99
    sget v0, Lcom/salesforce/android/service/common/ui/R$styleable;->SalesforceFloatingActionButton_salesforce_src_color_selected:I

    sget v2, Lcom/salesforce/android/service/common/ui/R$color;->salesforce_brand_primary_inverted:I

    invoke-direct {p0, v1, v0, v2}, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButton;->a(Landroid/content/res/TypedArray;II)I

    move-result v0

    iput v0, p0, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButton;->d:I

    .line 100
    sget v0, Lcom/salesforce/android/service/common/ui/R$styleable;->SalesforceFloatingActionButton_salesforce_src:I

    invoke-virtual {v1, v0}, Landroid/content/res/TypedArray;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButton;->e:Landroid/graphics/drawable/Drawable;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 102
    invoke-virtual {v1}, Landroid/content/res/TypedArray;->recycle()V

    .line 105
    invoke-static {p0}, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl;->a(Landroid/view/View;)Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl$Builder;

    move-result-object v0

    iget v1, p0, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButton;->a:I

    .line 106
    invoke-virtual {v0, v1}, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl$Builder;->a(I)Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl$Builder;

    move-result-object v0

    iget v1, p0, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButton;->b:I

    .line 107
    invoke-virtual {v0, v1}, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl$Builder;->b(I)Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl$Builder;

    move-result-object v0

    iget-object v1, p0, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButton;->e:Landroid/graphics/drawable/Drawable;

    .line 108
    invoke-virtual {v0, v1}, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl$Builder;->a(Landroid/graphics/drawable/Drawable;)Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl$Builder;

    move-result-object v0

    iget v1, p0, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButton;->c:I

    .line 109
    invoke-virtual {v0, v1}, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl$Builder;->c(I)Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl$Builder;

    move-result-object v0

    iget v1, p0, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButton;->d:I

    .line 110
    invoke-virtual {v0, v1}, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl$Builder;->d(I)Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl$Builder;

    move-result-object v0

    .line 111
    invoke-virtual {v0}, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl$Builder;->a()Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButton;->f:Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl;

    .line 112
    return-void

    .line 102
    :catchall_0
    move-exception v0

    invoke-virtual {v1}, Landroid/content/res/TypedArray;->recycle()V

    throw v0
.end method

.method private a(Landroid/content/res/TypedArray;II)I
    .locals 1

    .prologue
    .line 116
    invoke-virtual {p0}, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButton;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0, p3}, Landroid/support/v4/content/ContextCompat;->c(Landroid/content/Context;I)I

    move-result v0

    invoke-virtual {p1, p2, v0}, Landroid/content/res/TypedArray;->getColor(II)I

    move-result v0

    return v0
.end method


# virtual methods
.method protected onDraw(Landroid/graphics/Canvas;)V
    .locals 1

    .prologue
    .line 146
    iget-object v0, p0, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButton;->f:Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl;

    invoke-virtual {v0, p1}, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl;->a(Landroid/graphics/Canvas;)V

    .line 147
    return-void
.end method

.method protected onSizeChanged(IIII)V
    .locals 1

    .prologue
    .line 125
    invoke-super {p0, p1, p2, p3, p4}, Landroid/widget/Button;->onSizeChanged(IIII)V

    .line 127
    iget-object v0, p0, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButton;->f:Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl;

    invoke-virtual {v0, p1, p2}, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl;->a(II)V

    .line 128
    return-void
.end method

.method public onTouchEvent(Landroid/view/MotionEvent;)Z
    .locals 5

    .prologue
    .line 132
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getAction()I

    move-result v0

    if-nez v0, :cond_0

    .line 133
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getX()F

    move-result v0

    float-to-int v0, v0

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v1

    float-to-int v1, v1

    invoke-static {v0, v1}, Lcom/salesforce/android/service/common/utilities/spatial/Coordinate;->a(II)Lcom/salesforce/android/service/common/utilities/spatial/Coordinate;

    move-result-object v0

    .line 134
    new-instance v1, Landroid/animation/AnimatorSet;

    invoke-direct {v1}, Landroid/animation/AnimatorSet;-><init>()V

    .line 135
    const/4 v2, 0x2

    new-array v2, v2, [Landroid/animation/Animator;

    const/4 v3, 0x0

    iget-object v4, p0, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButton;->f:Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl;

    .line 136
    invoke-virtual {v4, v0}, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl;->a(Lcom/salesforce/android/service/common/utilities/spatial/Coordinate;)Landroid/animation/Animator;

    move-result-object v4

    aput-object v4, v2, v3

    const/4 v3, 0x1

    iget-object v4, p0, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButton;->f:Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl;

    .line 137
    invoke-virtual {v4, v0}, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl;->b(Lcom/salesforce/android/service/common/utilities/spatial/Coordinate;)Landroid/animation/Animator;

    move-result-object v0

    aput-object v0, v2, v3

    .line 135
    invoke-virtual {v1, v2}, Landroid/animation/AnimatorSet;->playSequentially([Landroid/animation/Animator;)V

    .line 139
    invoke-virtual {v1}, Landroid/animation/AnimatorSet;->start()V

    .line 141
    :cond_0
    invoke-super {p0, p1}, Landroid/widget/Button;->onTouchEvent(Landroid/view/MotionEvent;)Z

    move-result v0

    return v0
.end method
