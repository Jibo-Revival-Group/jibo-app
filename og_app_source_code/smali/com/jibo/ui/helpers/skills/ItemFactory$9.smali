.class Lcom/jibo/ui/helpers/skills/ItemFactory$9;
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
    .line 276
    iput-object p1, p0, Lcom/jibo/ui/helpers/skills/ItemFactory$9;->this$0:Lcom/jibo/ui/helpers/skills/ItemFactory;

    iput-object p2, p0, Lcom/jibo/ui/helpers/skills/ItemFactory$9;->val$dataItem:Lcom/jibo/ui/helpers/skills/DataItems$DataItem;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 5

    .prologue
    .line 279
    new-instance v1, Lcom/jibo/ui/fragment/dialog/skills/MaterialTimePickerDialogFragment;

    invoke-direct {v1}, Lcom/jibo/ui/fragment/dialog/skills/MaterialTimePickerDialogFragment;-><init>()V

    .line 280
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 281
    iget-object v2, p0, Lcom/jibo/ui/helpers/skills/ItemFactory$9;->val$dataItem:Lcom/jibo/ui/helpers/skills/DataItems$DataItem;

    invoke-virtual {v2}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v2

    invoke-static {}, Lcom/jibo/ui/helpers/skills/ItemFactory;->access$500()Lcom/google/gson/Gson;

    move-result-object v3

    iget-object v4, p0, Lcom/jibo/ui/helpers/skills/ItemFactory$9;->val$dataItem:Lcom/jibo/ui/helpers/skills/DataItems$DataItem;

    invoke-virtual {v3, v4}, Lcom/google/gson/Gson;->b(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 282
    const-string v2, "ARGS_SKILL_FRAGMENT"

    const/4 v3, 0x1

    invoke-virtual {v0, v2, v3}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 283
    invoke-virtual {v1, v0}, Lcom/jibo/ui/fragment/dialog/skills/MaterialTimePickerDialogFragment;->setArguments(Landroid/os/Bundle;)V

    .line 284
    invoke-virtual {p1}, Landroid/view/View;->getContext()Landroid/content/Context;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/activity/BaseActivity;

    invoke-virtual {v0}, Lcom/jibo/ui/activity/BaseActivity;->n()Landroid/support/v4/app/Fragment;

    move-result-object v0

    const/16 v2, 0x66

    invoke-virtual {v1, v0, v2}, Lcom/jibo/ui/fragment/dialog/skills/MaterialTimePickerDialogFragment;->setTargetFragment(Landroid/support/v4/app/Fragment;I)V

    .line 286
    invoke-virtual {p1}, Landroid/view/View;->getContext()Landroid/content/Context;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/activity/BaseActivity;

    invoke-virtual {v0}, Lcom/jibo/ui/activity/BaseActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    const-string v2, ""

    invoke-virtual {v1, v0, v2}, Lcom/jibo/ui/fragment/dialog/skills/MaterialTimePickerDialogFragment;->show(Landroid/support/v4/app/FragmentManager;Ljava/lang/String;)V

    .line 287
    return-void
.end method
