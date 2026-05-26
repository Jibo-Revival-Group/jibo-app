.class public Lcom/jibo/ui/fragment/settings/ChangeEmailFragment_ViewBinding;
.super Ljava/lang/Object;
.source "ChangeEmailFragment_ViewBinding.java"

# interfaces
.implements Lbutterknife/Unbinder;


# instance fields
.field private b:Lcom/jibo/ui/fragment/settings/ChangeEmailFragment;


# direct methods
.method public constructor <init>(Lcom/jibo/ui/fragment/settings/ChangeEmailFragment;Landroid/view/View;)V
    .locals 3

    .prologue
    .line 19
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 20
    iput-object p1, p0, Lcom/jibo/ui/fragment/settings/ChangeEmailFragment_ViewBinding;->b:Lcom/jibo/ui/fragment/settings/ChangeEmailFragment;

    .line 22
    const v0, 0x7f090122

    const-string v1, "field \'email\'"

    const-class v2, Landroid/widget/EditText;

    invoke-static {p2, v0, v1, v2}, Lbutterknife/internal/Utils;->b(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/EditText;

    iput-object v0, p1, Lcom/jibo/ui/fragment/settings/ChangeEmailFragment;->email:Landroid/widget/EditText;

    .line 23
    const v0, 0x7f09013a

    const-string v1, "field \'footer\'"

    const-class v2, Landroid/widget/TextView;

    invoke-static {p2, v0, v1, v2}, Lbutterknife/internal/Utils;->b(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p1, Lcom/jibo/ui/fragment/settings/ChangeEmailFragment;->footer:Landroid/widget/TextView;

    .line 24
    const v0, 0x7f09013b

    const-string v1, "field \'footerError\'"

    const-class v2, Landroid/widget/TextView;

    invoke-static {p2, v0, v1, v2}, Lbutterknife/internal/Utils;->b(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p1, Lcom/jibo/ui/fragment/settings/ChangeEmailFragment;->footerError:Landroid/widget/TextView;

    .line 25
    return-void
.end method


# virtual methods
.method public unbind()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 30
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/ChangeEmailFragment_ViewBinding;->b:Lcom/jibo/ui/fragment/settings/ChangeEmailFragment;

    .line 31
    if-nez v0, :cond_0

    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Bindings already cleared."

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 32
    :cond_0
    iput-object v1, p0, Lcom/jibo/ui/fragment/settings/ChangeEmailFragment_ViewBinding;->b:Lcom/jibo/ui/fragment/settings/ChangeEmailFragment;

    .line 34
    iput-object v1, v0, Lcom/jibo/ui/fragment/settings/ChangeEmailFragment;->email:Landroid/widget/EditText;

    .line 35
    iput-object v1, v0, Lcom/jibo/ui/fragment/settings/ChangeEmailFragment;->footer:Landroid/widget/TextView;

    .line 36
    iput-object v1, v0, Lcom/jibo/ui/fragment/settings/ChangeEmailFragment;->footerError:Landroid/widget/TextView;

    .line 37
    return-void
.end method
