class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        String[] a=s1.split(" ");
        String[] b=s2.split(" ");
        List<String>news=new ArrayList<>();
        for(String i:a){
            boolean flag=false;
            for(String j:b){
                if(i.equals(j)){
                    flag=true;
                     break;
                }
            }
           if (!flag && Collections.frequency(Arrays.asList(a), i) == 1) {
                news.add(i);
            }
        }for (String j : b) {
            boolean flag = false;
            for (String i : a) {
                if (j.equals(i)) {
                    flag = true;
                    break;
                }
            }
            if (!flag && Collections.frequency(Arrays.asList(b), j) == 1) {
                news.add(j);
            }
        }
        String[] res = new String[news.size()];
        int count = 0;
        for (String word:news){
            res[count++] = word;
        }
        return res;
    }
}
