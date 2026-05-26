.class public Lcom/google/maps/internal/StringJoin;
.super Ljava/lang/Object;
.source "StringJoin.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/google/maps/internal/StringJoin$UrlValue;
    }
.end annotation


# direct methods
.method private constructor <init>()V
    .locals 0

    .prologue
    .line 30
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static varargs join(C[Lcom/google/maps/internal/StringJoin$UrlValue;)Ljava/lang/String;
    .locals 6

    .prologue
    const/4 v0, 0x0

    .line 44
    array-length v1, p1

    new-array v3, v1, [Ljava/lang/String;

    .line 46
    array-length v4, p1

    move v1, v0

    :goto_0
    if-ge v0, v4, :cond_0

    aget-object v5, p1, v0

    .line 47
    add-int/lit8 v2, v1, 0x1

    invoke-virtual {v5}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v1

    .line 46
    add-int/lit8 v0, v0, 0x1

    move v1, v2

    goto :goto_0

    .line 50
    :cond_0
    invoke-static {p0, v3}, Lcom/google/maps/internal/StringJoin;->join(C[Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static varargs join(C[Ljava/lang/String;)Ljava/lang/String;
    .locals 3

    .prologue
    .line 33
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    .line 34
    const/4 v0, 0x0

    :goto_0
    array-length v2, p1

    if-ge v0, v2, :cond_1

    .line 35
    if-eqz v0, :cond_0

    .line 36
    invoke-virtual {v1, p0}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 38
    :cond_0
    aget-object v2, p1, v0

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 34
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 40
    :cond_1
    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
