package crawler;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.log4j.Logger;
import org.junit.Test;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class QzoneCrawler {
    private static Logger log = Logger.getLogger(QzoneCrawler.class);
    private CookieStore cookieStore = new BasicCookieStore();
    private CloseableHttpClient client = null;
    private String qzonetoken = null;
    private String p_skey = null;
    private int g_tk = 0;
    private int friendnum = 0;
    private List<String> friendlist = new ArrayList<>();

    @Test
    public void crawlerQQ() {
        try {
            FileReader fr = new FileReader(new File("C:\\Users\\chuan\\Desktop\\cookies.txt"));
            JSONArray arr = initCookies(fr);

            client = HttpClients.custom().setDefaultCookieStore(cookieStore).build();
            HttpUtils.copyUnitCookies(arr, cookieStore, true);
            String url = "https://user.qzone.qq.com/746060703";
            HttpGet get = HttpUtils.get(url);
            String result = HttpUtils.executeGetWithResult(client, get, "UTF-8");
            log.info(result);
            if (result.contains("<a class=\"app-name\">日志</a>")) {
                log.info("登陆成功！");

                String reg = "window.g_qzonetoken = \\(function\\(\\)\\{ try\\{return (.*?);\\}";
                Pattern pattern = Pattern.compile(reg);
                Matcher m = pattern.matcher(result);
                if (m.find()) {
                    qzonetoken = m.group(1);
                    qzonetoken = qzonetoken.replace("\"", "");
                    log.info("token=" + qzonetoken);

                }
                crawlerFriends();
            }

        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }

    public void crawlerFriends() throws ClientProtocolException, IOException {
        g_tk = getG_tk(p_skey);

        String url = "https://h5.qzone.qq.com/proxy/domain/base.qzone.qq.com/cgi-bin/right/get_entryright.cgi?uin=746060703&rd="
                + System.currentTimeMillis() + "&ver=1&fupdate=1&g_tk=" + g_tk + "&qzonetoken=" + qzonetoken;
        HttpGet get = HttpUtils.get(url);
        String result = HttpUtils.executeGetWithResult(client, get, "UTF-8");
        log.info("===========");
        log.info(result);
        log.info("===========");
        if (result.contains("_Callback(")) {
            log.info("好友获取成功");
            result = result.replaceFirst("_Callback\\(", "");
            result = result.substring(0, result.lastIndexOf(");"));
            result = result.replace("0x20101", "\"\"");
            log.info(result);
            getFriendList(result);
            int index = 1;
            while (friendnum > 50 && (index * 50 < friendnum)) {
                int offset = index * 50;
                url = "https://h5.qzone.qq.com/proxy/domain/base.qzone.qq.com/cgi-bin/right/get_entryuinlist.cgi?uin=746060703&fupdate=1&action=1&offset="
                        + offset + "&rd=" + System.currentTimeMillis() + "&ver=1&fupdate=1&g_tk=" + g_tk
                        + "&qzonetoken=" + qzonetoken;
                get = HttpUtils.get(url);
                result = HttpUtils.executeGetWithResult(client, get, "UTF-8");
                result = result.replaceFirst("_Callback\\(", "");
                result = result.substring(0, result.lastIndexOf(");"));
                getFriendList(result);
                index++;
            }
        }
        log.info(friendlist.size());
        if (!friendlist.isEmpty()) {
            for (String s : friendlist) {
                getShuoshuo(s);
            }
        }
    }

    public void getFriendList(String json) {
        JSONObject obj = JSONObject.parseObject(json);
        JSONObject data = obj.getJSONObject("data");
        JSONArray arr = null;
        if (data.containsKey("items")) {
            friendnum = data.getJSONArray("items").getJSONObject(0).getIntValue("friendnum");
            log.info("friendnum=" + friendnum);
            arr = data.getJSONArray("items").getJSONObject(0).getJSONArray("friendlist");
        } else {
            arr = data.getJSONArray("uinlist");
        }

        for (int i = 0; i < arr.size(); i++) {
            JSONObject o = arr.getJSONObject(i);
            String friendqq = o.getString("data");
            log.info("friendqq=" + friendqq);
            friendlist.add(friendqq);
        }

    }

    public void getShuoshuo(String qqnum) {
        String url = "https://user.qzone.qq.com/" + qqnum;

    }

    public int getG_tk(String p_skey) {
        int h = 5381;

        for (int i = 0; i < p_skey.length(); i++) {
            char c = p_skey.charAt(i);
            h += (h << 5) + c;
        }
        return h & 2147483647;
    }

    public JSONArray initCookies(FileReader fr) throws Exception {
        JSONArray list = new JSONArray();
        BufferedReader br = new BufferedReader(fr);
        String line = "";
        String[] arrs = null;
        while ((line = br.readLine()) != null) {
            Map<String, String> map = new HashMap<>();
            String domain = "";
            String expires = "";
            String path = "";
            String cookiesKey = "";
            if (line.endsWith("HttpOnly")) {
                line = line.substring(0, line.lastIndexOf(";"));
            }
            arrs = line.split(";");
            for (int i = 0; i < arrs.length; i++) {
                if (arrs[i].contains("domain") && !arrs[i].contains("qm_domain")) {
                    domain = arrs[i].replace("domain=", "").trim();
                } else if (arrs[i].contains("expires")) {
                    expires = arrs[i];
                } else if (arrs[i].contains("path")) {
                    path = arrs[i].replace("path=", "").trim();
                } else {
                    cookiesKey = arrs[i];
                }
            }
            log.info(cookiesKey);
            if (StringUtils.isNotBlank(cookiesKey)) {

                String name = cookiesKey.substring(0, cookiesKey.indexOf("="));
                String value = cookiesKey.substring(cookiesKey.indexOf("=") + 1, cookiesKey.length());
                JSONObject o = new JSONObject();
                o.put("name", name);
                o.put("value", value);
                o.put("path", "/");
                o.put("domain", ".qzone.qq.com");
                if (name.equals("p_skey")) {
                    p_skey = value;
                }
                list.add(o);
            }
        }
        br.close();
        fr.close();

        return list;
    }

    public void writeHtml(String path, String html) {
        try {
            FileUtils.write(new File(path), html, "UTF-8", true);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }
}
