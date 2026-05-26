.class public Lcom/jibo/ui/helpers/Items$TwoRowsSimpleItem;
.super Lcom/jibo/ui/helpers/Items$Item;
.source "Items.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/ui/helpers/Items;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "TwoRowsSimpleItem"
.end annotation


# instance fields
.field private a:Ljava/lang/CharSequence;

.field private b:Ljava/lang/CharSequence;


# direct methods
.method public constructor <init>(Lcom/jibo/ui/helpers/Items$ItemType;Landroid/view/View$OnClickListener;Ljava/lang/CharSequence;Ljava/lang/CharSequence;)V
    .locals 1

    .prologue
    .line 157
    invoke-direct {p0, p1, p2}, Lcom/jibo/ui/helpers/Items$Item;-><init>(Lcom/jibo/ui/helpers/Items$ItemType;Landroid/view/View$OnClickListener;)V

    .line 147
    const-string v0, ""

    iput-object v0, p0, Lcom/jibo/ui/helpers/Items$TwoRowsSimpleItem;->a:Ljava/lang/CharSequence;

    .line 148
    const-string v0, ""

    iput-object v0, p0, Lcom/jibo/ui/helpers/Items$TwoRowsSimpleItem;->b:Ljava/lang/CharSequence;

    .line 158
    iput-object p3, p0, Lcom/jibo/ui/helpers/Items$TwoRowsSimpleItem;->a:Ljava/lang/CharSequence;

    .line 159
    iput-object p4, p0, Lcom/jibo/ui/helpers/Items$TwoRowsSimpleItem;->b:Ljava/lang/CharSequence;

    .line 160
    return-void
.end method

.method public constructor <init>(Lcom/jibo/ui/helpers/Items$ItemType;Ljava/lang/CharSequence;Ljava/lang/CharSequence;)V
    .locals 1

    .prologue
    .line 151
    invoke-direct {p0, p1}, Lcom/jibo/ui/helpers/Items$Item;-><init>(Lcom/jibo/ui/helpers/Items$ItemType;)V

    .line 147
    const-string v0, ""

    iput-object v0, p0, Lcom/jibo/ui/helpers/Items$TwoRowsSimpleItem;->a:Ljava/lang/CharSequence;

    .line 148
    const-string v0, ""

    iput-object v0, p0, Lcom/jibo/ui/helpers/Items$TwoRowsSimpleItem;->b:Ljava/lang/CharSequence;

    .line 152
    iput-object p2, p0, Lcom/jibo/ui/helpers/Items$TwoRowsSimpleItem;->a:Ljava/lang/CharSequence;

    .line 153
    iput-object p3, p0, Lcom/jibo/ui/helpers/Items$TwoRowsSimpleItem;->b:Ljava/lang/CharSequence;

    .line 154
    return-void
.end method

.method public constructor <init>(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)V
    .locals 1

    .prologue
    .line 163
    sget-object v0, Lcom/jibo/ui/helpers/Items$ItemType;->text_double_row:Lcom/jibo/ui/helpers/Items$ItemType;

    invoke-direct {p0, v0, p1, p2}, Lcom/jibo/ui/helpers/Items$TwoRowsSimpleItem;-><init>(Lcom/jibo/ui/helpers/Items$ItemType;Ljava/lang/CharSequence;Ljava/lang/CharSequence;)V

    .line 164
    return-void
.end method


# virtual methods
.method public a(Ljava/lang/CharSequence;)V
    .locals 0

    .prologue
    .line 183
    iput-object p1, p0, Lcom/jibo/ui/helpers/Items$TwoRowsSimpleItem;->b:Ljava/lang/CharSequence;

    .line 184
    return-void
.end method

.method public e()Ljava/lang/CharSequence;
    .locals 1

    .prologue
    .line 171
    iget-object v0, p0, Lcom/jibo/ui/helpers/Items$TwoRowsSimpleItem;->a:Ljava/lang/CharSequence;

    return-object v0
.end method

.method public f()Ljava/lang/CharSequence;
    .locals 1

    .prologue
    .line 175
    iget-object v0, p0, Lcom/jibo/ui/helpers/Items$TwoRowsSimpleItem;->b:Ljava/lang/CharSequence;

    return-object v0
.end method
