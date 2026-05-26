.class public Lcom/jibo/ui/view/BitmapProgress;
.super Landroid/view/View;
.source "BitmapProgress.java"


# instance fields
.field private a:I

.field private b:I

.field private c:Landroid/graphics/Bitmap;

.field private d:Landroid/graphics/Path;

.field private e:Landroid/graphics/Paint;

.field private f:I

.field private g:I

.field private h:I

.field private i:F

.field private j:I

.field private k:Landroid/os/Handler;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 2

    .prologue
    .line 57
    const/4 v0, 0x0

    const/4 v1, 0x0

    invoke-direct {p0, p1, v0, v1}, Lcom/jibo/ui/view/BitmapProgress;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 58
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 1

    .prologue
    .line 60
    const/4 v0, 0x0

    invoke-direct {p0, p1, p2, v0}, Lcom/jibo/ui/view/BitmapProgress;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 61
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    .locals 1

    .prologue
    .line 63
    invoke-direct {p0, p1, p2, p3}, Landroid/view/View;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 33
    const v0, 0x106000b

    iput v0, p0, Lcom/jibo/ui/view/BitmapProgress;->f:I

    .line 35
    const/16 v0, 0x64

    iput v0, p0, Lcom/jibo/ui/view/BitmapProgress;->g:I

    .line 36
    const/4 v0, 0x0

    iput v0, p0, Lcom/jibo/ui/view/BitmapProgress;->h:I

    .line 39
    const/16 v0, 0x32

    iput v0, p0, Lcom/jibo/ui/view/BitmapProgress;->j:I

    .line 42
    new-instance v0, Lcom/jibo/ui/view/BitmapProgress$1;

    invoke-direct {v0, p0}, Lcom/jibo/ui/view/BitmapProgress$1;-><init>(Lcom/jibo/ui/view/BitmapProgress;)V

    iput-object v0, p0, Lcom/jibo/ui/view/BitmapProgress;->k:Landroid/os/Handler;

    .line 65
    invoke-direct {p0}, Lcom/jibo/ui/view/BitmapProgress;->b()V

    .line 66
    return-void
.end method

.method static synthetic a(Lcom/jibo/ui/view/BitmapProgress;)I
    .locals 1

    .prologue
    .line 24
    iget v0, p0, Lcom/jibo/ui/view/BitmapProgress;->j:I

    return v0
.end method

