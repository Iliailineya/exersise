import java.lang.reflect.Method;
import java.util.Random;

public class Utility {
    public static Object measureStaticMethodExecutionTime(String className, String methodName, Object... args) throws Exception {

        long startTime = System.currentTimeMillis();

        Class<?> clazz = Class.forName(className);
        Method method = clazz.getMethod(methodName, getArgTypes(args));
        Object result = method.invoke(null, args);

        long endTime = System.currentTimeMillis();
        System.out.println("Время выполнения метода " + methodName + " : " + (endTime - startTime) + " мс");

        return result;
    }

    private static Class<?>[] getArgTypes(Object[] args) {
        Class<?>[] argTypes = new Class<?>[args.length];
        for (int i = 0; i < args.length; i++) {
            argTypes[i] = args[i].getClass();
        }
        return argTypes;
    }
    public static void fillArray(int[] arr) {
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(101);
        }
    }

}
