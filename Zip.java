import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Zip {
    Area[][] postnr;
    int max = 13513;
    public class Area {
        int nmr;
        String region;
        int population;
        public Area(int nmr, String region, int population) {
            this.nmr = nmr;
            this.region = region;
            this.population = population;
        }
    }
    public Zip(String file) {
        this.postnr = new Area[this.max][1];
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] row = line.split(",");
                Integer code = Integer.valueOf(row[0].replaceAll("\\s",""));
                Area ar = new Area(code, row[1], Integer.valueOf(row[2]));
                insert(ar);
            }
        } catch (Exception e) {
            System.out.println(" file " + file + " not found");
        }
    }
//    public boolean lookup(String nmr){
//        for (int i = 0; i < max; i++) {
//            if (nmr.equals(postnr[i].nmr)) return true;
//        }
//        return false;
//    }
//    public boolean lookup(int nmr){
//        return lookuprcs(nmr, 0, max - 1);
//    }
//    public boolean lookuprcs(int nmr, int min, int max) {
//        int mid = (max + min) / 2;
//        if (postnr[mid].nmr == nmr) return true;
//        if (max >= min) return false;
//        if (postnr[mid].nmr < nmr) return lookuprcs(nmr, mid + 1, max);
//        if (postnr[mid].nmr > nmr) return lookuprcs(nmr, min, mid - 1);
//        return false;
//    }
    private int hash(int key) {
        return key % 10000;
    }
//    public boolean lookup(int zip) {
//        if (postnr[zip] != null) return true;
//        return false;
//    }

//    public void collisions(int mod) {
//        System.out.println(max);
//        int mx = 20;
//        int[] data = new int[mod];
//        int[] cols = new int[mx];
//// keys[] are the zip codes
//        for (int i = 0; i < max; i++) {
//            Integer index = postnr[i].nmr % mod;
//            data[index]++;
//        }
//        for(int i = 0; i < mod; i++) {
//            if (data[i] < mx)
//                cols[data[i]]++;
//        }
//        System.out.print(mod + ": ");
//        for (int i = 1; i < mx; i++) {
//            System.out.print("\t" + cols[i]);
//        }
//        }
        private void insert(Area ar) {
            int indx = ar.nmr % max;
            Area[] bucket = postnr[indx];
            if (bucket[bucket.length - 1] != null) {
                Area[] newBucket = new Area[postnr[indx].length + 1];
                for (int i = 0; i < bucket.length; i++) newBucket[i] = bucket[i];
                newBucket[bucket.length] = ar;
                postnr[indx] = newBucket;
            }
            else {
                int j = 0;
                while (postnr[indx][j] != null) j++;
                postnr[indx][j] = ar;
            }
        }

        public boolean lookup(int zip) {
            int indx = zip % max;
            for (int i = 0; i < postnr[indx].length; i++) {
                if (postnr[indx][i].nmr == zip) return true;
            }
            return false;
        }

}