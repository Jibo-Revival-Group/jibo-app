package com.jibo.aws.integration.helpers;

import android.text.TextUtils;
import com.jibo.aws.integration.aws.services.jot.model.Message;
import com.jibo.aws.integration.aws.services.jot.model.MessagePart;
import com.jibo.aws.integration.aws.services.media.model.Media;

/* JADX INFO: loaded from: classes.dex */
public class JotHelper {
    /* JADX INFO: renamed from: a */
    private static MessagePart m10057a(Message message, String str) {
        if (message.getParts() == null || message.getParts().isEmpty()) {
            return null;
        }
        int size = message.getParts().size();
        for (int i = 0; i < size; i++) {
            MessagePart messagePart = message.getParts().get(i);
            if (!TextUtils.isEmpty(messagePart.getType()) && messagePart.getType().equals(str)) {
                return messagePart;
            }
        }
        return null;
    }

    public static MessagePart getAudio(Message message) {
        return m10057a(message, Media.TYPE_AUDIO);
    }

    public static MessagePart getPhoto(Message message) {
        return m10057a(message, Media.TYPE_IMAGE);
    }

    public static MessagePart getRobotThumbnail(Message message) {
        return m10057a(message, Media.TYPE_THUMBNAIL_ROBOT);
    }

    public static MessagePart getThumbnail(Message message) {
        return m10057a(message, Media.TYPE_THUMBNAIL);
    }

    public static MessagePart getVideo(Message message) {
        return m10057a(message, Media.TYPE_RECORDING);
    }

    public static boolean hasAudio(Message message) {
        return hasMedia(message, Media.TYPE_AUDIO);
    }

    public static boolean hasDeletedMedia(Message message) {
        if (message.getParts() == null || message.getParts().isEmpty()) {
            return false;
        }
        int size = message.getParts().size();
        for (int i = 0; i < size; i++) {
            MessagePart messagePart = message.getParts().get(i);
            if (TextUtils.isEmpty(messagePart.getType()) || TextUtils.isEmpty(messagePart.getUrl())) {
                return true;
            }
        }
        return false;
    }

    public static boolean hasMedia(Message message, String str) {
        if (message.getParts() == null || message.getParts().isEmpty()) {
            return false;
        }
        int size = message.getParts().size();
        for (int i = 0; i < size; i++) {
            MessagePart messagePart = message.getParts().get(i);
            if (!TextUtils.isEmpty(messagePart.getType()) && messagePart.getType().equals(str) && !TextUtils.isEmpty(messagePart.getUrl())) {
                return true;
            }
        }
        return false;
    }

    public static boolean hasPhoto(Message message) {
        return hasMedia(message, Media.TYPE_IMAGE);
    }

    public static boolean hasPhotoOrVideo(Message message) {
        return hasMedia(message, Media.TYPE_IMAGE) || hasMedia(message, Media.TYPE_RECORDING);
    }

    public static boolean hasVideo(Message message) {
        return hasMedia(message, Media.TYPE_RECORDING);
    }
}
