.class public Lcom/jibo/ui/helpers/Items$CheckboxDateItem;
.super Lcom/jibo/ui/helpers/Items$CheckboxItem;
.source "Items.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/ui/helpers/Items;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "CheckboxDateItem"
.end annotation


# instance fields
.field private a:Landroid/view/View$OnLongClickListener;

.field private b:Ljava/lang/String;


# direct methods
.method public constructor <init>(Landroid/view/View$OnClickListener;Landroid/view/View$OnLongClickListener;Ljava/lang/String;Ljava/lang/String;Z)V
    .locals 1

    .prologue
    .line 514
    sget-object v0, Lcom/jibo/ui/helpers/Items$ItemType;->checkbox_date_row_leftsided:Lcom/jibo/ui/helpers/Items$ItemType;

    invoke-direct {p0, v0, p1, p3, p5}, Lcom/jibo/ui/helpers/Items$CheckboxItem;-><init>(Lcom/jibo/ui/helpers/Items$ItemType;Landroid/view/View$OnClickListener;Ljava/lang/String;Z)V

    .line 515
    iput-object p2, p0, Lcom/jibo/ui/helpers/Items$CheckboxDateItem;->a:Landroid/view/View$OnLongClickListener;

    .line 516
    iput-object p4, p0, Lcom/jibo/ui/helpers/Items$CheckboxDateItem;->b:Ljava/lang/String;

    .line 517
    return-void
.end method


# virtual methods
.method public a()Landroid/view/View$OnLongClickListener;
    .locals 1

    .prologue
    .line 520
    iget-object v0, p0, Lcom/jibo/ui/helpers/Items$CheckboxDateItem;->a:Landroid/view/View$OnLongClickListener;

    return-object v0
.end method

.method public b()Ljava/lang/String;
    .locals 1

    .prologue
    .line 524
    iget-object v0, p0, Lcom/jibo/ui/helpers/Items$CheckboxDateItem;->b:Ljava/lang/String;

    return-object v0
.end method
