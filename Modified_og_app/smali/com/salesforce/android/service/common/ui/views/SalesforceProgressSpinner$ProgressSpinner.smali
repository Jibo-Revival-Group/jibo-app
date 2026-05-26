.class Lcom/salesforce/android/service/common/ui/views/SalesforceProgressSpinner$ProgressSpinner;
.super Ljava/lang/Object;
.source "SalesforceProgressSpinner.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/salesforce/android/service/common/ui/views/SalesforceProgressSpinner;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = "ProgressSpinner"
.end annotation


# instance fields
.field final a:Landroid/graphics/drawable/GradientDrawable;

.field final b:Landroid/graphics/drawable/GradientDrawable;

.field private final c:Lcom/salesforce/android/service/common/ui/views/SalesforceProgressSpinner$ProgressSpinnerProperties;

.field private final d:Landroid/animation/ValueAnimator;


# direct methods
.method constructor <init>(Lcom/salesforce/android/service/common/ui/views/SalesforceProgressSpinner$ProgressSpinnerProperties;)V
    .locals 3

    .prologue
    .line 191
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 192
    iput-object p1, p0, Lcom/salesforce/android/service/common/ui/views/SalesforceProgressSpinner$ProgressSpinner;->c:Lcom/salesforce/android/service/common/ui/views/SalesforceProgressSpinner$ProgressSpinnerProperties;

    .line 193
    iget-object v0, p0, Lcom/salesforce/android/service/common/ui/views/SalesforceProgressSpinner$ProgressSpinner;->c:Lcom/salesforce/android/service/common/ui/views/SalesforceProgressSpinner$ProgressSpinnerProperties;

    iget v0, v0, Lcom/salesforce/android/service/common/ui/views/SalesforceProgressSpinner$ProgressSpinnerProperties;->e:F

    invoke-virtual {p0, v0}, Lcom/salesforce/android/service/common/ui/views/SalesforceProgressSpinner$ProgressSpinner;->b(F)Landroid/animation/ValueAnimator;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/service/common/ui/views/SalesforceProgressSpinner$ProgressSpinner;->d:Landroid/animation/ValueAnimator;

    .line 194
    invoke-virtual {p0}, Lcom/salesforce/android/service/common/ui/views/SalesforceProgressSpinner$ProgressSpinner;->c()Landroid/graphics/drawable/GradientDrawable;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/service/common/ui/views/SalesforceProgressSpinner$ProgressSpinner;->a:Landroid/graphics/drawable/GradientDrawable;

    .line 195
    iget-object v0, p0, Lcom/salesforce/android/service/common/ui/views/SalesforceProgressSpinner$ProgressSpinner;->a:Landroid/graphics/drawable/GradientDrawable;

    iget-object v1, p0, Lcom/salesforce/android/service/common/ui/views/SalesforceProgressSpinner$ProgressSpinner;->c:Lcom/salesforce/android/service/common/ui/views/SalesforceProgressSpinner$ProgressSpinnerProperties;

    iget v1, v1, Lcom/salesforce/android/service/common/ui/views/SalesforceProgressSpinner$ProgressSpinnerProperties;->a:I

    iget-object v2, p0, Lcom/salesforce/android/service/common/ui/views/SalesforceProgressSpinner$ProgressSpinner;->c:Lcom/salesforce/android/service/common/ui/views/SalesforceProgressSpinner$ProgressSpinnerProperties;

    iget v2, v2, Lcom/salesforce/android/service/common/ui/views/SalesforceProgressSpinner$ProgressSpinnerProperties;->c:I

    invoke-virtual {v0, v1, v2}, Landroid/graphics/drawable/GradientDrawable;->setStroke(II)V

    .line 196
    invoke-virtual {p0}, Lcom/salesforce/android/service/common/ui/views/SalesforceProgressSpinner$ProgressSpinner;->c()Landroid/graphics/drawable/GradientDrawable;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/service/common/ui/views/SalesforceProgressSpinner$ProgressSpinner;->b:Landroid/graphics/drawable/GradientDrawable;

    .line 197
    return-void
