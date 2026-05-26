.class public Lcom/jibo/ui/helpers/Items$DateItem;
.super Lcom/jibo/ui/helpers/Items$SimpleItem;
.source "Items.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/ui/helpers/Items;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "DateItem"
.end annotation


# direct methods
.method public constructor <init>(Ljava/lang/String;)V
    .locals 1

    .prologue
    .line 261
    sget-object v0, Lcom/jibo/ui/helpers/Items$ItemType;->date:Lcom/jibo/ui/helpers/Items$ItemType;

    invoke-direct {p0, v0, p1}, Lcom/jibo/ui/helpers/Items$SimpleItem;-><init>(Lcom/jibo/ui/helpers/Items$ItemType;Ljava/lang/CharSequence;)V

    .line 262
    return-void
.end method
