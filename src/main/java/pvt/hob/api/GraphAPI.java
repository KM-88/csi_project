package pvt.hob.api;

import org.springframework.http.HttpMethod;

public interface GraphAPI {
	
	public String getEndPoint();
	
	public HttpMethod getMethod();
	
	public void getBody();
	
	public void getACcept();
	
	public void getHeaders();
	
}
