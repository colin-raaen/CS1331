// Imposter Interface
public interface Impostor {
    // freeze abstract method, that accepts a Player object and returns nothing
    // any class that implements Impostor must provide a method definition for this method
    public abstract void freeze(Player p);

    // sabatoge abstract method, that accepts a Player object p and doesn't return anything
    // any class that implements Impostor must provide a method definition for this method
    public abstract void sabotage(Player p);
}