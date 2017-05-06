package cn.xuezhijian2.demo.redis.dto;

/**
 * Created with IntelliJ IDEA.
 * packageName  : cn.xuezhijian2.demo.redis.dto
 * User         : zj
 * Date         : 17/4/20
 * Time         : 下午2:04
 * Description  :
 */

public class DemoSessionDto {

    private String key;

    private String value;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}
