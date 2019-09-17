package exceptions;

public class WrongInputException extends Throwable {
    private String msg;
    public WrongInputException(String msg){
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
