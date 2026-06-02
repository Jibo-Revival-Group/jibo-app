package com.jibo.aws.integration.helpers;

import android.net.Uri;
import com.jibo.aws.integration.aws.services.jot.model.Message;
import com.jibo.aws.integration.aws.services.jot.model.MessagePart;
import com.jibo.aws.integration.aws.services.media.model.Media;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public class MediaHelper {
    public static File getShareableFile(String str, Media media) {
        return new File(str, "share_" + Math.abs(media.hashCode()) + media.getCreated() + ".jpg");
    }

    public static String getUrl(boolean z, Message message, MessagePart messagePart) {
        return isMessageEncrypted(z, message) ? Uri.parse(messagePart.getUrl()).buildUpon().appendQueryParameter("loopId", message.getLoopId()).build().toString() : messagePart.getUrl();
    }

    public static String getUrl(boolean z, Media media) {
        return isMediaEncrypted(z, media) ? Uri.parse(media.getUrl()).buildUpon().appendQueryParameter("loopId", media.getLoopId()).build().toString() : media.getUrl();
    }

    public static boolean isMediaEncrypted(boolean z, Media media) {
        return z && media.isEncrypted() != null && media.isEncrypted().booleanValue();
    }

    public static boolean isMessageEncrypted(boolean z, Message message) {
        return z && message.isEncrypted() != null && message.isEncrypted().booleanValue();
    }
}
