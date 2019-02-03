package com.legoapi.utils;

import com.legoapi.entity.HttpLog;
import org.apache.http.Consts;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.*;

public class HttpClientTool {

    private static CloseableHttpClient httpClient = HttpClients.createDefault();

    public static HttpLog getClient(String url) {
        HttpLog httpLog;
        Integer code = 1;
        Long spendTime = 0L;
        String msg = null;
        HttpGet httpGet = new HttpGet(url);
        HttpResponse httpResponse = null;
        try {
            Date t1 = new Date();
            httpResponse = httpClient.execute(httpGet);
            Date t2 = new Date();
            spendTime = t2.getTime() - t1.getTime();
        } catch (IOException e) {
            code = 0;
            msg = e.toString();
            e.printStackTrace();
        }

        String content = "";
        try {
            content = EntityUtils.toString(httpResponse.getEntity());
        } catch (IOException e) {
            e.printStackTrace();
            content = "";
        }

        httpLog = new HttpLog(UUID.randomUUID().toString().replace("-", "").toLowerCase(),
                code, msg, spendTime, httpGet.getURI().toString(), null, httpGet.getAllHeaders(), 1, 0,
                code == 1 ? httpResponse.getStatusLine().getStatusCode() : null,
                code == 1 ? httpResponse.getAllHeaders() : null,
                code == 1 ? content : null, new Date());
        return httpLog;
    }

    /**
     * @param url  url请求地址
     * @param type 1：form-data，2：urlencoded 3:raw-json/xml
     * @param data 请求的数据
     * @return
     */
    public static HttpLog postClient(String url, Integer type, Object data) {
        HttpLog httpLog;
        Integer code = 1;
        Long spendTime = 0L;
        String msg = null;

        HttpPost httpPost = new HttpPost(url);
        if (type == 2) {
            List<NameValuePair> formparams = new ArrayList<NameValuePair>();
            List<Map> list = (List<Map>) data;
            for (Map<String, String> item : list) {
                for (String key : item.keySet()) {
                    formparams.add(new BasicNameValuePair(key, item.get(key)));
                }
            }
            UrlEncodedFormEntity entity = new UrlEncodedFormEntity(formparams, Consts.UTF_8);
            httpPost.setEntity(entity);
        }
        if (type == 1) {

        }
        HttpResponse httpResponse = null;
        try {
            Date t1 = new Date();
            httpResponse = httpClient.execute(httpPost);
            Date t2 = new Date();
            spendTime = t2.getTime() - t1.getTime();

        } catch (Exception e) {
            code = 0;
            msg = e.toString();
            e.printStackTrace();
        }
        String content = "";
        try {
            content = EntityUtils.toString(httpResponse.getEntity());
        } catch (Exception e) {
            e.printStackTrace();
            content = "";
        }
        httpLog = new HttpLog(UUID.randomUUID().toString().replace("-", "").toLowerCase(),
                code, msg, spendTime, httpPost.getURI().toString(),httpPost.getEntity(), httpPost.getAllHeaders(), 2, type,
                code == 1 ? httpResponse.getStatusLine().getStatusCode() : null,
                code == 1 ? httpResponse.getAllHeaders() : null,
                code == 1 ? content : null, new Date());
        return httpLog;
    }


//    private static void setHttpResult(HttpResult httpResult, HttpResponse httpResponse) {
//        httpResult.setStatusCode(httpResponse.getStatusLine().getStatusCode());
//        httpResult.setAllHeaders(httpResponse.getAllHeaders());
//        HttpEntity httpEntity = httpResponse.getEntity();
//        if (httpEntity != null) {
//            try {
//                httpResult.setResponse(EntityUtils.toString(httpEntity));
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }

}
