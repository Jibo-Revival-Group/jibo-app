.class public Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionToggleButton;
.super Landroid/widget/ToggleButton;
.source "SalesforceFloatingActionToggleButton.java"

# interfaces
.implements Landroid/widget/CompoundButton$OnCheckedChangeListener;


# instance fields
.field a:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Landroid/widget/CompoundButton$OnCheckedChangeListener;",
            ">;"
        }
    .end annotation
.end field

.field private final b:I

.field private final c:I

.field private final d:I

.field private final e:I

.field private final f:Landroid/graphics/drawable/Drawable;

.field private final g:Landroid/graphics/drawable/Drawable;

.field private final h:Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl;

.field private i:Lcom/salesforce/android/service/common/utilities/spatial/Coordinate;


# direct methods
.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 95
    invoke-direct {p0, p1, p2}, Landroid/widget/ToggleButton;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 71
    invoke-static {v2, v2}, Lcom/salesforce/android/service/common/utilities/spatial/Coordinate;->a(II)Lcom/salesforce/android/service/common/utilities/spatial/Coordinate;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionToggleButton;->i:Lcom/salesforce/android/service/common/utilities/spatial/Coordinate;

    .line 96
    invoke-virtual {p0, p0}, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionToggleButton;->setOnCheckedChangeListener(Landroid/widget/CompoundButton$OnCheckedChangeListener;)V

    .line 97
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionToggleButton;->a:Ljava/util/List;

    .line 99
    invoke-virtual {p1}, Landroid/content/Context;->getTheme()Landroid/content/res/Resources$Theme;

    move-result-object v0

    sget-object v1, Lcom/salesforce/android/service/common/ui/R$styleable;->SalesforceFloatingActionToggleButton:[I

    invoke-virtual {v0, p2, v1, v2, v2}, Landroid/content/res/Resources$Theme;->obtainStyledAttributes(Landroid/util/AttributeSet;[III)Landroid/content/res/TypedArray;

    move-result-object v1

    .line 106
    :try_start_0
    sget v0, Lcom/salesforce/android/service/common/ui/R$styleable;->SalesforceFloatingActionToggleButton_salesforce_background_unchecked:I

    sget v2, Lcom/salesforce/android/service/common/ui/R$color;->salesforce_contrast_primary:I

    invoke-direct {p0, v1, v0, v2}, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionToggleButton;->a(Landroid/content/res/TypedArray;II)I

    move-result v0

    iput v0, p0, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionToggleButton;->b:I

    .line 107
    sget v0, Lcom/salesforce/android/service/common/ui/R$styleable;->SalesforceFloatingActionToggleButton_salesforce_background_checked:I

    sget v2, Lcom/salesforce/android/service/common/ui/R$color;->salesforce_feedback_secondary:I

    invoke-direct {p0, v1, v0, v2}, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionToggleButton;->a(Landroid/content/res/TypedArray;II)I

    move-result v0

    iput v0, p0, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionToggleButton;->c:I

    .line 108
    sget v0, Lcom/salesforce/android/service/common/ui/R$styleable;->SalesforceFloatingActionToggleButton_salesforce_src_color_unchecked:I

    sget v2, Lcom/salesforce/android/service/common/ui/R$color;->salesforce_contrast_inverted:I

    invoke-direct {p0, v1, v0, v2}, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionToggleButton;->a(Landroid/content/res/TypedArray;II)I

    move-result v0

    iput v0, p0, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionToggleButton;->d:I

    .line 109
    sget v0, Lcom/salesforce/android/service/common/ui/R$styleable;->SalesforceFloatingActionToggleButton_salesforce_src_color_checked:I

    sget v2, Lcom/salesforce/android/service/common/ui/R$color;->salesforce_brand_primary_inverted:I

    invoke-direct {p0, v1, v0, v2}, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionToggleButton;->a(Landroid/content/res/TypedArray;II)I

    move-result v0

    iput v0, p0, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionToggleButton;->e:I

    .line 110
    sget v0, Lcom/salesforce/android/service/common/ui/R$styleable;->SalesforceFloatingActionToggleButton_salesforce_src_unchecked:I

    invoke-virtual {v1, v0}, Landroid/content/res/TypedArray;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionToggleButton;->f:Landroid/graphics/drawable/Drawable;

    .line 111
    sget v0, Lcom/salesforce/android/service/common/ui/R$styleable;->SalesforceFloatingActionToggleButton_salesforce_src_checked:I

    invoke-virtual {v1, v0}, Landroid/content/res/TypedArray;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionToggleButton;->g:Landroid/graphics/drawable/Drawable;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 113
    invoke-virtual {v1}, Landroid/content/res/TypedArray;->recycle()V

    .line 116
    invoke-static {p0}, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl;->a(Landroid/view/View;)Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl$Builder;

    move-result-object v0

    iget v1, p0, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionToggleButton;->b:I

    .line 117
    invoke-virtual {v0, v1}, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl$Builder;->a(I)Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl$Builder;

    move-result-object v0

    iget v1, p0, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionToggleButton;->c:I

    .line 118
    invoke-virtual {v0, v1}, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl$Builder;->b(I)Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl$Builder;

    move-result-object v0

    iget-object v1, p0, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionToggleButton;->f:Landroid/graphics/drawable/Drawable;

    .line 119
    invoke-virtual {v0, v1}, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl$Builder;->a(Landroid/graphics/drawable/Drawable;)Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl$Builder;

    move-result-object v0

    iget v1, p0, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionToggleButton;->d:I

    .line 120
    invoke-virtual {v0, v1}, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl$Builder;->c(I)Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl$Builder;

    move-result-object v0

    iget-object v1, p0, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionToggleButton;->g:Landroid/graphics/drawable/Drawable;

    .line 121
    invoke-virtual {v0, v1}, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl$Builder;->b(Landroid/graphics/drawable/Drawable;)Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl$Builder;

    move-result-object v0

    iget v1, p0, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionToggleButton;->e:I

    .line 122
    invoke-virtual {v0, v1}, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl$Builder;->d(I)Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl$Builder;

    move-result-object v0

    .line 123
    invoke-virtual {v0}, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl$Builder;->a()Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionToggleButton;->h:Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl;

    .line 124
    return-void

    .line 113
    :catchall_0
    move-exception v0

    invoke-virtual {v1}, Landroid/content/res/TypedArray;->recycle()V

    throw v0
.end method

.method private a(Landroid/content/res/TypedArray;II)I
    .locals 1

    .prologue
    .line 128
    invoke-virtual {p0}, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionToggleButton;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0, p3}, Landroid/support/v4/content/ContextCompat;->c(Landroid/content/Context;I)I

    move-result v0

    invoke-virtual {p1, p2, v0}, Landroid/content/res/TypedArray;->getColor(II)I

    move-result v0

    return v0
.end method


# virtual methods
.method public onCheckedChanged(Landroid/widget/CompoundButton;Z)V
    .locals 2

    .prologue
    .line 137
    if-eqz p2, :cond_0

    .line 138
    iget-object v0, p0, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionToggleButton;->h:Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl;

    iget-object v1, p0, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionToggleButton;->i:Lcom/salesforce/android/service/common/utilities/spatial/Coordinate;

    invoke-virtual {v0, v1}, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl;->a(Lcom/salesforce/android/service/common/utilities/spatial/Coordinate;)Landroid/animation/Animator;

    move-result-object v0

    invoke-virtual {v0}, Landroid/animation/Animator;->start()V

    .line 143
    :goto_0
    iget-object v0, p0, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionToggleButton;->a:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_1
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_1

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/CompoundButton$OnCheckedChangeListener;

    .line 144
    invoke-interface {v0, p1, p2}, Landroid/widget/CompoundButton$OnCheckedChangeListener;->onCheckedChanged(Landroid/widget/CompoundButton;Z)V

    goto :goto_1

    .line 140
    :cond_0
    iget-object v0, p0, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionToggleButton;->h:Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl;

    iget-object v1, p0, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionToggleButton;->i:Lcom/salesforce/android/service/common/utilities/spatial/Coordinate;

    invoke-virtual {v0, v1}, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl;->b(Lcom/salesforce/android/service/common/utilities/spatial/Coordinate;)Landroid/animation/Animator;

    move-result-object v0

    invoke-virtual {v0}, Landroid/animation/Animator;->start()V

    goto :goto_0

    .line 146
    :cond_1
    return-void
.end method

.method protected onDraw(Landroid/graphics/Canvas;)V
    .locals 1

    .prologue
    .line 177
    iget-object v0, p0, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionToggleButton;->h:Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl;

    invoke-virtual {v0, p1}, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl;->a(Landroid/graphics/Canvas;)V

    .line 178
    return-void
.end method

.method protected onSizeChanged(IIII)V
    .locals 1

    .prologue
    .line 164
    invoke-super {p0, p1, p2, p3, p4}, Landroid/widget/ToggleButton;->onSizeChanged(IIII)V

    .line 165
    iget-object v0, p0, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionToggleButton;->h:Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl;

    invoke-virtual {v0, p1, p2}, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl;->a(II)V

    .line 166
    invoke-virtual {p0}, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionToggleButton;->invalidate()V

    .line 167
    return-void
.end method

.method public onTouchEvent(Landroid/view/MotionEvent;)Z
    .locals 2

    .prologue
    .line 171
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getX()F

    move-result v0

    float-to-int v0, v0

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v1

    float-to-int v1, v1

    invoke-static {v0, v1}, Lcom/salesforce/android/service/common/utilities/spatial/Coordinate;->a(II)Lcom/salesforce/android/service/common/utilities/spatial/Coordinate;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionToggleButton;->i:Lcom/salesforce/android/service/common/utilities/spatial/Coordinate;

    .line 172
    invoke-super {p0, p1}, Landroid/widget/ToggleButton;->onTouchEvent(Landroid/view/MotionEvent;)Z

    move-result v0

    return v0
.end method

.method public setOnCheckedChangeListener(Landroid/widget/CompoundButton$OnCheckedChangeListener;)V
    .locals 1

    .prologue
    .line 155
    instance-of v0, p1, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionToggleButton;

    if-eqz v0, :cond_0

    .line 156
    invoke-super {p0, p1}, Landroid/widget/ToggleButton;->setOnCheckedChangeListener(Landroid/widget/CompoundButton$OnCheckedChangeListener;)V

    .line 160
    :goto_0
    return-void

    .line 158
    :cond_0
    iget-object v0, p0, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionToggleButton;->a:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0
.end method
