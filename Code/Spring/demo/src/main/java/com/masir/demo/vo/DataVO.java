package com.masir.demo.vo;

import lombok.Data;

import lombok.Data;
import java.util.List;

/**
 * @Masir Description:
 * IO:
 */

@Data
public class DataVO<T> {
    private Integer code;
    private String msg;
    private Long count;
    private List<T> data;
}
