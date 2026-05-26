.class public Lcom/jibo/ui/helpers/Items$WifiSettingsItem;
.super Lcom/jibo/ui/helpers/Items$Item;
.source "Items.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/ui/helpers/Items;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "WifiSettingsItem"
.end annotation


# instance fields
.field private a:Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;

.field private b:Lcom/jibo/aws/integration/aws/services/notification/model/StatusContainer;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 323
    sget-object v0, Lcom/jibo/ui/helpers/Items$ItemType;->wifisettings:Lcom/jibo/ui/helpers/Items$ItemType;

    invoke-direct {p0, v0}, Lcom/jibo/ui/helpers/Items$Item;-><init>(Lcom/jibo/ui/helpers/Items$ItemType;)V

    .line 324
    return-void
.end method

.method public constructor <init>(Landroid/view/View$OnClickListener;)V
    .locals 1

    .prologue
    .line 327
    sget-object v0, Lcom/jibo/ui/helpers/Items$ItemType;->wifisettings:Lcom/jibo/ui/helpers/Items$ItemType;

    invoke-direct {p0, v0, p1}, Lcom/jibo/ui/helpers/Items$Item;-><init>(Lcom/jibo/ui/helpers/Items$ItemType;Landroid/view/View$OnClickListener;)V

    .line 328
    return-void
.end method


# virtual methods
.method public a()Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;
    .locals 1

    .prologue
    .line 343
    iget-object v0, p0, Lcom/jibo/ui/helpers/Items$WifiSettingsItem;->a:Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;

    return-object v0
.end method

.method public a(Lcom/jibo/aws/integration/aws/services/notification/model/StatusContainer;)V
    .locals 0

    .prologue
    .line 355
    iput-object p1, p0, Lcom/jibo/ui/helpers/Items$WifiSettingsItem;->b:Lcom/jibo/aws/integration/aws/services/notification/model/StatusContainer;

    .line 356
    return-void
.end method

.method public a(Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;)V
    .locals 0

    .prologue
    .line 347
    iput-object p1, p0, Lcom/jibo/ui/helpers/Items$WifiSettingsItem;->a:Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;

    .line 348
    return-void
.end method

.method public b()Lcom/jibo/aws/integration/aws/services/notification/model/StatusContainer;
    .locals 1

    .prologue
    .line 351
    iget-object v0, p0, Lcom/jibo/ui/helpers/Items$WifiSettingsItem;->b:Lcom/jibo/aws/integration/aws/services/notification/model/StatusContainer;

    return-object v0
.end method
