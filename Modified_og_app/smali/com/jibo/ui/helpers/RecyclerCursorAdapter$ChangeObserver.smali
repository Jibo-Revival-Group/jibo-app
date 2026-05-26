.class Lcom/jibo/ui/helpers/RecyclerCursorAdapter$ChangeObserver;
.super Landroid/database/ContentObserver;
.source "RecyclerCursorAdapter.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/ui/helpers/RecyclerCursorAdapter;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "ChangeObserver"
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/helpers/RecyclerCursorAdapter;


# direct methods
.method public constructor <init>(Lcom/jibo/ui/helpers/RecyclerCursorAdapter;)V
    .locals 1

    .prologue
    .line 235
    iput-object p1, p0, Lcom/jibo/ui/helpers/RecyclerCursorAdapter$ChangeObserver;->a:Lcom/jibo/ui/helpers/RecyclerCursorAdapter;

    .line 236
    new-instance v0, Landroid/os/Handler;

    invoke-direct {v0}, Landroid/os/Handler;-><init>()V

    invoke-direct {p0, v0}, Landroid/database/ContentObserver;-><init>(Landroid/os/Handler;)V

    .line 237
    return-void
.end method


# virtual methods
.method public deliverSelfNotifications()Z
    .locals 1

    .prologue
    .line 241
    const/4 v0, 0x1

    return v0
.end method

.method public onChange(Z)V
    .locals 1

    .prologue
    .line 246
    iget-object v0, p0, Lcom/jibo/ui/helpers/RecyclerCursorAdapter$ChangeObserver;->a:Lcom/jibo/ui/helpers/RecyclerCursorAdapter;

    invoke-virtual {v0}, Lcom/jibo/ui/helpers/RecyclerCursorAdapter;->b()V

    .line 247
    return-void
.end method
