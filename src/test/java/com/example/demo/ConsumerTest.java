package com.example.demo;

import com.rabbitmq.client.*;

import java.io.IOException;

//消费者  接收消息
public class ConsumerTest {

    //队列名称
    public  static  final  String QUEUE_NAME="hello";

    //接收消息
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


        //声明  消息的接受
        DeliverCallback deliverCallback = (consumerTag, message)->{
            System.out.println("消息接收到了"+message);
        };
        //取消消息时的回调
        CancelCallback cancelCallback = consumerTag ->{
            System.out.println("消息消费被中断了");
        };

        /**
         * 消费者消费消息
         * 1.消费那个队列
         * 2.消费成功之后是否要自动应答true 代表自动应答 ，false代表手动应答
         * 3，消费者未成功消费的回调
         * 4消费者取消消费的回调
         */

        channel.basicConsume(QUEUE_NAME,true,deliverCallback,cancelCallback);
    }
}
