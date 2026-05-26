.class public Landroid/support/v4/app/NotificationCompat$Action;
.super Ljava/lang/Object;
.source "NotificationCompat.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/support/v4/app/NotificationCompat;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Action"
.end annotation


# instance fields
.field final a:Landroid/os/Bundle;

.field public b:I

.field public c:Ljava/lang/CharSequence;

.field public d:Landroid/app/PendingIntent;

.field private final e:[Landroid/support/v4/app/RemoteInput;

.field private final f:[Landroid/support/v4/app/RemoteInput;

.field private g:Z


# virtual methods
.method public a()I
    .locals 1

    .prologue
    .line 2795
    iget v0, p0, Landroid/support/v4/app/NotificationCompat$Action;->b:I

    return v0
.end method

.method public b()Ljava/lang/CharSequence;
    .locals 1

    .prologue
    .line 2799
    iget-object v0, p0, Landroid/support/v4/app/NotificationCompat$Action;->c:Ljava/lang/CharSequence;

    return-object v0
.end method

.method public c()Landroid/app/PendingIntent;
    .locals 1

    .prologue
    .line 2803
    iget-object v0, p0, Landroid/support/v4/app/NotificationCompat$Action;->d:Landroid/app/PendingIntent;

    return-object v0
.end method

.method public d()Landroid/os/Bundle;
    .locals 1

    .prologue
    .line 2810
    iget-object v0, p0, Landroid/support/v4/app/NotificationCompat$Action;->a:Landroid/os/Bundle;

    return-object v0
.end method

.method public e()Z
    .locals 1

    .prologue
    .line 2818
    iget-boolean v0, p0, Landroid/support/v4/app/NotificationCompat$Action;->g:Z

    return v0
.end method

.method public f()[Landroid/support/v4/app/RemoteInput;
    .locals 1

    .prologue
    .line 2827
    iget-object v0, p0, Landroid/support/v4/app/NotificationCompat$Action;->e:[Landroid/support/v4/app/RemoteInput;

    return-object v0
.end method

.method public g()[Landroid/support/v4/app/RemoteInput;
    .locals 1

    .prologue
    .line 2841
    iget-object v0, p0, Landroid/support/v4/app/NotificationCompat$Action;->f:[Landroid/support/v4/app/RemoteInput;

    return-object v0
.end method
