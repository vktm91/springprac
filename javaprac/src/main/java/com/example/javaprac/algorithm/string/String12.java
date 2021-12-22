import java.util.Scanner;

// 암호
public class String12 {
    public String solution(int n, String s) {
        String answer = "";
        for(int i=0; i<n; i++){
            String tmp=s.substring(0,7).replace('#','1').replace('*','0');
            int num=Integer.parseInt(tmp,2);
            answer+=(char)num;
            s=s.substrig(7);
        }
        return answer;
    }

    public static void main(String[] args) {
        String12 T = new String12();
        int n = kb.nextInt();
        String str = kb.next();
        System.out.println(T.solution(n, str));
    }

}
