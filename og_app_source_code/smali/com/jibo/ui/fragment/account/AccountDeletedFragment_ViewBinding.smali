.class public Lcom/jibo/ui/fragment/account/AccountDeletedFragment_ViewBinding;
.super Ljava/lang/Object;
.source "AccountDeletedFragment_ViewBinding.java"

# interfaces
.implements Lbutterknife/Unbinder;


# instance fields
.field private b:Lcom/jibo/ui/fragment/account/AccountDeletedFragment;

.field private c:Landroid/view/View;


# direct methods
.method public constructor <init>(Lcom/jibo/ui/fragment/account/AccountDeletedFragment;Landroid/view/View;)V
    .locals 4

    .prologue
    const v3, 0x1020027

    .line 20
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 21
    iput-object p1, p0, Lcom/jibo/ui/fragment/account/AccountDeletedFragment_ViewBinding;->b:Lcom/jibo/ui/fragment/account/AccountDeletedFragment;

    .line 24
    const-string v0, "field \'closeButton\' and method \'onCloseButtonClick\'"

    invoke-static {p2, v3, v0}, Lbutterknife/internal/Utils;->a(Landroid/view/View;ILjava/lang/String;)Landroid/view/View;

    move-result-object v1

    .line 25
    const-string v0, "field \'closeButton\'"

    const-class v2, Landroid/widget/ImageView;

    invoke-static {v1, v3, v0, v2}, Lbutterknife/internal/Utils;->c(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p1, Lcom/jibo/ui/fragment/account/AccountDeletedFragment;->closeButton:Landroid/widget/ImageView;

    .line 26
    iput-object v1, p0, Lcom/jibo/ui/fragment/account/AccountDeletedFragment_ViewBinding;->c:Landroid/view/View;

    .line 27
    new-instance v0, Lcom/jibo/ui/fragment/account/AccountDeletedFragment_ViewBinding$1;

    invoke-direct {v0, p0, p1}, Lcom/jibo/ui/fragment/account/AccountDeletedFragment_ViewBinding$1;-><init>(Lcom/jibo/ui/fragment/account/AccountDeletedFragment_ViewBinding;Lcom/jibo/ui/fragment/account/AccountDeletedFragment;)V

    invoke-virtual {v1, v0}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 33
    return-void
.end method


# virtual methods
.method public unbind()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 38
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/AccountDeletedFragment_ViewBinding;->b:Lcom/jibo/ui/fragment/account/AccountDeletedFragment;

    .line 39
    if-nez v0, :cond_0

    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Bindings already cleared."

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 40
    :cond_0
    iput-object v1, p0, Lcom/jibo/ui/fragment/account/AccountDeletedFragment_ViewBinding;->b:Lcom/jibo/ui/fragment/account/AccountDeletedFragment;

    .line 42
    iput-object v1, v0, Lcom/jibo/ui/fragment/account/AccountDeletedFragment;->closeButton:Landroid/widget/ImageView;

    .line 44
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/AccountDeletedFragment_ViewBinding;->c:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 45
    iput-object v1, p0, Lcom/jibo/ui/fragment/account/AccountDeletedFragment_ViewBinding;->c:Landroid/view/View;

    .line 46
    return-void
.end method
