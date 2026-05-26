.class public Lcom/jibo/ui/view/MaterialNumberPicker;
.super Landroid/widget/NumberPicker;
.source "MaterialNumberPicker.java"


# instance fields
.field private a:I

.field private b:F


# direct methods
.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 4

    .prologue
    .line 34
    invoke-direct {p0, p1, p2}, Landroid/widget/NumberPicker;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 35
    invoke-direct {p0}, Lcom/jibo/ui/view/MaterialNumberPicker;->a()V

    .line 37
    sget-object v0, Lcom/jibo/R$styleable;->MaterialNumberPicker:[I

    invoke-virtual {p1, p2, v0}, Landroid/content/Context;->obtainStyledAttributes(Landroid/util/AttributeSet;[I)Landroid/content/res/TypedArray;

    move-result-object v1

    .line 39
    const/4 v0, 0x0

    :goto_0
    invoke-virtual {v1}, Landroid/content/res/TypedArray;->getIndexCount()I

    move-result v2

    if-ge v0, v2, :cond_2

    .line 41
    invoke-virtual {v1, v0}, Landroid/content/res/TypedArray;->getIndex(I)I

    move-result v2

    .line 42
    const/4 v3, 0x1

    if-ne v2, v3, :cond_1

    .line 43
    const/high16 v3, 0x41900000    # 18.0f

    invoke-virtual {v1, v2, v3}, Landroid/content/res/TypedArray;->getDimension(IF)F

    move-result v2

    invoke-virtual {p0, v2}, Lcom/jibo/ui/view/MaterialNumberPicker;->setTextSize(F)V

    .line 39
    :cond_0
    :goto_1
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 44
    :cond_1
    if-nez v2, :cond_0

    .line 45
    const v3, 0x7f06001f

    invoke-virtual {p1, v3}, Landroid/content/Context;->getColor(I)I

    move-result v3

    invoke-virtual {v1, v2, v3}, Landroid/content/res/TypedArray;->getColor(II)I

    move-result v2

    invoke-virtual {p0, v2}, Lcom/jibo/ui/view/MaterialNumberPicker;->setTextColor(I)V

    goto :goto_1

    .line 49
    :cond_2
    invoke-virtual {v1}, Landroid/content/res/TypedArray;->recycle()V

    .line 50
    return-void
.end method

.method private a(Landroid/content/Context;F)F
    .locals 1

    .prologue
    .line 145
    invoke-virtual {p1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v0

    iget v0, v0, Landroid/util/DisplayMetrics;->scaledDensity:F

    mul-float/2addr v0, p2

    return v0
.end method

.method private a()V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 60
    invoke-virtual {p0, v2}, Lcom/jibo/ui/view/MaterialNumberPicker;->setSeparatorColor(I)V

    .line 61
    invoke-virtual {p0}, Lcom/jibo/ui/view/MaterialNumberPicker;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v1, 0x7f06001f

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getColor(I)I

    move-result v0

    invoke-virtual {p0, v0}, Lcom/jibo/ui/view/MaterialNumberPicker;->setTextColor(I)V

    .line 62
    const/high16 v0, 0x41900000    # 18.0f

    invoke-virtual {p0, v0}, Lcom/jibo/ui/view/MaterialNumberPicker;->setTextSize(F)V

    .line 63
    invoke-virtual {p0, v2}, Lcom/jibo/ui/view/MaterialNumberPicker;->setWrapSelectorWheel(Z)V

    .line 64
    invoke-direct {p0, v2}, Lcom/jibo/ui/view/MaterialNumberPicker;->setFocusability(Z)V

    .line 67
    :try_start_0
    const-class v0, Landroid/widget/NumberPicker;

    const-string v1, "mInputText"

    invoke-virtual {v0, v1}, Ljava/lang/Class;->getDeclaredField(Ljava/lang/String;)Ljava/lang/reflect/Field;

    move-result-object v0

    .line 68
    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Ljava/lang/reflect/Field;->setAccessible(Z)V

    .line 69
    invoke-virtual {v0, p0}, Ljava/lang/reflect/Field;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/EditText;

    .line 70
    iget v1, p0, Lcom/jibo/ui/view/MaterialNumberPicker;->a:I

    invoke-virtual {v0, v1}, Landroid/widget/EditText;->setTextColor(I)V

    .line 71
    iget v1, p0, Lcom/jibo/ui/view/MaterialNumberPicker;->b:F

    invoke-virtual {v0, v1}, Landroid/widget/EditText;->setTextSize(F)V

    .line 72
    const/4 v1, 0x0

    new-array v1, v1, [Landroid/text/InputFilter;

    invoke-virtual {v0, v1}, Landroid/widget/EditText;->setFilters([Landroid/text/InputFilter;)V
    :try_end_0
    .catch Ljava/lang/NoSuchFieldException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/IllegalAccessException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Ljava/lang/IllegalArgumentException; {:try_start_0 .. :try_end_0} :catch_2

    .line 75
    :goto_0
    return-void

    .line 73
    :catch_0
    move-exception v0

    goto :goto_0

    :catch_1
    move-exception v0

    goto :goto_0

    :catch_2
    move-exception v0

    goto :goto_0
.end method

.method private b()V
    .locals 6

    .prologue
    .line 113
    const/4 v1, 0x0

    move v3, v1

    :goto_0
    invoke-virtual {p0}, Lcom/jibo/ui/view/MaterialNumberPicker;->getChildCount()I

    move-result v1

    if-ge v3, v1, :cond_0

    .line 114
    invoke-virtual {p0, v3}, Lcom/jibo/ui/view/MaterialNumberPicker;->getChildAt(I)Landroid/view/View;

    move-result-object v2

    .line 115
    instance-of v1, v2, Landroid/widget/EditText;

    if-eqz v1, :cond_1

    .line 117
    :try_start_0
    const-class v1, Landroid/widget/NumberPicker;

    const-string v4, "mSelectorWheelPaint"

    invoke-virtual {v1, v4}, Ljava/lang/Class;->getDeclaredField(Ljava/lang/String;)Ljava/lang/reflect/Field;

    move-result-object v1

    .line 118
    const/4 v4, 0x1

    invoke-virtual {v1, v4}, Ljava/lang/reflect/Field;->setAccessible(Z)V

    .line 120
    invoke-virtual {v1, p0}, Ljava/lang/reflect/Field;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/graphics/Paint;

    .line 121
    iget v4, p0, Lcom/jibo/ui/view/MaterialNumberPicker;->a:I

    invoke-virtual {v1, v4}, Landroid/graphics/Paint;->setColor(I)V

    .line 122
    invoke-virtual {p0}, Lcom/jibo/ui/view/MaterialNumberPicker;->getContext()Landroid/content/Context;

    move-result-object v4

    iget v5, p0, Lcom/jibo/ui/view/MaterialNumberPicker;->b:F

    invoke-direct {p0, v4, v5}, Lcom/jibo/ui/view/MaterialNumberPicker;->a(Landroid/content/Context;F)F

    move-result v4

    invoke-virtual {v1, v4}, Landroid/graphics/Paint;->setTextSize(F)V

    .line 124
    move-object v0, v2

    check-cast v0, Landroid/widget/EditText;

    move-object v1, v0

    .line 125
    iget v2, p0, Lcom/jibo/ui/view/MaterialNumberPicker;->a:I

    invoke-virtual {v1, v2}, Landroid/widget/EditText;->setTextColor(I)V

    .line 126
    iget v2, p0, Lcom/jibo/ui/view/MaterialNumberPicker;->b:F

    invoke-virtual {v1, v2}, Landroid/widget/EditText;->setTextSize(F)V

    .line 128
    invoke-virtual {p0}, Lcom/jibo/ui/view/MaterialNumberPicker;->invalidate()V
    :try_end_0
    .catch Ljava/lang/NoSuchFieldException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/IllegalAccessException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Ljava/lang/IllegalArgumentException; {:try_start_0 .. :try_end_0} :catch_2

    .line 134
    :cond_0
    return-void

    .line 130
    :catch_0
    move-exception v1

    .line 113
    :cond_1
    :goto_1
    add-int/lit8 v1, v3, 0x1

    move v3, v1

    goto :goto_0

    .line 130
    :catch_1
    move-exception v1

    goto :goto_1

    :catch_2
    move-exception v1

    goto :goto_1
.end method

.method private setFocusability(Z)V
    .locals 1

    .prologue
    .line 137
    if-eqz p1, :cond_0

    const/high16 v0, 0x40000

    :goto_0
    invoke-virtual {p0, v0}, Lcom/jibo/ui/view/MaterialNumberPicker;->setDescendantFocusability(I)V

    .line 138
    return-void

    .line 137
    :cond_0
    const/high16 v0, 0x60000

    goto :goto_0
.end method


# virtual methods
.method public setSeparatorColor(I)V
    .locals 6

    .prologue
    .line 83
    const-class v0, Landroid/widget/NumberPicker;

    invoke-virtual {v0}, Ljava/lang/Class;->getDeclaredFields()[Ljava/lang/reflect/Field;

    move-result-object v1

    .line 84
    array-length v2, v1

    const/4 v0, 0x0

    :goto_0
    if-ge v0, v2, :cond_0

    aget-object v3, v1, v0

    .line 85
    invoke-virtual {v3}, Ljava/lang/reflect/Field;->getName()Ljava/lang/String;

    move-result-object v4

    const-string v5, "mSelectionDivider"

    invoke-virtual {v4, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_1

    .line 86
    const/4 v0, 0x1

    invoke-virtual {v3, v0}, Ljava/lang/reflect/Field;->setAccessible(Z)V

    .line 88
    :try_start_0
    new-instance v0, Landroid/graphics/drawable/ColorDrawable;

    invoke-direct {v0, p1}, Landroid/graphics/drawable/ColorDrawable;-><init>(I)V

    invoke-virtual {v3, p0, v0}, Ljava/lang/reflect/Field;->set(Ljava/lang/Object;Ljava/lang/Object;)V
    :try_end_0
    .catch Ljava/lang/IllegalAccessException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/IllegalArgumentException; {:try_start_0 .. :try_end_0} :catch_1

    .line 94
    :cond_0
    :goto_1
    return-void

    .line 84
    :cond_1
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 89
    :catch_0
    move-exception v0

    goto :goto_1

    :catch_1
    move-exception v0

    goto :goto_1
.end method

.method public setTextColor(I)V
    .locals 0

    .prologue
    .line 100
    iput p1, p0, Lcom/jibo/ui/view/MaterialNumberPicker;->a:I

    .line 101
    invoke-direct {p0}, Lcom/jibo/ui/view/MaterialNumberPicker;->b()V

    .line 102
    return-void
.end method

.method public setTextSize(F)V
    .locals 0

    .prologue
    .line 108
    iput p1, p0, Lcom/jibo/ui/view/MaterialNumberPicker;->b:F

    .line 109
    invoke-direct {p0}, Lcom/jibo/ui/view/MaterialNumberPicker;->b()V

    .line 110
    return-void
.end method
