import java.util.*;
import java.io.*;
//import java.lang.String.*;

public class PathGenlab
{
public static void main(String[] args) throws IOException
{
Scanner keyboard = new Scanner(System.in);
System.out.print("Enter Obtained Feature file name: ");
String filename = keyboard.nextLine();
File file1 = new File(filename);
Scanner inputFile = new Scanner(file1);

Scanner keyboard1 = new Scanner(System.in);
System.out.print("Enter Topic Matrix file name: ");
String filename1 = keyboard1.nextLine();
File file2 = new File(filename1);
Scanner inputFile1 = new Scanner(file2);

int i=0,n,k,j=0;
String[] arr = new String[10000];
String[] arr1 = new String[10000];
String[] b = new String[10000];
String[] c = new String[10000];
String[] d = new String[10000];

while (inputFile.hasNext())
{
String line = inputFile.nextLine(); 
line = line.trim(); 
for (String retval: line.split(" "))
{

arr[i]=retval;
//System.out.println(arr[i]);
i++;
}
}
System.out.println("Array Size:"+i);
n=i;

while (inputFile1.hasNext())
{
String line1 = inputFile1.nextLine(); 
line1 = line1.trim();  
for (String retval1: line1.split(" "))
{

arr1[j]=retval1;
//System.out.println(arr1[j]);
j++;
}
}
System.out.println("Array Size:"+j);
k=j;

i=1; 
int l=4,m=0,p=0;
for(j=0;j<k;j++)
{
if(j==i)
{
b[m]=arr1[j];
i=i+6;
m++;
}
else if(j==l)
{
c[p]=arr1[j];
l=l+6;
p++;
}
}

try 
{
File file = new File("Obta.html");
if (!file.exists()) 
{
file.createNewFile();
}
FileWriter fw = new FileWriter(file.getAbsoluteFile());
BufferedWriter bw = new BufferedWriter(fw);
	
for(i=0;i<n;i++)
{
bw.write((i+1)+"."+arr[i]+":");
bw.write("<br>");
for(j=0;j<p;j++)
{
if(arr[i].equals(c[j]))
{
bw.write("<a href=file:///");
bw.write(b[j]);
bw.write(">");
bw.write(b[j]);
bw.write("</a>");
String newLine = System.getProperty("line.separator");
bw.write("<br>");
bw.write(newLine);
}
}
bw.write("<br>");
}


bw.close();
} 
catch (IOException e) 
{
e.printStackTrace();
}
inputFile.close();
inputFile1.close();
}
}
