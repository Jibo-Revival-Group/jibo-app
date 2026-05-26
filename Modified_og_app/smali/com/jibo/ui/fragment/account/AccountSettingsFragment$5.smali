.class Lcom/jibo/ui/fragment/account/AccountSettingsFragment$5;
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
    .line 296
    iput-object p1, p0, Lcom/jibo/ui/fragment/account/AccountSettingsFragment$5;->a:Lcom/jibo/ui/fragment/account/AccountSettingsFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 2

    .prologue
    .line 299
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/AccountSettingsFragment$5;->a:Lcom/jibo/ui/fragment/account/AccountSettingsFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/account/AccountSettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    sget-object v1, Lcom/jibo/JiboAnalytics;->aJ:Ljava/lang/String;

    invoke-static {v0, v1}, Lcom/jibo/JiboAnalytics;->e(Landroid/content/Context;Ljava/lang/String;)V

    .line 300
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/AccountSettingsFragment$5;->a:Lcom/jibo/ui/fragment/account/AccountSettingsFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/account/AccountSettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-static {v0}, Lcom/jibo/JiboSupport;->b(Landroid/content/Context;)V

    .line 301
    return-void
.end method
