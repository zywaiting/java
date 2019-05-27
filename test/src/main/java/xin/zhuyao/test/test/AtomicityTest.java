package xin.zhuyao.test.test;

/**
 * Created with IntelliJ IDEA.
 * User: zy
 * Date: 2019/5/13
 * Time: 10:25
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class AtomicityTest implements Runnable {
    private int i = 0;
    public synchronized int getValue(){
        return i;
    }
    private synchronized void evenIncrement(){
        i++;
        i++;
    }
    @Override
    public void run() {
        while (true)
            evenIncrement();
    }
}
