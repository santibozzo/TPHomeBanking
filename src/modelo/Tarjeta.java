package modelo;

public class Tarjeta {

    private int number;
    private String type;
    private String owner;
    private float debit = 0f;
    private float credit = 0f;

    public Tarjeta(String type, String owner) {
        this.type = type;
        this.owner = owner;
    }

    public Tarjeta(String type, String owner, float debit, float credit) {
        this.type = type;
        this.owner = owner;
        this.debit = debit;
        this.credit = credit;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public float getDebit() {
        return debit;
    }

    public void setDebit(float debit) {
        this.debit = debit;
    }

    public float getCredit() {
        return credit;
    }

    public void setCredit(float credit) {
        this.credit = credit;
    }
}
