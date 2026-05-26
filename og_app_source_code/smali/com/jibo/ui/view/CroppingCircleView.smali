.class public Lcom/jibo/ui/view/CroppingCircleView;
.super Landroid/widget/ImageView;
.source "CroppingCircleView.java"


# static fields
.field public static a:I

.field private static b:Ljava/lang/String;

.field private static c:Ljava/lang/String;

.field private static d:Ljava/lang/String;


# instance fields
.field private A:Z

.field private B:Z

.field private e:Landroid/graphics/Paint;

.field private f:Landroid/graphics/Paint;

.field private g:Landroid/graphics/Paint;

.field private h:Landroid/graphics/Path;

.field private i:Landroid/graphics/RectF;

.field private j:Landroid/graphics/RectF;

.field private k:Landroid/graphics/RectF;

.field private l:Landroid/graphics/Rect;

.field private m:Landroid/graphics/Path;

.field private n:I

.field private o:I

.field private p:I

.field private q:I

.field private r:I

.field private s:I

.field private t:I

.field private u:I

.field private v:I

.field private w:F

.field private x:F

.field private y:F

.field private z:Ljava/io/File;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 33
    const-string v0, "radius"

    sput-object v0, Lcom/jibo/ui/view/CroppingCircleView;->b:Ljava/lang/String;

    .line 34
    const-string v0, "x"

    sput-object v0, Lcom/jibo/ui/view/CroppingCircleView;->c:Ljava/lang/String;

    .line 35
    const-string v0, "y"

    sput-object v0, Lcom/jibo/ui/view/CroppingCircleView;->d:Ljava/lang/String;

    .line 37
    const/16 v0, 0x1f4

    sput v0, Lcom/jibo/ui/view/CroppingCircleView;->a:I

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 2

    .prologue
    const/4 v1, 0x0

    const/4 v0, -0x1

    .line 56
    invoke-direct {p0, p1, p2}, Landroid/widget/ImageView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 44
    iput v0, p0, Lcom/jibo/ui/view/CroppingCircleView;->n:I

    iput v0, p0, Lcom/jibo/ui/view/CroppingCircleView;->o:I

    iput v0, p0, Lcom/jibo/ui/view/CroppingCircleView;->p:I

    iput v0, p0, Lcom/jibo/ui/view/CroppingCircleView;->q:I

    .line 48
    iput-boolean v1, p0, Lcom/jibo/ui/view/CroppingCircleView;->A:Z

    iput-boolean v1, p0, Lcom/jibo/ui/view/CroppingCircleView;->B:Z

    .line 57
    invoke-direct {p0}, Lcom/jibo/ui/view/CroppingCircleView;->a()V

    .line 58
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    .locals 2

    .prologue
    const/4 v1, 0x0

    const/4 v0, -0x1

    .line 61
    invoke-direct {p0, p1, p2, p3}, Landroid/widget/ImageView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 44
    iput v0, p0, Lcom/jibo/ui/view/CroppingCircleView;->n:I

    iput v0, p0, Lcom/jibo/ui/view/CroppingCircleView;->o:I

    iput v0, p0, Lcom/jibo/ui/view/CroppingCircleView;->p:I

    iput v0, p0, Lcom/jibo/ui/view/CroppingCircleView;->q:I

    .line 48
    iput-boolean v1, p0, Lcom/jibo/ui/view/CroppingCircleView;->A:Z

    iput-boolean v1, p0, Lcom/jibo/ui/view/CroppingCircleView;->B:Z

    .line 62
    invoke-direct {p0}, Lcom/jibo/ui/view/CroppingCircleView;->a()V

    .line 63
    return-void
.end method

