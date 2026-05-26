.class Lcom/jibo/ui/fragment/account/skills/LocationFragment$1$1$1;
.super Ljava/lang/Object;
.source "LocationFragment.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/account/skills/LocationFragment$1$1;->a(Lcom/jibo/aws/integration/aws/services/skills/model/UpdateSettingsRequest;Lcom/jibo/aws/integration/aws/services/skills/model/UpdateSettingsRequest$UpdateSettingData;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/fragment/account/skills/LocationFragment$1$1;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/account/skills/LocationFragment$1$1;)V
    .locals 0

    .prologue
    .line 122
    iput-object p1, p0, Lcom/jibo/ui/fragment/account/skills/LocationFragment$1$1$1;->a:Lcom/jibo/ui/fragment/account/skills/LocationFragment$1$1;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 125
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/LocationFragment$1$1$1;->a:Lcom/jibo/ui/fragment/account/skills/LocationFragment$1$1;

    iget-object v0, v0, Lcom/jibo/ui/fragment/account/skills/LocationFragment$1$1;->c:Lcom/jibo/ui/fragment/account/skills/LocationFragment$1;

    iget-object v0, v0, Lcom/jibo/ui/fragment/account/skills/LocationFragment$1;->a:Lcom/jibo/ui/fragment/account/skills/LocationFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/account/skills/LocationFragment;->a()V

    .line 127
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/LocationFragment$1$1$1;->a:Lcom/jibo/ui/fragment/account/skills/LocationFragment$1$1;

    iget-object v0, v0, Lcom/jibo/ui/fragment/account/skills/LocationFragment$1$1;->c:Lcom/jibo/ui/fragment/account/skills/LocationFragment$1;

    iget-object v0, v0, Lcom/jibo/ui/fragment/account/skills/LocationFragment$1;->a:Lcom/jibo/ui/fragment/account/skills/LocationFragment;

    const v1, 0x7f10020c

    invoke-virtual {v0, v1}, Lcom/jibo/ui/fragment/account/skills/LocationFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    .line 128
    iget-object v1, p0, Lcom/jibo/ui/fragment/account/skills/LocationFragment$1$1$1;->a:Lcom/jibo/ui/fragment/account/skills/LocationFragment$1$1;

    iget-object v1, v1, Lcom/jibo/ui/fragment/account/skills/LocationFragment$1$1;->c:Lcom/jibo/ui/fragment/account/skills/LocationFragment$1;

    iget-object v1, v1, Lcom/jibo/ui/fragment/account/skills/LocationFragment$1;->a:Lcom/jibo/ui/fragment/account/skills/LocationFragment;

    invoke-static {v1}, Lcom/jibo/ui/fragment/account/skills/LocationFragment;->d(Lcom/jibo/ui/fragment/account/skills/LocationFragment;)Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    move-result-object v1

    invoke-virtual {v1, v0}, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;->a(Ljava/lang/String;)V

    .line 129
    return-void
.end method
