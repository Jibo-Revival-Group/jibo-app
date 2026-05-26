.class Lcom/jibo/ui/helpers/skills/ItemFactory$8;
.super Ljava/lang/Object;
.source "ItemFactory.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/helpers/skills/ItemFactory;->getOnClickLister(Lcom/jibo/ui/helpers/skills/DataItems$DataItem;I)Landroid/view/View$OnClickListener;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/jibo/ui/helpers/skills/ItemFactory;

.field final synthetic val$dataItem:Lcom/jibo/ui/helpers/skills/DataItems$DataItem;


# direct methods
.method constructor <init>(Lcom/jibo/ui/helpers/skills/ItemFactory;Lcom/jibo/ui/helpers/skills/DataItems$DataItem;)V
    .locals 0

    .prologue
    .line 257
    iput-object p1, p0, Lcom/jibo/ui/helpers/skills/ItemFactory$8;->this$0:Lcom/jibo/ui/helpers/skills/ItemFactory;

    iput-object p2, p0, Lcom/jibo/ui/helpers/skills/ItemFactory$8;->val$dataItem:Lcom/jibo/ui/helpers/skills/DataItems$DataItem;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 4

    .prologue
    .line 260
    invoke-virtual {p1}, Landroid/view/View;->getContext()Landroid/content/Context;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/activity/BaseActivity;

    invoke-virtual {v0}, Lcom/jibo/ui/activity/BaseActivity;->n()Landroid/support/v4/app/Fragment;

    move-result-object v0

    instance-of v0, v0, Lcom/jibo/ui/fragment/account/skills/SkillSettingsFragment;

    if-eqz v0, :cond_0

    .line 261
    new-instance v1, Landroid/os/Bundle;

    invoke-direct {v1}, Landroid/os/Bundle;-><init>()V

    .line 262
    invoke-static {}, Lcom/jibo/ui/helpers/skills/SkillsJsonParser;->getInstance()Lcom/jibo/ui/helpers/skills/SkillsJsonParser;

    move-result-object v2

    invoke-virtual {p1}, Landroid/view/View;->getContext()Landroid/content/Context;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/activity/BaseActivity;

    .line 263
    invoke-virtual {v0}, Lcom/jibo/ui/activity/BaseActivity;->n()Landroid/support/v4/app/Fragment;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/fragment/account/skills/SkillSettingsFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/account/skills/SkillSettingsFragment;->a()[I

    move-result-object v0

    .line 262
    invoke-virtual {v2, v0}, Lcom/jibo/ui/helpers/skills/SkillsJsonParser;->getView([I)Lcom/jibo/ui/helpers/skills/DataItems$DataItem;

    move-result-object v0

    .line 264
    invoke-virtual {v0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v2

    invoke-static {}, Lcom/jibo/ui/helpers/skills/ItemFactory;->access$500()Lcom/google/gson/Gson;

    move-result-object v3

    invoke-virtual {v3, v0}, Lcom/google/gson/Gson;->b(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v2, v0}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 265
    const-class v0, Lcom/jibo/ui/helpers/skills/DataItems$OauthDataItem;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    invoke-static {}, Lcom/jibo/ui/helpers/skills/ItemFactory;->access$500()Lcom/google/gson/Gson;

    move-result-object v2

    iget-object v3, p0, Lcom/jibo/ui/helpers/skills/ItemFactory$8;->val$dataItem:Lcom/jibo/ui/helpers/skills/DataItems$DataItem;

    invoke-virtual {v2, v3}, Lcom/google/gson/Gson;->b(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v0, v2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 267
    iget-object v0, p0, Lcom/jibo/ui/helpers/skills/ItemFactory$8;->val$dataItem:Lcom/jibo/ui/helpers/skills/DataItems$DataItem;

    invoke-virtual {v0}, Lcom/jibo/ui/helpers/skills/DataItems$DataItem;->getValueDefinition()Lcom/jibo/ui/helpers/skills/DataItems$ValueDefinition;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/ui/helpers/skills/DataItems$ValueDefinition;->getKey()Ljava/lang/String;

    move-result-object v0

    const-string v2, "google"

    invoke-virtual {v0, v2}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 268
    invoke-virtual {p1}, Landroid/view/View;->getContext()Landroid/content/Context;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/activity/BaseActivity;

    const-class v2, Lcom/jibo/ui/fragment/account/skills/OauthFragment;

    invoke-virtual {v0, v2, v1}, Lcom/jibo/ui/activity/BaseActivity;->b(Ljava/lang/Class;Landroid/os/Bundle;)V

    .line 273
    :cond_0
    :goto_0
    return-void

    .line 270
    :cond_1
    invoke-virtual {p1}, Landroid/view/View;->getContext()Landroid/content/Context;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/activity/BaseActivity;

    const-class v2, Lcom/jibo/ui/fragment/account/skills/OauthFragment;

    invoke-virtual {v0, v2, v1}, Lcom/jibo/ui/activity/BaseActivity;->c(Ljava/lang/Class;Landroid/os/Bundle;)V

    goto :goto_0
.end method
