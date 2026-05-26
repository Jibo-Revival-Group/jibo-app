.class final enum Lcom/jibo/service/JiboFirebaseMessagingService$MessageType;
.super Ljava/lang/Enum;
.source "JiboFirebaseMessagingService.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/service/JiboFirebaseMessagingService;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4018
    name = "MessageType"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/jibo/service/JiboFirebaseMessagingService$MessageType;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/jibo/service/JiboFirebaseMessagingService$MessageType;

.field public static final enum jot_created_silent:Lcom/jibo/service/JiboFirebaseMessagingService$MessageType;

.field public static final enum jot_created_tagged:Lcom/jibo/service/JiboFirebaseMessagingService$MessageType;

.field public static final enum key_needed_silent:Lcom/jibo/service/JiboFirebaseMessagingService$MessageType;

.field public static final enum key_shared_silent:Lcom/jibo/service/JiboFirebaseMessagingService$MessageType;

.field public static final enum key_timeout_silent:Lcom/jibo/service/JiboFirebaseMessagingService$MessageType;

.field public static final enum loop_accepted:Lcom/jibo/service/JiboFirebaseMessagingService$MessageType;

.field public static final enum loop_changed_silent:Lcom/jibo/service/JiboFirebaseMessagingService$MessageType;

.field public static final enum loop_invited:Lcom/jibo/service/JiboFirebaseMessagingService$MessageType;

.field public static final enum media_created_silent:Lcom/jibo/service/JiboFirebaseMessagingService$MessageType;

.field public static final enum media_deleted_silent:Lcom/jibo/service/JiboFirebaseMessagingService$MessageType;

.field public static final enum version_installed:Lcom/jibo/service/JiboFirebaseMessagingService$MessageType;

.field public static final enum version_updated:Lcom/jibo/service/JiboFirebaseMessagingService$MessageType;


