.class public Lcom/jibo/ui/fragment/dialog/DialogUtils;
.super Ljava/lang/Object;
.source "DialogUtils.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapperClickListener;,
        Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper;
    }
.end annotation


# direct methods
.method public static a(Landroid/support/v4/app/Fragment;ILcom/jibo/aws/integration/aws/services/loop/model/Member;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 3

    .prologue
    .line 217
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 218
    const-string v1, "ARGS_MESSAGE"

    invoke-virtual {v0, v1, p4}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 219
    const-string v1, "ARGS_TITLE"

    invoke-virtual {v0, v1, p3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 220
    const-string v1, "ARGS_OK_TEXT"

    invoke-virtual {v0, v1, p5}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 221
    const-class v1, Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    invoke-virtual {v1}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1, p2}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 222
    const-string v1, "ARGS_TYPE"

    const-string v2, "CONFIRMATION_DIALOG_ADD_CHILD"

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putSerializable(Ljava/lang/String;Ljava/io/Serializable;)V

    .line 224
    invoke-virtual {p0}, Landroid/support/v4/app/Fragment;->getFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v1

    const-string v2, "CONFIRMATION_DIALOG_ADD_CHILD"

    invoke-static {v0, p0, v1, p1, v2}, Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper;->a(Landroid/os/Bundle;Landroid/support/v4/app/Fragment;Landroid/support/v4/app/FragmentManager;ILjava/lang/String;)V

    .line 226
    return-void
.end method

.method public static a(Landroid/support/v4/app/Fragment;ILjava/lang/String;I)V
    .locals 3

    .prologue
    .line 87
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 88
    const-string v1, "ARGS_TITLE"

    invoke-virtual {v0, v1, p2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 89
    const-string v1, "ARGS_CHOICES_RES"

    invoke-virtual {v0, v1, p3}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 90
    const-string v1, "ARGS_TYPE"

    const-string v2, "SINGLE_CHOICE"

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putSerializable(Ljava/lang/String;Ljava/io/Serializable;)V

    .line 92
    const-string v1, "SINGLE_CHOICE"

    invoke-static {v0, p0, p1, v1}, Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper;->a(Landroid/os/Bundle;Landroid/support/v4/app/Fragment;ILjava/lang/String;)V

    .line 93
    return-void
.end method

.method public static a(Landroid/support/v4/app/Fragment;ILjava/lang/String;II)V
    .locals 3

    .prologue
    .line 96
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 97
    const-string v1, "ARGS_TITLE"

    invoke-virtual {v0, v1, p2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 98
    const-string v1, "ARGS_CHOICES_RES"

    invoke-virtual {v0, v1, p3}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 99
    const-string v1, "ARGS_CHOSEN_ITEM"

    invoke-virtual {v0, v1, p4}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 100
    const-string v1, "ARGS_TYPE"

    const-string v2, "SINGLE_CHOICE_RADIO"

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putSerializable(Ljava/lang/String;Ljava/io/Serializable;)V

    .line 102
    const-string v1, "SINGLE_CHOICE_RADIO"

    invoke-static {v0, p0, p1, v1}, Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper;->a(Landroid/os/Bundle;Landroid/support/v4/app/Fragment;ILjava/lang/String;)V

    .line 103
    return-void
.end method

.method public static a(Landroid/support/v4/app/Fragment;ILjava/lang/String;Ljava/lang/String;)V
    .locals 1

    .prologue
    .line 116
    invoke-virtual {p0}, Landroid/support/v4/app/Fragment;->getFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    invoke-static {p0, v0, p1, p2, p3}, Lcom/jibo/ui/fragment/dialog/DialogUtils;->a(Landroid/support/v4/app/Fragment;Landroid/support/v4/app/FragmentManager;ILjava/lang/String;Ljava/lang/String;)V

    .line 117
    return-void
.end method

.method public static a(Landroid/support/v4/app/Fragment;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 3

    .prologue
    .line 171
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 172
    const-string v1, "ARGS_TITLE"

    invoke-virtual {v0, v1, p2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 173
    const-string v1, "ARGS_MESSAGE"

    invoke-virtual {v0, v1, p3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 174
    const-string v1, "ARGS_OK_TEXT"

    invoke-virtual {v0, v1, p4}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 175
    const-string v1, "ARGS_TYPE"

    const-string v2, "CONFIRMATION_DIALOG_GREY"

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putSerializable(Ljava/lang/String;Ljava/io/Serializable;)V

    .line 177
    const-string v1, "CONFIRMATION_DIALOG_GREY"

    invoke-static {v0, p0, p1, v1}, Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper;->a(Landroid/os/Bundle;Landroid/support/v4/app/Fragment;ILjava/lang/String;)V

    .line 178
    return-void
.end method

.method public static a(Landroid/support/v4/app/Fragment;ILjava/lang/String;[I[Ljava/lang/String;)V
    .locals 3

    .prologue
    .line 247
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 248
    const-string v1, "ARGS_TYPE"

    const-string v2, "BOTTOM_DIALOG"

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putSerializable(Ljava/lang/String;Ljava/io/Serializable;)V

    .line 249
    const-string v1, "ARGS_TITLE"

    invoke-virtual {v0, v1, p2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 250
    const-string v1, "ARGS_CHOICES_RES"

    invoke-virtual {v0, v1, p3}, Landroid/os/Bundle;->putIntArray(Ljava/lang/String;[I)V

    .line 251
    const-string v1, "ARGS_CHOICES_ARRAY"

    invoke-virtual {v0, v1, p4}, Landroid/os/Bundle;->putStringArray(Ljava/lang/String;[Ljava/lang/String;)V

    .line 253
    const-string v1, "BOTTOM_DIALOG"

    invoke-static {v0, p0, p1, v1}, Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper;->a(Landroid/os/Bundle;Landroid/support/v4/app/Fragment;ILjava/lang/String;)V

    .line 254
    return-void
.end method

.method public static a(Landroid/support/v4/app/Fragment;Landroid/support/v4/app/FragmentManager;ILjava/lang/String;Ljava/lang/String;)V
    .locals 3

    .prologue
    .line 131
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 132
    const-string v1, "ARGS_MESSAGE"

    invoke-virtual {v0, v1, p3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 133
    const-string v1, "ARGS_OK_TEXT"

    invoke-virtual {v0, v1, p4}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 134
    const-string v1, "ARGS_TYPE"

    const-string v2, "CONFIRMATION_DIALOG"

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putSerializable(Ljava/lang/String;Ljava/io/Serializable;)V

    .line 136
    const-string v1, "CONFIRMATION_DIALOG"

    invoke-static {v0, p0, p1, p2, v1}, Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper;->a(Landroid/os/Bundle;Landroid/support/v4/app/Fragment;Landroid/support/v4/app/FragmentManager;ILjava/lang/String;)V

    .line 137
    return-void
.end method

.method public static a(Landroid/support/v4/app/Fragment;Landroid/support/v4/app/FragmentManager;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 3

    .prologue
    .line 206
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 207
    const-string v1, "ARGS_MESSAGE"

    invoke-virtual {v0, v1, p4}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 208
    const-string v1, "ARGS_TITLE"

    invoke-virtual {v0, v1, p3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 209
    const-string v1, "ARGS_OK_TEXT"

    invoke-virtual {v0, v1, p5}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 210
    const-string v1, "ARGS_TYPE"

    const-string v2, "INFO_DIALOG"

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putSerializable(Ljava/lang/String;Ljava/io/Serializable;)V

    .line 212
    const-string v1, "INFO_DIALOG"

    invoke-static {v0, p0, p1, p2, v1}, Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper;->a(Landroid/os/Bundle;Landroid/support/v4/app/Fragment;Landroid/support/v4/app/FragmentManager;ILjava/lang/String;)V

    .line 213
    return-void
.end method

.method public static a(Landroid/support/v4/app/Fragment;Landroid/support/v4/app/FragmentManager;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 3

    .prologue
    .line 120
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 121
    const-string v1, "ARGS_MESSAGE"

    invoke-virtual {v0, v1, p4}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 122
    const-string v1, "ARGS_TITLE"

    invoke-virtual {v0, v1, p3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 123
    const-string v1, "ARGS_OK_TEXT"

    invoke-virtual {v0, v1, p5}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 124
    const-string v1, "ARGS_CANCEL_TEXT"

    invoke-virtual {v0, v1, p6}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 125
    const-string v1, "ARGS_TYPE"

    const-string v2, "REGULAR"

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putSerializable(Ljava/lang/String;Ljava/io/Serializable;)V

    .line 127
    const-string v1, "CONFIRMATION_DIALOG"

    invoke-static {v0, p0, p1, p2, v1}, Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper;->a(Landroid/os/Bundle;Landroid/support/v4/app/Fragment;Landroid/support/v4/app/FragmentManager;ILjava/lang/String;)V

    .line 128
    return-void
.end method

.method public static a(Landroid/support/v4/app/FragmentManager;)Z
    .locals 5

    .prologue
    const/4 v0, 0x0

    .line 229
    const-class v1, Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper$DialogType;

    invoke-virtual {v1}, Ljava/lang/Class;->getDeclaredFields()[Ljava/lang/reflect/Field;

    move-result-object v2

    .line 230
    array-length v3, v2

    move v1, v0

    :goto_0
    if-ge v1, v3, :cond_0

    aget-object v4, v2, v1

    .line 231
    invoke-virtual {v4}, Ljava/lang/reflect/Field;->getName()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {p0, v4}, Landroid/support/v4/app/FragmentManager;->a(Ljava/lang/String;)Landroid/support/v4/app/Fragment;

    move-result-object v4

    if-eqz v4, :cond_1

    const/4 v0, 0x1

    .line 233
    :cond_0
    return v0

    .line 230
    :cond_1
    add-int/lit8 v1, v1, 0x1

    goto :goto_0
.end method

.method public static b(Landroid/support/v4/app/Fragment;ILjava/lang/String;Ljava/lang/String;)V
    .locals 1

    .prologue
    .line 167
    const-string v0, ""

    invoke-static {p0, p1, v0, p2, p3}, Lcom/jibo/ui/fragment/dialog/DialogUtils;->a(Landroid/support/v4/app/Fragment;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 168
    return-void
.end method

.method public static b(Landroid/support/v4/app/Fragment;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 6

    .prologue
    .line 198
    invoke-virtual {p0}, Landroid/support/v4/app/Fragment;->getFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v1

    move-object v0, p0

    move v2, p1

    move-object v3, p2

    move-object v4, p3

    move-object v5, p4

    invoke-static/range {v0 .. v5}, Lcom/jibo/ui/fragment/dialog/DialogUtils;->a(Landroid/support/v4/app/Fragment;Landroid/support/v4/app/FragmentManager;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 199
    return-void
.end method

.method public static b(Landroid/support/v4/app/Fragment;Landroid/support/v4/app/FragmentManager;ILjava/lang/String;Ljava/lang/String;)V
    .locals 3

    .prologue
    .line 185
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 186
    const-string v1, "ARGS_MESSAGE"

    invoke-virtual {v0, v1, p4}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 187
    const-string v1, "ARGS_TITLE"

    invoke-virtual {v0, v1, p3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 188
    const-string v1, "ARGS_TYPE"

    const-string v2, "INFO_DIALOG_MAINTENANCE"

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putSerializable(Ljava/lang/String;Ljava/io/Serializable;)V

    .line 190
    const-string v1, "INFO_DIALOG_MAINTENANCE"

    invoke-static {v0, p0, p1, p2, v1}, Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper;->a(Landroid/os/Bundle;Landroid/support/v4/app/Fragment;Landroid/support/v4/app/FragmentManager;ILjava/lang/String;)V

    .line 191
    return-void
.end method

.method public static c(Landroid/support/v4/app/Fragment;ILjava/lang/String;Ljava/lang/String;)V
    .locals 1

    .prologue
    .line 181
    invoke-virtual {p0}, Landroid/support/v4/app/Fragment;->getFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    invoke-static {p0, v0, p1, p2, p3}, Lcom/jibo/ui/fragment/dialog/DialogUtils;->b(Landroid/support/v4/app/Fragment;Landroid/support/v4/app/FragmentManager;ILjava/lang/String;Ljava/lang/String;)V

    .line 182
    return-void
.end method

.method public static c(Landroid/support/v4/app/Fragment;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 3

    .prologue
    .line 237
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 238
    const-string v1, "ARGS_MESSAGE"

    invoke-virtual {v0, v1, p2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 239
    const-string v1, "ARGS_OK_TEXT"

    invoke-virtual {v0, v1, p3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 240
    const-string v1, "ARGS_CANCEL_TEXT"

    invoke-virtual {v0, v1, p4}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 241
    const-string v1, "ARGS_TYPE"

    const-string v2, "CONFIRMATION_DIALOG_GREY"

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putSerializable(Ljava/lang/String;Ljava/io/Serializable;)V

    .line 243
    const-string v1, "CONFIRMATION_DIALOG_GREY"

    invoke-static {v0, p0, p1, v1}, Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper;->a(Landroid/os/Bundle;Landroid/support/v4/app/Fragment;ILjava/lang/String;)V

    .line 244
    return-void
.end method

.method public static c(Landroid/support/v4/app/Fragment;Landroid/support/v4/app/FragmentManager;ILjava/lang/String;Ljava/lang/String;)V
    .locals 6

    .prologue
    .line 202
    const/4 v5, 0x0

    move-object v0, p0

    move-object v1, p1

    move v2, p2

    move-object v3, p3

    move-object v4, p4

    invoke-static/range {v0 .. v5}, Lcom/jibo/ui/fragment/dialog/DialogUtils;->a(Landroid/support/v4/app/Fragment;Landroid/support/v4/app/FragmentManager;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 203
    return-void
.end method

.method public static d(Landroid/support/v4/app/Fragment;ILjava/lang/String;Ljava/lang/String;)V
    .locals 6

    .prologue
    .line 194
    invoke-virtual {p0}, Landroid/support/v4/app/Fragment;->getFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v1

    const/4 v5, 0x0

    move-object v0, p0

    move v2, p1

    move-object v3, p2

    move-object v4, p3

    invoke-static/range {v0 .. v5}, Lcom/jibo/ui/fragment/dialog/DialogUtils;->a(Landroid/support/v4/app/Fragment;Landroid/support/v4/app/FragmentManager;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 195
    return-void
.end method
