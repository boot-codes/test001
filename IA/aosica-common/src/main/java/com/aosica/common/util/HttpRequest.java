package com.aosica.common.util;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;
/**
 * @program: ai-planting->HttpRequest
 * @description: http请求
 * @author: dwj
 * @create: 2019-08-24 10:00
 **/
public class HttpRequest {

    private final static String ENCODING = "UTF-8";
    private final static String GZIPCODING = "gzip";

    /**
     * 向指定 URL 发送GET方法的请求
     *
     * @param url
     *            发送请求的 URL
     * @param param
     *            请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
     * @return 所代表远程资源的响应结果
     */
    public static String sendGet(String url, String param) {
        String result = "";
        BufferedReader in = null;
        HttpURLConnection conn = null;
        try {
            String urlNameString = url + "?" + param;
            URL realUrl = new URL(urlNameString);
            // 打开和URL之间的连接
            URLConnection connection = realUrl.openConnection();
            // 设置通用的请求属性
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            connection.setRequestProperty("Charset", "utf-8");

            // 建立实际的连接
            connection.connect();
            // 获取所有响应头字段
            Map<String, List<String>> map = connection.getHeaderFields();
            // 遍历所有的响应头字段
            for (String key : map.keySet()) {
                System.out.println(key + "--->" + map.get(key));
            }
            conn = (HttpURLConnection) connection;
            String encode = conn.getContentEncoding();
            System.out.println("encode is >"+encode);
            result = readStream(connection.getInputStream(), encode);
            conn.disconnect();
        } catch (Exception e) {
            System.out.println("发送GET请求出现异常！" + e);
            e.printStackTrace();
        }
        // 使用finally块来关闭输入流
        finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return result;
    }

    /**
     * 向指定 URL 发送POST方法的请求
     *
     * @param url
     *            发送请求的 URL
     * @param param
     *            请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
     * @return 所代表远程资源的响应结果
     */
    public static String sendPost(String url, String param) {
        PrintWriter out = null;
        BufferedReader in = null;
        String result = "";
        try {
            URL realUrl = new URL(url);
            // 打开和URL之间的连接
            URLConnection conn = realUrl.openConnection();
            // 设置通用的请求属性
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 发送POST请求必须设置如下两行
            conn.setDoOutput(true);
            conn.setDoInput(true);
            // 获取URLConnection对象对应的输出流
            out = new PrintWriter(conn.getOutputStream());
            // 发送请求参数
            out.print(param);
            // flush输出流的缓冲
            out.flush();
            // 定义BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("发送 POST 请求出现异常！" + e);
            e.printStackTrace();
        }
        // 使用finally块来关闭输出流、输入流
        finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return result;
    }

    /**
     * 读取将InputStream中的字节读以字符的形式取到字符串中，如果encoding是gzip，那么需要先有GZIPInputStream进行封装
     *
     * @param inputStream
     *            InputStream字节流
     * @param encoding
     *            编码格式
     * @return String类型的形式
     * @throws IOException
     *             IO异常
     */
    private static String readStream(InputStream inputStream, String encoding) throws Exception {
        StringBuffer buffer = new StringBuffer();

        InputStreamReader inputStreamReader = null;
        GZIPInputStream gZIPInputStream = null;
        if (GZIPCODING.equals(encoding)) {
            gZIPInputStream = new GZIPInputStream(inputStream);
            inputStreamReader = new InputStreamReader(gZIPInputStream, ENCODING);

        } else {

            inputStreamReader = new InputStreamReader(inputStream, ENCODING);
        }

        char[] c = new char[1024];

        int lenI;
        while ((lenI = inputStreamReader.read(c)) != -1) {

            buffer.append(new String(c, 0, lenI));

        }
        if (inputStream != null) {
            inputStream.close();
        }
        if (gZIPInputStream != null) {
            gZIPInputStream.close();
        }
        if (inputStreamReader != null) {
            inputStreamReader.close();
        }
        return buffer.toString();

    }
}
