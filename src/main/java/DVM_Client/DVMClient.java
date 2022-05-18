package DVM_Client;
import DVM_Server.DVMServerInitializer;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class DVMClient implements Runnable{
    private SocketAddress address;
    public DVMClient(SocketAddress address){
        this.address = address;
    }
    public DVMClient(String host, int PORT){
        this(new InetSocketAddress(host,PORT));
    }

    private ExecutorService executorService = null;
    private boolean isRunning = false;

    public synchronized void startClient(){
        if(!isRunning) {
            executorService = Executors.newFixedThreadPool(1);
            executorService.execute(this);
            isRunning = true;
            }
    }
    public synchronized boolean stopClient(){
        boolean bReturn = true;
        if (isRunning) {
            if (executorService != null) {
                executorService.shutdown();
                try {
                    executorService.shutdownNow();
                    if (executorService.awaitTermination(calcTime(10, 0.66667), TimeUnit.SECONDS)) {
                        if (!executorService.awaitTermination(calcTime(10, 0.33334), TimeUnit.SECONDS)) {
                            bReturn = false;
                        }
                    }
                } catch (InterruptedException ie) {
                    executorService.shutdownNow();
                    Thread.currentThread().interrupt();
                } finally {
                    executorService = null;
                }
            }
            isRunning = false;
        }
        return bReturn;
    }
    private long calcTime(int nTime, double dValue) {
        return (long) ((double) nTime * dValue);
    }

    public void run()  {
        EventLoopGroup group = new NioEventLoopGroup();
        try{
            Bootstrap clientBs = new Bootstrap();

            clientBs.group(group)
                .channel(NioSocketChannel.class)
                .option(ChannelOption.SO_KEEPALIVE, true)
                .remoteAddress(address)
                .handler( new DVMServerInitializer());
            ChannelFuture channelFuture = clientBs.connect().sync();
            channelFuture.channel().closeFuture().sync();
        }catch (InterruptedException ex){

        }
        finally {
            group.shutdownGracefully();
        }
    }
    public void writeMsg(String msg){
        DVMClientHandler handler = new DVMClientHandler();
        System.out.println("메시지를 전송합니다.");
        handler.sendMsg(msg);
    }
}
