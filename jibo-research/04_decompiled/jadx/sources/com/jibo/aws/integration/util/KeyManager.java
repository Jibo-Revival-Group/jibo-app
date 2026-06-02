package com.jibo.aws.integration.util;

import android.content.Context;
import android.security.KeyPairGeneratorSpec;
import android.text.TextUtils;
import android.util.Base64;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.spec.X509EncodedKeySpec;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Enumeration;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.security.auth.x500.X500Principal;
import org.apache.http.protocol.HTTP;

/* JADX INFO: loaded from: classes.dex */
public class KeyManager {
    public static final String DATA_SEPARATOR = "\n-----SIGNATURE-----\n";
    public static final String SIGNATURE_ALGORITHM = "SHA256withRSA";

    /* JADX INFO: renamed from: a */
    private static final String f9682a = KeyManager.class.getSimpleName();

    /* JADX INFO: renamed from: b */
    private static final byte[] f9683b = {2, 4, 6, 8, 31, 29, 27, 25, 9, 11, 13, 15, 24, 22, 20, 18};

    /* JADX INFO: renamed from: c */
    private static final byte[] f9684c = {10, 32, 101, 88, 3, 75, 46, 57, 94, 11, 27, 40, 6, 112, 51, 80};

    /* JADX INFO: renamed from: d */
    private static KeyManager f9685d = null;

    /* JADX INFO: renamed from: e */
    private KeyStore f9686e;

    /* JADX INFO: renamed from: f */
    private KeyStore.Entry f9687f;

    /* JADX INFO: renamed from: g */
    private String f9688g;

    public static class NoKeyForLoopException extends Exception {
        public NoKeyForLoopException() {
        }

        public NoKeyForLoopException(String str) {
            super("No key for loop:" + str);
        }

        public NoKeyForLoopException(String str, Throwable th) {
            super(str, th);
        }

        public NoKeyForLoopException(Throwable th) {
            super(th);
        }
    }

    public static class SymmetricKeyHolder {

        /* JADX INFO: renamed from: a */
        private SecretKey f9689a;

        /* JADX INFO: renamed from: b */
        private IvParameterSpec f9690b = new IvParameterSpec(m10068a());

        public SymmetricKeyHolder(SecretKey secretKey) {
            this.f9689a = secretKey;
        }

        /* JADX INFO: renamed from: a */
        private PublicKey m10066a(String str) {
            try {
                return KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(str.replace("-----BEGIN PUBLIC KEY-----\n", "").replace("\n-----END PUBLIC KEY-----", ""), 0)));
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        /* JADX INFO: renamed from: a */
        private void m10067a(InputStream inputStream, OutputStream outputStream) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IOException, InvalidAlgorithmParameterException {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(1, this.f9689a, this.f9690b);
            CipherOutputStream cipherOutputStream = new CipherOutputStream(outputStream, cipher);
            byte[] bArr = new byte[1024];
            while (true) {
                int i = inputStream.read(bArr);
                if (i == -1) {
                    inputStream.close();
                    cipherOutputStream.close();
                    outputStream.close();
                    return;
                }
                cipherOutputStream.write(bArr, 0, i);
            }
        }

        /* JADX INFO: renamed from: a */
        private byte[] m10068a() {
            byte[] bArr = new byte[16];
            byte[] encoded = this.f9689a.getEncoded();
            for (int i = 0; i < KeyManager.f9683b.length; i++) {
                bArr[i] = encoded[KeyManager.f9683b[i]];
            }
            return bArr;
        }

        /* JADX INFO: renamed from: b */
        private void m10069b(InputStream inputStream, OutputStream outputStream) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IOException, InvalidAlgorithmParameterException {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(2, this.f9689a, this.f9690b);
            CipherInputStream cipherInputStream = new CipherInputStream(inputStream, cipher);
            byte[] bArr = new byte[1024];
            while (true) {
                int i = cipherInputStream.read(bArr);
                if (i == -1) {
                    inputStream.close();
                    cipherInputStream.close();
                    outputStream.close();
                    return;
                }
                outputStream.write(bArr, 0, i);
            }
        }

        public void decodeFile(File file, File file2) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IOException, InvalidAlgorithmParameterException {
            m10069b(new FileInputStream(file), new FileOutputStream(file2));
        }

        public String decodeString(String str) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(2, this.f9689a, this.f9690b);
            return new String(cipher.doFinal(Base64.decode(str, 2)), HTTP.UTF_8);
        }

        public void encodeFile(File file, File file2) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IOException, InvalidAlgorithmParameterException {
            m10067a(new FileInputStream(file), new FileOutputStream(file2));
        }

