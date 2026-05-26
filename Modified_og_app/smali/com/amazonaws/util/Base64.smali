.class public final enum Lcom/amazonaws/util/Base64;
.super Ljava/lang/Enum;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/amazonaws/util/Base64;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/amazonaws/util/Base64;

.field private static final codec:Lcom/amazonaws/util/Base64Codec;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    const/4 v0, 0x0

    new-array v0, v0, [Lcom/amazonaws/util/Base64;

    sput-object v0, Lcom/amazonaws/util/Base64;->$VALUES:[Lcom/amazonaws/util/Base64;

    new-instance v0, Lcom/amazonaws/util/Base64Codec;

    invoke-direct {v0}, Lcom/amazonaws/util/Base64Codec;-><init>()V

    sput-object v0, Lcom/amazonaws/util/Base64;->codec:Lcom/amazonaws/util/Base64Codec;

    return-void
.end method

.method public static varargs encodeAsString([B)Ljava/lang/String;
    .locals 1

    if-nez p0, :cond_0

    const/4 v0, 0x0

    :goto_0
    return-object v0

    :cond_0
    array-length v0, p0

    if-nez v0, :cond_1

    const-string v0, ""

    goto :goto_0

    :cond_1
    sget-object v0, Lcom/amazonaws/util/Base64;->codec:Lcom/amazonaws/util/Base64Codec;

    invoke-virtual {v0, p0}, Lcom/amazonaws/util/Base64Codec;->encode([B)[B

    move-result-object v0

    invoke-static {v0}, Lcom/amazonaws/util/CodecUtils;->toStringDirect([B)Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/amazonaws/util/Base64;
    .locals 1

    const-class v0, Lcom/amazonaws/util/Base64;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/amazonaws/util/Base64;

    return-object v0
.end method

.method public static values()[Lcom/amazonaws/util/Base64;
    .locals 1

    sget-object v0, Lcom/amazonaws/util/Base64;->$VALUES:[Lcom/amazonaws/util/Base64;

    invoke-virtual {v0}, [Lcom/amazonaws/util/Base64;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/amazonaws/util/Base64;

    return-object v0
.end method
