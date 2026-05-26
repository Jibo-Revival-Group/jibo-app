.class public Lcom/salesforce/android/service/common/ui/internal/text/TypefaceFactory;
.super Ljava/lang/Object;
.source "TypefaceFactory.java"


# direct methods
.method public static a(Landroid/content/res/AssetManager;Ljava/lang/String;)Landroid/graphics/Typeface;
    .locals 1

    .prologue
    .line 39
    invoke-static {p0, p1}, Landroid/graphics/Typeface;->createFromAsset(Landroid/content/res/AssetManager;Ljava/lang/String;)Landroid/graphics/Typeface;

    move-result-object v0

    return-object v0
.end method
