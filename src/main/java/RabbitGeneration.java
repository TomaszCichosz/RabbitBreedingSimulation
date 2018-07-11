public class RabbitGeneration {

    private int age;
    private long count;

    public RabbitGeneration(long count) {
        age = 0;
        this.count = count;
    }

    public void age() {
        age++;
    }

    public int getAge() {
        return age;
    }

    public long getCount() {
        return count;
    }
}
