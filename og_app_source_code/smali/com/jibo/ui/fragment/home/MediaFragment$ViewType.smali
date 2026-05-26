.class final enum Lcom/jibo/ui/fragment/home/MediaFragment$ViewType;
.super Ljava/lang/Enum;
.source "MediaFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/ui/fragment/home/MediaFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4018
    name = "ViewType"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/jibo/ui/fragment/home/MediaFragment$ViewType;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/jibo/ui/fragment/home/MediaFragment$ViewType;

.field public static final enum header:Lcom/jibo/ui/fragment/home/MediaFragment$ViewType;

.field public static final enum media:Lcom/jibo/ui/fragment/home/MediaFragment$ViewType;

.field public static final enum pagination:Lcom/jibo/ui/fragment/home/MediaFragment$ViewType;


# direct methods
.method static constructor <clinit>()V
    .locals 5

    .prologue
    const/4 v4, 0x2

    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 914
    new-instance v0, Lcom/jibo/ui/fragment/home/MediaFragment$ViewType;

    const-string v1, "header"

    invoke-direct {v0, v1, v2}, Lcom/jibo/ui/fragment/home/MediaFragment$ViewType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/jibo/ui/fragment/home/MediaFragment$ViewType;->header:Lcom/jibo/ui/fragment/home/MediaFragment$ViewType;

    new-instance v0, Lcom/jibo/ui/fragment/home/MediaFragment$ViewType;

    const-string v1, "media"

    invoke-direct {v0, v1, v3}, Lcom/jibo/ui/fragment/home/MediaFragment$ViewType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/jibo/ui/fragment/home/MediaFragment$ViewType;->media:Lcom/jibo/ui/fragment/home/MediaFragment$ViewType;

    new-instance v0, Lcom/jibo/ui/fragment/home/MediaFragment$ViewType;

    const-string v1, "pagination"

    invoke-direct {v0, v1, v4}, Lcom/jibo/ui/fragment/home/MediaFragment$ViewType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/jibo/ui/fragment/home/MediaFragment$ViewType;->pagination:Lcom/jibo/ui/fragment/home/MediaFragment$ViewType;

    .line 913
    const/4 v0, 0x3

    new-array v0, v0, [Lcom/jibo/ui/fragment/home/MediaFragment$ViewType;

    sget-object v1, Lcom/jibo/ui/fragment/home/MediaFragment$ViewType;->header:Lcom/jibo/ui/fragment/home/MediaFragment$ViewType;

    aput-object v1, v0, v2

    sget-object v1, Lcom/jibo/ui/fragment/home/MediaFragment$ViewType;->media:Lcom/jibo/ui/fragment/home/MediaFragment$ViewType;

    aput-object v1, v0, v3

    sget-object v1, Lcom/jibo/ui/fragment/home/MediaFragment$ViewType;->pagination:Lcom/jibo/ui/fragment/home/MediaFragment$ViewType;

    aput-object v1, v0, v4

    sput-object v0, Lcom/jibo/ui/fragment/home/MediaFragment$ViewType;->$VALUES:[Lcom/jibo/ui/fragment/home/MediaFragment$ViewType;

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
    .line 913
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/jibo/ui/fragment/home/MediaFragment$ViewType;
    .locals 1

    .prologue
    .line 913
    const-class v0, Lcom/jibo/ui/fragment/home/MediaFragment$ViewType;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/fragment/home/MediaFragment$ViewType;

    return-object v0
.end method

.method public static values()[Lcom/jibo/ui/fragment/home/MediaFragment$ViewType;
    .locals 1

    .prologue
    .line 913
    sget-object v0, Lcom/jibo/ui/fragment/home/MediaFragment$ViewType;->$VALUES:[Lcom/jibo/ui/fragment/home/MediaFragment$ViewType;

    invoke-virtual {v0}, [Lcom/jibo/ui/fragment/home/MediaFragment$ViewType;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/jibo/ui/fragment/home/MediaFragment$ViewType;

    return-object v0
.end method
