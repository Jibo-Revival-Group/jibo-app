package com.jibo.aws.integration.aws.services.binary.p002a;

import com.jibo.aws.integration.util.C0977a;
import com.yalantis.ucrop.util.FileUtils;
import java.io.File;
import java.util.HashMap;
import org.apache.http.protocol.HTTP;

/* JADX INFO: renamed from: com.jibo.aws.integration.aws.services.binary.a.a */
/* JADX INFO: loaded from: classes.dex */
public class C0842a {

    /* JADX INFO: renamed from: a */
    private static final String f9406a = C0977a.m10070a(C0842a.class);

    /* JADX INFO: renamed from: b */
    private static C0842a f9407b = null;

    /* JADX INFO: renamed from: c */
    private final HashMap<String, String> f9408c = new HashMap<>();

    private C0842a() {
        this.f9408c.put("3gp", "video/3gpp");
        this.f9408c.put("ai", "application/postscript");
        this.f9408c.put("aif", "audio/x-aiff");
        this.f9408c.put("aifc", "audio/x-aiff");
        this.f9408c.put("aiff", "audio/x-aiff");
        this.f9408c.put("asc", HTTP.PLAIN_TEXT_TYPE);
        this.f9408c.put("atom", "application/atom+xml");
        this.f9408c.put("au", "audio/basic");
        this.f9408c.put("avi", "video/x-msvideo");
        this.f9408c.put("bcpio", "application/x-bcpio");
        this.f9408c.put("bin", "application/octet-stream");
        this.f9408c.put("bmp", "image/bmp");
        this.f9408c.put("cdf", "application/x-netcdf");
        this.f9408c.put("cgm", "image/cgm");
        this.f9408c.put("class", "application/octet-stream");
        this.f9408c.put("cpio", "application/x-cpio");
        this.f9408c.put("cpt", "application/mac-compactpro");
        this.f9408c.put("csh", "application/x-csh");
        this.f9408c.put("css", "text/css");
        this.f9408c.put("dcr", "application/x-director");
        this.f9408c.put("dif", "video/x-dv");
        this.f9408c.put("dir", "application/x-director");
        this.f9408c.put("djv", "image/vnd.djvu");
        this.f9408c.put("djvu", "image/vnd.djvu");
        this.f9408c.put("dll", "application/octet-stream");
        this.f9408c.put("dmg", "application/octet-stream");
        this.f9408c.put("dms", "application/octet-stream");
        this.f9408c.put("doc", "application/msword");
        this.f9408c.put("dtd", "application/xml-dtd");
        this.f9408c.put("dv", "video/x-dv");
        this.f9408c.put("dvi", "application/x-dvi");
        this.f9408c.put("dxr", "application/x-director");
        this.f9408c.put("eps", "application/postscript");
        this.f9408c.put("etx", "text/x-setext");
        this.f9408c.put("exe", "application/octet-stream");
        this.f9408c.put("ez", "application/andrew-inset");
        this.f9408c.put("flv", "video/x-flv");
        this.f9408c.put("gif", "image/gif");
        this.f9408c.put("gram", "application/srgs");
        this.f9408c.put("grxml", "application/srgs+xml");
        this.f9408c.put("gtar", "application/x-gtar");
        this.f9408c.put("gz", "application/x-gzip");
        this.f9408c.put("hdf", "application/x-hdf");
        this.f9408c.put("hqx", "application/mac-binhex40");
        this.f9408c.put("htm", "text/html");
        this.f9408c.put("html", "text/html");
        this.f9408c.put("ice", "x-conference/x-cooltalk");
        this.f9408c.put("ico", "image/x-icon");
        this.f9408c.put("ics", "text/calendar");
        this.f9408c.put("ief", "image/ief");
        this.f9408c.put("ifb", "text/calendar");
        this.f9408c.put("iges", "model/iges");
        this.f9408c.put("igs", "model/iges");
        this.f9408c.put("jnlp", "application/x-java-jnlp-file");
        this.f9408c.put("jp2", "image/jp2");
        this.f9408c.put("jpe", "image/jpeg");
        this.f9408c.put("jpeg", "image/jpeg");
        this.f9408c.put("jpg", "image/jpeg");
        this.f9408c.put("js", "application/x-javascript");
        this.f9408c.put("kar", "audio/midi");
        this.f9408c.put("latex", "application/x-latex");
        this.f9408c.put("lha", "application/octet-stream");
        this.f9408c.put("lzh", "application/octet-stream");
        this.f9408c.put("m3u", "audio/x-mpegurl");
        this.f9408c.put("m4a", "audio/mp4a-latm");
        this.f9408c.put("m4p", "audio/mp4a-latm");
        this.f9408c.put("m4u", "video/vnd.mpegurl");
        this.f9408c.put("m4v", "video/x-m4v");
        this.f9408c.put("mac", "image/x-macpaint");
        this.f9408c.put("man", "application/x-troff-man");
        this.f9408c.put("mathml", "application/mathml+xml");
        this.f9408c.put("me", "application/x-troff-me");
        this.f9408c.put("mesh", "model/mesh");
        this.f9408c.put("mid", "audio/midi");
        this.f9408c.put("midi", "audio/midi");
        this.f9408c.put("mif", "application/vnd.mif");
        this.f9408c.put("mov", "video/quicktime");
        this.f9408c.put("movie", "video/x-sgi-movie");
        this.f9408c.put("mp2", "audio/mpeg");
        this.f9408c.put("mp3", "audio/mpeg");
        this.f9408c.put("mp4", "video/mp4");
        this.f9408c.put("mpe", "video/mpeg");
        this.f9408c.put("mpeg", "video/mpeg");
        this.f9408c.put("mpg", "video/mpeg");
        this.f9408c.put("mpga", "audio/mpeg");
        this.f9408c.put("ms", "application/x-troff-ms");
        this.f9408c.put("msh", "model/mesh");
        this.f9408c.put("mxu", "video/vnd.mpegurl");
        this.f9408c.put("nc", "application/x-netcdf");
        this.f9408c.put("oda", "application/oda");
        this.f9408c.put("ogg", "application/ogg");
        this.f9408c.put("ogv", "video/ogv");
        this.f9408c.put("pbm", "image/x-portable-bitmap");
        this.f9408c.put("pct", "image/pict");
        this.f9408c.put("pdb", "chemical/x-pdb");
        this.f9408c.put("pdf", "application/pdf");
        this.f9408c.put("pgm", "image/x-portable-graymap");
        this.f9408c.put("pgn", "application/x-chess-pgn");
        this.f9408c.put("pic", "image/pict");
        this.f9408c.put("pict", "image/pict");
        this.f9408c.put("png", "image/png");
        this.f9408c.put("pnm", "image/x-portable-anymap");
        this.f9408c.put("pnt", "image/x-macpaint");
        this.f9408c.put("pntg", "image/x-macpaint");
        this.f9408c.put("ppm", "image/x-portable-pixmap");
        this.f9408c.put("ppt", "application/vnd.ms-powerpoint");
        this.f9408c.put("ps", "application/postscript");
        this.f9408c.put("qt", "video/quicktime");
        this.f9408c.put("qti", "image/x-quicktime");
        this.f9408c.put("qtif", "image/x-quicktime");
        this.f9408c.put("ra", "audio/x-pn-realaudio");
        this.f9408c.put("ram", "audio/x-pn-realaudio");
        this.f9408c.put("ras", "image/x-cmu-raster");
        this.f9408c.put("rdf", "application/rdf+xml");
        this.f9408c.put("rgb", "image/x-rgb");
        this.f9408c.put("rm", "application/vnd.rn-realmedia");
        this.f9408c.put("roff", "application/x-troff");
        this.f9408c.put("rtf", "text/rtf");
        this.f9408c.put("rtx", "text/richtext");
        this.f9408c.put("sgm", "text/sgml");
        this.f9408c.put("sgml", "text/sgml");
        this.f9408c.put("sh", "application/x-sh");
        this.f9408c.put("shar", "application/x-shar");
        this.f9408c.put("silo", "model/mesh");
        this.f9408c.put("sit", "application/x-stuffit");
        this.f9408c.put("skd", "application/x-koan");
        this.f9408c.put("skm", "application/x-koan");
        this.f9408c.put("skp", "application/x-koan");
        this.f9408c.put("skt", "application/x-koan");
        this.f9408c.put("smi", "application/smil");
        this.f9408c.put("smil", "application/smil");
        this.f9408c.put("snd", "audio/basic");
        this.f9408c.put("so", "application/octet-stream");
        this.f9408c.put("spl", "application/x-futuresplash");
        this.f9408c.put("src", "application/x-wais-source");
        this.f9408c.put("sv4cpio", "application/x-sv4cpio");
        this.f9408c.put("sv4crc", "application/x-sv4crc");
        this.f9408c.put("svg", "image/svg+xml");
        this.f9408c.put("swf", "application/x-shockwave-flash");
        this.f9408c.put("t", "application/x-troff");
        this.f9408c.put("tar", "application/x-tar");
        this.f9408c.put("tcl", "application/x-tcl");
        this.f9408c.put("tex", "application/x-tex");
        this.f9408c.put("texi", "application/x-texinfo");
        this.f9408c.put("texinfo", "application/x-texinfo");
        this.f9408c.put("tif", "image/tiff");
        this.f9408c.put("tiff", "image/tiff");
        this.f9408c.put("tr", "application/x-troff");
        this.f9408c.put("tsv", "text/tab-separated-values");
        this.f9408c.put("txt", HTTP.PLAIN_TEXT_TYPE);
        this.f9408c.put("ustar", "application/x-ustar");
        this.f9408c.put("vcd", "application/x-cdlink");
        this.f9408c.put("vrml", "model/vrml");
        this.f9408c.put("vxml", "application/voicexml+xml");
        this.f9408c.put("wav", "audio/x-wav");
        this.f9408c.put("wbmp", "image/vnd.wap.wbmp");
        this.f9408c.put("wbxml", "application/vnd.wap.wbxml");
        this.f9408c.put("webm", "video/webm");
        this.f9408c.put("wml", "text/vnd.wap.wml");
        this.f9408c.put("wmlc", "application/vnd.wap.wmlc");
        this.f9408c.put("wmls", "text/vnd.wap.wmlscript");
        this.f9408c.put("wmlsc", "application/vnd.wap.wmlscriptc");
        this.f9408c.put("wmv", "video/x-ms-wmv");
        this.f9408c.put("wrl", "model/vrml");
        this.f9408c.put("xbm", "image/x-xbitmap");
        this.f9408c.put("xht", "application/xhtml+xml");
        this.f9408c.put("xhtml", "application/xhtml+xml");
        this.f9408c.put("xls", "application/vnd.ms-excel");
        this.f9408c.put("xml", "application/xml");
        this.f9408c.put("xpm", "image/x-xpixmap");
        this.f9408c.put("xsl", "application/xml");
        this.f9408c.put("xslt", "application/xslt+xml");
        this.f9408c.put("xul", "application/vnd.mozilla.xul+xml");
        this.f9408c.put("xwd", "image/x-xwindowdump");
        this.f9408c.put("xyz", "chemical/x-xyz");
        this.f9408c.put("zip", "application/zip");
    }

