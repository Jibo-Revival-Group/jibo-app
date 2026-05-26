.class public final enum Lcom/salesforce/android/cases/core/model/CaseFieldType;
.super Ljava/lang/Enum;
.source "CaseFieldType.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/salesforce/android/cases/core/model/CaseFieldType;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/salesforce/android/cases/core/model/CaseFieldType;

.field public static final enum EMAIL:Lcom/salesforce/android/cases/core/model/CaseFieldType;

.field public static final enum PICK_LIST:Lcom/salesforce/android/cases/core/model/CaseFieldType;

.field public static final enum TEXT:Lcom/salesforce/android/cases/core/model/CaseFieldType;

.field public static final enum TEXT_AREA:Lcom/salesforce/android/cases/core/model/CaseFieldType;

.field public static final enum UNKNOWN:Lcom/salesforce/android/cases/core/model/CaseFieldType;


# instance fields
.field final textField:Z


# direct methods
.method static constructor <clinit>()V
    .locals 7

    .prologue
    const/4 v6, 0x4

    const/4 v5, 0x3

    const/4 v4, 0x2

    const/4 v3, 0x0

    const/4 v2, 0x1

    .line 28
    new-instance v0, Lcom/salesforce/android/cases/core/model/CaseFieldType;

    const-string v1, "UNKNOWN"

    invoke-direct {v0, v1, v3, v3}, Lcom/salesforce/android/cases/core/model/CaseFieldType;-><init>(Ljava/lang/String;IZ)V

    sput-object v0, Lcom/salesforce/android/cases/core/model/CaseFieldType;->UNKNOWN:Lcom/salesforce/android/cases/core/model/CaseFieldType;

    .line 29
    new-instance v0, Lcom/salesforce/android/cases/core/model/CaseFieldType;

    const-string v1, "TEXT"

    invoke-direct {v0, v1, v2, v2}, Lcom/salesforce/android/cases/core/model/CaseFieldType;-><init>(Ljava/lang/String;IZ)V

    sput-object v0, Lcom/salesforce/android/cases/core/model/CaseFieldType;->TEXT:Lcom/salesforce/android/cases/core/model/CaseFieldType;

    .line 30
    new-instance v0, Lcom/salesforce/android/cases/core/model/CaseFieldType;

    const-string v1, "EMAIL"

    invoke-direct {v0, v1, v4, v2}, Lcom/salesforce/android/cases/core/model/CaseFieldType;-><init>(Ljava/lang/String;IZ)V

    sput-object v0, Lcom/salesforce/android/cases/core/model/CaseFieldType;->EMAIL:Lcom/salesforce/android/cases/core/model/CaseFieldType;

    .line 31
    new-instance v0, Lcom/salesforce/android/cases/core/model/CaseFieldType;

    const-string v1, "TEXT_AREA"

    invoke-direct {v0, v1, v5, v2}, Lcom/salesforce/android/cases/core/model/CaseFieldType;-><init>(Ljava/lang/String;IZ)V

    sput-object v0, Lcom/salesforce/android/cases/core/model/CaseFieldType;->TEXT_AREA:Lcom/salesforce/android/cases/core/model/CaseFieldType;

    .line 32
    new-instance v0, Lcom/salesforce/android/cases/core/model/CaseFieldType;

    const-string v1, "PICK_LIST"

    invoke-direct {v0, v1, v6, v3}, Lcom/salesforce/android/cases/core/model/CaseFieldType;-><init>(Ljava/lang/String;IZ)V

    sput-object v0, Lcom/salesforce/android/cases/core/model/CaseFieldType;->PICK_LIST:Lcom/salesforce/android/cases/core/model/CaseFieldType;

    .line 27
    const/4 v0, 0x5

    new-array v0, v0, [Lcom/salesforce/android/cases/core/model/CaseFieldType;

    sget-object v1, Lcom/salesforce/android/cases/core/model/CaseFieldType;->UNKNOWN:Lcom/salesforce/android/cases/core/model/CaseFieldType;

    aput-object v1, v0, v3

    sget-object v1, Lcom/salesforce/android/cases/core/model/CaseFieldType;->TEXT:Lcom/salesforce/android/cases/core/model/CaseFieldType;

    aput-object v1, v0, v2

    sget-object v1, Lcom/salesforce/android/cases/core/model/CaseFieldType;->EMAIL:Lcom/salesforce/android/cases/core/model/CaseFieldType;

    aput-object v1, v0, v4

    sget-object v1, Lcom/salesforce/android/cases/core/model/CaseFieldType;->TEXT_AREA:Lcom/salesforce/android/cases/core/model/CaseFieldType;

    aput-object v1, v0, v5

    sget-object v1, Lcom/salesforce/android/cases/core/model/CaseFieldType;->PICK_LIST:Lcom/salesforce/android/cases/core/model/CaseFieldType;

    aput-object v1, v0, v6

    sput-object v0, Lcom/salesforce/android/cases/core/model/CaseFieldType;->$VALUES:[Lcom/salesforce/android/cases/core/model/CaseFieldType;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;IZ)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(Z)V"
        }
    .end annotation

    .prologue
    .line 36
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    .line 37
    iput-boolean p3, p0, Lcom/salesforce/android/cases/core/model/CaseFieldType;->textField:Z

    .line 38
    return-void