# direct methods
.method static constructor <clinit>()V
    .locals 8

    .prologue
    const/4 v7, 0x4

    const/4 v6, 0x3

    const/4 v5, 0x2

    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 52
    new-instance v0, Lcom/jibo/service/JiboFirebaseMessagingService$MessageType;

    const-string v1, "jot_created_silent"

    invoke-direct {v0, v1, v3}, Lcom/jibo/service/JiboFirebaseMessagingService$MessageType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/jibo/service/JiboFirebaseMessagingService$MessageType;->jot_created_silent:Lcom/jibo/service/JiboFirebaseMessagingService$MessageType;

    new-instance v0, Lcom/jibo/service/JiboFirebaseMessagingService$MessageType;

    const-string v1, "jot_created_tagged"

    invoke-direct {v0, v1, v4}, Lcom/jibo/service/JiboFirebaseMessagingService$MessageType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/jibo/service/JiboFirebaseMessagingService$MessageType;->jot_created_tagged:Lcom/jibo/service/JiboFirebaseMessagingService$MessageType;

    .line 53
    new-instance v0, Lcom/jibo/service/JiboFirebaseMessagingService$MessageType;

    const-string v1, "loop_changed_silent"

    invoke-direct {v0, v1, v5}, Lcom/jibo/service/JiboFirebaseMessagingService$MessageType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/jibo/service/JiboFirebaseMessagingService$MessageType;->loop_changed_silent:Lcom/jibo/service/JiboFirebaseMessagingService$MessageType;

    new-instance v0, Lcom/jibo/service/JiboFirebaseMessagingService$MessageType;

    const-string v1, "loop_invited"

    invoke-direct {v0, v1, v6}, Lcom/jibo/service/JiboFirebaseMessagingService$MessageType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/jibo/service/JiboFirebaseMessagingService$MessageType;->loop_invited:Lcom/jibo/service/JiboFirebaseMessagingService$MessageType;

    new-instance v0, Lcom/jibo/service/JiboFirebaseMessagingService$MessageType;

    const-string v1, "loop_accepted"

    invoke-direct {v0, v1, v7}, Lcom/jibo/service/JiboFirebaseMessagingService$MessageType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/jibo/service/JiboFirebaseMessagingService$MessageType;->loop_accepted:Lcom/jibo/service/JiboFirebaseMessagingService$MessageType;

    .line 54
    new-instance v0, Lcom/jibo/service/JiboFirebaseMessagingService$MessageType;

    const-string v1, "key_needed_silent"

    const/4 v2, 0x5

    invoke-direct {v0, v1, v2}, Lcom/jibo/service/JiboFirebaseMessagingService$MessageType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/jibo/service/JiboFirebaseMessagingService$MessageType;->key_needed_silent:Lcom/jibo/service/JiboFirebaseMessagingService$MessageType;

    new-instance v0, Lcom/jibo/service/JiboFirebaseMessagingService$MessageType;

    const-string v1, "key_shared_silent"

    const/4 v2, 0x6

    invoke-direct {v0, v1, v2}, Lcom/jibo/service/JiboFirebaseMessagingService$MessageType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/jibo/service/JiboFirebaseMessagingService$MessageType;->key_shared_silent:Lcom/jibo/service/JiboFirebaseMessagingService$MessageType;

    new-instance v0, Lcom/jibo/service/JiboFirebaseMessagingService$MessageType;

    const-string v1, "media_deleted_silent"

    const/4 v2, 0x7

    invoke-direct {v0, v1, v2}, Lcom/jibo/service/JiboFirebaseMessagingService$MessageType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/jibo/service/JiboFirebaseMessagingService$MessageType;->media_deleted_silent:Lcom/jibo/service/JiboFirebaseMessagingService$MessageType;

    .line 55
    new-instance v0, Lcom/jibo/service/JiboFirebaseMessagingService$MessageType;

    const-string v1, "key_timeout_silent"

    const/16 v2, 0x8

    invoke-direct {v0, v1, v2}, Lcom/jibo/service/JiboFirebaseMessagingService$MessageType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/jibo/service/JiboFirebaseMessagingService$MessageType;->key_timeout_silent:Lcom/jibo/service/JiboFirebaseMessagingService$MessageType;

    .line 56
    new-instance v0, Lcom/jibo/service/JiboFirebaseMessagingService$MessageType;

    const-string v1, "media_created_silent"

    const/16 v2, 0x9

    invoke-direct {v0, v1, v2}, Lcom/jibo/service/JiboFirebaseMessagingService$MessageType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/jibo/service/JiboFirebaseMessagingService$MessageType;->media_created_silent:Lcom/jibo/service/JiboFirebaseMessagingService$MessageType;

    .line 57
    new-instance v0, Lcom/jibo/service/JiboFirebaseMessagingService$MessageType;

    const-string v1, "version_installed"

    const/16 v2, 0xa

    invoke-direct {v0, v1, v2}, Lcom/jibo/service/JiboFirebaseMessagingService$MessageType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/jibo/service/JiboFirebaseMessagingService$MessageType;->version_installed:Lcom/jibo/service/JiboFirebaseMessagingService$MessageType;

    new-instance v0, Lcom/jibo/service/JiboFirebaseMessagingService$MessageType;

    const-string v1, "version_updated"

    const/16 v2, 0xb

    invoke-direct {v0, v1, v2}, Lcom/jibo/service/JiboFirebaseMessagingService$MessageType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/jibo/service/JiboFirebaseMessagingService$MessageType;->version_updated:Lcom/jibo/service/JiboFirebaseMessagingService$MessageType;

    .line 51
    const/16 v0, 0xc

    new-array v0, v0, [Lcom/jibo/service/JiboFirebaseMessagingService$MessageType;

    sget-object v1, Lcom/jibo/service/JiboFirebaseMessagingService$MessageType;->jot_created_silent:Lcom/jibo/service/JiboFirebaseMessagingService$MessageType;

    aput-object v1, v0, v3

    sget-object v1, Lcom/jibo/service/JiboFirebaseMessagingService$MessageType;->jot_created_tagged:Lcom/jibo/service/JiboFirebaseMessagingService$MessageType;

    aput-object v1, v0, v4

    sget-object v1, Lcom/jibo/service/JiboFirebaseMessagingService$MessageType;->loop_changed_silent:Lcom/jibo/service/JiboFirebaseMessagingService$MessageType;

    aput-object v1, v0, v5

    sget-object v1, Lcom/jibo/service/JiboFirebaseMessagingService$MessageType;->loop_invited:Lcom/jibo/service/JiboFirebaseMessagingService$MessageType;

    aput-object v1, v0, v6

    sget-object v1, Lcom/jibo/service/JiboFirebaseMessagingService$MessageType;->loop_accepted:Lcom/jibo/service/JiboFirebaseMessagingService$MessageType;

    aput-object v1, v0, v7

    const/4 v1, 0x5

    sget-object v2, Lcom/jibo/service/JiboFirebaseMessagingService$MessageType;->key_needed_silent:Lcom/jibo/service/JiboFirebaseMessagingService$MessageType;

    aput-object v2, v0, v1

    const/4 v1, 0x6

    sget-object v2, Lcom/jibo/service/JiboFirebaseMessagingService$MessageType;->key_shared_silent:Lcom/jibo/service/JiboFirebaseMessagingService$MessageType;

    aput-object v2, v0, v1

    const/4 v1, 0x7

    sget-object v2, Lcom/jibo/service/JiboFirebaseMessagingService$MessageType;->media_deleted_silent:Lcom/jibo/service/JiboFirebaseMessagingService$MessageType;

    aput-object v2, v0, v1

    const/16 v1, 0x8

    sget-object v2, Lcom/jibo/service/JiboFirebaseMessagingService$MessageType;->key_timeout_silent:Lcom/jibo/service/JiboFirebaseMessagingService$MessageType;

    aput-object v2, v0, v1

    const/16 v1, 0x9

    sget-object v2, Lcom/jibo/service/JiboFirebaseMessagingService$MessageType;->media_created_silent:Lcom/jibo/service/JiboFirebaseMessagingService$MessageType;

    aput-object v2, v0, v1

    const/16 v1, 0xa

    sget-object v2, Lcom/jibo/service/JiboFirebaseMessagingService$MessageType;->version_installed:Lcom/jibo/service/JiboFirebaseMessagingService$MessageType;

    aput-object v2, v0, v1

    const/16 v1, 0xb

    sget-object v2, Lcom/jibo/service/JiboFirebaseMessagingService$MessageType;->version_updated:Lcom/jibo/service/JiboFirebaseMessagingService$MessageType;

    aput-object v2, v0, v1

    sput-object v0, Lcom/jibo/service/JiboFirebaseMessagingService$MessageType;->$VALUES:[Lcom/jibo/service/JiboFirebaseMessagingService$MessageType;

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
    .line 51
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/jibo/service/JiboFirebaseMessagingService$MessageType;
    .locals 1

    .prologue
    .line 51
    const-class v0, Lcom/jibo/service/JiboFirebaseMessagingService$MessageType;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/jibo/service/JiboFirebaseMessagingService$MessageType;

    return-object v0
.end method

.method public static values()[Lcom/jibo/service/JiboFirebaseMessagingService$MessageType;
    .locals 1

    .prologue
    .line 51
    sget-object v0, Lcom/jibo/service/JiboFirebaseMessagingService$MessageType;->$VALUES:[Lcom/jibo/service/JiboFirebaseMessagingService$MessageType;

    invoke-virtual {v0}, [Lcom/jibo/service/JiboFirebaseMessagingService$MessageType;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/jibo/service/JiboFirebaseMessagingService$MessageType;

    return-object v0
.end method
