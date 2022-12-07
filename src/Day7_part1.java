import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day7_part1 {

    public static void main(String[] args) throws FileNotFoundException {

        File file = new File("D:\\programmes\\workspace\\aventOfCode2022\\src\\Day7_input.txt");
        Scanner sc = new Scanner(file);

        Pattern cdPattern = Pattern.compile("[$] cd (.*)");


        F fileSystem = new F();
        fileSystem.name = "/";
        fileSystem.folder=true;
        fileSystem.subFolder=new ArrayList<>();


        F current = fileSystem;

        List<F> folderList = new ArrayList<>();

        /* create graph */

        while(sc.hasNextLine()){
            String line = sc.nextLine();

            if(line.startsWith("$")){
                if(line.equals("$ ls")){
                    continue;
                }else{
                    Matcher m = cdPattern.matcher(line);
                    boolean b = m.matches();
                    String test = m.group(1);
                    if(test.equals("..")){
                       current=current.parent;
                    }else if(test.equals("/")){
                        current = fileSystem;
                    }else{
                       for(F target : current.subFolder){
                           if(target.name.equals(test)){
                               current = target;
                               continue;
                           }
                       }
                    }

                }


            }else{

                String[] info = line.split(" ");
                F nouveau = new F();
                nouveau.parent=current;
                nouveau.name = info[1];

                if(info[0].equals("dir")){
                    nouveau.folder=true;
                    nouveau.subFolder= new ArrayList<>();
                    folderList.add(nouveau);
                }else{
                    nouveau.size = Long.parseLong(info[0]);
                }
                current.subFolder.add(nouveau);

            }
        }

        /* fill size */
        fileSystem.fillAndGetDirectorySize();

        /* compute result */
        long size = 0L;
        for(F folder : folderList){

            if (folder.size<100000L){
                size+=folder.size;
                System.out.println("add "+folder.name);
            }
        }
        System.out.println(size);


    }

}

class F{

    String name;
    boolean folder;
    F parent;
    List<F> subFolder;
    Long size;


    long fillAndGetDirectorySize(){
        if(size ==null){
            size=0L;
            for(F sub : subFolder){
                size += sub.fillAndGetDirectorySize();
            }
        }
        return size;
    }
}
