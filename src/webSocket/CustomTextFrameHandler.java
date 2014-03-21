package webSocket;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;

public class CustomTextFrameHandler extends SimpleChannelInboundHandler<TextWebSocketFrame> {
	
	protected void messageReceived(ChannelHandlerContext ctx, TextWebSocketFrame frame) throws Exception {
		
		System.out.println("test");
//        String request = frame.text();
//        System.out.println("test");
//        ctx.channel().writeAndFlush(new TextWebSocketFrame(request.toUpperCase()));
    }

	@Override
	protected void channelRead0(ChannelHandlerContext ctx,
			TextWebSocketFrame msg) throws Exception {
		// TODO Auto-generated method stub
		
	}
}