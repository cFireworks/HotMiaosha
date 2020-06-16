package com.cfireworks.order.rabbitmq;

import com.cfireworks.order.entity.MiaoshaOrder;
import com.cfireworks.order.entity.MiaoshaUser;
import com.cfireworks.order.entity.OrderInfo;
import com.cfireworks.order.redis.RedisService;
import com.cfireworks.order.service.GoodsService;
import com.cfireworks.order.service.MiaoshaService;
import com.cfireworks.order.service.OrderService;
import com.cfireworks.common.vo.GoodsVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description: 消息发送
 * @author: cfireworks
 * @create: 2020-05-24 11:05
 **/
@Service
public class MQReceiver {

    private static Logger log = LoggerFactory.getLogger(MQSender.class);

    @Autowired
    GoodsService goodsService;

    @Autowired
    OrderService orderService;

    @Autowired
    MiaoshaService miaoshaService;

    @RabbitListener(queues=MQConfig.MIAOSHA_QUEUE)
    public void receiveMiaosha(String message){
        log.info("receive message:"+message);
        MiaoshaMessage mm = RedisService.stringToBean(message, MiaoshaMessage.class);
        MiaoshaUser user = mm.getUser();
        long goodsId = mm.getGoodsId();

        //判断库存
        GoodsVo goods = goodsService.getGoodsVoByGoodsId(goodsId);//10个商品，req1 req2
        int stock = goods.getStockCount();
        if(stock <= 0) {
            return;
        }
        //判断是否已经秒杀到了
        MiaoshaOrder order = orderService.getMiaoshaOrderByUserIdGoodsId(user.getId(), goodsId);
        if(order != null) {
            return;
        }
        //下订单 写入秒杀订单
        OrderInfo orderInfo = miaoshaService.miaosha(user, goods);
        return;
    }

//    @RabbitListener(queues=MQConfig.QUEUE)
//    public void receive(String message){
//        log.info("receive message:"+message);
//    }
//
//    @RabbitListener(queues=MQConfig.TOPIC_QUEUE1)
//    public void receiveTopic1(String message){
//        log.info("topic queue1 message:"+message);
//    }
//
//    @RabbitListener(queues=MQConfig.TOPIC_QUEUE2)
//    public void receiveTopic2(String message){
//        log.info("topic queue2 message:"+message);
//    }
//
//    @RabbitListener(queues=MQConfig.HEADER_QUEUE)
//    public void receiveTopic2(byte[] message){
//        log.info("header queue1 message:"+new String(message));
//    }
}
