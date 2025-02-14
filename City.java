public class City {
    String name;
    Connection[] Connections;
    int ConIndx;

    public City (String City){
        this.name = City;
        this.Connections = new Connection[4];
    }

    public class Connection {
        City CityCon;
        int distance;
        public Connection(City CityCon, int distance) {
            this.CityCon = CityCon;
            this.distance = distance;
        }
    }

    public void connect(City nxt, int dst) {
        if (Connections.length == ConIndx) {
            Connection[] larger = new Connection[ConIndx * 2];
            System.arraycopy(Connections, 0, larger, 0, ConIndx);
            Connections = larger;
        }
        Connections[ConIndx++] = new Connection(nxt, dst);
    }
}
