.class Lcom/jibo/ui/fragment/settings/ConfirmPasswordFragment$2$1;
.super Ljava/lang/Object;
.source "ConfirmPasswordFragment.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/settings/ConfirmPasswordFragment$2;->onError(Ljava/lang/Exception;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/fragment/settings/ConfirmPasswordFragment$2;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/settings/ConfirmPasswordFragment$2;)V
    .locals 0

    .prologue
    .line 182
    iput-object p1, p0, Lcom/jibo/ui/fragment/settings/ConfirmPasswordFragment$2$1;->a:Lcom/jibo/ui/fragment/settings/ConfirmPasswordFragment$2;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 1

    .prologue
    .line 185
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/ConfirmPasswordFragment$2$1;->a:Lcom/jibo/ui/fragment/settings/ConfirmPasswordFragment$2;

    iget-object v0, v0, Lcom/jibo/ui/fragment/settings/ConfirmPasswordFragment$2;->a:Lcom/jibo/ui/fragment/settings/ConfirmPasswordFragment;

    invoke-static {v0}, Lcom/jibo/ui/fragment/settings/ConfirmPasswordFragment;->a(Lcom/jibo/ui/fragment/settings/ConfirmPasswordFragment;)V

    .line 186
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/ConfirmPasswordFragment$2$1;->a:Lcom/jibo/ui/fragment/settings/ConfirmPasswordFragment$2;

    iget-object v0, v0, Lcom/jibo/ui/fragment/settings/ConfirmPasswordFragment$2;->a:Lcom/jibo/ui/fragment/settings/ConfirmPasswordFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/settings/ConfirmPasswordFragment;->g()V

    .line 187
    return-void
.end method
