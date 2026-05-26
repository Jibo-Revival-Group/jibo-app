.class public final enum Lcom/salesforce/androidsdk/ui/PasscodeActivity$PasscodeMode;
.super Ljava/lang/Enum;
.source "PasscodeActivity.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/salesforce/androidsdk/ui/PasscodeActivity;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "PasscodeMode"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/salesforce/androidsdk/ui/PasscodeActivity$PasscodeMode;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/salesforce/androidsdk/ui/PasscodeActivity$PasscodeMode;

.field public static final enum Change:Lcom/salesforce/androidsdk/ui/PasscodeActivity$PasscodeMode;

.field public static final enum Check:Lcom/salesforce/androidsdk/ui/PasscodeActivity$PasscodeMode;

.field public static final enum Create:Lcom/salesforce/androidsdk/ui/PasscodeActivity$PasscodeMode;

.field public static final enum CreateConfirm:Lcom/salesforce/androidsdk/ui/PasscodeActivity$PasscodeMode;


# direct methods
.method static constructor <clinit>()V
    .locals 6

    .prologue
    const/4 v5, 0x3

    const/4 v4, 0x2

    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 83
    new-instance v0, Lcom/salesforce/androidsdk/ui/PasscodeActivity$PasscodeMode;

    const-string v1, "Create"

    invoke-direct {v0, v1, v2}, Lcom/salesforce/androidsdk/ui/PasscodeActivity$PasscodeMode;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/salesforce/androidsdk/ui/PasscodeActivity$PasscodeMode;->Create:Lcom/salesforce/androidsdk/ui/PasscodeActivity$PasscodeMode;

    .line 84
    new-instance v0, Lcom/salesforce/androidsdk/ui/PasscodeActivity$PasscodeMode;

    const-string v1, "CreateConfirm"

    invoke-direct {v0, v1, v3}, Lcom/salesforce/androidsdk/ui/PasscodeActivity$PasscodeMode;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/salesforce/androidsdk/ui/PasscodeActivity$PasscodeMode;->CreateConfirm:Lcom/salesforce/androidsdk/ui/PasscodeActivity$PasscodeMode;

    .line 85
    new-instance v0, Lcom/salesforce/androidsdk/ui/PasscodeActivity$PasscodeMode;

    const-string v1, "Check"

    invoke-direct {v0, v1, v4}, Lcom/salesforce/androidsdk/ui/PasscodeActivity$PasscodeMode;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/salesforce/androidsdk/ui/PasscodeActivity$PasscodeMode;->Check:Lcom/salesforce/androidsdk/ui/PasscodeActivity$PasscodeMode;

    .line 86
    new-instance v0, Lcom/salesforce/androidsdk/ui/PasscodeActivity$PasscodeMode;

    const-string v1, "Change"

    invoke-direct {v0, v1, v5}, Lcom/salesforce/androidsdk/ui/PasscodeActivity$PasscodeMode;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/salesforce/androidsdk/ui/PasscodeActivity$PasscodeMode;->Change:Lcom/salesforce/androidsdk/ui/PasscodeActivity$PasscodeMode;

    .line 82
    const/4 v0, 0x4

    new-array v0, v0, [Lcom/salesforce/androidsdk/ui/PasscodeActivity$PasscodeMode;

    sget-object v1, Lcom/salesforce/androidsdk/ui/PasscodeActivity$PasscodeMode;->Create:Lcom/salesforce/androidsdk/ui/PasscodeActivity$PasscodeMode;

    aput-object v1, v0, v2

    sget-object v1, Lcom/salesforce/androidsdk/ui/PasscodeActivity$PasscodeMode;->CreateConfirm:Lcom/salesforce/androidsdk/ui/PasscodeActivity$PasscodeMode;

    aput-object v1, v0, v3

    sget-object v1, Lcom/salesforce/androidsdk/ui/PasscodeActivity$PasscodeMode;->Check:Lcom/salesforce/androidsdk/ui/PasscodeActivity$PasscodeMode;

    aput-object v1, v0, v4

    sget-object v1, Lcom/salesforce/androidsdk/ui/PasscodeActivity$PasscodeMode;->Change:Lcom/salesforce/androidsdk/ui/PasscodeActivity$PasscodeMode;

    aput-object v1, v0, v5

    sput-object v0, Lcom/salesforce/androidsdk/ui/PasscodeActivity$PasscodeMode;->$VALUES:[Lcom/salesforce/androidsdk/ui/PasscodeActivity$PasscodeMode;

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
    .line 82
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/salesforce/androidsdk/ui/PasscodeActivity$PasscodeMode;
    .locals 1

    .prologue
    .line 82
    const-class v0, Lcom/salesforce/androidsdk/ui/PasscodeActivity$PasscodeMode;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/salesforce/androidsdk/ui/PasscodeActivity$PasscodeMode;

    return-object v0
.end method

.method public static values()[Lcom/salesforce/androidsdk/ui/PasscodeActivity$PasscodeMode;
    .locals 1

    .prologue
    .line 82
    sget-object v0, Lcom/salesforce/androidsdk/ui/PasscodeActivity$PasscodeMode;->$VALUES:[Lcom/salesforce/androidsdk/ui/PasscodeActivity$PasscodeMode;

    invoke-virtual {v0}, [Lcom/salesforce/androidsdk/ui/PasscodeActivity$PasscodeMode;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/salesforce/androidsdk/ui/PasscodeActivity$PasscodeMode;

    return-object v0
.end method
