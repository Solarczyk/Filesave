import java.awt.*;
import java.io.*;
import java.nio.file.Path;

public class FSUtils extends Component {
    private Path actualDirectory;
    private String actualFile;

    public boolean openDirectory(){return false;}
    public void readDirectory(){}

    public String getActualFile(){return this.actualFile;}
    public void setActualFile(String actualFile){this.actualFile = actualFile;};
    public void saveFile(String name, String content){
        try {
            FileWriter fileWriter = new FileWriter(name);
            BufferedWriter writer = new BufferedWriter(fileWriter);

            writer.write(content);

            writer.close();
            fileWriter.close();
        }
        catch (IOException exception){
            System.out.println("Error while saving file");
        }
    }

    public String readFile(String name){
        String out = "";
        try {
            FileReader fileReader = new FileReader(name);
            BufferedReader reader = new BufferedReader(fileReader);

            String line;

            while((line = reader.readLine()) != null){
                out += line + System.getProperty("line.separator");

            }

            reader.close();
            fileReader.close();
        }
        catch (IOException e){
            System.out.println("Error while reading file");
        }
        return out;
    }

}
