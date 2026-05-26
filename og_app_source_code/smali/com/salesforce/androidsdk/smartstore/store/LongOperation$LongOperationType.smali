.class public final enum Lcom/salesforce/androidsdk/smartstore/store/LongOperation$LongOperationType;
.super Ljava/lang/Enum;
.source "LongOperation.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/salesforce/androidsdk/smartstore/store/LongOperation;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "LongOperationType"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/salesforce/androidsdk/smartstore/store/LongOperation$LongOperationType;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/salesforce/androidsdk/smartstore/store/LongOperation$LongOperationType;

.field public static final enum alterSoup:Lcom/salesforce/androidsdk/smartstore/store/LongOperation$LongOperationType;


# instance fields
.field private operationClass:Ljava/lang/Class;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/lang/Class",
            "<+",
            "Lcom/salesforce/androidsdk/smartstore/store/LongOperation;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 4

    .prologue
    const/4 v3, 0x0

    .line 38
    new-instance v0, Lcom/salesforce/androidsdk/smartstore/store/LongOperation$LongOperationType;

    const-string v1, "alterSoup"

    const-class v2, Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation;

    invoke-direct {v0, v1, v3, v2}, Lcom/salesforce/androidsdk/smartstore/store/LongOperation$LongOperationType;-><init>(Ljava/lang/String;ILjava/lang/Class;)V

    sput-object v0, Lcom/salesforce/androidsdk/smartstore/store/LongOperation$LongOperationType;->alterSoup:Lcom/salesforce/androidsdk/smartstore/store/LongOperation$LongOperationType;

    .line 37
    const/4 v0, 0x1

    new-array v0, v0, [Lcom/salesforce/androidsdk/smartstore/store/LongOperation$LongOperationType;

    sget-object v1, Lcom/salesforce/androidsdk/smartstore/store/LongOperation$LongOperationType;->alterSoup:Lcom/salesforce/androidsdk/smartstore/store/LongOperation$LongOperationType;

    aput-object v1, v0, v3

    sput-object v0, Lcom/salesforce/androidsdk/smartstore/store/LongOperation$LongOperationType;->$VALUES:[Lcom/salesforce/androidsdk/smartstore/store/LongOperation$LongOperationType;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;ILjava/lang/Class;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Class",
            "<+",
            "Lcom/salesforce/androidsdk/smartstore/store/LongOperation;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 42
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    .line 43
    iput-object p3, p0, Lcom/salesforce/androidsdk/smartstore/store/LongOperation$LongOperationType;->operationClass:Ljava/lang/Class;

    .line 44
    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/salesforce/androidsdk/smartstore/store/LongOperation$LongOperationType;
    .locals 1

    .prologue
    .line 37
    const-class v0, Lcom/salesforce/androidsdk/smartstore/store/LongOperation$LongOperationType;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/salesforce/androidsdk/smartstore/store/LongOperation$LongOperationType;

    return-object v0
.end method

.method public static values()[Lcom/salesforce/androidsdk/smartstore/store/LongOperation$LongOperationType;
    .locals 1

    .prologue
    .line 37
    sget-object v0, Lcom/salesforce/androidsdk/smartstore/store/LongOperation$LongOperationType;->$VALUES:[Lcom/salesforce/androidsdk/smartstore/store/LongOperation$LongOperationType;

    invoke-virtual {v0}, [Lcom/salesforce/androidsdk/smartstore/store/LongOperation$LongOperationType;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/salesforce/androidsdk/smartstore/store/LongOperation$LongOperationType;

    return-object v0
.end method


# virtual methods
.method public getOperation(Lcom/salesforce/androidsdk/smartstore/store/SmartStore;JLorg/json/JSONObject;Ljava/lang/String;)Lcom/salesforce/androidsdk/smartstore/store/LongOperation;
    .locals 6
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalAccessException;,
            Ljava/lang/InstantiationException;,
            Lorg/json/JSONException;
        }
    .end annotation

    .prologue
    .line 48
    iget-object v0, p0, Lcom/salesforce/androidsdk/smartstore/store/LongOperation$LongOperationType;->operationClass:Ljava/lang/Class;

    invoke-virtual {v0}, Ljava/lang/Class;->newInstance()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/salesforce/androidsdk/smartstore/store/LongOperation;

    move-object v1, p1

    move-wide v2, p2

    move-object v4, p4

    move-object v5, p5

    .line 49
    invoke-virtual/range {v0 .. v5}, Lcom/salesforce/androidsdk/smartstore/store/LongOperation;->a(Lcom/salesforce/androidsdk/smartstore/store/SmartStore;JLorg/json/JSONObject;Ljava/lang/String;)V

    .line 50
    return-object v0
.end method