.end method


# virtual methods
.method a()V
    .locals 1

    .prologue
    .line 222
    iget-object v0, p0, Lcom/salesforce/android/service/common/ui/views/SalesforceProgressSpinner$ProgressSpinner;->d:Landroid/animation/ValueAnimator;

    invoke-virtual {v0}, Landroid/animation/ValueAnimator;->start()V

    .line 223
    return-void
.end method

.method a(F)V
    .locals 5

    .prologue
    .line 216
    iget-object v0, p0, Lcom/salesforce/android/service/common/ui/views/SalesforceProgressSpinner$ProgressSpinner;->c:Lcom/salesforce/android/service/common/ui/views/SalesforceProgressSpinner$ProgressSpinnerProperties;

    iget v0, v0, Lcom/salesforce/android/service/common/ui/views/SalesforceProgressSpinner$ProgressSpinnerProperties;->b:I

    int-to-float v0, v0

    const/high16 v1, 0x43b40000    # 360.0f

    div-float/2addr v0, v1

    mul-float/2addr v0, p1

    .line 217
    sub-float v1, p1, v0

    .line 218
    iget-object v2, p0, Lcom/salesforce/android/service/common/ui/views/SalesforceProgressSpinner$ProgressSpinner;->b:Landroid/graphics/drawable/GradientDrawable;

    iget-object v3, p0, Lcom/salesforce/android/service/common/ui/views/SalesforceProgressSpinner$ProgressSpinner;->c:Lcom/salesforce/android/service/common/ui/views/SalesforceProgressSpinner$ProgressSpinnerProperties;

    iget v3, v3, Lcom/salesforce/android/service/common/ui/views/SalesforceProgressSpinner$ProgressSpinnerProperties;->a:I

    iget-object v4, p0, Lcom/salesforce/android/service/common/ui/views/SalesforceProgressSpinner$ProgressSpinner;->c:Lcom/salesforce/android/service/common/ui/views/SalesforceProgressSpinner$ProgressSpinnerProperties;

    iget v4, v4, Lcom/salesforce/android/service/common/ui/views/SalesforceProgressSpinner$ProgressSpinnerProperties;->d:I

    invoke-virtual {v2, v3, v4, v0, v1}, Landroid/graphics/drawable/GradientDrawable;->setStroke(IIFF)V

    .line 219
    return-void
.end method

.method a(II)V
    .locals 6

    .prologue
    .line 205
    invoke-static {p1, p2}, Ljava/lang/Math;->min(II)I

    move-result v0

    .line 206
    const v1, 0x40490fdb    # (float)Math.PI

    int-to-float v2, v0

    mul-float/2addr v1, v2

    .line 207
    sub-int v2, p1, v0

    div-int/lit8 v2, v2, 0x2

    .line 208
    sub-int v0, p2, v0

    div-int/lit8 v0, v0, 0x2

    .line 210
    iget-object v3, p0, Lcom/salesforce/android/service/common/ui/views/SalesforceProgressSpinner$ProgressSpinner;->a:Landroid/graphics/drawable/GradientDrawable;

    sub-int v4, p1, v2

    sub-int v5, p2, v0

    invoke-virtual {v3, v2, v0, v4, v5}, Landroid/graphics/drawable/GradientDrawable;->setBounds(IIII)V

    .line 211
    iget-object v3, p0, Lcom/salesforce/android/service/common/ui/views/SalesforceProgressSpinner$ProgressSpinner;->b:Landroid/graphics/drawable/GradientDrawable;

    sub-int v4, p1, v2

    sub-int v5, p2, v0

    invoke-virtual {v3, v2, v0, v4, v5}, Landroid/graphics/drawable/GradientDrawable;->setBounds(IIII)V

    .line 212
    invoke-virtual {p0, v1}, Lcom/salesforce/android/service/common/ui/views/SalesforceProgressSpinner$ProgressSpinner;->a(F)V

    .line 213
    return-void
.end method

