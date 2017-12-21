import java.util.*;
import java.io.*;
 
public class FileMerge 
{
     
public static void main(String args[]) throws IOException
{
Scanner keyboard = new Scanner(System.in);
System.out.print("Enter a file name: ");
String filename = keyboard.nextLine();

File file = new File(filename);

String[] fileList = file.list();
String[] a=new String[10000];
int i=0,n;

for(String name:fileList)
{
a[i]=name;
i++;
}
n=i;
System.out.println("No.of Files:"+i);

File file2 = new File("input.txt");
if (!file2.exists()) 
{
file2.createNewFile();
}
FileWriter fw = new FileWriter(file2.getAbsoluteFile());
BufferedWriter bw = new BufferedWriter(fw);

for(int k=0;k<n;k++)
{
BufferedReader br=new BufferedReader( new FileReader("Input Docs/"+a[k]));
String strLine;
while( (strLine = br.readLine()) != null)
{
bw.write((k+1)+" "+strLine);
String newLine = System.getProperty("line.separator");
bw.write(newLine);
}

}

bw.close();
System.out.println("input.txt Created!!....");

}
}
