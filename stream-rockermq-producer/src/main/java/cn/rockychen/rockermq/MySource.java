package cn.rockychen.rockermq;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * @author rockychen
 * @version 1.0
 * @date 2021-08-09 14:12
 */
public interface MySource {

    @Output("output1")
    MessageChannel output1();

}
