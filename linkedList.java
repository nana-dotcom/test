import java.util.Scanner;
public class linkedList{
static Node head;
static Node free;
int value;
Node next;
static int v1=0;
Node(int a){
value=a;
next=null;
}
Node(){
value=0;
next=null;
}
public static void main(String[] args){
Scanner kb=new Scanner(System.in);
int u=0;
head=new Node();
free=new Node();
while(u==0){
System.out.println("Input number for operation.\n1.\tInsert Value\n2.\tDelete Value\n3.\tEnd operations\n4.\tPrint for check");
int op=kb.nextInt();
if(op==1){
System.out.println("Enter value for input.");
Insert(kb.nextInt());
}
else if(op==2){
System.out.println("Enter value to delete.");
Delete(kb.nextInt());
}
else if(op==3){
u++;
}
else if(op==4){
Print();
}
}
}
public static void MakeNode(){
Node n = new Node();
free.next=n;
n.next=null;
}
public static void Insert(int value){
if(free.next==null){
MakeNode();
}
v1++;
Node n=free.next;
n.value=value;
free.next=n.next;
n.next=head.next;
head.next=n;
}
public static void Delete(int val){
int check=0;
Node k=head.next;
Node l=k.next;
Node f=free;
if(free.next!=null) f=free.next;
if(k.value==val){
k.value=0;
head.next=l;
free.next=k;
v1--;
}
else{
for(int i=0;i<v1;i++){
if(l.value==val){
l.value=0;
f.next=l;
k.next=l.next;
v1--;
check++;
}
else{
if(l.next!=null){
k=l;
l=l.next;
}
}
}
if(check==0) System.out.println(val+" could not be found.");
else System.out.println(val+" removed.");
}
}
public static void Print(){
Node l=head.next;
for(int i=0;i<v1;i++){
System.out.println("\t"+l.value);
if(l.next!=null){
l=l.next;
}
}
System.out.println("\tFree:"+free.next);
System.out.println("\tHead:"+head.next);
}
}