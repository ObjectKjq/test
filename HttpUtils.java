package com.highershine.gdna2.utils;

import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.protocol.HttpContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


public class HttpUtils {

	public static final Logger log = LoggerFactory.getLogger(HttpUtils.class);

	 /**
     * 向指定 URL 发送POST方法的请求
     *
     * @param url
     *            发送请求的 URL
     * @param param
     *            请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
     * @return 所代表远程资源的响应结果
     */
    public static String sendPost(String url, String param)throws Exception {

    	log.info("http连接开始：{}",DateTools.getNowTimeStr());
    	log.info("http url是：{}",url);
        log.info("http 参数是：{}", param);

        PrintWriter out = null;
        BufferedReader in = null;
        String result = "";
        try {
            URL realUrl = new URL(url);
            //打开和URL之间的连接
            URLConnection conn = realUrl.openConnection();
            conn.setConnectTimeout(60000);
            // 设置通用的请求属性
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 发送POST请求必须设置如下两行
            conn.setDoOutput(true);
            conn.setDoInput(true);
            // 获取URLConnection对象对应的输出流
            //out = new PrintWriter(conn.getOutputStream());
            out = new PrintWriter(new OutputStreamWriter(conn.getOutputStream(),"UTF-8"));
            // 发送请求参数
            //out.write(param);
            out.print(param);
            // flush输出流的缓冲
            out.flush();
            // 定义BufferedReader输入流来读取URL的响应
            in = new BufferedReader(
                    new InputStreamReader(conn.getInputStream(),"UTF-8"));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
            log.info("http连接结束：{}",DateTools.getNowTimeStr());
        } catch (Exception e) {

        	log.info("http连接失败：{}",DateTools.getNowTimeStr());

			log.error("sendPost",e);
        	log.error("发送 POST 请求出现异常！");
        	throw new Exception("发送 POST 请求出现异常！");
        }
        //使用finally块来关闭输出流、输入流
        finally{
            try{
                if(out!=null){
                    out.close();
                }
                if(in!=null){
                    in.close();
                }
            }
            catch(IOException ex){
    			log.error("sendPost",ex);
            }
        }
        return result;
    }

