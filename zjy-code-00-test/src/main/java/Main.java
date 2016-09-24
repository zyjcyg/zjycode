import java.util.Scanner;

/**
 * <pre>
 * Created with IntelliJ IDEA.
 * User: zjy
 * Date: 16-9-14
 * Time: 下午4:49
 * PC：ubuntu'IDEA with mine <br>
 * </pre>
 *
 * @author zjy.
 */
public class Main {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextInt())
        {
            int n = scanner.nextInt();
            int sum = 1;
            for(int i=0;i<n;i++)
            {
                sum = sum*n;
            }
            System.out.println(sum-n+1);
        }
/*

        Scanner cin=new Scanner(System.in);

        int i=1,n=1,x=1;
        //猴子个数
        int N=cin.nextInt();
        //需要总苹果数量
        int sum;

        while(i!=N) {
            //如果n-1只猴子刚好分完
            if((N*x+1) % (N-1)==0) {
                i++;
                x=(N*x+1)/(N-1);
            } else {
                i=1;
                x=++n;
            }
        }
        sum=N*x+1;
        System.out.println(sum);
*/


    }

}
