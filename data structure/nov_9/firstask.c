#include<stdio.h>
int main(){
int a=5,b=6,c=7,d=8,e=9;
int arr[5]={1,2,3,4,5};
int *p= arr;
  printf("\nvar adress %p %p %p %p %p",&a,&b,&c,&d,&e);
  for(int i = 0 ; i<5; i++){
  printf("\narr adress %d %p\n",i,p);
  p++;
  }
return 0;
}
