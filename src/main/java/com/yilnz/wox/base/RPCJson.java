package com.yilnz.wox.base;

import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString
class RPCJson{
    private String method;
    private List<Object> parameters;
}