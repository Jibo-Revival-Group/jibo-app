.class Lcom/jibo/ui/fragment/account/AccountSettingsFragment$1$1;
.super Ljava/lang/Object;
.source "AccountSettingsFragment.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/account/AccountSettingsFragment$1;->onError(Ljava/lang/Exception;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/fragment/account/AccountSettingsFragment$1;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/account/AccountSettingsFragment$1;)V
    .locals 0

    .prologue
    .line 176
    iput-object p1, p0, Lcom/jibo/ui/fragment/account/AccountSettingsFragment$1$1;->a:Lcom/jibo/ui/fragment/account/AccountSettingsFragment$1;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 1

    .prologue
    .line 179
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/AccountSettingsFragment$1$1;->a:Lcom/jibo/ui/fragment/account/AccountSettingsFragment$1;

    iget-object v0, v0, Lcom/jibo/ui/fragment/account/AccountSettingsFragment$1;->a:Lcom/jibo/ui/fragment/account/AccountSettingsFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/account/AccountSettingsFragment;->g()V

    .line 180
    return-void
.end method
