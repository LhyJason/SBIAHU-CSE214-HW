import org.junit.jupiter.api.Test; // JUnit 5 的 @Test 注解
import java.io.File; // 文件操作相关类
import java.io.FileNotFoundException; // 文件操作相关类
import java.util.Scanner; // 文件操作相关类
import static org.junit.jupiter.api.Assertions.assertEquals; // JUnit 5 的断言方法 assertEquals
public class VectorOperationsTest {
    @Test
    public void testMyCode() throws FileNotFoundException {
        File inputFile = new File("input.txt");
        Scanner scanner = new Scanner(inputFile);
        int input = scanner.nextInt();
        scanner.close();
        VectorOperations myCode = new VectorOperations();
        int output = myCode.myMethod(input);
        assertEquals(42, output);

    }

}
