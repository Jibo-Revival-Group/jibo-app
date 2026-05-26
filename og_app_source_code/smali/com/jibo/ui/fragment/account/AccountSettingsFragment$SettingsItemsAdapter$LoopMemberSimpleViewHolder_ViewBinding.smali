.class public Lcom/jibo/ui/fragment/account/AccountSettingsFragment$SettingsItemsAdapter$LoopMemberSimpleViewHolder_ViewBinding;
.super Ljava/lang/Object;
.source "AccountSettingsFragment$SettingsItemsAdapter$LoopMemberSimpleViewHolder_ViewBinding.java"

# interfaces
.implements Lbutterknife/Unbinder;


# instance fields
.field private b:Lcom/jibo/ui/fragment/account/AccountSettingsFragment$SettingsItemsAdapter$LoopMemberSimpleViewHolder;


# direct methods
.method public constructor <init>(Lcom/jibo/ui/fragment/account/AccountSettingsFragment$SettingsItemsAdapter$LoopMemberSimpleViewHolder;Landroid/view/View;)V
    .locals 3

    .prologue
    .line 19
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 20
    iput-object p1, p0, Lcom/jibo/ui/fragment/account/AccountSettingsFragment$SettingsItemsAdapter$LoopMemberSimpleViewHolder_ViewBinding;->b:Lcom/jibo/ui/fragment/account/AccountSettingsFragment$SettingsItemsAdapter$LoopMemberSimpleViewHolder;

    .line 22
    const v0, 0x1020006

    const-string v1, "field \'avatar\'"

    const-class v2, Lcom/jibo/ui/view/RoundedImageView;

    invoke-static {p2, v0, v1, v2}, Lbutterknife/internal/Utils;->b(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/view/RoundedImageView;

    iput-object v0, p1, Lcom/jibo/ui/fragment/account/AccountSettingsFragment$SettingsItemsAdapter$LoopMemberSimpleViewHolder;->avatar:Lcom/jibo/ui/view/RoundedImageView;

    .line 23
    const v0, 0x1020014

    const-string v1, "field \'name\'"

    const-class v2, Landroid/widget/TextView;

    invoke-static {p2, v0, v1, v2}, Lbutterknife/internal/Utils;->b(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p1, Lcom/jibo/ui/fragment/account/AccountSettingsFragment$SettingsItemsAdapter$LoopMemberSimpleViewHolder;->name:Landroid/widget/TextView;

    .line 24
    const v0, 0x1020015

    const-string v1, "field \'nickName\'"

    const-class v2, Landroid/widget/TextView;

    invoke-static {p2, v0, v1, v2}, Lbutterknife/internal/Utils;->b(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p1, Lcom/jibo/ui/fragment/account/AccountSettingsFragment$SettingsItemsAdapter$LoopMemberSimpleViewHolder;->nickName:Landroid/widget/TextView;

    .line 25
    return-void
.end method


# virtual methods
.method public unbind()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 30
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/AccountSettingsFragment$SettingsItemsAdapter$LoopMemberSimpleViewHolder_ViewBinding;->b:Lcom/jibo/ui/fragment/account/AccountSettingsFragment$SettingsItemsAdapter$LoopMemberSimpleViewHolder;

    .line 31
    if-nez v0, :cond_0

    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Bindings already cleared."

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 32
    :cond_0
    iput-object v1, p0, Lcom/jibo/ui/fragment/account/AccountSettingsFragment$SettingsItemsAdapter$LoopMemberSimpleViewHolder_ViewBinding;->b:Lcom/jibo/ui/fragment/account/AccountSettingsFragment$SettingsItemsAdapter$LoopMemberSimpleViewHolder;

    .line 34
    iput-object v1, v0, Lcom/jibo/ui/fragment/account/AccountSettingsFragment$SettingsItemsAdapter$LoopMemberSimpleViewHolder;->avatar:Lcom/jibo/ui/view/RoundedImageView;

    .line 35
    iput-object v1, v0, Lcom/jibo/ui/fragment/account/AccountSettingsFragment$SettingsItemsAdapter$LoopMemberSimpleViewHolder;->name:Landroid/widget/TextView;

    .line 36
    iput-object v1, v0, Lcom/jibo/ui/fragment/account/AccountSettingsFragment$SettingsItemsAdapter$LoopMemberSimpleViewHolder;->nickName:Landroid/widget/TextView;

    .line 37
    return-void
.end method
