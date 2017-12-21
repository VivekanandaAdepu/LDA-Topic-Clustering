import java.util.*;
import java.io.*;

public class Feature
{
public static void main(String[] args) throws IOException
{
Scanner keyboard = new Scanner(System.in);
System.out.print("Enter a file name: ");
String filename = keyboard.nextLine();

File file1 = new File(filename);
Scanner inputFile = new Scanner(file1);

int i=0,k,n,j,l=0,m=0,p=0;
String[] arr = new String[10000];
String[] arr1 = new String[10000];
int[] count = new int[10000];

while (inputFile.hasNext())
{
String line = inputFile.nextLine(); 
line = line.trim();  
for (String retval: line.split(" "))
{

arr[i]=retval;
arr1[i]=retval;
//System.out.println(arr[i]);
i++;
}
}
System.out.println("Array Size:"+i);
n=k=i;

for(i=0;i<n;i++)
{
l=0;
for(j=0;j<k;j++)
{
if(arr[i].equals(arr1[j]))
{
l++;
}
else if(arr[i].equals("."))
{
l=0;
}
}

count[m]=l;
if(count[m]>=1)
{
arr1[p]=arr[i];
p++;
}
m++;
}   

for(i=0;i<p;i++)
for(j=i+1;j<p;j++)
if(arr1[i].equals(arr1[j]))
arr1[j]="";

try 
{
File file = new File("Feature.txt");
if (!file.exists()) 
{
file.createNewFile();
}
FileWriter fw = new FileWriter(file.getAbsoluteFile());
BufferedWriter bw = new BufferedWriter(fw);
	
for(i=0;i<p;i++)
{
if(!(arr1[i].equals("")))
{
bw.write(arr1[i]);
bw.write(" ");
String newLine = System.getProperty("line.separator");
bw.write(newLine);
}
}

bw.close();
} 
catch (IOException e) 
{
e.printStackTrace();
}
inputFile.close();
System.out.println("Feature Set Is Genenrated and stored in Feature.txt!!....");
}
}