.class public abstract enum Lcom/salesforce/androidsdk/smartstore/store/SmartStore$TypeGroup;
.super Ljava/lang/Enum;
.source "SmartStore.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/salesforce/androidsdk/smartstore/store/SmartStore;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4409
    name = "TypeGroup"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/salesforce/androidsdk/smartstore/store/SmartStore$TypeGroup;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/salesforce/androidsdk/smartstore/store/SmartStore$TypeGroup;

.field public static final enum value_extracted_to_column:Lcom/salesforce/androidsdk/smartstore/store/SmartStore$TypeGroup;

.field public static final enum value_extracted_to_fts_column:Lcom/salesforce/androidsdk/smartstore/store/SmartStore$TypeGroup;

.field public static final enum value_indexed_with_json_extract:Lcom/salesforce/androidsdk/smartstore/store/SmartStore$TypeGroup;


# direct methods
.method static constructor <clinit>()V
    .locals 5

    .prologue
    const/4 v4, 0x2

    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 1529
    new-instance v0, Lcom/salesforce/androidsdk/smartstore/store/SmartStore$TypeGroup$1;

    const-string v1, "value_extracted_to_column"

    invoke-direct {v0, v1, v2}, Lcom/salesforce/androidsdk/smartstore/store/SmartStore$TypeGroup$1;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/salesforce/androidsdk/smartstore/store/SmartStore$TypeGroup;->value_extracted_to_column:Lcom/salesforce/androidsdk/smartstore/store/SmartStore$TypeGroup;

    .line 1535
    new-instance v0, Lcom/salesforce/androidsdk/smartstore/store/SmartStore$TypeGroup$2;

    const-string v1, "value_extracted_to_fts_column"

    invoke-direct {v0, v1, v3}, Lcom/salesforce/androidsdk/smartstore/store/SmartStore$TypeGroup$2;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/salesforce/androidsdk/smartstore/store/SmartStore$TypeGroup;->value_extracted_to_fts_column:Lcom/salesforce/androidsdk/smartstore/store/SmartStore$TypeGroup;

    .line 1541
    new-instance v0, Lcom/salesforce/androidsdk/smartstore/store/SmartStore$TypeGroup$3;

    const-string v1, "value_indexed_with_json_extract"

    invoke-direct {v0, v1, v4}, Lcom/salesforce/androidsdk/smartstore/store/SmartStore$TypeGroup$3;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/salesforce/androidsdk/smartstore/store/SmartStore$TypeGroup;->value_indexed_with_json_extract:Lcom/salesforce/androidsdk/smartstore/store/SmartStore$TypeGroup;

    .line 1528
    const/4 v0, 0x3

    new-array v0, v0, [Lcom/salesforce/androidsdk/smartstore/store/SmartStore$TypeGroup;

    sget-object v1, Lcom/salesforce/androidsdk/smartstore/store/SmartStore$TypeGroup;->value_extracted_to_column:Lcom/salesforce/androidsdk/smartstore/store/SmartStore$TypeGroup;

    aput-object v1, v0, v2

    sget-object v1, Lcom/salesforce/androidsdk/smartstore/store/SmartStore$TypeGroup;->value_extracted_to_fts_column:Lcom/salesforce/androidsdk/smartstore/store/SmartStore$TypeGroup;

    aput-object v1, v0, v3

    sget-object v1, Lcom/salesforce/androidsdk/smartstore/store/SmartStore$TypeGroup;->value_indexed_with_json_extract:Lcom/salesforce/androidsdk/smartstore/store/SmartStore$TypeGroup;

    aput-object v1, v0, v4

    sput-object v0, Lcom/salesforce/androidsdk/smartstore/store/SmartStore$TypeGroup;->$VALUES:[Lcom/salesforce/androidsdk/smartstore/store/SmartStore$TypeGroup;

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
    .line 1528
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method synthetic constructor <init>(Ljava/lang/String;ILcom/salesforce/androidsdk/smartstore/store/SmartStore$1;)V
    .locals 0

    .prologue
    .line 1528
    invoke-direct {p0, p1, p2}, Lcom/salesforce/androidsdk/smartstore/store/SmartStore$TypeGroup;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/salesforce/androidsdk/smartstore/store/SmartStore$TypeGroup;
    .locals 1

    .prologue
    .line 1528
    const-class v0, Lcom/salesforce/androidsdk/smartstore/store/SmartStore$TypeGroup;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/salesforce/androidsdk/smartstore/store/SmartStore$TypeGroup;

    return-object v0
.end method

.method public static values()[Lcom/salesforce/androidsdk/smartstore/store/SmartStore$TypeGroup;
    .locals 1

    .prologue
    .line 1528
    sget-object v0, Lcom/salesforce/androidsdk/smartstore/store/SmartStore$TypeGroup;->$VALUES:[Lcom/salesforce/androidsdk/smartstore/store/SmartStore$TypeGroup;

    invoke-virtual {v0}, [Lcom/salesforce/androidsdk/smartstore/store/SmartStore$TypeGroup;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/salesforce/androidsdk/smartstore/store/SmartStore$TypeGroup;

    return-object v0
.end method


# virtual methods
.method public abstract isMember(Lcom/salesforce/androidsdk/smartstore/store/SmartStore$Type;)Z
.end method
