package pvt.hob.api;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.web.client.RestOperations;


public class GraphAPIRequest {

	@Autowired
	private RestOperations restRequest;
	
	private void request(GraphAPI api, Map<String, ?> values ) {
		RequestEntity request =  (RequestEntity) RequestEntity.method(HttpMethod.GET, api.getEndPoint(), values);
		restRequest.exchange(api.getEndPoint(), api.getMethod(), request, String.class, values);
	}
	
}
