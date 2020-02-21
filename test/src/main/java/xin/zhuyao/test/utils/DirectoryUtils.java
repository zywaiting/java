package xin.zhuyao.test.utils;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Created with IntelliJ IDEA.
 * User: zy
 * Date: 2019/5/29
 * Time: 12:54
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class DirectoryUtils {

    public static File[] local(File dir, final String regex) {
        return dir.listFiles(new FilenameFilter() {
            private Pattern pattern = Pattern.compile(regex);
            public boolean accept(File dir,String name) {
                return pattern.matcher(
                        new File(name).getName()).matches();
            }
        });
    }

    public static File[] local(String path, final String regex) {
        return local(new File(path),regex);
    }

    public static class TreeInfo implements Iterable<File> {
        public List<File> files = new ArrayList<>();
        public List<File> dirs = new ArrayList<>();
        @Override
        public Iterator<File> iterator() {
            return files.iterator();
        }
        void addAll(TreeInfo other) {
            files.addAll(other.files);
            dirs.addAll(other.dirs);
        }
        public String toSting(){
            return "dirs: " + dirs +
                    "\n\nfiles: " + files;
        }
    }

    public static TreeInfo walk(String start, String regex) {
        return recurseDirs(new File(start),regex);
    }

    public static TreeInfo walk(File start, String regex) {
        return recurseDirs(start,regex);
    }

    public static TreeInfo walk(String start) {
        return recurseDirs(new File(start),".");
    }

    public static TreeInfo walk(File start) {
        return recurseDirs(start, ".");
    }

    static TreeInfo recurseDirs(File startDir, String regex) {
        TreeInfo result = new TreeInfo();
        for (File item : startDir.listFiles()) {
            if (item.isDirectory()) {
                result.dirs.add(item);
                result.addAll(recurseDirs(item,regex));
            } else{
                System.out.println(item.getName());
                System.out.println(item.getName().matches(regex));
                if (item.getName().matches(regex))
                    result.files.add(item);
            }

        }
        return result;
    }

    public static void main(String[] args) {


    }

    public static void test(File files){
        File[] filesArray = files.listFiles();
        if (filesArray != null) {
            for (File file : filesArray) {

                if (file.isDirectory())
                    test(file);
                System.out.println(file);
            }
        }

    }

}
