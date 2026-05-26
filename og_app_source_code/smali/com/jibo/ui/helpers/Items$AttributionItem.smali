.class public Lcom/jibo/ui/helpers/Items$AttributionItem;
.super Lcom/jibo/ui/helpers/Items$Item;
.source "Items.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/ui/helpers/Items;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "AttributionItem"
.end annotation


# instance fields
.field private a:Lcom/jibo/aws/integration/aws/services/gqa/model/Attribution;


# direct methods
.method public constructor <init>(Lcom/jibo/aws/integration/aws/services/gqa/model/Attribution;Landroid/view/View$OnClickListener;)V
    .locals 1

    .prologue
    .line 249
    sget-object v0, Lcom/jibo/ui/helpers/Items$ItemType;->attribution:Lcom/jibo/ui/helpers/Items$ItemType;

    invoke-direct {p0, v0, p2}, Lcom/jibo/ui/helpers/Items$Item;-><init>(Lcom/jibo/ui/helpers/Items$ItemType;Landroid/view/View$OnClickListener;)V

    .line 250
    iput-object p1, p0, Lcom/jibo/ui/helpers/Items$AttributionItem;->a:Lcom/jibo/aws/integration/aws/services/gqa/model/Attribution;

    .line 251
    return-void
.end method


# virtual methods
.method public a()Lcom/jibo/aws/integration/aws/services/gqa/model/Attribution;
    .locals 1

    .prologue
    .line 254
    iget-object v0, p0, Lcom/jibo/ui/helpers/Items$AttributionItem;->a:Lcom/jibo/aws/integration/aws/services/gqa/model/Attribution;

    return-object v0
.end method