        public String encodeString(String str) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(1, this.f9689a, this.f9690b);
            return Base64.encodeToString(cipher.doFinal(str.getBytes(HTTP.UTF_8)), 2);
        }

        public String shareSymmetricKey(String str) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException {
            PublicKey publicKeyM10066a = m10066a(str);
            Cipher cipher = Cipher.getInstance("RSA/NONE/PKCS1Padding");
            cipher.init(1, publicKeyM10066a);
            return Base64.encodeToString(cipher.doFinal(this.f9689a.getEncoded()), 2);
        }
    }

    public KeyManager(String str) {
        try {
            this.f9688g = str;
            this.f9686e = KeyStore.getInstance("AndroidKeyStore");
            this.f9686e.load(null);
        } catch (Exception e) {
            C0977a.m10078d(f9682a, "Could not create KeyManager", e);
        }
    }

    /* JADX INFO: renamed from: a */
    private String m10058a(String str) {
        return "loop_" + this.f9688g + "_" + str;
    }

    /* JADX INFO: renamed from: a */
    private void m10059a(Context context) {
        try {
            String str = "account_" + this.f9688g;
            if (!this.f9686e.containsAlias(str)) {
                Calendar calendar = Calendar.getInstance();
                Calendar calendar2 = Calendar.getInstance();
                calendar2.add(1, 50);
                KeyPairGeneratorSpec keyPairGeneratorSpecBuild = new KeyPairGeneratorSpec.Builder(context).setAlias(str).setSubject(new X500Principal("CN=" + str + ", O=Jibo Authority")).setSerialNumber(BigInteger.ONE).setStartDate(calendar.getTime()).setEndDate(calendar2.getTime()).build();
                KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA", "AndroidKeyStore");
                keyPairGenerator.initialize(keyPairGeneratorSpecBuild);
                keyPairGenerator.generateKeyPair();
            }
            this.f9687f = this.f9686e.getEntry(str, null);
            if (!(this.f9687f instanceof KeyStore.PrivateKeyEntry)) {
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: renamed from: a */
    private void m10060a(Context context, String str, byte[] bArr) throws BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeyException, IOException {
        Cipher cipher = Cipher.getInstance("RSA/NONE/PKCS1Padding");
        cipher.init(1, ((KeyStore.PrivateKeyEntry) this.f9687f).getCertificate().getPublicKey());
        byte[] bArrDoFinal = cipher.doFinal(Base64.encodeToString(bArr, 0).getBytes(HTTP.UTF_8));
        File file = new File(context.getFilesDir(), m10058a(str));
        if (file.exists()) {
            file.delete();
        }
        FileOutputStream fileOutputStreamOpenFileOutput = context.openFileOutput(m10058a(str), 0);
        fileOutputStreamOpenFileOutput.write(bArrDoFinal);
        fileOutputStreamOpenFileOutput.close();
    }

    /* JADX INFO: renamed from: a */
    private byte[] m10062a(Context context, String str) throws BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, NoKeyForLoopException, InvalidKeyException, IOException {
        if (!m10065c(context.getApplicationContext(), str)) {
            throw new NoKeyForLoopException(str);
        }
        Cipher cipher = Cipher.getInstance("RSA/NONE/PKCS1Padding");
        cipher.init(2, ((KeyStore.PrivateKeyEntry) this.f9687f).getPrivateKey());
        FileInputStream fileInputStreamOpenFileInput = context.openFileInput(m10058a(str));
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            int i = fileInputStreamOpenFileInput.read();
            if (i == -1) {
                byte[] bArrDoFinal = cipher.doFinal(byteArrayOutputStream.toByteArray());
                fileInputStreamOpenFileInput.close();
                byteArrayOutputStream.close();
                return Base64.decode(new String(bArrDoFinal, 0, bArrDoFinal.length, HTTP.UTF_8), 0);
            }
            byteArrayOutputStream.write(i);
        }
    }

    /* JADX INFO: renamed from: a */
    private byte[] m10063a(String str, String str2) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        SecretKeySpec secretKeySpec = new SecretKeySpec(MessageDigest.getInstance("SHA-256").digest(str2.getBytes(HTTP.UTF_8)), "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(2, secretKeySpec, new IvParameterSpec(f9684c));
        return cipher.doFinal(Base64.decode(str, 0));
    }

    /* JADX INFO: renamed from: b */
    private SecretKey m10064b(Context context, String str) throws BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, NoKeyForLoopException, InvalidKeyException, IOException {
        byte[] bArrM10062a = m10062a(context, str);
        return new SecretKeySpec(bArrM10062a, 0, bArrM10062a.length, "AES");
    }

    /* JADX INFO: renamed from: c */
    private boolean m10065c(Context context, String str) {
        return new File(context.getFilesDir(), m10058a(str)).exists();
    }

    public static synchronized KeyManager getInstance(Context context, String str) {
        if (f9685d == null) {
            f9685d = new KeyManager(str);
            f9685d.m10059a(context.getApplicationContext());
        }
        return f9685d;
    }

    public void deleteAccountData(Context context) {
        try {
            Enumeration<String> enumerationAliases = this.f9686e.aliases();
            String str = "account_" + this.f9688g;
            while (enumerationAliases.hasMoreElements()) {
                try {
                    String strNextElement = enumerationAliases.nextElement();
                    if (strNextElement.equals(str)) {
                        this.f9686e.deleteEntry(strNextElement);
                    } else {
                        continue;
                    }
                } catch (Exception e) {
                    C0977a.m10078d(f9682a, "Could not delete key alias", e);
                }
            }
        } catch (Exception e2) {
            C0977a.m10078d(f9682a, "Could not delete any of the aliases", e2);
        }
        try {
            File filesDir = context.getFilesDir();
            String str2 = "loop_" + this.f9688g + "_";
            File[] fileArrListFiles = filesDir.listFiles();
            for (File file : fileArrListFiles) {
                if (file.getName().startsWith(str2)) {
                    file.delete();
                }
            }
        } catch (Exception e3) {
            C0977a.m10078d(f9682a, "Could not delete key file", e3);
        }
    }

    public void generateSymmetricKey(Context context, String str, boolean z) throws BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeyException, IOException {
        SecureRandom secureRandom = new SecureRandom();
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(256, secureRandom);
        SecretKey secretKeyGenerateKey = keyGenerator.generateKey();
        C0977a.m10072a("KeyManager", "generateSymmetricKey raw:" + Base64.encodeToString(secretKeyGenerateKey.getEncoded(), 0));
        Cipher cipher = Cipher.getInstance("RSA/NONE/PKCS1Padding");
        cipher.init(1, ((KeyStore.PrivateKeyEntry) this.f9687f).getCertificate().getPublicKey());
        byte[] bArrDoFinal = cipher.doFinal(Base64.encodeToString(secretKeyGenerateKey.getEncoded(), 0).getBytes(HTTP.UTF_8));
        C0977a.m10072a("KeyManager", "generateSymmetricKey encoded:" + Base64.encodeToString(bArrDoFinal, 0));
        File file = new File(context.getFilesDir(), m10058a(str));
        if (file.exists() && z) {
            file.delete();
        }
        FileOutputStream fileOutputStreamOpenFileOutput = context.openFileOutput(m10058a(str), 0);
        fileOutputStreamOpenFileOutput.write(bArrDoFinal);
        fileOutputStreamOpenFileOutput.close();
    }

    public String getEncryptedKey(Context context, String str, String str2) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        String strEncodeToString = Base64.encodeToString(m10062a(context, str), 0);
        byte[] bArrDigest = MessageDigest.getInstance("SHA-256").digest(str2.getBytes(HTTP.UTF_8));
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(1, new SecretKeySpec(bArrDigest, "AES"), new IvParameterSpec(f9684c));
        String strEncodeToString2 = Base64.encodeToString(cipher.doFinal(strEncodeToString.getBytes(HTTP.UTF_8)), 0);
        C0977a.m10072a("KEY", "getEncryptedKey: " + strEncodeToString2);
        return strEncodeToString2;
    }

    public String getPublicKeyForSharing() {
        return Base64.encodeToString(((KeyStore.PrivateKeyEntry) this.f9687f).getCertificate().getPublicKey().getEncoded(), 2).trim();
    }

    public String getSymmetricalKey(Context context, String str) {
        return Base64.encodeToString(m10062a(context, str), 0);
    }

    public void logout(Context context) {
        try {
            this.f9686e = null;
            f9685d = null;
        } catch (Exception e) {
        }
    }

    public SymmetricKeyHolder obtainKeyHolder(Context context, String str) {
        return new SymmetricKeyHolder(m10064b(context.getApplicationContext(), str));
    }

    public void saveSymmetricKey(Context context, String str, String str2) throws BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeyException, IOException {
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str)) {
            return;
        }
        byte[] bArrDecode = Base64.decode(str2, 0);
        Cipher cipher = Cipher.getInstance("RSA/NONE/PKCS1Padding");
        cipher.init(2, ((KeyStore.PrivateKeyEntry) this.f9687f).getPrivateKey());
        byte[] bArrDoFinal = cipher.doFinal(bArrDecode);
        byte[] bArrCopyOfRange = Arrays.copyOfRange(bArrDoFinal, bArrDoFinal.length - 32, bArrDoFinal.length);
        C0977a.m10072a(f9682a, new String(bArrCopyOfRange));
        C0977a.m10072a(f9682a, Base64.encodeToString(bArrCopyOfRange, 0));
        m10060a(context, str, bArrCopyOfRange);
    }

    public void saveSymmetricKey(Context context, String str, String str2, String str3) throws BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeyException, IOException {
        m10060a(context, str, Base64.decode(m10063a(str2, str3), 0));
    }
}