.method a(Landroid/animation/ValueAnimator$AnimatorUpdateListener;)V
    .locals 1

    .prologue
    .line 230
    iget-object v0, p0, Lcom/salesforce/android/service/common/ui/views/SalesforceProgressSpinner$ProgressSpinner;->d:Landroid/animation/ValueAnimator;

    invoke-virtual {v0, p1}, Landroid/animation/ValueAnimator;->addUpdateListener(Landroid/animation/ValueAnimator$AnimatorUpdateListener;)V

    .line 231
    return-void
.end method

.method a(Landroid/graphics/Canvas;)V
    .locals 1

    .prologue
    .line 200
    iget-object v0, p0, Lcom/salesforce/android/service/common/ui/views/SalesforceProgressSpinner$ProgressSpinner;->a:Landroid/graphics/drawable/GradientDrawable;

    invoke-virtual {v0, p1}, Landroid/graphics/drawable/GradientDrawable;->draw(Landroid/graphics/Canvas;)V

    .line 201
    iget-object v0, p0, Lcom/salesforce/android/service/common/ui/views/SalesforceProgressSpinner$ProgressSpinner;->b:Landroid/graphics/drawable/GradientDrawable;

    invoke-virtual {v0, p1}, Landroid/graphics/drawable/GradientDrawable;->draw(Landroid/graphics/Canvas;)V

    .line 202
    return-void
.end method

.method b(F)Landroid/animation/ValueAnimator;
    .locals 4

    .prologue
    .line 245
    const/4 v0, 0x2

    new-array v0, v0, [F

    fill-array-data v0, :array_0

    invoke-static {v0}, Landroid/animation/ValueAnimator;->ofFloat([F)Landroid/animation/ValueAnimator;

    move-result-object v0

    .line 246
    const/4 v1, -0x1

    invoke-virtual {v0, v1}, Landroid/animation/ValueAnimator;->setRepeatCount(I)V

    .line 247
    const/high16 v1, 0x447a0000    # 1000.0f

    div-float/2addr v1, p1

    float-to-long v2, v1

    invoke-virtual {v0, v2, v3}, Landroid/animation/ValueAnimator;->setDuration(J)Landroid/animation/ValueAnimator;

    .line 248
    new-instance v1, Landroid/view/animation/LinearInterpolator;

    invoke-direct {v1}, Landroid/view/animation/LinearInterpolator;-><init>()V

    invoke-virtual {v0, v1}, Landroid/animation/ValueAnimator;->setInterpolator(Landroid/animation/TimeInterpolator;)V

    .line 249
    return-object v0

    .line 245
    :array_0
    .array-data 4
        0x0
        0x43b40000    # 360.0f
    .end array-data
.end method

.method b()V
    .locals 1

    .prologue
    .line 226
    iget-object v0, p0, Lcom/salesforce/android/service/common/ui/views/SalesforceProgressSpinner$ProgressSpinner;->d:Landroid/animation/ValueAnimator;

    invoke-virtual {v0}, Landroid/animation/ValueAnimator;->cancel()V

    .line 227
    return-void
.end method

.method b(Landroid/animation/ValueAnimator$AnimatorUpdateListener;)V
    .locals 1

    .prologue
    .line 234
    iget-object v0, p0, Lcom/salesforce/android/service/common/ui/views/SalesforceProgressSpinner$ProgressSpinner;->d:Landroid/animation/ValueAnimator;

    invoke-virtual {v0, p1}, Landroid/animation/ValueAnimator;->removeUpdateListener(Landroid/animation/ValueAnimator$AnimatorUpdateListener;)V

    .line 235
    return-void
.end method

.method c()Landroid/graphics/drawable/GradientDrawable;
    .locals 2

    .prologue
    .line 238
    invoke-static {}, Lcom/salesforce/android/service/common/ui/internal/utils/ShapeFactory;->a()Landroid/graphics/drawable/GradientDrawable;

    move-result-object v0

    .line 239
    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/graphics/drawable/GradientDrawable;->setColor(I)V

    .line 240
    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Landroid/graphics/drawable/GradientDrawable;->setShape(I)V

    .line 241
    return-object v0
.end method
