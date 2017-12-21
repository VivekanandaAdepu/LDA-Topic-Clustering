import java.util.*;
import java.io.*;

public class ActualFeature
{
public static void main(String[] args) throws IOException
{
Scanner keyboard = new Scanner(System.in);
System.out.print("Enter Topics file name: ");
String filename = keyboard.nextLine();
File file1 = new File(filename);
Scanner inputFile = new Scanner(file1);

Scanner keyboard1 = new Scanner(System.in);
System.out.print("Enter Feature set: ");
String filename1 = keyboard1.nextLine();
File file2 = new File(filename1);
Scanner inputFile1 = new Scanner(file2);

int i=0,n,k,j=0;
String[] arr = new String[10000];
String[] arr1 = new String[10000];
String[] arr2 = new String[10000];

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

for(i=0;i<n;i++)
{
int l=0;
for(j=0;j<k;j++)
{
if(arr[i].equals(arr1[j]))
{
//arr[i]="";
l++;
}
}
if(l==0)
{
arr[i]="";
}
}

for(i=0;i<n;i++)
{
arr2[i]=arr[i];   
}

for(i=0;i<n;i++)
{
for(j=i+1;j<n;j++)
{
if(arr[i].equals(arr2[j]))
{
arr[i]="";
}
}
}


try 
{
File file = new File("Obtained.txt");
if (!file.exists()) 
{
file.createNewFile();
}
FileWriter fw = new FileWriter(file.getAbsoluteFile());
BufferedWriter bw = new BufferedWriter(fw);
	
for(i=0;i<n;i++)
{
if(!(arr[i].equals("")))
{
bw.write(arr[i]);
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
}
}