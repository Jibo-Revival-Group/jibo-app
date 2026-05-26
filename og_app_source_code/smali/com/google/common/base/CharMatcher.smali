.class public abstract Lcom/google/common/base/CharMatcher;
.super Ljava/lang/Object;
.source "CharMatcher.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/google/common/base/CharMatcher$Is;,
        Lcom/google/common/base/CharMatcher$SingleWidth;,
        Lcom/google/common/base/CharMatcher$Invisible;,
        Lcom/google/common/base/CharMatcher$JavaIsoControl;,
        Lcom/google/common/base/CharMatcher$JavaLowerCase;,
        Lcom/google/common/base/CharMatcher$JavaUpperCase;,
        Lcom/google/common/base/CharMatcher$JavaLetterOrDigit;,
        Lcom/google/common/base/CharMatcher$JavaLetter;,
        Lcom/google/common/base/CharMatcher$JavaDigit;,
        Lcom/google/common/base/CharMatcher$Digit;,
        Lcom/google/common/base/CharMatcher$RangesMatcher;,
        Lcom/google/common/base/CharMatcher$Ascii;,
        Lcom/google/common/base/CharMatcher$BreakingWhitespace;,
        Lcom/google/common/base/CharMatcher$Whitespace;,
        Lcom/google/common/base/CharMatcher$None;,
        Lcom/google/common/base/CharMatcher$Any;,
        Lcom/google/common/base/CharMatcher$NamedFastMatcher;,
        Lcom/google/common/base/CharMatcher$FastMatcher;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;"
    }
.end annotation


# static fields
.field public static final a:Lcom/google/common/base/CharMatcher;
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation
.end field

.field public static final b:Lcom/google/common/base/CharMatcher;
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation
.end field

.field public static final c:Lcom/google/common/base/CharMatcher;
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation
.end field

.field public static final d:Lcom/google/common/base/CharMatcher;
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation
.end field

.field public static final e:Lcom/google/common/base/CharMatcher;
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation
.end field

.field public static final f:Lcom/google/common/base/CharMatcher;
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation
.end field

.field public static final g:Lcom/google/common/base/CharMatcher;
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation
.end field

.field public static final h:Lcom/google/common/base/CharMatcher;
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation
.end field

.field public static final i:Lcom/google/common/base/CharMatcher;
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation
.end field

.field public static final j:Lcom/google/common/base/CharMatcher;
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation
.end field

.field public static final k:Lcom/google/common/base/CharMatcher;
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation
.end field

.field public static final l:Lcom/google/common/base/CharMatcher;
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation
.end field

.field public static final m:Lcom/google/common/base/CharMatcher;
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation
.end field

