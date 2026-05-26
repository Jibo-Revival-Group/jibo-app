.class Lcom/jibo/ui/fragment/account/AccountSettingsFragment$2;
.super Ljava/lang/Object;
.source "AccountSettingsFragment.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/account/AccountSettingsFragment;->q()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/fragment/account/AccountSettingsFragment;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/account/AccountSettingsFragment;)V
    .locals 0

    .prologue
    .line 240
    iput-object p1, p0, Lcom/jibo/ui/fragment/account/AccountSettingsFragment$2;->a:Lcom/jibo/ui/fragment/account/AccountSettingsFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 3

    .prologue
    .line 243
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/AccountSettingsFragment$2;->a:Lcom/jibo/ui/fragment/account/AccountSettingsFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/account/AccountSettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/activity/BaseActivity;

    const-class v1, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Lcom/jibo/ui/activity/BaseActivity;->c(Ljava/lang/Class;Landroid/os/Bundle;)V

    .line 244
    return-void
.end method
