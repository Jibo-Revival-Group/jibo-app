.class final enum Lcom/jibo/ui/view/TouchImageView$State;
.super Ljava/lang/Enum;
.source "TouchImageView.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/ui/view/TouchImageView;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x401a
    name = "State"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/jibo/ui/view/TouchImageView$State;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/jibo/ui/view/TouchImageView$State;

.field public static final enum ANIMATE_ZOOM:Lcom/jibo/ui/view/TouchImageView$State;

.field public static final enum DRAG:Lcom/jibo/ui/view/TouchImageView$State;

.field public static final enum FLING:Lcom/jibo/ui/view/TouchImageView$State;

.field public static final enum NONE:Lcom/jibo/ui/view/TouchImageView$State;

.field public static final enum ZOOM:Lcom/jibo/ui/view/TouchImageView$State;


# direct methods
.method static constructor <clinit>()V
    .locals 7

    .prologue
    const/4 v6, 0x4

    const/4 v5, 0x3

    const/4 v4, 0x2

    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 66
    new-instance v0, Lcom/jibo/ui/view/TouchImageView$State;

    const-string v1, "NONE"

    invoke-direct {v0, v1, v2}, Lcom/jibo/ui/view/TouchImageView$State;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/jibo/ui/view/TouchImageView$State;->NONE:Lcom/jibo/ui/view/TouchImageView$State;

    new-instance v0, Lcom/jibo/ui/view/TouchImageView$State;

    const-string v1, "DRAG"

    invoke-direct {v0, v1, v3}, Lcom/jibo/ui/view/TouchImageView$State;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/jibo/ui/view/TouchImageView$State;->DRAG:Lcom/jibo/ui/view/TouchImageView$State;

    new-instance v0, Lcom/jibo/ui/view/TouchImageView$State;

    const-string v1, "ZOOM"

    invoke-direct {v0, v1, v4}, Lcom/jibo/ui/view/TouchImageView$State;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/jibo/ui/view/TouchImageView$State;->ZOOM:Lcom/jibo/ui/view/TouchImageView$State;

    new-instance v0, Lcom/jibo/ui/view/TouchImageView$State;

    const-string v1, "FLING"

    invoke-direct {v0, v1, v5}, Lcom/jibo/ui/view/TouchImageView$State;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/jibo/ui/view/TouchImageView$State;->FLING:Lcom/jibo/ui/view/TouchImageView$State;

    new-instance v0, Lcom/jibo/ui/view/TouchImageView$State;

    const-string v1, "ANIMATE_ZOOM"

    invoke-direct {v0, v1, v6}, Lcom/jibo/ui/view/TouchImageView$State;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/jibo/ui/view/TouchImageView$State;->ANIMATE_ZOOM:Lcom/jibo/ui/view/TouchImageView$State;

    const/4 v0, 0x5

    new-array v0, v0, [Lcom/jibo/ui/view/TouchImageView$State;

    sget-object v1, Lcom/jibo/ui/view/TouchImageView$State;->NONE:Lcom/jibo/ui/view/TouchImageView$State;

    aput-object v1, v0, v2

    sget-object v1, Lcom/jibo/ui/view/TouchImageView$State;->DRAG:Lcom/jibo/ui/view/TouchImageView$State;

    aput-object v1, v0, v3

    sget-object v1, Lcom/jibo/ui/view/TouchImageView$State;->ZOOM:Lcom/jibo/ui/view/TouchImageView$State;

    aput-object v1, v0, v4

    sget-object v1, Lcom/jibo/ui/view/TouchImageView$State;->FLING:Lcom/jibo/ui/view/TouchImageView$State;

    aput-object v1, v0, v5

    sget-object v1, Lcom/jibo/ui/view/TouchImageView$State;->ANIMATE_ZOOM:Lcom/jibo/ui/view/TouchImageView$State;

    aput-object v1, v0, v6

    sput-object v0, Lcom/jibo/ui/view/TouchImageView$State;->$VALUES:[Lcom/jibo/ui/view/TouchImageView$State;

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
    .line 66
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/jibo/ui/view/TouchImageView$State;
    .locals 1

    .prologue
    .line 66
    const-class v0, Lcom/jibo/ui/view/TouchImageView$State;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/view/TouchImageView$State;

    return-object v0
.end method

.method public static values()[Lcom/jibo/ui/view/TouchImageView$State;
    .locals 1

    .prologue
    .line 66
    sget-object v0, Lcom/jibo/ui/view/TouchImageView$State;->$VALUES:[Lcom/jibo/ui/view/TouchImageView$State;

    invoke-virtual {v0}, [Lcom/jibo/ui/view/TouchImageView$State;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/jibo/ui/view/TouchImageView$State;

    return-object v0
.end method
