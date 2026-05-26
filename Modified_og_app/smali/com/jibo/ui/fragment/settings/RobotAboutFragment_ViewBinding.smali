.class public Lcom/jibo/ui/fragment/settings/RobotAboutFragment_ViewBinding;
.super Ljava/lang/Object;
.source "RobotAboutFragment_ViewBinding.java"

# interfaces
.implements Lbutterknife/Unbinder;


# instance fields
.field private b:Lcom/jibo/ui/fragment/settings/RobotAboutFragment;


# direct methods
.method public constructor <init>(Lcom/jibo/ui/fragment/settings/RobotAboutFragment;Landroid/view/View;)V
    .locals 3

    .prologue
    .line 18
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 19
    iput-object p1, p0, Lcom/jibo/ui/fragment/settings/RobotAboutFragment_ViewBinding;->b:Lcom/jibo/ui/fragment/settings/RobotAboutFragment;

    .line 21
    const v0, 0x7f0901fb

    const-string v1, "field \'ownerName\'"

    const-class v2, Landroid/widget/TextView;

    invoke-static {p2, v0, v1, v2}, Lbutterknife/internal/Utils;->b(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p1, Lcom/jibo/ui/fragment/settings/RobotAboutFragment;->ownerName:Landroid/widget/TextView;

    .line 22
    const v0, 0x7f0901fa

    const-string v1, "field \'ownerEmail\'"

    const-class v2, Landroid/widget/TextView;

    invoke-static {p2, v0, v1, v2}, Lbutterknife/internal/Utils;->b(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p1, Lcom/jibo/ui/fragment/settings/RobotAboutFragment;->ownerEmail:Landroid/widget/TextView;

    .line 23
    const v0, 0x7f0901f7

    const-string v1, "field \'osVersion\'"

    const-class v2, Landroid/widget/TextView;

    invoke-static {p2, v0, v1, v2}, Lbutterknife/internal/Utils;->b(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p1, Lcom/jibo/ui/fragment/settings/RobotAboutFragment;->osVersion:Landroid/widget/TextView;

    .line 24
    const v0, 0x7f090273

    const-string v1, "field \'serialName\'"

    const-class v2, Landroid/widget/TextView;

    invoke-static {p2, v0, v1, v2}, Lbutterknife/internal/Utils;->b(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p1, Lcom/jibo/ui/fragment/settings/RobotAboutFragment;->serialName:Landroid/widget/TextView;

    .line 25
    return-void
.end method


# virtual methods
.method public unbind()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 30
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/RobotAboutFragment_ViewBinding;->b:Lcom/jibo/ui/fragment/settings/RobotAboutFragment;

    .line 31
    if-nez v0, :cond_0

    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Bindings already cleared."

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 32
    :cond_0
    iput-object v1, p0, Lcom/jibo/ui/fragment/settings/RobotAboutFragment_ViewBinding;->b:Lcom/jibo/ui/fragment/settings/RobotAboutFragment;

    .line 34
    iput-object v1, v0, Lcom/jibo/ui/fragment/settings/RobotAboutFragment;->ownerName:Landroid/widget/TextView;

    .line 35
    iput-object v1, v0, Lcom/jibo/ui/fragment/settings/RobotAboutFragment;->ownerEmail:Landroid/widget/TextView;

    .line 36
    iput-object v1, v0, Lcom/jibo/ui/fragment/settings/RobotAboutFragment;->osVersion:Landroid/widget/TextView;

    .line 37
    iput-object v1, v0, Lcom/jibo/ui/fragment/settings/RobotAboutFragment;->serialName:Landroid/widget/TextView;

    .line 38
    return-void
.end method
