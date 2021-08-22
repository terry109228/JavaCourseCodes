package lesson3;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.DefaultHttpHeaders;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.HttpHeaders;
import lesson3.main.java.io.github.kimmking.gateway.filter.HttpRequestFilter;

public class HelloUrlFilter implements HttpRequestFilter{
	 public static HelloUrlFilter newInstance() {
	        return new HelloUrlFilter();
	    }

	    public void filter(FullHttpRequest fullRequest, ChannelHandlerContext ctx) {
	        String uri = fullRequest.uri();
	        System.out.println(" HelloUrlFilter接收到的请求,url: " + uri);
	        if (uri.startsWith("/hello")) {
	            // �Ź�
	        } else {
	            throw new RuntimeException("不符合URL过滤条件" + uri);
	        }
	        HttpHeaders headers = fullRequest.headers();
	        if (headers == null) {
	            headers = new DefaultHttpHeaders();
	        }
	        headers.add("ClassName：", this.getClass().getSimpleName());
	    }
}
