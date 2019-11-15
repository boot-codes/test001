package com.aosica.demo.mqtt;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.EntityBuilder;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.ByteArrayBody;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class HttpClientUtil {

	public static String doGet(String url, Map<String, String> param) {

		// 创建Httpclient对象
		CloseableHttpClient httpclient = HttpClients.createDefault();

		String resultString = "";
		CloseableHttpResponse response = null;
		try 
		{
			// 创建uri
			URIBuilder builder = new URIBuilder(url);
			if (param != null) {
				for (String key : param.keySet()) {
					builder.addParameter(key, param.get(key));
				}
			}
			URI uri = builder.build();

			// 创建http GET请求
			HttpGet httpGet = new HttpGet(uri);

			// 执行请求
			response = httpclient.execute(httpGet);
			// 判断返回状态是否为200
			if (response.getStatusLine().getStatusCode() == 200) {
				resultString = EntityUtils.toString(response.getEntity(), "UTF-8");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (response != null) {
					response.close();
				}
				httpclient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return resultString;
	}

	public static String doPost(String url,File file)
	{
		 
		// 创建Httpclient对象
		CloseableHttpClient httpClient = HttpClients.createDefault();

		CloseableHttpResponse response = null;
		String resultString = "";
		try 
		{
			HttpPost httpPost = new HttpPost(url);
			
		    FileBody fileBody = new FileBody(file);
		    
			MultipartEntityBuilder builder = MultipartEntityBuilder.create();
			builder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
			builder.addPart("file", fileBody);
			
		    HttpEntity entity = builder.build();
			httpPost.setEntity(entity);
			
			response = httpClient.execute(httpPost);
			resultString = EntityUtils.toString(response.getEntity(), "utf-8");
		} 
		catch (Exception e) {
			e.printStackTrace();
		} 
		finally {
			try {
				response.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return resultString;
	}



	public static String doPost(String url,InputStream inputStream) {

		// 创建Httpclient对象
		CloseableHttpClient httpClient = HttpClients.createDefault();

		CloseableHttpResponse response = null;
		String resultString = "";

		try
		{
		HttpPost httpPost = new HttpPost(url);
		MultipartEntityBuilder builder = MultipartEntityBuilder.create();
		builder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
		builder.addBinaryBody("file", inputStream, ContentType.create("multipart/form-data"), "png");
		//4)构建请求参数 普通表单项
		StringBody stringBody = new StringBody("12",ContentType.MULTIPART_FORM_DATA);
		builder.addPart("id",stringBody);
		HttpEntity entity = builder.build();
		httpPost.setEntity(entity);

		response = httpClient.execute(httpPost);
		resultString = EntityUtils.toString(response.getEntity(), "utf-8");

		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				response.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return resultString;

	}



	public static String doPost(String url,byte[] fileByte) {

		// 创建Httpclient对象
		CloseableHttpClient httpClient = HttpClients.createDefault();
		CloseableHttpResponse response = null;
		String resultString = "";
		try
		{
			HttpPost httpPost = new HttpPost(url);
			ByteArrayBody byteArrayBody = new ByteArrayBody(fileByte,".png") ;

			MultipartEntityBuilder builder = MultipartEntityBuilder.create();
			builder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
			builder.addPart("file", byteArrayBody);

			HttpEntity entity = builder.build();
			httpPost.setEntity(entity);

			response = httpClient.execute(httpPost);
			resultString = EntityUtils.toString(response.getEntity(), "utf-8");
			System.out.println(resultString);
		}
		catch (Exception e) {
			resultString = "500" ;
			e.printStackTrace();
		}
		finally {
			try {
				if(response != null) {
					response.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return resultString;
	}


	public static String doPost(String url) throws Exception {

		// 创建Httpclient对象
		CloseableHttpClient httpClient = HttpClients.createDefault();
		CloseableHttpResponse response = null;
		String resultString = "";
		try
		{
			HttpPost httpPost = new HttpPost(url);
			//ByteArrayBody byteArrayBody = new ByteArrayBody(fileByte,".png") ;

			EntityBuilder builder = EntityBuilder.create().create();

			NameValuePair nameValuePair1 = new BasicNameValuePair("appId","DanmUIqDJIPlU7qIm55PMMGCjOQa") ;
			NameValuePair nameValuePair2 = new BasicNameValuePair("secret","37_7pZN2pEfYMOKzgf__Q4d2luQa") ;
			builder.setParameters(nameValuePair1,nameValuePair2) ;
			//builder.addPart("file", byteArrayBody);

			//HttpEntity entity = builder.build();
			httpPost.setEntity(builder.build());

			response = httpClient.execute(httpPost);
			resultString = EntityUtils.toString(response.getEntity(), "utf-8");
			System.out.println(resultString);
		}
		catch (Exception e) {
			resultString = "500" ;
			e.printStackTrace();
		}
		finally {
			try {
				if(response != null) {
					response.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return resultString;
	}
}
