/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        if(guess(n)==0) return n;
        int st=1,end=n;
        while(st<=end){
            int mid=st+(end-st)/2;
            if(guess(mid)==0){
                return mid;
            }
            else if(guess(mid)==1){
                st=mid+1;
            }
            else{
                end=mid-1;
            }
        }
        return -1;
    }
}
