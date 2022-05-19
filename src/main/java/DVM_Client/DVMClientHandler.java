package DVM_Client;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;



public class DVMClientHandler extends SimpleChannelInboundHandler {
    String msg2Send;
    public DVMClientHandler(String msg){
        this.msg2Send = msg;
    }
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {

    }
    @Override
    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
        System.out.println("channel Registered");
    }

    @Override
    public void channelUnregistered(ChannelHandlerContext ctx) throws Exception {
        System.out.println("channel UnRegistered");
    }
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("channel Active");
        sendMsg(ctx,msg2Send);
        ctx.close();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        super.exceptionCaught(ctx, cause);
    }
    public void channelClose(ChannelHandlerContext ctx){
        ctx.close();
    }

    public void sendMsg (ChannelHandlerContext ctx, String msg){
        ctx.writeAndFlush(msg);
        System.out.println("sendMessage");
    }
}
