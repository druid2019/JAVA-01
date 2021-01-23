package com.example.memo.homework.second20210118;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URLDecoder;
import java.util.List;

/**
 * @author Mr JinJun
 * @version 1.0
 * @date 2021/1/23 23:51
 * @Description ${description}
 */
public class HttpUtils {
    /**
     * 发送post请求--用于接口接收的参数为JSON字符串
     * @param url 请求地址
     * @param params json格式的字符串
     * @return
     */
    public static String httpPost(String url, String params){
        String result = null;
        try {
            HttpClient httpClient = new DefaultHttpClient();
            HttpPost httpPost = new HttpPost(url);
            /*
             * 发送json字符串，这两句需要设置
             */
            httpPost.addHeader("Content-type","application/json; charset=utf-8");
            httpPost.setHeader("Accept", "application/json");

            httpPost.setEntity(new StringEntity(params, "UTF-8"));

            HttpResponse response = httpClient.execute(httpPost);

            int statusCode = response.getStatusLine().getStatusCode();

            if (statusCode == HttpStatus.SC_OK) {
                // Read the response body
                result = EntityUtils.toString(response.getEntity(),"UTF-8");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 发送post请求--用于接口接收的参数为键值对
     * @param url 请求地址
     * @param nameValuePairs 键值对
     * @return
     */
    public static String httpPost(String url, List<NameValuePair> nameValuePairs) {
        HttpClient httpClient = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost(url);
        String strResult = "";

        try {
            httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs, "UTF-8"));
            HttpResponse response = httpClient.execute(httpPost);

            if (response.getStatusLine().getStatusCode() == 200) {
                /* 读返回数据 */
                strResult = EntityUtils.toString(response.getEntity());
                // System.out.println("conResult:"+conResult);
            } else {
                strResult += "发送失败:" + response.getStatusLine().getStatusCode();
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return strResult;
    }

    /**
     * 发送get请求--用于接口接收的参数为键值对
     * @param url 请求地址
     * @param nameValuePairs 键值对
     * @return
     */
    public static String httpGet(String url, List<NameValuePair> nameValuePairs){
        HttpClient httpClient = new DefaultHttpClient();
        String sb = "";
        String result = "";
        try {
            for(NameValuePair nvp:nameValuePairs){
                sb += nvp.getName()+"="+nvp.getValue()+"&";
            }
            sb = sb.substring(0,sb.length()-1);
            sb = URLDecoder.decode(sb, "UTF-8");
            HttpGet httpGet = new HttpGet(url+"?"+sb);

            HttpResponse response = httpClient.execute(httpGet);
            if (response.getStatusLine().getStatusCode() == 200) {
                /* 读返回数据 */
                result = EntityUtils.toString(response.getEntity());
            } else {
                result += "发送失败:" + response.getStatusLine().getStatusCode();
            }

        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 发送post请求--用于接口接收的参数为键值对
     * @param url 请求地址
     * @param 无参
     * @return
     */
    public static String httpGet(String url){
        HttpClient httpClient = new DefaultHttpClient();
        String result = "";
        try {
            HttpGet httpGet = new HttpGet(url);
            HttpResponse response = httpClient.execute(httpGet);
            if (response.getStatusLine().getStatusCode() == 200) {
                /* 读返回数据 */
                result = EntityUtils.toString(response.getEntity());
            } else {
                result += "发送失败:" + response.getStatusLine().getStatusCode();
            }

        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }



    public static void main(String[] args) {
        String url = "http://localhost:8801";
        httpGet(url);
    }
}
