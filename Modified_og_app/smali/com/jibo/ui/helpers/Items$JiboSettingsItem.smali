.class public Lcom/jibo/ui/helpers/Items$JiboSettingsItem;
.super Lcom/jibo/ui/helpers/Items$Item;
.source "Items.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/ui/helpers/Items;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "JiboSettingsItem"
.end annotation


# instance fields
.field private a:Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 363
    sget-object v0, Lcom/jibo/ui/helpers/Items$ItemType;->settings:Lcom/jibo/ui/helpers/Items$ItemType;

    invoke-direct {p0, v0}, Lcom/jibo/ui/helpers/Items$Item;-><init>(Lcom/jibo/ui/helpers/Items$ItemType;)V

    .line 364
    return-void
.end method

.method public constructor <init>(Landroid/view/View$OnClickListener;Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;)V
    .locals 1

    .prologue
    .line 376
    sget-object v0, Lcom/jibo/ui/helpers/Items$ItemType;->settings:Lcom/jibo/ui/helpers/Items$ItemType;

    invoke-direct {p0, v0, p1}, Lcom/jibo/ui/helpers/Items$Item;-><init>(Lcom/jibo/ui/helpers/Items$ItemType;Landroid/view/View$OnClickListener;)V

    .line 377
    iput-object p2, p0, Lcom/jibo/ui/helpers/Items$JiboSettingsItem;->a:Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;

    .line 378
    return-void
.end method


# virtual methods
.method public a()Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;
    .locals 1

    .prologue
    .line 381
    iget-object v0, p0, Lcom/jibo/ui/helpers/Items$JiboSettingsItem;->a:Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;

    return-object v0
.end method

.method public a(Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;)V
    .locals 0

    .prologue
    .line 385
    iput-object p1, p0, Lcom/jibo/ui/helpers/Items$JiboSettingsItem;->a:Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;

    .line 386
    return-void
.end method
