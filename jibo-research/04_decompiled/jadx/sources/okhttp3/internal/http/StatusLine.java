package okhttp3.internal.http;

import java.io.IOException;
import java.net.ProtocolException;
import okhttp3.Protocol;
import org.apache.http.message.TokenParser;

/* JADX INFO: loaded from: classes2.dex */
public final class StatusLine {

    /* JADX INFO: renamed from: a */
    public final Protocol f15383a;

    /* JADX INFO: renamed from: b */
    public final int f15384b;

    /* JADX INFO: renamed from: c */
    public final String f15385c;

    public StatusLine(Protocol protocol, int i, String str) {
        this.f15383a = protocol;
        this.f15384b = i;
        this.f15385c = str;
    }

    /* JADX INFO: renamed from: a */
    public static StatusLine m16002a(String str) throws IOException {
        Protocol protocol;
        String strSubstring;
        int i = 9;
        if (str.startsWith("HTTP/1.")) {
            if (str.length() < 9 || str.charAt(8) != ' ') {
                throw new ProtocolException("Unexpected status line: " + str);
            }
            int iCharAt = str.charAt(7) - '0';
            if (iCharAt == 0) {
                protocol = Protocol.HTTP_1_0;
            } else if (iCharAt == 1) {
                protocol = Protocol.HTTP_1_1;
            } else {
                throw new ProtocolException("Unexpected status line: " + str);
            }
        } else if (str.startsWith("ICY ")) {
            protocol = Protocol.HTTP_1_0;
            i = 4;
        } else {
            throw new ProtocolException("Unexpected status line: " + str);
        }
        if (str.length() < i + 3) {
            throw new ProtocolException("Unexpected status line: " + str);
        }
        try {
            int i2 = Integer.parseInt(str.substring(i, i + 3));
            if (str.length() <= i + 3) {
                strSubstring = "";
            } else {
                if (str.charAt(i + 3) != ' ') {
                    throw new ProtocolException("Unexpected status line: " + str);
                }
                strSubstring = str.substring(i + 4);
            }
            return new StatusLine(protocol, i2, strSubstring);
        } catch (NumberFormatException e) {
            throw new ProtocolException("Unexpected status line: " + str);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f15383a == Protocol.HTTP_1_0 ? "HTTP/1.0" : "HTTP/1.1");
        sb.append(TokenParser.f15715SP).append(this.f15384b);
        if (this.f15385c != null) {
            sb.append(TokenParser.f15715SP).append(this.f15385c);
        }
        return sb.toString();
    }
}
