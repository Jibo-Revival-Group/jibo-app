.class Lcom/jibo/ui/fragment/account/skills/OauthFragment$2;
.super Ljava/lang/Object;
.source "OauthFragment.java"

# interfaces
.implements Landroid/content/DialogInterface$OnDismissListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/account/skills/OauthFragment;->onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/fragment/account/skills/OauthFragment;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/account/skills/OauthFragment;)V
    .locals 0

    .prologue
    .line 156
    iput-object p1, p0, Lcom/jibo/ui/fragment/account/skills/OauthFragment$2;->a:Lcom/jibo/ui/fragment/account/skills/OauthFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onDismiss(Landroid/content/DialogInterface;)V
    .locals 1

    .prologue
    .line 159
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/OauthFragment$2;->a:Lcom/jibo/ui/fragment/account/skills/OauthFragment;

    invoke-static {v0}, Lcom/jibo/ui/fragment/account/skills/OauthFragment;->d(Lcom/jibo/ui/fragment/account/skills/OauthFragment;)V

    .line 160
    return-void
.end method
