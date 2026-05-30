import java.io.File;
import java.io.FileWriter;
import java.util.*;

//import javax.print.DocFlavor.STRING;
public class Student implements Comparable<Student> {

static Scanner sc=new Scanner(System.in);
static ArrayList<Student> arr= new ArrayList<>();
    int stu_id;
    String stu_name;
    int stu_age;
    String course;


Student(int stu_id, String stu_name,int stu_age,String course){
    this.stu_id = stu_id;
    this.stu_name= stu_name;
    this.stu_age = stu_age;
    this.course=course;
  
}
public int compareTo(Student other){
    
    return this.stu_name.compareTo(other.stu_name);
}


void displaystudent(){
      
   System.out.println(stu_id +" "+ stu_name+" "+stu_age +" "+ course);
}
static void addstudent(){
    try{
    System.out.println("enter id");
        int id=sc.nextInt();
 
        boolean g=true;
        for(Student s0:arr){
            if(id==s0.stu_id){
                System.out.println(id + "=id  is already used enter new id ");
                g=false;
                break;
            }
                
            }
           
         if(g==true)  { 
        sc.nextLine();         
            System.out.println("enter name");
        String name=sc.nextLine();
        
             System.out.println("enter age");
        int age=sc.nextInt();
        sc.nextLine();
            System.out.println("enter course");
        String cours=sc.nextLine();

         
      Student obj=new Student(id,name,age,cours);
      arr.add(obj);
      savefile();
           }
         }catch(Exception e){
    System.out.println("invalid input");
}
    

}

static void search(){
    //int srch=0;
    try{
    int srch=sc.nextInt();
           sc.nextLine();
 
        boolean flag=false;
        for(Student s1:arr){
            if(s1.stu_id==srch){
                flag=true;
                s1.displaystudent();
                break;
            }
        
        }
            
      
        if(flag==false){
            System.out.println("student not found");
        }
        }
        
            catch(Exception e){
    System.out.println("invalid input");
    sc.nextLine();
}
}

static void delete(){
    try{
      int del=sc.nextInt();
      sc.nextLine();
    
 
            boolean fl=false;
            for(Student s2: arr){
                if(s2.stu_id==del){
                    System.out.println("the deleted details are");
                    s2.displaystudent();
                    arr.remove(s2);
                    fl=true;
                    break;
                }
            }
            if(fl==false){
                System.out.println("student not found");
            }
            }
               catch(Exception e){
    System.out.println("invalid input");
    sc.nextLine();
}
savefile();
}
static void update(){
    try{
     int sea=sc.nextInt();
          sc.nextLine();

         boolean fag=false;
        for(Student s1:arr){
            if(s1.stu_id==sea){
                  System.out.println("which field you wanted to update :,name,age,corse enter num 1 t0 4 only");
    int up=sc.nextInt();
    sc.nextLine();
    if(up==1){
        System.out.println("enter new id");
        int id_=sc.nextInt();
        sc.nextLine();
            boolean g=true;
        for(Student s7:arr){
            if(id_==s7.stu_id){
                System.out.println(id_ + "=id  is already used enter new id ");
                g=false;
                break;
            }
                
            }
           
         if(g==true){
        s1.stu_id=id_;}

    }
    if(up==2){
        System.out.println("enter new name");

        String id_=sc.nextLine();
         s1.stu_name=id_;
        
    }
    if(up==3){
        System.out.println("enter new age");
        int id_=sc.nextInt();
        sc.nextLine();
         s1.stu_age=id_;
        
    }
    if(up==4){
        System.out.println("enter new course");
        String id_=sc.nextLine();
         s1.course=id_;

        
    }


System.out.println("updated details are");
                fag=true;
                s1.displaystudent();
                
            }
        
        }
  
        if(fag==false){
            System.out.println("student not found");
            
        }
              }
   catch(Exception e){
    System.out.println("invalid input");
    sc.nextLine();
}
savefile();

    
}
static void srchbyname(){
        sc.nextLine();
        String name=sc.nextLine();
        boolean f=false;
        for(Student s1:arr){
            if(s1.stu_name.equals(name)){
                f=true;
                s1.displaystudent();
                break;
            }
        
        }
        if(f==false){
            System.out.println("student not found");
        }
}
static void savefile(){
    //File f=new File("student.txt");
    try{
    FileWriter fw=new FileWriter("student.txt");
    for(Student s:arr){
        fw.write(s.stu_id + ","+s.stu_name + "," + s.stu_age + ","+s.course+"\n");
        
    }
    fw.close();
    System.out.println("data saved successfully");
}
catch(Exception e){
    System.out.println(e);

}
}
static void loadfile(){
    arr.clear();
    try{
File f=new File("student.txt");
if(!f.exists()){
    return;
}
Scanner fr=new Scanner(f);
String parts[];
while(fr.hasNextLine()){
    String line=fr.nextLine();
    parts=line.split(",");


int id=Integer.parseInt(parts[0]);
String name=parts[1];
int age=Integer.parseInt(parts[2]);
String course=parts[3];
Student st=new Student(id, name, age, course);
arr.add(st);
}
fr.close();
    }
    catch(Exception e){
        System.out.println(e);
    }

}
 static boolean n=true;
public static void main(String args[]){

loadfile();
do{
  try{
System.out.println("enter\n1.add new student\n2.display student\n 3.search student\n 4.delete a student entry\n5.update\n6.sort by id\n7.search by name\n8.sort by name\n9.exit");
int input=sc.nextInt();
  
switch(input){
    case 1:
        System.out.println("enter student details");
        addstudent();
        break;
        case 2:
    System.out.println("displaying student details");
if(arr.isEmpty()){
    System.out.println("student list is empty,to be displayed");
}
else{
    for(Student s : arr){
        s.displaystudent();
    }
}
    break;
   
     case 3:if(arr.isEmpty()){
    System.out.println("details are empty");
}
else{

        System.out.println("enter the id to be searched");
        search();
}
        break;  
        case 4:
            if(arr.isEmpty()){
    System.out.println("no student details are present");
}
else{
            System.out.println("enter id to be deleted");
          delete();
}
            break;

        case 5:
            if(arr.isEmpty()){
    System.out.println("student list is empty");
}
else{
        System.out.println("enter the id to be updated");
         update();
    
}
        break;
case 6:
    if(arr.isEmpty()){
    System.out.println("student lsit is empty");
}
else{
    System.out.println("sorting details according to their id");
  Collections.sort(arr,(student1,student2)->{
    return student1.stu_id -student2.stu_id;
  });
    for(Student s3: arr){
          
        s3.displaystudent();
    }
}
break;
case 7:
    if(arr.isEmpty()){
    System.out.println("student list is empty");
}
else{
    System.out.println("searching student details by name");
 srchbyname();
}
        break; 
        case 8:
            if(arr.isEmpty()){
    System.out.println("student list is empty");
}
else{
            System.out.println("sort  by name:");
            Collections.sort(arr);
             for(Student s4: arr){
          
        s4.displaystudent();
    }}
    break;
    // case 9:
    //     savefile();
    //     break;
    //     case 10:
    //         loadfile();
    //         System.out.println("file loaded");
    //         break;
    case 9:
        System.out.println("you exit from the program");
        n=false;
        break;



        
          default:
        System.out.println("exit /enter a valid input");
        break;

    }}
    catch(Exception e){
    System.out.println("invalid input .please enter a number");
    sc.nextLine();
}

}while(n);




}
}