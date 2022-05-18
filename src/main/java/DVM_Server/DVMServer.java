package DVM_Server;
import Model.Message;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.net.InetSocketAddress;

public class DVMServer {

    private static final int PORT = 8080;
    public void run() throws Exception{

        EventLoopGroup parentGroup = new NioEventLoopGroup();
        EventLoopGroup childGrup = new NioEventLoopGroup();

        try {
            ServerBootstrap bs = new ServerBootstrap();
            bs.group(parentGroup,childGrup)
                    .channel(NioServerSocketChannel.class)
                    .localAddress(new InetSocketAddress(PORT))
                    .childHandler(new DVMServerInitializer());
            ChannelFuture future = bs.bind().sync();
            future.addListener(new ChannelFutureListener() {
                @Override
                public void operationComplete(ChannelFuture future) throws Exception {
                    if(future.isSuccess()){
                        System.out.println("Server bound");
                    }else{
                        System.out.println("Server bound");
                        future.cause().printStackTrace();
                    }
                }
            });
            future.channel().closeFuture().sync();
        }finally {
            parentGroup.shutdownGracefully();
            childGrup.shutdownGracefully();
        }
    }
    public void writeMessage(String msg){

    }
}