    /* JADX INFO: renamed from: a */
    public static synchronized C0842a m9951a() {
        C0842a c0842a;
        if (f9407b != null) {
            c0842a = f9407b;
        } else {
            f9407b = new C0842a();
            c0842a = f9407b;
        }
        return c0842a;
    }

    /* JADX INFO: renamed from: a */
    public String m9952a(File file) {
        return m9953a(file.getName());
    }

    /* JADX INFO: renamed from: a */
    public String m9953a(String str) {
        int iLastIndexOf = str.lastIndexOf(FileUtils.HIDDEN_PREFIX);
        if (iLastIndexOf <= 0 || iLastIndexOf + 1 >= str.length()) {
            C0977a.m10072a(f9406a, "File name has no extension, mime type cannot be recognised for: " + str);
        } else {
            String lowerCase = str.substring(iLastIndexOf + 1).toLowerCase();
            if (this.f9408c.keySet().contains(lowerCase)) {
                String str2 = this.f9408c.get(lowerCase);
                C0977a.m10072a(f9406a, "Recognised extension '" + lowerCase + "', mimetype is: '" + str2 + "'");
                return str2;
            }
            C0977a.m10072a(f9406a, "Extension '" + lowerCase + "' is unrecognized in mime type listing, using default mime type: 'application/octet-stream'");
        }
        return "application/octet-stream";
    }
}
