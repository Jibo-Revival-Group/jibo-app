.class public final enum Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$DialogType;
.super Ljava/lang/Enum;
.source "LoopPassphraseUtils.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "DialogType"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$DialogType;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$DialogType;

.field public static final enum FIRST_TIME:Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$DialogType;

.field public static final enum FROM_SETTINGS:Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$DialogType;

.field public static final enum MEDIA_ADDED:Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$DialogType;

.field public static final enum NO_BACKUP_BY_TIMEOUT:Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$DialogType;

.field public static final enum ON_CANCEL:Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$DialogType;

.field public static final enum ON_RECONNECT_TO_JIBO:Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$DialogType;

.field public static final enum ON_RECONNECT_TO_JIBO_NO_BACKUP:Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$DialogType;

.field public static final enum ON_SET:Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$DialogType;

.field public static final enum RESTORE:Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$DialogType;

.field public static final enum RESTORE_BY_TIMEOUT:Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$DialogType;

.field public static final enum WEEK_AFTER:Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$DialogType;


# instance fields
.field private final name:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 9

    .prologue
    const/4 v8, 0x4

    const/4 v7, 0x3

    const/4 v6, 0x2

    const/4 v5, 0x1

    const/4 v4, 0x0

    .line 108
    new-instance v0, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$DialogType;

    const-string v1, "FIRST_TIME"

    const-string v2, "FIRST_TIME"

    invoke-direct {v0, v1, v4, v2}, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$DialogType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$DialogType;->FIRST_TIME:Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$DialogType;

    .line 109
    new-instance v0, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$DialogType;

    const-string v1, "MEDIA_ADDED"

    const-string v2, "MEDIA_ADDED"

    invoke-direct {v0, v1, v5, v2}, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$DialogType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$DialogType;->MEDIA_ADDED:Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$DialogType;

    .line 110
    new-instance v0, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$DialogType;

    const-string v1, "WEEK_AFTER"

    const-string v2, "WEEK_AFTER"

    invoke-direct {v0, v1, v6, v2}, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$DialogType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$DialogType;->WEEK_AFTER:Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$DialogType;

    .line 111
    new-instance v0, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$DialogType;

    const-string v1, "FROM_SETTINGS"

    const-string v2, "FROM_SETTINGS"

    invoke-direct {v0, v1, v7, v2}, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$DialogType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$DialogType;->FROM_SETTINGS:Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$DialogType;

    .line 112
    new-instance v0, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$DialogType;

    const-string v1, "ON_RECONNECT_TO_JIBO"

    const-string v2, "ON_RECONNECT_TO_JIBO"

    invoke-direct {v0, v1, v8, v2}, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$DialogType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$DialogType;->ON_RECONNECT_TO_JIBO:Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$DialogType;

    .line 113
    new-instance v0, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$DialogType;

    const-string v1, "ON_RECONNECT_TO_JIBO_NO_BACKUP"

    const/4 v2, 0x5

    const-string v3, "ON_RECONNECT_TO_JIBO_NO_BACKUP"

    invoke-direct {v0, v1, v2, v3}, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$DialogType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$DialogType;->ON_RECONNECT_TO_JIBO_NO_BACKUP:Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$DialogType;

    .line 114
    new-instance v0, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$DialogType;

    const-string v1, "ON_CANCEL"

    const/4 v2, 0x6

    const-string v3, "ON_CANCEL"

    invoke-direct {v0, v1, v2, v3}, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$DialogType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$DialogType;->ON_CANCEL:Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$DialogType;

    .line 115
    new-instance v0, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$DialogType;

    const-string v1, "ON_SET"

    const/4 v2, 0x7

    const-string v3, "ON_SET"

    invoke-direct {v0, v1, v2, v3}, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$DialogType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$DialogType;->ON_SET:Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$DialogType;

    .line 116
    new-instance v0, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$DialogType;

    const-string v1, "RESTORE"

    const/16 v2, 0x8

    const-string v3, "RESTORE"

    invoke-direct {v0, v1, v2, v3}, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$DialogType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$DialogType;->RESTORE:Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$DialogType;

    .line 117
    new-instance v0, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$DialogType;

    const-string v1, "RESTORE_BY_TIMEOUT"

    const/16 v2, 0x9

    const-string v3, "RESTORE_BY_TIMEOUT"

    invoke-direct {v0, v1, v2, v3}, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$DialogType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$DialogType;->RESTORE_BY_TIMEOUT:Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$DialogType;

    .line 118
    new-instance v0, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$DialogType;

    const-string v1, "NO_BACKUP_BY_TIMEOUT"

    const/16 v2, 0xa

    const-string v3, "NO_BACKUP_BY_TIMEOUT"

    invoke-direct {v0, v1, v2, v3}, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$DialogType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$DialogType;->NO_BACKUP_BY_TIMEOUT:Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$DialogType;

    .line 107
    const/16 v0, 0xb

    new-array v0, v0, [Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$DialogType;

    sget-object v1, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$DialogType;->FIRST_TIME:Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$DialogType;

    aput-object v1, v0, v4

    sget-object v1, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$DialogType;->MEDIA_ADDED:Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$DialogType;

    aput-object v1, v0, v5

    sget-object v1, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$DialogType;->WEEK_AFTER:Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$DialogType;

    aput-object v1, v0, v6

    sget-object v1, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$DialogType;->FROM_SETTINGS:Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$DialogType;

    aput-object v1, v0, v7

    sget-object v1, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$DialogType;->ON_RECONNECT_TO_JIBO:Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$DialogType;

    aput-object v1, v0, v8

    const/4 v1, 0x5

    sget-object v2, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$DialogType;->ON_RECONNECT_TO_JIBO_NO_BACKUP:Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$DialogType;

    aput-object v2, v0, v1

    const/4 v1, 0x6

    sget-object v2, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$DialogType;->ON_CANCEL:Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$DialogType;

    aput-object v2, v0, v1

    const/4 v1, 0x7

    sget-object v2, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$DialogType;->ON_SET:Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$DialogType;

    aput-object v2, v0, v1

    const/16 v1, 0x8

    sget-object v2, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$DialogType;->RESTORE:Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$DialogType;

    aput-object v2, v0, v1

    const/16 v1, 0x9

    sget-object v2, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$DialogType;->RESTORE_BY_TIMEOUT:Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$DialogType;

    aput-object v2, v0, v1

    const/16 v1, 0xa

    sget-object v2, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$DialogType;->NO_BACKUP_BY_TIMEOUT:Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$DialogType;

    aput-object v2, v0, v1

    sput-object v0, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$DialogType;->$VALUES:[Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$DialogType;

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

    .prologue
    .line 122
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    .line 123
    iput-object p3, p0, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$DialogType;->name:Ljava/lang/String;

    .line 124
    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$DialogType;
    .locals 1

    .prologue
    .line 107
    const-class v0, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$DialogType;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$DialogType;

    return-object v0
.end method

.method public static values()[Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$DialogType;
    .locals 1

    .prologue
    .line 107
    sget-object v0, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$DialogType;->$VALUES:[Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$DialogType;

    invoke-virtual {v0}, [Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$DialogType;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$DialogType;

    return-object v0
.end method


# virtual methods
.method public equalsName(Ljava/lang/String;)Z
    .locals 1

    .prologue
    .line 127
    if-nez p1, :cond_0

    const/4 v0, 0x0

    :goto_0
    return v0

    :cond_0
    iget-object v0, p0, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$DialogType;->name:Ljava/lang/String;

    invoke-virtual {v0, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    goto :goto_0
.end method

.method public toString()Ljava/lang/String;
    .locals 1

    .prologue
    .line 131
    iget-object v0, p0, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$DialogType;->name:Ljava/lang/String;

    return-object v0
.end method
