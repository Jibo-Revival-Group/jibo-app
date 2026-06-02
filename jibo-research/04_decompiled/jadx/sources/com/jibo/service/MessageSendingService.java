package com.jibo.service;

import android.app.IntentService;
import android.app.Service;
import android.content.Intent;
import android.graphics.BitmapFactory;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.cognitoidentity.model.InvalidParameterException;
import com.crashlytics.android.Crashlytics;
import com.google.gson.JsonObject;
import com.jibo.aws.integration.aws.services.account.model.Account;
import com.jibo.aws.integration.aws.services.jot.model.Message;
import com.jibo.aws.integration.aws.services.jot.model.MessagePart;
import com.jibo.aws.integration.aws.services.media.JiboMediaClient;
import com.jibo.aws.integration.aws.services.media.model.Media;
import com.jibo.aws.integration.helpers.JotHelper;
import com.jibo.aws.integration.util.KeyManager;
import com.jibo.p018db.EntityData;
import com.jibo.utils.ImageUtils;
import com.jibo.utils.ServiceUtils;
import java.io.File;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import org.apache.http.HttpHost;

/* JADX INFO: loaded from: classes.dex */
public class MessageSendingService extends IntentService {

    /* JADX INFO: renamed from: a */
    public static final String f9754a = MessageSendingService.class.getSimpleName();

    /* JADX INFO: renamed from: b */
    private Account f9755b;

    /* JADX INFO: renamed from: c */
    private JiboMediaClient f9756c;

    public MessageSendingService() {
        super(f9754a);
        this.f9756c = null;
    }

    @Override // android.app.IntentService, android.app.Service
    public void onCreate() {
        super.onCreate();
        ServiceUtils.m11426a((Service) this);
    }

    @Override // android.app.IntentService, android.app.Service
    public void onDestroy() {
        super.onDestroy();
        ServiceUtils.m11428b(this);
    }

    @Override // android.app.IntentService
    protected void onHandleIntent(Intent intent) {
        MessagePart messagePartM10172a;
        Message message = (Message) intent.getParcelableExtra("EXTRA_MESSAGE");
        if (message != null) {
            String id = message.getId();
            try {
                try {
                    this.f9755b = EntityData.m10089a(this).m10134i();
                    if (JotHelper.hasPhoto(message)) {
                        this.f9756c = new JiboMediaClient(new BasicAWSCredentials(this.f9755b.getAccessKeyId(), this.f9755b.getSecretAccessKey()));
                        MessagePart photo = JotHelper.getPhoto(message);
                        MessagePart thumbnail = JotHelper.getThumbnail(message);
                        MessagePart robotThumbnail = JotHelper.getRobotThumbnail(message);
                        if (photo != null) {
                            String url = photo.getUrl();
                            if (thumbnail == null) {
                                thumbnail = m10172a(url, url + ".thumb", Media.TYPE_THUMBNAIL, 720, 405);
                                message.getParts().add(thumbnail);
                            }
                            MessagePart messagePart = thumbnail;
                            if (robotThumbnail == null) {
                                messagePartM10172a = m10172a(url, url + ".robot_thumb", Media.TYPE_THUMBNAIL_ROBOT, 330, 330);
                                message.getParts().add(messagePartM10172a);
                            } else {
                                messagePartM10172a = robotThumbnail;
                            }
                            m10174a(message, photo, null);
                            m10174a(message, messagePart, photo);
                            m10174a(message, messagePartM10172a, photo);
                        }
                    }
                    if (this.f9756c != null) {
                        this.f9756c.shutdown();
                    }
                } catch (Exception e) {
                    Crashlytics.m5597a((Throwable) e);
                    message.setId("TEMP_FAILED_" + String.valueOf(System.currentTimeMillis()));
                    EntityData.m10089a(this).m10116a(message, id);
                    if (this.f9756c != null) {
                        this.f9756c.shutdown();
                    }
                }
            } catch (Throwable th) {
                if (this.f9756c != null) {
                    this.f9756c.shutdown();
                }
                throw th;
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private MessagePart m10172a(String str, String str2, String str3, int i, int i2) throws IOException {
        ImageUtils.m11398a(str, str2, i, i2);
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str2, options);
        JsonObject jsonObject = new JsonObject();
        jsonObject.m9405a("mime-type", options.outMimeType);
        MessagePart messagePart = new MessagePart();
        messagePart.setType(str3);
        messagePart.setUrl(str2);
        messagePart.setMeta(jsonObject);
        return messagePart;
    }

    /* JADX INFO: renamed from: a */
    private void m10174a(Message message, MessagePart messagePart, MessagePart messagePart2) throws BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, KeyManager.NoKeyForLoopException, InvalidKeyException, IOException, InvalidAlgorithmParameterException {
        if (messagePart == null) {
            throw new InvalidParameterException("messagePart cant be null");
        }
        if (!messagePart.getUrl().startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
            Media mediaCreate = this.f9756c.create(message.getLoopId(), messagePart.getType(), messagePart2 != null ? messagePart2.getPath() : null, null, m10173a(new File(messagePart.getUrl()), message), message.isEncrypted());
            messagePart.setUrl(mediaCreate.getUrl());
            messagePart.setPath(mediaCreate.getPath());
        }
    }

    /* JADX INFO: renamed from: a */
    private File m10173a(File file, Message message) throws BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, KeyManager.NoKeyForLoopException, InvalidKeyException, IOException, InvalidAlgorithmParameterException {
        if (message.isEncrypted().booleanValue()) {
            File file2 = new File(file.getAbsolutePath() + "_");
            file2.delete();
            KeyManager.getInstance(getApplicationContext(), this.f9755b.getId()).obtainKeyHolder(getApplicationContext(), message.getLoopId()).encodeFile(file, file2);
            if (file2.length() <= 0) {
                file2 = null;
            }
            return file2;
        }
        return file;
    }
}
