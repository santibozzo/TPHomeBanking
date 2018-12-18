package modelo;

public class Cuenta {
    private int cbu = 0;
    private String alias;
    private String owner;
    private float debit;
    private float credit;

    public Cuenta(String alias, String owner, float debit, float credit){
        this.alias = alias;
        this.owner = owner;
        this.debit = debit;
        this.credit = credit;
    }

    public int getCbu() {
        return cbu;
    }

    public void setCbu(int cbu) {
        this.cbu = cbu;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
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
