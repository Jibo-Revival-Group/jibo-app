.class public final enum Lcom/jibo/ui/fragment/dialog/CircleProgressFragment$Status;
.super Ljava/lang/Enum;
.source "CircleProgressFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "Status"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/jibo/ui/fragment/dialog/CircleProgressFragment$Status;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/jibo/ui/fragment/dialog/CircleProgressFragment$Status;

.field public static final enum Failure:Lcom/jibo/ui/fragment/dialog/CircleProgressFragment$Status;

.field public static final enum InProgress:Lcom/jibo/ui/fragment/dialog/CircleProgressFragment$Status;

.field public static final enum Success:Lcom/jibo/ui/fragment/dialog/CircleProgressFragment$Status;


# direct methods
.method static constructor <clinit>()V
    .locals 5

    .prologue
    const/4 v4, 0x2

    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 28
    new-instance v0, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment$Status;

    const-string v1, "InProgress"

    invoke-direct {v0, v1, v2}, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment$Status;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment$Status;->InProgress:Lcom/jibo/ui/fragment/dialog/CircleProgressFragment$Status;

    new-instance v0, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment$Status;

    const-string v1, "Success"

    invoke-direct {v0, v1, v3}, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment$Status;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment$Status;->Success:Lcom/jibo/ui/fragment/dialog/CircleProgressFragment$Status;

    new-instance v0, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment$Status;

    const-string v1, "Failure"

    invoke-direct {v0, v1, v4}, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment$Status;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment$Status;->Failure:Lcom/jibo/ui/fragment/dialog/CircleProgressFragment$Status;

    const/4 v0, 0x3

    new-array v0, v0, [Lcom/jibo/ui/fragment/dialog/CircleProgressFragment$Status;

    sget-object v1, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment$Status;->InProgress:Lcom/jibo/ui/fragment/dialog/CircleProgressFragment$Status;

    aput-object v1, v0, v2

    sget-object v1, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment$Status;->Success:Lcom/jibo/ui/fragment/dialog/CircleProgressFragment$Status;

    aput-object v1, v0, v3

    sget-object v1, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment$Status;->Failure:Lcom/jibo/ui/fragment/dialog/CircleProgressFragment$Status;

    aput-object v1, v0, v4

    sput-object v0, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment$Status;->$VALUES:[Lcom/jibo/ui/fragment/dialog/CircleProgressFragment$Status;

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
    .line 28
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/jibo/ui/fragment/dialog/CircleProgressFragment$Status;
    .locals 1

    .prologue
    .line 28
    const-class v0, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment$Status;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment$Status;

    return-object v0
.end method

.method public static values()[Lcom/jibo/ui/fragment/dialog/CircleProgressFragment$Status;
    .locals 1

    .prologue
    .line 28
    sget-object v0, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment$Status;->$VALUES:[Lcom/jibo/ui/fragment/dialog/CircleProgressFragment$Status;

    invoke-virtual {v0}, [Lcom/jibo/ui/fragment/dialog/CircleProgressFragment$Status;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/jibo/ui/fragment/dialog/CircleProgressFragment$Status;

    return-object v0
.end method