.method private a(Landroid/graphics/drawable/Drawable;)Landroid/graphics/Bitmap;
    .locals 7

    .prologue
    const/4 v0, 0x0

    .line 151
    if-nez p1, :cond_0

    .line 165
    :goto_0
    return-object v0

    .line 154
    :cond_0
    instance-of v1, p1, Landroid/graphics/drawable/BitmapDrawable;

    if-eqz v1, :cond_1

    .line 155
    check-cast p1, Landroid/graphics/drawable/BitmapDrawable;

    invoke-virtual {p1}, Landroid/graphics/drawable/BitmapDrawable;->getBitmap()Landroid/graphics/Bitmap;

    move-result-object v0

    goto :goto_0

    .line 159
    :cond_1
    :try_start_0
    invoke-virtual {p1}, Landroid/graphics/drawable/Drawable;->getIntrinsicWidth()I

    move-result v1

    invoke-virtual {p1}, Landroid/graphics/drawable/Drawable;->getIntrinsicHeight()I

    move-result v2

    sget-object v3, Landroid/graphics/Bitmap$Config;->ARGB_8888:Landroid/graphics/Bitmap$Config;

    invoke-static {v1, v2, v3}, Landroid/graphics/Bitmap;->createBitmap(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;

    move-result-object v1

    .line 160
    new-instance v2, Landroid/graphics/Canvas;

    invoke-direct {v2, v1}, Landroid/graphics/Canvas;-><init>(Landroid/graphics/Bitmap;)V

    .line 161
    const/4 v3, 0x0

    const/4 v4, 0x0

    invoke-virtual {v2}, Landroid/graphics/Canvas;->getWidth()I

    move-result v5

    invoke-virtual {v2}, Landroid/graphics/Canvas;->getHeight()I

    move-result v6

    invoke-virtual {p1, v3, v4, v5, v6}, Landroid/graphics/drawable/Drawable;->setBounds(IIII)V

    .line 162
    invoke-virtual {p1, v2}, Landroid/graphics/drawable/Drawable;->draw(Landroid/graphics/Canvas;)V
    :try_end_0
    .catch Ljava/lang/OutOfMemoryError; {:try_start_0 .. :try_end_0} :catch_0

    move-object v0, v1

    .line 163
    goto :goto_0

    .line 164
    :catch_0
    move-exception v1

    goto :goto_0
.end method

.method private b()V
    .locals 4

    .prologue
    .line 88
    invoke-virtual {p0}, Lcom/jibo/ui/view/BitmapProgress;->getBackground()Landroid/graphics/drawable/Drawable;

    move-result-object v0

    if-nez v0, :cond_0

    .line 89
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "background is null."

    const/4 v2, 0x0

    new-array v2, v2, [Ljava/lang/Object;

    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 91
    :cond_0
    invoke-virtual {p0}, Lcom/jibo/ui/view/BitmapProgress;->a()V

    .line 94
    new-instance v0, Landroid/graphics/Path;

    invoke-direct {v0}, Landroid/graphics/Path;-><init>()V

    iput-object v0, p0, Lcom/jibo/ui/view/BitmapProgress;->d:Landroid/graphics/Path;

    .line 95
    new-instance v0, Landroid/graphics/Paint;

    invoke-direct {v0}, Landroid/graphics/Paint;-><init>()V

    iput-object v0, p0, Lcom/jibo/ui/view/BitmapProgress;->e:Landroid/graphics/Paint;

    .line 96
    iget-object v0, p0, Lcom/jibo/ui/view/BitmapProgress;->e:Landroid/graphics/Paint;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setAntiAlias(Z)V

    .line 97
    iget-object v0, p0, Lcom/jibo/ui/view/BitmapProgress;->e:Landroid/graphics/Paint;

    sget-object v1, Landroid/graphics/Paint$Style;->FILL:Landroid/graphics/Paint$Style;

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setStyle(Landroid/graphics/Paint$Style;)V

    .line 99
    iget-object v0, p0, Lcom/jibo/ui/view/BitmapProgress;->k:Landroid/os/Handler;

    const/16 v1, 0x777

    const-wide/16 v2, 0x64

    invoke-virtual {v0, v1, v2, v3}, Landroid/os/Handler;->sendEmptyMessageDelayed(IJ)Z

    .line 100
    return-void
.end method

.method private c()Landroid/graphics/Bitmap;
    .locals 8

    .prologue
    const/4 v7, 0x0

    .line 122
    iget-object v0, p0, Lcom/jibo/ui/view/BitmapProgress;->e:Landroid/graphics/Paint;

    invoke-virtual {p0}, Lcom/jibo/ui/view/BitmapProgress;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    iget v2, p0, Lcom/jibo/ui/view/BitmapProgress;->f:I

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getColor(I)I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setColor(I)V

    .line 124
    new-instance v0, Landroid/graphics/Paint;

    invoke-direct {v0}, Landroid/graphics/Paint;-><init>()V

    .line 125
    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setAntiAlias(Z)V

    .line 126
    iget v1, p0, Lcom/jibo/ui/view/BitmapProgress;->a:I

    iget v2, p0, Lcom/jibo/ui/view/BitmapProgress;->b:I

    sget-object v3, Landroid/graphics/Bitmap$Config;->ARGB_8888:Landroid/graphics/Bitmap$Config;

    invoke-static {v1, v2, v3}, Landroid/graphics/Bitmap;->createBitmap(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;

    move-result-object v1

    .line 128
    new-instance v2, Landroid/graphics/Canvas;

    invoke-direct {v2, v1}, Landroid/graphics/Canvas;-><init>(Landroid/graphics/Bitmap;)V

    .line 130
    iget v3, p0, Lcom/jibo/ui/view/BitmapProgress;->a:I

    int-to-float v3, v3

    iget v4, p0, Lcom/jibo/ui/view/BitmapProgress;->h:I

    int-to-float v4, v4

    iget v5, p0, Lcom/jibo/ui/view/BitmapProgress;->g:I

    int-to-float v5, v5

    div-float/2addr v4, v5

    mul-float/2addr v3, v4

    .line 132
    iget-object v4, p0, Lcom/jibo/ui/view/BitmapProgress;->d:Landroid/graphics/Path;

    invoke-virtual {v4}, Landroid/graphics/Path;->reset()V

    .line 133
    iget-object v4, p0, Lcom/jibo/ui/view/BitmapProgress;->d:Landroid/graphics/Path;

    invoke-virtual {v4, v7, v7}, Landroid/graphics/Path;->moveTo(FF)V

    .line 134
    iget-object v4, p0, Lcom/jibo/ui/view/BitmapProgress;->d:Landroid/graphics/Path;

    iget v5, p0, Lcom/jibo/ui/view/BitmapProgress;->b:I

    int-to-float v5, v5

    invoke-virtual {v4, v7, v5}, Landroid/graphics/Path;->lineTo(FF)V

    .line 135
    iget-object v4, p0, Lcom/jibo/ui/view/BitmapProgress;->d:Landroid/graphics/Path;

    iget v5, p0, Lcom/jibo/ui/view/BitmapProgress;->b:I

    int-to-float v5, v5

    invoke-virtual {v4, v3, v5}, Landroid/graphics/Path;->lineTo(FF)V

    .line 136
    iget-object v4, p0, Lcom/jibo/ui/view/BitmapProgress;->d:Landroid/graphics/Path;

    invoke-virtual {v4, v3, v7}, Landroid/graphics/Path;->lineTo(FF)V

    .line 138
    iget-object v3, p0, Lcom/jibo/ui/view/BitmapProgress;->d:Landroid/graphics/Path;

    invoke-virtual {v3}, Landroid/graphics/Path;->close()V

    .line 139
    iget-object v3, p0, Lcom/jibo/ui/view/BitmapProgress;->d:Landroid/graphics/Path;

    iget-object v4, p0, Lcom/jibo/ui/view/BitmapProgress;->e:Landroid/graphics/Paint;

    invoke-virtual {v2, v3, v4}, Landroid/graphics/Canvas;->drawPath(Landroid/graphics/Path;Landroid/graphics/Paint;)V

    .line 141
    iget-object v3, p0, Lcom/jibo/ui/view/BitmapProgress;->c:Landroid/graphics/Bitmap;

    iget v4, p0, Lcom/jibo/ui/view/BitmapProgress;->a:I

    iget v5, p0, Lcom/jibo/ui/view/BitmapProgress;->b:I

    const/4 v6, 0x0

    invoke-static {v3, v4, v5, v6}, Landroid/graphics/Bitmap;->createScaledBitmap(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;

    move-result-object v3

    iput-object v3, p0, Lcom/jibo/ui/view/BitmapProgress;->c:Landroid/graphics/Bitmap;

    .line 143
    new-instance v3, Landroid/graphics/PorterDuffXfermode;

    sget-object v4, Landroid/graphics/PorterDuff$Mode;->DST_ATOP:Landroid/graphics/PorterDuff$Mode;

    invoke-direct {v3, v4}, Landroid/graphics/PorterDuffXfermode;-><init>(Landroid/graphics/PorterDuff$Mode;)V

    invoke-virtual {v0, v3}, Landroid/graphics/Paint;->setXfermode(Landroid/graphics/Xfermode;)Landroid/graphics/Xfermode;

    .line 145
    iget-object v3, p0, Lcom/jibo/ui/view/BitmapProgress;->c:Landroid/graphics/Bitmap;

    invoke-virtual {v2, v3, v7, v7, v0}, Landroid/graphics/Canvas;->drawBitmap(Landroid/graphics/Bitmap;FFLandroid/graphics/Paint;)V

    .line 147
    return-object v1
.end method


# virtual methods
.method public a()V
    .locals 1

    .prologue
    .line 103
    invoke-virtual {p0}, Lcom/jibo/ui/view/BitmapProgress;->getBackground()Landroid/graphics/drawable/Drawable;

    move-result-object v0

    invoke-direct {p0, v0}, Lcom/jibo/ui/view/BitmapProgress;->a(Landroid/graphics/drawable/Drawable;)Landroid/graphics/Bitmap;

    move-result-object v0

    iput-object v0, p0, Lcom/jibo/ui/view/BitmapProgress;->c:Landroid/graphics/Bitmap;

    .line 104
    return-void
.end method

.method public getCurrentProgress()I
    .locals 1

    .prologue
    .line 83
    iget v0, p0, Lcom/jibo/ui/view/BitmapProgress;->h:I

    return v0
.end method

.method protected onDraw(Landroid/graphics/Canvas;)V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 116
    iget-object v0, p0, Lcom/jibo/ui/view/BitmapProgress;->c:Landroid/graphics/Bitmap;

    if-eqz v0, :cond_0

    .line 117
    invoke-direct {p0}, Lcom/jibo/ui/view/BitmapProgress;->c()Landroid/graphics/Bitmap;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {p1, v0, v2, v2, v1}, Landroid/graphics/Canvas;->drawBitmap(Landroid/graphics/Bitmap;FFLandroid/graphics/Paint;)V

    .line 119
    :cond_0
    return-void
.end method

.method protected onMeasure(II)V
    .locals 1

    .prologue
    .line 108
    invoke-super {p0, p1, p2}, Landroid/view/View;->onMeasure(II)V

    .line 110
    invoke-static {p1}, Landroid/view/View$MeasureSpec;->getSize(I)I

    move-result v0

    iput v0, p0, Lcom/jibo/ui/view/BitmapProgress;->a:I

    int-to-float v0, v0

    iput v0, p0, Lcom/jibo/ui/view/BitmapProgress;->i:F

    .line 111
    invoke-static {p2}, Landroid/view/View$MeasureSpec;->getSize(I)I

    move-result v0

    iput v0, p0, Lcom/jibo/ui/view/BitmapProgress;->b:I

    .line 112
    return-void
.end method

.method public setMaxProgress(I)V
    .locals 0

    .prologue
    .line 79
    iput p1, p0, Lcom/jibo/ui/view/BitmapProgress;->g:I

    .line 80
    return-void
.end method

.method public setProgress(I)V
    .locals 0

    .prologue
    .line 74
    iput p1, p0, Lcom/jibo/ui/view/BitmapProgress;->h:I

    .line 75
    return-void
.end method

.method public setWaveColor(I)V
    .locals 0

    .prologue
    .line 69
    iput p1, p0, Lcom/jibo/ui/view/BitmapProgress;->f:I

    .line 70
    return-void
.end method
