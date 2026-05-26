.class public Lcom/jibo/ui/view/proxima/ProximaHelper;
.super Ljava/lang/Object;
.source "ProximaHelper.java"


# static fields
.field public static a:Landroid/graphics/Typeface;

.field public static b:Landroid/graphics/Typeface;

.field public static c:Landroid/graphics/Typeface;

.field public static d:Landroid/graphics/Typeface;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    const/4 v0, 0x0

    .line 16
    sput-object v0, Lcom/jibo/ui/view/proxima/ProximaHelper;->a:Landroid/graphics/Typeface;

    .line 17
    sput-object v0, Lcom/jibo/ui/view/proxima/ProximaHelper;->b:Landroid/graphics/Typeface;

    .line 18
    sput-object v0, Lcom/jibo/ui/view/proxima/ProximaHelper;->c:Landroid/graphics/Typeface;

    .line 19
    sput-object v0, Lcom/jibo/ui/view/proxima/ProximaHelper;->d:Landroid/graphics/Typeface;

    return-void
.end method

.method public static a(Landroid/content/Context;Ljava/lang/String;)Landroid/graphics/Typeface;
    .locals 3

    .prologue
    .line 29
    sget-object v0, Lcom/jibo/ui/view/proxima/ProximaHelper;->a:Landroid/graphics/Typeface;

    .line 31
    :try_start_0
    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-nez v1, :cond_0

    const-string v1, "ProximaNova-Regular.ttf"

    invoke-virtual {p1, v1}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 32
    invoke-virtual {p0}, Landroid/content/Context;->getAssets()Landroid/content/res/AssetManager;

    move-result-object v0

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "fonts/"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/graphics/Typeface;->createFromAsset(Landroid/content/res/AssetManager;Ljava/lang/String;)Landroid/graphics/Typeface;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    .line 36
    :cond_0
    :goto_0
    return-object v0

    .line 33
    :catch_0
    move-exception v0

    .line 34
    sget-object v0, Lcom/jibo/ui/view/proxima/ProximaHelper;->a:Landroid/graphics/Typeface;

    goto :goto_0
.end method

.method public static a(Landroid/content/Context;)V
    .locals 2

    .prologue
    .line 22
    invoke-virtual {p0}, Landroid/content/Context;->getAssets()Landroid/content/res/AssetManager;

    move-result-object v0

    const-string v1, "fonts/ProximaNova-Light.ttf"

    invoke-static {v0, v1}, Landroid/graphics/Typeface;->createFromAsset(Landroid/content/res/AssetManager;Ljava/lang/String;)Landroid/graphics/Typeface;

    move-result-object v0

    sput-object v0, Lcom/jibo/ui/view/proxima/ProximaHelper;->b:Landroid/graphics/Typeface;

    .line 23
    invoke-virtual {p0}, Landroid/content/Context;->getAssets()Landroid/content/res/AssetManager;

    move-result-object v0

    const-string v1, "fonts/ProximaNova-Regular.ttf"

    invoke-static {v0, v1}, Landroid/graphics/Typeface;->createFromAsset(Landroid/content/res/AssetManager;Ljava/lang/String;)Landroid/graphics/Typeface;

    move-result-object v0

    sput-object v0, Lcom/jibo/ui/view/proxima/ProximaHelper;->a:Landroid/graphics/Typeface;

    .line 24
    invoke-virtual {p0}, Landroid/content/Context;->getAssets()Landroid/content/res/AssetManager;

    move-result-object v0

    const-string v1, "fonts/ProximaNova-Semibold.ttf"

    invoke-static {v0, v1}, Landroid/graphics/Typeface;->createFromAsset(Landroid/content/res/AssetManager;Ljava/lang/String;)Landroid/graphics/Typeface;

    move-result-object v0

    sput-object v0, Lcom/jibo/ui/view/proxima/ProximaHelper;->c:Landroid/graphics/Typeface;

    .line 25
    invoke-virtual {p0}, Landroid/content/Context;->getAssets()Landroid/content/res/AssetManager;

    move-result-object v0

    const-string v1, "fonts/ProximaNova-Bold.otf"

    invoke-static {v0, v1}, Landroid/graphics/Typeface;->createFromAsset(Landroid/content/res/AssetManager;Ljava/lang/String;)Landroid/graphics/Typeface;

    move-result-object v0

    sput-object v0, Lcom/jibo/ui/view/proxima/ProximaHelper;->d:Landroid/graphics/Typeface;

    .line 26
    return-void
