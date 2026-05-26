.class public Lcom/jibo/ui/helpers/ViewHolders$WifiSettingsViewHolder;
.super Lcom/jibo/ui/helpers/ViewHolders$AbstractViewHolder;
.source "ViewHolders.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/ui/helpers/ViewHolders;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "WifiSettingsViewHolder"
.end annotation


# instance fields
.field public name:Landroid/widget/TextView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field


# direct methods
.method public constructor <init>(Landroid/view/View;)V
    .locals 0

    .prologue
    .line 429
    invoke-direct {p0, p1}, Lcom/jibo/ui/helpers/ViewHolders$AbstractViewHolder;-><init>(Landroid/view/View;)V

    .line 430
    return-void
.end method


# virtual methods
.method public invalidateView()V
    .locals 4

    .prologue
    .line 434
    iget-object v0, p0, Lcom/jibo/ui/helpers/ViewHolders$WifiSettingsViewHolder;->mItem:Lcom/jibo/ui/helpers/Items$Item;

    check-cast v0, Lcom/jibo/ui/helpers/Items$WifiSettingsItem;

    .line 435
    invoke-virtual {v0}, Lcom/jibo/ui/helpers/Items$WifiSettingsItem;->b()Lcom/jibo/aws/integration/aws/services/notification/model/StatusContainer;

    move-result-object v1

    .line 436
    iget-object v2, p0, Lcom/jibo/ui/helpers/ViewHolders$WifiSettingsViewHolder;->name:Landroid/widget/TextView;

    if-eqz v1, :cond_0

    invoke-virtual {v1}, Lcom/jibo/aws/integration/aws/services/notification/model/StatusContainer;->getConnected()Ljava/lang/Boolean;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v3

    if-eqz v3, :cond_0

    .line 437
    invoke-virtual {v0}, Lcom/jibo/ui/helpers/Items$WifiSettingsItem;->a()Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;

    move-result-object v0

    invoke-static {v0}, Lcom/jibo/aws/integration/helpers/RobotHelper;->getWifiName(Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;)Ljava/lang/String;

    move-result-object v0

    .line 436
    :goto_0
    invoke-virtual {v2, v0}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 439
    iget-object v2, p0, Lcom/jibo/ui/helpers/ViewHolders$WifiSettingsViewHolder;->name:Landroid/widget/TextView;

    iget-object v0, p0, Lcom/jibo/ui/helpers/ViewHolders$WifiSettingsViewHolder;->itemView:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->getContext()Landroid/content/Context;

    move-result-object v3

    if-eqz v1, :cond_1

    .line 440
    invoke-virtual {v1}, Lcom/jibo/aws/integration/aws/services/notification/model/StatusContainer;->getConnected()Ljava/lang/Boolean;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    if-eqz v0, :cond_1

    const v0, 0x7f0600c6

    .line 439
    :goto_1
    invoke-static {v3, v0}, Lcom/jibo/utils/ImageUtils;->b(Landroid/content/Context;I)I

    move-result v0

    invoke-virtual {v2, v0}, Landroid/widget/TextView;->setTextColor(I)V

    .line 441
    return-void

    .line 437
    :cond_0
    iget-object v0, p0, Lcom/jibo/ui/helpers/ViewHolders$WifiSettingsViewHolder;->itemView:Landroid/view/View;

    .line 438
    invoke-virtual {v0}, Landroid/view/View;->getContext()Landroid/content/Context;

    move-result-object v0

    const v3, 0x7f1001b4

    invoke-virtual {v0, v3}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 440
    :cond_1
    const v0, 0x7f060074

    goto :goto_1
.end method
