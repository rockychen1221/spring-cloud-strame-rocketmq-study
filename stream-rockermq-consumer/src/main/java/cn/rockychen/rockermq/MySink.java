package cn.rockychen.rockermq;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.cloud.stream.binder.PollableMessageSource;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

/**
 * @author rockychen
 * @version 1.0
 * @date 2021-08-09 14:12
 */
public interface MySink {

    @Input("input1")
    SubscribableChannel input1();

}
