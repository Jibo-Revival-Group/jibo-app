.class Lcom/jibo/ui/fragment/account/skills/LocationFragment$2;
.super Ljava/lang/Object;
.source "LocationFragment.java"

# interfaces
.implements Lcom/jibo/ui/fragment/settings/LocationFragment$ManualLocationFragmentListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/account/skills/LocationFragment;->setManuallyClick(Landroid/view/View;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/fragment/account/skills/LocationFragment;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/account/skills/LocationFragment;)V
    .locals 0

    .prologue
    .line 193
    iput-object p1, p0, Lcom/jibo/ui/fragment/account/skills/LocationFragment$2;->a:Lcom/jibo/ui/fragment/account/skills/LocationFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Lcom/jibo/ui/activity/SingleFragmentActivity$Builder;)V
    .locals 2

    .prologue
    .line 196
    const-string v0, "ARGS_SKILL_FRAGMENT"

    const/4 v1, 0x1

    invoke-virtual {p1, v0, v1}, Lcom/jibo/ui/activity/SingleFragmentActivity$Builder;->a(Ljava/lang/String;Z)Lcom/jibo/ui/activity/SingleFragmentActivity$Builder;

    .line 197
    return-void
.end method
