package xin.zhuyao.test.test;

/**
 * Created with IntelliJ IDEA.
 * User: zy
 * Date: 2019/5/13
 * Time: 11:44
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class DualSynch {
    private Object syncObject = new Object();
    public  void f(){
        synchronized (syncObject) {
            for (int i = 0; i < 5; i++) {
                System.out.println("f()");
                Thread.yield();
            }
        }

    }
    public void g(){
        synchronized (syncObject) {
            for (int i = 0; i < 5; i++) {
                System.out.println("g()");
                Thread.yield();
            }
        }
    }
}
