package DVM_Client;
import DVM_Server.DVMServerInitializer;
import Model.Message;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
public class DVMClient {

    private int PORT =8080;
    private String IP;
    private String msg;
    public DVMClient(String host, String msg){
        this.IP = host;
        this.msg = msg;
    }
    public void run() throws InterruptedException {
        EventLoopGroup group = new NioEventLoopGroup();
        try{
            Bootstrap clientBs = new Bootstrap();

            clientBs.group(group)
                .channel(NioSocketChannel.class)
                .remoteAddress(IP,PORT)
                .handler( new DVMClientInitializer(msg));
            ChannelFuture channelFuture = clientBs.connect().sync();
            channelFuture.channel().closeFuture().sync();
        }
        finally {
            group.shutdownGracefully();
        }
    }
}
