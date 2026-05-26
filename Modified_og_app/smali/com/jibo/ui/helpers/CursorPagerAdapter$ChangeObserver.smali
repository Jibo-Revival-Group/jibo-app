.class Lcom/jibo/ui/helpers/CursorPagerAdapter$ChangeObserver;
.super Landroid/database/ContentObserver;
.source "CursorPagerAdapter.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/ui/helpers/CursorPagerAdapter;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "ChangeObserver"
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/helpers/CursorPagerAdapter;


# direct methods
.method public constructor <init>(Lcom/jibo/ui/helpers/CursorPagerAdapter;)V
    .locals 1

    .prologue
    .line 160
    iput-object p1, p0, Lcom/jibo/ui/helpers/CursorPagerAdapter$ChangeObserver;->a:Lcom/jibo/ui/helpers/CursorPagerAdapter;

    .line 161
    new-instance v0, Landroid/os/Handler;

    invoke-direct {v0}, Landroid/os/Handler;-><init>()V

    invoke-direct {p0, v0}, Landroid/database/ContentObserver;-><init>(Landroid/os/Handler;)V

    .line 162
    return-void
.end method


# virtual methods
.method public deliverSelfNotifications()Z
    .locals 1

    .prologue
    .line 166
    const/4 v0, 0x1

    return v0
.end method

.method public onChange(Z)V
    .locals 1

    .prologue
    .line 171
    iget-object v0, p0, Lcom/jibo/ui/helpers/CursorPagerAdapter$ChangeObserver;->a:Lcom/jibo/ui/helpers/CursorPagerAdapter;

    invoke-virtual {v0}, Lcom/jibo/ui/helpers/CursorPagerAdapter;->e()V

    .line 172
    return-void
.end method
