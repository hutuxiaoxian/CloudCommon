package com.zhishouwei.common.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zhishouwei.common.exception.ServiceException;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;

/**
 * @author sunsl
 * @version 1.0
 * @date 2020/7/14 18:12
 */
@Slf4j
public class HttpUtil {

    private static final int DEFALT_TIME = 30000;

    private static final RequestConfig REQUEST_CONFIG_DEFAULT = RequestConfig.custom()
            .setSocketTimeout(DEFALT_TIME)
            .setConnectTimeout(DEFALT_TIME)
            .setConnectionRequestTimeout(DEFALT_TIME)
            .build();

    /**
     * post
     *
     * @param urls 地址
     * @param para 参数
     * @return String
     * @throws ServiceException 异常
     */
    public static String doPost(String urls, String para) throws ServiceException {
        try {
            URL url = new URL(urls);
            HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setRequestMethod("POST");
            connection.setUseCaches(false);
            connection.setInstanceFollowRedirects(true);
            connection.setRequestProperty("Content-Type", "application/json");
            connection.connect();
            // POST请求
            DataOutputStream out = new DataOutputStream(connection.getOutputStream());
            out.writeBytes(para);
            out.flush();
            out.close();
            // 读取响应
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String lines;
            StringBuffer sb = new StringBuffer("");
            while ((lines = reader.readLine()) != null) {
                sb.append(lines);
            }
            reader.close();
            // 断开连接
            connection.disconnect();
            return sb.toString();
        } catch (Exception e) {
            throw new ServiceException("Http请求出错！" + e.getMessage());
        }
    }

    /**
     * 通用api请求，返回结果为json
     *
     * @param url    地址
     * @param params 参数
     * @return JSONObject 数据
     * @throws ServiceException 异常
     */
    public static JSONObject doGet4Json(String url, Map<String, String> params)
            throws ServiceException {
        try {
            String result = doGet(url, params);
            return JSON.parseObject(result);
        } catch (Exception e) {
            throw new ServiceException(e.getMessage());
        }
    }

    /**
     * get 拼接
     *
     * @param url    url
     * @param params 参数
     * @return String
     * @throws ServiceException 异常
     */
    public static String doGet(String url, Map<String, String> params) throws ServiceException {
        return httpClientGet(url + "?" + buildParams(params));
    }

    /**
     * 最终请求
     *
     * @param url 地址
     * @return String
     * @throws ServiceException 异常
     */
    public static String httpClientGet(String url) throws ServiceException {
        CloseableHttpClient client = getHttpClient();
        HttpGet httpGet = new HttpGet(url);
        try {
            CloseableHttpResponse response = client.execute(httpGet);
            HttpEntity entity = response.getEntity();
            return EntityUtils.toString(entity, "UTF-8");
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new ServiceException("请求超时");
        } finally {
            try {
                client.close();
            } catch (IOException e) {
                log.error(e.getMessage());
            }
        }
    }

    /**
     * 获取 CloseableHttpClient
     *
     * @return CloseableHttpClient
     */
    private static CloseableHttpClient getHttpClient() {
        return HttpClients.custom().setDefaultRequestConfig(REQUEST_CONFIG_DEFAULT).build();
    }

    /**
     * 拼装请求参数的字符串
     *
     * @param params 参数
     * @return 拼接参数
     */
    private static String buildParams(Map<String, String> params) {
        StringBuilder builder = new StringBuilder();
        if (params != null && !params.isEmpty()) {
            int i = 0;
            for (Map.Entry<String, String> entry : params.entrySet()) {
                try {
                    String value = entry.getValue();
                    if (value != null) {
                        builder.append(entry.getKey()).append("=").append(URLEncoder.encode(value,
                                "UTF-8"));
                    } else {
                        builder.append(entry.getKey()).append("=");
                    }
                } catch (UnsupportedEncodingException e) {
                    return "";
                }
                if (i++ != params.size() - 1) {
                    builder.append("&");
                }
            }
        }
        return builder.toString();
    }
}
