.class public final Landroid/support/customtabs/CustomTabsSession;
.super Ljava/lang/Object;
.source "CustomTabsSession.java"


# instance fields
.field private final a:Landroid/support/customtabs/ICustomTabsCallback;

.field private final b:Landroid/content/ComponentName;


# virtual methods
.method a()Landroid/os/IBinder;
    .locals 1

    .prologue
    .line 146
    iget-object v0, p0, Landroid/support/customtabs/CustomTabsSession;->a:Landroid/support/customtabs/ICustomTabsCallback;

    invoke-interface {v0}, Landroid/support/customtabs/ICustomTabsCallback;->asBinder()Landroid/os/IBinder;

    move-result-object v0

    return-object v0
.end method

.method b()Landroid/content/ComponentName;
    .locals 1

    .prologue
    .line 150
    iget-object v0, p0, Landroid/support/customtabs/CustomTabsSession;->b:Landroid/content/ComponentName;

    return-object v0
.end method