.end method

.method public static fromString(Ljava/lang/String;)Lcom/salesforce/android/cases/core/model/CaseFieldType;
    .locals 2

    .prologue
    .line 47
    const/4 v0, -0x1

    invoke-virtual {p0}, Ljava/lang/String;->hashCode()I

    move-result v1

    sparse-switch v1, :sswitch_data_0

    :cond_0
    :goto_0
    packed-switch v0, :pswitch_data_0

    .line 57
    sget-object v0, Lcom/salesforce/android/cases/core/model/CaseFieldType;->UNKNOWN:Lcom/salesforce/android/cases/core/model/CaseFieldType;

    :goto_1
    return-object v0

    .line 47
    :sswitch_0
    const-string v1, "string"

    invoke-virtual {p0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    const/4 v0, 0x0

    goto :goto_0

    :sswitch_1
    const-string v1, "textarea"

    invoke-virtual {p0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    const/4 v0, 0x1

    goto :goto_0

    :sswitch_2
    const-string v1, "email"

    invoke-virtual {p0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    const/4 v0, 0x2

    goto :goto_0

    :sswitch_3
    const-string v1, "picklist"

    invoke-virtual {p0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    const/4 v0, 0x3

    goto :goto_0

    .line 49
    :pswitch_0
    sget-object v0, Lcom/salesforce/android/cases/core/model/CaseFieldType;->TEXT:Lcom/salesforce/android/cases/core/model/CaseFieldType;

    goto :goto_1

    .line 51
    :pswitch_1
    sget-object v0, Lcom/salesforce/android/cases/core/model/CaseFieldType;->TEXT_AREA:Lcom/salesforce/android/cases/core/model/CaseFieldType;

    goto :goto_1

    .line 53
    :pswitch_2
    sget-object v0, Lcom/salesforce/android/cases/core/model/CaseFieldType;->EMAIL:Lcom/salesforce/android/cases/core/model/CaseFieldType;

    goto :goto_1

    .line 55
    :pswitch_3
    sget-object v0, Lcom/salesforce/android/cases/core/model/CaseFieldType;->PICK_LIST:Lcom/salesforce/android/cases/core/model/CaseFieldType;

    goto :goto_1

    .line 47
    :sswitch_data_0
    .sparse-switch
        -0x3bcc48c6 -> :sswitch_1
        -0x352a9fef -> :sswitch_0
        -0x2c07c7c1 -> :sswitch_3
        0x5c24b9c -> :sswitch_2
    .end sparse-switch

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
    .end packed-switch
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/salesforce/android/cases/core/model/CaseFieldType;
    .locals 1

    .prologue
    .line 27
    const-class v0, Lcom/salesforce/android/cases/core/model/CaseFieldType;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/salesforce/android/cases/core/model/CaseFieldType;

    return-object v0
.end method

.method public static values()[Lcom/salesforce/android/cases/core/model/CaseFieldType;
    .locals 1

    .prologue
    .line 27
    sget-object v0, Lcom/salesforce/android/cases/core/model/CaseFieldType;->$VALUES:[Lcom/salesforce/android/cases/core/model/CaseFieldType;

    invoke-virtual {v0}, [Lcom/salesforce/android/cases/core/model/CaseFieldType;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/salesforce/android/cases/core/model/CaseFieldType;

    return-object v0
.end method


# virtual methods
.method public isTextField()Z
    .locals 1

    .prologue
    .line 67
    iget-boolean v0, p0, Lcom/salesforce/android/cases/core/model/CaseFieldType;->textField:Z

    return v0
.end method
