.class final enum Lcom/jibo/ui/activity/TabbedActivity$TabsState;
.super Ljava/lang/Enum;
.source "TabbedActivity.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/ui/activity/TabbedActivity;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x401a
    name = "TabsState"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/jibo/ui/activity/TabbedActivity$TabsState;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/jibo/ui/activity/TabbedActivity$TabsState;

.field public static final enum complete:Lcom/jibo/ui/activity/TabbedActivity$TabsState;

.field public static final enum initial:Lcom/jibo/ui/activity/TabbedActivity$TabsState;


# direct methods
.method static constructor <clinit>()V
    .locals 4

    .prologue
    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 79
    new-instance v0, Lcom/jibo/ui/activity/TabbedActivity$TabsState;

    const-string v1, "initial"

    invoke-direct {v0, v1, v2}, Lcom/jibo/ui/activity/TabbedActivity$TabsState;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/jibo/ui/activity/TabbedActivity$TabsState;->initial:Lcom/jibo/ui/activity/TabbedActivity$TabsState;

    new-instance v0, Lcom/jibo/ui/activity/TabbedActivity$TabsState;

    const-string v1, "complete"

    invoke-direct {v0, v1, v3}, Lcom/jibo/ui/activity/TabbedActivity$TabsState;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/jibo/ui/activity/TabbedActivity$TabsState;->complete:Lcom/jibo/ui/activity/TabbedActivity$TabsState;

    const/4 v0, 0x2

    new-array v0, v0, [Lcom/jibo/ui/activity/TabbedActivity$TabsState;

    sget-object v1, Lcom/jibo/ui/activity/TabbedActivity$TabsState;->initial:Lcom/jibo/ui/activity/TabbedActivity$TabsState;

    aput-object v1, v0, v2

    sget-object v1, Lcom/jibo/ui/activity/TabbedActivity$TabsState;->complete:Lcom/jibo/ui/activity/TabbedActivity$TabsState;

    aput-object v1, v0, v3

    sput-object v0, Lcom/jibo/ui/activity/TabbedActivity$TabsState;->$VALUES:[Lcom/jibo/ui/activity/TabbedActivity$TabsState;

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
    .line 79
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/jibo/ui/activity/TabbedActivity$TabsState;
    .locals 1

    .prologue
    .line 79
    const-class v0, Lcom/jibo/ui/activity/TabbedActivity$TabsState;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/activity/TabbedActivity$TabsState;

    return-object v0
.end method

.method public static values()[Lcom/jibo/ui/activity/TabbedActivity$TabsState;
    .locals 1

    .prologue
    .line 79
    sget-object v0, Lcom/jibo/ui/activity/TabbedActivity$TabsState;->$VALUES:[Lcom/jibo/ui/activity/TabbedActivity$TabsState;

    invoke-virtual {v0}, [Lcom/jibo/ui/activity/TabbedActivity$TabsState;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/jibo/ui/activity/TabbedActivity$TabsState;

    return-object v0
.end method
