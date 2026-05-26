.class public abstract Lcom/jibo/ui/helpers/Items$Item;
.super Ljava/lang/Object;
.source "Items.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/ui/helpers/Items;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x409
    name = "Item"
.end annotation


# instance fields
.field protected mItemType:Lcom/jibo/ui/helpers/Items$ItemType;

.field private mOnCheckChangeListener:Landroid/widget/CompoundButton$OnCheckedChangeListener;

.field private mOnRowClickListener:Landroid/view/View$OnClickListener;


# direct methods
.method protected constructor <init>(Lcom/jibo/ui/helpers/Items$ItemType;)V
    .locals 0

    .prologue
    .line 76
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 77
    iput-object p1, p0, Lcom/jibo/ui/helpers/Items$Item;->mItemType:Lcom/jibo/ui/helpers/Items$ItemType;

    .line 78
    return-void
.end method

.method protected constructor <init>(Lcom/jibo/ui/helpers/Items$ItemType;Landroid/view/View$OnClickListener;)V
    .locals 0

    .prologue
    .line 81
    invoke-direct {p0, p1}, Lcom/jibo/ui/helpers/Items$Item;-><init>(Lcom/jibo/ui/helpers/Items$ItemType;)V

    .line 82
    iput-object p2, p0, Lcom/jibo/ui/helpers/Items$Item;->mOnRowClickListener:Landroid/view/View$OnClickListener;

    .line 83
    return-void
.end method

.method protected constructor <init>(Lcom/jibo/ui/helpers/Items$ItemType;Landroid/view/View$OnClickListener;Landroid/widget/CompoundButton$OnCheckedChangeListener;)V
    .locals 0

    .prologue
    .line 86
    invoke-direct {p0, p1}, Lcom/jibo/ui/helpers/Items$Item;-><init>(Lcom/jibo/ui/helpers/Items$ItemType;)V

    .line 87
    iput-object p2, p0, Lcom/jibo/ui/helpers/Items$Item;->mOnRowClickListener:Landroid/view/View$OnClickListener;

    .line 88
    iput-object p3, p0, Lcom/jibo/ui/helpers/Items$Item;->mOnCheckChangeListener:Landroid/widget/CompoundButton$OnCheckedChangeListener;

    .line 89
    return-void
.end method


# virtual methods
.method public getCheckChangeListener()Landroid/widget/CompoundButton$OnCheckedChangeListener;
    .locals 1

    .prologue
    .line 100
    iget-object v0, p0, Lcom/jibo/ui/helpers/Items$Item;->mOnCheckChangeListener:Landroid/widget/CompoundButton$OnCheckedChangeListener;

    return-object v0
.end method

.method public getItemType()Lcom/jibo/ui/helpers/Items$ItemType;
    .locals 1

    .prologue
    .line 92
    iget-object v0, p0, Lcom/jibo/ui/helpers/Items$Item;->mItemType:Lcom/jibo/ui/helpers/Items$ItemType;

    return-object v0
.end method

.method public getOnRowClickListener()Landroid/view/View$OnClickListener;
    .locals 1

    .prologue
    .line 96
    iget-object v0, p0, Lcom/jibo/ui/helpers/Items$Item;->mOnRowClickListener:Landroid/view/View$OnClickListener;

    return-object v0
.end method