    public static String doPostFormData(String url, Map<String, Object> params) {
        log.info("请求地址{}",url);
        log.info("请求参数{}",params);
        BufferedReader in = null;
        InputStreamReader reader = null;
        //设置超时时间
        RequestConfig defaultRequestConfig = RequestConfig.custom()
                .setConnectTimeout(8000)
                .build();
        CloseableHttpClient client = HttpClientBuilder.create().setDefaultRequestConfig(defaultRequestConfig).setRetryHandler(new MyHttpRequestRetryHandler(3)).build();
        try {
            HttpPost request = new HttpPost();
            request.setURI(new URI(url));
            List<NameValuePair> nvps = new ArrayList<>();
            params.forEach((key, value) -> nvps.add(new BasicNameValuePair(key, String.valueOf(value))));
            request.setEntity(new UrlEncodedFormEntity(nvps, StandardCharsets.UTF_8));
            HttpResponse response = client.execute(request);
            response.getStatusLine().getStatusCode();
            reader = new InputStreamReader(response.getEntity().getContent(), StandardCharsets.UTF_8);
            in = new BufferedReader(reader);
            StringBuilder sb = new StringBuilder();
            String line = "";
            String nl = System.getProperty("line.separator");
            while ((line = in.readLine()) != null) {
                sb.append(line).append(nl);
            }
            in.close();
            return sb.toString();
        } catch (Exception var11) {
            var11.printStackTrace();
            log.error("调用接口出错:",var11);
            return null;
        } finally {
            try {
                if (client != null) {
                    client.close();
                }
                if (reader != null) {
                    reader.close();
                }
                if (in != null) {
                    in.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
                log.error("io操作异常:",e);
            }
        }
    }

    static class MyHttpRequestRetryHandler implements HttpRequestRetryHandler {
        private final int maxRetries;

        public MyHttpRequestRetryHandler(int maxRetries) {
            this.maxRetries = maxRetries;
        }

        @Override
        public boolean retryRequest(IOException exception, int executionCount, HttpContext context) {

            if (executionCount > maxRetries) {
                // 不再重试
                return false;
            }
            if (exception instanceof InterruptedIOException) {
                // 可能是超时或中断，可以重试
                return true;
            }
            if (exception instanceof UnknownHostException) {
                // 无法解析主机名，可以重试
                return true;
            }
            if (exception instanceof ConnectTimeoutException) {
                // 连接超时，可以重试
                return true;
            }

            if (exception instanceof SocketException) {
                // 连接重置
                return true;
            }
            return false;
        }
    }

    /**
     * httpClient 发送post请求
     * @param url
     * @param params
     * @return
     */
    @SuppressWarnings({ "deprecation", "rawtypes", "unchecked" })
	public static String doPost(String url, Map params) throws Exception{
        BufferedReader in = null;
        HttpClient client = new DefaultHttpClient();
        try {
            HttpPost request = new HttpPost();
            request.setURI(new URI(url));
            List<NameValuePair> nvps = new ArrayList();
            Iterator iter = params.keySet().iterator();

            while(iter.hasNext()) {
                String name = (String)iter.next();
                String value = String.valueOf(params.get(name));
                nvps.add(new BasicNameValuePair(name, value));
            }

            request.setEntity(new UrlEncodedFormEntity(nvps, "UTF-8"));
            HttpResponse response = client.execute(request);
            int code = response.getStatusLine().getStatusCode();
            if (code != 200) {
            	log.error("【POST请求】请求异常，request_url:{}, HTTPStatus：{}", url, code);
                return null;
            } else {
                in = new BufferedReader(new InputStreamReader(response.getEntity().getContent(), "utf-8"));
                StringBuffer sb = new StringBuffer("");
                String line = "";
                String NL = System.getProperty("line.separator");

                while((line = in.readLine()) != null) {
                    sb.append(line + NL);
                }

                in.close();
                return sb.toString();
            }
        } catch (Exception var11) {
            throw var11;
        } finally {
            if (client != null) {
                ((DefaultHttpClient) client).close();
            }
        }
    }

    /**
     * httpClient 发送get请求
     * @param url
     * @return
     */
    @SuppressWarnings("all")
	public static String doGet(String url ,Map<String,String> headers) throws Exception{
        BufferedReader in = null;
        HttpClient client = new DefaultHttpClient();
        try {
            HttpGet request = new HttpGet(url);

            //设置header  
            if (headers != null && headers.size() > 0) {
                for (Map.Entry<String, String> entry : headers.entrySet()) {
                	request.setHeader(entry.getKey(),entry.getValue());
                }
            }

            HttpResponse response = client.execute(request);
            int code = response.getStatusLine().getStatusCode();
            if (code != 200) {
            	log.error("【POST请求】请求异常，request_url:{}, HTTPStatus：{}", url, code);
                return null;
            } else {
                in = new BufferedReader(new InputStreamReader(response.getEntity().getContent(), "utf-8"));
                StringBuffer sb = new StringBuffer("");
                String line = "";
                String NL = System.getProperty("line.separator");

                while((line = in.readLine()) != null) {
                    sb.append(line + NL);
                }

                in.close();
                return sb.toString();
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if (client != null) {
                ((DefaultHttpClient) client).close();
            }
        }
    }

    /**
     * httpClient 发送put请求
     * @param url
     * @return
     */
    @SuppressWarnings("all")
	public static String doPut(String url) throws Exception{
        BufferedReader in = null;
        HttpClient client = new DefaultHttpClient();
        try {

            HttpPut request = new HttpPut(url);

            HttpResponse response = client.execute(request);
            int code = response.getStatusLine().getStatusCode();
            if (code != 200) {
            	log.error("【POST请求】请求异常，request_url:{}, HTTPStatus：{}", url, code);
                return null;
            } else {
                in = new BufferedReader(new InputStreamReader(response.getEntity().getContent(), "utf-8"));
                StringBuffer sb = new StringBuffer("");
                String line = "";
                String NL = System.getProperty("line.separator");

                while((line = in.readLine()) != null) {
                    sb.append(line + NL);
                }

                in.close();
                return sb.toString();
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if (client != null) {
                ((DefaultHttpClient) client).close();
            }
        }
    }


    /**
     * httpClient 发送post请求 验签
     *
     * @param url
     * @param params
     * @return
     */
    public static String doPost(String url, String signCode, Map params) {
        BufferedReader in = null;
        InputStreamReader reader = null;
        try {
            HttpClient  httpClient = HttpClientBuilder.create().build();
            HttpPost request = new HttpPost(url);
            List<NameValuePair> nvps = new ArrayList();
            Iterator iter = params.keySet().iterator();
            while (iter.hasNext()) {
                String name = (String) iter.next();
                String value = String.valueOf(params.get(name));
                nvps.add(new BasicNameValuePair(name, value));
            }
            request.setEntity(new UrlEncodedFormEntity(nvps, "UTF-8"));
            if (StringUtils.isNotBlank(signCode)) {
                request.setHeader("signCode", signCode);
            }
            HttpResponse response = httpClient.execute(request);
            int code = response.getStatusLine().getStatusCode();
            if (code != 200) {
                log.error("【POST请求】请求异常，request_url:{}, HTTPStatus：{}", url, code);
                return null;
            } else {
                reader = new InputStreamReader(response.getEntity().getContent(), "UTF-8");
                in = new BufferedReader(reader);
                StringBuffer sb = new StringBuffer();
                String line = "";
                String nl = System.getProperty("line.separator");
                while ((line = in.readLine()) != null) {
                    sb.append(line).append(nl);
                }
                return sb.toString();
            }
        } catch (Exception var11) {
            var11.printStackTrace();
            return null;
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
                if (in != null) {
                    in.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }



    /**
     * 发送post请求
     * @param url  路径
     * @param jsonParam  参数(json类型)
     * @param encoding 编码格式
     * @return
     * @throws IOException
     */
    public static String sendPostHaveCookie(String url, String jsonParam, String encoding, String cookie) throws Exception{
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost post = new HttpPost(url);
        post.setHeader("Content-Type", "application/json");
        post.addHeader("Cookie", cookie);
        String result;
        try {
            StringEntity s = new StringEntity(jsonParam, "utf-8");
            s.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE,
                    "application/json"));
            post.setEntity(s);
            // 发送请求
            HttpResponse httpResponse = client.execute(post);
            // 获取响应输入流
            InputStream inStream = httpResponse.getEntity().getContent();
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    inStream, "utf-8"));
            StringBuilder strber = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null)
                strber.append(line + "\n");
            inStream.close();
            result = strber.toString();
            if (httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                System.out.println("请求服务器成功，做相应处理");
            } else {
                System.out.println("请求服务端失败");
            }
        } catch (Exception e) {
            log.error("请求异常：", e);
            throw new RuntimeException(e);
        }
        return result;
    }

