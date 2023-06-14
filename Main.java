import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] ranArr = new int[3]; // 3자리수 랜덤 숫자를 받을 배열 선언
        int[] inputArr = new int[3]; // 3자리수 숫자를 입력할 배열 선언
        int strike = 0;
        int ball = 0;

        // 랜덤 숫자 만들기
        for (int i = 0; i < ranArr.length; i++) {
            ranArr[i] = (int)(Math.random() * 9 + 1); // (Math.random() * (최댓값-최솟값+1) + 최솟값)
            for (int j = 0; j < i; j++) { // 랜덤 숫자 중복값 제거
                if (ranArr[j] == ranArr[i]) { // 중복이면 i - 1 하여 이전으로 돌아가기
                    i--;
                    break;
                }
            }
        }
        System.out.println("컴퓨터가 숫자를 생성하였습니다. 답을 맞춰보세요!");

//        // 랜덤 숫자 생성 확인
//        for (int x : ranArr) {
//            System.out.print(x);
//        }
//        System.out.println();

        for (int k = 0; ; k++) { // 기회는 무제한
            int count = k + 1; // 시도 횟수를 카운트
            System.out.print(count + "번째 시도 : ");

            // 사용자가 숫자 입력
            Scanner sc = new Scanner(System.in);

            String[] strArr = sc.next().split(""); // 입력받은 문자열을 split()으로 분할하여 저장
            for (int i = 0; i < ranArr.length; i++) {
                inputArr[i] = Integer.parseInt(strArr[i]); // 문자형 숫자를 하나씩 int형으로 변환
                if (strArr.length != ranArr.length) { // 입력값의 길이와 랜덤숫자의 길이가 다르면
                    k--; // 시도 횟수를 세지않고 다시 시도
                    System.out.println("숫자를 3개 입력하세요.");
                    break;
                }
            }

//            // 입력 숫자 각각의 배열에 들어갔는지 확인
//            System.out.println(Arrays.toString(inputArr));

            // 랜덤 숫자와 입력받은 숫자를 비교하여 스트라이크, 볼 판단
            for (int i = 0; i < ranArr.length; i++) {
                for (int j = 0; j < inputArr.length; j++) {
                    if (ranArr[i] == inputArr[j] && i == j) { // 각 배열의 값이 같고 순서가 같으면
                        strike++;
                    } else if (ranArr[i] == inputArr[j] && i != j) { // 각 배열의 값이 같고 순서는 틀리면
                        ball++;
                    }
                }
            }

            // 스트라이크, 볼 표현
            if (strArr.length == ranArr.length) { // 입력값의 길이와 랜덤숫자의 길이가 같아야만 스트라이크, 볼 표현을 출력
                if (ball == 3){
                    System.out.println(ball + "B");
                } else if (strike == 3) {
                    System.out.println(strike + "S");
                    System.out.println(count + "번만에 맞히셨습니다.");
                    System.out.println("게임을 종료합니다.");
                    break;
                } else {
                    System.out.println(ball + "B" + strike + "S");
                }
            }

            strike = 0; // 새로 입력한 숫자의 스트라이크, 볼 판단을 위해 strike 값 초기화
            ball = 0; // 새로 입력한 숫자의 스트라이크, 볼 판단을 위해 ball 값 초기화

        }
    }
}