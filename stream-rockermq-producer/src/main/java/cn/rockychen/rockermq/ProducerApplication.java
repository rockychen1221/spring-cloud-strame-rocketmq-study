/*
 * Copyright 2013-2018 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package cn.rockychen.rockermq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableBinding({MySource.class})
public class ProducerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProducerApplication.class, args);
    }

    @Bean
    public CustomRunner customRunner() {
        return new CustomRunner("output1");
    }

    public static class CustomRunner implements CommandLineRunner {

        private final String bindingName;

        public CustomRunner(String bindingName) {
            this.bindingName = bindingName;
        }

        @Autowired
        private SenderService senderService;

        @Override
        public void run(String... args) throws Exception {
            if (this.bindingName.equals("output1")) {
                int count = 5;
                for (int index = 1; index <= count; index++) {
                    String msgContent = "message-" + index;
                    senderService.send(msgContent);
                    System.out.println("send==>" + msgContent);
//                    if (index % 3 == 0) {
//                        senderService.send(msgContent);
//                        System.out.println("send==>" + msgContent);
//                    } else if (index % 3 == 1) {
//                        senderService.sendWithTags(msgContent, "tagString");
//                        System.out.println("send==>tagString " + msgContent);
//                    } else {
//                        senderService.sendObject(new Message(index, "message"), "tagObject");
//                        System.out.println("send==>tagObject " + msgContent);
//                    }
                }
            }
        }
    }
}
