package modelo;


import java.sql.Date;

public class Movimiento {

    private int movementId = -1;
    private int entityId;
    private String entityType;
    private float amount;
    private Date date;
    private String movementType;
    private String description;

    public Movimiento(int entityId, String entityType, float amount, Date date, String movementType, String description) {
        this.entityId = entityId;
        this.entityType = entityType;
        this.amount = amount;
        this.date = date;
        this.movementType = movementType;
        this.description = description;
    }

    public int getEntityId() {
        return entityId;
    }

    public String getEntityType() {
        return entityType;
    }

    public float getAmount() {
        return amount;
    }

    public Date getDate() {
        return date;
    }

    public String getMovementType() {
        return movementType;
    }

    public String getDescription() {
        return description;
    }

    public int getMovementId() {
        return movementId;
    }

    public void setMovementId(int movementId) {
        this.movementId = movementId;
    }
}
