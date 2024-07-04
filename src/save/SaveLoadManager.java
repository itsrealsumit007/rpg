import java.io.*;

public class SaveLoadManager {
    public static void saveGame(Hero hero, String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(hero);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Hero loadGame(String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            return (Hero) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}
