.class public Lcom/jibo/ui/fragment/wifi/InviteLoopMembersFragment_ViewBinding;
.super Lcom/jibo/ui/fragment/wifi/WiFiBaseFragment_ViewBinding;
.source "InviteLoopMembersFragment_ViewBinding.java"


# instance fields
.field private b:Lcom/jibo/ui/fragment/wifi/InviteLoopMembersFragment;

.field private c:Landroid/view/View;

.field private d:Landroid/view/View;


# direct methods
.method public constructor <init>(Lcom/jibo/ui/fragment/wifi/InviteLoopMembersFragment;Landroid/view/View;)V
    .locals 5

    .prologue
    const v4, 0x7f09006e

    const v3, 0x1020027

    .line 24
    invoke-direct {p0, p1, p2}, Lcom/jibo/ui/fragment/wifi/WiFiBaseFragment_ViewBinding;-><init>(Lcom/jibo/ui/fragment/wifi/WiFiBaseFragment;Landroid/view/View;)V

    .line 26
    iput-object p1, p0, Lcom/jibo/ui/fragment/wifi/InviteLoopMembersFragment_ViewBinding;->b:Lcom/jibo/ui/fragment/wifi/InviteLoopMembersFragment;

    .line 29
    const-string v0, "field \'closeButton\' and method \'onCloseClick\'"

    invoke-static {p2, v3, v0}, Lbutterknife/internal/Utils;->a(Landroid/view/View;ILjava/lang/String;)Landroid/view/View;

    move-result-object v1

    .line 30
    const-string v0, "field \'closeButton\'"

    const-class v2, Landroid/widget/ImageView;

    invoke-static {v1, v3, v0, v2}, Lbutterknife/internal/Utils;->c(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p1, Lcom/jibo/ui/fragment/wifi/InviteLoopMembersFragment;->closeButton:Landroid/widget/ImageView;

    .line 31
    iput-object v1, p0, Lcom/jibo/ui/fragment/wifi/InviteLoopMembersFragment_ViewBinding;->c:Landroid/view/View;

    .line 32
    new-instance v0, Lcom/jibo/ui/fragment/wifi/InviteLoopMembersFragment_ViewBinding$1;

    invoke-direct {v0, p0, p1}, Lcom/jibo/ui/fragment/wifi/InviteLoopMembersFragment_ViewBinding$1;-><init>(Lcom/jibo/ui/fragment/wifi/InviteLoopMembersFragment_ViewBinding;Lcom/jibo/ui/fragment/wifi/InviteLoopMembersFragment;)V

    invoke-virtual {v1, v0}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 38
    const-string v0, "field \'btnInvitePeople\' and method \'btnInvitePeople\'"

    invoke-static {p2, v4, v0}, Lbutterknife/internal/Utils;->a(Landroid/view/View;ILjava/lang/String;)Landroid/view/View;

    move-result-object v1

    .line 39
    const-string v0, "field \'btnInvitePeople\'"

    const-class v2, Lcom/jibo/ui/view/proxima/CustomFontButton;

    invoke-static {v1, v4, v0, v2}, Lbutterknife/internal/Utils;->c(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/view/proxima/CustomFontButton;

    iput-object v0, p1, Lcom/jibo/ui/fragment/wifi/InviteLoopMembersFragment;->btnInvitePeople:Lcom/jibo/ui/view/proxima/CustomFontButton;

    .line 40
    iput-object v1, p0, Lcom/jibo/ui/fragment/wifi/InviteLoopMembersFragment_ViewBinding;->d:Landroid/view/View;

    .line 41
    new-instance v0, Lcom/jibo/ui/fragment/wifi/InviteLoopMembersFragment_ViewBinding$2;

    invoke-direct {v0, p0, p1}, Lcom/jibo/ui/fragment/wifi/InviteLoopMembersFragment_ViewBinding$2;-><init>(Lcom/jibo/ui/fragment/wifi/InviteLoopMembersFragment_ViewBinding;Lcom/jibo/ui/fragment/wifi/InviteLoopMembersFragment;)V

    invoke-virtual {v1, v0}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 47
    return-void
.end method


# virtual methods
.method public unbind()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 51
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/InviteLoopMembersFragment_ViewBinding;->b:Lcom/jibo/ui/fragment/wifi/InviteLoopMembersFragment;

    .line 52
    if-nez v0, :cond_0

    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Bindings already cleared."

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 53
    :cond_0
    iput-object v1, p0, Lcom/jibo/ui/fragment/wifi/InviteLoopMembersFragment_ViewBinding;->b:Lcom/jibo/ui/fragment/wifi/InviteLoopMembersFragment;

    .line 55
    iput-object v1, v0, Lcom/jibo/ui/fragment/wifi/InviteLoopMembersFragment;->closeButton:Landroid/widget/ImageView;

    .line 56
    iput-object v1, v0, Lcom/jibo/ui/fragment/wifi/InviteLoopMembersFragment;->btnInvitePeople:Lcom/jibo/ui/view/proxima/CustomFontButton;

    .line 58
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/InviteLoopMembersFragment_ViewBinding;->c:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 59
    iput-object v1, p0, Lcom/jibo/ui/fragment/wifi/InviteLoopMembersFragment_ViewBinding;->c:Landroid/view/View;

    .line 60
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/InviteLoopMembersFragment_ViewBinding;->d:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 61
    iput-object v1, p0, Lcom/jibo/ui/fragment/wifi/InviteLoopMembersFragment_ViewBinding;->d:Landroid/view/View;

    .line 63
    invoke-super {p0}, Lcom/jibo/ui/fragment/wifi/WiFiBaseFragment_ViewBinding;->unbind()V

    .line 64
    return-void
.end method
