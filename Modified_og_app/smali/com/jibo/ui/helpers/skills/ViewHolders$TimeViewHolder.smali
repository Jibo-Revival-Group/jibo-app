.class public Lcom/jibo/ui/helpers/skills/ViewHolders$TimeViewHolder;
.super Lcom/jibo/ui/helpers/skills/ViewHolders$AbstractSkillViewHolder;
.source "ViewHolders.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/ui/helpers/skills/ViewHolders;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "TimeViewHolder"
.end annotation


# direct methods
.method public constructor <init>(Landroid/view/View;Z)V
    .locals 0

    .prologue
    .line 248
    invoke-direct {p0, p1, p2}, Lcom/jibo/ui/helpers/skills/ViewHolders$AbstractSkillViewHolder;-><init>(Landroid/view/View;Z)V

    .line 249
    return-void
.end method


# virtual methods
.method protected bridge synthetic getTitle()Ljava/lang/CharSequence;
    .locals 1

    .prologue
    .line 245
    invoke-virtual {p0}, Lcom/jibo/ui/helpers/skills/ViewHolders$TimeViewHolder;->getTitle()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method protected getTitle()Ljava/lang/String;
    .locals 1

    .prologue
    .line 253
    iget-object v0, p0, Lcom/jibo/ui/helpers/skills/ViewHolders$TimeViewHolder;->mItem:Lcom/jibo/ui/helpers/Items$Item;

    check-cast v0, Lcom/jibo/ui/helpers/skills/Items$TimeItem;

    invoke-virtual {v0}, Lcom/jibo/ui/helpers/skills/Items$TimeItem;->getTime()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
