.class public Lcom/jibo/ui/view/MaterialDatePicker;
.super Landroid/widget/DatePicker;
.source "MaterialDatePicker.java"


# direct methods
.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 6

    .prologue
    const/4 v2, 0x0

    .line 27
    invoke-direct {p0, p1, p2}, Landroid/widget/DatePicker;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 31
    :try_start_0
    const-string v0, "com.android.internal.R$id"

    invoke-static {v0}, Ljava/lang/Class;->forName(Ljava/lang/String;)Ljava/lang/Class;
    :try_end_0
    .catch Ljava/lang/ClassNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    move-object v1, v0

    .line 37
    :goto_0
    :try_start_1
    const-string v0, "month"

    invoke-virtual {v1, v0}, Ljava/lang/Class;->getField(Ljava/lang/String;)Ljava/lang/reflect/Field;
    :try_end_1
    .catch Ljava/lang/NoSuchFieldException; {:try_start_1 .. :try_end_1} :catch_1

    move-result-object v0

    .line 43
    :goto_1
    const/4 v3, 0x0

    :try_start_2
    invoke-virtual {v0, v3}, Ljava/lang/reflect/Field;->getInt(Ljava/lang/Object;)I

    move-result v0

    invoke-virtual {p0, v0}, Lcom/jibo/ui/view/MaterialDatePicker;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/NumberPicker;
    :try_end_2
    .catch Ljava/lang/IllegalArgumentException; {:try_start_2 .. :try_end_2} :catch_2
    .catch Ljava/lang/IllegalAccessException; {:try_start_2 .. :try_end_2} :catch_3

    move-object v3, v0

    .line 50
    :goto_2
    :try_start_3
    const-string v0, "day"

    invoke-virtual {v1, v0}, Ljava/lang/Class;->getField(Ljava/lang/String;)Ljava/lang/reflect/Field;
    :try_end_3
    .catch Ljava/lang/NoSuchFieldException; {:try_start_3 .. :try_end_3} :catch_4

    move-result-object v0

    .line 56
    :goto_3
    const/4 v4, 0x0

    :try_start_4
    invoke-virtual {v0, v4}, Ljava/lang/reflect/Field;->getInt(Ljava/lang/Object;)I

    move-result v0

    invoke-virtual {p0, v0}, Lcom/jibo/ui/view/MaterialDatePicker;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/NumberPicker;
    :try_end_4
    .catch Ljava/lang/IllegalArgumentException; {:try_start_4 .. :try_end_4} :catch_5
    .catch Ljava/lang/IllegalAccessException; {:try_start_4 .. :try_end_4} :catch_6

    move-object v4, v0

    .line 63
    :goto_4
    :try_start_5
    const-string v0, "year"

    invoke-virtual {v1, v0}, Ljava/lang/Class;->getField(Ljava/lang/String;)Ljava/lang/reflect/Field;
    :try_end_5
    .catch Ljava/lang/NoSuchFieldException; {:try_start_5 .. :try_end_5} :catch_7

    move-result-object v0

    .line 69
    :goto_5
    const/4 v1, 0x0

    :try_start_6
    invoke-virtual {v0, v1}, Ljava/lang/reflect/Field;->getInt(Ljava/lang/Object;)I

    move-result v0

    invoke-virtual {p0, v0}, Lcom/jibo/ui/view/MaterialDatePicker;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/NumberPicker;
    :try_end_6
    .catch Ljava/lang/IllegalArgumentException; {:try_start_6 .. :try_end_6} :catch_8
    .catch Ljava/lang/IllegalAccessException; {:try_start_6 .. :try_end_6} :catch_9

    .line 76
    :goto_6
    :try_start_7
    const-string v1, "android.widget.NumberPicker"

    invoke-static {v1}, Ljava/lang/Class;->forName(Ljava/lang/String;)Ljava/lang/Class;
    :try_end_7
    .catch Ljava/lang/ClassNotFoundException; {:try_start_7 .. :try_end_7} :catch_a

    move-result-object v1

    .line 82
    :goto_7
    :try_start_8
    const-string v5, "mSelectionDivider"

    invoke-virtual {v1, v5}, Ljava/lang/Class;->getDeclaredField(Ljava/lang/String;)Ljava/lang/reflect/Field;
    :try_end_8
    .catch Ljava/lang/NoSuchFieldException; {:try_start_8 .. :try_end_8} :catch_e

    move-result-object v2

    .line 87
    :goto_8
    const/4 v1, 0x1

    :try_start_9
    invoke-virtual {v2, v1}, Ljava/lang/reflect/Field;->setAccessible(Z)V

    .line 88
    new-instance v1, Landroid/graphics/drawable/ColorDrawable;

    const/4 v5, 0x0

    invoke-direct {v1, v5}, Landroid/graphics/drawable/ColorDrawable;-><init>(I)V

    invoke-virtual {v2, v3, v1}, Ljava/lang/reflect/Field;->set(Ljava/lang/Object;Ljava/lang/Object;)V

    .line 89
    new-instance v1, Landroid/graphics/drawable/ColorDrawable;

    const/4 v5, 0x0

    invoke-direct {v1, v5}, Landroid/graphics/drawable/ColorDrawable;-><init>(I)V

    invoke-virtual {v2, v4, v1}, Ljava/lang/reflect/Field;->set(Ljava/lang/Object;Ljava/lang/Object;)V

    .line 90
    new-instance v1, Landroid/graphics/drawable/ColorDrawable;

    const/4 v5, 0x0

    invoke-direct {v1, v5}, Landroid/graphics/drawable/ColorDrawable;-><init>(I)V

    invoke-virtual {v2, v0, v1}, Ljava/lang/reflect/Field;->set(Ljava/lang/Object;Ljava/lang/Object;)V

    .line 92
    invoke-direct {p0, v4}, Lcom/jibo/ui/view/MaterialDatePicker;->a(Landroid/widget/NumberPicker;)V

    .line 93
    invoke-direct {p0, v3}, Lcom/jibo/ui/view/MaterialDatePicker;->a(Landroid/widget/NumberPicker;)V

    .line 94
    invoke-direct {p0, v0}, Lcom/jibo/ui/view/MaterialDatePicker;->a(Landroid/widget/NumberPicker;)V
    :try_end_9
    .catch Ljava/lang/IllegalArgumentException; {:try_start_9 .. :try_end_9} :catch_d
    .catch Landroid/content/res/Resources$NotFoundException; {:try_start_9 .. :try_end_9} :catch_c
    .catch Ljava/lang/IllegalAccessException; {:try_start_9 .. :try_end_9} :catch_b

    .line 99
    :goto_9
    return-void

    .line 32
    :catch_0
    move-exception v0

    move-object v1, v2

    goto :goto_0

    .line 38
    :catch_1
    move-exception v0

    move-object v0, v2

    goto :goto_1

    .line 44
    :catch_2
    move-exception v0

    move-object v3, v2

    .line 46
    goto :goto_2

    .line 45
    :catch_3
    move-exception v0

    move-object v3, v2

    goto :goto_2

    .line 51
    :catch_4
    move-exception v0

    move-object v0, v2

    goto :goto_3

    .line 57
    :catch_5
    move-exception v0

    move-object v4, v2

    .line 59
    goto :goto_4

    .line 58
    :catch_6
    move-exception v0

    move-object v4, v2

    goto :goto_4

    .line 64
    :catch_7
    move-exception v0

    move-object v0, v2

    goto :goto_5

    .line 70
    :catch_8
    move-exception v0

    move-object v0, v2

    .line 72
    goto :goto_6

    .line 71
    :catch_9
    move-exception v0

    move-object v0, v2

    goto :goto_6

    .line 77
    :catch_a
    move-exception v1

    move-object v1, v2

    goto :goto_7

    .line 97
    :catch_b
    move-exception v0

    goto :goto_9

    .line 96
    :catch_c
    move-exception v0

    goto :goto_9

    .line 95
    :catch_d
    move-exception v0

    goto :goto_9

    .line 83
    :catch_e
    move-exception v1

    goto :goto_8
