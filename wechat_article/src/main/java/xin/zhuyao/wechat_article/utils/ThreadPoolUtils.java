package xin.zhuyao.wechat_article.utils;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created with IntelliJ IDEA.
 * User: zy
 * Date: 2019/5/8
 * Time: 9:36
 * To change this template use File | Settings | File Templates.
 * Description:
 */
@Slf4j
public class ThreadPoolUtils {

    private static ExecutorService executorService = new ThreadPoolExecutor(5, 10, 1, TimeUnit.SECONDS, new LinkedBlockingDeque());

    public static <T> List<T> addTask(List<Callable<T>> tasks) {
        List<Future<T>> futureList = null;
        List<T> results = null;
        try {
            futureList = executorService.invokeAll(tasks);
            results = new ArrayList<>();
            for (Future<T> future : futureList) {
                results.add(future.get());
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        return results;
    }
}
