import java.lang.reflect.Method;
import java.util.*;

public class Solutions {

    public static String primeNumbers(int num) {
        List<Integer> primeNum = new ArrayList<>();

        boolean[] isPrime = new boolean[num + 1];
        Arrays.fill(isPrime, true);
        for (int i = 2; i * i <= num; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= num; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        for (int i = 2; i <= num; i++) {
            if (isPrime[i]) {
                primeNum.add(i);
            }
        }

        return primeNum.toString();
    }


    public static Object measureMethodExecutionTime(String methodName, int num) throws Exception {

        long startTime = System.currentTimeMillis();

        // Используйте рефлексию, чтобы найти и вызвать метод с переданным именем
        Method method = Solutions.class.getMethod(methodName, int.class); // указываем тип аргумента
        Object result = method.invoke(null, num); // передаем значение аргумента


        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;
        System.out.println("Время выполнения метода " + methodName + " : " + executionTime + " мс");

        return result;
    }
}
