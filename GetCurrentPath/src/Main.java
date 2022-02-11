import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.StreamSupport;

public class Main
{
    private static String[] separateFileInput(String file)
    {
        Path path = Paths.get(file);
        return StreamSupport.stream(path.spliterator(), false).map(Path::toString)
                .toArray(String[]::new);
    }

    private static String getCurrentPath()
    {
        String currentPath = System.getProperty("user.dir");
        String[] separated = separateFileInput(currentPath);

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < separated.length-1; i++)
        {
            if (i == 0)
                builder.append("/").append(separated[i]).append("/");
            else
                builder.append(separated[i]).append("/");
        }

        return builder.toString();
    }

    public static void main(String[] args)
    {
        System.out.println("Path = " + getCurrentPath());
    }
}
