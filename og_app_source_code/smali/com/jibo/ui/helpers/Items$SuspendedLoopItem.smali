.class public Lcom/jibo/ui/helpers/Items$SuspendedLoopItem;
.super Lcom/jibo/ui/helpers/Items$Item;
.source "Items.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/ui/helpers/Items;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SuspendedLoopItem"
.end annotation


# instance fields
.field private a:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;


# direct methods
.method public constructor <init>(Landroid/view/View$OnClickListener;Lcom/jibo/aws/integration/aws/services/loop/model/Loop;)V
    .locals 1

    .prologue
    .line 449
    sget-object v0, Lcom/jibo/ui/helpers/Items$ItemType;->suspended_loop:Lcom/jibo/ui/helpers/Items$ItemType;

    invoke-direct {p0, v0, p1}, Lcom/jibo/ui/helpers/Items$Item;-><init>(Lcom/jibo/ui/helpers/Items$ItemType;Landroid/view/View$OnClickListener;)V

    .line 450
    iput-object p2, p0, Lcom/jibo/ui/helpers/Items$SuspendedLoopItem;->a:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    .line 451
    return-void
.end method


# virtual methods
.method public a()Lcom/jibo/aws/integration/aws/services/loop/model/Loop;
    .locals 1

    .prologue
    .line 454
    iget-object v0, p0, Lcom/jibo/ui/helpers/Items$SuspendedLoopItem;->a:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    return-object v0
.end method
