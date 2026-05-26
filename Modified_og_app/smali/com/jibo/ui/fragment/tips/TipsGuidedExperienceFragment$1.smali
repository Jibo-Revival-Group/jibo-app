.class Lcom/jibo/ui/fragment/tips/TipsGuidedExperienceFragment$1;
.super Landroid/text/style/ClickableSpan;
.source "TipsGuidedExperienceFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/tips/TipsGuidedExperienceFragment;->b()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/fragment/tips/TipsGuidedExperienceFragment;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/tips/TipsGuidedExperienceFragment;)V
    .locals 0

    .prologue
    .line 115
    iput-object p1, p0, Lcom/jibo/ui/fragment/tips/TipsGuidedExperienceFragment$1;->a:Lcom/jibo/ui/fragment/tips/TipsGuidedExperienceFragment;

    invoke-direct {p0}, Landroid/text/style/ClickableSpan;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 5

    .prologue
    .line 118
    iget-object v0, p0, Lcom/jibo/ui/fragment/tips/TipsGuidedExperienceFragment$1;->a:Lcom/jibo/ui/fragment/tips/TipsGuidedExperienceFragment;

    new-instance v1, Landroid/content/Intent;

    const-string v2, "android.intent.action.VIEW"

    iget-object v3, p0, Lcom/jibo/ui/fragment/tips/TipsGuidedExperienceFragment$1;->a:Lcom/jibo/ui/fragment/tips/TipsGuidedExperienceFragment;

    const v4, 0x7f10016d

    invoke-virtual {v3, v4}, Lcom/jibo/ui/fragment/tips/TipsGuidedExperienceFragment;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v3

    invoke-direct {v1, v2, v3}, Landroid/content/Intent;-><init>(Ljava/lang/String;Landroid/net/Uri;)V

    invoke-virtual {v0, v1}, Lcom/jibo/ui/fragment/tips/TipsGuidedExperienceFragment;->startActivity(Landroid/content/Intent;)V

    .line 119
    return-void
.end method

.method public updateDrawState(Landroid/text/TextPaint;)V
    .locals 1

    .prologue
    .line 122
    const/4 v0, 0x0

    invoke-virtual {p1, v0}, Landroid/text/TextPaint;->setUnderlineText(Z)V

    .line 123
    return-void
.end method
