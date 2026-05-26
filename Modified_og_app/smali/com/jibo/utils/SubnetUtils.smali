.class public Lcom/jibo/utils/SubnetUtils;
.super Ljava/lang/Object;
.source "SubnetUtils.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/jibo/utils/SubnetUtils$SubnetInfo;
    }
.end annotation


# static fields
.field private static final a:Ljava/util/regex/Pattern;

.field private static final b:Ljava/util/regex/Pattern;


# instance fields
.field private c:I

.field private d:I

.field private e:I

.field private f:I


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 16
    const-string v0, "(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})"

    invoke-static {v0}, Ljava/util/regex/Pattern;->compile(Ljava/lang/String;)Ljava/util/regex/Pattern;

    move-result-object v0

    sput-object v0, Lcom/jibo/utils/SubnetUtils;->a:Ljava/util/regex/Pattern;

    .line 17
    const-string v0, "(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})/(\\d{1,3})"

    invoke-static {v0}, Ljava/util/regex/Pattern;->compile(Ljava/lang/String;)Ljava/util/regex/Pattern;

    move-result-object v0

    sput-object v0, Lcom/jibo/utils/SubnetUtils;->b:Ljava/util/regex/Pattern;

    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;)V
    .locals 1

    .prologue
    const/4 v0, 0x0

    .line 40
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 20
    iput v0, p0, Lcom/jibo/utils/SubnetUtils;->c:I

    .line 21
    iput v0, p0, Lcom/jibo/utils/SubnetUtils;->d:I

    .line 22
    iput v0, p0, Lcom/jibo/utils/SubnetUtils;->e:I

    .line 23
    iput v0, p0, Lcom/jibo/utils/SubnetUtils;->f:I

    .line 41
    invoke-direct {p0, p1, p2}, Lcom/jibo/utils/SubnetUtils;->a(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-direct {p0, v0}, Lcom/jibo/utils/SubnetUtils;->a(Ljava/lang/String;)V

    .line 42
    return-void
.end method

.method private a(III)I
    .locals 3

    .prologue
    .line 127
    if-lt p1, p2, :cond_0

    if-gt p1, p3, :cond_0

    .line 128
    return p1

    .line 130
    :cond_0
    new-instance v0, Ljava/lang/IllegalArgumentException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Value out of range: ["

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "]"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method static synthetic a(Lcom/jibo/utils/SubnetUtils;)I
    .locals 1

    .prologue
    .line 12
    iget v0, p0, Lcom/jibo/utils/SubnetUtils;->e:I

    return v0
.end method

.method private a(Ljava/util/regex/Matcher;)I
    .locals 5

    .prologue
    const/4 v2, 0x0

    .line 91
    .line 92
    const/4 v0, 0x1

    move v1, v2

    :goto_0
    const/4 v3, 0x4

    if-gt v0, v3, :cond_0

    .line 93
    invoke-virtual {p1, v0}, Ljava/util/regex/Matcher;->group(I)Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v3

    const/16 v4, 0xff

    invoke-direct {p0, v3, v2, v4}, Lcom/jibo/utils/SubnetUtils;->a(III)I

    move-result v3

    .line 94
    and-int/lit16 v3, v3, 0xff

    rsub-int/lit8 v4, v0, 0x4

    mul-int/lit8 v4, v4, 0x8

    shl-int/2addr v3, v4

    or-int/2addr v1, v3

    .line 92
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 96
    :cond_0
    return v1
.end method

.method static synthetic a(Lcom/jibo/utils/SubnetUtils;[I)Ljava/lang/String;
    .locals 1

    .prologue
    .line 12
    invoke-direct {p0, p1}, Lcom/jibo/utils/SubnetUtils;->a([I)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method private a(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    .locals 2

    .prologue
    .line 151
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "/"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-direct {p0, p2}, Lcom/jibo/utils/SubnetUtils;->b(Ljava/lang/String;)I

    move-result v1

    invoke-virtual {p0, v1}, Lcom/jibo/utils/SubnetUtils;->a(I)I

    move-result v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method private a([I)Ljava/lang/String;
    .locals 3

    .prologue
    .line 113
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    .line 114
    const/4 v0, 0x0

    :goto_0
    array-length v2, p1

    if-ge v0, v2, :cond_1

    .line 115
    aget v2, p1, v0

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    .line 116
    array-length v2, p1

    add-int/lit8 v2, v2, -0x1

    if-eq v0, v2, :cond_0

    .line 117
    const-string v2, "."

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 114
    :cond_0
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 120
    :cond_1
    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method private a(Ljava/lang/String;)V
    .locals 5

    .prologue
    const/4 v0, 0x0

    .line 55
    sget-object v1, Lcom/jibo/utils/SubnetUtils;->b:Ljava/util/regex/Pattern;

    invoke-virtual {v1, p1}, Ljava/util/regex/Pattern;->matcher(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;

    move-result-object v1

    .line 57
    invoke-virtual {v1}, Ljava/util/regex/Matcher;->matches()Z

    move-result v2

    if-eqz v2, :cond_1

    .line 58
    invoke-direct {p0, v1}, Lcom/jibo/utils/SubnetUtils;->a(Ljava/util/regex/Matcher;)I

    move-result v2

    iput v2, p0, Lcom/jibo/utils/SubnetUtils;->d:I

    .line 61
    const/4 v2, 0x5

    invoke-virtual {v1, v2}, Ljava/util/regex/Matcher;->group(I)Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v1

    const/16 v2, 0x1f

    invoke-direct {p0, v1, v0, v2}, Lcom/jibo/utils/SubnetUtils;->a(III)I

    move-result v1

    .line 62
    :goto_0
    if-ge v0, v1, :cond_0

    .line 63
    iget v2, p0, Lcom/jibo/utils/SubnetUtils;->c:I

    const/4 v3, 0x1

    rsub-int/lit8 v4, v0, 0x1f

    shl-int/2addr v3, v4

    or-int/2addr v2, v3

    iput v2, p0, Lcom/jibo/utils/SubnetUtils;->c:I

    .line 62
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 67
    :cond_0
    iget v0, p0, Lcom/jibo/utils/SubnetUtils;->d:I

    iget v1, p0, Lcom/jibo/utils/SubnetUtils;->c:I

    and-int/2addr v0, v1

    iput v0, p0, Lcom/jibo/utils/SubnetUtils;->e:I

    .line 70
    iget v0, p0, Lcom/jibo/utils/SubnetUtils;->e:I

    iget v1, p0, Lcom/jibo/utils/SubnetUtils;->c:I

    xor-int/lit8 v1, v1, -0x1

    or-int/2addr v0, v1

    iput v0, p0, Lcom/jibo/utils/SubnetUtils;->f:I

    .line 73
    return-void

    .line 72
    :cond_1
    new-instance v0, Ljava/lang/IllegalArgumentException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Could not parse ["

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "]"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method static synthetic a(Lcom/jibo/utils/SubnetUtils;I)[I
    .locals 1

    .prologue
    .line 12
    invoke-direct {p0, p1}, Lcom/jibo/utils/SubnetUtils;->b(I)[I

    move-result-object v0

    return-object v0
.end method

.method private b(Ljava/lang/String;)I
    .locals 3

    .prologue
    .line 79
    sget-object v0, Lcom/jibo/utils/SubnetUtils;->a:Ljava/util/regex/Pattern;

    invoke-virtual {v0, p1}, Ljava/util/regex/Pattern;->matcher(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;

    move-result-object v0

    .line 80
    invoke-virtual {v0}, Ljava/util/regex/Matcher;->matches()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 81
    invoke-direct {p0, v0}, Lcom/jibo/utils/SubnetUtils;->a(Ljava/util/regex/Matcher;)I

    move-result v0

    return v0

    .line 83
    :cond_0
    new-instance v0, Ljava/lang/IllegalArgumentException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Could not parse ["

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "]"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method private b(I)[I
    .locals 4

    .prologue
    .line 103
    const/4 v0, 0x4

    new-array v1, v0, [I

    .line 104
    const/4 v0, 0x3

    :goto_0
    if-ltz v0, :cond_0

    .line 105
    aget v2, v1, v0

    rsub-int/lit8 v3, v0, 0x3

    mul-int/lit8 v3, v3, 0x8

    ushr-int v3, p1, v3

    and-int/lit16 v3, v3, 0xff

    or-int/2addr v2, v3

    aput v2, v1, v0

    .line 104
    add-int/lit8 v0, v0, -0x1

    goto :goto_0

    .line 106
    :cond_0
    return-object v1
.end method


# virtual methods
.method a(I)I
    .locals 3

    .prologue
    const v2, 0x33333333

    .line 138
    ushr-int/lit8 v0, p1, 0x1

    const v1, 0x55555555

    and-int/2addr v0, v1

    sub-int v0, p1, v0

    .line 139
    and-int v1, v0, v2

    ushr-int/lit8 v0, v0, 0x2

    and-int/2addr v0, v2

    add-int/2addr v0, v1

    .line 140
    ushr-int/lit8 v1, v0, 0x4

    add-int/2addr v0, v1

    const v1, 0xf0f0f0f

    and-int/2addr v0, v1

    .line 141
    ushr-int/lit8 v1, v0, 0x8

    add-int/2addr v0, v1

    .line 142
    ushr-int/lit8 v1, v0, 0x10

    add-int/2addr v0, v1

    .line 143
    and-int/lit8 v0, v0, 0x3f

    return v0
.end method

.method public final a()Lcom/jibo/utils/SubnetUtils$SubnetInfo;
    .locals 2

    .prologue
    .line 49
    new-instance v0, Lcom/jibo/utils/SubnetUtils$SubnetInfo;

    const/4 v1, 0x0

    invoke-direct {v0, p0, v1}, Lcom/jibo/utils/SubnetUtils$SubnetInfo;-><init>(Lcom/jibo/utils/SubnetUtils;Lcom/jibo/utils/SubnetUtils$1;)V

    return-object v0
.end method
