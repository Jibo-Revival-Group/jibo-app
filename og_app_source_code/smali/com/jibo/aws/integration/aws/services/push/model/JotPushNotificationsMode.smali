.class public final enum Lcom/jibo/aws/integration/aws/services/push/model/JotPushNotificationsMode;
.super Ljava/lang/Enum;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/jibo/aws/integration/aws/services/push/model/JotPushNotificationsMode;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/jibo/aws/integration/aws/services/push/model/JotPushNotificationsMode;

.field public static final enum always:Lcom/jibo/aws/integration/aws/services/push/model/JotPushNotificationsMode;

.field public static final enum none:Lcom/jibo/aws/integration/aws/services/push/model/JotPushNotificationsMode;

.field public static final enum tagged:Lcom/jibo/aws/integration/aws/services/push/model/JotPushNotificationsMode;


# instance fields
.field private final name:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 6

    const/4 v5, 0x2

    const/4 v4, 0x1

    const/4 v3, 0x0

    new-instance v0, Lcom/jibo/aws/integration/aws/services/push/model/JotPushNotificationsMode;

    const-string v1, "always"

    const-string v2, "always"

    invoke-direct {v0, v1, v3, v2}, Lcom/jibo/aws/integration/aws/services/push/model/JotPushNotificationsMode;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/jibo/aws/integration/aws/services/push/model/JotPushNotificationsMode;->always:Lcom/jibo/aws/integration/aws/services/push/model/JotPushNotificationsMode;

    new-instance v0, Lcom/jibo/aws/integration/aws/services/push/model/JotPushNotificationsMode;

    const-string v1, "tagged"

    const-string v2, "tagged"

    invoke-direct {v0, v1, v4, v2}, Lcom/jibo/aws/integration/aws/services/push/model/JotPushNotificationsMode;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/jibo/aws/integration/aws/services/push/model/JotPushNotificationsMode;->tagged:Lcom/jibo/aws/integration/aws/services/push/model/JotPushNotificationsMode;

    new-instance v0, Lcom/jibo/aws/integration/aws/services/push/model/JotPushNotificationsMode;

    const-string v1, "none"

    const-string v2, "none"

    invoke-direct {v0, v1, v5, v2}, Lcom/jibo/aws/integration/aws/services/push/model/JotPushNotificationsMode;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/jibo/aws/integration/aws/services/push/model/JotPushNotificationsMode;->none:Lcom/jibo/aws/integration/aws/services/push/model/JotPushNotificationsMode;

    const/4 v0, 0x3

    new-array v0, v0, [Lcom/jibo/aws/integration/aws/services/push/model/JotPushNotificationsMode;

    sget-object v1, Lcom/jibo/aws/integration/aws/services/push/model/JotPushNotificationsMode;->always:Lcom/jibo/aws/integration/aws/services/push/model/JotPushNotificationsMode;

    aput-object v1, v0, v3

    sget-object v1, Lcom/jibo/aws/integration/aws/services/push/model/JotPushNotificationsMode;->tagged:Lcom/jibo/aws/integration/aws/services/push/model/JotPushNotificationsMode;

    aput-object v1, v0, v4

    sget-object v1, Lcom/jibo/aws/integration/aws/services/push/model/JotPushNotificationsMode;->none:Lcom/jibo/aws/integration/aws/services/push/model/JotPushNotificationsMode;

    aput-object v1, v0, v5

    sput-object v0, Lcom/jibo/aws/integration/aws/services/push/model/JotPushNotificationsMode;->$VALUES:[Lcom/jibo/aws/integration/aws/services/push/model/JotPushNotificationsMode;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;ILjava/lang/String;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")V"
        }
    .end annotation

    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    iput-object p3, p0, Lcom/jibo/aws/integration/aws/services/push/model/JotPushNotificationsMode;->name:Ljava/lang/String;

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/jibo/aws/integration/aws/services/push/model/JotPushNotificationsMode;
    .locals 1

    const-class v0, Lcom/jibo/aws/integration/aws/services/push/model/JotPushNotificationsMode;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/jibo/aws/integration/aws/services/push/model/JotPushNotificationsMode;

    return-object v0
.end method

.method public static values()[Lcom/jibo/aws/integration/aws/services/push/model/JotPushNotificationsMode;
    .locals 1

    sget-object v0, Lcom/jibo/aws/integration/aws/services/push/model/JotPushNotificationsMode;->$VALUES:[Lcom/jibo/aws/integration/aws/services/push/model/JotPushNotificationsMode;

    invoke-virtual {v0}, [Lcom/jibo/aws/integration/aws/services/push/model/JotPushNotificationsMode;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/jibo/aws/integration/aws/services/push/model/JotPushNotificationsMode;

    return-object v0
.end method


# virtual methods
.method public getName()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/jibo/aws/integration/aws/services/push/model/JotPushNotificationsMode;->name:Ljava/lang/String;

    return-object v0
.end method
