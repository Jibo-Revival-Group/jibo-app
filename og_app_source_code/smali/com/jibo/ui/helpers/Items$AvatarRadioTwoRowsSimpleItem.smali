.class public Lcom/jibo/ui/helpers/Items$AvatarRadioTwoRowsSimpleItem;
.super Lcom/jibo/ui/helpers/Items$AvatarTwoRowsSimpleItem;
.source "Items.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/ui/helpers/Items;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "AvatarRadioTwoRowsSimpleItem"
.end annotation


# instance fields
.field private a:Z


# direct methods
.method public constructor <init>(Landroid/view/View$OnClickListener;Ljava/lang/String;Ljava/lang/String;Z)V
    .locals 6

    .prologue
    .line 548
    sget-object v1, Lcom/jibo/ui/helpers/Items$ItemType;->text_avatar_radio_double_row:Lcom/jibo/ui/helpers/Items$ItemType;

    move-object v0, p0

    move-object v2, p1

    move-object v3, p2

    move-object v4, p3

    move v5, p4

    invoke-direct/range {v0 .. v5}, Lcom/jibo/ui/helpers/Items$AvatarRadioTwoRowsSimpleItem;-><init>(Lcom/jibo/ui/helpers/Items$ItemType;Landroid/view/View$OnClickListener;Ljava/lang/String;Ljava/lang/String;Z)V

    .line 549
    return-void
.end method

.method public constructor <init>(Lcom/jibo/ui/helpers/Items$ItemType;Landroid/view/View$OnClickListener;Ljava/lang/String;Ljava/lang/String;Z)V
    .locals 1

    .prologue
    .line 538
    invoke-direct {p0, p1, p2, p3, p4}, Lcom/jibo/ui/helpers/Items$AvatarTwoRowsSimpleItem;-><init>(Lcom/jibo/ui/helpers/Items$ItemType;Landroid/view/View$OnClickListener;Ljava/lang/String;Ljava/lang/String;)V

    .line 529
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/jibo/ui/helpers/Items$AvatarRadioTwoRowsSimpleItem;->a:Z

    .line 539
    iput-boolean p5, p0, Lcom/jibo/ui/helpers/Items$AvatarRadioTwoRowsSimpleItem;->a:Z

    .line 540
    return-void
.end method


# virtual methods
.method public b()Z
    .locals 1

    .prologue
    .line 552
    iget-boolean v0, p0, Lcom/jibo/ui/helpers/Items$AvatarRadioTwoRowsSimpleItem;->a:Z

    return v0
.end method
