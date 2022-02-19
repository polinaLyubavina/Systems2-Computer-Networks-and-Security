package msd.benjones;

import java.util.HashMap;
import java.util.Set;

public class Router {

    private HashMap<Router, Integer> distances;
    private String name;
    public Router(String name) {
        this.distances = new HashMap<>();
        this.name = name;
    }

    public void onInit() throws InterruptedException {
		//As soon as the network is online,
		//fill in your initial distance table and broadcast it to your neighbors

        for (Neighbor n : Network.getNeighbors(this)) {
            this.distances.put(n.router, n.cost);
        }

        for (Neighbor n : Network.getNeighbors(this)) {
            Network.sendDistanceMessage(new Message(this, n.router, distances));
        }
    }

    public void onDistanceMessage(Message message) throws InterruptedException {
		//update your distance table and broadcast it to your neighbors if it changed
        boolean changed = false;
        int distToSender = this.distances.get(message.sender);

        // Do Bellman Ford
        for (Neighbor n : Network.getNeighbors(this)) {
            Integer distanceFromSenderToN = message.distances.get(n.router);

            if (distanceFromSenderToN == null) {
                continue;
            }

            int distToNThroughSender = distToSender + distanceFromSenderToN;

            if (distToNThroughSender < this.distances.get(n.router)) {
                this.distances.put(n.router, distToNThroughSender);
                changed = true;
            }
        }

        if (changed) {
            for (Neighbor n : Network.getNeighbors(this)) {
                Network.sendDistanceMessage(new Message(this, n.router, distances));
            }
        }
    }


    public void dumpDistanceTable() {
        System.out.println("router: " + this);
        for(Router r : distances.keySet()){
            System.out.println("\t" + r + "\t" + distances.get(r));
        }
    }

    @Override
    public String toString(){
        return "Router: " + name;
    }
}
