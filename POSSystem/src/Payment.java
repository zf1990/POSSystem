
public abstract class Payment {

    protected float amount;
    protected PaymentType type;
    protected enum PaymentType{
        CREDIT,
        DEBIT,
        CASH
    }

    public float getAmount(){
        return amount;
    }
    public PaymentType getType(){
        return type;
    }

    public void setAmount(float amount){
        this.amount = amount;
    }
}