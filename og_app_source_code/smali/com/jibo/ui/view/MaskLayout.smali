.class public Lcom/jibo/ui/view/MaskLayout;
.super Landroid/widget/FrameLayout;
.source "MaskLayout.java"


# instance fields
.field private a:Landroid/os/Handler;

.field private b:Landroid/graphics/drawable/Drawable;

.field private c:Landroid/graphics/Bitmap;

.field private d:Z

.field private e:Landroid/graphics/Paint;

.field private f:Landroid/graphics/PorterDuffXfermode;


# direct methods
.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 69
    invoke-direct {p0, p1, p2}, Landroid/widget/FrameLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 54
    iput-object v1, p0, Lcom/jibo/ui/view/MaskLayout;->b:Landroid/graphics/drawable/Drawable;

    .line 56
    iput-object v1, p0, Lcom/jibo/ui/view/MaskLayout;->c:Landroid/graphics/Bitmap;

    .line 58
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/jibo/ui/view/MaskLayout;->d:Z

    .line 61
    iput-object v1, p0, Lcom/jibo/ui/view/MaskLayout;->e:Landroid/graphics/Paint;

    .line 62
    iput-object v1, p0, Lcom/jibo/ui/view/MaskLayout;->f:Landroid/graphics/PorterDuffXfermode;

    .line 70
    invoke-direct {p0, p1, p2}, Lcom/jibo/ui/view/MaskLayout;->a(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 71
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 74
    invoke-direct {p0, p1, p2, p3}, Landroid/widget/FrameLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 54
    iput-object v1, p0, Lcom/jibo/ui/view/MaskLayout;->b:Landroid/graphics/drawable/Drawable;

    .line 56
    iput-object v1, p0, Lcom/jibo/ui/view/MaskLayout;->c:Landroid/graphics/Bitmap;

    .line 58
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/jibo/ui/view/MaskLayout;->d:Z

    .line 61
    iput-object v1, p0, Lcom/jibo/ui/view/MaskLayout;->e:Landroid/graphics/Paint;

    .line 62
    iput-object v1, p0, Lcom/jibo/ui/view/MaskLayout;->f:Landroid/graphics/PorterDuffXfermode;

    .line 75
    invoke-direct {p0, p1, p2}, Lcom/jibo/ui/view/MaskLayout;->a(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 76
    return-void
.end method

.method static synthetic a(Lcom/jibo/ui/view/MaskLayout;Landroid/graphics/drawable/Drawable;)Landroid/graphics/Bitmap;
    .locals 1

    .prologue
    .line 28
    invoke-direct {p0, p1}, Lcom/jibo/ui/view/MaskLayout;->b(Landroid/graphics/drawable/Drawable;)Landroid/graphics/Bitmap;

    move-result-object v0

    return-object v0
.end method

.method private a(Z)Landroid/graphics/Paint;
    .locals 2

    .prologue
    .line 117
    new-instance v0, Landroid/graphics/Paint;

    const/4 v1, 0x1

    invoke-direct {v0, v1}, Landroid/graphics/Paint;-><init>(I)V

    .line 118
    invoke-virtual {v0, p1}, Landroid/graphics/Paint;->setAntiAlias(Z)V

    .line 119
    iget-object v1, p0, Lcom/jibo/ui/view/MaskLayout;->f:Landroid/graphics/PorterDuffXfermode;

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setXfermode(Landroid/graphics/Xfermode;)Landroid/graphics/Xfermode;

    .line 120
    return-object v0
.end method

.method private a(I)Landroid/graphics/PorterDuffXfermode;
    .locals 3

    .prologue
    const/16 v1, 0xb

    .line 277
    .line 278
    packed-switch p1, :pswitch_data_0

    .line 340
    sget-object v0, Landroid/graphics/PorterDuff$Mode;->DST_IN:Landroid/graphics/PorterDuff$Mode;

    .line 342
    :goto_0
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Mode is "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v0}, Landroid/graphics/PorterDuff$Mode;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {p0, v1}, Lcom/jibo/ui/view/MaskLayout;->a(Ljava/lang/String;)V

    .line 343
    new-instance v1, Landroid/graphics/PorterDuffXfermode;

    invoke-direct {v1, v0}, Landroid/graphics/PorterDuffXfermode;-><init>(Landroid/graphics/PorterDuff$Mode;)V

    return-object v1

    .line 280
    :pswitch_0
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    if-lt v0, v1, :cond_0

    .line 281
    sget-object v0, Landroid/graphics/PorterDuff$Mode;->ADD:Landroid/graphics/PorterDuff$Mode;

    .line 286
    :goto_1
    :pswitch_1
    sget-object v0, Landroid/graphics/PorterDuff$Mode;->CLEAR:Landroid/graphics/PorterDuff$Mode;

    goto :goto_0

    .line 283
    :cond_0
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "MODE_ADD is not supported on api lvl "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    sget v1, Landroid/os/Build$VERSION;->SDK_INT:I

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-direct {p0, v0}, Lcom/jibo/ui/view/MaskLayout;->a(Ljava/lang/String;)V

    goto :goto_1

    .line 289
    :pswitch_2
    sget-object v0, Landroid/graphics/PorterDuff$Mode;->DARKEN:Landroid/graphics/PorterDuff$Mode;

    goto :goto_0

    .line 292
    :pswitch_3
    sget-object v0, Landroid/graphics/PorterDuff$Mode;->DST:Landroid/graphics/PorterDuff$Mode;

    goto :goto_0

    .line 295
    :pswitch_4
    sget-object v0, Landroid/graphics/PorterDuff$Mode;->DST_ATOP:Landroid/graphics/PorterDuff$Mode;

    goto :goto_0

    .line 298
    :pswitch_5
    sget-object v0, Landroid/graphics/PorterDuff$Mode;->DST_IN:Landroid/graphics/PorterDuff$Mode;

    goto :goto_0

    .line 301
    :pswitch_6
    sget-object v0, Landroid/graphics/PorterDuff$Mode;->DST_OUT:Landroid/graphics/PorterDuff$Mode;

    goto :goto_0

    .line 304
    :pswitch_7
    sget-object v0, Landroid/graphics/PorterDuff$Mode;->DST_OVER:Landroid/graphics/PorterDuff$Mode;

    goto :goto_0

    .line 307
    :pswitch_8
    sget-object v0, Landroid/graphics/PorterDuff$Mode;->LIGHTEN:Landroid/graphics/PorterDuff$Mode;

    goto :goto_0

    .line 310
    :pswitch_9
    sget-object v0, Landroid/graphics/PorterDuff$Mode;->MULTIPLY:Landroid/graphics/PorterDuff$Mode;

    goto :goto_0

    .line 313
    :pswitch_a
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    if-lt v0, v1, :cond_1

    .line 314
    sget-object v0, Landroid/graphics/PorterDuff$Mode;->OVERLAY:Landroid/graphics/PorterDuff$Mode;

    .line 319
    :goto_2
    :pswitch_b
    sget-object v0, Landroid/graphics/PorterDuff$Mode;->SCREEN:Landroid/graphics/PorterDuff$Mode;

    goto :goto_0

    .line 316
    :cond_1
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "MODE_OVERLAY is not supported on api lvl "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    sget v1, Landroid/os/Build$VERSION;->SDK_INT:I

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-direct {p0, v0}, Lcom/jibo/ui/view/MaskLayout;->a(Ljava/lang/String;)V

    goto :goto_2

    .line 322
    :pswitch_c
    sget-object v0, Landroid/graphics/PorterDuff$Mode;->SRC:Landroid/graphics/PorterDuff$Mode;

    goto :goto_0

    .line 325
    :pswitch_d
    sget-object v0, Landroid/graphics/PorterDuff$Mode;->SRC_ATOP:Landroid/graphics/PorterDuff$Mode;

    goto/16 :goto_0

    .line 328
    :pswitch_e
    sget-object v0, Landroid/graphics/PorterDuff$Mode;->SRC_IN:Landroid/graphics/PorterDuff$Mode;

    goto/16 :goto_0

    .line 331
    :pswitch_f
    sget-object v0, Landroid/graphics/PorterDuff$Mode;->SRC_OUT:Landroid/graphics/PorterDuff$Mode;

    goto/16 :goto_0

    .line 334
    :pswitch_10
    sget-object v0, Landroid/graphics/PorterDuff$Mode;->SRC_OVER:Landroid/graphics/PorterDuff$Mode;

    goto/16 :goto_0

    .line 337
    :pswitch_11
    sget-object v0, Landroid/graphics/PorterDuff$Mode;->XOR:Landroid/graphics/PorterDuff$Mode;

    goto/16 :goto_0

    .line 278
    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
        :pswitch_4
        :pswitch_5
        :pswitch_6
        :pswitch_7
        :pswitch_8
        :pswitch_9
        :pswitch_a
        :pswitch_b
        :pswitch_c
        :pswitch_d
        :pswitch_e
        :pswitch_f
        :pswitch_10
        :pswitch_11
    .end packed-switch
.end method

.method private a(Landroid/content/res/TypedArray;)Landroid/graphics/drawable/Drawable;
    .locals 1

    .prologue
    .line 126
    const/4 v0, 0x1

    invoke-virtual {p1, v0}, Landroid/content/res/TypedArray;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v0

    return-object v0
.end method

.method static synthetic a(Lcom/jibo/ui/view/MaskLayout;)Landroid/graphics/drawable/Drawable;
    .locals 1

    .prologue
    .line 28
    iget-object v0, p0, Lcom/jibo/ui/view/MaskLayout;->b:Landroid/graphics/drawable/Drawable;

    return-object v0
.end method

.method private a()V
    .locals 2

    .prologue
    .line 213
    invoke-virtual {p0}, Lcom/jibo/ui/view/MaskLayout;->getViewTreeObserver()Landroid/view/ViewTreeObserver;

    move-result-object v0

    .line 214
    if-eqz v0, :cond_0

    invoke-virtual {v0}, Landroid/view/ViewTreeObserver;->isAlive()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 215
    new-instance v1, Lcom/jibo/ui/view/MaskLayout$1;

    invoke-direct {v1, p0, v0}, Lcom/jibo/ui/view/MaskLayout$1;-><init>(Lcom/jibo/ui/view/MaskLayout;Landroid/view/ViewTreeObserver;)V

    invoke-virtual {v0, v1}, Landroid/view/ViewTreeObserver;->addOnGlobalLayoutListener(Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;)V

    .line 235
    :cond_0
    return-void
.end method

.method private a(II)V
    .locals 1

    .prologue
    .line 188
    if-lez p1, :cond_1

    if-lez p2, :cond_1

    .line 189
    iget-object v0, p0, Lcom/jibo/ui/view/MaskLayout;->b:Landroid/graphics/drawable/Drawable;

    if-eqz v0, :cond_0

    .line 191
    iget-object v0, p0, Lcom/jibo/ui/view/MaskLayout;->b:Landroid/graphics/drawable/Drawable;

    invoke-direct {p0, v0}, Lcom/jibo/ui/view/MaskLayout;->b(Landroid/graphics/drawable/Drawable;)Landroid/graphics/Bitmap;

    move-result-object v0

    invoke-direct {p0, v0}, Lcom/jibo/ui/view/MaskLayout;->a(Landroid/graphics/Bitmap;)V

    .line 196
    :cond_0
    :goto_0
    return-void

    .line 194
    :cond_1
    const-string v0, "Width and height must be higher than 0"

    invoke-direct {p0, v0}, Lcom/jibo/ui/view/MaskLayout;->a(Ljava/lang/String;)V

    goto :goto_0
.end method

.method private a(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 4

    .prologue
    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 79
    new-instance v0, Landroid/os/Handler;

    invoke-direct {v0}, Landroid/os/Handler;-><init>()V

    iput-object v0, p0, Lcom/jibo/ui/view/MaskLayout;->a:Landroid/os/Handler;

    .line 80
    invoke-virtual {p0, v3}, Lcom/jibo/ui/view/MaskLayout;->setDrawingCacheEnabled(Z)V

    .line 81
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0xb

    if-lt v0, v1, :cond_0

    .line 82
    const/4 v0, 0x0

    invoke-virtual {p0, v3, v0}, Lcom/jibo/ui/view/MaskLayout;->setLayerType(ILandroid/graphics/Paint;)V

    .line 84
    :cond_0
    invoke-direct {p0, v2}, Lcom/jibo/ui/view/MaskLayout;->a(Z)Landroid/graphics/Paint;

    move-result-object v0

    iput-object v0, p0, Lcom/jibo/ui/view/MaskLayout;->e:Landroid/graphics/Paint;

    .line 85
    invoke-virtual {p1}, Landroid/content/Context;->getTheme()Landroid/content/res/Resources$Theme;

    move-result-object v0

    .line 86
    if-eqz v0, :cond_4

    .line 87
    sget-object v1, Lcom/jibo/R$styleable;->MaskLayout:[I

    invoke-virtual {v0, p2, v1, v2, v2}, Landroid/content/res/Resources$Theme;->obtainStyledAttributes(Landroid/util/AttributeSet;[III)Landroid/content/res/TypedArray;

    move-result-object v1

    .line 93
    :try_start_0
    invoke-direct {p0, v1}, Lcom/jibo/ui/view/MaskLayout;->a(Landroid/content/res/TypedArray;)Landroid/graphics/drawable/Drawable;

    move-result-object v0

    invoke-direct {p0, v0}, Lcom/jibo/ui/view/MaskLayout;->a(Landroid/graphics/drawable/Drawable;)V

    .line 95
    const/4 v0, 0x2

    const/4 v2, 0x0

    .line 96
    invoke-virtual {v1, v0, v2}, Landroid/content/res/TypedArray;->getInteger(II)I

    move-result v0

    .line 95
    invoke-direct {p0, v0}, Lcom/jibo/ui/view/MaskLayout;->a(I)Landroid/graphics/PorterDuffXfermode;

    move-result-object v0

    iput-object v0, p0, Lcom/jibo/ui/view/MaskLayout;->f:Landroid/graphics/PorterDuffXfermode;

    .line 97
    iget-object v0, p0, Lcom/jibo/ui/view/MaskLayout;->b:Landroid/graphics/drawable/Drawable;

    invoke-direct {p0, v0}, Lcom/jibo/ui/view/MaskLayout;->a(Landroid/graphics/drawable/Drawable;)V

    .line 99
    const/4 v0, 0x0

    const/4 v2, 0x0

    invoke-virtual {v1, v0, v2}, Landroid/content/res/TypedArray;->getBoolean(IZ)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 102
    const/4 v0, 0x1

    invoke-direct {p0, v0}, Lcom/jibo/ui/view/MaskLayout;->a(Z)Landroid/graphics/Paint;

    move-result-object v0

    iput-object v0, p0, Lcom/jibo/ui/view/MaskLayout;->e:Landroid/graphics/Paint;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 105
    :cond_1
    if-eqz v1, :cond_2

    .line 106
    invoke-virtual {v1}, Landroid/content/res/TypedArray;->recycle()V

    .line 112
    :cond_2
    :goto_0
    invoke-direct {p0}, Lcom/jibo/ui/view/MaskLayout;->a()V

    .line 113
    return-void

    .line 105
    :catchall_0
    move-exception v0

    if-eqz v1, :cond_3

    .line 106
    invoke-virtual {v1}, Landroid/content/res/TypedArray;->recycle()V

    :cond_3
    throw v0

    .line 110
    :cond_4
    const-string v0, "Couldn\'t load theme, mask in xml won\'t be loaded."

    invoke-direct {p0, v0}, Lcom/jibo/ui/view/MaskLayout;->a(Ljava/lang/String;)V

    goto :goto_0
.end method

.method private a(Landroid/graphics/Bitmap;)V
    .locals 1

    .prologue
    .line 267
    if-eqz p1, :cond_1

    .line 268
    iget-object v0, p0, Lcom/jibo/ui/view/MaskLayout;->c:Landroid/graphics/Bitmap;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/jibo/ui/view/MaskLayout;->c:Landroid/graphics/Bitmap;

    invoke-virtual {v0}, Landroid/graphics/Bitmap;->isRecycled()Z

    move-result v0

    if-nez v0, :cond_0

    .line 269
    iget-object v0, p0, Lcom/jibo/ui/view/MaskLayout;->c:Landroid/graphics/Bitmap;

    invoke-virtual {v0}, Landroid/graphics/Bitmap;->recycle()V

    .line 271
    :cond_0
    iput-object p1, p0, Lcom/jibo/ui/view/MaskLayout;->c:Landroid/graphics/Bitmap;

    .line 273
    :cond_1
    return-void
.end method

.method private a(Landroid/graphics/drawable/Drawable;)V
    .locals 1

    .prologue
    .line 130
    if-eqz p1, :cond_1

    .line 131
    iput-object p1, p0, Lcom/jibo/ui/view/MaskLayout;->b:Landroid/graphics/drawable/Drawable;

    .line 132
    iget-object v0, p0, Lcom/jibo/ui/view/MaskLayout;->b:Landroid/graphics/drawable/Drawable;

    instance-of v0, v0, Landroid/graphics/drawable/AnimationDrawable;

    if-eqz v0, :cond_0

    .line 133
    iget-object v0, p0, Lcom/jibo/ui/view/MaskLayout;->b:Landroid/graphics/drawable/Drawable;

    invoke-virtual {v0, p0}, Landroid/graphics/drawable/Drawable;->setCallback(Landroid/graphics/drawable/Drawable$Callback;)V

    .line 138
    :cond_0
    :goto_0
    return-void

    .line 136
    :cond_1
    const-string v0, "Are you sure you don\'t want to provide a mask ?"

    invoke-direct {p0, v0}, Lcom/jibo/ui/view/MaskLayout;->a(Ljava/lang/String;)V

    goto :goto_0
.end method

.method static synthetic a(Lcom/jibo/ui/view/MaskLayout;Landroid/graphics/Bitmap;)V
    .locals 0

    .prologue
    .line 28
    invoke-direct {p0, p1}, Lcom/jibo/ui/view/MaskLayout;->a(Landroid/graphics/Bitmap;)V

    return-void
.end method

.method static synthetic a(Lcom/jibo/ui/view/MaskLayout;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 28
    invoke-direct {p0, p1}, Lcom/jibo/ui/view/MaskLayout;->a(Ljava/lang/String;)V

    return-void
.end method

.method private a(Ljava/lang/String;)V
    .locals 1

    .prologue
    .line 239
    const-string v0, "MaskLayout"

    invoke-static {v0, p1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 240
    return-void
.end method

.method private b(Landroid/graphics/drawable/Drawable;)Landroid/graphics/Bitmap;
    .locals 5

    .prologue
    const/4 v0, 0x0

    const/4 v4, 0x0

    .line 147
    if-eqz p1, :cond_1

    .line 148
    invoke-virtual {p0}, Lcom/jibo/ui/view/MaskLayout;->getMeasuredWidth()I

    move-result v1

    if-lez v1, :cond_0

    invoke-virtual {p0}, Lcom/jibo/ui/view/MaskLayout;->getMeasuredHeight()I

    move-result v1

    if-lez v1, :cond_0

    .line 149
    invoke-virtual {p0}, Lcom/jibo/ui/view/MaskLayout;->getMeasuredWidth()I

    move-result v0

    invoke-virtual {p0}, Lcom/jibo/ui/view/MaskLayout;->getMeasuredHeight()I

    move-result v1

    sget-object v2, Landroid/graphics/Bitmap$Config;->ARGB_8888:Landroid/graphics/Bitmap$Config;

    invoke-static {v0, v1, v2}, Landroid/graphics/Bitmap;->createBitmap(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;

    move-result-object v0

    .line 151
    new-instance v1, Landroid/graphics/Canvas;

    invoke-direct {v1, v0}, Landroid/graphics/Canvas;-><init>(Landroid/graphics/Bitmap;)V

    .line 152
    invoke-virtual {p0}, Lcom/jibo/ui/view/MaskLayout;->getMeasuredWidth()I

    move-result v2

    invoke-virtual {p0}, Lcom/jibo/ui/view/MaskLayout;->getMeasuredHeight()I

    move-result v3

    invoke-virtual {p1, v4, v4, v2, v3}, Landroid/graphics/drawable/Drawable;->setBounds(IIII)V

    .line 153
    invoke-virtual {p1, v1}, Landroid/graphics/drawable/Drawable;->draw(Landroid/graphics/Canvas;)V

    .line 162
    :goto_0
    return-object v0

    .line 156
    :cond_0
    const-string v1, "Can\'t create a mask with height 0 or width 0. Or the layout has no children and is wrap content"

    invoke-direct {p0, v1}, Lcom/jibo/ui/view/MaskLayout;->a(Ljava/lang/String;)V

    goto :goto_0

    .line 160
    :cond_1
    const-string v1, "No bitmap mask loaded, view will NOT be masked !"

    invoke-direct {p0, v1}, Lcom/jibo/ui/view/MaskLayout;->a(Ljava/lang/String;)V

    goto :goto_0
.end method


# virtual methods
.method protected dispatchDraw(Landroid/graphics/Canvas;)V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 201
    invoke-super {p0, p1}, Landroid/widget/FrameLayout;->dispatchDraw(Landroid/graphics/Canvas;)V

    .line 202
    iget-object v0, p0, Lcom/jibo/ui/view/MaskLayout;->c:Landroid/graphics/Bitmap;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/jibo/ui/view/MaskLayout;->e:Landroid/graphics/Paint;

    if-eqz v0, :cond_0

    .line 203
    iget-object v0, p0, Lcom/jibo/ui/view/MaskLayout;->e:Landroid/graphics/Paint;

    iget-object v1, p0, Lcom/jibo/ui/view/MaskLayout;->f:Landroid/graphics/PorterDuffXfermode;

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setXfermode(Landroid/graphics/Xfermode;)Landroid/graphics/Xfermode;

    .line 204
    iget-object v0, p0, Lcom/jibo/ui/view/MaskLayout;->c:Landroid/graphics/Bitmap;

    iget-object v1, p0, Lcom/jibo/ui/view/MaskLayout;->e:Landroid/graphics/Paint;

    invoke-virtual {p1, v0, v2, v2, v1}, Landroid/graphics/Canvas;->drawBitmap(Landroid/graphics/Bitmap;FFLandroid/graphics/Paint;)V

    .line 205
    iget-object v0, p0, Lcom/jibo/ui/view/MaskLayout;->e:Landroid/graphics/Paint;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setXfermode(Landroid/graphics/Xfermode;)Landroid/graphics/Xfermode;

    .line 209
    :goto_0
    return-void

    .line 207
    :cond_0
    const-string v0, "Mask or paint is null ..."

    invoke-direct {p0, v0}, Lcom/jibo/ui/view/MaskLayout;->a(Ljava/lang/String;)V

    goto :goto_0
.end method

.method public getDrawableMask()Landroid/graphics/drawable/Drawable;
    .locals 1

    .prologue
    .line 142
    iget-object v0, p0, Lcom/jibo/ui/view/MaskLayout;->b:Landroid/graphics/drawable/Drawable;

    return-object v0
.end method

.method public invalidateDrawable(Landroid/graphics/drawable/Drawable;)V
    .locals 1

    .prologue
    .line 245
    if-eqz p1, :cond_0

    .line 246
    invoke-direct {p0, p1}, Lcom/jibo/ui/view/MaskLayout;->a(Landroid/graphics/drawable/Drawable;)V

    .line 247
    invoke-direct {p0, p1}, Lcom/jibo/ui/view/MaskLayout;->b(Landroid/graphics/drawable/Drawable;)Landroid/graphics/Bitmap;

    move-result-object v0

    invoke-direct {p0, v0}, Lcom/jibo/ui/view/MaskLayout;->a(Landroid/graphics/Bitmap;)V

    .line 248
    invoke-virtual {p0}, Lcom/jibo/ui/view/MaskLayout;->invalidate()V

    .line 250
    :cond_0
    return-void
.end method

.method protected onSizeChanged(IIII)V
    .locals 0

    .prologue
    .line 183
    invoke-super {p0, p1, p2, p3, p4}, Landroid/widget/FrameLayout;->onSizeChanged(IIII)V

    .line 184
    invoke-direct {p0, p1, p2}, Lcom/jibo/ui/view/MaskLayout;->a(II)V

    .line 185
    return-void
.end method

.method public scheduleDrawable(Landroid/graphics/drawable/Drawable;Ljava/lang/Runnable;J)V
    .locals 1

    .prologue
    .line 254
    if-eqz p1, :cond_0

    if-eqz p2, :cond_0

    .line 255
    iget-object v0, p0, Lcom/jibo/ui/view/MaskLayout;->a:Landroid/os/Handler;

    invoke-virtual {v0, p2, p3, p4}, Landroid/os/Handler;->postAtTime(Ljava/lang/Runnable;J)Z

    .line 257
    :cond_0
    return-void
.end method

.method public setMask(I)V
    .locals 1

    .prologue
    .line 166
    invoke-virtual {p0}, Lcom/jibo/ui/view/MaskLayout;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    .line 167
    if-eqz v0, :cond_0

    .line 168
    invoke-virtual {v0, p1}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/jibo/ui/view/MaskLayout;->setMask(Landroid/graphics/drawable/Drawable;)V

    .line 172
    :goto_0
    return-void

    .line 170
    :cond_0
    const-string v0, "Unable to load resources, mask will not be loaded as drawable"

    invoke-direct {p0, v0}, Lcom/jibo/ui/view/MaskLayout;->a(Ljava/lang/String;)V

    goto :goto_0
.end method

.method public setMask(Landroid/graphics/drawable/Drawable;)V
    .locals 1

    .prologue
    .line 175
    invoke-direct {p0, p1}, Lcom/jibo/ui/view/MaskLayout;->a(Landroid/graphics/drawable/Drawable;)V

    .line 176
    iget-object v0, p0, Lcom/jibo/ui/view/MaskLayout;->b:Landroid/graphics/drawable/Drawable;

    invoke-direct {p0, v0}, Lcom/jibo/ui/view/MaskLayout;->b(Landroid/graphics/drawable/Drawable;)Landroid/graphics/Bitmap;

    move-result-object v0

    invoke-direct {p0, v0}, Lcom/jibo/ui/view/MaskLayout;->a(Landroid/graphics/Bitmap;)V

    .line 177
    invoke-virtual {p0}, Lcom/jibo/ui/view/MaskLayout;->invalidate()V

    .line 178
    return-void
.end method

.method public unscheduleDrawable(Landroid/graphics/drawable/Drawable;Ljava/lang/Runnable;)V
    .locals 1

    .prologue
    .line 261
    if-eqz p1, :cond_0

    if-eqz p2, :cond_0

    .line 262
    iget-object v0, p0, Lcom/jibo/ui/view/MaskLayout;->a:Landroid/os/Handler;

    invoke-virtual {v0, p2}, Landroid/os/Handler;->removeCallbacks(Ljava/lang/Runnable;)V

    .line 264
    :cond_0
    return-void
.end method
