package strategymodel;

public enum ExEnum {
    EARLY("early",new EarlyExHandler()),
    LATE("late",new LateExHandler());
    String val;
    ExHandler exHandler;

    ExEnum(String val, ExHandler exHandler) {
        this.val = val;
        this.exHandler = exHandler;
    }

    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val = val;
    }

    public ExHandler getExHandler() {
        return exHandler;
    }

    public void setExHandler(ExHandler exHandler) {
        this.exHandler = exHandler;
    }
}
