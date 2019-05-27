package xin.zhuyao.test.test;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created with IntelliJ IDEA.
 * User: zy
 * Date: 2019/5/13
 * Time: 10:25
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class Test {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        AtomicityTest atomicityTest = new AtomicityTest();
        executorService.execute(atomicityTest);
        while (true) {
            int value = atomicityTest.getValue();
            if (value % 2 != 0) {
                System.out.println(value);
                System.exit(0);
            }
        }
    }
}
