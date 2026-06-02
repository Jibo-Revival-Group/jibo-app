package okhttp3;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface Dns {

    /* JADX INFO: renamed from: a */
    public static final Dns f15062a = new Dns() { // from class: okhttp3.Dns.1
        @Override // okhttp3.Dns
        /* JADX INFO: renamed from: a */
        public List<InetAddress> mo15602a(String str) throws UnknownHostException {
            if (str == null) {
                throw new UnknownHostException("hostname == null");
            }
            return Arrays.asList(InetAddress.getAllByName(str));
        }
    };

    /* JADX INFO: renamed from: a */
    List<InetAddress> mo15602a(String str) throws UnknownHostException;
}
