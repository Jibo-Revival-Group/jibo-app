.class public Lcom/jibo/utils/ErrorHelper;
.super Ljava/lang/Object;
.source "ErrorHelper.java"


# direct methods
.method private static a(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    .locals 4

    .prologue
    const/4 v0, 0x0

    .line 51
    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 57
    :cond_0
    :goto_0
    return-object v0

    .line 53
    :cond_1
    invoke-virtual {p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const/high16 v2, 0x7f030000

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getStringArray(I)[Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Ljava/util/Arrays;->asList([Ljava/lang/Object;)Ljava/util/List;

    move-result-object v1

    .line 54
    invoke-virtual {p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f030001

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getStringArray(I)[Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/util/Arrays;->asList([Ljava/lang/Object;)Ljava/util/List;

    move-result-object v2

    .line 56
    invoke-interface {v1, p1}, Ljava/util/List;->indexOf(Ljava/lang/Object;)I

    move-result v1

    .line 57
    const/4 v3, -0x1

    if-eq v1, v3, :cond_0

    invoke-interface {v2}, Ljava/util/List;->size()I

    move-result v3

    if-ge v1, v3, :cond_0

    invoke-interface {v2, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    goto :goto_0
.end method

.method public static a(Landroid/content/Context;Ljava/lang/Throwable;)Ljava/lang/String;
    .locals 3

    .prologue
    .line 68
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    .line 70
    instance-of v0, p1, Lcom/amazonaws/AmazonServiceException;

    if-eqz v0, :cond_0

    move-object v0, p1

    check-cast v0, Lcom/amazonaws/AmazonServiceException;

    .line 71
    invoke-virtual {v0}, Lcom/amazonaws/AmazonServiceException;->getErrorCode()Ljava/lang/String;

    move-result-object v0

    invoke-static {p0, v0}, Lcom/jibo/utils/ErrorHelper;->a(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 72
    :goto_0
    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-nez v2, :cond_1

    .line 73
    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 96
    :goto_1
    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0

    .line 71
    :cond_0
    const/4 v0, 0x0

    goto :goto_0

    .line 74
    :cond_1
    instance-of v0, p1, Lcom/jibo/aws/integration/aws/services/exception/UnprocessableEntityException;

    if-eqz v0, :cond_2

    .line 75
    const v0, 0x7f100134

    invoke-virtual {p0, v0}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_1

    .line 76
    :cond_2
    instance-of v0, p1, Lcom/jibo/aws/integration/aws/services/exception/ServiceException;

    if-eqz v0, :cond_3

    .line 77
    const v0, 0x7f100132

    invoke-virtual {p0, v0}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_1

    .line 78
    :cond_3
    instance-of v0, p1, Lcom/jibo/aws/integration/aws/services/exception/NotAcceptableException;

    if-nez v0, :cond_4

    instance-of v0, p1, Lcom/jibo/aws/integration/aws/services/exception/MethodNotAllowedException;

    if-nez v0, :cond_4

    instance-of v0, p1, Lcom/jibo/aws/integration/aws/services/exception/InvalidRequestContentException;

    if-nez v0, :cond_4

    instance-of v0, p1, Lcom/jibo/aws/integration/aws/services/exception/InvalidParameterValueException;

    if-nez v0, :cond_4

    instance-of v0, p1, Lcom/jibo/aws/integration/aws/services/exception/ForbiddenRequestException;

    if-eqz v0, :cond_5

    .line 83
    :cond_4
    const v0, 0x7f10012a

    invoke-virtual {p0, v0}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_1

    .line 84
    :cond_5
    instance-of v0, p1, Lcom/amazonaws/AmazonClientException;

    if-eqz v0, :cond_6

    invoke-virtual {p1}, Ljava/lang/Throwable;->getMessage()Ljava/lang/String;

    move-result-object v0

    const-string v2, "No address associated with hostname"

    invoke-virtual {v0, v2}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_6

    .line 86
    const/4 v0, 0x0

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->length()I

    move-result v2

    invoke-virtual {v1, v0, v2}, Ljava/lang/StringBuilder;->delete(II)Ljava/lang/StringBuilder;

    .line 87
    const v0, 0x7f10012d

    invoke-virtual {p0, v0}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_1

    .line 88
    :cond_6
    instance-of v0, p1, Lcom/jibo/aws/integration/util/KeyManager$NoKeyForLoopException;

    if-eqz v0, :cond_8

    .line 89
    invoke-virtual {p1}, Ljava/lang/Throwable;->getLocalizedMessage()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_7

    .line 90
    invoke-virtual {p1}, Ljava/lang/Throwable;->toString()Ljava/lang/String;

    move-result-object v0

    .line 89
    :goto_2
    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_1

    .line 90
    :cond_7
    invoke-virtual {p1}, Ljava/lang/Throwable;->getLocalizedMessage()Ljava/lang/String;

    move-result-object v0

    goto :goto_2

    .line 92
    :cond_8
    const v0, 0x7f10012e

    invoke-virtual {p0, v0}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto/16 :goto_1
.end method

.method public static a(Landroid/support/v7/app/AppCompatActivity;Landroid/support/v4/app/Fragment;Ljava/lang/Throwable;)Z
    .locals 6

    .prologue
    const v3, 0x7f100107

    const v4, 0x7f1000f8

    const/16 v5, 0x64

    const/4 v1, 0x1

    .line 178
    const/4 v0, 0x0

    .line 179
    instance-of v2, p2, Lcom/amazonaws/AmazonServiceException;

    if-eqz v2, :cond_0

    .line 180
    check-cast p2, Lcom/amazonaws/AmazonServiceException;

    .line 181
    invoke-static {p2}, Lcom/jibo/utils/ErrorHelper;->a(Lcom/amazonaws/AmazonServiceException;)Z

    move-result v2

    if-eqz v2, :cond_2

    .line 183
    if-eqz p1, :cond_1

    .line 185
    invoke-virtual {p1, v3}, Landroid/support/v4/app/Fragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    .line 186
    invoke-virtual {p1, v4}, Landroid/support/v4/app/Fragment;->getString(I)Ljava/lang/String;

    move-result-object v2

    .line 184
    invoke-static {p1, v5, v0, v2}, Lcom/jibo/ui/fragment/dialog/DialogUtils;->c(Landroid/support/v4/app/Fragment;ILjava/lang/String;Ljava/lang/String;)V

    move v0, v1

    .line 207
    :cond_0
    :goto_0
    return v0

    .line 187
    :cond_1
    if-eqz p0, :cond_4

    .line 188
    const/4 v0, 0x0

    invoke-virtual {p0}, Landroid/support/v7/app/AppCompatActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v2

    .line 190
    invoke-virtual {p0, v3}, Landroid/support/v7/app/AppCompatActivity;->getString(I)Ljava/lang/String;

    move-result-object v3

    .line 191
    invoke-virtual {p0, v4}, Landroid/support/v7/app/AppCompatActivity;->getString(I)Ljava/lang/String;

    move-result-object v4

    .line 188
    invoke-static {v0, v2, v5, v3, v4}, Lcom/jibo/ui/fragment/dialog/DialogUtils;->b(Landroid/support/v4/app/Fragment;Landroid/support/v4/app/FragmentManager;ILjava/lang/String;Ljava/lang/String;)V

    move v0, v1

    goto :goto_0

    .line 194
    :cond_2
    invoke-static {p2}, Lcom/jibo/utils/ErrorHelper;->b(Lcom/amazonaws/AmazonServiceException;)Z

    move-result v2

    if-nez v2, :cond_3

    invoke-static {p2}, Lcom/jibo/utils/ErrorHelper;->c(Lcom/amazonaws/AmazonServiceException;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 197
    :cond_3
    if-eqz p1, :cond_5

    .line 198
    invoke-virtual {p1}, Landroid/support/v4/app/Fragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/activity/BaseActivity;

    .line 202
    :goto_1
    invoke-virtual {p2}, Lcom/amazonaws/AmazonServiceException;->getErrorCode()Ljava/lang/String;

    move-result-object v2

    invoke-static {v0, v2}, Lcom/jibo/utils/ErrorHelper;->a(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-static {v0, v2, v1}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v2

    .line 203
    invoke-virtual {v2}, Landroid/widget/Toast;->show()V

    .line 204
    invoke-virtual {v0}, Lcom/jibo/ui/activity/BaseActivity;->e()V

    :cond_4
    move v0, v1

    goto :goto_0

    .line 200
    :cond_5
    check-cast p0, Lcom/jibo/ui/activity/BaseActivity;

    move-object v0, p0

    goto :goto_1
.end method

.method public static a(Lcom/amazonaws/AmazonServiceException;)Z
    .locals 2

    .prologue
    .line 150
    invoke-virtual {p0}, Lcom/amazonaws/AmazonServiceException;->getStatusCode()I

    move-result v0

    const/16 v1, 0x1f7

    if-ne v0, v1, :cond_0

    const-string v0, "MAINTENANCE_MODE"

    .line 151
    invoke-virtual {p0}, Lcom/amazonaws/AmazonServiceException;->getErrorCode()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static b(Lcom/amazonaws/AmazonServiceException;)Z
    .locals 2

    .prologue
    .line 155
    instance-of v0, p0, Lcom/jibo/aws/integration/aws/services/exception/ResourceNotFoundException;

    if-eqz v0, :cond_0

    const-string v0, "ACCOUNT_NOT_FOUND"

    .line 156
    invoke-virtual {p0}, Lcom/amazonaws/AmazonServiceException;->getErrorCode()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static c(Lcom/amazonaws/AmazonServiceException;)Z
    .locals 2

    .prologue
    .line 160
    invoke-virtual {p0}, Lcom/amazonaws/AmazonServiceException;->getStatusCode()I

    move-result v0

    const/16 v1, 0x191

    if-ne v0, v1, :cond_0

    instance-of v0, p0, Lcom/jibo/aws/integration/aws/services/exception/UnauthorizedRequestException;

    if-eqz v0, :cond_0

    const-string v0, "ACCOUNT_NOT_FOUND"

    .line 162
    invoke-virtual {p0}, Lcom/amazonaws/AmazonServiceException;->getErrorCode()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static d(Lcom/amazonaws/AmazonServiceException;)Z
    .locals 2

    .prologue
    .line 166
    const-string v0, "ACCOUNT_NOT_ACTIVE"

    invoke-virtual {p0}, Lcom/amazonaws/AmazonServiceException;->getErrorCode()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    return v0
.end method
