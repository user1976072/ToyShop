import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ToyStore {
    private List<Toy> toys = new ArrayList<>();
    private List<Toy> prizeToys = new ArrayList<>();
    private List<Toy> pastPrizeToys = new ArrayList<>();

    public void addToy(Toy toy) {
        toys.add(toy);
    }

    public void addToPrizeList(Toy toy) {
        prizeToys.add(toy);
    }

//    public Toy getPrizeToy() {
//        if (!prizeToys.isEmpty()) {
//            Toy prizeToy = prizeToys.remove(0);
//            saveTFile(prizeToy);
//            return prizeToy;
//        }
//        return null;
//    }

    public void saveTFile(Toy toy) {
        try (FileWriter writer = new FileWriter("winner.txt", true)){
            writer.write(toy.getName() + "\n");
        } catch (IOException e) {e.printStackTrace();}
    }

    public void printPrizeToys() {
        System.out.println("Призовые игрушки: ");
        for (Toy toy: prizeToys) {
            System.out.println(toy);
        }
    }

    public void printTotalToys() {
        System.out.println("Все игрушки:");
        for (Toy toy: toys) {
            System.out.println(toy);
        }
    }

    public void updateWeight(int toyId, double weight){
        for (Toy toy: toys) {
            if (toy.getId() == toyId) {
                toy.setWeight(weight);
                return;
            }
        }
    }

    public Toy play() {
        double totalWeight = 0;
        for (Toy toy : toys) {
            totalWeight += toy.getWeight();
        }

        if (totalWeight > 0) {
            double randomValue = new Random().nextDouble() * totalWeight;

            double currentWeight = 0;
            for (Toy toy : toys) {
                currentWeight += toy.getWeight();
                if (randomValue <= currentWeight && toy.getQuant() > 0) {
                    Toy selectedToy = new Toy(toy.getId(), toy.getName(), 1, toy.getWeight());
                    toy.decreaseQuant();
                    pastPrizeToys.add(selectedToy);
                    return selectedToy;
                }
            }
        }
        return null;
    }

//    public void loadPrizeToysFromFile(String filename) {
//        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
//            String line;
//            while ((line = reader.readLine()) != null) {
//                for (Toy toy : toys) {
//                    if (toy.getName().equals(line) && toy.getQuant() > 0) {
//                        Toy prizeToy = new Toy(toy.getId(), toy.getName(), 1, toy.getWeight());
////                        toy.decreaseQuant();
//                        prizeToys.add(prizeToy);
//                        break;
//                    }
//                }
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

//    public void updateRemainingToys() {
//        for (Toy prizeToy : pastPrizeToys) {
//            for (Toy toy : toys) {
//                if (toy.getName().equals(prizeToy.getName()) && toy.getQuant() > 0) {
//                    toy.decreaseQuant();
//                    break;
//                }
//            }
//        }
//        pastPrizeToys.clear();
//    }

}
