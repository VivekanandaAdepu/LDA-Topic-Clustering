import java.io.*;

public class CmdTest 
{
public static void main(String[] args) throws Exception 
{
ProcessBuilder builder = new ProcessBuilder(
 "cmd.exe", "/c", "cd \"D:\\LDA_IMPLEMENTATION\\2.INPUT_processing\\1.POS_tagging\" && java -mx500m -classpath stanford-postagger.jar edu.stanford.nlp.tagger.maxent.MaxentTagger -model english-bidirectional-distsim.tagger -textFile input1.txt > outfile.txt");
builder.redirectErrorStream(true);
Process p = builder.start();
BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
String line;
while (true) 
{
line = r.readLine();
if (line == null) 
{
break; 
}
System.out.println(line);
}
}
}