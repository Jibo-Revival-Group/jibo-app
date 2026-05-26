.class public final enum Lcom/salesforce/androidsdk/smartstore/store/SmartStore$Type;
.super Ljava/lang/Enum;
.source "SmartStore.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/salesforce/androidsdk/smartstore/store/SmartStore;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "Type"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/salesforce/androidsdk/smartstore/store/SmartStore$Type;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/salesforce/androidsdk/smartstore/store/SmartStore$Type;

.field public static final enum floating:Lcom/salesforce/androidsdk/smartstore/store/SmartStore$Type;

.field public static final enum full_text:Lcom/salesforce/androidsdk/smartstore/store/SmartStore$Type;

.field public static final enum integer:Lcom/salesforce/androidsdk/smartstore/store/SmartStore$Type;

.field public static final enum json1:Lcom/salesforce/androidsdk/smartstore/store/SmartStore$Type;

.field public static final enum string:Lcom/salesforce/androidsdk/smartstore/store/SmartStore$Type;


# instance fields
.field private columnType:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 8

    .prologue
    const/4 v7, 0x4

    const/4 v6, 0x3

    const/4 v5, 0x2

    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 1508
    new-instance v0, Lcom/salesforce/androidsdk/smartstore/store/SmartStore$Type;

    const-string v1, "string"

    const-string v2, "TEXT"

    invoke-direct {v0, v1, v3, v2}, Lcom/salesforce/androidsdk/smartstore/store/SmartStore$Type;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/salesforce/androidsdk/smartstore/store/SmartStore$Type;->string:Lcom/salesforce/androidsdk/smartstore/store/SmartStore$Type;

    .line 1509
    new-instance v0, Lcom/salesforce/androidsdk/smartstore/store/SmartStore$Type;

    const-string v1, "integer"

    const-string v2, "INTEGER"

    invoke-direct {v0, v1, v4, v2}, Lcom/salesforce/androidsdk/smartstore/store/SmartStore$Type;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/salesforce/androidsdk/smartstore/store/SmartStore$Type;->integer:Lcom/salesforce/androidsdk/smartstore/store/SmartStore$Type;

    .line 1510
    new-instance v0, Lcom/salesforce/androidsdk/smartstore/store/SmartStore$Type;

    const-string v1, "floating"

    const-string v2, "REAL"

    invoke-direct {v0, v1, v5, v2}, Lcom/salesforce/androidsdk/smartstore/store/SmartStore$Type;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/salesforce/androidsdk/smartstore/store/SmartStore$Type;->floating:Lcom/salesforce/androidsdk/smartstore/store/SmartStore$Type;

    .line 1511
    new-instance v0, Lcom/salesforce/androidsdk/smartstore/store/SmartStore$Type;

    const-string v1, "full_text"

    const-string v2, "TEXT"

    invoke-direct {v0, v1, v6, v2}, Lcom/salesforce/androidsdk/smartstore/store/SmartStore$Type;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/salesforce/androidsdk/smartstore/store/SmartStore$Type;->full_text:Lcom/salesforce/androidsdk/smartstore/store/SmartStore$Type;

    .line 1512
    new-instance v0, Lcom/salesforce/androidsdk/smartstore/store/SmartStore$Type;

    const-string v1, "json1"

    const/4 v2, 0x0

    invoke-direct {v0, v1, v7, v2}, Lcom/salesforce/androidsdk/smartstore/store/SmartStore$Type;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/salesforce/androidsdk/smartstore/store/SmartStore$Type;->json1:Lcom/salesforce/androidsdk/smartstore/store/SmartStore$Type;

    .line 1507
    const/4 v0, 0x5

    new-array v0, v0, [Lcom/salesforce/androidsdk/smartstore/store/SmartStore$Type;

    sget-object v1, Lcom/salesforce/androidsdk/smartstore/store/SmartStore$Type;->string:Lcom/salesforce/androidsdk/smartstore/store/SmartStore$Type;

    aput-object v1, v0, v3

    sget-object v1, Lcom/salesforce/androidsdk/smartstore/store/SmartStore$Type;->integer:Lcom/salesforce/androidsdk/smartstore/store/SmartStore$Type;

    aput-object v1, v0, v4

    sget-object v1, Lcom/salesforce/androidsdk/smartstore/store/SmartStore$Type;->floating:Lcom/salesforce/androidsdk/smartstore/store/SmartStore$Type;

    aput-object v1, v0, v5

    sget-object v1, Lcom/salesforce/androidsdk/smartstore/store/SmartStore$Type;->full_text:Lcom/salesforce/androidsdk/smartstore/store/SmartStore$Type;

    aput-object v1, v0, v6

    sget-object v1, Lcom/salesforce/androidsdk/smartstore/store/SmartStore$Type;->json1:Lcom/salesforce/androidsdk/smartstore/store/SmartStore$Type;

    aput-object v1, v0, v7

    sput-object v0, Lcom/salesforce/androidsdk/smartstore/store/SmartStore$Type;->$VALUES:[Lcom/salesforce/androidsdk/smartstore/store/SmartStore$Type;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;ILjava/lang/String;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")V"
        }
    .end annotation

    .prologue
    .line 1516
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    .line 1517
    iput-object p3, p0, Lcom/salesforce/androidsdk/smartstore/store/SmartStore$Type;->columnType:Ljava/lang/String;

    .line 1518
    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/salesforce/androidsdk/smartstore/store/SmartStore$Type;
    .locals 1

    .prologue
    .line 1507
    const-class v0, Lcom/salesforce/androidsdk/smartstore/store/SmartStore$Type;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/salesforce/androidsdk/smartstore/store/SmartStore$Type;

    return-object v0
.end method

.method public static values()[Lcom/salesforce/androidsdk/smartstore/store/SmartStore$Type;
    .locals 1

    .prologue
    .line 1507
    sget-object v0, Lcom/salesforce/androidsdk/smartstore/store/SmartStore$Type;->$VALUES:[Lcom/salesforce/androidsdk/smartstore/store/SmartStore$Type;

    invoke-virtual {v0}, [Lcom/salesforce/androidsdk/smartstore/store/SmartStore$Type;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/salesforce/androidsdk/smartstore/store/SmartStore$Type;

    return-object v0
.end method


# virtual methods
.method public getColumnType()Ljava/lang/String;
    .locals 1

    .prologue
    .line 1521
    iget-object v0, p0, Lcom/salesforce/androidsdk/smartstore/store/SmartStore$Type;->columnType:Ljava/lang/String;

    return-object v0
.end method
