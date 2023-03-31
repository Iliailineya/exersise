import java.lang.reflect.Method;
import java.util.*;

public class Solutions {

    public static List<Integer> primeNumbers(int num) {
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

        return primeNum;
    }

    public static Object measureMethodExecutionTime(String methodName, Object... args) throws Exception {
        long startTime = System.nanoTime();

        // Используйте рефлексию, чтобы найти и вызвать метод с переданным именем
        Method method = Main.class.getDeclaredMethod(methodName, getParameterTypes(args));
        Object result = method.invoke(null, args);

        long endTime = System.nanoTime();
        long executionTime = endTime - startTime;
        System.out.println("Время выполнения метода " + methodName + " : " + executionTime + " нс");

        return result;
    }

    private static Class<?>[] getParameterTypes(Object[] args) {
        return Arrays.stream(args).map(Object::getClass).toArray(Class[]::new);
    }
}
