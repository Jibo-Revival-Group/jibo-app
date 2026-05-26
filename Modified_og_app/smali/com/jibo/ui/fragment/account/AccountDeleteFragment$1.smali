.class Lcom/jibo/ui/fragment/account/AccountDeleteFragment$1;
.super Landroid/text/style/ClickableSpan;
.source "AccountDeleteFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/account/AccountDeleteFragment;->a()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/fragment/account/AccountDeleteFragment;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/account/AccountDeleteFragment;)V
    .locals 0

    .prologue
    .line 128
    iput-object p1, p0, Lcom/jibo/ui/fragment/account/AccountDeleteFragment$1;->a:Lcom/jibo/ui/fragment/account/AccountDeleteFragment;

    invoke-direct {p0}, Landroid/text/style/ClickableSpan;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 3

    .prologue
    .line 131
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/AccountDeleteFragment$1;->a:Lcom/jibo/ui/fragment/account/AccountDeleteFragment;

    const v1, 0x7f1002e8

    invoke-virtual {v0, v1}, Lcom/jibo/ui/fragment/account/AccountDeleteFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    .line 132
    new-instance v1, Landroid/content/Intent;

    const-string v2, "android.intent.action.VIEW"

    invoke-direct {v1, v2, v0}, Landroid/content/Intent;-><init>(Ljava/lang/String;Landroid/net/Uri;)V

    .line 133
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/AccountDeleteFragment$1;->a:Lcom/jibo/ui/fragment/account/AccountDeleteFragment;

    invoke-virtual {v0, v1}, Lcom/jibo/ui/fragment/account/AccountDeleteFragment;->startActivity(Landroid/content/Intent;)V

    .line 135
    return-void
.end method

.method public updateDrawState(Landroid/text/TextPaint;)V
    .locals 1

    .prologue
    .line 138
    const/4 v0, 0x0

    invoke-virtual {p1, v0}, Landroid/text/TextPaint;->setUnderlineText(Z)V

    .line 139
    return-void
.end method
