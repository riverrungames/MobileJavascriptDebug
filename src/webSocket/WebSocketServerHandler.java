package webSocket;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.FullHttpResponse;
import io.netty.handler.codec.http.websocketx.CloseWebSocketFrame;
import io.netty.handler.codec.http.websocketx.PingWebSocketFrame;
import io.netty.handler.codec.http.websocketx.PongWebSocketFrame;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.handler.codec.http.websocketx.WebSocketFrame;
import io.netty.handler.codec.http.websocketx.WebSocketServerHandshaker;
import io.netty.handler.codec.http.websocketx.WebSocketServerHandshakerFactory;
import io.netty.util.CharsetUtil;

import java.nio.charset.Charset;
import java.util.logging.Level;
import java.util.logging.Logger;

import static io.netty.handler.codec.http.HttpHeaders.Names.*;
import static io.netty.handler.codec.http.HttpHeaders.*;
import static io.netty.handler.codec.http.HttpMethod.*;
import static io.netty.handler.codec.http.HttpResponseStatus.*;
import static io.netty.handler.codec.http.HttpVersion.*;

/**
 * Handles handshakes and messages
 */
public class WebSocketServerHandler extends SimpleChannelInboundHandler<Object> {
    private static final Logger logger = Logger.getLogger(WebSocketServerHandler.class.getName());


    @Override  
    public void channelRead(final ChannelHandlerContext ctx, Object msg)  
            throws Exception {  
        // TODO Auto-generated method stub  
//    	System.out.println("msg rec");
    	 
        WebSocketFrame frame = (WebSocketFrame)msg;  
        ByteBuf buf = frame.content();  //真正的数据是放在buf里面的  
        
   
        String aa = buf.toString(Charset.forName("utf-8"));  //将数据按照utf-8的方式转化为字符串  
        
        if(aa.equals("cls")){
        	
//        	Runtime.getRuntime().exec("cls");
//        	System.out.print(String.format("\u001b[2J"));
//        	System.out.print("\b\b\b\b\bb\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b");
        	System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        	//Runtime.getRuntime().exec("clear");
        	
        }
        WebSocketServer.logger.debug(aa);
        buf.release();
        
        System.out.println(aa);  
        
        WebSocketFrame out = new TextWebSocketFrame(aa);  //创建一个websocket帧，将其发送给客户端  
        ctx.pipeline().writeAndFlush(out).addListener(new ChannelFutureListener(){  
      
            @Override  
            public void operationComplete(ChannelFuture future)  
                    throws Exception {  
                // TODO Auto-generated method stub  
//                ctx.pipeline().close();  //从pipeline上面关闭的时候，会关闭底层的chanel，而且会从eventloop上面取消注册  
//                ctx.close();
            }  
              
        });  
          
    }  
 

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }


	@Override
	protected void channelRead0(ChannelHandlerContext ctx, Object msg)
			throws Exception {
		// TODO Auto-generated method stub
		
	}
}