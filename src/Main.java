import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        ToyStore toyStore = new ToyStore();

        toyStore.addToy(new Toy(1, "Юла", 5,20));
        toyStore.addToy(new Toy(2,"Car", 10,30));
        toyStore.addToy(new Toy(3,"Bear",8,50));

        Toy selectedToy = toyStore.play();

        if (selectedToy != null) {
            System.out.println("Поздравляем. Вы выиграли " + selectedToy.getName());
//            toyStore.loadPrizeToysFromFile("winner.txt");
            toyStore.addToPrizeList(selectedToy);
            toyStore.saveTFile(selectedToy);
        } else {
            System.out.println("Нету игрушек");
        }
//        toyStore.updateRemainingToys();
        toyStore.printPrizeToys();
        toyStore.printTotalToys();

    }
}