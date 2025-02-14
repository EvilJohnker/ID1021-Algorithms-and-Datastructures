public class Paths {
    City[] path;
    int sp;
    public Paths() {
        path = new City[54];
        sp = 0;
    }
    public Integer shortest(City from, City to) {
        if (from == to) return 0;
        for (int i = 0; i < sp; i++) {
            if (path[i] == from)
                return null;
        }
        path[sp++] = from;
        Integer time;
        Integer shrt = null;
        for (int i = 0; i < from.Connections.length; i++) {
            if (from.Connections[i] == null) break;
            time = shortest(from.Connections[i].CityCon, to);
            if (time == null) continue;
            time += from.Connections[i].distance;
            if (shrt == null) shrt = time;
            else if (time < shrt) shrt = time;
        }
        path[sp--] = null;
        return shrt;
    }
}