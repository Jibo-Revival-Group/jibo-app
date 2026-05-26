.class public Lcom/jibo/ui/helpers/Items$SimpleItem;
.super Lcom/jibo/ui/helpers/Items$Item;
.source "Items.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/ui/helpers/Items;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SimpleItem"
.end annotation


# instance fields
.field private a:I

.field private b:Ljava/lang/CharSequence;


# direct methods
.method public constructor <init>(Lcom/jibo/ui/helpers/Items$ItemType;)V
    .locals 1

    .prologue
    .line 109
    invoke-direct {p0, p1}, Lcom/jibo/ui/helpers/Items$Item;-><init>(Lcom/jibo/ui/helpers/Items$ItemType;)V

    .line 106
    const/4 v0, -0x1

    iput v0, p0, Lcom/jibo/ui/helpers/Items$SimpleItem;->a:I

    .line 107
    const-string v0, ""

    iput-object v0, p0, Lcom/jibo/ui/helpers/Items$SimpleItem;->b:Ljava/lang/CharSequence;

    .line 110
    return-void
.end method

.method public constructor <init>(Lcom/jibo/ui/helpers/Items$ItemType;I)V
    .locals 0

    .prologue
    .line 117
    invoke-direct {p0, p1}, Lcom/jibo/ui/helpers/Items$SimpleItem;-><init>(Lcom/jibo/ui/helpers/Items$ItemType;)V

    .line 118
    iput p2, p0, Lcom/jibo/ui/helpers/Items$SimpleItem;->a:I

    .line 119
    return-void
.end method

.method public constructor <init>(Lcom/jibo/ui/helpers/Items$ItemType;Landroid/view/View$OnClickListener;)V
    .locals 1

    .prologue
    .line 113
    invoke-direct {p0, p1, p2}, Lcom/jibo/ui/helpers/Items$Item;-><init>(Lcom/jibo/ui/helpers/Items$ItemType;Landroid/view/View$OnClickListener;)V

    .line 106
    const/4 v0, -0x1

    iput v0, p0, Lcom/jibo/ui/helpers/Items$SimpleItem;->a:I

    .line 107
    const-string v0, ""

    iput-object v0, p0, Lcom/jibo/ui/helpers/Items$SimpleItem;->b:Ljava/lang/CharSequence;

    .line 114
    return-void
.end method

.method public constructor <init>(Lcom/jibo/ui/helpers/Items$ItemType;Landroid/view/View$OnClickListener;I)V
    .locals 0

    .prologue
    .line 127
    invoke-direct {p0, p1, p2}, Lcom/jibo/ui/helpers/Items$SimpleItem;-><init>(Lcom/jibo/ui/helpers/Items$ItemType;Landroid/view/View$OnClickListener;)V

    .line 128
    iput p3, p0, Lcom/jibo/ui/helpers/Items$SimpleItem;->a:I

    .line 129
    return-void
.end method

.method public constructor <init>(Lcom/jibo/ui/helpers/Items$ItemType;Landroid/view/View$OnClickListener;Ljava/lang/CharSequence;)V
    .locals 0

    .prologue
    .line 132
    invoke-direct {p0, p1, p2}, Lcom/jibo/ui/helpers/Items$SimpleItem;-><init>(Lcom/jibo/ui/helpers/Items$ItemType;Landroid/view/View$OnClickListener;)V

    .line 133
    iput-object p3, p0, Lcom/jibo/ui/helpers/Items$SimpleItem;->b:Ljava/lang/CharSequence;

    .line 134
    return-void
.end method

.method public constructor <init>(Lcom/jibo/ui/helpers/Items$ItemType;Ljava/lang/CharSequence;)V
    .locals 0

    .prologue
    .line 122
    invoke-direct {p0, p1}, Lcom/jibo/ui/helpers/Items$SimpleItem;-><init>(Lcom/jibo/ui/helpers/Items$ItemType;)V

    .line 123
    iput-object p2, p0, Lcom/jibo/ui/helpers/Items$SimpleItem;->b:Ljava/lang/CharSequence;

    .line 124
    return-void
.end method


# virtual methods
.method public d()I
    .locals 1

    .prologue
    .line 137
    iget v0, p0, Lcom/jibo/ui/helpers/Items$SimpleItem;->a:I

    return v0
.end method

.method public e()Ljava/lang/CharSequence;
    .locals 1

    .prologue
    .line 141
    iget-object v0, p0, Lcom/jibo/ui/helpers/Items$SimpleItem;->b:Ljava/lang/CharSequence;

    return-object v0
.end method
