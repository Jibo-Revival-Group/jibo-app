.class public Lcom/jibo/ui/helpers/Items$MemberItem;
.super Lcom/jibo/ui/helpers/Items$LoopBasedItem;
.source "Items.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/ui/helpers/Items;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "MemberItem"
.end annotation


# instance fields
.field private a:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

.field private b:Landroid/os/Bundle;


# direct methods
.method public constructor <init>(Landroid/view/View$OnClickListener;Lcom/jibo/aws/integration/aws/services/loop/model/Loop;Lcom/jibo/aws/integration/aws/services/loop/model/Member;)V
    .locals 1

    .prologue
    .line 404
    sget-object v0, Lcom/jibo/ui/helpers/Items$ItemType;->member:Lcom/jibo/ui/helpers/Items$ItemType;

    invoke-direct {p0, v0, p1, p2}, Lcom/jibo/ui/helpers/Items$LoopBasedItem;-><init>(Lcom/jibo/ui/helpers/Items$ItemType;Landroid/view/View$OnClickListener;Lcom/jibo/aws/integration/aws/services/loop/model/Loop;)V

    .line 405
    iput-object p3, p0, Lcom/jibo/ui/helpers/Items$MemberItem;->a:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    .line 406
    return-void
.end method

.method public constructor <init>(Landroid/view/View$OnClickListener;Lcom/jibo/aws/integration/aws/services/loop/model/Loop;Lcom/jibo/aws/integration/aws/services/loop/model/Member;Landroid/os/Bundle;)V
    .locals 0

    .prologue
    .line 409
    invoke-direct {p0, p1, p2, p3}, Lcom/jibo/ui/helpers/Items$MemberItem;-><init>(Landroid/view/View$OnClickListener;Lcom/jibo/aws/integration/aws/services/loop/model/Loop;Lcom/jibo/aws/integration/aws/services/loop/model/Member;)V

    .line 410
    iput-object p4, p0, Lcom/jibo/ui/helpers/Items$MemberItem;->b:Landroid/os/Bundle;

    .line 411
    return-void
.end method

.method public constructor <init>(Lcom/jibo/aws/integration/aws/services/loop/model/Loop;Lcom/jibo/aws/integration/aws/services/loop/model/Member;)V
    .locals 1

    .prologue
    .line 394
    sget-object v0, Lcom/jibo/ui/helpers/Items$ItemType;->member:Lcom/jibo/ui/helpers/Items$ItemType;

    invoke-direct {p0, v0, p1}, Lcom/jibo/ui/helpers/Items$LoopBasedItem;-><init>(Lcom/jibo/ui/helpers/Items$ItemType;Lcom/jibo/aws/integration/aws/services/loop/model/Loop;)V

    .line 395
    iput-object p2, p0, Lcom/jibo/ui/helpers/Items$MemberItem;->a:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    .line 396
    return-void
.end method


# virtual methods
.method public b()Lcom/jibo/aws/integration/aws/services/loop/model/Member;
    .locals 1

    .prologue
    .line 414
    iget-object v0, p0, Lcom/jibo/ui/helpers/Items$MemberItem;->a:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    return-object v0
.end method

.method public c()Landroid/os/Bundle;
    .locals 1

    .prologue
    .line 418
    iget-object v0, p0, Lcom/jibo/ui/helpers/Items$MemberItem;->b:Landroid/os/Bundle;

    return-object v0
.end method
