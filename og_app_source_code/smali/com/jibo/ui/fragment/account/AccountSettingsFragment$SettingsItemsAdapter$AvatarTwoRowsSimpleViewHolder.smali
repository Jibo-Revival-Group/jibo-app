.class public Lcom/jibo/ui/fragment/account/AccountSettingsFragment$SettingsItemsAdapter$AvatarTwoRowsSimpleViewHolder;
.super Lcom/jibo/ui/helpers/ViewHolders$AvatarTwoRowsSimpleViewHolder;
.source "AccountSettingsFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/ui/fragment/account/AccountSettingsFragment$SettingsItemsAdapter;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "AvatarTwoRowsSimpleViewHolder"
.end annotation


# direct methods
.method public constructor <init>(Landroid/view/View;)V
    .locals 1

    .prologue
    .line 373
    invoke-direct {p0, p1}, Lcom/jibo/ui/helpers/ViewHolders$AvatarTwoRowsSimpleViewHolder;-><init>(Landroid/view/View;)V

    .line 374
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/AccountSettingsFragment$SettingsItemsAdapter$AvatarTwoRowsSimpleViewHolder;->subtitle:Lcom/jibo/ui/view/proxima/CustomFontTextView;

    invoke-static {v0}, Lcom/jibo/ui/view/proxima/ProximaHelper;->b(Landroid/view/View;)V

    .line 375
    return-void
.end method
