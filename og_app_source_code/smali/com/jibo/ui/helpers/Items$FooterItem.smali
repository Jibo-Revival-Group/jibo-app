.class public Lcom/jibo/ui/helpers/Items$FooterItem;
.super Lcom/jibo/ui/helpers/Items$SimpleItem;
.source "Items.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/ui/helpers/Items;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "FooterItem"
.end annotation


# instance fields
.field protected a:Ljava/lang/CharSequence;


# direct methods
.method public constructor <init>(Ljava/lang/CharSequence;)V
    .locals 1

    .prologue
    .line 426
    sget-object v0, Lcom/jibo/ui/helpers/Items$ItemType;->footer:Lcom/jibo/ui/helpers/Items$ItemType;

    invoke-direct {p0, v0}, Lcom/jibo/ui/helpers/Items$SimpleItem;-><init>(Lcom/jibo/ui/helpers/Items$ItemType;)V

    .line 427
    iput-object p1, p0, Lcom/jibo/ui/helpers/Items$FooterItem;->a:Ljava/lang/CharSequence;

    .line 428
    return-void
.end method


# virtual methods
.method public a()Ljava/lang/CharSequence;
    .locals 1

    .prologue
    .line 436
    iget-object v0, p0, Lcom/jibo/ui/helpers/Items$FooterItem;->a:Ljava/lang/CharSequence;

    return-object v0
.end method
