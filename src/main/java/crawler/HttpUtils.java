package crawler;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.http.HttpHost;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CookieStore;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.cookie.BasicClientCookie;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class HttpUtils {
    private static final Logger LOG = Logger.getLogger(HttpUtils.class);
    public static final String DEFAULT_USER_AGENT = "Mozilla/5.0 (Windows NT 6.3; WOW64; rv:32.0) Gecko/20100101 Firefox/33.0";

    public static void copyUnitCookies(JSONArray cookies, CookieStore cookieStore, boolean clear) {
        if (clear) {
            cookieStore.clear();
        }
        for (Object o : cookies) {
            JSONObject oo = (JSONObject) o;
            BasicClientCookie basicClientCookie = new BasicClientCookie(oo.getString("name"), oo.getString("value"));
            basicClientCookie.setDomain(oo.getString("domain"));
            basicClientCookie.setPath(oo.getString("path"));
            cookieStore.addCookie(basicClientCookie);
        }
    }

    public static HttpGet get(String url) {
        return get(url, null, null);
    }

    public static HttpGet get(String url, Map<String, Object> params, String userAgent) {
        url += buildParamString(params, "UTF-8");
        HttpGet result = new HttpGet(url);
        result.addHeader("User-Agent", userAgent == null ? DEFAULT_USER_AGENT : userAgent);
        return result;
    }

    public static String buildParamString(Map<String, ? extends Object> params, String encoding) {
        if (params == null || params.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        try {
            for (Entry<String, ? extends Object> entry : params.entrySet()) {
                Object value = entry.getValue();
                value = value == null ? "" : value.toString();
                sb.append("&").append(URLEncoder.encode(entry.getKey(), encoding)).append("=")
                        .append(URLEncoder.encode((String) value, encoding));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    public static HttpPost post(String url) {
        return post(url, null);
    }

    public static HttpPost post(String url, Map<String, Object> params) {
        return post(url, params, null);
    }

    public static HttpPost post(String url, Map<String, Object> params, HttpHost proxy) {
        return post(url, params, proxy, DEFAULT_USER_AGENT);
    }

    public static HttpPost post(String url, Map<String, Object> params, HttpHost proxy, String userAgent,
            String encoding) {
        HttpPost result = new HttpPost(url);
        result.addHeader("User-Agent", userAgent == null ? DEFAULT_USER_AGENT : userAgent);
        if (params != null && !params.isEmpty()) {
            result.setEntity(buildParams(params, encoding));
        }
        return result;
    }

    public static HttpPost post(String url, Map<String, Object> params, HttpHost proxy, String userAgent) {
        HttpPost result = new HttpPost(url);
        result.addHeader("User-Agent", userAgent == null ? DEFAULT_USER_AGENT : userAgent);
        if (params != null && !params.isEmpty()) {
            result.setEntity(buildParams(params));
        }
        return result;
    }

    public static UrlEncodedFormEntity buildParams(Map<String, ? extends Object> params) {
        return buildParams(params, "UTF-8");
    }

    @SuppressWarnings("rawtypes")
    public static UrlEncodedFormEntity buildParams(Map<String, ? extends Object> params, String encoding) {
        if (params == null || params.isEmpty()) {
            return null;
        }
        List<NameValuePair> parameters = new ArrayList<NameValuePair>();
        for (Entry<String, ? extends Object> entry : params.entrySet()) {
            Object value = entry.getValue();
            if (value != null) {
                if (value instanceof List) {
                    for (Object o : (List) value) {
                        if (o != null) {
                            parameters.add(new BasicNameValuePair(entry.getKey(), o.toString()));
                        }
                    }
                } else {
                    parameters.add(new BasicNameValuePair(entry.getKey(), value.toString()));
                }
            } else {
                parameters.add(new BasicNameValuePair(entry.getKey(), null));
            }
        }
        return new UrlEncodedFormEntity(parameters, Charset.forName(encoding));
    }

    public static void executeGet(CloseableHttpClient client, String url) throws ClientProtocolException, IOException {
        HttpGet get = HttpUtils.get(url);
        client.execute(get).close();
    }

    public static String executeGetWithResult(CloseableHttpClient client, String url)
            throws ClientProtocolException, IOException {
        HttpGet get = get(url);
        CloseableHttpResponse resp = client.execute(get);
        String result = EntityUtils.toString(resp.getEntity());
        resp.close();
        return result;
    }

    public static String executeGetWithResult(CloseableHttpClient client, HttpGet get)
            throws ClientProtocolException, IOException {
        CloseableHttpResponse resp = client.execute(get);
        String result = EntityUtils.toString(resp.getEntity());
        resp.close();
        return result;
    }

    public static String executeGetWithResult(CloseableHttpClient client, HttpGet get, String encoding)
            throws ClientProtocolException, IOException {
        CloseableHttpResponse resp = client.execute(get);
        String result = EntityUtils.toString(resp.getEntity(), encoding);
        resp.close();
        return result;
    }
}