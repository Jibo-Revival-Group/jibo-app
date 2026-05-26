.class public final enum Lcom/jibo/ui/fragment/home/MediaFragment$ModesHelper$Mode;
.super Ljava/lang/Enum;
.source "MediaFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/ui/fragment/home/MediaFragment$ModesHelper;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "Mode"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/jibo/ui/fragment/home/MediaFragment$ModesHelper$Mode;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/jibo/ui/fragment/home/MediaFragment$ModesHelper$Mode;

.field public static final enum Gridview:Lcom/jibo/ui/fragment/home/MediaFragment$ModesHelper$Mode;

.field public static final enum Timeline:Lcom/jibo/ui/fragment/home/MediaFragment$ModesHelper$Mode;


# direct methods
.method static constructor <clinit>()V
    .locals 4

    .prologue
    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 1646
    new-instance v0, Lcom/jibo/ui/fragment/home/MediaFragment$ModesHelper$Mode;

    const-string v1, "Timeline"

    invoke-direct {v0, v1, v2}, Lcom/jibo/ui/fragment/home/MediaFragment$ModesHelper$Mode;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/jibo/ui/fragment/home/MediaFragment$ModesHelper$Mode;->Timeline:Lcom/jibo/ui/fragment/home/MediaFragment$ModesHelper$Mode;

    new-instance v0, Lcom/jibo/ui/fragment/home/MediaFragment$ModesHelper$Mode;

    const-string v1, "Gridview"

    invoke-direct {v0, v1, v3}, Lcom/jibo/ui/fragment/home/MediaFragment$ModesHelper$Mode;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/jibo/ui/fragment/home/MediaFragment$ModesHelper$Mode;->Gridview:Lcom/jibo/ui/fragment/home/MediaFragment$ModesHelper$Mode;

    const/4 v0, 0x2

    new-array v0, v0, [Lcom/jibo/ui/fragment/home/MediaFragment$ModesHelper$Mode;

    sget-object v1, Lcom/jibo/ui/fragment/home/MediaFragment$ModesHelper$Mode;->Timeline:Lcom/jibo/ui/fragment/home/MediaFragment$ModesHelper$Mode;

    aput-object v1, v0, v2

    sget-object v1, Lcom/jibo/ui/fragment/home/MediaFragment$ModesHelper$Mode;->Gridview:Lcom/jibo/ui/fragment/home/MediaFragment$ModesHelper$Mode;

    aput-object v1, v0, v3

    sput-object v0, Lcom/jibo/ui/fragment/home/MediaFragment$ModesHelper$Mode;->$VALUES:[Lcom/jibo/ui/fragment/home/MediaFragment$ModesHelper$Mode;

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
    .line 1646
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/jibo/ui/fragment/home/MediaFragment$ModesHelper$Mode;
    .locals 1

    .prologue
    .line 1646
    const-class v0, Lcom/jibo/ui/fragment/home/MediaFragment$ModesHelper$Mode;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/fragment/home/MediaFragment$ModesHelper$Mode;

    return-object v0
.end method

.method public static values()[Lcom/jibo/ui/fragment/home/MediaFragment$ModesHelper$Mode;
    .locals 1

    .prologue
    .line 1646
    sget-object v0, Lcom/jibo/ui/fragment/home/MediaFragment$ModesHelper$Mode;->$VALUES:[Lcom/jibo/ui/fragment/home/MediaFragment$ModesHelper$Mode;

    invoke-virtual {v0}, [Lcom/jibo/ui/fragment/home/MediaFragment$ModesHelper$Mode;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/jibo/ui/fragment/home/MediaFragment$ModesHelper$Mode;

    return-object v0
.end method
