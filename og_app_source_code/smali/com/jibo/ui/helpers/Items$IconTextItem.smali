.class public Lcom/jibo/ui/helpers/Items$IconTextItem;
.super Lcom/jibo/ui/helpers/Items$Item;
.source "Items.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/ui/helpers/Items;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "IconTextItem"
.end annotation


# instance fields
.field private a:I

.field private b:Ljava/lang/CharSequence;


# direct methods
.method public constructor <init>(Lcom/jibo/ui/helpers/Items$ItemType;Landroid/view/View$OnClickListener;ILjava/lang/CharSequence;)V
    .locals 1

    .prologue
    .line 567
    invoke-direct {p0, p1, p2}, Lcom/jibo/ui/helpers/Items$Item;-><init>(Lcom/jibo/ui/helpers/Items$ItemType;Landroid/view/View$OnClickListener;)V

    .line 563
    const/4 v0, -0x1

    iput v0, p0, Lcom/jibo/ui/helpers/Items$IconTextItem;->a:I

    .line 564
    const-string v0, ""

    iput-object v0, p0, Lcom/jibo/ui/helpers/Items$IconTextItem;->b:Ljava/lang/CharSequence;

    .line 569
    iput p3, p0, Lcom/jibo/ui/helpers/Items$IconTextItem;->a:I

    .line 570
    iput-object p4, p0, Lcom/jibo/ui/helpers/Items$IconTextItem;->b:Ljava/lang/CharSequence;

    .line 571
    return-void
.end method


# virtual methods
.method public a()I
    .locals 1

    .prologue
    .line 574
    iget v0, p0, Lcom/jibo/ui/helpers/Items$IconTextItem;->a:I

    return v0
.end method

.method public b()Ljava/lang/CharSequence;
    .locals 1

    .prologue
    .line 577
    iget-object v0, p0, Lcom/jibo/ui/helpers/Items$IconTextItem;->b:Ljava/lang/CharSequence;

    return-object v0
.end method
