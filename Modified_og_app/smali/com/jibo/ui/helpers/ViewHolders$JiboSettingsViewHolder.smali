.class public Lcom/jibo/ui/helpers/ViewHolders$JiboSettingsViewHolder;
.super Lcom/jibo/ui/helpers/ViewHolders$AbstractViewHolder;
.source "ViewHolders.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/ui/helpers/ViewHolders;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "JiboSettingsViewHolder"
.end annotation


# instance fields
.field public avatar:Landroid/widget/ImageView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field


# direct methods
.method public constructor <init>(Landroid/view/View;)V
    .locals 0

    .prologue
    .line 383
    invoke-direct {p0, p1}, Lcom/jibo/ui/helpers/ViewHolders$AbstractViewHolder;-><init>(Landroid/view/View;)V

    .line 384
    return-void
.end method


# virtual methods
.method public invalidateView()V
    .locals 2

    .prologue
    .line 388
    iget-object v0, p0, Lcom/jibo/ui/helpers/ViewHolders$JiboSettingsViewHolder;->mItem:Lcom/jibo/ui/helpers/Items$Item;

    check-cast v0, Lcom/jibo/ui/helpers/Items$JiboSettingsItem;

    .line 390
    invoke-virtual {v0}, Lcom/jibo/ui/helpers/Items$JiboSettingsItem;->a()Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;

    move-result-object v1

    if-eqz v1, :cond_0

    .line 391
    iget-object v1, p0, Lcom/jibo/ui/helpers/ViewHolders$JiboSettingsViewHolder;->avatar:Landroid/widget/ImageView;

    invoke-virtual {v0}, Lcom/jibo/ui/helpers/Items$JiboSettingsItem;->a()Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;

    move-result-object v0

    invoke-static {v0}, Lcom/jibo/aws/integration/helpers/RobotHelper;->getAvatar(Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;)I

    move-result v0

    invoke-virtual {v1, v0}, Landroid/widget/ImageView;->setImageLevel(I)V

    .line 393
    :cond_0
    return-void
.end method
