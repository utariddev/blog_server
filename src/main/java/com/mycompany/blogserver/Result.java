package com.mycompany.blogserver;

/**
 * @date Feb 17, 2019
 * @author ekcdr
 */
public class Result {

    private String code;
    private String desc;

    public Result() {
        code = Constant.RESULT_CODE_SUCCESS;
        desc = Constant.RESULT_DESC_SUCCESS;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

}