.field public static final n:Lcom/google/common/base/CharMatcher;
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 272
    invoke-static {}, Lcom/google/common/base/CharMatcher;->c()Lcom/google/common/base/CharMatcher;

    move-result-object v0

    sput-object v0, Lcom/google/common/base/CharMatcher;->a:Lcom/google/common/base/CharMatcher;

    .line 284
    invoke-static {}, Lcom/google/common/base/CharMatcher;->d()Lcom/google/common/base/CharMatcher;

    move-result-object v0

    sput-object v0, Lcom/google/common/base/CharMatcher;->b:Lcom/google/common/base/CharMatcher;

    .line 294
    invoke-static {}, Lcom/google/common/base/CharMatcher;->e()Lcom/google/common/base/CharMatcher;

    move-result-object v0

    sput-object v0, Lcom/google/common/base/CharMatcher;->c:Lcom/google/common/base/CharMatcher;

    .line 306
    invoke-static {}, Lcom/google/common/base/CharMatcher;->f()Lcom/google/common/base/CharMatcher;

    move-result-object v0

    sput-object v0, Lcom/google/common/base/CharMatcher;->d:Lcom/google/common/base/CharMatcher;

    .line 317
    invoke-static {}, Lcom/google/common/base/CharMatcher;->g()Lcom/google/common/base/CharMatcher;

    move-result-object v0

    sput-object v0, Lcom/google/common/base/CharMatcher;->e:Lcom/google/common/base/CharMatcher;

    .line 329
    invoke-static {}, Lcom/google/common/base/CharMatcher;->h()Lcom/google/common/base/CharMatcher;

    move-result-object v0

    sput-object v0, Lcom/google/common/base/CharMatcher;->f:Lcom/google/common/base/CharMatcher;

    .line 339
    invoke-static {}, Lcom/google/common/base/CharMatcher;->i()Lcom/google/common/base/CharMatcher;

    move-result-object v0

    sput-object v0, Lcom/google/common/base/CharMatcher;->g:Lcom/google/common/base/CharMatcher;

    .line 349
    invoke-static {}, Lcom/google/common/base/CharMatcher;->j()Lcom/google/common/base/CharMatcher;

    move-result-object v0

    sput-object v0, Lcom/google/common/base/CharMatcher;->h:Lcom/google/common/base/CharMatcher;

    .line 359
    invoke-static {}, Lcom/google/common/base/CharMatcher;->k()Lcom/google/common/base/CharMatcher;

    move-result-object v0

    sput-object v0, Lcom/google/common/base/CharMatcher;->i:Lcom/google/common/base/CharMatcher;

    .line 369
    invoke-static {}, Lcom/google/common/base/CharMatcher;->l()Lcom/google/common/base/CharMatcher;

    move-result-object v0

    sput-object v0, Lcom/google/common/base/CharMatcher;->j:Lcom/google/common/base/CharMatcher;

    .line 380
    invoke-static {}, Lcom/google/common/base/CharMatcher;->m()Lcom/google/common/base/CharMatcher;

    move-result-object v0

    sput-object v0, Lcom/google/common/base/CharMatcher;->k:Lcom/google/common/base/CharMatcher;

    .line 394
    invoke-static {}, Lcom/google/common/base/CharMatcher;->n()Lcom/google/common/base/CharMatcher;

    move-result-object v0

    sput-object v0, Lcom/google/common/base/CharMatcher;->l:Lcom/google/common/base/CharMatcher;

    .line 403
    invoke-static {}, Lcom/google/common/base/CharMatcher;->a()Lcom/google/common/base/CharMatcher;

    move-result-object v0

    sput-object v0, Lcom/google/common/base/CharMatcher;->m:Lcom/google/common/base/CharMatcher;

    .line 412
    invoke-static {}, Lcom/google/common/base/CharMatcher;->b()Lcom/google/common/base/CharMatcher;

    move-result-object v0

    sput-object v0, Lcom/google/common/base/CharMatcher;->n:Lcom/google/common/base/CharMatcher;

    return-void
.end method

.method protected constructor <init>()V
    .locals 0

    .prologue
    .line 484
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static a()Lcom/google/common/base/CharMatcher;
    .locals 1

    .prologue
    .line 108
    sget-object v0, Lcom/google/common/base/CharMatcher$Any;->o:Lcom/google/common/base/CharMatcher$Any;

    return-object v0
.end method

.method public static a(C)Lcom/google/common/base/CharMatcher;
    .locals 1

    .prologue
    .line 420
    new-instance v0, Lcom/google/common/base/CharMatcher$Is;

    invoke-direct {v0, p0}, Lcom/google/common/base/CharMatcher$Is;-><init>(C)V

    return-object v0
.end method

.method public static b()Lcom/google/common/base/CharMatcher;
    .locals 1

    .prologue
    .line 117
    sget-object v0, Lcom/google/common/base/CharMatcher$None;->o:Lcom/google/common/base/CharMatcher$None;

    return-object v0
.end method

.method public static c()Lcom/google/common/base/CharMatcher;
    .locals 1

    .prologue
    .line 134
    sget-object v0, Lcom/google/common/base/CharMatcher$Whitespace;->p:Lcom/google/common/base/CharMatcher$Whitespace;

    return-object v0
.end method

.method static synthetic c(C)Ljava/lang/String;
    .locals 1

    .prologue
    .line 54
    invoke-static {p0}, Lcom/google/common/base/CharMatcher;->d(C)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static d()Lcom/google/common/base/CharMatcher;
    .locals 1

    .prologue
    .line 145
    sget-object v0, Lcom/google/common/base/CharMatcher$BreakingWhitespace;->o:Lcom/google/common/base/CharMatcher;

    return-object v0
.end method

