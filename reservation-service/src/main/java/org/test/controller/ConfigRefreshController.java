package org.test.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.aspectj.apache.bcel.classfile.annotation.NameValuePair;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigRefreshController {
	
	@RequestMapping("/doRefresh/{csrf}")
	public String doRefresh(@PathVariable("csrf") String csrf) throws ClientProtocolException, IOException{
		String result = "";
		
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost("http://localhost:8000/refresh");
		List <BasicNameValuePair> nvps = new ArrayList <BasicNameValuePair>();
		nvps.add(new BasicNameValuePair("username", "admin"));
		nvps.add(new BasicNameValuePair("password", "password"));
		nvps.add(new BasicNameValuePair("_csrf", csrf));
		
		httpPost.setEntity(new UrlEncodedFormEntity(nvps));
		
		CloseableHttpResponse response = httpclient.execute(httpPost);

		try {
		    System.out.println(response.getStatusLine());
		    HttpEntity entity = (HttpEntity) response.getEntity();
		    
		    System.out.println(getStringFromInputStream(entity.getContent()));
		    // do something useful with the response body
		    // and ensure it is fully consumed
		    EntityUtils.consume(entity);
		} finally {
		    response.close();
		}
		
		return result ;
		
	}
	
	private String getStringFromInputStream(InputStream is) {
		BufferedReader br = null;
		StringBuilder sb = new StringBuilder();
		String line;
		try {
			br = new BufferedReader(new InputStreamReader(is));
			while ((line = br.readLine()) != null) {
				sb.append(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return sb.toString();
	}

	
}
