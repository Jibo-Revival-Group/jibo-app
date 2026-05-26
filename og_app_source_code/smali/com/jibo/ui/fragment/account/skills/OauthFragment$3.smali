.class Lcom/jibo/ui/fragment/account/skills/OauthFragment$3;
.super Ljava/lang/Object;
.source "OauthFragment.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/account/skills/OauthFragment;->onResume()V
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
    .line 220
    iput-object p1, p0, Lcom/jibo/ui/fragment/account/skills/OauthFragment$3;->a:Lcom/jibo/ui/fragment/account/skills/OauthFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 1

    .prologue
    .line 223
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/OauthFragment$3;->a:Lcom/jibo/ui/fragment/account/skills/OauthFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/account/skills/OauthFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentActivity;->onBackPressed()V

    .line 224
    return-void
.end method
