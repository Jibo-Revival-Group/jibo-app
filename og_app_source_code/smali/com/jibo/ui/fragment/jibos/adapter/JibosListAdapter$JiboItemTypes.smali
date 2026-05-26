.class final enum Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter$JiboItemTypes;
.super Ljava/lang/Enum;
.source "JibosListAdapter.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x401a
    name = "JiboItemTypes"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter$JiboItemTypes;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter$JiboItemTypes;

.field public static final enum invitedLoop:Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter$JiboItemTypes;

.field public static final enum joinedLoop:Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter$JiboItemTypes;

.field public static final enum myLoop:Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter$JiboItemTypes;

.field public static final enum newjibo:Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter$JiboItemTypes;


# direct methods
.method static constructor <clinit>()V
    .locals 6

    .prologue
    const/4 v5, 0x3

    const/4 v4, 0x2

    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 47
    new-instance v0, Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter$JiboItemTypes;

    const-string v1, "myLoop"

    invoke-direct {v0, v1, v2}, Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter$JiboItemTypes;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter$JiboItemTypes;->myLoop:Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter$JiboItemTypes;

    new-instance v0, Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter$JiboItemTypes;

    const-string v1, "invitedLoop"

    invoke-direct {v0, v1, v3}, Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter$JiboItemTypes;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter$JiboItemTypes;->invitedLoop:Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter$JiboItemTypes;

    new-instance v0, Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter$JiboItemTypes;

    const-string v1, "joinedLoop"

    invoke-direct {v0, v1, v4}, Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter$JiboItemTypes;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter$JiboItemTypes;->joinedLoop:Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter$JiboItemTypes;

    new-instance v0, Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter$JiboItemTypes;

    const-string v1, "newjibo"

    invoke-direct {v0, v1, v5}, Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter$JiboItemTypes;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter$JiboItemTypes;->newjibo:Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter$JiboItemTypes;

    const/4 v0, 0x4

    new-array v0, v0, [Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter$JiboItemTypes;

    sget-object v1, Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter$JiboItemTypes;->myLoop:Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter$JiboItemTypes;

    aput-object v1, v0, v2

    sget-object v1, Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter$JiboItemTypes;->invitedLoop:Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter$JiboItemTypes;

    aput-object v1, v0, v3

    sget-object v1, Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter$JiboItemTypes;->joinedLoop:Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter$JiboItemTypes;

    aput-object v1, v0, v4

    sget-object v1, Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter$JiboItemTypes;->newjibo:Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter$JiboItemTypes;

    aput-object v1, v0, v5

    sput-object v0, Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter$JiboItemTypes;->$VALUES:[Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter$JiboItemTypes;

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
    .line 47
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter$JiboItemTypes;
    .locals 1

    .prologue
    .line 47
    const-class v0, Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter$JiboItemTypes;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter$JiboItemTypes;

    return-object v0
.end method

.method public static values()[Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter$JiboItemTypes;
    .locals 1

    .prologue
    .line 47
    sget-object v0, Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter$JiboItemTypes;->$VALUES:[Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter$JiboItemTypes;

    invoke-virtual {v0}, [Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter$JiboItemTypes;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter$JiboItemTypes;

    return-object v0
.end method
