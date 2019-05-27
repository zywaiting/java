package xin.zhuyao.test.test;

/**
 * Created with IntelliJ IDEA.
 * User: zy
 * Date: 2019/5/13
 * Time: 11:46
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class SyncObject {
    public static void main(String[] args) {
        final DualSynch dualSynch = new DualSynch();
        new Thread(()->dualSynch.f()).start();
        dualSynch.g();
    }
}
