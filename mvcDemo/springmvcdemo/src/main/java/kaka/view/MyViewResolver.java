package kaka.view;

/**
 * 视图解析器
 */
public class MyViewResolver {
    private String prefix;
    private String suffix;
    public String getPrefix() {
        return prefix;
    }
    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }
    public String getSuffix() {
        return suffix;
    }
    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public String jspMapping(String value){
        return this.prefix+value+this.suffix;
    }
}