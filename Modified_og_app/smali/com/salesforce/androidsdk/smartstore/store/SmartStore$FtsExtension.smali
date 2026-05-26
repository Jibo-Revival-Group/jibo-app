.class public final enum Lcom/salesforce/androidsdk/smartstore/store/SmartStore$FtsExtension;
.super Ljava/lang/Enum;
.source "SmartStore.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/salesforce/androidsdk/smartstore/store/SmartStore;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "FtsExtension"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/salesforce/androidsdk/smartstore/store/SmartStore$FtsExtension;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/salesforce/androidsdk/smartstore/store/SmartStore$FtsExtension;

.field public static final enum fts4:Lcom/salesforce/androidsdk/smartstore/store/SmartStore$FtsExtension;

.field public static final enum fts5:Lcom/salesforce/androidsdk/smartstore/store/SmartStore$FtsExtension;


# direct methods
.method static constructor <clinit>()V
    .locals 4

    .prologue
    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 1555
    new-instance v0, Lcom/salesforce/androidsdk/smartstore/store/SmartStore$FtsExtension;

    const-string v1, "fts4"

    invoke-direct {v0, v1, v2}, Lcom/salesforce/androidsdk/smartstore/store/SmartStore$FtsExtension;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/salesforce/androidsdk/smartstore/store/SmartStore$FtsExtension;->fts4:Lcom/salesforce/androidsdk/smartstore/store/SmartStore$FtsExtension;

    .line 1556
    new-instance v0, Lcom/salesforce/androidsdk/smartstore/store/SmartStore$FtsExtension;

    const-string v1, "fts5"

    invoke-direct {v0, v1, v3}, Lcom/salesforce/androidsdk/smartstore/store/SmartStore$FtsExtension;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/salesforce/androidsdk/smartstore/store/SmartStore$FtsExtension;->fts5:Lcom/salesforce/androidsdk/smartstore/store/SmartStore$FtsExtension;

    .line 1554
    const/4 v0, 0x2

    new-array v0, v0, [Lcom/salesforce/androidsdk/smartstore/store/SmartStore$FtsExtension;

    sget-object v1, Lcom/salesforce/androidsdk/smartstore/store/SmartStore$FtsExtension;->fts4:Lcom/salesforce/androidsdk/smartstore/store/SmartStore$FtsExtension;

    aput-object v1, v0, v2

    sget-object v1, Lcom/salesforce/androidsdk/smartstore/store/SmartStore$FtsExtension;->fts5:Lcom/salesforce/androidsdk/smartstore/store/SmartStore$FtsExtension;

    aput-object v1, v0, v3

    sput-object v0, Lcom/salesforce/androidsdk/smartstore/store/SmartStore$FtsExtension;->$VALUES:[Lcom/salesforce/androidsdk/smartstore/store/SmartStore$FtsExtension;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;I)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()V"
        }
    .end annotation

    .prologue
    .line 1554
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/salesforce/androidsdk/smartstore/store/SmartStore$FtsExtension;
    .locals 1

    .prologue
    .line 1554
    const-class v0, Lcom/salesforce/androidsdk/smartstore/store/SmartStore$FtsExtension;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/salesforce/androidsdk/smartstore/store/SmartStore$FtsExtension;

    return-object v0
.end method

.method public static values()[Lcom/salesforce/androidsdk/smartstore/store/SmartStore$FtsExtension;
    .locals 1

    .prologue
    .line 1554
    sget-object v0, Lcom/salesforce/androidsdk/smartstore/store/SmartStore$FtsExtension;->$VALUES:[Lcom/salesforce/androidsdk/smartstore/store/SmartStore$FtsExtension;

    invoke-virtual {v0}, [Lcom/salesforce/androidsdk/smartstore/store/SmartStore$FtsExtension;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/salesforce/androidsdk/smartstore/store/SmartStore$FtsExtension;

    return-object v0
.end method
