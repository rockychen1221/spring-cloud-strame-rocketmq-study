package cn.rockychen.rockermq;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author rockychen
 * @version 1.0
 * @date 2021-08-09 13:58
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Message {

    private Integer id;

    private String content;
}
