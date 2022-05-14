package com.example.goodscommon.vo;

public class ResultVo {

    private Integer code;
    private String msg;
    private Object data;

    private ResultVo(){}

    /**
     * 成功
     * @return
     */
    public static ResultVo success(Object data) {
        ResultVo resultVo = new ResultVo();
        resultVo.setCode(200);
        resultVo.setMsg("success");
        resultVo.setData(data);
        return resultVo;
    }

    public static ResultVo success(){
        return ResultVo.success(null);
    }

    /**
     * 失败
     * @return
     */
    public static ResultVo wrong() {
        ResultVo resultVo = new ResultVo();
        resultVo.setCode(500);
        resultVo.setMsg("wrong");
        return resultVo;
    }

    public static ResultVo wrong(String msg) {
        ResultVo resultVo = new ResultVo();
        resultVo.setCode(500);
        resultVo.setMsg(msg);
        return resultVo;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
