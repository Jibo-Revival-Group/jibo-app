.class public Lcom/salesforce/android/service/common/utilities/spatial/Orientation;
.super Ljava/lang/Object;
.source "Orientation.java"


# static fields
.field public static a:Lcom/salesforce/android/service/common/utilities/spatial/Orientation;

.field public static b:Lcom/salesforce/android/service/common/utilities/spatial/Orientation;

.field public static c:Lcom/salesforce/android/service/common/utilities/spatial/Orientation;

.field public static d:Lcom/salesforce/android/service/common/utilities/spatial/Orientation;

.field public static e:Lcom/salesforce/android/service/common/utilities/spatial/Orientation;

.field public static f:Lcom/salesforce/android/service/common/utilities/spatial/Orientation;


# instance fields
.field private final g:I


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 91
    const/4 v0, 0x0

    invoke-static {v0}, Lcom/salesforce/android/service/common/utilities/spatial/Orientation;->a(I)Lcom/salesforce/android/service/common/utilities/spatial/Orientation;

    move-result-object v0

    sput-object v0, Lcom/salesforce/android/service/common/utilities/spatial/Orientation;->a:Lcom/salesforce/android/service/common/utilities/spatial/Orientation;

    .line 93
    const/16 v0, 0x5a

    invoke-static {v0}, Lcom/salesforce/android/service/common/utilities/spatial/Orientation;->a(I)Lcom/salesforce/android/service/common/utilities/spatial/Orientation;

    move-result-object v0

    sput-object v0, Lcom/salesforce/android/service/common/utilities/spatial/Orientation;->b:Lcom/salesforce/android/service/common/utilities/spatial/Orientation;

    .line 95
    const/16 v0, 0xb4

    invoke-static {v0}, Lcom/salesforce/android/service/common/utilities/spatial/Orientation;->a(I)Lcom/salesforce/android/service/common/utilities/spatial/Orientation;

    move-result-object v0

    sput-object v0, Lcom/salesforce/android/service/common/utilities/spatial/Orientation;->c:Lcom/salesforce/android/service/common/utilities/spatial/Orientation;

    .line 97
    const/16 v0, 0x10e

    invoke-static {v0}, Lcom/salesforce/android/service/common/utilities/spatial/Orientation;->a(I)Lcom/salesforce/android/service/common/utilities/spatial/Orientation;

    move-result-object v0

    sput-object v0, Lcom/salesforce/android/service/common/utilities/spatial/Orientation;->d:Lcom/salesforce/android/service/common/utilities/spatial/Orientation;

    .line 99
    sget-object v0, Lcom/salesforce/android/service/common/utilities/spatial/Orientation;->a:Lcom/salesforce/android/service/common/utilities/spatial/Orientation;

    sput-object v0, Lcom/salesforce/android/service/common/utilities/spatial/Orientation;->e:Lcom/salesforce/android/service/common/utilities/spatial/Orientation;

    .line 101
    sget-object v0, Lcom/salesforce/android/service/common/utilities/spatial/Orientation;->b:Lcom/salesforce/android/service/common/utilities/spatial/Orientation;

    sput-object v0, Lcom/salesforce/android/service/common/utilities/spatial/Orientation;->f:Lcom/salesforce/android/service/common/utilities/spatial/Orientation;

    return-void
.end method

.method private constructor <init>(I)V
    .locals 0

    .prologue
    .line 83
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 84
    iput p1, p0, Lcom/salesforce/android/service/common/utilities/spatial/Orientation;->g:I

    .line 85
    return-void
.end method

.method public static a(I)Lcom/salesforce/android/service/common/utilities/spatial/Orientation;
    .locals 1

    .prologue
    .line 72
    new-instance v0, Lcom/salesforce/android/service/common/utilities/spatial/Orientation;

    invoke-direct {v0, p0}, Lcom/salesforce/android/service/common/utilities/spatial/Orientation;-><init>(I)V

    return-object v0
.end method


# virtual methods
.method public a()Z
    .locals 2

    .prologue
    .line 129
    iget v0, p0, Lcom/salesforce/android/service/common/utilities/spatial/Orientation;->g:I

    if-eqz v0, :cond_0

    iget v0, p0, Lcom/salesforce/android/service/common/utilities/spatial/Orientation;->g:I

    const/16 v1, 0xb4

    if-ne v0, v1, :cond_1

    :cond_0
    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public b()Z
    .locals 2

    .prologue
    .line 133
    iget v0, p0, Lcom/salesforce/android/service/common/utilities/spatial/Orientation;->g:I

    const/16 v1, 0x5a

    if-eq v0, v1, :cond_0

    iget v0, p0, Lcom/salesforce/android/service/common/utilities/spatial/Orientation;->g:I

    const/16 v1, 0x10e

    if-ne v0, v1, :cond_1

    :cond_0
    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public equals(Ljava/lang/Object;)Z
    .locals 4

    .prologue
    const/4 v0, 0x1

    const/4 v1, 0x0

    .line 145
    if-ne p0, p1, :cond_1

    .line 154
    :cond_0
    :goto_0
    return v0

    .line 149
    :cond_1
    instance-of v2, p1, Lcom/salesforce/android/service/common/utilities/spatial/Orientation;

    if-eqz v2, :cond_2

    .line 150
    check-cast p1, Lcom/salesforce/android/service/common/utilities/spatial/Orientation;

    .line 151
    iget v2, p0, Lcom/salesforce/android/service/common/utilities/spatial/Orientation;->g:I

    iget v3, p1, Lcom/salesforce/android/service/common/utilities/spatial/Orientation;->g:I

    if-eq v2, v3, :cond_0

    move v0, v1

    goto :goto_0

    :cond_2
    move v0, v1

    .line 154
    goto :goto_0
.end method

.method public hashCode()I
    .locals 1

    .prologue
    .line 158
    iget v0, p0, Lcom/salesforce/android/service/common/utilities/spatial/Orientation;->g:I

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Integer;->hashCode()I

    move-result v0

    return v0
.end method

.method public toString()Ljava/lang/String;
    .locals 2

    .prologue
    .line 162
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "["

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget v1, p0, Lcom/salesforce/android/service/common/utilities/spatial/Orientation;->g:I

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "]"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
