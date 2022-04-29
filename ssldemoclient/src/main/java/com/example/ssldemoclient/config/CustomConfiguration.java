package com.example.ssldemoclient.config;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;

import javax.net.ssl.SSLContext;

import org.apache.http.client.HttpClient;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContextBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
public class CustomConfiguration {

//	@Value("${trust.store}")
//	private Resource trustStore;
//	@Value("${trust.store.password}")
	private String trustStorePassword = "dataflow";

	@Bean
	public RestTemplate restTemplate() throws KeyManagementException, NoSuchAlgorithmException, KeyStoreException,
			CertificateException, MalformedURLException, IOException {
		SSLContext sslContext = new SSLContextBuilder()
				.loadTrustMaterial(new URL( "file:C:\\Users\\1039032\\Downloads\\ssldemoclient\\ssldemoclient\\src\\main\\resources\\dataflow.truststore"), trustStorePassword.toCharArray()).build();
		SSLConnectionSocketFactory socketFactory = new SSLConnectionSocketFactory(sslContext);
		HttpClient httpClient = HttpClients.custom().setSSLSocketFactory(socketFactory).build();
		HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory(httpClient);
		return new RestTemplate(factory);

	}
}