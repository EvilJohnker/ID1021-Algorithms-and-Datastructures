import java.io.BufferedReader;
import java.io.FileReader;

public class Map {
    private City[][] cities;
    private final int mod = 50;
    public Map(String file) {
        cities = new City[mod][0];
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] row = line.split(",");
                City one = lookup(row[0]);
                City two = lookup(row[1]);
                int dist = Integer.parseInt(row[2]);
                one.connect(two, dist);
                two.connect(one, dist);
            }
        } catch (Exception e) {
            System.out.println(" file " + file + " not found or corrupt");
        }
    }

    public City lookup(String name) {
        int key = hash(name, mod);
        int length = cities[key].length;
        for (int i = 0; i < length; i++) {
            if (cities[key][i].name.equals(name)) return cities[key][i];
        }
        City[] extend = new City[length+1];
        System.arraycopy(cities[key], 0, extend, 0, length);
        extend[length] = new City(name);
        cities[key] = extend;
        return cities[key][length];
    }

    private static Integer hash(String name, int mod) {
        int hash = 0;
        for (int i = 0; i < name.length(); i++) {
            hash = (hash*31 + name.charAt(i)) % mod;
        }
        return hash;
    }

}