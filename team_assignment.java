import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class team_assignment {
    public static void main(String[] args) throws IOException {
       for(;;){
           BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
           int a[] = new int[3];
           Random r = new Random();
           for(int i =0; i < 3; i++){
               a[i] = r.nextInt(9) +1;
               for(int j =0; j<i; j++){
                   if(a[i] == a[j]){
                       i--;
                   }
               }
           }
           String str ="";
           for(int i =0; i <3;i++){
               str += a[i];
           }
           System.out.println("컴퓨터가 숫자를 생성하였습니다. 답을 맞춰보세요!");
           String numbers = bf.readLine();

           int cnt_Try =0;
           int cnt_Strike =0;
           int ball = 0;
           for(int i =0; i < str.length();i++){
               for(int j =0; j< 3;j++){
                   if(numbers.charAt(i) == str.charAt(j) && i==j){
                       cnt_Strike +=1;
                   }else if(numbers.charAt(i) == str.charAt(j) && i!=j){
                       ball +=1;
                   }
               }
           }
           if(numbers.equals(str)){
               cnt_Try +=1;
               System.out.println(cnt_Try + "번째 시도 : " + str);
               System.out.println("3S");
               System.out.println(cnt_Try + "번만에 맞히셨습니다.");
               System.out.println("게임을 종료합니다.");
               break;
           }

           cnt_Try +=1;

           System.out.println(cnt_Try + "번째 시도 : " + numbers);
           System.out.println(ball + "B" + cnt_Strike + "S" );




       }



    }
}
