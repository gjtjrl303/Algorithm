import java.util.*;

class Solution {
    
    Map<String, Node> map;
    
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount){
        map = new HashMap<>();
        Node center = new Node("center", null);
        map.put("center", center);
        
        for(int i = 0 ; i < enroll.length ; i++){
            if(referral[i].equals("-")) {
                map.put(enroll[i], new Node(enroll[i], map.get("center")));
            }else{
                map.put(enroll[i], new Node(enroll[i], map.get(referral[i])));
            }
        }
        
        for(int i = 0 ; i < seller.length ; i++){
            pay(map.get(seller[i]), amount[i] * 100);
        }        
        
        // for(String key : map.keySet()){
        //     Node node = map.get(key);
        //     System.out.println(node + " " + node.getParent() + " " + node.getPrice());
        // }
        
        int[] result = new int[enroll.length];
        for(int i = 0 ; i < enroll.length ; i++) {
            result[i] = map.get(enroll[i]).getPrice();
        }
        
        return result;
    }
    
    public void pay(Node node, int pay){
        if(node == null) return;
        node.sellPrice(pay);
        pay = pay * 10 / 100;
        node.payCharge(pay);
        pay(node.getParent(), pay);
    }
    
    class Node{
        String name;
        Node parent;
        List<Node> children = new ArrayList<>();
        int price;
        int pay;
        
        public Node(String name, Node parent){
            this.name = name;
            this.parent = parent;
            price = 0;
            pay = 0;
        }
        
        public void sellPrice(int price){
            this.price += price;
        }
        
        public void addChild(Node node){
            children.add(node);
        }
        
        public List<Node> getChilren(){
            return children;
        }
        
        public Node getParent(){
            return parent;
        }
        
        public int getPrice(){
            return price;
        }
        
        private void plusPay(int pay){
            pay += pay;
        }
        
        public void payCharge(int pay){
            price -= pay;
        }
        
        @Override
        public String toString(){
            return name;
        }
    }
}