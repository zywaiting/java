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
 * Time: 15:51
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class EDocAnalysisUtils {

    /**
     * @param filePath 文件路径
     * @return 返回map
     * @throws IOException
     */
    public static Map<String,List<List<String>>> getE(String filePath) throws IOException {
        Path path = Paths.get(filePath);
        List<String> stringList = Files.readLines(path.toFile(), Charset.defaultCharset());
        Map<Boolean, List<String>> booleanListMap = stringList.stream().collect(Collectors.groupingBy(s -> s.contains("<")));
        List<String> keyList = booleanListMap.get(true);
        List<Integer> indexList = keyList.stream().map(s -> stringList.indexOf(s)).collect(Collectors.toList());
        Map<String,List<List<String>>> hashMap = new HashMap<>();
        hashMap.put(keyList.get(0),null);
        for (int i = 2; i < indexList.size(); i = i + 2) {
            hashMap.put(keyList.get(i - 1),
                    stringList.subList(indexList.get(i - 1) + 3, indexList.get(i))
                            .stream().map(s -> s.replace("#\t", "")).map(s -> Arrays.asList(s.split("\\s+"))).collect(Collectors.toList()));
        }
        return hashMap;
    }
}
