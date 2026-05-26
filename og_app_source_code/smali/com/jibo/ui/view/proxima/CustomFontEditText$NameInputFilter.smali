.class public Lcom/jibo/ui/view/proxima/CustomFontEditText$NameInputFilter;
.super Ljava/lang/Object;
.source "CustomFontEditText.java"

# interfaces
.implements Landroid/text/InputFilter;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/ui/view/proxima/CustomFontEditText;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "NameInputFilter"
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 40
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method private a(C)Z
    .locals 1

    .prologue
    .line 43
    const/16 v0, 0x41

    if-lt p1, v0, :cond_0

    const/16 v0, 0x5a

    if-le p1, v0, :cond_1

    :cond_0
    const/16 v0, 0x61

    if-lt p1, v0, :cond_2

    const/16 v0, 0x7a

    if-gt p1, v0, :cond_2

    :cond_1
    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_2
    const/4 v0, 0x0

    goto :goto_0
.end method


# virtual methods
.method public filter(Ljava/lang/CharSequence;IILandroid/text/Spanned;II)Ljava/lang/CharSequence;
    .locals 6

    .prologue
    const/16 v5, 0x2d

    const/16 v4, 0x27

    .line 49
    instance-of v0, p1, Landroid/text/SpannableStringBuilder;

    if-eqz v0, :cond_1

    move-object v0, p1

    .line 50
    check-cast v0, Landroid/text/SpannableStringBuilder;

    .line 51
    add-int/lit8 v1, p3, -0x1

    :goto_0
    if-lt v1, p2, :cond_5

    .line 52
    invoke-interface {p1, v1}, Ljava/lang/CharSequence;->charAt(I)C

    move-result v2

    .line 53
    invoke-direct {p0, v2}, Lcom/jibo/ui/view/proxima/CustomFontEditText$NameInputFilter;->a(C)Z

    move-result v3

    if-nez v3, :cond_0

    invoke-static {v2}, Ljava/lang/Character;->isSpaceChar(C)Z

    move-result v3

    if-nez v3, :cond_0

    if-eq v2, v5, :cond_0

    if-eq v2, v4, :cond_0

    .line 54
    add-int/lit8 v2, v1, 0x1

    invoke-virtual {v0, v1, v2}, Landroid/text/SpannableStringBuilder;->delete(II)Landroid/text/SpannableStringBuilder;

    .line 51
    :cond_0
    add-int/lit8 v1, v1, -0x1

    goto :goto_0

    .line 59
    :cond_1
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    .line 60
    :goto_1
    if-ge p2, p3, :cond_4

    .line 61
    invoke-interface {p1, p2}, Ljava/lang/CharSequence;->charAt(I)C

    move-result v1

    .line 62
    invoke-direct {p0, v1}, Lcom/jibo/ui/view/proxima/CustomFontEditText$NameInputFilter;->a(C)Z

    move-result v2

    if-nez v2, :cond_2

    invoke-static {v1}, Ljava/lang/Character;->isSpaceChar(C)Z

    move-result v2

    if-nez v2, :cond_2

    if-eq v1, v5, :cond_2

    if-ne v1, v4, :cond_3

    .line 63
    :cond_2
    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 60
    :cond_3
    add-int/lit8 p2, p2, 0x1

    goto :goto_1

    .line 66
    :cond_4
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    :cond_5
    return-object p1
.end method
