.class public final enum Lcom/jibo/aws/integration/aws/services/loop/model/Member$InvitationStatus;
.super Ljava/lang/Enum;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/aws/integration/aws/services/loop/model/Member;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "InvitationStatus"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/jibo/aws/integration/aws/services/loop/model/Member$InvitationStatus;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/jibo/aws/integration/aws/services/loop/model/Member$InvitationStatus;

.field public static final enum accepted:Lcom/jibo/aws/integration/aws/services/loop/model/Member$InvitationStatus;

.field public static final enum declined:Lcom/jibo/aws/integration/aws/services/loop/model/Member$InvitationStatus;

.field public static final enum invited:Lcom/jibo/aws/integration/aws/services/loop/model/Member$InvitationStatus;

.field public static final enum removed:Lcom/jibo/aws/integration/aws/services/loop/model/Member$InvitationStatus;


# direct methods
.method static constructor <clinit>()V
    .locals 6

    const/4 v5, 0x3

    const/4 v4, 0x2

    const/4 v3, 0x1

    const/4 v2, 0x0

    new-instance v0, Lcom/jibo/aws/integration/aws/services/loop/model/Member$InvitationStatus;

    const-string v1, "invited"

    invoke-direct {v0, v1, v2}, Lcom/jibo/aws/integration/aws/services/loop/model/Member$InvitationStatus;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/jibo/aws/integration/aws/services/loop/model/Member$InvitationStatus;->invited:Lcom/jibo/aws/integration/aws/services/loop/model/Member$InvitationStatus;

    new-instance v0, Lcom/jibo/aws/integration/aws/services/loop/model/Member$InvitationStatus;

    const-string v1, "accepted"

    invoke-direct {v0, v1, v3}, Lcom/jibo/aws/integration/aws/services/loop/model/Member$InvitationStatus;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/jibo/aws/integration/aws/services/loop/model/Member$InvitationStatus;->accepted:Lcom/jibo/aws/integration/aws/services/loop/model/Member$InvitationStatus;

    new-instance v0, Lcom/jibo/aws/integration/aws/services/loop/model/Member$InvitationStatus;

    const-string v1, "declined"

    invoke-direct {v0, v1, v4}, Lcom/jibo/aws/integration/aws/services/loop/model/Member$InvitationStatus;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/jibo/aws/integration/aws/services/loop/model/Member$InvitationStatus;->declined:Lcom/jibo/aws/integration/aws/services/loop/model/Member$InvitationStatus;

    new-instance v0, Lcom/jibo/aws/integration/aws/services/loop/model/Member$InvitationStatus;

    const-string v1, "removed"

    invoke-direct {v0, v1, v5}, Lcom/jibo/aws/integration/aws/services/loop/model/Member$InvitationStatus;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/jibo/aws/integration/aws/services/loop/model/Member$InvitationStatus;->removed:Lcom/jibo/aws/integration/aws/services/loop/model/Member$InvitationStatus;

    const/4 v0, 0x4

    new-array v0, v0, [Lcom/jibo/aws/integration/aws/services/loop/model/Member$InvitationStatus;

    sget-object v1, Lcom/jibo/aws/integration/aws/services/loop/model/Member$InvitationStatus;->invited:Lcom/jibo/aws/integration/aws/services/loop/model/Member$InvitationStatus;

    aput-object v1, v0, v2

    sget-object v1, Lcom/jibo/aws/integration/aws/services/loop/model/Member$InvitationStatus;->accepted:Lcom/jibo/aws/integration/aws/services/loop/model/Member$InvitationStatus;

    aput-object v1, v0, v3

    sget-object v1, Lcom/jibo/aws/integration/aws/services/loop/model/Member$InvitationStatus;->declined:Lcom/jibo/aws/integration/aws/services/loop/model/Member$InvitationStatus;

    aput-object v1, v0, v4

    sget-object v1, Lcom/jibo/aws/integration/aws/services/loop/model/Member$InvitationStatus;->removed:Lcom/jibo/aws/integration/aws/services/loop/model/Member$InvitationStatus;

    aput-object v1, v0, v5

    sput-object v0, Lcom/jibo/aws/integration/aws/services/loop/model/Member$InvitationStatus;->$VALUES:[Lcom/jibo/aws/integration/aws/services/loop/model/Member$InvitationStatus;

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

.method public static valueOf(Ljava/lang/String;)Lcom/jibo/aws/integration/aws/services/loop/model/Member$InvitationStatus;
    .locals 1

    const-class v0, Lcom/jibo/aws/integration/aws/services/loop/model/Member$InvitationStatus;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/jibo/aws/integration/aws/services/loop/model/Member$InvitationStatus;

    return-object v0
.end method

.method public static values()[Lcom/jibo/aws/integration/aws/services/loop/model/Member$InvitationStatus;
    .locals 1

    sget-object v0, Lcom/jibo/aws/integration/aws/services/loop/model/Member$InvitationStatus;->$VALUES:[Lcom/jibo/aws/integration/aws/services/loop/model/Member$InvitationStatus;

    invoke-virtual {v0}, [Lcom/jibo/aws/integration/aws/services/loop/model/Member$InvitationStatus;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/jibo/aws/integration/aws/services/loop/model/Member$InvitationStatus;

    return-object v0
.end method
