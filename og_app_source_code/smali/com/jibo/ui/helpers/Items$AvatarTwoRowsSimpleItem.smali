.class public Lcom/jibo/ui/helpers/Items$AvatarTwoRowsSimpleItem;
.super Lcom/jibo/ui/helpers/Items$TwoRowsSimpleItem;
.source "Items.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/ui/helpers/Items;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "AvatarTwoRowsSimpleItem"
.end annotation


# instance fields
.field private a:Ljava/lang/String;

.field private b:I


# direct methods
.method public constructor <init>(Landroid/view/View$OnClickListener;Ljava/lang/String;Ljava/lang/String;)V
    .locals 1

    .prologue
    .line 205
    sget-object v0, Lcom/jibo/ui/helpers/Items$ItemType;->text_avatar_double_row:Lcom/jibo/ui/helpers/Items$ItemType;

    invoke-direct {p0, v0, p1, p2, p3}, Lcom/jibo/ui/helpers/Items$AvatarTwoRowsSimpleItem;-><init>(Lcom/jibo/ui/helpers/Items$ItemType;Landroid/view/View$OnClickListener;Ljava/lang/String;Ljava/lang/String;)V

    .line 206
    return-void
.end method

.method public constructor <init>(Lcom/jibo/ui/helpers/Items$ItemType;Landroid/view/View$OnClickListener;Ljava/lang/String;Ljava/lang/String;)V
    .locals 1

    .prologue
    .line 197
    invoke-direct {p0, p1, p2, p3, p4}, Lcom/jibo/ui/helpers/Items$TwoRowsSimpleItem;-><init>(Lcom/jibo/ui/helpers/Items$ItemType;Landroid/view/View$OnClickListener;Ljava/lang/CharSequence;Ljava/lang/CharSequence;)V

    .line 189
    const-string v0, ""

    iput-object v0, p0, Lcom/jibo/ui/helpers/Items$AvatarTwoRowsSimpleItem;->a:Ljava/lang/String;

    .line 190
    const/4 v0, -0x1

    iput v0, p0, Lcom/jibo/ui/helpers/Items$AvatarTwoRowsSimpleItem;->b:I

    .line 198
    return-void
.end method


# virtual methods
.method public a(I)V
    .locals 0

    .prologue
    .line 221
    iput p1, p0, Lcom/jibo/ui/helpers/Items$AvatarTwoRowsSimpleItem;->b:I

    .line 222
    return-void
.end method

.method public a(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 213
    iput-object p1, p0, Lcom/jibo/ui/helpers/Items$AvatarTwoRowsSimpleItem;->a:Ljava/lang/String;

    .line 214
    return-void
.end method

.method public c()Ljava/lang/String;
    .locals 1

    .prologue
    .line 209
    iget-object v0, p0, Lcom/jibo/ui/helpers/Items$AvatarTwoRowsSimpleItem;->a:Ljava/lang/String;

    return-object v0
.end method

.method public d()I
    .locals 1

    .prologue
    .line 217
    iget v0, p0, Lcom/jibo/ui/helpers/Items$AvatarTwoRowsSimpleItem;->b:I

    return v0
.end method
