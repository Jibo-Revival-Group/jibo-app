.class public abstract Lcom/jibo/ui/helpers/Items$LoopBasedItem;
.super Lcom/jibo/ui/helpers/Items$SimpleItem;
.source "Items.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/ui/helpers/Items;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x409
    name = "LoopBasedItem"
.end annotation


# instance fields
.field private a:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;


# direct methods
.method public constructor <init>(Lcom/jibo/ui/helpers/Items$ItemType;Landroid/view/View$OnClickListener;Lcom/jibo/aws/integration/aws/services/loop/model/Loop;)V
    .locals 0

    .prologue
    .line 296
    invoke-direct {p0, p1, p2}, Lcom/jibo/ui/helpers/Items$SimpleItem;-><init>(Lcom/jibo/ui/helpers/Items$ItemType;Landroid/view/View$OnClickListener;)V

    .line 297
    iput-object p3, p0, Lcom/jibo/ui/helpers/Items$LoopBasedItem;->a:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    .line 298
    return-void
.end method

.method public constructor <init>(Lcom/jibo/ui/helpers/Items$ItemType;Lcom/jibo/aws/integration/aws/services/loop/model/Loop;)V
    .locals 0

    .prologue
    .line 291
    invoke-direct {p0, p1}, Lcom/jibo/ui/helpers/Items$SimpleItem;-><init>(Lcom/jibo/ui/helpers/Items$ItemType;)V

    .line 292
    iput-object p2, p0, Lcom/jibo/ui/helpers/Items$LoopBasedItem;->a:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    .line 293
    return-void
.end method


# virtual methods
.method public a()Lcom/jibo/aws/integration/aws/services/loop/model/Loop;
    .locals 1

    .prologue
    .line 301
    iget-object v0, p0, Lcom/jibo/ui/helpers/Items$LoopBasedItem;->a:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    return-object v0
.end method
