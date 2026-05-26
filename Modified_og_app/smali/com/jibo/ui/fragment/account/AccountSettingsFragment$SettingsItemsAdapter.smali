.class public Lcom/jibo/ui/fragment/account/AccountSettingsFragment$SettingsItemsAdapter;
.super Lcom/jibo/ui/helpers/skills/SkillBasedRecycleViewAdapter;
.source "AccountSettingsFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/ui/fragment/account/AccountSettingsFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SettingsItemsAdapter"
.end annotation

.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/jibo/ui/fragment/account/AccountSettingsFragment$SettingsItemsAdapter$SpacesItemDecoration;,
        Lcom/jibo/ui/fragment/account/AccountSettingsFragment$SettingsItemsAdapter$LoopMemberSimpleViewHolder;,
        Lcom/jibo/ui/fragment/account/AccountSettingsFragment$SettingsItemsAdapter$AvatarTwoRowsSimpleViewHolder;
    }
.end annotation


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
    .line 356
    invoke-direct {p0, p1, p2}, Lcom/jibo/ui/helpers/skills/SkillBasedRecycleViewAdapter;-><init>(Ljava/util/List;Z)V

    .line 357
    return-void
.end method


# virtual methods
.method protected getViewHolderByItem(Landroid/view/View;Lcom/jibo/ui/helpers/Items$ItemType;)Lcom/jibo/ui/helpers/ViewHolders$AbstractViewHolder;
    .locals 2

    .prologue
    .line 361
    sget-object v0, Lcom/jibo/ui/fragment/account/AccountSettingsFragment$11;->a:[I

    invoke-virtual {p2}, Lcom/jibo/ui/helpers/Items$ItemType;->ordinal()I

    move-result v1

    aget v0, v0, v1

    packed-switch v0, :pswitch_data_0

    .line 366
    invoke-super {p0, p1, p2}, Lcom/jibo/ui/helpers/skills/SkillBasedRecycleViewAdapter;->getViewHolderByItem(Landroid/view/View;Lcom/jibo/ui/helpers/Items$ItemType;)Lcom/jibo/ui/helpers/ViewHolders$AbstractViewHolder;

    move-result-object v0

    :goto_0
    return-object v0

    .line 363
    :pswitch_0
    new-instance v0, Lcom/jibo/ui/fragment/account/AccountSettingsFragment$SettingsItemsAdapter$AvatarTwoRowsSimpleViewHolder;

    invoke-direct {v0, p1}, Lcom/jibo/ui/fragment/account/AccountSettingsFragment$SettingsItemsAdapter$AvatarTwoRowsSimpleViewHolder;-><init>(Landroid/view/View;)V

    goto :goto_0

    .line 365
    :pswitch_1
    new-instance v0, Lcom/jibo/ui/fragment/account/AccountSettingsFragment$SettingsItemsAdapter$LoopMemberSimpleViewHolder;

    invoke-direct {v0, p1}, Lcom/jibo/ui/fragment/account/AccountSettingsFragment$SettingsItemsAdapter$LoopMemberSimpleViewHolder;-><init>(Landroid/view/View;)V

    goto :goto_0

    .line 361
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method
