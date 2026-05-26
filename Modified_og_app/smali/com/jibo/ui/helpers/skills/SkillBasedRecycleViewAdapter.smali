.class public Lcom/jibo/ui/helpers/skills/SkillBasedRecycleViewAdapter;
.super Lcom/jibo/ui/helpers/AbstractItemRecycleViewAdapter;
.source "SkillBasedRecycleViewAdapter.java"


# instance fields
.field private mIsOwner:Z


# direct methods
.method public constructor <init>(Ljava/util/List;Z)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/jibo/ui/helpers/Items$Item;",
            ">;Z)V"
        }
    .end annotation

    .prologue
    .line 19
    invoke-direct {p0, p1}, Lcom/jibo/ui/helpers/AbstractItemRecycleViewAdapter;-><init>(Ljava/util/List;)V

    .line 20
    iput-boolean p2, p0, Lcom/jibo/ui/helpers/skills/SkillBasedRecycleViewAdapter;->mIsOwner:Z

    .line 21
    return-void
.end method


# virtual methods
.method protected getViewHolderByItem(Landroid/view/View;Lcom/jibo/ui/helpers/Items$ItemType;)Lcom/jibo/ui/helpers/ViewHolders$AbstractViewHolder;
    .locals 2

    .prologue
    .line 25
    sget-object v0, Lcom/jibo/ui/helpers/skills/SkillBasedRecycleViewAdapter$1;->$SwitchMap$com$jibo$ui$helpers$Items$ItemType:[I

    invoke-virtual {p2}, Lcom/jibo/ui/helpers/Items$ItemType;->ordinal()I

    move-result v1

    aget v0, v0, v1

    packed-switch v0, :pswitch_data_0

    .line 44
    invoke-super {p0, p1, p2}, Lcom/jibo/ui/helpers/AbstractItemRecycleViewAdapter;->getViewHolderByItem(Landroid/view/View;Lcom/jibo/ui/helpers/Items$ItemType;)Lcom/jibo/ui/helpers/ViewHolders$AbstractViewHolder;

    move-result-object v0

    :goto_0
    return-object v0

    .line 27
    :pswitch_0
    new-instance v0, Lcom/jibo/ui/helpers/skills/ViewHolders$SkillViewHolder;

    iget-boolean v1, p0, Lcom/jibo/ui/helpers/skills/SkillBasedRecycleViewAdapter;->mIsOwner:Z

    invoke-direct {v0, p1, v1}, Lcom/jibo/ui/helpers/skills/ViewHolders$SkillViewHolder;-><init>(Landroid/view/View;Z)V

    goto :goto_0

    .line 29
    :pswitch_1
    new-instance v0, Lcom/jibo/ui/helpers/skills/ViewHolders$FooterViewHolder;

    iget-boolean v1, p0, Lcom/jibo/ui/helpers/skills/SkillBasedRecycleViewAdapter;->mIsOwner:Z

    invoke-direct {v0, p1, v1}, Lcom/jibo/ui/helpers/skills/ViewHolders$FooterViewHolder;-><init>(Landroid/view/View;Z)V

    goto :goto_0

    .line 31
    :pswitch_2
    new-instance v0, Lcom/jibo/ui/helpers/skills/ViewHolders$SwitchViewHolder;

    iget-boolean v1, p0, Lcom/jibo/ui/helpers/skills/SkillBasedRecycleViewAdapter;->mIsOwner:Z

    invoke-direct {v0, p1, v1}, Lcom/jibo/ui/helpers/skills/ViewHolders$SwitchViewHolder;-><init>(Landroid/view/View;Z)V

    goto :goto_0

    .line 33
    :pswitch_3
    new-instance v0, Lcom/jibo/ui/helpers/skills/ViewHolders$ToggleViewHolder;

    iget-boolean v1, p0, Lcom/jibo/ui/helpers/skills/SkillBasedRecycleViewAdapter;->mIsOwner:Z

    invoke-direct {v0, p1, v1}, Lcom/jibo/ui/helpers/skills/ViewHolders$ToggleViewHolder;-><init>(Landroid/view/View;Z)V

    goto :goto_0

    .line 35
    :pswitch_4
    new-instance v0, Lcom/jibo/ui/helpers/skills/ViewHolders$LocationViewHolder;

    const/4 v1, 0x1

    invoke-direct {v0, p1, v1}, Lcom/jibo/ui/helpers/skills/ViewHolders$LocationViewHolder;-><init>(Landroid/view/View;Z)V

    goto :goto_0

    .line 37
    :pswitch_5
    new-instance v0, Lcom/jibo/ui/helpers/skills/ViewHolders$ChoiceViewHolder;

    iget-boolean v1, p0, Lcom/jibo/ui/helpers/skills/SkillBasedRecycleViewAdapter;->mIsOwner:Z

    invoke-direct {v0, p1, v1}, Lcom/jibo/ui/helpers/skills/ViewHolders$ChoiceViewHolder;-><init>(Landroid/view/View;Z)V

    goto :goto_0

    .line 39
    :pswitch_6
    new-instance v0, Lcom/jibo/ui/helpers/skills/ViewHolders$TimeViewHolder;

    iget-boolean v1, p0, Lcom/jibo/ui/helpers/skills/SkillBasedRecycleViewAdapter;->mIsOwner:Z

    invoke-direct {v0, p1, v1}, Lcom/jibo/ui/helpers/skills/ViewHolders$TimeViewHolder;-><init>(Landroid/view/View;Z)V

    goto :goto_0

    .line 41
    :pswitch_7
    new-instance v0, Lcom/jibo/ui/helpers/skills/ViewHolders$ConnectableViewHolder;

    iget-boolean v1, p0, Lcom/jibo/ui/helpers/skills/SkillBasedRecycleViewAdapter;->mIsOwner:Z

    invoke-direct {v0, p1, v1}, Lcom/jibo/ui/helpers/skills/ViewHolders$ConnectableViewHolder;-><init>(Landroid/view/View;Z)V

    goto :goto_0

    .line 43
    :pswitch_8
    new-instance v0, Lcom/jibo/ui/helpers/skills/ViewHolders$OauthViewHolder;

    iget-boolean v1, p0, Lcom/jibo/ui/helpers/skills/SkillBasedRecycleViewAdapter;->mIsOwner:Z

    invoke-direct {v0, p1, v1}, Lcom/jibo/ui/helpers/skills/ViewHolders$OauthViewHolder;-><init>(Landroid/view/View;Z)V

    goto :goto_0

    .line 25
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
        :pswitch_4
        :pswitch_5
        :pswitch_6
        :pswitch_7
        :pswitch_8
    .end packed-switch
.end method
