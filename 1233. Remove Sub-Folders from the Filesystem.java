class Solution {
    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder);    //sorting of Array
        List<String> new_list=new ArrayList<>();    //new list to store result
        String previous=""; // take a empty string to start
        for(String str:folder){ 
            if(previous.isEmpty() || (!str.startsWith(previous+"/"))){
                new_list.add(str);
                previous=str;
            }
        }
        return new_list;
    }
}
