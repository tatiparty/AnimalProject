package options;

public enum Options {
    ADD("ADD"),
    LIST("LIST"),
    EXIT("EXIT");

    public final String opt;

    Options(String opt) {
        this.opt = opt;
    }

    public String getOpt(){
        return opt;
    }
}
