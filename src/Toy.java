public class Toy {
    private int id;
    private String name;
    private int quant;
    private double weight;

    public Toy(int id, String name, int quant, double weight) {
        this.id = id;
        this.name = name;
        this.quant = quant;
        this.weight = weight;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public long getQuant() {
        return quant;
    }

     public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void decreaseQuant() {
        if (quant > 0) {quant--;}
    }

//    public int removeQuant(int count) {
//        int i = 0;
//        if (quant > 0 ) {i = quant - count;}
//        return i;
//    }

    @Override
    public String toString() {
        return "Toy{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", quant=" + quant +
                ", weight=" + weight +
                '}';
    }
}
