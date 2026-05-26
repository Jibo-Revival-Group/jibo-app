.class final enum Lcom/jibo/ui/fragment/account/skills/OauthFragment$Type;
.super Ljava/lang/Enum;
.source "OauthFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/ui/fragment/account/skills/OauthFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x401a
    name = "Type"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/jibo/ui/fragment/account/skills/OauthFragment$Type;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/jibo/ui/fragment/account/skills/OauthFragment$Type;

.field public static final enum Google:Lcom/jibo/ui/fragment/account/skills/OauthFragment$Type;

.field public static final enum Other:Lcom/jibo/ui/fragment/account/skills/OauthFragment$Type;


# direct methods
.method static constructor <clinit>()V
    .locals 4

    .prologue
    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 51
    new-instance v0, Lcom/jibo/ui/fragment/account/skills/OauthFragment$Type;

    const-string v1, "Google"

    invoke-direct {v0, v1, v2}, Lcom/jibo/ui/fragment/account/skills/OauthFragment$Type;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/jibo/ui/fragment/account/skills/OauthFragment$Type;->Google:Lcom/jibo/ui/fragment/account/skills/OauthFragment$Type;

    new-instance v0, Lcom/jibo/ui/fragment/account/skills/OauthFragment$Type;

    const-string v1, "Other"

    invoke-direct {v0, v1, v3}, Lcom/jibo/ui/fragment/account/skills/OauthFragment$Type;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/jibo/ui/fragment/account/skills/OauthFragment$Type;->Other:Lcom/jibo/ui/fragment/account/skills/OauthFragment$Type;

    .line 50
    const/4 v0, 0x2

    new-array v0, v0, [Lcom/jibo/ui/fragment/account/skills/OauthFragment$Type;

    sget-object v1, Lcom/jibo/ui/fragment/account/skills/OauthFragment$Type;->Google:Lcom/jibo/ui/fragment/account/skills/OauthFragment$Type;

    aput-object v1, v0, v2

    sget-object v1, Lcom/jibo/ui/fragment/account/skills/OauthFragment$Type;->Other:Lcom/jibo/ui/fragment/account/skills/OauthFragment$Type;

    aput-object v1, v0, v3

    sput-object v0, Lcom/jibo/ui/fragment/account/skills/OauthFragment$Type;->$VALUES:[Lcom/jibo/ui/fragment/account/skills/OauthFragment$Type;

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
    .line 50
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/jibo/ui/fragment/account/skills/OauthFragment$Type;
    .locals 1

    .prologue
    .line 50
    const-class v0, Lcom/jibo/ui/fragment/account/skills/OauthFragment$Type;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/fragment/account/skills/OauthFragment$Type;

    return-object v0
.end method

.method public static values()[Lcom/jibo/ui/fragment/account/skills/OauthFragment$Type;
    .locals 1

    .prologue
    .line 50
    sget-object v0, Lcom/jibo/ui/fragment/account/skills/OauthFragment$Type;->$VALUES:[Lcom/jibo/ui/fragment/account/skills/OauthFragment$Type;

    invoke-virtual {v0}, [Lcom/jibo/ui/fragment/account/skills/OauthFragment$Type;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/jibo/ui/fragment/account/skills/OauthFragment$Type;

    return-object v0
.end method
