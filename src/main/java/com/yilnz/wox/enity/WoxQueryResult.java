package com.yilnz.wox.enity;

import lombok.Data;

@Data
public class WoxQueryResult extends WoxResult{
    private String ContextData;
    private JsonRPCAction_ JsonRPCAction;
}