.end method

.method private a(Landroid/content/Context;F)F
    .locals 1

    .prologue
    .line 129
    invoke-virtual {p1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v0

    iget v0, v0, Landroid/util/DisplayMetrics;->scaledDensity:F

    mul-float/2addr v0, p2

    return v0
.end method

.method private a(Landroid/widget/NumberPicker;)V
    .locals 5

    .prologue
    .line 102
    const/high16 v0, 0x60000

    invoke-virtual {p1, v0}, Landroid/widget/NumberPicker;->setDescendantFocusability(I)V

    .line 103
    const/4 v0, 0x0

    move v2, v0

    :goto_0
    invoke-virtual {p0}, Lcom/jibo/ui/view/MaterialDatePicker;->getChildCount()I

    move-result v0

    if-ge v2, v0, :cond_0

    .line 104
    invoke-virtual {p1, v2}, Landroid/widget/NumberPicker;->getChildAt(I)Landroid/view/View;

    move-result-object v1

    .line 105
    instance-of v0, v1, Landroid/widget/EditText;

    if-eqz v0, :cond_1

    .line 107
    :try_start_0
    const-class v0, Landroid/widget/NumberPicker;

    const-string v3, "mSelectorWheelPaint"

    invoke-virtual {v0, v3}, Ljava/lang/Class;->getDeclaredField(Ljava/lang/String;)Ljava/lang/reflect/Field;

    move-result-object v0

    .line 108
    const/4 v3, 0x1

    invoke-virtual {v0, v3}, Ljava/lang/reflect/Field;->setAccessible(Z)V

    .line 110
    invoke-virtual {v0, p1}, Ljava/lang/reflect/Field;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/graphics/Paint;

    .line 111
    invoke-virtual {p0}, Lcom/jibo/ui/view/MaterialDatePicker;->getContext()Landroid/content/Context;

    move-result-object v3

    const v4, 0x106000c

    invoke-static {v3, v4}, Lcom/jibo/utils/ImageUtils;->b(Landroid/content/Context;I)I

    move-result v3

    invoke-virtual {v0, v3}, Landroid/graphics/Paint;->setColor(I)V

    .line 112
    invoke-virtual {p0}, Lcom/jibo/ui/view/MaterialDatePicker;->getContext()Landroid/content/Context;

    move-result-object v3

    const/high16 v4, 0x41900000    # 18.0f

    invoke-direct {p0, v3, v4}, Lcom/jibo/ui/view/MaterialDatePicker;->a(Landroid/content/Context;F)F

    move-result v3

    invoke-virtual {v0, v3}, Landroid/graphics/Paint;->setTextSize(F)V

    .line 113
    sget-object v3, Lcom/jibo/ui/view/proxima/ProximaHelper;->a:Landroid/graphics/Typeface;

    invoke-virtual {v0, v3}, Landroid/graphics/Paint;->setTypeface(Landroid/graphics/Typeface;)Landroid/graphics/Typeface;

    .line 115
    check-cast v1, Landroid/widget/EditText;

    .line 116
    invoke-virtual {p0}, Lcom/jibo/ui/view/MaterialDatePicker;->getContext()Landroid/content/Context;

    move-result-object v3

    const v4, 0x106000c

    invoke-static {v3, v4}, Lcom/jibo/utils/ImageUtils;->b(Landroid/content/Context;I)I

    move-result v3

    invoke-virtual {v1, v3}, Landroid/widget/EditText;->setTextColor(I)V

    .line 117
    const/high16 v3, 0x41900000    # 18.0f

    invoke-virtual {v1, v3}, Landroid/widget/EditText;->setTextSize(F)V

    .line 118
    sget-object v1, Lcom/jibo/ui/view/proxima/ProximaHelper;->a:Landroid/graphics/Typeface;

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setTypeface(Landroid/graphics/Typeface;)Landroid/graphics/Typeface;

    .line 120
    invoke-virtual {p1}, Landroid/widget/NumberPicker;->invalidate()V
    :try_end_0
    .catch Ljava/lang/NoSuchFieldException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/IllegalAccessException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Ljava/lang/IllegalArgumentException; {:try_start_0 .. :try_end_0} :catch_2

    .line 126
    :cond_0
    return-void

    .line 122
    :catch_0
    move-exception v0

    .line 103
    :cond_1
    :goto_1
    add-int/lit8 v0, v2, 0x1

    move v2, v0

    goto :goto_0

    .line 122
    :catch_1
    move-exception v0

    goto :goto_1

    :catch_2
    move-exception v0

    goto :goto_1
.end method
