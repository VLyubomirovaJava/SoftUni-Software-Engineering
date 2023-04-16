package magicGame.models.magicians;

import magicGame.models.magics.Magic;

import static magicGame.common.ExceptionMessages.*;

public abstract class MagicianImpl implements Magician {
    private String username;
    private int health;
    private int protection;
    private boolean isAlive;
    private Magic magic;

    public MagicianImpl(String username, int health, int protection, Magic magic) {
        setUsername(username);
        setHealth(health);
        setProtection(protection);
        setMagic(magic);
        setAlive();
    }
//checked
    @Override
    public String getUsername() {
        return username;
    }
//checked
    protected void setUsername(String username) {
        if (username == null || username.trim().isEmpty()) {
            throw new NullPointerException(INVALID_MAGICIAN_NAME);
        }
        this.username = username;
    }
//checked
    @Override
    public int getHealth() {
        return health;
    }
//checked
    protected void setHealth(int health) {
        if (health < 0) {
            throw new IllegalArgumentException(INVALID_MAGICIAN_HEALTH);
        }
        this.health = health;
    }

    @Override
    public int getProtection() {
        return protection;
    }
//checked
    protected void setProtection(int protection) {
        if (protection < 0) {
            throw new IllegalArgumentException(INVALID_MAGICIAN_PROTECTION);
        }
        this.protection = protection;
    }


//checked
    protected void setAlive() {
        isAlive = health > 0;

    }

    @Override
    public Magic getMagic() {
        return magic;
    }
//checked
    protected void setMagic(Magic magic) {
        if (magic==null){
            throw new NullPointerException(INVALID_MAGIC);
        }
        this.magic = magic;
    }
//checked
    @Override
    public void takeDamage(int points) {
        if (getProtection() > points) {
            setProtection(getProtection() - points);
        } else {
            int rest = points - getProtection();
            if (getHealth() > rest) {
                setHealth(getHealth() - rest);
            }
            setProtection(0);
            setHealth(0);
            setAlive();
        }
    }
    //checked
        @Override
        public boolean isAlive() {
            return isAlive;
        }
//checked
@Override
public String toString(){
    String sb = this.getClass().getSimpleName() + " : " + username +
            System.lineSeparator() +
            "Health: " + health +
            System.lineSeparator() +
            "Protection: " + protection +
            System.lineSeparator() +
            "Magic: " + magic.getName();

    return sb;

}

}

