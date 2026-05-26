.class Lcom/jibo/ui/fragment/guided/LocationSlideFragment$1;
.super Landroid/text/style/ClickableSpan;
.source "LocationSlideFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/guided/LocationSlideFragment;->onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/fragment/guided/LocationSlideFragment;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/guided/LocationSlideFragment;)V
    .locals 0

    .prologue
    .line 71
    iput-object p1, p0, Lcom/jibo/ui/fragment/guided/LocationSlideFragment$1;->a:Lcom/jibo/ui/fragment/guided/LocationSlideFragment;

    invoke-direct {p0}, Landroid/text/style/ClickableSpan;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 5

    .prologue
    .line 74
    iget-object v0, p0, Lcom/jibo/ui/fragment/guided/LocationSlideFragment$1;->a:Lcom/jibo/ui/fragment/guided/LocationSlideFragment;

    new-instance v1, Landroid/content/Intent;

    const-string v2, "android.intent.action.VIEW"

    iget-object v3, p0, Lcom/jibo/ui/fragment/guided/LocationSlideFragment$1;->a:Lcom/jibo/ui/fragment/guided/LocationSlideFragment;

    const v4, 0x7f10016d

    invoke-virtual {v3, v4}, Lcom/jibo/ui/fragment/guided/LocationSlideFragment;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v3

    invoke-direct {v1, v2, v3}, Landroid/content/Intent;-><init>(Ljava/lang/String;Landroid/net/Uri;)V

    invoke-virtual {v0, v1}, Lcom/jibo/ui/fragment/guided/LocationSlideFragment;->startActivity(Landroid/content/Intent;)V

    .line 75
    return-void
.end method

.method public updateDrawState(Landroid/text/TextPaint;)V
    .locals 1

    .prologue
    .line 78
    const/4 v0, 0x0

    invoke-virtual {p1, v0}, Landroid/text/TextPaint;->setUnderlineText(Z)V

    .line 79
    return-void
.end method
