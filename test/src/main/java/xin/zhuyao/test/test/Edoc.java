package xin.zhuyao.test.test;

import com.google.common.io.Files;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created with IntelliJ IDEA.
 * User: zy
 * Date: 2019/5/28
 * Time: 14:46
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class Edoc {

    public static void main(String[] args) throws IOException {
        Long start = System.currentTimeMillis();
        String filePath = "C:\\Users\\浙达\\Documents\\WXWork\\1688851158354777\\Cache\\File\\2019-05\\WX_201904292300.CIME";
        Map<String, List<List<String>>> e = EDocAnalysisUtils.getE(filePath);
        Long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
