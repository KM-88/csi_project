package pvt.hob.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

import pvt.hob.api.GraphAPI;

@Configuration
public class ResourceConfig {
	
	@Bean
	public RestOperations getGraphAPIRestTemplate() {
		return new RestTemplate();
	}
	
	@Bean
	public ClientHttpRequestFactory getClientHttpRequestFactory() {
		HttpComponentsClientHttpRequestFactory httpComponentsClientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory();
		return httpComponentsClientHttpRequestFactory;
	}
	
	public HttpHeaders getGraphAPIHttpHeaders(GraphAPI api) {
		HttpHeaders httpHeaders = new HttpHeaders();
		return httpHeaders;
	}
	
}
