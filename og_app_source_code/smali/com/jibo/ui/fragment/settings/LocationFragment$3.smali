.class Lcom/jibo/ui/fragment/settings/LocationFragment$3;
.super Ljava/lang/Object;
.source "LocationFragment.java"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/settings/LocationFragment;->r()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/fragment/settings/LocationFragment;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/settings/LocationFragment;)V
    .locals 0

    .prologue
    .line 391
    iput-object p1, p0, Lcom/jibo/ui/fragment/settings/LocationFragment$3;->a:Lcom/jibo/ui/fragment/settings/LocationFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/content/DialogInterface;I)V
    .locals 0

    .prologue
    .line 394
    invoke-interface {p1}, Landroid/content/DialogInterface;->dismiss()V

    .line 395
    return-void
.end method
