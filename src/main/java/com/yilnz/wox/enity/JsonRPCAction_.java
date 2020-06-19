package com.yilnz.wox.enity;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class JsonRPCAction_ {
    private String method = "take_action";
    private List<String> parameters;
    private boolean dontHideAfterAction;
}
