.class public Lcom/jibo/ui/fragment/invite/LegalGuardianFragment_ViewBinding;
.super Ljava/lang/Object;
.source "LegalGuardianFragment_ViewBinding.java"

# interfaces
.implements Lbutterknife/Unbinder;


# instance fields
.field private b:Lcom/jibo/ui/fragment/invite/LegalGuardianFragment;


# direct methods
.method public constructor <init>(Lcom/jibo/ui/fragment/invite/LegalGuardianFragment;Landroid/view/View;)V
    .locals 3

    .prologue
    .line 19
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 20
    iput-object p1, p0, Lcom/jibo/ui/fragment/invite/LegalGuardianFragment_ViewBinding;->b:Lcom/jibo/ui/fragment/invite/LegalGuardianFragment;

    .line 22
    const v0, 0x1020014

    const-string v1, "field \'name\'"

    const-class v2, Landroid/widget/TextView;

    invoke-static {p2, v0, v1, v2}, Lbutterknife/internal/Utils;->b(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p1, Lcom/jibo/ui/fragment/invite/LegalGuardianFragment;->name:Landroid/widget/TextView;

    .line 23
    const v0, 0x1020015

    const-string v1, "field \'email\'"

    const-class v2, Landroid/widget/TextView;

    invoke-static {p2, v0, v1, v2}, Lbutterknife/internal/Utils;->b(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p1, Lcom/jibo/ui/fragment/invite/LegalGuardianFragment;->email:Landroid/widget/TextView;

    .line 24
    const v0, 0x1020006

    const-string v1, "field \'avatar\'"

    const-class v2, Landroid/widget/ImageView;

    invoke-static {p2, v0, v1, v2}, Lbutterknife/internal/Utils;->b(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p1, Lcom/jibo/ui/fragment/invite/LegalGuardianFragment;->avatar:Landroid/widget/ImageView;

    .line 25
    const v0, 0x7f0901b6

    const-string v1, "field \'legalGuardianInfo\'"

    const-class v2, Landroid/widget/TextView;

    invoke-static {p2, v0, v1, v2}, Lbutterknife/internal/Utils;->b(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p1, Lcom/jibo/ui/fragment/invite/LegalGuardianFragment;->legalGuardianInfo:Landroid/widget/TextView;

    .line 26
    const v0, 0x7f0901b8

    const-string v1, "field \'legalGuardianTitle\'"

    const-class v2, Landroid/widget/TextView;

    invoke-static {p2, v0, v1, v2}, Lbutterknife/internal/Utils;->b(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p1, Lcom/jibo/ui/fragment/invite/LegalGuardianFragment;->legalGuardianTitle:Landroid/widget/TextView;

    .line 27
    return-void
.end method


# virtual methods
.method public unbind()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 32
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/LegalGuardianFragment_ViewBinding;->b:Lcom/jibo/ui/fragment/invite/LegalGuardianFragment;

    .line 33
    if-nez v0, :cond_0

    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Bindings already cleared."

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 34
    :cond_0
    iput-object v1, p0, Lcom/jibo/ui/fragment/invite/LegalGuardianFragment_ViewBinding;->b:Lcom/jibo/ui/fragment/invite/LegalGuardianFragment;

    .line 36
    iput-object v1, v0, Lcom/jibo/ui/fragment/invite/LegalGuardianFragment;->name:Landroid/widget/TextView;

    .line 37
    iput-object v1, v0, Lcom/jibo/ui/fragment/invite/LegalGuardianFragment;->email:Landroid/widget/TextView;

    .line 38
    iput-object v1, v0, Lcom/jibo/ui/fragment/invite/LegalGuardianFragment;->avatar:Landroid/widget/ImageView;

    .line 39
    iput-object v1, v0, Lcom/jibo/ui/fragment/invite/LegalGuardianFragment;->legalGuardianInfo:Landroid/widget/TextView;

    .line 40
    iput-object v1, v0, Lcom/jibo/ui/fragment/invite/LegalGuardianFragment;->legalGuardianTitle:Landroid/widget/TextView;

    .line 41
    return-void
.end method
