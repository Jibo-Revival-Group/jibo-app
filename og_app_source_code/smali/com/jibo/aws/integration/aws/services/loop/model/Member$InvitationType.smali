.class public final enum Lcom/jibo/aws/integration/aws/services/loop/model/Member$InvitationType;
.super Ljava/lang/Enum;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/aws/integration/aws/services/loop/model/Member;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "InvitationType"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/jibo/aws/integration/aws/services/loop/model/Member$InvitationType;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/jibo/aws/integration/aws/services/loop/model/Member$InvitationType;

.field public static final enum incoming:Lcom/jibo/aws/integration/aws/services/loop/model/Member$InvitationType;

.field public static final enum outgoing:Lcom/jibo/aws/integration/aws/services/loop/model/Member$InvitationType;


# direct methods
.method static constructor <clinit>()V
    .locals 4

    const/4 v3, 0x1

    const/4 v2, 0x0

    new-instance v0, Lcom/jibo/aws/integration/aws/services/loop/model/Member$InvitationType;

    const-string v1, "incoming"

    invoke-direct {v0, v1, v2}, Lcom/jibo/aws/integration/aws/services/loop/model/Member$InvitationType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/jibo/aws/integration/aws/services/loop/model/Member$InvitationType;->incoming:Lcom/jibo/aws/integration/aws/services/loop/model/Member$InvitationType;

    new-instance v0, Lcom/jibo/aws/integration/aws/services/loop/model/Member$InvitationType;

    const-string v1, "outgoing"

    invoke-direct {v0, v1, v3}, Lcom/jibo/aws/integration/aws/services/loop/model/Member$InvitationType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/jibo/aws/integration/aws/services/loop/model/Member$InvitationType;->outgoing:Lcom/jibo/aws/integration/aws/services/loop/model/Member$InvitationType;

    const/4 v0, 0x2

    new-array v0, v0, [Lcom/jibo/aws/integration/aws/services/loop/model/Member$InvitationType;

    sget-object v1, Lcom/jibo/aws/integration/aws/services/loop/model/Member$InvitationType;->incoming:Lcom/jibo/aws/integration/aws/services/loop/model/Member$InvitationType;

    aput-object v1, v0, v2

    sget-object v1, Lcom/jibo/aws/integration/aws/services/loop/model/Member$InvitationType;->outgoing:Lcom/jibo/aws/integration/aws/services/loop/model/Member$InvitationType;

    aput-object v1, v0, v3

    sput-object v0, Lcom/jibo/aws/integration/aws/services/loop/model/Member$InvitationType;->$VALUES:[Lcom/jibo/aws/integration/aws/services/loop/model/Member$InvitationType;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;I)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()V"
        }
    .end annotation

    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/jibo/aws/integration/aws/services/loop/model/Member$InvitationType;
    .locals 1

    const-class v0, Lcom/jibo/aws/integration/aws/services/loop/model/Member$InvitationType;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/jibo/aws/integration/aws/services/loop/model/Member$InvitationType;

    return-object v0
.end method

.method public static values()[Lcom/jibo/aws/integration/aws/services/loop/model/Member$InvitationType;
    .locals 1

    sget-object v0, Lcom/jibo/aws/integration/aws/services/loop/model/Member$InvitationType;->$VALUES:[Lcom/jibo/aws/integration/aws/services/loop/model/Member$InvitationType;

    invoke-virtual {v0}, [Lcom/jibo/aws/integration/aws/services/loop/model/Member$InvitationType;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/jibo/aws/integration/aws/services/loop/model/Member$InvitationType;

    return-object v0
.end method
