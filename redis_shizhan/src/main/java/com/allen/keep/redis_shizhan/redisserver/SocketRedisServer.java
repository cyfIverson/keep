package com.allen.keep.redis_shizhan.redisserver;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author allen
 * @descript 手写的redis服务
 * @date 2020-03-23 11:36 AM
 */
public class SocketRedisServer {

    /**
     * 手写的redis服务
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(6380);
        Socket accept = serverSocket.accept();
        byte[] result = new byte[2048];
        accept.getInputStream().read(result);
        System.out.println(result);
    }

}
