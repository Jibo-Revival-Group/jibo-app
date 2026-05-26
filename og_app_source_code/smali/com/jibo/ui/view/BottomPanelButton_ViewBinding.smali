.class public Lcom/jibo/ui/view/BottomPanelButton_ViewBinding;
.super Ljava/lang/Object;
.source "BottomPanelButton_ViewBinding.java"

# interfaces
.implements Lbutterknife/Unbinder;


# instance fields
.field private b:Lcom/jibo/ui/view/BottomPanelButton;


# direct methods
.method public constructor <init>(Lcom/jibo/ui/view/BottomPanelButton;)V
    .locals 0

    .prologue
    .line 19
    invoke-direct {p0, p1, p1}, Lcom/jibo/ui/view/BottomPanelButton_ViewBinding;-><init>(Lcom/jibo/ui/view/BottomPanelButton;Landroid/view/View;)V

    .line 20
    return-void
.end method

.method public constructor <init>(Lcom/jibo/ui/view/BottomPanelButton;Landroid/view/View;)V
    .locals 3

    .prologue
    .line 23
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 24
    iput-object p1, p0, Lcom/jibo/ui/view/BottomPanelButton_ViewBinding;->b:Lcom/jibo/ui/view/BottomPanelButton;

    .line 26
    const v0, 0x1020014

    const-string v1, "field \'text\'"

    const-class v2, Landroid/widget/TextView;

    invoke-static {p2, v0, v1, v2}, Lbutterknife/internal/Utils;->b(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p1, Lcom/jibo/ui/view/BottomPanelButton;->text:Landroid/widget/TextView;

    .line 27
    const v0, 0x1020006

    const-string v1, "field \'icon\'"

    const-class v2, Landroid/widget/ImageView;

    invoke-static {p2, v0, v1, v2}, Lbutterknife/internal/Utils;->b(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p1, Lcom/jibo/ui/view/BottomPanelButton;->icon:Landroid/widget/ImageView;

    .line 28
    const v0, 0x1020015

    const-string v1, "field \'badge\'"

    const-class v2, Landroid/widget/TextView;

    invoke-static {p2, v0, v1, v2}, Lbutterknife/internal/Utils;->b(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p1, Lcom/jibo/ui/view/BottomPanelButton;->badge:Landroid/widget/TextView;

    .line 29
    return-void
.end method


# virtual methods
.method public unbind()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 34
    iget-object v0, p0, Lcom/jibo/ui/view/BottomPanelButton_ViewBinding;->b:Lcom/jibo/ui/view/BottomPanelButton;

    .line 35
    if-nez v0, :cond_0

    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Bindings already cleared."

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 36
    :cond_0
    iput-object v1, p0, Lcom/jibo/ui/view/BottomPanelButton_ViewBinding;->b:Lcom/jibo/ui/view/BottomPanelButton;

    .line 38
    iput-object v1, v0, Lcom/jibo/ui/view/BottomPanelButton;->text:Landroid/widget/TextView;

    .line 39
    iput-object v1, v0, Lcom/jibo/ui/view/BottomPanelButton;->icon:Landroid/widget/ImageView;

    .line 40
    iput-object v1, v0, Lcom/jibo/ui/view/BottomPanelButton;->badge:Landroid/widget/TextView;

    .line 41
    return-void
.end method
