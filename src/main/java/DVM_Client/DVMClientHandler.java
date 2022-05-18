package DVM_Client;


import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;

import java.nio.charset.Charset;

public class DVMClientHandler extends SimpleChannelInboundHandler {
    ChannelHandlerContext ctx;
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {

    }
    public void sendMsg (String msg){
        if(ctx != null){
            ChannelFuture channelFuture = ctx.write(Unpooled.copiedBuffer(msg, CharsetUtil.UTF_8));
            ctx.flush();
            if(!channelFuture.isSuccess()){
                System.out.println("Send failed" + channelFuture.cause());
            }
        }else{
            System.out.println("채널 초기화 실패");
        }
    }
}
