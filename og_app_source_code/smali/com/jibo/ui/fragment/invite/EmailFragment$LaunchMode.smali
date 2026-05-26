.class public final enum Lcom/jibo/ui/fragment/invite/EmailFragment$LaunchMode;
.super Ljava/lang/Enum;
.source "EmailFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/ui/fragment/invite/EmailFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "LaunchMode"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/jibo/ui/fragment/invite/EmailFragment$LaunchMode;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/jibo/ui/fragment/invite/EmailFragment$LaunchMode;

.field public static final enum add_email:Lcom/jibo/ui/fragment/invite/EmailFragment$LaunchMode;

.field public static final enum return_email:Lcom/jibo/ui/fragment/invite/EmailFragment$LaunchMode;

.field public static final enum send_invite:Lcom/jibo/ui/fragment/invite/EmailFragment$LaunchMode;

.field public static final enum set_email:Lcom/jibo/ui/fragment/invite/EmailFragment$LaunchMode;


# direct methods
.method static constructor <clinit>()V
    .locals 6

    .prologue
    const/4 v5, 0x3

    const/4 v4, 0x2

    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 56
    new-instance v0, Lcom/jibo/ui/fragment/invite/EmailFragment$LaunchMode;

    const-string v1, "send_invite"

    invoke-direct {v0, v1, v2}, Lcom/jibo/ui/fragment/invite/EmailFragment$LaunchMode;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/jibo/ui/fragment/invite/EmailFragment$LaunchMode;->send_invite:Lcom/jibo/ui/fragment/invite/EmailFragment$LaunchMode;

    new-instance v0, Lcom/jibo/ui/fragment/invite/EmailFragment$LaunchMode;

    const-string v1, "return_email"

    invoke-direct {v0, v1, v3}, Lcom/jibo/ui/fragment/invite/EmailFragment$LaunchMode;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/jibo/ui/fragment/invite/EmailFragment$LaunchMode;->return_email:Lcom/jibo/ui/fragment/invite/EmailFragment$LaunchMode;

    new-instance v0, Lcom/jibo/ui/fragment/invite/EmailFragment$LaunchMode;

    const-string v1, "set_email"

    invoke-direct {v0, v1, v4}, Lcom/jibo/ui/fragment/invite/EmailFragment$LaunchMode;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/jibo/ui/fragment/invite/EmailFragment$LaunchMode;->set_email:Lcom/jibo/ui/fragment/invite/EmailFragment$LaunchMode;

    new-instance v0, Lcom/jibo/ui/fragment/invite/EmailFragment$LaunchMode;

    const-string v1, "add_email"

    invoke-direct {v0, v1, v5}, Lcom/jibo/ui/fragment/invite/EmailFragment$LaunchMode;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/jibo/ui/fragment/invite/EmailFragment$LaunchMode;->add_email:Lcom/jibo/ui/fragment/invite/EmailFragment$LaunchMode;

    const/4 v0, 0x4

    new-array v0, v0, [Lcom/jibo/ui/fragment/invite/EmailFragment$LaunchMode;

    sget-object v1, Lcom/jibo/ui/fragment/invite/EmailFragment$LaunchMode;->send_invite:Lcom/jibo/ui/fragment/invite/EmailFragment$LaunchMode;

    aput-object v1, v0, v2

    sget-object v1, Lcom/jibo/ui/fragment/invite/EmailFragment$LaunchMode;->return_email:Lcom/jibo/ui/fragment/invite/EmailFragment$LaunchMode;

    aput-object v1, v0, v3

    sget-object v1, Lcom/jibo/ui/fragment/invite/EmailFragment$LaunchMode;->set_email:Lcom/jibo/ui/fragment/invite/EmailFragment$LaunchMode;

    aput-object v1, v0, v4

    sget-object v1, Lcom/jibo/ui/fragment/invite/EmailFragment$LaunchMode;->add_email:Lcom/jibo/ui/fragment/invite/EmailFragment$LaunchMode;

    aput-object v1, v0, v5

    sput-object v0, Lcom/jibo/ui/fragment/invite/EmailFragment$LaunchMode;->$VALUES:[Lcom/jibo/ui/fragment/invite/EmailFragment$LaunchMode;

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
    .line 56
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/jibo/ui/fragment/invite/EmailFragment$LaunchMode;
    .locals 1

    .prologue
    .line 56
    const-class v0, Lcom/jibo/ui/fragment/invite/EmailFragment$LaunchMode;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/fragment/invite/EmailFragment$LaunchMode;

    return-object v0
.end method

.method public static values()[Lcom/jibo/ui/fragment/invite/EmailFragment$LaunchMode;
    .locals 1

    .prologue
    .line 56
    sget-object v0, Lcom/jibo/ui/fragment/invite/EmailFragment$LaunchMode;->$VALUES:[Lcom/jibo/ui/fragment/invite/EmailFragment$LaunchMode;

    invoke-virtual {v0}, [Lcom/jibo/ui/fragment/invite/EmailFragment$LaunchMode;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/jibo/ui/fragment/invite/EmailFragment$LaunchMode;

    return-object v0
.end method
