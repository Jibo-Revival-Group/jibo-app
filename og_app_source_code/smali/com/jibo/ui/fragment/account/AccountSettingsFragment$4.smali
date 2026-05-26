.class Lcom/jibo/ui/fragment/account/AccountSettingsFragment$4;
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
    .line 287
    iput-object p1, p0, Lcom/jibo/ui/fragment/account/AccountSettingsFragment$4;->a:Lcom/jibo/ui/fragment/account/AccountSettingsFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 1

    .prologue
    .line 290
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/AccountSettingsFragment$4;->a:Lcom/jibo/ui/fragment/account/AccountSettingsFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/account/AccountSettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-static {v0}, Lcom/jibo/JiboAnalytics;->h(Landroid/content/Context;)V

    .line 292
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/AccountSettingsFragment$4;->a:Lcom/jibo/ui/fragment/account/AccountSettingsFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/account/AccountSettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-static {v0}, Lcom/jibo/JiboSupport;->a(Landroid/app/Activity;)V

    .line 293
    return-void
.end method
