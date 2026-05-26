.class Lcom/jibo/ui/fragment/settings/LocationFragment$1$1$1;
.super Ljava/lang/Object;
.source "LocationFragment.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/settings/LocationFragment$1$1;->a(Lcom/jibo/aws/integration/aws/services/robotProperties/model/GetRobotRequest;Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/fragment/settings/LocationFragment$1$1;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/settings/LocationFragment$1$1;)V
    .locals 0

    .prologue
    .line 146
    iput-object p1, p0, Lcom/jibo/ui/fragment/settings/LocationFragment$1$1$1;->a:Lcom/jibo/ui/fragment/settings/LocationFragment$1$1;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 1

    .prologue
    .line 149
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/LocationFragment$1$1$1;->a:Lcom/jibo/ui/fragment/settings/LocationFragment$1$1;

    iget-object v0, v0, Lcom/jibo/ui/fragment/settings/LocationFragment$1$1;->c:Lcom/jibo/ui/fragment/settings/LocationFragment$1;

    iget-object v0, v0, Lcom/jibo/ui/fragment/settings/LocationFragment$1;->a:Lcom/jibo/ui/fragment/settings/LocationFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/settings/LocationFragment;->a()V

    .line 150
    return-void
.end method
