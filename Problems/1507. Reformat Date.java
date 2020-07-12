class Solution {
    private int getMonth(String month){
        HashMap<String, Integer> map = new HashMap<>();
        map.put("Jan", 1);
        map.put("Feb", 2);
        map.put("Mar", 3);
        map.put("Apr", 4);
        map.put("May", 5);
        map.put("Jun", 6);
        map.put("Jul", 7);
        map.put("Aug", 8);
        map.put("Sep", 9);
        map.put("Oct", 10);
        map.put("Nov", 11);
        map.put("Dec", 12);
        
        return map.get(month);
    }
    
    public String reformatDate(String date) {
        String str[]  = date.split(" ");
        date  = str[2]+ "-" + 
                String.format("%02d", getMonth(str[1])) + "-" + 
                String.format("%02d", Integer.parseInt(str[0].substring(0, str[0].length()-2)));
        
        return date; 
    }
}
