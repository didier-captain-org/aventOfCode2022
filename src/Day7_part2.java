import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day7_part2 {

    public static void main(String[] args) throws FileNotFoundException {

        File file = new File("D:\\programmes\\workspace\\aventOfCode2022\\src\\Day7_input.txt");
        Scanner sc = new Scanner(file);

        Pattern cdPattern = Pattern.compile("[$] cd (.*)");


        F2 fileSystem = new F2();
        fileSystem.name = "/";
        fileSystem.folder=true;
        fileSystem.subFolder=new ArrayList<>();


        F2 current = fileSystem;

        List<F2> folderList = new ArrayList<>();

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
                       for(F2 target : current.subFolder){
                           if(target.name.equals(test)){
                               current = target;
                               continue;
                           }
                       }
                    }

                }


            }else{

                String[] info = line.split(" ");
                F2 nouveau = new F2();
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

        long filesystemSize =70000000;
        long updateNeed = 30000000;
        long spaceUsed = fileSystem.size;
        long necesarySpaceToFree = updateNeed - (filesystemSize-spaceUsed);
        System.out.println("you need "+necesarySpaceToFree);

        long minSize = Long.MAX_VALUE;
        for(F2 folder : folderList){

            if (folder.size>=necesarySpaceToFree && folder.size<minSize){
                minSize = folder.size;
                System.out.println("candidat "+folder.name+" with "+folder.size);
            }
        }
        System.out.println(minSize);


    }

}

class F2{

    String name;
    boolean folder;
    F2 parent;
    List<F2> subFolder;
    Long size;


    long fillAndGetDirectorySize(){
        if(size ==null){
            size=0L;
            for(F2 sub : subFolder){
                size += sub.fillAndGetDirectorySize();
            }
        }
        return size;
    }
}
