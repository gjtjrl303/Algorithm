
import java.util.*;

class Solution {
    int count = 0; 
    boolean flag = false;
    int ticketSize;
    Deque<Airport> deque = new ArrayDeque<>();
    
    public String[] solution(String[][] tickets) {
        ticketSize = tickets.length;
        Set<String> set = new HashSet<>();
    
        Map<String, Airport> airports = new HashMap<>();
        
        for(int i = 0 ; i < tickets.length ; i++){
            airports.put(tickets[i][0], new Airport(tickets[i][0]));
            airports.put(tickets[i][1], new Airport(tickets[i][1]));
        }
        
        for(int i = 0 ; i < tickets.length ; i++){
            airports.get(tickets[i][0]).addTicket(new Ticket(tickets[i][1]));
        }
        
        // for(int i = 0 ; i < list.size() ; i++){
        //     System.out.println(list.get(i));
        // }
        
        // for(Airport airport : airports.values()){
        //     System.out.print(airport + " : ");
        //     Queue<Ticket> temp = airport.getTickets();
        //     for(Ticket ticket : temp){
        //         System.out.print(ticket.to + " ");
        //     }
        //     System.out.println();
        // }
        
        deque.add(airports.get("ICN"));
        dfs(airports, airports.get("ICN"), count + 1);
        
        int size = deque.size();
        String[] answer = new String[size];
        for(int i = 0 ; i < size ; i++){
            answer[i] = deque.removeFirst().name;
        }
        
        return answer;
    }
    
    public void dfs(Map<String, Airport> airports, Airport currentAirport, int count){
        if(count == ticketSize + 1) {
            flag = true;
            return;
        }
        
        List<Ticket> list = currentAirport.getTickets();
        for(Ticket ticket : list){
            if(ticket.isUsed) continue;
            ticket.setUsed(true);
            deque.add(airports.get(ticket.to));
            dfs(airports, airports.get(ticket.to), count + 1);
            if(flag) return;
            
            deque.removeLast();
            ticket.setUsed(false);
        }
    }
    
    class Airport {
        String name;
        LinkedList<Ticket> tickets = new LinkedList();
        
        public Airport(String airPort){
            this.name = airPort;
        }
        
        public void addTicket(Ticket ticket){
            tickets.add(ticket);
            tickets.sort((t1,t2) -> t1.to.compareTo(t2.to));
        }
        
        public List getTickets(){
            return tickets;
        }
        
        @Override
        public String toString(){
            return name;
        }
    }
    
    class Ticket {
        boolean isUsed;
        String to;
        
        public Ticket(String to){
            this.to = to;
            this.isUsed = false;
        }
        
        public void setUsed(boolean isUsed){
            this.isUsed = isUsed;
        }
    }
}