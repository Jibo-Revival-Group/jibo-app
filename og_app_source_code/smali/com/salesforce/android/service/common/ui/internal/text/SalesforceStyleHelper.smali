.class public Lcom/salesforce/android/service/common/ui/internal/text/SalesforceStyleHelper;
.super Ljava/lang/Object;
.source "SalesforceStyleHelper.java"


# instance fields
.field private final a:Landroid/content/Context;

.field private final b:Landroid/util/AttributeSet;

.field private final c:Landroid/graphics/Typeface;

.field private d:Landroid/text/style/StyleSpan;


# direct methods
.method constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 1

    .prologue
    .line 74
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 75
    iput-object p1, p0, Lcom/salesforce/android/service/common/ui/internal/text/SalesforceStyleHelper;->a:Landroid/content/Context;

    .line 76
    iput-object p2, p0, Lcom/salesforce/android/service/common/ui/internal/text/SalesforceStyleHelper;->b:Landroid/util/AttributeSet;

    .line 77
    invoke-virtual {p0}, Lcom/salesforce/android/service/common/ui/internal/text/SalesforceStyleHelper;->a()Landroid/graphics/Typeface;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/service/common/ui/internal/text/SalesforceStyleHelper;->c:Landroid/graphics/Typeface;

    .line 78
    return-void
.end method

.method public static a(Landroid/content/Context;Landroid/util/AttributeSet;)Lcom/salesforce/android/service/common/ui/internal/text/SalesforceStyleHelper;
    .locals 1

    .prologue
    .line 67
    new-instance v0, Lcom/salesforce/android/service/common/ui/internal/text/SalesforceStyleHelper;

    invoke-direct {v0, p0, p1}, Lcom/salesforce/android/service/common/ui/internal/text/SalesforceStyleHelper;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    return-object v0
.end method


# virtual methods
.method a(Landroid/content/res/TypedArray;I)I
    .locals 1

    .prologue
    .line 155
    const/4 v0, 0x0

    invoke-virtual {p1, p2, v0}, Landroid/content/res/TypedArray;->getInt(II)I

    move-result v0

    return v0
.end method

.method a()Landroid/graphics/Typeface;
    .locals 5

    .prologue
    .line 81
    invoke-virtual {p0}, Lcom/salesforce/android/service/common/ui/internal/text/SalesforceStyleHelper;->c()Landroid/content/res/TypedArray;

    move-result-object v1

    .line 82
    invoke-virtual {p0}, Lcom/salesforce/android/service/common/ui/internal/text/SalesforceStyleHelper;->d()Landroid/content/res/TypedArray;

    move-result-object v2

    .line 85
    :try_start_0
    invoke-virtual {p0, v1}, Lcom/salesforce/android/service/common/ui/internal/text/SalesforceStyleHelper;->a(Landroid/content/res/TypedArray;)Landroid/graphics/Typeface;

    move-result-object v0

    .line 86
    new-instance v3, Landroid/text/style/StyleSpan;

    invoke-virtual {p0}, Lcom/salesforce/android/service/common/ui/internal/text/SalesforceStyleHelper;->e()I

    move-result v4

    invoke-virtual {p0, v2, v4}, Lcom/salesforce/android/service/common/ui/internal/text/SalesforceStyleHelper;->a(Landroid/content/res/TypedArray;I)I

    move-result v4

    invoke-direct {v3, v4}, Landroid/text/style/StyleSpan;-><init>(I)V

    iput-object v3, p0, Lcom/salesforce/android/service/common/ui/internal/text/SalesforceStyleHelper;->d:Landroid/text/style/StyleSpan;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 91
    invoke-virtual {v1}, Landroid/content/res/TypedArray;->recycle()V

    .line 92
    invoke-virtual {v2}, Landroid/content/res/TypedArray;->recycle()V

    .line 88
    return-object v0

    .line 91
    :catchall_0
    move-exception v0

    invoke-virtual {v1}, Landroid/content/res/TypedArray;->recycle()V

    .line 92
    invoke-virtual {v2}, Landroid/content/res/TypedArray;->recycle()V

    throw v0
.end method

.method a(Landroid/content/res/TypedArray;)Landroid/graphics/Typeface;
    .locals 2

    .prologue
    .line 119
    sget v0, Lcom/salesforce/android/service/common/ui/R$styleable;->SalesforceTextView_salesforceFont:I

    invoke-virtual {p1, v0}, Landroid/content/res/TypedArray;->getString(I)Ljava/lang/String;

    move-result-object v0

    .line 120
    if-eqz v0, :cond_0

    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v1

    if-eqz v1, :cond_1

    .line 121
    :cond_0
    const/4 v0, 0x0

    .line 124
    :goto_0
    return-object v0

    :cond_1
    iget-object v1, p0, Lcom/salesforce/android/service/common/ui/internal/text/SalesforceStyleHelper;->a:Landroid/content/Context;

    invoke-virtual {v1}, Landroid/content/Context;->getAssets()Landroid/content/res/AssetManager;

    move-result-object v1

    invoke-static {v1, v0}, Lcom/salesforce/android/service/common/ui/internal/text/TypefaceFactory;->a(Landroid/content/res/AssetManager;Ljava/lang/String;)Landroid/graphics/Typeface;

    move-result-object v0

    goto :goto_0