    /**
     * 发送post请求
     * @param url  路径
     * @param jsonParam  参数(json类型)
     * @return
     * @throws IOException
     */
    public static String sendPostHaveToken(String url, String jsonParam, String token) throws Exception{
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost post = new HttpPost(url);
        post.setHeader("Content-Type", "application/json;charset=UTF-8");
        post.addHeader("token", token);
        String result;
        try {
            StringEntity s = new StringEntity(jsonParam, "utf-8");
            s.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE,
                    "application/json"));
            post.setEntity(s);
            // 发送请求
            HttpResponse httpResponse = client.execute(post);
            // 获取响应输入流
            InputStream inStream = httpResponse.getEntity().getContent();
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    inStream, "utf-8"));
            StringBuilder strber = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                strber.append(line + "\n");
            }
            inStream.close();
            result = strber.toString();
            if (httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                System.out.println("请求服务器成功，做相应处理");
            } else {
                log.error("请求服务端失败");
                throw new RuntimeException("请求服务端失败");
            }
        } catch (Exception e) {
            log.error("请求异常：", e);
            throw new RuntimeException(e);
        }
        return result;
    }

    public static String sendPostHaveAuthorization(String url, String jsonParam, String authorizationCode) throws Exception{
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost post = new HttpPost(url);
        post.setHeader("Content-Type", "application/json;charset=UTF-8");
        if (StringUtils.isNotBlank(authorizationCode)) {
            post.addHeader("Authorization", authorizationCode);
        }
        String result;
        try {
            StringEntity s = new StringEntity(jsonParam, "utf-8");
            s.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE,
                    "application/json"));
            post.setEntity(s);
            // 发送请求
            HttpResponse httpResponse = client.execute(post);
            // 获取响应输入流
            InputStream inStream = httpResponse.getEntity().getContent();
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    inStream, "utf-8"));
            StringBuilder strber = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                strber.append(line + "\n");
            }
            inStream.close();
            result = strber.toString();
            if (httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                System.out.println("请求服务器成功，做相应处理");
            } else {
                System.out.println("请求服务端失败");
                log.error("请求服务端失败，响应信息：" + result);
                throw new RuntimeException("请求服务端失败，响应信息：" + result);
            }
        } catch (Exception e) {
            log.error("请求异常：", e);
            throw new RuntimeException(e);
        }
        return result;
    }
}