.method private static d(C)Ljava/lang/String;
    .locals 5

    .prologue
    .line 1035
    const-string v1, "0123456789ABCDEF"

    .line 1036
    const/4 v0, 0x6

    new-array v2, v0, [C

    fill-array-data v2, :array_0

    .line 1037
    const/4 v0, 0x0

    :goto_0
    const/4 v3, 0x4

    if-ge v0, v3, :cond_0

    .line 1038
    rsub-int/lit8 v3, v0, 0x5

    and-int/lit8 v4, p0, 0xf

    invoke-virtual {v1, v4}, Ljava/lang/String;->charAt(I)C

    move-result v4

    aput-char v4, v2, v3

    .line 1039
    shr-int/lit8 v3, p0, 0x4

    int-to-char p0, v3

    .line 1037
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 1041
    :cond_0
    invoke-static {v2}, Ljava/lang/String;->copyValueOf([C)Ljava/lang/String;

    move-result-object v0

    return-object v0

    .line 1036
    nop

    :array_0
    .array-data 2
        0x5cs
        0x75s
        0x0s
        0x0s
        0x0s
        0x0s
    .end array-data
.end method

.method public static e()Lcom/google/common/base/CharMatcher;
    .locals 1

    .prologue
    .line 154
    sget-object v0, Lcom/google/common/base/CharMatcher$Ascii;->o:Lcom/google/common/base/CharMatcher$Ascii;

    return-object v0
.end method

.method public static f()Lcom/google/common/base/CharMatcher;
    .locals 1

    .prologue
    .line 165
    sget-object v0, Lcom/google/common/base/CharMatcher$Digit;->o:Lcom/google/common/base/CharMatcher$Digit;

    return-object v0
.end method

.method public static g()Lcom/google/common/base/CharMatcher;
    .locals 1

    .prologue
    .line 176
    sget-object v0, Lcom/google/common/base/CharMatcher$JavaDigit;->o:Lcom/google/common/base/CharMatcher$JavaDigit;

    return-object v0
.end method

.method public static h()Lcom/google/common/base/CharMatcher;
    .locals 1

    .prologue
    .line 187
    sget-object v0, Lcom/google/common/base/CharMatcher$JavaLetter;->o:Lcom/google/common/base/CharMatcher$JavaLetter;

    return-object v0
.end method

.method public static i()Lcom/google/common/base/CharMatcher;
    .locals 1

    .prologue
    .line 197
    sget-object v0, Lcom/google/common/base/CharMatcher$JavaLetterOrDigit;->o:Lcom/google/common/base/CharMatcher$JavaLetterOrDigit;

    return-object v0
.end method

.method public static j()Lcom/google/common/base/CharMatcher;
    .locals 1

    .prologue
    .line 207
    sget-object v0, Lcom/google/common/base/CharMatcher$JavaUpperCase;->o:Lcom/google/common/base/CharMatcher$JavaUpperCase;

    return-object v0
.end method

.method public static k()Lcom/google/common/base/CharMatcher;
    .locals 1

    .prologue
    .line 217
    sget-object v0, Lcom/google/common/base/CharMatcher$JavaLowerCase;->o:Lcom/google/common/base/CharMatcher$JavaLowerCase;

    return-object v0
.end method

.method public static l()Lcom/google/common/base/CharMatcher;
    .locals 1

    .prologue
    .line 227
    sget-object v0, Lcom/google/common/base/CharMatcher$JavaIsoControl;->o:Lcom/google/common/base/CharMatcher$JavaIsoControl;

    return-object v0
.end method

.method public static m()Lcom/google/common/base/CharMatcher;
    .locals 1

    .prologue
    .line 238
    sget-object v0, Lcom/google/common/base/CharMatcher$Invisible;->o:Lcom/google/common/base/CharMatcher$Invisible;

    return-object v0
.end method

.method public static n()Lcom/google/common/base/CharMatcher;
    .locals 1

    .prologue
    .line 252
    sget-object v0, Lcom/google/common/base/CharMatcher$SingleWidth;->o:Lcom/google/common/base/CharMatcher$SingleWidth;

    return-object v0
.end method


# virtual methods
.method public a(Ljava/lang/CharSequence;I)I
    .locals 3

    .prologue
    .line 688
    invoke-interface {p1}, Ljava/lang/CharSequence;->length()I

    move-result v1

    .line 689
    invoke-static {p2, v1}, Lcom/google/common/base/Preconditions;->a(II)I

    move v0, p2

    .line 690
    :goto_0
    if-ge v0, v1, :cond_1

    .line 691
    invoke-interface {p1, v0}, Ljava/lang/CharSequence;->charAt(I)C

    move-result v2

    invoke-virtual {p0, v2}, Lcom/google/common/base/CharMatcher;->b(C)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 695
    :goto_1
    return v0

    .line 690
    :cond_0
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 695
    :cond_1
    const/4 v0, -0x1

    goto :goto_1
.end method

.method public abstract b(C)Z
.end method

.method public toString()Ljava/lang/String;
    .locals 1

    .prologue
    .line 1027
    invoke-super {p0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