.end method

.method public a(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;
    .locals 3

    .prologue
    .line 128
    iget-object v0, p0, Lcom/salesforce/android/service/common/ui/internal/text/SalesforceStyleHelper;->d:Landroid/text/style/StyleSpan;

    if-eqz v0, :cond_0

    if-eqz p1, :cond_0

    invoke-interface {p1}, Ljava/lang/CharSequence;->length()I

    move-result v0

    const/4 v1, 0x1

    if-ge v0, v1, :cond_1

    :cond_0
    move-object v1, p1

    .line 137
    :goto_0
    return-object v1

    .line 132
    :cond_1
    instance-of v0, p1, Landroid/text/Spannable;

    if-nez v0, :cond_2

    .line 133
    new-instance v1, Lcom/salesforce/android/service/common/ui/internal/text/SpannableString;

    invoke-direct {v1, p1}, Lcom/salesforce/android/service/common/ui/internal/text/SpannableString;-><init>(Ljava/lang/CharSequence;)V

    :goto_1
    move-object v0, v1

    .line 136
    check-cast v0, Landroid/text/Spannable;

    iget-object v2, p0, Lcom/salesforce/android/service/common/ui/internal/text/SalesforceStyleHelper;->d:Landroid/text/style/StyleSpan;

    invoke-virtual {p0, v0, v2}, Lcom/salesforce/android/service/common/ui/internal/text/SalesforceStyleHelper;->a(Landroid/text/Spannable;Landroid/text/style/StyleSpan;)V

    goto :goto_0

    :cond_2
    move-object v1, p1

    goto :goto_1
.end method

.method a(Landroid/text/Spannable;Landroid/text/style/StyleSpan;)V
    .locals 3

    .prologue
    .line 163
    const/4 v0, 0x0

    invoke-interface {p1}, Landroid/text/Spannable;->length()I

    move-result v1

    const/16 v2, 0x21

    invoke-interface {p1, p2, v0, v1, v2}, Landroid/text/Spannable;->setSpan(Ljava/lang/Object;III)V

    .line 164
    return-void
.end method

.method public b()Landroid/graphics/Typeface;
    .locals 1

    .prologue
    .line 102
    iget-object v0, p0, Lcom/salesforce/android/service/common/ui/internal/text/SalesforceStyleHelper;->c:Landroid/graphics/Typeface;

    return-object v0
.end method

.method c()Landroid/content/res/TypedArray;
    .locals 5

    .prologue
    .line 110
    iget-object v0, p0, Lcom/salesforce/android/service/common/ui/internal/text/SalesforceStyleHelper;->a:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getTheme()Landroid/content/res/Resources$Theme;

    move-result-object v0

    iget-object v1, p0, Lcom/salesforce/android/service/common/ui/internal/text/SalesforceStyleHelper;->b:Landroid/util/AttributeSet;

    sget-object v2, Lcom/salesforce/android/service/common/ui/R$styleable;->SalesforceTextView:[I

    sget v3, Lcom/salesforce/android/service/common/ui/R$attr;->salesforceFontStyle:I

    const/4 v4, 0x0

    invoke-virtual {v0, v1, v2, v3, v4}, Landroid/content/res/Resources$Theme;->obtainStyledAttributes(Landroid/util/AttributeSet;[III)Landroid/content/res/TypedArray;

    move-result-object v0

    return-object v0
.end method

.method d()Landroid/content/res/TypedArray;
    .locals 5

    .prologue
    .line 145
    iget-object v0, p0, Lcom/salesforce/android/service/common/ui/internal/text/SalesforceStyleHelper;->a:Landroid/content/Context;

    iget-object v1, p0, Lcom/salesforce/android/service/common/ui/internal/text/SalesforceStyleHelper;->b:Landroid/util/AttributeSet;

    const/4 v2, 0x1

    new-array v2, v2, [I

    const/4 v3, 0x0

    const v4, 0x1010097

    aput v4, v2, v3

    invoke-virtual {v0, v1, v2}, Landroid/content/Context;->obtainStyledAttributes(Landroid/util/AttributeSet;[I)Landroid/content/res/TypedArray;

    move-result-object v0

    return-object v0
.end method

.method e()I
    .locals 4

    .prologue
    .line 149
    new-instance v0, Landroid/util/TypedValue;

    invoke-direct {v0}, Landroid/util/TypedValue;-><init>()V

    .line 150
    iget-object v1, p0, Lcom/salesforce/android/service/common/ui/internal/text/SalesforceStyleHelper;->a:Landroid/content/Context;

    invoke-virtual {v1}, Landroid/content/Context;->getTheme()Landroid/content/res/Resources$Theme;

    move-result-object v1

    const v2, 0x1010097

    const/4 v3, 0x1

    invoke-virtual {v1, v2, v0, v3}, Landroid/content/res/Resources$Theme;->resolveAttribute(ILandroid/util/TypedValue;Z)Z

    .line 151
    iget v0, v0, Landroid/util/TypedValue;->data:I

    return v0
.end method