.end method

.method public static a(Landroid/view/View;)V
    .locals 1

    .prologue
    .line 83
    instance-of v0, p0, Landroid/widget/TextView;

    if-eqz v0, :cond_1

    .line 84
    check-cast p0, Landroid/widget/TextView;

    sget-object v0, Lcom/jibo/ui/view/proxima/ProximaHelper;->a:Landroid/graphics/Typeface;

    invoke-virtual {p0, v0}, Landroid/widget/TextView;->setTypeface(Landroid/graphics/Typeface;)V

    .line 88
    :cond_0
    :goto_0
    return-void

    .line 85
    :cond_1
    instance-of v0, p0, Landroid/support/design/widget/TextInputLayout;

    if-eqz v0, :cond_0

    .line 86
    check-cast p0, Landroid/support/design/widget/TextInputLayout;

    sget-object v0, Lcom/jibo/ui/view/proxima/ProximaHelper;->a:Landroid/graphics/Typeface;

    invoke-virtual {p0, v0}, Landroid/support/design/widget/TextInputLayout;->setTypeface(Landroid/graphics/Typeface;)V

    goto :goto_0
.end method

.method public static a(Landroid/view/View;Ljava/lang/String;)V
    .locals 2

    .prologue
    .line 46
    invoke-virtual {p0}, Landroid/view/View;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0, p1}, Lcom/jibo/ui/view/proxima/ProximaHelper;->a(Landroid/content/Context;Ljava/lang/String;)Landroid/graphics/Typeface;

    move-result-object v0

    .line 47
    instance-of v1, p0, Landroid/widget/TextView;

    if-eqz v1, :cond_1

    .line 48
    check-cast p0, Landroid/widget/TextView;

    invoke-virtual {p0, v0}, Landroid/widget/TextView;->setTypeface(Landroid/graphics/Typeface;)V

    .line 52
    :cond_0
    :goto_0
    return-void

    .line 49
    :cond_1
    instance-of v1, p0, Landroid/support/design/widget/TextInputLayout;

    if-eqz v1, :cond_0

    .line 50
    check-cast p0, Landroid/support/design/widget/TextInputLayout;

    invoke-virtual {p0, v0}, Landroid/support/design/widget/TextInputLayout;->setTypeface(Landroid/graphics/Typeface;)V

    goto :goto_0
.end method

.method public static b(Landroid/view/View;)V
    .locals 1

    .prologue
    .line 91
    instance-of v0, p0, Landroid/widget/TextView;

    if-eqz v0, :cond_1

    .line 92
    check-cast p0, Landroid/widget/TextView;

    sget-object v0, Lcom/jibo/ui/view/proxima/ProximaHelper;->c:Landroid/graphics/Typeface;

    invoke-virtual {p0, v0}, Landroid/widget/TextView;->setTypeface(Landroid/graphics/Typeface;)V

    .line 96
    :cond_0
    :goto_0
    return-void

    .line 93
    :cond_1
    instance-of v0, p0, Landroid/support/design/widget/TextInputLayout;

    if-eqz v0, :cond_0

    .line 94
    check-cast p0, Landroid/support/design/widget/TextInputLayout;

    sget-object v0, Lcom/jibo/ui/view/proxima/ProximaHelper;->c:Landroid/graphics/Typeface;

    invoke-virtual {p0, v0}, Landroid/support/design/widget/TextInputLayout;->setTypeface(Landroid/graphics/Typeface;)V

    goto :goto_0
.end method
