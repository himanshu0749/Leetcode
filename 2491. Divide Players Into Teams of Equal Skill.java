class Solution {
    public long dividePlayers(int[] skill) {
        Arrays.sort(skill);
        int n=skill.length;
        int high =skill[0]+skill[n-1];
        long chem=0;
        for(int i=0;i<n/2;i++){
            if(skill[i]+skill[n-i-1]!=high) return -1;
            chem+=skill[i]*skill[n-i-1];
        }
        return chem;
    }
}
