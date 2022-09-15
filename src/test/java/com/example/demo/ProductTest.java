package com.example.demo;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
//生产者  发送消息
public class ProductTest {

    //队列名称
    public  static  final  String QUEUE_NAME="hello";

    //发送消息
    public static void main(String[] args) throws Exception {
        //创建一个连接工厂
        ConnectionFactory connectionFactory = new ConnectionFactory();
        //工厂Ip  理解RabbitMQ的队列
        connectionFactory.setHost("");
        //用户名
        connectionFactory.setUsername("");
        //密码
        connectionFactory.setPassword("");
        //创建一个连接
        Connection connection = connectionFactory.newConnection();
        //通过连接  获取信道
        Channel channel = connection.createChannel();


        /**
         * 生成一个队列
         *  1.队列名称
         *  2.队列里面的消息是否持久化（磁盘） 默认情况消息存储在内存中（不持久化）
         *  3.改队列是否只供一个消费者进行消费，是否进行消息共享，True可以多个消费者消费，
         *  false只能一个消费者消费
         *  4.是否自动删除，最后一个消费者断开连接后，该队列是否自动删除，true自动删除，falser不自动删除
         *  5.其他参数
         */
        channel.queueDeclare(QUEUE_NAME,false,false,false,null);
        //发消息
        String message = "hello world";//初次使用

        /**
         * 发送一个消息
         * 1.发送到那个交换机
         * 2.路由的key值是哪个，本次是队列的名称
         * 3.其他参数信息
         * 4.发送消息的消息体
         */
        channel.basicPublish("",QUEUE_NAME,null,message.getBytes());
        System.out.println("消息发送完毕！");
    }
}
