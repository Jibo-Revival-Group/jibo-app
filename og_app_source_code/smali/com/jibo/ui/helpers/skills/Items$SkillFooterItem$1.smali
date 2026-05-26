.class Lcom/jibo/ui/helpers/skills/Items$SkillFooterItem$1;
.super Landroid/text/style/ClickableSpan;
.source "Items.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/helpers/skills/Items$SkillFooterItem;->getTitle()Ljava/lang/CharSequence;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/jibo/ui/helpers/skills/Items$SkillFooterItem;

.field final synthetic val$intentLink:Lcom/jibo/ui/helpers/skills/DataItems$FooterDataItem$Link;


# direct methods
.method constructor <init>(Lcom/jibo/ui/helpers/skills/Items$SkillFooterItem;Lcom/jibo/ui/helpers/skills/DataItems$FooterDataItem$Link;)V
    .locals 0

    .prologue
    .line 111
    iput-object p1, p0, Lcom/jibo/ui/helpers/skills/Items$SkillFooterItem$1;->this$0:Lcom/jibo/ui/helpers/skills/Items$SkillFooterItem;

    iput-object p2, p0, Lcom/jibo/ui/helpers/skills/Items$SkillFooterItem$1;->val$intentLink:Lcom/jibo/ui/helpers/skills/DataItems$FooterDataItem$Link;

    invoke-direct {p0}, Landroid/text/style/ClickableSpan;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 3

    .prologue
    .line 114
    iget-object v0, p0, Lcom/jibo/ui/helpers/skills/Items$SkillFooterItem$1;->val$intentLink:Lcom/jibo/ui/helpers/skills/DataItems$FooterDataItem$Link;

    .line 115
    invoke-virtual {v0}, Lcom/jibo/ui/helpers/skills/DataItems$FooterDataItem$Link;->getPlaceholder()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/jibo/ui/helpers/skills/SkillsJsonParser$TextLinksMatcher;->getClassForPlaceholder(Ljava/lang/String;)Ljava/lang/Class;

    move-result-object v0

    .line 117
    if-eqz v0, :cond_1

    .line 118
    new-instance v1, Lcom/jibo/ui/activity/SingleFragmentActivity$Builder;

    invoke-virtual {p1}, Landroid/view/View;->getContext()Landroid/content/Context;

    move-result-object v2

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    invoke-direct {v1, v2, v0}, Lcom/jibo/ui/activity/SingleFragmentActivity$Builder;-><init>(Landroid/content/Context;Ljava/lang/String;)V

    const/16 v0, 0x3e7

    .line 119
    invoke-virtual {v1, v0}, Lcom/jibo/ui/activity/SingleFragmentActivity$Builder;->a(I)V

    .line 130
    :cond_0
    :goto_0
    return-void

    .line 120
    :cond_1
    iget-object v0, p0, Lcom/jibo/ui/helpers/skills/Items$SkillFooterItem$1;->val$intentLink:Lcom/jibo/ui/helpers/skills/DataItems$FooterDataItem$Link;

    invoke-virtual {v0}, Lcom/jibo/ui/helpers/skills/DataItems$FooterDataItem$Link;->getUrl()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 122
    :try_start_0
    iget-object v0, p0, Lcom/jibo/ui/helpers/skills/Items$SkillFooterItem$1;->val$intentLink:Lcom/jibo/ui/helpers/skills/DataItems$FooterDataItem$Link;

    invoke-virtual {v0}, Lcom/jibo/ui/helpers/skills/DataItems$FooterDataItem$Link;->getUrl()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    .line 123
    new-instance v1, Landroid/content/Intent;

    const-string v2, "android.intent.action.VIEW"

    invoke-direct {v1, v2, v0}, Landroid/content/Intent;-><init>(Ljava/lang/String;Landroid/net/Uri;)V

    .line 124
    invoke-virtual {p1}, Landroid/view/View;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-virtual {v0, v1}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 125
    :catch_0
    move-exception v0

    .line 126
    invoke-static {v0}, Lcom/crashlytics/android/Crashlytics;->a(Ljava/lang/Throwable;)V

    goto :goto_0
.end method

.method public updateDrawState(Landroid/text/TextPaint;)V
    .locals 1

    .prologue
    .line 133
    const/4 v0, 0x0

    invoke-virtual {p1, v0}, Landroid/text/TextPaint;->setUnderlineText(Z)V

    .line 134
    return-void
.end method
