.class public final enum Lcom/jibo/ui/activity/WifiActivity$Mode;
.super Ljava/lang/Enum;
.source "WifiActivity.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/ui/activity/WifiActivity;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "Mode"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/jibo/ui/activity/WifiActivity$Mode;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/jibo/ui/activity/WifiActivity$Mode;

.field public static final enum INIT:Lcom/jibo/ui/activity/WifiActivity$Mode;

.field public static final enum INIT_OR_RECONNECT:Lcom/jibo/ui/activity/WifiActivity$Mode;

.field public static final enum RECONNECT:Lcom/jibo/ui/activity/WifiActivity$Mode;

.field public static final enum RECONNECT_SUSPENDED:Lcom/jibo/ui/activity/WifiActivity$Mode;


# direct methods
.method static constructor <clinit>()V
    .locals 6

    .prologue
    const/4 v5, 0x3

    const/4 v4, 0x2

    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 36
    new-instance v0, Lcom/jibo/ui/activity/WifiActivity$Mode;

    const-string v1, "INIT_OR_RECONNECT"

    invoke-direct {v0, v1, v2}, Lcom/jibo/ui/activity/WifiActivity$Mode;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/jibo/ui/activity/WifiActivity$Mode;->INIT_OR_RECONNECT:Lcom/jibo/ui/activity/WifiActivity$Mode;

    new-instance v0, Lcom/jibo/ui/activity/WifiActivity$Mode;

    const-string v1, "INIT"

    invoke-direct {v0, v1, v3}, Lcom/jibo/ui/activity/WifiActivity$Mode;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/jibo/ui/activity/WifiActivity$Mode;->INIT:Lcom/jibo/ui/activity/WifiActivity$Mode;

    new-instance v0, Lcom/jibo/ui/activity/WifiActivity$Mode;

    const-string v1, "RECONNECT"

    invoke-direct {v0, v1, v4}, Lcom/jibo/ui/activity/WifiActivity$Mode;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/jibo/ui/activity/WifiActivity$Mode;->RECONNECT:Lcom/jibo/ui/activity/WifiActivity$Mode;

    new-instance v0, Lcom/jibo/ui/activity/WifiActivity$Mode;

    const-string v1, "RECONNECT_SUSPENDED"

    invoke-direct {v0, v1, v5}, Lcom/jibo/ui/activity/WifiActivity$Mode;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/jibo/ui/activity/WifiActivity$Mode;->RECONNECT_SUSPENDED:Lcom/jibo/ui/activity/WifiActivity$Mode;

    .line 35
    const/4 v0, 0x4

    new-array v0, v0, [Lcom/jibo/ui/activity/WifiActivity$Mode;

    sget-object v1, Lcom/jibo/ui/activity/WifiActivity$Mode;->INIT_OR_RECONNECT:Lcom/jibo/ui/activity/WifiActivity$Mode;

    aput-object v1, v0, v2

    sget-object v1, Lcom/jibo/ui/activity/WifiActivity$Mode;->INIT:Lcom/jibo/ui/activity/WifiActivity$Mode;

    aput-object v1, v0, v3

    sget-object v1, Lcom/jibo/ui/activity/WifiActivity$Mode;->RECONNECT:Lcom/jibo/ui/activity/WifiActivity$Mode;

    aput-object v1, v0, v4

    sget-object v1, Lcom/jibo/ui/activity/WifiActivity$Mode;->RECONNECT_SUSPENDED:Lcom/jibo/ui/activity/WifiActivity$Mode;

    aput-object v1, v0, v5

    sput-object v0, Lcom/jibo/ui/activity/WifiActivity$Mode;->$VALUES:[Lcom/jibo/ui/activity/WifiActivity$Mode;

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
    .line 35
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/jibo/ui/activity/WifiActivity$Mode;
    .locals 1

    .prologue
    .line 35
    const-class v0, Lcom/jibo/ui/activity/WifiActivity$Mode;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/activity/WifiActivity$Mode;

    return-object v0
.end method

.method public static values()[Lcom/jibo/ui/activity/WifiActivity$Mode;
    .locals 1

    .prologue
    .line 35
    sget-object v0, Lcom/jibo/ui/activity/WifiActivity$Mode;->$VALUES:[Lcom/jibo/ui/activity/WifiActivity$Mode;

    invoke-virtual {v0}, [Lcom/jibo/ui/activity/WifiActivity$Mode;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/jibo/ui/activity/WifiActivity$Mode;

    return-object v0
.end method
