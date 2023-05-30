package ProjetoAED2LP2;

import edu.princeton.cs.algs4.Digraph;
import java.util.HashMap;
import java.util.Map;
public class Mapa_BD {
        private Digraph graph;
        private Map<String, Station> stations;
        private Map<String, Connection> connections;

        public Mapa() {
            graph = new Digraph();
            stations = new HashMap<>();
            connections = new HashMap<>();
        }

        public void addStation(Station station) {
            stations.put(station.getId(), station);
            graph.addVertex(Integer.parseInt(station.getId()));
        }

        public void addConnection(Connection connection) {
            connections.put(connection.getId(), connection);
            graph.addEdge(Integer.parseInt(connection.getSource().getId()), Integer.parseInt(connection.getDestination().getId()));
        }

        public Station getStation(String id) {
            return stations.get(id);
        }

        public Connection getConnection(String id) {
            return connections.get(id);
        }

        // Outros métodos relevantes para a manipulação do mapa
    }

    public class Station {
        private String id;
        // outros atributos relevantes

        public Station(String id) {
            this.id = id;
        }

        public String getId() {
            return id;
        }

        // getters e setters para outros atributos
    }

    public class Connection {
        private String id;
        private Station source;
        private Station destination;
        private double distance;
        private double time;
        private double price;
        // outros atributos relevantes

        public Connection(String id, Station source, Station destination, double distance, double time, double price) {
            this.id = id;
            this.source = source;
            this.destination = destination;
            this.distance = distance;
            this.time = time;
            this.price = price;
        }

        public String getId() {
            return id;
        }

        public Station getSource() {
            return source;
        }

        public Station getDestination() {
            return destination;
        }

        public double getDistance() {
            return distance;
        }

        public double getTime() {
            return time;
        }

        public double getPrice() {
            return price;
        }

        // getters e setters para outros atributos
    }

}
