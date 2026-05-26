.class public final enum Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation$AlterSoupStep;
.super Ljava/lang/Enum;
.source "AlterSoupLongOperation.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "AlterSoupStep"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation$AlterSoupStep;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation$AlterSoupStep;

.field public static final enum COPY_TABLE:Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation$AlterSoupStep;

.field public static final enum DROP_OLD_INDEXES:Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation$AlterSoupStep;

.field public static final enum DROP_OLD_TABLE:Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation$AlterSoupStep;

.field public static final LAST:Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation$AlterSoupStep;

.field public static final enum REGISTER_SOUP_USING_TABLE_NAME:Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation$AlterSoupStep;

.field public static final enum RENAME_OLD_SOUP_TABLE:Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation$AlterSoupStep;

.field public static final enum RE_INDEX_SOUP:Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation$AlterSoupStep;

.field public static final enum STARTING:Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation$AlterSoupStep;


# direct methods
.method static constructor <clinit>()V
    .locals 8

    .prologue
    const/4 v7, 0x4

    const/4 v6, 0x3

    const/4 v5, 0x2

    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 70
    new-instance v0, Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation$AlterSoupStep;

    const-string v1, "STARTING"

    invoke-direct {v0, v1, v3}, Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation$AlterSoupStep;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation$AlterSoupStep;->STARTING:Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation$AlterSoupStep;

    .line 71
    new-instance v0, Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation$AlterSoupStep;

    const-string v1, "RENAME_OLD_SOUP_TABLE"

    invoke-direct {v0, v1, v4}, Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation$AlterSoupStep;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation$AlterSoupStep;->RENAME_OLD_SOUP_TABLE:Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation$AlterSoupStep;

    .line 72
    new-instance v0, Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation$AlterSoupStep;

    const-string v1, "DROP_OLD_INDEXES"

    invoke-direct {v0, v1, v5}, Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation$AlterSoupStep;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation$AlterSoupStep;->DROP_OLD_INDEXES:Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation$AlterSoupStep;

    .line 73
    new-instance v0, Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation$AlterSoupStep;

    const-string v1, "REGISTER_SOUP_USING_TABLE_NAME"

    invoke-direct {v0, v1, v6}, Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation$AlterSoupStep;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation$AlterSoupStep;->REGISTER_SOUP_USING_TABLE_NAME:Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation$AlterSoupStep;

    .line 74
    new-instance v0, Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation$AlterSoupStep;

    const-string v1, "COPY_TABLE"

    invoke-direct {v0, v1, v7}, Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation$AlterSoupStep;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation$AlterSoupStep;->COPY_TABLE:Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation$AlterSoupStep;

    .line 75
    new-instance v0, Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation$AlterSoupStep;

    const-string v1, "RE_INDEX_SOUP"

    const/4 v2, 0x5

    invoke-direct {v0, v1, v2}, Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation$AlterSoupStep;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation$AlterSoupStep;->RE_INDEX_SOUP:Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation$AlterSoupStep;

    .line 76
    new-instance v0, Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation$AlterSoupStep;

    const-string v1, "DROP_OLD_TABLE"

    const/4 v2, 0x6

    invoke-direct {v0, v1, v2}, Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation$AlterSoupStep;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation$AlterSoupStep;->DROP_OLD_TABLE:Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation$AlterSoupStep;

    .line 69
    const/4 v0, 0x7

    new-array v0, v0, [Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation$AlterSoupStep;

    sget-object v1, Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation$AlterSoupStep;->STARTING:Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation$AlterSoupStep;

    aput-object v1, v0, v3

    sget-object v1, Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation$AlterSoupStep;->RENAME_OLD_SOUP_TABLE:Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation$AlterSoupStep;

    aput-object v1, v0, v4

    sget-object v1, Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation$AlterSoupStep;->DROP_OLD_INDEXES:Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation$AlterSoupStep;

    aput-object v1, v0, v5

    sget-object v1, Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation$AlterSoupStep;->REGISTER_SOUP_USING_TABLE_NAME:Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation$AlterSoupStep;

    aput-object v1, v0, v6

    sget-object v1, Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation$AlterSoupStep;->COPY_TABLE:Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation$AlterSoupStep;

    aput-object v1, v0, v7

    const/4 v1, 0x5

    sget-object v2, Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation$AlterSoupStep;->RE_INDEX_SOUP:Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation$AlterSoupStep;

    aput-object v2, v0, v1

    const/4 v1, 0x6

    sget-object v2, Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation$AlterSoupStep;->DROP_OLD_TABLE:Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation$AlterSoupStep;

    aput-object v2, v0, v1

    sput-object v0, Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation$AlterSoupStep;->$VALUES:[Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation$AlterSoupStep;

    .line 78
    sget-object v0, Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation$AlterSoupStep;->DROP_OLD_TABLE:Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation$AlterSoupStep;

    sput-object v0, Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation$AlterSoupStep;->LAST:Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation$AlterSoupStep;

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
    .line 69
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation$AlterSoupStep;
    .locals 1

    .prologue
    .line 69
    const-class v0, Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation$AlterSoupStep;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation$AlterSoupStep;

    return-object v0
.end method

.method public static values()[Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation$AlterSoupStep;
    .locals 1

    .prologue
    .line 69
    sget-object v0, Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation$AlterSoupStep;->$VALUES:[Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation$AlterSoupStep;

    invoke-virtual {v0}, [Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation$AlterSoupStep;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation$AlterSoupStep;

    return-object v0
.end method
