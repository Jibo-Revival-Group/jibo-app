.class public Lcom/jibo/ui/helpers/Items$SubheaderItem;
.super Lcom/jibo/ui/helpers/Items$SimpleItem;
.source "Items.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/ui/helpers/Items;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SubheaderItem"
.end annotation


# direct methods
.method public constructor <init>(I)V
    .locals 1

    .prologue
    .line 228
    sget-object v0, Lcom/jibo/ui/helpers/Items$ItemType;->subheader:Lcom/jibo/ui/helpers/Items$ItemType;

    invoke-direct {p0, v0, p1}, Lcom/jibo/ui/helpers/Items$SimpleItem;-><init>(Lcom/jibo/ui/helpers/Items$ItemType;I)V

    .line 229
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .locals 1

    .prologue
    .line 236
    sget-object v0, Lcom/jibo/ui/helpers/Items$ItemType;->subheader:Lcom/jibo/ui/helpers/Items$ItemType;

    invoke-direct {p0, v0, p1}, Lcom/jibo/ui/helpers/Items$SimpleItem;-><init>(Lcom/jibo/ui/helpers/Items$ItemType;Ljava/lang/CharSequence;)V

    .line 237
    return-void
.end method
