.class final enum Lcom/jibo/ui/fragment/settings/HolidaysListFragment$ItemType;
.super Ljava/lang/Enum;
.source "HolidaysListFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/ui/fragment/settings/HolidaysListFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4018
    name = "ItemType"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/jibo/ui/fragment/settings/HolidaysListFragment$ItemType;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/jibo/ui/fragment/settings/HolidaysListFragment$ItemType;

.field public static final enum empty:Lcom/jibo/ui/fragment/settings/HolidaysListFragment$ItemType;

.field public static final enum holiday:Lcom/jibo/ui/fragment/settings/HolidaysListFragment$ItemType;


# direct methods
.method static constructor <clinit>()V
    .locals 4

    .prologue
    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 194
    new-instance v0, Lcom/jibo/ui/fragment/settings/HolidaysListFragment$ItemType;

    const-string v1, "empty"

    invoke-direct {v0, v1, v2}, Lcom/jibo/ui/fragment/settings/HolidaysListFragment$ItemType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/jibo/ui/fragment/settings/HolidaysListFragment$ItemType;->empty:Lcom/jibo/ui/fragment/settings/HolidaysListFragment$ItemType;

    new-instance v0, Lcom/jibo/ui/fragment/settings/HolidaysListFragment$ItemType;

    const-string v1, "holiday"

    invoke-direct {v0, v1, v3}, Lcom/jibo/ui/fragment/settings/HolidaysListFragment$ItemType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/jibo/ui/fragment/settings/HolidaysListFragment$ItemType;->holiday:Lcom/jibo/ui/fragment/settings/HolidaysListFragment$ItemType;

    .line 193
    const/4 v0, 0x2

    new-array v0, v0, [Lcom/jibo/ui/fragment/settings/HolidaysListFragment$ItemType;

    sget-object v1, Lcom/jibo/ui/fragment/settings/HolidaysListFragment$ItemType;->empty:Lcom/jibo/ui/fragment/settings/HolidaysListFragment$ItemType;

    aput-object v1, v0, v2

    sget-object v1, Lcom/jibo/ui/fragment/settings/HolidaysListFragment$ItemType;->holiday:Lcom/jibo/ui/fragment/settings/HolidaysListFragment$ItemType;

    aput-object v1, v0, v3

    sput-object v0, Lcom/jibo/ui/fragment/settings/HolidaysListFragment$ItemType;->$VALUES:[Lcom/jibo/ui/fragment/settings/HolidaysListFragment$ItemType;

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
    .line 193
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/jibo/ui/fragment/settings/HolidaysListFragment$ItemType;
    .locals 1

    .prologue
    .line 193
    const-class v0, Lcom/jibo/ui/fragment/settings/HolidaysListFragment$ItemType;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/fragment/settings/HolidaysListFragment$ItemType;

    return-object v0
.end method

.method public static values()[Lcom/jibo/ui/fragment/settings/HolidaysListFragment$ItemType;
    .locals 1

    .prologue
    .line 193
    sget-object v0, Lcom/jibo/ui/fragment/settings/HolidaysListFragment$ItemType;->$VALUES:[Lcom/jibo/ui/fragment/settings/HolidaysListFragment$ItemType;

    invoke-virtual {v0}, [Lcom/jibo/ui/fragment/settings/HolidaysListFragment$ItemType;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/jibo/ui/fragment/settings/HolidaysListFragment$ItemType;

    return-object v0
.end method