.method private a(II)I
    .locals 5

    .prologue
    const/4 v4, 0x0

    const/high16 v3, 0x40000000    # 2.0f

    .line 279
    .line 280
    invoke-direct {p0}, Lcom/jibo/ui/view/CroppingCircleView;->getBitmapInViewBounds()[F

    move-result-object v0

    .line 281
    invoke-virtual {p0}, Lcom/jibo/ui/view/CroppingCircleView;->getWidth()I

    move-result v1

    div-int/lit8 v1, v1, 0x2

    int-to-float v1, v1

    aget v2, v0, v4

    div-float/2addr v2, v3

    sub-float/2addr v1, v2

    float-to-int v1, v1

    add-int/lit8 v1, v1, 0x2

    .line 282
    invoke-virtual {p0}, Lcom/jibo/ui/view/CroppingCircleView;->getWidth()I

    move-result v2

    div-int/lit8 v2, v2, 0x2

    int-to-float v2, v2

    aget v0, v0, v4

    div-float/2addr v0, v3

    add-float/2addr v0, v2

    float-to-int v0, v0

    add-int/lit8 v2, v0, -0x2

    .line 283
    sub-int v0, p2, p1

    if-ge v0, v1, :cond_1

    add-int v0, v1, p1

    .line 284
    :goto_0
    add-int v1, v0, p1

    if-le v1, v2, :cond_0

    sub-int v0, v2, p1

    .line 285
    :cond_0
    return v0

    :cond_1
    move v0, p2

    .line 283
    goto :goto_0
.end method

.method private a(IIII)I
    .locals 1

    .prologue
    .line 315
    invoke-direct {p0, p2, p3}, Lcom/jibo/ui/view/CroppingCircleView;->a(II)I

    move-result v0

    if-ne p3, v0, :cond_0

    invoke-direct {p0, p2, p4}, Lcom/jibo/ui/view/CroppingCircleView;->b(II)I

    move-result v0

    if-eq p4, v0, :cond_1

    :cond_0
    move p2, p1

    .line 318
    :cond_1
    return p2
.end method

.method private a()V
    .locals 5

    .prologue
    const/4 v4, 0x1

    const v2, 0x7f070057

    const/4 v3, 0x0

    .line 219
    invoke-virtual {p0}, Lcom/jibo/ui/view/CroppingCircleView;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    invoke-virtual {v0, v2}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v0

    iput v0, p0, Lcom/jibo/ui/view/CroppingCircleView;->p:I

    .line 220
    iget v0, p0, Lcom/jibo/ui/view/CroppingCircleView;->p:I

    add-int/lit8 v0, v0, -0x2

    iput v0, p0, Lcom/jibo/ui/view/CroppingCircleView;->q:I

    .line 221
    invoke-virtual {p0}, Lcom/jibo/ui/view/CroppingCircleView;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v1, 0x7f070055

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v0

    iput v0, p0, Lcom/jibo/ui/view/CroppingCircleView;->s:I

    .line 222
    invoke-virtual {p0}, Lcom/jibo/ui/view/CroppingCircleView;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    invoke-virtual {v0, v2}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v0

    int-to-float v0, v0

    .line 223
    invoke-virtual {p0}, Lcom/jibo/ui/view/CroppingCircleView;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v1

    int-to-float v1, v1

    const v2, 0x3dcccccd    # 0.1f

    mul-float/2addr v1, v2

    sub-float/2addr v0, v1

    float-to-int v0, v0

    iput v0, p0, Lcom/jibo/ui/view/CroppingCircleView;->r:I

    .line 224
    iget v0, p0, Lcom/jibo/ui/view/CroppingCircleView;->p:I

    div-int/lit8 v0, v0, 0x4

    iput v0, p0, Lcom/jibo/ui/view/CroppingCircleView;->v:I

    .line 226
    new-instance v0, Landroid/graphics/Paint;

    invoke-direct {v0}, Landroid/graphics/Paint;-><init>()V

    iput-object v0, p0, Lcom/jibo/ui/view/CroppingCircleView;->e:Landroid/graphics/Paint;

    .line 227
    iget-object v0, p0, Lcom/jibo/ui/view/CroppingCircleView;->e:Landroid/graphics/Paint;

    const/16 v1, 0x64

    invoke-virtual {v0, v1, v3, v3, v3}, Landroid/graphics/Paint;->setARGB(IIII)V

    .line 228
    iget-object v0, p0, Lcom/jibo/ui/view/CroppingCircleView;->e:Landroid/graphics/Paint;

    sget-object v1, Landroid/graphics/Paint$Cap;->SQUARE:Landroid/graphics/Paint$Cap;

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setStrokeCap(Landroid/graphics/Paint$Cap;)V

    .line 229
    iget-object v0, p0, Lcom/jibo/ui/view/CroppingCircleView;->e:Landroid/graphics/Paint;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setStrokeWidth(F)V

    .line 230
    new-instance v0, Landroid/graphics/Paint;

    invoke-direct {v0}, Landroid/graphics/Paint;-><init>()V

    iput-object v0, p0, Lcom/jibo/ui/view/CroppingCircleView;->f:Landroid/graphics/Paint;

    .line 231
    iget-object v0, p0, Lcom/jibo/ui/view/CroppingCircleView;->f:Landroid/graphics/Paint;

    const/4 v1, -0x1

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setColor(I)V

    .line 232
    iget-object v0, p0, Lcom/jibo/ui/view/CroppingCircleView;->f:Landroid/graphics/Paint;

    const/high16 v1, 0x40800000    # 4.0f

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setStrokeWidth(F)V

    .line 233
    iget-object v0, p0, Lcom/jibo/ui/view/CroppingCircleView;->f:Landroid/graphics/Paint;

    sget-object v1, Landroid/graphics/Paint$Style;->STROKE:Landroid/graphics/Paint$Style;

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setStyle(Landroid/graphics/Paint$Style;)V

    .line 234
    iget-object v0, p0, Lcom/jibo/ui/view/CroppingCircleView;->f:Landroid/graphics/Paint;

    invoke-virtual {v0, v4}, Landroid/graphics/Paint;->setAntiAlias(Z)V

    .line 235
    new-instance v0, Landroid/graphics/Paint;

    invoke-direct {v0}, Landroid/graphics/Paint;-><init>()V

    iput-object v0, p0, Lcom/jibo/ui/view/CroppingCircleView;->g:Landroid/graphics/Paint;

    .line 236
    iget-object v0, p0, Lcom/jibo/ui/view/CroppingCircleView;->g:Landroid/graphics/Paint;

    invoke-virtual {p0}, Lcom/jibo/ui/view/CroppingCircleView;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f06007b

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getColor(I)I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setColor(I)V

    .line 237
    iget-object v0, p0, Lcom/jibo/ui/view/CroppingCircleView;->g:Landroid/graphics/Paint;

    const/high16 v1, 0x40c00000    # 6.0f

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setStrokeWidth(F)V

    .line 238
    iget-object v0, p0, Lcom/jibo/ui/view/CroppingCircleView;->g:Landroid/graphics/Paint;

    sget-object v1, Landroid/graphics/Paint$Style;->STROKE:Landroid/graphics/Paint$Style;

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setStyle(Landroid/graphics/Paint$Style;)V

    .line 239
    iget-object v0, p0, Lcom/jibo/ui/view/CroppingCircleView;->g:Landroid/graphics/Paint;

    invoke-virtual {v0, v4}, Landroid/graphics/Paint;->setAntiAlias(Z)V

    .line 240
    new-instance v0, Landroid/graphics/Path;

    invoke-direct {v0}, Landroid/graphics/Path;-><init>()V

    iput-object v0, p0, Lcom/jibo/ui/view/CroppingCircleView;->h:Landroid/graphics/Path;

    .line 241
    iget-object v0, p0, Lcom/jibo/ui/view/CroppingCircleView;->h:Landroid/graphics/Path;

    sget-object v1, Landroid/graphics/Path$FillType;->INVERSE_EVEN_ODD:Landroid/graphics/Path$FillType;

    invoke-virtual {v0, v1}, Landroid/graphics/Path;->setFillType(Landroid/graphics/Path$FillType;)V

    .line 242
    new-instance v0, Landroid/graphics/Path;

    invoke-direct {v0}, Landroid/graphics/Path;-><init>()V

    iput-object v0, p0, Lcom/jibo/ui/view/CroppingCircleView;->m:Landroid/graphics/Path;

    .line 243
    iget-object v0, p0, Lcom/jibo/ui/view/CroppingCircleView;->m:Landroid/graphics/Path;

    sget-object v1, Landroid/graphics/Path$FillType;->EVEN_ODD:Landroid/graphics/Path$FillType;

    invoke-virtual {v0, v1}, Landroid/graphics/Path;->setFillType(Landroid/graphics/Path$FillType;)V

    .line 244
    return-void
.end method

.method private b(II)I
    .locals 5

    .prologue
    const/4 v4, 0x1

    const/high16 v3, 0x40000000    # 2.0f

    .line 296
    .line 297
    invoke-direct {p0}, Lcom/jibo/ui/view/CroppingCircleView;->getBitmapInViewBounds()[F

    move-result-object v0

    .line 298
    invoke-virtual {p0}, Lcom/jibo/ui/view/CroppingCircleView;->getHeight()I

    move-result v1

    div-int/lit8 v1, v1, 0x2

    int-to-float v1, v1

    aget v2, v0, v4

    div-float/2addr v2, v3

    sub-float/2addr v1, v2

    float-to-int v1, v1

    add-int/lit8 v1, v1, 0x2

    .line 299
    invoke-virtual {p0}, Lcom/jibo/ui/view/CroppingCircleView;->getHeight()I

    move-result v2

    div-int/lit8 v2, v2, 0x2

    int-to-float v2, v2

    aget v0, v0, v4

    div-float/2addr v0, v3

    add-float/2addr v0, v2

    float-to-int v0, v0

    add-int/lit8 v2, v0, -0x2

    .line 300
    sub-int v0, p2, p1

    if-ge v0, v1, :cond_1

    add-int v0, v1, p1

    .line 301
    :goto_0
    add-int v1, v0, p1

    if-le v1, v2, :cond_0

    sub-int v0, v2, p1

    .line 302
    :cond_0
    return v0

    :cond_1
    move v0, p2

    .line 300
    goto :goto_0
.end method

.method private b()V
    .locals 7

    .prologue
    const/high16 v6, 0x3f800000    # 1.0f

    .line 250
    iget-object v0, p0, Lcom/jibo/ui/view/CroppingCircleView;->z:Ljava/io/File;

    if-eqz v0, :cond_0

    invoke-virtual {p0}, Lcom/jibo/ui/view/CroppingCircleView;->getWidth()I

    move-result v0

    if-eqz v0, :cond_0

    invoke-virtual {p0}, Lcom/jibo/ui/view/CroppingCircleView;->getHeight()I

    move-result v0

    if-nez v0, :cond_1

    .line 269
    :cond_0
    :goto_0
    return-void

    .line 253
    :cond_1
    new-instance v0, Landroid/graphics/RectF;

    iget v1, p0, Lcom/jibo/ui/view/CroppingCircleView;->n:I

    iget v2, p0, Lcom/jibo/ui/view/CroppingCircleView;->p:I

    sub-int/2addr v1, v2

    int-to-float v1, v1

    iget v2, p0, Lcom/jibo/ui/view/CroppingCircleView;->o:I

    iget v3, p0, Lcom/jibo/ui/view/CroppingCircleView;->p:I

    sub-int/2addr v2, v3

    int-to-float v2, v2

    iget v3, p0, Lcom/jibo/ui/view/CroppingCircleView;->n:I

    iget v4, p0, Lcom/jibo/ui/view/CroppingCircleView;->p:I

    add-int/2addr v3, v4

    int-to-float v3, v3

    iget v4, p0, Lcom/jibo/ui/view/CroppingCircleView;->o:I

    iget v5, p0, Lcom/jibo/ui/view/CroppingCircleView;->p:I

    add-int/2addr v4, v5

    int-to-float v4, v4

    invoke-direct {v0, v1, v2, v3, v4}, Landroid/graphics/RectF;-><init>(FFFF)V

    iput-object v0, p0, Lcom/jibo/ui/view/CroppingCircleView;->k:Landroid/graphics/RectF;

    .line 256
    new-instance v0, Landroid/graphics/RectF;

    iget v1, p0, Lcom/jibo/ui/view/CroppingCircleView;->n:I

    iget v2, p0, Lcom/jibo/ui/view/CroppingCircleView;->q:I

    sub-int/2addr v1, v2

    int-to-float v1, v1

    iget v2, p0, Lcom/jibo/ui/view/CroppingCircleView;->o:I

    iget v3, p0, Lcom/jibo/ui/view/CroppingCircleView;->q:I

    sub-int/2addr v2, v3

    int-to-float v2, v2

    iget v3, p0, Lcom/jibo/ui/view/CroppingCircleView;->n:I

    iget v4, p0, Lcom/jibo/ui/view/CroppingCircleView;->q:I

    add-int/2addr v3, v4

    int-to-float v3, v3

    iget v4, p0, Lcom/jibo/ui/view/CroppingCircleView;->o:I

    iget v5, p0, Lcom/jibo/ui/view/CroppingCircleView;->q:I

    add-int/2addr v4, v5

    int-to-float v4, v4

    invoke-direct {v0, v1, v2, v3, v4}, Landroid/graphics/RectF;-><init>(FFFF)V

    iput-object v0, p0, Lcom/jibo/ui/view/CroppingCircleView;->i:Landroid/graphics/RectF;

    .line 259
    new-instance v0, Landroid/graphics/RectF;

    iget-object v1, p0, Lcom/jibo/ui/view/CroppingCircleView;->i:Landroid/graphics/RectF;

    iget v1, v1, Landroid/graphics/RectF;->left:F

    sub-float/2addr v1, v6

    iget-object v2, p0, Lcom/jibo/ui/view/CroppingCircleView;->i:Landroid/graphics/RectF;

    iget v2, v2, Landroid/graphics/RectF;->top:F

    sub-float/2addr v2, v6

    iget-object v3, p0, Lcom/jibo/ui/view/CroppingCircleView;->i:Landroid/graphics/RectF;

    iget v3, v3, Landroid/graphics/RectF;->right:F

    sub-float/2addr v3, v6

    iget-object v4, p0, Lcom/jibo/ui/view/CroppingCircleView;->i:Landroid/graphics/RectF;

    iget v4, v4, Landroid/graphics/RectF;->bottom:F

    sub-float/2addr v4, v6

    invoke-direct {v0, v1, v2, v3, v4}, Landroid/graphics/RectF;-><init>(FFFF)V

    iput-object v0, p0, Lcom/jibo/ui/view/CroppingCircleView;->j:Landroid/graphics/RectF;

    .line 262
    iget v0, p0, Lcom/jibo/ui/view/CroppingCircleView;->n:I

    invoke-virtual {p0}, Lcom/jibo/ui/view/CroppingCircleView;->getWidth()I

    move-result v1

    div-int/lit8 v1, v1, 0x2

    sub-int/2addr v0, v1

    .line 263
    iget v1, p0, Lcom/jibo/ui/view/CroppingCircleView;->o:I

    invoke-virtual {p0}, Lcom/jibo/ui/view/CroppingCircleView;->getHeight()I

    move-result v2

    div-int/lit8 v2, v2, 0x2

    sub-int/2addr v1, v2

    .line 265
    new-instance v2, Landroid/graphics/Rect;

    iget v3, p0, Lcom/jibo/ui/view/CroppingCircleView;->t:I

    div-int/lit8 v3, v3, 0x2

    neg-int v4, v0

    iget v5, p0, Lcom/jibo/ui/view/CroppingCircleView;->q:I

    add-int/2addr v4, v5

    int-to-float v4, v4

    iget v5, p0, Lcom/jibo/ui/view/CroppingCircleView;->w:F

    mul-float/2addr v4, v5

    float-to-int v4, v4

    sub-int/2addr v3, v4

    iget v4, p0, Lcom/jibo/ui/view/CroppingCircleView;->u:I

    div-int/lit8 v4, v4, 0x2

    neg-int v5, v1

    iget v6, p0, Lcom/jibo/ui/view/CroppingCircleView;->q:I

    add-int/2addr v5, v6

    int-to-float v5, v5

    iget v6, p0, Lcom/jibo/ui/view/CroppingCircleView;->w:F

    mul-float/2addr v5, v6

    float-to-int v5, v5

    sub-int/2addr v4, v5

    iget v5, p0, Lcom/jibo/ui/view/CroppingCircleView;->t:I

    div-int/lit8 v5, v5, 0x2

    iget v6, p0, Lcom/jibo/ui/view/CroppingCircleView;->q:I

    add-int/2addr v0, v6

    int-to-float v0, v0

    iget v6, p0, Lcom/jibo/ui/view/CroppingCircleView;->w:F

    mul-float/2addr v0, v6

    float-to-int v0, v0

    add-int/2addr v0, v5

    iget v5, p0, Lcom/jibo/ui/view/CroppingCircleView;->u:I

    div-int/lit8 v5, v5, 0x2

    iget v6, p0, Lcom/jibo/ui/view/CroppingCircleView;->q:I

    add-int/2addr v1, v6

    int-to-float v1, v1

    iget v6, p0, Lcom/jibo/ui/view/CroppingCircleView;->w:F

    mul-float/2addr v1, v6

    float-to-int v1, v1

    add-int/2addr v1, v5

    invoke-direct {v2, v3, v4, v0, v1}, Landroid/graphics/Rect;-><init>(IIII)V

    iput-object v2, p0, Lcom/jibo/ui/view/CroppingCircleView;->l:Landroid/graphics/Rect;

    goto/16 :goto_0
.end method

.method private c()V
    .locals 3

    .prologue
    .line 353
    iget-object v0, p0, Lcom/jibo/ui/view/CroppingCircleView;->z:Ljava/io/File;

    if-eqz v0, :cond_0

    invoke-virtual {p0}, Lcom/jibo/ui/view/CroppingCircleView;->getWidth()I

    move-result v0

    if-eqz v0, :cond_0

    invoke-virtual {p0}, Lcom/jibo/ui/view/CroppingCircleView;->getHeight()I

    move-result v0

    if-nez v0, :cond_1

    .line 369
    :cond_0
    :goto_0
    return-void

    .line 356
    :cond_1
    :try_start_0
    new-instance v0, Landroid/graphics/BitmapFactory$Options;

    invoke-direct {v0}, Landroid/graphics/BitmapFactory$Options;-><init>()V

    .line 357
    const/4 v1, 0x1

    iput-boolean v1, v0, Landroid/graphics/BitmapFactory$Options;->inJustDecodeBounds:Z

    .line 358
    iget-object v1, p0, Lcom/jibo/ui/view/CroppingCircleView;->z:Ljava/io/File;

    invoke-virtual {v1}, Ljava/io/File;->getPath()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1, v0}, Landroid/graphics/BitmapFactory;->decodeFile(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;

    .line 359
    iget v1, v0, Landroid/graphics/BitmapFactory$Options;->outWidth:I

    iput v1, p0, Lcom/jibo/ui/view/CroppingCircleView;->t:I

    .line 360
    iget v0, v0, Landroid/graphics/BitmapFactory$Options;->outHeight:I

    iput v0, p0, Lcom/jibo/ui/view/CroppingCircleView;->u:I

    .line 362
    iget-object v0, p0, Lcom/jibo/ui/view/CroppingCircleView;->z:Ljava/io/File;

    invoke-virtual {v0}, Ljava/io/File;->getPath()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0}, Lcom/jibo/ui/view/CroppingCircleView;->getWidth()I

    move-result v1

    invoke-virtual {p0}, Lcom/jibo/ui/view/CroppingCircleView;->getHeight()I

    move-result v2

    invoke-static {v0, v1, v2}, Lcom/jibo/utils/ImageUtils;->a(Ljava/lang/String;II)Landroid/graphics/Bitmap;

    move-result-object v0

    .line 363
    invoke-virtual {p0, v0}, Lcom/jibo/ui/view/CroppingCircleView;->setImageBitmap(Landroid/graphics/Bitmap;)V

    .line 364
    invoke-direct {p0}, Lcom/jibo/ui/view/CroppingCircleView;->getBitmapInViewBounds()[F

    move-result-object v0

    .line 365
    iget v1, p0, Lcom/jibo/ui/view/CroppingCircleView;->t:I

    int-to-float v1, v1

    const/4 v2, 0x0

    aget v0, v0, v2

    div-float v0, v1, v0

    iput v0, p0, Lcom/jibo/ui/view/CroppingCircleView;->w:F
    :try_end_0
    .catch Ljava/io/FileNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 367
    :catch_0
    move-exception v0

    goto :goto_0
.end method

.method private getBitmapInViewBounds()[F
    .locals 7

    .prologue
    const/4 v6, 0x0

    const/4 v5, 0x1

    .line 328
    const/4 v0, 0x2

    new-array v0, v0, [F

    invoke-virtual {p0}, Lcom/jibo/ui/view/CroppingCircleView;->getWidth()I

    move-result v1

    int-to-float v1, v1

    aput v1, v0, v6

    invoke-virtual {p0}, Lcom/jibo/ui/view/CroppingCircleView;->getHeight()I

    move-result v1

    int-to-float v1, v1

    aput v1, v0, v5

    .line 330
    invoke-virtual {p0}, Lcom/jibo/ui/view/CroppingCircleView;->getDrawable()Landroid/graphics/drawable/Drawable;

    move-result-object v1

    invoke-virtual {v1}, Landroid/graphics/drawable/Drawable;->getIntrinsicWidth()I

    move-result v1

    int-to-float v1, v1

    invoke-virtual {p0}, Lcom/jibo/ui/view/CroppingCircleView;->getDrawable()Landroid/graphics/drawable/Drawable;

    move-result-object v2

    invoke-virtual {v2}, Landroid/graphics/drawable/Drawable;->getIntrinsicHeight()I

    move-result v2

    int-to-float v2, v2

    div-float/2addr v1, v2

    .line 331
    invoke-virtual {p0}, Lcom/jibo/ui/view/CroppingCircleView;->getWidth()I

    move-result v2

    int-to-float v2, v2

    invoke-virtual {p0}, Lcom/jibo/ui/view/CroppingCircleView;->getDrawable()Landroid/graphics/drawable/Drawable;

    move-result-object v3

    invoke-virtual {v3}, Landroid/graphics/drawable/Drawable;->getIntrinsicWidth()I

    move-result v3

    int-to-float v3, v3

    div-float/2addr v2, v3

    .line 332
    invoke-virtual {p0}, Lcom/jibo/ui/view/CroppingCircleView;->getHeight()I

    move-result v3

    int-to-float v3, v3

    invoke-virtual {p0}, Lcom/jibo/ui/view/CroppingCircleView;->getDrawable()Landroid/graphics/drawable/Drawable;

    move-result-object v4

    invoke-virtual {v4}, Landroid/graphics/drawable/Drawable;->getIntrinsicHeight()I

    move-result v4

    int-to-float v4, v4

    div-float/2addr v3, v4

    .line 335
    const/high16 v4, 0x3f800000    # 1.0f

    cmpl-float v1, v1, v4

    if-lez v1, :cond_0

    .line 336
    invoke-virtual {p0}, Lcom/jibo/ui/view/CroppingCircleView;->getDrawable()Landroid/graphics/drawable/Drawable;

    move-result-object v1

    invoke-virtual {v1}, Landroid/graphics/drawable/Drawable;->getIntrinsicHeight()I

    move-result v1

    int-to-float v1, v1

    mul-float/2addr v1, v2

    aput v1, v0, v5

    .line 346
    :goto_0
    return-object v0

    .line 339
    :cond_0
    invoke-virtual {p0}, Lcom/jibo/ui/view/CroppingCircleView;->getDrawable()Landroid/graphics/drawable/Drawable;

    move-result-object v1

    invoke-virtual {v1}, Landroid/graphics/drawable/Drawable;->getIntrinsicHeight()I

    move-result v1

    int-to-float v1, v1

    mul-float/2addr v1, v2

    invoke-virtual {p0}, Lcom/jibo/ui/view/CroppingCircleView;->getHeight()I

    move-result v4

    int-to-float v4, v4

    cmpg-float v1, v1, v4

    if-gez v1, :cond_1

    .line 340
    invoke-virtual {p0}, Lcom/jibo/ui/view/CroppingCircleView;->getDrawable()Landroid/graphics/drawable/Drawable;

    move-result-object v1

    invoke-virtual {v1}, Landroid/graphics/drawable/Drawable;->getIntrinsicHeight()I

    move-result v1

    int-to-float v1, v1

    mul-float/2addr v1, v2

    aput v1, v0, v5

    goto :goto_0

    .line 342
    :cond_1
    invoke-virtual {p0}, Lcom/jibo/ui/view/CroppingCircleView;->getDrawable()Landroid/graphics/drawable/Drawable;

    move-result-object v1

    invoke-virtual {v1}, Landroid/graphics/drawable/Drawable;->getIntrinsicWidth()I

    move-result v1

    int-to-float v1, v1

    mul-float/2addr v1, v3

    aput v1, v0, v6

    goto :goto_0
.end method


# virtual methods
.method public getCroppedImage()Landroid/graphics/Bitmap;
    .locals 4

    .prologue
    const/4 v0, 0x0

    .line 388
    .line 390
    :try_start_0
    iget-object v1, p0, Lcom/jibo/ui/view/CroppingCircleView;->z:Ljava/io/File;

    invoke-virtual {v1}, Ljava/io/File;->getPath()Ljava/lang/String;

    move-result-object v1

    const/4 v2, 0x0

    invoke-static {v1, v2}, Landroid/graphics/BitmapRegionDecoder;->newInstance(Ljava/lang/String;Z)Landroid/graphics/BitmapRegionDecoder;

    move-result-object v1

    .line 391
    iget-object v2, p0, Lcom/jibo/ui/view/CroppingCircleView;->l:Landroid/graphics/Rect;

    const/4 v3, 0x0

    invoke-virtual {v1, v2, v3}, Landroid/graphics/BitmapRegionDecoder;->decodeRegion(Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    .line 396
    :goto_0
    return-object v0

    .line 392
    :catch_0
    move-exception v1

    goto :goto_0
.end method

.method protected onDraw(Landroid/graphics/Canvas;)V
    .locals 7

    .prologue
    const/4 v4, 0x0

    const/4 v5, 0x0

    .line 73
    invoke-super {p0, p1}, Landroid/widget/ImageView;->onDraw(Landroid/graphics/Canvas;)V

    .line 74
    iget-object v0, p0, Lcom/jibo/ui/view/CroppingCircleView;->k:Landroid/graphics/RectF;

    if-nez v0, :cond_1

    .line 113
    :cond_0
    :goto_0
    return-void

    .line 76
    :cond_1
    iget-object v0, p0, Lcom/jibo/ui/view/CroppingCircleView;->h:Landroid/graphics/Path;

    invoke-virtual {v0}, Landroid/graphics/Path;->reset()V

    .line 77
    iget-object v0, p0, Lcom/jibo/ui/view/CroppingCircleView;->h:Landroid/graphics/Path;

    iget-object v1, p0, Lcom/jibo/ui/view/CroppingCircleView;->k:Landroid/graphics/RectF;

    sget-object v2, Landroid/graphics/Path$Direction;->CW:Landroid/graphics/Path$Direction;

    invoke-virtual {v0, v1, v2}, Landroid/graphics/Path;->addOval(Landroid/graphics/RectF;Landroid/graphics/Path$Direction;)V

    .line 78
    iget-object v0, p0, Lcom/jibo/ui/view/CroppingCircleView;->m:Landroid/graphics/Path;

    invoke-virtual {v0}, Landroid/graphics/Path;->reset()V

    .line 79
    iget v0, p0, Lcom/jibo/ui/view/CroppingCircleView;->p:I

    add-int/lit8 v0, v0, 0x2

    .line 81
    iget-object v1, p0, Lcom/jibo/ui/view/CroppingCircleView;->m:Landroid/graphics/Path;

    iget v2, p0, Lcom/jibo/ui/view/CroppingCircleView;->n:I

    sub-int/2addr v2, v0

    int-to-float v2, v2

    iget v3, p0, Lcom/jibo/ui/view/CroppingCircleView;->o:I

    sub-int/2addr v3, v0

    int-to-float v3, v3

    invoke-virtual {v1, v2, v3}, Landroid/graphics/Path;->moveTo(FF)V

    .line 82
    iget-object v1, p0, Lcom/jibo/ui/view/CroppingCircleView;->m:Landroid/graphics/Path;

    iget v2, p0, Lcom/jibo/ui/view/CroppingCircleView;->n:I

    add-int/2addr v2, v0

    int-to-float v2, v2

    iget v3, p0, Lcom/jibo/ui/view/CroppingCircleView;->o:I

    sub-int/2addr v3, v0

    int-to-float v3, v3

    invoke-virtual {v1, v2, v3}, Landroid/graphics/Path;->lineTo(FF)V

    .line 83
    iget-object v1, p0, Lcom/jibo/ui/view/CroppingCircleView;->m:Landroid/graphics/Path;

    iget v2, p0, Lcom/jibo/ui/view/CroppingCircleView;->n:I

    add-int/2addr v2, v0

    int-to-float v2, v2

    iget v3, p0, Lcom/jibo/ui/view/CroppingCircleView;->o:I

    add-int/2addr v3, v0

    int-to-float v3, v3

    invoke-virtual {v1, v2, v3}, Landroid/graphics/Path;->lineTo(FF)V

    .line 84
    iget-object v1, p0, Lcom/jibo/ui/view/CroppingCircleView;->m:Landroid/graphics/Path;

    iget v2, p0, Lcom/jibo/ui/view/CroppingCircleView;->n:I

    sub-int/2addr v2, v0

    int-to-float v2, v2

    iget v3, p0, Lcom/jibo/ui/view/CroppingCircleView;->o:I

    add-int/2addr v3, v0

    int-to-float v3, v3

    invoke-virtual {v1, v2, v3}, Landroid/graphics/Path;->lineTo(FF)V

    .line 85
    iget-object v1, p0, Lcom/jibo/ui/view/CroppingCircleView;->m:Landroid/graphics/Path;

    iget v2, p0, Lcom/jibo/ui/view/CroppingCircleView;->n:I

    sub-int/2addr v2, v0

    int-to-float v2, v2

    iget v3, p0, Lcom/jibo/ui/view/CroppingCircleView;->o:I

    sub-int v0, v3, v0

    int-to-float v0, v0

    invoke-virtual {v1, v2, v0}, Landroid/graphics/Path;->lineTo(FF)V

    .line 86
    iget-object v0, p0, Lcom/jibo/ui/view/CroppingCircleView;->m:Landroid/graphics/Path;

    invoke-virtual {v0, v5, v5}, Landroid/graphics/Path;->lineTo(FF)V

    .line 87
    iget-object v0, p0, Lcom/jibo/ui/view/CroppingCircleView;->m:Landroid/graphics/Path;

    invoke-virtual {p0}, Lcom/jibo/ui/view/CroppingCircleView;->getHeight()I

    move-result v1

    int-to-float v1, v1

    invoke-virtual {v0, v5, v1}, Landroid/graphics/Path;->lineTo(FF)V

    .line 88
    iget-object v0, p0, Lcom/jibo/ui/view/CroppingCircleView;->m:Landroid/graphics/Path;

    invoke-virtual {p0}, Lcom/jibo/ui/view/CroppingCircleView;->getWidth()I

    move-result v1

    int-to-float v1, v1

    invoke-virtual {p0}, Lcom/jibo/ui/view/CroppingCircleView;->getHeight()I

    move-result v2

    int-to-float v2, v2

    invoke-virtual {v0, v1, v2}, Landroid/graphics/Path;->lineTo(FF)V

    .line 89
    iget-object v0, p0, Lcom/jibo/ui/view/CroppingCircleView;->m:Landroid/graphics/Path;

    invoke-virtual {p0}, Lcom/jibo/ui/view/CroppingCircleView;->getWidth()I

    move-result v1

    int-to-float v1, v1

    invoke-virtual {v0, v1, v5}, Landroid/graphics/Path;->lineTo(FF)V

    .line 90
    iget-object v0, p0, Lcom/jibo/ui/view/CroppingCircleView;->m:Landroid/graphics/Path;

    invoke-virtual {v0, v5, v5}, Landroid/graphics/Path;->lineTo(FF)V

    .line 91
    iget-object v0, p0, Lcom/jibo/ui/view/CroppingCircleView;->m:Landroid/graphics/Path;

    invoke-virtual {v0}, Landroid/graphics/Path;->close()V

    .line 92
    iget-object v0, p0, Lcom/jibo/ui/view/CroppingCircleView;->h:Landroid/graphics/Path;

    iget-object v1, p0, Lcom/jibo/ui/view/CroppingCircleView;->e:Landroid/graphics/Paint;

    invoke-virtual {p1, v0, v1}, Landroid/graphics/Canvas;->drawPath(Landroid/graphics/Path;Landroid/graphics/Paint;)V

    .line 93
    iget-object v0, p0, Lcom/jibo/ui/view/CroppingCircleView;->m:Landroid/graphics/Path;

    iget-object v1, p0, Lcom/jibo/ui/view/CroppingCircleView;->e:Landroid/graphics/Paint;

    invoke-virtual {p1, v0, v1}, Landroid/graphics/Canvas;->drawPath(Landroid/graphics/Path;Landroid/graphics/Paint;)V

    .line 94
    iget-object v0, p0, Lcom/jibo/ui/view/CroppingCircleView;->i:Landroid/graphics/RectF;

    iget-object v1, p0, Lcom/jibo/ui/view/CroppingCircleView;->f:Landroid/graphics/Paint;

    invoke-virtual {p1, v0, v1}, Landroid/graphics/Canvas;->drawOval(Landroid/graphics/RectF;Landroid/graphics/Paint;)V

    .line 95
    iget-object v1, p0, Lcom/jibo/ui/view/CroppingCircleView;->j:Landroid/graphics/RectF;

    const/high16 v2, 0x43910000    # 290.0f

    const/high16 v3, 0x42480000    # 50.0f

    iget-object v5, p0, Lcom/jibo/ui/view/CroppingCircleView;->g:Landroid/graphics/Paint;

    move-object v0, p1

    invoke-virtual/range {v0 .. v5}, Landroid/graphics/Canvas;->drawArc(Landroid/graphics/RectF;FFZLandroid/graphics/Paint;)V

    .line 98
    iget-boolean v0, p0, Lcom/jibo/ui/view/CroppingCircleView;->B:Z

    if-eqz v0, :cond_0

    .line 99
    new-instance v0, Landroid/graphics/Rect;

    invoke-virtual {p0}, Lcom/jibo/ui/view/CroppingCircleView;->getHeight()I

    move-result v1

    sget v2, Lcom/jibo/ui/view/CroppingCircleView;->a:I

    sub-int/2addr v1, v2

    sget v2, Lcom/jibo/ui/view/CroppingCircleView;->a:I

    invoke-virtual {p0}, Lcom/jibo/ui/view/CroppingCircleView;->getHeight()I

    move-result v3

    invoke-direct {v0, v4, v1, v2, v3}, Landroid/graphics/Rect;-><init>(IIII)V

    .line 102
    :try_start_0
    iget-object v1, p0, Lcom/jibo/ui/view/CroppingCircleView;->z:Ljava/io/File;

    invoke-virtual {v1}, Ljava/io/File;->getPath()Ljava/lang/String;

    move-result-object v1

    const/4 v2, 0x0

    invoke-static {v1, v2}, Landroid/graphics/BitmapRegionDecoder;->newInstance(Ljava/lang/String;Z)Landroid/graphics/BitmapRegionDecoder;

    move-result-object v1

    .line 103
    iget-object v2, p0, Lcom/jibo/ui/view/CroppingCircleView;->l:Landroid/graphics/Rect;

    const/4 v3, 0x0

    invoke-virtual {v1, v2, v3}, Landroid/graphics/BitmapRegionDecoder;->decodeRegion(Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;

    move-result-object v1

    .line 104
    if-eqz v1, :cond_0

    .line 105
    new-instance v2, Landroid/graphics/Rect;

    const/4 v3, 0x0

    const/4 v4, 0x0

    invoke-virtual {v1}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v5

    invoke-virtual {v1}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v6

    invoke-direct {v2, v3, v4, v5, v6}, Landroid/graphics/Rect;-><init>(IIII)V

    .line 106
    const/4 v3, 0x0

    invoke-virtual {p1, v1, v2, v0, v3}, Landroid/graphics/Canvas;->drawBitmap(Landroid/graphics/Bitmap;Landroid/graphics/Rect;Landroid/graphics/Rect;Landroid/graphics/Paint;)V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    goto/16 :goto_0

    .line 108
    :catch_0
    move-exception v0

    goto/16 :goto_0
.end method

.method protected onRestoreInstanceState(Landroid/os/Parcelable;)V
    .locals 2

    .prologue
    .line 130
    instance-of v0, p1, Landroid/os/Bundle;

    if-eqz v0, :cond_0

    move-object v0, p1

    .line 132
    check-cast v0, Landroid/os/Bundle;

    sget-object v1, Lcom/jibo/ui/view/CroppingCircleView;->b:Ljava/lang/String;

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getInt(Ljava/lang/String;)I

    move-result v0

    iput v0, p0, Lcom/jibo/ui/view/CroppingCircleView;->p:I

    .line 133
    iget v0, p0, Lcom/jibo/ui/view/CroppingCircleView;->p:I

    add-int/lit8 v0, v0, -0x2

    iput v0, p0, Lcom/jibo/ui/view/CroppingCircleView;->q:I

    .line 134
    iget v0, p0, Lcom/jibo/ui/view/CroppingCircleView;->p:I

    div-int/lit8 v0, v0, 0x4

    iput v0, p0, Lcom/jibo/ui/view/CroppingCircleView;->v:I

    move-object v0, p1

    .line 135
    check-cast v0, Landroid/os/Bundle;

    sget-object v1, Lcom/jibo/ui/view/CroppingCircleView;->c:Ljava/lang/String;

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getInt(Ljava/lang/String;)I

    move-result v0

    iput v0, p0, Lcom/jibo/ui/view/CroppingCircleView;->n:I

    move-object v0, p1

    .line 136
    check-cast v0, Landroid/os/Bundle;

    sget-object v1, Lcom/jibo/ui/view/CroppingCircleView;->d:Ljava/lang/String;

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getInt(Ljava/lang/String;)I

    move-result v0

    iput v0, p0, Lcom/jibo/ui/view/CroppingCircleView;->o:I

    .line 138
    invoke-direct {p0}, Lcom/jibo/ui/view/CroppingCircleView;->b()V

    .line 140
    check-cast p1, Landroid/os/Bundle;

    const-string v0, "instanceState"

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v0

    invoke-super {p0, v0}, Landroid/widget/ImageView;->onRestoreInstanceState(Landroid/os/Parcelable;)V

    .line 145
    :goto_0
    return-void

    .line 144
    :cond_0
    invoke-super {p0, p1}, Landroid/widget/ImageView;->onRestoreInstanceState(Landroid/os/Parcelable;)V

    goto :goto_0
.end method

.method protected onSaveInstanceState()Landroid/os/Parcelable;
    .locals 3

    .prologue
    .line 149
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 150
    sget-object v1, Lcom/jibo/ui/view/CroppingCircleView;->b:Ljava/lang/String;

    iget v2, p0, Lcom/jibo/ui/view/CroppingCircleView;->p:I

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 151
    sget-object v1, Lcom/jibo/ui/view/CroppingCircleView;->c:Ljava/lang/String;

    iget v2, p0, Lcom/jibo/ui/view/CroppingCircleView;->n:I

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 152
    sget-object v1, Lcom/jibo/ui/view/CroppingCircleView;->d:Ljava/lang/String;

    iget v2, p0, Lcom/jibo/ui/view/CroppingCircleView;->o:I

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 153
    const-string v1, "instanceState"

    invoke-super {p0}, Landroid/widget/ImageView;->onSaveInstanceState()Landroid/os/Parcelable;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 154
    return-object v0
.end method

.method protected onSizeChanged(IIII)V
    .locals 2

    .prologue
    const/4 v1, -0x1

    .line 117
    invoke-super {p0, p1, p2, p3, p4}, Landroid/widget/ImageView;->onSizeChanged(IIII)V

    .line 118
    iget v0, p0, Lcom/jibo/ui/view/CroppingCircleView;->n:I

    if-ne v0, v1, :cond_0

    div-int/lit8 v0, p1, 0x2

    :goto_0
    iput v0, p0, Lcom/jibo/ui/view/CroppingCircleView;->n:I

    .line 119
    iget v0, p0, Lcom/jibo/ui/view/CroppingCircleView;->o:I

    if-ne v0, v1, :cond_1

    div-int/lit8 v0, p2, 0x2

    :goto_1
    iput v0, p0, Lcom/jibo/ui/view/CroppingCircleView;->o:I

    .line 122
    invoke-direct {p0}, Lcom/jibo/ui/view/CroppingCircleView;->c()V

    .line 125
    invoke-direct {p0}, Lcom/jibo/ui/view/CroppingCircleView;->b()V

    .line 126
    return-void

    .line 118
    :cond_0
    iget v0, p0, Lcom/jibo/ui/view/CroppingCircleView;->n:I

    goto :goto_0

    .line 119
    :cond_1
    iget v0, p0, Lcom/jibo/ui/view/CroppingCircleView;->o:I

    goto :goto_1
.end method

.method public onTouchEvent(Landroid/view/MotionEvent;)Z
    .locals 11

    .prologue
    const/4 v4, 0x0

    const/4 v10, 0x1

    const-wide/high16 v8, 0x4000000000000000L    # 2.0

    .line 160
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getPointerCount()I

    move-result v0

    if-ne v0, v10, :cond_0

    invoke-virtual {p0}, Lcom/jibo/ui/view/CroppingCircleView;->getDrawable()Landroid/graphics/drawable/Drawable;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 161
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getX()F

    move-result v0

    .line 162
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v1

    .line 164
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getActionMasked()I

    move-result v2

    packed-switch v2, :pswitch_data_0

    .line 207
    :goto_0
    invoke-direct {p0}, Lcom/jibo/ui/view/CroppingCircleView;->b()V

    .line 208
    invoke-virtual {p0}, Lcom/jibo/ui/view/CroppingCircleView;->invalidate()V

    .line 211
    :cond_0
    return v10

    .line 167
    :pswitch_0
    iget v2, p0, Lcom/jibo/ui/view/CroppingCircleView;->n:I

    iget v3, p0, Lcom/jibo/ui/view/CroppingCircleView;->p:I

    add-int/2addr v2, v3

    iget v3, p0, Lcom/jibo/ui/view/CroppingCircleView;->v:I

    mul-int/lit8 v3, v3, 0x2

    sub-int/2addr v2, v3

    int-to-float v2, v2

    cmpl-float v2, v0, v2

    if-ltz v2, :cond_1

    iget v2, p0, Lcom/jibo/ui/view/CroppingCircleView;->n:I

    iget v3, p0, Lcom/jibo/ui/view/CroppingCircleView;->p:I

    add-int/2addr v2, v3

    int-to-float v2, v2

    cmpg-float v2, v0, v2

    if-gtz v2, :cond_1

    iget v2, p0, Lcom/jibo/ui/view/CroppingCircleView;->o:I

    iget v3, p0, Lcom/jibo/ui/view/CroppingCircleView;->p:I

    sub-int/2addr v2, v3

    int-to-float v2, v2

    cmpl-float v2, v1, v2

    if-ltz v2, :cond_1

    iget v2, p0, Lcom/jibo/ui/view/CroppingCircleView;->o:I

    iget v3, p0, Lcom/jibo/ui/view/CroppingCircleView;->p:I

    sub-int/2addr v2, v3

    iget v3, p0, Lcom/jibo/ui/view/CroppingCircleView;->v:I

    mul-int/lit8 v3, v3, 0x2

    add-int/2addr v2, v3

    int-to-float v2, v2

    cmpg-float v2, v1, v2

    if-gtz v2, :cond_1

    .line 171
    iput-boolean v10, p0, Lcom/jibo/ui/view/CroppingCircleView;->A:Z

    .line 172
    iput v0, p0, Lcom/jibo/ui/view/CroppingCircleView;->x:F

    .line 173
    iput v1, p0, Lcom/jibo/ui/view/CroppingCircleView;->y:F

    goto :goto_0

    .line 175
    :cond_1
    iput-boolean v4, p0, Lcom/jibo/ui/view/CroppingCircleView;->A:Z

    .line 176
    iget v2, p0, Lcom/jibo/ui/view/CroppingCircleView;->q:I

    iget v3, p0, Lcom/jibo/ui/view/CroppingCircleView;->p:I

    div-int/lit8 v3, v3, 0x2

    int-to-float v3, v3

    sub-float/2addr v0, v3

    float-to-int v0, v0

    invoke-direct {p0, v2, v0}, Lcom/jibo/ui/view/CroppingCircleView;->a(II)I

    move-result v0

    iput v0, p0, Lcom/jibo/ui/view/CroppingCircleView;->n:I

    .line 177
    iget v0, p0, Lcom/jibo/ui/view/CroppingCircleView;->q:I

    iget v2, p0, Lcom/jibo/ui/view/CroppingCircleView;->p:I

    div-int/lit8 v2, v2, 0x2

    int-to-float v2, v2

    sub-float/2addr v1, v2

    float-to-int v1, v1

    invoke-direct {p0, v0, v1}, Lcom/jibo/ui/view/CroppingCircleView;->b(II)I

    move-result v0

    iput v0, p0, Lcom/jibo/ui/view/CroppingCircleView;->o:I

    goto :goto_0

    .line 183
    :pswitch_1
    iget-boolean v2, p0, Lcom/jibo/ui/view/CroppingCircleView;->A:Z

    if-eqz v2, :cond_2

    .line 184
    iget v2, p0, Lcom/jibo/ui/view/CroppingCircleView;->n:I

    int-to-float v2, v2

    sub-float v2, v0, v2

    float-to-double v2, v2

    invoke-static {v2, v3, v8, v9}, Ljava/lang/Math;->pow(DD)D

    move-result-wide v2

    iget v4, p0, Lcom/jibo/ui/view/CroppingCircleView;->o:I

    int-to-float v4, v4

    sub-float v4, v1, v4

    float-to-double v4, v4

    .line 185
    invoke-static {v4, v5, v8, v9}, Ljava/lang/Math;->pow(DD)D

    move-result-wide v4

    add-double/2addr v2, v4

    .line 184
    invoke-static {v2, v3}, Ljava/lang/Math;->sqrt(D)D

    move-result-wide v2

    .line 186
    iget v4, p0, Lcom/jibo/ui/view/CroppingCircleView;->x:F

    iget v5, p0, Lcom/jibo/ui/view/CroppingCircleView;->n:I

    int-to-float v5, v5

    sub-float/2addr v4, v5

    float-to-double v4, v4

    invoke-static {v4, v5, v8, v9}, Ljava/lang/Math;->pow(DD)D

    move-result-wide v4

    iget v6, p0, Lcom/jibo/ui/view/CroppingCircleView;->y:F

    iget v7, p0, Lcom/jibo/ui/view/CroppingCircleView;->o:I

    int-to-float v7, v7

    sub-float/2addr v6, v7

    float-to-double v6, v6

    .line 187
    invoke-static {v6, v7, v8, v9}, Ljava/lang/Math;->pow(DD)D

    move-result-wide v6

    add-double/2addr v4, v6

    .line 186
    invoke-static {v4, v5}, Ljava/lang/Math;->sqrt(D)D

    move-result-wide v4

    .line 189
    iget v6, p0, Lcom/jibo/ui/view/CroppingCircleView;->p:I

    int-to-double v6, v6

    div-double/2addr v2, v4

    mul-double/2addr v2, v6

    invoke-static {v2, v3}, Ljava/lang/Math;->round(D)J

    move-result-wide v2

    long-to-int v2, v2

    .line 190
    iget v3, p0, Lcom/jibo/ui/view/CroppingCircleView;->r:I

    invoke-static {v2, v3}, Ljava/lang/Math;->max(II)I

    move-result v2

    iget v3, p0, Lcom/jibo/ui/view/CroppingCircleView;->s:I

    invoke-static {v2, v3}, Ljava/lang/Math;->min(II)I

    move-result v2

    .line 191
    iget v3, p0, Lcom/jibo/ui/view/CroppingCircleView;->p:I

    iget v4, p0, Lcom/jibo/ui/view/CroppingCircleView;->n:I

    iget v5, p0, Lcom/jibo/ui/view/CroppingCircleView;->o:I

    invoke-direct {p0, v3, v2, v4, v5}, Lcom/jibo/ui/view/CroppingCircleView;->a(IIII)I

    move-result v2

    iput v2, p0, Lcom/jibo/ui/view/CroppingCircleView;->p:I

    .line 192
    iget v2, p0, Lcom/jibo/ui/view/CroppingCircleView;->p:I

    add-int/lit8 v2, v2, -0x2

    iput v2, p0, Lcom/jibo/ui/view/CroppingCircleView;->q:I

    .line 193
    iget v2, p0, Lcom/jibo/ui/view/CroppingCircleView;->p:I

    div-int/lit8 v2, v2, 0x4

    iput v2, p0, Lcom/jibo/ui/view/CroppingCircleView;->v:I

    .line 195
    iput v0, p0, Lcom/jibo/ui/view/CroppingCircleView;->x:F

    .line 196
    iput v1, p0, Lcom/jibo/ui/view/CroppingCircleView;->y:F

    goto/16 :goto_0

    .line 199
    :cond_2
    iget v2, p0, Lcom/jibo/ui/view/CroppingCircleView;->q:I

    iget v3, p0, Lcom/jibo/ui/view/CroppingCircleView;->p:I

    div-int/lit8 v3, v3, 0x2

    int-to-float v3, v3

    sub-float/2addr v0, v3

    float-to-int v0, v0

    invoke-direct {p0, v2, v0}, Lcom/jibo/ui/view/CroppingCircleView;->a(II)I

    move-result v0

    iput v0, p0, Lcom/jibo/ui/view/CroppingCircleView;->n:I

    .line 200
    iget v0, p0, Lcom/jibo/ui/view/CroppingCircleView;->q:I

    iget v2, p0, Lcom/jibo/ui/view/CroppingCircleView;->p:I

    div-int/lit8 v2, v2, 0x2

    int-to-float v2, v2

    sub-float/2addr v1, v2

    float-to-int v1, v1

    invoke-direct {p0, v0, v1}, Lcom/jibo/ui/view/CroppingCircleView;->b(II)I

    move-result v0

    iput v0, p0, Lcom/jibo/ui/view/CroppingCircleView;->o:I

    goto/16 :goto_0

    .line 204
    :pswitch_2
    iput-boolean v4, p0, Lcom/jibo/ui/view/CroppingCircleView;->A:Z

    goto/16 :goto_0

    .line 164
    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_2
        :pswitch_1
    .end packed-switch
.end method

.method public setCropPreview(Z)V
    .locals 0

    .prologue
    .line 433
    iput-boolean p1, p0, Lcom/jibo/ui/view/CroppingCircleView;->B:Z

    .line 434
    return-void
.end method

.method public setImageFile(Ljava/io/File;)V
    .locals 0

    .prologue
    .line 375
    iput-object p1, p0, Lcom/jibo/ui/view/CroppingCircleView;->z:Ljava/io/File;

    .line 377
    invoke-direct {p0}, Lcom/jibo/ui/view/CroppingCircleView;->c()V

    .line 379
    invoke-direct {p0}, Lcom/jibo/ui/view/CroppingCircleView;->b()V

    .line 380
    return-void
.end method
